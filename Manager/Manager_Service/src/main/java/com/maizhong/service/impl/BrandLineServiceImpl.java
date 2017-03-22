package com.maizhong.service.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.mapper.TbCarBrandLineMapper;
import com.maizhong.pojo.TbCarBrand;
import com.maizhong.pojo.TbCarBrandLine;
import com.maizhong.pojo.TbCarBrandLineExample;
import com.maizhong.service.BrandLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by YangF on 2017/3/16.
 */
@Service
public class BrandLineServiceImpl implements BrandLineService {


    @Resource
    private TbCarBrandLineMapper tbCarBrandLineMapper;


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
        tbCarBrandLineMapper.deleteByPrimaryKey(id);
        return JsonResult.OK("修改成功");
    }
}
