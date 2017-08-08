package com.maizhong.auction.controller;

import com.maizhong.auction.service.PersonalAppService;
import com.maizhong.common.result.JsonResult;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 车主APP Controller
 * Created by Xushd on 2017/8/1.
 */
@RestController
public class PersonalAppController extends BaseController {

    @Autowired
    private PersonalAppService appService;



    /**
     * 获取token
     * @param deviceId
     * @return
     */
    @RequestMapping(value = "/app/personal/getToken/{deviceId}")
    public JsonResult getToken(@PathVariable String deviceId){
        return appService.getToken(deviceId);
    }

    /**
     * 获取验证码
     * @param phone
     * @return
     */
    @RequestMapping(value = "/app/personal/getVerifyCode/{phone}")
    public JsonResult getVerifyCode(@PathVariable long phone){

        return appService.getVerifyCode(phone);
    }

    /**
     * 登录
     * @param phone
     * @param verifyCode
     * @return
     */
    @RequestMapping(value = "/app/personal/login/{phone}/{verifyCode}")
    public JsonResult login(@PathVariable long phone,
                            @PathVariable String verifyCode,
                            HttpServletRequest request){
        String token = super.getToken(request);
        return appService.login(phone,verifyCode,token);
    }

    /**
     * 反馈
     * @param content
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/personal/feedback")
    public JsonResult feedback(String content,HttpServletRequest request){
        String token = super.getToken(request);
        return appService.feedback(content,token);
    }

    /**
     * 获取新闻列表
     * @return
     */
    @RequestMapping(value = "/app/personal/news/list")
    public JsonResult newsList(){
        return appService.getNewsList();
    }

    /**
     * 获取新闻详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/app/personal/news/detail/{id}")
    public JsonResult newsDetail(@PathVariable long id){
        return appService.getNewsDetail(id);
    }

    /**
     * 常见问题列表
     * @return
     */
    @RequestMapping(value = "/app/personal/problem/list")
    public JsonResult problemList(){
        return appService.getProblemList();
    }

    /**
     * 常见问题详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/app/personal/problem/detail/{id}")
    public JsonResult problemDetail(@PathVariable long id){
        return appService.getProblemDetail(id);
    }

    /**
     * 修改头像
     * @param imgStr
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/personal/headimg")
    public JsonResult headImg(String imgStr,HttpServletRequest request){
        String token = super.getToken(request);
        return appService.changeHeadImg(imgStr,token);
    }

    /**
     * 卖车请求
     * @param phone
     * @param cityId
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/personal/sale/{phone}/{cityId}")
    public JsonResult saleCar(@PathVariable long phone,
                              @PathVariable int cityId,
                              HttpServletRequest request){
        String token = super.getToken(request);
        return appService.saleCar(phone,cityId,token);
    }
}
