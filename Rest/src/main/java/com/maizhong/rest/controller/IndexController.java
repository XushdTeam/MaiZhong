package com.maizhong.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 * Created by Xushd on 2017/3/3.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String Index(){
        return "index";
    }
}

