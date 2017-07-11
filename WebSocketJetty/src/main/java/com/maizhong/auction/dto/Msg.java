package com.maizhong.auction.dto;

import java.util.Date;

/**
 * Created by Xushd on 2017/6/26.
 */
public class Msg {
    private int id;
    private long price;
    private String date;

    public Msg() {
    }

    public Msg(int id, long price, String date) {
        this.id = id;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
