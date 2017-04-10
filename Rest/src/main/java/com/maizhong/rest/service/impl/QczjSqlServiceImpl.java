package com.maizhong.rest.service.impl;

import com.maizhong.common.dto.KeyValue;
import com.maizhong.common.utils.TimeUtils;
import com.maizhong.mapper.TbAssessBrandMapper;
import com.maizhong.mapper.TbAssessCarMapper;
import com.maizhong.mapper.TbAssessSeriesMapper;
import com.maizhong.pojo.*;
import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.QczjSqlService;
import com.maizhong.rest.service.QczjhttpService;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yangf on 2017/4/7.
 */
@Service
public class QczjSqlServiceImpl implements QczjSqlService {

    @Resource
    private TbAssessBrandMapper tbAssessBrandMapper;

    @Resource
    private TbAssessSeriesMapper tbAssessSeriesMapper;

    @Resource
    private TbAssessCarMapper tbAssessCarMapper;


    @Resource
    private QczjhttpService qczjhttpService;


    /**
     * 根据汽车品牌 id
     *          插入 车系
     *              根据车系 插入车型数据
     *                  同步方法
     *          用途 ： 更新数据库
     */
    @Override
    public JsonResult getSeries4Brand(){
        List<TbAssessBrand> brands = tbAssessBrandMapper.selectByExample(null);

        for (TbAssessBrand tbBrand:brands) {
            Long id = tbBrand.getId();

            JsonResult jsonResult = qczjhttpService.returnCarSeries(id);
            Map<String,List<KeyValue>> map = (Map<String, List<KeyValue>>) jsonResult.getData();


            if (map==null||map.size()==0){
                return JsonResult.Error("此次查询未发现数据");
            }
            for (Map.Entry<String,List<KeyValue>> entry:map.entrySet()) {
                TbAssessSeries series = null;
                if (StringUtils.isNotBlank(entry.getKey())){
                    for (KeyValue kv:entry.getValue()) {

                        series = new TbAssessSeries();
                        series.setId(Long.parseLong(kv.getKey()));
                        series.setBrandId(id);
                        series.setFactory(entry.getKey());
                        series.setName(kv.getValue());
                        try {
                            if (tbAssessSeriesMapper.selectByPrimaryKey(series.getId())==null){
                                tbAssessSeriesMapper.insertSelective(series);
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        getCarInfo4Series(series.getId());
                        series = null;
                    }
                }
            }
//            tbAssessBrandMapper.deleteByPrimaryKey(id);
        }
        return JsonResult.OK("同步成功");
    }

    public JsonResult getCarInfo4Series(Long seriesId){

        List<QczjCarSeries> result = (List<QczjCarSeries>)( qczjhttpService.returnCarType(seriesId).getData());

        Integer count = 0;

        for (QczjCarSeries series:result) {
            List<Map<String, String>> spec = series.getSpec();
            String year = series.getYear().replaceAll("[^0-9]", "");
            String maxlen = series.getMaxlen();
            for (Map<String,String> map:spec) {
                TbAssessCar car = new TbAssessCar();
                car.setId(Long.parseLong(map.get("id")));
                car.setName(map.get("name"));
                car.setYear(year);
                car.setMaxlen(maxlen);
                car.setSeriesId(seriesId);
                try {
                    if (tbAssessCarMapper.selectByPrimaryKey(car.getId())==null){
                        int i = tbAssessCarMapper.insertSelective(car);
                        if (i==0){

                        }
                    }else{
                        System.out.println(car.getId()+"数据重复");
                        count ++;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    count++;
                }
            }
        }
        return JsonResult.OK("添加成功"+(count==0?"":("失败"+count+"条")));
    }


    @Override
    public JsonResult getBrandBySql() {
        TbAssessBrandExample example = new TbAssessBrandExample();
        example.setOrderByClause(" initial asc ");
        return JsonResult.OK(tbAssessBrandMapper.selectByExample(example));
    }

    @Override
    public JsonResult getSeriesByBrandId(Long brandId) {
        TbAssessSeriesExample example = new TbAssessSeriesExample();
        example.setOrderByClause(" factory asc ");
        example.createCriteria().andBrandIdEqualTo(brandId);
        return JsonResult.OK(tbAssessSeriesMapper.selectByExample(example));
    }

    @Override
    public JsonResult getCarBySeriesId(Long seriesId) {
        TbAssessCarExample example = new TbAssessCarExample();
        example.setOrderByClause(" year desc ");
        example.createCriteria().andSeriesIdEqualTo(seriesId);
        return JsonResult.OK(tbAssessCarMapper.selectByExample(example));
    }

    /**
     * 获取排量以及公里数
     *          先查询数据库  没有发送请求   并且同步到数据库中
     * @param carId
     * @return
     */
    @Override
    public JsonResult getCarBuyDateAndmileage(Long carId) {
        TbAssessCar car = tbAssessCarMapper.selectByPrimaryKey(carId);
        if(car.getBuydate()!=null){
            Map returnResult = new HashMap();
            DateTime time = new DateTime(car.getBuydate());
            returnResult.put("year",time.toString("yyyy"));
            returnResult.put("buydate",time.toString("yyyy-MM-dd"));
            returnResult.put("mileage",car.getMileage());
            return JsonResult.OK(returnResult);
        }
        JsonResult jsonResult = qczjhttpService.carBrandCallback(carId);
        if (jsonResult.getStatus()==200){
            Map data = (Map) jsonResult.getData();
            if (data.get("buydate")==null||data.get("mileage")==null){
                return JsonResult.Error("数据错误");
            }
            DateTime time = DateTime.parse(data.get("buydate").toString(), DateTimeFormat.forPattern("yyyy-MM-dd"));
            car.setBuydate(time.toDate());
            car.setMileage(data.get("mileage").toString());
            tbAssessCarMapper.updateByPrimaryKeySelective(car);
        }
        return jsonResult;
    }
}