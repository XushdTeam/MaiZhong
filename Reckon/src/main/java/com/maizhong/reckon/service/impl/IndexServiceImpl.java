package com.maizhong.reckon.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.reckon.DTO.GuzhiDTO;
import com.maizhong.reckon.DTO.IndexDTO;
import com.maizhong.reckon.service.IndexService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Xushd on 2017/4/18.
 */
@Service
public class IndexServiceImpl implements IndexService {


    @Value("${REST_URL}")
    private String RESTURL;


    @Override
    public IndexDTO getIndexDTO() {
        try{

            String res = HttpClientUtil.doGet(RESTURL+"GetBrandList");
            JSONObject object = JSON.parseObject(res);
            IndexDTO indexDTO = new IndexDTO();
            indexDTO.setBrandList(object.getJSONArray("data"));
            res = HttpClientUtil.doGet(RESTURL+"getProvice");
            object = JSON.parseObject(res);
            indexDTO.setProviceList(object.getJSONArray("data"));

            return indexDTO;

        }catch (Exception e){

            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过品牌获取车系
     * @param brandId
     * @return
     */
    @Override
    public JsonResult getSeries(String brandId) {

        try {

            String res = HttpClientUtil.doGet(RESTURL+"GetSeriesByBrandId/"+brandId);
            return JsonUtils.jsonToPojo(res,JsonResult.class);

        } catch (Exception e){

            e.printStackTrace();

        }
        return null;


    }

    /**
     * 获取车型
     * @param seriesId
     * @return
     */
    @Override
    public JsonResult getCarType(String seriesId) {

        try {

            String res = HttpClientUtil.doGet(RESTURL+"getCarType/"+seriesId);
            return JsonUtils.jsonToPojo(res,JsonResult.class);


        }catch (Exception e){

            e.printStackTrace();

        }

        return null;
    }

    @Override
    public JsonResult getAllCity() {
        try {

            String res = HttpClientUtil.doGet(RESTURL+"getCity/");
            return JsonUtils.jsonToPojo(res,JsonResult.class);


        }catch (Exception e){

            e.printStackTrace();

        }

        return null;

    }

    @Override
    public GuzhiDTO getGuZhi(String param) {


        String res = HttpClientUtil.doGet(RESTURL+"guzhi/"+param);

        JSONObject object = JSON.parseObject(res);
        JSONObject data = object.getJSONObject("data");

        GuzhiDTO guzhiDTO = new GuzhiDTO();

        guzhiDTO.setPriceA(data.getString("priceMinA")+"万~"+data.getString("priceMaxA")+"万");
        guzhiDTO.setPriceB(data.getString("priceMinB")+"万~"+data.getString("priceMaxB")+"万");
        guzhiDTO.setPriceC(data.getString("priceMinC")+"万~"+data.getString("priceMaxC")+"万");
        guzhiDTO.setPriceD(data.getString("priceMinD")+"万~"+data.getString("priceMaxD")+"万");



        return guzhiDTO;

    }
}
