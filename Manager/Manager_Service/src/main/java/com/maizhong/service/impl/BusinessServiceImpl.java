package com.maizhong.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.DistrictMapper;
import com.maizhong.mapper.TbBusinessMapper;
import com.maizhong.pojo.District;
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
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    JedisClient jedisClient;

    /**
     * 根据id获取店铺对象
     *
     * @param id
     * @return
     */
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

    /**
     * 获取店铺列表
     *
     * @param param
     * @return
     */
    @Override
    public PageResult getBusinessList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        TbBusinessExample example = new TbBusinessExample();
        TbBusinessExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        if (param.getFiled("businessName") != null && !Objects.equals(param.getFiled("businessName"), "")) {
            criteria.andBusinessNameLike(SqlUtils.getLikeSql(param.getFiled("businessName")));
        }
        if (param.getFiled("mobilePhone") != null && !Objects.equals(param.getFiled("mobilePhone"), "")) {
            criteria.andMobilePhoneEqualTo(param.getFiled("mobilePhone"));
        }

        List<TbBusiness> list = tbBusinessMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo(list);

        return new PageResult(pageInfo);
    }

    /**
     * 获取所有上线店铺
     *
     * @return
     */
    @Override
    public List<TbBusiness> getBusinessListAll() {

        TbBusinessExample example = new TbBusinessExample();
        TbBusinessExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        criteria.andStatusEqualTo(1);
        List<TbBusiness> list = tbBusinessMapper.selectByExample(example);
        return list;
    }

    /**
     * 店铺添加
     *
     * @param tbBusiness
     * @return
     */
    @Override
    public OperateEnum insertBusiness(TbBusiness tbBusiness) {

        TbBusinessExample tbBusinessExample = new TbBusinessExample();
        TbBusinessExample.Criteria criteria = tbBusinessExample.createCriteria();
        criteria.andBusinessNameEqualTo(tbBusiness.getBusinessName());
        criteria.andDelflagEqualTo(0);
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

    /**
     * 店铺更新
     *
     * @param tbBusiness
     * @return
     */
    @Override
    public OperateEnum updateBusiness(TbBusiness tbBusiness) {
        int res = tbBusinessMapper.updateByPrimaryKeySelective(tbBusiness);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    /**
     * 店铺删除
     *
     * @param id
     * @return
     */
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

    /**
     * 更新4S店logo
     *
     * @param logo
     * @param id
     * @return
     */
    @Override
    public int updateBusinessLogo(String logo, long id) {
        //更新4S店铺LOGO示例图片
        TbBusiness tbBusiness = new TbBusiness();
        tbBusiness.setId(id);
        tbBusiness.setLogo(logo);
        int res = tbBusinessMapper.updateByPrimaryKeySelective(tbBusiness);
        return res;
    }

    /**
     * 北京所有区县
     * @return
     */

    @Override
    public List<District> getDistrict() {
        List<District> list = districtMapper.selectByExample(null);
        return list;
    }

    /**
     * 店铺更新缓存
     * @return
     */
    @Override
    public OperateEnum updateHelpRedis() {
        try {
            jedisClient.del("BUSINESS_ADDRESS");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long totalNumber = tbBusinessMapper.countByExample(null);
        List<District> districts = districtMapper.selectByExample(null);//区县 16
        TbBusinessExample example = new TbBusinessExample();
        JSONArray array = new JSONArray();
        for (District district : districts) {//遍历北京16个区县
            JSONObject object = new JSONObject();
            object.put("district", district.getName());
            object.put("id", district.getId());
            object.put("totalNumber", totalNumber);
            example.clear();
            TbBusinessExample.Criteria criteria = example.createCriteria();
            criteria.andDistrictIdEqualTo(Long.valueOf(district.getId()));
            criteria.andDelflagEqualTo(0);
            List<TbBusiness> tbBusinesses = tbBusinessMapper.selectByExample(example);
            if (tbBusinesses == null || tbBusinesses.size() == 0) {
                continue;//如果区县下没有合作4S店，则跳过
            }else {
                object.put("count", tbBusinesses.size());
            }
            JSONArray array1 = new JSONArray();
            for (TbBusiness tbBusiness : tbBusinesses) {
                JSONObject object1 = new JSONObject();//添加4S店信息
                object1.put("address", tbBusiness.getAddress());
                object1.put("name", tbBusiness.getBusinessName());
                object1.put("id", tbBusiness.getId());
                object1.put("location", tbBusiness.getLocation());
                object1.put("districtId", tbBusiness.getDistrictId());
                object1.put("img",tbBusiness.getLogo());
                array1.add(object1);
            }
            object.put("shop", array1);
            array.add(object);
        }
        jedisClient.set("BUSINESS_ADDRESS", JsonUtils.objectToJson(array));

        return OperateEnum.SUCCESS;
    }
}
