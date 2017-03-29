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





    @Resource
    private JedisClient jedisClient;


    @Value("${BUSSINESSUSER_PREFIX}")
    private String BUSSINESSUSER_PREFIX;

    @Value("${BUSSINESSUSER_INFO}")
    private String BUSSINESSUSER_INFO;

    @Value("${BUSINESS_USER_URL}")
    private String BUSINESS_USER_URL;


    @Override
    public JsonResult login(String username, String password) {

        if (StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            return JsonResult.Error("登陆失败,请输入完整的用户名以及密码");
        }


        HashMap<String, String> param = new HashMap<>();
        param.put("username",username);
        param.put("password",password);
        String resultJson = null;
        try{
            resultJson = HttpClientUtil.doPost(BUSINESS_USER_URL,param);
        }catch(Exception e){
            e.printStackTrace();
            return JsonResult.Error("服务器繁忙,请稍后再试");
        }


        if (StringUtils.isNotBlank(resultJson)){
            JsonResult result = JsonUtils.jsonToPojo(resultJson, JsonResult.class);
            if (result.getStatus()==200){
                Map<String,Object> map = (Map<String, Object>) result.getData();

                if (map!=null&&map.size()>0){
                    //生成Token
                    String token = UUID.randomUUID().toString().replace("-","");

                    //redis 模拟缓存 添加到缓存命中
                    String jsonInfo = JsonUtils.objectToJson(map);

                    if (StringUtils.isNotBlank(jsonInfo)) {
                        jedisClient.hset(BUSSINESSUSER_PREFIX + token, BUSSINESSUSER_INFO, jsonInfo);
                        jedisClient.expire(BUSSINESSUSER_PREFIX + token, 3600);
                    }

                    Map<String,Object> realResult = new HashMap<>();

                    realResult.put("token",token);
                    realResult.put("userInfo",map);

                    return JsonResult.OK(realResult);
                }
            }else{
                return result;
            }
        }
        return JsonResult.Error("登录失败，用户名或者密码错误");
    }

    @Override
    public JsonResult isOnline(String token) {
        if (StringUtils.isNotBlank(token)){
            String json = jedisClient.hget(BUSSINESSUSER_PREFIX + token, BUSSINESSUSER_INFO);
            if (StringUtils.isNotBlank(json)){
                jedisClient.expire(BUSSINESSUSER_PREFIX + token,60);
                Map<String,Object> map = JsonUtils.jsonToPojo(json, Map.class);
                if (map!=null){

                    Map<Object, Object> result = new HashMap<>();
                    result.put("userInfo",map);

                    return JsonResult.OK(result);
                }
            }
        }
        return JsonResult.Error("未登录");
    }
}
