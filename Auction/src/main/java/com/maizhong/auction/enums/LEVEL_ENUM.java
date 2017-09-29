package com.maizhong.auction.enums;

/**
 * 评级 1A2B3C4D
 * Created by Xushd on 2017/9/8.
 */
public enum LEVEL_ENUM {
    A(1,"A","较好","全车除前后保险杠外无修复痕迹"),
    B(2,"B","良好","全车结构件无损伤，加强件无严重损伤，允许覆盖件和加强件有修复"),
    C(3,"C","一般","全车结构件无重大损伤，允许覆盖件和加强件有修复"),
    D(4,"D","较差","全车结构件发生一处或多处变形类损伤");

    private int index;
    private String name;
    private String des1;
    private String des2;

    LEVEL_ENUM(int index, String name, String des1, String des2) {
        this.index = index;
        this.name = name;
        this.des1 = des1;
        this.des2 = des2;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getDes1() {
        return des1;
    }

    public String getDes2() {
        return des2;
    }

    public static LEVEL_ENUM indexOf(int index){
        for (LEVEL_ENUM state : values()) {
            if(state.getIndex()==index){
                return state;
            }
        }
        return D;
    }
}
