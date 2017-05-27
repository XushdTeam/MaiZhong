package com.maizhong.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/5/25.
 */
public interface InterFaceRedisService {
    JsonResult selectProvice(PageSearchParam param);

    JsonResult proviceRedis();


    JsonResult proviceSyncOSS();

    JsonResult selectCity(PageSearchParam param);

    JsonResult cityRedis();

    JsonResult syncInter();

    JsonResult citySyncOSS();

    JsonResult selectBrand(PageSearchParam param);

    JsonResult brandHotChange(long brandId, int i);

    JsonResult brandRedis();

    JsonResult brandSyncInter();

    JsonResult brandSyncOSS();

    JsonResult seriesList(PageSearchParam param);

    JsonResult seriesSyncInter();
}
