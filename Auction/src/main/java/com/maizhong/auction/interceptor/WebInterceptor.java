package com.maizhong.auction.interceptor;

import com.maizhong.auction.service.IndexService;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Xushd on 2017/7/4.
 */
public class WebInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private IndexService indexService;

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
            JsonResult result = indexService.checkLoginStatus(token);
            if(result.getStatus()==200){
                request.setAttribute("token",token);
                request.setAttribute("username",result.getMessage());
                return true;
            }
        }
        if(StringUtils.isBlank(requestType)){
            request.getRequestDispatcher("/").forward(request, response);
        }else{
            //ajax
            PrintWriter writer = response.getWriter();
            writer.write(JsonUtils.objectToJson(JsonResult.build(100,"登录超时","")));
            writer.flush();
        }
        return false;
    }
}
