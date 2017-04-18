package com.maizhong.bRest.filter;


import com.maizhong.bRest.service.UserService;
import com.maizhong.common.dto.UserInfo;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
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


    @Autowired
    private UserService userService;

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
        if (!StringUtils.isBlank(requestURI)
                &&!"/bRest/login".equals(requestURI)
                &&!"/bRest/upload/body".equals(requestURI)
                &&!"/bRest/upload/head".equals(requestURI)){

            String token = request.getHeader("Authorization");

            if(StringUtils.isBlank(token)){
                response.setStatus(401);
                return false;
            } else {
                JsonResult result = userService.isOnline(token);
                if(result.getStatus()==200){
                    //需要用到token数据 用于提取用户信息
//                    Map<String,Object> map = (Map<String, Object>) result.getData();
                    request.setAttribute("token",token);
                    request.setAttribute("userInfo",JsonUtils.jsonToPojo(result.getData().toString(),UserInfo.class));
                    return true;
                }else {
                    response.setStatus(401);
                    return false;
                }
            }
        }else{
            return true;
        }
    }

}
