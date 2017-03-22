package com.maizhong.pojo.vo;

import com.maizhong.pojo.TbCarBrand;
import com.maizhong.pojo.TbCarBrandLine;
import com.maizhong.pojo.TbCarType;
import com.maizhong.pojo.TbDictionary;

import java.util.List;
import java.util.Map;

/**
 * Created by YangF on 2017/3/20.
 */
public class SearchResult {

    private List<TbCarVo> rows;
    private Integer total;
    private Integer pageNum;
    private Integer pageSize;
    private Integer currentPage;


    private List<TbCarBrand> tbCarBrands;
    private List<TbCarType> tbCarTypes;
    private List<TbDictionary> colors;
    private List<TbDictionary> geadboxs;
    private List<TbCarBrandLine> tbCarBrandLines;
    private Map<String,String> conditions;
    private String queryString;
    private String sortString;

    public String getSortString() {
        return sortString;
    }

    public void setSortString(String sortString) {
        this.sortString = sortString;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }
    public Map<String, String> getConditions() {
        return conditions;
    }

    public void setConditions(Map<String, String> conditions) {
        this.conditions = conditions;
    }
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<TbCarVo> getRows() {
        return rows;
    }

    public void setRows(List<TbCarVo> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    public List<TbCarBrand> getTbCarBrands() {
        return tbCarBrands;
    }

    public void setTbCarBrands(List<TbCarBrand> tbCarBrands) {
        this.tbCarBrands = tbCarBrands;
    }

    public List<TbCarType> getTbCarTypes() {
        return tbCarTypes;
    }

    public void setTbCarTypes(List<TbCarType> tbCarTypes) {
        this.tbCarTypes = tbCarTypes;
    }

    public List<TbDictionary> getColors() {
        return colors;
    }

    public void setColors(List<TbDictionary> colors) {
        this.colors = colors;
    }

    public List<TbDictionary> getGeadboxs() {
        return geadboxs;
    }

    public void setGeadboxs(List<TbDictionary> geadboxs) {
        this.geadboxs = geadboxs;
    }

    public List<TbCarBrandLine> getTbCarBrandLines() {
        return tbCarBrandLines;
    }

    public void setTbCarBrandLines(List<TbCarBrandLine> tbCarBrandLines) {
        this.tbCarBrandLines = tbCarBrandLines;
    }
}
