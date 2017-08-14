package com.maizhong.auction.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.CarInfoDto;
import com.maizhong.auction.mapper.*;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.PersonalService;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by Xushd on 2017/8/14.
 */
@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private AcOrderMapper acOrderMapper;

    @Autowired
    private AcFreezeMapper acFreezeMapper;

    @Autowired
    private AcCarLikeMapper acCarLikeMapper;

    @Autowired
    private AcBidRecordMapper acBidRecordMapper;

    @Autowired
    private AcAuctionRecordMapper acAuctionRecordMapper;

    @Autowired
    private CkCarbaseMapper ckCarbaseMapper;


    /**
     * 个人中心 信息
     * @param token
     * @return
     */
    @Override
    public JsonResult getPersonalInfo(String token) {

        AcUser acUser = getUserInfoByToken(token);
        if(acUser==null)return JsonResult.Error("未登录");

        AcOrderExample example = new AcOrderExample();
        example.createCriteria().andUserIdEqualTo(acUser.getId());
        List<AcOrder> acOrders = acOrderMapper.selectByExample(example);

        JSONObject object = new JSONObject();
        int num1=0,num2=0,num3=0,num4=0;
        for (AcOrder acOrder : acOrders) {
            if(acOrder.getStatus()==1){
                num1++;
            }else if(acOrder.getStatus()==2){
                num2++;
            }else if(acOrder.getStatus()==3){
                num3++;
            }else if(acOrder.getStatus()==4){
                num4++;
            }
        }
        object.put("n1",num1);
        object.put("n2",num2);
        object.put("n3",num3);
        object.put("n4",num4);

        //保证金冻结
        AcFreezeExample ex = new AcFreezeExample();
        ex.createCriteria().andUserIdNotEqualTo(acUser.getId());
        List<AcFreeze> acFreezes = acFreezeMapper.selectByExample(ex);

        long freezePrice = 0L;
        JSONArray list = new JSONArray();
        for (AcFreeze acFreeze : acFreezes) {
            freezePrice+= acFreeze.getFreeze();
        }
        object.put("freeze",freezePrice);

        return JsonResult.OK(object);
    }

    /**
     * 获取成交确认车辆
     * @param token
     * @return
     */
    @Override
    public JsonResult getOrderDealOK(String token) {
        AcUser acUser = this.getUserInfoByToken(token);

        if(acUser==null)return JsonResult.Error("未登录");

        AcOrderExample example = new AcOrderExample();
        example.createCriteria().andUserIdEqualTo(acUser.getId()).andStatusEqualTo(1);

        List<AcOrder> acOrders = acOrderMapper.selectByExample(example);

        JSONArray list = new JSONArray();

        for (AcOrder acOrder : acOrders) {
            Long carId = acOrder.getCarId();
            String car_info = jedisClient.hget("CAR_INFO", String.valueOf(carId));
            CarInfoDto infoDto = JsonUtils.jsonToPojo(car_info, CarInfoDto.class);
            infoDto.setDealTime(TimeUtils.getFormatDateTime3(acOrder.getCreateTime()));
            infoDto.setDealPrice(acOrder.getPrice());
            list.add(infoDto);
        }
        return JsonResult.OK(list);

    }

    /**
     * 获取所有订单
     * @param token
     * @return
     */
    @Override
    public JsonResult getOrderList(String token) {
        AcUser acUser = this.getUserInfoByToken(token);

        if(acUser==null)return JsonResult.Error("未登录");

        AcOrderExample example = new AcOrderExample();
        example.createCriteria().andUserIdEqualTo(acUser.getId());

        List<AcOrder> acOrders = acOrderMapper.selectByExample(example);

        JSONArray list = new JSONArray();

        for (AcOrder acOrder : acOrders) {
            Long carId = acOrder.getCarId();
            String car_info = jedisClient.hget("CAR_INFO", String.valueOf(carId));
            CarInfoDto infoDto = JsonUtils.jsonToPojo(car_info, CarInfoDto.class);
            infoDto.setDealTime(TimeUtils.getFormatDateTime3(acOrder.getCreateTime()));
            infoDto.setDealPrice(acOrder.getPrice());
            if(acOrder.getStatus()==0){
                infoDto.setStatus("等待卖方确认");
            }else if(acOrder.getStatus()==1){
                infoDto.setStatus("订单已确认");
            }else if(acOrder.getStatus()==2){
                infoDto.setStatus("待付款");
            }else if(acOrder.getStatus()==3){
                infoDto.setStatus("交付中");
            }else if(acOrder.getStatus()==4){
                infoDto.setStatus("交易完成");
            }
            list.add(infoDto);
        }
        return JsonResult.OK(list);
    }

    /**
     * 获取出价车辆
     * @param token
     * @return
     */
    @Override
    public JsonResult getBidRecordList(String token) {

        AcUser acUser = this.getUserInfoByToken(token);

        if(acUser==null)return JsonResult.Error("未登录");

        AcBidRecordExample example = new AcBidRecordExample();
        example.createCriteria().andUserIdEqualTo(acUser.getId()).andCreateTimeBetween(TimeUtils.getNowMoring(),new Date());
        example.setDistinct(true);
        List<AcBidRecord> acBidRecords = acBidRecordMapper.selectByExample(example);
        JSONArray list = new JSONArray();
        for (AcBidRecord acBidRecord : acBidRecords) {
            Long carId = acBidRecord.getCarId();
            CkCarbase ckCarbase = ckCarbaseMapper.selectByPrimaryKey(carId);
            String car_info = jedisClient.hget("CAR_INFO", String.valueOf(carId));
            CarInfoDto infoDto = JsonUtils.jsonToPojo(car_info, CarInfoDto.class);
            if(ckCarbase.getStatus()==5){
                infoDto.setAuction(true);
            }
            list.add(infoDto);

        }


        return JsonResult.OK(list);
    }

    /**
     * 获取关注车辆
     * @param token
     * @return
     */
    @Override
    public JsonResult getLikeCarList(String token) {

        AcUser acUser = this.getUserInfoByToken(token);

        if(acUser==null)return JsonResult.Error("未登录");

        AcCarLikeExample example = new AcCarLikeExample();
        example.createCriteria().andUserIdEqualTo(acUser.getId());
        JSONArray list = new JSONArray();
        List<AcCarLikeKey> acCarLikeKeys = acCarLikeMapper.selectByExample(example);
        for (AcCarLikeKey acCarLikeKey : acCarLikeKeys) {

            Long carId = acCarLikeKey.getCarId();
            CkCarbase ckCarbase = ckCarbaseMapper.selectByPrimaryKey(carId);
            String car_info = jedisClient.hget("CAR_INFO", String.valueOf(carId));
            CarInfoDto infoDto = JsonUtils.jsonToPojo(car_info, CarInfoDto.class);
            if(ckCarbase.getStatus()==5){
                infoDto.setAuction(true);
            }
            list.add(infoDto);

        }

        return JsonResult.OK(list);
    }


    public AcUser getUserInfoByToken(String token){

        String ac_user_token = jedisClient.hget("AC_USER_TOKEN", token);
        if(StringUtils.isNotBlank(ac_user_token)){
            return JsonUtils.jsonToPojo(ac_user_token,AcUser.class);
        }
        return null;

    }



}
