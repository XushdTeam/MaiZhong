package com.maizhong.rest.service;

import com.maizhong.common.result.JsonResult;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-18
 * Time: 9:57
 */
public interface AppService {
    JsonResult getTokenByDeciceId(String deviceId,String phone);

    JsonResult testGetToken(HttpServletRequest request);

    JsonResult getAdvert();

    JsonResult getProvince();

    JsonResult getCity();

    JsonResult getLine();

    JsonResult getLineSite();

    JsonResult getBrand();

    JsonResult getSeries(String brandId);

    JsonResult getModelBySeries(String seriesId);


    JsonResult getSmsCode(String phone);

    JsonResult userLogin(String smsCode, String phone);

    JsonResult getGuzhi(String param, HttpServletRequest request);

    JsonResult uploadBase64(String base64Date,HttpServletRequest request);

    JsonResult getGzrecord(HttpServletRequest request);

    JsonResult getHelpTitle();

    JsonResult getHelpContent(String id);

    JsonResult getSaleGZ(String guzhiKey, String otherKey,HttpServletRequest request);

    JsonResult updateOrders(String orderNumber, String dealWay, String wayId, String linkMan, String linkPhone, String address, String checkTime);

    JsonResult getOrdersByPhone(HttpServletRequest request);

    JsonResult getOrderAgreement();

    JsonResult getGZDetail(long phone);

    JsonResult getBusinessAddress();

    JsonResult getGZDetailByOrderNumber(long orderNumber);

    JsonResult deleteOrder(String orderNumber, HttpServletRequest request);

    JsonResult getAppGZDetail(HttpServletRequest request);

    JsonResult getVersion();

    JsonResult getModelById(String id);

    JsonResult getSaleNum();

    JsonResult getSaleGZDetail(String guzhiKey, String otherKey,int vrate, HttpServletRequest request);

    JsonResult syncUserInfo(String token);
}
