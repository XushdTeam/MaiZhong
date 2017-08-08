package com.maizhong.auction.pojo;

public class CkVerify {
    private Long id;

    private Long carId;

    private String xsz;

    private String djz;

    private String cjh;

    private String ltgg;

    private String bxlc;

    private String startPrice;

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

    public String getXsz() {
        return xsz;
    }

    public void setXsz(String xsz) {
        this.xsz = xsz == null ? null : xsz.trim();
    }

    public String getDjz() {
        return djz;
    }

    public void setDjz(String djz) {
        this.djz = djz == null ? null : djz.trim();
    }

    public String getCjh() {
        return cjh;
    }

    public void setCjh(String cjh) {
        this.cjh = cjh == null ? null : cjh.trim();
    }

    public String getLtgg() {
        return ltgg;
    }

    public void setLtgg(String ltgg) {
        this.ltgg = ltgg == null ? null : ltgg.trim();
    }

    public String getBxlc() {
        return bxlc;
    }

    public void setBxlc(String bxlc) {
        this.bxlc = bxlc == null ? null : bxlc.trim();
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice == null ? null : startPrice.trim();
    }
}