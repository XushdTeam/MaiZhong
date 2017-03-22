package com.maizhong.portal.service;

import com.maizhong.common.result.JsonResult;

import java.util.List;
import java.util.Map;

/**
 * Portal Index服务接口层
 * Created by Xushd on 2017/3/13.
 */
public interface IndexService {


    String getAdvert(int advertType);

    List<Map> getCarBrand();

    List<Map> getCarType();

    String getFeedBackUrl();

    JsonResult saveFeedback(String c, String p, String n, String r);
}
