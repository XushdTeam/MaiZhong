package com.maizhong.youpin.service;

import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/8/16.
 */
public interface AppService {

    JsonResult getNewsList(int pageIndex);

    JsonResult getTokenByDeviceId(String deviceId);

    JsonResult getHelpList();
}
