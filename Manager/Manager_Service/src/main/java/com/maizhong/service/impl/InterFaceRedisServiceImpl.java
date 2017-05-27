package com.maizhong.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.*;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.FileUploadUtil;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.BrandMapper;
import com.maizhong.mapper.CityMapper;
import com.maizhong.mapper.ProvinceMapper;
import com.maizhong.mapper.SeriesMapper;
import com.maizhong.pojo.*;
import com.maizhong.service.InterFaceRedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Xushd on 2017/5/25.
 */
@Service
public class InterFaceRedisServiceImpl implements InterFaceRedisService {



    @Value("${CHE_MODEL}")
    private String CHE_MODEL;

    @Value("${CHE_BRAND}")
    private String CHE_BRAND;

    @Value("${CHE_SERIES}")
    private String CHE_SERIES;

    @Value("${CHE_CITY}")
    private String CHE_CITY;

    @Value("${GUZHI}")
    private String GUZHI;

    @Value("${TOKEN}")
    private String token;


    // aliOSS

    @Value("${ENDPOINT}")
    private  String ENDPOINT;

    @Value("${ACCESSKEYID}")
    private  String ACCESSKEYID;

    @Value("${ACCESSKEYSECRET}")
    private  String ACCESSKEYSECRET;

    @Value("${BUCKETNAME}")
    private  String BUCKETNAME;



    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private SeriesMapper seriesMapper;


    /**
     * 获取OSS对象参数
     * @return
     */
    private Map<String,String> getParam(String fileName){

        String version = jedisClient.get("APP_VERSION");
        JSONObject object = JSON.parseObject(version);
        String versionNumber = object.getString("versionNumber");

        Map<String,String> param = new HashMap<>();
        param.put("endpoint",ENDPOINT);
        param.put("accessKeyId",ACCESSKEYID);
        param.put("accessKeySecret",ACCESSKEYSECRET);
        param.put("bucketName",BUCKETNAME);
        param.put("fileName",fileName);
        param.put("key","app/"+versionNumber+"/");
        return param;
    }


    @Override
    public JsonResult selectProvice(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        ProvinceExample example = new ProvinceExample();
        ProvinceExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause(" prov_id ASC ");
        if (param.getFiled("provName") != null) {
            criteria.andProvNameLike(SqlUtils.getLikeSql(param.getFiled("provName")));
        }
        List<Province> list = provinceMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        PageResult result = new PageResult(pageInfo);
        return JsonResult.OK(result);
    }

    @Override
    public JsonResult proviceRedis() {
        String[] mark = {"A","B","C","D","E","F","J","H","I","G","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        try {
            ProvinceExample example = new ProvinceExample();
            example.setOrderByClause(" initial ASC ");
            List<Province> list = provinceMapper.selectByExample(example);
            List<Province> redisList = new ArrayList<>();
            List<ProvinceDTO> plist = new ArrayList<>();
            for (String s : mark) {
                List<Province> temp = new ArrayList<>();
                Iterator it = list.iterator();
                while(it.hasNext()){
                    Province prov = (Province)it.next();

                    if(s.equals(prov.getInitial())){
                        plist.add(new ProvinceDTO(prov.getProvId(),prov.getProvName()));
                        temp.add(prov);
                        it.remove();
                    }
                }
                if(temp.size()!=0){
                    Province prov = new Province();
                    prov.setProvId(0);
                    prov.setInitial(s);
                    prov.setProvName("G");
                    redisList.add(prov);
                    redisList.addAll(temp);
                }
            }
            jedisClient.del("APP_PROVINCE");
            jedisClient.set("APP_PROVINCE", JsonUtils.objectToJson(redisList));
            jedisClient.del("PROVINCE");
            jedisClient.set("PROVINCE", JsonUtils.objectToJson(plist));

            return JsonResult.build(OperateEnum.SUCCESS);


        }catch (Exception e){
            e.printStackTrace();
        }



        return JsonResult.build(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult proviceSyncOSS() {

        try {
            String redisProv = jedisClient.get("APP_PROVINCE");
            if(StringUtils.isNotBlank(redisProv)){
                InputStream is= new ByteArrayInputStream(redisProv.getBytes("utf-8"));
                boolean b = FileUploadUtil.UploadJsonOSS(this.getParam("province.json"), is);
                if(b)return JsonResult.build(OperateEnum.SUCCESS);
            }else{
                return JsonResult.build(OperateEnum.SERVER_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.build(OperateEnum.SERVER_ERROR);

    }

    @Override
    public JsonResult selectCity(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        CityExample example = new CityExample();
        CityExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause(" city_id ASC ");
        if (param.getFiled("cityName") != null) {
            criteria.andCityNameLike(SqlUtils.getLikeSql(param.getFiled("cityName")));
        }
        List<City> list = cityMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        PageResult result = new PageResult(pageInfo);
        return JsonResult.OK(result);

    }

    @Override
    public JsonResult cityRedis() {

        try {
            CityExample example = new CityExample();
            List<City> cities = cityMapper.selectByExample(example);
            List<CityDTO> list = new ArrayList<>();

            for (City city : cities) {
                list.add(new CityDTO(city.getCityId(),city.getCityName(),city.getProvId()));
                jedisClient.hdel("CITY_KEY",city.getCityId()+"");
                jedisClient.hset("CITY_KEY",city.getCityId()+"",city.getCityName());
            }
            jedisClient.del("CITY");
            jedisClient.set("CITY",JsonUtils.objectToJson(list));
            return JsonResult.build(OperateEnum.SUCCESS);

        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.build(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult syncInter() {

        try {
            String res = HttpClientUtil.doGet(CHE_CITY + "?token=" + token);
            if(StringUtils.isNotBlank(res)){
                JSONObject parse = JSON.parseObject(res);
                if(parse.getInteger("status")!=1){
                    return JsonResult.Error("CHE300 RESULT STATUS ERROR");
                }else{
                    CityExample example = new CityExample();
                    CityExample.Criteria criteria = example.createCriteria();
                    criteria.andCityIdIsNotNull();
                    cityMapper.deleteByExample(example);
                    JSONArray city_list = parse.getJSONArray("city_list");
                    for (Object o : city_list) {
                        JSONObject city = (JSONObject) o;
                        City cityBean = new City();
                        cityBean.setCityId(city.getInteger("city_id"));
                        cityBean.setCityName(city.getString("city_name"));
                        cityBean.setInitial(city.getString("initial"));
                        cityBean.setProvId(city.getInteger("prov_id"));
                        cityBean.setAdminCode(city.getInteger("admin_code"));
                        cityBean.setHotLevel(1);
                        cityMapper.insert(cityBean);
                    }
                    return JsonResult.OK();
                }
            }else {
                return JsonResult.Error("CHE300 RESULT NULL ERROR");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return JsonResult.build(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult citySyncOSS() {

        try {
            String redisCity = jedisClient.get("CITY");
            if(StringUtils.isNotBlank(redisCity)){
                InputStream is= new ByteArrayInputStream(redisCity.getBytes("utf-8"));
                boolean b = FileUploadUtil.UploadJsonOSS(this.getParam("city.json"), is);
                if(b)return JsonResult.build(OperateEnum.SUCCESS);
            }else{
                return JsonResult.build(OperateEnum.SERVER_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.build(OperateEnum.SERVER_ERROR);

    }

    @Override
    public JsonResult selectBrand(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        BrandExample example = new BrandExample();
        BrandExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause(" brand_id ASC ");
        if (param.getFiled("brandName") != null) {
            criteria.andBrandNameLike(SqlUtils.getLikeSql(param.getFiled("brandName")));
        }
        List<Brand> list = brandMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        PageResult result = new PageResult(pageInfo);
        return JsonResult.OK(result);

    }

    @Override
    public JsonResult brandHotChange(long brandId, int i) {

        Brand brand = new Brand();
        brand.setBrandId(brandId);
        brand.setIsHot(i);

        int i1 = brandMapper.updateByPrimaryKeySelective(brand);
        if(i1>0)return JsonResult.build(OperateEnum.SUCCESS);


        return JsonResult.build(OperateEnum.FAILE);
    }

    @Override
    public JsonResult brandRedis() {

        String[] mark = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        try {
            BrandExample example = new BrandExample();
            example.setOrderByClause(" initial ASC ");
            List<Brand> list = brandMapper.selectByExample(example);
            List<KeyObject> keyList = new ArrayList<>();
            List<BrandDTO> appList = new ArrayList<>();
            JSONArray hotBrand = new JSONArray();
            for (String s : mark) {
                List<Brand> temp = new ArrayList<>();
                Iterator it = list.iterator();
                while(it.hasNext()){
                    Brand brand = (Brand)it.next();
                    if(s.equals(brand.getInitial())){
                        if(brand.getIsHot()>0){
                            JSONObject object = new JSONObject();
                            object.put("brand",brand.getBrandName());
                            object.put("brandId",brand.getBrandId());
                            object.put("largeLogo",brand.getLargeLogo());
                            hotBrand.add(object);
                        }
                        temp.add(brand);
                        it.remove();
                    }
                }
                if(temp.size()!=0){
                    appList.add(new BrandDTO(0L,s,"","",0));
                    KeyObject obj = new KeyObject();
                    obj.setKey(s);
                    JSONArray arry = new JSONArray();
                    for (Brand brand : temp) {
                        appList.add(new BrandDTO(brand.getBrandId(),s,brand.getBrandName(),brand.getLargeLogo(),brand.getIsHot()));
                        arry.add(new KeyValue(brand.getBrandId()+"",brand.getBrandName()));
                    }
                    obj.setObject(arry);
                    keyList.add(obj);
                }
            }
            jedisClient.del("APP_BRAND");
            jedisClient.set("APP_BRAND",JsonUtils.objectToJson(appList));
            jedisClient.del("HOT_BRAND");
            jedisClient.set("HOT_BRAND",JsonUtils.objectToJson(hotBrand));
            jedisClient.del("BRAND_GROUP_INITIAL");
            jedisClient.set("BRAND_GROUP_INITIAL",JsonUtils.objectToJson(keyList));
            return JsonResult.build(OperateEnum.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.build(OperateEnum.SERVER_ERROR);

    }

    @Override
    public JsonResult brandSyncInter() {

        try {
            String res = HttpClientUtil.doGet(CHE_BRAND + "?token=" + token);
            if(StringUtils.isNotBlank(res)){
                JSONObject parse = JSON.parseObject(res);
                if(parse.getInteger("status")!=1){
                    return JsonResult.Error("CHE300 RESULT STATUS ERROR");
                }else{
                    BrandExample example = new BrandExample();
                    BrandExample.Criteria criteria = example.createCriteria();
                    criteria.andBrandIdIsNotNull();
                    brandMapper.deleteByExample(example);
                    JSONArray brand_list = parse.getJSONArray("brand_list");
                    for (Object o : brand_list) {
                        JSONObject brand = (JSONObject) o;
                        Brand brandBean = new Brand();
                        brandBean.setBrandId(brand.getLong("brand_id"));
                        brandBean.setBrandName(brand.getString("brand_name"));
                        brandBean.setInitial(brand.getString("initial"));
                        brandBean.setUpdateTime(brand.getDate("update_time"));
                        brandBean.setLargeLogo("http://assets.che300.com/theme/images/brand/large/b" + brand.getString("brand_id") + ".jpg");
                        brandBean.setSmallLogo("http://assets.che300.com/theme/images/brand/small/b" + brand.getString("brand_id") + ".jpg");
                        brandBean.setIsHot(0);
                        brandMapper.insert(brandBean);
                    }
                    return JsonResult.OK();
                }
            }else {
                return JsonResult.Error("CHE300 RESULT NULL ERROR");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return JsonResult.build(OperateEnum.SERVER_ERROR);

    }

    @Override
    public JsonResult brandSyncOSS() {

        try {
            String redisBrand = jedisClient.get("APP_BRAND");
            if(StringUtils.isNotBlank(redisBrand)){
                InputStream is= new ByteArrayInputStream(redisBrand.getBytes("utf-8"));
                boolean b = FileUploadUtil.UploadJsonOSS(this.getParam("allbrand.json"), is);
                is.close();
                String redisHotBrand = jedisClient.get("HOT_BRAND");
                is =  new ByteArrayInputStream(redisHotBrand.getBytes("utf-8"));
                boolean c = FileUploadUtil.UploadJsonOSS(this.getParam("hotbrand.json"), is);
                is.close();
                if(b&&c)return JsonResult.build(OperateEnum.SUCCESS);
            }else{
                return JsonResult.build(OperateEnum.SERVER_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.build(OperateEnum.SERVER_ERROR);
    }

    @Override
    public JsonResult seriesList(PageSearchParam param) {

        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        SeriesExample example = new SeriesExample();
        SeriesExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause(" series_id ASC ");
        if (param.getFiled("seriesName") != null) {
            criteria.andSeriesNameLike(SqlUtils.getLikeSql(param.getFiled("seriesName")));
        }
        List<Series> list = seriesMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        PageResult result = new PageResult(pageInfo);
        return JsonResult.OK(result);

    }

    @Override
    public JsonResult seriesSyncInter() {
        BrandExample example = new BrandExample();
        example.setOrderByClause("brand_id");
        List<Brand> brands = brandMapper.selectByExample(example);
        for (Brand brand : brands) {
            JSONArray objArry = new JSONArray();
            Map<String, List<Series>> resultMap= new HashMap<>();
            try {
                String reidsSeries = HttpClientUtil.doGet(CHE_SERIES + "?token=" + token + "&brandId=" + brand.getBrandId());
                JSONObject jsonObject = JSON.parseObject(reidsSeries);
                if (jsonObject.getInteger("status") == 1) {
                    JSONArray seriesList = jsonObject.getJSONArray("series_list");
                    example.clear();
                    SeriesExample example1 = new SeriesExample();
                    SeriesExample.Criteria criteria = example1.createCriteria();
                    criteria.andBrandIdEqualTo(brand.getBrandId());
                    seriesMapper.deleteByExample(example1);
                    for (Object o : seriesList) {
                        JSONObject obj = (JSONObject) o;
                        Series series = new Series();
                        series.setBrandId(brand.getBrandId());
                        series.setSeriesId(obj.getInteger("series_id"));
                        series.setSeriesName(obj.getString("series_name"));
                        series.setSeriesGroupName(obj.getString("series_group_name"));
                        series.setUpdateTime(obj.getDate("update_time"));
                        series.setSeriesPic(obj.getString("series_pic").replace("\\", ""));
                        seriesMapper.insert(series);

                        jedisClient.hdel("CAR_SERIES_KEY",obj.getString("series_id"));
                        jedisClient.hset("CAR_SERIES_KEY",obj.getString("series_id"), JSON.toJSONString(series));

                        JSONObject object = new JSONObject();
                        object.put("series_group_name",obj.getString("series_group_name"));
                        object.put("series_id",obj.getString("series_id"));
                        object.put("series_name",obj.getString("series_name"));
                        objArry.add(object);

                        if(resultMap.containsKey(obj.getString("series_group_name"))){
                            resultMap.get(obj.getString("series_group_name")).add(series);
                        }else{
                            List<Series> list = new ArrayList<>();
                            list.add(series);
                            resultMap.put(obj.getString("series_group_name"),list);
                        }

                    }


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(objArry.size()>0){
                jedisClient.hdel("SERIES_GROUP_BRAND",brand.getBrandId()+"");
                jedisClient.hset("SERIES_GROUP_BRAND",brand.getBrandId()+"",JsonUtils.objectToJson(objArry));
            }

            if(resultMap.size()>0){
                JSONArray arry = new JSONArray();
                for (String s : resultMap.keySet()) {
                    JSONObject obj = new JSONObject();
                    obj.put("seriesName","");
                    obj.put("seriesGroupName",s);
                    obj.put("brandId",brand.getBrandId());
                    obj.put("seriesId",0);
                    arry.add(obj);
                    List<Series> series = resultMap.get(s);
                    for (Series sery : series) {
                        obj = new JSONObject();
                        obj.put("seriesName",sery.getSeriesName());
                        obj.put("brandId",brand.getBrandId());
                        obj.put("seriesId",sery.getSeriesId());
                        arry.add(obj);
                    }
                }
                jedisClient.hdel("APP_BRAND_SERIES",brand.getBrandId()+"");
                jedisClient.hset("APP_BRAND_SERIES",brand.getBrandId()+"",JsonUtils.objectToJson(arry));

            }

        }
        return JsonResult.OK();
    }


}
