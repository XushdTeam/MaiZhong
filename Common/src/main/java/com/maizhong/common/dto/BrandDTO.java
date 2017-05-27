package com.maizhong.common.dto;

/**
 * Created by Xushd on 2017/5/25.
 */
public class BrandDTO {

    private Long id;
    private String initial;
    private String name;
    private String img;
    private int isHot;

    public BrandDTO(Long id, String initial, String name, String img, int isHot) {
        this.id = id;
        this.initial = initial;
        this.name = name;
        this.img = img;
        this.isHot = isHot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }
}
