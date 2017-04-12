package com.maizhong.portal.service;

import com.maizhong.common.result.JsonResult;

/**
 * Created by YangF  on 2017/4/10.
 */
public interface AssessService {

    JsonResult getCarBuyDateAndmileage(Long carId);

    JsonResult getCarBrand();

    JsonResult getCarSeries(Long brandId);

    JsonResult getCarType(Long seriesId);

    JsonResult calculatePrice(String bid, String sid, String specId, String registerYear, String registerMonth, String selectCarName);

}
