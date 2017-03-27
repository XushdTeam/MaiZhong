package com.maizhong.pojo;

public class TbCarBrand {
    private Long id;

    private String initial;

    private String brandName;

    private String brandImg;

    private Integer brandSequence;

    private Integer status;

    private Integer delflag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial == null ? null : initial.trim();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getBrandImg() {
        return brandImg;
    }

    public void setBrandImg(String brandImg) {
        this.brandImg = brandImg == null ? null : brandImg.trim();
    }

    public Integer getBrandSequence() {
        return brandSequence;
    }

    public void setBrandSequence(Integer brandSequence) {
        this.brandSequence = brandSequence;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelflag() {
        return delflag;
    }

    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
    }
}