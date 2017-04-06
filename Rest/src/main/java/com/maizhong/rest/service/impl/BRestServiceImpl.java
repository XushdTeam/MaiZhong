package com.maizhong.rest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.CarBaseDTO;
import com.maizhong.common.dto.KeyObject;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.IDUtils;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.TimeUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.*;
import com.maizhong.mapper.ext.TbCarBaseMapperExt;
import com.maizhong.mapper.ext.TbCarMapperExt;
import com.maizhong.pojo.*;
import com.maizhong.pojo.vo.TbCarBaseVo;
import com.maizhong.rest.service.BRestService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by YangF on 2017/3/28.
 */
@Service
public class BRestServiceImpl implements BRestService {

    @Resource
    private TbCarMapper tbCarMapper;

    @Resource
    private TbCarMapperExt tbCarMapperExt;

    @Resource
    private TbMessageMapper tbMessageMapper;

    @Resource
    private TbBusinessMapper tbBusinessMapper;

    @Resource
    private TbBusinessUserMapper tbBusinessUserMapper;
    @Resource
    private TbCarBrandMapper tbCarBrandMapper;
    @Resource
    private TbCarBrandLineMapper tbCarBrandLineMapper;
    @Resource
    private TbCarBaseMapperExt tbCarBaseMapperExt;
    @Resource
    private TbCarFactoryMapper tbCarFactoryMapper;


    @Resource
    private JedisClient jedisClient;


    @Value("${CAR_SERIES}")
    private String CAR_SERIES;
    @Value("${CAR_BRAND_ID}")
    private String CAR_BRAND_ID;
    @Value("${CAR_SERIES_ID}")
    private String CAR_SERIES_ID;

    @Value("${BUSSINESSUSER_PREFIX}")
    private String BUSSINESSUSER_PREFIX;

    @Value("${BUSSINESSUSER_INFO}")
    private String BUSSINESSUSER_INFO;


    private String verifyCar(TbCar car) {

        if (car == null) {
            return "数据错误";
        }

        //number`'汽车编号   name`'车型名称 类似奥迪a4',
//        if (car.getNumber()==null|| StringUtils.isBlank(car.getNumber())){
//            return "编号或者名称不可以为空";
//        }
        //car_brand   外键链接车辆品牌  类似奥迪  car_type  外键  链接车辆类型',
        if (car.getCarBrand() == null || StringUtils.isBlank(car.getCarBrand() + "")) {
            return "请选择汽车品牌";
        }
        //`baseId`  连接基础库Id
        if (car.getBaseId() == null || StringUtils.isBlank(car.getBaseId() + "")) {
            return "库中车辆数据不可以为空";
        }

        //订金价格',
        if (car.getSellPrice() == null || StringUtils.isBlank(car.getSellPrice() + "")) {
            return "车辆卖价不可以为空";
        }

        //如果商家ID不为空  返回数据
        if (car.getBusinessId() == null) {
            return "账户处于不安全环境下，请联系网站管理员或重试";
        }

        return null;
    }


    /***
     * 外接 汽车添加接口
     * 重点
     * 商店id
     * 添加数量
     * 编号
     * 手动填充的数据  ： 暂无
     *
     * @param car
     * @return
     */
    @Override
    public JsonResult insertCar(TbCar car) {

        String meaasge = verifyCar(car);
        if (meaasge != null) {
            return JsonResult.Error(meaasge);
        }
        String name = IDUtils.genImageName();
        car.setNumber(name);

        //添加时间
        if (car.getCreateTime() == null) {
            car.setCreateTime(new Date());
        }
        //修改时间',
        car.setUpdateTime(new Date());
        //unable   借用此接口  默认不可用  需要后台进行处理
//        if (car.getUnable()==null||StringUtils.isBlank(car.getUnable()+"")){
        //TODO  暂时设置为 可用
        car.setUnable(1);
//        }


        //权重搜索字段默认用户不可修改    置为0
        car.setWeight(0);

        //设置销售数量
        car.setSellNum(0);

        int insert = tbCarMapper.insertSelective(car);

        if (insert == 1) {
            //id 回显  mapper未修改
//            return JsonResult.OK(car.getId());
            return JsonResult.OK("添加成功");
        } else {
            return JsonResult.Error("网络异常 请联系管理员");
        }
    }


    @Override
    public JsonResult updateCar(TbCar tbCar) {

        verifyCar(tbCar);

        if (tbCar != null) {
            if (tbCar.getId() != null) {
                TbCar oldTbCar = tbCarMapper.selectByPrimaryKey(tbCar.getId());
                if (oldTbCar != null) {

                    tbCar.setNumber(null);
                    tbCar.setUnable(null);
                    tbCar.setSellNum(null);
                    tbCar.setWeight(null);
                    tbCar.setUpdateTime(new Date());


                    tbCarMapper.updateByPrimaryKeySelective(tbCar);
                    return JsonResult.OK("修改成功");
                }
            }
        }
        return JsonResult.Error("修改失败，数据错误");
    }

    @Override
    public JsonResult deleteCar(String id) {
        Long longId = null;
        if (id != null) {
            longId = Long.parseLong(id);
        }
        int i = tbCarMapper.deleteByPrimaryKey(longId);
        return JsonResult.OK("删除成功");
    }

    //下架方法
    @Override
    public JsonResult unable(String id, Integer unalbe) {
        TbCar tbCar = new TbCar();
        if (id != null) {
            Long longId = Long.parseLong(id);
            tbCar.setId(longId);
            if (unalbe != null && unalbe == 1) {
                tbCar.setUnable(unalbe);
            } else {
                tbCar.setUnable(0);
            }
            tbCarMapper.updateByPrimaryKeySelective(tbCar);
            JsonResult.OK(unalbe == 1 ? "上架成功" : "下架成功");
        }
        return JsonResult.Error("系统错误，请检查网络");
    }


    /***
     * 外接系统
     * 此汽车方法根据外来参数返回数据
     * 不可频繁调用此方法
     * 此方法不添加缓存
     *
     * @return
     */
    @Override
    public JsonResult selectCarByBussiness(Long businessId, Long carSeries,
                                           Long brandId, String date, String carYear,
                                           Integer currentPage, Integer pageSize, String sortString) {


        if (businessId == null) {
            return JsonResult.Error("账号状态异常，请联系管理员");
        }

        //分页
        pageSize = 10;
        Integer start = 0;
        if (currentPage != null) {
            start = currentPage;
        }
        PageHelper.startPage(start, pageSize);
        if (StringUtils.isNotBlank(sortString)) {
            //TODO  未确定排序格式
            sortString = null;
        }
        if (StringUtils.isBlank(carYear) || "0".equals(carYear)) {
            carYear = null;
        }
        if (StringUtils.isNotBlank(date)) {
            //TODO  未确定时间格式
            date = null;
        }
        List<Map<String, Object>> cars = tbCarMapperExt.findByBussinessId(businessId, carSeries, brandId, carYear, date, sortString);

        PageInfo<Map<String, Object>> info = new PageInfo<>(cars);

        return JsonResult.OK(new PageResult(info));
    }

    /**
     * 根据汽车id获取汽车信息
     *
     * @param id
     * @return
     */
    @Override
    public JsonResult findCarInfoById(Long id) {
        TbCar tbCar = tbCarMapper.selectByPrimaryKey(id);
        return JsonResult.OK(tbCar);
    }


    /***
     * 返回汽车品牌
     *
     * @return
     */
    @Override
    public JsonResult findBrandsByCatch() {

        String s = jedisClient.get("CAR_BRAND_GROUP");
        List<KeyObject> car_brand_group = null;
        if (s != null) {
            car_brand_group = JsonUtils.jsonToList(s, KeyObject.class);
        }
        return JsonResult.OK(car_brand_group);
    }


    /***
     * 根据品牌Id获取车系
     *
     * @return
     */
    @Override
    public JsonResult findSeriesByCatch(String brandId) {
        String brand = jedisClient.hget("CAR_SERIES", brandId);
        List<TbCarBrandLine> list = JsonUtils.jsonToList(brand, TbCarBrandLine.class);
        return JsonResult.OK(list);
    }

    /**
     * 根据车系  与 年份 返回 年款式
     *
     * @param seriesId year
     * @return
     */
    @Override
    public JsonResult findSkuBySeriesAndYear(String seriesId, String year) {
        if (seriesId == null) {
            return JsonResult.Error("data error");
        }
        TbCarBrandLine tbCarBrandLine = new TbCarBrandLine();
        try {
            tbCarBrandLine = tbCarBrandLineMapper.selectByPrimaryKey(Long.valueOf(seriesId));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String name = tbCarBrandLine.getLineName();
        List<TbCarBaseVo> vos = tbCarMapperExt.findByCarYearAndCarSeres(name, year);
        return JsonResult.OK(vos);
    }


    /**
     * 根据 bussiness 返回 商户信息
     *
     * @param username,password
     * @return
     */
    @Override
    public JsonResult userLogin(String username, String password) {

        TbBusinessUserExample example = new TbBusinessUserExample();
        TbBusinessUserExample.Criteria criteria = example.createCriteria();

        criteria.andUserNameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<TbBusinessUser> users = tbBusinessUserMapper.selectByExample(example);

        //登陆成功  添加用户至缓存    用户未关联商户 禁止登陆
        //  用户缓存重复添加
        if (users != null && users.size() == 1 && users.get(0).getBusinessId() != null) {
            TbBusinessUser user = users.get(0);
            Map<String, Object> userInfo = new HashMap<>();

            TbBusiness business = tbBusinessMapper.selectByPrimaryKey(user.getBusinessId());

            if (business != null) {
                userInfo.put("businessName", business.getBusinessName());
                userInfo.put("businessId", business.getId());
                userInfo.put("businessLogo", business.getLogo());
                userInfo.put("businessAdress", business.getAddress());
                userInfo.put("userName", user.getUserName());
                userInfo.put("userId", user.getId());
                userInfo.put("userAdvert", user.getUserAdvert());
                userInfo.put("userPhone", user.getUserPhone());
                userInfo.put("userEmail", user.getUserEmail());


                return JsonResult.OK(userInfo);
            }
        }
        return JsonResult.Error("登陆失败，用户名或者密码不匹配");
    }


    @Override
    public JsonResult loginOfCatch(String username, String password) {
        JsonResult result = userLogin(username, password);
        if (result.getStatus()==200){
            Map<String,Object> data = (Map<String, Object>) result.getData();
            if (data!=null&&data.size()>0){
                //生成Token
                String token = UUID.randomUUID().toString().replace("-","");

                //redis 模拟缓存 添加到缓存命中
                String jsonInfo = JsonUtils.objectToJson(data);

                if (StringUtils.isNotBlank(jsonInfo)) {
                    jedisClient.hset(BUSSINESSUSER_PREFIX + token, BUSSINESSUSER_INFO, jsonInfo);
                    jedisClient.expire(BUSSINESSUSER_PREFIX + token, 900);
                }

                Map<String,Object> realResult = new HashMap<>();

                realResult.put("token",token);
                realResult.put("userInfo",data);

                return JsonResult.OK(realResult);
            }
            return JsonResult.Error("登录失败，用户名或者密码错误");
        }
        return result;
    }



    @Override
    public JsonResult getDetailsByCarId(Long id) {
        List<Map<String, Object>> list = tbCarMapperExt.findDetailsByCarId(id);
        if (list != null && list.size() > 0) {
            return JsonResult.OK(list.get(0));
        }
        return JsonResult.Error("数据错误");
    }


    @Override
    public OperateEnum insertSeries(Long brandId, Long factoryId,String seriesName) {
        if (brandId == null || StringUtils.isBlank(seriesName)) {
            return OperateEnum.FAILE;
        }
        TbCarBrandLine tbCarBrandLine = new TbCarBrandLine();
        try {
            tbCarBrandLine.setBrandId(brandId);
        } catch (Exception e) {
            e.printStackTrace();
            return OperateEnum.FAILE;
        }
        TbCarBrandLineExample tbCarBrandLineExample = new TbCarBrandLineExample();
        TbCarBrandLineExample.Criteria criteria = tbCarBrandLineExample.createCriteria();
        criteria.andLineNameEqualTo(seriesName);
        criteria.andDelflagEqualTo(0);
        criteria.andFactoryIdEqualTo(factoryId);
        List<TbCarBrandLine> tbCarBrandLines = tbCarBrandLineMapper.selectByExample(tbCarBrandLineExample);
        if (tbCarBrandLines.size() > 0) {
            return OperateEnum.NAME_REPEAT;
        }
        tbCarBrandLine.setDelflag(0);
        tbCarBrandLine.setLineName(seriesName);
        tbCarBrandLine.setLineSequence(999);
        tbCarBrandLine.setStatus(1);
        tbCarBrandLine.setFactoryId(factoryId);
        int res = tbCarBrandLineMapper.insertSelective(tbCarBrandLine);
        if (res > 0) {
            jedisClient.hdel(CAR_SERIES, brandId + "");
            TbCarBrandLineExample example = new TbCarBrandLineExample();
            TbCarBrandLineExample.Criteria criteria2 = example.createCriteria();
            criteria2.andDelflagEqualTo(0);
            criteria2.andBrandIdEqualTo(brandId);
            List<TbCarBrandLine> list2 = tbCarBrandLineMapper.selectByExample(example);
            //写入缓存
            try {
                String jsonStr = JsonUtils.objectToJson(list2);
                jedisClient.hset(CAR_SERIES, brandId + "", jsonStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return OperateEnum.SUCCESS;
        }
        return OperateEnum.FAILE;
    }

    /**
     * 添加汽车基础数据
     *
     * @param carBaseDTO
     * @return
     */
    @Override
    public OperateEnum insertCarCarBase(CarBaseDTO carBaseDTO) {
        if (carBaseDTO == null) {
            return OperateEnum.FAILE;
        }
        String brandId = carBaseDTO.getCarBrand();
        String carSeries = carBaseDTO.getCarSeries();
        String initial = null;
        try {
            initial = tbCarBrandMapper.selectByPrimaryKey(Long.valueOf(brandId)).getInitial();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            brandId = jedisClient.hget(CAR_BRAND_ID, brandId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TbCarBrandLine tbCarBrandLine=new TbCarBrandLine();
        try {
            tbCarBrandLine = tbCarBrandLineMapper.selectByPrimaryKey(Long.valueOf(carSeries));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        TbCarFactory tbCarFactory =new TbCarFactory();
        try {
            tbCarFactory=   tbCarFactoryMapper.selectByPrimaryKey(Long.valueOf(carBaseDTO.getCarFactory()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        carBaseDTO.setCarFactory(tbCarFactory.getFactoryName());
        carBaseDTO.setCarBrand(brandId);
        carBaseDTO.setCarSeries(tbCarBrandLine.getLineName());
        carBaseDTO.setInitial(initial);
        int res = tbCarBaseMapperExt.insertSelective(carBaseDTO);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public JsonResult getShopCount(Long businessId) {
        long totalCarNumber = tbCarMapper.totalCarNumber(businessId);
        long totalBrandNumber = tbCarMapper.totalBrandNumber(businessId);
        long totalSeriesNumber = tbCarMapper.totalSeriesNumber(businessId);
        long shopCarNumber = tbCarMapper.shopCarNumber(businessId);
        long shopBrandNumber = tbCarMapper.shopBrandNumber(businessId);
        long shopSeriesNumber = tbCarMapper.shopSeriesNumber(businessId);
        TbCarExample example = new TbCarExample();
        List<String> dateList = new ArrayList<>();
        List<Long> numberList = new ArrayList<>();
        for (int i = 6; i >= 0; i--) {
            dateList.add(TimeUtils.getDateBeforeDay(i));
            Long num = 0L;
            if (i == 0) {
                num = tbCarMapper.weekNumber(TimeUtils.getDateBeforeDay(i), TimeUtils.getDateBeforeDay(-1), businessId);
            } else {
                num = tbCarMapper.weekNumber(TimeUtils.getDateBeforeDay(i), TimeUtils.getDateBeforeDay(i - 1), businessId);
            }
            numberList.add(num);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("totalCarNumber", totalCarNumber);
        map.put("shopCarNumber", shopCarNumber);
        map.put("totalBrandNumber", totalBrandNumber);
        map.put("shopBrandNumber", shopBrandNumber);
        map.put("totalSeriesNumber", totalSeriesNumber);
        map.put("shopSeriesNumber", shopSeriesNumber);
        map.put("dateList", dateList);
        map.put("numberList", numberList);
        return JsonResult.build(200, "获取成功", map);
    }

    /**
     * 根据品牌获取厂商
     *
     * @param brandId
     * @return
     */
    @Override
    public JsonResult findFactoryByBrand(String brandId) {
        TbCarFactoryExample tbCarFactoryExample = new TbCarFactoryExample();
        TbCarFactoryExample.Criteria criteria = tbCarFactoryExample.createCriteria();
        try {
            criteria.andBrandIdEqualTo(Long.valueOf(brandId));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return JsonResult.Error("网络错误，请刷新后重试");
        }
        List<TbCarFactory> tbCarFactories = tbCarFactoryMapper.selectByExample(tbCarFactoryExample);

        if (tbCarFactories != null && tbCarFactories.size() > 0) {
            return JsonResult.OK(tbCarFactories);
        }
        return JsonResult.OK();

    }

  //根据汽车厂商获取车系
    @Override
    public JsonResult getSeriesByFactory(String factoryId) {
        TbCarBrandLineExample tbCarBrandLineExample=new TbCarBrandLineExample();
        TbCarBrandLineExample.Criteria criteria = tbCarBrandLineExample.createCriteria();
        try {
            criteria.andFactoryIdEqualTo(Long.valueOf(factoryId));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return JsonResult.Error("网络错误，请刷新后重试！");
        }
        List<TbCarBrandLine> tbCarBrandLines = tbCarBrandLineMapper.selectByExample(tbCarBrandLineExample);
        if (tbCarBrandLines!=null&&tbCarBrandLines.size()>0){
            return JsonResult.OK(tbCarBrandLines);
        }
        return JsonResult.OK();
    }

    @Override
    public JsonResult isOnline(String token) {
        if (StringUtils.isNotBlank(token)){
            String json = jedisClient.hget(BUSSINESSUSER_PREFIX + token, BUSSINESSUSER_INFO);
            if (StringUtils.isNotBlank(json)){
                jedisClient.expire(BUSSINESSUSER_PREFIX + token,60);
                Map<String,Object> map = JsonUtils.jsonToPojo(json, Map.class);
                if (map!=null){

                    Map<Object, Object> result = new HashMap<>();
                    result.put("userInfo",map);

                    return JsonResult.OK(map);
                }
            }
        }
        return JsonResult.Error("未登录");
    }

    /*//插入汽车厂商
    @Override
    public JsonResult getFactoryByBrand() {
        TbCarBrandExample example = new TbCarBrandExample();
        List<TbCarBrand> brands = tbCarBrandMapper.selectByExample(example);
        for (TbCarBrand brand : brands) {
            String brandName = brand.getBrandName();
            List<String> list = tbCarFactoryMapper.getFactoryByBrand(brandName);
            for (String factoryName : list) {
                TbCarFactory tbCarFactory = new TbCarFactory();
                tbCarFactory.setFactoryName(factoryName);
                tbCarFactory.setBrandId(brand.getId());
                tbCarFactoryMapper.insert(tbCarFactory);
            }
        }
        return JsonResult.OK("插入成功");
    }
*/

    /**
     * 插入车系
     * @return
     */
    /*@Override
    public JsonResult getSeriesByFactory() {
        TbCarFactoryExample example=new TbCarFactoryExample();
        List<TbCarFactory> list = tbCarFactoryMapper.selectByExample(example);
        for (TbCarFactory factory:list){
            String factoryName = factory.getFactoryName();
          String  brandName = jedisClient.hget(CAR_BRAND_ID, String.valueOf(factory.getBrandId()));
            List<String> seriesByFactory = tbCarBrandLineMapper.getSeriesByFactory(factoryName,brandName);
            for (String series:seriesByFactory){
                TbCarBrandLine tbCarBrandLine=new TbCarBrandLine();
                tbCarBrandLine.setBrandId(factory.getBrandId());
                tbCarBrandLine.setLineName(series);
                tbCarBrandLine.setFactoryId(factory.getId());
                tbCarBrandLineMapper.insert(tbCarBrandLine);
            }
        }
        return JsonResult.OK("插入成功！");
    }
*/

}
