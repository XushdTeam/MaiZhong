package com.maizhong.reckon.service;

import com.maizhong.common.result.JsonResult;
import com.maizhong.reckon.DTO.IndexDTO;

/**
 * Created by Xushd on 2017/4/18.
 */
public interface IndexService {

    IndexDTO getIndexDTO();

    JsonResult getSeries(String brandId);

    JsonResult getCarType(String seriesId);
}
