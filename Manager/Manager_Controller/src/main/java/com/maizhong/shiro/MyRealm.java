package com.maizhong.shiro;

import com.maizhong.common.enums.AuthEnum;
import com.maizhong.pojo.TbPermission;
import com.maizhong.pojo.TbRole;
import com.maizhong.pojo.TbUser;
import com.maizhong.service.PermissionService;
import com.maizhong.service.RoleService;
import com.maizhong.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * shiro 验证
 * Created by Xushd on 2017/2/28.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 为当前登陆成功的用户授予权限和角色，已经登陆成功了
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String userPhone = (String) principalCollection.getPrimaryPrincipal();
        Subject currentSubject = SecurityUtils.getSubject();
        TbUser tbUser = (TbUser) currentSubject.getSession().getAttribute(userPhone);
        List<TbRole> roleList =  roleService.getRoleByUserId(tbUser.getId());
        for (TbRole tbRole : roleList) {
            simpleAuthorizationInfo.addRole(tbRole.getRoleKey());
            List<TbPermission> tbPermissionList = permissionService.getPermissionByRoleId(tbRole.getId());
            for (TbPermission tbPermission : tbPermissionList) {
                simpleAuthorizationInfo.addStringPermission(tbPermission.getPermissionKey());
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 验证当前登录的用户，获取认证信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userPhone = token.getUsername();
        String passWord = String.valueOf(token.getPassword());
        TbUser tbUser = userService.getSystemUserByUserPhone(userPhone);
        if (tbUser == null) {
            //用户不存在
            throw new AuthenticationException(AuthEnum.USER_NO_EXIT.getStateInfo());
        } else if (tbUser.getStatus() == 0) {
            //帐号停用
            throw new AuthenticationException(AuthEnum.USER_STOP.getStateInfo());
        } else if (!passWord.equals(tbUser.getPassword())) {
            //密码错误
            throw new AuthenticationException(AuthEnum.USER_ERROR_PASSWORD.getStateInfo());
        }
        //登录成功
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userPhone, passWord, tbUser.getUserName());
        //绑定session信息
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        //用户手机号作为sessionKey
        session.setAttribute(userPhone, tbUser);
        return simpleAuthenticationInfo;

    }
}
