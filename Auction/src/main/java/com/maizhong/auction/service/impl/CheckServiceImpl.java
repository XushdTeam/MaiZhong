package com.maizhong.auction.service.impl;

import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.mapper.CkUserMapper;
import com.maizhong.auction.pojo.CkUser;
import com.maizhong.auction.pojo.CkUserExample;
import com.maizhong.auction.service.CheckService;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.IDUtils;
import com.maizhong.common.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xushd on 2017/6/14.
 */
@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CkUserMapper ckUserMapper;
    @Autowired
    private JedisClient jedisClient;

    @Override
    public JsonResult checkLogin(String account, String pass) {

        if(StringUtils.isBlank(account)){
            return JsonResult.Error("帐号为空");
        }
        if(StringUtils.isBlank(pass)){
            return JsonResult.Error("密码为空");
        }
        CkUserExample example = new CkUserExample();
        CkUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserPhoneEqualTo(Long.valueOf(account));
        List<CkUser> ckUsers = ckUserMapper.selectByExample(example);
        if(ckUsers.size()==0){
            return JsonResult.Error("用户不存在");
        } else {
            CkUser ckUser = ckUsers.get(0);
            if(!StringUtils.equals(pass,ckUser.getPassword())){
                return JsonResult.Error("密码错误");
            }else{
                //判断用户以前是否登陆过
                String redisToken = jedisClient.hget("CHECK_ACCOUNT_TOKEN",account);
                if(StringUtils.isBlank(redisToken)){
                    redisToken = IDUtils.getUUID();
                }
                ckUser.setPassword(null);
                return JsonResult.build(200,redisToken,JsonUtils.objectToJson(ckUser));
            }
        }
    }
}
