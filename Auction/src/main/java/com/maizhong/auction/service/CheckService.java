package com.maizhong.auction.service;

import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/6/14.
 */
public interface CheckService {
    JsonResult checkLogin(String account, String pass);
}
