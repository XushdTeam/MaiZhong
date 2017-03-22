package com.maizhong.pojo;

import java.util.Date;

public class TbCar {
    private Long id;

    private String number;

    private Long baseId;

    private Long carBrand;

    private Long carBrandLine;

    private Long carType;

    private Long color;

    private String sellpoint;

    private Long reservePrice;

    private Long sellPrice;

    private Date createTime;

    private Date updateTime;

    private String smimage;

    private String image;

    private Long businessId;

    private Integer stockNum;

    private Integer sellNum;

    private Integer unable;

    private Integer weight;

    private String details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public Long getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(Long carBrand) {
        this.carBrand = carBrand;
    }

    public Long getCarBrandLine() {
        return carBrandLine;
    }

    public void setCarBrandLine(Long carBrandLine) {
        this.carBrandLine = carBrandLine;
    }

    public Long getCarType() {
        return carType;
    }

    public void setCarType(Long carType) {
        this.carType = carType;
    }

    public Long getColor() {
        return color;
    }

    public void setColor(Long color) {
        this.color = color;
    }

    public String getSellpoint() {
        return sellpoint;
    }

    public void setSellpoint(String sellpoint) {
        this.sellpoint = sellpoint == null ? null : sellpoint.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSmimage() {
        return smimage;
    }

    public void setSmimage(String smimage) {
        this.smimage = smimage == null ? null : smimage.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public Integer getUnable() {
        return unable;
    }

    public void setUnable(Integer unable) {
        this.unable = unable;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }
}