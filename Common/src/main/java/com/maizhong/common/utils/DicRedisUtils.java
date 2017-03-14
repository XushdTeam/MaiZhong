package com.maizhong.common.utils;

import com.maizhong.common.dto.KeyValue;

import java.util.List;

/**
 * 数据字典工具类
 * Created by Xushd on 2017/3/14.
 */
public class DicRedisUtils {

    public static String getDicFormRedisById(String id,String jsonData){

        String result = "";
        List<KeyValue> list = JsonUtils.jsonToList(jsonData,KeyValue.class);
        for (KeyValue keyValue : list) {
            if(keyValue.getKey().equals(id)){
                result = keyValue.getValue();
                break;
            }

        }
        return result;
    }
}
