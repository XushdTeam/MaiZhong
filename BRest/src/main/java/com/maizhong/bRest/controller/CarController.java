package com.maizhong.bRest.controller;

import com.maizhong.bRest.service.CarService;
import com.maizhong.bRest.service.ImgUploadService;
import com.maizhong.common.dto.UserInfo;
import com.maizhong.common.exception.UploadException;
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
    public JsonResult findList(
            String brandId,
            String carSeries,
            String date,
            String carYear,
            Integer currentPage,
            String sortString,
            HttpServletRequest request){

        //数据填充
        UserInfo userInfo = (UserInfo) request.getAttribute("userInfo");

        return carService.findList(userInfo.getBusinessId(),brandId,carSeries,
                date,carYear,currentPage,sortString);
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
     * @return
     */
    @RequestMapping(value = "/car/modify",method = RequestMethod.POST)
    public JsonResult updateCar(
            String id,
            String baseId,
            String carBrand,
            String carBrandLine,
            String sellpoint,
            String sellPrice,
            String carYear,
            String stockNum,
            String image,
            String smimage,
            HttpServletRequest request){
        UserInfo userInfo= (UserInfo) request.getAttribute("userInfo");

        if (userInfo!=null&&userInfo.getBusinessId()!=null){
           return carService.modifyCar(id,baseId,carBrand,carBrandLine,sellpoint,
                   sellPrice,stockNum,image,smimage,userInfo.getBusinessId(),carYear);
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
    @RequestMapping(value = "/upload/body")
    public JsonResult uploadImgBody(@RequestParam(value = "file", required = false)MultipartFile filedata) throws UploadException {
        JsonResult res = imgUploadService.uploadImg(filedata, "carbody/");
        if (res.getStatus() == 200) {
            return res;
        } else {
            throw new UploadException(res.getMessage());
        }
    }
    /**
     * 图片上传
     * @param filedata
     * @return
     */
    @RequestMapping(value = "/upload/head")
    public JsonResult uploadImgHead(@RequestParam(value = "file", required = false)MultipartFile filedata) throws UploadException {
        JsonResult res = imgUploadService.uploadImg(filedata, "carhead/");
        if (res.getStatus() == 200) {
            return res;
        } else {
            throw new UploadException(res.getMessage());
        }
    }

    /**
     * 汽车详情
     * @param carId
     * @return
     */
    @RequestMapping(value = "/cardetail/{carId}")
    public JsonResult getCarDetail(@PathVariable String carId){
        JsonResult res = this.carService.getCarDetail(carId);
        return res;
    }

    /**
     * 车系添加
     * @param brandId
     * @param seriseName
     * @return
     */
    @RequestMapping(value = "/car/serise/save")
    public JsonResult saveSerise(String brandId,String seriseName){
        JsonResult res = this.carService.saveSerise(brandId,seriseName);
        return res;
    }
}
