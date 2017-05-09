package com.maizhong.pojo;

import java.util.Date;

public class Userrecord {
    private Long id;

    private Long gzId;

    private Long userId;

    private Date gzDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGzId() {
        return gzId;
    }

    public void setGzId(Long gzId) {
        this.gzId = gzId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getGzDate() {
        return gzDate;
    }

    public void setGzDate(Date gzDate) {
        this.gzDate = gzDate;
    }
}