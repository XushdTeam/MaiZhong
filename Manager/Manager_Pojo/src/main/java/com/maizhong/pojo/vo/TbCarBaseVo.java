package com.maizhong.pojo.vo;

/**
 * Created by yangF on 2017/3/22.
 */
public class TbCarBaseVo {
    private Long id;
    private String carTypeName;
    private String color;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(String carTypeName) {
        this.carTypeName = carTypeName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
