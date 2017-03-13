package com.maizhong.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商城首页
 * Created by Xushd on 2017/3/3.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }





}
