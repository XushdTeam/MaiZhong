package com.maizhong.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 菜单Controller
 * Created by Xushd on 2017/3/1.
 */
@Controller
public class MenuController {


    @Autowired
    private MenuService menuService;




    /**
     * 前台菜单JSON数据获取
     * @param typeId
     * @return
     */
    @RequestMapping(value = "/menu/json/{typeId}",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult menuJson(@PathVariable String typeId){
        JsonResult result = menuService.getMenuListForWeb(typeId);
        return result;
    }

}
