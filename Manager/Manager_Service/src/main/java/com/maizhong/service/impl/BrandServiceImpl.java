package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.maizhong.common.dto.CarBrandDTO;
import com.maizhong.common.dto.KeyObject;
import com.maizhong.common.dto.KeyValue;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.TbCarBrandMapper;
import com.maizhong.pojo.TbCarBrand;
import com.maizhong.pojo.TbCarBrandExample;
import com.maizhong.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:汽车品牌接口实现
 * User: 王存浩
 * Date: 2017-03-06
 * Time: 11:13
 */

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbCarBrandMapper tbCarBrandMapper;

    @Autowired
    private JedisClient jedisClient;

    //基础库汽车品牌
    @Value("${CAR_BRAND}")
    private String CAR_BRAND;

    //汽车品牌ID 和名称
    @Value("${CAR_BRAND_ID}")
    private String CAR_BRAND_ID;

    //基础库汽车品牌ID 和名称
    @Value("${CAR_BRAND_HOT}")
    private String CAR_BRAND_HOT;
    @Value("${CAR_BRAND_GROUP}")
    private String CAR_BRAND_GROUP;

    /**
     * 根据Id获取品牌对象
     *
     * @param id
     * @return
     */

    @Override
    public TbCarBrand getCarBrandByid(Long id) {
        TbCarBrandExample tbCarBrandExample = new TbCarBrandExample();
        TbCarBrandExample.Criteria criteria = tbCarBrandExample.createCriteria();
        criteria.andIdEqualTo(id).andDelflagEqualTo(0);
        List<TbCarBrand> carBrand = tbCarBrandMapper.selectByExample(tbCarBrandExample);
        if (carBrand == null || carBrand.size() == 0) return null;
        return carBrand.get(0);
    }

    /**
     * 根据参数查询品牌列表
     *
     * @param param
     * @return
     */
    @Override
    public PageResult getCarBrandList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        TbCarBrandExample example = new TbCarBrandExample();
        TbCarBrandExample.Criteria criteria = example.createCriteria();
        if (param.getFiled("brandName") != null) {
            criteria.andBrandNameLike(SqlUtils.getLikeSql(param.getFiled("brandName")));
        }
        //查询出未删除的
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("brand_sequence ASC,id ASC");
        List<TbCarBrand> list = tbCarBrandMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo(list);

        return new PageResult(pageInfo);
    }

    @Override
    public List<TbCarBrand> getCarBrandList() {
        TbCarBrandExample example = new TbCarBrandExample();
        TbCarBrandExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        criteria.andStatusEqualTo(1);
        example.setOrderByClause("brand_sequence ASC,id ASC");
        List<TbCarBrand> list = tbCarBrandMapper.selectByExample(example);
        return list;
    }

    /**
     * 查询出所有状态为1 未删除的品牌信息
     *
     * @return
     */

    @Override
    public String getCarBrandListAll() {
        TbCarBrandExample example = new TbCarBrandExample();
        TbCarBrandExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        criteria.andStatusEqualTo(1);
        example.setOrderByClause("brand_sequence ASC,id ASC");
        List<TbCarBrand> list = tbCarBrandMapper.selectByExample(example);
        return JsonUtils.objectToJson(list);
    }

    /**
     * 添加品牌信息含LOGO
     *
     * @param tbCarBrand
     * @return
     */

    @Override
    public OperateEnum insertCarBrand(TbCarBrand tbCarBrand) {
        TbCarBrandExample tbCarBrandExample = new TbCarBrandExample();
        TbCarBrandExample.Criteria criteria = tbCarBrandExample.createCriteria();
        criteria.andBrandNameEqualTo(tbCarBrand.getBrandName());
        List<TbCarBrand> carBrand = tbCarBrandMapper.selectByExample(tbCarBrandExample);
        if (carBrand.size() > 0) {
            return OperateEnum.NAME_REPEAT;
        }
        int res = tbCarBrandMapper.insertSelective(tbCarBrand);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    /**
     * 更新品牌信息
     *
     * @param tbCarBrand
     * @return
     */
    @Override
    public OperateEnum updateCarBrand(TbCarBrand tbCarBrand) {
        int res = tbCarBrandMapper.updateByPrimaryKeySelective(tbCarBrand);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    /**
     * 根据id删除品牌信息 delflag设置为1
     *
     * @param id
     * @return
     */
    @Override
    public OperateEnum deleteCarBrandById(long id) {
        TbCarBrand carBrand = new TbCarBrand();
        carBrand.setId(id);
        carBrand.setDelflag(1);
        int ret = tbCarBrandMapper.updateByPrimaryKeySelective(carBrand);
        if (ret > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    /**
     * 修改品牌Logo
     *
     * @param carBrandAdvertImgUrl
     * @param id
     * @return
     */

    @Override
    public int updateBrandAdvert(String carBrandAdvertImgUrl, long id) {
        //更新品牌logo
        TbCarBrand carBrand = new TbCarBrand();
        carBrand.setId(id);
        carBrand.setBrandImg(carBrandAdvertImgUrl);
        int res = tbCarBrandMapper.updateByPrimaryKeySelective(carBrand);
        return res;
    }

    private List<TbCarBrand> getCarBrand(int rows){
        try {
            List<TbCarBrand> list = jedisClient.getObjectList(CAR_BRAND, TbCarBrand.class, 0, rows);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 更新品牌缓存
     * @return
     */
    @Override
    public JsonResult updateBrandRedis() {

        //删除品牌按字母分组
        try {
            jedisClient.del(CAR_BRAND_GROUP);
        } catch (Exception e) {
            e.printStackTrace();
        }

       //删除品牌信息缓存
        try {
            jedisClient.del(CAR_BRAND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //删除品牌ID对应品牌
        try {
            jedisClient.del(CAR_BRAND_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //删除热门品牌 top10
        try {
            jedisClient.del(CAR_BRAND_HOT);
        } catch (Exception e) {
            e.printStackTrace();
        }


        TbCarBrandExample example = new TbCarBrandExample();
        TbCarBrandExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("brand_sequence ASC,id ASC");
        List<TbCarBrand> list = tbCarBrandMapper.selectByExample(example);

        //写入品牌详情缓存
        try {
            jedisClient.setObjectList(CAR_BRAND, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
       //写入品牌信息  key：id  value：brandName
        for (TbCarBrand brand:list){
            try {
                jedisClient.hset(CAR_BRAND_ID,brand.getId()+"",brand.getBrandName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //写入热门品牌信息到缓存
        List<TbCarBrand> carBrandList= getCarBrand(9);
        List<CarBrandDTO> resList = Lists.newArrayList();
        for (TbCarBrand tbCarBrand : carBrandList) {
            resList.add(new CarBrandDTO(tbCarBrand.getId(),tbCarBrand.getBrandName(),tbCarBrand.getBrandImg()));
        }
        try {
            String carBrandHot = JsonUtils.objectToJson(resList);
            jedisClient.set(CAR_BRAND_HOT,carBrandHot);
        }catch (Exception e){
            e.printStackTrace();
        }

        //写入品牌分组

        List<TbCarBrand> carBrands = tbCarBrandMapper.selectByExample(null);

        if (carBrands==null||carBrands.size()==0){
            jedisClient.set(CAR_BRAND_GROUP,"");
        }

        Map<String, List<KeyValue>> map = new HashMap<>();

        List<KeyValue> list2 = null;
        for (TbCarBrand carBrand:carBrands) {
            list2 = map.get(carBrand.getInitial());
            if (list2==null){
                list2 = new ArrayList<>();
            }
            list2.add(new KeyValue(carBrand.getId()+"",carBrand.getBrandName()));
            map.put(carBrand.getInitial(),list2);
        }

        List<KeyObject> result = new ArrayList<>();

        for(char i='A';i<='Z';i++){
            if (map.get(i+"")==null){
                continue;
            }
            result.add(new KeyObject(i+"",map.get(i+"")));
        }
        jedisClient.set(CAR_BRAND_GROUP,JsonUtils.objectToJson(result));

        return JsonResult.build(OperateEnum.SUCCESS);
    }

}
