package com.maizhong.pojo;

public class TbCarColumn {
    private Long id;

    private Long carId;

    private Integer columnId;

    private Integer carSort;

    private Integer status;

    private Integer deflag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public Integer getCarSort() {
        return carSort;
    }

    public void setCarSort(Integer carSort) {
        this.carSort = carSort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeflag() {
        return deflag;
    }

    public void setDeflag(Integer deflag) {
        this.deflag = deflag;
    }
}