package com.maizhong.rest.service.impl;

import com.maizhong.common.dto.KeyObject;
import com.maizhong.common.dto.KeyValue;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.EncryptUtils;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.BrandMapper;
import com.maizhong.pojo.Brand;
import com.maizhong.rest.service.AppService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-18
 * Time: 10:43
 */

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private JedisClient jedisClient;
    @Autowired
    private BrandMapper brandMapper;

    @Value("${UNLOGIN_TOKEN}")
    private String UNLOGIN_TOKEN;

    @Value("${BRAND_GROUP_INITIAL}")
    private String BRAND_GROUP_INITIAL;

    /**
     * 根据设备Id获取token
     *
     * @param deviceId
     * @return
     */
    @Override
    public JsonResult getTokenByDeciceId(String deviceId) {
        try {
            String hget = jedisClient.get(UNLOGIN_TOKEN + ":" + deviceId);
            if (StringUtils.isNotBlank(hget)) {
                return JsonResult.build(200, "获取成功", hget);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String token = EncryptUtils.getSHA256Str(deviceId + "*#$maizhong!*");

        try {
            jedisClient.set(UNLOGIN_TOKEN + ":" + deviceId, token);
            jedisClient.expire(UNLOGIN_TOKEN + ":" + deviceId, 60 * 60 * 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(200, "获取成功", token);
    }

}
