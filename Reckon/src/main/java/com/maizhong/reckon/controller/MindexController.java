package com.maizhong.reckon.controller;

import com.maizhong.common.dto.GuzhiDTO;
import com.maizhong.common.result.JsonResult;
import com.maizhong.reckon.service.IndexService;
import com.maizhong.reckon.service.MindexService;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
}
