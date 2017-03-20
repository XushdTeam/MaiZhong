package com.maizhong.common.dto;

import java.util.List;

/**
 * Description:首页汽车显示--分栏目
 * User: 王存浩
 * Date: 2017-03-17
 * Time: 16:32
 */
public class CarShowIndex {
    private Long id;
    private String name;
    private List<CarIndexDetail> arry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CarIndexDetail> getArry() {
        return arry;
    }

    public void setArry(List<CarIndexDetail> arry) {
        this.arry = arry;
    }


    public CarShowIndex() {
    }

    public CarShowIndex(String name, List<CarIndexDetail> arry, Long id) {
        this.name = name;
        this.arry = arry;
        this.id = id;
    }

    public CarShowIndex(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
