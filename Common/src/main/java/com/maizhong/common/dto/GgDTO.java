package com.maizhong.common.dto;

/**
 * 广告DTO
 * Created by Xushd on 2017/3/23.
 */
public class GgDTO {

    private Long id;

    private String ggUrl;

    private String ggImg;

    public GgDTO(Long id, String ggUrl, String ggImg) {
        this.id = id;
        this.ggUrl = ggUrl;
        this.ggImg = ggImg;
    }

    public GgDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGgUrl() {
        return ggUrl;
    }

    public void setGgUrl(String ggUrl) {
        this.ggUrl = ggUrl;
    }

    public String getGgImg() {
        return ggImg;
    }

    public void setGgImg(String ggImg) {
        this.ggImg = ggImg;
    }
}
