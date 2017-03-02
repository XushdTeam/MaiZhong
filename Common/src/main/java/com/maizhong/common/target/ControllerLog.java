package com.maizhong.common.target;

import java.lang.annotation.*;

/**
 * 自定义日志注解 拦截Controller
 * Created by Xushd on 2017/3/1.
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLog {

    String module()  default "";
    String methods()  default "";
}
