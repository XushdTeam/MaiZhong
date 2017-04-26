package com.maizhong.rest.service.impl;

import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.EncryptUtils;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.*;
import com.maizhong.pojo.*;
import com.maizhong.rest.DTO.AdvertDTO;
import com.maizhong.rest.service.AppService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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

    @Value("${UNLOGIN_TOKEN}")
    private String UNLOGIN_TOKEN;

    @Value("${BRAND_GROUP_INITIAL}")
    private String BRAND_GROUP_INITIAL;
    @Value("${APP_ADVERT}")
    private String APP_ADVERT;
    @Value("${APP_PROVINCE}")
    private String APP_PROVINCE;
    @Value("${APP_CITY}")
    private String APP_CITY;
    @Value("${APP_LINE}")
    private String APP_LINE;
    @Value("${APP_LINE_SITE}")
    private String APP_LINE_SITE;


    /**
     * 根据设备Id获取token
     *
     * @param deviceId
     * @return
     */
    @Override
    public JsonResult getTokenByDeciceId(String deviceId) {
        try {
            String hget = jedisClient.get(UNLOGIN_TOKEN + ":" + deviceId);
            if (StringUtils.isNotBlank(hget)) {
                return JsonResult.build(200, "获取成功", hget);
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
        return JsonResult.build(200, "获取成功", token);
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
            if (StringUtils.isNotBlank(s)){
                List<Province> provinces1 = JsonUtils.jsonToList(s, Province.class);
                return JsonResult.build(200, "获取省份成功", provinces1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Province> provinces = provinceMapper.selectByExample(null);
        try {
            jedisClient.set(APP_PROVINCE,JsonUtils.objectToJson(provinces));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(200, "获取省份成功", provinces);
    }

    /**
     * 获取城市
     * @return
     */
    @Override
    public JsonResult getCity() {
        try {
            String s = jedisClient.get(APP_CITY);
            if (StringUtils.isNotBlank(s)){
                List<City> cities2 = JsonUtils.jsonToList(s, City.class);
                return JsonResult.build(200,"获取成功",cities2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<City> cities = cityMapper.selectByExample(null);
        jedisClient.set(APP_CITY,JsonUtils.objectToJson(cities));
        return JsonResult.build(200,"获取成功",cities);
    }

    /**
     * 获取地铁线路
     * @return
     */
    @Override
    public JsonResult getLine() {
        try {
            String s = jedisClient.get(APP_LINE);
            if (StringUtils.isNotBlank(s)){
                List<Line> lines2 = JsonUtils.jsonToList(s, Line.class);
                return JsonResult.build(200,"获取成功",lines2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Line> lines = lineMapper.selectByExample(null);
        jedisClient.set(APP_LINE,JsonUtils.objectToJson(lines));
        return JsonResult.build(200,"获取成功",lines);
    }

    /**
     * 获取地铁站点
     * @return
     */
    @Override
    public JsonResult getLineSite() {
        try {
            String s = jedisClient.get(APP_LINE_SITE);
            if (StringUtils.isNotBlank(s)){
                List<LineSite> lineSites2 = JsonUtils.jsonToList(s, LineSite.class);
                return JsonResult.build(200,"获取成功",lineSites2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<LineSite> lineSites = lineSiteMapper.selectByExample(null);
        jedisClient.set(APP_LINE_SITE,JsonUtils.objectToJson(lineSites));
        return JsonResult.build(200,"获取成功",lineSites);
    }
}
