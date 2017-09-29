package com.maizhong.auction.dto;

/**
 * Created by Xushd on 2017/7/18.
 */
public class BidRecordDto {

    private String plusTime;
    private String bussinessName;
    private String price;
    private boolean isMy;
    private int type;

    public BidRecordDto() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPlusTime() {
        return plusTime;
    }

    public void setPlusTime(String plusTime) {
        this.plusTime = plusTime;
    }

    public String getBussinessName() {
        return bussinessName;
    }

    public void setBussinessName(String bussinessName) {
        this.bussinessName = bussinessName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isMy() {
        return isMy;
    }

    public void setMy(boolean my) {
        isMy = my;
    }
}
