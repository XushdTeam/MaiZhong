package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.common.utils.TimeUtils;
import com.maizhong.mapper.UserMapper;
import com.maizhong.pojo.User;
import com.maizhong.pojo.UserExample;
import com.maizhong.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-06-08
 * Time: 11:27
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 客户查询
     *
     * @param param
     * @return
     */
    @Override
    public PageResult getUserList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (param.getFiled("userName") != null) {
            criteria.andUserNameLike(SqlUtils.getLikeSql(param.getFiled("userName")));
        }
        if (param.getFiled("userPhone") != null) {
            try {
                criteria.andPhoneEqualTo(Long.valueOf(param.getFiled("userPhone")));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if (param.getFiled("shopName") != null) {
            try {
                criteria.andShopNameLike(SqlUtils.getLikeSql(param.getFiled("shopName")));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if (param.getFiled("timeBegin") != null) {
            try {
                criteria.andCreateTimeGreaterThan(TimeUtils.getDate(param.getFiled("timeBegin")));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if (param.getFiled("timeEnd") != null) {
            try {
                criteria.andCreateTimeLessThan(TimeUtils.getDate(param.getFiled("timeEnd")));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        if (param.getFiled("userRole") != null) {
            try {
                if (param.getFiled("userRole").equals("2")){
                    criteria.andUserRoleEqualTo(2);
                }else {
                    criteria.andUserRoleNotEqualTo(2);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("user_id DESC");
        List<User> list = userMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo(list);

        return new PageResult(pageInfo);
    }

    /**
     * 根据id获取客户
     *
     * @param userId
     * @return
     */
    @Override
    public User getUserById(Long userId) {
        if (userId == null) {
            return null;
        }
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }

    /**
     * 修改客户
     *
     * @param user
     * @return
     */
    @Override
    public OperateEnum updateUser(User user) {
        int res = userMapper.updateByPrimaryKeySelective(user);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }


    /**
     * 删除客户
     *
     * @param userId
     * @return
     */
    @Override
    public OperateEnum deleteUserById(long userId) {

        User user = userMapper.selectByPrimaryKey(userId);
        if (user==null){
            return OperateEnum.FAILE;
        }
        user.setDelflag(1);
        int ret = userMapper.updateByPrimaryKeySelective(user);
        if (ret > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }
}
