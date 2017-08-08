package com.maizhong.auction.controller;

import com.maizhong.auction.pojo.AcPickUpMan;
import com.maizhong.auction.pojo.AcUser;
import com.maizhong.auction.service.AuctionService;
import com.maizhong.auction.service.ImgUploadService;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.IDUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
     * 获取验证码
     * @param phone
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/verify/{phone}")
    public JsonResult getVerifyCode(@PathVariable String phone, HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.getVerifyCode(phone,token);
        return result;
    }

    /**
     * 用户注册
     * @param acUser
     * @param bind
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/user/regist/{verifyCode}")
    public JsonResult userRegist(@Valid AcUser acUser,
                                 BindingResult bind,
                                 @PathVariable String verifyCode,
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
        if(!auctionService.checkVerifyCode(verifyCode,token))return JsonResult.Error("验证码错误");
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

    /**
     * 用户退出登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/user/logout")
    public JsonResult userLogout(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.userLogout(token);
        return result;
    }

    /**
     * APP 用户修改头像
     * @param url
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/user/headimg")
    public JsonResult userHeadimg(String url,
                                  HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.userHeadImg(url,token);
        return result;

    }

    /**
     * APP 用户实名认证
     * @param name
     * @param idNum
     * @param pic1
     * @param pic2
     * @param pic3
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/user/certification")
    public JsonResult userCertification(String name,
                                        String idNum,
                                        String pic1,String pic2,String pic3,
                                        HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.userCertification(name,idNum,pic1,pic2,pic3,token);
        return result;
    }

    /**
     * 修改归属城市
     */
    @RequestMapping(value = "/app/user/changeCity")
    public JsonResult userChangeCity(String city,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.userChangeCity(city,token);
        return result;
    }

    /**
     * 同步用户信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/sync/userinfo")
    public JsonResult syncUserInfo(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.syncUserInfo(token);
        return result;
    }

    /**
     * 获取正在拍的车辆
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/now/auction/list")
    public JsonResult getNowAuctionList(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.getNowAuctionList(token);
        return result;
    }


    /**
     * 获取汽车详情
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/car/detail/{carId}")
    public JsonResult getCarDetail(@PathVariable long carId){
        JsonResult result = auctionService.getCarDetail(carId);
        return result;
    }

    /**
     * 出价
     * @param ch
     * @param carId
     * @param plus
     * @param price
     * @return
     */
    @RequestMapping(value = "/app/addPrice/{ch}/{carId}")
    public JsonResult addPrice(@PathVariable String ch,
                               @PathVariable long carId,
                               String plus,
                               String price,
                               HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.addPrice(ch,carId,plus,price,token);
        return result;
    }

    /**
     * 获取出价记录
     * @param auctionId
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/bid/record/{auctionId}")
    public JsonResult bidrecord(@PathVariable long auctionId,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.getBidRecord(auctionId,token);
        return result;

    }

    /**
     * 获取成交车辆列表
     * @return
     */
    @RequestMapping(value = "/app/car/deal/list")
    public JsonResult getCarDealList(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.getCarDealList(token);
        return result;
    }

    /**
     * 获取出价车辆列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/car/plus/list")
    public JsonResult getCarPlusList(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.getCarPlusList(token);
        return result;
    }

    /**
     * 获取当前车辆状态
     * @param carId
     * @param chKey
     * @return
     */
    @RequestMapping(value = "/app/car/now/{carId}/{chKey}")
    public JsonResult getCarNow(@PathVariable long carId,@PathVariable String chKey,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.getCarNow(carId,chKey,token);
        return result;
    }

    /**
     * 关注车辆
     * @param carId
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/car/like/{carId}")
    public JsonResult carLike(@PathVariable long carId,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.carLike(carId,token);
        return result;
    }

    /**
     * 取消关注
     * @param carId
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/car/like/cancle/{carId}")
    public JsonResult carLikeCancle(@PathVariable long carId,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.carLikeCancle(carId,token);
        return result;
    }

    /**
     * 获取关注列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/car/like/list")
    public JsonResult carLikeList(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.carLikeList(token);
        return result;
    }


    /**
     * 智能报价
     * @param carId
     * @param price
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/car/auto/price/{carId}/{price}")
    public JsonResult autoPrice(@PathVariable long carId,
                                @PathVariable long price,
                                HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.autoPrice(carId,price,token);
        return result;
    }


}
