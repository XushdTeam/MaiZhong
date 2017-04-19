package com.maizhong.service;

import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.TbCarBrandLineMapper;
import com.maizhong.mapper.TbCarBrandMapper;
import com.maizhong.mapper.TbCarFactoryMapper;
import com.maizhong.pojo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Xushd on 2017/4/5.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class RedisTest {

//    @Resource
//    private JedisClient jedisClient;
//
//    @Resource
//    private TbCarBrandMapper carBrandMapper;
//
//    @Resource
//    private TbCarFactoryMapper factoryMapper;
//
//    @Resource
//    private TbCarBrandLineMapper seriseMapper;
//
//    @Value("${FACTORY_SERISE}")
//    private String FACTORY_SERISE;
//
//    @Value("${CAR_FACTORY}")
//    private String CAR_FACTORY;
//
//    @Value("${BRAND_FACTORY_SERISE}")
//    private String BRAND_FACTORY_SERISE;
//
//
//    @Test
//    public void SetFactoryRedis(){
//        TbCarFactoryExample example = new TbCarFactoryExample();
//        List<TbCarFactory> factoryList = factoryMapper.selectByExample(example);
//        for (TbCarFactory factory : factoryList) {
//            Map<String,String> map = new HashMap<>();
//            map.put("brandId",factory.getBrandId()+"");
//            map.put("Id",factory.getId()+"");
//            map.put("name",factory.getFactoryName()+"");
//            jedisClient.hset(CAR_FACTORY,factory.getId()+"",JsonUtils.objectToJson(map));
//        }
//    }
//
//    @Test
//    public void SetBrandFactorySerise(){
//        TbCarBrandExample brandExample = new TbCarBrandExample();
//        TbCarFactoryExample factoryExample = new TbCarFactoryExample();
//        TbCarBrandLineExample lineExample = new TbCarBrandLineExample();
//
//        TbCarBrandExample.Criteria criteria = brandExample.createCriteria();
//        criteria.andDelflagEqualTo(0).andStatusEqualTo(1);
//
//
//        List<TbCarBrand> tbCarBrands = carBrandMapper.selectByExample(brandExample);
//
//        for (TbCarBrand tbCarBrand : tbCarBrands) {
//
//            List<Map<String,Object>> list = new ArrayList<>();
//
//            factoryExample.clear();
//            TbCarFactoryExample.Criteria factoryCriteria = factoryExample.createCriteria();
//            factoryCriteria.andBrandIdEqualTo(tbCarBrand.getId());
//
//            List<TbCarFactory> factoryList = factoryMapper.selectByExample(factoryExample);
//
//            for (TbCarFactory factory : factoryList) {
//                lineExample.clear();
//                TbCarBrandLineExample.Criteria lineExampleCriteria = lineExample.createCriteria();
//                lineExampleCriteria.andFactoryIdEqualTo(factory.getId());
//                List<TbCarBrandLine> tbCarBrandLines = seriseMapper.selectByExample(lineExample);
//
//                Map<String,Object> map1 = new HashMap<>();
//                map1.put("fN",factory.getFactoryName());
//                map1.put("fI",factory.getId()+"");
//                map1.put("fBi",factory.getBrandId()+"");
//                List<Map<String,String>> list1 = new ArrayList<>();
//                for (TbCarBrandLine tbCarBrandLine : tbCarBrandLines) {
//                    Map<String,String> map2 = new HashMap<>();
//                    map2.put("sN",tbCarBrandLine.getLineName());
//                    map2.put("sI",tbCarBrandLine.getId()+"");
//                    map2.put("sBi",tbCarBrandLine.getBrandId()+"");
//                    map2.put("sFi",tbCarBrandLine.getFactoryId()+"");
//                    list1.add(map2);
//                }
//                map1.put("fSL",list1);
//                list.add(map1);
//            }
//            jedisClient.hset(BRAND_FACTORY_SERISE,tbCarBrand.getId()+"",JsonUtils.objectToJson(list));
//
//        }
//
//        jedisClient.hset("BFR:123","1","test");
//    }


}