package com.maizhong.portal.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.pojo.vo.SearchResult;
import com.maizhong.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by YangF on 2017/3/16.
 */
@Controller
/*@RequestMapping("/search")*/
public class SearchController {

    @Resource
    private SearchService searchService;

    @RequestMapping("/info")
    public String searchIndex(PageSearchParam pageSearchParam, Model model){
        //乱码处理
//        new String(entry.getValue().getBytes("iso8859-1"),"UTF-8")
        if (pageSearchParam!=null&&pageSearchParam.getSearchFileds()!=null){
            for (Map.Entry<String,String> entry:pageSearchParam.getSearchFileds().entrySet()) {
                try {
                    entry.setValue(new String(entry.getValue().getBytes("iso8859-1"),"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        SearchResult search = searchService.search(pageSearchParam);
        model.addAttribute("searchResult",search);
        model.addAttribute("searchUrl","/search/info.html");
        return "search";
    }
    @RequestMapping(value = "/car")
    public String carlist(){

        return "search";
    }
}
