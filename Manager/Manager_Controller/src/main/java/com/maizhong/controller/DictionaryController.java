package com.maizhong.controller;

import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.pojo.TbDictionary;
import com.maizhong.service.DicService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * 字典控制器
 * Created by Xushd on 2017/3/2.
 */
@Controller
public class DictionaryController extends GlobalController {

    @Autowired
    private DicService dicService;

    /**
     * 字典跳转
     * @return
     */
    @RequestMapping(value = "/dictionary",method = RequestMethod.GET)
    public String dictionary(Model model){

        model.addAttribute("baseUrl","/dictionary");
        model.addAttribute("listUrl","/dictionary/list");
        model.addAttribute("handleUrl","/dictionary/handle");
        model.addAttribute("deleteUrl","/dictionary/delete");

        return "system/dictionary";
    }

    /**
     * 获取字典列表数据
     * @return
     */
    @ControllerLog(module = "字典管理",methods = "字典列表")
    @RequestMapping(value="/dictionary/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult dictionaryList(){
        List<TbDictionary> list = dicService.getDicList(false);
        return JsonResult.OK(list);
    }

    /**
     * 跳转到新增修改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/dictionary/handle/{id}")
    public String handle(@PathVariable String id, Model model){
        String resultView = "system/dictionary_a_e";
        List<TbDictionary> list = dicService.getDicList(true);
        if(StringUtils.equals("null",id)){
            //新增
            model.addAttribute("handle","字典新增");
            model.addAttribute("saveUrl","/dictionary/save");
        }else {
            //修改
            TbDictionary dic = dicService.getDicById(Long.valueOf(id));
            model.addAttribute("dic",dic);
            model.addAttribute("handle", "字典修改");
            model.addAttribute("saveUrl","/dictionary/update");
        }
        model.addAttribute("list",list);
        model.addAttribute("baseUrl","/dictionary");
        return resultView;
    }

    /**
     * 字典新增
     * @param dictionary
     * @param result
     * @return
     */
    @ControllerLog(module = "字典管理",methods = "字典新增")
    @RequestMapping(value = "/dictionary/save",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult dictionarySave(@Valid TbDictionary dictionary, BindingResult result){
        //验证有错误
        if(result.hasErrors()){
            String error = "";
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError allError : allErrors) {
                error+= allError.getDefaultMessage();
            }
            return JsonResult.Error(error);
        } else{
            dictionary.setCreateUser(super.getUserInfo().getUserName());
            dictionary.setCreateTime(new Date());
            OperateEnum res = dicService.insertDic(dictionary);
            return JsonResult.build(res);
        }
    }

    /**
     * 字典修改
     * @param dictionary
     * @param result
     * @return
     */
    @ControllerLog(module = "字典管理",methods = "字典修改")
    @RequestMapping(value = "/dictionary/update",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult dictionaryUpdate(@Valid TbDictionary dictionary,BindingResult result){
        //验证有错误
        if(result.hasErrors()){
            String error = "";
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError allError : allErrors) {
                error+= allError.getDefaultMessage();
            }
            return JsonResult.Error(error);
        }else{
            OperateEnum res = dicService.updateDic(dictionary);
            return JsonResult.build(res);
        }
    }

    /**
     * 字典删除
     * @param id
     * @return
     */
    @ControllerLog(module = "字典管理",methods = "字典删除")
    @RequestMapping(value = "/dictionary/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult dictionaryDelete(@PathVariable String id){
        OperateEnum res = dicService.deleteDic(Long.parseLong(id));
        return JsonResult.build(res);
    }





}
