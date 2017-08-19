package com.maizhong.youpin.dto;

import com.maizhong.youpin.pojo.Model;
import com.maizhong.youpin.pojo.SaleImg;
import com.maizhong.youpin.pojo.SaleRecord;
import com.maizhong.youpin.pojo.User;

import java.util.List;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-08-18
 * Time: 11:10
 */
public class RecordDto {

    private UserDto userDto;

    private User user;

    private List<SaleImg> saleImgList;

   private SaleRecord saleRecord;

   private Model model;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SaleImg> getSaleImgList() {
        return saleImgList;
    }

    public void setSaleImgList(List<SaleImg> saleImgList) {
        this.saleImgList = saleImgList;
    }

    public SaleRecord getSaleRecord() {
        return saleRecord;
    }

    public void setSaleRecord(SaleRecord saleRecord) {
        this.saleRecord = saleRecord;
    }

    public RecordDto() {
    }
}
