package com.maizhong.rest.service;

import com.maizhong.common.result.JsonResult;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-18
 * Time: 9:57
 */
public interface AppService {
    JsonResult getTokenByDeciceId(String deviceId);
}
