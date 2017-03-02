package com.maizhong.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.TbRole;

import java.util.List;

/**
 * 角色服务接口
 * Created by Xushd on 2017/3/1.
 */
public interface RoleService {



    /**
     * 通过用户ID 获取ROLE列表 包含权限集合
     * @param userId
     * @return
     */
    List<TbRole> getRoleByUserId(long userId);

    /**
     * 通过分页数据和查询字段获取ROLE列表
     * @param param
     * @return
     */
    PageResult roleList(PageSearchParam param);

    /**
     * 通过ID获取角色信息
     * @param iD
     * @return
     */
    TbRole getRoleById(Long iD);

    /**
     * 角色新增
     * @param role
     * @return
     */
    OperateEnum insertRole(TbRole role);

    /**
     * 角色信息修改
     * @param role
     * @return
     */
    OperateEnum update(TbRole role);

    /**
     * 角色信息删除
     * @param id
     * @return
     */
    OperateEnum deleteRoleById(Long id);



    /**
     * 修改角色权限信息
     * @param permission
     * @param roleId
     * @return
     */
    OperateEnum updateRolePermission(List permission, long roleId);

    /**
     * 获取用户的Role角色All
     * @param id
     * @return
     */
    List<TbRole> getRoleListByUserIdAll(Long id);
}
