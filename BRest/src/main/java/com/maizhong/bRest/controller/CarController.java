package com.maizhong.bRest.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbCar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/28.
 */
@RestController
@RequestMapping("/car")
public class CarController {


    //更改方法和添加方法
    @RequestMapping("/modfiy")
    public JsonResult insertCar(TbCar car){
        if (car==null){

        }
        return null;
    }



}
