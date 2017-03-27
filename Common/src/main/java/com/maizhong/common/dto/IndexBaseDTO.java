package com.maizhong.common.dto;

import java.util.List;

/**
 * 首页初次数据DTO
 * Created by Xushd on 2017/3/23.
 */
public class IndexBaseDTO {

    private List<CarBrandDTO> carBrand;

    private List<GgDTO> ggDTOs;

    private List<carTypeDTO> carType;

    public IndexBaseDTO() {
    }


    public List<CarBrandDTO> getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(List<CarBrandDTO> carBrand) {
        this.carBrand = carBrand;
    }

    public List<GgDTO> getGgDTOs() {
        return ggDTOs;
    }

    public void setGgDTOs(List<GgDTO> ggDTOs) {
        this.ggDTOs = ggDTOs;
    }

    public List<carTypeDTO> getCarType() {
        return carType;
    }

    public void setCarType(List<carTypeDTO> carType) {
        this.carType = carType;
    }

    public IndexBaseDTO(List<CarBrandDTO> carBrand, List<GgDTO> ggDTOs, List<carTypeDTO> carType) {
        this.carBrand = carBrand;
        this.ggDTOs = ggDTOs;
        this.carType = carType;
    }
}
