package com.maizhong.rest.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangF on 2017/3/14.
 */
@Controller
@RequestMapping("/carList")
public class SearchController {

    @Resource
    private SearchService searchService;


    @RequestMapping("/sync")
    @ResponseBody
    public JsonResult testOfSync(){
        System.out.println("方法执行中");
        return searchService.syncIndex();
    }


    /**
     * solr 查询主接口
     * @param param
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public JsonResult Search(PageSearchParam param){
        return searchService.searchDoc(param);
    }

    /***
     * 返回词典列表数据
     * @param
     * @return
     */
    @RequestMapping("/dicList")
    @ResponseBody
    public JsonResult dicList(@RequestParam("type") Long typeId){
        return searchService.searchDicList(typeId);
    }



    /***
     * 返回车型列表数据
     * @param
     * @return
     */
    @RequestMapping("/carBrandList")
    @ResponseBody
    public JsonResult carTypeList(){
        return searchService.searchCarBrandList();
    }




    /***
     * 返回车系列表数据
     * @param
     * @return
     */
    @RequestMapping("/carBrandLineList")
    @ResponseBody
    public JsonResult carTypeList(Long brandId){
        return searchService.searchBrandLineList(brandId);
    }
}
