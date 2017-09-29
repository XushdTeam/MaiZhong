package com.maizhong.auction.dto;

import java.util.List;

/**
 * Created by Xushd on 2017/9/11.
 */
public class FreezeDTO {

    private long auctionId;
    private String carName;
    private String chKey;
    private String price;
    private String time;

    public FreezeDTO() {
    }

    public long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(long auctionId) {
        this.auctionId = auctionId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getChKey() {
        return chKey;
    }

    public void setChKey(String chKey) {
        this.chKey = chKey;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
