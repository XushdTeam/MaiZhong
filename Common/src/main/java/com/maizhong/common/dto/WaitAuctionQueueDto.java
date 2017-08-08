package com.maizhong.common.dto;

/**
 * 候拍队列中的对象
 * Created by Xushd on 2017/7/12.
 */
public class WaitAuctionQueueDto {

    //车辆id
    private long carId;
    //起拍价
    private String startPrice;
    //拍卖时长
    private int minutes;
    //拍卖通道
    private String channel;

    public WaitAuctionQueueDto() {
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
