package com.maizhong.rest.service;

import com.maizhong.common.result.JsonResult;

/**
 * Created by Administrator on 2017/4/3.
 */
public interface QczjhttpService {

    public JsonResult returnCarSeries(Long BrandId);

    public JsonResult returnCarType(Long seriesId);

   abstract JsonResult calculatePrice(String bid, String sid, String specId,
                                      String registerYear, String registerMonth,
                                      String selectCarName);

    JsonResult carBrandCallback(Long specid);
}

