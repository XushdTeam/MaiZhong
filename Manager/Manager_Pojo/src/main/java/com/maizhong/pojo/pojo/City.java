package com.maizhong.pojo.pojo;

public class City {
    private Integer cityId;

    private String cityName;

    private Integer adminCode;

    private Integer provId;

    private String initial;

    private Integer hotLevel;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Integer getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(Integer adminCode) {
        this.adminCode = adminCode;
    }

    public Integer getProvId() {
        return provId;
    }

    public void setProvId(Integer provId) {
        this.provId = provId;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial == null ? null : initial.trim();
    }

    public Integer getHotLevel() {
        return hotLevel;
    }

    public void setHotLevel(Integer hotLevel) {
        this.hotLevel = hotLevel;
    }
}