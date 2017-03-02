package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ServiceLog;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.mapper.TbRoleMapper;
import com.maizhong.mapper.TbRolePermissionMapper;
import com.maizhong.mapper.TbUserRoleMapper;
import com.maizhong.pojo.TbRole;
import com.maizhong.pojo.TbRoleExample;
import com.maizhong.pojo.TbRolePermissionExample;
import com.maizhong.pojo.TbUserRoleExample;
import com.maizhong.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色服务接口实现
 * Created by Xushd on 2017/3/1.
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private TbRoleMapper tbRoleMapper;

    @Autowired
    private TbRolePermissionMapper rolePermissionMapper;

    @Autowired
    private TbUserRoleMapper userRoleMapper;

    @Override
    public List<TbRole> getRoleByUserId(long userId) {

        return tbRoleMapper.getRoleByUserId(userId);
    }

    @ServiceLog(module = "角色管理", methods = "角色列表")
    @Override
    public PageResult roleList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        TbRoleExample example = new TbRoleExample();
        TbRoleExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("id");
        if (param.getFiled("roleName") != null) {
            criteria.andRoleNameLike(SqlUtils.getLikeSql(param.getFiled("roleName")));
        }
        List<TbRole> roleList = tbRoleMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(roleList);
        return new PageResult(pageInfo);
    }

    @Override
    public TbRole getRoleById(Long iD) {
        return tbRoleMapper.selectByPrimaryKey(iD);
    }


    @ServiceLog(module = "角色管理", methods = "角色新增")
    @Override
    public OperateEnum insertRole(TbRole role) {
        int res = tbRoleMapper.insertSelective(role);
        if(res>0){
            return OperateEnum.SUCCESS;
        }else{
            return OperateEnum.FAILE;
        }
    }
    @ServiceLog(module = "角色管理", methods = "角色修改")
    @Override
    public OperateEnum update(TbRole role) {
        int res = tbRoleMapper.updateByPrimaryKeySelective(role);
        if(res>0){
            return OperateEnum.SUCCESS;
        }else {
            return OperateEnum.FAILE;
        }
    }


    @ServiceLog(module = "角色管理", methods = "角色删除")
    @Override
    public OperateEnum deleteRoleById(Long id) {
        //判断该角色是否分配给用户了
        TbUserRoleExample example = new TbUserRoleExample();
        TbUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(id);
        long count = userRoleMapper.countByExample(example);
        if (count > 0) {
            return OperateEnum.ROLE_IS_USED;
        } else {
            TbRole role = new TbRole();
            role.setId(id);
            role.setStatus(null);
            role.setDelflag(1);
            int res = tbRoleMapper.updateByPrimaryKeySelective(role);
            if (res > 0) {
                return OperateEnum.SUCCESS;
            } else {
                return OperateEnum.FAILE;
            }
        }
    }

    @ServiceLog(module = "角色管理", methods = "修改角色的权限信息")
    @Override
    public OperateEnum updateRolePermission(List permission, long roleId) {

        //删除roleId拥有的所有权限
        TbRolePermissionExample example = new TbRolePermissionExample();
        TbRolePermissionExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        rolePermissionMapper.deleteByExample(example);
        //判断permission是否为NULL
        if (permission == null) {
            return OperateEnum.SUCCESS;
        } else {
            //批量插入权限信息
            List<Map<String, String>> list = new ArrayList<>();
            for (Object id : permission) {
                Map<String, String> map = new HashMap<>();
                map.put("permissionId", String.valueOf(id));
                map.put("roleId", String.valueOf(roleId));
                list.add(map);
            }
            int ret = rolePermissionMapper.insertRolePermission(list);
            if (ret > 0) {
                return OperateEnum.SUCCESS;
            } else {
                return OperateEnum.FAILE;
            }
        }
    }

    @Override
    public List<TbRole> getRoleListByUserIdAll(Long id) {


        return tbRoleMapper.gerRoleListByUserIdAll(id);
    }
}
