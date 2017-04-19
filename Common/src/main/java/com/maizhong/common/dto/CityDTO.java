package com.maizhong.common.dto;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-18
 * Time: 20:30
 */
public class CityDTO {
    private Integer id;
    private String name;
    private Integer prov;


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

    public Integer getProv() {
        return prov;
    }

    public void setProv(Integer prov) {
        this.prov = prov;
    }

    public CityDTO() {
    }

    public CityDTO(Integer id, String name, Integer prov) {
        this.id = id;
        this.name = name;
        this.prov = prov;
    }
}
