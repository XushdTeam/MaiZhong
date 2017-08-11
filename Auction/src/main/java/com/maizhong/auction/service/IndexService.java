package com.maizhong.auction.service;

import com.maizhong.auction.dto.CarDetailDto;
import com.maizhong.auction.dto.CarInfoDto;
import com.maizhong.auction.pojo.AcUser;
import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/7/3.
 */
public interface IndexService {
    JsonResult loginCheck(String account, String password, boolean checked);

    JsonResult checkLoginStatus(String token);

    String getSystemMenu(String token);

    JsonResult logOff(String token);

    JsonResult loginByPhone(long phone, String verify);

    JsonResult getVerifyCodeRegist(long phone);

    JsonResult registUser(long phone, String verify,int type);

    AcUser getUserInfo(String token);

    JsonResult loginByPass(long account, String pass);

    JsonResult getTopCar(String token);

    CarDetailDto getCarDetail(long carId);

    CarInfoDto getCarInfo(long carId);

    JsonResult getCarNow(long carId, String token);

    JsonResult getBidRecordList(long auctionId);
}
