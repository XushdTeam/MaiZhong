package com.maizhong.auction.pojo;

public class CkXsz {
    private Long id;

    private Long carId;

    private String pic1;

    private String pic2;

    private String pic3;

    private Integer wj;

    private String number;

    private Integer lx;

    private Integer xz;

    private String ppxh;

    private String cjh;

    private String fdjh;

    private String njh;

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

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1 == null ? null : pic1.trim();
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2 == null ? null : pic2.trim();
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3 == null ? null : pic3.trim();
    }

    public Integer getWj() {
        return wj;
    }

    public void setWj(Integer wj) {
        this.wj = wj;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getLx() {
        return lx;
    }

    public void setLx(Integer lx) {
        this.lx = lx;
    }

    public Integer getXz() {
        return xz;
    }

    public void setXz(Integer xz) {
        this.xz = xz;
    }

    public String getPpxh() {
        return ppxh;
    }

    public void setPpxh(String ppxh) {
        this.ppxh = ppxh == null ? null : ppxh.trim();
    }

    public String getCjh() {
        return cjh;
    }

    public void setCjh(String cjh) {
        this.cjh = cjh == null ? null : cjh.trim();
    }

    public String getFdjh() {
        return fdjh;
    }

    public void setFdjh(String fdjh) {
        this.fdjh = fdjh == null ? null : fdjh.trim();
    }

    public String getNjh() {
        return njh;
    }

    public void setNjh(String njh) {
        this.njh = njh == null ? null : njh.trim();
    }
}