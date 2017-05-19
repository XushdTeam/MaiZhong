package com.maizhong.reckon.controller;

import com.alibaba.fastjson.JSON;
import com.maizhong.common.dto.GuzhiDTO;
import com.maizhong.common.result.JsonResult;

import com.maizhong.pojo.Line;
import com.maizhong.reckon.DTO.IndexDTO;
import com.maizhong.reckon.DTO.OrderDTO;
import com.maizhong.reckon.service.IndexService;
import com.maizhong.reckon.service.LoginService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Xushd on 2017/4/18.
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/")
    public String index(Model model){

        IndexDTO indexDTO = indexService.getIndexDTO();
        JsonResult result =indexService.getBusinessAddress();
        JsonResult result1 = indexService.getHotBrand();
        JsonResult result2 = indexService.getHotSeries();
        model.addAttribute("brandList",indexDTO.getBrandList());
        model.addAttribute("proviceList",indexDTO.getProviceList());
        model.addAttribute("shopList",result.getData());
        model.addAttribute("hotBrand",result1.getData());
        model.addAttribute("hotSeries",result2.getData());
        return "index";
    }
    @RequestMapping(value = "/index")
    public String index1(Model model){

        IndexDTO indexDTO = indexService.getIndexDTO();

        model.addAttribute("brandList",indexDTO.getBrandList());
        model.addAttribute("proviceList",indexDTO.getProviceList());
        return "index";
    }



   @RequestMapping(value = "/{page}")
   public String test(@PathVariable String page){
      return page;
   }

    /**
     * 跳转到活动页
     * @param activityId
     * @return
     */
    @RequestMapping(value = "/activity/{activityId}")
    public String activity(@PathVariable String activityId,Model model){
        String modelview = null;
        if(StringUtils.equals("1",activityId)){
            modelview = "prepo";
        }
        if(StringUtils.equals("2",activityId)){
            modelview = "zhihuan";
        }
        if(StringUtils.equals("3",activityId)){
            modelview = "act";
        }
        model.addAttribute("key","activity");

        return modelview;

    }

    @RequestMapping(value = "/app")
    public String appdown(Model model){

        model.addAttribute("key","app");
        return "prepo";
    }

    @RequestMapping(value = "/zhihuancar")
    @ResponseBody
    public JsonResult zhihuan(String phone){
        indexService.zhihuan(phone);
        return JsonResult.OK();
    }

    /**
     * 获取车系
     * @param brandId
     * @return
     */
    @RequestMapping(value = "/series/series_brand/{brandId}")
    @ResponseBody
    public JsonResult getSeries(@PathVariable String brandId){

        JsonResult result = indexService.getSeries(brandId);
        return result;
    }

    /**
     * 获取车型
     * @param seriesId
     * @return
     */
    @RequestMapping(value = "/model/model_series/{seriesId}")
    @ResponseBody
    public JsonResult getCarType(@PathVariable String seriesId){
        JsonResult result = indexService.getCarType(seriesId);
        return result;
    }

    /**
     * 获取所有城市
     * @return
     */
    @RequestMapping(value = "/getAllCity")
    @ResponseBody
    public JsonResult getAllCity(){
        JsonResult result = indexService.getAllCity();
        return result;
    }

    /**
     * 跳转到估值页面
     * @param param
     * @param model
     * @return
     */
    @RequestMapping(value = "/guzhi/{param}")
    public String compute(@PathVariable String param,Model model){

        String params = param;
        GuzhiDTO guzhiDTO = indexService.getGuZhi(param);
        model.addAttribute("result",guzhiDTO);
        model.addAttribute("ppap",params);


        return "guzhi";
    }

    /**
     * 估值完成后跳转
     * @param model
     * @param param
     * @return
     */
    @RequestMapping(value = "/sale/{param}")
    public String sale(Model model,@PathVariable String param){

        IndexDTO indexDTO = indexService.getIndexDTO(param);
      //  model.addAttribute("brandList",indexDTO.getBrandList());
       // model.addAttribute("proviceList",indexDTO.getProviceList());
        model.addAttribute("result",indexDTO);
        model.addAttribute("second","1");
        return "jingzhun";
    }

    @RequestMapping(value = "/sale/model/{param}")
    public String saleSe(Model model,@PathVariable String param){

        IndexDTO indexDTO = indexService.getIndexDTOSe(param);
        model.addAttribute("result",indexDTO);
        model.addAttribute("second","1");
        return "jingzhun";
    }

    /**
     * 未估值直接跳转
     * @param model
     * @return
     */
    @RequestMapping(value = "/sale")
    public String sale(Model model){
        IndexDTO indexDTO = indexService.getIndexDTO();
        model.addAttribute("result",indexDTO);
//        model.addAttribute("brandList",indexDTO.getBrandList());
//        model.addAttribute("proviceList",indexDTO.getProviceList());
        model.addAttribute("second","0");
        return "jingzhun";
    }

    @RequestMapping(value = "/login")
    public String login(){

        return "dl";
    }

    /**
     * 精准估值结果
     * @param param
     * @return
     */
    @RequestMapping(value="/saleguzhi/{param}")
    public String saleguzhi(@PathVariable String param, Model model,
                            @CookieValue(value = "phone",required = true) String phone
    ){

        String[] arry = param.split("o");
        String guzhiKey = arry[0];
        String otherKey = arry[1];

        String price = indexService.saleguzhi(guzhiKey,otherKey, Long.valueOf(phone));

        model.addAttribute("price",price);

        return "jiage";
    }

    @RequestMapping(value = "/yuyue")
    public String yuyue( @CookieValue(value = "phone",required = true) String phone,Model model){



        GuzhiDTO guzhiDTO = indexService.getYuyueInfo(phone);
        List<Line> lineList = indexService.getLineList();
        JsonResult result =indexService.getBusinessAddress();
        JsonResult result1 =indexService.getOneWeek();

        model.addAttribute("shop",result.getData());
        model.addAttribute("week",result1.getData());
        model.addAttribute("result",guzhiDTO);
        model.addAttribute("lines",lineList);
        return "yuyue";
    }

    /**
     * 获取地铁站信息
     * @param lineId
     * @return
     */
    @RequestMapping(value = "getSite/{lineId}")
    @ResponseBody
    public JsonResult getSiteByLineId(@PathVariable String lineId){

        JsonResult result = indexService.getSiteByLineId(lineId);

        return result;
    }

    /**
     * 订单确认
     * @param orderNumber 订单编号
     * @param dealWay 交易方式 1 4S店 2 地铁站 3 上门
     * @param wayId  4S店ID 或者 地铁站ID
     * @param linkMan 联系人
     * @param linkPhone 联系人手机号
     * @param address 上门地址
     * @return
     */
    @RequestMapping(value = "/OrderConfim",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult orderConfim(String orderNumber,
                                  String dealWay,
                                  String wayId,
                                  String linkMan,
                                  String linkPhone,
                                  String checktime,
                                  String address ){

        JsonResult result = indexService.orderConfim(orderNumber,dealWay,wayId,linkMan,linkPhone,checktime,address);
        return result;
    }

    /**
     * 跳转到个人中心
     * @param phone
     * @param token
     * @param model
     * @return
     */
    @RequestMapping(value = "/per/{cu}")
    public String userCenter(@CookieValue(value = "phone",required = false) String phone,
                             @CookieValue(value = "token",required = false) String token,
                             @PathVariable String cu,
                             Model model){

        if(StringUtils.isBlank(phone)||StringUtils.isBlank(token)){
            return "dl";
        }else{
            JsonResult result = loginService.loginByToken(phone,token);
            if(result.getStatus()==200){

                List<OrderDTO> list = indexService.getOrderDTO(phone);

                model.addAttribute("orderInfo",list);
                model.addAttribute("phone",phone);
                return cu;
            }else{
                return "dl";
            }
        }
    }

    @RequestMapping("/about")
    public String about(Model model){

        model.addAttribute("mark","about");
        model.addAttribute("key","1");
        return "about";
    }
    @RequestMapping("/about/{key}")
    public String aboutkey(Model model,@PathVariable String key){

        model.addAttribute("mark","about");
        model.addAttribute("key",key);
        return "about";
    }
    @RequestMapping("/help")
    public String help(Model model){

        model.addAttribute("mark","help");
        model.addAttribute("key","1");
        return "about";
    }
    @RequestMapping("/help/{key}")
    public String help(Model model,@PathVariable String key){

        model.addAttribute("mark","help");
        model.addAttribute("key",key);
        return "about";
    }
    @RequestMapping("/join")
    public String join(Model model){

        model.addAttribute("mark","join");
        model.addAttribute("key","1");
        return "about";
    }
    @RequestMapping("/join/{key}")
    public String join(Model model,@PathVariable String key){

        model.addAttribute("mark","join");
        model.addAttribute("key",key);
        return "about";
    }
    @RequestMapping("/work")
    public String work(Model model){

        model.addAttribute("mark","work");
        model.addAttribute("key","1");
        return "about";
    }
    @RequestMapping("/work/{key}")
    public String work(Model model,@PathVariable String key){

        model.addAttribute("mark","work");
        model.addAttribute("key",key);
        return "about";
    }

    @RequestMapping("/deal")
    public String deal(Model model){

        model.addAttribute("mark","deal");
        model.addAttribute("key","1");
        return "about";
    }
    @RequestMapping("/deal/{key}")
    public String dealKey(Model model,@PathVariable String key){

        model.addAttribute("mark","deal");
        model.addAttribute("key",key);
        return "about";
    }

    @RequestMapping("/check")
    public String check(Model model){

        model.addAttribute("mark","check");
        model.addAttribute("key","1");
        return "about";
    }
    @RequestMapping("/check/{key}")
    public String check(Model model,@PathVariable String key){

        model.addAttribute("mark","check");
        model.addAttribute("key",key);
        return "about";
    }

    @RequestMapping("/news/{id}")
    public String news(@PathVariable String id){
        String result = null;
        if(StringUtils.equals("1",id)){
            result = "news1";
        }else{
            result = "news2";
        }
        return result;
    }

    @RequestMapping(value = "/wanthz",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult wanthz(String txt_companyname,
                            String txt_contactperson,
                            String txt_tel,
                            String txt_city,
                            String txt_remark)
    {
        indexService.wanghz(txt_companyname,txt_contactperson,txt_tel,txt_city,txt_remark);
        return JsonResult.OK();
    }

    @RequestMapping(value = "/app/ac/{acPage}")
    public String startac(@PathVariable String acPage){

        return acPage;
    }

    @RequestMapping(value = "/app/download")
    public String scanDown(HttpServletRequest request,Model model){
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        OperatingSystem os = userAgent.getOperatingSystem();
        String key = os.toString().toLowerCase();
        if(key.contains("android")){
            //安卓
            model.addAttribute("key","android");
        }else if(key.contains("mac")){
            //IOS
            model.addAttribute("key","ios");
        }
        return "appdownload";
    }

}
