package com.maizhong.rest.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.SpreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 推广信息接口
 * Created by Xushd on 2017/3/7.
 */
@RestController
public class SpreadController {

    @Autowired
    private SpreadService spreadService;

    @RequestMapping("/getSpread/{type}")
    public JsonResult getSpread(@PathVariable Integer type){

        return JsonResult.OK();
    }

    /**
     * 获取首页品显示品牌前十个
     */
    @RequestMapping(value="/getIndexBrand")
    public JsonResult getIndexBrand() {
        JsonResult result=spreadService.getIndexBrand();
        return result;
    }

    /**
     * 获取汽车类型
     */
    @RequestMapping(value="/getIndexCarType")
    public JsonResult getIndexCarType() {
        JsonResult result=spreadService.getIndexCarType();
        return result;
    }

    /**
     * 广告获取接口，根据广告类型
     */
    @RequestMapping(value = "/getAdvert/{type}")
    public JsonResult getAdvertByType(@PathVariable("type") Integer type) {
        JsonResult result=spreadService.getAdvertByType(type);
        return result;
    }

}
