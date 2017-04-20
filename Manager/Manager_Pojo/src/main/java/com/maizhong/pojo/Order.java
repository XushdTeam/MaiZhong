package com.maizhong.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Long orderId;

    private Long orderNumber;

    private Long userId;

    private Long modelId;

    private String modelName;

    private BigDecimal reckonPrice;

    private BigDecimal dealPrice;

    private Integer dealWay;

    private String linkMan;

    private String address;

    private Date reckonTime;

    private Integer status;

    private Integer delflag;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public BigDecimal getReckonPrice() {
        return reckonPrice;
    }

    public void setReckonPrice(BigDecimal reckonPrice) {
        this.reckonPrice = reckonPrice;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Integer getDealWay() {
        return dealWay;
    }

    public void setDealWay(Integer dealWay) {
        this.dealWay = dealWay;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getReckonTime() {
        return reckonTime;
    }

    public void setReckonTime(Date reckonTime) {
        this.reckonTime = reckonTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelflag() {
        return delflag;
    }

    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
    }
}