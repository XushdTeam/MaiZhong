package com.maizhong.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.User;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-06-08
 * Time: 11:26
 */
public interface CustomerService {
    PageResult getUserList(PageSearchParam param);

    User getUserById(Long aLong);

    OperateEnum updateUser(User user);

    OperateEnum deleteUserById(long userId);
}
