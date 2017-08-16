package com.maizhong.youpin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-08-16
 * Time: 11:50
 */

@Controller
public class TestController {


    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){

        return "index";
    }

}
