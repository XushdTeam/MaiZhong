package com.maizhong.youpin.interceptor;

import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Xushd on 2017/8/16.
 */
public class WebInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                token = cookie.getValue();
            }
        }
        String requestType = request.getHeader("X-Requested-With");
        if (StringUtils.isNotBlank(token)) {
            request.setAttribute("token",token);
        }else{
            request.setAttribute("token",null);
        }

        if(StringUtils.isBlank(requestType)){
            request.getRequestDispatcher("/").forward(request, response);
        }else{
            //ajax
            PrintWriter writer = response.getWriter();
            writer.write(JsonUtils.objectToJson(JsonResult.build(100,"LOGIN TIME OUT","")));
            writer.flush();
        }
        return true;
    }
}
