package com.maizhong.service;


import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.TbCarType;

/**
 * Description:类别服务接口
 * User: 王存浩
 * Date: 2017-03-06
 * Time: 10:57
 */
public interface TypeService {


    /**
     * 通过类别id 获取汽车类别对象
     * @param id
     * @return
     */
    TbCarType getCarTypeByid(Long id);

    /**
     * 类别列表-分页
     * @param param
     * @return
     */
    PageResult getCarTypeList(PageSearchParam param);


    /**
     * 所有类别列表
     * @return
     */

    public String getCarTypeListAll();



    /**
     * 新增类别
     * @param
     * @return
     */
    OperateEnum insertCarType(TbCarType tbCarType);

    /**
     * 类别信息修改
     * @param tbCarType
     * @return
     */
    OperateEnum updateCarType(TbCarType tbCarType);


    /**
     * 删除汽车类别信息
     * @param id
     * @return
     */
    OperateEnum deleteCarTypeById(long id);

    /**
     * 修改汽车类别示例图片
     * @param carTypeAdvertImgUrl
     * @param id
     * @return
     */
    int updateTypeAdvert(String carTypeAdvertImgUrl, long id);


    JsonResult updateTypeRedis();
}
