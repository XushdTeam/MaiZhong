package com.maizhong.portal.service.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.pojo.TbCar;
import com.maizhong.pojo.vo.SearchResult;
import com.maizhong.pojo.vo.TbCarVo;
import com.maizhong.portal.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangF on 2017/3/16.
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Value("${REST_URL}")
    private String REST_URL;

    @Value("${CAR_SEARCH}")
    private String CAR_SEARCH;

    @Value("${CAR_BRAND_LINE}")
    private String CAR_BRAND_LINE;

    @Value("${CAR_BRAND}")
    private String CAR_BRAND;

    @Value("${CAR_DIC}")
    private String CAR_DIC;

    @Value("${CAR_TYPE}")
    private String CAR_TYPE;





    /**
     * 查询方法
     *      根据参数返回数据
     *          此方法主要用于数据准备
     *                 数据来源于Rest服务  主要为rest服务和页面提供参数以及数据
     * @param pageSearchParam
     * @return
     */
    @Override
    public Map<String, Object> search(PageSearchParam pageSearchParam) {
        //查询条件准备
        Map<String,String> param =new HashMap();
        //总结果集数据
        Map<String,Object> results = new HashMap();
        //获取查询条件
        if (pageSearchParam!=null&&pageSearchParam.getSearchFileds()!=null){
            //参数获取
               //如果查询参数 不为空
            //好麻烦。。。
            for (Map.Entry<String,String> entry: pageSearchParam.getSearchFileds().entrySet()) {
                param.put("searchFileds["+entry.getKey()+"]",entry.getValue());
            }
            results.put("conditions",pageSearchParam.getSearchFileds());
        }

        //起始页
//        param.put("pageIndex",pageSearchParam.getPageIndex()+"");


        //调用服务层服务
//        conditions  条件
        String jsonResult = HttpClientUtil.doPost(REST_URL + CAR_SEARCH,param);
        SearchResult result = null;
        try {
            if (StringUtils.isNotBlank(jsonResult)){
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(jsonResult);
                JsonNode data = jsonNode.get("data");
                result = mapper.treeToValue(data, SearchResult.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BeanUtils.copyProperties(result,results);

        return results;
    }
}

