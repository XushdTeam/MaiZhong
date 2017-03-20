package com.maizhong.rest.controller;


import com.maizhong.common.dto.CarShowIndex;
import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.SpreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 首页汽车栏目获取列表，根据栏目Id (作废)
     */
    @RequestMapping(value="/getCarColumnById/{columnId}/{number}")
    public JsonResult getCarColumnById(@PathVariable("columnId") Integer columnId,@PathVariable("number") Integer number){
    JsonResult result=spreadService.getCarColumnById(columnId,number);
        return  result;
    }

    /**
     * 首页分栏数据
     * @param jsoncallback
     * @return JSONP
     */

    @RequestMapping(value = "/getHomeItemContent",method = RequestMethod.GET)
    public Object getHomeItemContent(String jsoncallback){
        List<CarShowIndex> list = spreadService.getHomeItem();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        mappingJacksonValue.setJsonpFunction(jsoncallback);
        return mappingJacksonValue;

    }


}
