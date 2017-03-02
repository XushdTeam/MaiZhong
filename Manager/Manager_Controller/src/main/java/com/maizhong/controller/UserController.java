package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.pojo.TbRole;
import com.maizhong.pojo.TbUser;
import com.maizhong.service.FileUploadService;
import com.maizhong.service.RoleService;
import com.maizhong.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * 用户Controller
 * Created by Xushd on 2017/3/2.
 */
@Controller
public class UserController extends GlobalController{

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private FileUploadService fileUploadService;

    @RequiresPermissions("/user")
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String user(Model model){

        model.addAttribute("baseUrl","/user");
        model.addAttribute("listUrl","/user/list");
        model.addAttribute("handleUrl","/user/handle");
        model.addAttribute("deleteUrl","/user/delete");

        return "system/user";
    }


    @ControllerLog(module = "用户管理",methods = "用户列表")
    @RequestMapping(value = "/user/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userList(PageSearchParam param){
        PageResult result = userService.getUserList(param);
        return JsonResult.OK(result);
    }


    @RequestMapping(value = "/user/handle/{id}")
    public String handle(@PathVariable String id, Model model){

        model.addAttribute("baseUrl","/user");
        if(StringUtils.equals("new",id)){
            //新增
            model.addAttribute("handle","用户管理/用户注册");
            model.addAttribute("saveUrl","/user/save");
            return "system/user_register";
        }else {
            //修改
            TbUser user = userService.getUserById(Long.valueOf(id));
            List<TbRole> roleList = roleService.getRoleListByUserIdAll(Long.valueOf(id));
            model.addAttribute("user",user);
            model.addAttribute("roleList",roleList);
            model.addAttribute("handle", "用户管理/用户修改");
            model.addAttribute("saveUrl","/user/update");
            model.addAttribute("uploadUrl","/user/"+user.getId()+"/advert/upload");
            model.addAttribute("passUpdateUrl","/user/"+user.getId()+"/pass/update");
            model.addAttribute("roleUpdateUrl","/user/"+user.getId()+"/role/update");

            return "system/user_setting";
        }

    }

    @RequiresPermissions("/user/save")
    @ControllerLog(module = "用户管理",methods = "用户新增")
    @RequestMapping(value = "/user/save",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userSave(TbUser user){
        user.setUserAdvert("/resources/images/person.jpg");
        user.setCreateUser(super.getUserInfo().getUserName());
        user.setCreateTime(new Date());
        OperateEnum res = userService.insertUser(user);
        return JsonResult.build(res);
    }

    @RequiresPermissions("/user/update")
    @ControllerLog(module = "用户管理",methods = "用户信息修改")
    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userUpdate(TbUser user){

        OperateEnum result = userService.updateUser(user);
        return JsonResult.build(result);
    }

    @RequiresPermissions("/user/advert")
    @ControllerLog(module = "用户管理",methods = "用户头像修改")
    @RequestMapping(value = "/user/{userId}/advert/upload",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userAdvertUpload(@RequestParam(value = "advert", required = false) MultipartFile filedata, @PathVariable String userId){

        JsonResult jsonResult = fileUploadService.uploadImg(filedata);
        if(jsonResult.getStatus()==200){

            int res = userService.updateUserAdvert(jsonResult.getData().toString(),Long.parseLong(userId));
            if(res>0){
                return jsonResult;
            }else{
                return JsonResult.Error(OperateEnum.FAILE);
            }

        }else{
            return jsonResult;
        }


    }

    @RequiresPermissions("/user/pass")
    @ControllerLog(module = "用户管理",methods = "用户密码修改")
    @RequestMapping(value = "/user/{id}/pass/update",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userPassUpdate(String pass0,String pass1,String pass2,@PathVariable String id){

        String pass =  super.getUserInfo().getPassword();

        JsonResult result = userService.userPassUpdate(pass,pass0,pass1,pass2, Long.parseLong(id));

        return result;
    }

    @RequiresPermissions("/user/role")
    @ControllerLog(module = "用户管理",methods = "修改用户角色")
    @RequestMapping(value = "/user/{userId}/role/update",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userRoleUpdate(@RequestParam(value = "role[]",required = false)List role, @PathVariable long userId){
        OperateEnum result = userService.updateUserRole(role,userId);
        return JsonResult.build(result);
    }


    @RequiresPermissions("/user/delete")
    @ControllerLog(module = "用户管理",methods = "删除用户")
    @RequestMapping(value = "/user/delete/{userId}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userDelete(@PathVariable long userId){
        if (userId==super.getUserInfo().getId()){
            return JsonResult.build(OperateEnum.SB);
        }
        OperateEnum result = userService.deleteUserById(userId);
        return JsonResult.build(result);
    }


}
