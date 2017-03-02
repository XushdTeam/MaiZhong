package com.maizhong.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.dto.PermissionResult;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.TbPermission;

import java.util.List;

/**
 * 权限服务接口
 * Created by Xushd on 2017/3/1.
 */
public interface PermissionService {


    List<TbPermission> getPermissionByRoleId(Long id);

    PageResult getPermissionList(PageSearchParam pageSearchParam);

    OperateEnum insertPermission(TbPermission permission);

    TbPermission getPermissionById(long id);


    List<TbPermission> getPermissionList(Boolean isParent);

    OperateEnum updatePermission(TbPermission permission);

    OperateEnum deletePermission(long id);

    List<PermissionResult> getRolePermission(Long roleId);
}
