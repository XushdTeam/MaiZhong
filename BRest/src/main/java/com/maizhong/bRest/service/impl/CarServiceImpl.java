package com.maizhong.bRest.service.impl;

import com.maizhong.bRest.service.CarService;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.pojo.TbCar;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/28.
 */
public class CarServiceImpl implements CarService {

    @Resource
    private JedisClient jedisClient;

    @Value("BUSSINESSUSER_PREFIX")
    private String  BUSSINESSUSER_PREFIX;


    @Value("${CARBYBUID_URL}")
    private static String CARBYBUID_URL;



    //缓存数据需要手动同步
    @Override
    public List<Map<String, Object>> syncDataToRedis(Long businessId){
        if (businessId!=null){

            try {
                String jsonResult = HttpClientUtil.doGet(CARBYBUID_URL+"/"+businessId);

                if (StringUtils.isNotBlank(jsonResult)){
                    JsonResult result = JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
                    if (result.getStatus()==200){
                        List<Map<String,Object>> list = (List<Map<String, Object>>) result.getData();

                        if (list!=null&&list.size()>0){
                            //redis 模拟缓存 添加到缓存命中
                            String jsonInfo = JsonUtils.objectToJson(list);

                            if (StringUtils.isNotBlank(jsonInfo)) {
                                jedisClient.set(BUSSINESSUSER_PREFIX + ":car:"+businessId,jsonInfo);
                            }
                        }else{
                            jedisClient.set(BUSSINESSUSER_PREFIX + ":car:"+businessId,"");
                        }
                        jedisClient.expire(BUSSINESSUSER_PREFIX +":car:"+businessId,7200);
                        return list;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public JsonResult updateCar(TbCar tbCar) {
        if (tbCar==null){
            return JsonResult.Error("数据错误");
        }

        Map<String,String> map = new HashMap<>();

        BeanUtils.copyProperties(tbCar,map);


        HttpClientUtil.doPost(CARBYBUID_URL,map);


        return null;
    }



    //条件查询  //buzuo le cao
    //参数无用
    @Override
    public JsonResult findList(TbCar tbCar){
        //
        if (tbCar.getBusinessId()==null){
            return JsonResult.Error("未登录账号");
        }

        try {
            String jsonResult = HttpClientUtil.doGet(CARBYBUID_URL+"/"+tbCar.getBusinessId());

            if (StringUtils.isNotBlank(jsonResult)){
                JsonResult result = JsonUtils.jsonToPojo(jsonResult, JsonResult.class);
                if (result.getStatus()==200){
                  return result;
//                    List<Map<String,Object>> list = (List<Map<String, Object>>) result.getData();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return JsonResult.Error("数据操作");




//        String json = jedisClient.get(BUSSINESSUSER_PREFIX + ":car:" + tbCar.getBusinessId());
//        List<Map> list = null;
//        if (StringUtils.isNotBlank(json)){
//            list = JsonUtils.jsonToList(json, Map.class);
//            //TODO  条件筛选
//        }else{
////            list = this.syncDataToRedis(tbCar.getBusinessId());
//        }
//        return JsonResult.OK(list);
    }
}
