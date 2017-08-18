package com.maizhong.youpin.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.youpin.service.AppService;
import com.maizhong.youpin.service.ImgUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Xushd on 2017/8/16.
 */
@RestController
public class APPController extends BaseController {

    @Autowired
    private AppService appService;
    @Autowired
    private ImgUploadService imgUploadService;


    /**
     * 根据deviceId 获取token
     * @param deviceId
     * @return
     */
    @RequestMapping(value = "/app/token/{deviceId}")
    public JsonResult getToken(@PathVariable String deviceId){
        return appService.getTokenByDeviceId(deviceId);
    }

    /**
     * 获取新闻
     * @return
     */
    @RequestMapping(value = "/app/news/{pageIndex}")
    public JsonResult getNewsListTop(@PathVariable int pageIndex){
        return appService.getNewsList(pageIndex);
    }

    /**
     * 获取帮助中心列表
     * @return
     */
    @RequestMapping(value = "/app/help/list")
    public JsonResult getHelp(){
        return appService.getHelpList();
    }

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @RequestMapping(value = "/app/send/verifycode/{phone}")
    public JsonResult sendVerifyCode(@PathVariable String phone){
        return appService.sendVerifyCode(phone);
    }

    /**
     * 登录
     * @param phone
     * @param vercode
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/login")
    public JsonResult login(String phone, String vercode, HttpServletRequest request){
        String token = super.getToken(request);
        return appService.login(phone,vercode,token);
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/logout")
    public JsonResult logout(HttpServletRequest request){
        return appService.logout(super.getToken(request));
    }

    /**
     * 获取公司名称
     * @return
     */
    @RequestMapping(value = "/app/company/list")
    public JsonResult getCompany(){
        return appService.getCompanyList();
    }

    /**
     * 修改用户信息
     * @param company
     * @param companyName
     * @param name
     * @param job
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/userinfo/save")
    public JsonResult updateUserInfo(long company,String companyName,String name,int job,HttpServletRequest request){
        String token = super.getToken(request);
        return appService.updateUserInfo(company,companyName,name,job,token);
    }

    /**
     * 上传图片
     * @param base64
     * @param type
     * @return
     */
    @RequestMapping(value = "/app/uploadImg")
    public JsonResult uploadImg(String base64,String type){
        return imgUploadService.uploadImg(base64,type);
    }

    /**
     * 修改头像
     * @param headimg
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/change/headimg")
    public JsonResult changHeadImg(String headimg,HttpServletRequest request){
        String token = super.getToken(request);
        return appService.changHeadImg(headimg,token);
    }

    /**
     * 同步用户信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/sync/userinfo")
    public JsonResult syncUserInfo(HttpServletRequest request){
        String token = super.getToken(request);
        return appService.syncUserInfo(token);
    }

    /**
     * 获取
     * @param guzhiKey
     * @param otherKey
     * @return
     */
    @RequestMapping(value = "/app/getSaleGZDetail/{guzhiKey:.+}/{otherKey}", method = RequestMethod.GET)
    public JsonResult getModeDetail(@PathVariable String guzhiKey,
                                    @PathVariable String otherKey,HttpServletRequest request){
        String token = super.getToken(request);
        return appService.getModelDetail(guzhiKey,otherKey,token);

    }

    /**
     * 提交卖车 申请
     * @param imgArry
     * @return
     */
    @RequestMapping(value = "/app/submit/record")
    public JsonResult submitRecord(String imgArry,HttpServletRequest request){
        String token = super.getToken(request);
        return appService.saveSaleRecord(imgArry,token);
    }

}
