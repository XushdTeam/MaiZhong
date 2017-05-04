package com.maizhong.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.Help;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-05-03
 * Time: 13:36
 */
public interface AppHelpService {
    PageResult getHelpList(PageSearchParam param);


    Help getHelpById(Long aLong);

    OperateEnum insertHelp(Help help);

    OperateEnum deleteHelpById(long id);

    OperateEnum updateHelp(Help help);

    OperateEnum updateHelpRedis();
}
