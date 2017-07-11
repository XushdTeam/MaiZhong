package com.maizhong.auction.service.impl;

import com.maizhong.auction.channel.InitChannel;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.AuctionHistoryDTO;
import com.maizhong.auction.dto.CarAcutionDTO;
import com.maizhong.auction.mapper.TpAuctionoverMapper;
import com.maizhong.auction.mapper.TpHistoryMapper;
import com.maizhong.auction.mapper.TpNowMapper;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.ChannelService;
import com.maizhong.auction.socket.SpringWebSocketHandler;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.ObjectUtil;
import com.maizhong.common.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xushd on 2017/6/26.
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    public static Logger LOGGER = LoggerFactory.getLogger(InitChannel.class);

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private TpAuctionoverMapper tpAuctionoverMapper;

    @Autowired
    private TpHistoryMapper tpHistoryMapper;

    @Autowired
    private TpNowMapper tpNowMapper;

    @Autowired
    private SpringWebSocketHandler socketHandler;

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





    @Override
    @Transactional
    public void dataSave() {
        byte[] redisKey = "DataQueue".getBytes();
        byte[] rpop = jedisClient.rpop(redisKey);
        if (rpop!=null){
            try {
                CarAcutionDTO dto = ObjectUtil.deserializer(rpop, CarAcutionDTO.class);
                long carId = dto.getCarId();

                TpAuctionover over = new TpAuctionover();
                over.setCarId(carId);
                over.setPrice(dto.getNowPrice());
                over.setChannel(dto.getChannel());

                TpHistoryExample example = new TpHistoryExample();
                TpHistoryExample.Criteria criteria = example.createCriteria();
                criteria.andCarIdEqualTo(carId);
                List<TpHistory> tpHistories = tpHistoryMapper.selectByExample(example);
                if(tpHistories.size()==0){

                    over.setUserId(0L);
                    over.setBussinessName("无用户出价");

                }else{
                    TpHistory tpHistory = tpHistories.get(tpHistories.size() - 1);
                    over.setUserId(tpHistory.getUserId());
                    over.setBussinessName(tpHistory.getBussinessName());
                }
                over.setCreateTime(new Date());
                over.setUpdateTime(new Date());

                tpAuctionoverMapper.insertSelective(over);

                LOGGER.info("INSET {}",carId);

                TpNowExample tpNowExample = new TpNowExample();
                TpNowExample.Criteria criteria1 = tpNowExample.createCriteria();
                criteria1.andCarIdEqualTo(carId);
                tpNowMapper.deleteByExample(tpNowExample);

                LOGGER.info("Clear {}",carId);

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
                //未结束

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

    @Override
    public void clearChannel(int chNum) {
        jedisClient.del("DataQueue");
        for (int i = 0; i < chNum; i++) {
             jedisClient.del("CHANNEL:CH"+i);
             jedisClient.del("AuctionQueue:CH"+i);

        }


    }

    @Override
    public void addSocketQueue(AuctionHistoryDTO historyDTO) {
        byte[] redisKey = "Socket".getBytes();
        jedisClient.lpush(redisKey, ObjectUtil.serializer(historyDTO));
    }

    @Override
    public void sendSocket() {

        byte[] redisKey = ("Socket").getBytes();
        byte[] rpop = jedisClient.rpop(redisKey);
        if(rpop!=null){
            AuctionHistoryDTO deserializer = ObjectUtil.deserializer(rpop, AuctionHistoryDTO.class);

            TextMessage msg = new TextMessage(JsonUtils.objectToJson(deserializer));

            try {
                socketHandler.sendMessageToCH(msg,deserializer.getCh());
            } catch (IOException e) {
                e.printStackTrace();
            }
            TpHistory history = new TpHistory();
            history.setPrice(deserializer.getPrice());
            history.setUserId(deserializer.getUserId());
            history.setPlus(deserializer.getPuls());
            history.setCarId(deserializer.getCarId());
            history.setBussinessName(deserializer.getBussinessName());
            history.setAuctionDate(deserializer.getAuctionDate());
            tpHistoryMapper.insertSelective(history);
        }


    }

    /**
     * 数据持久化队列添加
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
                CarAcutionDTO dto = ObjectUtil.deserializer(rpop, CarAcutionDTO.class);
                TpNow now = new TpNow();
                now.setCarId(dto.getCarId());
                now.setCh(ch);
                TimeUnit.SECONDS.sleep(4);
                long overTime = TimeUtils.getOverTime(15);
                dto.setOverTime(overTime);
                now.setOverTime(overTime);
                tpNowMapper.insertSelective(now);
                nextCar = JsonUtils.objectToJson(dto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return nextCar;
    }

}
