package com.maizhong.portal.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.pojo.vo.SearchResult;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/16.
 */
public interface SearchService {
    SearchResult search(PageSearchParam pageSearchParam);
}
