package com.maizhong.rest.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.QczjSqlService;

import com.maizhong.rest.service.QczjhttpService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by YangF on 2017/4/7.
 */
@RestController
@RequestMapping("/qczj")
public class QczjController {

    @Resource
    private QczjSqlService qczjSqlService;

    @Resource
    private QczjhttpService qczjhttpService;

    /**
     * 数据同步方法
     *      用于同步数据
     *
     *
     *         慎用！！！
     * @return
     */
    @RequestMapping("/syncSql")
    public JsonResult sqlSync(){
        return qczjSqlService.getSeries4Brand();
    }


    @RequestMapping("/getCarBuyDateAndmileage/{carId}")
    public JsonResult getCarBuyDateAndmileage(@PathVariable Long carId){
        return qczjSqlService.getCarBuyDateAndmileage(carId);
    }

    @RequestMapping("/getCarBrand")
    public JsonResult getCarBrand(){
        return qczjSqlService.getBrandBySql();
    }


    @RequestMapping("/getCarSeries/{brandId}")
    public JsonResult getCarSeries(@PathVariable Long brandId){
        return qczjSqlService.getSeriesByBrandId(brandId);
    }

    @RequestMapping("/getCarType/{seriesId}")
    public JsonResult getCarType(@PathVariable Long seriesId){
        return qczjSqlService.getCarBySeriesId(seriesId);
    }


    /***
     *  验证主方法
     *      用途  返回通过http根据specId查询的汽车最低价格与最高价格
     * @param bid
     * @param sid
     * @param specId
     * @param registerYear
     * @param registerMonth
     * @param selectCarName
     * @return
     */
    @RequestMapping("/assess")
    public JsonResult assess(String bid, String sid, String specId,String registerYear, String registerMonth,String selectCarName){
        return qczjhttpService.calculatePrice(bid,sid,specId,registerYear,registerMonth,selectCarName);
    }

}
