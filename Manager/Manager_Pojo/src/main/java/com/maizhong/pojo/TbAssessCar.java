package com.maizhong.pojo;

import java.util.Date;

public class TbAssessCar {
    private Long id;

    private Long seriesId;

    private String year;

    private String maxlen;

    private String name;

    private Date buydate;

    private String mileage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Long seriesId) {
        this.seriesId = seriesId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMaxlen() {
        return maxlen;
    }

    public void setMaxlen(String maxlen) {
        this.maxlen = maxlen == null ? null : maxlen.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBuydate() {
        return buydate;
    }

    public void setBuydate(Date buydate) {
        this.buydate = buydate;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage == null ? null : mileage.trim();
    }
}