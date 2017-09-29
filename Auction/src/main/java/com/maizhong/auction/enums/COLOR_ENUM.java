package com.maizhong.auction.enums;

/**
 * 车身颜色 1黑2蓝3白4红5银6金7绿8灰9紫10黄11橙12粉13其他颜色
 * Created by Xushd on 2017/9/8.
 */
public enum COLOR_ENUM {
    A(1,"黑色"),
    B(2,"蓝色"),
    C(3,"白色"),
    D(4,"红色"),
    E(5,"银色"),
    F(6,"金色"),
    G(7,"绿色"),
    H(8,"灰色"),
    I(9,"紫色"),
    J(10,"黄色"),
    K(11,"橙色"),
    L(12,"粉色"),
    M(13,"其他颜色");

    private int index;
    private String name;

    COLOR_ENUM(int index,String name) {
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
        for (COLOR_ENUM state : values()) {
            if(state.getIndex()==index){
                return state.getName();
            }
        }
        return "不详";
    }
}
