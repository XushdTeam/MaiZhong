package com.maizhong.auction.dto;

import java.util.List;

/**
 * 检测报告 实体类
 * Created by Xushd on 2017/9/8.
 */
public class CarReportDTO {

    /**
     * 附加
     */
    private int like;
    private int likeCount;

    //报告编号
    private String reportNum;
    //检测时间
    private String checkTime;
    //车辆ID
    private long carId;
    //车型名称
    private String modelName;
    //评定等级
    private String level;
    //等级说明
    private String levelDes1;
    private String levelDes2;
    //注册时间
    private String registTime;
    //公里数
    private String mileage;
    //排放标准
    private String pfbz;
    //注册地
    private String registLocal;
    //起拍价
    private String startPrice;
    //保留价
    private String savePrice;
    //拍卖次数
    private int count;

    //基本信息
    private List<ItemDTO> jb;
    //手续信息
    private List<ItemDTO> sx;
    //配置信息
    private List<ItemDTO> pz;
    //附加信息
    private List<ItemDTO> fj;
    //动力信息
    private List<ItemDTO> dl;
    //外观缺陷
    private List<ItemDTO> wg;
    //内饰缺陷
    private List<ItemDTO> ns;
    //泡水
    private List<ItemDTO> ps;
    //火烧
    private List<ItemDTO> hs;
    //事故
    private List<ItemDTO> sg;
    //基本图片
    private List<ItemDTO> imgs;

    public CarReportDTO() {
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public List<ItemDTO> getImgs() {
        return imgs;
    }

    public void setImgs(List<ItemDTO> imgs) {
        this.imgs = imgs;
    }

    public String getReportNum() {
        return reportNum;
    }

    public void setReportNum(String reportNum) {
        this.reportNum = reportNum;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelDes1() {
        return levelDes1;
    }

    public void setLevelDes1(String levelDes1) {
        this.levelDes1 = levelDes1;
    }

    public String getLevelDes2() {
        return levelDes2;
    }

    public void setLevelDes2(String levelDes2) {
        this.levelDes2 = levelDes2;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getPfbz() {
        return pfbz;
    }

    public void setPfbz(String pfbz) {
        this.pfbz = pfbz;
    }

    public String getRegistLocal() {
        return registLocal;
    }

    public void setRegistLocal(String registLocal) {
        this.registLocal = registLocal;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getSavePrice() {
        return savePrice;
    }

    public void setSavePrice(String savePrice) {
        this.savePrice = savePrice;
    }

    public List<ItemDTO> getJb() {
        return jb;
    }

    public void setJb(List<ItemDTO> jb) {
        this.jb = jb;
    }

    public List<ItemDTO> getSx() {
        return sx;
    }

    public void setSx(List<ItemDTO> sx) {
        this.sx = sx;
    }

    public List<ItemDTO> getPz() {
        return pz;
    }

    public void setPz(List<ItemDTO> pz) {
        this.pz = pz;
    }

    public List<ItemDTO> getFj() {
        return fj;
    }

    public void setFj(List<ItemDTO> fj) {
        this.fj = fj;
    }

    public List<ItemDTO> getDl() {
        return dl;
    }

    public void setDl(List<ItemDTO> dl) {
        this.dl = dl;
    }

    public List<ItemDTO> getWg() {
        return wg;
    }

    public void setWg(List<ItemDTO> wg) {
        this.wg = wg;
    }

    public List<ItemDTO> getNs() {
        return ns;
    }

    public void setNs(List<ItemDTO> ns) {
        this.ns = ns;
    }

    public List<ItemDTO> getPs() {
        return ps;
    }

    public void setPs(List<ItemDTO> ps) {
        this.ps = ps;
    }

    public List<ItemDTO> getHs() {
        return hs;
    }

    public void setHs(List<ItemDTO> hs) {
        this.hs = hs;
    }

    public List<ItemDTO> getSg() {
        return sg;
    }

    public void setSg(List<ItemDTO> sg) {
        this.sg = sg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
