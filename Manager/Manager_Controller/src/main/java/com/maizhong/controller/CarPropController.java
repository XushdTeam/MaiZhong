package com.maizhong.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.pojo.TbAdvertPublish;
import com.maizhong.pojo.TbCarProp;
import com.maizhong.service.CarPropService;
import com.sun.glass.ui.Size;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangF on 2017/3/9.
 */
@RequestMapping("/carProp")
@Controller
public class CarPropController {


    @Resource
    private CarPropService carPropService;

    /**
     * 汽车属性注入
     */
    @RequestMapping("/prop/{id}")
    public String seePropUi(@PathVariable("id") Long carId,Model model){

        model.addAttribute("saveUrl","/carProp/save");
        model.addAttribute("baseUrl","/carProp/save");

        model.addAttribute("carId",carId);


        TbCarProp carProp = carPropService.findPropByCarId(carId);
        if (carProp!=null){
            model.addAttribute("prop",carProp);
        }
        return "/car/carProp";
    }



    @ControllerLog(module = "汽车属性管理",methods = "汽车属性操作")
    @RequestMapping("/save")
    @ResponseBody
    public JsonResult saveOrEdit(@RequestBody TbCarProp tbCarProp){

        if (tbCarProp!=null&&tbCarProp.getCarId()!=null){
            if (tbCarProp.getId()==null||StringUtils.isBlank(tbCarProp.getId()+"")){
                 return  carPropService.insertCarProp(tbCarProp);
            }else{
                 return  carPropService.updateCarProp(tbCarProp);
            }
        }
        return JsonResult.Error("数据错误");
    }
}
