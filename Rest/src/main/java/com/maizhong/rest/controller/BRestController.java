package com.maizhong.rest.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.common.target.ServiceLog;
import com.maizhong.pojo.TbCar;
import com.maizhong.rest.service.BRestService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 主服务
 *      作用  根据其他服务器返回的数据对服务器进行数据处理
 *              处理汽车CRUD
 *
 * Created by YangF on 2017/3/28.
 */
@RequestMapping("/bRest")
@RestController
public class BRestController {

    @Resource
    private BRestService bRestService;


    //数据添加
    @RequestMapping("/car/insert")
    public JsonResult insertCar(TbCar car){
        return null;
    }

    //数据修改
    @RequestMapping("/car/update")
    public JsonResult updateCar(TbCar tbCar){

        return null;
    }

    //数据删除
    @RequestMapping("/car/delete/{id}")
    public JsonResult delCar(@PathVariable("id") String id){
        return null;
    }

    //商品下架
    @RequestMapping("/car/unable/{id}")
    public JsonResult unable(@PathVariable("id") String id){
        return null;
    }

    //商品查询接口
    @RequestMapping("/car/find/{businessId}")
    public JsonResult selectCarList(@PathVariable("businessId") Long businessId){
        return bRestService.selectCarByBussiness(businessId);
    }


    @RequestMapping("/user")
    public JsonResult userLogin(String username,String password){
        return bRestService.userLogin(username,password);
    }
}
