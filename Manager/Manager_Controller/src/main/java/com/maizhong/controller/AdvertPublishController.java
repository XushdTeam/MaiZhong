package com.maizhong.controller;

import com.maizhong.common.dto.KeyValue;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.pojo.TbAdvert;
import com.maizhong.pojo.TbAdvertPublish;
import com.maizhong.service.AdvertPublishService;
import com.maizhong.service.AdvertService;
import com.maizhong.service.FileUploadService;
import com.mysql.fabric.xmlrpc.base.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * Description:广告发布管理
 * User: 王存浩
 * Date: 2017-03-08
 * Time: 14:30
 */

@Controller
public class AdvertPublishController {

    @Autowired
    AdvertPublishService advertPublishService;


    //@RequiresPermissions("/advertPublish")
    @RequestMapping(value = "/advertPublish", method = RequestMethod.GET)
    public String advertPublish(Model model) {
        List<KeyValue> list=advertPublishService.getAdvertTypeList();
        model.addAttribute("typeList",list);
        model.addAttribute("baseUrl", "/advertPublish");
        model.addAttribute("listUrl", "/advertPublish/list");
        model.addAttribute("handleUrl", "/advertPublish/handle");
        model.addAttribute("deleteUrl", "/advertPublish/delete");

        return "advert/advertPublish";
    }

    /**
     * 广告发布列表--分页--查询
     * @param param
     * @return
     */
    @ControllerLog(module = "发布管理", methods = "广告发布列表")
    @RequestMapping(value = "/advertPublish/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult advertPublishList(PageSearchParam param) {
        PageResult result = advertPublishService.getAdvertPublishList(param);
        return JsonResult.OK(result);
    }


    /**
     * 修改广告序列
     * @param id
     * @return
     */
    @RequestMapping(value = "/advertPublish/handle/{meth}/{id}")
    @ResponseBody
    public JsonResult changeSort(@PathVariable String meth,@PathVariable long id) {
        OperateEnum operateEnum = advertPublishService.changeSort(meth, id);
        return JsonResult.build(operateEnum);
    }


    /**
     * 根据Id删除已发布广告
     * @param id
     * @return
     */
    //@RequiresPermissions("/advertPublish/delete")
    @ControllerLog(module = "发布管理", methods = "删除广告")
    @RequestMapping(value = "/advertPublish/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult advertPublishDelete(@PathVariable long id) {
        //已发布广告删除
        OperateEnum result = advertPublishService.deleteAdvertPublishById(id);
        return JsonResult.build(result);
    }


}
