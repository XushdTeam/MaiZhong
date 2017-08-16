package com.maizhong.youpin.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.youpin.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Xushd on 2017/8/16.
 */
@RestController
public class APPController extends BaseController {

    @Autowired
    private AppService appService;


    /**
     * 根据deviceId 获取token
     * @param deviceId
     * @return
     */
    @RequestMapping(value = "/app/token/{deviceId}")
    public JsonResult getToken(@PathVariable String deviceId){
        return appService.getTokenByDeviceId(deviceId);
    }

    /**
     * 获取新闻
     * @return
     */
    @RequestMapping(value = "/app/news/{pageIndex}")
    public JsonResult getNewsListTop(@PathVariable int pageIndex){
        return appService.getNewsList(pageIndex);
    }

    /**
     * 获取帮助中心列表
     * @return
     */
    @RequestMapping(value = "/app/help/list")
    public JsonResult getHelp(){
        return appService.getHelpList();
    }



}
