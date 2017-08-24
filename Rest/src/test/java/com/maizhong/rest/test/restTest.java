package com.maizhong.rest.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.HttpUtils;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.rest.DTO.NewsDto;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xushd on 2017/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class restTest {



    @Value("${APPCODE}")
    private String APPCODE;

    @Value("${API_URL}")
    private String API_URL;


    @Autowired
    private JedisClient jedisClient;


    @Test
    public void newsTest(){
        getNewsList(1);
    }



    public JsonResult getNewsList(int pageIndex){


        String news = jedisClient.hget("NEWS", String.valueOf(pageIndex));
        if(StringUtils.isBlank(news)){
            if(pageIndex>1)return JsonResult.OK(new JSONArray());
            //获取最新10条 后 开启异步同步新闻
            JSONObject pagebean = getNews(1);

            int allPages = pagebean.getIntValue("allPages");
            List<NewsDto> list = getNewsDtoList(pagebean);

            jedisClient.hset("NEWS",String.valueOf(1), JsonUtils.objectToJson(list));
            jedisClient.expire("NEWS",60*60);
            //开启异步获取

            syncGetAllNews(allPages);

            return JsonResult.OK(list);
        }else{
            return JsonResult.OK(JSON.parseArray(news));
        }


    }

    /**
     * 异步同步新闻信息
     */
    private void syncGetAllNews(int allPages){

        for (int i = 2; i <= allPages; i++) {
            Thread thread = new Thread(new ThreadChanle(i),"news"+i);
            thread.start();

        }
    }

    /**
     * 接口获取数据转换成NewsDto
     * @param pagebean
     * @return
     */
    private List<NewsDto> getNewsDtoList(JSONObject pagebean){
        List<NewsDto> list = new ArrayList<>();

        JSONArray contentlist = pagebean.getJSONArray("contentlist");
        for (Object o : contentlist) {
            JSONObject obj = (JSONObject) o;
            NewsDto dto = new NewsDto();
            dto.setId(obj.getString("id"));
            dto.setContent(obj.getString("html"));
            dto.setLink(obj.getString("link"));
            dto.setSource(obj.getString("source"));
            dto.setPubDate(obj.getString("pubDate"));
            dto.setTitle(obj.getString("title"));
            List<String> imgArry = new ArrayList<>();
            if(obj.getBoolean("havePic")){
                JSONArray imageurls = obj.getJSONArray("imageurls");
                for (Object imageurl : imageurls) {
                    JSONObject objImg = (JSONObject) imageurl;
                    imgArry.add(objImg.getString("url"));
                }
                dto.setPic(imgArry.get(0));

            }else{
                dto.setPic("");
            }
            dto.setImgArry(imgArry);
            list.add(dto);
        }
        return list;
    }

    /**
     * 获取新闻
     * @param pageIndex
     * @return
     */
    private JSONObject getNews(int pageIndex){
        Map<String, String> headers = new HashMap<>();

        headers.put("Authorization", "APPCODE " + APPCODE);
        Map<String, String> querys = new HashMap<>();
        querys.put("channelId", "5572a108b3cdc86cf39001d3");
        querys.put("channelName", "");
        querys.put("maxResult", "10");
        querys.put("needAllList", "1");
        querys.put("needContent", "0");
        querys.put("needHtml", "1");
        querys.put("page", String.valueOf(pageIndex));
        querys.put("title", "");

        try {

            HttpResponse response = HttpUtils.doGet(API_URL, "/newsList", "GET", headers, querys);
            //获取response的body
            String resposeBody = EntityUtils.toString(response.getEntity());
            JSONObject result = JSON.parseObject(resposeBody);
            JSONObject showapi_res_body = result.getJSONObject("showapi_res_body");
            JSONObject pagebean = showapi_res_body.getJSONObject("pagebean");
            return pagebean;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 内部类线程类
     */
    class ThreadChanle implements Runnable {
        public ThreadChanle(int pageIndex) {
            this.pageIndex = pageIndex;
        }
        private int pageIndex;
        public void run() {
            try {
                JSONObject news = getNews(pageIndex);
                if(news!=null){
                    List<NewsDto> newsDtoList = getNewsDtoList(news);
                    jedisClient.hset("NEWS",String.valueOf(pageIndex), JsonUtils.objectToJson(newsDtoList));
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }


}
