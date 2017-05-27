package com.maizhong.controller;

import com.maizhong.common.enums.DicParentEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.Rate;
import com.maizhong.pojo.TbDictionary;
import com.maizhong.service.DicService;
import com.maizhong.service.RateConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Xushd on 2017/5/24.
 */
@Controller
public class RateController extends GlobalController{


    @Autowired
    private DicService dicService;

    @Autowired
    private RateConService rateConService;


    @RequestMapping(value = "/rate/list")
    @ResponseBody
    public JsonResult rateList(){

        List<TbDictionary> dicListByParent = dicService.getDicListByParent(DicParentEnum.RATE.getState());
        List<Rate> rateList = rateConService.getRateList(dicListByParent);
        return JsonResult.OK(rateList);
    }

    @RequestMapping(value = "/rate")
    public String rate(Model model){

        model.addAttribute("baseUrl","/rate");
        model.addAttribute("listUrl","/rate/list");
        model.addAttribute("handleUrl","/rate/edit");
        return "rate/index";
    }

    @RequestMapping(value = "/rate/edit/{id}/{rate:.+}")
    @ResponseBody
    public JsonResult rateEdit(@PathVariable Integer id, @PathVariable float rate){
        JsonResult result = rateConService.updateRate(id,rate,super.getUserInfo().getUserName());

        return JsonResult.OK();
    }

}
