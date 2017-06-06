package com.maizhong.rest.service;

import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/4/18.
 */

public interface ReckonService {
    void getBrandData();

    void getSeriesData();

    JsonResult getBrandList();

    JsonResult sysBrandGroupByInitial();

    JsonResult getSeriesByBrandId(String brandId);

    JsonResult getProvince();

    JsonResult getCity();

    JsonResult getCarType(String seriesId);

    JsonResult getSMSCode(String phone,String ip);
    JsonResult userLogin(String smsCode,String phone,String ip);
    
    JsonResult getGuzhi(String param);

    void setRedisCity();

    JsonResult getSaleGZ(String guzhiKey, String otherKey,long phone);

    JsonResult getGZDetail(long phone);

    void site();


    JsonResult getBusinessAddress();

    JsonResult getOneWeek();


    JsonResult getLines();

    JsonResult getSiteByLineId(String lineId);

    JsonResult updateOrders(String orderNumber, String dealWay, String wayId, String linkMan, String linkPhone,String address,String checkTime);

    JsonResult loginByToken(String phone, String token);

    JsonResult getOrdersByPhone(String phone);

    JsonResult getHotBrand();

    JsonResult getHotSeries();

    JsonResult getModelById(String id);

    void wanghz(String txt_companyname, String txt_contactperson, String txt_tel, String txt_city, String txt_remark);

    JsonResult testUploadOss(String json);

    JsonResult getDocById(long docId);

    JsonResult getSaleGZDetail(String guzhiKey, String otherKey, long phone);
}
