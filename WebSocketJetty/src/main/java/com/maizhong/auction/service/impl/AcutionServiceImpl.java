package com.maizhong.auction.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.CarAcutionDTO;
import com.maizhong.auction.mapper.AcAuctionNowMapper;
import com.maizhong.auction.pojo.AcAuctionNow;
import com.maizhong.auction.pojo.AcAuctionNowExample;
import com.maizhong.auction.pojo.AcBidRecord;
import com.maizhong.auction.pojo.AcUser;
import com.maizhong.auction.service.AcutionService;
import com.maizhong.auction.service.ChannelService;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xushd on 2017/6/28.
 */
@Service
public class AcutionServiceImpl implements AcutionService {

    public static Logger LOGGER = LoggerFactory.getLogger(AcutionServiceImpl.class);

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private AcAuctionNowMapper acAuctionNowMapper;

    @Autowired
    private ChannelService channelService;

    @Override
    public JsonResult getCarNow() {

        AcAuctionNowExample example = new AcAuctionNowExample();
        example.setOrderByClause( " end_time desc");
        JSONArray list = new JSONArray();
        List<AcAuctionNow> acAuctionNows = acAuctionNowMapper.selectByExample(example);
        for (AcAuctionNow acAuctionNow : acAuctionNows) {
            JSONObject dto = new JSONObject();
            String chKey = acAuctionNow.getChKey();
            String redieCH = jedisClient.get("CHANNEL:" + chKey);
            CarAcutionDTO carAcutionDTO = JsonUtils.jsonToPojo(redieCH, CarAcutionDTO.class);
            dto.put("carId",carAcutionDTO.getCarId());
            dto.put("chKey",carAcutionDTO.getChannel());
            dto.put("endTime",carAcutionDTO.getOverTime());
            dto.put("price",carAcutionDTO.getNowPrice());
            list.add(dto);
        }
        return JsonResult.build(200, TimeUtils.getCurrentTime()+"",list);
    }

    /**
     * 加价
     * @param ch
     * @param carId
     * @param plus
     * @param price
     * @param token
     * @return
     */
    @Override
    public synchronized JsonResult addPrice(String ch, long carId, long plus, long price, String token) {
        try {

            AcUser acUser = this.getAcUserByToken(token);

            String redieCH = jedisClient.get("CHANNEL:" + ch);
            if((StringUtils.isNotBlank(redieCH)&&!StringUtils.equals("over",redieCH))){
                CarAcutionDTO carAcutionDTO = JsonUtils.jsonToPojo(redieCH, CarAcutionDTO.class);
                if(TimeUtils.compare(carAcutionDTO.getOverTime())){
                    //
                    if(Long.valueOf(carAcutionDTO.getNowPrice())>=(price+plus)){
                        return JsonResult.Error("出价过低");
                    }else{
                        carAcutionDTO.setNowPrice(price+plus+"");
                        jedisClient.set("CHANNEL:" + ch,JsonUtils.objectToJson(carAcutionDTO));

                        AcBidRecord record = new AcBidRecord();
                        record.setCarId(carId);
                        record.setPrice(String.valueOf(price+plus));
                        record.setPlus(String.valueOf(plus));
                        record.setUserId(acUser.getId());
                        record.setBussinessName(acUser.getCity());
                        record.setChKey(ch);
                        //添加到发送队列
                        channelService.addSocketQueue(record);
                        LOGGER.info("ADD BID 车辆 ID {} 通道 {}",carId,ch);
                        return JsonResult.OK();
                    }


                }else {
                    return JsonResult.Error("拍卖结束");
                }

            }else{
                return JsonResult.Error("拍卖结束");
            }
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.FAILE);
        }
    }
    /**
     * 通过token获取用户信息
     * @param token
     * @return
     */
    public AcUser getAcUserByToken(String token){
        String ac_user_token = jedisClient.hget("AC_USER_TOKEN", token);
        return JsonUtils.jsonToPojo(ac_user_token,AcUser.class);
    }


}
