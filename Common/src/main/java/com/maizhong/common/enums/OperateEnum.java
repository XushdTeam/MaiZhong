package com.maizhong.common.enums;

/**
 * 操作类型枚举
 * Created by Xushd on 2017/2/28.
 */
public enum OperateEnum {
    SUCCESS(200,"操作成功"),
    FAILE(500,"操作失败"),
    NAME_REPEAT(500,"名称重复"),
    ADD_REPEAT(500,"添加重复"),
    ROLE_IS_USED(500,"角色下有用户存在"),
    USER_PHONE_EXIST(500,"该手机号已经注册"),
    FILE_SIZE(500,"文件太大"),
    FILE_EMPTY(500,"文件为空"),
    PASS_NOT_EQUAIL(500,"两次密码不一致"),
    PASS_ERROR(500,"原密码错误"),
    FILE_UPLOAD_SUCCESS(200,"上传成功"),
    SB(500,"你是不是疯了"),
    NO_CAR(500,"添加的汽车不存在" ),
    THAN_FOUR(500,"同一栏目不能超过4条" );

    private int state;

    private String stateInfo;

    OperateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
