package com.maizhong.bRest.service;

import com.maizhong.common.result.JsonResult;

/**
 * Created by Administrator on 2017/3/28.
 */
public interface UserService {

    public JsonResult login(String username,String password);
    public JsonResult isOnline(String token);
}
