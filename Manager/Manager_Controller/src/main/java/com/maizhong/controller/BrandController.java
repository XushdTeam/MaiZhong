package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.pojo.TbCarBrand;
import com.maizhong.pojo.TbCarType;
import com.maizhong.service.BrandService;
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
 * Description:汽车品牌控制器
 * User: 王存浩
 * Date: 2017-03-06
 * Time: 10:56
 */

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private FileUploadService fileUploadService;

    @Value("${LOGO_FILEPATH_KEY}")
    private String logoImgFilepathKey;


    @RequiresPermissions("/brand")
    @RequestMapping(value = "/brand", method = RequestMethod.GET)
    public String carBrand(Model model) {

        model.addAttribute("baseUrl", "/brand");
        model.addAttribute("listUrl", "/brand/list");
        model.addAttribute("handleUrl", "/brand/handle");
        model.addAttribute("deleteUrl", "/brand/delete");
        model.addAttribute("insertLineUrl", "/carBrandLine/insert");
        model.addAttribute("lineListUrl", "/carBrandLine/list");
        model.addAttribute("deleteLineUrl", "/carBrandLine/delete");


        return "shop/brand";
    }


    @ControllerLog(module = "品牌管理", methods = "品牌列表")
    @RequestMapping(value = "/brand/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult brandList(PageSearchParam param) {
        PageResult result = brandService.getCarBrandList(param);
        return JsonResult.OK(result);
    }

    /**
     * 获取所有品牌信息 不含删除和停用
     * @return
     */
    @RequestMapping(value = "/getCarBrandListAll", method = RequestMethod.GET)
    @ResponseBody
    public String brandListAll() {
        return brandService.getCarBrandListAll();
    }


    /**
     * 品牌新增和修改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/brand/handle/{id}")
    public String handle(@PathVariable String id, Model model) {

        model.addAttribute("baseUrl", "/brand");
        if (StringUtils.equals("new", id)) {
            //新增
            model.addAttribute("handle", "品牌管理/新增品牌");
            model.addAttribute("saveUrl", "/brand/save");
            return "shop/brand_add";
        } else {
            TbCarBrand brand = brandService.getCarBrandByid(Long.valueOf(id));
            model.addAttribute("brand", brand);
            model.addAttribute("handle", "品牌管理/品牌修改");
            model.addAttribute("saveUrl", "/brand/update");
            model.addAttribute("uploadUrl", "/brand/" + brand.getId() + "/advert/upload");
            return "shop/brand_setting";
        }
    }

    /**
     * 品牌新增
     * @param carBrand
     * @return
     */

    @RequiresPermissions("/brand/save")
    @ControllerLog(module = "品牌管理", methods = "品牌新增")
    @RequestMapping(value = "/brand/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult carBrandSave(TbCarBrand carBrand) {
            OperateEnum res = brandService.insertCarBrand(carBrand);
            return JsonResult.build(res);
    }

    /**
     * 根据Id删除品牌
     * @param id
     * @return
     */
    @RequiresPermissions("/brand/delete")
    @ControllerLog(module = "品牌管理", methods = "删除品牌")
    @RequestMapping(value = "/brand/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult carBrandDelete(@PathVariable long id) {
        //品牌删除
        OperateEnum result = brandService.deleteCarBrandById(id);
        return JsonResult.build(result);
    }

    /**
     * 品牌信息修改
     * @param tbCarBrand
     * @return
     */
    @RequiresPermissions("/brand/update")
    @ControllerLog(module = "品牌管理", methods = "品牌信息修改")
    @RequestMapping(value = "/brand/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult brandUpdate(TbCarBrand tbCarBrand) {
        OperateEnum result = brandService.updateCarBrand(tbCarBrand);
        return JsonResult.build(result);
    }

    /**
     * 品牌Logo修改
     * @param filedata
     * @param id
     * @return
     */
    @RequiresPermissions("/brand/advert")
    @ControllerLog(module = "品牌管理", methods = "品牌LOGO修改")
    @RequestMapping(value = "/brand/{id}/advert/upload", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult brandAdvertUpdate(@RequestParam(value = "advert", required = false) MultipartFile filedata, @PathVariable String id) {

        System.out.println("品牌LOGO修改");

        JsonResult jsonResult = fileUploadService.uploadImg(filedata, logoImgFilepathKey==null?"/carlogo":logoImgFilepathKey);
        if (jsonResult.getStatus() == 200) {
            int res = brandService.updateBrandAdvert(jsonResult.getData().toString(), Long.parseLong(id));
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
     * 品牌LOGO图片上传
     * @param filedata
     * @return
     */
    @RequiresPermissions("/brand/advert")
    @RequestMapping(value = "/brand/advert/upload", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult brandAdvertUpload(@RequestParam(value = "advert", required = false) MultipartFile filedata) {
        JsonResult jsonResult = fileUploadService.uploadImg(filedata, logoImgFilepathKey==null?"/carlogo":logoImgFilepathKey);
        return  jsonResult;
    }


    /***
     * 返回所有的json数据
     * @return
     */
    @RequestMapping("/brand/findAll")
    @ResponseBody
    public JsonResult findAll(){
//        String type = brandService.getCarBrandListAll();
//        return type==null?"{status:500}":"{status:200,data:"+type+"}";
        List<TbCarBrand> list = JsonUtils.jsonToList(brandService.getCarBrandListAll(), TbCarBrand.class);
        return JsonResult.OK(list);
    }
}



