package com.maizhong.auction.service;

import com.maizhong.auction.pojo.CkUser;
import com.maizhong.auction.pojo.SysCompany;
import com.maizhong.auction.pojo.SysUser;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;

/**
 * Created by Xushd on 2017/7/4.
 */
public interface SystemService {
    JsonResult getSysAccountList(PageSearchParam param);

    JsonResult saveSysAccount(SysUser user, String token);

    JsonResult statusSysAccount(long id, int status);

    JsonResult delSysAccount(long id);

    JsonResult getCheckAccountList(PageSearchParam param);

    JsonResult getCompanyListAll();

    JsonResult saveCheckAccount(CkUser user, String token);

    JsonResult statusCheckAccount(long id, int status);

    JsonResult delSCheckAccount(long id);

    JsonResult getCompanyList(PageSearchParam param);

    JsonResult saveCompany(SysCompany user, String token);

    JsonResult statusCompany(long id, int status);

    JsonResult delCompany(long id);

    JsonResult getExamineCarList(PageSearchParam param);

    JsonResult examinePass(long id, String token);

    JsonResult examineReject(long id, String reason, String token);

    JsonResult getWaitCarList(PageSearchParam param);

    JsonResult selectChannel();

    JsonResult selectChannelQueueByKey(String key);

    JsonResult channelAdd(String carIds, int time, String ch);

    JsonResult setCarStartPrice(long carId, String price);

    JsonResult getChannelOverList(PageSearchParam param);

    JsonResult carDeal(long carId,long auctionId);

    JsonResult carSecond(long carId,long auctionId);

    JsonResult getCompanyUserList(PageSearchParam param);

    JsonResult changeStatusUser(long id, int status, String token);

    JsonResult companyUserDel(long id, String token);

    JsonResult companyBzjAdd(long id, long plus, String token);

    JsonResult auctionCarList();

    JsonResult setCarSavePrice(long carId, String price);
}
