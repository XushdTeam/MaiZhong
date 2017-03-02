package com.maizhong.service;

import com.maizhong.common.result.JsonResult;

/**
 * 菜单服务接口
 * Created by Xushd on 2017/3/1.
 */
public interface MenuService {

    JsonResult getMenuListForWeb(String typeId);
}
