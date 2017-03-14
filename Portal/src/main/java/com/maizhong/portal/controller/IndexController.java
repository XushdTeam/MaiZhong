package com.maizhong.portal.controller;

import com.maizhong.common.enums.DicParentEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.portal.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商城首页
 * Created by Xushd on 2017/3/3.
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/index")
    public String index(Model model){

        String adJson = indexService.getAdvert(14);
        String carBrand = indexService.getCarBrand();
        model.addAttribute("adJson", adJson);
        return "index";
    }





}
