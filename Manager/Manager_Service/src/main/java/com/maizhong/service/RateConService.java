package com.maizhong.service;

import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.Rate;
import com.maizhong.pojo.TbDictionary;

import java.util.List;

/**
 * Created by Xushd on 2017/5/24.
 */
public interface RateConService {
    List<Rate> getRateList(List<TbDictionary> dicListByParent);

    JsonResult updateRate(Integer id, float rate,String userName);
}
