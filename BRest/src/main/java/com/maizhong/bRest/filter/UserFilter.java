package com.maizhong.bRest.filter;


import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *      拦截器
 *          作用 ：拦截请求 查看请求头是否携带token 然后判断是否登录
 *                  未登录返回401状态
 *
 *                  HandlerInterceptorAdapter 用于空实现 postHandle和afterCompletion
 *
 *
 * Created by yangF on 2017/3/28.
 */
public class UserFilter extends HandlerInterceptorAdapter {


    @Resource
    private JedisClient jedisClient;



    @Value("${LOGIN_URL}")
    private  String LOGIN_URL;

    @Value("${BUSSINESSUSER_PREFIX}")
    private String BUSSINESSUSER_PREFIX;

    @Value("${BUSSINESSUSER_INFO}")
    private String BUSSINESSUSER_INFO;

    /**
     * 方法执行前 检查请求头中携带的参数
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if (StringUtils.isBlank(requestURI)||!LOGIN_URL.equals(requestURI)){
            String token = request.getHeader("Authorization");
            if (StringUtils.isNotBlank(token)){
                String hget = jedisClient.hget(BUSSINESSUSER_PREFIX + token, BUSSINESSUSER_INFO);
                if (StringUtils.isNotBlank(hget)){
                    jedisClient.expire(BUSSINESSUSER_PREFIX + token,3600);
                    return true;
                }
            }
            response.setStatus(401);
            return false;
        }
        return true;
    }

}
