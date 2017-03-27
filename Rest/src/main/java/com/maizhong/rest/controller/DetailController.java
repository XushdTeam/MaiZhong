package com.maizhong.rest.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.DetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YangF on 2017/3/27.
 */
@RequestMapping("/detail")
@RestController
public class DetailController {


    private DetailService detailService;

    @RequestMapping("/{id}")
    public JsonResult getDetailById(@PathVariable Long id){
        return detailService.getDetailById(id);
    }



}
