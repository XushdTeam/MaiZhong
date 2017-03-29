package com.maizhong.rest.service;

import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbCar;

/**
 * Created by yangF on 2017/3/28.
 */
public interface BRestService {

    //数据添加
    public JsonResult insertCar(TbCar tbCar);

    //数据修改
    public JsonResult updateCar(TbCar tbCar);

    //数据删除
    public JsonResult deleteCar(String id);


    //下架方法
    JsonResult unable(String id, Integer unalbe);



    JsonResult findBrandsByCatch();
    JsonResult findSeriesByCatch(String brandId);

    JsonResult findSkuBySeriesAndYear(String seriesId, String year);

    public JsonResult userLogin(String username, String password);
    
    //商品查询接口
    JsonResult selectCarByBussiness(Long businessId, Long carSeries, Long brandId,
                                    String date, String carYear, Integer start, Integer pageSize, String sortString);

    JsonResult findCarInfoById(Long id);
}
