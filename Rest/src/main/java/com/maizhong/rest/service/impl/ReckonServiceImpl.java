package com.maizhong.rest.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.maizhong.common.dto.*;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.*;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.*;
import com.maizhong.pojo.*;
import com.maizhong.rest.DTO.OrderDTO;
import com.maizhong.rest.service.ReckonService;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.*;

/**
 * Created by Xushd on 2017/4/18.
 */
@Service
public class ReckonServiceImpl implements ReckonService {


    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private SeriesMapper seriesMapper;
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GzrecordMapper gzrecordMapper;
    @Autowired
    private ParamsMapper paramsMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private LineMapper lineMapper;

    @Autowired
    private LineSiteMapper lineSiteMapper;

    @Autowired
    private TbBusinessMapper tbBusinessMapper;
    @Autowired
    private DistrictMapper districtMapper;

    @Value("${CHE_MODEL}")
    private String CHE_MODEL;

    @Value("${CHE_BRAND}")
    private String CHE_BRAND;

    @Value("${CHE_SERIES}")
    private String CHE_SERIES;

    @Value("${GUZHI}")
    private String GUZHI;

    @Value("${TOKEN}")
    private String token;

    @Value("${BRAND_GROUP_INITIAL}")
    private String BRAND_GROUP_INITIAL;
    @Value("${SERIES_GROUP_BRAND}")
    private String SERIES_GROUP_BRAND;
    @Value("${PROVINCE}")
    private String PROVINCE;
    @Value("${CITY}")
    private String CITY;
    @Value("${SMS_CODE}")
    private String SMS_CODE;
    @Value("${LOGIN_TOKEN}")
    private String LOGIN_TOKEN;
    @Value("${BUSINESS_ADDRESS}")
    private String BUSINESS_ADDRESS;

    @Override
    public void getBrandData() {

        String res = HttpClientUtil.doGet(CHE_BRAND + "?token=" + token);
        JSONObject jsonObject = JSON.parseObject(res);

        JSONArray brand_list = jsonObject.getJSONArray("brand_list");

        for (Object o : brand_list) {
            JSONObject object = (JSONObject) o;
            Brand brand = new Brand();
            brand.setBrandId(object.getInteger("brand_id"));
            brand.setBrandName(object.getString("brand_name"));
            brand.setInitial(object.getString("initial"));
            brand.setUpdateTime(object.getDate("update_time"));
            brand.setLargeLogo("http://assets.che300.com/theme/images/brand/large/b" + object.getString("brand_id") + ".jpg");
            brand.setSmallLogo("http://assets.che300.com/theme/images/brand/small/b" + object.getString("brand_id") + ".jpg");

            brandMapper.insert(brand);
        }

    }

    @Override
    public void getSeriesData() {

        BrandExample example = new BrandExample();
        example.setOrderByClause("brand_id");
        List<Brand> brands = brandMapper.selectByExample(example);
        for (Brand brand : brands) {
            String res = HttpClientUtil.doGet(CHE_SERIES + "?token=" + token + "&brandId=" + brand.getBrandId());
            System.out.println(res);
            JSONObject jsonObject = JSON.parseObject(res);
            JSONArray series_list = jsonObject.getJSONArray("series_list");
            for (Object o : series_list) {
                JSONObject object = (JSONObject) o;
                Series series = new Series();
                series.setBrandId(brand.getBrandId());
                series.setSeriesId(object.getInteger("series_id"));
                series.setSeriesName(object.getString("series_name"));
                series.setSeriesGroupName(object.getString("series_group_name"));
                series.setUpdateTime(object.getDate("update_time"));
                series.setSeriesPic(object.getString("series_pic").replace("\\", ""));
                jedisClient.hset("CAR_SERIES_KEY", object.getString("series_id"), JSON.toJSONString(series));
                seriesMapper.insert(series);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取汽车品牌分组数据信息
     *
     * @return
     */
    @Override
    public JsonResult getBrandList() {
        String json = null;
        try {
            json = jedisClient.get(BRAND_GROUP_INITIAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<KeyObject> brand_group_initial = null;
        if (json != null) {
            brand_group_initial = JsonUtils.jsonToList(json, KeyObject.class);
        } else {
            //如果缓存内没有，则去查询数据库
            List<Brand> brands = brandMapper.selectByExample(null);

            if (brands == null || brands.size() == 0) {
                //如果数据库也为空，则去调用车300接口
                try {
                    getBrandData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                brands = brandMapper.selectByExample(null);
            }
            Map<String, List<KeyValue>> map = new HashMap<>();

            List<KeyValue> list = null;
            for (Brand brand : brands) {
                list = map.get(brand.getInitial());
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(new KeyValue(brand.getBrandId() + "", brand.getBrandName()));
                map.put(brand.getInitial(), list);
            }

            List<KeyObject> result = new ArrayList<>();

            for (char i = 'A'; i <= 'Z'; i++) {
                if (map.get(i + "") == null) {
                    continue;
                }
                result.add(new KeyObject(i + "", map.get(i + "")));
            }
            jedisClient.set(BRAND_GROUP_INITIAL, JsonUtils.objectToJson(result));
            return JsonResult.OK(result);
        }
        return JsonResult.OK(brand_group_initial);
    }

    /**
     * 同步品牌分组信息
     *
     * @return
     */
    @Override
    public JsonResult sysBrandGroupByInitial() {

        try {
            jedisClient.del(BRAND_GROUP_INITIAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getBrandList();
        return JsonResult.build(OperateEnum.SUCCESS);
    }

    @Override
    public JsonResult getSeriesByBrandId(String brandId) {
        String hget = null;
        try {
            hget = jedisClient.hget(SERIES_GROUP_BRAND, brandId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (StringUtils.isNotBlank(hget)) {
            return JsonResult.build(200, "获取成功", JsonUtils.jsonToList(hget, SeriesDTO.class));
        }


        SeriesExample example = new SeriesExample();
        SeriesExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("series_group_name ASC");
        try {
            criteria.andBrandIdEqualTo(Integer.valueOf(brandId));

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return JsonResult.Error("品牌Id有误");
        }
        List<Series> series = seriesMapper.selectByExample(example);
        List<SeriesDTO> seriesDTOList = new ArrayList<>();
        for (Series series1 : series) {
            SeriesDTO dto = new SeriesDTO();
            dto.setSeries_id(series1.getSeriesId());
            dto.setSeries_name(series1.getSeriesName());
            dto.setSeries_group_name(series1.getSeriesGroupName());
            seriesDTOList.add(dto);
        }

        try {
            jedisClient.hset(SERIES_GROUP_BRAND, brandId, JsonUtils.objectToJson(seriesDTOList));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(200, "获取成功", seriesDTOList);
    }

    @Override
    public JsonResult getProvince() {
        String get = null;
        try {
            get = jedisClient.get(PROVINCE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(get)) {
            return JsonResult.build(200, "获取成功", JsonUtils.jsonToList(get, ProvinceDTO.class));
        }
        List<Province> provinces = provinceMapper.selectByExample(null);
        List<ProvinceDTO> provinceDTOList = new ArrayList<>();
        for (Province province : provinces) {
            ProvinceDTO dto = new ProvinceDTO();
            dto.setId(province.getProvId());
            dto.setName(province.getProvName());
            provinceDTOList.add(dto);
        }
        try {
            jedisClient.set(PROVINCE, JsonUtils.objectToJson(provinceDTOList));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(200, "获取省份成功", provinceDTOList);
    }

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
     * 通过车系获取车型
     *
     * @param seriesId
     * @return
     */
    @Override
    public JsonResult getCarType(String seriesId) {

        try {
            //STEP 1 查看本地缓存是否存在
            String redisJson = jedisClient.hget("CAR_SERIES_MODEL", seriesId);
            if (StringUtils.isNotBlank(redisJson)) {
                //STEP 2 有 直接返回
                return JsonResult.OK(JSON.parseArray(redisJson));
            } else {
                //STEP 3 没有 调用接口

                String res = HttpClientUtil.doGet(CHE_MODEL + "?token=" + token + "&seriesId=" + seriesId);
                JSONObject jsonObject = JSON.parseObject(res);
                JSONArray model_list = jsonObject.getJSONArray("model_list");
                //STEP 4 放到缓存
                jedisClient.hset("CAR_SERIES_MODEL", seriesId, JSON.toJSONString(model_list));

                //STEP 5 存入数据库
                for (Object o : model_list) {
                    JSONObject object = (JSONObject) o;
                    Model model = new Model();
                    model.setDischargeStandard(object.getString("discharge_standard"));
                    model.setSeriesId(Integer.valueOf(seriesId));
                    model.setGearType(object.getString("gear_type"));
                    model.setLiter(object.getString("liter"));
                    model.setMaxRegYear(object.getInteger("max_reg_year"));
                    model.setMinRegYear(object.getInteger("min_reg_year"));
                    model.setModelName(object.getString("model_name"));
                    model.setModelId(object.getLong("model_id"));
                    model.setModelYear(object.getInteger("model_year"));
                    model.setSeatNumber(object.getString("seat_number"));
                    model.setUpdateTime(object.getDate("update_time"));
                    model.setShortName(object.getString("short_name"));
                    model.setModelPrice(object.getBigDecimal("model_price"));
                    modelMapper.insert(model);

                    jedisClient.hset("CAR_MODEL", object.getInteger("model_id") + "", JSON.toJSONString(model));
                }
                return JsonResult.OK(model_list);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JsonResult getGuzhi(String param) {
        try {

            String redisJson = jedisClient.hget("GUZHI", param);

            if (StringUtils.isNotBlank(redisJson)) {

                return JsonResult.OK(JsonUtils.jsonToPojo(redisJson, GuzhiDTO.class));
            }

            String[] paramarry = param.split("c|m|r|g");
            String url = String.format("%s?token=%s&modelId=%s&regDate=%s&mile=%s&zone=%s", GUZHI, token, paramarry[2], paramarry[3], paramarry[4], paramarry[1]);

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

    @Override
    public void setRedisCity() {

    }

    /**
     * 精准估值
     *
     * @param guzhiKey
     * @param otherKey
     * @return
     */
    @Transactional
    @Override
    public JsonResult getSaleGZ(String guzhiKey, String otherKey, long phone) {

        JsonResult guzhi = getGuzhi(guzhiKey);
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
        if (StringUtils.equals(gh, "1")) {
            guzhiDTO.setGh("0次");
        } else if (StringUtils.equals(gh, "2")) {
            guzhiDTO.setGh("1次");
        } else if (StringUtils.equals(gh, "3")) {
            guzhiDTO.setGh("2次");
        } else {
            guzhiDTO.setGh("3次及以上");
        }
        //过户时间
        if (StringUtils.equals(ghtime, "1")) {
            guzhiDTO.setGhtime("无过户");
        } else if (StringUtils.equals(ghtime, "2")) {
            guzhiDTO.setGhtime("六个月以内");
        }
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
        //颜色影响
        basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));

        String jqxParam = jedisClient.hget("GZ_PARAM", "jqx");
        JSONObject jqxObject = JSON.parseObject(jqxParam);
        rate = jqxObject.getString("p" + jqx);
        //交强险影响
        basePrice = basePrice.subtract(new BigDecimal(rate));

        String ghParam = jedisClient.hget("GZ_PARAM", "gh");
        JSONObject ghObject = JSON.parseObject(ghParam);
        rate = ghObject.getString("p" + gh);
        //过户次数影响
        basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));

        String ghtParam = jedisClient.hget("GZ_PARAM", "ghtime");
        JSONObject ghtObject = JSON.parseObject(ghtParam);
        rate = ghtObject.getString("p" + ghtime);
        //过户时间影响
        basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));

        String xzParam = jedisClient.hget("GZ_PARAM", "xz");
        JSONObject xzObject = JSON.parseObject(xzParam);
        rate = xzObject.getString("p" + xz);
        //性质
        basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));

        String njParam = jedisClient.hget("GZ_PARAM", "nj");
        JSONObject njObject = JSON.parseObject(njParam);
        rate = njObject.getString("p" + nj);
        //年检
        basePrice = basePrice.subtract(new BigDecimal(rate));

        String methodParam = jedisClient.hget("GZ_PARAM", "method");
        JSONObject mObject = JSON.parseObject(methodParam);
        rate = mObject.getString("p" + method);
        //使用方式
        basePrice = basePrice.subtract(basePrice.multiply(new BigDecimal(rate)));

        guzhiDTO.setSalePrice(basePrice.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());

        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(phone).andModelIdEqualTo(Long.valueOf(guzhiDTO.getModelId()));
        long l = ordersMapper.countByExample(example);
        if (l == 0L) {
            long orderNum = IDUtils.getOrderId();

            Orders order = new Orders();
            order.setOrderNumber(orderNum);
            order.setUserId(phone);
            order.setModelId(Long.valueOf(guzhiDTO.getModelId()));
            order.setModelName(guzhiDTO.getModelName());
            order.setReckonPrice(guzhiDTO.getSalePrice());
            order.setDealPrice("");
            order.setReckonTime(new Date());
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
            orderInfoMapper.insert(orderInfo);

            jedisClient.hset("ORDER_PHONE", phone + "", JSON.toJSONString(guzhiDTO));
        }

        return JsonResult.build(200, "", guzhiDTO.getSalePrice());

    }

    /**
     * 精确估值相关信息
     *
     * @param phone
     * @return
     */
    @Override
    public JsonResult getGZDetail(long phone) {
        GuzhiDTO guzhiDTO = null;
        try {
            String order_phone = jedisClient.hget("ORDER_PHONE", phone + "");
            guzhiDTO = JsonUtils.jsonToPojo(order_phone, GuzhiDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(200, phone + "", guzhiDTO);
    }

    @Override
    public void site() {

        try {


            LineExample example = new LineExample();
            List<Line> lines = lineMapper.selectByExample(example);

            for (Line line : lines) {

                String res = HttpClientUtil.doGet("http://www.aihuishou.com/util/GetMetroSiteByLine?lineId=" + line.getId());
                System.out.println(res);
                JSONArray jsonArray = JSON.parseArray(res);

                for (Object o : jsonArray) {
                    JSONObject obj = (JSONObject) o;
                    LineSite site = new LineSite();
                    site.setLineId(line.getId());
                    site.setName(obj.getString("name"));
                    site.setId(obj.getLong("id"));
                    lineSiteMapper.insert(site);

                }
                Thread.sleep(10);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取地铁线路
     *
     * @return
     */
    @Override
    public JsonResult getLines() {

        try {

            String linesRedis = jedisClient.get("LINES");
            if (StringUtils.isBlank(linesRedis)) {
                LineExample example = new LineExample();
                List<Line> lineList = lineMapper.selectByExample(example);
                jedisClient.set("LINES", JsonUtils.objectToJson(lineList));
                return JsonResult.OK(lineList);

            } else {

                return JsonResult.OK(JsonUtils.jsonToList(linesRedis, Line.class));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * 通过线路ID获取地铁信息
     *
     * @param lineId
     * @return
     */
    @Override
    public JsonResult getSiteByLineId(String lineId) {

        try {

            String siteRedis = jedisClient.hget("LINE_SITE", lineId);
            if (StringUtils.isBlank(siteRedis)) {
                LineSiteExample example = new LineSiteExample();
                LineSiteExample.Criteria criteria = example.createCriteria();
                criteria.andLineIdEqualTo(Long.valueOf(lineId));
                List<LineSite> lineSites = lineSiteMapper.selectByExample(example);
                jedisClient.hset("LINE_SITE", lineId, JsonUtils.objectToJson(lineSites));
                return JsonResult.OK(lineSites);

            } else {

                return JsonResult.OK(JsonUtils.jsonToList(siteRedis, LineSite.class));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public JsonResult updateOrders(String orderNumber, String dealWay, String wayId, String linkMan, String linkPhone, String address, String checkTime) {
        try {
            OrdersExample example = new OrdersExample();
            OrdersExample.Criteria criteria = example.createCriteria();
            criteria.andOrderNumberEqualTo(Long.valueOf(orderNumber));
            List<Orders> orderses = ordersMapper.selectByExample(example);
            Orders orders = orderses.get(0);
            //4s店
            if (Integer.valueOf(dealWay) == 1) {
                TbBusiness tbBusiness = tbBusinessMapper.selectByPrimaryKey(Long.valueOf(wayId));
                orders.setAddress(tbBusiness.getBusinessName() + " " + tbBusiness.getAddress());
            }
            //地铁
            if (Integer.valueOf(dealWay) == 2) {
                LineSite lineSite = lineSiteMapper.selectByPrimaryKey(Long.valueOf(wayId));
                Line line = lineMapper.selectByPrimaryKey(lineSite.getLineId());
                orders.setAddress("北京市地铁" + line.getName() + "线" + lineSite.getName() + "站");
                orders.setCheckTime(checkTime);
            }
            //上门
            if (Integer.valueOf(dealWay) == 3) {
                orders.setAddress(address);
                orders.setCheckTime(checkTime);
            }
            orders.setDealWay(Integer.valueOf(dealWay));
            orders.setWayId(Long.valueOf(wayId));
            orders.setLinkMan(linkMan);
            orders.setLinkPhone(linkPhone);
            ordersMapper.updateByPrimaryKey(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.OK();
    }

    /**
     * 使用手机号和token判断
     *
     * @param phone
     * @param token
     * @return
     */
    @Override
    public JsonResult loginByToken(String phone, String token) {
        if (StringUtils.isBlank(token) || StringUtils.isBlank(phone)) {
            return JsonResult.build(500, "登录失败", phone);
        }
        String baseToken = null;
        try {
            baseToken = jedisClient.get(LOGIN_TOKEN + ":" + phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.equals(baseToken, token)) {
            return JsonResult.build(200, "登录成功", phone);
        }
        return JsonResult.build(500, "登录失败", phone);
    }

    /**
     * 根据手机号获取订单信息
     *
     * @param phone
     * @return
     */
    @Override
    public JsonResult getOrdersByPhone(String phone) {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(Long.valueOf(phone));
        List<Orders> ordersList = ordersMapper.selectByExample(example);
        if (ordersList == null || ordersList.size() == 0) {
            return JsonResult.build(200, "无订单", phone);
        }
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Orders orders : ordersList) {
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
            orderDTO.setLinkMan(orders.getLinkMan());//联系人
            orderDTO.setLinkPhone(orders.getLinkPhone());//联系人电话
            orderDTO.setReckon_time(TimeUtils.getFormatDateTime3(orders.getReckonTime()));//评估时间
            OrderInfoExample orderInfoExample = new OrderInfoExample();
            orderInfoExample.createCriteria();
            criteria.andOrderNumberEqualTo(orders.getOrderNumber());
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
                if (StringUtils.equals(orderInfo.getGh(), "1")) {
                    orderInfo.setGh("0次");
                } else if (StringUtils.equals(orderInfo.getGh(), "2")) {
                    orderInfo.setGh("1次");
                } else if (StringUtils.equals(orderInfo.getGh(), "3")) {
                    orderInfo.setGh("2次");
                } else {
                    orderInfo.setGh("3次及以上");
                }
                //过户时间
                if (StringUtils.equals(orderInfo.getGhtime(), "1")) {
                    orderInfo.setGhtime("无过户");
                } else if (StringUtils.equals(orderInfo.getGhtime(), "2")) {
                    orderInfo.setGhtime("六个月以内");
                }
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
            try {
                orderDTO.setStatus(String.valueOf(orders.getStatus()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            orderDTOList.add(orderDTO);
        }

        return JsonResult.build(200, "获取成功", orderDTOList);
    }

    /**
     * 获取验证码
     *
     * @param phone
     * @return
     */
    @Override
    public JsonResult getSMSCode(String phone, String ip) {
        try {
            try {
                jedisClient.del(SMS_CODE + ":" + phone);//重新发送短息时要清空上一次信息
            } catch (Exception e) {
                e.printStackTrace();
            }
            int smsCode = (int) (Math.random() * (9999 - 1000 + 1)) + 1000;//验证码 4位随机数
            Map<String, Object> codeMap = new HashMap<>();
            codeMap.put("ip", ip);
            codeMap.put("smsCode", String.valueOf(smsCode));
         /*   codeMap.put("date", new Date());//保存发送时间*/
            jedisClient.set(SMS_CODE + ":" + phone, JsonUtils.objectToJson(codeMap));//写入缓存
            jedisClient.expire(SMS_CODE + ":" + phone, 60 * 5);//5分钟过期

           /* 阿里发送短信*/
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIZ3jQm7dX5Inv", "1OqUiGxTQeH2afyKhYv6vlPtzh1m2a");
            /*主题编号 默认  和 Access Key ID  和 Access Key Secret */
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms", "sms.aliyuncs.com");
            IAcsClient client = new DefaultAcsClient(profile);
            SingleSendSmsRequest request = new SingleSendSmsRequest();
            request.setSignName("迈众");//控制台创建的签名名称
            request.setTemplateCode("SMS_62710241");//控制台创建的模板CODE
            Map<String, String> map = new HashMap<>();
            map.put("name", "迈众汽车");//称呼
            map.put("code", String.valueOf(smsCode));//短信验证码
            request.setParamString(JsonUtils.objectToJson(map));//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
            request.setRecNum(phone);//接收号码
            SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            return JsonResult.OK("发送失败,请重新发送");
        } catch (ClientException e) {
            return JsonResult.OK("发送失败，请重新发送");
        }
        return JsonResult.OK("发送成功");
    }

    /**
     * 用户登录
     *
     * @param smsCode
     * @return
     */
    @Override
    public JsonResult userLogin(String smsCode, String phone, String ip) {
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
            String token = EncryptUtils.getSHA256Str(phone + "*#$maizhong%$!*");
            try {
                jedisClient.set(LOGIN_TOKEN + ":" + phone, token);
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
     * 获取4S店地址
     *
     * @return
     */
    @Override
    public JsonResult getBusinessAddress() {

        String s = null;
        try {
            s = jedisClient.get(BUSINESS_ADDRESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(s)) {
            List list = JsonUtils.jsonToPojo(s, List.class);
            return JsonResult.build(200, "获取成功", list);
        }


        List<District> districts = districtMapper.selectByExample(null);//区县 16
        TbBusinessExample example = new TbBusinessExample();
        JSONArray array = new JSONArray();
        for (District district : districts) {
            JSONObject object = new JSONObject();
            object.put("district", district.getName());
            object.put("id", district.getId());
            example.clear();
            TbBusinessExample.Criteria criteria = example.createCriteria();
            criteria.andDistrictIdEqualTo(Long.valueOf(district.getId()));
            List<TbBusiness> tbBusinesses = tbBusinessMapper.selectByExample(example);
            if (tbBusinesses == null || tbBusinesses.size() == 0) {
                continue;
            }
            JSONArray array1 = new JSONArray();
            for (TbBusiness tbBusiness : tbBusinesses) {
                JSONObject object1 = new JSONObject();
                object1.put("address", tbBusiness.getAddress());
                object1.put("name", tbBusiness.getBusinessName());
                object1.put("id", tbBusiness.getId());
                object1.put("location", tbBusiness.getLocation());
                object1.put("districtId", tbBusiness.getDistrictId());
                array1.add(object1);
            }
            object.put("shop", array1);
            array.add(object);
        }
        jedisClient.set(BUSINESS_ADDRESS, JsonUtils.objectToJson(array));
        return JsonResult.build(200, "获取成功", array);
    }

    @Override
    public JsonResult getOneWeek() {
        List<Map> mapList = new ArrayList<>();

        for (int i = 0; i >= -6; i--) {
            Map<String, String> map = new HashMap<>();
            String StringDate = TimeUtils.getDateBeforeDay(i);
            Date date = TimeUtils.getDate2(StringDate);
            String[] weekDaysName = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            String weekDate = weekDaysName[intWeek];
            String Mday = StringUtils.substring(StringDate, 5);
            map.put("Ydate", StringDate);
            map.put("week", weekDate);
            map.put("Mday", Mday);
            mapList.add(map);
        }
        return JsonResult.build(200, "获取成功", mapList);
    }
}

