package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ServiceLog;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.common.utils.TimeUtils;
import com.maizhong.mapper.TbMemberMapper;
import com.maizhong.pojo.TbMember;
import com.maizhong.pojo.TbMemberExample;
import com.maizhong.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-15
 * Time: 10:18
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private TbMemberMapper tbMemberMapper;

    /**
     * 获取会员列表
     *
     * @param param
     * @return
     */
    @ServiceLog(module = "会员管理", methods = "会员列表")
    @Override
    public PageResult getMemberList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        TbMemberExample example = new TbMemberExample();
        TbMemberExample.Criteria criteria = example.createCriteria();
        if (param.getFiled("memberName") != null) {
            criteria.andMemberNameLike(SqlUtils.getLikeSql(param.getFiled("memberName")));
        }
        if (param.getFiled("mobile") != null) {
            criteria.andMobileLike(param.getFiled("mobile"));
        }
        if (param.getFiled("timeBegin") != null) {
            criteria.andRegisterTimeGreaterThan(TimeUtils.getDate(param.getFiled("timeBegin")));
        }
        if (param.getFiled("timeEnd") != null) {
            criteria.andRegisterTimeLessThan(TimeUtils.getDate(param.getFiled("timeEnd")));
        }
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("id ASC");
        List<TbMember> list = tbMemberMapper.selectByExample(example);
        for (TbMember tbMember : list) {
            tbMember.setPassword(null);
        }
        PageInfo pageInfo = new PageInfo(list);

        return new PageResult(pageInfo);
    }
}

