package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-15
 * Time: 10:09
 */

@Controller
public class MemberController {
    @Autowired
   private MemberService memberService;


    //@RequiresPermissions("/member")
    @RequestMapping(value = "/member", method = RequestMethod.GET)
    public String member(Model model) {
        model.addAttribute("baseUrl", "/member");
        model.addAttribute("listUrl", "/member/list");
        model.addAttribute("handleUrl", "/member/handle");
        model.addAttribute("deleteUrl", "/member/delete");
        return "member/member";
    }



    /**
     * 获取会员列表
     * @param param
     * @return
     */
    @ControllerLog(module = "会员管理",methods = "会员列表")
    @RequestMapping(value = "/member/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userList(PageSearchParam param){
       PageResult result = memberService.getMemberList(param);
        return JsonResult.OK(result);
    }


}
