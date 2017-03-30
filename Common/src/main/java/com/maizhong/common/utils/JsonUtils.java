package com.maizhong.common.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.maizhong.common.result.JsonResult;

import java.util.List;
import java.util.Map;

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
     *  将json结果集转化为对象
     * @param jsonData
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> clazz) {
        return JSON.parseObject(jsonData, clazz);
    }

    /**
     * json字符串转LIST
     * @param jsonData
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> clazz){

        return JSON.parseArray(jsonData, clazz);

    }

    public static List<Map<String,String>> jsonResultToList(String jsonResult){
        try {
            JsonResult result = jsonToPojo(jsonResult,JsonResult.class);

            return JSON.parseObject(result.getData().toString(),
                    new TypeReference<List<Map<String, String>>>() {
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
