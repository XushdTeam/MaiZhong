package com.maizhong.common.dto;

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
    private Long reservePrice;
    private Long sellPrice;

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

    public CarIndexDetail() {
    }

    public CarIndexDetail(Long id, String name, String factoryPrice, String img, Long reservePrice, Long sellPrice) {
        this.id = id;
        this.name = name;
        this.factoryPrice = factoryPrice;
        this.img = img;
        this.reservePrice = reservePrice;
        this.sellPrice = sellPrice;
    }
}
