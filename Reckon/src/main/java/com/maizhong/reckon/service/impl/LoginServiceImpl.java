package com.maizhong.reckon.service.impl;

import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.reckon.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-19
 * Time: 15:09
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Value("${REST_URL}")
    private String RESTURL;


    /**
     * 获取验证码
     * @param phone
     * @param request
     * @return
     */
    @Override
    public JsonResult getSMSCode(String phone, HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        try {
            Map<String,String> map=new HashMap<>();
            map.put("ip",ip);
            map.put("phone",phone);
            String res= HttpClientUtil.doPost(RESTURL + "getSMSCode/",map);
            return JsonUtils.jsonToPojo(res, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.Error("网络异常，请刷新后重试");
    }

    /**
     * 判断用户是否登成功
     * @param phone
     * @param token
     * @return
     */
    @Override
    public JsonResult userIsLogin(String phone, String token) {

        try {

            String res = HttpClientUtil.doGet(RESTURL+"");
            return JsonUtils.jsonToPojo(res,JsonResult.class);

        }catch (Exception e){
            e.printStackTrace();
        }

        return JsonResult.Error(OperateEnum.SERVER_ERROR);
    }

    /**
     * 用户登录
     * @return
     */

    @Override
    public JsonResult userLogin(String phone, String smsCode,HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        try {
            Map<String,String> map=new HashMap<>();
            map.put("smsCode",smsCode);
            map.put("phone",phone);
            map.put("ip",ip);
            String res = HttpClientUtil.doPost(RESTURL + "userLogin/",map);
//            System.out.println(res);
            if (StringUtils.isBlank(res)){
                return JsonResult.Error("网络异常，请刷新后重试");
            }
            return JsonUtils.jsonToPojo(res, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.Error("网络异常，请刷新后重试");
    }

}
