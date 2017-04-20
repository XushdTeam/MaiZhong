package com.maizhong.reckon.service;

import com.maizhong.common.dto.GuzhiDTO;
import com.maizhong.common.result.JsonResult;

import com.maizhong.reckon.DTO.IndexDTO;

/**
 * Created by Xushd on 2017/4/18.
 */
public interface IndexService {

    IndexDTO getIndexDTO();

    JsonResult getSeries(String brandId);

    JsonResult getCarType(String seriesId);

    JsonResult getAllCity();

    GuzhiDTO getGuZhi(String param);

    IndexDTO getIndexDTO(String param);

    String saleguzhi(String guzhiKey, String otherKey, Long phone);
}
