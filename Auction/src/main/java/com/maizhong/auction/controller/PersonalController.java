package com.maizhong.auction.controller;

import com.alibaba.fastjson.JSON;
import com.maizhong.auction.dto.CarInfoDto;
import com.maizhong.auction.pojo.AcUser;
import com.maizhong.auction.service.ImgUploadService;
import com.maizhong.auction.service.IndexService;
import com.maizhong.auction.service.PersonalService;
import com.maizhong.common.result.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Xushd on 2017/6/7.
 */
@Controller
public class PersonalController {

    @Autowired
    private PersonalService personalService;
    @Autowired
    private IndexService indexService;
    @Autowired
    private ImgUploadService imgUploadService;


    /**
     * 成交列表
     * @param token
     * @param model
     * @return
     */
    @RequestMapping(value = "/personal/deallist")
    private String dealList(@CookieValue(value = "token",required = false)String token,Model model){

        if(StringUtils.isBlank(token)){
            return "redirect:/user/login";
        }
        AcUser user =  indexService.getUserInfo(token);
        if(user!=null){
            model.addAttribute("username",user.getName());
        }else{
            return "redirect:/user/login";
        }

        List<CarInfoDto> list = personalService.getOrderDealOK(token);
        model.addAttribute("list",list);

        model.addAttribute("cur",1);
        return "list_deal";
    }

    /**
     * 全部订单
     * @param token
     * @param model
     * @return
     */
    @RequestMapping(value = "/personal/orderlist")
    public String orderList(@CookieValue(value = "token",required = false)String token,Model model){
        if(StringUtils.isBlank(token)){
            return "redirect:/user/login";
        }
        AcUser user =  indexService.getUserInfo(token);
        if(user!=null){
            model.addAttribute("username",user.getName());
        }else{
            return "redirect:/user/login";
        }

        List<CarInfoDto> list = personalService.getOrderList(token);
        model.addAttribute("list",list);

        model.addAttribute("cur",2);

        return "list_order";
    }

    /**
     * 出价车辆
     * @return
     */
    @RequestMapping(value = "/personal/bidlist")
    public String bidList(@CookieValue(value = "token",required = false)String token,Model model){
        if(StringUtils.isBlank(token)){
            return "redirect:/user/login";
        }
        AcUser user =  indexService.getUserInfo(token);
        if(user!=null){
            model.addAttribute("username",user.getName());
        }else{
            return "redirect:/user/login";
        }

        List<CarInfoDto> list = personalService.getBidRecordList(token);
        model.addAttribute("list",list);

        model.addAttribute("cur",3);
        return "list_bid";
    }




    /**
     * 关注车辆列表
     * @param token
     * @param model
     * @return
     */
    @RequestMapping(value = "/personal/likelist")
    public String likeList(@CookieValue(value = "token",required = false)String token,Model model){
        if(StringUtils.isBlank(token)){
            return "redirect:/user/login";
        }
        AcUser user =  indexService.getUserInfo(token);
        if(user!=null){
            model.addAttribute("username",user.getName());
        }else{
            return "redirect:/user/login";
        }

        List<CarInfoDto> list = personalService.getLikeCarList(token);
        model.addAttribute("list",list);

        model.addAttribute("cur",4);

        return "list_like";
    }


    /**
     * 个人中心
     * @return
     */
    @RequestMapping(value = "/personal/baseinfo")
    public String personalBaseInfo(@CookieValue(value = "token",required = false)String token,Model model){
        if(StringUtils.isBlank(token)){
            return "redirect:/user/login";
        }
        AcUser user =  indexService.getUserInfo(token);
        if(user!=null){
            model.addAttribute("userInfo",user);
            model.addAttribute("username",user.getName());
            model.addAttribute("cur",5);
        }else{
            return "redirect:/user/login";
        }
        return "baseinfo";
    }


    /**
     * 修改所在城市
     * @param city
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/persional/change/city")
    @ResponseBody
    public JsonResult changeCity(String city,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        if(StringUtils.isNotBlank(token) && !StringUtils.equals(token,"null")){
            return personalService.changeCity(city,token);
        }else{
            return JsonResult.Error("当前账户未登录");
        }
    }

    /**
     * 图片上传
     * @param file
     * @return
     */
    @RequestMapping(value = "/personal/img/upload")
    @ResponseBody
    public JsonResult checkBaseImgUpload(@RequestParam(value = "file") MultipartFile file){
        JsonResult result = imgUploadService.uploadImgFile(file,"pickup/");
        return result;
    }

    /**
     * 实名认证提交
     * @param name
     * @param idNum
     * @param img1
     * @param img2
     * @param img3
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/personal/rz/submit")
    @ResponseBody
    public JsonResult smrzSubmit(String name,
                                 String idNum,
                                 String img1,
                                 String img2,
                                 String img3,
                                 HttpServletRequest request){
        String token = (String)request.getAttribute("token");
        return personalService.smrzSubmit(name,idNum,img1,img2,img3,token);
    }

    /**
     * 头像修改
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/personal/headImg")
    @ResponseBody
    public JsonResult changeHeadImg(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        if(StringUtils.isBlank(token)||StringUtils.equals(token,"null"))return JsonResult.Error("用户未登录");
        JsonResult result = imgUploadService.uploadImgFile(file, "headimg/");
        if(result.getStatus()==200){
            return personalService.changeHeadImg(result.getData().toString(),token);
        }else{
            return result;
        }

    }

    /**
     * 充值记录
     * @param token
     * @param model
     * @return
     */
    @RequestMapping(value = "/personal/recharge")
    public String rechargeRecord(@CookieValue(value = "token",required = false)String token,Model model){
        if(StringUtils.isBlank(token)){
            return "redirect:/user/login";
        }
        AcUser user =  indexService.getUserInfo(token);
        if(user!=null){
            model.addAttribute("userInfo",user);
            model.addAttribute("username",user.getName());
            model.addAttribute("cur",6);
        }else{
            return "redirect:/user/login";
        }
        return "list_recharge";
    }

    /**
     * 获取充值记录
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/recharge/list")
    @ResponseBody
    public JsonResult rechargeList(HttpServletRequest request){
        String token = (String )request.getAttribute("token");
        return personalService.getRechargeList(token);
    }


    /**
     * 帐号安全
     * @param token
     * @param model
     * @return
     */
    @RequestMapping(value = "/personal/account/safe")
    public String accountSafe(@CookieValue(value = "token",required = false)String token,Model model){
        if(StringUtils.isBlank(token)){
            return "redirect:/user/login";
        }
        AcUser user =  indexService.getUserInfo(token);
        if(user!=null){
            model.addAttribute("userInfo",user);
            model.addAttribute("username",user.getName());
            model.addAttribute("cur",7);
        }else{
            return "redirect:/user/login";
        }
        return "account_safe";
    }


    /**
     * 修改密码发送短信
     * @param phone
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/send/sms/{phone}")
    @ResponseBody
    public JsonResult sendSMS(@PathVariable String phone , HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        return personalService.sendSMS(phone,token);
    }

    /**
     * 修改密码
     * @param verifyCode
     * @param pass
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/change/pass")
    @ResponseBody
    public JsonResult changPass(String verifyCode,String pass,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        return personalService.changePass(verifyCode,pass,token);
    }

    /**
     * 投诉建议
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/personal/myyijian")
    public String tousu(HttpServletRequest request,Model model){
        String token = (String) request.getAttribute("token");
        if(StringUtils.isNotBlank(token)){
            AcUser user =  indexService.getUserInfo(token);
            if(user!=null){
                model.addAttribute("username",user.getName());
                model.addAttribute("userInfo",user);
            }
            return "myyijian";
        }else{
            return "login";
        }
    }


    /**
     * 修改密码
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/personal/changePass")
    public String changePass(HttpServletRequest request,Model model){
        String token = (String) request.getAttribute("token");
        if(StringUtils.isNotBlank(token)){
            AcUser user =  indexService.getUserInfo(token);
            if(user!=null){
                model.addAttribute("username",user.getName());
                model.addAttribute("userInfo",user);
            }
            return "mypass";
        }else{
            return "login";
        }
    }





    /**
     * 个人信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/personalInfo")
    @ResponseBody
    public JsonResult personalInfo(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        if(StringUtils.equals("null",token)){
            return JsonResult.build(500,"no login","login");
        }
        return personalService.getPersonalInfo(token);
    }

}
