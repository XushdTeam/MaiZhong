package com.maizhong.youpin.dto;

/**
 * Description;//
 * User;// 王存浩
 * Date;// 2017-08-19
 * Time;// 9;//55
 */
public class OrderInfoDto {
    private String cityId;
    private String cityName;// 北京,
    private String ck;// 车况良好,有过少量剐蹭或钣金,
    private String color;// 黑色,
    private String gh;// 0次,
    private String ghtime;// 无过户,
    private String gls;// 2.5,
    private String img;// http;////seriespic.che300.com/e8f39c340b1932e302bfacd29967a00a,
    private String imgArry;// http;////yppc.maizhongcar.com/carImg/1503045268198410.jpg,0,0,0,0,0,
    private String jqx;// 两个月以上,
    private String liter;// 2.4L,
    private String method;// 个人,
    private String modelId;// 29836,
    private String modelName;// 2016款 艾力绅 2.4L 经典版,
    private String nj;// 两个月以上,
    private String orderNum;// 150304527417724,
    private String param1;// 0c1m29836r2016-1g2.5,
    private String param2;// 8j2h4t1x1n2d2k2,
    private String pfbz;// 国5,
    private String registTime;// 2016-1,
    private String status;// 0,
    private String submitTime;// 2017-08-18 16;//34;//34,
    private String xz;// 非营运

    public OrderInfoDto() {
    }

    public OrderInfoDto(String cityId, String cityName, String ck, String color, String gh, String ghtime, String gls, String img, String imgArry, String jqx, String liter, String method, String modelId, String modelName, String nj, String orderNum, String param1, String param2, String pfbz, String registTime, String status, String submitTime, String xz) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.ck = ck;
        this.color = color;
        this.gh = gh;
        this.ghtime = ghtime;
        this.gls = gls;
        this.img = img;
        this.imgArry = imgArry;
        this.jqx = jqx;
        this.liter = liter;
        this.method = method;
        this.modelId = modelId;
        this.modelName = modelName;
        this.nj = nj;
        this.orderNum = orderNum;
        this.param1 = param1;
        this.param2 = param2;
        this.pfbz = pfbz;
        this.registTime = registTime;
        this.status = status;
        this.submitTime = submitTime;
        this.xz = xz;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCk() {
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getGhtime() {
        return ghtime;
    }

    public void setGhtime(String ghtime) {
        this.ghtime = ghtime;
    }

    public String getGls() {
        return gls;
    }

    public void setGls(String gls) {
        this.gls = gls;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgArry() {
        return imgArry;
    }

    public void setImgArry(String imgArry) {
        this.imgArry = imgArry;
    }

    public String getJqx() {
        return jqx;
    }

    public void setJqx(String jqx) {
        this.jqx = jqx;
    }

    public String getLiter() {
        return liter;
    }

    public void setLiter(String liter) {
        this.liter = liter;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getNj() {
        return nj;
    }

    public void setNj(String nj) {
        this.nj = nj;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getPfbz() {
        return pfbz;
    }

    public void setPfbz(String pfbz) {
        this.pfbz = pfbz;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getXz() {
        return xz;
    }

    public void setXz(String xz) {
        this.xz = xz;
    }
}
