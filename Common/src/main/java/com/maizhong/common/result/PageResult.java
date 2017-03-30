package com.maizhong.common.result;


import com.alibaba.fastjson.annotation.JSONField;
import com.github.pagehelper.PageInfo;

/**
 * 分页查询返回结果
 * Created by Xushd on 2017/3/2.
 */
public class PageResult {

    //总条数
    private int total;
    //总页数
    private int pages;
    //当前页
    private int pageNum;
    //rows 数据
    @JSONField(name = "rows")
    private Object data;


    public PageResult(int total, Object data, int pageNum, int pages) {
        this.total = total;
        this.data = data;
        this.pageNum = pageNum;
        this.pages = pages;
    }

    public PageResult(PageInfo pageInfo) {
        this.total = (int) pageInfo.getTotal();
        this.data = pageInfo.getList();
        this.pageNum = pageInfo.getPageNum();
        this.pages = pageInfo.getPages();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
