package com.maizhong.youpin.pojo;

public class SaleRecord {
    private Long id;

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

    private String price;

    private String ordernum;

    private Integer status;

    private String createtime;

    private String updatetime;

    private String solvePerson;

    private String solveTime;

    private Integer level;

    private String mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getSolvePerson() {
        return solvePerson;
    }

    public void setSolvePerson(String solvePerson) {
        this.solvePerson = solvePerson == null ? null : solvePerson.trim();
    }

    public String getSolveTime() {
        return solveTime;
    }

    public void setSolveTime(String solveTime) {
        this.solveTime = solveTime == null ? null : solveTime.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}