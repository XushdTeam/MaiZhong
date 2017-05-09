package com.maizhong.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.Version;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-05-03
 * Time: 13:36
 */
public interface AppVersionService {
    PageResult getVersionList(PageSearchParam param);


    Version getVersionById(Long aLong);

    OperateEnum insertVersion(Version version);

    OperateEnum deleteVersionById(long id);

    OperateEnum updateVersion(Version version);

    OperateEnum updateVersionRedis();
}
