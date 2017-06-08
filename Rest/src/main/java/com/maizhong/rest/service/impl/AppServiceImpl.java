package com.maizhong.rest.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.dto.CityDTO;
import com.maizhong.common.dto.GuzhiDTO;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.*;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.*;
import com.maizhong.pojo.*;
import com.maizhong.rest.DTO.AdvertDTO;
import com.maizhong.rest.DTO.OrderDTO;
import com.maizhong.rest.service.AppService;
import com.maizhong.rest.service.FileUploadService;
import com.maizhong.rest.service.ReckonService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
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
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private TbBusinessMapper tbBusinessMapper;

    @Autowired
    private ParamsMapper paramsMapper;

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
    private UserrecordMapper userrecordMapper;


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

        if (StringUtils.isNotBlank(deviceId)) {
            deviceId.replace(":", "-");
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
                    }
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
            strings = seriesMapper.selectByBrandId(Long.valueOf(brandId));
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
                criteria.andBrandIdEqualTo(Long.valueOf(brandId));
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
        String app_login_phone = jedisClient.get("APP_LOGIN_PHONE" + ":" + token);
        try {

            String redisJson = jedisClient.hget("GUZHI", param);

            if (StringUtils.isNotBlank(redisJson)) {
                GuzhiDTO guzhiDTO = JsonUtils.jsonToPojo(redisJson, GuzhiDTO.class);
                if (StringUtils.isNotBlank(app_login_phone) && app_login_phone.length() == 11) {//粗略判断是否为登录用户估值
                    GzrecordExample gzrecordExample = new GzrecordExample();
                    GzrecordExample.Criteria criteria = gzrecordExample.createCriteria();
                    criteria.andParamEqualTo(param);//到数据库查询记录
                    List<Gzrecord> gzrecords = gzrecordMapper.selectByExample(gzrecordExample);
                    if (gzrecords != null && gzrecords.size() > 0) {//查询出结果 取最新记录
                        try {
                            Userrecord userrecord = new Userrecord();
                            userrecord.setUserId(Long.valueOf(app_login_phone));
                            userrecord.setGzDate(new Date());
                            userrecord.setGzId(gzrecords.get(gzrecords.size() - 1).getId());
                            userrecordMapper.insert(userrecord);//插入估值记录
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                return JsonResult.OK(guzhiDTO);
            }

            String[] paramarry = param.split("c|m|r|g");
            String url = String.format("%s?token=%s&modelId=%s&regDate=%s&mile=%s&zone=%s", GUZHI, TOKEN, paramarry[2], paramarry[3], paramarry[4], paramarry[1]);

            String res = HttpClientUtil.doGet(url);

            JSONObject jsonObject = JSON.parseObject(res);
            JSONArray eval_prices = jsonObject.getJSONArray("eval_prices");


            Gzrecord gzrecord = new Gzrecord();
            gzrecord.setParam(param);
            gzrecord.setCity(Integer.valueOf(paramarry[1]));
            gzrecord.setMail(paramarry[4]);
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
                    gzrecord.setPriceMaxA(object.getString("individual_low_sold_price"));
                    gzrecord.setPriceMinA(object.getString("dealer_low_buy_price"));
                }
                if (object.getString("condition").equals("good")) {
                    //车况良好
                    gzrecord.setPriceMaxB(object.getString("individual_low_sold_price"));
                    gzrecord.setPriceMinB(object.getString("dealer_low_buy_price"));
                }
                if (object.getString("condition").equals("normal")) {
                    //车况一般
                    gzrecord.setPriceMaxC(object.getString("individual_low_sold_price"));
                    gzrecord.setPriceMinC(object.getString("dealer_low_buy_price"));
                    //车况较差
                    gzrecord.setPriceMaxD(new BigDecimal(object.getInteger("individual_low_sold_price") * 0.94).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
                    gzrecord.setPriceMinD(new BigDecimal(object.getInteger("dealer_low_buy_price") * 0.94).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
//
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

            if (StringUtils.isNotBlank(app_login_phone) && app_login_phone.length() == 11) {//粗略判断是否为登录用户估值
                GzrecordExample gzrecordExample = new GzrecordExample();
                GzrecordExample.Criteria criteria = gzrecordExample.createCriteria();
                criteria.andParamEqualTo(param);//到数据库查询记录
                List<Gzrecord> gzrecords = gzrecordMapper.selectByExample(gzrecordExample);
                if (gzrecords != null && gzrecords.size() > 0) {//查询出结果 取最新记录
                    try {
                        Userrecord userrecord = new Userrecord();
                        userrecord.setUserId(Long.valueOf(app_login_phone));
                        userrecord.setGzDate(new Date());
                        userrecord.setGzId(gzrecords.get(gzrecords.size() - 1).getId());
                        userrecordMapper.insert(userrecord);//插入估值记录
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

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
        /*String app_login_phone = "18515455566";*/
        if (StringUtils.isBlank(app_login_phone)) {
            return JsonResult.build(200, "手机号有误", null);
        }

        UserrecordExample userrecordExample = new UserrecordExample();
        UserrecordExample.Criteria criteria1 = userrecordExample.createCriteria();
        criteria1.andUserIdEqualTo(Long.valueOf(app_login_phone));
        Date dateBefore = TimeUtils.getDateBefore(15);
        criteria1.andGzDateGreaterThan(dateBefore);
        userrecordExample.setOrderByClause("gz_date DESC");
        List<Userrecord> userrecords = userrecordMapper.selectByExample(userrecordExample);//获取所有的估值记录

        if (userrecords == null || userrecords.size() < 1) {
            return JsonResult.build(200, "获取成功", null);
        }
        JSONArray array = new JSONArray();
        for (Userrecord userrecord : userrecords) {
            Gzrecord gzrecord = gzrecordMapper.selectByPrimaryKey(userrecord.getGzId());
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
            object.put("modelId", model.getModelId());//ID
            object.put("dischargeStandard", model.getDischargeStandard());//排放标准
            object.put("regDate", gzrecord.getRegDate());//上牌时间
            String formatDateTime3 = TimeUtils.getFormatDateTime3(userrecord.getGzDate());//获取估值时间
            object.put("time", formatDateTime3);//评估时间
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
     * 精准估值详细信息
     * @param guzhiKey
     * @param otherKey
     * @param request
     * @return
     */

    @Override
    public JsonResult getSaleGZDetail(String guzhiKey, String otherKey, HttpServletRequest request) {
        String token = request.getHeader("X-Maizhong-AppKey");//获取token
        String phone = jedisClient.get("APP_LOGIN_PHONE" + ":" + token);//获取手机号
        if (StringUtils.isBlank(phone)) {
            return JsonResult.build(500, "信息错误，请重新登录", null);
        }

       /**/

        JsonResult guzhi = reckonService.getGuzhi(guzhiKey);
        GuzhiDTO guzhiDTO = JsonUtils.jsonToPojo(JSON.toJSONString(guzhi.getData()), GuzhiDTO.class);
        String[] otherArry = otherKey.split("o|j|h|t|x|n|d|k");

        String ck = otherArry[7], color = otherArry[0], jqx = otherArry[1],
                gh = otherArry[2], ghtime = otherArry[3], xz = otherArry[4],
                nj = otherArry[5], method = otherArry[6];
        BigDecimal basePrice;
        if (StringUtils.equals("1", ck)) {
            basePrice = new BigDecimal(guzhiDTO.getPriceA_min());
            guzhiDTO.setCk("车况优秀,好没有任何故障");
        } else if (StringUtils.equals("2", ck)) {
            guzhiDTO.setCk("车况良好,有过少量剐蹭或钣金");
            basePrice = new BigDecimal(guzhiDTO.getPriceB_min());
        } else if (StringUtils.equals("3", ck)) {
            guzhiDTO.setCk("车况一般,有过前后轻碰事故");
            basePrice = new BigDecimal(guzhiDTO.getPriceC_min());
        } else {
            guzhiDTO.setCk("车况较差,有发生过伤及主体框架的碰撞或较大事故");
            basePrice = new BigDecimal(guzhiDTO.getPriceD_min());
        }
        //颜色
        switch (color) {
            case "1":
                guzhiDTO.setColor("米色");
                break;
            case "2":
                guzhiDTO.setColor("白色");
                break;
            case "3":
                guzhiDTO.setColor("灰色");
                break;
            case "4":
                guzhiDTO.setColor("红色");
                break;
            case "5":
                guzhiDTO.setColor("棕色");
                break;
            case "6":
                guzhiDTO.setColor("蓝色");
                break;
            case "7":
                guzhiDTO.setColor("黄色");
                break;
            case "8":
                guzhiDTO.setColor("黑色");
                break;
            case "9":
                guzhiDTO.setColor("银色");
                break;
            case "10":
                guzhiDTO.setColor("绿色");
                break;
            default:
                guzhiDTO.setColor("其他颜色");
                break;
        }
        //交强险
        if (StringUtils.equals(jqx, "1")) {
            guzhiDTO.setJqx("两个月以内");
        } else {
            guzhiDTO.setJqx("两个月以上");
        }
        //过户
        if (StringUtils.equals(gh, "4")) {
            guzhiDTO.setGh("0次");
        } else if (StringUtils.equals(gh, "1")) {
            guzhiDTO.setGh("1次");
        } else if (StringUtils.equals(gh, "2")) {
            guzhiDTO.setGh("2次");
        } else {
            guzhiDTO.setGh("3次及以上");
        }
        //过户时间
        if (StringUtils.equals(ghtime, "1")) {
            guzhiDTO.setGhtime("无过户");
        } else if (StringUtils.equals(ghtime, "2")) {
            guzhiDTO.setGhtime("六个月以内");
        }else
        {
            guzhiDTO.setGhtime("六个月以上");
        }
        //性质
        if (StringUtils.equals(xz, "1")) {
            guzhiDTO.setXz("非营运");
        } else {
            guzhiDTO.setXz("租赁");
        }
        //年检
        if (StringUtils.equals(nj, "1")) {
            guzhiDTO.setNj("两个月以内");
        } else {
            guzhiDTO.setNj("两个月以上");
        }
        //使用方式
        if (StringUtils.equals(method, "1")) {
            guzhiDTO.setMethod("公司");
        } else {
            guzhiDTO.setMethod("个人");
        }


        String colorParam = jedisClient.hget("GZ_PARAM", "color");
        if (StringUtils.isBlank(colorParam)) {

            ParamsExample example = new ParamsExample();

            List<Params> paramses = paramsMapper.selectByExample(example);

            for (Params paramse : paramses) {
                jedisClient.hset("GZ_PARAM", paramse.getId(), JSON.toJSONString(paramse));
            }
            colorParam = jedisClient.hget("GZ_PARAM", "color");
        }


        JSONObject colorObject = JSON.parseObject(colorParam);
        String rate = colorObject.getString("p" + color);
        //颜色影响*（不扣）
        //basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));

        String jqxParam = jedisClient.hget("GZ_PARAM", "jqx");
        JSONObject jqxObject = JSON.parseObject(jqxParam);
        rate = jqxObject.getString("p" + jqx);
        //交强险影响 减法
        basePrice = basePrice.subtract(new BigDecimal(rate));
        if (basePrice.compareTo(BigDecimal.ZERO) < 0) {
            basePrice = BigDecimal.ZERO;
        }

        String ghParam = jedisClient.hget("GZ_PARAM", "gh");
        JSONObject ghObject = JSON.parseObject(ghParam);
        rate = ghObject.getString("p" + gh);
        //过户次数影响
        basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));

        //2017.5.27
        //String ghtParam = jedisClient.hget("GZ_PARAM", "ghtime");
        //JSONObject ghtObject = JSON.parseObject(ghtParam);
        //rate = ghtObject.getString("p" + ghtime);
        //过户时间影响 *（不扣）
        //basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));

        String xzParam = jedisClient.hget("GZ_PARAM", "xz");
        JSONObject xzObject = JSON.parseObject(xzParam);
        rate = xzObject.getString("p" + xz);
        //性质
        basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));

        String njParam = jedisClient.hget("GZ_PARAM", "nj");
        JSONObject njObject = JSON.parseObject(njParam);
        rate = njObject.getString("p" + nj);
        //年检 (减法)
        basePrice = basePrice.subtract(new BigDecimal(rate));
        if (basePrice.compareTo(BigDecimal.ZERO) < 0) {
            basePrice = BigDecimal.ZERO;
        }
        String methodParam = jedisClient.hget("GZ_PARAM", "method");
        JSONObject mObject = JSON.parseObject(methodParam);
        rate = mObject.getString("p" + method);
        //使用方式
        basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));

        if (basePrice.compareTo(BigDecimal.ZERO) < 0) {
            basePrice = BigDecimal.ZERO;
        }
        if (basePrice.compareTo(new BigDecimal(1))<0){
            guzhiDTO.setSalePrice(basePrice.setScale(3, BigDecimal.ROUND_HALF_DOWN).toString());
        }else{
            guzhiDTO.setSalePrice(basePrice.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
        }


        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(Long.valueOf(phone)).andModelIdEqualTo(Long.valueOf(guzhiDTO.getModelId()));
        long l = ordersMapper.countByExample(example);
        if (l == 0L) {
            long orderNum = IDUtils.getOrderId();

            Orders order = new Orders();
            order.setOrderNumber(orderNum);
            order.setUserId(Long.valueOf(phone));
            order.setModelId(Long.valueOf(guzhiDTO.getModelId()));
            order.setModelName(guzhiDTO.getModelName());
            order.setReckonPrice(guzhiDTO.getSalePrice());
            order.setDealPrice("");
            order.setReckonTime(new Date());
            order.setStatus(0);
            order.setDelflag(0);
            ordersMapper.insert(order);

            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderNumber(orderNum);
            orderInfo.setModelId(Long.valueOf(guzhiDTO.getModelId()));
            orderInfo.setRegDate(guzhiDTO.getRegdate());
            //获取下单时间
            guzhiDTO.setReckonTime(TimeUtils.getFormatDateTime2(new DateTime()));
            guzhiDTO.setOrderNumber(orderNum);

            orderInfo.setCityId(guzhiDTO.getCity());
            orderInfo.setsKm(guzhiDTO.getMail());
            orderInfo.setColor(color);
            orderInfo.setJqx(jqx);
            orderInfo.setNj(nj);
            orderInfo.setXz(xz);
            orderInfo.setGh(gh);
            orderInfo.setGhtime(ghtime);
            orderInfo.setMethod(method);
            orderInfo.setCk(ck);
            orderInfo.setDelflag(0);
            orderInfoMapper.insert(orderInfo);

            jedisClient.hset("ORDER_PHONE", phone + "", JSON.toJSONString(guzhiDTO));
        }

        return JsonResult.build(200, "", guzhiDTO);

        /**/
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
        if (StringUtils.isBlank(phone)) {
            List list = new ArrayList();
            return JsonResult.build(200, "无", list);
        }
        JsonResult ordersByPhone = reckonService.getOrdersByPhone(phone);
        return ordersByPhone;
    }

    /**
     * 获取交易协议
     *
     * @return
     */
    @Override
    public JsonResult getOrderAgreement() {
        RichtextExample example = new RichtextExample();
        RichtextExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(1L);
        List<Richtext> richtexts = richtextMapper.selectByExampleWithBLOBs(example);
        if (richtexts == null || richtexts.size() == 0) {
            return JsonResult.OK();
        }
        String content = richtexts.get(richtexts.size() - 1).getContent();
        return JsonResult.build(200, "获取协议成功", content);
    }


    /**
     * 获取4S店地址
     *
     * @return
     */
    @Override
    public JsonResult getBusinessAddress() {
        return reckonService.getBusinessAddress();
    }


    /**
     * 获取估值详情
     *
     * @param phone
     * @return
     */
    @Override
    public JsonResult getGZDetail(long phone) {
        String order_phone = jedisClient.hget("ORDER_PHONE", phone + "");//获取缓存
        if (StringUtils.isBlank(order_phone)) {
            return JsonResult.OK();
        }

        GuzhiDTO guzhiDTO = JsonUtils.jsonToPojo(order_phone, GuzhiDTO.class);
        String modelId = guzhiDTO.getModelId();


        ModelExample example = new ModelExample();
        ModelExample.Criteria criteria = example.createCriteria();
        criteria.andModelIdEqualTo(Long.parseLong(modelId));
        long l = modelMapper.countByExample(example);
        if(l==0){
            String redisModel = jedisClient.hget("CAR_MODEL",modelId);
            Model model = JsonUtils.jsonToPojo(redisModel,Model.class);
            modelMapper.insert(model);
        }

        Long orderNumber = null;
        try {
            orderNumber = Long.valueOf(guzhiDTO.getOrderNumber());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return JsonResult.OK();
        }
        JsonResult gzDetailByOrderNumber = getGZDetailByOrderNumber(orderNumber);
        return gzDetailByOrderNumber;
    }

    /**
     * 获取估值详情
     *
     * @param orderNumber
     * @return
     */
    @Override
    public JsonResult getGZDetailByOrderNumber(long orderNumber) {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNumberEqualTo(orderNumber);
        List<Orders> ordersList = ordersMapper.selectByExample(example);
        if (ordersList == null || ordersList.size() == 0) {
            return JsonResult.OK();
        }
        Orders orders = ordersList.get(0);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderNumber(String.valueOf(orders.getOrderNumber()));//订单编号
        orderDTO.setUserId(String.valueOf(orders.getUserId()));//用户Id
        Model model = modelMapper.selectByPrimaryKey(orders.getModelId());//车型对象

        Series series = seriesMapper.selectByPrimaryKey(model.getSeriesId());
        orderDTO.setSeriesImg(series.getSeriesPic());//车系图片
        orderDTO.setModel(model);
        orderDTO.setModelName(orders.getModelName());//车型名称
        orderDTO.setReckonPrice(orders.getReckonPrice());//评估价格
        orderDTO.setDealPrice(orders.getDealPrice());//交易价格--实际
        orderDTO.setDealTime(orders.getDealTime());//交易时间
        try {
            if (orders.getDealWay() != null) {
                //4s店
                if (orders.getDealWay() == 1) {
                    TbBusiness tbBusiness = tbBusinessMapper.selectByPrimaryKey(orders.getWayId());
                    orderDTO.setAddress(tbBusiness.getBusinessName() + " " + tbBusiness.getAddress());
                    orderDTO.setCheckTime("4S店营业时间内");//验车时间
                    orderDTO.setDealWay("4S店");//验车地址
                }
                //地铁
                if (orders.getDealWay() == 2) {
                    LineSite lineSite = lineSiteMapper.selectByPrimaryKey(orders.getWayId());
                    Line line = lineMapper.selectByPrimaryKey(lineSite.getLineId());
                    orderDTO.setAddress("北京市地铁" + line.getName() + "线" + lineSite.getName() + "站");
                    orderDTO.setCheckTime(orders.getCheckTime());//验车时间
                    orderDTO.setDealWay("地铁站附近");//验车地址
                }
                //上门
                if (orders.getDealWay() == 3) {
                    orderDTO.setAddress(orders.getAddress());//验车地址
                    orderDTO.setCheckTime(orders.getAddress());//验车时间
                    orderDTO.setDealWay("上门");
                }
            }


            orderDTO.setLinkMan(orders.getLinkMan());//联系人
            orderDTO.setLinkPhone(orders.getLinkPhone());//联系人电话
            orderDTO.setReckon_time(TimeUtils.getFormatDateTime3(orders.getReckonTime()));//评估时间
            OrderInfoExample orderInfoExample = new OrderInfoExample();
            OrderInfoExample.Criteria criteria1 = orderInfoExample.createCriteria();
            criteria1.andOrderNumberEqualTo(orders.getOrderNumber());

            List<OrderInfo> orderInfoList = orderInfoMapper.selectByExample(orderInfoExample);
            if (orderInfoList != null && orderInfoList.size() > 0) {
                OrderInfo orderInfo = orderInfoList.get(0);
                if (StringUtils.equals("1", orderInfo.getCk())) {
                    orderInfo.setCk("车况优秀");
                } else if (StringUtils.equals("2", orderInfo.getCk())) {
                    orderInfo.setCk("车况良好");
                } else if (StringUtils.equals("3", orderInfo.getCk())) {
                    orderInfo.setCk("车况一般");
                } else {
                    orderInfo.setCk("车况较差");
                }
                //颜色
                switch (orderInfo.getColor()) {
                    case "1":
                        orderInfo.setColor("米色");
                        break;
                    case "2":
                        orderInfo.setColor("白色");
                        break;
                    case "3":
                        orderInfo.setColor("灰色");
                        break;
                    case "4":
                        orderInfo.setColor("红色");
                        break;
                    case "5":
                        orderInfo.setColor("棕色");
                        break;
                    case "6":
                        orderInfo.setColor("蓝色");
                        break;
                    case "7":
                        orderInfo.setColor("黄色");
                        break;
                    case "8":
                        orderInfo.setColor("黑色");
                        break;
                    case "9":
                        orderInfo.setColor("银色");
                        break;
                    case "10":
                        orderInfo.setColor("绿色");
                        break;
                    default:
                        orderInfo.setColor("其他颜色");
                        break;
                }
                //交强险
                if (StringUtils.equals(orderInfo.getJqx(), "1")) {
                    orderInfo.setJqx("两个月以内");
                } else {
                    orderInfo.setJqx("两个月以上");
                }
                //过户
                if (StringUtils.equals(orderInfo.getGh(), "4")) {
                    orderInfo.setGh("0次");
                } else if (StringUtils.equals(orderInfo.getGh(), "1")) {
                    orderInfo.setGh("1次");
                } else if (StringUtils.equals(orderInfo.getGh(), "2")) {
                    orderInfo.setGh("2次");
                } else {
                    orderInfo.setGh("3次及以上");
                }
                //过户时间
                if (StringUtils.equals(orderInfo.getGhtime(), "1")) {
                    orderInfo.setGhtime("无过户");
                } else if (StringUtils.equals(orderInfo.getGhtime(), "2")) {
                    orderInfo.setGhtime("六个月以内");
                }else
                {
                    orderInfo.setGhtime("六个月以上");
                }
                //性质
                if (StringUtils.equals(orderInfo.getXz(), "1")) {
                    orderInfo.setXz("非营运");
                } else {
                    orderInfo.setXz("租赁");
                }
                //年检
                if (StringUtils.equals(orderInfo.getNj(), "1")) {
                    orderInfo.setNj("两个月以内");
                } else {
                    orderInfo.setNj("两个月以上");
                }
                //使用方式
                if (StringUtils.equals(orderInfo.getMethod(), "1")) {
                    orderInfo.setMethod("公司");
                } else {
                    orderInfo.setMethod("个人");
                }
                orderDTO.setOrderInfo(orderInfo);//评测信息详情
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            orderDTO.setStatus(String.valueOf(orders.getStatus()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonResult oneWeek = reckonService.getOneWeek();
        Object data1 = oneWeek.getData();
        JSONObject object = new JSONObject();
        object.put("gzDetail", orderDTO);
        object.put("oneWeek", data1);
        return JsonResult.build(200, "返回成功", object);
    }

    /**
     * \
     * 删除订单
     *
     * @param orderNumber
     * @param request
     * @return
     */
    @Override
    public JsonResult deleteOrder(String orderNumber, HttpServletRequest request) {
        try {
            String token = request.getHeader("X-Maizhong-AppKey");//获取token
            String app_login_phone = jedisClient.get("APP_LOGIN_PHONE" + ":" + token);//获取手机号
            OrdersExample example = new OrdersExample();
            OrdersExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(Long.valueOf(app_login_phone));
            criteria.andOrderNumberEqualTo(Long.valueOf(orderNumber));

            List<Orders> ordersList = ordersMapper.selectByExample(example);
            if (ordersList == null || ordersList.size() == 0) {
                return JsonResult.build(200, "删除成功", "删除成功");
            }
            Orders order = ordersList.get(0);
            order.setDelflag(1);
            OrderInfoExample orderInfoExample = new OrderInfoExample();
            OrderInfoExample.Criteria criteria1 = orderInfoExample.createCriteria();
            criteria1.andOrderNumberEqualTo(Long.valueOf(orderNumber));
            List<OrderInfo> orderInfoList = orderInfoMapper.selectByExample(orderInfoExample);
            if (orderInfoList != null && orderInfoList.size() > 0) {
                OrderInfo orderInfo = orderInfoList.get(0);
                orderInfo.setDelflag(1);
                orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
            }

            ordersMapper.updateByPrimaryKeySelective(order);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return JsonResult.build(200, "删除成功", "删除成功");
    }

    /**
     * 获取缓存估值
     *
     * @param request
     * @return
     */
    @Override
    public JsonResult getAppGZDetail(HttpServletRequest request) {
        JsonResult gzDetail = null;
        try {
            String token = request.getHeader("X-Maizhong-AppKey");//获取token
            String app_login_phone = jedisClient.get("APP_LOGIN_PHONE" + ":" + token);//获取手机号
            gzDetail = getGZDetail(Long.parseLong(app_login_phone));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (gzDetail == null) {
            JsonResult.build(200, "无", null);
        }
        return gzDetail;
    }

    /**
     * 获取版本号
     *
     * @return
     */
    @Override
    public JsonResult getVersion() {
        String app_version1 = jedisClient.get("APP_VERSION");
        if (StringUtils.isNotBlank(app_version1)) {
            JSONObject object = JsonUtils.jsonToPojo(app_version1, JSONObject.class);
            return JsonResult.OK(object);
        }
        List<Version> versionList = versionMapper.selectByExample(null);
        if (versionList != null && versionList.size() > 0) {
            Version version = versionList.get(versionList.size() - 1);
            JSONObject object = new JSONObject();
            String app_version = version.getVersionNumber();
            int i = app_version.lastIndexOf(".");
            String versionNumber = app_version.substring(0, i);
            object.put("versionNumber", versionNumber);
            object.put("versionDetail", app_version);
            jedisClient.set("APP_VERSION", JsonUtils.objectToJson(object));
            return JsonResult.OK(object);
        }
        return null;
    }


    /**
     * APP根据id获取model
     * @param id
     * @return
     */
    @Override
    public JsonResult getModelById(String id) {

        Model model = null;
        Series series = null;
        JSONObject object=new JSONObject();
        try {
            String car_model = jedisClient.hget("CAR_MODEL", id);
            model = JsonUtils.jsonToPojo(car_model, Model.class);
            series = seriesMapper.selectByPrimaryKey(model.getSeriesId());
            object.put("max_reg_year",model.getMaxRegYear());
            object.put("liter",model.getLiter());
            object.put("gear_type",model.getGearType());
            object.put("model_id",model.getModelId());
            object.put("model_year",model.getModelYear());
            object.put("min_reg_year",model.getMinRegYear());
            object.put("discharge_standard",model.getDischargeStandard());
            object.put("short_name",model.getShortName());
            object.put("model_name",model.getModelName());
            object.put("model_price",model.getModelPrice());
            object.put("seat_number",model.getSeatNumber());
            object.put("group",0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(200, series.getBrandId() + "", object);
    }

    /**
     * 收车数量
     * @return
     */
    @Override
    public JsonResult getSaleNum() {
        String sale_num=null;
        try {
            sale_num= jedisClient.get("SALE_NUM");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(sale_num)){
            return  JsonResult.build(200,"获取成功",sale_num);
        }

        Long num=95895L;
        try {
            jedisClient.set("SALE_NUM",num+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  JsonResult.build(200,"获取成功",num);
    }


}