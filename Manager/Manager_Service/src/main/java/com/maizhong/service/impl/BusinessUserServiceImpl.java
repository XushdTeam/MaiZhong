package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.mapper.TbBusinessMapper;
import com.maizhong.mapper.TbBusinessUserMapper;
import com.maizhong.pojo.TbBusiness;
import com.maizhong.pojo.TbBusinessExample;
import com.maizhong.pojo.TbBusinessUser;
import com.maizhong.pojo.TbBusinessUserExample;
import com.maizhong.service.BusinessService;
import com.maizhong.service.BusinessUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Description:店铺管理员管理接口实现
 * User: 王存浩
 * Date: 2017-03-06
 * Time: 11:13
 */

@Service
public class BusinessUserServiceImpl implements BusinessUserService {

    @Autowired
    private TbBusinessUserMapper tbBusinessUserMapper;
    @Autowired
    private BusinessService businessService;

    /**
     * 根据ID获取4S店管理员对象
     *
     * @param id
     * @return
     */
    @Override
    public TbBusinessUser getBusinessUserByid(Long id) {
        TbBusinessUserExample tbBusinessUserExample = new TbBusinessUserExample();
        TbBusinessUserExample.Criteria criteria = tbBusinessUserExample.createCriteria();
        criteria.andDeflagEqualTo(0);
        criteria.andIdEqualTo(id);
        List<TbBusinessUser> tbBusinessUsers = tbBusinessUserMapper.selectByExample(tbBusinessUserExample);
        if (tbBusinessUsers == null || tbBusinessUsers.size() == 0) return null;
        return tbBusinessUsers.get(0);
    }

    @Override
    public PageResult getBusinessUserList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        TbBusinessUserExample example = new TbBusinessUserExample();
        TbBusinessUserExample.Criteria criteria = example.createCriteria();
        criteria.andDeflagEqualTo(0);
        if (param.getFiled("userName") != null && !Objects.equals(param.getFiled("userName"), "")) {
            criteria.andUserNameLike(SqlUtils.getLikeSql(param.getFiled("userName")));
        }
      /*  if (param.getFiled("business_id") != null && !Objects.equals(param.getFiled("business_id"), "")) {
            criteria.andBusinessIdEqualTo(Long.valueOf(param.getFiled("business_id")));
        }
*/
        List<TbBusinessUser> list = tbBusinessUserMapper.selectByExample(example);

        for (TbBusinessUser user : list) {
            TbBusiness tbBusiness = businessService.getBusinessByid(user.getBusinessId());
            if (tbBusiness != null && tbBusiness.getId() != null) {
                user.setBusinessName(tbBusiness.getBusinessName());
            }
        }
        PageInfo pageInfo = new PageInfo(list);

        return new PageResult(pageInfo);
    }


    @Override
    public String getBusinessUserListAll() {
        TbBusinessUserExample example = new TbBusinessUserExample();
        TbBusinessUserExample.Criteria criteria = example.createCriteria();
        criteria.andDeflagEqualTo(0);
        criteria.andStatusEqualTo(1);
        List<TbBusinessUser> list = tbBusinessUserMapper.selectByExample(example);
        return JsonUtils.objectToJson(list);
    }

    @Override
    public OperateEnum insertBusinessUser(TbBusinessUser tbBusinessUser) {
        int res = tbBusinessUserMapper.insertSelective(tbBusinessUser);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public OperateEnum updateBusinessUser(TbBusinessUser tbBusinessUser) {
        int res = tbBusinessUserMapper.updateByPrimaryKeySelective(tbBusinessUser);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public OperateEnum deleteBusinessUserById(long id) {
        TbBusinessUser tbBusinessUser = new TbBusinessUser();
        tbBusinessUser.setId(id);
        tbBusinessUser.setDeflag(1);
        int ret = tbBusinessUserMapper.updateByPrimaryKeySelective(tbBusinessUser);
        if (ret > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }
}
