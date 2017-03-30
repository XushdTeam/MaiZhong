package com.maizhong.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class TbMember {
    /*附加字段*/
    @NotBlank(message = "验证码为空")
    private String verifyCode;

    //附加字段
    private List<String> roleName;


    private Long id;

    @NotBlank(message = "账号为空")
    private String mobile;

    private String memberName;

    private Integer sex;

    @NotBlank(message = "密码为空")
    private String password;

    private String telephone;

    private String email;

    private String idcard;

    private Integer regionProvinceId;

    private Integer regionCityId;

    private Integer regionCountryId;

    private String address;

    private Date registerTime;

    private Integer status;

    private Integer delflag;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public List<String> getRoleName() {
        return roleName;
    }

    public void setRoleName(List<String> roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public Integer getRegionProvinceId() {
        return regionProvinceId;
    }

    public void setRegionProvinceId(Integer regionProvinceId) {
        this.regionProvinceId = regionProvinceId;
    }

    public Integer getRegionCityId() {
        return regionCityId;
    }

    public void setRegionCityId(Integer regionCityId) {
        this.regionCityId = regionCityId;
    }

    public Integer getRegionCountryId() {
        return regionCountryId;
    }

    public void setRegionCountryId(Integer regionCountryId) {
        this.regionCountryId = regionCountryId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
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