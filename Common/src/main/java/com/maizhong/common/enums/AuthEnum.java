package com.maizhong.common.enums;

/**
 * 登录错误枚举
 * Created by Xushd on 2017/3/1.
 */
public enum AuthEnum {

    VERIFYCODE_ERROR(500,"验证码错误"),
    USER_NO_EXIT(500,"用户不存在"),
    USER_ERROR_PASSWORD(500,"密码错误"),
    USER_STOP(500,"帐号已停用"),
    SUCCESS(200,"登录成功");

    AuthEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    private int state;

    private String stateInfo;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
