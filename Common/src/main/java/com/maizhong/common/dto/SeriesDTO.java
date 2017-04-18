package com.maizhong.common.dto;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-18
 * Time: 19:46
 */
public class SeriesDTO {
    private Integer series_id;
    private String series_name;
    private String series_group_name;

    public Integer getSeries_id() {
        return series_id;
    }

    public void setSeries_id(Integer series_id) {
        this.series_id = series_id;
    }

    public String getSeries_name() {
        return series_name;
    }

    public void setSeries_name(String series_name) {
        this.series_name = series_name;
    }

    public String getSeries_group_name() {
        return series_group_name;
    }

    public void setSeries_group_name(String series_group_name) {
        this.series_group_name = series_group_name;
    }

    public SeriesDTO() {
    }

    public SeriesDTO(Integer series_id, String series_name, String series_group_name) {
        this.series_id = series_id;
        this.series_name = series_name;
        this.series_group_name = series_group_name;
    }
}
