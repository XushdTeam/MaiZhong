package com.maizhong.rest.service;

import com.maizhong.common.dto.CarShowIndex;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;

import java.util.List;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-13
 * Time: 15:05
 */
public interface SpreadService {

    JsonResult getCarColumnById(Integer columnId,Integer number);

    List<CarShowIndex> getHomeItem();

    OperateEnum insertFeedback(String phone, String content, String surname);

    OperateEnum insertConsult(String phone,String type);

    JsonResult getHotSeries();

    JsonResult getIndexBase();
}
