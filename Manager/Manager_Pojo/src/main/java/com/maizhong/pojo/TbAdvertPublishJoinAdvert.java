package com.maizhong.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-13
 * Time: 16:41
 */
public class TbAdvertPublishJoinAdvert {
    private String advertName;
    private String advertImg;
    private Integer advertType;
    private Long id;
    private Long advertId;
    private Date advertTime;
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    private Integer advertSort;

    public Long getId() {
        return id;
    }

    public String getAdvertName() {
        return advertName;
    }

    public String getAdvertImg() {
        return advertImg;
    }

    public Integer getAdvertType() {
        return advertType;
    }

    public Long getAdvertId() {
        return advertId;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getAdvertTime() {
        return advertTime;
    }

    public Integer getAdvertSort() {
        return advertSort;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }

    public void setAdvertImg(String advertImg) {
        this.advertImg = advertImg;
    }

    public void setAdvertType(Integer advertType) {
        this.advertType = advertType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
    }

    public void setAdvertTime(Date advertTime) {
        this.advertTime = advertTime;
    }

    public void setAdvertSort(Integer advertSort) {
        this.advertSort = advertSort;
    }

    public TbAdvertPublishJoinAdvert(String advertName, String advertImg, Integer advertType, Long id, Long advertId, Date advertTime, Integer advertSort) {
        this.advertName = advertName;
        this.advertImg = advertImg;
        this.advertType = advertType;
        this.id = id;
        this.advertId = advertId;
        this.advertTime = advertTime;
        this.advertSort = advertSort;
    }

    public TbAdvertPublishJoinAdvert() {
    }
}
