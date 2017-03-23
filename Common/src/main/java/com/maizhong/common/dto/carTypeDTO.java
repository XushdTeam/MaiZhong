package com.maizhong.common.dto;

/**
 * 汽车类型DTO
 * Created by Xushd on 2017/3/23.
 */
public class CarTypeDTO {

    private Long id;

    private String typeName;

    private String typeImg;

    public CarTypeDTO(Long id, String typeName, String typeImg) {
        this.id = id;
        this.typeName = typeName;
        this.typeImg = typeImg;
    }

    public CarTypeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeImg() {
        return typeImg;
    }

    public void setTypeImg(String typeImg) {
        this.typeImg = typeImg;
    }
}
