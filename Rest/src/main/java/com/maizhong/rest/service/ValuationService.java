package com.maizhong.rest.service;

/**
 * 评估 接口
 *
 *
 * Created by YangF on 2017/3/31.
 */
public interface ValuationService {

    Double[] valuation(Long baseId, String useDate, Double journey) throws IllegalAccessException;
}
