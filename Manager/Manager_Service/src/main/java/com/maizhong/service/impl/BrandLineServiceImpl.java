package com.maizhong.service.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.TbCarBrandLineMapper;
import com.maizhong.pojo.TbCar;
import com.maizhong.pojo.TbCarBrand;
import com.maizhong.pojo.TbCarBrandLine;
import com.maizhong.pojo.TbCarBrandLineExample;
import com.maizhong.service.BrandLineService;
import com.maizhong.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by YangF on 2017/3/16.
 */
@Service
public class BrandLineServiceImpl implements BrandLineService {

    @Autowired
    private BrandService brandService;


    @Autowired
    private TbCarBrandLineMapper tbCarBrandLineMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${CAR_SERIES}")
    private String CAR_SERIES;


    @Override
    public TbCarBrandLine getCarBrandLineByid(Long id) {
        return id==null?null:tbCarBrandLineMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据品牌查询车型
     *
     * @param brandId
     * @return
     */
    @Override
    public JsonResult getCarBrandLineList(Long brandId) {
        if (brandId==null) return JsonResult.Error("系统错误");
        TbCarBrandLineExample example = new TbCarBrandLineExample();
        example.createCriteria().andBrandIdEqualTo(brandId);
        List<TbCarBrandLine> list = tbCarBrandLineMapper.selectByExample(example);
        return JsonResult.OK(list);
    }


    @Override
    public JsonResult insertCarBrandLine(TbCarBrandLine tbCarBrandLine) {
        if (tbCarBrandLine==null||tbCarBrandLine.getBrandId()==null){
            return JsonResult.Error("错误的数据");
        }
        if (tbCarBrandLine.getStatus()!=null){
            if (tbCarBrandLine.getStatus()==1){
                tbCarBrandLine.setDelflag(0);
            }else{
                tbCarBrandLine.setDelflag(1);
            }
        }else{
            tbCarBrandLine.setStatus(1);
            tbCarBrandLine.setDelflag(0);
        }

        //TODO 缓存处理 预留
        if (tbCarBrandLine.getShowFlag()!=null&&tbCarBrandLine.getShowFlag()==1){

        }

        tbCarBrandLineMapper.insertSelective(tbCarBrandLine);
        return JsonResult.OK("添加成功");
    }

    @Override
    public JsonResult updateCarBrandLine(TbCarBrandLine tbCarBrandLine) {

        if (tbCarBrandLine==null||tbCarBrandLine.getId()==null||tbCarBrandLine.getBrandId()==null){
            return JsonResult.Error("错误的数据");
        }
        if (tbCarBrandLine.getStatus()!=null){
            if (tbCarBrandLine.getStatus()==1){
                tbCarBrandLine.setDelflag(0);
            }else{
                tbCarBrandLine.setDelflag(1);
            }
        }else{
            tbCarBrandLine.setStatus(1);
            tbCarBrandLine.setDelflag(0);
        }

        //TODO 缓存处理 预留
        if (tbCarBrandLine.getShowFlag()!=null&&tbCarBrandLine.getShowFlag()==1){

        }
        tbCarBrandLineMapper.updateByPrimaryKeySelective(tbCarBrandLine);
        return JsonResult.OK("修改成功");

    }

    @Override
    public JsonResult deleteById(Long id) {
        if (id==null)
            return JsonResult.Error("数据错误");
        TbCarBrandLine tbCarBrandLine=tbCarBrandLineMapper.selectByPrimaryKey(id);
        tbCarBrandLine.setDelflag(1);
        tbCarBrandLineMapper.updateByPrimaryKey(tbCarBrandLine);
        return JsonResult.OK("删除成功");
    }

    /**
     * 根据id获取车系
     * @param id
     * @return
     */
    @Override
    public TbCarBrandLine getSeriesById(Long id) {
        TbCarBrandLine tbCarBrandLine=tbCarBrandLineMapper.selectByPrimaryKey(id);
        return tbCarBrandLine;
    }

    @Override
    public PageResult getSeriesList(PageSearchParam param, Long id) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        TbCarBrandLineExample example = new TbCarBrandLineExample();
        TbCarBrandLineExample.Criteria criteria = example.createCriteria();
        if (param.getFiled("lineName") != null) {
            criteria.andLineNameLike(SqlUtils.getLikeSql(param.getFiled("lineName")));
        }
        criteria.andBrandIdEqualTo(id);
        criteria.andDelflagEqualTo(0);
        List<TbCarBrandLine> list = tbCarBrandLineMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        return new PageResult(pageInfo);
    }

    @Override
    public OperateEnum updateSeries(TbCarBrandLine tbCarBrandLine) {
        int res = tbCarBrandLineMapper.updateByPrimaryKeySelective(tbCarBrandLine);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public OperateEnum insertSeries(TbCarBrandLine tbCarBrandLine) {

        TbCarBrandLineExample tbCarBrandLineExample = new TbCarBrandLineExample();
        TbCarBrandLineExample.Criteria criteria = tbCarBrandLineExample.createCriteria();
        criteria.andLineNameEqualTo(tbCarBrandLine.getLineName());
        List<TbCarBrandLine> tbCarBrandLines = tbCarBrandLineMapper.selectByExample(tbCarBrandLineExample);
        if (tbCarBrandLines.size() > 0){
            return OperateEnum.NAME_REPEAT;
        }

        int res = tbCarBrandLineMapper.insertSelective(tbCarBrandLine);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public OperateEnum updateRedis() {
        //先删除缓存
        try {
            jedisClient.del(CAR_SERIES);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<TbCarBrand> list=brandService.getCarBrandList();

        for (TbCarBrand brand:list){
            TbCarBrandLineExample example = new TbCarBrandLineExample();
            TbCarBrandLineExample.Criteria criteria = example.createCriteria();
            criteria.andDelflagEqualTo(0);
            criteria.andBrandIdEqualTo(brand.getId());
            List<TbCarBrandLine> list2 = tbCarBrandLineMapper.selectByExample(example);
            //写入缓存
            try {
                String jsonStr = JsonUtils.objectToJson(list2);
                jedisClient.hset(CAR_SERIES,brand.getId()+"", jsonStr);
            } catch (Exception e) {
                e.printStackTrace();
                return OperateEnum.FAILE;
            }
        }

       /* //写入热门车型
        PageHelper.startPage(1,10);
        TbCarBrandLineExample example = new TbCarBrandLineExample();
        TbCarBrandLineExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("line_sequence ASC");
        List<TbCarBrandLine> listHot = tbCarBrandLineMapper.selectByExample(example);
        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(listHot);
            jedisClient.hset(CAR_SERIES,"hot", jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
            return OperateEnum.FAILE;
        }*/
        return OperateEnum.SUCCESS;
    }
}
