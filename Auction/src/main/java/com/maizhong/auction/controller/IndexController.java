package com.maizhong.auction.controller;

import com.maizhong.auction.service.IndexService;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Xushd on 2017/6/7.
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/")
    public String index(@CookieValue(value = "token",required = false) String token,Model model){
        if(StringUtils.isBlank(token)){
            return "redirect:/login";
        }
        JsonResult result = indexService.checkLoginStatus(token);
        if(result.getStatus()!=200){
            return "redirect:/login";
        }
        String sysMenuJson = indexService.getSystemMenu(token);
        model.addAttribute("menu",sysMenuJson);
        model.addAttribute("username",result.getMessage());

        return "index";
    }


    /**
     * 跳转到登录页
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }


    /**
     * 后台登录验证
     * @param account
     * @param password
     * @param checked
     * @return
     */
    @RequestMapping(value = "/login/check")
    @ResponseBody
    public JsonResult loginCheck(String account,String password,boolean checked){
        JsonResult result = indexService.loginCheck(account,password,checked);
        return result;
    }



}
