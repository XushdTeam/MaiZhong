package com.maizhong.auction.pojo;

import java.util.Date;

public class AcAuctionOver {
    private Long id;

    private Long carId;

    private String price;

    private Long userId;

    private String bussinessName;

    private String chKey;

    private Date createTime;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBussinessName() {
        return bussinessName;
    }

    public void setBussinessName(String bussinessName) {
        this.bussinessName = bussinessName == null ? null : bussinessName.trim();
    }

    public String getChKey() {
        return chKey;
    }

    public void setChKey(String chKey) {
        this.chKey = chKey == null ? null : chKey.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}