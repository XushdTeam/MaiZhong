package com.maizhong.service.impl;

import com.maizhong.common.result.JsonResult;
import com.maizhong.common.target.ServiceLog;
import com.maizhong.mapper.TbCarMapper;
import com.maizhong.mapper.TbCarPropMapper;
import com.maizhong.pojo.TbCar;
import com.maizhong.pojo.TbCarProp;
import com.maizhong.pojo.TbCarPropExample;
import com.maizhong.service.CarPropService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 属性业务实现类
 *
 * Created by yangF on 2017/3/9.
 */
@Service
public class CarPropServiceImpl implements CarPropService {

    @Resource
    private TbCarPropMapper tbCarPropMapper;

    @Resource
    private TbCarMapper tbCarMapper;


    /**
     * 根据汽车id返回 汽车属性数据
     * */
    @Override
    public TbCarProp findPropByCarId(Long id) {

        TbCarPropExample example = new TbCarPropExample();

        TbCarPropExample.Criteria criteria = example.createCriteria();

        criteria.andCarIdEqualTo(id);

        List<TbCarProp> list = tbCarPropMapper.selectByExample(example);

        if (list!=null&&list.size()==1){
            return list.get(0);
        }
        return null;
    }

    /**
     * 插入汽车属性
     * */
    @ServiceLog(module = "汽车属性管理",methods = "汽车属性添加")
    @Override
    public JsonResult insertCarProp(TbCarProp tbCarProp) {
        if (tbCarProp.getCarId()!=null){
            //确认汽车数据是否在
            TbCar tbCar = tbCarMapper.selectByPrimaryKey(tbCarProp.getId());
            if (tbCar==null){
                return JsonResult.Error("属性所添加的汽车不存在 请确认数据");
            }

            //属性填充
            tbCarProp.setCreateTime(new Date());
            tbCarProp.setUpdateTime(new Date());

            if (tbCarProp.getUnable()==null|| StringUtils.isBlank(tbCarProp.getUnable()+"")){
                tbCarProp.setUnable(1);
            }

            int i = tbCarPropMapper.insertSelective(tbCarProp);
            if (i==1){
                return JsonResult.OK("属性添加成功");
            }
        }
        return JsonResult.Error("属性添加失败");
    }

    @ServiceLog(module = "汽车属性管理",methods = "汽车属性修改")
    @Override
    public JsonResult updateCarProp(TbCarProp tbCarProp) {
        if (tbCarProp.getCarId()!=null||tbCarProp.getId()!=null){
            //确认汽车数据是否在
            TbCar tbCar = tbCarMapper.selectByPrimaryKey(tbCarProp.getId());
            if (tbCar==null){
                return JsonResult.Error("所修改的汽车不存在 请确认数据");
            }

            //属性填充
            tbCarProp.setUpdateTime(new Date());

            if (tbCarProp.getUnable()==null|| StringUtils.isBlank(tbCarProp.getUnable()+"")){
                tbCarProp.setUnable(1);
            }

            int i = tbCarPropMapper.updateByPrimaryKeySelective(tbCarProp);

            if (i==1){
                return JsonResult.OK("属性修改成功");
            }
        }
        return JsonResult.Error("属性修改失败");
    }


    @ServiceLog(module = "汽车属性管理",methods = "汽车属性删除")
    @Override
    public JsonResult deleteCarPropByCarId(Long id) {
        if (id==null){
            return JsonResult.Error("传参错误");
        }



        TbCarPropExample example = new TbCarPropExample();
        example.createCriteria().andCarIdEqualTo(id);

        List<TbCarProp> list = tbCarPropMapper.selectByExample(example);
        if (list!=null&&list.size()>0){
            int i = tbCarPropMapper.deleteByExample(example);
            if (i==1){
                return JsonResult.OK("删除成功");
            }
        }

        return JsonResult.Error("删除失败");
    }
}
