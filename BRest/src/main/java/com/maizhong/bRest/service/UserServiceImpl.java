package com.maizhong.bRest.service;

import com.maizhong.common.result.JsonResult;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

/**
 * Created by YangF on 2017/3/28.
 */
public class UserServiceImpl implements UserService {


    @Value("${BUSSINESSUSER_PREFIX}")
    private String BUSSINESSUSER_PREFIX;

    @Override
    public JsonResult login(String username, String password) {



        return null;
    }

    @Override
    public JsonResult isOnline(String token) {
        String key = BUSSINESSUSER_PREFIX+ UUID.randomUUID().toString().replaceAll("-","");
        System.out.println();
        return null;
    }
}
