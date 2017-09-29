package com.maizhong.youpin.service.impl;

import com.maizhong.common.utils.JsonUtils;
import com.maizhong.youpin.dao.JedisClient;
import com.maizhong.youpin.pojo.ManagerUser;
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

    @Value("${CHE300.GUZHI}")
    private String CHE300_GUZHI;

    @Value("${CHE300.TOKEN}")
    private String CHE300_TOKEN;


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

    public String getCHE300_GUZHI() {
        return CHE300_GUZHI;
    }

    public String getCHE300_TOKEN() {
        return CHE300_TOKEN;
    }

    public User getAppUserByToken(String token){
        String userinfo = jedisClient.get("APP_PERSONAL:" + token);
        if(StringUtils.isBlank(userinfo))return null;
        return JsonUtils.jsonToPojo(userinfo,User.class);
    }
    /**
     * 根据token获取用户信息
     *
     * @param token
     * @return
     */
    public ManagerUser getManageUserByToken(String token) {
        String userStr = this.jedisClient.get("YOUPIN_LOGIN:" + token);
        if(StringUtils.isNotBlank(userStr)){
            ManagerUser managerUser = JsonUtils.jsonToPojo(userStr, ManagerUser.class);
            return managerUser;
        }else{
            return null;
        }

    }
}
