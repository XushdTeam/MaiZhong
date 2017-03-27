package com.maizhong.common.dto;

import java.util.Date;

public class CarColumnJoinCar {
    private Long id;

    private Long carId;

    private Integer columnId;

    private Integer carSort;

    private Integer status;

    private Integer deflag;

    private String columnName;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    //汽车字段

    private String number;

    private String name;

    private String sellpoint;

    private Long reservePrice;

    private Long sellPrice;

    private String factoryPrice;

    private String image;

    //


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public Integer getCarSort() {
        return carSort;
    }

    public void setCarSort(Integer carSort) {
        this.carSort = carSort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeflag() {
        return deflag;
    }

    public void setDeflag(Integer deflag) {
        this.deflag = deflag;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSellpoint() {
        return sellpoint;
    }

    public void setSellpoint(String sellpoint) {
        this.sellpoint = sellpoint;
    }

    public Long getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(Long reservePrice) {
        this.reservePrice = reservePrice;
    }

    public Long getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Long sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getFactoryPrice() {
        return factoryPrice;
    }

    public void setFactoryPrice(String factoryPrice) {
        this.factoryPrice = factoryPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public CarColumnJoinCar() {
    }

    public CarColumnJoinCar(Long id, Long carId, Integer columnId, Integer carSort, Integer status, Integer deflag, String columnName,
                            String number, String name, String sellpoint, Long reservePrice, Long sellPrice, String factoryPrice, String image) {
        this.id = id;
        this.carId = carId;
        this.columnId = columnId;
        this.carSort = carSort;
        this.status = status;
        this.deflag = deflag;
        this.columnName = columnName;
        this.number = number;
        this.name = name;
        this.sellpoint = sellpoint;
        this.reservePrice = reservePrice;
        this.sellPrice = sellPrice;
        this.factoryPrice = factoryPrice;
        this.image = image;
    }
}