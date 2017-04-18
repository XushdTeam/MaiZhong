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
import com.sun.xml.internal.rngom.parse.host.Base;
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
    //基础信息录入
    @Value("${CAR_BASEINFO_SAVE}")
    private String CAR_BASEINFO_SAVE;
    //首页统计数据
    @Value("${HOME_STATIC}")
    private String HOME_STATIC;
    //品牌获取厂商
    @Value("${FACTORY}")
    private String FACTORY;
    //车系
    @Value("${SERISE}")
    private String SERISE;
    //商户信息
    @Value("${BUSINESS_INFO}")
    private String BUSSINESSINFO;
    //修改密码
    @Value("${CHANGE_PASS}")
    private String CHANGE_PASS;


//
//    @Override
//    public JsonResult findList(TbCar tbCar) {
//
//        try {
//            String jsonResult = HttpClientUtil.doGet(BASE_URL + CAR_LIST_URL + "/" + tbCar.getBusinessId());
//
//            if (StringUtils.isNotBlank(jsonResult)) {
//                JsonResult result = JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
//                if (result.getStatus() == 200) {
//                    return result;
//                } else {
//                    return JsonResult.Error("服务器繁忙");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return JsonResult.Error("数据操作");
//
//    }


    //------------------------------------------------------------------//

    /**
     * 获取汽车品牌
     *
     * @return
     */
    @Override
    public JsonResult getBrand() {
        try {
            String jsonResult = HttpClientUtil.doGet(BASE_URL + BRAND_URL);
            return JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }

    }

    /**
     * 获取车系
     *
     * @param brandId
     * @return
     */
    @Override
    public JsonResult getSeriesByBrand(String brandId) {
        try {
            String jsonResult = HttpClientUtil.doGet(BASE_URL + SERIES_BRAND_URL + "/" + brandId);
            return JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }

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
        try {
            String jsonResult = HttpClientUtil.doGet(BASE_URL + CARTYPE_SERIES_CARYEAR_URL + "/" + seriesId + "/" + caryear);
            return JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }

    }

    @Override
    public JsonResult getCarById(String carid) {

        try {
            String jsonResult = HttpClientUtil.doGet(BASE_URL + CAR_INFO_URL + "/" + carid);
            return JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }

    }

    @Override
    public JsonResult deleteCar(String carid) {

        try {
            Map<String,String> param = new HashMap<>();
            param.put("id",carid);
            String jsonResult = HttpClientUtil.doPost(BASE_URL + CAR_DELETE_URL,param);
            return JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }

    }

    @Override
    public JsonResult modifyCar(String id, String baseId, String carBrand, String carBrandLine, String sellpoint, String sellPrice, String stockNum,
                                String image, String smimage, String businessId, String carYear) {

        HashMap<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("baseId", baseId);
        map.put("carBrand", carBrand);
        map.put("carBrandLine", carBrandLine);
        map.put("sellpoint", sellpoint);
        map.put("sellPrice", sellPrice);
        map.put("stockNum", stockNum);
        map.put("image", image);
        map.put("smimage", smimage);
        map.put("businessId", businessId);
        map.put("carYear", carYear);
        String jsonResult = null;
        try {
            jsonResult = HttpClientUtil.doPost(BASE_URL + CAR_MODIFY_URL, map);
            return JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }


    }

    @Override
    public JsonResult findList(String businessId, String brandId, String carSeries, String date,
                               String carYear, Integer currentPage, String sortString) {
        try {

            Map<String, String> params = new HashMap<>();
            if (StringUtils.isNotBlank(brandId)) {
                params.put("brandId", brandId);
            }
            if (StringUtils.isNotBlank(carSeries)) {
                params.put("carSeries", carSeries);
            }
            if (StringUtils.isNotBlank(date)) {
                params.put("date", date);
            }
            if (StringUtils.isNotBlank(carYear)) {
                params.put("carYear", carYear);
            }
            params.put("currentPage", currentPage + "");
            if (StringUtils.isNotBlank(sortString)) {
                params.put("sortString", sortString);
            }
            String jsonResult = HttpClientUtil.doGet(BASE_URL + CAR_LIST_URL + "?businessId=" + businessId, params);

            if (StringUtils.isNotBlank(jsonResult)) {
                return JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
            } else {
                return JsonResult.Error(OperateEnum.SERVER_ERROR);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }
    }

    @Override
    public JsonResult getCarDetail(String carId) {
        String res = HttpClientUtil.doGet(BASE_URL + CAR_DETAIL + carId);
        if (StringUtils.isNotBlank(res)) {
            return JsonUtils.jsonToPojo(res, JsonResult.class);
        } else {
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }
    }

    @Override
    public JsonResult saveSerise(String brandId, String seriseName,String factoryId) {

        Map<String, String> params = new HashMap<>();
        params.put("brandId", brandId);
        params.put("seriesName", seriseName);
        params.put("factoryId", factoryId);
        try {
            String res = HttpClientUtil.doPost(BASE_URL + CAR_SERISE_ADD, params);
            return JsonUtils.jsonToPojo(res, JsonResult.class);
        }catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }

    }

    @Override
    public JsonResult saveCarBaseInfo(Map<String, String> map) {
        try {
            String res = HttpClientUtil.doPost(BASE_URL + CAR_BASEINFO_SAVE, map);
            return JsonUtils.jsonToPojo(res, JsonResult.class);
        } catch (Exception e){
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }

    }

    @Override
    public JsonResult getStatict(String businessId) {
        try {
            String res = HttpClientUtil.doGet(BASE_URL + HOME_STATIC + businessId);
            return JsonUtils.jsonToPojo(res, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }


    }

    @Override
    public JsonResult getFactory(String brandId) {
        try {
            String res = HttpClientUtil.doGet(BASE_URL + FACTORY + brandId);
            return JsonUtils.jsonToPojo(res, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }
    }

    @Override
    public JsonResult getCarSeriseByFactory(String factoryId) {
        try {
            String res = HttpClientUtil.doGet(BASE_URL + SERISE + factoryId);
            return JsonUtils.jsonToPojo(res, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }
    }

    @Override
    public JsonResult getBussinessInfo(String businessId) {

        try {
            String res = HttpClientUtil.doGet(BASE_URL + BUSSINESSINFO + businessId);
            return JsonUtils.jsonToPojo(res, JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }

    }

    @Override
    public JsonResult changePass(String userId, String pass1, String pass2, String pass3) {

        try {
            Map<String,String> param = new HashMap<>();
            param.put("id",userId);
            param.put("oldPassword",pass1);
            param.put("newPassword",pass2);
            param.put("reNewPassword",pass3);
            String res = HttpClientUtil.doPost(BASE_URL + CHANGE_PASS,param);
            return JsonUtils.jsonToPojo(res, JsonResult.class);

        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error(OperateEnum.SERVER_ERROR);
        }
    }


}