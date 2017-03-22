package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.TimeUtils;
import com.maizhong.mapper.TbConsultMapper;
import com.maizhong.pojo.TbConsult;
import com.maizhong.pojo.TbConsultExample;
import com.maizhong.pojo.TbMember;
import com.maizhong.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-21
 * Time: 15:12
 */


@Service
public class ConsultServiceImpl implements ConsultService {

    @Autowired
    private TbConsultMapper tbConsultMapper;

    /**
     * 用户咨询列表--分页 条件查询
     *
     * @param param
     * @return
     */
    @Override
    public PageResult getConsultList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        TbConsultExample example = new TbConsultExample();
        TbConsultExample.Criteria criteria = example.createCriteria();
        if (param.getFiled("phone") != null) {
            criteria.andPhoneEqualTo(param.getFiled("phone"));
        }
        if (param.getFiled("type") != null) {
            criteria.andTypeEqualTo(Integer.valueOf(param.getFiled("type")));
        }
        if (param.getFiled("status") != null) {
            criteria.andStatusEqualTo(Integer.valueOf(param.getFiled("status")));
        }
        if (param.getFiled("timeBegin") != null) {
            criteria.andConsultTimeGreaterThan(TimeUtils.getDate(param.getFiled("timeBegin")));
        }
        if (param.getFiled("timeEnd") != null) {
            criteria.andConsultTimeLessThan(TimeUtils.getDate(param.getFiled("timeEnd")));
        }
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("id ASC");
        List<TbConsult> list = tbConsultMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        return new PageResult(pageInfo);
    }


    @Override
    public TbConsult getConsultById(Long id) {
        TbConsult tbConsult=tbConsultMapper.selectByPrimaryKey(id);
        return  tbConsult;
    }

    @Override
    public OperateEnum updatConsult(TbConsult tbConsult) {
        int res = tbConsultMapper.updateByPrimaryKeySelective(tbConsult);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }
}
