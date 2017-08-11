package com.maizhong.auction.pojo;

public class AcFreeze {
    private Long id;

    private Long carId;

    private Long userId;

    private Long freeze;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFreeze() {
        return freeze;
    }

    public void setFreeze(Long freeze) {
        this.freeze = freeze;
    }
}