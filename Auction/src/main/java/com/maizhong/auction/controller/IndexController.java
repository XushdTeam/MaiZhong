package com.maizhong.auction.controller;

import com.alibaba.fastjson.JSONObject;
import com.maizhong.auction.service.AuctionService;
import com.maizhong.common.result.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Xushd on 2017/6/7.
 */
@Controller
public class IndexController {


    @Autowired
    private AuctionService auctionService;

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/num")
    public String num(){
        return "num";
    }
    @RequestMapping(value = "/indexTimer")
    public String indexTimer(){
        return "indexTimer";
    }
    @RequestMapping(value = "/now")
    public JsonResult now(){
        Date date = new Date();
        return JsonResult.OK(date);
    }

    @RequestMapping(value = "/ch/{num}")
    public String ch(@PathVariable String num, Model model){

        model.addAttribute("num",num);

        return "ch";
    }

    @RequestMapping(value = "/add/{ch}/{price}")
    @ResponseBody
    public JsonResult addprice(@PathVariable String ch,@PathVariable Long price){
        JsonResult result = auctionService.addprice(ch,price);
        return result;

    }

    @RequestMapping(value = "/plushlet")
    public String plushlet(){
        return "plushlet";
    }






}
