package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.pojo.Version;
import com.maizhong.service.AppVersionService;
import org.apache.commons.lang.StringUtils;
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
 * Date: 2017-05-08
 * Time: 15:59
 */

@Controller
public class AppVersionController {


    @Autowired
    private AppVersionService appVersionService;

    /*@RequiresPermissions("/version")*/
    @RequestMapping(value = "/app/version", method = RequestMethod.GET)
    public String version(Model model) {
        model.addAttribute("baseUrl", "/app/version");
        model.addAttribute("listUrl", "/version/list");
        model.addAttribute("handleUrl", "/version/handle");
        model.addAttribute("deleteUrl", "/version/delete");
        return "app/version";
    }

    /**
     * APP版本号
     *
     * @param param
     * @return
     */
    @ControllerLog(module = "APP版本", methods = "版本列表")
    @RequestMapping(value = "/version/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult typeList(PageSearchParam param) {
        PageResult result = appVersionService.getVersionList(param);
        return JsonResult.OK(result);
    }

    /**
     * APP版本号新增和修改
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/version/handle/{id}")
    public String handle(@PathVariable String id, Model model) {

        model.addAttribute("baseUrl", "/app/version");
        if (StringUtils.equals("new", id)) {
            //新增
            model.addAttribute("handle", "版本管理/版本新增");
            model.addAttribute("saveUrl", "/version/save");
            return "app/version_add";
        } else {
            Version version =appVersionService.getVersionById(Long.valueOf(id));
            model.addAttribute("version", version);
            model.addAttribute("handle", "版本管理/版本修改");
            model.addAttribute("saveUrl", "/version/update");
            return "app/version_setting";
        }
    }

    /**
     * 版本管理--新增
     * @param version
     * @return
     */
   /* @RequiresPermissions("/version/save")*/
    @ControllerLog(module = "版本管理", methods = "版本新增")
    @RequestMapping(value = "/version/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult versionSave(Version version) {
        OperateEnum res = appVersionService.insertVersion(version);
        return JsonResult.build(res);
    }

    /**
     * 版本删除
     *
     * @param id
     * @return
     */
  /*  @RequiresPermissions("/version/delete")*/
    @ControllerLog(module = "版本管理", methods = "版本删除")
    @RequestMapping(value = "/version/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult versionDelete(@PathVariable long id) {
        //版本删除
        OperateEnum result = appVersionService.deleteVersionById(id);
        return JsonResult.build(result);
    }


    /**
     * 版本管理
     * @param version
     * @return
     */
    /*@RequiresPermissions("/version/update")*/
    @ControllerLog(module = "版本管理", methods = "版本信息修改")
    @RequestMapping(value = "/version/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult versionUpdate(Version version) {
        OperateEnum result = appVersionService.updateVersion(version);
        return JsonResult.build(result);
    }


    /**
     * 更新缓存
     * @return
     */
    /*@RequiresPermissions("/version/update")*/
    @ControllerLog(module = "版本管理", methods = "缓存更新")
    @RequestMapping(value = "/version/updateVersionRedis", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult updateVersionRedis() {
        OperateEnum result = appVersionService.updateVersionRedis();
        return JsonResult.build(result);
    }

}
