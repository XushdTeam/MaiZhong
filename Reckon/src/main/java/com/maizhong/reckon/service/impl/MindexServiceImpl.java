package com.maizhong.reckon.service.impl;

import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.reckon.service.MindexService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Xushd on 2017/6/1.
 */
@Service
public class MindexServiceImpl implements MindexService {


    @Value("${WAP_URL}")
    private String WAP_URL;
    @Value("${REST_URL}")
    private String REST_URL;


    @Override
    public JsonResult getSeriesByBrand(String brandId) {

        try {
            String res = HttpClientUtil.doGet(WAP_URL + "getSeriesByBrand/" + brandId);
            return JsonUtils.jsonToPojo(res, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult getModelBySeries(String seriesId) {
        try {
            String res = HttpClientUtil.doGet(WAP_URL + "getModelBySeries/" + seriesId);
            return JsonUtils.jsonToPojo(res, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(OperateEnum.SERVER_ERROR);

    }

    /**
     * 通过modelId获取model信息
     * @param modelId
     * @return
     */
    @Override
    public Object getModelById(String modelId) {
        try {
            String res = HttpClientUtil.doGet(WAP_URL + "getModelById/" + modelId);
            JsonResult result = JsonUtils.jsonToPojo(res, JsonResult.class);
            return result.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object getGuzhi(String param) {
        try {
            String res = HttpClientUtil.doGet(WAP_URL+"guzhi/"+param);
            JsonResult result = JsonUtils.jsonToPojo(res, JsonResult.class);
            return result.getData();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;



    }

    @Override
    public JsonResult getAgreement() {

        try {

            String res = HttpClientUtil.doGet(WAP_URL+"getOrderAgreement");
            return JsonUtils.jsonToPojo(res,JsonResult.class);

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Object getMyorderList(String phone) {

        try {

            String res = HttpClientUtil.doGet(REST_URL+"getOrdersByPhone/"+phone);
            JsonResult result = JsonUtils.jsonToPojo(res, JsonResult.class);
            return result.getData();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;



    }

    @Override
    public Object getSaleGZByOrder(String orderNum) {

        try {
            String res = HttpClientUtil.doGet(WAP_URL+"getSaleGZByOrder/"+orderNum);
            JsonResult result = JsonUtils.jsonToPojo(res,JsonResult.class);
            return result.getData();
        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public Object getHelpContent() {
        try {
            String res = HttpClientUtil.doGet(WAP_URL+"getHelpTitle");
            JsonResult result = JsonUtils.jsonToPojo(res,JsonResult.class);
            return result.getData();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object getHelpDetail(String itemId) {

        try{

            String res = HttpClientUtil.doGet(WAP_URL+"getHelpContent/"+itemId);
            JsonResult result = JsonUtils.jsonToPojo(res,JsonResult.class);
            return result.getData();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
