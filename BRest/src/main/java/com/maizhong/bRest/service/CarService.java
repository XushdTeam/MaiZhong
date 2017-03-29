package com.maizhong.bRest.service;

import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbCar;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/28.
 */
public interface CarService {
    //缓存数据需要手动同步
    List<Map<String, Object>> syncDataToRedis(Long businessId);

    public JsonResult updateCar(TbCar tbCar);

    //条件查询  //buzuo le cao
    //参数无用
    JsonResult findList(TbCar tbCar);
}
