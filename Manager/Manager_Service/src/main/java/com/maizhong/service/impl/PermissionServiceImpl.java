package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.dto.PermissionResult;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ServiceLog;
import com.maizhong.mapper.TbPermissionMapper;
import com.maizhong.pojo.TbPermission;
import com.maizhong.pojo.TbPermissionExample;
import com.maizhong.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 权限服务接口实现
 * Created by Xushd on 2017/3/1.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private TbPermissionMapper permissionMapper;


    @ServiceLog(module = "权限管理",methods = "获取角色权限")
    @Override
    public List<TbPermission> getPermissionByRoleId(Long systemRoleId) {
        return permissionMapper.getPermissionByRoleId(systemRoleId);
    }


    @Override
    public PageResult getPermissionList(PageSearchParam pageSearchParam) {

        PageHelper.startPage(pageSearchParam.getPageIndex(),pageSearchParam.getPageSize());

        TbPermissionExample example = new TbPermissionExample();
        TbPermissionExample.Criteria criteria = example.createCriteria();
        Map<String, String> searchFileds = pageSearchParam.getSearchFileds();
        if (searchFileds.containsKey("name")){
            criteria.andPermissionNameLike(searchFileds.get("name"));
        }
        if (searchFileds.containsKey("key")){
            criteria.andPermissionKeyEqualTo(searchFileds.get("key"));
        }
        List<TbPermission> systemPermissionList = permissionMapper.selectByExample(example);
        PageInfo pageInfo= new PageInfo(systemPermissionList);
        return new PageResult(pageInfo);
    }

    @ServiceLog(module = "权限管理",methods = "权限新增")
    @Override
    public OperateEnum insertPermission(TbPermission permission) {
        int res = permissionMapper.insertSelective(permission);
        if(res>0){
            return OperateEnum.SUCCESS;
        }else{
            return OperateEnum.FAILE;
        }
    }


    @Override
    public TbPermission getPermissionById(long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @ServiceLog(module = "权限管理",methods = "获取权限列表")
    @Override
    public List<TbPermission> getPermissionList(Boolean isParent) {

        TbPermissionExample example = new TbPermissionExample();
        TbPermissionExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0).andParentEqualTo(0L);
        example.setOrderByClause("sort");
        List<TbPermission> permissionList = permissionMapper.selectByExample(example);
        if (isParent){
            return permissionList;
        }
        List<TbPermission> resultList = new ArrayList<>();
        for (TbPermission permission : permissionList) {
            resultList.add(permission);
            TbPermissionExample example1 = new TbPermissionExample();
            TbPermissionExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andDelflagEqualTo(0).andParentEqualTo(permission.getId());
            example1.setOrderByClause("sort");
            resultList.addAll(permissionMapper.selectByExample(example1));
        }
        return resultList;
    }

    @ServiceLog(module = "权限管理",methods = "权限修改")
    @Override
    public OperateEnum updatePermission(TbPermission permission) {
        int res = permissionMapper.updateByPrimaryKeySelective(permission);
        if(res>0){
            return OperateEnum.SUCCESS;
        }else{
            return OperateEnum.FAILE;
        }
    }

    @ServiceLog(module = "权限管理",methods = "权限删除")
    @Override
    public OperateEnum deletePermission(long id) {
        //逻辑删除
        TbPermission permission = new TbPermission();
        permission.setDelflag(1);
        permission.setStatus(null);
        permission.setId(id);
        //criteria.
        int res =  permissionMapper.updateByPrimaryKeySelective(permission);
        if(res>0){
            return OperateEnum.SUCCESS;
        }else{
            return OperateEnum.FAILE;
        }
    }

    @ServiceLog(module = "角色管理",methods = "获取角色对应的全部权限")
    @Override
    public List<PermissionResult> getRolePermission(Long roleId) {

        List<PermissionResult> resultList = new ArrayList<>();
        List<TbPermission> parentList = permissionMapper.getPermissionByRoleIdAll(roleId,0L);
        for (TbPermission permission : parentList) {
            List<TbPermission> childList = permissionMapper.getPermissionByRoleIdAll(roleId,permission.getId());
            PermissionResult parentResult = new PermissionResult(permission.getId(),permission.getPermissionName(),permission.getPermissionKey(),permission.getIsChecked());
            List<PermissionResult> childListResult = new ArrayList<>();
            for (TbPermission permission_c : childList) {
                childListResult.add(new PermissionResult(permission_c.getId(),permission_c.getPermissionName(),permission_c.getPermissionKey(),permission_c.getIsChecked()));
            }
            parentResult.setList(childListResult);
            resultList.add(parentResult);
        }

        return resultList;
    }





}
