package com.maizhong.rest.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.BrandMapper;
import com.maizhong.pojo.Brand;
import com.maizhong.rest.service.ReckonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Xushd on 2017/4/18.
 */
@Service
public class ReckonServiceImpl implements ReckonService {



    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private BrandMapper brandMapper;

    @Value("${CHE_MODEL}")
    private String CHE_MODEL;

    @Value("${CHE_BRAND}")
    private String CHE_BRAND;

    @Value("${TOKEN}")
    private String token;

    @Override
    public void getBrandData() {

        String res = HttpClientUtil.doGet(CHE_BRAND+"?token="+token);
        JSONObject jsonObject = JSON.parseObject(res);

        JSONArray brand_list = jsonObject.getJSONArray("brand_list");

        for (Object o : brand_list) {
            JSONObject object = (JSONObject) o;
            Brand brand = new Brand();
            brand.setBrandId(object.getInteger("brand_id"));
            brand.setBrandName(object.getString("brand_name"));
            brand.setInitial(object.getString("initial"));
            brand.setUpdateTime(object.getDate("update_time"));
            brand.setLargeLogo("http://assets.che300.com/theme/images/brand/large/b"+object.getString("brand_id")+".jpg");
            brand.setSmallLogo("http://assets.che300.com/theme/images/brand/small/b"+object.getString("brand_id")+".jpg");

            brandMapper.insert(brand);
        }

    }
}
