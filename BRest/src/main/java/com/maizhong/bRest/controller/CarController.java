package com.maizhong.bRest.controller;

import com.maizhong.bRest.service.CarService;
import com.maizhong.common.dto.UserInfo;
import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbCar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/3/28.
 */
@RestController
@RequestMapping("/car")
public class CarController {

    @Resource
    private CarService carService;

    //更改方法和添加方法
    @RequestMapping("/modfiy")
    public JsonResult insertCar(TbCar car){
        if (car==null){

        }
        return null;
    }


    @RequestMapping("/list")
    public JsonResult findList(TbCar tbCar,HttpServletRequest request){

        //数据填充
        UserInfo userInfo = (UserInfo) request.getAttribute("userInfo");
        if (userInfo.getBusinessId()!=null){
            tbCar.setBusinessId(Long.parseLong(userInfo.getBusinessId()));
        }
        return carService.findList(tbCar);
    }


}
