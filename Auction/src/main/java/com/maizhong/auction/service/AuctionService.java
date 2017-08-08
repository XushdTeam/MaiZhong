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

    JsonResult userHeadImg(String url, String token);

    JsonResult userCertification(String name, String idNum, String pic1, String pic2, String pic3, String token);

    JsonResult getVerifyCode(String phone, String token);

    boolean checkVerifyCode(String verifyCode, String token);

    JsonResult userChangeCity(String city, String token);

    JsonResult syncUserInfo(String token);

    JsonResult getNowAuctionList(String token);

    JsonResult getCarDetail(long carId);

    JsonResult addPrice(String ch, long carId, String plus, String price, String token);

    JsonResult getBidRecord(long auctionId, String token);

    JsonResult getCarDealList(String token);

    JsonResult getCarPlusList(String token);

    JsonResult getCarNow(long carId, String chKey, String token);

    JsonResult userLogout(String token);

    JsonResult carLike(long carId, String token);

    JsonResult carLikeCancle(long carId, String token);

    JsonResult carLikeList(String token);

    JsonResult autoPrice(long carId, long price, String token);

}
