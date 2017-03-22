package com.maizhong.portal.controller;

import com.maizhong.common.result.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/15.
 */

@Controller
public class TestController {



    @RequestMapping("/to/{url}")
    public String test(@PathVariable("url") String url){
        return url;
    }

    @RequestMapping("/test")
    @ResponseBody
    public JsonResult test(){

        return JsonResult.OK();
    }
}
