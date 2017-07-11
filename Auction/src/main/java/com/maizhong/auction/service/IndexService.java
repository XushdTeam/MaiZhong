package com.maizhong.auction.service;

import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/7/3.
 */
public interface IndexService {
    JsonResult loginCheck(String account, String password, boolean checked);

    JsonResult checkLoginStatus(String token);

    String getSystemMenu(String token);

    JsonResult logOff(String token);
}
