package com.maizhong.rest.controller;

import com.maizhong.common.result.JsonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 推广信息接口
 * Created by Xushd on 2017/3/7.
 */
@RestController
public class SpreadController {



    @RequestMapping("/getSpread/{type}")
    public JsonResult getSpread(@PathVariable Integer type){

        return JsonResult.OK();
    }

}
