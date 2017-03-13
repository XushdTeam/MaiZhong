package com.maizhong.rest.service.impl;

import com.maizhong.common.result.JsonResult;
import com.maizhong.mapper.TbAdvertMapper;
import com.maizhong.mapper.TbAdvertPublishMapper;
import com.maizhong.pojo.TbAdvert;
import com.maizhong.pojo.TbAdvertPublish;
import com.maizhong.pojo.TbAdvertPublishExample;
import com.maizhong.rest.service.AdvertPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-13
 * Time: 15:07
 */

@Service
public class AdvertPublishServiceImpl implements AdvertPublishService {

    @Autowired
    TbAdvertMapper tbAdvertMapper;

    @Override
    public JsonResult getAdvertByType(Integer type) {
        List<TbAdvert> list = tbAdvertMapper.getAdvertPublish(Long.valueOf(type));
        return JsonResult.OK(list);
    }
}

