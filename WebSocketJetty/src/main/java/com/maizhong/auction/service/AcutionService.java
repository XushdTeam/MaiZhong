package com.maizhong.auction.service;

import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/6/28.
 */
public interface AcutionService {
    JsonResult getCarNow();

    JsonResult addPrice(String ch, long carId, long plus, long price);
}
