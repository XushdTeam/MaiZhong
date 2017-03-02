package com.maizhong.service.impl;

import com.maizhong.mapper.TbUserMapper;
import com.maizhong.pojo.TbUser;
import com.maizhong.pojo.TbUserExample;
import com.maizhong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务接口实现
 * Created by Xushd on 2017/3/1.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getSystemUserByUserPhone(String userPhone) {

        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserPhoneEqualTo(userPhone).andDelflagEqualTo(0);
        List<TbUser> tbUsersList = tbUserMapper.selectByExample(example);
        if (tbUsersList == null || tbUsersList.size() == 0) return null;
        return tbUsersList.get(0);
    }
}
