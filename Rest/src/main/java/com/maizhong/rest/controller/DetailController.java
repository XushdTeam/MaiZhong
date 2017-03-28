package com.maizhong.rest.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.DetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by YangF on 2017/3/27.
 */
@RestController
public class DetailController {


    @Resource
    private DetailService detailService;

    @RequestMapping("/detail/{id}")
    public JsonResult getDetailById(@PathVariable Long id){
        return detailService.getDetailById(id);
    }
}
