package com.maizhong.portal.controller;

import com.maizhong.common.dto.IndexBaseDTO;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.pojo.TbFeedback;
import com.maizhong.portal.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
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
    public String index(Model model) {

        Map<String,Object> map =  indexService.getIndexBase();
        model.addAttribute("ggList", JsonUtils.objectToJson(map.get("ggDTOs")));
        model.addAttribute("cbList", map.get("carBrand"));
        model.addAttribute("ctList", map.get("carType"));
        return "index";
    }

    /**
     * 关于我们
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/about")
    public String about(Model model) {
        model.addAttribute("title", "关于我们");
        model.addAttribute("tab", 0);
        return "public";
    }

    /**
     * 加入我们
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/joinus")
    public String joinus(Model model) {
        model.addAttribute("title", "加入我们");
        model.addAttribute("tab", 2);
        return "public";
    }

    /**
     * 加入我们
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/help")
    public String help(Model model) {
        model.addAttribute("title", "帮助中心");
        model.addAttribute("tab", 1);
        return "public";
    }

    /**
     * 反馈
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/feedback")
    public String feedback(Model model) {
        model.addAttribute("title", "用户反馈");
        model.addAttribute("tab", 3);
        return "public";
    }

    @RequestMapping(value = "/sale")
    public String sale(Model model) {
        return "sale";
    }

    /**
     * 用户反馈
     * @param feedback
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value = "/feedback/post")
    public String feedbackForm(@Valid TbFeedback feedback, BindingResult result, Model model) {
        model.addAttribute("title", "用户反馈");
        model.addAttribute("tab", 4);
        if(result.hasErrors()){

            List<ObjectError> allErrors = result.getAllErrors();
            String error = "";
            for (ObjectError allError : allErrors) {
                error+= allError.getDefaultMessage()+"<br/>";
            }
            model.addAttribute("res",error);
        }else{
           if(this.indexService.saveFeedback(feedback)){
               model.addAttribute("res","我们已经收到您的反馈，非常感谢！");
           }
            model.addAttribute("res","信号被风吹走了");
        }
        return "public";
    }

    /**
     * 新闻
     * @param newsId
     * @return
     */
    @RequestMapping(value = "/news.html")
    public String news(Long newsId){
        return "news";
    }



}
