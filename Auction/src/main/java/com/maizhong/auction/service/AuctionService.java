package com.maizhong.auction.service;

import com.maizhong.auction.pojo.AcPickUpMan;
import com.maizhong.auction.pojo.AcUser;
import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/7/10.
 */
public interface AuctionService {
    JsonResult getDocList(int type);

    JsonResult getDocDetail(long id);

    JsonResult getTopCar();


    JsonResult getSaleBackCar(String token);

    JsonResult getPickUpMan(String token);

    JsonResult savePickUpMan(AcPickUpMan man, String token);

    JsonResult registUser(AcUser acUser, String token);

    JsonResult userLogin(long phone, String pass, String token);
}
