package com.maizhong.auction.controller;

import com.maizhong.auction.service.AcutionService;
import com.maizhong.auction.service.ChannelService;
import com.maizhong.common.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Xushd on 2017/6/26.
 */
@Controller
public class IndexController {


    @Autowired
    private ChannelService channelService;

    @Autowired
    private AcutionService acutionService;

    @RequestMapping(value = "/")
    public String index(){
      return "index";
    }



    @RequestMapping(value = "/getCar/list")
    @ResponseBody
    public JsonResult getNowCarAuction(){

        JsonResult result = acutionService.getCarNow();
        return result;

    }
    @RequestMapping(value = "/addPrice/{ch}/{carId}")
    @ResponseBody
    public JsonResult addPrice(@PathVariable String ch,
                               @PathVariable long carId,
                               long plus,
                               long price){
        JsonResult result = acutionService.addPrice(ch,carId,plus,price);
        return result;
    }
}
