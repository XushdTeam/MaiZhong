package com.maizhong.service.impl;

import com.maizhong.mapper.TbPermissionMapper;
import com.maizhong.pojo.TbPermission;
import com.maizhong.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限服务接口实现
 * Created by Xushd on 2017/3/1.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private TbPermissionMapper permissionMapper;



    @Override
    public List<TbPermission> getPermissionByRoleId(Long id) {
        return permissionMapper.getPermissionByRoleId(id);
    }
}
