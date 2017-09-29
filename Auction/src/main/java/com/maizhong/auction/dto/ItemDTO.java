package com.maizhong.auction.dto;

/**
 * Created by Xushd on 2017/9/8.
 */
public class ItemDTO {

    private String n;
    private String d;

    public ItemDTO() {
    }

    public ItemDTO(String n, String d) {
        this.n = n;
        this.d = d;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
