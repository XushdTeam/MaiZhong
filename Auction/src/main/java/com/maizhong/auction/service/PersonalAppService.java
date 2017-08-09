package com.maizhong.auction.service;

import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/8/1.
 */
public interface PersonalAppService {
    JsonResult getToken(String deviceId);

    JsonResult getVerifyCode(long phone);

    JsonResult login(long phone, String verifyCode, String token);

    JsonResult feedback(String content, String token);

    JsonResult getNewsList();

    JsonResult getNewsDetail(long id);

    JsonResult getProblemList();

    JsonResult getProblemDetail(long id);

    JsonResult changeHeadImg(String imgStr, String token);

    JsonResult saleCar(long phone, int cityId, String token);


    JsonResult myCarList(String token);

    JsonResult getCarDetail(long carId);
}
