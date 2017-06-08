package com.maizhong.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Xushd on 2017/6/7.
 */
@Controller
public class IndexController {


    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

}
