package com.maizhong.rest.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangF on 2017/3/14.
 */
@Controller
@RequestMapping("/test")
public class SearchController {

    @Resource
    private SearchService searchService;


    @RequestMapping("/sync")
    @ResponseBody
    public JsonResult testOfSync(){
        System.out.println("方法执行中");
        return searchService.syncIndex();
    }


    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println("方法执行中");
        return "haha";
    }


    @RequestMapping("/test/{param}")
    @ResponseBody
    public JsonResult test(@PathVariable("param") String q){
        PageSearchParam param = new PageSearchParam();
        Map<String, String> map = new HashMap<>();
        map.put("queryString",q);
        System.out.println("方法执行中");
        return  searchService.searchDoc(param);
    }




}
