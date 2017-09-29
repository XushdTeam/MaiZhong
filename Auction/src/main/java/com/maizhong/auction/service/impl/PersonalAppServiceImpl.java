package com.maizhong.auction.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.CarDetailDto;
import com.maizhong.auction.dto.CarInfoDto;
import com.maizhong.auction.mapper.*;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.PersonalAppService;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.enums.SMSTemplateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.AliSMSUtils;
import com.maizhong.common.utils.IDUtils;
import com.maizhong.common.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Xushd on 2017/8/1.
 */
@Service
public class PersonalAppServiceImpl extends BaseServiceImpl implements PersonalAppService {


    @Autowired
    private PsUserMapper psUserMapper;

    @Autowired
    private AcFeedbackMapper feedbackMapper;

    @Autowired
    private CkNewsMapper ckNewsMapper;

    @Autowired
    private PsSaleNeedMapper psSaleNeedMapper;

    @Autowired
    private CkCarbaseMapper ckCarbaseMapper;
    /**
     * 获取token
     * @param deviceId
     * @return
     */
    @Override
    public JsonResult getToken(String deviceId) {
        String token = IDUtils.sha256(IDUtils.replaceSpecStr(deviceId));
        return JsonResult.build(200,token,token);
    }

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @Override
    public JsonResult getVerifyCode(long phone) {
        JedisClient jedisClient = super.getJedisClient();
        String phoneVerifyCode = jedisClient.get("SMS:" + phone);
        if(StringUtils.isNotBlank(phoneVerifyCode)){
            return JsonResult.Error("验证码已发送");
        }
        String verifyCode = IDUtils.getVerifyCode();
        boolean sms = AliSMSUtils.sendSMS2(SMSTemplateEnum.YouPinPaiChe, verifyCode, String.valueOf(phone),"登录");
        if(sms){
            jedisClient.set("SMS:"+phone,verifyCode);
            jedisClient.expire("SMS:"+phone,120);
            return JsonResult.OK("验证码发送成功，请注意查收！");
        }

        return JsonResult.Error("发送失败");
    }

    /**
     * 登录
     * @param phone
     * @param verifyCode
     * @param token
     * @return
     */
    @Override
    public JsonResult login(long phone, String verifyCode, String token) {

        JedisClient jedisClient = super.getJedisClient();
        String phoneVerifyCode = jedisClient.get("SMS:" + phone);
        if(StringUtils.isBlank(phoneVerifyCode)){
            return JsonResult.Error("验证码过期，请重新发送");
        } else if(!StringUtils.equals(phoneVerifyCode,verifyCode)){
            return JsonResult.Error("验证码错误");
        } else {
            PsUserExample example = new PsUserExample();
            example.createCriteria().andPhoneEqualTo(phone);
            PsUser user = new PsUser();
            List<PsUser> psUsers = psUserMapper.selectByExample(example);
            if(psUsers.size()==0){
                //注册
                user.setPhone(phone);
                user.setPasswod(IDUtils.sha256("123456"));
                user.setDelflag(0);
                user.setStatus(1);
                user.setRegistTime(new Date());
                user.setUpdateTime(new Date());
                psUserMapper.insertSelective(user);
            }else{
                //登录
                user = psUsers.get(0);
            }
            user.setToken(token);
            jedisClient.hset("APP_PERSONAL",token, JsonUtils.objectToJson(user));
            jedisClient.del("SMS:" + phone);
            return JsonResult.OK(user);
        }
    }

    /**
     * 反馈
     * @param content
     * @param token
     * @return
     */
    @Override
    public JsonResult feedback(String content, String token) {
        PsUser psUser = super.getPersonalUserByToken(token);
        AcFeedback feedback = new AcFeedback();
        feedback.setContent(content);
        feedback.setType(2);
        feedback.setUserId(psUser.getId());
        feedback.setUserPhone(psUser.getPhone());
        feedback.setCreateTime(new Date());

        int i = feedbackMapper.insertSelective(feedback);
        if(i>0)return JsonResult.OK();
        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 新闻列表
     * @return
     */
    @Override
    public JsonResult getNewsList() {

        CkNewsExample example = new CkNewsExample();
        example.createCriteria().andTypeEqualTo(2);
        List<CkNews> ckNews = ckNewsMapper.selectByExample(example);
        JSONArray list = new JSONArray();
        for (CkNews ckNew : ckNews) {
            JSONObject object = new JSONObject();
            object.put("title",ckNew.getNewsTitle());
            object.put("id",ckNew.getId());
            object.put("img",ckNew.getNewsImg());
            list.add(object);
        }
        return JsonResult.OK(list);
    }

    /**
     * 新闻详情
     * @param id
     * @return
     */
    @Override
    public JsonResult getNewsDetail(long id) {

        CkNews ckNews = ckNewsMapper.selectByPrimaryKey(id);
        JSONObject object = new JSONObject();
        object.put("title",ckNews.getNewsTitle());
        object.put("content",ckNews.getNewsContent());
        object.put("time",ckNews.getUpdateTime());
        object.put("img",ckNews.getNewsImg());
        object.put("author",ckNews.getAuthor());
        return JsonResult.OK(object);
    }

    /**
     * 问题列表
     * @return
     */
    @Override
    public JsonResult getProblemList() {
        CkNewsExample example = new CkNewsExample();
        example.createCriteria().andTypeEqualTo(3);
        List<CkNews> ckNews = ckNewsMapper.selectByExample(example);
        JSONArray list = new JSONArray();
        for (CkNews ckNew : ckNews) {
            JSONObject object = new JSONObject();
            object.put("title",ckNew.getNewsTitle());
            object.put("id",ckNew.getId());
            list.add(object);
        }
        return JsonResult.OK(list);
    }

    /**
     * 问题详情
     * @param id
     * @return
     */
    @Override
    public JsonResult getProblemDetail(long id) {
        CkNews ckNews = ckNewsMapper.selectByPrimaryKey(id);
        JSONObject object = new JSONObject();
        object.put("title",ckNews.getNewsTitle());
        object.put("content",ckNews.getNewsContent());
        object.put("time",ckNews.getUpdateTime());
        object.put("img",ckNews.getNewsImg());
        object.put("author",ckNews.getAuthor());
        return JsonResult.OK(object);
    }

    /**
     * 修改头像
     * @param imgStr
     * @param token
     * @return
     */
    @Override
    public JsonResult changeHeadImg(String imgStr, String token) {

        PsUser psUser = super.getPersonalUserByToken(token);

        psUser.setHeadImg(imgStr);

        super.getJedisClient().hset("APP_PERSONAL",token,JsonUtils.objectToJson(psUser));

        psUserMapper.updateByPrimaryKeySelective(psUser);

        return JsonResult.OK(psUser);
    }

    /**
     * 卖车
     * @param phone
     * @param cityId
     * @param token
     * @return
     */
    @Override
    public JsonResult saleCar(long phone, int cityId, String token) {

        PsUser psUser = super.getPersonalUserByToken(token);

        PsSaleNeedExample example = new PsSaleNeedExample();
        example.createCriteria().andPhoneEqualTo(phone).andCityIdEqualTo(cityId).andUserIdEqualTo(psUser.getId());
        long l = psSaleNeedMapper.countByExample(example);
        if(l>0)return JsonResult.Error("已经提交申请，客服人员会很快联系您！");

        PsSaleNeed need = new PsSaleNeed();
        need.setOrderNumber(String.valueOf(IDUtils.getOrderId()));
        need.setPhone(phone);
        need.setCityId(cityId);
        need.setStatus(0);
        need.setUserId(psUser.getId());
        need.setUserPhone(psUser.getPhone());
        need.setCreateTime(new Date());
        int i = psSaleNeedMapper.insertSelective(need);
        if(i>0)return JsonResult.OK();

        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * wo de pai che list
     * @param token
     * @return
     */
    @Override
    public JsonResult myCarList(String token) {

        PsUser psUser = super.getPersonalUserByToken(token);

        PsSaleNeedExample example = new PsSaleNeedExample();
        example.createCriteria().andUserIdEqualTo(psUser.getId());

        List<PsSaleNeed> psSaleNeeds = psSaleNeedMapper.selectByExample(example);

        CkCarbaseExample ex = new CkCarbaseExample();

        List<CarInfoDto> list = new ArrayList<>();
        for (PsSaleNeed psSaleNeed : psSaleNeeds) {
            String orderNumber = psSaleNeed.getOrderNumber();
            ex.clear();
            ex.createCriteria().andOrderNumEqualTo(Long.valueOf(orderNumber));
            List<CkCarbase> ckCarbases = ckCarbaseMapper.selectByExample(ex);
            for (CkCarbase ckCarbasis : ckCarbases) {
                Long id = ckCarbasis.getId();
                String car_info = super.getJedisClient().hget("CAR_INFO", String.valueOf(id));
                CarInfoDto infoDto = JsonUtils.jsonToPojo(car_info, CarInfoDto.class);
                infoDto.setStatus(ckCarbasis.getStatus()+"");
                list.add(infoDto);
            }

        }


        return JsonResult.OK(list);
    }

    /**
     * 检车报告
     * @param carId
     * @return
     */
    @Override
    public JsonResult getCarDetail(long carId) {

        String car_detail = super.getJedisClient().hget("CAR_DETAIL", String.valueOf(carId));
        return JsonResult.OK(JsonUtils.jsonToPojo(car_detail, CarDetailDto.class));
    }


}
