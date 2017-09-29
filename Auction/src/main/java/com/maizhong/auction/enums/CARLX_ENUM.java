package com.maizhong.auction.enums;

/**
 * 车辆类型 1微型车2小型车3中型车4大型车
 * Created by Xushd on 2017/9/8.
 */
public enum CARLX_ENUM {
    A(1,"微型车"),
    B(2,"小型车"),
    C(3,"中型车"),
    D(4,"大型车");

    private int index;
    private String name;

    CARLX_ENUM(int index,String name) {
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
        for (CARLX_ENUM state : values()) {
            if(state.getIndex()==index){
                return state.getName();
            }
        }
        return "不详";
    }

}
