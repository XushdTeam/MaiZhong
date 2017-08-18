package com.maizhong.youpin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.enums.SMSTemplateEnum;
import com.maizhong.common.result.JsonResult;
<<<<<<< Updated upstream:Youpin/src/main/java/com/maizhong/youpin/service/impl/AppServiceImpl.java
import com.maizhong.common.utils.*;
import com.maizhong.youpin.dto.CompanyDto;
import com.maizhong.youpin.dto.NewsDto;
import com.maizhong.youpin.mapper.CompanyMapper;
import com.maizhong.youpin.mapper.DocMapper;
import com.maizhong.youpin.mapper.UserMapper;
import com.maizhong.youpin.pojo.*;
import com.maizhong.youpin.service.AppService;
=======
import com.maizhong.common.utils.HttpUtils;
import com.maizhong.common.utils.IDUtils;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.youpin.pojo.Doc;
import com.maizhong.youpin.pojo.DocExample;
>>>>>>> Stashed changes:Youpin/src/main/java/com.maizhong.youpin.service/impl/AppServiceImpl.java
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Xushd on 2017/8/16.
 */
@Service
public class AppServiceImpl extends BaseService implements AppService {


    @Autowired
    private DocMapper docMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 获取相关新闻
     * @param pageIndex
     * @return
     */
    @Override
    public JsonResult getNewsList(int pageIndex) {
        String news = super.getJedisClient().hget("NEWS", String.valueOf(pageIndex));
        if(StringUtils.isBlank(news)){
            if(pageIndex>1)return JsonResult.OK(new JSONArray());
            //获取最新10条 后 开启异步同步新闻
            JSONObject pagebean = getNews(1);

            int allPages = pagebean.getIntValue("allPages");
            List<NewsDto> list = getNewsDtoList(pagebean);

            super.getJedisClient().hset("NEWS",String.valueOf(1), JsonUtils.objectToJson(list));
            super.getJedisClient().expire("NEWS",60*60);
            //开启异步获取

            syncGetAllNews(allPages);

            return JsonResult.OK(list);
        }else{
            return JsonResult.OK(JSON.parseArray(news));
        }
    }

    /**
     * 根据deviceId 获取
     * @param deviceId
     * @return
     */
    @Override
    public JsonResult getTokenByDeviceId(String deviceId) {

        String token = IDUtils.sha256(IDUtils.replaceSpecStr(deviceId));
        return JsonResult.build(200,"OK",token);
    }

    /**
     * 获取帮助中心列表
     * @return
     */
    @Override
    public JsonResult getHelpList() {

        DocExample example = new DocExample();
        example.createCriteria().andTypeEqualTo(3);
        List<Doc> docs = docMapper.selectByExample(example);

        return JsonResult.OK(docs);

    }

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @Override
    public JsonResult sendVerifyCode(String phone) {

        String phoneVerifyCode = super.getJedisClient().get("SMS:" + phone);
        if(StringUtils.isNotBlank(phoneVerifyCode)){
            return JsonResult.Error("验证码已发送");
        }
        String verifyCode = IDUtils.getVerifyCode();
        boolean sms = AliSMSUtils.sendSMS2(SMSTemplateEnum.YouPinPaiChe, verifyCode, String.valueOf(phone),"登录");
        if(sms){
            super.getJedisClient().set("SMS:"+phone,verifyCode);
            super.getJedisClient().expire("SMS:"+phone,120);
            return JsonResult.OK("验证码发送成功，请注意查收！");
        }

        return JsonResult.Error("发送失败");
    }

    /**
     * 登录
     * @param phone
     * @param verifyCode
     * @param token
     * @return
     */
    @Override
    public JsonResult login(String phone, String verifyCode, String token) {

        String phoneVerifyCode = super.getJedisClient().get("SMS:" + phone);
        if(StringUtils.isBlank(phoneVerifyCode)){
            return JsonResult.Error("验证码过期，请重新发送");
        } else if(!StringUtils.equals(phoneVerifyCode,verifyCode)){
            return JsonResult.Error("验证码错误");
        } else {
            UserExample example = new UserExample();
            example.createCriteria().andPhoneEqualTo(phone);
            List<User> users = userMapper.selectByExample(example);
            User user = new User();
            if(users.size()==0){
                //注册
                user.setPhone(phone);
                user.setPassword(IDUtils.sha256(phone.substring(7,10)));
                user.setDelflag(0);
                user.setStatus(1);
                user.setCompanyId(0L);
                user.setName(phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
                user.setType(1);
                user.setLevel(0);
                user.setJob("");
                user.setRegisttime(TimeUtils.getFormatDateTime3(new Date()));
                userMapper.insertSelective(user);

            }else{
                //登录
                user = users.get(0);
            }

            super.getJedisClient().set("APP_PERSONAL:"+token, JsonUtils.objectToJson(user));
            if(!StringUtils.equals("17600601529",phone)){
                super.getJedisClient().del("SMS:" + phone);
            }
            return JsonResult.OK(user);
        }

    }

    /**
     * 退出登录
     * @param token
     * @return
     */
    @Override
    public JsonResult logout(String token) {
        super.getJedisClient().del("APP_PERSONAL:"+token);
        return JsonResult.OK();
    }

    /**
     * 获取公司列表
     * @return
     */
    @Override
    public JsonResult getCompanyList() {

        String company_json = super.getJedisClient().get("COMPANY_JSON");
        if(StringUtils.isNotBlank(company_json)){
            return JsonResult.OK(JsonUtils.jsonToList(company_json, CompanyDto.class));
        }else{
            CompanyExample example = new CompanyExample();
            example.createCriteria().andStatusEqualTo(1).andDelflagEqualTo(0);
            List<Company> companies = companyMapper.selectByExample(example);
            List<CompanyDto> list = new ArrayList<>();
            for (Company company : companies) {
                CompanyDto dto = new CompanyDto();
                dto.setId(company.getId());
                dto.setName(company.getName());
                dto.setArea(company.getArea());
                dto.setBrand(company.getLogo());
                list.add(dto);
            }
            super.getJedisClient().set("COMPANY_JSON",JsonUtils.objectToJson(list));
            return JsonResult.OK(list);
        }

    }

    /**
     * 用户信息修改
     * @param company
     * @param companyName
     * @param name
     * @param job
     * @param token
     * @return
     */
    @Override
    public JsonResult updateUserInfo(long company, String companyName, String name, int job, String token) {

        User user = super.getAppUserByToken(token);
        if(user==null)return JsonResult.Error("当前用户未登录!");

        user.setCompanyId(company);
        user.setJob(job+"");
        user.setName(name);
        user.setCompanyName(companyName);

        userMapper.updateByPrimaryKeySelective(user);

        super.getJedisClient().set("APP_PERSONAL:"+token,JsonUtils.objectToJson(user));

        return JsonResult.OK(user);

    }

    /**
     * 修改头像
     * @param headimg
     * @param token
     * @return
     */
    @Override
    public JsonResult changHeadImg(String headimg, String token) {

        User user = super.getAppUserByToken(token);
        if(user==null)return JsonResult.Error("当前用户未登录!");
        user.setHeadimg(headimg);
        userMapper.updateByPrimaryKey(user);
        super.getJedisClient().set("APP_PERSONAL:"+token,JsonUtils.objectToJson(user));

        return JsonResult.OK();
    }

    /**
     * 同步用户信息
     * @param token
     * @return
     */
    @Override
    public JsonResult syncUserInfo(String token) {

        User user = super.getAppUserByToken(token);
        if(user==null)return JsonResult.Error("用户已退出登录");
        return JsonResult.OK(user);
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

        headers.put("Authorization", "APPCODE " + super.getAPPCODE());
        Map<String, String> querys = new HashMap<>();
        querys.put("channelId", "5572a109b3cdc86cf39001e5");
        querys.put("channelName", "");
        querys.put("maxResult", "10");
        querys.put("needAllList", "1");
        querys.put("needContent", "0");
        querys.put("needHtml", "1");
        querys.put("page", String.valueOf(pageIndex));
        querys.put("title", "");

        try {

            HttpResponse response = HttpUtils.doGet(super.getAPI_URL(), "/newsList", "GET", headers, querys);
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
                    saveNews(pageIndex,newsDtoList);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    public void saveNews(int pageIndex,List<NewsDto> newsDtoList){
        super.getJedisClient().hset("NEWS",String.valueOf(pageIndex), JsonUtils.objectToJson(newsDtoList));
    }
}
