package com.maizhong.auction.pojo;

public class CkOther {
    private Long id;

    private Long carId;

    private Integer wzF;

    private String wzQ;

    private Integer pfbz;

    private String other;

    private Integer qmgjd;

    private Integer pj;

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

    public Integer getWzF() {
        return wzF;
    }

    public void setWzF(Integer wzF) {
        this.wzF = wzF;
    }

    public String getWzQ() {
        return wzQ;
    }

    public void setWzQ(String wzQ) {
        this.wzQ = wzQ == null ? null : wzQ.trim();
    }

    public Integer getPfbz() {
        return pfbz;
    }

    public void setPfbz(Integer pfbz) {
        this.pfbz = pfbz;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public Integer getQmgjd() {
        return qmgjd;
    }

    public void setQmgjd(Integer qmgjd) {
        this.qmgjd = qmgjd;
    }

    public Integer getPj() {
        return pj;
    }

    public void setPj(Integer pj) {
        this.pj = pj;
    }
}