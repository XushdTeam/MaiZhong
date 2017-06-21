package com.maizhong.auction.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Xushd on 2017/6/14.
 */
public class AppInterceptor extends HandlerInterceptorAdapter {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String token = request.getHeader("X-Maizhong-AppKey");

        //没有Token返回404 进行拦截
        if (StringUtils.isNotBlank(token)||"/app/check/login".equals(requestURI)) {

            request.setAttribute("token",token);
            return true;
        } else {
            response.setStatus(404);
            return false;
        }
        //return true;
    }
}
