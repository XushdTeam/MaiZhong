package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ServiceLog;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.mapper.TbRoleMapper;
import com.maizhong.mapper.TbUserMapper;
import com.maizhong.mapper.TbUserRoleMapper;
import com.maizhong.pojo.TbRole;
import com.maizhong.pojo.TbUser;
import com.maizhong.pojo.TbUserExample;
import com.maizhong.pojo.TbUserRoleExample;
import com.maizhong.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户服务接口实现
 * Created by Xushd on 2017/3/1.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private TbUserRoleMapper tbUserRoleMapper;

    @Autowired
    private TbRoleMapper tbRoleMapper;



    @Override
    public TbUser getSystemUserByUserPhone(String userPhone) {
        TbUserExample systemUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = systemUserExample.createCriteria();
        criteria.andUserPhoneEqualTo(userPhone).andDelflagEqualTo(0);
        List<TbUser> systemUsers = tbUserMapper.selectByExample(systemUserExample);
        if (systemUsers == null || systemUsers.size() == 0) return null;
        return systemUsers.get(0);
    }

    @ServiceLog(module = "用户管理", methods = "用户列表")
    @Override
    public PageResult getUserList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        if (param.getFiled("userName") != null) {
            criteria.andUserNameLike(SqlUtils.getLikeSql(param.getFiled("userName")));
        }
        if (param.getFiled("userPhone") != null) {
            criteria.andUserPhoneEqualTo(param.getFiled("userPhone"));
        }
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("id DESC");
        List<TbUser> list = tbUserMapper.selectByExample(example);
        for (TbUser user : list) {
            List<TbRole> roleList = tbRoleMapper.getRoleByUserId(user.getId());
            List<String> roleName = new ArrayList<>();
            for (TbRole role : roleList) {
                roleName.add(role.getRoleName());
            }
            user.setRoleName(roleName);

        }
        PageInfo pageInfo = new PageInfo(list);

        return new PageResult(pageInfo);
    }


    @Override
    public TbUser getUserById(Long iD) {
        return tbUserMapper.selectByPrimaryKey(iD);
    }

    @ServiceLog(module = "用户管理", methods = "用户新增")
    @Override
    public OperateEnum insertUser(TbUser user) {
        //查询手机号是否重复
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserPhoneEqualTo(user.getUserPhone());
        long count = tbUserMapper.countByExample(example);
        if (count > 0) {
            return OperateEnum.USER_PHONE_EXIST;
        } else {
            int res = tbUserMapper.insertSelective(user);
            if (res > 0) {
                return OperateEnum.SUCCESS;
            } else {
                return OperateEnum.FAILE;
            }
        }
    }

    @ServiceLog(module = "用户管理", methods = "用户信息修改")
    @Override
    public OperateEnum updateUser(TbUser user) {

        int res = tbUserMapper.updateByPrimaryKeySelective(user);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }



    @ServiceLog(module = "用户管理", methods = "密码修改")
    @Override
    public JsonResult userPassUpdate(String pass, String pass0, String pass1, String pass2, long id) {

        if (!StringUtils.equals(pass, pass0)) {
            return JsonResult.build(OperateEnum.PASS_ERROR);
        } else if (!StringUtils.equals(pass1, pass2)) {
            return JsonResult.build(OperateEnum.PASS_NOT_EQUAIL);
        } else {
            TbUser user = new TbUser();
            user.setId(id);
            user.setPassword(pass1);
            int ret = tbUserMapper.updateByPrimaryKeySelective(user);
            if (ret > 0) {
                return JsonResult.build(OperateEnum.SUCCESS);
            } else {
                return JsonResult.build(OperateEnum.FAILE);
            }
        }
    }

    @ServiceLog(module = "用户管理", methods = "修改用户角色")
    @Override
    public OperateEnum updateUserRole(List role, long userId) {

        //删除用户已有的角色信息
        TbUserRoleExample example = new TbUserRoleExample();
        TbUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        tbUserRoleMapper.deleteByExample(example);
        if (role == null) {
            return OperateEnum.SUCCESS;
        } else {
            //批量插入角色信息
            List<Map<String, String>> list = new ArrayList<>();
            for (Object id : role) {
                Map<String, String> map = new HashMap<>();
                map.put("roleId", String.valueOf(id));
                map.put("userId", String.valueOf(userId));
                list.add(map);
            }
            int ret = tbUserRoleMapper.insertUserRole(list);
            if (ret > 0) {
                return OperateEnum.SUCCESS;
            } else {
                return OperateEnum.FAILE;
            }
        }

    }

    @ServiceLog(module = "用户管理", methods = "删除用户信息")
    @Override
    public OperateEnum deleteUserById(long userId) {

        TbUser user = new TbUser();
        user.setId(userId);
        user.setDelflag(1);
        int ret = tbUserMapper.updateByPrimaryKeySelective(user);
        if (ret > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }

    }

    @ServiceLog(module = "用户管理", methods = "用户头像修改")
    @Override
    public int updateUserAdvert(String userAdvertImgUrl, long userId) {
        //更新用户信息
        TbUser user = new TbUser();
        user.setId(userId);
        user.setUserAdvert(userAdvertImgUrl);
        int res = tbUserMapper.updateByPrimaryKeySelective(user);
        return res;
    }

}
