package com.maizhong.rest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.AuthEnum;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.RestInterfaceMapper;
import com.maizhong.mapper.TbCarBrandLineMapper;
import com.maizhong.mapper.TbCarBrandMapper;
import com.maizhong.mapper.TbCarFactoryMapper;
import com.maizhong.pojo.*;
import com.maizhong.rest.service.IndexService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xushd on 2017/3/3.
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Value("${ACCOUNT}")
    private String ACCOUNT;

    @Value("${PASSWORD}")
    private String PASSWORD;

    @Value("${ADVERT}")
    private String ADVERT;

    @Value("${FACTORY_SERISE}")
    private String FACTORY_SERISE;

    @Value("${CAR_FACTORY}")
    private String CAR_FACTORY;

    @Value("${BRAND_FACTORY_SERISE}")
    private String BRAND_FACTORY_SERISE;

    @Autowired
    private RestInterfaceMapper interfaceMapper;

    @Autowired
    private TbCarBrandMapper carBrandMapper;

    @Autowired
    private TbCarFactoryMapper factoryMapper;

    @Autowired
    private TbCarBrandLineMapper seriseMapper;

    @Autowired
    private JedisClient jedisClient;

    @Override
    public JsonResult login(String username, String password) {
        if(!StringUtils.equals(ACCOUNT,username)){
            return JsonResult.build(AuthEnum.USER_NO_EXIT);
        }else if(!StringUtils.equals(PASSWORD,password)){
            return JsonResult.build(AuthEnum.USER_ERROR_PASSWORD);
        }else{
            Map<String,Object> user = new HashMap<>();
            user.put("username",ACCOUNT);
            user.put("password",PASSWORD);
            user.put("advert",ADVERT);
            return JsonResult.OK(user);
        }
    }

    @Override
    public JsonResult getBaseInfo() {
        Map<String,Object> baseInfo = new HashMap<>();
        baseInfo.put("version","1.0.0");
        RestInterfaceExample example = new RestInterfaceExample();
        long count = interfaceMapper.countByExample(example);
        baseInfo.put("interfaceCount",count);
        return JsonResult.OK(baseInfo);
    }

    @Override
    public JsonResult getInterfaceList(PageSearchParam pageSearchParam) {

        PageHelper.startPage(pageSearchParam.getPageIndex(), pageSearchParam.getPageSize());
        RestInterfaceExample example = new RestInterfaceExample();
        RestInterfaceExample.Criteria criteria = example.createCriteria();
        if(pageSearchParam.getFiled("interfaceName")!= null){
            criteria.andInterfaceNameLike(SqlUtils.getLikeSql(pageSearchParam.getFiled("interfaceName")));
        }
        if(pageSearchParam.getFiled("interfaceUrl")!= null){
            criteria.andInterfaceUrlEqualTo(pageSearchParam.getFiled("interfaceUrl"));
        }
        List<RestInterface> list = interfaceMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);

        PageResult result = new PageResult(pageInfo);
        return JsonResult.OK(result);
    }


    @Override
    public JsonResult saveInterface(RestInterface restInterface) {

        int res = interfaceMapper.insertSelective(restInterface);
        if(res>0){
            return JsonResult.build(OperateEnum.SUCCESS);
        }else{
            return JsonResult.build(OperateEnum.FAILE);
        }
    }

    @Override
    public JsonResult SetFactoryRedis() {

        TbCarFactoryExample example = new TbCarFactoryExample();
        List<TbCarFactory> factoryList = factoryMapper.selectByExample(example);
        for (TbCarFactory factory : factoryList) {
            Map<String,String> map = new HashMap<>();
            map.put("brandId",factory.getBrandId()+"");
            map.put("Id",factory.getId()+"");
            map.put("name",factory.getFactoryName()+"");
            jedisClient.hset(CAR_FACTORY,factory.getId()+"", JsonUtils.objectToJson(map));
        }


        return JsonResult.OK();
    }

    @Override
    public JsonResult SetBrandFactorySerise() {
        TbCarBrandExample brandExample = new TbCarBrandExample();
        TbCarFactoryExample factoryExample = new TbCarFactoryExample();
        TbCarBrandLineExample lineExample = new TbCarBrandLineExample();

        TbCarBrandExample.Criteria criteria = brandExample.createCriteria();
        criteria.andDelflagEqualTo(0).andStatusEqualTo(1);


        List<TbCarBrand> tbCarBrands = carBrandMapper.selectByExample(brandExample);

        for (TbCarBrand tbCarBrand : tbCarBrands) {

            List<Map<String,Object>> list = new ArrayList<>();

            factoryExample.clear();
            TbCarFactoryExample.Criteria factoryCriteria = factoryExample.createCriteria();
            factoryCriteria.andBrandIdEqualTo(tbCarBrand.getId());

            List<TbCarFactory> factoryList = factoryMapper.selectByExample(factoryExample);

            for (TbCarFactory factory : factoryList) {
                lineExample.clear();
                TbCarBrandLineExample.Criteria lineExampleCriteria = lineExample.createCriteria();
                lineExampleCriteria.andFactoryIdEqualTo(factory.getId());
                List<TbCarBrandLine> tbCarBrandLines = seriseMapper.selectByExample(lineExample);

                Map<String,Object> map1 = new HashMap<>();
                map1.put("fN",factory.getFactoryName());
                map1.put("fI",factory.getId()+"");
                map1.put("fBi",factory.getBrandId()+"");
                List<Map<String,String>> list1 = new ArrayList<>();
                for (TbCarBrandLine tbCarBrandLine : tbCarBrandLines) {
                    Map<String,String> map2 = new HashMap<>();
                    map2.put("sN",tbCarBrandLine.getLineName());
                    map2.put("sI",tbCarBrandLine.getId()+"");
                    map2.put("sBi",tbCarBrandLine.getBrandId()+"");
                    map2.put("sFi",tbCarBrandLine.getFactoryId()+"");
                    list1.add(map2);
                }
                map1.put("fSL",list1);
                list.add(map1);
            }
            jedisClient.hset(BRAND_FACTORY_SERISE,tbCarBrand.getId()+"",JsonUtils.objectToJson(list));

        }



        return JsonResult.OK();

    }
}
