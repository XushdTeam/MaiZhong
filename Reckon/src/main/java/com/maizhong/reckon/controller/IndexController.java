package com.maizhong.reckon.controller;

import com.maizhong.common.dto.GuzhiDTO;
import com.maizhong.common.result.JsonResult;

import com.maizhong.reckon.DTO.IndexDTO;
import com.maizhong.reckon.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.parsing.SourceExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Xushd on 2017/4/18.
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/")
    public String index(Model model){

        IndexDTO indexDTO = indexService.getIndexDTO();

        model.addAttribute("brandList",indexDTO.getBrandList());
        model.addAttribute("proviceList",indexDTO.getProviceList());
        return "index";
    }
    @RequestMapping(value = "/{page}")
    public String test(@PathVariable String page){
        return page;
    }


    /**
     * 获取车系
     * @param brandId
     * @return
     */
    @RequestMapping(value = "/series/series_brand/{brandId}")
    @ResponseBody
    public JsonResult getSeries(@PathVariable String brandId){

        JsonResult result = indexService.getSeries(brandId);
        return result;
    }

    /**
     * 获取车型
     * @param seriesId
     * @return
     */
    @RequestMapping(value = "/model/model_series/{seriesId}")
    @ResponseBody
    public JsonResult getCarType(@PathVariable String seriesId){
        JsonResult result = indexService.getCarType(seriesId);
        return result;
    }

    /**
     * 获取所有城市
     * @return
     */
    @RequestMapping(value = "/getAllCity")
    @ResponseBody
    public JsonResult getAllCity(){
        JsonResult result = indexService.getAllCity();
        return result;
    }

    /**
     * 跳转到估值页面
     * @param param
     * @param model
     * @return
     */
    @RequestMapping(value = "/guzhi/{param}")
    public String compute(@PathVariable String param,Model model){

        String params = param;
        GuzhiDTO guzhiDTO = indexService.getGuZhi(param);
        model.addAttribute("result",guzhiDTO);
        model.addAttribute("ppap",params);


        return "guzhi";
    }

    /**
     * 估值完成后跳转
     * @param model
     * @param param
     * @return
     */
    @RequestMapping(value = "/sale/{param}")
    public String sale(Model model,@PathVariable String param){

        IndexDTO indexDTO = indexService.getIndexDTO(param);
      //  model.addAttribute("brandList",indexDTO.getBrandList());
       // model.addAttribute("proviceList",indexDTO.getProviceList());
        model.addAttribute("result",indexDTO);
        model.addAttribute("second","1");
        return "jingzhun";
    }

    /**
     * 未估值直接跳转
     * @param model
     * @return
     */
    @RequestMapping(value = "/sale")
    public String sale(Model model){
        IndexDTO indexDTO = indexService.getIndexDTO();
        model.addAttribute("result",indexDTO);
//        model.addAttribute("brandList",indexDTO.getBrandList());
//        model.addAttribute("proviceList",indexDTO.getProviceList());
        model.addAttribute("second","0");
        return "jingzhun";
    }

    @RequestMapping(value = "/login")
    public String login(){

        return "dl";
    }

    /**
     * 精准估值结果
     * @param param
     * @return
     */
    @RequestMapping(value="/saleguzhi/{param}")
    public String saleguzhi(@PathVariable String param,Model model){
        System.out.println(param);
        String[] arry = param.split("o");
        String guzhiKey = arry[0];
        String otherKey = arry[1];

        String price = indexService.saleguzhi(guzhiKey,otherKey);

        model.addAttribute("price",price);

        return "jiage";
    }
}
