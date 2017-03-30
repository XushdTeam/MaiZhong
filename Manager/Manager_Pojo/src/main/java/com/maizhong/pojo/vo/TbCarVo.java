package com.maizhong.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by yangFan on 2017/3/9.
 */
public class TbCarVo {


    //    <th>编号</th>
    private String id;
    private String number;
    private String name;
    //    <th>品牌</th>
    private String carBrand;
    //    <th>结构</th>
    private String carType;
    //    <th>型号  车系</th>
    private String carBrandLine;
    //    <th>颜色</th>
    private String carColor;
    //    <th>排量</th>
    private String capacity;
    //    <th>变速箱类型</th>
    private String gearbox;
    //    <th>卖点</th>
    private String sellpoint;
    //    <th>订金</th>
    private String reservePrice;
    //    <th>售价</th>
    private String sellPrice;
    //    <th>修改时间</th>
    private Date updateTime;
    //    <th>图片</th>
    private String image;
    //    <th>上架</th>
    private Integer unable;
    //    <th>库存</th>
    private Integer stockNum;
    //    <th>销量</th>
    private Integer sellNum;
    //    <th>所属商家</th>
    private String business;
    //    <th>权重</th>
    private String weight;
    //    <th>详情</th>
    private String details;


    //solr 字段
    private String carYear;
    private String shopPrice;
    private Date createTime;
    private String carBrandCopy;
    private String carBrandLineCopy;
    private String carTypeCopy;
    private String smimage;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    public Date getUpdateTime() {
        return updateTime;
    }




    public String getCarBrandCopy() {
        return carBrandCopy;
    }

    public void setCarBrandCopy(String carBrandCopy) {
        this.carBrandCopy = carBrandCopy;
    }

    public String getCarBrandLineCopy() {
        return carBrandLineCopy;
    }

    public void setCarBrandLineCopy(String carBrandLineCopy) {
        this.carBrandLineCopy = carBrandLineCopy;
    }

    public String getCarTypeCopy() {
        return carTypeCopy;
    }

    public void setCarTypeCopy(String carTypeCopy) {
        this.carTypeCopy = carTypeCopy;
    }

    public String getSmimage() {
        return smimage;
    }

    public void setSmimage(String smimage) {
        this.smimage = smimage;
    }


    public String getCarBrandLine() {
        return carBrandLine;
    }

    public void setCarBrandLine(String carBrandLine) {
        this.carBrandLine = carBrandLine;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getSellpoint() {
        return sellpoint;
    }

    public void setSellpoint(String sellpoint) {
        this.sellpoint = sellpoint;
    }

    public String getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(String reservePrice) {
        this.reservePrice = reservePrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getUnable() {
        return unable;
    }

    public void setUnable(Integer unable) {
        this.unable = unable;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(String shopPrice) {
        this.shopPrice = shopPrice;
    }
}
