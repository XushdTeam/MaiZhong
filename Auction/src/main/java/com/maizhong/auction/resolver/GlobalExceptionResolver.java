package com.maizhong.auction.resolver;

import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Xushd on 2017/6/14.
 */
public class GlobalExceptionResolver extends SimpleMappingExceptionResolver {

    public static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionResolver.class);


    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {


        response.setCharacterEncoding("UTF-8");
        if(request.getHeader("x-requested-with")==null){
            LOGGER.error("Error:{}",ex);
            return getModelAndView("common/500", ex, request);
        }else{//ajax
            try {
                LOGGER.error("Error:{}",ex);
                String result = JsonUtils.objectToJson(JsonResult.build(500,"Service Error",ex));
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
