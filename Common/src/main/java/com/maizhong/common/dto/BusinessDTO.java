package com.maizhong.common.dto;

import java.util.Date;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-21
 * Time: 10:24
 */
public class BusinessDTO {

    private Long id;

    private String businessName;

    private String address;

    private Long districtId;

    private String location;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
