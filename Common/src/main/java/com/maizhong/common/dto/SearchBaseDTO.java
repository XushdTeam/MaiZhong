package com.maizhong.common.dto;

import java.util.List;

/**
 * 查询基本数据DTO
 * Created by Xushd on 2017/3/23.
 */
public class SearchBaseDTO {

    private List<CarBrandDTO> carBrandDTOs;

    public SearchBaseDTO(List<CarBrandDTO> carBrandDTOs) {
        this.carBrandDTOs = carBrandDTOs;
    }

    public SearchBaseDTO() {
    }

    public List<CarBrandDTO> getCarBrandDTOs() {
        return carBrandDTOs;
    }

    public void setCarBrandDTOs(List<CarBrandDTO> carBrandDTOs) {
        this.carBrandDTOs = carBrandDTOs;
    }
}
