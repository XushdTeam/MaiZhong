package com.maizhong.reckon.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.dto.GuzhiDTO;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.pojo.Line;
import com.maizhong.reckon.DTO.IndexDTO;
import com.maizhong.reckon.service.IndexService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


            indexDTO.setCityId("1");
            indexDTO.setModelId("0");
            indexDTO.setProvice("1");
            indexDTO.setYear("0");
            indexDTO.setMouth("0");
            indexDTO.setBrandId("0");
            indexDTO.setSeriesId("0");
            indexDTO.setCity("北京");
            indexDTO.setModelName("请 选 择 车 型");
            indexDTO.setRegdate("首 次 上 牌 时 间");

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
        return  JSON.parseObject(data.toJSONString(),GuzhiDTO.class);

    }

    @Override
    public IndexDTO getIndexDTO(String param) {

        String res = HttpClientUtil.doGet(RESTURL+"GetBrandList");
        JSONObject object = JSON.parseObject(res);
        IndexDTO indexDTO = new IndexDTO();
        indexDTO.setBrandList(object.getJSONArray("data"));
        res = HttpClientUtil.doGet(RESTURL+"getProvice");
        object = JSON.parseObject(res);
        indexDTO.setProviceList(object.getJSONArray("data"));

        res = HttpClientUtil.doGet(RESTURL+"guzhi/"+param);
        object = JSON.parseObject(res);
        JSONObject data = object.getJSONObject("data");
        GuzhiDTO guzhiDTO = JSON.parseObject(data.toJSONString(), GuzhiDTO.class);

        String[] paramArry = param.split("c|m|r|g");

        indexDTO.setCity(guzhiDTO.getCity());
        indexDTO.setCityId(paramArry[1]);
        indexDTO.setRegdate(guzhiDTO.getRegdate());
        indexDTO.setModelName(guzhiDTO.getModelName());
        indexDTO.setModelId(paramArry[2]);
        indexDTO.setMail(paramArry[4]);
        indexDTO.setProvice(paramArry[0]);
        indexDTO.setYear(paramArry[3].split("-")[0]);
        indexDTO.setMouth(paramArry[3].split("-")[1]);
        indexDTO.setBrandId(guzhiDTO.getBrandId());
        indexDTO.setSeriesId(guzhiDTO.getSeriesId());

        indexDTO.setMaxYear(guzhiDTO.getMaxYear());
        indexDTO.setMinYear(guzhiDTO.getMinYear());

        return indexDTO;
    }

    @Override
    public String saleguzhi(String guzhiKey, String otherKey, Long phone) {

        try {
            String res = HttpClientUtil.doGet(RESTURL+"getSaleGZ/"+guzhiKey+"/"+otherKey+"/"+phone);
            return JsonUtils.jsonToPojo(res,JsonResult.class).getData().toString();
        }catch (Exception e){

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GuzhiDTO getYuyueInfo(String phone) {

        try {
            String res = HttpClientUtil.doGet(RESTURL+"getGZDetail"+"/"+phone);
            JsonResult result = JsonUtils.jsonToPojo(res, JsonResult.class);
            return JsonUtils.jsonToPojo(JSON.toJSONString(result.getData()),GuzhiDTO.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Line> getLineList() {
        try {

            String res = HttpClientUtil.doGet(RESTURL+"getLines");
            JsonResult result = JsonUtils.jsonToPojo(res,JsonResult.class);
            return JsonUtils.jsonToList(JSON.toJSONString(result.getData()),Line.class);

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 通过线路获取地铁站信息
     * @param lineId
     * @return
     */
    @Override
    public JsonResult getSiteByLineId(String lineId) {

        try{
            String res = HttpClientUtil.doGet(RESTURL+"getSite/"+lineId);
            return JsonUtils.jsonToPojo(res,JsonResult.class);
        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public JsonResult getBusinessAddress() {
        String res = HttpClientUtil.doGet(RESTURL+"getBusinessAddress");
        JsonResult object = JsonUtils.jsonToPojo(res,JsonResult.class);
        return  object;
    }

    @Override
    public JsonResult getOneWeek() {
        String res = HttpClientUtil.doGet(RESTURL+"getOneWeek");
        JsonResult object = JsonUtils.jsonToPojo(res,JsonResult.class);
        return  object;
    }

    /**
     * 订单确认
     * @param orderNumber
     * @param dealWay
     * @param wayId
     * @param linkMan
     * @param linkPhone
     * @param address
     * @return
     */
    @Override
    public JsonResult orderConfim(String orderNumber, String dealWay, String wayId, String linkMan, String linkPhone,String checktime, String address) {

        try {
            Map<String,String> param = new HashMap<>();
            param.put("orderNumber",orderNumber);
            param.put("dealWay",dealWay);
            param.put("wayId",wayId);
            param.put("linkMan",linkMan);
            param.put("linkPhone",linkPhone);
            param.put("checktime",checktime);
            param.put("address",address);

            String res = HttpClientUtil.doPost(RESTURL+"updateOrders",param);
            return JsonResult.OK(JsonUtils.jsonToPojo(res,JsonResult.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
