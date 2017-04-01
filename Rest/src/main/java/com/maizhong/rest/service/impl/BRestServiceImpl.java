package com.maizhong.rest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.KeyObject;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.IDUtils;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.TbBusinessMapper;
import com.maizhong.mapper.TbBusinessUserMapper;
import com.maizhong.mapper.TbCarBrandMapper;
import com.maizhong.mapper.TbCarMapper;
import com.maizhong.mapper.ext.TbCarMapperExt;
import com.maizhong.pojo.*;
import com.maizhong.pojo.vo.TbCarBaseVo;
import com.maizhong.rest.service.BRestService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private TbBusinessMapper tbBusinessMapper;

    @Resource
    private TbBusinessUserMapper tbBusinessUserMapper;


    @Resource
    private TbCarBrandMapper tbCarBrandMapper;


    @Resource
    private JedisClient jedisClient;



    private String verifyCar(TbCar car){

        if (car==null){
            return "数据错误";
        }

        //number`'汽车编号   name`'车型名称 类似奥迪a4',
//        if (car.getNumber()==null|| StringUtils.isBlank(car.getNumber())){
//            return "编号或者名称不可以为空";
//        }
        //car_brand   外键链接车辆品牌  类似奥迪  car_type  外键  链接车辆类型',
        if (car.getCarBrand()==null||StringUtils.isBlank(car.getCarBrand()+"")){
            return "请选择汽车品牌";
        }
        //`baseId`  连接基础库Id
        if (car.getBaseId()==null||StringUtils.isBlank(car.getBaseId()+"")){
            return "库中车辆数据不可以为空";
        }

        //订金价格',
        if (car.getSellPrice()==null||StringUtils.isBlank(car.getSellPrice()+"")){
            return "车辆卖价不可以为空";
        }

        //如果商家ID不为空  返回数据
        if (car.getBusinessId()==null){
            return "账户处于不安全环境下，请联系网站管理员或重试";
        }

        return null;
    }



    /***
     * 外接 汽车添加接口
     *             重点
     *                  商店id
     *                  添加数量
     *                  编号
     *                  手动填充的数据  ： 暂无
     *
     * @param car
     * @return
     */
    @Override
    public JsonResult insertCar(TbCar car) {

        String meaasge = verifyCar(car);
        if (meaasge!=null){
            return JsonResult.Error(meaasge);
        }
        String name = IDUtils.genImageName();
        car.setNumber(name);

        //添加时间
        if (car.getCreateTime()==null){
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

        if (insert==1){
            //id 回显  mapper未修改
//            return JsonResult.OK(car.getId());
            return  JsonResult.OK("添加成功");
        } else{
            return JsonResult.Error("网络异常 请联系管理员");
        }
    }


    @Override
    public JsonResult updateCar(TbCar tbCar) {

        verifyCar(tbCar);

        if (tbCar!=null){
            if (tbCar.getId()!=null){
                TbCar oldTbCar = tbCarMapper.selectByPrimaryKey(tbCar.getId());
                if (oldTbCar!=null){

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
        if (id!=null){
            longId = Long.parseLong(id);
        }
        int i = tbCarMapper.deleteByPrimaryKey(longId);
        return JsonResult.OK("删除成功");
    }

    //下架方法
    @Override
    public JsonResult unable(String id, Integer unalbe) {
        TbCar tbCar = new TbCar();
        if (id!=null){
            Long longId = Long.parseLong(id);
            tbCar.setId(longId);
            if (unalbe!=null&&unalbe==1){
                tbCar.setUnable(unalbe);
            }else{
                tbCar.setUnable(0);
            }
            tbCarMapper.updateByPrimaryKeySelective(tbCar);
            JsonResult.OK(unalbe==1?"上架成功":"下架成功");
        }
        return JsonResult.Error("系统错误，请检查网络");
    }


    /***
     * 外接系统
     *         此汽车方法根据外来参数返回数据
     *         不可频繁调用此方法
     *         此方法不添加缓存
     * @return
     */
    @Override
    public JsonResult selectCarByBussiness(Long businessId, Long carSeries,
                                           Long brandId, String date, String carYear,
                                           Integer currentPage, Integer pageSize, String sortString) {


        if (businessId==null){
            return JsonResult.Error("账号状态异常，请联系管理员");
        }

        //分页
        pageSize = 10;
        Integer start = 0;
        if (currentPage != null){
            start = currentPage ;
        }
        PageHelper.startPage(start,pageSize);
        if (StringUtils.isNotBlank(sortString)){
            //TODO  未确定排序格式
            sortString = null;
        }
        if (StringUtils.isBlank(carYear)||"0".equals(carYear)){
            carYear = null;
        }
        if (StringUtils.isNotBlank(date)){
            //TODO  未确定时间格式
            date = null;
        }
        List<Map<String, Object>> cars = tbCarMapperExt.findByBussinessId(businessId,carSeries,brandId,carYear,date,sortString);

        PageInfo<Map<String, Object>> info = new PageInfo<>(cars);

        return JsonResult.OK(new PageResult(info));
    }

    /**
     * 根据汽车id获取汽车信息
     * @param id
     * @return
     */
    @Override
    public JsonResult findCarInfoById(Long id) {
        TbCar tbCar = tbCarMapper.selectByPrimaryKey(id);
        return JsonResult.OK(tbCar);
    }


    /***
     *  返回汽车品牌
     *
     * @return
     */
    @Override
    public JsonResult findBrandsByCatch() {

        String s = jedisClient.get("CAR_BRAND_GROUP");
        List<KeyObject> car_brand_group =null;
        if (s!=null){
            car_brand_group = JsonUtils.jsonToList(s, KeyObject.class);
        }
        return  JsonResult.OK(car_brand_group);
    }



    /***
     * 根据品牌Id获取车系
     *
     * @return
     */
    @Override
    public JsonResult findSeriesByCatch(String brandId) {
        String brand = jedisClient.hget("CAR_SERIES",brandId);
        List<TbCarBrandLine> list = JsonUtils.jsonToList(brand, TbCarBrandLine.class);
        return  JsonResult.OK(list);
    }

    /**
     * 根据车系  与 年份 返回 年款式
     * @param seriesId  year
     * @return
     */
    @Override
    public JsonResult findSkuBySeriesAndYear(String seriesId, String year) {
        if (seriesId==null){
            return JsonResult.Error("data error");
        }
        String name = jedisClient.hget("CAR_SERIES_ID", seriesId);

        List<TbCarBaseVo> vos = tbCarMapperExt.findByCarYearAndCarSeres(name, year);
        return  JsonResult.OK(vos);
    }


    /**
     *  根据 bussiness 返回 商户信息
     * @param username,password
     * @return
     */
    @Override
    public JsonResult userLogin(String username,String password) {

        TbBusinessUserExample example = new TbBusinessUserExample();
        TbBusinessUserExample.Criteria criteria = example.createCriteria();

        criteria.andUserNameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<TbBusinessUser> users = tbBusinessUserMapper.selectByExample(example);

        //登陆成功  添加用户至缓存    用户未关联商户 禁止登陆
        //  用户缓存重复添加
        if (users!=null&&users.size()==1&&users.get(0).getBusinessId()!=null) {
            TbBusinessUser user = users.get(0);
            Map<String, Object> userInfo = new HashMap<>();

            TbBusiness business = tbBusinessMapper.selectByPrimaryKey(user.getBusinessId());

            if (business!=null){
                userInfo.put("businessName",business.getBusinessName());
                userInfo.put("businessId",business.getId());
                userInfo.put("businessLogo",business.getLogo());
                userInfo.put("businessAdress",business.getAddress());
                userInfo.put("userName",user.getUserName());
                userInfo.put("userId",user.getId());
                userInfo.put("userAdvert",user.getUserAdvert());
                userInfo.put("userPhone",user.getUserPhone());
                userInfo.put("userEmail",user.getUserEmail());


                return JsonResult.OK(userInfo);
            }
        }
        return JsonResult.Error("登陆失败，用户名或者密码不匹配");
    }


    @Override
    public JsonResult getDetailsByCarId(Long id){
        List<Map<String, Object>> list = tbCarMapperExt.findDetailsByCarId(id);
        if (list!=null&&list.size()>0){
            return JsonResult.OK(list.get(0));
        }
        return JsonResult.Error("数据错误");
    }


}
