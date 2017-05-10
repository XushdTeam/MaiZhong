package com.maizhong.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.PageResult;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-05-09
 * Time: 13:23
 */
public interface OrderService  {
    PageResult getOrderList(PageSearchParam param);
}
