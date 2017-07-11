package com.maizhong.auction.dto;

/**
 * Created by Xushd on 2017/6/28.
 */
public class DataHistoryDTO {
    private String carStr;
    private String history;

    public DataHistoryDTO(String carStr, String history) {
        this.carStr = carStr;
        this.history = history;
    }

    public DataHistoryDTO() {
    }

    public String getCarStr() {
        return carStr;
    }

    public void setCarStr(String carStr) {
        this.carStr = carStr;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
