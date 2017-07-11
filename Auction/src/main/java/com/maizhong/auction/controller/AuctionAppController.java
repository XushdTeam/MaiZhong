package com.maizhong.auction.controller;

import com.maizhong.auction.pojo.AcPickUpMan;
import com.maizhong.auction.pojo.AcUser;
import com.maizhong.auction.service.AuctionService;
import com.maizhong.auction.service.ImgUploadService;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Xushd on 2017/7/10.
 */
@RestController
public class AuctionAppController {

    @Autowired
    private AuctionService auctionService;
    @Autowired
    private ImgUploadService imgUploadService;

    /**
     * 获取临时token
     * @param request
     * @return
     */
    @RequestMapping(value = "/get/token")
    public JsonResult getToken(HttpServletRequest request){
        String token = IDUtils.getUUID();
        return JsonResult.build(200,"ok",token);
    }

    /**
     * 获取文档列表
     *
     * @param type
     * @return
     */
    @RequestMapping(value = "/app/doc/list/{type}")
    public JsonResult getDocList(@PathVariable int type) {
        JsonResult result = auctionService.getDocList(type);
        return result;
    }

    /**
     * 获取文档详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/app/doc/detail/{id}")
    public JsonResult getDocDetail(@PathVariable long id) {
        JsonResult result = auctionService.getDocDetail(id);
        return result;
    }


    /**
     * 首页推荐车辆
     * @return
     */
    @RequestMapping(value = "/app/top/car")
    public JsonResult getTopCar(){
        JsonResult result = auctionService.getTopCar();
        return result;
    }

    /**
     * 查询售后车辆
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/saleback/car")
    public JsonResult getSaleBackCar(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.getSaleBackCar(token);
        return result;
    }

    /**
     * 获取授权提车人
     * @return
     */
    @RequestMapping(value = "/app/pickupman")
    public JsonResult getPickUpMan(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.getPickUpMan(token);
        return result;

    }

    /**
     * 保存授权提车人
     * @param man
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/save/pickupman")
    public JsonResult savePickUpMan(AcPickUpMan man,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.savePickUpMan(man,token);
        return result;
    }

    /**
     * 图片上传
     * @param imgStr
     * @return
     */
    @RequestMapping(value = "/app/img/upload")
    public JsonResult checkBaseImgUpload(String imgStr){
        JsonResult result = imgUploadService.uploadImg(imgStr,"check/pickup/");
        return result;
    }

    /**
     * 用户注册
     * @param acUser
     * @param bind
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/user/regist")
    public JsonResult userRegist(@Validated AcUser acUser,
                                 BindingResult bind,
                                 HttpServletRequest request){
        if(bind.hasErrors()){
            String error = "";
            List<ObjectError> allErrors = bind.getAllErrors();
            for (ObjectError allError : allErrors) {
                error+= allError.getDefaultMessage();
            }
            return JsonResult.Error(error);
        }
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.registUser(acUser,token);
        return result;

    }

    /**
     * APP 用户登录
     * @param phone
     * @param pass
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/user/login/{phone}/{pass}")
    public JsonResult userLogin(@PathVariable long phone,
                                @PathVariable String pass,
                                HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.userLogin(phone,pass,token);
        return result;

    }
}
