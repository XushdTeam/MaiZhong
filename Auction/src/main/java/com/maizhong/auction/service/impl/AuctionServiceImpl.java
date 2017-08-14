package com.maizhong.auction.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.AutoPrice;
import com.maizhong.auction.dto.BidRecordDto;
import com.maizhong.auction.dto.CarAcutionDTO;
import com.maizhong.auction.dto.CarInfoDto;
import com.maizhong.auction.mapper.*;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.AuctionService;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.enums.SMSTemplateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Xushd on 2017/7/10.
 */
@Service
public class AuctionServiceImpl implements AuctionService {

    public static Logger LOGGER = LoggerFactory.getLogger(AuctionServiceImpl.class);

    @Autowired
    private AcDocMapper acDocMapper;
    @Autowired
    private AcTopcarMapper acTopcarMapper;
    @Autowired
    private AcSalebackMapper acSalebackMapper;
    @Autowired
    private CkCarbaseMapper ckCarbaseMapper;
    @Autowired
    private CkOtherMapper ckOtherMapper;
    @Autowired
    private CkDjzMapper ckDjzMapper;
    @Autowired
    private CkVerifyMapper ckVerifyMapper;
    @Autowired
    private CkCarmodelMapper ckCarmodelMapper;
    @Autowired
    private CkBaseimgMapper ckBaseimgMapper;
    @Autowired
    private CkXszMapper ckXszMapper;
    @Autowired
    private AcPickUpManMapper acPickUpManMapper;
    @Autowired
    private AcUserMapper acUserMapper;
    @Autowired
    private AcAuctionNowMapper acAuctionNowMapper;
    @Autowired
    private AcBidRecordMapper acBidRecordMapper;
    @Autowired
    private AcOrderMapper acOrderMapper;
    @Autowired
    private AcAuctionRecordMapper acAuctionRecordMapper;
    @Autowired
    private AcCarLikeMapper acCarLikeMapper;

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private AcFreezeMapper acFreezeMapper;


    /**
     * 根据类型获取文档列表
     * @param type
     * @return
     */
    @Override
    public JsonResult getDocList(int type) {

        AcDocExample example = new AcDocExample();
        AcDocExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1).andTypeEqualTo(type);
        List<AcDoc> acDocs = acDocMapper.selectByExample(example);
        JSONArray list = new JSONArray();
        for (AcDoc acDoc : acDocs) {
            JSONObject dto = new JSONObject();
            dto.put("id",acDoc.getId());
            dto.put("title",acDoc.getTitle());
            list.add(dto);
        }
        return JsonResult.OK(list);
    }

    /**
     * 获取文档详情
     * @param id
     * @return
     */
    @Override
    public JsonResult getDocDetail(long id) {
        AcDoc acDoc = acDocMapper.selectByPrimaryKey(id);
        return JsonResult.OK(acDoc);
    }

    /**
     * 获取推荐车辆
     * @return
     */
    @Override
    public JsonResult getTopCar() {



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
            list.add(infoDto);
        }
        return JsonResult.OK(list);
    }

    /**
     * 获取售后车辆
     * @param token
     * @return
     */
    @Override
    public JsonResult getSaleBackCar(String token) {

        AcUser acUser = this.getAcUserByToken(token);
        AcSalebackExample example = new AcSalebackExample();
        AcSalebackExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(acUser.getId());
        List<AcSaleback> acSalebacks = acSalebackMapper.selectByExample(example);
        List<CarInfoDto> list = new ArrayList<>();
        for (AcSaleback acSaleback : acSalebacks) {
            long carId = acSaleback.getCarId();
            CarInfoDto dto = new CarInfoDto();
            dto.setDealPrice(acSaleback.getDealPrice());
            dto.setDealTime(TimeUtils.getFormatDateTimeShort(acSaleback.getCreateTime()));
            if(acSaleback.getStatus()==1){
                dto.setStatus("订单生成");
            }

            dto.setCarId(carId);
            CkCarbase ckCarbase = ckCarbaseMapper.selectByPrimaryKey(carId);

            dto.setModelName(ckCarbase.getModelName());

            CkOtherExample ex1 = new CkOtherExample();
            CkOtherExample.Criteria cr1 = ex1.createCriteria();
            cr1.andCarIdEqualTo(carId);
            List<CkOther> ckOthers = ckOtherMapper.selectByExample(ex1);
            if (ckOthers.size() > 0) {
                Integer pfbz = ckOthers.get(0).getPfbz();
                if (pfbz == 1) {
                    dto.setPfbz("国2及以下");
                } else if (pfbz == 2) {
                    dto.setPfbz("国3");
                } else if (pfbz == 3) {
                    dto.setPfbz("国4");
                } else if (pfbz == 4) {
                    dto.setPfbz("国5");
                } else {
                    dto.setPfbz("不详");
                }
                Integer pj = ckOthers.get(0).getPj();
                if (pj == 1) {
                    dto.setPj("A");
                } else if (pj == 2) {
                    dto.setPj("B");
                } else if (pj == 3) {
                    dto.setPj("C");
                } else if (pj == 4) {
                    dto.setPj("D");
                }
            }

            CkBaseimgExample ex2 = new CkBaseimgExample();
            CkBaseimgExample.Criteria c2 = ex2.createCriteria();
            c2.andCarIdEqualTo(carId);
            List<CkBaseimg> ckBaseimgs = ckBaseimgMapper.selectByExample(ex2);
            if (ckBaseimgs.size() > 0) {
                dto.setZq45(ckBaseimgs.get(0).getZq45());
            }

            CkDjzExample ex3 = new CkDjzExample();
            CkDjzExample.Criteria c3 = ex3.createCriteria();
            c3.andCarIdEqualTo(carId);
            List<CkDjz> ckDjzs = ckDjzMapper.selectByExample(ex3);
            if(ckDjzs.size()>0){
                dto.setCdrq(ckDjzs.get(0).getCdrq().substring(0,7));
                dto.setZcd(ckDjzs.get(0).getZcd());
            }

            CkXszExample ex4 = new CkXszExample();
            CkXszExample.Criteria c4 = ex4.createCriteria();
            c4.andCarIdEqualTo(carId);
            List<CkXsz> ckXszs = ckXszMapper.selectByExample(ex4);
            if(ckXszs.size()>0){
                dto.setNumber(ckXszs.get(0).getNumber().substring(0,2));
            }

            CkVerifyExample ex5 = new CkVerifyExample();
            CkVerifyExample.Criteria c5 = ex5.createCriteria();
            c5.andCarIdEqualTo(carId);
            List<CkVerify> ckVerifies = ckVerifyMapper.selectByExample(ex5);
            if(ckVerifies.size()>0){
                dto.setBxlc(ckVerifies.get(0).getBxlc());
            }
            list.add(dto);

        }


        return JsonResult.OK(list);
    }

    /**
     * 获取授权提车人
     * @param token
     * @return
     */
    @Override
    public JsonResult getPickUpMan(String token) {
        AcUser acUser = this.getAcUserByToken(token);
        AcPickUpManExample example = new AcPickUpManExample();
        AcPickUpManExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(acUser.getId());
        List<AcPickUpMan> acPickUpMEN = acPickUpManMapper.selectByExample(example);
        if(acPickUpMEN.size()==0){
            return JsonResult.OK(new JSONObject());
        }else{
            return JsonResult.OK(acPickUpMEN.get(0));
        }
    }

    /**
     * 添加授权提车人
     * @param man
     * @param token
     * @return
     */
    @Override
    public JsonResult savePickUpMan(AcPickUpMan man, String token) {

        AcUser acUser = this.getAcUserByToken(token);
        man.setUserId(acUser.getId());
        man.setCreateTime(new Date());
        int i = acPickUpManMapper.insertSelective(man);
        if(i>0){
            acUser.setPickupman(man.getId());
            acUserMapper.updateByPrimaryKeySelective(acUser);
            jedisClient.hset("AC_USER_TOKEN",token,JsonUtils.objectToJson(acUser));
            return JsonResult.OK(man.getId()+"");
        }


        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 用户注册
     * @param acUser
     * @param token
     * @return
     */
    @Override
    public JsonResult registUser(AcUser acUser, String token) {

        acUser.setId(null);
        acUser.setCreateTime(new Date());
        acUser.setStatus(9);
        int i = acUserMapper.insertSelective(acUser);
        if(i>0){
            acUser = acUserMapper.selectByPrimaryKey(acUser.getId());
            jedisClient.hset("AC_USER_TOKEN",token,JsonUtils.objectToJson(acUser));
            jedisClient.hset("AC_USER_PHONE",acUser.getPhone()+"",token);
            return JsonResult.OK(acUser);
        }
        return JsonResult.Error(OperateEnum.FAILE);
    }



    /**
     * 用户登录
     * @param phone
     * @param pass
     * @param token
     * @return
     */
    @Override
    public JsonResult userLogin(long phone, String pass, String token) {

        AcUserExample example = new AcUserExample();
        AcUserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<AcUser> acUsers = acUserMapper.selectByExample(example);
        if(acUsers.size()==0)return JsonResult.Error("用户不存在");
        AcUser acUser = acUsers.get(0);

        if(!StringUtils.equals(pass,acUser.getPassword()))return JsonResult.Error("密码不正确");
        if(acUser.getStatus()<=0)return JsonResult.Error("帐号被停用");
        String newToken = jedisClient.hget("AC_USER_PHONE", phone + "");
        if(StringUtils.isBlank(newToken)){
            newToken = token;
            jedisClient.hset("AC_USER_PHONE",acUser.getPhone()+"",newToken);
        }

        jedisClient.hset("AC_USER_TOKEN",newToken,JsonUtils.objectToJson(acUser));
        return JsonResult.build(200,newToken,acUser);

    }
    /**
     * 用户退出登录
     * @param token
     * @return
     */
    @Override
    public JsonResult userLogout(String token) {
        AcUser acUser = this.getAcUserByToken(token);
        jedisClient.hdel("AC_USER_PHONE",acUser.getPhone()+"");
        jedisClient.hdel("AC_USER_TOKEN",token);
        return JsonResult.OK();
    }

    /**
     * 车辆关注
     * @param carId
     * @param token
     * @return
     */
    @Override
    public JsonResult carLike(long carId, String token) {
        AcUser acUser = this.getAcUserByToken(token);
        if(acUser == null)return JsonResult.Error("未登录");
        AcCarLikeKey likeKey = new AcCarLikeKey();
        likeKey.setCarId(carId);
        likeKey.setUserId(acUser.getId());
        try{
            acCarLikeMapper.insert(likeKey);
        }catch (Exception e){
            return JsonResult.Error("已关注");
        }

        return JsonResult.OK();
    }

    /**
     * 取消关注
     * @param carId
     * @param token
     * @return
     */
    @Override
    public JsonResult carLikeCancle(long carId, String token) {
        AcUser acUser = this.getAcUserByToken(token);
        if(acUser == null)return JsonResult.Error("未登录");
        AcCarLikeKey likeKey = new AcCarLikeKey();
        likeKey.setCarId(carId);
        likeKey.setUserId(acUser.getId());
        acCarLikeMapper.deleteByPrimaryKey(likeKey);
        return JsonResult.OK();
    }

    /**
     * 关注列表
     * @param token
     * @return
     */
    @Override
    public JsonResult carLikeList(String token) {
        AcUser acUser = this.getAcUserByToken(token);
        if(acUser==null)return JsonResult.Error("未登录");

        AcCarLikeExample example = new AcCarLikeExample();
        example.createCriteria().andUserIdEqualTo(acUser.getId());
        List<AcCarLikeKey> acCarLikeKeys = acCarLikeMapper.selectByExample(example);

        List<CarInfoDto> list = new ArrayList<>();

        for (AcCarLikeKey acCarLikeKey : acCarLikeKeys) {

            Long carId = acCarLikeKey.getCarId();
            String car_info = jedisClient.hget("CAR_INFO", String.valueOf(carId));
            CarInfoDto infoDto = JsonUtils.jsonToPojo(car_info, CarInfoDto.class);

            AcAuctionRecordExample ex = new AcAuctionRecordExample();
            ex.createCriteria().andCarIdEqualTo(carId).andStatusEqualTo(0);
            long l = acAuctionRecordMapper.countByExample(ex);
            if(l>0){
                infoDto.setAuction(true);
            }else{
                infoDto.setAuction(false);
            }


            list.add(infoDto);

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

        AcUser acUser = this.getAcUserByToken(token);
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
        jedisClient.lpush(key.getBytes(),ObjectUtil.serializer(dto));

        jedisClient.hset("AUTOPRICE_CAR:" + auctionId, String.valueOf(acUser.getId()),price+"");

        return JsonResult.OK();

    }

    /**
     * APP 修改头像用户
     * @param url
     * @param token
     * @return
     */
    @Override
    public JsonResult userHeadImg(String url, String token) {
        AcUser acUser = this.getAcUserByToken(token);

        acUser.setHeadImg(url);
        int i = acUserMapper.updateByPrimaryKeySelective(acUser);
        if(i>0){
            jedisClient.hset("AC_USER_TOKEN",token,JsonUtils.objectToJson(acUser));
            return JsonResult.OK();
        }
        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 实名认证
     * @param name
     * @param idNum
     * @param pic1
     * @param pic2
     * @param pic3
     * @param token
     * @return
     */
    @Override
    public JsonResult userCertification(String name, String idNum, String pic1, String pic2, String pic3, String token) {
        AcUser acUser = this.getAcUserByToken(token);
        acUser.setIdNum(idNum);
        acUser.setPic1(pic1);
        acUser.setPic2(pic2);
        acUser.setPic3(pic3);
        acUser.setName(name);
        acUser.setStatus(2);
        int i = acUserMapper.updateByPrimaryKeySelective(acUser);
        if(i>0){
            jedisClient.hset("AC_USER_TOKEN",token,JsonUtils.objectToJson(acUser));

            return JsonResult.OK();
        }
        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 获取验证码
     * @param phone
     * @param token
     * @return
     */
    @Override
    public JsonResult getVerifyCode(String phone, String token) {

        AcUserExample example = new AcUserExample();
        AcUserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(Long.valueOf(phone));
        long l = acUserMapper.countByExample(example);
        if(l>0)return JsonResult.Error("该手机号已经注册");

        String phoneVerifyCode = jedisClient.get("SMS:" + phone);
        if(StringUtils.isNotBlank(phoneVerifyCode)){
            return JsonResult.Error("验证码已发送");
        }

        String code = IDUtils.getVerifyCode();
        boolean sms = AliSMSUtils.sendSMS2(SMSTemplateEnum.YouPinPaiChe, code, String.valueOf(phone),"注册");
        if(sms){
            jedisClient.set("SMS:"+phone,code);
            jedisClient.expire("SMS:"+phone,120);
            return JsonResult.OK("验证码发送成功，请注意查收！");
        }

        return JsonResult.Error("发送失败");
    }

    @Override
    public boolean checkVerifyCode(String verifyCode, String token) {

        String code = jedisClient.get("SMS:"+token);

        if(StringUtils.equals(code,verifyCode)){
            return true;
        }

        return false;
    }

    /**
     * 修改归属城市
     * @param city
     * @param token
     * @return
     */
    @Override
    public JsonResult userChangeCity(String city, String token) {
        AcUser acUser = this.getAcUserByToken(token);
        acUser.setCity(city+"车商");
        int i = acUserMapper.updateByPrimaryKeySelective(acUser);
        if(i>0){
            jedisClient.hset("AC_USER_TOKEN",token,JsonUtils.objectToJson(acUser));
            return JsonResult.OK();
        }
        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 同步用户信息
     * @param token
     * @return
     */
    @Override
    public JsonResult syncUserInfo(String token) {

        AcUser acUser = this.getAcUserByToken(token);
        if(acUser==null)return JsonResult.Error("TimeOut");
        if(acUser.getStatus()==0)return JsonResult.Error("STOP");

        return JsonResult.OK(acUser);
    }

    /**
     * 获取正在拍的车辆
     * @param token
     * @return
     */
    @Override
    public JsonResult getNowAuctionList(String token) {
        AcUser acUser = this.getAcUserByToken(token);

        AcAuctionRecordExample example = new AcAuctionRecordExample();
        AcAuctionRecordExample.Criteria cr = example.createCriteria();
        cr.andStatusEqualTo(0);
        example.setOrderByClause("end_time");

        List<AcAuctionRecord> acAuctionRecords = acAuctionRecordMapper.selectByExample(example);

        List<CarInfoDto> list = new ArrayList<>();
        for (AcAuctionRecord record : acAuctionRecords) {
            String chKey = record.getChKey();
            String key = "CHANNEL:"+chKey;
            String s = jedisClient.get(key);
            if(StringUtils.isBlank(s)||StringUtils.equals("over",s))continue;
            Long carId = record.getCarId();

            String car_info = jedisClient.hget("CAR_INFO", carId + "");
            CarInfoDto carInfoDto = JsonUtils.jsonToPojo(car_info,CarInfoDto.class);

            carInfoDto.setAuctionId(record.getId());
            if(acUser==null){
                carInfoDto.setMyAuction(false);
            }else{
                AcBidRecordExample bidRecordExample = new AcBidRecordExample();
                AcBidRecordExample.Criteria criteria = bidRecordExample.createCriteria();
                criteria.andAuctionIdEqualTo(record.getId()).andUserIdEqualTo(acUser.getId());
                long l = acBidRecordMapper.countByExample(bidRecordExample);
                if(l>0){
                    carInfoDto.setMyAuction(true);
                }else{
                    carInfoDto.setMyAuction(false);
                }
            }

            CarAcutionDTO carAcutionDTO = JsonUtils.jsonToPojo(s, CarAcutionDTO.class);
            carInfoDto.setNowPrice(carAcutionDTO.getNowPrice());
            carInfoDto.setOverTime(carAcutionDTO.getOverTime());
            carInfoDto.setNowTime(TimeUtils.getCurrentTime());
            carInfoDto.setChKey(chKey);
            carInfoDto.setAuction(true);
            AcCarLikeExample likeExample = new AcCarLikeExample();
            likeExample.createCriteria().andCarIdEqualTo(carId);
            List<AcCarLikeKey> acCarLikeKeys = acCarLikeMapper.selectByExample(likeExample);
            carInfoDto.setLikeCounts(acCarLikeKeys.size());
            if(acUser!=null){
                for (AcCarLikeKey acCarLikeKey : acCarLikeKeys) {
                    if(acCarLikeKey.getUserId() == acUser.getId()){
                        carInfoDto.setImMyLike(true);
                        break;
                    }
                }
            }else{
                carInfoDto.setImMyLike(false);
            }

            list.add(carInfoDto);

        }
        return JsonResult.OK(list);
    }

    /**
     * 获取汽车详情
     * @param carId
     * @return
     */
    @Override
    public JsonResult getCarDetail(long carId) {

        String carDetail = jedisClient.hget("CAR_DETAIL",carId+"");
        return JsonResult.OK(JSON.parse(carDetail));

    }

    /**
     * 出价
     * @param ch
     * @param carId
     * @param plus
     * @param price
     * @param token
     * @return
     */
    @Override
    public synchronized JsonResult addPrice(String ch, long carId, String  plus, String price, String token,long auctionId) {
        try {

            AcUser acUser = this.getAcUserByToken(token);
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
            String redieCH = jedisClient.get("CHANNEL:" + ch);
            if((StringUtils.isNotBlank(redieCH)&&!StringUtils.equals("over",redieCH))){
                CarAcutionDTO carAcutionDTO = JsonUtils.jsonToPojo(redieCH, CarAcutionDTO.class);
                if(carAcutionDTO.getCarId()!=carId)return JsonResult.Error("拍卖结束");
                long diff = TimeUtils.getDiff(carAcutionDTO.getOverTime());
                if(diff>0){
                    //
                    BigDecimal nowPrice = new BigDecimal(price).add(new BigDecimal(plus));

                    if(new BigDecimal(carAcutionDTO.getNowPrice()).compareTo(nowPrice)>=0){
                        return JsonResult.Error("出价过低");
                    }else{
                        carAcutionDTO.setNowPrice(String.valueOf(nowPrice));
                        carAcutionDTO.setLastUserId(acUser.getId());
                        if(diff<20000){
                            //小于20s
                            carAcutionDTO.setOverTime(carAcutionDTO.getOverTime()+5000);
                        }
                        jedisClient.set("CHANNEL:" + ch,JsonUtils.objectToJson(carAcutionDTO));

                        AcBidRecord record = new AcBidRecord();
                        record.setAuctionId(carAcutionDTO.getId());
                        record.setCarId(carId);
                        record.setPrice(nowPrice.toString());
                        record.setPlus(plus);
                        record.setUserId(acUser.getId());
                        record.setBussinessName(acUser.getCity());
                        record.setChKey(ch);
                        record.setCreateTime(new Date());
                        record.setOverTime(carAcutionDTO.getOverTime());
                        //添加到发送队列
                        this.addSocketQueue(record);
                        LOGGER.info("ADD BID 车辆 ID {} 通道 {}",carId,ch);

                        //判断是否要冻结保证金
                        if(!isPlused){
                            AcFreeze freeze = new AcFreeze();
                            freeze.setFreeze(2000L);
                            freeze.setUserId(acUser.getId());
                            freeze.setAuctionId(auctionId);
                            freeze.setCreateTime(new Date());
                            acFreezeMapper.insertSelective(freeze);

                        }

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

        }
        return JsonResult.Error(OperateEnum.FAILE);
    }

    /**
     * 获取出价记录
     * @param auctionId
     * @param token
     * @return
     */
    @Override
    public JsonResult getBidRecord(long auctionId, String token) {

        AcUser acUser = this.getAcUserByToken(token);

        AcBidRecordExample ex = new AcBidRecordExample();
        ex.createCriteria().andAuctionIdEqualTo(auctionId);
        ex.setOrderByClause(" create_time DESC ");
        List<AcBidRecord> acBidRecords = acBidRecordMapper.selectByExample(ex);
        List<BidRecordDto> list = new ArrayList<>();
        for (AcBidRecord acBidRecord : acBidRecords) {
            BidRecordDto dto = new BidRecordDto();
            dto.setBussinessName(acBidRecord.getBussinessName());
            dto.setPlusTime(TimeUtils.getFormatDateTime3(acBidRecord.getCreateTime()));
            dto.setPrice(acBidRecord.getPrice());

            if(acUser!=null&&acBidRecord.getUserId()==acUser.getId()){
                dto.setMy(true);
            }else{
                dto.setMy(false);
            }
            list.add(dto);
        }


        return JsonResult.OK(list);
    }

    /**
     * 获取成交车辆
     * @param token
     * @return
     */
    @Override
    public JsonResult getCarDealList(String token) {
        AcUser acUser = this.getAcUserByToken(token);

        AcOrderExample example = new AcOrderExample();
        AcOrderExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(acUser.getId()).andStatusEqualTo(1);
        List<AcOrder> acOrders = acOrderMapper.selectByExample(example);
        List<CarInfoDto> list = new ArrayList<>();
        for (AcOrder acOrder : acOrders) {
            Long carId = acOrder.getCarId();
            String car_info = jedisClient.hget("CAR_INFO", carId + "");
            CarInfoDto carInfoDto = JsonUtils.jsonToPojo(car_info, CarInfoDto.class);
            carInfoDto.setDealPrice(acOrder.getPrice());
            carInfoDto.setDealTime(TimeUtils.getFormatDateTime3(acOrder.getCreateTime()));
            carInfoDto.setOrderNum(acOrder.getOrderNum()+"");
            list.add(carInfoDto);
        }
        return JsonResult.OK(list);
    }

    /**
     * 获取加价车辆
     * @param token
     * @return
     */
    @Override
    public JsonResult getCarPlusList(String token) {

        AcUser user = this.getAcUserByToken(token);
        if(user==null)return JsonResult.Error(OperateEnum.FAILE);

        List<AcBidRecord> acBidRecords = acBidRecordMapper.selectRecord(user.getId());
        List<CarInfoDto> list = new ArrayList<>();
        for (AcBidRecord bidRecord : acBidRecords) {
            Long carId = bidRecord.getCarId();
            String car_info = jedisClient.hget("CAR_INFO", carId + "");
            CarInfoDto carInfoDto = JsonUtils.jsonToPojo(car_info, CarInfoDto.class);
            carInfoDto.setDealPrice(bidRecord.getPrice());
            carInfoDto.setDealTime(TimeUtils.getFormatDateTime3(bidRecord.getCreateTime()));
            carInfoDto.setChKey(bidRecord.getChKey());
            list.add(carInfoDto);
        }

        return JsonResult.OK(list);
    }

    /**
     * 获取当前汽车状态
     * @param carId
     * @param chKey
     * @return
     */
    @Override
    public JsonResult getCarNow(long carId, String chKey, String token) {

        AcUser acUser = this.getAcUserByToken(token);

        String redieCH = jedisClient.get("CHANNEL:" + chKey);
        if((StringUtils.isNotBlank(redieCH)&&!StringUtils.equals("over",redieCH))){

            CarAcutionDTO carAcutionDTO = JsonUtils.jsonToPojo(redieCH, CarAcutionDTO.class);
            if(carAcutionDTO.getCarId()==carId){
                JSONObject object = new JSONObject();
                object.put("curPrice",carAcutionDTO.getNowPrice());
                object.put("overTime",carAcutionDTO.getOverTime());
                object.put("nowTime",TimeUtils.getCurrentTime());
                object.put("lastUserId",carAcutionDTO.getLastUserId());
                object.put("auction",true);
                object.put("chKey",chKey);
                object.put("auctionId",carAcutionDTO.getId());

                if(acUser!=null){
                    AcBidRecordExample example = new AcBidRecordExample();
                    AcBidRecordExample.Criteria criteria = example.createCriteria();
                    criteria.andUserIdEqualTo(acUser.getId()).andAuctionIdEqualTo(carAcutionDTO.getId());
                    long l = acBidRecordMapper.countByExample(example);
                    if(l>0){
                        object.put("ismyplus",true);
                    }else{
                        object.put("ismyplus",false);
                    }

                    AcCarLikeExample ex = new AcCarLikeExample();
                    AcCarLikeExample.Criteria cr = ex.createCriteria();
                    cr.andCarIdEqualTo(carId);
                    List<AcCarLikeKey> acCarLikeKeys = acCarLikeMapper.selectByExample(ex);
                    object.put("likeCount",acCarLikeKeys.size());
                    int ismylike = 0;
                    for (AcCarLikeKey acCarLikeKey : acCarLikeKeys) {
                        if(acCarLikeKey.getUserId()==acUser.getId()){
                            ismylike = 1;
                            break;
                        }
                    }
                    if(ismylike>0){
                        object.put("like",true);
                    }else{
                        object.put("like",false);
                    }

                    //是否开启智能
                    String auto = jedisClient.hget("AUTOPRICE_CAR:" + carAcutionDTO.getId(), String.valueOf(acUser.getId()));
                    if(StringUtils.isNotBlank(auto)&&!StringUtils.equals("over",auto)){
                        object.put("auto",true);
                        object.put("autoPrice",auto);
                    }else{
                        object.put("auto",false);
                    }

                    //出价列表 根据保证金的金额
                    JSONArray list = new JSONArray();
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
                        JSONObject obj = new JSONObject();
                        obj.put("p",ps[i]);
                        if(i >= level){
                            obj.put("c",1);
                        }else{
                            obj.put("c",0);
                        }
                        list.add(obj);
                    }
                    object.put("priceList",list);
                    if(level==0){
                        object.put("isReal",0);
                    }
                }else{
                    object.put("like",false);
                    object.put("ismyplus",false);
                }
                return JsonResult.OK(object);

            }


        }

        //拍卖结束 出价记录最后一条 取车辆起拍价
        AcBidRecordExample example = new AcBidRecordExample();
        AcBidRecordExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("id DESC");
        criteria.andCarIdEqualTo(carId);
        JSONObject object = new JSONObject();
        List<AcBidRecord> acBidRecords = acBidRecordMapper.selectByExample(example);
        long currentTime = TimeUtils.getCurrentTime();
        object.put("overTime",currentTime);
        object.put("nowTime",TimeUtils.getCurrentTime());
        object.put("auction",false);
        if(acBidRecords.size()>0){
            object.put("curPrice",acBidRecords.get(0).getPrice());
            object.put("lastUserId",acBidRecords.get(0).getUserId());
            object.put("ismyplus",true);
        }else{
            CkCarbase ckCarbase = ckCarbaseMapper.selectByPrimaryKey(carId);
            object.put("curPrice",ckCarbase.getSavePrice());
            object.put("lastUserId",0);
            object.put("ismyplus",false);
        }
        AcCarLikeExample ex = new AcCarLikeExample();
        AcCarLikeExample.Criteria cr = ex.createCriteria();
        cr.andCarIdEqualTo(carId);
        List<AcCarLikeKey> acCarLikeKeys = acCarLikeMapper.selectByExample(ex);
        object.put("likeCount",acCarLikeKeys.size());
        if(acUser!=null){
            int ismylike = 0;
            for (AcCarLikeKey acCarLikeKey : acCarLikeKeys) {
                if(acCarLikeKey.getUserId()==acUser.getId()){
                    ismylike = 1;
                    break;
                }
            }
            if(ismylike>0){
                object.put("like",true);
            }else{
                object.put("like",false);
            }
        }
        return JsonResult.OK(object);



    }



    /**
     * 出价记录 发送队列
     * @param acBidRecord
     */
    private void addSocketQueue(AcBidRecord acBidRecord) {
        byte[] redisKey = "Socket".getBytes();
        jedisClient.lpush(redisKey, ObjectUtil.serializer(acBidRecord));
    }
    /**
     * 通过token获取用户信息
     * @param token
     * @return
     */
    public AcUser getAcUserByToken(String token){
        String ac_user_token = jedisClient.hget("AC_USER_TOKEN", token);
        if(StringUtils.isBlank(ac_user_token))return null;
        return JsonUtils.jsonToPojo(ac_user_token,AcUser.class);
    }
    /**
     * carInfo
     * @param carId
     * @return
     */
    private CarInfoDto getCarInfoDto(long carId){

        CarInfoDto dto = new CarInfoDto();

        dto.setCarId(carId);
        CkCarbase ckCarbase = ckCarbaseMapper.selectByPrimaryKey(carId);

        dto.setModelName(ckCarbase.getModelName());

        CkOtherExample ex1 = new CkOtherExample();
        CkOtherExample.Criteria cr1 = ex1.createCriteria();
        cr1.andCarIdEqualTo(carId);
        List<CkOther> ckOthers = ckOtherMapper.selectByExample(ex1);
        if (ckOthers.size() > 0) {
            Integer pfbz = ckOthers.get(0).getPfbz();
            if (pfbz == 1) {
                dto.setPfbz("国2及以下");
            } else if (pfbz == 2) {
                dto.setPfbz("国3");
            } else if (pfbz == 3) {
                dto.setPfbz("国4");
            } else if (pfbz == 4) {
                dto.setPfbz("国5");
            } else {
                dto.setPfbz("不详");
            }
            Integer pj = ckOthers.get(0).getPj();
            if (pj == 1) {
                dto.setPj("A");
            } else if (pj == 2) {
                dto.setPj("B");
            } else if (pj == 3) {
                dto.setPj("C");
            } else if (pj == 4) {
                dto.setPj("D");
            }
        }

        CkBaseimgExample ex2 = new CkBaseimgExample();
        CkBaseimgExample.Criteria c2 = ex2.createCriteria();
        c2.andCarIdEqualTo(carId);
        List<CkBaseimg> ckBaseimgs = ckBaseimgMapper.selectByExample(ex2);
        if (ckBaseimgs.size() > 0) {
            dto.setZq45(ckBaseimgs.get(0).getZq45());
        }

        CkDjzExample ex3 = new CkDjzExample();
        CkDjzExample.Criteria c3 = ex3.createCriteria();
        c3.andCarIdEqualTo(carId);
        List<CkDjz> ckDjzs = ckDjzMapper.selectByExample(ex3);
        if(ckDjzs.size()>0){
            dto.setCdrq(ckDjzs.get(0).getCdrq().substring(0,7));
            dto.setZcd(ckDjzs.get(0).getZcd());
        }

        CkXszExample ex4 = new CkXszExample();
        CkXszExample.Criteria c4 = ex4.createCriteria();
        c4.andCarIdEqualTo(carId);
        List<CkXsz> ckXszs = ckXszMapper.selectByExample(ex4);
        if(ckXszs.size()>0){
            dto.setNumber(ckXszs.get(0).getNumber().substring(0,2));
        }

        CkVerifyExample ex5 = new CkVerifyExample();
        CkVerifyExample.Criteria c5 = ex5.createCriteria();
        c5.andCarIdEqualTo(carId);
        List<CkVerify> ckVerifies = ckVerifyMapper.selectByExample(ex5);
        if(ckVerifies.size()>0){
            dto.setBxlc(ckVerifies.get(0).getBxlc());
        }
        return dto;
    }



}
