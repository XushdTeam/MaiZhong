package com.maizhong.youpin.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Xushd on 2017/8/16.
 */
public class BaseController {


    /**
     * 获取token
     * @param request
     * @return
     */
    protected String getToken(HttpServletRequest request){
        return (String) request.getAttribute("token");
    }
}
