package com.maizhong.pojo;

import java.util.Date;

public class TbCarSpu {
    private Long id;

    private Integer carType;

    private String name;

    private String sellpoint;

    private Date createTime;

    private Integer carBrand;

    private String image;

    private Integer unable;

    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSellpoint() {
        return sellpoint;
    }

    public void setSellpoint(String sellpoint) {
        this.sellpoint = sellpoint == null ? null : sellpoint.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(Integer carBrand) {
        this.carBrand = carBrand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getUnable() {
        return unable;
    }

    public void setUnable(Integer unable) {
        this.unable = unable;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}