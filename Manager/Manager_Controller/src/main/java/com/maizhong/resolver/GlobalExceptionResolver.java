package com.maizhong.resolver;

import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 全局错误处理类
 * Created by Xushd on 2017/2/28.
 */
public class GlobalExceptionResolver extends SimpleMappingExceptionResolver {

    public static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionResolver.class);


    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        Boolean isShiroException = ex instanceof AuthorizationException;
        response.setCharacterEncoding("UTF-8");
        if(request.getHeader("x-requested-with")==null){
            //非ajax
            if(isShiroException){
                return getModelAndView("common/noAuth", ex, request);
            }else{
                LOGGER.error("Error:{}",ex);
                return getModelAndView("common/500", ex, request);
            }

        }else{//ajax
            String result = "";
            //shiro 权限错误
            if(isShiroException){
                result = JsonUtils.objectToJson(JsonResult.build(401,"没有权限哦！",null));
            }else{
                LOGGER.error("Error:{}",ex);
                result = JsonUtils.objectToJson(JsonResult.build(500,"Service Error",ex));
            }
            try {
                PrintWriter writer = response.getWriter();
                writer.write(result);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new ModelAndView() ;
        }
    }

}
