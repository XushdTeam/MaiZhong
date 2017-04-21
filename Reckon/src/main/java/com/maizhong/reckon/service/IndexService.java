package com.maizhong.reckon.service;

import com.maizhong.common.dto.GuzhiDTO;
import com.maizhong.common.result.JsonResult;

import com.maizhong.pojo.Line;
import com.maizhong.reckon.DTO.IndexDTO;

import java.util.List;

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

    GuzhiDTO getYuyueInfo(String phone);

    List<Line> getLineList();

    JsonResult getSiteByLineId(String lineId);

    JsonResult getBusinessAddress();

    JsonResult getOneWeek();

    JsonResult orderConfim(String orderNumber, String dealWay, String wayId, String linkMan, String linkPhone, String address);
}
