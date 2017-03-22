package com.maizhong.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ServiceLog;
import com.maizhong.common.utils.TimeUtils;
import com.maizhong.mapper.TbCarMapper;
import com.maizhong.mapper.TbCarPropMapper;
import com.maizhong.mapper.ext.TbCarMapperExt;
import com.maizhong.pojo.TbCar;
import com.maizhong.pojo.TbCarExample;
import com.maizhong.pojo.TbCarPropExample;
import com.maizhong.pojo.vo.TbCarBaseVo;
import com.maizhong.pojo.vo.TbCarVo;
import com.maizhong.service.CarService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by yangF on 2017/3/7.
 */
@Service
public class CarServiceImpl implements CarService {


    @Resource
    private TbCarMapper tbCarMapper;

    @Resource
    private TbCarMapperExt tbCarMapperExt;


    @Resource
    private TbCarPropMapper carPropMapper;

    @Value("${PAGESIZE}")
    private  static Integer PAGESIZE;

    @Value("${POINTPRICE}")
    private  static Integer POINTPRICE;

    @ServiceLog(module = "汽车管理",methods = "汽车添加")
    @Override
    public JsonResult addTbCar(TbCar car) {
        if (car==null){
            return JsonResult.Error("数据错误");
        }

        //number`'汽车编号 ',  `name`'车型名称 类似奥迪a4',
//        if (car.getNumber()==null||car.getName()==null||StringUtils.isBlank(car.getNumber())||StringUtils.isBlank(car.getName()+"")){
//            return JsonResult.Error("编号或者名称不可以为空");
//        }
        //car_brand`  '外键链接车辆品牌  类似奥迪',`car_type` '外键  链接车辆类型',
//        if (car.getCarType()==null||car.getCarBrand()==null||StringUtils.isBlank(car.getCarType()+"")||StringUtils.isBlank(car.getCarBrand()+"")){
//            return JsonResult.Error("品牌和类型是必选项");
//        }
        //`year_sku`  '年款式 类似 奥迪a42016款',
//        if (car.getYearSku()==null||StringUtils.isBlank(car.getYearSku()+"")){
//            return JsonResult.Error("车辆年份不可以为空");
//        }

        //订金价格',
        if (car.getReservePrice()==null||car.getSellPrice()==null||StringUtils.isBlank(car.getReservePrice()+"")||StringUtils.isBlank(car.getSellPrice()+"")){
            return JsonResult.Error("车辆卖价和定金不可以为空");
        }
        //添加时间',
        car.setCreateTime(new Date());
        //修改时间',
        car.setUpdateTime(new Date());
        //unable` '是否可用 用于搜索时是否展示',
        if (car.getUnable()==null||StringUtils.isBlank(car.getUnable()+"")){
            car.setUnable(1);
        }
        //desc` text NOT NULL COMMENT '商品详情的存储字段',
        //weight` int(11) DEFAULT '100' COMMENT '权重',

        int insert = tbCarMapper.insertSelective(car);

        if (insert==1){
            JsonResult build = JsonResult.build(OperateEnum.SUCCESS);
            //以后改成number？？？ 预留一下
            build.setData(car.getId());
            return build;
        } else{
            return JsonResult.Error("网络异常 请联系管理员");
        }
    }

    /**
     * 根据id查询方法
     * @param id
     * @return
     */
    @Override
    public TbCar findCarById(Long id) {
        return id==null?null:tbCarMapper.selectByPrimaryKey(id);
    }


    /**
     * 修改方法
     * @param car
     * @return
     */
    @ServiceLog(module = "汽车管理",methods = "汽车修改")
    @Override
    public JsonResult updateCar(TbCar car){

        if (car==null){
            return JsonResult.Error("数据错误");
        }

        //  `number`'汽车编号 ', id 主键
        if (car.getNumber()==null||car.getId()==null||StringUtils.isBlank(car.getId()+"")||StringUtils.isBlank(car.getNumber()+"")){
            return JsonResult.Error("编号或者Id为空了");
        }
        //品牌类型
        if (car.getCarType()==null||car.getCarBrand()==null||StringUtils.isBlank(car.getCarType()+"")||StringUtils.isBlank(car.getCarBrand()+"")){
            return JsonResult.Error("品牌和类型是必选项");
        }
        // `year_sku 年款式
//        if ( car.getYearSku()==null||StringUtils.isBlank(car.getYearSku()+"")){
//            return JsonResult.Error("车辆年份不可以为空");
//        }
        //    '订金价格',
        if (car.getReservePrice()==null||car.getSellPrice()==null||StringUtils.isBlank(car.getReservePrice()+"")||StringUtils.isBlank(car.getSellPrice()+"")){
            return JsonResult.Error("车辆卖价和定金不可以为空");
        }
        //  '修改时间',
        car.setUpdateTime(new Date());
        //  unable` '是否可用 用于搜索时是否展示',
        if (car.getUnable()==null||StringUtils.isBlank(car.getUnable()+"")){
            car.setUnable(1);
        }

        //修改方法
        return  tbCarMapper.updateByPrimaryKeySelective(car)==1?JsonResult.OK("修改成功"):JsonResult.Error("修改失败");
    }

    /***
     * 删除方法
     * @param id
     * @return
     */
    @ServiceLog(module = "汽车管理",methods = "汽车删除")
    @Override
    public JsonResult deleteCar(Long id) {
        if (id!=null){
            //清除汽车属性表
            if(tbCarMapper.deleteByPrimaryKey(id)>0){
                TbCarPropExample example = new TbCarPropExample();
                example.createCriteria().andCarIdEqualTo(id);
                carPropMapper.deleteByExample(example);
            }
            JsonResult.build(OperateEnum.SUCCESS);
        }
        return JsonResult.build(OperateEnum.FAILE);
    }

    /****
     * 汽车 列表查询
     *
     *      汽车属性不包含 详情
     *      汽车实体为TbCarVo
     * @param param
     * @return
     */
    @Override
    public PageResult findListToShow(PageSearchParam param) {
        if (param==null){
            param=new PageSearchParam();
        }
        if (param.getPageSize()==0){
            param.setPageSize(PAGESIZE);
        }
        //开启分页
        Page page = PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        //添加条件
        TbCarExample example = new TbCarExample();

        TbCarExample.Criteria criteria = example.createCriteria();
        //添加查询条件 queryString
        if (param!=null){

            //添加时间条件
            if (param.getFiled("timeBegin")!=null){
                criteria.andUpdateTimeGreaterThan(TimeUtils.getDate(param.getFiled("timeBegin")));
            }
            if (param.getFiled("timeEnd")!=null){
                criteria.andUpdateTimeLessThan(TimeUtils.getDate(param.getFiled("timeEnd")));
            }

            //添加品牌与类型
            if (param.getFiled("carType")!=null){
                criteria.andCarTypeEqualTo(Long.parseLong(param.getFiled("carType")));
            }
            if (param.getFiled("carBrand")!=null){
                criteria.andCarBrandEqualTo(Long.parseLong(param.getFiled("carBrand")));
            }

            //价格区间放弃
            /*if (StringUtils.isNotBlank(param.getFiled("queryString"))&&!param.getFiled("queryString").contains("=")){
                criteria.andNameLike("%"+param.getFiled("queryString")+"%");
            }*/
        }

        //查询
        List<TbCarVo> list=tbCarMapperExt.findListNotContainsDesc(example);
        PageInfo pageInfo = null;
        if (list!=null){
            pageInfo = new PageInfo(list);
        }

        return new PageResult(pageInfo);
    }


    @Override
    public JsonResult findBaseCar(String carSeries, String carYear){
        if (StringUtils.isBlank(carSeries)||StringUtils.isBlank(carYear)){
            return JsonResult.Error("数据错误");
        }
        List<TbCarBaseVo> list = tbCarMapperExt.findByCarYearAndCarSeres(carSeries, carYear);
        if (list!=null){
            return JsonResult.OK(list);
        }
        return JsonResult.Error("数据错误");
    }
}
