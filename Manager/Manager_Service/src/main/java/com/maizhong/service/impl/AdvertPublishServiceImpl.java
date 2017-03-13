package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.common.utils.TimeUtils;
import com.maizhong.mapper.TbAdvertMapper;
import com.maizhong.mapper.TbAdvertPublishMapper;
import com.maizhong.pojo.TbAdvert;
import com.maizhong.pojo.TbAdvertExample;
import com.maizhong.pojo.TbAdvertPublish;
import com.maizhong.pojo.TbAdvertPublishExample;
import com.maizhong.service.AdvertPublishService;
import com.maizhong.service.AdvertService;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
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


@Override
    public TbAdvertPublish getPublishByid(Long id) {
        List<TbAdvertPublish> advertPublishes = tbAdvertPublishMapper.selectTypeListByPrimaryKey(id);
        if (advertPublishes == null || advertPublishes.size() == 0) return null;
        return advertPublishes.get(0);
    }

    @Override
    public OperateEnum changeSort(String meth,Long id) {
        TbAdvertPublish tbAdvertPublish = getPublishByid(id);
        if (StringUtils.equals("top", meth)) {
            //置顶
            tbAdvertPublish.setAdvertSort(0);
            updateAdvertPublish(tbAdvertPublish);

        } else if (StringUtils.equals("up", meth)) {
            if (tbAdvertPublish.getAdvertSort()==0){
                return OperateEnum.SUCCESS;
            }else {
            tbAdvertPublish.setAdvertSort(getPublishByid(id).getAdvertSort() - 1);
            updateAdvertPublish(tbAdvertPublish);
            return  OperateEnum.SUCCESS;
            }
        } else {
            tbAdvertPublish.setAdvertSort(tbAdvertPublish.getAdvertSort() + 1);
            updateAdvertPublish(tbAdvertPublish);
            return OperateEnum.SUCCESS;
        }
        return OperateEnum.SUCCESS;
    }

    @Override
    public OperateEnum advertPublish(long id) {
        System.out.println("====advertPublishIMpl========");
        TbAdvertPublish tbAdvertPublish=new TbAdvertPublish();
        tbAdvertPublish.setAdvertSort(0);
        tbAdvertPublish.setAdvertTime(new Date());
        tbAdvertPublish.setAdvertId(id);
        OperateEnum result = insertAdvertPublish(tbAdvertPublish);
        return result;
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

      if (param.getFiled("advertType") != null) {
            criteria.andAdvertTypeEqualTo(Integer.valueOf(param.getFiled("advertType")));
     }else {
          criteria.andAdvertTypeEqualTo(null);
      }
        example.setOrderByClause("id ASC");
        List<TbAdvertPublish> list = tbAdvertPublishMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        return new PageResult(pageInfo);
    }

    @Override
    public OperateEnum insertAdvertPublish(TbAdvertPublish tbAdvertPublish) {
        /*TbAdvertPublishExample tbAdvertPublishExample = new TbAdvertPublishExample();
        TbAdvertPublishExample.Criteria criteria = tbAdvertPublishExample.createCriteria();*/

        int res = tbAdvertPublishMapper.insertSelective(tbAdvertPublish);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public OperateEnum updateAdvertPublish(TbAdvertPublish tbAdvertPublish) {
        int res = tbAdvertPublishMapper.updateByPrimaryKeySelective(tbAdvertPublish);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

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
    public List<TbAdvertPublish> selectTypeListByPrimaryKey(long id) {
       return tbAdvertPublishMapper.selectTypeListByPrimaryKey(id);
    }





}
