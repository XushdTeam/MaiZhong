package com.maizhong.auction.pojo;

import java.util.Date;

public class CkCarbase {
    private Long id;

    private String modelName;

    private Long modelId;

    private Integer status;

    private String userName;

    private Long userPhone;

    private String startPrice;

    private Date createTime;

    private Long examineUserId;

    private String examineUsername;

    private String examineReason;

    private Date examineTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
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
        this.userName = userName == null ? null : userName.trim();
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice == null ? null : startPrice.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getExamineUserId() {
        return examineUserId;
    }

    public void setExamineUserId(Long examineUserId) {
        this.examineUserId = examineUserId;
    }

    public String getExamineUsername() {
        return examineUsername;
    }

    public void setExamineUsername(String examineUsername) {
        this.examineUsername = examineUsername == null ? null : examineUsername.trim();
    }

    public String getExamineReason() {
        return examineReason;
    }

    public void setExamineReason(String examineReason) {
        this.examineReason = examineReason == null ? null : examineReason.trim();
    }

    public Date getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
    }
}