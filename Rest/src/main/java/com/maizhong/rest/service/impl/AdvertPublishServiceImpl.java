package com.maizhong.rest.service.impl;

import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.TbAdvertMapper;
import com.maizhong.mapper.TbAdvertPublishMapper;
import com.maizhong.pojo.TbAdvert;
import com.maizhong.pojo.TbAdvertPublish;
import com.maizhong.pojo.TbAdvertPublishExample;
import com.maizhong.rest.service.AdvertPublishService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-13
 * Time: 15:07
 */

@Service
public class AdvertPublishServiceImpl implements AdvertPublishService {

    @Autowired
    private TbAdvertMapper tbAdvertMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${AD_HOME}")
    private String AD_HOME;

    /**
     * 获取发布广告信息
     * @param type
     * @return
     */
    @Override
    public JsonResult getAdvertByType(Integer type) {

        //缓存命中
        try {
            String json = jedisClient.hget(AD_HOME,type+"");
            if(StringUtils.isNotBlank(json)){
                return JsonResult.OK(JsonUtils.jsonToList(json,TbAdvert.class));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        List<TbAdvert> list = tbAdvertMapper.getAdvertPublish(Long.valueOf(type));

        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(list);
            jedisClient.hset(AD_HOME,type+"",jsonStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.OK(list);
    }
}

