package com.maizhong.pojo;

public class TbAdvert {
    private Long id;

    private String advertName;

    private String advertUrl;

    private String advertImg;

    private Integer advertType;

    private String carNumber;

    private Integer publishState;

    private String advertDesc;
    private  String typeName;

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName == null ? null : advertName.trim();
    }

    public String getAdvertUrl() {
        return advertUrl;
    }

    public void setAdvertUrl(String advertUrl) {
        this.advertUrl = advertUrl == null ? null : advertUrl.trim();
    }

    public String getAdvertImg() {
        return advertImg;
    }

    public void setAdvertImg(String advertImg) {
        this.advertImg = advertImg == null ? null : advertImg.trim();
    }

    public Integer getAdvertType() {
        return advertType;
    }

    public void setAdvertType(Integer advertType) {
        this.advertType = advertType;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    public Integer getPublishState() {
        return publishState;
    }

    public void setPublishState(Integer publishState) {
        this.publishState = publishState;
    }

    public String getAdvertDesc() {
        return advertDesc;
    }

    public void setAdvertDesc(String advertDesc) {
        this.advertDesc = advertDesc == null ? null : advertDesc.trim();
    }
}