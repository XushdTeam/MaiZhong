package com.maizhong.rest.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.RestInterface;
import com.maizhong.rest.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 首页控制器
 * Created by Xushd on 2017/3/3.
 */
@Controller
public class IndexController {


    @Autowired
    private IndexService indexService;




    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(String username, String password){
        JsonResult result = indexService.login(username,password);
        return result;
    }

    @RequestMapping(value = "/interface",method = RequestMethod.GET)
    public String interfacePage(){
        return "interface";
    }



    @RequestMapping(value = "/baseInfo")
    @ResponseBody
    public JsonResult baseInfo(){
        JsonResult result = indexService.getBaseInfo();
        return result;
    }


    @RequestMapping(value = "/interfaceList",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult interfaceList(PageSearchParam pageSearchParam){

        JsonResult resutl = indexService.getInterfaceList(pageSearchParam);
        return resutl;
    }

    @RequestMapping(value ="/interfaceAdd",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult interfaceAdd(@Validated RestInterface restInterface, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            String error = "";
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                error+= allError.getDefaultMessage();
            }
            return JsonResult.Error(error);
        }else {
            JsonResult result = indexService.saveInterface(restInterface);
            return result;
        }

    }

}

