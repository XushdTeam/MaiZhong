package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.dto.PermissionResult;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.pojo.TbRole;
import com.maizhong.service.PermissionService;
import com.maizhong.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * 角色控制器
 * Created by Xushd on 2017/3/2.
 */
@Controller
public class RoleController extends GlobalController{

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;


    @RequiresPermissions("/role")
    @RequestMapping(value = "/role",method = RequestMethod.GET)
    public String role(Model model){

        model.addAttribute("baseUrl","/role");
        model.addAttribute("listUrl","/role/list");
        model.addAttribute("handleUrl","/role/handle");
        model.addAttribute("deleteUrl","/role/delete");
        model.addAttribute("permissionUrl","/role/permission");


        return "/system/role";
    }

    @ControllerLog(module = "角色管理",methods = "角色列表")
    @RequestMapping(value = "/role/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult roleList(PageSearchParam param){
        PageResult result = roleService.roleList(param);
        return JsonResult.OK(result);
    }


    @ControllerLog(module = "角色管理",methods = "角色权限获取")
    @RequestMapping(value = "/role/permission/{id}",method = RequestMethod.GET)
    public String rolePermission(@PathVariable String id, Model model){

        //角色分配
        model.addAttribute("handle","角色管理/权限分配");
        model.addAttribute("saveUrl","/role/permission/save");
        model.addAttribute("baseUrl","/role");
        model.addAttribute("roleId",id);
        List<PermissionResult> roleList = permissionService.getRolePermission(Long.valueOf(id));
        model.addAttribute("list",roleList);
        return "/system/role_p";
    }

    @RequiresPermissions("/role/permission")
    @ControllerLog(module = "角色管理",methods = "角色权限分配")
    @RequestMapping(value = "/role/permission/save",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult rolePermission(@RequestParam(value = "permission[]",required = false)List permission, long roleId){
        OperateEnum result = roleService.updateRolePermission(permission,roleId);
        return JsonResult.build(result);
    }

    /**
     * 菜单新增修改跳转
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/role/handle/{id}")
    public String handle(@PathVariable String id, Model model){
        String resultView = "system/role_a_e";

        model.addAttribute("baseUrl","/role");
        if(StringUtils.equals("null",id)){
            //新增
            model.addAttribute("handle","角色管理/角色新增");
            model.addAttribute("saveUrl","/role/save");
        }else {
            //修改
            TbRole role = roleService.getRoleById(Long.valueOf(id));
            model.addAttribute("role",role);
            model.addAttribute("handle", "角色管理/角色修改");
            model.addAttribute("saveUrl","/role/update");
        }
        return resultView;
    }

    @RequiresPermissions("/role/save")
    @ControllerLog(module = "角色管理",methods = "角色新增")
    @RequestMapping(value = "/role/save",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult save(@Valid TbRole role, BindingResult result){

        if (result.hasErrors()){
            String error = "";
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError allError : allErrors) {
                error+= allError.getDefaultMessage();
            }
            return JsonResult.Error(error);
        }else {
            role.setCreateUser(super.getUserInfo().getUserName());
            role.setCreateTime(new Date());
            OperateEnum res = roleService.insertRole(role);
            return JsonResult.build(res);
        }
    }

    @RequiresPermissions("/role/update")
    @ControllerLog(module = "角色管理",methods = "角色修改")
    @RequestMapping(value = "/role/update",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(@Valid TbRole role, BindingResult result){
        if (result.hasErrors()){
            String error = "";
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError allError : allErrors) {
                error+= allError.getDefaultMessage();
            }
            return JsonResult.Error(error);
        }else {
            OperateEnum res = roleService.update(role);
            return JsonResult.build(res);
        }
    }

    @RequiresPermissions("/role/delete")
    @ControllerLog(module = "角色管理",methods = "角色删除")
    @RequestMapping(value = "/role/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable String id){

        OperateEnum result = roleService.deleteRoleById(Long.valueOf(id));
        return JsonResult.build(result);
    }
}
