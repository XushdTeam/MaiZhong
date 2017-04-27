package com.maizhong.rest.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.dto.CityDTO;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.EncryptUtils;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.*;
import com.maizhong.pojo.*;
import com.maizhong.rest.DTO.AdvertDTO;
import com.maizhong.rest.service.AppService;
import com.maizhong.rest.service.ReckonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-18
 * Time: 10:43
 */

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private JedisClient jedisClient;
    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private TbAdvertMapper tbAdvertMapper;
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private LineMapper lineMapper;
    @Autowired
    private LineSiteMapper lineSiteMapper;
    @Autowired
    private SeriesMapper seriesMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VersionMapper versionMapper;


    @Autowired
    private ReckonService reckonService;
    @Value("${UNLOGIN_TOKEN}")
    private String UNLOGIN_TOKEN;
    @Value("${BRAND_GROUP_INITIAL}")
    private String BRAND_GROUP_INITIAL;
    @Value("${APP_ADVERT}")
    private String APP_ADVERT;
    @Value("${APP_PROVINCE}")
    private String APP_PROVINCE;
    @Value("${CITY}")
    private String CITY;
    @Value("${LINES}")
    private String LINES;
    @Value("${APP_LINE_SITE}")
    private String APP_LINE_SITE;
    @Value("${APP_BRAND}")
    private String APP_BRAND;
    @Value("${APP_BRAND_SERIES}")
    private String APP_BRAND_SERIES;
    @Value("${SMS_CODE}")
    private String SMS_CODE;
    @Value("${APP_LOGIN_TOKEN}")
    private String APP_LOGIN_TOKEN;

    /**
     * 根据设备Id获取token
     *
     * @param deviceId
     * @return
     */
    @Override
    public JsonResult getTokenByDeciceId(String deviceId, String phone) {
        JSONObject object = new JSONObject();
        List<Version> versions = versionMapper.selectByExample(null);
        Version version = null;
        try {
            if (versions != null && versions.size() > 0) {
                version = versions.get(versions.size() - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (version != null) {
            object.put("versionNumber", version.getVersionNumber());
        } else {
            object.put("versionNumber", "V0.0.0");
        }
        if (StringUtils.isNotBlank(deviceId)) {
            try {
                String hget = jedisClient.get(UNLOGIN_TOKEN + ":" + deviceId);
                if (StringUtils.isNotBlank(hget)) {
                    object.put("token",hget);
                    return JsonResult.build(200, "获取成功", object);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String token = EncryptUtils.getSHA256Str(deviceId + "*#$maizhong!*");

            try {
                jedisClient.set(UNLOGIN_TOKEN + ":" + deviceId, token);
           /* jedisClient.expire(UNLOGIN_TOKEN + ":" + deviceId, 60 * 60 * 2);*/
            } catch (Exception e) {
                e.printStackTrace();
            }
            object.put("token", token);
            return JsonResult.build(200, "获取成功", object);
        } else {
            String s = jedisClient.get(APP_LOGIN_TOKEN + ":" + phone);
            if (StringUtils.isNotBlank(s)) {
                object.put("token", s);
            } else {
                String token = EncryptUtils.getSHA256Str(phone + "*#$maizhongCAR%$!*");
                try {
                    jedisClient.set(APP_LOGIN_TOKEN + ":" + phone, token);
             /*   jedisClient.expire(LOGIN_TOKEN + ":" + phone, 60 * 60 * 2);  登录用户暂时不设置失效时间*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    User user = new User();
                    user.setUserId(Long.valueOf(phone));
                    user.setPhone(phone);
                    user.setStatus(1);
                    user.setDelflag(0);
                    userMapper.insert(user);
                }  catch (Exception e) {
                    e.printStackTrace();
                }
                object.put("token", token);
            }
            return JsonResult.build(200, "获取成功", object);
        }
    }

    @Override
    public JsonResult testGetToken(HttpServletRequest request) {
        String header = request.getHeader("X-Maizhong-AppKey");
        return JsonResult.build(200, "token读取成功", header);
    }

    @Override
    public JsonResult getAdvert() {
        String s = null;
        try {
            s = jedisClient.get(APP_ADVERT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(s)) {
            List list = JsonUtils.jsonToPojo(s, List.class);
            return JsonResult.build(200, "获取成功", list);
        }
        List<AdvertDTO> advertDTOList = new ArrayList<>();
        List<TbAdvert> adverts = tbAdvertMapper.selectByExample(null);
        //最后一个
        TbAdvert tbAdvert1 = adverts.get(adverts.size() - 1);
        AdvertDTO advertDTO1 = new AdvertDTO();
        advertDTO1.setH(tbAdvert1.getAdvertUrl());
        advertDTO1.setI(tbAdvert1.getAdvertImg());
        advertDTO1.setN(tbAdvert1.getAdvertName());
        advertDTOList.add(advertDTO1);

        for (TbAdvert tbAdvert : adverts) {
            AdvertDTO advertDTO = new AdvertDTO();
            advertDTO.setH(tbAdvert.getAdvertUrl());
            advertDTO.setI(tbAdvert.getAdvertImg());
            advertDTO.setN(tbAdvert.getAdvertName());
            advertDTOList.add(advertDTO);
        }

        //第一个
        TbAdvert tbAdvert0 = adverts.get(0);
        AdvertDTO advertDTO0 = new AdvertDTO();
        advertDTO0.setH(tbAdvert0.getAdvertUrl());
        advertDTO0.setI(tbAdvert0.getAdvertImg());
        advertDTO0.setN(tbAdvert0.getAdvertName());
        advertDTOList.add(advertDTO0);


        jedisClient.set(APP_ADVERT, JsonUtils.objectToJson(advertDTOList));
        return JsonResult.build(200, "获取成功", advertDTOList);
    }

    /**
     * 获取省份
     *
     * @return
     */
    @Override
    public JsonResult getProvince() {

        try {
            String s = jedisClient.get(APP_PROVINCE);
            if (StringUtils.isNotBlank(s)) {
                List<Province> provinces1 = JsonUtils.jsonToList(s, Province.class);
                return JsonResult.build(200, "获取省份成功", provinces1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        char[] str = new char[26];
        for (int i = 0; i < 26; i++) {
            str[i] = (char) (65 + i);
        }
        List<Province> provinceList = new ArrayList<>();

        ProvinceExample example = new ProvinceExample();
        for (int i = 0; i < 26; i++) {
            example.clear();
            ProvinceExample.Criteria criteria = example.createCriteria();
            criteria.andInitialEqualTo(String.valueOf(str[i]));
            example.setOrderByClause("prov_id ASC");
            List<Province> provinces = provinceMapper.selectByExample(example);
            if (provinces == null || provinces.size() == 0) {
                continue;
            }
            Province province1 = new Province();
            province1.setInitial(String.valueOf(str[i]));
            province1.setProvId(0);
            province1.setProvName(null);
            provinceList.add(province1);
            for (Province province : provinces) {
                provinceList.add(province);
            }
        }
        try {
            jedisClient.set(APP_PROVINCE, JsonUtils.objectToJson(provinceList));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JsonResult.build(200, "获取省份成功", provinceList);
    }

    /**
     * 获取城市
     *
     * @return
     */
    @Override
    public JsonResult getCity() {
        String get = null;
        try {
            get = jedisClient.get(CITY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(get)) {
            List<CityDTO> cityDTOList = JsonUtils.jsonToList(get, CityDTO.class);
            return JsonResult.build(200, "获取城市成功", cityDTOList);
        }

        List<City> cities = cityMapper.selectByExample(null);
        if (cities == null || cities.size() == 0) {
            return JsonResult.OK();
        }
        List<CityDTO> cityDTOList = new ArrayList<>();
        for (City city : cities) {
            CityDTO dto = new CityDTO();
            dto.setId(city.getCityId());
            dto.setName(city.getCityName());
            dto.setProv(city.getProvId());
            cityDTOList.add(dto);
        }
        try {
            jedisClient.set(CITY, JsonUtils.objectToJson(cityDTOList));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(200, "获取城市成功", cityDTOList);
    }

    /**
     * 获取地铁线路
     *
     * @return
     */
    @Override
    public JsonResult getLine() {
        String linesRedis = jedisClient.get("LINES");
        if (StringUtils.isBlank(linesRedis)) {
            LineExample example = new LineExample();
            List<Line> lineList = lineMapper.selectByExample(example);
            jedisClient.set("LINES", JsonUtils.objectToJson(lineList));
            return JsonResult.OK(lineList);
        } else {
            return JsonResult.OK(JsonUtils.jsonToList(linesRedis, Line.class));
        }

    }

    /**
     * 地铁站站点
     *
     * @return
     */
    @Override
    public JsonResult getLineSite() {
        try {
            String s = jedisClient.get(APP_LINE_SITE);
            if (StringUtils.isNotBlank(s)) {
                List<LineSite> lineSites2 = JsonUtils.jsonToList(s, LineSite.class);
                return JsonResult.build(200, "获取成功", lineSites2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<LineSite> lineSites = lineSiteMapper.selectByExample(null);
        jedisClient.set(APP_LINE_SITE, JsonUtils.objectToJson(lineSites));
        return JsonResult.build(200, "获取成功", lineSites);
    }

    /**
     * 获取品牌
     *
     * @return
     */
    @Override
    public JsonResult getBrand() {
        String s = null;
        try {
            s = jedisClient.get(APP_BRAND);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (StringUtils.isNotBlank(s)) {
                List list = JsonUtils.jsonToPojo(s, List.class);
                return JsonResult.build(200, "获取成功", list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        char[] str = new char[26];
        for (int i = 0; i < 26; i++) {
            str[i] = (char) (65 + i);
        }
        JSONArray array = new JSONArray();

        BrandExample example = new BrandExample();
        for (int i = 0; i < 26; i++) {
            example.clear();
            BrandExample.Criteria criteria = example.createCriteria();
            criteria.andInitialEqualTo(String.valueOf(str[i]));
            example.setOrderByClause("brand_id ASC");
            List<Brand> brands = brandMapper.selectByExample(example);
            if (brands == null || brands.size() == 0) {
                continue;
            }
            JSONObject object1 = new JSONObject();
            object1.put("id", 0);
            object1.put("name", "");
            object1.put("img", "");
            object1.put("initial", String.valueOf(str[i]));
            object1.put("isHot", 0);
            array.add(object1);
            for (Brand brand : brands) {
                JSONObject object = new JSONObject();
                object.put("id", brand.getBrandId());
                object.put("name", brand.getBrandName());
                object.put("img", brand.getLargeLogo());
                object.put("initial", brand.getInitial());
                object.put("isHot", brand.getIsHot());
                array.add(object);
            }
        }
        try {
            jedisClient.set(APP_BRAND, JsonUtils.objectToJson(array));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(200, "获取成功", array);
    }

    /**
     * 根据品牌获取车系
     *
     * @param brandId
     * @return
     */
    @Override
    public JsonResult getSeries(String brandId) {
        String hget = null;
        try {
            hget = jedisClient.hget(APP_BRAND_SERIES, brandId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(hget)) {
            List list = JsonUtils.jsonToPojo(hget, List.class);
            return JsonResult.build(200, "获取成功", list);
        }

        List<String> strings = null;
        try {
            strings = seriesMapper.selectByBrandId(Integer.valueOf(brandId));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (strings == null || strings.size() == 0) {
            return JsonResult.build(200, "品牌Id有误", null);
        }
        JSONArray array = new JSONArray();
        SeriesExample example = new SeriesExample();
        for (String factory : strings) {
            example.clear();
            JSONObject object = new JSONObject();
            object.put("seriesId", 0);
            object.put("seriesName", "");
            object.put("seriesGroupName", factory);
           /* object.put("seriesPic",null);*/
            object.put("brandId", brandId);
            array.add(object);
            SeriesExample.Criteria criteria = example.createCriteria();
            try {
                criteria.andBrandIdEqualTo(Integer.valueOf(brandId));
                criteria.andSeriesGroupNameEqualTo(factory);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return JsonResult.build(200, "品牌Id有误", null);
            }
            List<Series> seriesList = seriesMapper.selectByExample(example);
            for (Series series1 : seriesList) {
                JSONObject object2 = new JSONObject();
                object2.put("seriesId", series1.getSeriesId());
                object2.put("seriesName", series1.getSeriesName());
                object.put("seriesGroupName", series1.getSeriesGroupName());
               /* object2.put("seriesPic",null);*/
                object2.put("brandId", series1.getBrandId());
                array.add(object2);
            }
        }
        try {
            jedisClient.hset(APP_BRAND_SERIES, brandId, JsonUtils.objectToJson(array));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(200, "获取成功", array);
    }

    /**
     * 根据车系获取车型
     *
     * @param seriesId
     * @return
     */
    @Override
    public JsonResult getModelBySeries(String seriesId) {
        JsonResult carType = null;
        try {
            carType = reckonService.getCarType(seriesId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(200, "获取成功", carType);
    }

    /**
     * 获取短信验证码
     *
     * @param phone
     * @return
     */
    @Override
    public JsonResult getSmsCode(String phone) {
        JsonResult smsCode = reckonService.getSMSCode(phone, "127.0.0.1");
        return smsCode;
    }

    @Override
    public JsonResult userLogin(String smsCode, String phone) {
        String res = null;
        try {
            res = jedisClient.get(SMS_CODE + ":" + phone);//获取缓存内的信息
        } catch (Exception e) {
            return JsonResult.Error("请发送验证码");
        }
        if (StringUtils.isBlank(res)) {
            return JsonResult.Error("请发送验证码");
        }
        Map map = JsonUtils.jsonToPojo(res, Map.class);
        String reSmsCode = (String) map.get("smsCode");
        if (StringUtils.equals(smsCode, reSmsCode)) {
            String token = EncryptUtils.getSHA256Str(phone + "*#$maizhongCAR%$!*");
            try {
                jedisClient.set(APP_LOGIN_TOKEN + ":" + phone, token);
             /*   jedisClient.expire(LOGIN_TOKEN + ":" + phone, 60 * 60 * 2);  登录用户暂时不设置失效时间*/
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                User user = new User();
                user.setUserId(Long.valueOf(phone));
                user.setPhone(phone);
                user.setStatus(1);
                user.setDelflag(0);
                userMapper.insert(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return JsonResult.build(200, "登录成功", token);
        } else {
            return JsonResult.Error("登录失败，验证码不匹配");
        }
    }

    /**
     * 估值
     *
     * @param param
     * @return
     */
    @Override
    public JsonResult getGuzhi(String param) {
        return reckonService.getGuzhi(param);
    }
}