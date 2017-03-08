package com.maizhong.controller;

import com.github.pagehelper.PageInfo;
import com.maizhong.common.result.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/2.
 *
 * 测试方法  待删除
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/{test}")
    public String test(@PathVariable("test") String test){
        System.out.println("test");
        if (test.contains("0")) {
            return test.replace("0","/");
        }
        return test;
    }

    @RequestMapping("/carSku/add")
    public String testSku(@RequestParam("car_name") String[] carName, @RequestParam("carColor") String[] carColor,
                          @RequestParam("carType") Integer[] carType, @RequestParam("shopPrice") Double[] shopPrice,
                          @RequestParam("reservePrice") Double[] reservePrice) throws Exception {
        if (carName==null||carName.length==0)
            throw new Exception();
        List list = new ArrayList();
        for (int i = 0; i <carName.length ; i++) {
        }
//        car_name:321321
//        carColor:0
//        carType:0
//        shopPrice:321
//        sellPrice:321
//        reservePrice:321
//        car_name:321321
//        carColor:1
//        carType:1
//        shopPrice:321
//        sellPrice:321
//        reservePrice:321
        for (String carname:carName) {
            System.out.println(carname);
        }
        return null;
    }

}
