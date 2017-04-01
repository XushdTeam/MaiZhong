package com.maizhong.bRest.service.impl;

import com.maizhong.bRest.service.CarService;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.pojo.TbCar;

import java.util.List;

import com.maizhong.pojo.TbCarBrand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/28.
 */
@Service
public class CarServiceImpl implements CarService {

    @Resource
    private JedisClient jedisClient;

    @Value("BUSSINESSUSER_PREFIX")
    private String BUSSINESSUSER_PREFIX;
    @Value("${CARBYBUID_URL}")
    private String CARBYBUID_URL;
    @Value("${BRAND_URL}")
    private String BRAND_URL;
    @Value("${SERIES_BRAND_URL}")
    private String SERIES_BRAND_URL;
    @Value("${CARTYPE_SERIES_CARYEAR_URL}")
    private String CARTYPE_SERIES_CARYEAR_URL;
    @Value("${CAR_MODIFY_URL}")
    private String CAR_MODIFY_URL;
    @Value("${CAR_INFO_URL}")
    private String CAR_INFO_URL;
    @Value("${CAR_DELETE_URL}")
    private String CAR_DELETE_URL;

    //REST服务器地址
    @Value("${BASE_URL}")
    private String BASE_URL;
    //汽车列表地址
    @Value("${CAR_LIST_URL}")
    private String CAR_LIST_URL;
    //汽车详情
    @Value("${CAR_DETAIL}")
    private String CAR_DETAIL;
    //车系录入
    @Value("${CAR_SERISE_ADD}")
    private String CAR_SERISE_ADD;



    //缓存数据需要手动同步
    @Override
    public List<Map<String, Object>> syncDataToRedis(Long businessId) {
        if (businessId != null) {

            try {
                String jsonResult = HttpClientUtil.doGet(CARBYBUID_URL + "/" + businessId);

                if (StringUtils.isNotBlank(jsonResult)) {
                    JsonResult result = JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
                    if (result.getStatus() == 200) {
                        List<Map<String, Object>> list = (List<Map<String, Object>>) result.getData();

                        if (list != null && list.size() > 0) {
                            //redis 模拟缓存 添加到缓存命中
                            String jsonInfo = JsonUtils.objectToJson(list);

                            if (StringUtils.isNotBlank(jsonInfo)) {
                                jedisClient.set(BUSSINESSUSER_PREFIX + ":car:" + businessId, jsonInfo);
                            }
                        } else {
                            jedisClient.set(BUSSINESSUSER_PREFIX + ":car:" + businessId, "");
                        }
                        jedisClient.expire(BUSSINESSUSER_PREFIX + ":car:" + businessId, 7200);
                        return list;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public JsonResult findList(TbCar tbCar) {

        try {
            String jsonResult = HttpClientUtil.doGet(BASE_URL+CAR_LIST_URL + "/" + tbCar.getBusinessId());

            if (StringUtils.isNotBlank(jsonResult)) {
                JsonResult result = JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
                if (result.getStatus() == 200) {
                    return result;
                }else {
                    return JsonResult.Error("服务器繁忙");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JsonResult.Error("数据操作");

    }


    //------------------------------------------------------------------//
    /**
     * 获取汽车品牌
     *
     * @return
     */
    @Override
    public JsonResult getBrand() {
        String jsonResult = null;
        try {
            jsonResult = HttpClientUtil.doGet(BRAND_URL);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error("网络错误，请刷新后重试！");
        }
        return JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
    }

    /**
     * 获取车系
     *
     * @param brandId
     * @return
     */
    @Override
    public JsonResult getSeriesByBrand(String brandId) {
        String jsonResult = null;
        try {
            jsonResult = HttpClientUtil.doGet(SERIES_BRAND_URL + "/" + brandId);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error("网络错误，请刷新后重试！");
        }
        return JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
    }

    /**
     * 获取车型
     *
     * @param seriesId
     * @param caryear
     * @return
     */
    @Override
    public JsonResult getCarTypeBySeries(String seriesId, String caryear) {
        if (StringUtils.isBlank(caryear)) {
            caryear = "0";
        }
        String jsonResult = null;
        try {
            jsonResult = HttpClientUtil.doGet(CARTYPE_SERIES_CARYEAR_URL + "/" + seriesId + "/" + caryear);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error("网络错误，请刷新后重试！");
        }
        return JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
    }

    @Override
    public JsonResult getCarById(String carid) {
        String jsonResult= null;
        try {
            jsonResult = HttpClientUtil.doGet(CAR_INFO_URL+"/"+carid);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error("网络错误，请刷新后重试！");
        }
        return JsonUtils.jsonToPojo(jsonResult,JsonResult.class);
    }

    @Override
    public JsonResult deleteCar(String carid) {
        String jsonResult= null;
        try {
            jsonResult = HttpClientUtil.doGet(CAR_DELETE_URL+"/"+carid);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error("网络错误，请刷新后重试！");
        }
        return JsonUtils.jsonToPojo(jsonResult,JsonResult.class);
    }

    @Override
    public JsonResult modifyCar(String id, String baseId, String carBrand, String carBrandLine, String sellpoint, String sellPrice, String stockNum,
                                String image, String smimage, String businessId,String carYear) {

        HashMap<String, String> map = new HashMap<>();
        map.put("id",id);
        map.put("baseId",baseId);
        map.put("carBrand",carBrand);
        map.put("carBrandLine",carBrandLine);
        map.put("sellpoint",sellpoint);
        map.put("sellPrice",sellPrice);
        map.put("stockNum",stockNum);
        map.put("image",image);
        map.put("smimage",smimage);
        map.put("businessId",businessId);
        map.put("carYear",carYear);
        String jsonResult = null;
        try {
            jsonResult = HttpClientUtil.doPost(CAR_MODIFY_URL, map);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error("网络错误，请刷新后重试！");
        }
        return JsonUtils.jsonToPojo(jsonResult, JsonResult.class);

    }

    @Override
    public JsonResult findList(String businessId, String brandId, String carSeries, String date,
                               String carYear, Integer currentPage, String sortString) {
        try {

            Map<String,String> params = new HashMap<>();
            if(StringUtils.isNotBlank(brandId)){
                params.put("brandId",brandId);
            }
            if(StringUtils.isNotBlank(carSeries)){
                params.put("carSeries",carSeries);
            }
            if(StringUtils.isNotBlank(date)){
                params.put("date",date);
            }
            if(StringUtils.isNotBlank(carYear)){
                params.put("carYear",carYear);
            }
            params.put("currentPage",currentPage+"");
            if(StringUtils.isNotBlank(sortString)){
                params.put("sortString",sortString);
            }
            String jsonResult = HttpClientUtil.doGet(BASE_URL+CAR_LIST_URL+"?businessId="+businessId,params);

            if(StringUtils.isNotBlank(jsonResult)){
                return JsonUtils.jsonToPojo(jsonResult,JsonResult.class);
            }else {
                return JsonResult.Error(OperateEnum.FAILE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.FAILE);
        }
    }

    @Override
    public JsonResult getCarDetail(String carId) {
        String res = HttpClientUtil.doGet(BASE_URL+CAR_DETAIL+carId);
        if(StringUtils.isNotBlank(res)){
            return JsonUtils.jsonToPojo(res,JsonResult.class);
        }else{
            return JsonResult.Error(OperateEnum.FAILE);
        }
    }

    @Override
    public JsonResult saveSerise(String brandId, String seriseName) {

        Map<String,String> params = new HashMap<>();
        params.put("",brandId);
        params.put("",seriseName);

        String res = HttpClientUtil.doPost(BASE_URL+CAR_SERISE_ADD,params);
        if(StringUtils.isNotBlank(res)){
            return JsonUtils.jsonToPojo(res,JsonResult.class);
        } else {
            return JsonResult.Error(OperateEnum.FAILE);
        }
    }


}