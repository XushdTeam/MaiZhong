package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.pojo.TbLog;
import com.maizhong.service.LogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 日志控制器
 * Created by Xushd on 2017/3/2.
 */
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 运行日志跳转
     * @param model
     * @return
     */
    @RequiresPermissions("/log/run")
    @RequestMapping(value = "/log/run",method = RequestMethod.GET)
    public String runLog(Model model){

        model.addAttribute("baseUrl","/log/run");
        model.addAttribute("listUrl","/log/run/list");
        model.addAttribute("deleteUrl","/log/run/delete");

        return "/system/logrunning";
    }

    /**
     * 错误日志跳转
     * @param model
     * @return
     */
    @RequiresPermissions("/log/error")
    @RequestMapping(value = "/log/error",method = RequestMethod.GET)
    public String errorLog(Model model){

        model.addAttribute("baseUrl","/log/error");
        model.addAttribute("listUrl","/log/error/list");
        model.addAttribute("deleteUrl","/log/error/delete");
        model.addAttribute("handleUrl","/log/error/detail");

        return "/system/logerror";
    }


    /**
     * 获取运行日志LIST
     * @param param
     * @return
     */
    @RequestMapping(value = "/log/run/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult logRunList(PageSearchParam param){

        PageResult result = logService.getLogRunList(param,0);

        return JsonResult.OK(result);
    }

    /**
     * 获取错误日志LIST
     * @param param
     * @return
     */
    @RequestMapping(value = "/log/error/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult logErrorList(PageSearchParam param){

        PageResult result = logService.getLogRunList(param,1);

        return JsonResult.OK(result);
    }

    @RequiresPermissions("/log/run/delete")
    @ControllerLog(module = "日志管理",methods = "删除7天之前运行日志")
    @RequestMapping(value = "/log/run/delete",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult logRunDelete(){
        if (logService.logRunDel(0)){
            return JsonResult.build(OperateEnum.SUCCESS);
        }else {
            return JsonResult.build(OperateEnum.FAILE);
        }

    }

    @RequiresPermissions("/log/error/delete")
    @ControllerLog(module = "日志管理",methods = "删除7天之前错误日志")
    @RequestMapping(value = "/log/error/delete",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult logErrorDelete(){

        if (logService.logRunDel(1)){
            return JsonResult.build(OperateEnum.SUCCESS);
        }else {
            return JsonResult.build(OperateEnum.FAILE);
        }

    }
    @ControllerLog(module = "日志管理",methods = "异常日志详情")
    @RequestMapping(value = "/log/error/detail/{id}")
    public String logErrorDetail(@PathVariable int id, Model model){
        TbLog log = logService.getLogById(id);
        model.addAttribute("log",log);
        model.addAttribute("baseUrl","/log/error");
        return "system/logerror_d";
    }


}
