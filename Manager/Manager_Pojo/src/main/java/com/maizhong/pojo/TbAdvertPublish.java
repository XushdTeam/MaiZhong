package com.maizhong.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

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



    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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