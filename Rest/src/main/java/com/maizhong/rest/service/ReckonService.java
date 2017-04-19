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
}
