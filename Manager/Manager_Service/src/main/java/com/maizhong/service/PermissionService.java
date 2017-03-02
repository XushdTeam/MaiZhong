package com.maizhong.service;

import com.maizhong.pojo.TbPermission;

import java.util.List;

/**
 * 权限服务接口
 * Created by Xushd on 2017/3/1.
 */
public interface PermissionService {


    List<TbPermission> getPermissionByRoleId(Long id);
}
