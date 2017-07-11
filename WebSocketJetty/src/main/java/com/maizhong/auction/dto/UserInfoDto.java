package com.maizhong.auction.dto;

/**
 * Created by Xushd on 2017/6/30.
 */
public class UserInfoDto {

    private long userId;
    private String bussinessName;

    public UserInfoDto() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getBussinessName() {
        return bussinessName;
    }

    public void setBussinessName(String bussinessName) {
        this.bussinessName = bussinessName;
    }
}
