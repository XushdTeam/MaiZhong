package com.maizhong.rest.controller;

import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.ReckonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 估值Controller
 * Created by Xushd on 2017/4/18.
 */
@Controller
public class ReckonController {

    @Autowired
    private ReckonService reckonService;

    @RequestMapping(value = "/GetBrandData")
    @ResponseBody
    public JsonResult GetBrandData(){
        reckonService.getBrandData();
        return JsonResult.OK();
    }


}
