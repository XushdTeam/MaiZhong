package com.maizhong.pojo;

import java.util.Date;

public class TbCarProp {
    private Long id;

    private Long carId;

    private Integer unable;

    private String manufacturers;

    private String construction;

    private String size;

    private Double axleDistance;

    private String engine;

    private String oilNum;

    private String capacity;

    private String oilCost;

    private String environmentNorm;

    private String speed100;

    private String protectLimit;

    private Double speedHigh;

    private String driveType;

    private Date createTime;

    private Date updateTime;

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

    public Integer getUnable() {
        return unable;
    }

    public void setUnable(Integer unable) {
        this.unable = unable;
    }

    public String getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers == null ? null : manufacturers.trim();
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction == null ? null : construction.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public Double getAxleDistance() {
        return axleDistance;
    }

    public void setAxleDistance(Double axleDistance) {
        this.axleDistance = axleDistance;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine == null ? null : engine.trim();
    }

    public String getOilNum() {
        return oilNum;
    }

    public void setOilNum(String oilNum) {
        this.oilNum = oilNum == null ? null : oilNum.trim();
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity == null ? null : capacity.trim();
    }

    public String getOilCost() {
        return oilCost;
    }

    public void setOilCost(String oilCost) {
        this.oilCost = oilCost == null ? null : oilCost.trim();
    }

    public String getEnvironmentNorm() {
        return environmentNorm;
    }

    public void setEnvironmentNorm(String environmentNorm) {
        this.environmentNorm = environmentNorm == null ? null : environmentNorm.trim();
    }

    public String getSpeed100() {
        return speed100;
    }

    public void setSpeed100(String speed100) {
        this.speed100 = speed100 == null ? null : speed100.trim();
    }

    public String getProtectLimit() {
        return protectLimit;
    }

    public void setProtectLimit(String protectLimit) {
        this.protectLimit = protectLimit == null ? null : protectLimit.trim();
    }

    public Double getSpeedHigh() {
        return speedHigh;
    }

    public void setSpeedHigh(Double speedHigh) {
        this.speedHigh = speedHigh;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType == null ? null : driveType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}