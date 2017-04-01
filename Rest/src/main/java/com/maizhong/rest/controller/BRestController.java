package com.maizhong.rest.controller;

import com.maizhong.common.dto.CarBaseDTO;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.target.ServiceLog;
import com.maizhong.pojo.TbCar;
import com.maizhong.rest.service.BRestService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 主服务
 *      作用  根据其他服务器返回的数据对服务器进行数据处理
 *              处理汽车CRUD
 *
 * Created by YangF on 2017/3/28.
 */
@RequestMapping("/bRest")
@RestController
public class BRestController {

    @Resource
    private BRestService bRestService;


    //数据添加
    @RequestMapping("/car/insert")
    public JsonResult insertCar(TbCar car){
        return bRestService.insertCar(car);
    }

    //数据修改
    @RequestMapping("/car/modify")
    public JsonResult updateCar(TbCar tbCar){
        if (tbCar!=null){
            if (tbCar.getId()==null){
                return bRestService.insertCar(tbCar);
            }
            return bRestService.updateCar(tbCar);
        }
        return JsonResult.Error("数据错误，请检查数据");
    }

    @RequestMapping("/car/info/{id}")
    public JsonResult findInfo(@PathVariable Long id){
        //TODO
        return  bRestService.findCarInfoById(id);
    }

    //数据删除
    @RequestMapping("/car/delete/{id}")
    public JsonResult delCar(@PathVariable("id") String id){
        return null;
    }

    //商品下架
    @RequestMapping("/car/detail/{id}")
    public JsonResult unable(@PathVariable("id") String id){
        return bRestService.getDetailsByCarId(Long.valueOf(id));
    }

    //商品查询接口
    @RequestMapping("/car/find")
    public JsonResult selectCarList(@RequestParam("businessId") Long businessId, Long carSeries, Long brandId,
                                    String date, String carYear, Integer currentPage, String sortString) {

        Integer pageSize = 10;
        return bRestService.selectCarByBussiness(businessId,carSeries,brandId,date,carYear,currentPage,pageSize,sortString);
    }




    @RequestMapping("/user")
    public JsonResult userLogin(String username,String password){
        return bRestService.userLogin(username,password);
    }



    @RequestMapping("/getCarBrand")
    public JsonResult getCarSeriesByBrand(){
        return bRestService.findBrandsByCatch();
    }


    @RequestMapping("/getCarSeriesByBrand/{brandId}")
    public JsonResult getCarSeriesByBrand(@PathVariable String brandId){
        return bRestService.findSeriesByCatch(brandId);
    }


    @RequestMapping("/getCarSeriesByBrand/{seriesId}/{caryear}")
    public JsonResult getCarSeriesByBrand(@PathVariable String seriesId,@PathVariable String caryear){
        if (caryear.equals("0")||caryear.equals("")){
            caryear = null;
        }
        return bRestService.findSkuBySeriesAndYear(seriesId,caryear);
    }


    /**
     * 根据品牌Id和车系名称添加车系
     * @param brandId
     * @param seriesName
     * @return
     */
    @RequestMapping(value = "/insertCarSeries", method = RequestMethod.POST)
    public JsonResult insertCarSeries(Long brandId, String seriesName) {
        OperateEnum operateEnum = bRestService.insertSeries(brandId, seriesName);
        return JsonResult.build(operateEnum);
    }


    /**
     * 添加基础库
     * @return
     */
    @RequestMapping(value = "/insertCarBase", method = RequestMethod.POST)
    public JsonResult insertCarCarBase(CarBaseDTO carBaseDTO) {
        OperateEnum operateEnum = bRestService.insertCarCarBase(carBaseDTO);
        return JsonResult.build(operateEnum);
    }

    /**
     * 统计4s店信息
     * @param businessId
     * @return
     */
    @RequestMapping(value = "/getShopCount/{businessId}",method = RequestMethod.GET)
    public JsonResult getShopCount(@PathVariable("businessId") Long businessId){
       JsonResult result= bRestService.getShopCount(businessId);
        return result;
    }
}
