package com.maizhong.auction.pojo;

public class TpNow {
    private Long id;

    private Long carId;

    private String ch;

    private Long overTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch == null ? null : ch.trim();
    }

    public Long getOverTime() {
        return overTime;
    }

    public void setOverTime(Long overTime) {
        this.overTime = overTime;
    }
}