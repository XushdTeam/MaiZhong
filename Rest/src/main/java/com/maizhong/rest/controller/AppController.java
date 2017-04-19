package com.maizhong.rest.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.AppService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: APP端接口
 * User: 王存浩
 * Date: 2017-04-18
 * Time: 9:55
 */

@Controller
public class AppController {

    @Autowired
    private AppService appService;

    /**
     * 根据设备Id获取token
     * @param deviceId
     * @return
     */
    @RequestMapping(value = "/app/getTokenByDeviceId", method = RequestMethod.POST)
    @ResponseBody
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


}
