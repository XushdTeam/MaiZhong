package com.maizhong.auction.enums;

/**
 * 排放标准 1 国2及以下 2 “国3” 3 “国4” 4 “国5” 5 不详
 * Created by Xushd on 2017/9/8.
 */
public enum PFBZ_ENUM {
    A(1,"国2及以下"),
    B(2,"国3"),
    C(3,"国4"),
    D(4,"国5"),
    E(5,"不详");

    private int index;
    private String name;

    PFBZ_ENUM(int index,String name) {
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
        for (PFBZ_ENUM state : values()) {
            if(state.getIndex()==index){
                return state.getName();
            }
        }
        return "不详";
    }

}
