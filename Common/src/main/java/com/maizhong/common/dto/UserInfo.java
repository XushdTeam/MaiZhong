package com.maizhong.common.dto;

/**
 * Created by YangF on 2017/3/29.
 */
public class UserInfo {

    private String businessName;
    private String businessId;
    private String businessLogo;
    private String businessAdress;
    private String userName;
    private String userId;
    private String userAdvert;
    private String userPhone;
    private String userEmail;


    public UserInfo() {
    }

    public UserInfo(String businessName, String businessId, String businessLogo, String businessAdress, String userName, String userId, String userAdvert, String userPhone, String userEmail) {
        this.businessName = businessName;
        this.businessId = businessId;
        this.businessLogo = businessLogo;
        this.businessAdress = businessAdress;
        this.userName = userName;
        this.userId = userId;
        this.userAdvert = userAdvert;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessLogo() {
        return businessLogo;
    }

    public void setBusinessLogo(String businessLogo) {
        this.businessLogo = businessLogo;
    }

    public String getBusinessAdress() {
        return businessAdress;
    }

    public void setBusinessAdress(String businessAdress) {
        this.businessAdress = businessAdress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAdvert() {
        return userAdvert;
    }

    public void setUserAdvert(String userAdvert) {
        this.userAdvert = userAdvert;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
