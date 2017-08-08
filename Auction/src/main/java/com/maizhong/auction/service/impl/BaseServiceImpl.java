package com.maizhong.auction.service.impl;

import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.pojo.PsUser;
import com.maizhong.common.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Xushd on 2017/8/1.
 */
public class BaseServiceImpl {

    @Autowired
    private JedisClient jedisClient;

    protected JedisClient getJedisClient() {
        return jedisClient;
    }

    /**
     * 获取车主APP用户信息
     * @param token
     * @return
     */
    protected PsUser getPersonalUserByToken(String token){
        String app_personal = jedisClient.hget("APP_PERSONAL", token);
        if(StringUtils.isNotBlank(app_personal)){
            return JsonUtils.jsonToPojo(app_personal,PsUser.class);
        }
        return null;
    }
}
