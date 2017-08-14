package com.maizhong.auction.controller;

import com.alibaba.fastjson.JSONObject;
import com.maizhong.auction.dto.CarDetailDto;
import com.maizhong.auction.dto.CarInfoDto;
import com.maizhong.auction.pojo.AcUser;
import com.maizhong.auction.service.AuctionService;
import com.maizhong.auction.service.IndexService;
import com.maizhong.auction.service.PersonalAppService;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.VerifyCodeUtils;
import net.sf.json.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Xushd on 2017/6/7.
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private PersonalAppService personalAppService;

    @RequestMapping(value = "/manage")
    public String indexManage(@CookieValue(value = "m_token",required = false) String token,Model model){
        if(StringUtils.isBlank(token)){
            return "redirect:/manage/login";
        }
        JsonResult result = indexService.checkLoginStatus(token);
        if(result.getStatus()!=200){
            return "redirect:/manage/login";
        }
        String sysMenuJson = indexService.getSystemMenu(token);
        model.addAttribute("menu",sysMenuJson);
        model.addAttribute("username",result.getMessage());

        return "manage/index";
    }


    /**
     * 跳转到登录页
     * @return
     */
    @RequestMapping(value = "/manage/login")
    public String managelogin(){
        return "manage/login";
    }


    /**
     * 后台登录验证
     * @param account
     * @param password
     * @param checked
     * @return
     */
    @RequestMapping(value = "/login/check")
    @ResponseBody
    public JsonResult loginCheck(String account,String password,boolean checked){
        JsonResult result = indexService.loginCheck(account,password,checked);
        return result;
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/logOff")
    @ResponseBody
    public JsonResult logOff(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = indexService.logOff(token);
        return result;
    }


    /**
     * 拍卖PC index
     * @param model
     * @return
     */
    @RequestMapping(value = "/")
    public String index(@CookieValue(value = "token",required = false) String token,Model model){
        if(StringUtils.isNotBlank(token)){
            AcUser user =  indexService.getUserInfo(token);
            if(user!=null){
                model.addAttribute("username",user.getName());
            }
        }
        model.addAttribute("menu","/");
        return "index";
    }

    /**
     * 拍卖大厅
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(@CookieValue(value = "token",required = false) String token,Model model){
        if(StringUtils.isNotBlank(token)){
            AcUser user =  indexService.getUserInfo(token);
            if(user!=null){
                model.addAttribute("username",user.getName());
            }
        }
        model.addAttribute("menu","/list");
        return "list";
    }

    /**
     * 服务大厅
     * @param model
     * @return
     */
    @RequestMapping(value = "/warranty")
    public String  warranty(Model model){
        model.addAttribute("menu","/warranty");
        return "warranty";
    }

    /**
     * 个人中心
     * @param model
     * @return
     */
    @RequestMapping(value = "/personal")
    public String personal(@CookieValue(value = "token",required = false) String token,Model model){
        if(StringUtils.isBlank(token)){
            return "redirect:/user/login";
        }
        AcUser user =  indexService.getUserInfo(token);
        if(user!=null){
            model.addAttribute("username",user.getName());
            model.addAttribute("userInfo",user);
        }else{
            return "redirect:/user/login";
        }

        model.addAttribute("menu","/personal");
        return "personal";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "/user/login")
    public String login(){
        return "login";
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "/user/regist")
    public String regist(){
        return "regist";
    }

    /**
     * 退出登录
     * @param response
     * @return
     */
    @RequestMapping(value = "/user/logout")
    public String logOut(HttpServletResponse response){
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(5);// 设置为60min*24
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/";
    }
    /**
     * 获取正在拍的车辆
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/now/car/list")
    @ResponseBody
    public JsonResult getNowCarList(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult nowAuctionList = auctionService.getNowAuctionList(token);
        return nowAuctionList;
    }

    /**
     * 生成验证码
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/verifyCode",method = RequestMethod.GET)
    public void verifyCode(HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        Cookie cookie = new Cookie("ver", verifyCode);
        cookie.setMaxAge(2 * 60);// 设置为30min
        cookie.setPath("/");
        response.addCookie(cookie);
        //生成图片
        int w = 200, h = 80;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }

    /**
     * pc 获取验证码
     * @param phone
     * @param ver
     * @param ver2
     * @return
     */
    @RequestMapping(value = "/sendSms/{phone}/{ver}")
    @ResponseBody
    public JsonResult sendSMS(@PathVariable long phone,
                              @PathVariable String ver,
                              @CookieValue(value = "ver",required = false) String ver2){
        if(StringUtils.isBlank(ver2)){
            return JsonResult.Error("图形验证码过期!");
        }
        if(!StringUtils.equals(ver.toLowerCase(),ver2.toLowerCase())){
            return JsonResult.Error("图形验证码错误!");
        }
        return personalAppService.getVerifyCode(phone);

    }

    /**
     * 发送注册验证码
     * @param phone
     * @param ver
     * @param ver2
     * @return
     */
    @RequestMapping(value = "/sendSms/regist/{phone}/{ver}")
    @ResponseBody
    public JsonResult sendSMSRegist(@PathVariable long phone,
                                    @PathVariable String ver,
                                    @CookieValue(value = "ver",required = false) String ver2){
        if(StringUtils.isBlank(ver2)){
            return JsonResult.Error("图形验证码过期!");
        }
        if(!StringUtils.equals(ver.toLowerCase(),ver2.toLowerCase())){
            return JsonResult.Error("图形验证码错误!");
        }
        return indexService.getVerifyCodeRegist(phone);
    }

    /**
     * 手机验证码登录
     * @param phone
     * @param verify
     * @return
     */
    @RequestMapping(value = "/login/phone")
    @ResponseBody
    public JsonResult loginByPhone(long phone,String verify,HttpServletResponse response){
        JsonResult result = indexService.loginByPhone(phone, verify);
        if(result.getStatus()==200){
            Cookie cookie = new Cookie("token", result.getData().toString());
            cookie.setMaxAge(60 * 60 * 24);// 设置为60min*24
            cookie.setPath("/");
            response.addCookie(cookie);
            return result;
        }else{
            return result;
        }
    }

    /**
     * 手机号密码登录
     * @param account
     * @param pass
     * @param response
     * @return
     */
    @RequestMapping(value = "/login/pass")
    @ResponseBody
    public JsonResult loginByPass(long account,String pass,HttpServletResponse response){
        JsonResult result = indexService.loginByPass(account, pass);
        if(result.getStatus()==200){
            Cookie cookie = new Cookie("token", result.getData().toString());
            cookie.setMaxAge(60 * 60 * 24);// 设置为60min*24
            cookie.setPath("/");
            response.addCookie(cookie);
            return result;
        }else{
            return result;
        }
    }

    /**
     * PC 用户注册
     * @param phone
     * @param verify
     * @param response
     * @return
     */
    @RequestMapping(value = "/regist/phone")
    @ResponseBody
    public JsonResult registUser(long phone,String verify,int type,HttpServletResponse response){
        JsonResult result = indexService.registUser(phone, verify,type);
        if(result.getStatus()==200){
            Cookie cookie = new Cookie("token", result.getData().toString());
            cookie.setMaxAge(60 * 60 * 24);// 设置为60min*24
            cookie.setPath("/");
            response.addCookie(cookie);
            return result;
        }else{
            return result;
        }
    }

    /**
     * 即将上拍的车辆
     * @return
     */
    @RequestMapping(value = "/more/car")
    @ResponseBody
    public JsonResult getMoreCar(@CookieValue(value = "token",required = false)String token){

        return indexService.getTopCar(token);
    }

    /**
     * 取消关注
     * @param carId
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/car/like/cancle/{carId}")
    @ResponseBody
    public JsonResult carLikeCancle(@PathVariable long carId, HttpServletRequest request){
        String token = (String) request.getAttribute("token");

        return auctionService.carLikeCancle(carId,token);

    }

    /**
     * 关注
     * @param carId
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/car/like/{carId}")
    @ResponseBody
    public JsonResult carLike(@PathVariable long carId,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        if(StringUtils.equals("null",token)){
            return JsonResult.build(500,"no login","login");
        }
        return auctionService.carLike(carId,token);
    }

    /**
     * 车辆详情
     * @return
     */
    @RequestMapping(value = "/list/detail/{auctionId}/{carId}")
    public String carDetail(@CookieValue(value = "token",required = false) String token,
                            @PathVariable long auctionId,
                            @PathVariable long carId, Model model){

        if(StringUtils.isNotBlank(token)){
            AcUser user =  indexService.getUserInfo(token);
            if(user!=null){
                model.addAttribute("username",user.getName());
                model.addAttribute("userId",user.getId());
            }
        }

        CarDetailDto dto = indexService.getCarDetail(carId);
        model.addAttribute("title",dto.getModelName());
        model.addAttribute("carInfo",dto);
        model.addAttribute("auctionId",auctionId);

        return "detail";
    }

    @RequestMapping(value = "/to/{url}")
    public String gotoUrl(@PathVariable String url){

        return url;
    }

    /**
     * 获取当前车辆拍卖状态
     * @param auctionId
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/car/now/{auctionId}")
    @ResponseBody
    public JsonResult getCarNow(@PathVariable long auctionId,HttpServletRequest request){
        String token = (String) request.getAttribute("token");

        JsonResult result = indexService.getCarNow(auctionId,token);
        return result;
    }

    /**
     * 出价
     * @param ch
     * @param carId
     * @param plus
     * @param price
     * @return
     */
    @RequestMapping(value = "/auction/addPrice/{ch}/{carId}/{auctionId}")
    @ResponseBody
    public JsonResult addPrice(@PathVariable String ch,
                               @PathVariable long carId,
                               @PathVariable long auctionId,
                               String plus,
                               String price,
                               HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = auctionService.addPrice(ch,carId,plus,price,token,auctionId);
        return result;
    }

    /**
     * 智能报价
     * @param auctionId
     * @param price
     * @param request
     * @return
     */
    @RequestMapping(value = "/auction/car/auto/price/{auctionId}/{price}")
    @ResponseBody
    public JsonResult autoPrice(@PathVariable long auctionId,
                                @PathVariable long price,
                                HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        if(StringUtils.equals(token,"null"))return JsonResult.Error("未登录");
        JsonResult result = indexService.autoPrice(auctionId,price,token);
        return result;
    }

    /**
     * 出价记录
     * @param auctionId
     * @return
     */
    @RequestMapping(value = "/auction/bidrecord/list/{auctionId}")
    @ResponseBody
    public JsonResult getBidList(@PathVariable long auctionId){

        JsonResult result = indexService.getBidRecordList(auctionId);
        return result;
    }
}
