package com.maizhong.auction.dto;

import java.util.List;

/**
 * Created by Xushd on 2017/7/17.
 */
public class CarDetailDto {

    private long carId;

    private String modelName;

    //拍卖次数
    private int auctionCount;

    private String startPrice;

    //变速箱1手动2自动3CVT
    private String bsx;
    //驱动方式1两驱2四驱
    private String qdfs;

    private String checkNum;

    private String checkDate;

    private String savePrice;

    //基本图片
    private List<ImgDesc> baseImgArry;

    //登记证
    private DjzDto djz;

    //ck_verify
    private VerIfyDto verify;

    //ck_other
    private OtherDto other;

    //ck_xsz
    private XszDto xsz;

    //ck_qtz
    private QtzDto qtz;

    //配置
    private PzDto pz;
    //动力
    private DlDto dl;
    //外观缺陷
    List<ImgDesc> wgqx;
    //内饰缺陷
    List<ImgDesc> nsqx;
    //泡水
    List<ImgDesc> ps;
    //火烧
    List<ImgDesc> hs;
    //事故
    List<ImgDesc> sg;


    public CarDetailDto() {
    }

    public String getSavePrice() {
        return savePrice;
    }

    public void setSavePrice(String savePrice) {
        this.savePrice = savePrice;
    }

    public int getAuctionCount() {
        return auctionCount;
    }

    public void setAuctionCount(int auctionCount) {
        this.auctionCount = auctionCount;
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

    public String getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getBsx() {
        return bsx;
    }

    public void setBsx(String bsx) {
        this.bsx = bsx;
    }

    public String getQdfs() {
        return qdfs;
    }

    public void setQdfs(String qdfs) {
        this.qdfs = qdfs;
    }

    public List<ImgDesc> getBaseImgArry() {
        return baseImgArry;
    }

    public void setBaseImgArry(List<ImgDesc> baseImgArry) {
        this.baseImgArry = baseImgArry;
    }

    public DjzDto getDjz() {
        return djz;
    }

    public void setDjz(DjzDto djz) {
        this.djz = djz;
    }

    public VerIfyDto getVerify() {
        return verify;
    }

    public void setVerify(VerIfyDto verify) {
        this.verify = verify;
    }

    public OtherDto getOther() {
        return other;
    }

    public void setOther(OtherDto other) {
        this.other = other;
    }

    public XszDto getXsz() {
        return xsz;
    }

    public void setXsz(XszDto xsz) {
        this.xsz = xsz;
    }

    public QtzDto getQtz() {
        return qtz;
    }

    public void setQtz(QtzDto qtz) {
        this.qtz = qtz;
    }

    public PzDto getPz() {
        return pz;
    }

    public void setPz(PzDto pz) {
        this.pz = pz;
    }

    public DlDto getDl() {
        return dl;
    }

    public void setDl(DlDto dl) {
        this.dl = dl;
    }

    public List<ImgDesc> getWgqx() {
        return wgqx;
    }

    public void setWgqx(List<ImgDesc> wgqx) {
        this.wgqx = wgqx;
    }

    public List<ImgDesc> getNsqx() {
        return nsqx;
    }

    public void setNsqx(List<ImgDesc> nsqx) {
        this.nsqx = nsqx;
    }

    public List<ImgDesc> getPs() {
        return ps;
    }

    public void setPs(List<ImgDesc> ps) {
        this.ps = ps;
    }

    public List<ImgDesc> getHs() {
        return hs;
    }

    public void setHs(List<ImgDesc> hs) {
        this.hs = hs;
    }

    public List<ImgDesc> getSg() {
        return sg;
    }

    public void setSg(List<ImgDesc> sg) {
        this.sg = sg;
    }
}
