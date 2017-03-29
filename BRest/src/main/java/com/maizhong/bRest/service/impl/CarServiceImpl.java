package com.maizhong.bRest.service.impl;

import com.maizhong.bRest.service.CarService;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.pojo.TbCar;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/28.
 */
public class CarServiceImpl implements CarService {

    @Override
    public JsonResult updateCar(TbCar tbCar) {
        if (tbCar==null){
            return JsonResult.Error("数据错误");
        }

        Map<String,String> map = new HashMap<>();

        BeanUtils.copyProperties(tbCar,map);



        HttpClientUtil.doPost("",map);


        return null;
    }
}
