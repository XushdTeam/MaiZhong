package com.maizhong.bRest.controller;

import com.maizhong.bRest.service.CarService;
import com.maizhong.bRest.service.ImgUploadService;
import com.maizhong.common.dto.UserInfo;
import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/3/28.
 */
@RestController
public class CarController {

    @Resource
    private CarService carService;

    @Autowired
    private ImgUploadService imgUploadService;



    @RequestMapping("/car/list")
    public JsonResult findList(TbCar tbCar,HttpServletRequest request){

        //数据填充
        UserInfo userInfo = (UserInfo) request.getAttribute("userInfo");
        if (userInfo.getBusinessId()!=null){
            tbCar.setBusinessId(Long.parseLong(userInfo.getBusinessId()));
        }
        return carService.findList(tbCar);
    }

    /**
     * 获取所有汽车品牌
     * @return
     */
    @RequestMapping(value = "/getBrand",method = RequestMethod.GET)
    public JsonResult getBrand(){
     return   carService.getBrand();
    }

    /**
     * 根据品牌Id获取车系
     * @param brandId
     * @return
     */
    @RequestMapping(value = "/getSeriesByBrand/{brandId}",method = RequestMethod.GET)
    public JsonResult getSeriesByBrand(@PathVariable String brandId){
        return   carService.getSeriesByBrand(brandId);
    }

    /**
     * 根据车系Id和年份获取车型号
     * @param seriesId
     * @param caryear
     * @return
     */
    @RequestMapping(value = "/getCarType/{seriesId}/{caryear}",method = RequestMethod.GET)
    public JsonResult getCarTypeBySeries(@PathVariable String seriesId,@PathVariable String caryear){
        return   carService.getCarTypeBySeries(seriesId,caryear);
    }


    /**
     *汽车添加和修改
     * @param tbCar
     * @return
     */
    @RequestMapping(value = "/car/modify",method = RequestMethod.POST)
    public JsonResult updateCar(TbCar tbCar,HttpServletRequest request){
        UserInfo userInfo= (UserInfo) request.getAttribute("userInfo");
        if (userInfo!=null&&userInfo.getBusinessId()!=null){
            tbCar.setBusinessId(Long.valueOf(userInfo.getBusinessId()));
            return carService.modifyCar(tbCar);
        }
        return  JsonResult.Error("操作失败！请刷新后重新！");
    }
    /**
     *获取汽车对象
     * @param carid
     * @return
     */
    @RequestMapping(value = "/car/info/{carId}",method = RequestMethod.GET)
    public JsonResult infoCar(@PathVariable String carid){
            return carService.getCarById(carid);

    }
    /**
     *删除汽车
     * @param carid
     * @return
     */
    @RequestMapping(value = "/car/delete/{carId}",method = RequestMethod.GET)
    public JsonResult deleteCar(@PathVariable String carid){
        return carService.deleteCar(carid);

    }

    /**
     * 图片上传
     * @param filedata
     * @return
     */
    @RequestMapping(value = "/upload")
    public JsonResult uploadImg(@RequestParam(value = "file", required = false)MultipartFile filedata){
        JsonResult res = imgUploadService.uploadImg(filedata,"carimg/");
        return res;
    }


}
