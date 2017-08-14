package com.maizhong.auction.dto;

/**
 * APP 显示
 * Created by Xushd on 2017/7/10.
 */
public class CarInfoDto {

    //拍卖ID
    private long auctionId;
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
    private String orderNum;

    //是否出价
    private boolean myAuction;
    private String nowPrice;
    private long overTime;
    private long nowTime;

    private String savePrice;

    private String chKey;

    //是否在竞拍 关注列表中用
    private boolean isAuction;

    //拍卖次数
    private int auctionCount;

    //关注数
    private long likeCounts;

    //我是否关注
    private boolean imMyLike;

    public long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(long auctionId) {
        this.auctionId = auctionId;
    }

    public boolean isImMyLike() {
        return imMyLike;
    }

    public void setImMyLike(boolean imMyLike) {
        this.imMyLike = imMyLike;
    }

    public long getLikeCounts() {
        return likeCounts;
    }

    public void setLikeCounts(long likeCounts) {
        this.likeCounts = likeCounts;
    }

    public String getSavePrice() {
        return savePrice;
    }

    public void setSavePrice(String savePrice) {
        this.savePrice = savePrice;
    }

    public boolean isAuction() {
        return isAuction;
    }

    public void setAuction(boolean auction) {
        isAuction = auction;
    }

    public String getChKey() {
        return chKey;
    }

    public void setChKey(String chKey) {
        this.chKey = chKey;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public long getOverTime() {
        return overTime;
    }

    public void setOverTime(long overTime) {
        this.overTime = overTime;
    }

    public long getNowTime() {
        return nowTime;
    }

    public void setNowTime(long nowTime) {
        this.nowTime = nowTime;
    }

    public String getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(String nowPrice) {
        this.nowPrice = nowPrice;
    }

    public int getAuctionCount() {
        return auctionCount;
    }

    public void setAuctionCount(int auctionCount) {
        this.auctionCount = auctionCount;
    }


    public boolean isMyAuction() {
        return myAuction;
    }

    public void setMyAuction(boolean myAuction) {
        this.myAuction = myAuction;
    }

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
