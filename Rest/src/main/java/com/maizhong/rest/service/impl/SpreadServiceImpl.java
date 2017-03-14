package com.maizhong.rest.service.impl;

import com.github.pagehelper.PageHelper;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.TbAdvertMapper;
import com.maizhong.mapper.TbCarBrandMapper;
import com.maizhong.mapper.TbCarTypeMapper;
import com.maizhong.pojo.*;
import com.maizhong.rest.service.SpreadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-13
 * Time: 15:07
 */

@Service
public class SpreadServiceImpl implements SpreadService {

    @Autowired
    private TbAdvertMapper tbAdvertMapper;
    @Autowired
    private TbCarBrandMapper tbCarBrandMapper;
    @Autowired
    private TbCarTypeMapper tbCarTypeMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${AD_HOME}")
    private String AD_HOME;

    @Value("${CAR_BRAND}")
    private String CAR_BRAND;

    @Value("${CAR_TYPE}")
    private String CAR_TYPE;


    /**
     * 获取发布广告信息
     * @param type
     * @return
     */
    @Override
    public JsonResult getAdvertByType(Integer type) {

        //缓存命中
        try {
            String json = jedisClient.hget(AD_HOME,type+"");
            if(StringUtils.isNotBlank(json)){
                return JsonResult.OK(JsonUtils.jsonToList(json,TbAdvert.class));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        List<TbAdvert> list = tbAdvertMapper.getAdvertPublish(Long.valueOf(type));

        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(list);
            jedisClient.hset(AD_HOME,type+"",jsonStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.OK(list);
    }



    @Override
    public JsonResult getIndexBrand() {

        //缓存命中
        try {
            String json = jedisClient.get(CAR_BRAND);
            if(StringUtils.isNotBlank(json)){
                return JsonResult.OK(JsonUtils.jsonToList(json,TbCarBrand.class));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        PageHelper.startPage(0, 10);
        TbCarBrandExample example = new TbCarBrandExample();
        TbCarBrandExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("brand_sequence ASC,id ASC");
        List<TbCarBrand> list = tbCarBrandMapper.selectByExample(example);

        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(list);
            jedisClient.set(CAR_BRAND,jsonStr);
        }catch (Exception e){
            e.printStackTrace();
        }

        return JsonResult.OK(list);
    }

    @Override
    public JsonResult getIndexCarType() {

        //缓存命中
        try {
            String json = jedisClient.get(CAR_TYPE);
            if(StringUtils.isNotBlank(json)){
                return JsonResult.OK(JsonUtils.jsonToList(json,TbCarType.class));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        TbCarTypeExample example = new TbCarTypeExample();
        TbCarTypeExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("type_sequence ASC,id ASC");
        List<TbCarType> list = tbCarTypeMapper.selectByExample(example);

        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(list);
            jedisClient.set(CAR_TYPE,jsonStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.OK(list);
    }


}

