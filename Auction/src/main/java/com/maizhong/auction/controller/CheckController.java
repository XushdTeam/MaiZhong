package com.maizhong.auction.controller;

import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.CheckService;
import com.maizhong.auction.service.ImgUploadService;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Xushd on 2017/6/14.
 */
@RestController
public class CheckController {

    @Autowired
    private CheckService checkService;
    @Autowired
    private ImgUploadService imgUploadService;
    /**
     * 登录
     * @param account
     * @param pass
     * @return
     */
    @RequestMapping(value = "/app/check/login",method = RequestMethod.POST)
    public JsonResult checkLogin(String account,String pass){
        JsonResult result = checkService.checkLogin(account,pass);
        return result;
    }

    /**
     * 修改密码
     * @param pass
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/check/changePwd",method = RequestMethod.POST)
    public JsonResult editPass(String pass, HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = checkService.changePwd(pass,token);
        return result;
    }

    /**
     * 反馈建议
     * @param content
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/check/feedback",method = RequestMethod.POST)
    public JsonResult feedback(String content, HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = checkService.feedback(content,token);
        return result;
    }

    /**
     * 获取帮助中心列表
     * @return
     */
    @RequestMapping(value = "/app/check/getHelpTitle",method = RequestMethod.GET)
    public JsonResult help(){
        JsonResult result = checkService.getHelp();
        return result;
    }

    /**
     * 获取帮助详细内容
     * @param id
     * @return
     */
    @RequestMapping(value = "/app/check/getHelpContent/{id}",method = RequestMethod.GET)
    public JsonResult helpDetail(@PathVariable long id){
        JsonResult result = checkService.getHelpDetail(id);
        return result;
    }

    /**
     * 获取公告信息列表
     * @return
     */
    @RequestMapping(value = "/app/check/news/list",method = RequestMethod.GET)
    public JsonResult newslist(){
        JsonResult result = checkService.getNewsList();
        return result;
    }

    /**
     * 获取新闻详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/app/check/news/detail/{id}",method = RequestMethod.GET)
    public JsonResult newsDetail(@PathVariable long id){
        JsonResult result = checkService.getNewsDetail(id);
        return result;
    }


    @RequestMapping(value = "/app/check/base/img/upload")
    public JsonResult checkBaseImgUpload(String imgStr){
        JsonResult result = imgUploadService.uploadImg(imgStr,"check/base/");
        return result;
    }

    /**
     * 检测端创建一辆车
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/check/newcar",method = RequestMethod.POST)
    public JsonResult checkCarNew(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = checkService.newCarbase(token);
        return result;
    }

    /**
     * 获取汽车列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/check/car/list")
    public JsonResult checkCarList(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = checkService.checkCarList(token);
        return result;
    }

    /**
     * 删除车辆
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/check/car/del/{carId}")
    public JsonResult checkCarDel(@PathVariable long carId){
        JsonResult result = checkService.checkCarDel(carId);
        return result;
    }


    /**
     * 保存行驶证信息
     * @param xsz
     * @return
     */
    @RequestMapping(value = "/app/check/car/xsz/save")
    public JsonResult checkCarXSZ(CkXsz xsz){
        if(xsz==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.saveXSZ(xsz);
        return result;
    }

    /**
     * 保存登记证信息
     * @param djz
     * @return
     */
    @RequestMapping(value = "/app/check/car/djz/save")
    public JsonResult checkCarDJZ(CkDjz djz){
        if(djz==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.saveDJZ(djz);
        return result;
    }

    /**
     * 保存其他证件信息
     * @param qtz
     * @return
     */
    @RequestMapping(value = "/app/check/car/qtz/save")
    public JsonResult checkCarQTZ(CkQtz qtz){
        if(qtz==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.saveQTZ(qtz);
        return result;
    }

    /**
     * 保存车主信息
     * @param czinfo
     * @return
     */
    @RequestMapping(value = "/app/check/car/czxx/save")
    public JsonResult checkCarCZINFO(CkCzinfo czinfo){
        if(czinfo==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.saveCZXX(czinfo);
        return result;
    }

    /**
     * 获取检测车辆STEP1信息 （xsz,djz,qtz,czxx）
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/check/car/step1/{carId}")
    public JsonResult checkCarSTEP1(@PathVariable long carId){
        JsonResult result = checkService.getCarStep1(carId);
        return result;
    }

    /**
     * 检测车辆基本照片
     * @param ckBaseimg
     * @return
     */
    @RequestMapping(value = "/app/check/car/baseimg")
    public JsonResult checkCarBaseImg(CkBaseimg ckBaseimg){
        if(ckBaseimg==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.saveCarBaseImg(ckBaseimg);
        return result;
    }

    /**
     * 获取基本照片
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/check/getcar/baseimg/{carId}")
    public JsonResult getCarBaseImg(@PathVariable long carId){
        JsonResult result = checkService.getCarBaseImg(carId);
        return result;
    }


}
