package com.maizhong.rest.service.impl;

import com.maizhong.common.enums.AuthEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.IndexService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Xushd on 2017/3/3.
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Value("${USER}")
    private String USERNAME;

    @Value("${PASSWORD}")
    private String PASSWORD;

    @Override
    public JsonResult login(String username, String password) {
        if(!StringUtils.equals(USERNAME,username)){
            return JsonResult.build(AuthEnum.USER_NO_EXIT);
        }else if(!StringUtils.equals(PASSWORD,password)){
            return JsonResult.build(AuthEnum.USER_ERROR_PASSWORD);
        }else{
            return JsonResult.build(200,AuthEnum.SUCCESS.getStateInfo(),"/rest/index/interface");
        }
    }
}
