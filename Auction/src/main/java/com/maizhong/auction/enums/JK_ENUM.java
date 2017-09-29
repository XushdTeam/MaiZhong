package com.maizhong.auction.enums;

/**
 * 1非进口2海关罚没3境外自带4海关进口5海关监管
 * Created by Xushd on 2017/9/8.
 */
public enum  JK_ENUM {
    A(1,"非进口"),B(2,"海关罚没"),C(3,"境外自带"),D(4,"海关进口"),E(5,"海关监管");

    private int index;
    private String name;

    JK_ENUM(int index, String name) {
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
        for (JK_ENUM state : values()) {
            if(state.getIndex()==index){
                return state.getName();
            }
        }
        return "不详";
    }
}
