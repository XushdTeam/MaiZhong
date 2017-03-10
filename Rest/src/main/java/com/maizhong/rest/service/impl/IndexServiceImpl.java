package com.maizhong.rest.service.impl;

import com.maizhong.common.enums.AuthEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.IndexService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xushd on 2017/3/3.
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Value("${ACCOUNT}")
    private String ACCOUNT;

    @Value("${PASSWORD}")
    private String PASSWORD;

    @Override
    public JsonResult login(String username, String password) {
        if(!StringUtils.equals(ACCOUNT,username)){
            return JsonResult.build(AuthEnum.USER_NO_EXIT);
        }else if(!StringUtils.equals(PASSWORD,password)){
            return JsonResult.build(AuthEnum.USER_ERROR_PASSWORD);
        }else{
            Map<String,Object> user = new HashMap();
            user.put("username",ACCOUNT);
            user.put("password",PASSWORD);
            return JsonResult.OK(user);
        }
    }

    @Override
    public JsonResult getBaseInfo() {
        Map<String,Object> baseInfo = new HashMap<>();
        baseInfo.put("interfaceCount",0);
        baseInfo.put("version","1.0.0");
        return JsonResult.OK(baseInfo);
    }
}
