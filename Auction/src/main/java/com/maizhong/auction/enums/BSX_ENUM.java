package com.maizhong.auction.enums;

/**
 * 变速箱1手动2自动3CVT
 * Created by Xushd on 2017/9/8.
 */
public enum BSX_ENUM {
    A(1,"手动"),
    B(2,"自动"),
    C(3,"CVT");

    private int index;
    private String name;

    BSX_ENUM(int index,String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public static String indexOf(int index){
        for (BSX_ENUM state : values()) {
            if(state.getIndex()==index){
                return state.getName();
            }
        }
        return "不详";
    }
}
