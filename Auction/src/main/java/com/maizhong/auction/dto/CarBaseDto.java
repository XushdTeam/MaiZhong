package com.maizhong.auction.dto;

/**
 * Created by Xushd on 2017/6/22.
 */
public class CarBaseDto {

    private long id;
    private String shotModuleName;
    private String modelName;
    private String carNum;
    private String img;
    private int status;
    private String createTime;

    public CarBaseDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShotModuleName() {
        return shotModuleName;
    }

    public void setShotModuleName(String shotModuleName) {
        this.shotModuleName = shotModuleName;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
