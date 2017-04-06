package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.CarColumnJoinCar;
import com.maizhong.common.dto.KeyValue;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.DicParentEnum;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.DicRedisUtils;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.TbCarColumnMapper;
import com.maizhong.mapper.TbCarMapper;
import com.maizhong.pojo.TbCar;
import com.maizhong.pojo.TbCarColumn;
import com.maizhong.pojo.TbCarColumnExample;
import com.maizhong.service.CarColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-15
 * Time: 15:41
 */

@Controller
public class CarColumnServiceImpl implements CarColumnService {

    @Autowired
    private TbCarColumnMapper tbCarColumnMapper;


    @Autowired
    private TbCarMapper tbCarMapper;

    @Autowired
    private JedisClient jedisClient;


    @Value("${DIC_KEY}")
    private String DIC_KEY;
    @Value("${CM_CONTENT}")
    private String CM_CONTENT;

    @Override
    public PageResult getCarColumnList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        Long columnId=null;
        if (param.getFiled("columnId") != null) {
            columnId= Long.valueOf(param.getFiled("columnId"));
        }

        List<CarColumnJoinCar> list = tbCarColumnMapper.getListByColumn(null,columnId);
        String json= null;
        try {
            json = jedisClient.hget(DIC_KEY, DicParentEnum.CMID.getState()+"");
        } catch (Exception e) {
            e.printStackTrace();
            return new PageResult(null);
        }

        for (CarColumnJoinCar carColumnJoinCar : list) {
           carColumnJoinCar.setColumnName(DicRedisUtils.getDicFormRedisById(carColumnJoinCar.getColumnId()+"",json));
        }
        PageInfo pageInfo = new PageInfo(list);
        return new PageResult(pageInfo);
    }

    /**
     * 添加汽车栏目下的汽车
     * @param tbCarColumn
     * @return
     */
    @Override
    public OperateEnum insertCarColumn(TbCarColumn tbCarColumn) {
        TbCar tbCar = tbCarMapper.selectByPrimaryKey(tbCarColumn.getCarId());
        if (tbCar==null){
            return OperateEnum.NO_CAR;
        }

        TbCarColumnExample tbCarColumnExample= new TbCarColumnExample();
        TbCarColumnExample.Criteria criteria = tbCarColumnExample.createCriteria();
        criteria.andCarIdEqualTo(tbCarColumn.getCarId());
        List<TbCarColumn> list = tbCarColumnMapper.selectByExample(tbCarColumnExample);
        if (list.size() > 0){
            return OperateEnum.ADD_REPEAT;
        }

       List<CarColumnJoinCar>  listCount=tbCarColumnMapper.getListByColumn(null, Long.valueOf(tbCarColumn.getColumnId()));

        if (listCount!=null&&listCount.size()>=4){
            return OperateEnum.THAN_FOUR;
        }

        int res = tbCarColumnMapper.insertSelective(tbCarColumn);
        if (res > 0) {
            try {
                jedisClient.del(CM_CONTENT);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public List<KeyValue> getColumnList() {
        String json= null;
        try {
            json = jedisClient.hget(DIC_KEY, DicParentEnum.CMID.getState()+"");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        List<KeyValue> list= JsonUtils.jsonToList(json,KeyValue.class);
        return list;
    }
//删除栏目
    @Override
    public OperateEnum deleteColumnCarById(long id) {
        int ret = tbCarColumnMapper.deleteByPrimaryKey(id);
        if (ret > 0) {
            try {
                jedisClient.del(CM_CONTENT);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }
//更新栏目
    @Override
    public TbCarColumn getCarColumnByid(Long id) {
        TbCarColumnExample tbCarColumnExample = new TbCarColumnExample();
        TbCarColumnExample.Criteria criteria = tbCarColumnExample.createCriteria();
        criteria.andIdEqualTo(id).andDeflagEqualTo(0);
        List<TbCarColumn> list = tbCarColumnMapper.selectByExample(tbCarColumnExample);
        if (list == null || list.size() == 0) return null;
        return list.get(0);
    }

    @Override
    public OperateEnum updateCarColumn(TbCarColumn tbCarColumn) {
       int res= tbCarColumnMapper.updateByPrimaryKeySelective(tbCarColumn);
        if (res > 0) {
            try {
                jedisClient.del(CM_CONTENT);//可能修改类型，所以所有类型全部删除
            } catch (Exception e) {
                e.printStackTrace();
            }
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public JsonResult carColumnRedis() {
        try {
                jedisClient.del(CM_CONTENT);
            return JsonResult.build(OperateEnum.SUCCESS);

        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.build(OperateEnum.FAILE);
        }
    }
}
