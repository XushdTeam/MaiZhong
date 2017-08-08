package com.maizhong.auction.service.impl;

import com.github.pagehelper.PageHelper;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.CarDetailDto;
import com.maizhong.auction.dto.CarInfoDto;
import com.maizhong.auction.dto.MenuDto;
import com.maizhong.auction.mapper.*;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.IndexService;
import com.maizhong.common.enums.AuthEnum;
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
import java.util.List;

/**
 * Created by Xushd on 2017/7/3.
 */
@Service
public class IndexServiceImpl implements IndexService {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private AcUserMapper acUserMapper;

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private CkCarbaseMapper ckCarbaseMapper;

    @Autowired
    private AcCarLikeMapper acCarLikeMapper;


    /**
     * 后台登录验证
     * @param account
     * @param password
     * @param checked
     * @return
     */
    @Override
    public JsonResult loginCheck(String account, String password, boolean checked) {

        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0).andPhoneNumEqualTo(Long.valueOf(account));
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        if(sysUsers.size()==0){
            return JsonResult.build(AuthEnum.USER_NO_EXIT);
        }else{
            SysUser sysUser = sysUsers.get(0);
            if(!StringUtils.equals(password,sysUser.getPassword())){
                return JsonResult.build(AuthEnum.USER_ERROR_PASSWORD);
            }else{
                if(sysUser.getStatus()==0){
                    return JsonResult.build(AuthEnum.USER_STOP);
                }
                String token = IDUtils.getUUID();
                jedisClient.set("WEB_LOGIN:"+token, JsonUtils.objectToJson(sysUser));
                if(!checked){
                    jedisClient.expire("WEB_LOGIN:"+token,60*30);
                }
                return JsonResult.build(200,"登录成功",token);
            }
        }

    }

    /**
     * 验证登录状态
     * @param token
     * @return
     */
    @Override
    public JsonResult checkLoginStatus(String token) {

        String s = jedisClient.get("WEB_LOGIN:" + token);
        if(StringUtils.isBlank(s)){
            return JsonResult.Error("TIME IS OUT");
        }
        return JsonResult.OK(JsonUtils.jsonToPojo(s,SysUser.class).getUsername());
    }

    /**
     * 获取用户的菜单
     * @param token
     * @return
     */
    @Override
    public String getSystemMenu(String token) {

        String userStr = jedisClient.get("WEB_LOGIN:" + token);
        SysUser sysUser = JsonUtils.jsonToPojo(userStr, SysUser.class);


        List<SysMenu> sysMenus = sysMenuMapper.selectMenuByUserId(sysUser.getId());

        SysMenuExample example = new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(0L).andDelflagEqualTo(0);
        List<SysMenu> parents = sysMenuMapper.selectByExample(example);

        List<MenuDto> list = new ArrayList<>();

        for (SysMenu parent : parents) {
            List<MenuDto> temp = new ArrayList<>();
            for (SysMenu menu : sysMenus) {
                if(menu.getParentId()==parent.getId()){
                    MenuDto dto = new MenuDto();
                    dto.setIcon(menu.getIcon());
                    dto.setName(menu.getName());
                    dto.setUrl(menu.getUrl());
                    temp.add(dto);
                }
            }
            if(temp.size()>0){
                MenuDto dto = new MenuDto();
                dto.setIcon(parent.getIcon());
                dto.setName(parent.getName());
                dto.setUrl(parent.getUrl());
                dto.setSubs(temp);
                list.add(dto );
            }

        }
        return JsonUtils.objectToJson(list);
    }

    @Override
    public JsonResult logOff(String token) {

        jedisClient.del("WEB_LOGIN:"+token);

        return JsonResult.OK();
    }

    /**
     * 手机号验证码登录
     * @param phone
     * @param verifyCode
     * @return
     */
    @Override
    public JsonResult loginByPhone(long phone, String verifyCode) {

        String phoneVerifyCode = jedisClient.get("SMS:" + phone);
        if(StringUtils.isBlank(phoneVerifyCode)){
            return JsonResult.Error("验证码过期，请重新发送");
        } else if(!StringUtils.equals(phoneVerifyCode,verifyCode)){
            return JsonResult.Error("验证码错误");
        } else {
            String token = jedisClient.hget("AC_USER_TOKEN", phone + "");
            if(StringUtils.isBlank(token)){
                AcUserExample example = new AcUserExample();
                example.createCriteria().andPhoneEqualTo(phone).andStatusNotEqualTo(-1);
                List<AcUser> acUsers = acUserMapper.selectByExample(example);
                if(acUsers.size()==0)return JsonResult.Error("帐号不存在!");
                AcUser acUser = acUsers.get(0);
                if(acUser.getStatus()==0)return JsonResult.Error("帐号被停用，请联系客服人员！");
                token = IDUtils.getUUID();
                jedisClient.hset("AC_USER_PHONE", phone + "",token);
                jedisClient.hset("AC_USER_TOKEN", token + "",JsonUtils.objectToJson(acUser));
            }
            return JsonResult.build(200,"OK",token);
        }

    }

    /**
     * 发送注册手机号
     * @param phone
     * @return
     */
    @Override
    public JsonResult getVerifyCodeRegist(long phone) {

        AcUserExample example = new AcUserExample();
        example.createCriteria().andPhoneEqualTo(phone).andStatusNotEqualTo(-1);
        long l = acUserMapper.countByExample(example);
        if(l>0)return JsonResult.Error("手机号已注册，请直接登录！");

        String phoneVerifyCode = jedisClient.get("SMS:" + phone);
        if(StringUtils.isNotBlank(phoneVerifyCode)){
            return JsonResult.Error("验证码已发送");
        }

        String verifyCode = IDUtils.getVerifyCode();
        boolean sms = AliSMSUtils.sendSMS2(SMSTemplateEnum.YouPinPaiChe, verifyCode, String.valueOf(phone),"注册");
        if(sms){
            jedisClient.set("SMS:"+phone,verifyCode);
            jedisClient.expire("SMS:"+phone,120);
            return JsonResult.OK("验证码发送成功，请注意查收！");
        }

        return JsonResult.Error("发送失败");

    }

    /**
     * pc 用户注册
     * @param phone
     * @param verifyCode
     * @param type
     * @return
     */
    @Override
    public JsonResult registUser(long phone, String verifyCode,int type) {

        String phoneVerifyCode = jedisClient.get("SMS:" + phone);
        if(StringUtils.isBlank(phoneVerifyCode)){
            return JsonResult.Error("验证码过期，请重新发送");
        } else if(!StringUtils.equals(phoneVerifyCode,verifyCode)){
            return JsonResult.Error("验证码错误");
        } else {

            AcUser acUser = new AcUser();
            acUser.setPhone(phone);
            acUser.setPassword(IDUtils.sha256("123456"));
            acUser.setStatus(9);
            acUser.setName(String.valueOf(phone));
            acUser.setType(type);
            acUser.setCity("北京车商");
            int i = acUserMapper.insertSelective(acUser);
            if(i>0){
                String token = IDUtils.getUUID();
                jedisClient.hset("AC_USER_PHONE",String.valueOf(phone),token);
                jedisClient.hset("AC_USER_TOKEN",token,JsonUtils.objectToJson(acUser));
                return JsonResult.build(200,"OK",token);
            }
        }
        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 通过TOKEN 获取登录用户信息
     * @param token
     * @return
     */
    @Override
    public AcUser getUserInfo(String token) {

        String ac_user_token = jedisClient.hget("AC_USER_TOKEN", token);
        if(StringUtils.isNotBlank(ac_user_token)){
            return JsonUtils.jsonToPojo(ac_user_token,AcUser.class);
        }

        return null;
    }

    /**
     * 通过手机号密码登录
     * @param account
     * @param pass
     * @return
     */
    @Override
    public JsonResult loginByPass(long account, String pass) {

        AcUserExample example = new AcUserExample();
        example.createCriteria().andPhoneEqualTo(account).andStatusNotEqualTo(-1);
        List<AcUser> acUsers = acUserMapper.selectByExample(example);
        if(acUsers.size()==0)return JsonResult.Error("用户不存在!");
        AcUser acUser = acUsers.get(0);
        if(StringUtils.equals(pass,acUser.getPassword())){
            String token = jedisClient.hget("AC_USER_TOKEN", acUser.getPhone() + "");
            if(StringUtils.isBlank(token)){

                token = IDUtils.getUUID();
                jedisClient.hset("AC_USER_PHONE",String.valueOf(acUser.getPhone()),token);
                jedisClient.hset("AC_USER_TOKEN",token,JsonUtils.objectToJson(acUser));

            }
            return JsonResult.build(200,"OK",token);

        }else{
            return JsonResult.Error("密码错误！");
        }
    }

    /**
     * 获取即将上牌的车辆
     * @param token
     * @return
     */
    @Override
    public JsonResult getTopCar(String token) {
        token = token==null?"null":token;
        AcUser acUser = this.getUserInfo(token);

        PageHelper.startPage(1,10);
        CkCarbaseExample example = new CkCarbaseExample();
        CkCarbaseExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(4);
        List<CkCarbase> ckCarbases = ckCarbaseMapper.selectByExample(example);
        List<CarInfoDto> list = new ArrayList<>();
        for (CkCarbase ckCarbasis : ckCarbases) {
            String car_info = jedisClient.hget("CAR_INFO", ckCarbasis.getId() + "");
            CarInfoDto infoDto = JsonUtils.jsonToPojo(car_info, CarInfoDto.class);
            infoDto.setNowPrice(ckCarbasis.getStartPrice());
            if(acUser!=null){
                AcCarLikeExample ex1 = new AcCarLikeExample();
                ex1.createCriteria().andCarIdEqualTo(ckCarbasis.getId());
                List<AcCarLikeKey> acCarLikeKeys = acCarLikeMapper.selectByExample(ex1);
                infoDto.setLikeCounts(acCarLikeKeys.size());
                for (AcCarLikeKey acCarLikeKey : acCarLikeKeys) {
                    if(acCarLikeKey.getUserId()==acUser.getId()){
                        infoDto.setImMyLike(true);
                        break;
                    }
                }
            }
            list.add(infoDto);
        }
        return JsonResult.OK(list);

    }

    @Override
    public CarDetailDto getCarDetail(long carId) {

        String car_detail = jedisClient.hget("CAR_DETAIL", String.valueOf(carId));
        return JsonUtils.jsonToPojo(car_detail, CarDetailDto.class);

    }

}
