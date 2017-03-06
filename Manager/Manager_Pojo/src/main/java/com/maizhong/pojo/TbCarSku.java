package com.maizhong.pojo;

import java.util.Date;

public class TbCarSku {
    private Long id;

    private String name;

    private Long carModelId;

    private Long color;

    private Double capacity;

    private Long gearbox;

    private Integer unable;

    private Double shopPrice;

    private Double sellPrice;

    private Double reservePrice;

    private Date createTime;

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
        this.name = name == null ? null : name.trim();
    }

    public Long getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(Long carModelId) {
        this.carModelId = carModelId;
    }

    public Long getColor() {
        return color;
    }

    public void setColor(Long color) {
        this.color = color;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Long getGearbox() {
        return gearbox;
    }

    public void setGearbox(Long gearbox) {
        this.gearbox = gearbox;
    }

    public Integer getUnable() {
        return unable;
    }

    public void setUnable(Integer unable) {
        this.unable = unable;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(Double reservePrice) {
        this.reservePrice = reservePrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}