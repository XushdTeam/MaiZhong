package com.maizhong.rest.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.AppService;
import com.maizhong.rest.service.ReckonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ReckonService reckonService;

    /**
     * 根据设备Id获取token
     *
     * @param deviceId
     * @return
     */
    @RequestMapping(value = "/getTokenByDeviceId", method = RequestMethod.GET)
    public JsonResult getTokenByDeviceId(@RequestParam(value = "deviceId", required = false) String deviceId, @RequestParam(value = "phone", required = false) String phone) {

        if (StringUtils.isBlank(deviceId) && StringUtils.isBlank(phone)) return JsonResult.Error("网络繁忙，请稍后重试");

        JsonResult result = null;
        try {
            result = appService.getTokenByDeciceId(deviceId, phone);
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

    /**
     * 根据品品牌获取车系
     *
     * @return
     */
    @RequestMapping(value = "/getSeriesByBrand/{brandId}", method = RequestMethod.GET)
    public JsonResult getSeries(@PathVariable("brandId") String brandId) {
        JsonResult result = appService.getSeries(brandId);
        return result;
    }

    /**
     * 根据车系获取车型
     *
     * @param seriesId
     * @return
     */
    @RequestMapping(value = "/getModelBySeries/{seriesId}")
    public JsonResult getModelBySeries(@PathVariable("seriesId") String seriesId) {
        JsonResult result = appService.getModelBySeries(seriesId);
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

        JsonResult result = appService.getModelById(id);
        return result;
    }


    /**
     * 预估值
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/guzhi/{param:.+}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getGuzhi(@PathVariable String param, HttpServletRequest request) {
        JsonResult result = appService.getGuzhi(param, request);
        return result;
    }

    /**
     * 根据手机号发送验证码
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "/getSmsCode/{phone}")
    public JsonResult getSmsCode(@PathVariable("phone") String phone) {
        JsonResult result = appService.getSmsCode(phone);
        return result;
    }



    /**
     * 用户登录
     *
     * @param smsCode
     * @param phone
     * @return
     */
    @RequestMapping(value = "/userLogin/{smsCode}/{phone}", method = RequestMethod.GET)
    public JsonResult userLogin(@PathVariable("smsCode") String smsCode, @PathVariable("phone") String phone) {
        JsonResult result = appService.userLogin(smsCode, phone);
        return result;
    }

    /**
     * APP头像上传
     *
     * @param base64Date
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadBase64", method = RequestMethod.POST)
    public JsonResult uploadBase64(String base64Date, HttpServletRequest request) {
        JsonResult result = appService.uploadBase64(base64Date, request);
        return result;
    }

    /**
     * 获取估值记录
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getGzrecord")
    public JsonResult getGzrecord(HttpServletRequest request) {
        JsonResult result = appService.getGzrecord(request);
        return result;
    }

    /**
     * 帮助中心获取标题
     *
     * @return
     */
    @RequestMapping(value = "getHelpTitle")
    public JsonResult getHelp() {
        JsonResult result = appService.getHelpTitle();
        return result;
    }

    /**
     * 帮助中心 根据id获取内容
     *
     * @return
     */
    @RequestMapping(value = "getHelpContent/{id}", method = RequestMethod.GET)
    public JsonResult getHelp(@PathVariable("id") String id) {
        JsonResult result = appService.getHelpContent(id);
        return result;
    }

    /**
     * 获取精准估值结果
     *
     * @param guzhiKey
     * @param otherKey
     * @return
     */
    @RequestMapping(value = "/getSaleGZ/{guzhiKey:.+}/{otherKey}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getSaleGZ(@PathVariable String guzhiKey,
                                @PathVariable String otherKey,
                                HttpServletRequest request) {
        JsonResult result = appService.getSaleGZ(guzhiKey, otherKey, request);
        return result;
    }

    /**
     * 获取精准详细估值结果
     *
     * @param guzhiKey
     * @param otherKey
     * @return
     */
    @RequestMapping(value = "/getSaleGZDetail/{guzhiKey:.+}/{otherKey}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getSaleGZDetail(@PathVariable String guzhiKey,
                                @PathVariable String otherKey,String rate,
                                HttpServletRequest request) {
        int vrate = 0;
        if(StringUtils.isNotBlank(rate))vrate = Integer.parseInt(rate);
        JsonResult result = appService.getSaleGZDetail(guzhiKey, otherKey,vrate, request);
        return result;
    }



    /**
     * 从缓存获取估值信息 通过手机
     *
     * @return
     */
    @RequestMapping(value = "/getGZDetail/{phone}")
    @ResponseBody
    public JsonResult getSaleGZ(@PathVariable long phone) {

        JsonResult result = appService.getGZDetail(phone);

        return result;
    }

    /**
     * 从缓存获取估值信息 通过手机
     *
     * @return
     */
    @RequestMapping(value = "/getAppGZDetail")
    @ResponseBody
    public JsonResult getSaleGZ(HttpServletRequest request) {

        JsonResult result = appService.getAppGZDetail(request);

        return result;
    }


    /**
     * 从缓存获取估值信息 通过订单编号
     *
     * @return
     */
    @RequestMapping(value = "/getSaleGZByOrder/{orderNumber}")
    @ResponseBody
    public JsonResult getSaleGZByOrderNumber(@PathVariable long orderNumber) {

        JsonResult result = appService.getGZDetailByOrderNumber(orderNumber);

        return result;
    }


    /**
     * 订单--完善
     *
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
        JsonResult resul = appService.updateOrders(orderNumber, dealWay, wayId, linkMan, linkPhone, address, checkTime);
        return resul;
    }

    /**
     * 根据手机号获取订单信息/DTO
     *
     * @return
     */
    @RequestMapping(value = "/getOrdersByPhone")
    @ResponseBody
    public JsonResult getOrdersByPhone(HttpServletRequest request) {
        JsonResult result = appService.getOrdersByPhone(request);
        return result;
    }


    /**
     * 获取汽车协议
     *
     * @return
     */
    @RequestMapping(value = "getOrderAgreement", method = RequestMethod.GET)
    public JsonResult getOrderAgreement() {
        JsonResult result = appService.getOrderAgreement();
        return result;
    }

    /**
     * 获取4S店地址
     *
     * @return
     */
    @RequestMapping(value = "/getBusinessAddress")
    @ResponseBody
    public JsonResult getBusinessAddress() {
        JsonResult result = appService.getBusinessAddress();
        return result;
    }

    /**
     * 删除
     *
     * @param orderNumber
     * @return
     */
    @RequestMapping(value = "/deleteOrder/{orderNumber}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult deleteOrder(@PathVariable("orderNumber") String orderNumber, HttpServletRequest request) {
        JsonResult result = appService.deleteOrder(orderNumber, request);
        return result;
    }


    /**
     * 获取版本号
     *
     * @return
     */
    @RequestMapping(value = "/getVersion")
    @ResponseBody
    public JsonResult getVersion() {
        JsonResult result = appService.getVersion();
        return result;
    }

    /**
     * 获取销售数量
     * @return
     */
    @RequestMapping(value = "/getSaleNum")
    @ResponseBody
    public JsonResult getSaleNum(){
        JsonResult result=appService.getSaleNum();
        return result;
    }

    /**
     * 同步用户信息
     * @since 2017年6月15日 09:59:08
     * @author Xushd
     * @param request
     * @return
     */
    @RequestMapping(value = "/syncUserInfo")
    @ResponseBody
    public JsonResult syncUserInfo(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult  result =  appService.syncUserInfo(token);
        return result;

    }
}
