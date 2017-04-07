package com.maizhong.common.dto;

import java.math.BigDecimal;

/**
 * Description:首页汽车显示的信息
 * User: 王存浩
 * Date: 2017-03-17
 * Time: 16:33
 */
public class CarIndexDetail {
    private Long id;
    private String name;
    private String factoryPrice;
    private String img;
    private BigDecimal reservePrice;
    private BigDecimal sellPrice;

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
        this.name = name;
    }

    public String getFactoryPrice() {
        return factoryPrice;
    }

    public void setFactoryPrice(String factoryPrice) {
        this.factoryPrice = factoryPrice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public BigDecimal getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(BigDecimal reservePrice) {
        this.reservePrice = reservePrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public CarIndexDetail() {
    }

    public CarIndexDetail(Long id, String name, String factoryPrice, String img, BigDecimal reservePrice, BigDecimal sellPrice) {
        this.id = id;
        this.name = name;
        this.factoryPrice = factoryPrice;
        this.img = img;
        this.reservePrice = reservePrice;
        this.sellPrice = sellPrice;
    }
}
