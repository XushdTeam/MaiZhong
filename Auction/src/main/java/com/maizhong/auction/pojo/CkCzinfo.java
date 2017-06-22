package com.maizhong.auction.pojo;

public class CkCzinfo {
    private Long id;

    private Long carId;

    private String czxx;

    private Integer zjlx;

    private Integer djzczyz;

    private String yxzj;

    private String lxdh;

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

    public String getCzxx() {
        return czxx;
    }

    public void setCzxx(String czxx) {
        this.czxx = czxx == null ? null : czxx.trim();
    }

    public Integer getZjlx() {
        return zjlx;
    }

    public void setZjlx(Integer zjlx) {
        this.zjlx = zjlx;
    }

    public Integer getDjzczyz() {
        return djzczyz;
    }

    public void setDjzczyz(Integer djzczyz) {
        this.djzczyz = djzczyz;
    }

    public String getYxzj() {
        return yxzj;
    }

    public void setYxzj(String yxzj) {
        this.yxzj = yxzj == null ? null : yxzj.trim();
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh == null ? null : lxdh.trim();
    }
}