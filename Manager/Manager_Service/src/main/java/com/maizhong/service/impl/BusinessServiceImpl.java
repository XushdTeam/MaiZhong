package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.mapper.TbBusinessMapper;
import com.maizhong.pojo.TbBusiness;
import com.maizhong.pojo.TbBusinessExample;
import com.maizhong.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Description:店铺管理接口实现
 * User: 王存浩
 * Date: 2017-03-06
 * Time: 11:13
 */

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private TbBusinessMapper tbBusinessMapper;


    @Override
    public TbBusiness getBusinessByid(Long id) {
        TbBusinessExample tbBusinessExample = new TbBusinessExample();
        TbBusinessExample.Criteria criteria = tbBusinessExample.createCriteria();
        criteria.andDelflagEqualTo(0);
        criteria.andIdEqualTo(id);
        List<TbBusiness> tbBusinesses = tbBusinessMapper.selectByExample(tbBusinessExample);
        if (tbBusinesses == null || tbBusinesses.size() == 0) return null;
        return tbBusinesses.get(0);
    }

    @Override
    public PageResult getBusinessList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        TbBusinessExample example = new TbBusinessExample();
        TbBusinessExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        if (param.getFiled("businessName") != null&& !Objects.equals(param.getFiled("businessName"), "")) {
            criteria.andBusinessNameLike(SqlUtils.getLikeSql(param.getFiled("businessName")));
        }
        if (param.getFiled("mobilePhone") != null&& !Objects.equals(param.getFiled("mobilePhone"), "")) {
            criteria.andMobilePhoneEqualTo(param.getFiled("mobilePhone"));
        }

        List<TbBusiness> list = tbBusinessMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo(list);

        return new PageResult(pageInfo);
    }


    @Override
    public String getBusinessListAll() {

        TbBusinessExample example = new TbBusinessExample();
        TbBusinessExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        criteria.andStatusEqualTo(1);
        List<TbBusiness> list = tbBusinessMapper.selectByExample(example);
        return JsonUtils.objectToJson(list);
    }

    @Override
    public OperateEnum insertBusiness(TbBusiness tbBusiness) {

        TbBusinessExample tbBusinessExample = new TbBusinessExample();
        TbBusinessExample.Criteria criteria = tbBusinessExample.createCriteria();
        criteria.andBusinessNameEqualTo(tbBusiness.getBusinessName());
        List<TbBusiness> tbBusinessList = tbBusinessMapper.selectByExample(tbBusinessExample);
        if (tbBusinessList.size() > 0) {
            return OperateEnum.NAME_REPEAT;
        }
        int res = tbBusinessMapper.insertSelective(tbBusiness);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public OperateEnum updateBusiness(TbBusiness tbBusiness) {
        int res = tbBusinessMapper.updateByPrimaryKeySelective(tbBusiness);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public OperateEnum deleteBusinessById(long id) {
        TbBusiness tbBusiness = new TbBusiness();
        tbBusiness.setId(id);
        tbBusiness.setDelflag(1);
        int ret = tbBusinessMapper.updateByPrimaryKeySelective(tbBusiness);
        if (ret > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public int updateBusinessLogo(String logo, long id) {
        //更新4S店铺LOGO示例图片
        TbBusiness tbBusiness = new TbBusiness();
        tbBusiness.setId(id);
        tbBusiness.setLogo(logo);
        int res = tbBusinessMapper.updateByPrimaryKeySelective(tbBusiness);
        return res;
    }
}
