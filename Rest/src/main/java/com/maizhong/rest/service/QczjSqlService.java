package com.maizhong.rest.service;

import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbAssessBrand;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public interface QczjSqlService {

    JsonResult getSeries4Brand();

    JsonResult getBrandBySql();

    JsonResult getSeriesByBrandId(Long brandId);

    JsonResult getCarBySeriesId(Long seriesId);


    JsonResult getCarBuyDateAndmileage(Long carId);

}
