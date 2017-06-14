package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.pojo.User;
import com.maizhong.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户Controller
 * Created by Wang on 2017/6/8.
 */
@Controller
public class CustomerController{

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer",method = RequestMethod.GET)
    public String user(Model model){

        model.addAttribute("baseUrl","/customer");
        model.addAttribute("listUrl","/customer/list");
        model.addAttribute("handleUrl","/customer/handle");
        model.addAttribute("deleteUrl","/customer/delete");

        return "customer/customer";
    }


    @ControllerLog(module = "客户管理",methods = "客户列表")
    @RequestMapping(value = "/customer/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userList(PageSearchParam param){
        PageResult result = customerService.getUserList(param);
        return JsonResult.OK(result);
    }


    @RequestMapping(value = "/customer/handle/{id}")
    public String handle(@PathVariable String id, Model model){

        model.addAttribute("baseUrl","/customer");
        if(StringUtils.equals("new",id)){
            //新增
         /*   model.addAttribute("handle","用户管理/用户注册");
            model.addAttribute("saveUrl","/user/save");*/
            return "customer/customer";
        }else {
            //修改
            User user = customerService.getUserById(Long.valueOf(id));
            model.addAttribute("user",user);
            model.addAttribute("handle", "用户管理/用户修改");
            model.addAttribute("saveUrl","/customer/update");
            return "customer/customer_setting";
        }

    }


    @ControllerLog(module = "客户管理",methods = "客户息修改")
    @RequestMapping(value = "/customer/update",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userUpdate(User user){
        OperateEnum result = customerService.updateUser(user);
        return JsonResult.build(result);
    }


    @ControllerLog(module = "客户管理",methods = "删除客户")
    @RequestMapping(value = "/customer/delete/{userId}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userDelete(@PathVariable long userId){

        OperateEnum result = customerService.deleteUserById(userId);
        return JsonResult.build(result);
    }

}
