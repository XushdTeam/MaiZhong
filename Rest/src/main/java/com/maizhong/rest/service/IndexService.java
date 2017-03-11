package com.maizhong.rest.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/3/3.
 */
public interface IndexService {


    JsonResult login(String username, String password);

    JsonResult getBaseInfo();

    JsonResult getInterfaceList(PageSearchParam pageSearchParam);
}
