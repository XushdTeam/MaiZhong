package com.maizhong.service.impl;

import com.maizhong.mapper.TbLogMapper;
import com.maizhong.pojo.TbLog;
import com.maizhong.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
