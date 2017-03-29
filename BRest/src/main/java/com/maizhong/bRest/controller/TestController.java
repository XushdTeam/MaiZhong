package com.maizhong.bRest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/3/28.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/testGet",method = RequestMethod.GET)
    @ResponseBody
    public String test(String param){
        return param;
    }


    @RequestMapping(value = "/testPost",method = RequestMethod.POST)
    @ResponseBody
    public String testPost(String param){
        return param;
    }


    @RequestMapping("/12345")
    @ResponseBody
    public String xsaaxsa(){
        return "dsadsad";
    }


}
