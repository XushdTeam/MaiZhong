package com.maizhong.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.TbUser;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户服务接口
 * Created by Xushd on 2017/3/1.
 */
public interface UserService {


    /**
     * 通过用户phone 获取用户对象
     * @param userPhone
     * @return
     */
    TbUser getSystemUserByUserPhone(String userPhone);

    /**
     * 用户列表
     * @param param
     * @return
     */
    PageResult getUserList(PageSearchParam param);

    /**
     * 通过用户id查找用户
     * @param iD
     * @return
     */
    TbUser getUserById(Long iD);

    /**
     * 新增用户
     * @param user
     * @return
     */
    OperateEnum insertUser(TbUser user);

    /**
     * 用户信息修改
     * @param user
     * @return
     */
    OperateEnum updateUser(TbUser user);


    /**
     * 用户密码修改
     * @param pass
     * @param pass0
     * @param pass1
     * @param pass2
     * @param id
     * @return
     */
    JsonResult userPassUpdate(String pass, String pass0, String pass1, String pass2, long id);

    /**
     * 用户修改角色
     * @param role
     * @param userId
     * @return
     */
    OperateEnum updateUserRole(List role, long userId);


    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    OperateEnum deleteUserById(long userId);

    /**
     * 修改用户头像
     * @param userAdvertImgUrl
     * @param userId
     * @return
     */
    int updateUserAdvert(String userAdvertImgUrl, long userId);
}
