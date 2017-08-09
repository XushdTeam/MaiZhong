package com.maizhong.auction.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maizhong.auction.pojo.*;
import com.maizhong.auction.service.CheckService;
import com.maizhong.auction.service.ImgUploadService;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import net.sf.json.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Xushd on 2017/6/14.
 */
@RestController
public class CheckController {

    @Autowired
    private CheckService checkService;
    @Autowired
    private ImgUploadService imgUploadService;
    /**
     * 登录
     * @param account
     * @param pass
     * @return
     */
    @RequestMapping(value = "/app/check/login",method = RequestMethod.POST)
    public JsonResult checkLogin(String account,String pass){
        JsonResult result = checkService.checkLogin(account,pass);
        return result;
    }

    /**
     * 修改密码
     * @param pass
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/check/changePwd",method = RequestMethod.POST)
    public JsonResult editPass(String pass, HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = checkService.changePwd(pass,token);
        return result;
    }

    /**
     * 反馈建议
     * @param content
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/check/feedback",method = RequestMethod.POST)
    public JsonResult feedback(String content, HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = checkService.feedback(content,token);
        return result;
    }

    /**
     * 获取帮助中心列表
     * @return
     */
    @RequestMapping(value = "/app/check/getHelpTitle",method = RequestMethod.GET)
    public JsonResult help(){
        JsonResult result = checkService.getHelp();
        return result;
    }

    /**
     * 获取帮助详细内容
     * @param id
     * @return
     */
    @RequestMapping(value = "/app/check/getHelpContent/{id}",method = RequestMethod.GET)
    public JsonResult helpDetail(@PathVariable long id){
        JsonResult result = checkService.getHelpDetail(id);
        return result;
    }

    /**
     * 获取公告信息列表
     * @return
     */
    @RequestMapping(value = "/app/check/news/list",method = RequestMethod.GET)
    public JsonResult newslist(){
        JsonResult result = checkService.getNewsList();
        return result;
    }

    /**
     * 获取新闻详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/app/check/news/detail/{id}",method = RequestMethod.GET)
    public JsonResult newsDetail(@PathVariable long id){
        JsonResult result = checkService.getNewsDetail(id);
        return result;
    }

    /**
     * 图片上传
     * @param imgStr
     * @return
     */
    @RequestMapping(value = "/app/check/base/img/upload")
    public JsonResult checkBaseImgUpload(String imgStr){
        JsonResult result = imgUploadService.uploadImg(imgStr,"check/base/");
        return result;
    }

    /**
     * 行驶证图片识别
     * @param imgUrl
     * @return
     */
    @RequestMapping(value = "/app/check/xsz/sb")
    public JsonResult checkXSZsb(String imgUrl){

        JsonResult result = imgUploadService.xszSb(imgUrl);
        return result;
    }

    /**
     * 检测端创建一辆车
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/check/newcar/{ordernum}",method = RequestMethod.POST)
    public JsonResult checkCarNew(HttpServletRequest request,@PathVariable long ordernum){
        String token = (String) request.getAttribute("token");
        JsonResult result = checkService.newCarbase(token,ordernum);
        return result;
    }

    /**
     * 获取汽车列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/check/car/list")
    public JsonResult checkCarList(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = checkService.checkCarList(token);
        return result;
    }

    /**
     * 删除车辆
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/check/car/del/{carId}")
    public JsonResult checkCarDel(@PathVariable long carId){
        JsonResult result = checkService.checkCarDel(carId);
        return result;
    }


    /**
     * 保存行驶证信息
     * @param xsz
     * @return
     */
    @RequestMapping(value = "/app/check/car/xsz/save")
    public JsonResult checkCarXSZ(CkXsz xsz){
        if(xsz==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.saveXSZ(xsz);
        return result;
    }

    /**
     * 保存登记证信息
     * @param djz
     * @return
     */
    @RequestMapping(value = "/app/check/car/djz/save")
    public JsonResult checkCarDJZ(CkDjz djz){
        if(djz==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.saveDJZ(djz);
        return result;
    }

    /**
     * 保存其他证件信息
     * @param qtz
     * @return
     */
    @RequestMapping(value = "/app/check/car/qtz/save")
    public JsonResult checkCarQTZ(CkQtz qtz){
        if(qtz==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.saveQTZ(qtz);
        return result;
    }

    /**
     * 保存车主信息
     * @param czinfo
     * @return
     */
    @RequestMapping(value = "/app/check/car/czxx/save")
    public JsonResult checkCarCZINFO(CkCzinfo czinfo){
        if(czinfo==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.saveCZXX(czinfo);
        return result;
    }

    /**
     * 获取检测车辆STEP1信息 （xsz,djz,qtz,czxx）
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/check/car/step1/{carId}")
    public JsonResult checkCarSTEP1(@PathVariable long carId){
        JsonResult result = checkService.getCarStep1(carId);
        return result;
    }

    /**
     * 检测车辆基本照片
     * @param ckBaseimg
     * @return
     */
    @RequestMapping(value = "/app/check/car/baseimg")
    public JsonResult checkCarBaseImg(CkBaseimg ckBaseimg){
        if(ckBaseimg==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.saveCarBaseImg(ckBaseimg);
        return result;
    }

    /**
     * 获取基本照片
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/check/getcar/baseimg/{carId}")
    public JsonResult getCarBaseImg(@PathVariable long carId){
        JsonResult result = checkService.getCarBaseImg(carId);
        return result;
    }

    /**
     * 保存/更新车辆配置信息
     * @param ckPz
     * @return
     */
    @RequestMapping(value = "/app/check/car/pz/save")
    public JsonResult checkPz(CkPz ckPz){
        if(ckPz==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.savePZ(ckPz);
        return result;
    }

    /**
     * 保存/更新车辆动力检测信息
     * @param ckDl
     * @return
     */
    @RequestMapping(value = "/app/check/car/dl/save")
    public JsonResult checkDL(CkDl ckDl){
        if(ckDl==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.saveDL(ckDl);
        return result;
    }


    /**
     * 获取车辆信息的配置动力 pz dl
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/check/car/step4/{carId}")
    public JsonResult checkCarSTEP4(@PathVariable long carId){
        JsonResult result = checkService.getCarStep4(carId);
        return result;
    }

    /**
     * 外观缺陷故障保存
     * @param list
     * @return
     */
    @RequestMapping(value = "/app/check/car/wgqx/save/{carId}")
    public JsonResult checkWgqx(String list,@PathVariable long carId){
        if(StringUtils.isBlank(list))return JsonResult.Error(OperateEnum.FAILE);
        List<CkCkwgqx> ckCkwgqxes = JsonUtils.jsonToList(list, CkCkwgqx.class);
        JsonResult result = checkService.saveWgqx(ckCkwgqxes,carId);
        return result;
    }

    /**
     * 内饰缺陷故障保存
     * @param list
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/check/car/nsqx/save/{carId}")
    public JsonResult checkNsqx(String list,@PathVariable long carId){
        if(StringUtils.isBlank(list))return JsonResult.Error(OperateEnum.FAILE);
        List<CkCknsqx>  ckCknsqxs= JsonUtils.jsonToList(list, CkCknsqx.class);
        JsonResult result = checkService.saveNsqx(ckCknsqxs,carId);
        return result;
    }

    /**
     * 事故信息
     * @param list
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/check/car/sg/save/{carId}")
    public JsonResult checkSgqx(String list,@PathVariable long carId){
        if(StringUtils.isBlank(list))return JsonResult.Error(OperateEnum.FAILE);
        List<CkCksg> ckCksgs = JsonUtils.jsonToList(list, CkCksg.class);
        JsonResult result = checkService.saveSg(ckCksgs,carId);
        return result;
    }

    /**
     * 泡水
     * @param list
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/check/car/ps/save/{carId}")
    public JsonResult checkPs(String list,@PathVariable long carId){
        if(StringUtils.isBlank(list))return JsonResult.Error(OperateEnum.FAILE);
        List<CkCkps> ckCkps = JsonUtils.jsonToList(list, CkCkps.class);
        JsonResult result = checkService.savePs(ckCkps,carId);
        return result;
    }

    /**
     * 火烧
     * @param list
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/check/car/hs/save/{carId}")
    public JsonResult checkHs(String list,@PathVariable long carId){
        if(StringUtils.isBlank(list))return JsonResult.Error(OperateEnum.FAILE);
        List<CkCkhs> ckCkhs = JsonUtils.jsonToList(list, CkCkhs.class);
        JsonResult result = checkService.saveHs(ckCkhs,carId);
        return result;
    }

    /**
     * 获取车辆的检测情况
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/check/car/step3/{carId}")
    public JsonResult checkCarSTEP3(@PathVariable long carId){
        JsonResult result = checkService.getCarStep3(carId);
        return result;
    }


    /**
     * 核对信息保存
     * @param verify
     * @return
     */
    @RequestMapping(value = "/app/check/car/verify/save")
    public JsonResult checkCarVerify(CkVerify verify){
        if(verify==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.checkCarVerify(verify);
        return result;
    }

    /**
     * 附加信息保存
     * @param other
     * @return
     */
    @RequestMapping(value = "/app/check/car/other/save")
    public JsonResult checkCarOther(CkOther other){
        if(other==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.checkCarOther(other);
        return result;
    }

    /**
     * 车型信息保存
     * @param carmodel
     * @return
     */
    @RequestMapping(value = "/app/check/car/model/save")
    public JsonResult checkCarModel(CkCarmodel carmodel){
        if(carmodel==null)return JsonResult.Error(OperateEnum.FAILE);
        JsonResult result = checkService.checkCarModel(carmodel);
        return result;
    }

    /**
     * 获取核对所有信息
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/check/car/step5/{carId}")
    public JsonResult checkCarSTEP5(@PathVariable long carId){
        JsonResult result = checkService.getCarStep5(carId);
        return result;
    }

    /**
     *
     * 提交审核
     * @param carId
     * @return
     */
    @RequestMapping(value = "/app/check/car/examine/{carId}")
    public JsonResult checkCarStatus(@PathVariable long carId){
        JsonResult result = checkService.checkCarExamine(carId);
        return result;
    }

    /**
     * 查看驳回原因
     * @param id
     * @return
     */
    @RequestMapping(value = "/app/check/car/examine/reject/{id}")
    public JsonResult checkeRejectReason(@PathVariable long id){
        JsonResult result = checkService.getRejectReason(id);
        return result;
    }

    /**
     * 获取我的检测任务
     * @param request
     * @return
     */
    @RequestMapping(value = "/app/check/mytask")
    @ResponseBody
    public JsonResult checkMyTask(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        return checkService.getMyTask(token);
    }

    /**
     * 修改保留价
     * @return
     */
    @RequestMapping(value = "/app/check/chang/save/price/{carId}")
    @ResponseBody
    public JsonResult checkUpdateSavePrice(@PathVariable long carId, String price,HttpServletRequest request){
        String token = (String)request.getAttribute("token");
        return checkService.checkUpdateSavePrice(carId,price,token);
    }
}
