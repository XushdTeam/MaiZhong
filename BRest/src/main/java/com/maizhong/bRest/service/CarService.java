package com.maizhong.bRest.service;

import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbCar;

/**
 * Created by Administrator on 2017/3/28.
 */
public interface CarService {
    public JsonResult updateCar(TbCar tbCar);
}
