package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:用户反馈控制器
 * User: 王存浩
 * Date: 2017-03-20
 * Time: 14:19
 */

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;


    //@RequiresPermissions("/member")
    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public String member(Model model) {
        model.addAttribute("baseUrl", "/feedback");
        model.addAttribute("listUrl", "/feedback/list");
        model.addAttribute("handleUrl", "/feedback/handle");
        model.addAttribute("deleteUrl", "/feedback/delete");
        return "member/feedback";
    }


    /**
     * 获取反馈列表
     * @param param
     * @return
     */
    @ControllerLog(module = "用户反馈",methods = "反馈列表")
    @RequestMapping(value = "/feedback/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userList(PageSearchParam param){
        PageResult result = feedbackService.getFeedBackList(param);
        return JsonResult.OK(result);
    }




}
