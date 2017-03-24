package com.maizhong.rest.service.impl;

import com.github.pagehelper.PageHelper;
import com.maizhong.common.dto.CarColumnJoinCar;
import com.maizhong.common.dto.CarIndexDetail;
import com.maizhong.common.dto.CarShowIndex;
import com.maizhong.common.dto.KeyValue;
import com.maizhong.common.enums.DicParentEnum;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.*;
import com.maizhong.pojo.*;
import com.maizhong.rest.service.SpreadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    private TbCarColumnMapper tbCarColumnMapper;
    @Autowired
    private TbFeedbackMapper tbFeedbackMapper;
    @Autowired
    private TbConsultMapper tbConsultMapper;
    @Autowired
    private TbCarBrandLineMapper tbCarBrandLineMapper;
    @Autowired
    private JedisClient jedisClient;

    @Value("${AD_HOME}")
    private String AD_HOME;

    @Value("${CAR_BRAND}")
    private String CAR_BRAND;

    @Value("${CAR_TYPE}")
    private String CAR_TYPE;

    @Value("${CM_CONTENT}")
    private String CM_CONTENT;

    @Value("${DIC_KEY}")
    private String DIC_KEY;

    @Value("${CAR_SERIES}")
    private String CAR_SERIES;

    /**
     * 获取发布广告信息
     *
     * @param type
     * @return
     */
    @Override
    public JsonResult getAdvertByType(Integer type) {

        //缓存命中
        try {
            String json = jedisClient.hget(AD_HOME, type + "");
            if (StringUtils.isNotBlank(json)) {
                return JsonResult.OK(JsonUtils.jsonToList(json, TbAdvert.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<TbAdvert> list = tbAdvertMapper.getAdvertPublish(Long.valueOf(type));

        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(list);
            jedisClient.hset(AD_HOME, type + "", jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.OK(list);
    }


    @Override
    public JsonResult getIndexBrand() {

        //缓存命中
        try {
            String json = jedisClient.get(CAR_SERIES);
            if (StringUtils.isNotBlank(json)) {
                List<TbCarBrand> brands=JsonUtils.jsonToList(json, TbCarBrand.class);
                return JsonResult.OK(brands.subList(0,10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TbCarBrandExample example = new TbCarBrandExample();
        TbCarBrandExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("brand_sequence ASC,id ASC");
        List<TbCarBrand> list = tbCarBrandMapper.selectByExample(example);

        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(list);
            jedisClient.set(CAR_BRAND, jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.OK(list.subList(0,10));
    }

    @Override
    public JsonResult getIndexCarType() {

        //缓存命中
        try {
            String json = jedisClient.get(CAR_TYPE);
            if (StringUtils.isNotBlank(json)) {
                return JsonResult.OK(JsonUtils.jsonToList(json, TbCarType.class));
            }
        } catch (Exception e) {
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
            jedisClient.set(CAR_TYPE, jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.OK(list);
    }

    /**
     * 根据栏目Id获取栏目下的所有汽车
     *
     * @param columnId
     * @return
     */
    @Override
    public JsonResult getCarColumnById(Integer columnId, Integer number) {

        if (number <= 0) {
            number = 1;
        }
        int size = 0;
        //缓存命中
        try {
            String json = jedisClient.get(CM_CONTENT);
            if (StringUtils.isNotBlank(json)) {
                return JsonResult.OK(JsonUtils.jsonToList(json, CarShowIndex.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String dicJson = jedisClient.hget(DIC_KEY, DicParentEnum.CMID + "");
        List<KeyValue> dicList = JsonUtils.jsonToList(dicJson, KeyValue.class);
        List<CarShowIndex> carShowList = new ArrayList<>();
        for (KeyValue keyValue : dicList) {
            List<CarColumnJoinCar> list = tbCarColumnMapper.getListByColumn(1L, Long.valueOf(keyValue.getKey()));
            if (list != null && list.size() > 0) {
                CarShowIndex car_show = new CarShowIndex(Long.valueOf(keyValue.getKey()), keyValue.getValue());

            }
        }

        List<CarColumnJoinCar> list = tbCarColumnMapper.getListByColumn(1L, null);
        //获取列表


        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(list);
            jedisClient.hset(CM_CONTENT, columnId + "", jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list != null) {
            size = list.size();
            if (size <= number) {
                return JsonResult.OK(list);
            } else {
                return JsonResult.OK(list.subList(0, number));
            }

        } else {
            return JsonResult.OK(null);
        }
    }

    @Override
    public List<CarShowIndex> getHomeItem() {
        //缓存命中
        try {
            String json = jedisClient.get(CM_CONTENT);
            if (StringUtils.isNotBlank(json)) {
                return JsonUtils.jsonToList(json, CarShowIndex.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String dicJson = jedisClient.hget(DIC_KEY, DicParentEnum.CMID.getState() + "");
        List<KeyValue> dicList = JsonUtils.jsonToList(dicJson, KeyValue.class);
        List<CarShowIndex> carShowList = new ArrayList<>();
        for (KeyValue keyValue : dicList) {
            List<CarColumnJoinCar> list = tbCarColumnMapper.getListByColumn(1L, Long.valueOf(keyValue.getKey()));
            if (list != null && list.size() > 0) {
                CarShowIndex car_show = new CarShowIndex(Long.valueOf(keyValue.getKey()), keyValue.getValue());
                List<CarIndexDetail> carIndexList = new ArrayList<>();
                for (CarColumnJoinCar carColumnJoinCar : list) {
                    carIndexList.add(new CarIndexDetail(carColumnJoinCar.getCarId(), carColumnJoinCar.getName(),carColumnJoinCar.getFactoryPrice(),
                            carColumnJoinCar.getImage(),carColumnJoinCar.getReservePrice(),carColumnJoinCar.getSellPrice()));
                }
                car_show.setArry(carIndexList);
                carShowList.add(car_show);
            }
        }


        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(carShowList);
            jedisClient.set(CM_CONTENT, jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carShowList;
    }


    /**
     * 用户反馈添加
     * @param phone  手机号
     * @param content  反馈内容
     * @param surname  称谓
     * @return
     */
    @Override
    public OperateEnum insertFeedback(String phone, String content, String surname) {
        TbFeedback tbFeedback=new TbFeedback();
        tbFeedback.setPhone(phone);
        tbFeedback.setDelflag(0);
        tbFeedback.setStatus(1);
        tbFeedback.setCheckStatus(0);
        tbFeedback.setCreateTime(new Date());
        tbFeedback.setContent(content);
        tbFeedback.setSurname(surname);

       int res= tbFeedbackMapper.insert(tbFeedback);

        if (res>0){
            return OperateEnum.SUCCESS;
        }else {
            return  OperateEnum.FAILE;
        }
    }

    @Override
    public OperateEnum insertConsult(String phone,String type) {
        TbConsult tbConsult=new TbConsult();
        tbConsult.setPhone(phone);
        try {
            tbConsult.setType(Integer.valueOf(type));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        tbConsult.setDelflag(0);
        tbConsult.setStatus(0);
        tbConsult.setConsultTime(new Date());
        int res= tbConsultMapper.insert(tbConsult);
        if (res>0){
            return OperateEnum.SUCCESS;
        }else {
            return  OperateEnum.FAILE;
        }
    }

    /**
     * 获取所有品牌
     * @return
     */
    @Override
    public JsonResult getAllBrand() {
        //缓存命中
        try {
            List<TbCarBrand> list = jedisClient.getObjectList(CAR_BRAND,TbCarBrand.class,0,-1);
            if(list!=null&&list.size()>0){
                return JsonResult.OK(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TbCarBrandExample example = new TbCarBrandExample();
        TbCarBrandExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("id ASC");
        List<TbCarBrand> list = tbCarBrandMapper.selectByExample(example);

        //写入缓存
        try {
            jedisClient.setObjectList(CAR_BRAND,list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JsonResult.OK(list);
    }

    @Override
    public JsonResult getSeriesByBrand(Long brandId) {
        //缓存命中
        try {
            String json = jedisClient.hget(CAR_SERIES,brandId+"");
            if (StringUtils.isNotBlank(json)) {
                List<TbCarBrandLine> tbCarBrandLineList=JsonUtils.jsonToList(json, TbCarBrandLine.class);
                return JsonResult.OK(tbCarBrandLineList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TbCarBrandLineExample example = new TbCarBrandLineExample();
        TbCarBrandLineExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        criteria.andBrandIdEqualTo(brandId);
        example.setOrderByClause("line_name ASC");
        List<TbCarBrandLine> list = tbCarBrandLineMapper.selectByExample(example);
        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(list);
            jedisClient.hset(CAR_SERIES,brandId+"", jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.OK(list);
    }

    /**
     * 获取前十车系 key 存为hot
     * @return
     */

    @Override
    public JsonResult getHotSeries() {
        //缓存命中
        try {
            String json = jedisClient.hget(CAR_SERIES,"hot");
            if (StringUtils.isNotBlank(json)) {
                List<TbCarBrandLine> tbCarBrandLineList=JsonUtils.jsonToList(json, TbCarBrandLine.class);
                return JsonResult.OK(tbCarBrandLineList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageHelper.startPage(1,10);
        TbCarBrandLineExample example = new TbCarBrandLineExample();
        TbCarBrandLineExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("line_sequence ASC");
        List<TbCarBrandLine> list = tbCarBrandLineMapper.selectByExample(example);
        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(list);
            jedisClient.hset(CAR_SERIES,"hot", jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.OK(list);
    }
}

