package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.KeyValue;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.DicParentEnum;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.DicRedisUtils;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.common.utils.TimeUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.TbAdvertMapper;
import com.maizhong.mapper.TbAdvertPublishMapper;
import com.maizhong.pojo.*;
import com.maizhong.service.AdvertPublishService;
import com.maizhong.service.AdvertService;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Description:广告发布接口实现
 * User: 王存浩
 * Date: 2017-03-08
 * Time: 13:26
 */

@Service
public class AdvertPublishServiceImpl implements AdvertPublishService {

    @Autowired
    TbAdvertPublishMapper tbAdvertPublishMapper;
    @Autowired
    TbAdvertMapper tbAdvertMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${DIC_KEY}")
    private String DIC_KEY;
    @Value("${AD_HOME}")
    private String AD_HOME;


    /**
     * 根据广告发布Id获取对象
     *
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


    @Override
    public TbAdvertPublish getPublishByid(Long id) {
        List<TbAdvertPublish> advertPublishes = tbAdvertPublishMapper.selectTypeListByPrimaryKey(id);
        if (advertPublishes == null || advertPublishes.size() == 0) return null;
        return advertPublishes.get(0);
    }

    @Override
    public OperateEnum changeSort(String meth, Long id) {
        int res = 0;

        if (StringUtils.equals("top", meth)) {
            //置顶
            res = tbAdvertPublishMapper.topSort(id);

        } else if (StringUtils.equals("up", meth)) {
            res = tbAdvertPublishMapper.upSort(id);
        } else {
            res = tbAdvertPublishMapper.downSort(id);
        }
        if (res > 0) {
            TbAdvertPublish tbAdvertPublish = tbAdvertPublishMapper.selectByPrimaryKey(id);
            Long advertId = tbAdvertPublish.getAdvertId();
            TbAdvert tbAdvert = tbAdvertMapper.selectByPrimaryKey(advertId);
            jedisClient.hdel(AD_HOME, tbAdvert.getAdvertType() + "");
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public OperateEnum advertPublish(Long id) {
        TbAdvertPublish tbAdvertPublish = new TbAdvertPublish();
        tbAdvertPublish.setAdvertSort(0);
        tbAdvertPublish.setAdvertTime(new Date());
        tbAdvertPublish.setAdvertId(id);
        TbAdvert tbAdvert = tbAdvertMapper.selectByPrimaryKey(id);
        int count = 0;
        if (tbAdvert == null) {
            return OperateEnum.FAILE;
        } else {
            tbAdvert.setPublishState(1);
            count = tbAdvertMapper.updateByPrimaryKeySelective(tbAdvert);
        }
        if (count < 1) {
            return OperateEnum.FAILE;
        }
        int res = tbAdvertPublishMapper.insertSelective(tbAdvertPublish);
        if (res > 0) {
            jedisClient.hdel(AD_HOME, tbAdvert.getAdvertType() + "");
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }


    /**
     * 获取广告列表，分页查询，按条件查询
     *
     * @param param
     * @return
     */
    @Override
    public PageResult getAdvertPublishList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        Long typeId = null;
        if (param.getFiled("advertType") != null) {
            typeId = Long.valueOf(param.getFiled("advertType"));
        }
        int startPage = (param.getPageIndex() - 1) * param.getPageSize();
        List<TbAdvertPublishJoinAdvert> list = tbAdvertPublishMapper.getAdvertPublishByType(typeId);
        String json = jedisClient.hget(DIC_KEY, DicParentEnum.ADTYPE.getState() + "");
        for (TbAdvertPublishJoinAdvert tbAdvert : list) {
            tbAdvert.setTypeName(DicRedisUtils.getDicFormRedisById(tbAdvert.getAdvertType() + "", json));
        }
        PageInfo pageInfo = new PageInfo(list);
        return new PageResult(pageInfo);
    }

    /**
     * 更新发布
     *
     * @param tbAdvertPublish
     * @return
     */


    /**
     * 删除发布
     *
     * @param id
     * @return
     */

    @Override
    public OperateEnum deleteAdvertPublishById(Long id) {
        TbAdvertPublish tbAdvertPublish = tbAdvertPublishMapper.selectByPrimaryKey(id);
        System.out.println(tbAdvertPublish.getAdvertId());
        Long advertId = tbAdvertPublish.getAdvertId();
        TbAdvert tbAdvert = tbAdvertMapper.selectByPrimaryKey(advertId);
        int count = 0;

        if (tbAdvert == null) {
            return OperateEnum.FAILE;
        } else {
            tbAdvert.setPublishState(0);
            count = tbAdvertMapper.updateByPrimaryKeySelective(tbAdvert);
        }

        int ret = tbAdvertPublishMapper.deleteByPrimaryKey(id);
        if (ret > 0 && count > 0) {
            jedisClient.hdel(AD_HOME, tbAdvert.getAdvertType() + "");
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }


    /**
     * 根据广告id取消广告发布
     *
     * @param id
     * @return
     */
    @Override
    public OperateEnum removeAdvertPublishById(long id) {
        TbAdvert tbAdvert = tbAdvertMapper.selectByPrimaryKey(id);
        TbAdvertPublishExample example = new TbAdvertPublishExample();
        TbAdvertPublishExample.Criteria criteria = example.createCriteria();
        criteria.andAdvertIdEqualTo(id);
        List<TbAdvertPublish> list = tbAdvertPublishMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return OperateEnum.FAILE;
        }

        TbAdvertPublish tbAdvertPublish = list.get(0);
        int count = 0;

        if (tbAdvert == null) {
            return OperateEnum.FAILE;
        } else {
            tbAdvert.setPublishState(0);
            count = tbAdvertMapper.updateByPrimaryKeySelective(tbAdvert);
        }
        int ret = tbAdvertPublishMapper.deleteByPrimaryKey(tbAdvertPublish.getId());
        if (ret > 0 && count > 0) {
            jedisClient.hdel(AD_HOME, tbAdvert.getAdvertType() + "");
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }


    /**
     * 根据类型查询
     *
     * @param id
     * @return
     */
    @Override
    public List<TbAdvertPublish> selectTypeListByPrimaryKey(Long id) {
        return tbAdvertPublishMapper.selectTypeListByPrimaryKey(id);
    }

    @Override
    public List<KeyValue> getAdvertTypeList() {
        String json = jedisClient.hget(DIC_KEY, DicParentEnum.ADTYPE.getState() + "");
        List<KeyValue> list = JsonUtils.jsonToList(json, KeyValue.class);
        return list;
    }

}
