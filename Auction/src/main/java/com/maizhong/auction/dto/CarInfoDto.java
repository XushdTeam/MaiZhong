package com.maizhong.auction.dto;

/**
 * APP 显示
 * Created by Xushd on 2017/7/10.
 */
public class CarInfoDto {

    private long carId;
    private String modelName;
    private String zq45;
    private String pfbz;
    private String pj;
    private String cdrq;
    private String zcd;
    private String number;
    private String bxlc;

    private String status;
    private String dealPrice;
    private String dealTime;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(String dealPrice) {
        this.dealPrice = dealPrice;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public CarInfoDto() {
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getZq45() {
        return zq45;
    }

    public void setZq45(String zq45) {
        this.zq45 = zq45;
    }

    public String getPfbz() {
        return pfbz;
    }

    public void setPfbz(String pfbz) {
        this.pfbz = pfbz;
    }

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public String getCdrq() {
        return cdrq;
    }

    public void setCdrq(String cdrq) {
        this.cdrq = cdrq;
    }

    public String getZcd() {
        return zcd;
    }

    public void setZcd(String zcd) {
        this.zcd = zcd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBxlc() {
        return bxlc;
    }

    public void setBxlc(String bxlc) {
        this.bxlc = bxlc;
    }


    @Override
    public String toString() {
        return "CarInfoDto{" +
                "carId=" + carId +
                ", modelName='" + modelName + '\'' +
                ", zq45='" + zq45 + '\'' +
                ", pfbz='" + pfbz + '\'' +
                ", pj='" + pj + '\'' +
                ", cdrq='" + cdrq + '\'' +
                ", zcd='" + zcd + '\'' +
                ", number='" + number + '\'' +
                ", bxlc='" + bxlc + '\'' +
                '}';
    }
}
