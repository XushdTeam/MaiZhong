package com.maizhong.service;

import com.maizhong.pojo.TbRole;

import java.util.List;

/**
 * 角色服务接口
 * Created by Xushd on 2017/3/1.
 */
public interface RoleService {


    List<TbRole> getRoleByUserId(Long id);
}
