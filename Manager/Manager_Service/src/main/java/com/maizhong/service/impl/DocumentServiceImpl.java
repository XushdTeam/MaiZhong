package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.mapper.DocumentMapper;
import com.maizhong.pojo.Document;
import com.maizhong.pojo.DocumentExample;
import com.maizhong.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xushd on 2017/5/22.
 */
@Service
public class DocumentServiceImpl implements DocumentService {


    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public PageResult getDocList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        DocumentExample example = new DocumentExample();
        DocumentExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        if (param.getFiled("title") != null) {
            criteria.andTitleLike(SqlUtils.getLikeSql(param.getFiled("title")));
        }
        if (param.getFiled("author") != null) {
            criteria.andAuthorLike(SqlUtils.getLikeSql(param.getFiled("author")));
        }
        example.setOrderByClause("id ASC");
        List<Document> list = documentMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        return new PageResult(pageInfo);
    }

    @Override
    public Document getDocById(long id) {
        return documentMapper.selectByPrimaryKey(id);
    }

    @Override
    public JsonResult insertDoc(Document doc) {

        int i = documentMapper.insertSelective(doc);
        if(i>0){
            return JsonResult.build(OperateEnum.SUCCESS);
        }else{
            return JsonResult.build(OperateEnum.FAILE);
        }
    }

    @Override
    public JsonResult update(Document doc) {

        int i = documentMapper.updateByPrimaryKeySelective(doc);
        if(i>0){
            return JsonResult.build(OperateEnum.SUCCESS);
        }else{
            return JsonResult.build(OperateEnum.FAILE);
        }
    }

    @Override
    public JsonResult deleteById(String id) {

        Document document = new Document();
        document.setId(Long.valueOf(id));
        document.setDelflag(1);
        int i = documentMapper.updateByPrimaryKeySelective(document);
        if(i>0){
            return JsonResult.build(OperateEnum.SUCCESS);
        }else{
            return JsonResult.build(OperateEnum.FAILE);
        }
    }
}
