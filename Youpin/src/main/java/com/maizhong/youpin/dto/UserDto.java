package com.maizhong.youpin.dto;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-08-18
 * Time: 9:45
 */
public class UserDto {
    private Long id;
    private String company;
    private String name;
    private String phone;
    private String level;
    private String job;
    private String type;
    private Integer status;
    private String registtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRegisttime() {
        return registtime;
    }

    public void setRegisttime(String registtime) {
        this.registtime = registtime;
    }

    public UserDto() {
    }

    public UserDto(Long id, String company, String name, String phone, String level, String job, String type, Integer status, String registtime) {
        this.id = id;
        this.company = company;
        this.name = name;
        this.phone = phone;
        this.level = level;
        this.job = job;
        this.type = type;
        this.status = status;
        this.registtime = registtime;
    }
}


