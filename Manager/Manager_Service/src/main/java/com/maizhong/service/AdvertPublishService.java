package com.maizhong.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.TbAdvert;
import com.maizhong.pojo.TbAdvertPublish;

import java.util.List;

/**
 * Description:广告发布信息接口
 * User: 王存浩
 * Date: 2017-03-08
 * Time: 13:25
 */
public interface AdvertPublishService {
    /**
     * 通过广告发布表id 获取广告发布对象
     * @param id
     * @return
     */
    TbAdvertPublish getAdvertPublishByid(Long id);

    /**
     * 广告发布信息列表-分页
     * @param param
     * @return
     */
    PageResult getAdvertPublishList(PageSearchParam param);


    /**
     * 新增广告信息
     * @param tbAdvertPublish
     * @return
     */
    OperateEnum insertAdvertPublish(TbAdvertPublish tbAdvertPublish);

    /**
     * 广告发布信息修改
     * @param tbAdvertPublish
     * @return
     */
    OperateEnum updateAdvertPublish(TbAdvertPublish tbAdvertPublish);

    /**
     * 删除广告发布信息
     * @param id
     * @return
     */
    OperateEnum deleteAdvertPublishById(long id);

   List<TbAdvertPublish> selectTypeListByPrimaryKey(long id);


    public TbAdvertPublish getPublishByid(Long id);

    public OperateEnum changeSort(String meth,Long id);

    public  OperateEnum advertPublish(long id);


}
