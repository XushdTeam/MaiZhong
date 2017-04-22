package com.maizhong.reckon.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.reckon.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-19
 * Time: 15:08
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 获取验证码
     * @param phone
     * @param request
     * @return
     */
    @RequestMapping(value = "/getSMSCode/{phone}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getSMSCode(@PathVariable("phone") String phone, HttpServletRequest request) {
        JsonResult result = loginService.getSMSCode(phone, request);
        return result;
    }

    /**
     * 用户登录
     *
     * @param phone
     * @param smsCode
     * @return
     */
    @RequestMapping(value = "/userLogin/{phone}/{smsCode}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult userLogin(@PathVariable("phone") String phone, @PathVariable("smsCode") String smsCode, HttpServletRequest request) {
        JsonResult result = loginService.userLogin(phone, smsCode, request);
        return result;
    }

    /**
     * 使用phone和Token判断是否登录
     *
     * @param phone
     * @param token
     * @return
     */
    @RequestMapping(value = "/loginByToken/{phone}/{token}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult loginByToken(@PathVariable("phone") String phone, @PathVariable("token") String token) {
        JsonResult result = loginService.loginByToken(phone, token);
        return result;
    }
}
