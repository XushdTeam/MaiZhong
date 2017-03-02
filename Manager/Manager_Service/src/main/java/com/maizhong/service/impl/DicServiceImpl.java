package com.maizhong.service.impl;

import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.target.ServiceLog;
import com.maizhong.mapper.TbDictionaryMapper;
import com.maizhong.pojo.TbDictionary;
import com.maizhong.pojo.TbDictionaryExample;
import com.maizhong.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典接口实现
 * Created by Xushd on 2017/3/2.
 */
@Service
public class DicServiceImpl implements DicService {

    @Autowired
    private TbDictionaryMapper tbDictionaryMapper;


    @ServiceLog(module = "字典管理",methods = "字典列表")
    @Override
    public List<TbDictionary> getDicList(Boolean isParent) {
        TbDictionaryExample example = new TbDictionaryExample();
        TbDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0).andParentEqualTo(0L);
        List<TbDictionary> dictionaryList = tbDictionaryMapper.selectByExample(example);
        if (isParent){
            return dictionaryList;
        }else{
            List<TbDictionary> result = new ArrayList<>();
            for (TbDictionary dictionary : dictionaryList) {
                result.add(dictionary);
                example.clear();
                criteria = example.createCriteria();
                criteria.andDelflagEqualTo(0).andParentEqualTo(dictionary.getId());
                result.addAll(tbDictionaryMapper.selectByExample(example));
            }
            return result;
        }
    }

    @Override
    public TbDictionary getDicById(Long id) {
        return tbDictionaryMapper.selectByPrimaryKey(id);
    }

    @ServiceLog(module = "字典管理",methods = "字典新增")
    @Override
    public OperateEnum insertDic(TbDictionary dictionary) {

        int res = tbDictionaryMapper.insertSelective(dictionary);
        if(res>0){
            return OperateEnum.SUCCESS;
        }else {
            return OperateEnum.FAILE;
        }
    }

    @ServiceLog(module = "字典管理",methods = "字典修改")
    @Override
    public OperateEnum updateDic(TbDictionary dictionary) {
        int res = tbDictionaryMapper.updateByPrimaryKeySelective(dictionary);
        if(res>0){
            return OperateEnum.SUCCESS;
        }else {
            return OperateEnum.FAILE;
        }
    }

    @ServiceLog(module = "字典管理",methods = "字典删除")
    @Override
    public OperateEnum deleteDic(long id) {
        //逻辑删除
        TbDictionary dictionary = new TbDictionary();
        dictionary.setDelflag(1);
        dictionary.setStatus(null);
        dictionary.setId(id);
        //criteria.
        int res =  tbDictionaryMapper.updateByPrimaryKeySelective(dictionary);
        if(res>0){
            return OperateEnum.SUCCESS;
        }else {
            return OperateEnum.FAILE;
        }
    }


    @Override
    public List<TbDictionary> getDicListByParent(long parent) {
        TbDictionaryExample example = new TbDictionaryExample();
        TbDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andParentEqualTo(parent).andDelflagEqualTo(0).andStatusEqualTo(1);
        return tbDictionaryMapper.selectByExample(example);
    }
}
