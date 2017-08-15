package com.maizhong.auction.service.impl;

import com.maizhong.auction.channel.InitChannel;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.AutoPrice;
import com.maizhong.auction.dto.CarAcutionDTO;
import com.maizhong.auction.mapper.*;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.ChannelService;
import com.maizhong.auction.socket.SpringWebSocketHandler;
import com.maizhong.common.dto.WaitAuctionQueueDto;
import com.maizhong.common.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xushd on 2017/6/26.
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    public static Logger LOGGER = LoggerFactory.getLogger(ChannelServiceImpl.class);

    @Autowired
    private JedisClient jedisClient;

//    @Autowired
//    private AcAuctionOverMapper acAuctionOverMapper;

    @Autowired
    private AcAuctionRecordMapper acAuctionRecordMapper;
    @Autowired
    private AcBidRecordMapper acBidRecordMapper;

    @Autowired
    private AcOrderMapper acOrderMapper;

    @Autowired
    private AcAuctionNowMapper acAuctionNowMapper;

    @Autowired
    private SpringWebSocketHandler socketHandler;

    @Autowired
    private CkCarbaseMapper ckCarbaseMapper;

    @Autowired
    private AcFreezeMapper acFreezeMapper;

    @Value("${MAIN_SERVICE}")
    private String MAINSERVICE;

    /**
     * 创建拍卖队列
     * 测试用
     * @param chNum
     */
    @Override
    public void createAuctionQueue(int chNum) {
        for (int i = 0; i < chNum; i++) {
            byte[] redisKey = ("AuctionQueue:CH"+i).getBytes();
            int i1 = new Random().nextInt(1000);
            for (int j = 0; j < i1; j++) {
                CarAcutionDTO dto = new CarAcutionDTO();
                long time = TimeUtils.getCurrentTime();
                dto.setCarId(time);
                dto.setChannel("CH:"+i);
                dto.setNowPrice(String.valueOf(i1));
                jedisClient.lpush(redisKey,ObjectUtil.serializer(dto));
            }

        }

    }


    /**
     * 拍卖结束后 数据轮训
     */
    @Override
    @Transactional
    public void dataSave() {
        byte[] redisKey = "DataQueue".getBytes();
        byte[] rpop = jedisClient.rpop(redisKey);
        if (rpop!=null){
            try {
                CarAcutionDTO dto = ObjectUtil.deserializer(rpop, CarAcutionDTO.class);
                long carId = dto.getCarId();
                long recordId = dto.getId();

                CkCarbase carbase = new CkCarbase();
                carbase.setId(carId);

                long lastUserId = dto.getLastUserId();
                if(lastUserId==0L){
                    //无人出价
                    //流拍
                    carbase.setStatus(6);
                }else{
                    //创建订单
                    long orderNum = IDUtils.getOrderId();
                    AcOrder order = new AcOrder();
                    order.setAuctionId(recordId);
                    order.setOrderNum(orderNum);
                    order.setCarId(carId);
                    order.setPrice(dto.getNowPrice());
                    order.setUserId(lastUserId);
                    order.setStatus(0);
                    order.setChKey(dto.getChannel());
                    order.setCreateTime(new Date());
                    //等待确认
                    carbase.setStatus(7);
                    acOrderMapper.insertSelective(order);
                    LOGGER.info("INSET ORDER 车辆 ID {} 订单编号 {}",carId,orderNum);

                    //清理智能报价队列
                    jedisClient.del("AUTOPRICE_QUEUE:"+recordId);
                    LOGGER.info("CLEAR AUTOPRICE_QUEUE",recordId);

                    //清理冻结资金
                    AcFreezeExample example = new AcFreezeExample();
                    example.createCriteria().andAuctionIdEqualTo(recordId).andUserIdNotEqualTo(lastUserId);
                    acFreezeMapper.deleteByExample(example);
                    LOGGER.info("CLEAR FREEZE {}",carId);

                }

                ckCarbaseMapper.updateByPrimaryKeySelective(carbase);
                LOGGER.info("UPDATE CARBASE 车辆 ID {} 拍卖状态 {}",carId,carbase.getStatus());

                //更新 拍卖记录
                AcAuctionRecord record = new AcAuctionRecord();
                record.setId(recordId);
                record.setStatus(1);
                record.setPrice(dto.getNowPrice());
                record.setUserId(dto.getLastUserId());
                record.setEndTime(TimeUtils.getNowTime());

                acAuctionRecordMapper.updateByPrimaryKeySelective(record);
                LOGGER.info("UPDATE RECORD carID {} recordId {}",carId,recordId);
//
//
//                jedisClient.del("AUTOPRICE_CAR:"+carId);
//                LOGGER.info("CLEAR AUTOPRICE carID {} ",carId);

            }catch (Exception e){
                e.printStackTrace();
                //jedisClient.lpush(redisKey,rpop);
            }

        }

    }

    /**
     * 通道轮询
     * @param ch
     */
    @Override
    public void pollingChannel(String ch) {

        String now = jedisClient.get("CHANNEL:" + ch);
        if(StringUtils.isBlank(now)||StringUtils.equals("over",now)){
            //通道为空
            String nextCar = getNextCarQueue(ch);
            jedisClient.set("CHANNEL:" + ch,nextCar);


        }else{
            //不为空
            CarAcutionDTO carAcutionDTO = JsonUtils.jsonToPojo(now, CarAcutionDTO.class);
            if(TimeUtils.compare(carAcutionDTO.getOverTime())){
                //未结束 继续轮训

                //智能报价处理
                autoPrice(carAcutionDTO);

            }else{


                //结束
                jedisClient.set("CHANNEL:" + ch,"over");

                //拍完的车加入到数据处理队列中
                addDataQueue(carAcutionDTO);

                String nextCar = getNextCarQueue(ch);
                jedisClient.set("CHANNEL:" + ch,nextCar);
            }
        }
    }

    /***
     * 通道清理
     * @param chNum
     */
    @Override
    public void clearChannel(int chNum) {
        jedisClient.del("DataQueue");
        for (int i = 0; i < chNum; i++) {
             jedisClient.del("CHANNEL:CH"+i);
             jedisClient.del("AuctionQueue:CH"+i);

        }


    }

    /**
     * 出价记录 发送队列
     * @param acBidRecord
     */
    @Override
    public void addSocketQueue(AcBidRecord acBidRecord) {
        byte[] redisKey = "Socket".getBytes();
        jedisClient.lpush(redisKey, ObjectUtil.serializer(acBidRecord));
    }

    /**
     * 轮需 出价记录 队列 有发送
     */
    @Override
    public void sendSocket() {

        byte[] redisKey = ("Socket").getBytes();
        byte[] rpop = jedisClient.rpop(redisKey);
        if(rpop!=null){
            AcBidRecord deserializer = ObjectUtil.deserializer(rpop, AcBidRecord.class);
            deserializer.setNowTime(TimeUtils.getCurrentTime());
            TextMessage msg = new TextMessage(JsonUtils.objectToJson(deserializer));

            try {
                //发送出价信息
                socketHandler.sendMessageToCH(msg,deserializer.getChKey());
                //数据持久化出价记录
                acBidRecordMapper.insertSelective(deserializer);

            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }

    /**
     * 智能报价处理
     */
    private void autoPrice(CarAcutionDTO carAcutionDTO){
        Long userId = carAcutionDTO.getLastUserId();
        Long auctionId = carAcutionDTO.getId();
        long carId = carAcutionDTO.getCarId();
        String channel = carAcutionDTO.getChannel();

        String price = carAcutionDTO.getNowPrice();
        String key = "AUTOPRICE_QUEUE:"+auctionId;

        byte[] rpop = jedisClient.rpop(key.getBytes());

        if(rpop!=null){
            AutoPrice autoPrice = ObjectUtil.deserializer(rpop, AutoPrice.class);
            if(autoPrice.getAuctionId()==auctionId){
                //如果最高价是本人
                if(userId==autoPrice.getUserId()){
                    //如果当前最高价小于智能报价 放回队列
                    if(Double.valueOf(price)<Double.valueOf(autoPrice.getPrice())){
                        jedisClient.lpush(key.getBytes(),rpop);
                    }else{
                        jedisClient.hset("AUTOPRICE_CAR:" + auctionId, String.valueOf(autoPrice.getUserId()),"over");
                    }
                }else{
                    //最高价不是本人
                    //加价
                    BigDecimal now = new BigDecimal(price);
                    BigDecimal auto = new BigDecimal(autoPrice.getPrice()).divide(new BigDecimal(10000));
                    //当前价格小于智能报价
                    if(now.compareTo(auto)<0){
                        BigDecimal diff = auto.subtract(now);

                        String token = jedisClient.hget("AC_USER_PHONE", autoPrice.getPhone() + "");
                        Map<String,String> head = new HashMap<>();
                        Map<String,String> query = new HashMap<>();
                        Map<String,String> body = new HashMap<>();
                        head.put("X-Maizhong-AppKey",token);


                        //如果智能报价与当前价格差值小于500 直接给智能报价
                        if(diff.compareTo(new BigDecimal("0.05"))<0){

                            body.put("plus",diff.toString());
                            body.put("price",now.toString());

                        }else{
                            //加500
                            body.put("plus","0.05");
                            body.put("price",now.toString());
                            //放回队列
                            jedisClient.lpush(key.getBytes(),rpop);
                        }
                        try {
                            LOGGER.info("智能出价 {}",body.toString());
                            HttpUtils.doPost(MAINSERVICE,"/app/addPrice/"+channel+"/"+carId+ "/" +auctionId,null,head,query,body);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else{
                        //jedisClient.hset("AUTOPRICE_CAR:" + auctionId, String.valueOf(autoPrice.getUserId()),"over");
                    }

                }
            }else{
                //jedisClient.hset("AUTOPRICE_CAR:" + auctionId, String.valueOf(autoPrice.getUserId()),"over");
            }

        }



    }

    /**
     * 拍卖结束 数据持久化队列添加
     */
    private void addDataQueue(CarAcutionDTO carAcutionDTO){
        byte[] redisKey = "DataQueue".getBytes();
        jedisClient.lpush(redisKey, ObjectUtil.serializer(carAcutionDTO));
    }

    /**
     * 拍卖队列获取下俩车
     * @param ch
     */
    private String getNextCarQueue(String ch){

        String nextCar = "over";
        try {
            byte[] redisKey = ("AuctionQueue:"+ch).getBytes();
            byte[] rpop = jedisClient.rpop(redisKey);
            if(rpop==null){
                //没有车了
                TimeUnit.SECONDS.sleep(5);
            }else{

                WaitAuctionQueueDto dto = ObjectUtil.deserializer(rpop, WaitAuctionQueueDto.class);
                TimeUnit.SECONDS.sleep(4);

                long carId = dto.getCarId();
                long overTime = TimeUtils.getOverTime(dto.getMinutes());
                //创建拍卖记录
                AcAuctionRecord record = new AcAuctionRecord();
                record.setCarId(carId);
                record.setChKey(ch);
                record.setStartTime(TimeUtils.getNowTime());
                record.setTime(Long.valueOf(dto.getMinutes()));
                record.setEndTime(String.valueOf(overTime));
                record.setStatus(0);
                record.setUserId(0L);
                acAuctionRecordMapper.insertSelective(record);
                //更新状态为正在拍
                CkCarbase ckCarbase = new CkCarbase();
                ckCarbase.setId(carId);
                ckCarbase.setStatus(5);
                ckCarbaseMapper.updateByPrimaryKeySelective(ckCarbase);
                //通道数据
                CarAcutionDTO carAcutionDTO = new CarAcutionDTO();
                carAcutionDTO.setNowPrice(dto.getStartPrice());
                carAcutionDTO.setChannel(ch);
                carAcutionDTO.setCarId(carId);
                carAcutionDTO.setOverTime(overTime);
                carAcutionDTO.setId(record.getId());
                carAcutionDTO.setLastUserId(0L);
                nextCar = JsonUtils.objectToJson(carAcutionDTO);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return nextCar;
    }

}
