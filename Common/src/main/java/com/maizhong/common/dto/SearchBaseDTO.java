package com.maizhong.common.dto;

import java.util.List;
import java.util.Map;

/**
 * 查询基本数据DTO
 * Created by Xushd on 2017/3/23.
 */
public class SearchBaseDTO {

    private List<CarBrandDTO> carBrandhot;

    private Map<String,List<KeyValue>> carBrandAll;

    private List<KeyValue> carSeriesList;

    public List<CarBrandDTO> getCarBrandhot() {
        return carBrandhot;
    }

    public void setCarBrandhot(List<CarBrandDTO> carBrandhot) {
        this.carBrandhot = carBrandhot;
    }

    public Map<String, List<KeyValue>> getCarBrandAll() {
        return carBrandAll;
    }

    public void setCarBrandAll(Map<String, List<KeyValue>> carBrandAll) {
        this.carBrandAll = carBrandAll;
    }

    public List<KeyValue> getCarSeriesList() {
        return carSeriesList;
    }

    public void setCarSeriesList(List<KeyValue> carSeriesList) {
        this.carSeriesList = carSeriesList;
    }
}
