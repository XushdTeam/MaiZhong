package com.maizhong.common.dto;

import java.util.List;

/**
 * Created by Xushd on 2017/3/2.
 */
public class PermissionResult {

    private long id;

    private String name;

    private String key;

    private int isChecked;

    public List<?> list;

    public PermissionResult(long id, String name, String key, int isChecked) {
        this.id = id;
        this.name = name;
        this.key = key;
        this.isChecked = isChecked;
    }

    public PermissionResult(long id, String name, String key, List<?> list) {
        this.id = id;
        this.name = name;
        this.key = key;
        this.list = list;
    }

    public long getId() {
        return id;
    }

    public int isChecked() {
        return isChecked;
    }

    public void setChecked(int checked) {
        isChecked = checked;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
