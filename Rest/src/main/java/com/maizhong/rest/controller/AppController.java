package com.maizhong.rest.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.rest.service.AppService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: APP端接口
 * User: 王存浩
 * Date: 2017-04-18
 * Time: 9:55
 */

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AppService appService;

    /**
     * 根据设备Id获取token
     *
     * @param deviceId
     * @return
     */
    @RequestMapping(value = "/getTokenByDeviceId", method = RequestMethod.POST)
    public JsonResult getTokenByDeviceId(String deviceId) {

        if (StringUtils.isBlank(deviceId)) return JsonResult.Error("设备编号不能为空");

        JsonResult result = null;
        try {
            result = appService.getTokenByDeciceId(deviceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 测试Token
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/testGetToken")
    public JsonResult testGetToken(HttpServletRequest request) {
        JsonResult result = appService.testGetToken(request);
        return result;

    }

    /**
     * 广告获取
     *
     * @return
     */
    @RequestMapping(value = "/getTopPic")
    public JsonResult getAdvert() {
        JsonResult result = appService.getAdvert();
        return result;
    }

    /**
     * 获取省份
     *
     * @return
     */
    @RequestMapping(value = "/getProvince")
    public JsonResult getProvince() {
        JsonResult result = appService.getProvince();
        return result;
    }

    /**
     * 获取城市
     *
     * @return
     */
    @RequestMapping(value = "/getCity")
    public JsonResult getCity() {
        JsonResult result = appService.getCity();
        return result;
    }

    /**
     * 获取地铁线路
     *
     * @return
     */
    @RequestMapping(value = "/getLine")
    public JsonResult getLine() {
        JsonResult result = appService.getLine();
        return result;
    }

    /**
     * 获取地铁站点
     *
     * @return
     */
    @RequestMapping(value = "/getLineSite")
    public JsonResult getLineSite() {
        JsonResult result = appService.getLineSite();
        return result;
    }

    /**
     * 获取品牌
     *
     * @return
     */
    @RequestMapping(value = "/getBrand")
    public JsonResult getBrand() {
        JsonResult result = appService.getBrand();
        return result;
    }
}
