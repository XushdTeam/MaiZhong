package com.maizhong.auction.enums;

/**
 * 使用性质 1非营运 2运营 3营转非 4租赁 5教练
 * Created by Xushd on 2017/9/8.
 */
public enum SYXZ_ENUM {
    A(1,"非营运 "),
    B(2,"运营"),
    C(3,"营转非"),
    D(4,"租赁"),
    E(5,"教练");

    private int index;
    private String name;

    SYXZ_ENUM(int index,String name) {
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
        for (SYXZ_ENUM state : values()) {
            if(state.getIndex()==index){
                return state.getName();
            }
        }
        return "不详";
    }
}
