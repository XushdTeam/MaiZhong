package com.maizhong.youpin.service.impl;

import com.maizhong.common.utils.JsonUtils;
import com.maizhong.youpin.dao.JedisClient;
import com.maizhong.youpin.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Xushd on 2017/8/16.
 */
public class BaseService {

    @Value("${APPCODE}")
    private String APPCODE;

    @Value("${API_URL}")
    private String API_URL;


    @Autowired
    private JedisClient jedisClient;


    public JedisClient getJedisClient() {
        return jedisClient;
    }

    public String getAPPCODE() {
        return APPCODE;
    }

    public String getAPI_URL() {
        return API_URL;
    }

    public User getAppUserByToken(String token){
        String userinfo = jedisClient.get("APP_PERSONAL:" + token);
        if(StringUtils.isBlank(userinfo))return null;
        return JsonUtils.jsonToPojo(userinfo,User.class);
    }
}
