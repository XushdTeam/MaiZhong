package com.maizhong.common.dto;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 通用分页查询 dto 用户controller接受 请求参数
 * Created by Xushd on 2017/3/2.
 */
public class PageSearchParam {


    private int pageIndex;

    private int pageSize;

    private Map<String,String> searchFileds;

    public int getPageIndex() {
        if(pageIndex==0)pageIndex=1;return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        if (pageSize==0)pageSize=10;
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, String> getSearchFileds() {
        return searchFileds;
    }

    public void setSearchFileds(Map<String, String> searchFileds) {
        this.searchFileds = searchFileds;
    }

    public String getFiled(String key){
        if (this.searchFileds==null)return null;
        if (StringUtils.isEmpty(searchFileds.get(key)))return null;
        return searchFileds.get(key);
    }


    @Override
    public String toString() {
        return "PageSearchParam{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", searchFileds=" + searchFileds +
                '}';
    }
}
