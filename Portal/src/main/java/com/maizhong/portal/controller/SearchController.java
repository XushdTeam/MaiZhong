package com.maizhong.portal.controller;

import com.google.common.collect.Maps;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.pojo.vo.SearchResult;
import com.maizhong.portal.service.IndexService;
import com.maizhong.portal.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

/**
 * Created by YangF on 2017/3/16.
 */
@Controller
/*@RequestMapping("/search")*/
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("/info")
    public String searchIndex(PageSearchParam pageSearchParam, Model model) {
        //乱码处理
//        new String(entry.getValue().getBytes("iso8859-1"),"UTF-8")
        if (pageSearchParam != null && pageSearchParam.getSearchFileds() != null) {
            for (Map.Entry<String, String> entry : pageSearchParam.getSearchFileds().entrySet()) {
                try {
                    entry.setValue(new String(entry.getValue().getBytes("iso8859-1"), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        SearchResult search = searchService.search(pageSearchParam);
        model.addAttribute("searchResult", search);
        model.addAttribute("searchUrl", "/search/info.html");
        return "search";
    }

    @RequestMapping(value = "/car/list.html",method = RequestMethod.GET)
    public String carList(Model model,String s){
        Map<String,String> param = Maps.newHashMap();
        param.put("s","d");
        param.put("m","1");
        param.put("b","0");
        param.put("se","0");
        param.put("p","0");
        param.put("v","0");
        param.put("pe","1");
        if(StringUtils.isNotBlank(s)){
            try {
                param.put("qs", new String(s.getBytes("ISO8859-1"),"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else{
            param.put("qs","");
        }
        model = searchService.getSearchResult(param,model);
        return "search";

    }

    /**
     * 品牌+车系+价格+排量
     *
     * @param brandId
     * @param seriseId
     * @param price
     * @param volume
     * @param model
     * @return
     */
    @RequestMapping(value = "/car/cb_{brandId}/cs_{seriseId}/cp_{price}/cv_{volume}/list.html")
    public String searchlist(@PathVariable String brandId,
                             @PathVariable String seriseId,
                             @PathVariable String price,
                             @PathVariable String volume,
                             String s,
                             Model model) {
        Map<String,String> param = Maps.newHashMap();
        param.put("s","d");
        param.put("m","1");
        param.put("b",brandId);
        param.put("se",seriseId);
        param.put("p",price);
        param.put("v",volume);
        param.put("pe","1");

        if(StringUtils.isNotBlank(s)){
            try {
                param.put("qs", new String(s.getBytes("ISO8859-1"),"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else{
            param.put("qs","");
        }

        model = searchService.getSearchResult(param,model);
        return "search";
    }


    /**
     * 查询带更多条件
     * @param model
     * @return
     */
    @RequestMapping(value = "/car/s_{sort}_{method}_{page}/cb_{brandId}/cs_{seriseId}/cp_{price}/cv_{volume}/list.html",method = RequestMethod.GET)
    public String searchListMore(
                    @PathVariable String sort,
                    @PathVariable String method,
                    @PathVariable String brandId,
                    @PathVariable String seriseId,
                    @PathVariable String price,
                    @PathVariable String volume,
                    @PathVariable String page,
                    String s,
                    Model model){

        Map<String,String> param = Maps.newHashMap();
        param.put("s",sort);
        param.put("m",method);
        param.put("b",brandId);
        param.put("se",seriseId);
        param.put("p",price);
        param.put("v",volume);
        param.put("pe",page);
        if(StringUtils.isNotBlank(s)){
            try {
                param.put("qs", new String(s.getBytes("ISO8859-1"),"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else{
            param.put("qs","");
        }
        model = searchService.getSearchResult(param,model);

        return "search";
    }

}
