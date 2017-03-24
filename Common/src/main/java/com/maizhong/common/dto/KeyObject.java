package com.maizhong.common.dto;

/**
 * Created by Xushd on 2017/3/23.
 */
public class KeyObject {

    private String key;

    private Object object;

    public KeyObject(String key, Object object) {
        this.key = key;
        this.object = object;
    }

    public KeyObject() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
