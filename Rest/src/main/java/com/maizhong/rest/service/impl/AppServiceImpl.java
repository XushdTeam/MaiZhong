package com.maizhong.rest.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.dto.CityDTO;
import com.maizhong.common.dto.GuzhiDTO;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.EncryptUtils;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.TimeUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.*;
import com.maizhong.pojo.*;
import com.maizhong.rest.DTO.AdvertDTO;
import com.maizhong.rest.service.AppService;
import com.maizhong.rest.service.FileUploadService;
import com.maizhong.rest.service.ReckonService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
    private GzrecordMapper gzrecordMapper;

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
    private ModelMapper modelMapper;
    @Autowired
    private HelpMapper helpMapper;
    @Autowired
    private RichtextMapper richtextMapper;

    @Autowired
    private ReckonService reckonService;
    @Autowired
    private FileUploadService fileUploadService;




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
    @Value("${GUZHI}")
    private String GUZHI;
    @Value("${TOKEN}")
    private String TOKEN;

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
                    object.put("token", hget);
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
                    jedisClient.set("APP_LOGIN_PHONE" + ":" + token, phone);
             /*   jedisClient.expire(LOGIN_TOKEN + ":" + phone, 60 * 60 * 2);  登录用户暂时不设置失效时间*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    User user = new User();
                    user.setPhone(Long.valueOf(phone));
                    user.setStatus(1);
                    user.setDelflag(0);
                    userMapper.insert(user);
                } catch (Exception e) {
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
        return carType;
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
            return JsonResult.build(200, "请发送验证码", phone);
        }
        if (StringUtils.isBlank(res)) {
            return JsonResult.build(200, "请发送验证码", phone);
        }
        Map map = JsonUtils.jsonToPojo(res, Map.class);
        String reSmsCode = (String) map.get("smsCode");
        if (StringUtils.equals(smsCode, reSmsCode)) {
            String token = EncryptUtils.getSHA256Str(phone + "*#$maizhongCAR%$!*");
            try {
                jedisClient.set(APP_LOGIN_TOKEN + ":" + phone, token);
                jedisClient.set("APP_LOGIN_PHONE" + ":" + token, phone);
             /*   jedisClient.expire(LOGIN_TOKEN + ":" + phone, 60 * 60 * 2);  登录用户暂时不设置失效时间*/
            } catch (Exception e) {
                e.printStackTrace();
            }

            JSONObject object = new JSONObject();
            object.put("token", token);
            object.put("phone", phone);

            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andPhoneEqualTo(Long.valueOf(phone));
            List<User> users = userMapper.selectByExample(example);
            if (users == null || users.size() == 0) {
                User user = new User();
                user.setPhone(Long.valueOf(phone));
                user.setStatus(1);
                user.setDelflag(0);
                userMapper.insert(user);
                object.put("userImg", null);
            } else {
                User user = users.get(users.size() - 1);
                object.put("userImg", user.getUserImg());
            }
            return JsonResult.build(200, "登录成功", object);
        } else {
            return JsonResult.build(200, "验证码不匹配", phone);
        }
    }

    /**
     * 估值
     *
     * @param param
     * @return
     */
    @Override
    public JsonResult getGuzhi(String param, HttpServletRequest request) {
        String token = request.getHeader("X-Maizhong-AppKey");
        String app_login_phone = jedisClient.hget("APP_LOGIN_PHONE", token);
        try {

            String redisJson = jedisClient.hget("GUZHI", param);

            if (StringUtils.isNotBlank(redisJson)) {

                return JsonResult.OK(JsonUtils.jsonToPojo(redisJson, GuzhiDTO.class));
            }

            String[] paramarry = param.split("c|m|r|g");
            String url = String.format("%s?token=%s&modelId=%s&regDate=%s&mile=%s&zone=%s", GUZHI, TOKEN, paramarry[2], paramarry[3], paramarry[4], paramarry[1]);

            String res = HttpClientUtil.doGet(url);

            JSONObject jsonObject = JSON.parseObject(res);
            JSONArray eval_prices = jsonObject.getJSONArray("eval_prices");


            Gzrecord gzrecord = new Gzrecord();
            gzrecord.setParam(param);
            gzrecord.setCity(Integer.valueOf(paramarry[1]));
            gzrecord.setMail(Integer.valueOf(paramarry[4]));
            gzrecord.setModelId(Long.valueOf(paramarry[2]));
            gzrecord.setRegDate(paramarry[3]);
            gzrecord.setTime(new Date());
            if (StringUtils.isNotBlank(app_login_phone)) {
                try {
                    gzrecord.setPhone(Long.valueOf(app_login_phone));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            for (Object eval_price : eval_prices) {
                JSONObject object = (JSONObject) eval_price;
//
                if (object.getString("condition").equals("excellent")) {
                    //车况优秀
                    gzrecord.setPriceMaxA(object.getString("dealer_buy_price"));
                    gzrecord.setPriceMinA(object.getString("dealer_low_buy_price"));
                }
                if (object.getString("condition").equals("good")) {
                    //车况良好
                    gzrecord.setPriceMaxB(object.getString("dealer_buy_price"));
                    gzrecord.setPriceMinB(object.getString("dealer_low_buy_price"));
                }
                if (object.getString("condition").equals("normal")) {
                    //车况一般
                    gzrecord.setPriceMaxC(object.getString("dealer_buy_price"));
                    gzrecord.setPriceMinC(object.getString("dealer_low_buy_price"));
                    //车况较差
                    gzrecord.setPriceMaxD(new BigDecimal(object.getInteger("dealer_buy_price") * 0.94).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
                    gzrecord.setPriceMinD(new BigDecimal(object.getInteger("dealer_low_buy_price") * 0.94).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
//
//                    gzrecord.setPriceMaxD(new BigDecimal(object.getInteger("dealer_buy_price") * 0.94 * 0.94).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
//                    gzrecord.setPriceMinD(new BigDecimal(object.getInteger("dealer_low_buy_price") * 0.94 * 0.94).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
                }

            }


            GuzhiDTO guzhiDTO = new GuzhiDTO();
            guzhiDTO.setPriceA(gzrecord.getPriceMinA() + "万~" + gzrecord.getPriceMaxA() + "万");
            guzhiDTO.setPriceA_max(gzrecord.getPriceMaxA());
            guzhiDTO.setPriceA_min(gzrecord.getPriceMinA());
            guzhiDTO.setPriceB(gzrecord.getPriceMinB() + "万~" + gzrecord.getPriceMaxB() + "万");
            guzhiDTO.setPriceB_max(gzrecord.getPriceMaxB());
            guzhiDTO.setPriceB_min(gzrecord.getPriceMinB());
            guzhiDTO.setPriceC(gzrecord.getPriceMinC() + "万~" + gzrecord.getPriceMaxC() + "万");
            guzhiDTO.setPriceC_max(gzrecord.getPriceMaxC());
            guzhiDTO.setPriceC_min(gzrecord.getPriceMinC());
            guzhiDTO.setPriceD(gzrecord.getPriceMinD() + "万~" + gzrecord.getPriceMaxD() + "万");
            guzhiDTO.setPriceD_max(gzrecord.getPriceMaxD());
            guzhiDTO.setPriceD_min(gzrecord.getPriceMinD());


            String modelRedis = jedisClient.hget("CAR_MODEL", gzrecord.getModelId() + "");

            Model model = JsonUtils.jsonToPojo(modelRedis, Model.class);

            guzhiDTO.setMaxYear(model.getMaxRegYear() + "");
            guzhiDTO.setMinYear(model.getMinRegYear() + "");

            guzhiDTO.setModelId(model.getModelId() + "");

            guzhiDTO.setModelName(model.getModelName());
            guzhiDTO.setDischargeStandard(model.getDischargeStandard());
            guzhiDTO.setLiter(model.getLiter());
            guzhiDTO.setModelPrice(model.getModelPrice() + "");
            guzhiDTO.setGearType(model.getGearType());

            guzhiDTO.setMail(gzrecord.getMail() + "");
            guzhiDTO.setCity(jedisClient.hget("CITY_KEY", gzrecord.getCity() + ""));

            String seriesRedis = jedisClient.hget("CAR_SERIES_KEY", model.getSeriesId() + "");

            Series series = JsonUtils.jsonToPojo(seriesRedis, Series.class);
            guzhiDTO.setSeriesImg(series.getSeriesPic());
            guzhiDTO.setSeriesId(series.getSeriesId() + "");
            guzhiDTO.setBrandId(series.getBrandId() + "");

            guzhiDTO.setRegdate(gzrecord.getRegDate().replace("-", "年") + "月");


            jedisClient.hset("GUZHI", param, JsonUtils.objectToJson(guzhiDTO));
            gzrecordMapper.insert(gzrecord);

            return JsonResult.OK(guzhiDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 图片上传
     *
     * @param base64Date
     * @return
     */
    @Override
    public JsonResult uploadBase64(String base64Date, HttpServletRequest request) {
        String imgName = null;
        try {
            String[] split = base64Date.split(";");
            String[] split1 = split[0].split("/");
            imgName = "xxx." + split1[1];
            String[] split2 = split[1].split("se64,");
            base64Date = split2[1];
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        byte[] json = null;
        try {
            json = base64Date.getBytes("UTF-8");
            json = Base64.decodeBase64(json);
            JsonResult result = fileUploadService.uploadImg(json, "appPerson/", imgName);
            String data = String.valueOf(result.getData());
            String token = request.getHeader("X-Maizhong-AppKey");
            String app_login_phone = jedisClient.get("APP_LOGIN_PHONE" + ":" + token);
           /* String app_login_phone = "18515455566";*/
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andPhoneEqualTo(Long.valueOf(app_login_phone));
            List<User> users = userMapper.selectByExample(example);
            if (users == null || users.size() == 0) {
                return JsonResult.build(200, "修改成功", data);
            }
            User user = users.get(users.size() - 1);
            user.setUserImg(data);
            userMapper.updateByPrimaryKeySelective(user);
            return JsonResult.build(200, "修改成功", data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(500, "修改失败", null);
    }

    /**
     * 获取估值记录
     *
     * @param request
     * @return
     */
    @Override
    public JsonResult getGzrecord(HttpServletRequest request) {
        String token = request.getHeader("X-Maizhong-AppKey");//获取token
        String app_login_phone = jedisClient.get("APP_LOGIN_PHONE" + ":" + token);//获取手机号
       /* String app_login_phone = "18515455566";*/
        if (StringUtils.isBlank(app_login_phone)) {
            return JsonResult.build(200, "获取成功", null);
        }
        GzrecordExample example = new GzrecordExample();
        GzrecordExample.Criteria criteria = example.createCriteria();
        try {
            criteria.andPhoneEqualTo(Long.valueOf(app_login_phone));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return JsonResult.build(200, "获取成功", null);
        }

        List<Gzrecord> gzrecords = gzrecordMapper.selectByExample(example);
        if (gzrecords == null || gzrecords.size() < 1) {
            return JsonResult.build(200, "获取成功", null);
        }
        JSONArray array = new JSONArray();

        for (Gzrecord gzrecord : gzrecords) {
            Model model = modelMapper.selectByPrimaryKey(gzrecord.getModelId());
            if (model == null) {
                continue;
            }
            City city = cityMapper.selectByPrimaryKey(gzrecord.getCity());
            if (city == null) {
                continue;
            }
            JSONObject object = new JSONObject();
            object.put("city", city.getCityName());//城市
            object.put("modelName", model.getModelName());//名称
            object.put("regDate", gzrecord.getRegDate());//上牌时间
            String formatDateTime3 = TimeUtils.getFormatDateTime3(gzrecord.getTime());
            object.put("time",formatDateTime3);//评估时间
            object.put("mail", gzrecord.getMail());//行驶里程/万公里
            array.add(object);
        }
        return JsonResult.build(200, "获取成功", array);
    }


    /**
     * 获取帮助标题
     *
     * @return
     */
    @Override
    public JsonResult getHelpTitle() {
        String app_help_title = null;
        try {
            app_help_title = jedisClient.get("APP_HELP_TITLE");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(app_help_title)) {
            List list = JsonUtils.jsonToPojo(app_help_title, List.class);
            return JsonResult.OK(list);
        }

        HelpExample example = new HelpExample();
        HelpExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        criteria.andStatusEqualTo(1);
        List<Help> helps = helpMapper.selectByExample(example);
        JSONArray array = new JSONArray();

        //存入标题
        for (Help help : helps) {
            JSONObject object = new JSONObject();
            object.put("id", help.getId());
            object.put("title", help.getTitle());
            array.add(object);
        }
        jedisClient.set("APP_HELP_TITLE", JsonUtils.objectToJson(array));
        return JsonResult.OK(array);
    }

    /**
     * 获取帮助内容
     *
     * @param id
     * @return
     */
    @Override
    public JsonResult getHelpContent(String id) {

        if (StringUtils.isBlank(id)) {
            return JsonResult.OK();
        }
        String app_help_content = null;
        try {
            app_help_content = jedisClient.hget("APP_HELP_CONTENT", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(app_help_content)) {
            JSONObject object = JsonUtils.jsonToPojo(app_help_content, JSONObject.class);
            return JsonResult.OK(object);
        }

        HelpExample example = new HelpExample();
        HelpExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        criteria.andStatusEqualTo(1);
        criteria.andIdEqualTo(Long.valueOf(id));
        List<Help> helps = helpMapper.selectByExample(example);
        if (helps == null || helps.size() == 0) {
            return JsonResult.OK();
        }
        Help help = helps.get(helps.size() - 1);
        JSONObject object = new JSONObject();
        object.put("id", help.getId());
        object.put("title", help.getTitle());
        object.put("content", help.getContent());
        jedisClient.hset("APP_HELP_CONTENT", id, JsonUtils.objectToJson(object));
        return JsonResult.OK(object);
    }

    /**
     * 精准估值
     *
     * @param guzhiKey
     * @param otherKey
     * @param request
     * @return
     */
    @Override
    public JsonResult getSaleGZ(String guzhiKey, String otherKey, HttpServletRequest request) {
        String token = request.getHeader("X-Maizhong-AppKey");//获取token
        String phone = jedisClient.get("APP_LOGIN_PHONE" + ":" + token);//获取手机号
        if (StringUtils.isBlank(phone)) {
            return JsonResult.build(500, "信息错误，请重新登录", null);
        }
        JsonResult saleGZ = reckonService.getSaleGZ(guzhiKey, otherKey, Long.parseLong(phone));
        return saleGZ;
    }

    /**
     * 订单完善
     *
     * @param orderNumber
     * @param dealWay
     * @param wayId
     * @param linkMan
     * @param linkPhone
     * @param address
     * @param checkTime
     * @return
     */
    @Override
    public JsonResult updateOrders(String orderNumber, String dealWay, String wayId, String linkMan, String linkPhone, String address, String checkTime) {
        JsonResult result = reckonService.updateOrders(orderNumber, dealWay, wayId, linkMan, linkPhone, address, checkTime);
        return result;
    }


    /**
     * 根据手机号获取订单信息
     *
     * @param request
     * @return
     */
    @Override
    public JsonResult getOrdersByPhone(HttpServletRequest request) {
        String token = request.getHeader("X-Maizhong-AppKey");//获取token
        String phone = jedisClient.get("APP_LOGIN_PHONE" + ":" + token);//获取手机号
        JsonResult ordersByPhone = reckonService.getOrdersByPhone(phone);
        return ordersByPhone;
    }

    /**
     * 获取交易协议
     * @return
     */
    @Override
    public JsonResult getOrderAgreement() {
        RichtextExample example=new RichtextExample();
        RichtextExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(1L);
        List<Richtext> richtexts = richtextMapper.selectByExampleWithBLOBs(example);
        if (richtexts==null||richtexts.size()==0){
            return JsonResult.OK();
        }
        String content=richtexts.get(richtexts.size()-1).getContent();
        return JsonResult.build(200,"获取协议成功",content);
    }
}