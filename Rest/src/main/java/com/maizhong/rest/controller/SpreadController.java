package com.maizhong.rest.controller;


import com.maizhong.common.dto.CarShowIndex;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbFeedback;
import com.maizhong.rest.service.SpreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * 推广信息接口
 * Created by Xushd on 2017/3/7.
 */
@RestController
public class SpreadController {

    @Autowired
    private SpreadService spreadService;

    @RequestMapping("/getSpread/{type}")
    public JsonResult getSpread(@PathVariable Integer type) {

        return JsonResult.OK();
    }

    /**
     * 首页分栏数据
     *
     * @param jsoncallback
     * @return JSONP
     */

    @RequestMapping(value = "/getHomeItemContent", method = RequestMethod.GET)
    public Object getHomeItemContent(String jsoncallback) {
        List<CarShowIndex> list = spreadService.getHomeItem();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        mappingJacksonValue.setJsonpFunction(jsoncallback);
        return mappingJacksonValue;

    }

    /**
     * 用户反馈
     *
     * @param content 反馈内容
     * @param phone   手机号
     * @param surname 称谓
     * @return
     */
    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public JsonResult insertFeedback(String content, String phone, String surname) {

        OperateEnum result = spreadService.insertFeedback(phone, content, surname);

        return JsonResult.build(result);
    }


    /**
     * 用户咨询
     *
     * @param phone 手机号
     * @param type  种类  0新车 1 二手车
     * @return
     */
    @RequestMapping(value = "/consult", method = RequestMethod.POST)
    public JsonResult insertConsult(String phone, String type) {
        OperateEnum result = spreadService.insertConsult(phone, type);
        return JsonResult.build(result);
    }

    @RequestMapping(value = "/getSeriesByBrand/{brandId}")
    public JsonResult getSeriesByBrand(@PathVariable("brandId") Long brandId) {
        return spreadService.getSeriesByBrand(brandId);
    }

    @RequestMapping(value = "/getHotSeries")
    public JsonResult getHotSeries() {
        return spreadService.getHotSeries();
    }


    /**
     * 前台首页 初次数据获取
     * @return
     */
    @RequestMapping(value = "/getIndexBase",method = RequestMethod.GET)
    public JsonResult getIndexBase(){
        JsonResult result = spreadService.getIndexBase();
        return result;
    }
}
