package com.maizhong.bRest.service.impl;

import com.maizhong.bRest.service.UserService;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.TbBusinessMapper;
import com.maizhong.mapper.TbBusinessUserMapper;
import com.maizhong.pojo.TbBusiness;
import com.maizhong.pojo.TbBusinessUser;
import com.maizhong.pojo.TbBusinessUserExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by YangF on 2017/3/28.
 */
@Service
public class UserServiceImpl implements UserService {








    @Value("${BUSSINESSUSER_PREFIX}")
    private String BUSSINESSUSER_PREFIX;

    @Value("${BUSSINESSUSER_INFO}")
    private String BUSSINESSUSER_INFO;

    @Value("${BUSINESS_USER_URL}")
    private String BUSINESS_USER_URL;

    @Value("${BASE_URL}")
    private String BASE_URL;

    @Value("${BUSINESS_ISONLINE_URL}")
    private String BUSINESS_ISONLINE_URL;

    @Override
    public JsonResult login(String username, String password) {

        if (StringUtils.isBlank(username)){
            return JsonResult.Error("登陆失败,用户名为空");
        }
        if(StringUtils.isBlank(password)){
            return JsonResult.Error("登陆失败,密码为空");
        }

        HashMap<String, String> param = new HashMap<>();
        param.put("username",username);
        param.put("password",password);
        String resultJson = null;
        try{
            resultJson = HttpClientUtil.doPost(BASE_URL+BUSINESS_USER_URL,param);
            return JsonUtils.jsonToPojo(resultJson,JsonResult.class);
        }catch(Exception e){
            e.printStackTrace();
            return JsonResult.Error("服务器繁忙,请稍后再试");
        }

    }


    @Override
    public JsonResult isOnline(String token) {

        HashMap<String, String> param = new HashMap<>();
        param.put("token",token);
        try {
            String resultJson = HttpClientUtil.doPost(BASE_URL+BUSINESS_ISONLINE_URL, param);
            return JsonUtils.jsonToPojo(resultJson, JsonResult.class);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.Error("服务器繁忙,请稍后再试");
        }
    }

}
