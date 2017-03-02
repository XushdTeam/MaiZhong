package com.maizhong.aspect;

import com.maizhong.common.target.ControllerLog;
import com.maizhong.common.target.ServiceLog;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.pojo.TbLog;
import com.maizhong.pojo.TbUser;
import com.maizhong.service.LogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 系统日志Aspect
 * Created by Xushd on 2017/2/28.
 */
@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    private LogService logService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemLogAspect.class);

    /**
     * Service层切点
     */
    @Pointcut("@annotation(com.maizhong.common.target.ServiceLog)")
    public void ServiceAspect(){

    }

    /**
     * Controller层切点
     */
    @Pointcut("@annotation(com.maizhong.common.target.ControllerLog)")
    public void ControllerAspect(){

    }


    /**
     * Controller前置拦截
     * @param joinPoint
     */
    @Before("ControllerAspect()")
    public void doBefore(JoinPoint joinPoint){

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Subject subject = SecurityUtils.getSubject();
        String userPhone = (String) subject.getPrincipal();
        Session session = subject.getSession();
        TbUser tbUser = (TbUser) session.getAttribute(userPhone);
        if (tbUser==null)return;
        //请求的IP
        String ip = request.getRemoteAddr();
        try {
            Map<String,String> controllerDescription = getControllerDescription(joinPoint);
            //*========控制台输出=========*//
            System.out.println("=====前置通知开始=====");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("模块名称:" + controllerDescription.get("module"));
            System.out.println("方法名称:" + controllerDescription.get("method"));
            System.out.println("请求人:" + tbUser.getUserName());
            System.out.println("请求IP:" + ip);
            //*========数据库日志=========*//
            TbLog tbLog = new TbLog();
            tbLog.setMethodName(controllerDescription.get("method"));
            tbLog.setModuleName(controllerDescription.get("module"));
            tbLog.setLogType(0);
            tbLog.setRequestIp(ip);
            tbLog.setExceptionCode(null);
            tbLog.setExceptionDetail( null);
            tbLog.setParams(null);
            tbLog.setUserName(tbUser.getUserName());
            tbLog.setLogTime(new Date());
            //保存数据库
            logService.writeLog(tbLog);
            System.out.println("=====前置通知结束=====");
        }  catch (Exception e) {
            //记录本地异常日志
            LOGGER.error("==前置通知异常==");
            LOGGER.error("异常信息:{}", e.getMessage());
        }


    }


    /**
     * Service 抛出错误拦截日志
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "ServiceAspect()", throwing = "e")
    public void  doAfterThrowing(JoinPoint joinPoint, Throwable e){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        Subject subject = SecurityUtils.getSubject();
        String userPhone = (String) subject.getPrincipal();
        Session session = subject.getSession();
        TbUser tbUser = (TbUser) session.getAttribute(userPhone);
        if (tbUser==null)return;
        //请求的IP
        String ip = request.getRemoteAddr();
        //获取用户请求方法的参数并序列化为JSON格式字符串
        Object[] arguments = joinPoint.getArgs();
        String params = JsonUtils.objectToJson(arguments);
        try {

            Map<String,String> serviceDescription = getServiceDescription(joinPoint);
              /*========控制台输出=========*/
            System.out.println("=====异常通知开始=====");
            System.out.println("异常代码:" + e.getClass().getName());
            System.out.println("异常信息:" + e.getMessage());
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("模块名称:" + serviceDescription.get("module"));
            System.out.println("方法名称:" + serviceDescription.get("method"));
            System.out.println("请求人:" + tbUser.getUserName());
            System.out.println("请求IP:" + ip);
            System.out.println("请求参数:" + params);
               /*==========数据库日志=========*/
            TbLog tbLog = new TbLog();
            tbLog.setMethodName(serviceDescription.get("method"));
            tbLog.setModuleName(serviceDescription.get("module"));
            tbLog.setExceptionCode(e.getClass().getName());
            tbLog.setLogType(1);
            tbLog.setExceptionDetail(e.getMessage());
            tbLog.setParams(params);
            tbLog.setUserName(tbUser.getUserName());
            tbLog.setLogTime(new Date());
            tbLog.setRequestIp(ip);
            //保存数据库
            logService.writeLog(tbLog);
            System.out.println("=====异常通知结束=====");
        }  catch (Exception ex) {
            //记录本地异常日志
            LOGGER.error("==异常通知异常==");
            LOGGER.error("异常信息:{}", ex.getMessage());
        }
         /*==========记录本地异常日志==========*/
        Object[] object = {joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(),e.getClass().getName(), e.getMessage(), params};
        LOGGER.error("异常方法:{}异常代码:{}异常信息:{}参数:{}",object);
    }


    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * @param joinPoint
     * @return
     * @throws ClassNotFoundException
     */
    private Map<String, String> getControllerDescription(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        Map<String,String> map = new HashMap<>();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    map.put("method",method.getAnnotation(ControllerLog. class).methods());
                    map.put("module",method.getAnnotation(ControllerLog. class).module());
                    break;
                }
            }
        }
        return map;
    }

    /**
     * 获取注解中对方法的描述信息 用于Service层注解
     * @param joinPoint
     * @return
     */
    private Map<String, String> getServiceDescription(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        Map<String,String> map = new HashMap<>();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    map.put("method",method.getAnnotation(ServiceLog. class).methods());
                    map.put("module",method.getAnnotation(ServiceLog. class).module());
                    break;
                }
            }
        }
        return map;
    }









}
