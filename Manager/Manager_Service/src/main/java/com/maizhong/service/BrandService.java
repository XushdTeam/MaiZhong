package com.maizhong.service;


import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.TbCarBrand;

import java.util.List;

/**
 * Description:品牌服务接口
 * User: 王存浩
 * Date: 2017-03-06
 * Time: 10:57
 */
public interface BrandService {


    /**
     * 通过汽车品牌id 获取汽车品牌对象
     * @param id
     * @return
     */
    TbCarBrand getCarBrandByid(Long id);

    /**
     * 品牌列表-分页
     * @param param
     * @return
     */
    PageResult getCarBrandList(PageSearchParam param);

    List<TbCarBrand> getCarBrandList();


    /**
     * 所有品牌列表
     * @return
     */

    public String getCarBrandListAll();



    /**
     * 新增品牌
     * @param tbCarBrand
     * @return
     */
    OperateEnum insertCarBrand(TbCarBrand tbCarBrand);

    /**
     * 品牌信息修改
     * @param tbCarBrand
     * @return
     */
    OperateEnum updateCarBrand(TbCarBrand tbCarBrand);


    /**
     * 删除汽车品牌信息
     * @param id
     * @return
     */
    OperateEnum deleteCarBrandById(long id);

    /**
     * 修改汽车品牌logo
     * @param carBrandAdvertImgUrl
     * @param id
     * @return
     */
    int updateBrandAdvert(String carBrandAdvertImgUrl, long id);


    JsonResult updateBrandRedis();
}
