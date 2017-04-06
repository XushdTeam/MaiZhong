package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.pojo.TbBusiness;
import com.maizhong.service.BusinessService;
import com.maizhong.service.FileUploadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Description:店铺管理控制器
 * User: 王存浩
 * Date: 2017-03-06
 * Time: 10:56
 */

@Controller
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @Autowired
    private FileUploadService fileUploadService;

    @Value("${BUSINESS_FILEPATH_KEY}")
    private String logoImgFilepathKey;


    //@RequiresPermissions("/business")
    @RequestMapping(value = "/business", method = RequestMethod.GET)
    public String carType(Model model) {

        model.addAttribute("baseUrl", "/business");
        model.addAttribute("listUrl", "/business/list");
        model.addAttribute("handleUrl", "/business/handle");
        model.addAttribute("deleteUrl", "/business/delete");
        model.addAttribute("detailUrl", "/business/detail");


        return "business/business";
    }

    /**
     * 获取 分页 查询
     *
     * @param param
     * @return
     */
    @ControllerLog(module = "店铺管理", methods = "店铺列表")
    @RequestMapping(value = "/business/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult BusinessList(PageSearchParam param) {
        PageResult result = businessService.getBusinessList(param);
        return JsonResult.OK(result);
    }


    /**
     * 获取所有店铺 不含删除和停用
     *
     * @return
     */
    @RequestMapping(value = "/getBusinessListAll", method = RequestMethod.GET)
    @ResponseBody
    public String typeListAll() {
        List<TbBusiness> businessListAll = businessService.getBusinessListAll();
        if (businessListAll != null && businessListAll.size() > 0) {
            return JsonUtils.objectToJson(businessListAll);
        }
        return null;
    }

    /**
     * 店铺新增和修改
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/business/handle/{id}")
    public String handle(@PathVariable String id, Model model) {

        model.addAttribute("baseUrl", "/business");
        if (StringUtils.equals("new", id)) {
            //新增
            model.addAttribute("handle", "店铺管理/店铺新增");
            model.addAttribute("saveUrl", "/business/save");
            return "business/business_add";
        } else {
            TbBusiness business = businessService.getBusinessByid(Long.valueOf(id));
            model.addAttribute("business", business);
            model.addAttribute("handle", "店铺管理/店铺修改");
            model.addAttribute("saveUrl", "/business/update");
            model.addAttribute("uploadUrl", "/business/" + business.getId() + "/logo/upload");
            return "business/business_setting";
        }
    }

    /**
     * 店铺新增
     *
     * @param tbBusiness
     * @return
     */
    //@RequiresPermissions("/business/save")
    @ControllerLog(module = "店铺管理", methods = "店铺新增")
    @RequestMapping(value = "/business/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult businessSave(TbBusiness tbBusiness) {
        OperateEnum res = businessService.insertBusiness(tbBusiness);
        return JsonResult.build(res);
    }

    /**
     * 店铺删除
     *
     * @param id
     * @return
     */
    //  @RequiresPermissions("/business/delete")
    @ControllerLog(module = "店铺管理", methods = "删除店铺")
    @RequestMapping(value = "/business/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult businessDelete(@PathVariable long id) {
        //店铺删除
        OperateEnum result = businessService.deleteBusinessById(id);
        return JsonResult.build(result);
    }

    /**
     * 店铺信息修改
     *
     * @param tbBusiness
     * @return
     */
    // @RequiresPermissions("/business/update")
    @ControllerLog(module = "店铺管理", methods = "店铺信息修改")
    @RequestMapping(value = "/business/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult businessUpdate(TbBusiness tbBusiness) {
        OperateEnum result = businessService.updateBusiness(tbBusiness);
        return JsonResult.build(result);
    }

    /**
     * 店铺详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/business/detail/{id}")
    public String detail(@PathVariable String id,Model model) {
        TbBusiness business = businessService.getBusinessByid(Long.valueOf(id));
        model.addAttribute("business",business);
        return "business/business_d";
    }

    /**
     * 店铺LOGO修改
     *
     * @param filedata
     * @param id
     * @return
     */
    //@RequiresPermissions("/business/logo")
    @ControllerLog(module = "店铺管理", methods = "店铺LOGO修改")
    @RequestMapping(value = "/business/{id}/logo/upload", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult businessLogoUpdate(@RequestParam(value = "logo", required = false) MultipartFile filedata, @PathVariable String id) {

        JsonResult jsonResult = fileUploadService.uploadImg(filedata, logoImgFilepathKey == null ? "/business" : logoImgFilepathKey);
        if (jsonResult.getStatus() == 200) {
            int res = businessService.updateBusinessLogo(jsonResult.getData().toString(), Long.parseLong(id));
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
     * 店铺Logo图片上传
     *
     * @param filedata
     * @return
     */
    //@RequiresPermissions("/business/logo")
    @RequestMapping(value = "/business/logo/upload", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult bussinessUpload(@RequestParam(value = "businessLogo", required = false) MultipartFile filedata) {
        JsonResult jsonResult = fileUploadService.uploadImg(filedata, logoImgFilepathKey == null ? "/business" : logoImgFilepathKey);
        return jsonResult;
    }


    @RequestMapping("/business/findAll")
    @ResponseBody
    public JsonResult findAll() {
        List<TbBusiness> list = businessService.getBusinessListAll();
        return JsonResult.OK(list);
    }
}



