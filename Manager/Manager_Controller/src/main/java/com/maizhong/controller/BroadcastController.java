package com.maizhong.controller;

import com.alibaba.druid.util.StringUtils;
import com.maizhong.common.dto.KeyValue;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.pojo.TbCarColumn;
import com.maizhong.service.CarColumnService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description:宣传管理
 * User: 王存浩
 * Date: 2017-03-15
 * Time: 15:30
 */

@Controller
public class BroadcastController {

    @Autowired
    private CarColumnService carColumnService;



    //@RequiresPermissions("/broadcast")
    @RequestMapping(value = "/carColumn", method = RequestMethod.GET)
    public String carColumn(Model model) {
        List<KeyValue> list=carColumnService.getColumnList();
        model.addAttribute("columnList",list);
        model.addAttribute("baseUrl", "/carColumn");
        model.addAttribute("redisUrl","/carColumn/redisUrl");
        model.addAttribute("listUrl", "/carColumn/list");
        model.addAttribute("handleUrl", "/carColumn/handle");
        model.addAttribute("deleteUrl", "/carColumn/delete");
        return "broadcast/carColumn";
    }


    /**
     * 汽车栏目列表
     * @param param
     * @return
     */
    @ControllerLog(module = "宣传管理", methods = "首页汽车")
    @RequestMapping(value = "/carColumn/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult advertList(PageSearchParam param) {
        PageResult result = carColumnService.getCarColumnList(param);
        return JsonResult.OK(result);
    }


    /**
     * 栏目中商品的添加和修改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/carColumn/handle/{id}")
    public String handle(@PathVariable String id, Model model) {

        model.addAttribute("baseUrl", "/carColumn");
        List<KeyValue> list=carColumnService.getColumnList();
        model.addAttribute("columnList",list);
        if (StringUtils.equals("new", id)) {
            //新增
            model.addAttribute("handle", "首页汽车/新增商品");
            model.addAttribute("saveUrl", "/carColumn/carColumn_add");
            return "broadcast/carColumn_add";
        } else {
          TbCarColumn carColumn = carColumnService.getCarColumnByid(Long.valueOf(id));
            model.addAttribute("carColumn", carColumn);
            model.addAttribute("handle", "首页汽车/商品修改");
            model.addAttribute("saveUrl", "/carColumn/update");
            return "broadcast/carColumn_setting";
        }
    }


    /**
     * 栏目下商品新增
     * @param tbCarColumn
     * @return
     */

  /*  @RequiresPermissions("/carColumn/carColumn_add")*/
    @ControllerLog(module = "首页汽车", methods = "新增商品")
    @RequestMapping(value = "/carColumn/carColumn_add", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult columnCarSave(TbCarColumn tbCarColumn) {
        OperateEnum res = carColumnService.insertCarColumn(tbCarColumn);
        return JsonResult.build(res);
    }


    /**
     * 根据Id删除栏目下的汽车
     * @param id
     * @return
     */
    //@RequiresPermissions("/carColumn/delete")
    @ControllerLog(module = "首页汽车", methods = "删除汽车")
    @RequestMapping(value = "/carColumn/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult carBrandDelete(@PathVariable long id) {
        //栏目下的汽车删除
        OperateEnum result = carColumnService.deleteColumnCarById(id);
        return JsonResult.build(result);
    }


    /**
     * 栏目下汽车信息修改
     * @param tbCarColumn
     * @return
     */
   // @RequiresPermissions("/carColumn/update")
    @ControllerLog(module = "首页汽车", methods = "汽车修改")
    @RequestMapping(value = "/carColumn/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult carColumnUpdate(TbCarColumn tbCarColumn) {
        OperateEnum result = carColumnService.updateCarColumn(tbCarColumn);
        return JsonResult.build(result);
    }

    /**
     * 缓存刷新
     * @return
     */
    @ControllerLog(module = "首页汽车",methods = "缓存同步")
    @RequestMapping(value = "/carColumn/redisUrl")
    @ResponseBody
    public JsonResult dictionaryRedis(){
        JsonResult result = carColumnService.carColumnRedis();
        return result;
    }

}
