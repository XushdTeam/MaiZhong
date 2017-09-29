package com.tool.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.utils.JsonUtils;
import com.tools.mapper.CarBrandMapper;
import com.tools.mapper.CarFactoryMapper;
import com.tools.mapper.CarModelMapper;
import com.tools.mapper.CarSeriesMapper;
import com.tools.pojo.*;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * Created by Xushd on 2017/9/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class TestDocument {

    private static String[] initral = {"B","C","D","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","V","W","X","Y","Z"};
    @Autowired
    private CarBrandMapper carBrandMapper;
    @Autowired
    private CarFactoryMapper carFactoryMapper;
    @Autowired
    private CarSeriesMapper carSeriesMapper;
    @Autowired
    private CarModelMapper carModelMapper;
    //private static String[] initral = {"A"};
    @Test
    public void getCarBrand() throws Exception {
        for (String s : initral) {
            String url = String.format("http://www.autohome.com.cn/grade/carhtml/%s.html",s);


            Document parse = Jsoup.connect(url).get();

            Elements lis = parse.getElementsByTag("dl");
            System.out.println("品牌个数:"+lis.size());
            for (Element element : lis) {
                String id = element.attr("id");
                Long brandId = Long.valueOf(id);
                Elements dts = element.getElementsByTag("dt");
                //获取品牌和图片
                String img = dts.get(0).getElementsByTag("a").get(0).getElementsByTag("img").get(0).attr("src");
                String text = dts.get(0).getElementsByTag("div").get(0).getElementsByTag("a").get(0).text();
                CarBrand brand = new CarBrand();
                brand.setId(brandId);
                brand.setName(text);
                brand.setLogo(img);
                brand.setInitials(s);
                System.out.println(JsonUtils.objectToJson(brand));
                int i1 = carBrandMapper.insertSelective(brand);
                if(i1==0)throw new Exception("品牌插入失败");

                Element dd = element.getElementsByTag("dd").get(0);
                Elements divs = dd.getElementsByClass("h3-tit");
                Elements uls = dd.getElementsByClass("rank-list-ul");

                // 厂商
                for (int i = 0; i < divs.size(); i++) {
                    Element div = divs.get(i);
                    String fs = div.text();
                    CarFactory factory = new CarFactory();
                    factory.setBrandId(brandId);
                    factory.setName(fs);
                    System.out.println(JsonUtils.objectToJson(factory));

                    int i2 = carFactoryMapper.insertSelective(factory);
                    if(i2==0)throw new Exception("厂商插入失败");


                    Element ul = uls.get(i);
                    Elements lis_li = ul.getElementsByTag("li");
                    for (Element element1 : lis_li) {
                        String id1 = element1.attr("id");
                        if(StringUtils.isBlank(id1))continue;
                        id1 = id1.replace("s","");
                        System.out.println(id1);
                        String seriesName = element1.getElementsByTag("h4").get(0).getElementsByTag("a").get(0).text();
                        Elements div1s = element1.getElementsByTag("div");
                        String price="";
                        if(div1s.size()==2){
                            price = div1s.get(0).getElementsByTag("a").get(0).text();
                        }else{
                            price = "暂无";
                        }
                        CarSeries carSeries = new CarSeries();
                        carSeries.setId(Long.valueOf(id1));
                        carSeries.setBrandId(brandId);
                        carSeries.setName(seriesName);
                        carSeries.setPrice(price);
                        carSeries.setFactoryId(factory.getId());
                        System.out.println(JsonUtils.objectToJson(carSeries));

                        int i3 = carSeriesMapper.insertSelective(carSeries);
                        if(i3==0)throw new Exception("车系插入失败");

                    }

                }


            }

          //  System.out.println(html);
        }


    }
    @Test
    public void getCarModel() throws IOException {

        List<CarSeries> carSeries = carSeriesMapper.selectByExample(new CarSeriesExample());
        for (CarSeries carSery : carSeries) {

            Long brandId = carSery.getBrandId();
            Long seriesId = carSery.getId();

            String url = String.format("http://www.che168.com/Handler/ScriptCarList_V1.ashx?seriesid=%d",seriesId);


            Document parse = Jsoup.connect(url).get();

            String text = parse.body().text();
            text = text.replace("spec","\"spec\"");
            System.out.println(text);
            try {
                JSONArray array = JSON.parseArray(text);
                for (Object o : array) {
                    JSONObject object = (JSONObject) o;
                    String year = object.getString("year");
                    JSONArray spec = object.getJSONArray("spec");
                    for (Object o1 : spec) {
                        JSONObject obj = (JSONObject) o1;
                        CarModel model = new CarModel();
                        model.setId(obj.getLong("id"));
                        model.setYear(year);
                        model.setBrandId(brandId);
                        model.setSeriesId(seriesId);
                        model.setName(obj.getString("name"));

                        carModelMapper.insertSelective(model);
                    }

                }
            } catch (Exception e){
                e.printStackTrace();
            }


        }

    }
}
