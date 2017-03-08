package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.TbCar;
import com.maizhong.service.CarService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 汽车controller
 *
 * Created by yangF on 2017/3/6.
 */
@RequestMapping("/car")
@Controller
public class CarController {



    @Value("${PAGESIZE}")
    private static String PageSize;


    @Resource
    private CarService carService;


    /***
     * 返回汽车列表数据
     * @param param
     * @return
     */


    @RequestMapping("/findAll")
    @ResponseBody
    public JsonResult findAll(PageSearchParam param){
        PageResult result = carService.findAll(param);
        return JsonResult.OK(result);
    }



    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("carListUrl","/car/findAll");
        model.addAttribute("carTypeListUrl","/car/type");
        model.addAttribute("carAddUrl","/car/add");
        return "/car/list2";
    }






    @RequestMapping("/seeDesc")
    @ResponseBody
    public JsonResult seeDesc(@RequestParam("id") Long id){
        if (id==null){
            return JsonResult.Error("id 不能为空");
        }
        TbCar tbcar = carService.findCarById(id);
        if (tbcar!=null){
            return JsonResult.OK(tbcar.getDetails());
        }else{
            return JsonResult.Error("数据错误！请联系管理员");
        }
    }


    @RequestMapping("/add")
    public String addCar(Model model){
        model.addAttribute("insertUrl","/car/insert");
        return "/car/add";
    }


    /**
     * 添加方法  返回json数据
     * @param tbCar
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public  JsonResult insert(@RequestBody TbCar tbCar){
        if (tbCar==null){
            return JsonResult.Error("数据错误");
        }
        return carService.addTbCar(tbCar);
    }


    @RequestMapping("/delete/{id}")
    @ResponseBody
    public JsonResult delCar(@PathVariable("id") Long id){
        return carService.deleteCar(id);
    }



    @RequestMapping("/update")
    @ResponseBody
    public  JsonResult updateCar(TbCar tbCar){
        if (tbCar==null){
            return JsonResult.Error("数据错误");
        }
        return carService.updateCar(tbCar);
    }




    /***
     *  修改页面跳转
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/updateUI")
    public String updateUI(@RequestParam("id") Long id,Model model){
        //数据查询与填充
        TbCar car = carService.findCarById(id);

        model.addAttribute("car",car);


        return "/car/update";
    }
}
