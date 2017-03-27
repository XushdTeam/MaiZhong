package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.pojo.TbCar;
import com.maizhong.pojo.TbCarBrand;
import com.maizhong.pojo.TbCarType;
import com.maizhong.pojo.vo.TbCarBaseVo;
import com.maizhong.service.*;
import org.apache.commons.lang3.StringUtils;
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



    //页面显示数据大小
    @Value("${PAGESIZE}")
    private static String PageSize;

    @Value("${COLOR_CAR_DIC}")
    private static String COLOR_CAR_DIC;
    @Value("${GAERBOX_CAR_DIC}")
    private static String GAERBOX_CAR_DIC;

    @Resource
    private CarService carService;


    @Resource
    private BrandService brandService;

    @Resource
    private TypeService typeService;

    @Resource
    private DicService dicService;

    @Resource
    private BrandLineService brandLineService;

    /***
     * 返回汽车列表数据
     * @param param
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public JsonResult findAll(PageSearchParam param){
        PageResult result = carService.findListToShow(param);
        return JsonResult.OK(result);
    }


    /***
     * 列表UI方法
     *
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("carListUrl","/car/findAll");
        model.addAttribute("carTypeListUrl","/car/type");
        model.addAttribute("carAddUrl","/car/modify");
        model.addAttribute("cartypeUrl","/type/findAll");
        model.addAttribute("carBrandType","/brand/findAll");
        model.addAttribute("deleteUrl","/car/deleteCar");
        model.addAttribute("editCarUrl","/car/modify");



        //数据准备
        model.addAttribute("carTypeList", JsonUtils.jsonToList(typeService.getCarTypeListAll(), TbCarType.class));
        model.addAttribute("carBrandList",JsonUtils.jsonToList(brandService.getCarBrandListAll(), TbCarBrand.class));
        model.addAttribute("colorList",dicService.getDicListByParent(4L));
        model.addAttribute("gaerboxList",dicService.getDicListByParent(9L));

        return "/car/list2";
    }






    /**
     * 查看汽车详情
     * */
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


    /***
     * 添加汽车UI页面
     * @param model
     * @return
     */
    @RequestMapping("/add")
    public String addCar(Model model){
        model.addAttribute("insertUrl","/car/insert");
//        model.addAttribute("seepropUrl","/carProp/prop");
        model.addAttribute("lineListUrl","/carBrandLine/list");
        model.addAttribute("findBaseCarUrl","/car/overall");



        //数据准备
        model.addAttribute("carTypeList", JsonUtils.jsonToList(typeService.getCarTypeListAll(), TbCarType.class));
        model.addAttribute("carBrandList",JsonUtils.jsonToList(brandService.getCarBrandListAll(), TbCarBrand.class));
//        model.addAttribute("colorList",dicService.getDicListByParent(4L));
//        model.addAttribute("gaerboxList",dicService.getDicListByParent(9L));
//        model.addAttribute("colorList",dicService.getDicListByParent(Long.parseLong(COLOR_CAR_DIC)));
//        model.addAttribute("gaerboxList",dicService.getDicListByParent(Long.parseLong(GAERBOX_CAR_DIC)));


        return "/car/add";
    }


    /**
     * 添加方法  返回json数据
     * @param tbCar
     * @return
     */
    @ControllerLog(module = "汽车管理",methods = "汽车新增")
    @RequestMapping("/insert")
    @ResponseBody
    public  JsonResult insert(@RequestBody TbCar tbCar){
        if (tbCar==null){
            return JsonResult.Error("数据错误");
        }
        return carService.addTbCar(tbCar);
    }


    /***
     * 汽车删除入口
     * @param id
     * @return
     */
    @ControllerLog(module = "汽车管理",methods = "汽车删除")
    @RequestMapping("/deleteCar/{id}")
    @ResponseBody
    public JsonResult delCar(@PathVariable("id") Long id){
        return carService.deleteCar(id);
    }



    /**
     * 更改方法
     * */
    @ControllerLog(module = "汽车管理",methods = "汽车更改")
    @RequestMapping("/update")
    @ResponseBody
    public  JsonResult updateCar(@RequestBody TbCar tbCar){
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
    @RequestMapping("/updateUI/{id}")
    public String updateUI(@PathVariable("id") Long id,Model model){

        model.addAttribute("updateCarUrl","/car/update");
        model.addAttribute("seepropUrl","/carProp/prop");
        model.addAttribute("lineListUrl","/carBrandLine/list");
        model.addAttribute("findBaseCarUrl","/car/overall");

        /*
            数据填充  重点
                    根据车型查找车系
                    根据车系和年份确认款式
         */

        //数据查询与填充
        TbCar car = carService.findCarById(id);
        model.addAttribute("car",car);

        //数据准备
        model.addAttribute("carTypeList", JsonUtils.jsonToList(typeService.getCarTypeListAll(), TbCarType.class));
        model.addAttribute("carBrandList",JsonUtils.jsonToList(brandService.getCarBrandListAll(), TbCarBrand.class));

        //数据准备  车系列表
        model.addAttribute("lineList",brandLineService.getCarBrandLineList(car.getCarBrand()).getData());
        //  设置基础列表
        model.addAttribute("carBaseVoList",carService.findBaseCar(car.getCarBrandLine(),car.getCarYear()).getData());



        return "/car/update";
    }


    /**
     *
     * 前台ajax获取数据
     *         使用车型和汽车年限定位汽车基础类
     */
    @RequestMapping("/overall/{carSeries}/{carYear}")
    @ResponseBody
    public JsonResult findBaseCar(@PathVariable("carSeries")Long carSeries,@PathVariable("carYear") String carYear){
        return carService.findBaseCar(carSeries,carYear);
    }


    @RequestMapping("/modify")
    public String modifyCar(Long id,Model model){



        model.addAttribute("seepropUrl","/carProp/prop");
        model.addAttribute("lineListUrl","/carBrandLine/list");
        model.addAttribute("findBaseCarUrl","/car/overall");

        /*
            数据填充  重点
                    根据车型查找车系
                    根据车系和年份确认款式
         */
        if (id!=null&&StringUtils.isNotBlank(id+"")){
            //数据查询与填充
            TbCar car = carService.findCarById(id);
            model.addAttribute("car",car);
            model.addAttribute("updateCarUrl","/car/update");


            //数据准备  车系列表
            model.addAttribute("lineList",brandLineService.getCarBrandLineList(car.getCarBrand()).getData());
            //  设置基础列表
            model.addAttribute("carBaseVoList",carService.findBaseCar(car.getCarBrandLine(),car.getCarYear()).getData());

        }else{
            model.addAttribute("updateCarUrl","/car/insert");
        }



        //数据准备
        model.addAttribute("carTypeList", JsonUtils.jsonToList(typeService.getCarTypeListAll(), TbCarType.class));
        model.addAttribute("carBrandList",JsonUtils.jsonToList(brandService.getCarBrandListAll(), TbCarBrand.class));





        return "/car/car";
    }
}
