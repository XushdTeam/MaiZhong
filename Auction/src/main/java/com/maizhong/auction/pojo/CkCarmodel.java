package com.maizhong.auction.pojo;

public class CkCarmodel {
    private Long id;

    private Long carId;

    private Long modelId;

    private String modelName;

    private String modelShorname;

    private Integer bsx;

    private Integer qdfs;

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

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getModelShorname() {
        return modelShorname;
    }

    public void setModelShorname(String modelShorname) {
        this.modelShorname = modelShorname == null ? null : modelShorname.trim();
    }

    public Integer getBsx() {
        return bsx;
    }

    public void setBsx(Integer bsx) {
        this.bsx = bsx;
    }

    public Integer getQdfs() {
        return qdfs;
    }

    public void setQdfs(Integer qdfs) {
        this.qdfs = qdfs;
    }
}