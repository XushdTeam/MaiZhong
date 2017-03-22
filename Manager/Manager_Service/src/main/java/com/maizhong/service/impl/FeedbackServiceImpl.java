package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ServiceLog;
import com.maizhong.common.utils.TimeUtils;
import com.maizhong.mapper.TbFeedbackMapper;
import com.maizhong.pojo.TbFeedback;
import com.maizhong.pojo.TbFeedbackExample;
import com.maizhong.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:客服反馈服务实现
 * User: 王存浩
 * Date: 2017-03-20
 * Time: 14:26
 */

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private TbFeedbackMapper tbFeedbackMapper;


    /**
     * 用户反馈列表
     * @param param
     * @return
     */

    @ServiceLog(module = "用户反馈", methods = "反馈列表")
    @Override
    public PageResult getFeedBackList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        TbFeedbackExample example = new TbFeedbackExample();
        TbFeedbackExample.Criteria criteria = example.createCriteria();
        if (param.getFiled("phone") != null) {
            criteria.andPhoneEqualTo(param.getFiled("phone"));
        }
        if (param.getFiled("timeBegin") != null) {
            criteria.andCreateTimeGreaterThan(TimeUtils.getDate(param.getFiled("timeBegin")));
        }
        if (param.getFiled("timeEnd") != null) {
            criteria.andCreateTimeLessThan(TimeUtils.getDate(param.getFiled("timeEnd")));
        }
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("create_time DESC");
        List<TbFeedback> list = tbFeedbackMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        return new PageResult(pageInfo);
    }
    }

