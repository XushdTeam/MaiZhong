package com.maizhong.youpin.dto;

/**
 * Created by Xushd on 2017/8/21.
 */
public class SocketMsg {

    private long orderId;
    private String time;

    public SocketMsg(long orderId, String time) {
        this.orderId = orderId;
        this.time = time;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
