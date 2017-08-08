package com.maizhong.auction.dto;

/**
 * 拍卖车辆
 * Created by Xushd on 2017/6/28.
 */

public class CarAcutionDTO {

    private long id;

    private long carId;

    //结束时间 时间戳
    private long overTime;

    //当前价格
    private String nowPrice;

    private String channel;




    //当前出价用户id
    private long lastUserId;

    public long getLastUserId() {
        return lastUserId;
    }

    public void setLastUserId(long lastUserId) {
        this.lastUserId = lastUserId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public CarAcutionDTO(long carId, long overTime, String nowPrice) {
        this.carId = carId;
        this.overTime = overTime;
        this.nowPrice = nowPrice;
    }

    public CarAcutionDTO() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getOverTime() {
        return overTime;
    }

    public void setOverTime(long overTime) {
        this.overTime = overTime;
    }

    public String getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(String nowPrice) {
        this.nowPrice = nowPrice;
    }
}
