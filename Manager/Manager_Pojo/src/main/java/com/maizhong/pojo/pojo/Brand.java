package com.maizhong.pojo.pojo;

import java.util.Date;

public class Brand {
    private Integer brandId;

    private String brandName;

    private String initial;

    private Date updateTime;

    private String smallLogo;

    private String largeLogo;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial == null ? null : initial.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSmallLogo() {
        return smallLogo;
    }

    public void setSmallLogo(String smallLogo) {
        this.smallLogo = smallLogo == null ? null : smallLogo.trim();
    }

    public String getLargeLogo() {
        return largeLogo;
    }

    public void setLargeLogo(String largeLogo) {
        this.largeLogo = largeLogo == null ? null : largeLogo.trim();
    }
}