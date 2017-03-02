package com.maizhong.service.impl;

import com.maizhong.mapper.TbRoleMapper;
import com.maizhong.pojo.TbRole;
import com.maizhong.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色服务接口实现
 * Created by Xushd on 2017/3/1.
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private TbRoleMapper tbRoleMapper;


    @Override
    public List<TbRole> getRoleByUserId(Long id) {

        return tbRoleMapper.getRoleByUserId(id);
    }
}
