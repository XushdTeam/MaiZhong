package com.maizhong.youpin.service;

import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/8/16.
 */
public interface AppService {

    JsonResult getNewsList(int pageIndex);

    JsonResult getTokenByDeviceId(String deviceId);

    JsonResult getHelpList();

    JsonResult sendVerifyCode(String phone);

    JsonResult login(String phone, String verifyCode, String token);

    JsonResult logout(String token);

    JsonResult getCompanyList();

    JsonResult updateUserInfo(long company, String companyName, String name, int job, String token);

    JsonResult changHeadImg(String headimg, String token);

    JsonResult syncUserInfo(String token);

    JsonResult getModelDetail(String guzhiKey, String otherKey, String token);

    JsonResult saveSaleRecord(String imgArry,String token);

    JsonResult getRecordList(String token);

    JsonResult getJobList();
}
