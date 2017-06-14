package com.maizhong.auction.dto;

import java.util.Date;

/**
 * Created by Xushd on 2017/6/12.
 */
public class PriceDto {

    private Long nowPrice;
    private String threadNum;
    private Date updateTime;


    public PriceDto(Long nowPrice, String threadNum, Date updateTime) {
        this.nowPrice = nowPrice;
        this.threadNum = threadNum;
        this.updateTime = updateTime;
    }

    public PriceDto() {
    }

    public Long getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(Long nowPrice) {
        this.nowPrice = nowPrice;
    }

    public String getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(String threadNum) {
        this.threadNum = threadNum;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
