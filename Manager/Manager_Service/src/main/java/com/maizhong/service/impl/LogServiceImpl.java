package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ServiceLog;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.common.utils.TimeUtils;
import com.maizhong.mapper.TbLogMapper;
import com.maizhong.pojo.TbLog;
import com.maizhong.pojo.TbLogExample;
import com.maizhong.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.LogManager;

/**
 * 日志服务实现类
 * Created by Xushd on 2017/3/1.
 */
@Service
public class LogServiceImpl implements LogService {


    @Autowired
    private TbLogMapper tbLogMapper;


    @Override
    public void writeLog(TbLog tbLog) {
        tbLogMapper.insertSelective(tbLog);
    }

    @ServiceLog(module = "日志管理",methods = "日志列表")
    @Override
    public PageResult getLogRunList(PageSearchParam param, int type) {
        PageHelper.startPage(param.getPageIndex(),param.getPageSize());
        TbLogExample example = new TbLogExample();
        TbLogExample.Criteria criteria = example.createCriteria();
        if (param.getFiled("userName")!=null){
            criteria.andUserNameLike(SqlUtils.getLikeSql(param.getFiled("userName")));
        }
        if (param.getFiled("timeBegin")!=null){
            criteria.andLogTimeGreaterThanOrEqualTo(TimeUtils.getDate(param.getFiled("timeBegin")));
        }
        if (param.getFiled("timeEnd")!=null){
            criteria.andLogTimeLessThanOrEqualTo(TimeUtils.getDate(param.getFiled("timeEnd")));
        }
        criteria.andLogTypeEqualTo(type);
        example.setOrderByClause("id desc");
        List<TbLog> logList = tbLogMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(logList);

        return new PageResult(pageInfo);
    }


    @ServiceLog(module = "日志管理",methods = "删除7天之前日志")
    @Override
    public boolean logRunDel(int type) {
        TbLogExample example = new TbLogExample();
        TbLogExample.Criteria criteria = example.createCriteria();
        criteria.andLogTypeEqualTo(type).andLogTimeLessThan(TimeUtils.getDateBefore(7));
        int i = tbLogMapper.deleteByExample(example);
        if(i>=0)return true;
        return false;
    }

    @ServiceLog(module = "日志管理",methods = "异常日志详情")
    @Override
    public TbLog getLogById(int id) {
        return tbLogMapper.selectByPrimaryKey((long) id);
    }
}
