package com.maizhong.portal.service;

import com.maizhong.common.dto.PageSearchParam;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/16.
 */
public interface SearchService {
    Map<String,Object> search(PageSearchParam pageSearchParam);
}
