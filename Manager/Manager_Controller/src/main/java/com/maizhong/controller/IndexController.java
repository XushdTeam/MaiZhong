package com.maizhong.controller;

import com.maizhong.pojo.TbUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 主控制器
 * Created by Xushd on 2017/2/28.
 */
@Controller
public class IndexController extends GlobalController{


    @RequestMapping(value = "/")
    public String root(){
        return "index";
    }




    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String Index(Model model){
        TbUser user = super.getUserInfo();

        model.addAttribute("userName",user.getUserName());
        model.addAttribute("userAdvert",user.getUserAdvert());

        return "index";
    }
}
