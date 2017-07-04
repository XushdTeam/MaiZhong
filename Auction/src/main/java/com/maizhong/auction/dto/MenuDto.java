package com.maizhong.auction.dto;

import java.util.List;

/**
 * Created by Xushd on 2017/7/3.
 */
public class MenuDto {

    private String icon;
    private String url;
    private String name;
    private List<MenuDto> subs;

    public MenuDto() {
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuDto> getSubs() {
        return subs;
    }

    public void setSubs(List<MenuDto> subs) {
        this.subs = subs;
    }
}
