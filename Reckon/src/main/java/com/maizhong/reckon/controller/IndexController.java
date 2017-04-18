package com.maizhong.reckon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Xushd on 2017/4/18.
 */
@Controller
public class IndexController {


    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }
}
