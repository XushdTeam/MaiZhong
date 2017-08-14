package com.maizhong.auction.service;

import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/8/14.
 */
public interface PersonalService {


    JsonResult getPersonalInfo(String token);

    JsonResult getOrderDealOK(String token);

    JsonResult getOrderList(String token);

    JsonResult getBidRecordList(String token);

    JsonResult getLikeCarList(String token);
}
