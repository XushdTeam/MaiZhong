package com.maizhong.auction.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.mapper.AcFreezeMapper;
import com.maizhong.auction.mapper.AcOrderMapper;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.PersonalService;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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



    public AcUser getUserInfoByToken(String token){

        String ac_user_token = jedisClient.hget("AC_USER_TOKEN", token);
        if(StringUtils.isNotBlank(ac_user_token)){
            return JsonUtils.jsonToPojo(ac_user_token,AcUser.class);
        }
        return null;

    }



}
