package com.maizhong.auction.service;

import com.maizhong.auction.dto.CarInfoDto;
import com.maizhong.common.result.JsonResult;

import java.util.List;

/**
 * Created by Xushd on 2017/8/14.
 */
public interface PersonalService {


    JsonResult getPersonalInfo(String token);

    List<CarInfoDto> getOrderDealOK(String token);

    List<CarInfoDto> getOrderList(String token);

    List<CarInfoDto> getBidRecordList(String token);

    List<CarInfoDto> getLikeCarList(String token);
}
