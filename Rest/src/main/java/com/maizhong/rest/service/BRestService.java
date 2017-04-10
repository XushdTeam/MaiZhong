package com.maizhong.rest.service;

import com.maizhong.common.dto.CarBaseDTO;
import com.maizhong.common.enums.OperateEnum;
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


    JsonResult loginOfCatch(String username, String password);


    JsonResult findBrandsByCatch();
    JsonResult findSeriesByCatch(String brandId);

    JsonResult findSkuBySeriesAndYear(String seriesId, String year);

    public JsonResult userLogin(String username, String password);
    
    //商品查询接口
    JsonResult selectCarByBussiness(Long businessId, Long carSeries, Long brandId,
                                    String date, String carYear, Integer start, Integer pageSize, String sortString);

    JsonResult findCarInfoById(Long id);

    JsonResult getDetailsByCarId(Long id);
    OperateEnum insertSeries(Long brandId,Long factoryId, String seriesName);

    OperateEnum insertCarCarBase(CarBaseDTO carBaseDTO);

    JsonResult getShopCount(Long businessId);

    JsonResult findFactoryByBrand(String brandId);

    JsonResult getSeriesByFactory(String factoryId);

    JsonResult isOnline(String token);

    JsonResult updateUserPwd(Long id, String oldPassword, String newPassword, String reNewPassword);

    JsonResult getBusinessById(Long id);


/*    JsonResult getFactoryByBrand();*/

  /*  JsonResult getSeriesByFactory();*/
}
