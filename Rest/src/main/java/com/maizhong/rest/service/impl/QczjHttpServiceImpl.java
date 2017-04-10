package com.maizhong.rest.service.impl;

import com.maizhong.common.dto.KeyValue;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.maizhong.rest.service.QczjhttpService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户获取qczj数据
 *      数据参数   车型 年份 公里数
 *
 *      获取全部数据
 *          解析页面
 *
 *
 *
 * Created by yangF on 2017/4/3.
 */
 @Service
public class QczjHttpServiceImpl implements QczjhttpService {

    /**
     *  根据品牌Id获取车系
     *      http数据结构
     *          var br=new Array();br['173']='3557,北京汽车 绅宝D20,3794,北京汽车 绅宝D20';
     * @param brandId
     * @return
     */
    @Override
    public JsonResult returnCarSeries(Long brandId) {

        Map<String,List<KeyValue>> map = new HashMap<>();
        try {
            //请求发送
            String json = qczjHttpGet("2", "bid", brandId.toString());
            String[] result = json.split(";")[1].split("=")[1].replace("'", "").split(",");
        //////////////////////////////////////////////////////////////////
        //    数据格式为
        //        '3557,北京汽车 绅宝D70,3794,北京汽车 绅宝D50';
        //        转换格式为
        //            [
        //                {“北京汽车”:[
        //                        {“3557”：“绅宝D20”}，
        //                        {“3584”：“绅宝D50”}
        //                    ]
        //            ]
        ////////////////////////////////////////////////////////////////////
            //数据传递
            for (int i=0;result.length-i>2;){
                String[] car = result[i + 1].split(" ");

                List<KeyValue> keyValue = map.get(car[0]);
                if (keyValue==null){
                    keyValue = new ArrayList<>();
                }

                keyValue.add(new KeyValue(result[i],car[1]));
                map.put(car[0],keyValue);

                i=i+2;
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("数据解析错误：汽车品牌获取数据错误");
        }
        return JsonResult.OK(map);
    }

    /**
     * 根据车系Id 获取 车型
     *
     *         请求返回数据格式
     *         [{
     *              "year":"2014款",
     *              "maxlen":22,
     *              spec:[
     *                      {"id":18723,"name":"2014款 2.0T 自动豪华型"},
     *                      {"id":20085,"name":"2014款 2.0T 手动基本型"}
     *                  ]
     *         }]
     *
     * @param seriesId
     * @return
     */
    @Override
    public JsonResult returnCarType(Long seriesId) {
        //请求发送
        String json = qczjHttpGet("2", "seriesid",seriesId.toString());

        List<QczjCarSeries> result = JsonUtils.jsonToList(json, QczjCarSeries.class);
//
        return JsonResult.OK(result);
    }

    /**
     *
     *     bid=33&sid=18&specId=27956            //
     *       &registerYear=2017&registerMonth=1  //初次上牌时间
     *       &pid=110000&cid=110100          //卖车地区选项
     *            &selectCarName=%u5965%u8FEAA6L%202017%u6B3E%20TFSI%20%u8FD0%u52A8%u578B
     *            &pvareaid=100656            //浏览器地区选项  应该存在默认值
     *            &sellMark=uahp10004         //
     *
     * @param carYear
     * @param distance
     * @return
     */
    /**
     *      用途： 获取汽车之家网站上拥有的数据
     *
     *      方法一共发送两个请求
     *              第一个请求过去freemarket的模板id
     *              第二个请求获取真实页面并解析返回minprice与maxprice
     *
     *          http://www.che168.com/Handler/GetCarYearBySpecId.ashx?specid=20396
     *              根据汽车id返回汽车年份
     *
     *
     *     bid=33&sid=18&specId=27956            //
     *       &registerYear=2017&registerMonth=1  //初次上牌时间
     *       &pid=110000&cid=110100          //卖车地区选项
     *            &selectCarName=%u5965%u8FEAA6L%202017%u6B3E%20TFSI%20%u8FD0%u52A8%u578B
     *            &pvareaid=100656            //浏览器地区选项  应该存在默认值
     *            &sellMark=uahp10004         //
     * @param bid
     * @param sid
     * @param specId
     * @param registerYear
     * @param registerMonth
     * @param selectCarName
     * @return
     */
    @Override
    public  JsonResult calculatePrice(String bid, String sid, String specId,
                                            String registerYear, String registerMonth,
                                            String selectCarName) {
        //eva_0为默认值   可用   //可用个屁
        String evaCode = new String("http://www.che168.com/Evaluate/v2/EvaCar.aspx?pgtype=1&pgbid="+bid+"&pgsid="+sid+"&pgspid="+specId+"&pgyear="+registerYear+"&pgmonth="+registerMonth+"&pgpid=110000&pgcid=110100&pgmlg=12&type=1&sellMark=uahp10004");

//        &selectCarName="+selectCarName+"
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Host","www.che168.com");
        headers.put("Referer","http://www.che168.com/pinggu/");
        headers.put("Accept-Language","zh-CN,zh;q=0.8");
        headers.put("Connection","keep-alive");
        headers.put("Accept-Encoding","gzip, deflate, sdch");
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.87 Safari/537.36");

        try {

//            ec_pid + "&pgcid=" + ec_cid + "&pgmlg=" + ec_mlg + "&type=1" + "&sellMark=" + "uahp10004";
            //获取消息中的标记
            String messageJson = doGet(evaCode, headers, null);
            Map map = JsonUtils.jsonToPojo(messageJson, Map.class);
            //返回数据格式为 ['xxxx']  有可能出现返回两个数据的情况
            String message = map.get("message").toString() ;
            if(!message.contains(",")){
                message = map.get("message").toString().replaceAll("[^0-9]","");
            }else{
                //获取数组中第一个数据
                message = message.substring(0,message.indexOf(",")).replaceAll("[^0-9]","");
            }
            //pid  cid 为地区  此方法限定为北京   selectCarName为页面编码后的carName    pvareaid为用户页面所选地区的id  &sellMark=uahp10004设为默认值
            String url = new String("http://www.che168.com/pinggu/eva_"+message+"/1.html?bid="+bid+"&sid="+sid+"&specId="+specId+"&registerYear="+registerYear+"&registerMonth="+registerMonth
                    +"&pid=110000&cid=110100&pvareaid=100656");

            headers.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            headers.remove("Content-Type");

            HashMap<String, String> param = new HashMap<>();
            param.put("selectCarName",selectCarName);
            //获取response页面的数据
            String html = doGet(url, headers, param);
            String[] split = html.substring(html.indexOf("minPrice ="), html.indexOf("isSuccess =")).split(";");
            String minprice = "";
            String maxpriec = "";
            for (String string:split) {
                String trim = string.replaceAll("[^\\d.]","").trim();
                if (StringUtils.isNotBlank(trim)){
                    if (StringUtils.isBlank(minprice)){
                        minprice = trim;
                    }else{
                        maxpriec = trim;
                    }
                }
            }
            Map<String, String> result = new HashMap<>();
            result.put("minprice",minprice);
            result.put("maxprice",maxpriec);
            return JsonResult.OK(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.Error("服务器繁忙，请稍候再试");
    }

    /**
     *      用途：获取汽车之家网站中的汽车年份与汽车公里数
     *
     *          http://www.che168.com/Handler/GetCarYearBySpecId.ashx?specid=20396
     *              根据汽车id返回汽车年份
     *
     *          http://api.assess.che168.com/api/AssessMileageYear.ashx
     *                  ?_appid=2sc&_callback=loaddefaultdatecallback&specid=20396&callback=_callback
    */
    @Override
    public JsonResult carBrandCallback(Long specid){

        //数据初始化
        Map returnResult = new HashMap();

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept","text/plain, */*; q=0.01");
        headers.put("Host","www.che168.com");
        headers.put("Referer","http://www.che168.com/pinggu/");
        headers.put("Accept-Language","zh-CN,zh;q=0.8");
        headers.put("Connection","keep-alive");
        headers.put("Accept-Encoding","gzip, deflate, sdch");
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.87 Safari/537.36");
        headers.put("X-Requested-With","XMLHttpRequest");


        String getYearUrl = new String("http://www.che168.com/Handler/GetCarYearBySpecId.ashx?specid="+specid);

        //返回为  字符串   2014
        String year = doGet(getYearUrl, headers, null);
        returnResult.put("year",year);

        //
        //获取排量与年份
        //数据样式
        //loaddefaultdatecallback({"returncode":0,"message":"","result":{"buydate":"2014-09-01","mileage":"3.7"}})
        String getMileageUrl = new String("http://api.assess.che168.com/api/AssessMileageYear.ashx?_appid=2sc&_callback=loaddefaultdatecallback&specid="+specid+"&callback=_callback");
        headers.put("Accept","*/*");
        headers.put("Host","api.assess.che168.com");
        headers.remove("X-Requested-With");
        String message = doGet(getMileageUrl, headers, null);
        if (StringUtils.isNotBlank(message)){
            String substring = message.substring(message.indexOf("(")+1, message.lastIndexOf(")"));
            if (StringUtils.isNotBlank(substring)){
                Map map = JsonUtils.jsonToPojo(substring, Map.class);
                if (map.get("result")!=null){
                    Map result = (Map) map.get("result");
                    returnResult.put("buydate",result.get("buydate"));
                    returnResult.put("mileage",result.get("mileage"));
                }
            }
        }
        return JsonResult.OK(returnResult);
    }




    /**
     * 用于json数据的传送
     *          适用于 车型获取 车系获取
     * @param dataType
     * @param getType
     * @param paramId
     * @return
     */
    private  String  qczjHttpGet(String dataType,String getType,String paramId) {
        String path = "http://www.che168.com/Handler/ScriptCarList_V1.ashx?seriesGroupType=2&needData="+dataType+"&"+getType+"="+paramId;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Referer","http://www.che168.com/pinggu/");
        headers.put("Accept-Language","zh-CN,zh;q=0.8");
        headers.put("Connection","keep-alive");
        headers.put("Accept-Encoding","gzip, deflate, sdch");
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.87 Safari/537.36");
        headers.put("X-Requested-With","XMLHttpRequest");
        headers.put("Host","www.che168.com");

        try {
            Map<String, String> param = new HashMap<>();

            //获取response的数据
            return doGet(path, headers, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 通用方法
     *          可以传入header参数
     * @param url
     * @param headers
     * @param param
     * @return
     */
    private String doGet(String url, Map<String, String> headers, Map<String, String> param) {

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));

                }
            }
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            for (Map.Entry<String, String> e : headers.entrySet()) {
                httpGet.addHeader(e.getKey(), e.getValue());
            }
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }
}
///////////////////////////////////////////////////////////////////////////////////
//                  [{
//                      "year":"2014款",
//                      "maxlen":22,
//                      spec:[
//                              {"id":18723,"name":"2014款 2.0T 自动豪华型"},
//                              {"id":20085,"name":"2014款 2.0T 手动基本型"}
//                          ]
//                 }]
///////////////////////////////////////////////////////////////////////////////////
class  QczjCarSeries{
    private String year;
    private String maxlen;
    private List<Map<String,String>> spec;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMaxlen() {
        return maxlen;
    }

    public void setMaxlen(String maxlen) {
        this.maxlen = maxlen;
    }

    public List<Map<String, String>> getSpec() {
        return spec;
    }

    public void setSpec(List<Map<String, String>> spec) {
        this.spec = spec;
    }
}

