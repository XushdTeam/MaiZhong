package com.maizhong.auction.dto;

/**
 * Created by Xushd on 2017/7/17.
 */
public class OtherDto {



    //违章分+元
    private String wz;
    //排放标准
    private String pfbz;
    //评级
    private String pj;

    private String other;

    private String pjDes1;

    private String pjDes2;

    public String getPjDes1() {
        return pjDes1;
    }

    public void setPjDes1(String pjDes1) {
        this.pjDes1 = pjDes1;
    }

    public String getPjDes2() {
        return pjDes2;
    }

    public void setPjDes2(String pjDes2) {
        this.pjDes2 = pjDes2;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public OtherDto() {
    }
    public String getWz() {
        return wz;
    }

    public void setWz(String wz) {
        this.wz = wz;
    }


    public String getPfbz() {
        return pfbz;
    }

    public void setPfbz(String pfbz) {
        this.pfbz = pfbz;
    }

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }
}
