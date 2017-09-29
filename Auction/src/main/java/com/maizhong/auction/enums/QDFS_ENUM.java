package com.maizhong.auction.enums;

/**
 * 驱动方式1两驱2四驱
 * Created by Xushd on 2017/9/8.
 */
public enum  QDFS_ENUM {
    A(1,"两驱"),
    B(2,"四驱");

    private int index;
    private String name;

    QDFS_ENUM(int index,String name) {
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
        for (QDFS_ENUM state : values()) {
            if(state.getIndex()==index){
                return state.getName();
            }
        }
        return "不详";
    }


}
