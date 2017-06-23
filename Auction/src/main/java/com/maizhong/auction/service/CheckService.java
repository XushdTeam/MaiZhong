package com.maizhong.auction.service;

import com.maizhong.auction.pojo.*;
import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/6/14.
 */
public interface CheckService {
    JsonResult checkLogin(String account, String pass);

    JsonResult changePwd(String pass, String token);

    JsonResult feedback(String content, String token);

    JsonResult getHelp();

    JsonResult getHelpDetail(long id);


    JsonResult getNewsList();

    JsonResult getNewsDetail(long id);

    JsonResult newCarbase(String token);

    JsonResult checkCarList(String token);


    JsonResult saveXSZ(CkXsz xsz);

    JsonResult saveDJZ(CkDjz djz);

    JsonResult saveQTZ(CkQtz qtz);

    JsonResult saveCZXX(CkCzinfo czinfo);

    JsonResult getCarStep1(long carId);

    JsonResult saveCarBaseImg(CkBaseimg ckBaseimg);

    JsonResult getCarBaseImg(long carId);

    JsonResult checkCarDel(long carId);
}
