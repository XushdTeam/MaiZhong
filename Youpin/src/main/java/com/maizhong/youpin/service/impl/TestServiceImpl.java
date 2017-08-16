package com.maizhong.youpin.service.impl;

import com.maizhong.youpin.mapper.UserMapper;
import com.maizhong.youpin.pojo.User;
import com.maizhong.youpin.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-08-16
 * Time: 12:02
 */
@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private UserMapper userMapper;


    @Override
    public List test() {
        List<User> users = userMapper.selectByExample(null);
        return users;
    }


}
