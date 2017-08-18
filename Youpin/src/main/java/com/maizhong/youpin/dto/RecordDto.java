package com.maizhong.youpin.dto;

import com.maizhong.youpin.pojo.SaleImg;
import com.maizhong.youpin.pojo.User;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-08-18
 * Time: 11:10
 */
public class RecordDto {
    private Long id;

    private Long modelId;

    private String regDate;

    private String cityId;

    private String sKm;

    private String color;

    private String jqx;

    private String nj;

    private String xz;

    private String gh;

    private String ghtime;

    private String method;

    private String ck;

    private String price;

    private String ordernum;

    private Integer status;

    private String createtime;

    private String updatetime;

    private String solvePerson;

    private String solveTime;

    private Integer level;

    private String mark;

    private UserDto userDto;

    private User user;

    private SaleImg saleImg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getsKm() {
        return sKm;
    }

    public void setsKm(String sKm) {
        this.sKm = sKm;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getJqx() {
        return jqx;
    }

    public void setJqx(String jqx) {
        this.jqx = jqx;
    }

    public String getNj() {
        return nj;
    }

    public void setNj(String nj) {
        this.nj = nj;
    }

    public String getXz() {
        return xz;
    }

    public void setXz(String xz) {
        this.xz = xz;
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCk() {
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getSolvePerson() {
        return solvePerson;
    }

    public void setSolvePerson(String solvePerson) {
        this.solvePerson = solvePerson;
    }

    public String getSolveTime() {
        return solveTime;
    }

    public void setSolveTime(String solveTime) {
        this.solveTime = solveTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SaleImg getSaleImg() {
        return saleImg;
    }

    public void setSaleImg(SaleImg saleImg) {
        this.saleImg = saleImg;
    }

    public RecordDto(Long id, Long modelId, String regDate, String cityId, String sKm, String color, String jqx, String nj, String xz, String gh, String ghtime, String method, String ck, String price, String ordernum, Integer status, String createtime, String updatetime, String solvePerson, String solveTime, Integer level, String mark, UserDto userDto, User user, SaleImg saleImg) {
        this.id = id;
        this.modelId = modelId;
        this.regDate = regDate;
        this.cityId = cityId;
        this.sKm = sKm;
        this.color = color;
        this.jqx = jqx;
        this.nj = nj;
        this.xz = xz;
        this.gh = gh;
        this.ghtime = ghtime;
        this.method = method;
        this.ck = ck;
        this.price = price;
        this.ordernum = ordernum;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.solvePerson = solvePerson;
        this.solveTime = solveTime;
        this.level = level;
        this.mark = mark;
        this.userDto = userDto;
        this.user = user;
        this.saleImg = saleImg;
    }

    public RecordDto() {
    }
}
