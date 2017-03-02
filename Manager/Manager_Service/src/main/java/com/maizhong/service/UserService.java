package com.maizhong.service;

import com.maizhong.pojo.TbUser;

/**
 * 用户服务接口
 * Created by Xushd on 2017/3/1.
 */
public interface UserService {


    TbUser getSystemUserByUserPhone(String userPhone);
}
