package com.maizhong.youpin.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.youpin.pojo.ManagerUser;
import com.maizhong.youpin.pojo.SaleRecord;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-08-17
 * Time: 11:27
 */
public interface ManageService {

    JsonResult loginCheck(String account, String password, boolean checked);

    JsonResult checkLoginStatus(String token);

    String getSystemMenu(String token);

    JsonResult getSysAccountList(PageSearchParam param);

    JsonResult logOff(String token);

    JsonResult saveSysAccount(ManagerUser user, String token);

    JsonResult statusSysAccount(long id, int status);

    JsonResult delSysAccount(long id);

    JsonResult delUser(long id);

    JsonResult getUserListAll();

    JsonResult  getUserList(PageSearchParam param);


    /*-订单信息---*/
    JsonResult getRecordList(PageSearchParam param);
    JsonResult saveRecord(SaleRecord saleRecord, String token);

    JsonResult statusRecord(long id, int status);

    JsonResult delRecord(long id);


}
