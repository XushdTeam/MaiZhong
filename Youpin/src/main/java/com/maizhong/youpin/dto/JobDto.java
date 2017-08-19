package com.maizhong.youpin.dto;

/**
 * Created by Xushd on 2017/8/18.
 */
public class JobDto {

    private int id;
    private String name;

    public JobDto() {
    }

    public JobDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
