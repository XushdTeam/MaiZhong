package com.maizhong.common.dto;

/**
 * Description:首页汽车显示的信息
 * User: 王存浩
 * Date: 2017-03-17
 * Time: 16:33
 */
public class CarIndexDetail {
    private Long id;
    private String name;
    private String price;
    private String img;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public CarIndexDetail() {
    }

    public CarIndexDetail(Long id, String name, String price, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
    }
}
