package com.maizhong.auction.enums;

/**
 * Created by Xushd on 2017/9/8.
 */
public enum  HAS_ENUM {
    A(1,"有"),B(2,"未见");
    private int index;
    private String name;

    HAS_ENUM(int index,String name) {
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
        for (HAS_ENUM state : values()) {
            if(state.getIndex()==index){
                return state.getName();
            }
        }
        return "未见";
    }
}
