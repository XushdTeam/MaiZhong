package com.maizhong.common.dto;

/**
 * Key-Value
 * Created by Xushd on 2017/3/14.
 */
public class KeyValue {

    public KeyValue() {
    }

    private String key;

    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
