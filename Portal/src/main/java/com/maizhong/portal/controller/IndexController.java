package com.maizhong.portal.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.portal.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 商城首页
 * Created by Xushd on 2017/3/3.
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/index")
    public String index(Model model){

        String adJson = indexService.getAdvert(14);
        List<Map> cbList = indexService.getCarBrand();
        List<Map> ctList = indexService.getCarType();
        model.addAttribute("adJson", adJson);
        model.addAttribute("cbList", cbList);
        model.addAttribute("ctList", ctList);
        return "index";
    }

    /**
     * 关于我们
     * @param model
     * @return
     */
    @RequestMapping(value = "/about")
    public String about(Model model){
        model.addAttribute("title","关于我们");
        model.addAttribute("tab",0);
        return "public";
    }

    /**
     * 加入我们
     * @param model
     * @return
     */
    @RequestMapping(value = "/joinus")
    public String joinus(Model model){
        model.addAttribute("title","加入我们");
        model.addAttribute("tab",2);
        return "public";
    }
    /**
     * 加入我们
     * @param model
     * @return
     */
    @RequestMapping(value = "/help")
    public String help(Model model){
        model.addAttribute("title","帮助中心");
        model.addAttribute("tab",1);
        return "public";
    }
     /**
     * 反馈
     * @param model
     * @return
     */
    @RequestMapping(value = "/feedback")
    public String feedback(Model model){
        model.addAttribute("title","用户反馈");
        model.addAttribute("tab",3);
        return "public";
    }

    @RequestMapping(value = "/sale")
    public String sale(Model model){
        return "sale";
    }

    /**
     * 用户反馈
     * @param c
     * @param p
     * @param n
     * @param r
     * @return
     */
    @RequestMapping(value = "/feedback/post")
    public JsonResult feedbackForm(String c,String p,String n,String r){
        this.indexService.saveFeedback(c,p,n,r);
        return JsonResult.OK();
    }
}
