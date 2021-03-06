package com.maizhong.pojo;

public class OrderInfo {
    private Long infoId;

    private Long orderNumber;

    private Long modelId;

    private String regDate;

    private String cityId;

    private String sKm;

    private String color;

    private String jqx;

    private String nj;

    private String xz;

    private String gh;

    private String ghtime;

    private String method;

    private String ck;

    private Integer delflag;

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate == null ? null : regDate.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getsKm() {
        return sKm;
    }

    public void setsKm(String sKm) {
        this.sKm = sKm == null ? null : sKm.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getJqx() {
        return jqx;
    }

    public void setJqx(String jqx) {
        this.jqx = jqx == null ? null : jqx.trim();
    }

    public String getNj() {
        return nj;
    }

    public void setNj(String nj) {
        this.nj = nj == null ? null : nj.trim();
    }

    public String getXz() {
        return xz;
    }

    public void setXz(String xz) {
        this.xz = xz == null ? null : xz.trim();
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh == null ? null : gh.trim();
    }

    public String getGhtime() {
        return ghtime;
    }

    public void setGhtime(String ghtime) {
        this.ghtime = ghtime == null ? null : ghtime.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getCk() {
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck == null ? null : ck.trim();
    }

    public Integer getDelflag() {
        return delflag;
    }

    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
    }
}