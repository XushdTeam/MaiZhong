package com.maizhong.rest.service.impl;

import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.ext.TbCarMapperExt;
import com.maizhong.rest.service.DetailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YangF on 2017/3/27.
 */
@Service
public class DetailServiceImpl implements DetailService {

    @Resource
    private JedisClient jedisClient;

    @Resource
    private TbCarMapperExt tbCarMapperExt;

    @Value("${CAR}")
    private String CAR;


    @Override
    public JsonResult getDetailById(Long id) {
        if (id == null){
            return JsonResult.Error("数据错误");
        }
        //缓存命中

        try {
            String json = jedisClient.hget(CAR,id+"");
            Map result = null;
            if (StringUtils.isNotBlank(json)){
                result= JsonUtils.jsonToPojo(json,Map.class);
            }
            //json串为“” 代表数据库中也不存在此数据
            if (result!=null){
                return JsonResult.OK(result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        List<Map<String, Object>> list = tbCarMapperExt.findDetailsByCarId(id);
        //空数据处理
        if (list!=null&&list.size()>0){
            for (Map.Entry<String,Object> entry:list.get(0).entrySet()) {
                if (entry.getValue()==null){
                    entry.setValue("-");
                }
            }
        }


        //缓存添加
        try {
            if (list!=null&&list.size()>0){
                String jsonStr = JsonUtils.objectToJson(list.get(0));
                jedisClient.hset(CAR,id+"",jsonStr);
            }else{
                //避免redis穿透
                jedisClient.hset(CAR,id+"","");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        if (list!=null&&list.size()>0){
            return JsonResult.OK(list.get(0));
        }
        return JsonResult.Error("数据错误");

    }



}
