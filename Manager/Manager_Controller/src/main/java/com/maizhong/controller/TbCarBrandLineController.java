package com.maizhong.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.pojo.TbCarBrandLine;
import com.maizhong.service.BrandLineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by yangF on 2017/3/16.
 */
@Controller
@RequestMapping("/carBrandLine")
public class TbCarBrandLineController {

    @Resource
    private BrandLineService brandLineService;


    /**
     * 根据  汽车品牌Id返回 汽车车系集合
     * @param id
     * @return
     */
    @RequestMapping("/list/{brandId}")
    @ResponseBody
    public JsonResult findLineByBrandId(@PathVariable("brandId") Long id){
        return brandLineService.getCarBrandLineList(id);
    }


    /**
     * 添加方法
     * @param tbCarBrandLine
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public JsonResult insertLine(@RequestBody TbCarBrandLine tbCarBrandLine){
        if (tbCarBrandLine==null||tbCarBrandLine.getBrandId()==null) return JsonResult.Error("错误");
        if (tbCarBrandLine.getId()==null)
            return brandLineService.insertCarBrandLine(tbCarBrandLine);
        return brandLineService.updateCarBrandLine(tbCarBrandLine);
    }



    /**
     * 删除方法
     * @param id
     * @return
     */
    @RequestMapping("/delect/{id}")
    @ResponseBody
    public JsonResult deleteLine(@PathVariable("id") Long id){
        if (id==null)
            return JsonResult.Error("错误");
        return brandLineService.deleteById(id);
    }
}
