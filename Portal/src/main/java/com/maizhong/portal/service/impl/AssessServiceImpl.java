package com.maizhong.portal.service.impl;

import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.EscapeUtils;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.portal.service.AssessService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangF  on 2017/4/10.
 */
@Service
public class AssessServiceImpl implements AssessService {

    @Value("${REST_URL}")
    private String REST_URL;

    @Value("${ASSESS_BRAND}")
    private String ASSESS_BRAND;

    @Value("${ASSESS_SERIES}")
    private String ASSESS_SERIES;

    @Value("${ASSESS_CARSPEC}")
    private String ASSESS_CARSPEC;

    @Value("${ASSESS_BUYDATE}")
    private String ASSESS_BUYDATE;

    @Value("${ASSESS_ASSESS}")
    private String ASSESS_ASSESS;


    @Override
    public JsonResult getCarBuyDateAndmileage(Long carId) {
        if (carId==null||carId==0){
            return JsonResult.Error("数据错误");
        }
        JsonResult result = null;
        try {
            String res = HttpClientUtil.doGet(REST_URL+ASSESS_BUYDATE+carId);
            result = JsonUtils.jsonToPojo(res,JsonResult.class);
        }catch (Exception e){
            result = JsonResult.Error("系统繁忙，请稍候再试");
        }
        return result;
    }

    @Override
    public JsonResult getCarBrand() {
        JsonResult result = null;
        try {
            String res = HttpClientUtil.doGet(REST_URL+ASSESS_BRAND);
            result = JsonUtils.jsonToPojo(res,JsonResult.class);
        }catch (Exception e){
            result = JsonResult.Error("系统繁忙，请稍候再试");
        }
        return result;
    }

    @Override
    public JsonResult getCarSeries(Long brandId) {
        if (brandId==null||brandId==0){
            return JsonResult.Error("数据错误");
        }
        JsonResult result = null;
        try {
            String res = HttpClientUtil.doGet(REST_URL+ASSESS_SERIES+brandId);
            result = JsonUtils.jsonToPojo(res,JsonResult.class);
        }catch (Exception e){
            result = JsonResult.Error("系统繁忙，请稍候再试");
        }
        return result;
    }

    @Override
    public JsonResult getCarType(Long seriesId) {
        if (seriesId==null||seriesId==0){
            return JsonResult.Error("数据错误");
        }
        JsonResult result = null;
        try {
            String res = HttpClientUtil.doGet(REST_URL+ASSESS_CARSPEC+seriesId);
            result = JsonUtils.jsonToPojo(res,JsonResult.class);
        }catch (Exception e){
            result = JsonResult.Error("系统繁忙，请稍候再试");
        }
        return result;
    }

    @Override
    public JsonResult calculatePrice(String bid, String sid, String specId, String registerYear, String registerMonth, String selectCarName) {
        JsonResult result = null;
        try {
            HashMap<String, String> param = new HashMap<>();
            if (StringUtils.isBlank(bid)||StringUtils.isBlank(sid) ||StringUtils.isBlank(specId)||StringUtils.isBlank(registerYear)||StringUtils.isBlank(selectCarName)){
                return JsonResult.Error("数据错误，请检查数据");
            }
            param.put("bid",bid);
            param.put("sid",sid);
            param.put("specId",specId);
            param.put("registerYear",registerYear);
            param.put("registerMonth",registerMonth);

            param.put("selectCarName", EscapeUtils.escape(selectCarName));

            String res = HttpClientUtil.doGet(REST_URL+ASSESS_ASSESS,param);
            result = JsonUtils.jsonToPojo(res,JsonResult.class);
        }catch (Exception e){
            result = JsonResult.Error("系统繁忙，请稍候再试");
        }
        return result;
    }
}
