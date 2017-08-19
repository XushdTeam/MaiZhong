package com.maizhong.youpin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.enums.SMSTemplateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.*;

import com.maizhong.youpin.dto.*;
import com.maizhong.youpin.mapper.*;
import com.maizhong.youpin.pojo.*;
import com.maizhong.youpin.pojo.Model;
import com.maizhong.youpin.service.AppService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private SaleRecordMapper saleRecordMapper;
    @Autowired
    private SaleImgMapper saleImgMapper;

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

            if(user.getCompanyId()==0L){
                user.setCompanyName("未选择");
            }else{
                Company company = companyMapper.selectByPrimaryKey(user.getCompanyId());
                user.setCompanyName(company.getName());
            }
            int job = 0;
            String job1 = user.getJob();
            if(StringUtils.isNotBlank(job1)){
                job = Integer.parseInt(job1);
            }

            switch (job){
                case 1:user.setJobName("CEO");break;
                case 2:user.setJobName("经理");break;
                case 3:user.setJobName("销售");break;
                case 4:user.setJobName("评估师");break;
                default:user.setJobName("其他");break;
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
        switch (job){
            case 1:user.setJobName("CEO");break;
            case 2:user.setJobName("经理");break;
            case 3:user.setJobName("销售");break;
            case 4:user.setJobName("评估师");break;
            case 5:user.setJobName("其他");break;
        }

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
     * 获取model
     *
     * @param token
     * @param guzhiKey
     * @param otherKey
     * @return
     */
    @Override
    public JsonResult getModelDetail(String guzhiKey, String otherKey, String token) {

        AppRecordDto dto = new AppRecordDto();

        dto.setParam1(guzhiKey);
        dto.setParam2(otherKey);

        String[] paramarry = guzhiKey.split("c|m|r|g");

        //城市
        dto.setCityId(paramarry[1]);
        String city = super.getJedisClient().hget("CITY_KEY",paramarry[1]);
        dto.setCityName(city);
        //车型
        dto.setModelId(paramarry[2]);
        String car_model = super.getJedisClient().hget("CAR_MODEL", paramarry[2]);
        Model model = JsonUtils.jsonToPojo(car_model, Model.class);
        //图片
        int seriesId = model.getSeriesId();
        String car_series_key = super.getJedisClient().hget("CAR_SERIES_KEY", seriesId + "");
        Series series = JsonUtils.jsonToPojo(car_series_key, Series.class);
        dto.setImg(series.getSeriesPic());

        dto.setModelName(model.getModelName());
        //排量
        dto.setLiter(model.getLiter());
        //排放标准
        dto.setPfbz(model.getDischargeStandard());

        //上牌数据
        dto.setRegistTime(paramarry[3]);
        //公里数
        dto.setGls(paramarry[4]);

        String[] otherArry = otherKey.split("o|j|h|t|x|n|d|k");

        String ck = otherArry[7], color = otherArry[0], jqx = otherArry[1],
                gh = otherArry[2], ghtime = otherArry[3], xz = otherArry[4],
                nj = otherArry[5], method = otherArry[6];

        if (StringUtils.equals("1", ck)) {
            dto.setCk("车况优秀,好没有任何故障");
        } else if (StringUtils.equals("2", ck)) {
            dto.setCk("车况良好,有过少量剐蹭或钣金");
        } else if (StringUtils.equals("3", ck)) {
            dto.setCk("车况一般,有过前后轻碰事故");
        } else {
            dto.setCk("车况较差,有发生过伤及主体框架的碰撞或较大事故");
        }
        //颜色
        switch (color) {
            case "1":
                dto.setColor("米色");
                break;
            case "2":
                dto.setColor("白色");
                break;
            case "3":
                dto.setColor("灰色");
                break;
            case "4":
                dto.setColor("红色");
                break;
            case "5":
                dto.setColor("棕色");
                break;
            case "6":
                dto.setColor("蓝色");
                break;
            case "7":
                dto.setColor("黄色");
                break;
            case "8":
                dto.setColor("黑色");
                break;
            case "9":
                dto.setColor("银色");
                break;
            case "10":
                dto.setColor("绿色");
                break;
            default:
                dto.setColor("其他颜色");
                break;
        }
        //交强险
        if (StringUtils.equals(jqx, "1")) {
            dto.setJqx("两个月以内");
        } else {
            dto.setJqx("两个月以上");
        }
        //过户
        if (StringUtils.equals(gh, "4")) {
            dto.setGh("0次");
        } else if (StringUtils.equals(gh, "1")) {
            dto.setGh("1次");
        } else if (StringUtils.equals(gh, "2")) {
            dto.setGh("2次");
        } else {
            dto.setGh("3次及以上");
        }
        //过户时间
        if (StringUtils.equals(ghtime, "1")) {
            dto.setGhtime("无过户");
        } else if (StringUtils.equals(ghtime, "2")) {
            dto.setGhtime("六个月以内");
        }else
        {
            dto.setGhtime("六个月以上");
        }
        //性质
        if (StringUtils.equals(xz, "1")) {
            dto.setXz("非营运");
        } else {
            dto.setXz("租赁");
        }
        //年检
        if (StringUtils.equals(nj, "1")) {
            dto.setNj("两个月以内");
        } else {
            dto.setNj("两个月以上");
        }
        //使用方式
        if (StringUtils.equals(method, "1")) {
            dto.setMethod("公司");
        } else {
            dto.setMethod("个人");
        }

        super.getJedisClient().set("RECORD:"+token,JsonUtils.objectToJson(dto));
        super.getJedisClient().expire("RECORD:"+token,60*10);

        return JsonResult.OK(dto);
    }

    /**
     * 提交申请
     * @param imgArry
     * @param token
     * @return
     */

    @Transactional
    @Override
    public JsonResult saveSaleRecord(String imgArry,String token) {

        User user = super.getAppUserByToken(token);
        if(user==null)return JsonResult.Error("当前用户非登录状态");

        String s = super.getJedisClient().get("RECORD:" + token);
        if(StringUtils.isBlank(s))return JsonResult.Error("数据失效，重新选择");

        AppRecordDto appRecordDto = JsonUtils.jsonToPojo(s, AppRecordDto.class);

        long orderId = IDUtils.getOrderId();
        SaleRecord record = new SaleRecord();
        record.setOrdernum(orderId+"");
        record.setCityId(appRecordDto.getCityId());
        record.setCk(appRecordDto.getCk());
        record.setColor(appRecordDto.getColor());
        String createTime = TimeUtils.getFormatDateTime3(new Date());
        record.setCreatetime(createTime);
        record.setGh(appRecordDto.getGh());
        record.setJqx(appRecordDto.getJqx());
        record.setMethod(appRecordDto.getMethod());
        record.setGhtime(appRecordDto.getGhtime());
        record.setModelId(Long.valueOf(appRecordDto.getModelId()));
        record.setNj(appRecordDto.getNj());
        record.setRegDate(appRecordDto.getRegistTime());
        record.setsKm(appRecordDto.getGls());
        record.setXz(appRecordDto.getXz());
        record.setStatus(1);
        record.setUserId(user.getId());

        saleRecordMapper.insertSelective(record);

        Long id = record.getId();

        String[] split = imgArry.split(",");
        SaleImg img = new SaleImg();
        img.setRecordId(id);
        img.setImg1(split[0]);
        img.setImg2(split[1]);
        img.setImg3(split[2]);
        img.setImg4(split[3]);
        img.setImg5(split[4]);
        img.setImg6(split[5]);

        saleImgMapper.insertSelective(img);

        appRecordDto.setImgArry(imgArry);
        appRecordDto.setOrderNum(orderId+"");
        appRecordDto.setSubmitTime(createTime);

        super.getJedisClient().hset("RECORD_INFO",orderId+"",JsonUtils.objectToJson(appRecordDto));

        return JsonResult.OK();
    }

    /**
     * 获取提交记录
     * @param token
     * @return
     */
    @Override
    public JsonResult getRecordList(String token) {

        User user = super.getAppUserByToken(token);
        if(user==null)return JsonResult.Error("当前用户非登录状态");

        SaleRecordExample example = new SaleRecordExample();
        example.createCriteria().andUserIdEqualTo(user.getId());

        List<SaleRecord> saleRecords = saleRecordMapper.selectByExample(example);
        List<AppRecordDto> list = new ArrayList<>();
        for (SaleRecord saleRecord : saleRecords) {
            String ordernum = saleRecord.getOrdernum();

            String record_info = super.getJedisClient().hget("RECORD_INFO", ordernum);
            if(StringUtils.isBlank(record_info))continue;

            AppRecordDto appRecordDto = JsonUtils.jsonToPojo(record_info, AppRecordDto.class);

            appRecordDto.setStatus(saleRecord.getStatus());
            appRecordDto.setPrice(saleRecord.getPrice());

            list.add(appRecordDto);
        }

        return JsonResult.OK(list);

    }


    /**
     * 获取职位列表
     * @return
     */
    @Override
    public JsonResult getJobList() {

        List<JobDto> list = new ArrayList<>();
        list.add(new JobDto(1,"CEO"));
        list.add(new JobDto(2,"经理"));
        list.add(new JobDto(3,"销售"));
        list.add(new JobDto(4,"评估师"));
        list.add(new JobDto(5,"其他"));

        return JsonResult.OK(list);
    }

//    /**
//     * 获取估值结果
//     * @param param
//     * @return
//     */
//
//    public JsonResult getGuzhi(String param) {
//
//
//        // 测试
//       /* WebSocketTest webSocketTest = new WebSocketTest();
//
//        webSocketTest.SendMessages("<html><a onclick=\"openOrders('/orders/handle/138')\">测试</a></html>");*/
//        //测试
//
//        try {
//
//            String redisJson = null;
////            try {
////                redisJson = jedisClient.hget("GUZHI", param);
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////
////            if (StringUtils.isNotBlank(redisJson)) {
////
////                return JsonResult.OK(JsonUtils.jsonToPojo(redisJson, GuzhiDTO.class));
////            }
//
//            String[] paramarry = param.split("c|m|r|g");
//            String url = String.format("%s?token=%s&modelId=%s&regDate=%s&mile=%s&zone=%s", GUZHI, token, paramarry[2], paramarry[3], paramarry[4], paramarry[1]);
//
//
//
//
//            String res = HttpClientUtil.doGet(url);
//
//            JSONObject jsonObject = JSON.parseObject(res);
//            JSONArray eval_prices = jsonObject.getJSONArray("eval_prices");
//
//
//
//
//
//
//            Gzrecord gzrecord = new Gzrecord();
//            gzrecord.setParam(param);
//            gzrecord.setCity(Integer.valueOf(paramarry[1]));
//            gzrecord.setMail(paramarry[4]);
//            gzrecord.setModelId(Long.valueOf(paramarry[2]));
//            gzrecord.setRegDate(paramarry[3]);
//            gzrecord.setTime(new Date());
//
//            for (Object eval_price : eval_prices) {
//                JSONObject object = (JSONObject) eval_price;
////
//                /**
//                 * 修改 2017-0804 修改 段位价格整体下移
//                 */
//                if (object.getString("condition").equals("excellent")) {
//                    //车况优秀
////                    gzrecord.setPriceMaxA(object.getString("individual_low_sold_price"));
////                    gzrecord.setPriceMinA(object.getString("dealer_low_buy_price"));
//                }
//                if (object.getString("condition").equals("good")) {
//                    //车况优秀
//                    gzrecord.setPriceMaxA(object.getString("individual_low_sold_price"));
//                    gzrecord.setPriceMinA(object.getString("dealer_low_buy_price"));
//
//                }
//                if (object.getString("condition").equals("normal")) {
//                    //车况良好
//                    gzrecord.setPriceMaxB(object.getString("individual_low_sold_price"));
//                    gzrecord.setPriceMinB(object.getString("dealer_low_buy_price"));
////                    //车况一般
////                    gzrecord.setPriceMaxC(object.getString("individual_low_sold_price"));
////                    gzrecord.setPriceMinC(object.getString("dealer_low_buy_price"));
//                    //车况一般
//                    gzrecord.setPriceMaxC(new BigDecimal(object.getDouble("individual_low_sold_price") * 0.94).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
//                    gzrecord.setPriceMinC(new BigDecimal(object.getDouble("dealer_low_buy_price") * 0.94).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
//
////                  //车况较差
//                    gzrecord.setPriceMaxD(new BigDecimal(object.getDouble("individual_low_sold_price") * 0.94 * 0.94).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
//                    gzrecord.setPriceMinD(new BigDecimal(object.getDouble("dealer_low_buy_price") * 0.94 * 0.94).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
//                }
//
//            }
//
//
//            com.maizhong.common.dto.GuzhiDTO guzhiDTO = new com.maizhong.common.dto.GuzhiDTO();
//            guzhiDTO.setPriceA(gzrecord.getPriceMinA() + "万~" + gzrecord.getPriceMaxA() + "万");
//            guzhiDTO.setPriceA_max(gzrecord.getPriceMaxA());
//            guzhiDTO.setPriceA_min(gzrecord.getPriceMinA());
//            guzhiDTO.setPriceB(gzrecord.getPriceMinB() + "万~" + gzrecord.getPriceMaxB() + "万");
//            guzhiDTO.setPriceB_max(gzrecord.getPriceMaxB());
//            guzhiDTO.setPriceB_min(gzrecord.getPriceMinB());
//            guzhiDTO.setPriceC(gzrecord.getPriceMinC() + "万~" + gzrecord.getPriceMaxC() + "万");
//            guzhiDTO.setPriceC_max(gzrecord.getPriceMaxC());
//            guzhiDTO.setPriceC_min(gzrecord.getPriceMinC());
//            guzhiDTO.setPriceD(gzrecord.getPriceMinD() + "万~" + gzrecord.getPriceMaxD() + "万");
//            guzhiDTO.setPriceD_max(gzrecord.getPriceMaxD());
//            guzhiDTO.setPriceD_min(gzrecord.getPriceMinD());
//
//
//            String modelRedis = jedisClient.hget("CAR_MODEL", gzrecord.getModelId() + "");
//
//            Model model = JsonUtils.jsonToPojo(modelRedis, Model.class);
//
//            if(StringUtils.isNotBlank(modelRedis)){
//
//                ModelExample example = new ModelExample();
//                ModelExample.Criteria criteria = example.createCriteria();
//                criteria.andModelIdEqualTo(Long.parseLong(paramarry[2]));
//                long l = modelMapper.countByExample(example);
//                if(l==0){
//                    modelMapper.insert(model);
//                }
//            }
//
//
//            guzhiDTO.setMaxYear(model.getMaxRegYear() + "");
//            guzhiDTO.setMinYear(model.getMinRegYear() + "");
//
//            guzhiDTO.setModelId(model.getModelId() + "");
//
//            guzhiDTO.setModelName(model.getModelName());
//            guzhiDTO.setDischargeStandard(model.getDischargeStandard());
//            guzhiDTO.setLiter(model.getLiter());
//            guzhiDTO.setModelPrice(model.getModelPrice() + "");
//            guzhiDTO.setGearType(model.getGearType());
//
//            guzhiDTO.setMail(gzrecord.getMail() + "");
//            guzhiDTO.setCity(jedisClient.hget("CITY_KEY", gzrecord.getCity() + ""));
//
//            String seriesRedis = jedisClient.hget("CAR_SERIES_KEY", model.getSeriesId() + "");
//
//            Series series = JsonUtils.jsonToPojo(seriesRedis, Series.class);
//            guzhiDTO.setSeriesImg(series.getSeriesPic());
//            guzhiDTO.setSeriesId(series.getSeriesId() + "");
//            guzhiDTO.setBrandId(series.getBrandId() + "");
//
//            guzhiDTO.setRegdate(gzrecord.getRegDate().replace("-", "年") + "月");
//
//
//            jedisClient.hset("GUZHI", param, JsonUtils.objectToJson(guzhiDTO));
//            gzrecordMapper.insert(gzrecord);
//
//            return JsonResult.OK(guzhiDTO);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }








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
