package com.maizhong.controller;

import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.pojo.TbPermission;
import com.maizhong.service.PermissionService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * 权限Controller
 * Created by Xushd on 2017/3/2.
 */
@Controller
public class PermissionController extends GlobalController{


    @Autowired
    private PermissionService permissionService;


    /**
     * 跳转
     * @return
     */
    @RequiresPermissions("/permission")
    @RequestMapping(value = "/permission",method = RequestMethod.GET)
    public String permission(Model model){

        model.addAttribute("baseUrl","/permission");
        model.addAttribute("listUrl","/permission/list");
        model.addAttribute("handleUrl","/permission/handle");
        model.addAttribute("deleteUrl","/permission/delete");

        return "system/permission";
    }


    /**
     * ajax 获取权限LIST
     * @return
     */
    @ControllerLog(module = "权限管理",methods = "权限列表")
    @RequestMapping(value = "/permission/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult permissionList(){


        List<TbPermission> list = permissionService.getPermissionList(false);
        return JsonResult.OK(list);
    }

    /**
     * 新增修改跳转 id=null 新增 id!=null 修改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/permission/handle/{id}")
    public String handle(@PathVariable String id, Model model){
        String resultView = "system/permission_a_e";

        if(StringUtils.equals("null",id)){
            //新增
            model.addAttribute("handle","新增权限");
            model.addAttribute("saveUrl","/permission/save");
        }else{
            //修改
            TbPermission permission = permissionService.getPermissionById(Long.parseLong(id));
            model.addAttribute("handle","修改权限");
            model.addAttribute("permission",permission);
            model.addAttribute("saveUrl","/permission/update");
        }
        //获取父级
        List<TbPermission> permissionList = permissionService.getPermissionList(true);
        model.addAttribute("list",permissionList);
        model.addAttribute("baseUrl","/permission");
        return resultView;
    }

    /**
     * 权限新增
     * @param permission
     * @param result
     * @return
     */
    @RequiresPermissions("/permission/save")
    @ControllerLog(module = "权限管理",methods = "权限新增")
    @RequestMapping(value = "/permission/save",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult permissionSave(@Valid TbPermission permission, BindingResult result){
        //验证有错误
        if(result.hasErrors()){
            String error = "";
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError allError : allErrors) {
                error+= allError.getDefaultMessage();
            }
            return JsonResult.Error(error);
        } else{
            permission.setCreateUser(super.getUserInfo().getUserName());
            permission.setCreateTime(new Date());
            OperateEnum res = permissionService.insertPermission(permission);
            return JsonResult.build(res);
        }
    }

    /**
     * 权限修改
     * @param permission
     * @param result
     * @return
     */
    @RequiresPermissions("/permission/update")
    @ControllerLog(module = "权限管理",methods = "权限修改")
    @RequestMapping(value = "/permission/update",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult permissionUpdate(@Valid TbPermission permission,BindingResult result){
        //验证有错误
        if(result.hasErrors()){
            String error = "";
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError allError : allErrors) {
                error+= allError.getDefaultMessage();
            }
            return JsonResult.Error(error);
        }else{
            OperateEnum res = permissionService.updatePermission(permission);
            return JsonResult.build(res);
        }

    }

    @RequiresPermissions("/permission/delete")
    @ControllerLog(module = "权限管理",methods = "权限删除")
    @RequestMapping(value = "/permission/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult permissionDelete(@PathVariable String id){
        OperateEnum res = permissionService.deletePermission(Long.parseLong(id));
        return JsonResult.build(res);

    }







}
