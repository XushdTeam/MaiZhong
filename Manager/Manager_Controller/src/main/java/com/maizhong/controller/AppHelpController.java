package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.pojo.Help;
import com.maizhong.pojo.TbCarType;
import com.maizhong.service.AppHelpService;
import com.maizhong.service.TypeService;
import com.maizhong.service.FileUploadService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Description:汽车类别控制器
 * User: 王存浩
 * Date: 2017-03-06
 * Time: 10:56
 */

@Controller
public class AppHelpController {

    @Autowired
    private AppHelpService appHelpService;

    /*@RequiresPermissions("/help")*/
    @RequestMapping(value = "/app/help", method = RequestMethod.GET)
    public String carType(Model model) {
        model.addAttribute("baseUrl", "/app/help");
        model.addAttribute("listUrl", "/help/list");
        model.addAttribute("handleUrl", "/help/handle");
        model.addAttribute("deleteUrl", "/help/delete");
        return "app/help";
    }

    /**
     * APP帮助
     *
     * @param param
     * @return
     */
    @ControllerLog(module = "APP帮助", methods = "帮助列表")
    @RequestMapping(value = "/help/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult typeList(PageSearchParam param) {
        PageResult result = appHelpService.getHelpList(param);
        return JsonResult.OK(result);
    }

    /**
     * 帮助新增和修改
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/help/handle/{id}")
    public String handle(@PathVariable String id, Model model) {

        model.addAttribute("baseUrl", "/app/help");
        if (StringUtils.equals("new", id)) {
            //新增
            model.addAttribute("handle", "帮助管理/帮助新增");
            model.addAttribute("saveUrl", "/help/save");
            return "app/help_add";
        } else {
           Help help= appHelpService.getHelpById(Long.valueOf(id));
            model.addAttribute("help", help);
            model.addAttribute("handle", "帮助管理/帮助修改");
            model.addAttribute("saveUrl", "/help/update");
            return "app/help_setting";
        }
    }

    /**
     * 帮助管理--新增
     * @param help
     * @return
     */
   /* @RequiresPermissions("/type/save")*/
    @ControllerLog(module = "帮助管理", methods = "帮助新增")
    @RequestMapping(value = "/help/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult helpSave(Help help) {
        OperateEnum res = appHelpService.insertHelp(help);
        return JsonResult.build(res);
    }

    /**
     * 帮助删除
     *
     * @param id
     * @return
     */
  /*  @RequiresPermissions("/type/delete")*/
    @ControllerLog(module = "帮助管理", methods = "帮助删除")
    @RequestMapping(value = "/help/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult helpDelete(@PathVariable long id) {
        //类别删除
        OperateEnum result = appHelpService.deleteHelpById(id);
        return JsonResult.build(result);
    }


    /**
     * 帮助管理
      * @param help
     * @return
     */
    /*@RequiresPermissions("/help/update")*/
    @ControllerLog(module = "帮助管理", methods = "帮助信息修改")
    @RequestMapping(value = "/help/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult helpUpdate(Help help) {
        OperateEnum result = appHelpService.updateHelp(help);
        return JsonResult.build(result);
    }


    /**
     * 更新缓存
     * @return
     */
    /*@RequiresPermissions("/help/update")*/
    @ControllerLog(module = "帮助管理", methods = "缓存更新")
    @RequestMapping(value = "/help/updateHelpRedis", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult updateHelpRedis() {
        OperateEnum result = appHelpService.updateHelpRedis();
        return JsonResult.build(result);
    }
}

