package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.KeyValue;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.DicParentEnum;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.DicRedisUtils;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.TbAdvertMapper;
import com.maizhong.mapper.TbAdvertPublishMapper;
import com.maizhong.pojo.TbAdvert;
import com.maizhong.pojo.TbAdvertExample;
import com.maizhong.pojo.TbAdvertPublish;
import com.maizhong.pojo.TbAdvertPublishExample;
import com.maizhong.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:广告信息接口实现
 * User: 王存浩
 * Date: 2017-03-08
 * Time: 13:26
 */

@Service
public class AdvertServiceImpl implements AdvertService {

    @Autowired
    private JedisClient jedisClient;


    @Value("${DIC_KEY}")
    private String DIC_KEY;


    @Autowired
    TbAdvertMapper tbAdvertMapper;

    @Autowired
    TbAdvertPublishMapper tbAdvertPublishMapper;

    /**
     * 根据id获取广告信息对象
     *
     * @param id
     * @return
     */
    @Override
    public TbAdvert getAdvertByid(Long id) {

        TbAdvertExample tbAdvertExample = new TbAdvertExample();
        TbAdvertExample.Criteria criteria = tbAdvertExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<TbAdvert> adverts = tbAdvertMapper.selectByExample(tbAdvertExample);
        if (adverts == null || adverts.size() == 0) return null;
        return adverts.get(0);
    }

    /**
     * 获取广告信息列表--分页--条件查询
     *
     * @param param
     * @return
     */
    @Override
    public PageResult getAdvertList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        TbAdvertExample example = new TbAdvertExample();
        TbAdvertExample.Criteria criteria = example.createCriteria();
        //根据广告名称查询
        if (param.getFiled("advertName") != null) {
            criteria.andAdvertNameLike(SqlUtils.getLikeSql(param.getFiled("advertName")));
        }
        //根据广告类型查询
        if (param.getFiled("advertType") != null) {
            criteria.andAdvertTypeEqualTo(Integer.valueOf(param.getFiled("advertType")));
        }

        example.setOrderByClause("advert_type ASC,id ASC");
        List<TbAdvert> list = tbAdvertMapper.selectByExample(example);
        String json=jedisClient.hget(DIC_KEY, DicParentEnum.ADTYPE.getState()+"");
        for (TbAdvert tbAdvert : list) {
               tbAdvert.setTypeName(DicRedisUtils.getDicFormRedisById(tbAdvert.getAdvertType()+"",json));
        }
        PageInfo pageInfo = new PageInfo(list);
        return new PageResult(pageInfo);
    }


    /**
     * 插入广告信息
     *
     * @param tbAdvert
     * @return
     */
    @Override
    public OperateEnum insertAdvert(TbAdvert tbAdvert) {
        TbAdvertExample tbAdvertExample = new TbAdvertExample();
        TbAdvertExample.Criteria criteria = tbAdvertExample.createCriteria();
        criteria.andAdvertNameEqualTo(tbAdvert.getAdvertName());
        List<TbAdvert> adverts = tbAdvertMapper.selectByExample(tbAdvertExample);
        if (adverts.size() > 0) {
            return OperateEnum.NAME_REPEAT;
        }
        tbAdvert.setPublishState(0);//默认为未发布
        int res = tbAdvertMapper.insertSelective(tbAdvert);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    /**
     * 更新广告信息
     *
     * @param tbAdvert
     * @return
     */
    @Override
    public OperateEnum updateAdvert(TbAdvert tbAdvert) {
        int res = tbAdvertMapper.updateByPrimaryKeySelective(tbAdvert);

        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    /**
     * 根据id删除广告信息
     *
     * @param id
     * @return
     */
    @Override
    public OperateEnum deleteAdvertById(long id) {
        int ret = tbAdvertMapper.deleteByPrimaryKey(id);
        if (ret > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }


    /**
     * 修改广告图片
     *
     * @param advertImgUrl
     * @param id
     * @return
     */
    @Override
    public int updateAdvertImg(String advertImgUrl, long id) {

        TbAdvert tbAdvert = new TbAdvert();
        tbAdvert.setId(id);
        tbAdvert.setAdvertImg(advertImgUrl);
        int res = tbAdvertMapper.updateByPrimaryKeySelective(tbAdvert);
        return res;
    }

    /**
     * 根据广告发布Id获取对象
     * @param id
     * @return
     */
    @Override
    public TbAdvertPublish getAdvertPublishByid(Long id) {
        TbAdvertPublishExample tbAdvertPublishExample = new TbAdvertPublishExample();
        TbAdvertPublishExample.Criteria criteria = tbAdvertPublishExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<TbAdvertPublish> advertPublishes = tbAdvertPublishMapper.selectByExample(tbAdvertPublishExample);
        if (advertPublishes == null || advertPublishes.size() == 0) return null;
        return advertPublishes.get(0);
    }


    /**
     * 获取广告列表，分页查询，按条件查询
     * @param param
     * @return
     */
    @Override
    public PageResult getAdvertPublishList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        TbAdvertPublishExample example = new TbAdvertPublishExample();
        TbAdvertPublishExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("advertSort ASC,id ASC");
        List<TbAdvertPublish> list = tbAdvertPublishMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        return new PageResult(pageInfo);
    }

    @Override
    public OperateEnum insertAdvertPublish(TbAdvertPublish tbAdvertPublish) {
        return null;
    }


    /**
     * 更新广告
     * @param tbAdvertPublish
     * @return
     */
    @Override
    public OperateEnum updateAdvertPublish(TbAdvertPublish tbAdvertPublish) {
        int res = tbAdvertPublishMapper.updateByPrimaryKeySelective(tbAdvertPublish);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    /**
     * 删除广告-根据id
     * @param id
     * @return
     */
    @Override
    public OperateEnum deleteAdvertPublishById(long id) {
        int ret = tbAdvertPublishMapper.deleteByPrimaryKey(id);
        if (ret > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public List<KeyValue> getAdvertTypeList() {
        String json=jedisClient.hget(DIC_KEY,DicParentEnum.ADTYPE.getState()+"");
        List<KeyValue> list= JsonUtils.jsonToList(json,KeyValue.class);
        return  list;
    }
}
