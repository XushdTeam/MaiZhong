package com.maizhong.bRest.service.impl;

import com.maizhong.bRest.service.CarService;
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


    //条件查询  //buzuo le cao
    //参数无用
    @Override
    public JsonResult findList(TbCar tbCar) {
        //
        if (tbCar.getBusinessId() == null) {
            return JsonResult.Error("未登录账号");
        }

        try {
            String jsonResult = HttpClientUtil.doGet(CARBYBUID_URL + "/" + tbCar.getBusinessId());

            if (StringUtils.isNotBlank(jsonResult)) {
                JsonResult result = JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
                if (result.getStatus() == 200) {
                    return result;
//                    List<Map<String,Object>> list = (List<Map<String, Object>>) result.getData();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JsonResult.Error("数据操作");


//        String json = jedisClient.get(BUSSINESSUSER_PREFIX + ":car:" + tbCar.getBusinessId());
//        List<Map> list = null;
//        if (StringUtils.isNotBlank(json)){
//            list = JsonUtils.jsonToList(json, Map.class);
//            //TODO  条件筛选
//        }else{
////            list = this.syncDataToRedis(tbCar.getBusinessId());
//        }
//        return JsonResult.OK(list);
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
    public JsonResult modifyCar(TbCar tbCar) {
        HashMap<String, String> map = new HashMap<>();
        BeanUtils.copyProperties(tbCar, map);
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
}