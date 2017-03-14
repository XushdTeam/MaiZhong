package com.maizhong.rest.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbAdvertPublish;
import com.maizhong.rest.service.AdvertPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-13
 * Time: 15:03
 */

@RestController
public class AdvertController {


    @Autowired
    private AdvertPublishService advertPublishService;

    /**
     * 广告获取接口，根据广告类型
     */
    @RequestMapping(value = "/getAdvert/{type}")
    public JsonResult getAdvertByType(@PathVariable("type") Integer type) {
        JsonResult result=advertPublishService.getAdvertByType(type);
        return result;
    }


}
