package com.maizhong.common.dto;

import java.util.List;

/**
 * Created by Xushd on 2017/1/23.
 */
public class MenuNode {

    private String title;

    private String icon;

    private String href;

    private boolean spread;

    private List<MenuNode> children;


    public MenuNode() {
    }

    public MenuNode(String title, String icon, boolean spread, List<MenuNode> children) {
        this.title = title;
        this.icon = icon;
        this.spread = spread;
        this.children = children;
    }

    public MenuNode(String title, String icon, String href) {
        this.title = title;
        this.icon = icon;
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public List<MenuNode> getChildren() {
        return children;
    }

    public void setChildren(List<MenuNode> children) {
        this.children = children;
    }
}
