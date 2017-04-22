package com.maizhong.reckon.DTO;

import com.maizhong.pojo.Model;
import com.maizhong.pojo.OrderInfo;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-22
 * Time: 11:25
 */
public class OrderDTO {
    private String orderNumber;//订单编号
    private String userId;//用户ID
    private Model model;//车型对象
    private String modelName;//车型名称
    private String reckonPrice;//评估价格
    private String way;//交易方式 地铁站点或者4S店信息
    private String dealPrice;//交易价格--实际
    private String checkTime;//约定验车时间
    private String dealTime;//交易时间
    private String dealWay;//交易方式 4S店、地铁站、上门
    private String linkMan;//联系人
    private String linkPhone;//联系人电话
    private String address; //地址
    private String reckon_time;//评估时间
    private String seriesImg;//车系图片
    private OrderInfo orderInfo;//评测信息详情

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getReckonPrice() {
        return reckonPrice;
    }

    public void setReckonPrice(String reckonPrice) {
        this.reckonPrice = reckonPrice;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(String dealPrice) {
        this.dealPrice = dealPrice;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealWay() {
        return dealWay;
    }

    public void setDealWay(String dealWay) {
        this.dealWay = dealWay;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReckon_time() {
        return reckon_time;
    }

    public void setReckon_time(String reckon_time) {
        this.reckon_time = reckon_time;
    }

    public String getSeriesImg() {
        return seriesImg;
    }

    public void setSeriesImg(String seriesImg) {
        this.seriesImg = seriesImg;
    }
}
