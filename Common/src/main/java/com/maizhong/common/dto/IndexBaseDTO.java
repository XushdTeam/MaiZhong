package com.maizhong.common.dto;

/**
 * 首页初次数据DTO
 * Created by Xushd on 2017/3/23.
 */
public class IndexBaseDTO {

    private Object carBrand;

    private Object carGg;

    private Object carType;

    public IndexBaseDTO() {
    }

    public IndexBaseDTO(Object carBrand, Object carGg, Object carType) {
        this.carBrand = carBrand;
        this.carGg = carGg;
        this.carType = carType;
    }

    public Object getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(Object carBrand) {
        this.carBrand = carBrand;
    }

    public Object getCarGg() {
        return carGg;
    }

    public void setCarGg(Object carGg) {
        this.carGg = carGg;
    }

    public Object getCarType() {
        return carType;
    }

    public void setCarType(Object carType) {
        this.carType = carType;
    }
}
