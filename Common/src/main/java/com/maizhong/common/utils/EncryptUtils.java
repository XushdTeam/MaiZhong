package com.maizhong.common.utils;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-18
 * Time: 10:17
 */
public class EncryptUtils {
    public static String getSHA256Str(String str){
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encdeStr;
    }

}