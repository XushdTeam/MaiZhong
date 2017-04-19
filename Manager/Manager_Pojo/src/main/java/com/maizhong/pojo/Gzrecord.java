package com.maizhong.pojo;

import java.util.Date;

public class Gzrecord {
    private Long id;

    private String param;

    private Long modelId;

    private Integer city;

    private Integer mail;

    private String regDate;

    private String priceMaxA;

    private String priceMinA;

    private String priceMaxB;

    private String priceMinB;

    private String priceMaxC;

    private String priceMinC;

    private String priceMaxD;

    private String priceMinD;

    private Date time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getMail() {
        return mail;
    }

    public void setMail(Integer mail) {
        this.mail = mail;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate == null ? null : regDate.trim();
    }

    public String getPriceMaxA() {
        return priceMaxA;
    }

    public void setPriceMaxA(String priceMaxA) {
        this.priceMaxA = priceMaxA == null ? null : priceMaxA.trim();
    }

    public String getPriceMinA() {
        return priceMinA;
    }

    public void setPriceMinA(String priceMinA) {
        this.priceMinA = priceMinA == null ? null : priceMinA.trim();
    }

    public String getPriceMaxB() {
        return priceMaxB;
    }

    public void setPriceMaxB(String priceMaxB) {
        this.priceMaxB = priceMaxB == null ? null : priceMaxB.trim();
    }

    public String getPriceMinB() {
        return priceMinB;
    }

    public void setPriceMinB(String priceMinB) {
        this.priceMinB = priceMinB == null ? null : priceMinB.trim();
    }

    public String getPriceMaxC() {
        return priceMaxC;
    }

    public void setPriceMaxC(String priceMaxC) {
        this.priceMaxC = priceMaxC == null ? null : priceMaxC.trim();
    }

    public String getPriceMinC() {
        return priceMinC;
    }

    public void setPriceMinC(String priceMinC) {
        this.priceMinC = priceMinC == null ? null : priceMinC.trim();
    }

    public String getPriceMaxD() {
        return priceMaxD;
    }

    public void setPriceMaxD(String priceMaxD) {
        this.priceMaxD = priceMaxD == null ? null : priceMaxD.trim();
    }

    public String getPriceMinD() {
        return priceMinD;
    }

    public void setPriceMinD(String priceMinD) {
        this.priceMinD = priceMinD == null ? null : priceMinD.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}