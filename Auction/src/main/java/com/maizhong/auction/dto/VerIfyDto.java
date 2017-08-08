package com.maizhong.auction.dto;

/**
 * Created by Xushd on 2017/7/17.
 */
public class VerIfyDto {

    private String djz;

    private String bxlc;

    //行驶证与实车
    private String xsz;

    public String getXsz() {
        return xsz;
    }

    public void setXsz(String xsz) {
        this.xsz = xsz;
    }

    public VerIfyDto() {
    }

    public String getDjz() {
        return djz;
    }

    public void setDjz(String djz) {
        this.djz = djz;
    }

    public String getBxlc() {
        return bxlc;
    }

    public void setBxlc(String bxlc) {
        this.bxlc = bxlc;
    }
}
