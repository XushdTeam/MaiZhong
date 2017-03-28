package com.maizhong.portal.service;

import com.maizhong.common.dto.IndexBaseDTO;
import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbFeedback;

import java.util.List;
import java.util.Map;

/**
 * Portal Index服务接口层
 * Created by Xushd on 2017/3/13.
 */
public interface IndexService {

    String getFeedBackUrl();

    boolean saveFeedback(TbFeedback feedback);


    Map<String,Object> getIndexBase();

    Map<String,Object> getCarDetail(String carId);
}
