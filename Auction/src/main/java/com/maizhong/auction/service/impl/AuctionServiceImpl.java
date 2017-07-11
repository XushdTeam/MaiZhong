package com.maizhong.auction.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.CarInfoDto;
import com.maizhong.auction.mapper.*;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.AuctionService;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Xushd on 2017/7/10.
 */
@Service
public class AuctionServiceImpl implements AuctionService {


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
    private JedisClient jedisClient;


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

        List<AcTopcar> acTopcars = acTopcarMapper.selectByExample(new AcTopcarExample());
        List<CarInfoDto> list = new ArrayList<>();
        for (AcTopcar acTopcar : acTopcars) {
            long carId = acTopcar.getCarId();
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
            list.add(dto);

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
        if(i>0)return JsonResult.OK();


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
            return JsonResult.OK();
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
        jedisClient.hset("AC_USER_TOKEN",token,JsonUtils.objectToJson(acUser));
        return JsonResult.OK(acUser);

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
