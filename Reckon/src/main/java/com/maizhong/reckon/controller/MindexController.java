package com.maizhong.reckon.controller;

import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.dto.GuzhiDTO;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.pojo.Line;
import com.maizhong.pojo.User;
import com.maizhong.reckon.service.IndexService;
import com.maizhong.reckon.service.MindexService;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Xushd on 2017/5/31.
 */
@Controller
public class MindexController {

    @Autowired
    private MindexService mindexService;

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/m")
    public String m_index(HttpServletRequest request, Model model){

        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        OperatingSystem os = userAgent.getOperatingSystem();
        String key = os.toString().toLowerCase();

        if(key.contains("windows")){
            // 移动端
            return "redirect:http://www.wukongshouche.com";
        }

        model.addAttribute("OSS","http://oss.maizhongcar.com/app/v0.0.1");
        return "m/index";
    }

    @RequestMapping(value = "/m/allbrand")
    public String m_allbrand(Model model){

        model.addAttribute("OSS","http://oss.maizhongcar.com/app/v0.0.1");
        return "m/allbrand";
    }

    @RequestMapping(value = "/m/model/{seriesId}")
    public String m_model(@PathVariable String seriesId,Model model){
        model.addAttribute("seriesId",seriesId);
        return "m/model";
    }



    @RequestMapping(value = "/m/getSeriesByBrand/{brandId}")
    @ResponseBody
    public JsonResult m_getSeriesByBrand(@PathVariable String brandId){
        JsonResult result = mindexService.getSeriesByBrand(brandId);
        return result;
    }

    @RequestMapping(value = "/m/getModelBySeries/{seriesId}")
    @ResponseBody
    public JsonResult m_getModelBySeries(@PathVariable String seriesId){
        JsonResult result = mindexService.getModelBySeries(seriesId);
        return result;
    }

    @RequestMapping(value = "/m/computed")
    public String m_salen(Model model){
        model.addAttribute("model","{}");
        return "m/computed";
    }

    @RequestMapping(value = "/m/computed/{modelId}")
    public String m_sale(@PathVariable String modelId,Model model){
        Object modelObj = mindexService.getModelById(modelId);
        model.addAttribute("model",modelObj);
        return "m/computed";
    }

    @RequestMapping(value = "/m/guzhi/{param:.+}")
    public String guzhi(@PathVariable String param,Model model){
        Object object = mindexService.getGuzhi(param);
        model.addAttribute("data",object);
        return "m/guzhi";
    }

    @RequestMapping(value = "/m/precise")
    public String precise(){

        return "m/precise";
    }
    @RequestMapping(value = "/m/saleguzhid/{param:.+}")
    public String saleguzhid(@PathVariable String param,
                             @CookieValue(value = "phone",required = true) String phone,
                             Model model){

        String[] arry = param.split("o");
        String guzhiKey = arry[0];
        String otherKey = arry[1];

        Object data = indexService.saleguzhi(guzhiKey,otherKey, Long.valueOf(phone));

        model.addAttribute("data",data);


        return "m/guzhidetail";
    }
    @RequestMapping(value = "/m/dl")
    public String dl(){
        return "/m/dl";
    }


    @RequestMapping(value = "/m/series/{brandId}")
    public String seriesByBrandId(@PathVariable String brandId,Model model){
        JsonResult result = mindexService.getSeriesByBrand(brandId);
        model.addAttribute("data",result.getData());
        return "m/series";
    }

    @RequestMapping(value = "/m/agreement")
    public String agreement(Model model){

        JsonResult result = mindexService.getAgreement();

        model.addAttribute("context",result.getData());


        return "m/agreement";
    }


    @RequestMapping(value = "/m/yuyue")
    public String yuyue( @CookieValue(value = "phone",required = true) String phone,Model model){

        GuzhiDTO guzhiDTO = indexService.getYuyueInfo(phone);
//        List<Line> lineList = indexService.getLineList();
//        JsonResult result =indexService.getBusinessAddress();
//        JsonResult result1 =indexService.getOneWeek();
//
//        model.addAttribute("shop",result.getData());
//        model.addAttribute("week",result1.getData());
//        model.addAttribute("result",guzhiDTO);
//        model.addAttribute("lines",lineList);
        model.addAttribute("orderInfo", JsonUtils.objectToJson(guzhiDTO));
        return "m/yuyue";
    }

    @RequestMapping(value = "/m/yuyue2/{orderNum}")
    public String yuyue2(@PathVariable String orderNum,Model model){

        Object object = mindexService.getSaleGZByOrder(orderNum);
        JSONObject obj = (JSONObject) object;
        JSONObject gzDetail = obj.getJSONObject("gzDetail");
        gzDetail.put("salePrice",gzDetail.getString("reckonPrice"));
        model.addAttribute("orderInfo", gzDetail);
        return "m/yuyue";
    }




    @RequestMapping(value = "/m/yuyue/4s")
    public String yuyue4s(Model model){
        JsonResult result =indexService.getBusinessAddress();
        model.addAttribute("business",result.getData());
        return "m/4s";
    }

    @RequestMapping(value = "/m/yuyue/site")
    public String yuyueSite(Model model){
        JsonResult result =indexService.getOneWeek();

        model.addAttribute("OSS","http://oss.maizhongcar.com/app/v0.0.1");
        model.addAttribute("week",result.getData());
        return "m/site";
    }

    @RequestMapping(value = "/m/yuyue/address")
    public String yuyueAddress(Model model){
        JsonResult result =indexService.getOneWeek();
        model.addAttribute("week",result.getData());
        return "m/address";
    }

    @RequestMapping(value = "/m/bmap")
    public String bmap(){

        return "m/bmap";
    }
    @RequestMapping(value = "/m/ordersuccess")
    public String ordersuccess(){

        return "m/ordersuccess";
    }
    @RequestMapping(value = "/m/my")
    public String my(@CookieValue(value = "phone",required = false)String phone){
        if (StringUtils.isBlank(phone)) {
            return "redirect:/m/dl";
        }
        return "m/my";
    }

    @RequestMapping(value = "/m/order")
    public String m_order(@CookieValue(value = "phone",required = false)String phone,Model model){
        if (StringUtils.isBlank(phone)) {
            return "redirect:/m/dl";
        }
        Object object = mindexService.getMyorderList(phone);
        if(object==null){
            model.addAttribute("orderList","[]");
        }else {
            model.addAttribute("orderList",object);
        }

        return "m/order";
    }

    @RequestMapping(value = "/m/saleback")
    public String m_saleback(@CookieValue(value = "phone",required = false)String phone,Model model){
        if (StringUtils.isBlank(phone)) {
            return "redirect:/m/dl";
        }
        Object object = mindexService.getMyorderList(phone);
        if(object==null){
            model.addAttribute("orderList","[]");
        }else {
            model.addAttribute("orderList",object);
        }
        return "m/saleback";
    }


    @RequestMapping(value = "/m/orderdetail")
    public String m_orderdetail(@CookieValue(value = "phone",required = false)String phone,
                                Model model){
        if (StringUtils.isBlank(phone)) {
            return "redirect:/m/dl";
        }
        return "m/orderdetail";
    }

    @RequestMapping(value = "/m/help")
    public String m_help(Model model){

        Object object = mindexService.getHelpContent();
        model.addAttribute("list",object);
        return "m/help";
    }

    @RequestMapping(value = "/m/helpdetail/{itemId}")
    public String m_helpdetail(Model model,
                               @PathVariable String itemId){

        Object object = mindexService.getHelpDetail(itemId);
        model.addAttribute("content",object);
        return "m/helpdetail";
    }


    @RequestMapping(value = "/m/about")
    public String m_about(){

        return "m/about";
    }
}
