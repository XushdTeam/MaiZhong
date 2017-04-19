package com.maizhong.rest.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.dto.*;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.*;
import com.maizhong.pojo.*;
import com.maizhong.rest.service.ReckonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    private ModelMapper modelMapper;

    @Autowired
    private GzrecordMapper gzrecordMapper;


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
                series.setSeriesPic(object.getString("series_pic").replace("\\",""));
                jedisClient.hset("CAR_SERIES_KEY",object.getString("series_id"),JSON.toJSONString(series));
                seriesMapper.insert(series);
            }
            try {
                Thread.sleep(100);
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
            jedisClient.set(CITY,JsonUtils.objectToJson(cityDTOList));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(200, "获取城市成功", cityDTOList);
    }


    /**
     * 通过车系获取车型
     * @param seriesId
     * @return
     */
    @Override
    public JsonResult getCarType(String seriesId) {

        try {
            //STEP 1 查看本地缓存是否存在
            String redisJson = jedisClient.hget("CAR_SERIES_MODEL",seriesId);
            if(StringUtils.isNotBlank(redisJson)){
                //STEP 2 有 直接返回
                return JsonResult.OK(JSON.parseArray(redisJson));
            }else{
                //STEP 3 没有 调用接口

                String res = HttpClientUtil.doGet(CHE_MODEL+"?token="+token+"&seriesId="+seriesId);
                JSONObject jsonObject = JSON.parseObject(res);
                JSONArray model_list = jsonObject.getJSONArray("model_list");
                //STEP 4 放到缓存
                jedisClient.hset("CAR_SERIES_MODEL",seriesId,JSON.toJSONString(model_list));
                //STEP 5 存入数据库
                for (Object o : model_list) {
                    JSONObject object= (JSONObject) o;
                    Model model=new Model();
                    model.setDischargeStandard(object.getString("discharge_standard"));
                    model.setSeriesId(Integer.valueOf(seriesId));
                    model.setGearType(object.getString("gear_type"));
                    model.setLiter(object.getString("liter"));
                    model.setMaxRegYear(object.getInteger("max_reg_year"));
                    model.setMinRegYear(object.getInteger("min_reg_year"));
                    model.setModelName(object.getString("model_name"));
                    model.setModelId(object.getInteger("model_id"));
                    model.setModelYear(object.getInteger("model_year"));
                    model.setSeatNumber(object.getString("seat_number"));
                    model.setUpdateTime(object.getDate("update_time"));
                    model.setShortName(object.getString("short_name"));
                    model.setModelPrice(object.getBigDecimal("model_price"));
                    modelMapper.insert(model);

                    jedisClient.hset("CAR_MODEL",model.getModelId()+"",JSON.toJSONString(model));
                }
                return JsonResult.OK(model_list);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JsonResult getGuzhi(String param) {
        try {

             String redisJson = jedisClient.hget("GUZHI",param);

            if(StringUtils.isNotBlank(redisJson)){

                return JsonResult.OK(JsonUtils.jsonToPojo(redisJson,GuzhiDTO.class));
            }

            String[] paramarry = param.split("c|m|r|g");
            String url = String.format("%s?token=%s&modelId=%s&regDate=%s&mile=%s&zone=%s",GUZHI,token,paramarry[2],paramarry[3],paramarry[4],paramarry[1]);

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

                if(object.getString("condition").equals("excellent")){
                    //车况优秀
                    gzrecord.setPriceMaxA(object.getString("dealer_buy_price"));
                    gzrecord.setPriceMinA(object.getString("dealer_low_buy_price"));
                }
                if(object.getString("condition").equals("good")){
                    //车况良好
                    gzrecord.setPriceMaxB(object.getString("dealer_buy_price"));
                    gzrecord.setPriceMinB(object.getString("dealer_low_buy_price"));
                }
                if(object.getString("condition").equals("normal")){
                    //车况一般
                    gzrecord.setPriceMaxC(object.getString("dealer_buy_price"));
                    gzrecord.setPriceMinC(object.getString("dealer_low_buy_price"));
                    //车况较差
                    gzrecord.setPriceMaxD(new BigDecimal(object.getInteger("dealer_buy_price")*0.94).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
                    gzrecord.setPriceMinD(new BigDecimal(object.getInteger("dealer_low_buy_price")*0.94).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
                }

            }



            GuzhiDTO guzhiDTO = new GuzhiDTO();
            guzhiDTO.setPriceA(gzrecord.getPriceMinA()+"万~"+gzrecord.getPriceMaxA()+"万");
            guzhiDTO.setPriceB(gzrecord.getPriceMinB()+"万~"+gzrecord.getPriceMaxB()+"万");
            guzhiDTO.setPriceC(gzrecord.getPriceMinC()+"万~"+gzrecord.getPriceMaxC()+"万");
            guzhiDTO.setPriceD(gzrecord.getPriceMinD()+"万~"+gzrecord.getPriceMaxD()+"万");

            String modelRedis = jedisClient.hget("CAR_MODEL",gzrecord.getModelId()+"");

            Model model = JsonUtils.jsonToPojo(modelRedis, Model.class);

            guzhiDTO.setModelName(model.getModelName());
            guzhiDTO.setDischargeStandard(model.getDischargeStandard());
            guzhiDTO.setLiter(model.getLiter());
            guzhiDTO.setModelPrice(model.getModelPrice()+"");
            guzhiDTO.setGearType(model.getGearType());

            guzhiDTO.setMail(gzrecord.getMail()+"");
            guzhiDTO.setCity(jedisClient.hget("CITY_KEY",gzrecord.getCity()+""));

            String seriesRedis = jedisClient.hget("CAR_SERIES_KEY",model.getSeriesId()+"");

            guzhiDTO.setSeriesImg(JsonUtils.jsonToPojo(seriesRedis,Series.class).getSeriesPic());

            guzhiDTO.setRegdate(gzrecord.getRegDate().replace("-","年")+"月");


            jedisClient.hset("GUZHI",param,JsonUtils.objectToJson(guzhiDTO));
            gzrecordMapper.insert(gzrecord);

            return JsonResult.OK(guzhiDTO);

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void setRedisCity() {

        CityExample example = new CityExample();
        List<City> cities = cityMapper.selectByExample(example);

        for (City city : cities) {
            jedisClient.hset("CITY_KEY",city.getCityId()+"",city.getCityName());
        }


    }
}

