package com.maizhong.auction.controller;

import com.maizhong.auction.service.CheckService;
import com.maizhong.common.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Xushd on 2017/6/14.
 */
@RestController
public class CheckController {

    @Autowired
    private CheckService checkService;

    @RequestMapping(value = "/app/check/login",method = RequestMethod.POST)
    public JsonResult checkLogin(String account,String pass){
        JsonResult result = checkService.checkLogin(account,pass);
        return result;
    }

}
