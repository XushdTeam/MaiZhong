package com.maizhong.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.dto.KeyValue;
import com.maizhong.common.enums.DicParentEnum;
import com.maizhong.common.utils.DicRedisUtils;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.LineMapper;
import com.maizhong.mapper.LineSiteMapper;
import com.maizhong.pojo.Line;
import com.maizhong.pojo.LineExample;
import com.maizhong.pojo.LineSite;
import com.maizhong.pojo.TbDictionary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * Created by Xushd on 2017/3/14.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class DicServiceImplTest {
/*
    @Autowired
    private JedisClient jedisClient;

    @Value("${DIC_KEY}")
    private String DIC_KEY;

    @Test
    public void JedisTest(){




    }*/
//    @Autowired
//    private LineMapper lineMapper;
//
//    @Autowired
//    private LineSiteMapper lineSiteMapper;
//
//    @Test
//    public void getDT() throws InterruptedException {
//
//        LineExample example = new LineExample();
//        List<Line> lines = lineMapper.selectByExample(example);
//
//        for (Line line : lines) {
//
//            String res = HttpClientUtil.doGet("http://www.aihuishou.com/util/GetMetroSiteByLine?lineId="+line.getId());
//            System.out.println(res);
//            JSONArray jsonArray = JSON.parseArray(res);
//
//            for (Object o : jsonArray) {
//                JSONObject obj = (JSONObject) o;
//                LineSite site = new LineSite();
//                site.setLineId(line.getId());
//                site.setName(obj.getString("name"));
//                site.setId(obj.getLong("id"));
//                lineSiteMapper.insert(site);
//
//            }
//            Thread.sleep(10);
//
//
//        }
//
//
//
//
//
//
//
//    }


}
