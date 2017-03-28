package com.maizhong.portal.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
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
import org.springframework.ui.Model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

    @Value("${SEARCH_BASE}")
    private String SEARCH_BASE;

    @Value("${SEARCH_SOLR}")
    private String SEARCH_SOLR;

    @Override
    public SearchResult search(PageSearchParam pageSearchParam) {
        return null;
    }

    /**
     * 查询基础信息
     * @return
     */
    @Override
    public Map<String, Object> getSearchResult(String bId, String sId, String pId, String vId) {

        /*//STEP1 获取查询 基本数据
        Map<String,String> param = Maps.newHashMap();
        param.put("brandId",bId);
        param.put("seriesId",sId);

        String res1 = HttpClientUtil.doGet(REST_URL+SEARCH_BASE,param);
        JsonResult jsonResult = JsonUtils.jsonToPojo(res1,JsonResult.class);
        if(jsonResult.getStatus()==200){
            return (Map<String, Object>) jsonResult.getData();

        }
        //STEP2 sole 查询
        param = Maps.newHashMap();
        param.put("queryString","");
        param.put("sortString","");
        param.put("carBrand","");
        param.put("carSeries","");
        param.put("sellPrice","");
        param.put("capacity","");
        param.put("carYear","");
        param.put("pageIndex","");*/



        return null;
    }

    @Override
    public Model getSearchResult(Map<String, String> param,Model model) {

        String brandId = param.get("b"),
                seriseId = param.get("se"),
                price = param.get("p"),
                volume =param.get("v"),
                sort = param.get("s"),
                method = param.get("m"),
                page = param.get("pe"),
                qs = param.get("qs");
        //STEP1 获取查询 基本数据
        Map<String,String> param1 = Maps.newHashMap();
        param1.put("brandId",param.get("b"));
        param1.put("seriesId",param.get("se"));
        String res1 = HttpClientUtil.doGet(REST_URL+SEARCH_BASE,param1);
        JsonResult jsonResult1 = JsonUtils.jsonToPojo(res1,JsonResult.class);
        if(jsonResult1.getStatus()==200){
            Map<String, Object> map = (Map<String, Object>) jsonResult1.getData();
            model.addAttribute("bHot",map.get("carBrandhot"));
            model.addAttribute("bOut",map.get("brandHot"));
            model.addAttribute("bAll",map.get("carBrandAll"));
            model.addAttribute("bN",map.get("brandName"));
            List<Object> list = (List<Object>) map.get("carSeriesAll");
            model.addAttribute("sAll",map.get("carSeriesAll"));
            model.addAttribute("sL",list.size());
            model.addAttribute("sN",map.get("seriesName"));
            model.addAttribute("bId",brandId);
            model.addAttribute("sId",seriseId);
            model.addAttribute("pId",price);
            if(!StringUtils.equals("0",price)){
                if(price.equals("0-5")){
                    model.addAttribute("pN","5万以下");
                }else if(price.equals("50-")){
                    model.addAttribute("pN","50万以上");
                }else{
                    if(!price.equals("5-10")&&!price.equals("10-15")&&!price.equals("15-20")&&!price.equals("20-30")&&!price.equals("30-50")){
                        model.addAttribute("ps",StringUtils.split(price,"-")[0]);
                        try {
                            model.addAttribute("pe",StringUtils.split(price,"-")[1]);
                            if(StringUtils.split(price,"-")[0].equals("0")){
                                model.addAttribute("pN",StringUtils.split(price,"-")[1]+"万以下");
                            }else{
                                model.addAttribute("pN",price+"万");
                            }
                        }catch (Exception e){
                            model.addAttribute("pe","");
                            model.addAttribute("pN",StringUtils.split(price,"-")[0]+"万以上");
                        }
                    }else{
                        model.addAttribute("pN",price+"万");
                    }
                }
            }
            model.addAttribute("vId",volume);
            if(!StringUtils.equals("0",volume)){
                if(volume.equals("0-1.0")){
                    model.addAttribute("vN","1.0L以下");
                }else if(volume.equals("4.0-")){
                    model.addAttribute("vN","4.0L以上");
                }else{
                    model.addAttribute("vN",volume+"L");
                }
            }
        }
        //STEP2 获取solr查询结果
        Map<String,String> param2 = Maps.newHashMap();
        if(StringUtils.isNotBlank(qs)){
            param2.put("queryString",qs);
        }else {
            if(sort.equals("d")){
                param2.put("sortString","");
            }else if(sort.equals("h")){
                if(method.equals("1")){
                    param2.put("sortString","car_weight-asc");
                }else{
                    param2.put("sortString","car_weight-des");
                }
            }else if(sort.equals("p")){
                if(method.equals("1")){
                    param2.put("sortString","car_sellPrice-asc");
                }else{
                    param2.put("sortString","car_sellPrice-des");
                }
            }else{
                if(method.equals("1")){
                    param2.put("sortString","car_year-asc");
                }else{
                    param2.put("sortString","car_year-des");
                }
            }
            if(!brandId.equals("0")){
                param2.put("carBrand",brandId);
            }
            if(!seriseId.equals("0")){
                param2.put("carSeries",seriseId);
            }
            if(!price.equals("0")){
                param2.put("sellPrice",price);
            }
            if(!volume.equals("0")){
                param2.put("capacity",volume);
            }
        }
        param2.put("pageIndex",page==null?"1":page);
        String res2 = HttpClientUtil.doGet(REST_URL+SEARCH_SOLR,param2);
        JsonResult result2 = JsonUtils.jsonToPojo(res2,JsonResult.class);
        if(result2.getStatus()==200){
            Map<String,Object> map2 = (Map<String, Object>) result2.getData();

            model.addAttribute("total",map2.get("totalCount"));
            model.addAttribute("carList",map2.get("rows"));
            model.addAttribute("cur",map2.get("currentPage"));
            model.addAttribute("tp",map2.get("totalPage"));

        }
        model.addAttribute("sort",sort);
        if(method.equals("1")){
            model.addAttribute("method","2");
        }else{
            model.addAttribute("method","1");
        }
        model.addAttribute("queryStr",qs);
        return model;
    }
}

