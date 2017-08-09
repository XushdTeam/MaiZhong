package com.maizhong.auction.service;

import com.maizhong.auction.pojo.*;
import com.maizhong.common.result.JsonResult;

import java.util.List;

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

    JsonResult newCarbase(String token, long ordernum);

    JsonResult checkCarList(String token);


    JsonResult saveXSZ(CkXsz xsz);

    JsonResult saveDJZ(CkDjz djz);

    JsonResult saveQTZ(CkQtz qtz);

    JsonResult saveCZXX(CkCzinfo czinfo);

    JsonResult getCarStep1(long carId);

    JsonResult saveCarBaseImg(CkBaseimg ckBaseimg);

    JsonResult getCarBaseImg(long carId);

    JsonResult checkCarDel(long carId);

    JsonResult savePZ(CkPz ckPz);

    JsonResult saveDL(CkDl ckDl);

    JsonResult getCarStep4(long carId);

    JsonResult saveWgqx(List<CkCkwgqx> list, long carId);

    JsonResult saveNsqx(List<CkCknsqx> list, long carId);

    JsonResult saveSg(List<CkCksg> list, long carId);

    JsonResult savePs(List<CkCkps> list, long carId);

    JsonResult saveHs(List<CkCkhs> list, long carId);

    JsonResult getCarStep3(long carId);

    JsonResult checkCarVerify(CkVerify verify);

    JsonResult checkCarOther(CkOther other);

    JsonResult checkCarModel(CkCarmodel carmodel);

    JsonResult getCarStep5(long carId);

    JsonResult checkCarExamine(long carId);

    JsonResult getRejectReason(long id);

    JsonResult getMyTask(String token);

    JsonResult checkUpdateSavePrice(long carId, String price, String token);
}
