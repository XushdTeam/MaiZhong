package com.maizhong.reckon.service;

import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.Model;

/**
 * Created by Xushd on 2017/6/1.
 */
public interface MindexService {
    JsonResult getSeriesByBrand(String brandId);

    JsonResult getModelBySeries(String seriesId);

    Object getModelById(String modelId);

    Object getGuzhi(String param);
}
