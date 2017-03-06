package com.maizhong.pojo;

public class TbCarType {
    private Long id;

    private String typeName;

    private String typeImg;

    private Integer typeSequence;

    private Integer status;

    private Integer delflag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeImg() {
        return typeImg;
    }

    public void setTypeImg(String typeImg) {
        this.typeImg = typeImg == null ? null : typeImg.trim();
    }

    public Integer getTypeSequence() {
        return typeSequence;
    }

    public void setTypeSequence(Integer typeSequence) {
        this.typeSequence = typeSequence;
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