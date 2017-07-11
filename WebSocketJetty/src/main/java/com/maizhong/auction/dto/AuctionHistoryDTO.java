package com.maizhong.auction.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 出价记录
 * Created by Xushd on 2017/6/28.
 */
public class AuctionHistoryDTO {

    private long carId;

    private Date auctionDate;

    private String price;

    private int puls;

    private String bussinessName;

    private long userId;

    private String ch;

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public AuctionHistoryDTO(long carId, Date auctionDate, String price, int puls, String bussinessName, long userId) {
        this.carId = carId;
        this.auctionDate = auctionDate;
        this.price = price;
        this.puls = puls;
        this.bussinessName = bussinessName;
        this.userId = userId;
    }

    public AuctionHistoryDTO() {
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public Date getAuctionDate() {
        return auctionDate;
    }

    public void setAuctionDate(Date auctionDate) {
        this.auctionDate = auctionDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPuls() {
        return puls;
    }

    public void setPuls(int puls) {
        this.puls = puls;
    }

    public String getBussinessName() {
        return bussinessName;
    }

    public void setBussinessName(String bussinessName) {
        this.bussinessName = bussinessName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
