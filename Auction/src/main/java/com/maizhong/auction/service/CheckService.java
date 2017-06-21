package com.maizhong.auction.service;

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
}
