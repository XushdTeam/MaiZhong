package com.maizhong.common.dto;

/**
 * Description:基础库字段l.
 * User: 王存浩
 * Date: 2017-03-31
 * Time: 11:27
 */
public class CarBaseDTO {
    private Long id;
    private String carBrand;//品牌
    private String initial;//品牌首字母
    private String carSeries;//车系
    private String carType;//车型
    private String carYear;//年款
    private String carFactoryPrice;//厂商指导价
    private String carSize;//长宽高
    private String carFactory;//厂商
    private String carLevel;//级别
    private String carLOil;//工信部油耗
    private String carZMm;//轴距
    private String carWarranty;//整车质保
    private String carFuelLabel;//燃油标号
    private String carEnvironmentStandards;//环保标准
    private String carLuggage;//行李箱容积
    private String carColor;//外观颜色
    private String carDisplacement;//排量
    private String carEngine;//发动机
    private String carMarPower;//最大功率
    private String carHsFactory;//百公里加速时间
    private String carGearbox;//变速箱
    private String carMaxTorque;//最大扭矩
    private String carMaxspeed;//最高车速
    private String carDriveMode;//驱动方式

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getCarFactoryPrice() {
        return carFactoryPrice;
    }

    public void setCarFactoryPrice(String carFactoryPrice) {
        this.carFactoryPrice = carFactoryPrice;
    }

    public String getCarSize() {
        return carSize;
    }

    public void setCarSize(String carSize) {
        this.carSize = carSize;
    }

    public String getCarFactory() {
        return carFactory;
    }

    public void setCarFactory(String carFactory) {
        this.carFactory = carFactory;
    }

    public String getCarLevel() {
        return carLevel;
    }

    public void setCarLevel(String carLevel) {
        this.carLevel = carLevel;
    }

    public String getCarLOil() {
        return carLOil;
    }

    public void setCarLOil(String carLOil) {
        this.carLOil = carLOil;
    }

    public String getCarZMm() {
        return carZMm;
    }

    public void setCarZMm(String carZMm) {
        this.carZMm = carZMm;
    }

    public String getCarWarranty() {
        return carWarranty;
    }

    public void setCarWarranty(String carWarranty) {
        this.carWarranty = carWarranty;
    }

    public String getCarFuelLabel() {
        return carFuelLabel;
    }

    public void setCarFuelLabel(String carFuelLabel) {
        this.carFuelLabel = carFuelLabel;
    }

    public String getCarEnvironmentStandards() {
        return carEnvironmentStandards;
    }

    public void setCarEnvironmentStandards(String carEnvironmentStandards) {
        this.carEnvironmentStandards = carEnvironmentStandards;
    }

    public String getCarLuggage() {
        return carLuggage;
    }

    public void setCarLuggage(String carLuggage) {
        this.carLuggage = carLuggage;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarDisplacement() {
        return carDisplacement;
    }

    public void setCarDisplacement(String carDisplacement) {
        this.carDisplacement = carDisplacement;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

    public String getCarMarPower() {
        return carMarPower;
    }

    public void setCarMarPower(String carMarPower) {
        this.carMarPower = carMarPower;
    }

    public String getCarHsFactory() {
        return carHsFactory;
    }

    public void setCarHsFactory(String carHsFactory) {
        this.carHsFactory = carHsFactory;
    }

    public String getCarGearbox() {
        return carGearbox;
    }

    public void setCarGearbox(String carGearbox) {
        this.carGearbox = carGearbox;
    }

    public String getCarMaxTorque() {
        return carMaxTorque;
    }

    public void setCarMaxTorque(String carMaxTorque) {
        this.carMaxTorque = carMaxTorque;
    }

    public String getCarMaxspeed() {
        return carMaxspeed;
    }

    public void setCarMaxspeed(String carMaxspeed) {
        this.carMaxspeed = carMaxspeed;
    }

    public String getCarDriveMode() {
        return carDriveMode;
    }

    public void setCarDriveMode(String carDriveMode) {
        this.carDriveMode = carDriveMode;
    }

    public CarBaseDTO() {
    }

    public CarBaseDTO(Long id, String carBrand, String initial, String carSeries, String carType, String carYear,
                      String carFactoryPrice, String carSize, String carFactory, String carLevel, String carLOil,
                      String carZMm, String carWarranty, String carFuelLabel, String carEnvironmentStandards,
                      String carLuggage, String carColor, String carDisplacement, String carEngine,
                      String carMarPower, String carHsFactory, String carGearbox, String carMaxTorque,
                      String carMaxspeed, String carDriveMode) {
        this.id = id;
        this.carBrand = carBrand;
        this.initial = initial;
        this.carSeries = carSeries;
        this.carType = carType;
        this.carYear = carYear;
        this.carFactoryPrice = carFactoryPrice;
        this.carSize = carSize;
        this.carFactory = carFactory;
        this.carLevel = carLevel;
        this.carLOil = carLOil;
        this.carZMm = carZMm;
        this.carWarranty = carWarranty;
        this.carFuelLabel = carFuelLabel;
        this.carEnvironmentStandards = carEnvironmentStandards;
        this.carLuggage = carLuggage;
        this.carColor = carColor;
        this.carDisplacement = carDisplacement;
        this.carEngine = carEngine;
        this.carMarPower = carMarPower;
        this.carHsFactory = carHsFactory;
        this.carGearbox = carGearbox;
        this.carMaxTorque = carMaxTorque;
        this.carMaxspeed = carMaxspeed;
        this.carDriveMode = carDriveMode;
    }
}
