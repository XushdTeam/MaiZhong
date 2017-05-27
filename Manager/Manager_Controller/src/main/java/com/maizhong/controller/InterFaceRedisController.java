package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.service.InterFaceRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Xushd on 2017/5/25.
 */
@Controller
public class InterFaceRedisController {


    @Autowired
    private InterFaceRedisService faceRedisService;

    @RequestMapping(value = "/interface/redis/provice")
    public String provice(Model model){

        model.addAttribute("baseUrl","/interface/redis/provice");
        model.addAttribute("listUrl","/interface/redis/provice/list");
        model.addAttribute("redisUrl","/interface/redis/provice/redis");
        model.addAttribute("syncOSS","/interface/redis/provice/syncOSS");
        return "redis/provice_list";
    }

    @RequestMapping(value = "/interface/redis/provice/list")
    @ResponseBody
    public JsonResult proviceList(PageSearchParam param){

        JsonResult result = faceRedisService.selectProvice(param);
        return result;
    }

    @RequestMapping(value = "/interface/redis/provice/redis")
    @ResponseBody
    public JsonResult proviceReids(){
        JsonResult result = faceRedisService.proviceRedis();
        return result;
    }

    @RequestMapping(value = "/interface/redis/provice/syncOSS")
    @ResponseBody
    public JsonResult proviceSyncOSS(){
        JsonResult  result = faceRedisService.proviceSyncOSS();
        return result;
    }

    /*********************************************************/
    @RequestMapping(value = "/interface/redis/city")
    public String city(Model model){

        model.addAttribute("baseUrl","/interface/redis/city");
        model.addAttribute("listUrl","/interface/redis/city/list");
        model.addAttribute("redisUrl","/interface/redis/city/redis");
        model.addAttribute("interUrl","/interface/redis/city/syncInter");
        model.addAttribute("syncOSS","/interface/redis/city/syncOSS");
        return "redis/city_list";
    }

    @RequestMapping(value = "/interface/redis/city/list")
    @ResponseBody
    public JsonResult cityList(PageSearchParam param){

        JsonResult result = faceRedisService.selectCity(param);
        return result;
    }

    @RequestMapping(value = "/interface/redis/city/redis")
    @ResponseBody
    public JsonResult cityReids(){
        JsonResult result = faceRedisService.cityRedis();
        return result;
    }

    @RequestMapping(value = "/interface/redis/city/syncInter")
    @ResponseBody
    public JsonResult citySyncInter(){
        JsonResult result = faceRedisService.syncInter();
        return result;
    }

    @RequestMapping(value = "/interface/redis/city/syncOSS")
    @ResponseBody
    public JsonResult citySyncOSS(){
        JsonResult result = faceRedisService.citySyncOSS();
        return result;
    }
    /*********************************************************/
    @RequestMapping(value = "/interface/redis/brand")
    public String brand(Model model){

        model.addAttribute("baseUrl","/interface/redis/brand");
        model.addAttribute("listUrl","/interface/redis/brand/list");
        model.addAttribute("redisUrl","/interface/redis/brand/redis");
        model.addAttribute("interUrl","/interface/redis/brand/syncInter");
        model.addAttribute("syncOSS","/interface/redis/brand/syncOSS");
        model.addAttribute("cancleUrl","/interface/redis/brand/cancle");
        model.addAttribute("hotUrl","/interface/redis/brand/hot");
        return "redis/brand_list";
    }

    @RequestMapping(value = "/interface/redis/brand/list")
    @ResponseBody
    public JsonResult brandList(PageSearchParam param){

        JsonResult result = faceRedisService.selectBrand(param);
        return result;
    }

    @RequestMapping(value = "/interface/redis/brand/cancle/{brandId}")
    @ResponseBody
    public JsonResult brandCancle(@PathVariable long brandId){

        JsonResult result = faceRedisService.brandHotChange(brandId,0);
        return result;
    }

    @RequestMapping(value = "/interface/redis/brand/hot/{brandId}")
    @ResponseBody
    public JsonResult brandHot(@PathVariable long brandId){

        JsonResult result = faceRedisService.brandHotChange(brandId,1);
        return result;
    }

    @RequestMapping(value = "/interface/redis/brand/redis")
    @ResponseBody
    public JsonResult brandRedis(){
        JsonResult result = faceRedisService.brandRedis();
        return result;
    }

    @RequestMapping(value = "/interface/redis/brand/syncInter")
    @ResponseBody
    public JsonResult brandSyncInter(){
        JsonResult result = faceRedisService.brandSyncInter();
        return result;
    }

    @RequestMapping(value = "/interface/redis/brand/syncOSS")
    @ResponseBody
    public JsonResult brandSyncOSS(){
        JsonResult result = faceRedisService.brandSyncOSS();
        return result;
    }
    /*********************************************************/
    @RequestMapping(value = "/interface/redis/series")
    public String series(Model model){

        model.addAttribute("baseUrl","/interface/redis/series");
        model.addAttribute("listUrl","/interface/redis/series/list");
        model.addAttribute("redisUrl","/interface/redis/series/redis");
        model.addAttribute("interUrl","/interface/redis/series/syncInter");
        return "redis/series_list";
    }


    @RequestMapping(value = "/interface/redis/series/list")
    @ResponseBody
    public JsonResult seriesList(PageSearchParam param){

        JsonResult result = faceRedisService.seriesList(param);
        return result;
    }
    @RequestMapping(value = "/interface/redis/series/syncInter")
    @ResponseBody
    public JsonResult seriesSyncInter(){
        JsonResult result = faceRedisService.seriesSyncInter();
        return result;
    }

}
