package com.maizhong.common.dto;

import java.util.List;
import java.util.Map;

/**
 * 查询基本数据DTO
 * Created by Xushd on 2017/3/23.
 */
public class SearchBaseDTO {

    private String brandName;
    private Boolean isBrandHot = false;
    private String seriesName;
    private Boolean isSeriesHot = false;

    private List<KeyValue> carBrandhot;

    private List<KeyObject> carBrandAll;

    private List<Object> carSeriesAll;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public List<KeyObject> getCarBrandAll() {
        return carBrandAll;
    }

    public void setCarBrandAll(List<KeyObject> carBrandAll) {
        this.carBrandAll = carBrandAll;
    }


    public Boolean getBrandHot() {
        return isBrandHot;
    }

    public void setBrandHot(Boolean brandHot) {
        isBrandHot = brandHot;
    }

    public Boolean getSeriesHot() {
        return isSeriesHot;
    }

    public void setSeriesHot(Boolean seriesHot) {
        isSeriesHot = seriesHot;
    }


    public List<KeyValue> getCarBrandhot() {
        return carBrandhot;
    }

    public void setCarBrandhot(List<KeyValue> carBrandhot) {
        this.carBrandhot = carBrandhot;
    }

    public List<Object> getCarSeriesAll() {
        return carSeriesAll;
    }

    public void setCarSeriesAll(List<Object> carSeriesAll) {
        this.carSeriesAll = carSeriesAll;
    }
}
