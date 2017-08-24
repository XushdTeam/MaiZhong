package com.maizhong.youpin.dto;

/**
 * Created by Xushd on 2017/8/17.
 */
public class CompanyDto {

    private long id;
    private String name;
    private String area;
    private String brand;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public CompanyDto() {
    }

    public CompanyDto(long id, String name, String area, String brand) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.brand = brand;
    }
}
