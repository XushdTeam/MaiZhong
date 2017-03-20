package com.maizhong.rest.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbCarBrand;
import com.maizhong.pojo.TbDictionary;
import com.maizhong.pojo.vo.SearchResult;
import com.maizhong.rest.service.SearchService;
import com.maizhong.rest.service.SpreadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

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

        if (param == null){
            param = new PageSearchParam();
        }

        return searchService.searchDoc(param);
    }


    /**
     * 前台搜索页面
     *      完全匹配数据接口
     *      包括
     *              参数回显
     *              solr查询数据
     *                  以及
     *                      车型
     *                      汽车品牌
     *                      车系
     *                      颜色列表
     *                      变速箱类型
     * */
    @RequestMapping("/searchPage")
    public JsonResult searchPageCallBack(PageSearchParam param){
        SearchResult result = searchService.searchPageResult(param);
        return JsonResult.OK(result);
    }


    /***
     * 返回词典列表数据
     * @param
     * @return
     */
    @RequestMapping("/dicList")
    @ResponseBody
    public JsonResult dicList(@RequestParam("type") Long typeId) {
        List<TbDictionary> tbDictionaries = searchService.searchDicList(typeId);
        return tbDictionaries==null?JsonResult.Error("数据错误"):JsonResult.OK(tbDictionaries);
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
