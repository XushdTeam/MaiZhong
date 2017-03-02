package com.maizhong.common.utils;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Json工具类
 * Created by Xushd on 2017/2/28.
 */
public class JsonUtils {


    /**
     * 对象转化成json字符串
     * @param object
     * @return
     */
    public static String objectToJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * json字符串转LIST
     * @param jsonStr
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T>List<T> jsonToList(String jsonStr, Class<T> beanType){
        return JSON.parseArray(jsonStr,beanType);
    }

}
