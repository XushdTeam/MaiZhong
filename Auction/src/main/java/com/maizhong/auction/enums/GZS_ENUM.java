package com.maizhong.auction.enums;

/**
 * 购置税 1购置税政（征税）2购置税政（免税）3无购置税
 * Created by Xushd on 2017/9/8.
 */
public enum GZS_ENUM {
    A(1,"购置税政（征税）"),B(2,"购置税政（免税）"),C(3,"无购置税");
    private int index;
    private String name;

    GZS_ENUM(int index,String name) {
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
        for (GZS_ENUM state : values()) {
            if(state.getIndex()==index){
                return state.getName();
            }
        }
        return "不详";
    }
}
