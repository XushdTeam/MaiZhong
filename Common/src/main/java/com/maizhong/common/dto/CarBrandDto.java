package com.maizhong.common.dto;

/**
 * 汽车品牌DTO
 * Created by Xushd on 2017/3/23.
 */
public class CarBrandDTO {

    private Long id;

    private String name;

    private String imgUrl;

    public CarBrandDTO() {
    }

    public CarBrandDTO(Long id, String name, String imgUrl) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
