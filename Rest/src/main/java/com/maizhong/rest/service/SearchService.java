package com.maizhong.rest.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;

/**
 * Created by yangF on 2017/3/14.
 */
public interface SearchService {
    /**
    * 数据库同步索引
    * */
    public JsonResult syncIndex();


    public JsonResult searchDoc(PageSearchParam param);

}
