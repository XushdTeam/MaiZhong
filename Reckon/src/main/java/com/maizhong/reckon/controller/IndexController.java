package com.maizhong.reckon.controller;

import com.maizhong.common.dto.GuzhiDTO;
import com.maizhong.common.result.JsonResult;

import com.maizhong.pojo.Line;
import com.maizhong.reckon.DTO.IndexDTO;
import com.maizhong.reckon.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.parsing.SourceExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String saleguzhi(@PathVariable String param, Model model,
                            @CookieValue(value = "phone",required = true) String phone
    ){

        String[] arry = param.split("o");
        String guzhiKey = arry[0];
        String otherKey = arry[1];

        String price = indexService.saleguzhi(guzhiKey,otherKey, Long.valueOf(phone));

        model.addAttribute("price",price);

        return "jiage";
    }

    @RequestMapping(value = "/yuyue")
    public String yuyue( @CookieValue(value = "phone",required = true) String phone,Model model){



        GuzhiDTO guzhiDTO = indexService.getYuyueInfo(phone);
        List<Line> lineList = indexService.getLineList();
        JsonResult result =indexService.getBusinessAddress();
        JsonResult result1 =indexService.getOneWeek();

        model.addAttribute("shop",result.getData());
        model.addAttribute("week",result1.getData());
        model.addAttribute("result",guzhiDTO);
        model.addAttribute("lines",lineList);
        return "yuyue";
    }

    /**
     * 获取地铁站信息
     * @param lineId
     * @return
     */
    @RequestMapping(value = "getSite/{lineId}")
    @ResponseBody
    public JsonResult getSiteByLineId(@PathVariable String lineId){

        JsonResult result = indexService.getSiteByLineId(lineId);

        return result;
    }

    /**
     * 订单确认
     * @param orderNumber 订单编号
     * @param dealWay 交易方式 1 4S店 2 地铁站 3 上门
     * @param wayId  4S店ID 或者 地铁站ID
     * @param linkMan 联系人
     * @param linkPhone 联系人手机号
     * @param address 上门地址
     * @return
     */
    @RequestMapping(value = "/OrderConfim",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult orderConfim(String orderNumber,
                                  String dealWay,
                                  String wayId,
                                  String linkMan,
                                  String linkPhone,
                                  String address ){

        JsonResult result = indexService.orderConfim(orderNumber,dealWay,wayId,linkMan,linkPhone,address);
        return result;
    }
}
