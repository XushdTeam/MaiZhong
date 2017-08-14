package com.maizhong.auction.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.*;
import com.maizhong.auction.mapper.*;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.AuctionService;
import com.maizhong.auction.service.IndexService;
import com.maizhong.common.enums.AuthEnum;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.enums.SMSTemplateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.*;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private AcBidRecordMapper acBidRecordMapper;

    @Autowired
    private AcAuctionRecordMapper acAuctionRecordMapper;

    @Autowired
    private AcFreezeMapper acFreezeMapper;


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
            acUser.setBzj("0");
            int i = acUserMapper.insertSelective(acUser);
            if(i>0){
                acUser = acUserMapper.selectByPrimaryKey(acUser.getId());
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

    @Override
    public CarInfoDto getCarInfo(long carId) {

        String car_info = jedisClient.hget("CAR_INFO", String.valueOf(carId));


        return JsonUtils.jsonToPojo(car_info,CarInfoDto.class);
    }

    /**
     * 获取当前拍卖车辆信息
     * @param auctionId
     * @param token
     * @return
     */
    @Override
    public JsonResult getCarNow(long auctionId, String token) {

        AcUser acUser = this.getUserInfo(token);

        AuctionNow auctionNow = new AuctionNow();

        auctionNow.setAuctionId(auctionId);

        AcAuctionRecord record = acAuctionRecordMapper.selectByPrimaryKey(auctionId);
        Long carId = record.getCarId();
        String chKey = record.getChKey();

        auctionNow.setChKey(chKey);
        auctionNow.setAuction(0);

        auctionNow.setCurPrice(record.getPrice());
        auctionNow.setLastUserId(record.getUserId());

        if(record.getStatus()==0){
            //拍卖进行中
            String redieCH = jedisClient.get("CHANNEL:" + chKey);
            if((StringUtils.isNotBlank(redieCH)&&!StringUtils.equals("over",redieCH))){

                CarAcutionDTO carAcutionDTO = JsonUtils.jsonToPojo(redieCH, CarAcutionDTO.class);

                if(carAcutionDTO.getId()==auctionId){

                    auctionNow.setAuction(1);
                    auctionNow.setCurPrice(carAcutionDTO.getNowPrice());
                    auctionNow.setOverTime(carAcutionDTO.getOverTime());
                    auctionNow.setNowTime(TimeUtils.getCurrentTime());
                    auctionNow.setLastUserId(carAcutionDTO.getLastUserId());
                }
            }
        }

        //出价记录
        auctionNow.setMyPlus(0);

        AcBidRecordExample example = new AcBidRecordExample();
        example.createCriteria().andAuctionIdEqualTo(auctionId);
        example.setOrderByClause("id desc");
        List<AcBidRecord> acBidRecords = acBidRecordMapper.selectByExample(example);
        List<BidDto> bidList = new ArrayList<>();
        for (AcBidRecord acBidRecord : acBidRecords) {
            BidDto dto = new BidDto();
            dto.setPrice(acBidRecord.getPrice());
            dto.setTime(TimeUtils.getFormatDateTime3(acBidRecord.getCreateTime()).substring(10,19));
            dto.setName(acBidRecord.getBussinessName());
            dto.setUserId(acBidRecord.getUserId());
            bidList.add(dto);
            //判断我是否出价
            if(acUser!=null&&acUser.getId()==acBidRecord.getUserId()&&auctionNow.getMyPlus()==0){
                auctionNow.setMyPlus(1);
            }
        }
        auctionNow.setBidList(bidList);

        //我是否最高价
        auctionNow.setMyTop(0);
        if(auctionNow.getMyPlus()==1){
            if(auctionNow.getLastUserId()==acUser.getId()){
                auctionNow.setMyTop(1);
            }
        }

        //关注
        AcCarLikeExample ex = new AcCarLikeExample();
        ex.createCriteria().andCarIdEqualTo(carId);
        List<AcCarLikeKey> acCarLikeKeys = acCarLikeMapper.selectByExample(ex);
        auctionNow.setLikeCount(acCarLikeKeys.size());
        auctionNow.setMyLike(0);
        if(acUser!=null){
            for (AcCarLikeKey acCarLikeKey : acCarLikeKeys) {
                if(acCarLikeKey.getUserId()==acUser.getId()){
                    auctionNow.setMyLike(1);
                    break;
                }
            }
        }

        //出价列表 根据保证金的金额
        List<PlusDto> plusList = new ArrayList<>();
        if(acUser!=null && !StringUtils.equals(acUser.getBzj(),"0")){
            BigDecimal bzj = new BigDecimal(acUser.getBzj());
            int level = 5;
            if(bzj.compareTo(new BigDecimal(5000))>=0){
                level = 0;
            }else if(bzj.compareTo(new BigDecimal(3000))>=0 && bzj.compareTo(new BigDecimal(5000))<0){
                level = 1;
            }else if(bzj.compareTo(new BigDecimal(200))>=0 && bzj.compareTo(new BigDecimal(3000))<0){
                level = 2;
            }
            int[] ps = {200,300,500,1000,2000};
            for (int i = 0; i < ps.length; i++) {
                PlusDto dto = new PlusDto();
                dto.setPlus(ps[i]);
                if(i >= level){
                    dto.setUsable(1);
                }else{
                    dto.setUsable(0);
                }
                plusList.add(dto);
            }
        }
        auctionNow.setPlusList(plusList);

        // 智能
        auctionNow.setMyAuto(0);
        auctionNow.setAutoPrice("0");
        if(acUser!=null){
            String auto = jedisClient.hget("AUTOPRICE_CAR:" + auctionId, String.valueOf(acUser.getId()));
            if(StringUtils.isNotBlank(auto)){
                auctionNow.setMyAuto(1);
                auctionNow.setAutoPrice(auto);
            }
        }

        return JsonResult.OK(auctionNow);

    }

    /**
     * 出价记录
     * @param auctionId
     * @return
     */
    @Override
    public JsonResult getBidRecordList(long auctionId) {

        AcBidRecordExample example = new AcBidRecordExample();

        example.createCriteria().andAuctionIdEqualTo(auctionId);
        example.setOrderByClause("create_time desc");
        List<AcBidRecord> acBidRecords = acBidRecordMapper.selectByExample(example);

        JSONArray list = new JSONArray();
        for (AcBidRecord acBidRecord : acBidRecords) {
            JSONObject obj = new JSONObject();
            obj.put("price",acBidRecord.getPrice());
            obj.put("createTime",TimeUtils.getFormatDateTime3(acBidRecord.getCreateTime()).substring(10,19));
            obj.put("bussinessName",acBidRecord.getBussinessName());
            obj.put("userId",acBidRecord.getUserId());
            list.add(obj);
        }
        return JsonResult.OK(list);
    }

    /**
     * 智能报价
     * @param auctionId
     * @param price
     * @param token
     * @return
     */
    @Override
    public JsonResult autoPrice(long auctionId, long price, String token) {

        AcUser acUser = this.getUserInfo(token);

        if(acUser==null)return JsonResult.Error("未登录");
        Boolean isPlused = false;
        //保证金扣除冻结是否大于2000 大于可以加价 否则不可以
        BigDecimal bzj = new BigDecimal(acUser.getBzj());
        if(bzj.compareTo(new BigDecimal(0))==0){
            return JsonResult.Error("该帐号未缴纳保证金!");
        }else if(bzj.compareTo(new BigDecimal(2000))<0){
            return JsonResult.Error("该帐号保证金不足2000");
        }else{
            AcFreezeExample example = new AcFreezeExample();
            example.createCriteria().andUserIdEqualTo(acUser.getId());
            List<AcFreeze> acFreezes = acFreezeMapper.selectByExample(example);
            for (AcFreeze acFreeze : acFreezes) {
                if (acFreeze.getAuctionId()==auctionId){
                    isPlused = true;break;
                }
            }
            if(!isPlused){
                int size = acFreezes.size();
                BigDecimal freezePrice = new BigDecimal(2000).multiply(new BigDecimal(size));
                BigDecimal subtract = bzj.subtract(freezePrice);
                if(subtract.compareTo(new BigDecimal(2000))<0){
                    return JsonResult.Error("该帐号保证金余额不足2000");
                }
            }
        }

        String key = "AUTOPRICE_QUEUE:"+auctionId;

        AutoPrice dto = new AutoPrice();
        dto.setAuctionId(auctionId);
        dto.setPrice(price);
        dto.setUserId(acUser.getId());
        dto.setPhone(acUser.getPhone());
        jedisClient.lpush(key.getBytes(), ObjectUtil.serializer(dto));

        jedisClient.hset("AUTOPRICE_CAR:" + auctionId, String.valueOf(acUser.getId()),price+"");

        return JsonResult.OK();

    }

}
