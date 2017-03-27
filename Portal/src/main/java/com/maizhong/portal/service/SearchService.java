package com.maizhong.portal.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.pojo.vo.SearchResult;
import org.springframework.ui.Model;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/16.
 */
public interface SearchService {
    SearchResult search(PageSearchParam pageSearchParam);

    Map<String,Object> getSearchResult(String bId, String sId, String pId, String vId);

    Model getSearchResult(Map<String, String> param,Model model);
}
