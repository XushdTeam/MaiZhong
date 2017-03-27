package com.maizhong.portal.controller;

import com.google.common.collect.Maps;
import com.maizhong.common.result.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/15.
 */

@Controller
public class TestController {



    @RequestMapping("/to/{url}")
    public String test(@PathVariable("url") String url){
        return url;
    }

    @RequestMapping("/test/cb_{id1}/cs_{id2}/cp_{id3}/ct_{id4}/list.html")
    @ResponseBody
    public JsonResult test(
            @PathVariable String id1,
            @PathVariable String id2,
            @PathVariable String id3,
            @PathVariable String id4){
        Map<String,String> map = Maps.newHashMap();
        map.put("id1",id1);
        map.put("id1",id2);
        map.put("id1",id3);
        map.put("id1",id4);
        return JsonResult.OK(map);
    }
}
