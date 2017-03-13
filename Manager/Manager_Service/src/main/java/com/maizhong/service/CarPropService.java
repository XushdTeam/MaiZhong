package com.maizhong.service;

import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbCarProp;

/**
 * 汽车属性 界面
 *
 *
 * Created by yangF on 2017/3/9.
 */
public interface CarPropService {
    public TbCarProp findPropByCarId(Long id);

    JsonResult insertCarProp(TbCarProp tbCarProp);

    JsonResult updateCarProp(TbCarProp tbCarProp);

    JsonResult deleteCarPropByCarId(Long id);
}
