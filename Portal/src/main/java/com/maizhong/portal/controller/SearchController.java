package com.maizhong.portal.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @Resource
    private SearchService searchService;

    @RequestMapping("/")
    public String searchIndex(PageSearchParam pageSearchParam, Model model){

        Map<String,Object> result = searchService.search(pageSearchParam);
        model.addAllAttributes(result);

        return "search";
    }




}
