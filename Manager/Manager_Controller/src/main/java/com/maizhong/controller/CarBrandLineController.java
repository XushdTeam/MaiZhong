package com.maizhong.controller;

import com.alibaba.druid.util.StringUtils;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.pojo.TbCarBrandLine;
import com.maizhong.service.BrandLineService;
import com.maizhong.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yangF on 2017/3/16.
 */
@Controller
public class CarBrandLineController {

    @Autowired
    private BrandLineService brandLineService;
    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/series", method = RequestMethod.GET)
    public String carBrand(Model model) {
        model.addAttribute("baseUrl", "/series");
        model.addAttribute("listUrl", "/brandseries/list");
        model.addAttribute("handleSeries", "/series/list");
        model.addAttribute("handleUrl", "/series/handle");
        model.addAttribute("deleteUrl", "/series/delete");
        return "shop/brandseries";
    }


    @ControllerLog(module = "品牌列表", methods = "品牌列表")
    @RequestMapping(value = "/brandseries/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult brandList(PageSearchParam param) {
        PageResult result = brandService.getCarBrandList(param);
        return JsonResult.OK(result);
    }

    @ControllerLog(module = "车系管理", methods = "车系列表")
    @RequestMapping(value = "/series/list/{id}")
    public String seriesList(@PathVariable Long id, Model model) {
        model.addAttribute("baseUrl", "/series");
        model.addAttribute("brandIdS", id);
        model.addAttribute("listUrl", "/series/listUrl/" + id);
        model.addAttribute("handleSeries", "/series/list");
        model.addAttribute("handleUrl", "/series/handle");
        model.addAttribute("deleteUrl", "/series/delete");
        return "shop/series";
    }

    @ControllerLog(module = "车系管理", methods = "车系列表")
    @RequestMapping(value = "/series/listUrl/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult seriesList(@PathVariable Long id, PageSearchParam param) {
        PageResult result = brandLineService.getSeriesList(param, id);
        return JsonResult.OK(result);
    }

    @RequestMapping(value = "/carBrandLine/list/{id}")
    @ResponseBody
    public JsonResult getSeriesByBrand(@PathVariable Long id){
        return brandLineService.getCarBrandLineList(id);
    }


    /**
     * 车系新增和修改
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/series/handle/{type}/{id}")
    public String handle(@PathVariable String id, @PathVariable String type, Model model) {

        if (StringUtils.equals("new", type)) {
            //新增
            model.addAttribute("baseUrl", "/series/list/" + id);
            model.addAttribute("brandIdS", id);
            model.addAttribute("handle", "车系管理/新增车系");
            model.addAttribute("saveUrl", "/series/save");
            return "shop/series_add";
        } else {
            TbCarBrandLine series = brandLineService.getSeriesById(Long.valueOf(id));
            Long brandId=brandLineService.getBaseUrl(id);
            if (brandId==null){
                model.addAttribute("baseUrl","/series");
            }else {
                model.addAttribute("baseUrl","/series/list/"+brandId);
            }
            model.addAttribute("series", series);
            model.addAttribute("handle", "车系管理/车系修改");
            model.addAttribute("saveUrl", "/series/update");
            return "shop/series_setting";
        }
    }

    /**
     * 车系新增
     *
     * @param tbCarBrandLine
     * @return
     */

    //@RequiresPermissions("/series/save")
    @ControllerLog(module = "车系管理", methods = "车系新增")
    @RequestMapping(value = "/series/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult carSeriesSave(TbCarBrandLine tbCarBrandLine) {
        OperateEnum res = brandLineService.insertSeries(tbCarBrandLine);
        return JsonResult.build(res);
    }

    /**
     * 根据Id删除车系
     *
     * @param id
     * @return
     */
    //@RequiresPermissions("/series/delete")
    @ControllerLog(module = "车系管理", methods = "删除车系")
    @RequestMapping(value = "/series/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult carSeriesDelete(@PathVariable Long id) {
        //车系删除
        if (id == null)
            return JsonResult.Error("错误");
        return brandLineService.deleteById(id);
    }

    /**
     * 车系信息修改
     *
     * @param tbCarBrandLine
     * @return
     */
    //@RequiresPermissions("/series/update")
    @ControllerLog(module = "车系管理", methods = "车系信息修改")
    @RequestMapping(value = "/series/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult seriesUpdate(TbCarBrandLine tbCarBrandLine) {
        OperateEnum result = brandLineService.updateSeries(tbCarBrandLine);
        return JsonResult.build(result);
    }

    /**
     * 车系缓存更新
     *
     * @return
     */
    @ControllerLog(module = "车系管理", methods = "插入车系缓存")
    @RequestMapping(value = "/series/updateRedis")
    @ResponseBody
    public JsonResult updateRedis() {
        OperateEnum result = brandLineService.updateRedis();
        return JsonResult.build(result);
    }

}
