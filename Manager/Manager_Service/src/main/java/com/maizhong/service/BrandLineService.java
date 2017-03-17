package com.maizhong.service;


import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.TbCarBrand;
import com.maizhong.pojo.TbCarBrandLine;

/**
 * Description:车型  品牌子类
 * User: yangF
 * Date: 2017-03-16
 */
public interface BrandLineService {


    /**
     * 通过汽车车型id 获取汽车车型对象
     * @param id
     * @return
     */
    TbCarBrandLine getCarBrandLineByid(Long id);

    /**
     * 车型  根据品牌Id返回
     * @param brandId
     * @return
     */
    JsonResult getCarBrandLineList(Long brandId);


    /**
     * 新增
     * @param tbCarBrandLine
     * @return
     */
    JsonResult insertCarBrandLine(TbCarBrandLine tbCarBrandLine);

    /**
     * 品牌信息修改
     * @param tbCarBrandLine
     * @return
     */
    JsonResult updateCarBrandLine(TbCarBrandLine tbCarBrandLine);


    /**
     * 删除
     * @param id
     * @return
     */
    JsonResult deleteById(Long id);

}
