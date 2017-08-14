package com.maizhong.auction.dto;

/**
 * Created by Xushd on 2017/8/11.
 */
public class BidDto {

    // 价格
    private String price;
    // 时间
    private String time;
    // 商户
    private String name;
    // 商户
    private long userId;

    public BidDto() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
