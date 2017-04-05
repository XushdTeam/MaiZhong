package com.maizhong.rest.service;

import com.maizhong.common.dto.CarBrandDTO;
import com.maizhong.common.dto.KeyObject;
import com.maizhong.common.dto.KeyValue;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;

import java.util.List;
import java.util.Map;

/**
 * Created by yangF on 2017/3/14.
 */
public interface SearchService {
    /**
    * 数据库同步索引
    * */
    public JsonResult syncIndex();


    Map<String,Object> searchDoc(String queryString, String[] sortString, Integer pageIndex, String highTiken);

    public JsonResult getSearchResult(String queryString, String sortString, String carBrand, String carSeries,String carType, String price, String capacity, String carYear, String pageIndex);


    List<Object> getCarSeriesList(String brandId,String seriesId);

    JsonResult getSearchBase(String brandId, String seriesId);

    List<CarBrandDTO> getCarBrandHot();

    List<KeyObject> syncCarBrandGroup();

    List<KeyObject> getCarBrandGroupByInitial();

    JsonResult syncTosolr(String delId, String insertId);
}
