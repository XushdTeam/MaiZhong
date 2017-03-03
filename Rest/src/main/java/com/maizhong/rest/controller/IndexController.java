package com.maizhong.rest.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 首页控制器
 * Created by Xushd on 2017/3/3.
 */
@Controller
public class IndexController {


    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/")
    public String index(){
        return "login";
    }



    @RequestMapping(value = "/index/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(String username, String password){
        JsonResult result = indexService.login(username,password);
        return result;
    }

    @RequestMapping(value = "/index/interface",method = RequestMethod.GET)
    public String interfacePage(){
        return "interface";
    }

}

