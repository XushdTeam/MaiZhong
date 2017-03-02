package com.maizhong.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.TbLog;

/**
 * 日志服务接口
 * Created by Xushd on 2017/3/1.
 */
public interface LogService {

    void writeLog(TbLog tbLog);

    PageResult getLogRunList(PageSearchParam param, int type);

    boolean logRunDel(int type);

    TbLog getLogById(int id);
}
