package com.maizhong.service;

import com.maizhong.common.dto.KeyValue;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
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
     * 删除广告发布信息
     * @param id
     * @return
     */
    OperateEnum deleteAdvertPublishById(Long id);

   List<TbAdvertPublish> selectTypeListByPrimaryKey(Long id);

    public TbAdvertPublish getPublishByid(Long id);

    public OperateEnum changeSort(String meth,Long id);

    public  OperateEnum advertPublish(Long id);

    OperateEnum removeAdvertPublishById(long id);
    List<KeyValue> getAdvertTypeList();
}
