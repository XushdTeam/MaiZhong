package com.maizhong.service;


import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.TbBusiness;

/**
 * Description:店铺管理服务接口
 * User: 王存浩
 * Date: 2017-03-06
 * Time: 10:57
 */
public interface BusinessService {


    /**
     * 通过类别id 获取4s店对象
     * @param id
     * @return
     */
    TbBusiness getBusinessByid(Long id);

    /**
     * 类别列表-分页
     * @param param
     * @return
     */
    PageResult getBusinessList(PageSearchParam param);


    /**
     * 所有店铺列表
     * @return
     */

    public String getBusinessListAll();



    /**
     * 新增店铺
     * @param
     * @return
     */
    OperateEnum insertBusiness(TbBusiness tbBusiness);

    /**
     * 店铺信息修改
     * @param tbBusiness
     * @return
     */
    OperateEnum updateBusiness(TbBusiness tbBusiness);


    /**
     * 删除店铺信息
     * @param id
     * @return
     */
    OperateEnum deleteBusinessById(long id);

    /**
     * 修改店铺的LOGO
     * @param logo
     * @param id
     * @return
     */
    int updateBusinessLogo(String logo, long id);


}
