package com.maizhong.reckon.service;

import com.maizhong.common.result.JsonResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-19
 * Time: 15:09
 */
public interface LoginService {

    JsonResult userLogin(String phone,String smsCode,HttpServletRequest request);
    JsonResult getSMSCode(String phone, HttpServletRequest request);

    JsonResult loginByToken(String phone, String token);
}
