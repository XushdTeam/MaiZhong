package com.maizhong.auction.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Xushd on 2017/8/1.
 */
public class BaseController {

    protected String getToken(HttpServletRequest request){
        return (String) request.getAttribute("token");
    }
}
