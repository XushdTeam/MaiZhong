package com.maizhong.auction.enums;

/**
 * 使用方 1个人2单位3出租车4汽车租赁公司5汽车销售（服务）公司'
 * Created by Xushd on 2017/9/8.
 */
public enum SYF_ENUM {

    A(1,"个人"),B(2,"单位"),C(3,"出租车"),D(4,"汽车租赁公司"),E(5,"汽车销售（服务）公司");
    private int index;
    private String name;

    SYF_ENUM(int index,String name) {
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
        for (SYF_ENUM state : values()) {
            if(state.getIndex()==index){
                return state.getName();
            }
        }
        return "不详";
    }
}
