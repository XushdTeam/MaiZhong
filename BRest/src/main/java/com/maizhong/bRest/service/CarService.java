package com.maizhong.bRest.service;

import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbCar;
import com.maizhong.pojo.TbCarBrand;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/28.
 */
public interface CarService {

    JsonResult getBrand();

    JsonResult getSeriesByBrand(String brandId);

    JsonResult getCarTypeBySeries(String seriesId, String caryear);

    JsonResult getCarById(String carid);

    JsonResult deleteCar(String carid);

    JsonResult modifyCar(String id,String baseId, String carBrand, String carBrandLine, String sellpoint, String sellPrice, String stockNum, String image, String smimage, String businessId,String carYear);

    JsonResult findList(String businessId, String brandId, String carSeries, String date, String carYear, Integer currentPage, String sortString);

    JsonResult getCarDetail(String carId);

    JsonResult saveSerise(String brandId, String seriseName,String factoryId);

    JsonResult saveCarBaseInfo(Map<String, String> map);

    JsonResult getStatict(String businessId);

    JsonResult getFactory(String brandId);

    JsonResult getCarSeriseByFactory(String factoryId);

    JsonResult getBussinessInfo(String businessId);

    JsonResult changePass(String userId, String pass1, String pass2, String pass3);
}
