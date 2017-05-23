package com.maizhong.service;

import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.Document;

import java.util.List;

/**
 * Created by Xushd on 2017/5/22.
 */
public interface DocumentService {


    PageResult getDocList(PageSearchParam param);

    Document getDocById(long id);

    JsonResult insertDoc(Document doc);

    JsonResult update(Document doc);

    JsonResult deleteById(String id);

    JsonResult documentRedisSync();

}
