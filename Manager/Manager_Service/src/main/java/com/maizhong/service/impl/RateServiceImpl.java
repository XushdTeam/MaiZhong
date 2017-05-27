package com.maizhong.service.impl;

import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.mapper.RateMapper;
import com.maizhong.pojo.Rate;
import com.maizhong.pojo.RateExample;
import com.maizhong.pojo.TbDictionary;
import com.maizhong.service.RateConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Xushd on 2017/5/24.
 */
@Service
public class RateServiceImpl implements RateConService {


    @Autowired
    private RateMapper rateMapper;


    @Override
    public List<Rate> getRateList(List<TbDictionary> dicListByParent) {

        List<Rate> list = new ArrayList<>();
        RateExample example = new RateExample();
        for (TbDictionary tbDictionary : dicListByParent) {
            example.clear();
            RateExample.Criteria criteria = example.createCriteria();
            criteria.andRateIdEqualTo(tbDictionary.getId());
            List<Rate> rateList = rateMapper.selectByExample(example);
            if(rateList.size()==0){
                Rate rate = new Rate();
                rate.setRateId(tbDictionary.getId());
                rate.setRate(0.00F);
                rate.setUpdateTime(new Date());
                rate.setUpdateUser("admin");
                rateMapper.insertSelective(rate);
                rate.setRateName(tbDictionary.getDicName());
                list.add(rate);
            }else{
                Rate rate = rateList.get(0);
                rate.setRateName(tbDictionary.getDicName());
                list.add(rate);
            }

        }
        return list;
    }

    @Override
    public JsonResult updateRate(Integer id, float rate,String userName) {

        Rate rateB = new Rate();
        rateB.setId(id);
        rateB.setUpdateTime(new Date());
        rateB.setUpdateUser(userName);
        rateB.setRate(rate);

        int i = rateMapper.updateByPrimaryKeySelective(rateB);
        if(i>0){
            return JsonResult.OK();
        }else {
            return JsonResult.build(OperateEnum.FAILE);
        }


    }
}
