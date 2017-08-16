package com.maizhong.youpin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Xushd on 2017/8/16.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    private String index(){
        return "index";
    }
}
