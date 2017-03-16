package com.maizhong.rest.service;

import com.maizhong.common.result.JsonResult;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-13
 * Time: 15:05
 */
public interface SpreadService {
    /**
     * 根据广告类型获取广告列表/getAdvert/{type}
     * @param type
     * @return
     */
    JsonResult getAdvertByType(Integer type);
    /**
     * 获取首页品牌信息
     * @return
     */
    public JsonResult getIndexBrand();

    JsonResult getIndexCarType();

    JsonResult getCarColumnById(Integer columnId);
}
