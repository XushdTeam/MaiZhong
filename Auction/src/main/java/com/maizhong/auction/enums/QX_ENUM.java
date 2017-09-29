package com.maizhong.auction.enums;

/**
 * 缺陷类型1故障2卡滞3异响4漏油5沉重
 * Created by Xushd on 2017/9/8.
 */
public enum QX_ENUM {
    A(1,"故障"),B(2,"卡滞"),C(3,"异响"),D(4,"漏油"),E(5,"沉重");
    private int index;
    private String name;

    QX_ENUM(int index, String name) {
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
        for (QX_ENUM state : values()) {
            if(state.getIndex()==index){
                return state.getName();
            }
        }
        return "正常";
    }
}
