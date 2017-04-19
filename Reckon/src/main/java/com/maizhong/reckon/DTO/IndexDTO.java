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
