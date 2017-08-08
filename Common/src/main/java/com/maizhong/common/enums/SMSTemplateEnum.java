package com.maizhong.common.enums;

/**
 * 阿里短信模版
 * Created by Xushd on 2017/8/1.
 */
public enum SMSTemplateEnum {
    WuKongShouChe("SMS_66905213","悟空收车"),
    YouPinPaiChe("T170317001164","优品拍车");

    private String code;
    private String name;
    SMSTemplateEnum(String code,String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
