package com.maizhong.rest.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-25
 * Time: 14:28
 */
public class TokenFilter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String token = request.getHeader("X-Maizhong-AppKey");

        //获取Token
        if ("/rest/app/getTokenByDeviceId".equals(requestURI)||"/rest/app/getVersion".equals(requestURI)){
            return true;
        }

       //没有Token返回404 进行拦截
        if (StringUtils.isBlank(token)) {
            //response.setStatus(404);
            return true;
            /*return true;*/
        } else {
            request.setAttribute("token",token);
            return true;
        }
    }
}

