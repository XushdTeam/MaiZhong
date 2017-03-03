package com.maizhong.shiro;

import com.maizhong.pojo.TbUser;
import com.maizhong.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 记住密码处理
 * Created by Xushd on 2017/2/28.
 */
public class RememberFilter extends FormAuthenticationFilter {


    @Autowired
    private UserService userService;



    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        Subject subject = SecurityUtils.getSubject();
        String userPhone = (String) subject.getPrincipal();
        //如果 isAuthenticated 为 false 证明不是登录过的，
        // 同时 isRememberd 为true 证明是没登陆直接通过记住我功能进来的
        if(!subject.isAuthenticated() && subject.isRemembered()){
            //获取session看看是不是空的
            Session session = subject.getSession(true);
            //随便拿session的一个属性来看session当前是否是空的
            if(session.getAttribute(userPhone) == null){
                //如果是空的才初始化，否则每次都要初始化，项目得慢死
                TbUser user = userService.getSystemUserByUserPhone(userPhone);
                session.setAttribute(userPhone,user);

            }
        }
        //这个方法本来只返回 subject.isAuthenticated()
        // 现在我们加上 subject.isRemembered() 让它同时也兼容remember这种情况
        return subject.isAuthenticated() || subject.isRemembered();
    }
}
