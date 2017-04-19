package com.maizhong.common.dto;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-18
 * Time: 20:29
 */
public class ProvinceDTO{
    private  Integer id;
    private  String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProvinceDTO() {
    }

    public ProvinceDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
