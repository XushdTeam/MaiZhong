package com.maizhong.reckon.DTO;

import com.maizhong.common.dto.KeyValue;
import com.maizhong.pojo.Brand;

import java.util.List;

/**
 * Created by Xushd on 2017/4/18.
 */
public class IndexDTO {


    private List<Object> brandList;


    private List<Object> cityList;

    private List<Object> proviceList;

    private String city;

    private String cityId;

    private String regdate;

    private String mail;

    private String modelName;

    private String modelId;


    private String provice;

    private String regdateId;

    private String brandId;

    private String seriesId;

    private String year;

    private String mouth;

    private String maxYear;

    private String minYear;

    public String getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(String maxYear) {
        this.maxYear = maxYear;
    }

    public String getMinYear() {
        return minYear;
    }

    public void setMinYear(String minYear) {
        this.minYear = minYear;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getRegdateId() {
        return regdateId;
    }

    public void setRegdateId(String regdateId) {
        this.regdateId = regdateId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public List<Object> getProviceList() {
        return proviceList;
    }

    public void setProviceList(List<Object> proviceList) {
        this.proviceList = proviceList;
    }

    public List<Object> getCityList() {
        return cityList;
    }

    public void setCityList(List<Object> cityList) {
        this.cityList = cityList;
    }

    public List<Object> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Object> brandList) {
        this.brandList = brandList;
    }
}
