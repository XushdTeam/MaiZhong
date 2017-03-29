package com.maizhong.rest.service;

import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbCar;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    //商品查询接口
    public JsonResult selectCarList(TbCar tbCar);

    public JsonResult userLogin(String username,String password);
}
