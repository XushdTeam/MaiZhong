package com.maizhong.auction.enums;

/**
 *  1汽油2柴油3纯电动4混合动力5天然气
 * Created by Xushd on 2017/9/8.
 */
public enum RSZL_ENUM {
    A(1,"汽油"),
    B(2,"柴油"),
    C(3,"纯电动"),
    D(4,"混合动力"),
    E(5,"天然气");

    private int index;
    private String name;

    RSZL_ENUM(int index, String name) {
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
        for (RSZL_ENUM state : values()) {
            if(state.getIndex()==index){
                return state.getName();
            }
        }
        return "不详";
    }
}
