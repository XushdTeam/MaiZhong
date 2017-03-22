package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.pojo.TbConsult;
import com.maizhong.service.ConsultService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-21
 * Time: 15:02
 */

@Controller
public class ConsultController {


    @Autowired
    private ConsultService consultService;

    /**
     * 用户咨询管理控制器
     * @param model
     * @return
     */
    //@RequiresPermissions("/member")
    @RequestMapping(value = "/consult", method = RequestMethod.GET)
    public String member(Model model) {
        model.addAttribute("baseUrl", "/consult");
        model.addAttribute("listUrl", "/consult/list");
        model.addAttribute("handleUrl", "/consult/handle");
        model.addAttribute("deleteUrl", "/consult/delete");
        return "member/consult";
    }


    /**
     * 获取咨询列表
     *
     * @param param
     * @return
     */
    @ControllerLog(module = "用户咨询", methods = "咨询列表")
    @RequestMapping(value = "/consult/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult consultList(PageSearchParam param) {
        PageResult result = consultService.getConsultList(param);
        return JsonResult.OK(result);
    }
    /**
     * 跳转到修改页面
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/consult/handle/{id}")
    public String handle(@PathVariable String id, Model model) {
        model.addAttribute("baseUrl", "/consult");
            TbConsult consult = consultService.getConsultById(Long.valueOf(id));
            model.addAttribute("consult", consult);
            model.addAttribute("saveUrl", "/consult/update");
            return "member/consult_setting";
        }

   // @RequiresPermissions("/consult/update")
    @ControllerLog(module = "客户咨询", methods = "咨询处理")
    @RequestMapping(value = "/consult/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult consultUpdate(TbConsult tbConsult) {
        OperateEnum result = consultService.updatConsult(tbConsult);
        return JsonResult.build(result);
    }

}



