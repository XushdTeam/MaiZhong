package com.maizhong.auction.controller;

import com.maizhong.auction.dto.CarInfoDto;
import com.maizhong.auction.pojo.AcUser;
import com.maizhong.auction.service.IndexService;
import com.maizhong.auction.service.PersonalService;
import com.maizhong.common.result.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return "deal_list";
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
