package com.maizhong.auction.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.CarInfoDto;
import com.maizhong.auction.mapper.*;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.PersonalService;
import com.maizhong.common.enums.SMSTemplateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.AliSMSUtils;
import com.maizhong.common.utils.IDUtils;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private AcUserMapper acUserMapper;

    @Autowired
    private AcBzjRecordMapper acBzjRecordMapper;


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
        ex.createCriteria().andUserIdEqualTo(acUser.getId());
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
    public List<CarInfoDto> getOrderDealOK(String token) {

        List<CarInfoDto> list = new ArrayList<>();

        AcUser acUser = this.getUserInfoByToken(token);

        if(acUser==null)return list;

        AcOrderExample example = new AcOrderExample();
        example.createCriteria().andUserIdEqualTo(acUser.getId()).andStatusEqualTo(1);

        List<AcOrder> acOrders = acOrderMapper.selectByExample(example);



        for (AcOrder acOrder : acOrders) {
            Long carId = acOrder.getCarId();
            String car_info = jedisClient.hget("CAR_INFO", String.valueOf(carId));
            CarInfoDto infoDto = JsonUtils.jsonToPojo(car_info, CarInfoDto.class);
            infoDto.setDealTime(TimeUtils.getFormatDateTime3(acOrder.getCreateTime()));
            infoDto.setDealPrice(acOrder.getPrice());
            list.add(infoDto);
        }
        return list;

    }

    /**
     * 获取所有订单
     * @param token
     * @return
     */
    @Override
    public List<CarInfoDto> getOrderList(String token) {
        List<CarInfoDto> list = new ArrayList<>();
        AcUser acUser = this.getUserInfoByToken(token);

        if(acUser==null)return list;

        AcOrderExample example = new AcOrderExample();
        example.createCriteria().andUserIdEqualTo(acUser.getId());

        List<AcOrder> acOrders = acOrderMapper.selectByExample(example);



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
        return list;
    }

    /**
     * 获取出价车辆
     * @param token
     * @return
     */
    @Override
    public List<CarInfoDto> getBidRecordList(String token) {

        List<CarInfoDto> list = new ArrayList<>();

        AcUser acUser = this.getUserInfoByToken(token);

        if(acUser==null)return list;

        AcBidRecordExample example = new AcBidRecordExample();
        example.createCriteria().andUserIdEqualTo(acUser.getId()).andCreateTimeBetween(TimeUtils.getNowMoring(),new Date());
        example.setDistinct(true);

        List<AcBidRecord> acBidRecords = acBidRecordMapper.selectByExampleWithGroupBy(example);

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


        return list;
    }

    /**
     * 获取关注车辆
     * @param token
     * @return
     */
    @Override
    public List<CarInfoDto> getLikeCarList(String token) {

        List<CarInfoDto> list = new ArrayList<>();
        AcUser acUser = this.getUserInfoByToken(token);

        if(acUser==null)return list;

        AcCarLikeExample example = new AcCarLikeExample();
        example.createCriteria().andUserIdEqualTo(acUser.getId());

        List<AcCarLikeKey> acCarLikeKeys = acCarLikeMapper.selectByExample(example);
        for (AcCarLikeKey acCarLikeKey : acCarLikeKeys) {

            Long carId = acCarLikeKey.getCarId();
            CkCarbase ckCarbase = ckCarbaseMapper.selectByPrimaryKey(carId);
            String car_info = jedisClient.hget("CAR_INFO", String.valueOf(carId));
            CarInfoDto infoDto = JsonUtils.jsonToPojo(car_info, CarInfoDto.class);
            if(ckCarbase.getStatus()==5){
                infoDto.setAuction(true);
            }
            AcAuctionRecordExample ex = new AcAuctionRecordExample();
            ex.createCriteria().andCarIdEqualTo(carId).andStatusEqualTo(0);

            list.add(infoDto);

        }

        return list;
    }

    /**
     * 修改城市
     * @param city
     * @param token
     * @return
     */
    @Override
    public JsonResult changeCity(String city, String token) {

        AcUser acUser = this.getUserInfoByToken(token);
        if(acUser==null)return JsonResult.Error("当前用户未登录");

        acUser.setCity(city);

        acUserMapper.updateByPrimaryKeySelective(acUser);

        jedisClient.hset("AC_USER_TOKEN",token,JsonUtils.objectToJson(acUser));

        return JsonResult.OK();
    }

    /**
     * 实名认证提交
     * @param name
     * @param idNum
     * @param img1
     * @param img2
     * @param img3
     * @param token
     * @return
     */
    @Override
    public JsonResult smrzSubmit(String name, String idNum, String img1, String img2, String img3, String token) {


        AcUser acUser = this.getUserInfoByToken(token);
        if(acUser==null)return JsonResult.Error("当前用户未登录");

        if(acUser.getStatus()==1)return JsonResult.Error("已认证，请勿重复认证");
        if(acUser.getStatus()==2)return JsonResult.Error("认证中，请等待");

        acUser.setStatus(2);
        acUser.setIdNum(idNum);
        acUser.setPic1(img1);
        acUser.setPic2(img2);
        acUser.setPic3(img3);

        acUserMapper.updateByPrimaryKeySelective(acUser);

        jedisClient.hset("AC_USER_TOKEN",token,JsonUtils.objectToJson(acUser));
        return JsonResult.OK();

    }

    /**
     * 头像修改
     * @param s
     * @param token
     * @return
     */
    @Override
    public JsonResult changeHeadImg(String s, String token) {
        AcUser acUser = this.getUserInfoByToken(token);
        if(acUser==null)return JsonResult.Error("当前用户未登录");

        acUser.setHeadImg(s);

        acUserMapper.updateByPrimaryKeySelective(acUser);
        jedisClient.hset("AC_USER_TOKEN",token,JsonUtils.objectToJson(acUser));
        return JsonResult.build(200,"OK",s);
    }

    /**
     * 获取充值记录
     * @param token
     * @return
     */
    @Override
    public JsonResult getRechargeList(String token) {
        AcUser acUser = this.getUserInfoByToken(token);
        if(acUser==null)return JsonResult.Error("当前用户未登录");

        AcBzjRecordExample example = new AcBzjRecordExample();
        example.createCriteria().andUserIdEqualTo(acUser.getId());
        example.setOrderByClause("create_time desc");

        List<AcBzjRecord> acBzjRecords = acBzjRecordMapper.selectByExample(example);

        return JsonResult.OK(acBzjRecords);

    }

    @Override
    public JsonResult sendSMS(String phone, String token) {
        AcUser acUser = this.getUserInfoByToken(token);
        if(acUser==null)return JsonResult.Error("当前用户未登录");
        String m_phone = String.valueOf(acUser.getPhone());
        if(StringUtils.equals(m_phone,phone)){


            String phoneVerifyCode = jedisClient.get("SMS:" + phone);
            if(StringUtils.isNotBlank(phoneVerifyCode)){
                return JsonResult.Error("验证码已发送");
            }
            String verifyCode = IDUtils.getVerifyCode();
            boolean sms = AliSMSUtils.sendSMS2(SMSTemplateEnum.YouPinPaiChe, verifyCode, String.valueOf(phone),"修改密码");
            if(sms){
                jedisClient.set("SMS:"+phone,verifyCode);
                jedisClient.expire("SMS:"+phone,120);
                return JsonResult.OK("验证码发送成功，请注意查收！");
            }

            return JsonResult.Error("发送失败");

        }else{
            return JsonResult.Error("注册手机号错误！");
        }

    }

    /**
     * 修改密码
     * @param verifyCode
     * @param pass
     * @param token
     * @return
     */
    @Override
    public JsonResult changePass(String verifyCode, String pass, String token) {
        AcUser acUser = this.getUserInfoByToken(token);
        if(acUser==null)return JsonResult.Error("当前用户未登录");
        String phoneVerifyCode = jedisClient.get("SMS:" + acUser.getPhone());
        if(StringUtils.isBlank(phoneVerifyCode))return JsonResult.Error("验证码过期");
        if(StringUtils.equals(phoneVerifyCode,verifyCode)){

            acUser.setPassword(IDUtils.sha256(pass));

            acUserMapper.updateByPrimaryKeySelective(acUser);

            jedisClient.hset("AC_USER_TOKEN",token,JsonUtils.objectToJson(acUser));
            return JsonResult.OK();

        }else{
            return JsonResult.Error("验证码错误");
        }

    }


    public AcUser getUserInfoByToken(String token){

        String ac_user_token = jedisClient.hget("AC_USER_TOKEN", token);
        if(StringUtils.isNotBlank(ac_user_token)){
            return JsonUtils.jsonToPojo(ac_user_token,AcUser.class);
        }
        return null;

    }



}
