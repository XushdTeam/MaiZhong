package com.maizhong.portal.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.portal.service.AssessService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * Created by YangF on 2017/4/10.
 */
@Controller
@RequestMapping("/assess")
public class AssessController {


    @Resource
    private AssessService assessService;



    @RequestMapping("/info")
    public String toAssess(Model model){

        model.addAttribute("getCarBrandUrl","/assess/getCarBrand.action");
        model.addAttribute("getCarSeriesUrl","/assess/getCarSeries/");
        model.addAttribute("getCarTypeUrl","/assess/getCarType/");
        model.addAttribute("getCarBuyDateAndmileageUrl","/assess/getCarBuyDateAndmileage/");
        model.addAttribute("assessUrl","/assess/assess.action");

        return "assess";
    }


    @RequestMapping("/getCarBuyDateAndmileage/{carId}")
    @ResponseBody
    public JsonResult getCarBuyDateAndmileage(@PathVariable Long carId) {
        return assessService.getCarBuyDateAndmileage(carId);
    }

    @RequestMapping("/getCarBrand")
    @ResponseBody
    public JsonResult getCarBrand() {
        return assessService.getCarBrand();
    }

    @RequestMapping("/getCarSeries/{brandId}")
    @ResponseBody
    public JsonResult getCarSeries(@PathVariable Long brandId) {
        return assessService.getCarSeries(brandId);
    }

    @RequestMapping("/getCarType/{seriesId}")
    @ResponseBody
    public JsonResult getCarType(@PathVariable Long seriesId) {
        return assessService.getCarType(seriesId);
    }

    @RequestMapping("/assess")
    @ResponseBody
    public JsonResult assess(String bid, String sid, String specId,String registerYear, String registerMonth,String selectCarName) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(selectCarName)){
         selectCarName = new String(selectCarName.getBytes("iso-8859-1"),"utf-8");
        }
        return assessService.calculatePrice(bid,sid,specId,registerYear,registerMonth,selectCarName);
    }

}
