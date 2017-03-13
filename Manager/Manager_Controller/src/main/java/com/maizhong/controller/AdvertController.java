package com.maizhong.controller;

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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-08
 * Time: 14:30
 */

@Controller
public class AdvertController {

    @Autowired
   AdvertService advertService;

    @Autowired
    AdvertPublishService advertPublishService;

    @Autowired
    FileUploadService fileUploadService;

    @Value("${ADVERT_FILEPATH_KEY}")
    private String advertImgFilepathKey;


    //@RequiresPermissions("/advert")
    @RequestMapping(value = "/advert", method = RequestMethod.GET)
    public String advert(Model model) {
        model.addAttribute("baseUrl", "/advert");
        model.addAttribute("listUrl", "/advert/list");
        model.addAttribute("handleUrl", "/advert/handle");
        model.addAttribute("deleteUrl", "/advert/delete");

        return "advert/advert";
    }


    @ControllerLog(module = "广告信息", methods = "广告列表")
    @RequestMapping(value = "/advert/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult advertList(PageSearchParam param) {
        PageResult result = advertService.getAdvertList(param);
        return JsonResult.OK(result);
    }



    /**
     * 广告新增和修改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/advert/handle/{id}")
    public String handle(@PathVariable String id, Model model) {

        model.addAttribute("baseUrl", "/advert");
        if (StringUtils.equals("new", id)) {
            //新增
            model.addAttribute("handle", "广告信息/新增广告");
            model.addAttribute("saveUrl", "/advert/save");
            return "advert/advert_add";
        } else {
            System.out.println("广告信息修改！！");
            TbAdvert advert = advertService.getAdvertByid(Long.valueOf(id));
            model.addAttribute("advert", advert);
            model.addAttribute("handle", "广告信息/广告修改");
            model.addAttribute("saveUrl", "/advert/update");
            model.addAttribute("uploadUrl", "/advert/" + advert.getId() + "/advert/upload");
            return "advert/advert_setting";
        }
    }



    /**
     * 广告信息添加
     * @param tbAdvert
     * @return
     */

    //@RequiresPermissions("/advert/save")
    @ControllerLog(module = "广告信息", methods = "广告新增")
    @RequestMapping(value = "/advert/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult advertSave(TbAdvert tbAdvert) {
        OperateEnum res = advertService.insertAdvert(tbAdvert);
        return JsonResult.build(res);
    }

    /**
     * 根据Id删除广告
     * @param id
     * @return
     */
    //@RequiresPermissions("/advert/delete")
    @ControllerLog(module = "广告信息", methods = "删除广告")
    @RequestMapping(value = "/advert/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult advertDelete(@PathVariable long id) {
        //广告信息删除
        OperateEnum result = advertService.deleteAdvertById(id);
        return JsonResult.build(result);
    }



    /**
     * 广告发布
     * @param id
     * @return
     */
    @RequestMapping(value = "/advert/fabu/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult advertPublish(@PathVariable long id) {
        OperateEnum result = advertPublishService.advertPublish(id);
        return JsonResult.build(result);
    }

    /**
     * 广告信息修改
     * @param tbAdvert
     * @return
     */
    //@RequiresPermissions("/advert/update")
    @ControllerLog(module = "广告信息", methods = "广告信息修改")
    @RequestMapping(value = "/advert/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult advertUpdate(TbAdvert tbAdvert) {
        OperateEnum result = advertService.updateAdvert(tbAdvert);
        return JsonResult.build(result);
    }

    /**
     * 广告图片修改
     * @param filedata
     * @param id
     * @return
     */
    //@RequiresPermissions("/advert/advert")
    @ControllerLog(module = "广告管理", methods = "广告图片修改")
    @RequestMapping(value = "/advert/{id}/advert/upload", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult AdvertImgUpdate(@RequestParam(value = "advert", required = false) MultipartFile filedata, @PathVariable String id) {
        JsonResult jsonResult = fileUploadService.uploadImg(filedata, advertImgFilepathKey==null?"/ads":advertImgFilepathKey);
        if (jsonResult.getStatus() == 200) {
            int res = advertService.updateAdvertImg(jsonResult.getData().toString(), Long.parseLong(id));
            if (res > 0) {
                return jsonResult;
            } else {
                return JsonResult.Error(OperateEnum.FAILE);
            }
        } else {
            return jsonResult;
        }
    }

    /**
     * 广告图片上传
     * @param filedata
     * @return
     */
   // @RequiresPermissions("/advert/advert")
    @RequestMapping(value = "/advert/advert/upload", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult AdvertImgUpload(@RequestParam(value = "advert", required = false) MultipartFile filedata){
        JsonResult jsonResult = fileUploadService.uploadImg(filedata, advertImgFilepathKey==null?"/ads":advertImgFilepathKey);
        return  jsonResult;
    }




}
