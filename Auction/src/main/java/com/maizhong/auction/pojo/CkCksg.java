package com.maizhong.auction.pojo;

public class CkCksg {
    private Long id;

    private Long carId;

    private Integer fw;

    private Integer bw;

    private Integer ms;

    private String des;

    private String img;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Integer getFw() {
        return fw;
    }

    public void setFw(Integer fw) {
        this.fw = fw;
    }

    public Integer getBw() {
        return bw;
    }

    public void setBw(Integer bw) {
        this.bw = bw;
    }

    public Integer getMs() {
        return ms;
    }

    public void setMs(Integer ms) {
        this.ms = ms;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}