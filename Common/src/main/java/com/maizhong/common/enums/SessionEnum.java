package com.maizhong.common.enums;

/**
 * SessionKEY
 * Created by Xushd on 2017/2/28.
 */
public enum SessionEnum {
    VERIFYCODE_KEY("verifyCode"),
    USER_KEY("userInfo");


    private String stateInfo;

    SessionEnum(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    @Override
    public String toString() {
        return this.stateInfo;
    }
}
