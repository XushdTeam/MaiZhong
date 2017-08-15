package com.maizhong.auction.controller;

import com.maizhong.auction.pojo.AcUser;
import com.maizhong.auction.service.IndexService;
import com.maizhong.auction.service.PersonalService;
import com.maizhong.common.result.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Xushd on 2017/6/7.
 */
@Controller
public class PersonalController {

    @Autowired
    private PersonalService personalService;
    @Autowired
    private IndexService indexService;


    /**
     * 成交确认
     * @param request
     * @return
     */
    @RequestMapping(value = "/orderDealOK")
    @ResponseBody
    public JsonResult orderDealOK(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        if(StringUtils.equals("null",token)){
            return JsonResult.build(500,"no login","login");
        }
        return personalService.getOrderDealOK(token);
    }


    /**
     * 我的确认列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/personal/mylist")
    public String mylist(HttpServletRequest request,Model model){
        String token = (String) request.getAttribute("token");
        if(StringUtils.isNotBlank(token)){
            AcUser user =  indexService.getUserInfo(token);
            if(user!=null){
                model.addAttribute("username",user.getName());
                model.addAttribute("userInfo",user);
                model.addAttribute("from",1);
                model.addAttribute("title","成交确认");
            }
            return "mylist";
        }else{
            return "login";
        }
    }





    /**
     * 订单车辆
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/personal/orderList")
    public String order(HttpServletRequest request,Model model){
        String token = (String) request.getAttribute("token");
        if(StringUtils.isNotBlank(token)){
            AcUser user =  indexService.getUserInfo(token);
            if(user!=null){
                model.addAttribute("username",user.getName());
                model.addAttribute("userInfo",user);
                model.addAttribute("from",2);
                model.addAttribute("title","订单车辆");
            }
            return "mylist";
        }else{
            return "login";
        }
    }


    /**
     * 我的确认列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/personal/bidRecordList")
    public String history(HttpServletRequest request,Model model){
        String token = (String) request.getAttribute("token");
        if(StringUtils.isNotBlank(token)){
            AcUser user =  indexService.getUserInfo(token);
            if(user!=null){
                model.addAttribute("username",user.getName());
                model.addAttribute("userInfo",user);
                model.addAttribute("from",3);
                model.addAttribute("title","历史订单");
            }
            return "mylist";
        }else{
            return "login";
        }
    }

    /**
     * 我喜欢的列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/personal/likeCarList")
    public String like(HttpServletRequest request,Model model){
        String token = (String) request.getAttribute("token");
        if(StringUtils.isNotBlank(token)){
            AcUser user =  indexService.getUserInfo(token);
            if(user!=null){
                model.addAttribute("username",user.getName());
                model.addAttribute("userInfo",user);
                model.addAttribute("from",4);
                model.addAttribute("title","关注车辆");
            }
            return "mylist";
        }else{
            return "login";
        }
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
     * 个人列表跳转
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/mylist")
    @ResponseBody
    public JsonResult mylist2(HttpServletRequest request,Model model){
        String token = (String) request.getAttribute("token");
        if(StringUtils.equals("null",token)){
            return JsonResult.build(500,"no login","login");
        }
        return personalService.getOrderList(token);
    }




    /**
     * 订单车辆
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/orderList")
    @ResponseBody
    public JsonResult getOrderList(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        if(StringUtils.equals("null",token)){
            return JsonResult.build(500,"no login","login");
        }
        return personalService.getOrderList(token);
    }


    /**
     * 历史竞价
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/bidRecordList")
    @ResponseBody
    public JsonResult bidRecordList(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        if(StringUtils.equals("null",token)){
            return JsonResult.build(500,"no login","login");
        }
        return personalService.getBidRecordList(token);
    }




    /**
     * 关注车辆
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/likeCarList")
    @ResponseBody
    public JsonResult likeCarList(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        if(StringUtils.equals("null",token)){
            return JsonResult.build(500,"no login","login");
        }
        return personalService.getLikeCarList(token);
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
