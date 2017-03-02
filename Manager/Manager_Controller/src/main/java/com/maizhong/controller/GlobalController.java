package com.maizhong.controller;

import com.maizhong.pojo.TbUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Controller基类
 * Created by Xushd on 2017/3/1.
 */
public class GlobalController {

    /**
     * shiro session 中获取用户信息
     * @return
     */
    protected TbUser getUserInfo(){
        Subject subject = SecurityUtils.getSubject();
        String userPhone = (String) subject.getPrincipal();
        TbUser user = (TbUser) subject.getSession().getAttribute(userPhone);
        return user;
    }



}
