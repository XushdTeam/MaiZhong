package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.pojo.TbCarType;
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
public class TypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private FileUploadService fileUploadService;

    @Value("${TYPE_FILEPATH_KEY}")
    private String typeImgFilepathKey;


    @RequiresPermissions("/type")
    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public String carType(Model model) {

        model.addAttribute("baseUrl", "/type");
        model.addAttribute("listUrl", "/type/list");
        model.addAttribute("handleUrl", "/type/handle");
        model.addAttribute("deleteUrl", "/type/delete");

        return "shop/type";
    }

    /**
     * 汽车类别获取 分页 查询
     * @param param
     * @return
     */
    @ControllerLog(module = "类别管理", methods = "类别列表")
    @RequestMapping(value = "/type/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult typeList(PageSearchParam param) {
        PageResult result = typeService.getCarTypeList(param);
        return JsonResult.OK(result);
    }


    /**
     *获取所有类别 不含删除和停用
     * @return
     */
    @RequestMapping(value = "/getCarTypeListAll", method = RequestMethod.GET)
    @ResponseBody
    public String typeListAll() {
        return typeService.getCarTypeListAll();
    }

    /**
     * 类别新增和修改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/type/handle/{id}")
    public String handle(@PathVariable String id, Model model) {

        model.addAttribute("baseUrl", "/type");
        if (StringUtils.equals("new", id)) {
            //新增
            model.addAttribute("handle", "类别管理/新增类别");
            model.addAttribute("saveUrl", "/type/save");
            return "shop/type_add";
        } else {
            TbCarType type = typeService.getCarTypeByid(Long.valueOf(id));
            model.addAttribute("type", type);
            model.addAttribute("handle", "类别管理/类别修改");
            model.addAttribute("saveUrl", "/type/update");
            model.addAttribute("uploadUrl", "/type/" + type.getId() + "/advert/upload");
            model.addAttribute("passUpdateUrl", "/type/" + type.getId() + "/pass/update");
            return "shop/type_setting";
        }
    }

    /**
     * 类别新增
     * @param carType
     * @return
     */
    @RequiresPermissions("/type/save")
    @ControllerLog(module = "类别管理", methods = "类别新增")
    @RequestMapping(value = "/type/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult carTypeSave(TbCarType carType) {
            OperateEnum res = typeService.insertCarType(carType);
            return JsonResult.build(res);
    }

    /**
     * 类别删除
     * @param id
     * @return
     */
    @RequiresPermissions("/type/delete")
    @ControllerLog(module = "类别管理", methods = "删除类别")
    @RequestMapping(value = "/type/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult carTypeDelete(@PathVariable long id) {
        //类别删除
        OperateEnum result = typeService.deleteCarTypeById(id);
        return JsonResult.build(result);
    }

    /**
     * 类别信息修改
     * @param tbCarType
     * @return
     */
    @RequiresPermissions("/type/update")
    @ControllerLog(module = "类别管理", methods = "类别信息修改")
    @RequestMapping(value = "/type/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult typeUpdate(TbCarType tbCarType) {
        OperateEnum result = typeService.updateCarType(tbCarType);
        return JsonResult.build(result);
    }

    /**
     * 类别示例图片修改
     * @param filedata
     * @param id
     * @return
     */
    @RequiresPermissions("/type/advert")
    @ControllerLog(module = "类别管理", methods = "类别示例修改")
    @RequestMapping(value = "/type/{id}/advert/upload", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult typeAdvertUpdate(@RequestParam(value = "advert", required = false) MultipartFile filedata, @PathVariable String id) {

        System.out.println("类别示例修改");

        JsonResult jsonResult = fileUploadService.uploadImg(filedata, typeImgFilepathKey==null?"/cartype":typeImgFilepathKey);
        if (jsonResult.getStatus() == 200) {
            int res = typeService.updateTypeAdvert(jsonResult.getData().toString(), Long.parseLong(id));
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
     * 类别示例图片上传
     * @param filedata
     * @return
     */
    @RequiresPermissions("/type/advert")
    @RequestMapping(value = "/type/advert/upload", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult typeAdvertUpload(@RequestParam(value = "advert", required = false) MultipartFile filedata) {
        JsonResult jsonResult = fileUploadService.uploadImg(filedata, typeImgFilepathKey==null?"/cartype":typeImgFilepathKey);
        return  jsonResult;
    }


    @RequestMapping("/type/findAll")
    @ResponseBody
    public JsonResult findAll(){
//        String type = typeService.getCarTypeListAll();
//        return type==null?"{status:500}":"{status:200,data:"+type+"}";
        List<TbCarType> list = JsonUtils.jsonToList(typeService.getCarTypeListAll(), TbCarType.class);
        return JsonResult.OK(list);
    }

    /**
     * 更新汽车种类缓存
     * @return
     */
    @RequestMapping("/type/updateTypeRedis")
    @ResponseBody
    public  JsonResult updateTypeRedis(){
        return typeService.updateTypeRedis();
    }
}



