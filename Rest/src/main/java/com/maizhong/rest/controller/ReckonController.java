package com.maizhong.rest.controller;

import com.alibaba.fastjson.JSON;
import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.ReckonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

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
     * 缓存城市keyvalue
     *
     * @return
     */
    @RequestMapping(value = "/setRedisCity")
    @ResponseBody
    public JsonResult setRedisCity() {
        reckonService.setRedisCity();
        return JsonResult.OK();

    }


    /**
     * 同步品牌首字母分组
     *
     * @return
     */
    @RequestMapping(value = "/SysBrandGroup", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult brandGroupByInitial() {
        JsonResult result = reckonService.sysBrandGroupByInitial();
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
        JsonResult result = reckonService.getBrandList();
        return result;
    }

    /**
     * 根据品牌Id获取车系
     *
     * @return
     */
    @RequestMapping(value = "/GetSeriesByBrandId/{brandId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getSeriesByBrandId(@PathVariable("brandId") String brandId) {
        if (StringUtils.isBlank(brandId)) {
            return JsonResult.OK();
        }
        JsonResult result = reckonService.getSeriesByBrandId(brandId);

        return result;
    }


    /**
     * 获取所有省份
     *
     * @return
     */
    @RequestMapping(value = "/getProvice", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult GetProvince() {

        JsonResult result = reckonService.getProvince();
        return result;
    }

    /**
     * 获取所有省份
     *
     * @return
     */
    @RequestMapping(value = "/getCity", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getCity() {

        JsonResult result = reckonService.getCity();

        return result;
    }


    /**
     * 通过车系ID获取车型信息
     *
     * @param seriesId
     * @return
     */
    @RequestMapping(value = "/getCarType/{seriesId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getCarType(@PathVariable String seriesId) {

        JsonResult result = reckonService.getCarType(seriesId);

        return result;
    }

    /**
     * 获取用户验证码
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "getSMSCode", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getSMSCode(String phone, String ip) {
        JsonResult result = reckonService.getSMSCode(phone, ip);
        return result;
    }

    /**
     * 用户使用验证码进行登录
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "userLogin", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userLogin(String phone, String smsCode, String ip) {
        JsonResult result = reckonService.userLogin(smsCode, phone, ip);
        return result;
    }

    /**
     * 估值
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/guzhi/{param:.+}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getGuzhi(@PathVariable String param) {

        JsonResult result = reckonService.getGuzhi(param);
        return result;
    }

    /**
     * 获取精准估值结果
     *
     * @param guzhiKey
     * @param otherKey
     * @return
     */
    @RequestMapping(value = "/getSaleGZ/{guzhiKey:.+}/{otherKey}/{phone}")
    @ResponseBody
    public JsonResult getSaleGZ(@PathVariable String guzhiKey,
                                @PathVariable String otherKey,
                                @PathVariable long phone) {

        JsonResult result = reckonService.getSaleGZ(guzhiKey, otherKey, phone);
        return result;
    }

    /**
     * 近准估值 带估值车辆 信息
     * @param guzhiKey
     * @param otherKey
     * @param phone
     * @return
     */
    @RequestMapping(value = "/getSaleGZDT/{guzhiKey:.+}/{otherKey}/{phone}")
    @ResponseBody
    public JsonResult getSaleGZDetail(@PathVariable String guzhiKey,
                                      @PathVariable String otherKey,
                                      @PathVariable long phone){
        JsonResult result = reckonService.getSaleGZDetail(guzhiKey, otherKey, phone);
        return result;
    }

    /**
     * 从缓存获取估值信息
     *
     * @return
     */
    @RequestMapping(value = "/getGZDetail/{phone}")
    @ResponseBody
    public JsonResult getSaleGZ(@PathVariable long phone) {

        JsonResult result = reckonService.getGZDetail(phone);

        return result;
    }


    /**
     * 获取地铁站信息
     *
     * @return
     */

    @RequestMapping(value = "/getSite")
    @ResponseBody
    public JsonResult site() {
        reckonService.site();
        return JsonResult.OK();
    }

    /**
     * 获取4S店地址
     *
     * @return
     */
    @RequestMapping(value = "/getBusinessAddress")
    @ResponseBody
    public JsonResult getBusinessAddress() {
        JsonResult result = reckonService.getBusinessAddress();
        return result;
    }

    /**
     * 获取一周的时间
     *
     * @return
     */
    @RequestMapping(value = "/getOneWeek")
    @ResponseBody
    public JsonResult getOneWeek() {
        JsonResult result = reckonService.getOneWeek();
        return result;
    }

    /**
     * 获取地铁线路
     *
     * @return
     */
    @RequestMapping(value = "/getLines")
    @ResponseBody
    public JsonResult getLines() {
        JsonResult result = reckonService.getLines();
        return result;
    }

    /**
     * 通过线路ID 获取地铁站信息
     *
     * @param lineId
     * @return
     */
    @RequestMapping(value = "/getSite/{lineId}")
    @ResponseBody
    public JsonResult getSite(@PathVariable String lineId) {
        JsonResult result = reckonService.getSiteByLineId(lineId);
        return result;
    }

    /**
     * @param orderNumber 订单编号
     * @param dealWay     交易方式 1 4S店 2 地铁站 3 上门
     * @param wayId       4S店ID 或者 地铁站ID
     * @param linkMan     联系人
     * @param linkPhone   联系人手机号
     * @param address     上门地址
     * @return
     */
    @RequestMapping(value = "/updateOrders", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult updateOrders(String orderNumber,
                                   String dealWay,
                                   String wayId,
                                   String linkMan,
                                   String linkPhone,
                                   String address,
                                   String checkTime) {
        JsonResult resul = reckonService.updateOrders(orderNumber, dealWay, wayId, linkMan, linkPhone, address, checkTime);
        return resul;
    }

    @RequestMapping(value = "loginByToken/{phone}/{token}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult loginByToken(@PathVariable("phone") String phone, @PathVariable("token") String token) {
        JsonResult result = reckonService.loginByToken(phone, token);
        return result;
    }

    /**
     * 根据手机号获取订单信息/DTO
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "getOrdersByPhone/{phone}")
    @ResponseBody
    public JsonResult getOrdersByPhone(@PathVariable("phone") String phone) {
        JsonResult result = reckonService.getOrdersByPhone(phone);
        return result;
    }

 /*   @RequestMapping(value = "/joinUs",method = RequestMethod.POST)
    public JsonResult joinUs(String coName){
        return null;
    }*/

    /**
     * 获取热门品牌
     *
     * @return
     */
    @RequestMapping(value = "/getHotBrand")
    @ResponseBody
    public JsonResult getHotBrand() {
        JsonResult result = reckonService.getHotBrand();
        return result;
    }

    /**
     * 获取热门车系
     *
     * @return
     */
    @RequestMapping(value = "/reckon/getHotSeries")
    @ResponseBody
    public JsonResult getHotSeries() {
        JsonResult result = reckonService.getHotSeries();
        return result;
    }

    /**
     * 根据ID获取车型
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getModelById/{id}")
    @ResponseBody
    public JsonResult getModelById(@PathVariable("id") String id) {

        JsonResult result = reckonService.getModelById(id);
        return result;
    }


    @RequestMapping(value = "/wanghz", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult wanthz(String txt_companyname,
                             String txt_contactperson,
                             String txt_tel,
                             String txt_city,
                             String txt_remark) {
        reckonService.wanghz(txt_companyname, txt_contactperson, txt_tel, txt_city, txt_remark);

        return JsonResult.OK();
    }


    @RequestMapping(value = "/testUploadOss",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult testUploadOss(String json) {
     JsonResult result=reckonService.testUploadOss(json);
        return result;
    }

    @RequestMapping(value = "/getDocById/{documentId}")
    @ResponseBody
    public JsonResult document(@PathVariable String documentId){
        JsonResult result =  reckonService.getDocById(Long.parseLong(documentId));
        return result;
    }
}
