package com.maizhong.pojo;

import java.util.Date;

public class TbAdvertPublish {
    private Long id;

    private Long advertId;

    private Date advertTime;

    private Integer advertSort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
    }

    public Date getAdvertTime() {
        return advertTime;
    }

    public void setAdvertTime(Date advertTime) {
        this.advertTime = advertTime;
    }

    public Integer getAdvertSort() {
        return advertSort;
    }

    public void setAdvertSort(Integer advertSort) {
        this.advertSort = advertSort;
    }
}