package com.maizhong.reckon.controller;

import com.maizhong.reckon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-17
 * Time: 13:30
 */

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/doTest",method = RequestMethod.GET)
    public String testReckon() {
        String result = testService.testService("这是测试");
        System.out.println(result);
        return "index";
    }
}
