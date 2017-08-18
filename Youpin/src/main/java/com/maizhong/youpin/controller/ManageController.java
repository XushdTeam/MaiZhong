package com.maizhong.youpin.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.youpin.pojo.ManagerUser;
import com.maizhong.youpin.service.ManageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-08-17
 * Time: 11:17
 */

@Controller
public class ManageController {

    @Autowired
    private ManageService manageService;

    /**
     * 后台首页
     * @param token
     * @param model
     * @return
     */
    @RequestMapping(value = "/manage")
    public String indexManage(@CookieValue(value = "m_token", required = false) String token, Model model) {
        if (StringUtils.isBlank(token)) {
            return "redirect:/manage/login";
        }
        JsonResult result = manageService.checkLoginStatus(token);
        if (result.getStatus() != 200) {
            return "redirect:/manage/login";
        }
        String sysMenuJson = manageService.getSystemMenu(token);
        model.addAttribute("menu", sysMenuJson);
        model.addAttribute("username", result.getMessage());

        return "manage/index";
    }



    /**
     * 跳转到登录页
     *
     * @return
     */
    @RequestMapping(value = "/manage/login")
    public String managelogin() {
        return "manage/login";
    }


    /**
     * 后台登录验证
     *
     * @param account
     * @param password
     * @param checked
     * @return
     */
    @RequestMapping(value = "/login/check")
    @ResponseBody
    public JsonResult loginCheck(String account, String password, boolean checked) {
        JsonResult result = manageService.loginCheck(account, password, checked);
        return result;
    }

    /**
     * 退出登录
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/logOff")
    @ResponseBody
    public JsonResult logOff(HttpServletRequest request) {
        String token = (String) request.getAttribute("token");
        JsonResult result = manageService.logOff(token);
        return result;
    }


/*用户*/


    /**
     * 系统用户
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/account")
    public String accountIndex(Model model, HttpServletRequest request) {
        String token = (String) request.getAttribute("token");
        String username = (String) request.getAttribute("username");

        String sysMenuJson = manageService.getSystemMenu(token);
        model.addAttribute("menu", sysMenuJson);
        model.addAttribute("cur", "/system/account");
        model.addAttribute("username", username);
        return "/manage/views/sys_account";
    }


    /**
     * 获取用户列表数据
     *
     * @return
     */
    @RequestMapping(value = "/system/account/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult accountList(PageSearchParam param) {
        JsonResult result = manageService.getSysAccountList(param);
        return result;
    }



    /**
     * 用户保存或更新
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/account/save")
    @ResponseBody
    public JsonResult accountSave(ManagerUser user, HttpServletRequest request) {
        String token = (String) request.getAttribute("token");
        JsonResult result = manageService.saveSysAccount(user, token);
        return result;
    }

    /**
     * 用户修改状态
     *
     * @param id
     * @param status
     * @return
     */
    @RequestMapping(value = "/system/account/status/{id}/{status}")
    @ResponseBody
    public JsonResult accountStatus(@PathVariable long id, @PathVariable int status) {
        JsonResult result = manageService.statusSysAccount(id, status);
        return result;
    }

    /**
     * 用户删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/system/account/del/{id}")
    @ResponseBody
    public JsonResult accountDelete(@PathVariable long id) {
        JsonResult result = manageService.delSysAccount(id);
        return result;
    }


    /**
     * 客户管理
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/user")
    public String companyIndex(Model model, HttpServletRequest request) {

        String token = (String) request.getAttribute("token");
        String username = (String) request.getAttribute("username");

        String sysMenuJson = manageService.getSystemMenu(token);
        model.addAttribute("menu", sysMenuJson);
        model.addAttribute("cur", "/system/user");
        model.addAttribute("username", username);
        return "/manage/views/sys_user";
    }

    /**
     * 获取客户列表数据
     *
     * @return
     */
    @RequestMapping(value = "/system/user/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult companyList(PageSearchParam param) {
        JsonResult result = manageService.getUserList(param);
        return result;
    }


    /**
     * 客户删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/system/user/del/{id}")
    @ResponseBody
    public JsonResult userDelete(@PathVariable long id) {
        JsonResult result = manageService.delUser(id);
        return result;
    }


    /*------------------------订单管理----------------------------*/


    /**
     * 订单
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/record")
    public String recordIndex(Model model, HttpServletRequest request) {
        String token = (String) request.getAttribute("token");
        String username = (String) request.getAttribute("username");

        String sysMenuJson = manageService.getSystemMenu(token);
        model.addAttribute("menu", sysMenuJson);
        model.addAttribute("cur", "/system/record");
        model.addAttribute("username", username);
        return "/manage/views/sys_record";
    }


    /**
     * 获取订单列表数据
     *
     * @return
     */
    @RequestMapping(value = "/system/record/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult recordList(PageSearchParam param) {
        JsonResult result = manageService.getRecordList(param);
        return result;
    }



    /**
     * 订单保存或更新
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/record/save")
    @ResponseBody
    public JsonResult recordSave(ManagerUser user, HttpServletRequest request) {
        String token = (String) request.getAttribute("token");
        JsonResult result = manageService.saveSysAccount(user, token);
        return result;
    }

    /**
     * 订单修改状态
     *
     * @param id
     * @param status
     * @return
     */
    @RequestMapping(value = "/system/record/status/{id}/{status}")
    @ResponseBody
    public JsonResult recordStatus(@PathVariable long id, @PathVariable int status) {
        JsonResult result = manageService.statusSysAccount(id, status);
        return result;
    }

    /**
     * 订单删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/system/record/del/{id}")
    @ResponseBody
    public JsonResult recordDelete(@PathVariable long id) {
        JsonResult result = manageService.delSysAccount(id);
        return result;
    }
























}
