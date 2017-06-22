package com.maizhong.auction.service;

import com.maizhong.auction.pojo.CkCzinfo;
import com.maizhong.auction.pojo.CkDjz;
import com.maizhong.auction.pojo.CkQtz;
import com.maizhong.auction.pojo.CkXsz;
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
}
