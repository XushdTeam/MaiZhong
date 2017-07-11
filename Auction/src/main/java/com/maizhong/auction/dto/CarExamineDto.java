package com.maizhong.auction.dto;

import java.util.Date;

/**
 * 车辆审核
 * Created by Xushd on 2017/7/5.
 */
public class CarExamineDto {

    private Long id;

    private String modelName;

    private String picMain;

    private String carNum;

    private Integer status;

    private String userName;

    private Long userPhone;

    private Date createTime;

    private String companyName;

    public CarExamineDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicMain() {
        return picMain;
    }

    public void setPicMain(String picMain) {
        this.picMain = picMain;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
