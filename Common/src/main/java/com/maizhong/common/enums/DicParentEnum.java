package com.maizhong.common.enums;

/**
 * Created by Xushd on 2017/3/2.
 */
public enum DicParentEnum {
    FUNCTION(1,"系统功能"),
    ADTYPE(13,"广告类型"),
    RATE(28,"利率"),
    CMID(17,"栏目类型");

    private int state;

    private String stateInfo;

    DicParentEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }


    public static String stateOf(int index){
        for (DicParentEnum state : values()) {
            if(state.getState()==index){
                return state.getStateInfo();
            }
        }
        return null;
    }
}
