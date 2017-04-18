package com.maizhong.rest.controller;

import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.ReckonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 估值Controller
 * Created by Xushd on 2017/4/18.
 */
@Controller
public class ReckonController {

    @Autowired
    private ReckonService reckonService;

    /**
     * 同步车型库
     *
     * @return
     */
    @RequestMapping(value = "/GetBrandData")
    @ResponseBody
    public JsonResult GetBrandData() {
        reckonService.getBrandData();
        return JsonResult.OK();
    }

    /**
     * 同步车系库
     *
     * @return
     */
    @RequestMapping(value = "/GetSeriesData")
    @ResponseBody
    public JsonResult GetSeriesData() {
        reckonService.getSeriesData();
        return JsonResult.OK();
    }

    /**
     * 同步品牌首字母分组
     * @return
     */
    @RequestMapping(value = "/SysBrandGroup",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult brandGroupByInitial(){
        JsonResult result = null;
        try {
            result = reckonService.sysBrandGroupByInitial();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 按照首字母获取品牌信息
     *
     * @return
     */
    @RequestMapping(value = "/GetBrandList")
    @ResponseBody
    public JsonResult getBrandList() {
        JsonResult result = null;
        try {
            result = reckonService.getBrandList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据品牌Id获取车系
     *
     * @return
     */
    @RequestMapping(value = "/GetSeriesByBrandId/{brandId}",method =RequestMethod.GET)
    @ResponseBody
    public JsonResult getSeriesByBrandId(@PathVariable("brandId") String brandId) {
        if (StringUtils.isBlank(brandId)){
            return JsonResult.Error("品牌Id不能为空");
        }
        JsonResult result = null;
        try {
            result = reckonService.getSeriesByBrandId(brandId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 获取所有省份
     *
     * @return
     */
    @RequestMapping(value = "/getProvice",method =RequestMethod.GET)
    @ResponseBody
    public JsonResult GetProvince() {

        JsonResult result = null;
        try {
            result = reckonService.getProvince();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 获取所有省份
     *
     * @return
     */
    @RequestMapping(value = "/getCity/proviceId",method =RequestMethod.GET)
    @ResponseBody
    public JsonResult getCity(@PathVariable("proviceId") String proviceId) {

        JsonResult result = null;
        try {
            result = reckonService.getCity(proviceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }




}
