package com.maizhong.common.utils;

/**
 * Created by Xushd on 2017/3/2.
 */
public class SqlUtils {

    public static String getLikeSql(String filed){
        return "%"+filed+"%";
    }
}
