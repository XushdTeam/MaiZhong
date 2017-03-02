package com.maizhong.service;

import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbMenu;

import java.util.List;

/**
 * 菜单服务接口
 * Created by Xushd on 2017/3/1.
 */
public interface MenuService {

    JsonResult getMenuListForWeb(String typeId);

    /**
     * isParent True 获取父节点菜单 False 获取所有菜单
     * @param isParent
     * @return
     */
    List<TbMenu> getMenuList(Boolean isParent);

    TbMenu getMenuById(Long id);

    OperateEnum insertMenu(TbMenu menu);

    OperateEnum updateMenu(TbMenu menu);

    OperateEnum deleteMenu(long id);

    OperateEnum menuRedisClear();
}
