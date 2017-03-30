package com.maizhong.rest.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbDictionary;
import com.maizhong.pojo.vo.SearchResult;
import com.maizhong.rest.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangF on 2017/3/14.
 */
@Controller
public class SearchController {

    @Resource
    private SearchService searchService;



    @RequestMapping("/sync")
    @ResponseBody
    public JsonResult testOfSync(){
        return searchService.syncIndex();
    }

    /***
     * 返回车系列表数据
     * @param brandId,seriesID
     * @return
     */
    @RequestMapping("/getSearchBase")
    @ResponseBody
    public JsonResult getSearchBase(String brandId,String seriesId){
        return searchService.getSearchBase(brandId,seriesId);
    }


    @RequestMapping("/getSearchResult")
    @ResponseBody
    public JsonResult getSearchResult(String queryString,String sortString, String carBrand,
                                      String carSeries,String sellPrice,String capacity,String carYear,String pageIndex){
        if (StringUtils.isNotBlank(queryString)){
            try {
                queryString = new String(queryString.getBytes("iso-8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e) {
                queryString = queryString;
                e.printStackTrace();
            }
        }

        JsonResult jsonResult = searchService.getSearchResult(queryString, sortString, carBrand, carSeries, sellPrice, capacity, carYear, pageIndex);
        return jsonResult;
    }
}
