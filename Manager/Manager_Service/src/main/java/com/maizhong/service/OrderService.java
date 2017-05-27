package com.maizhong.service;

import com.alibaba.fastjson.JSONObject;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.OrderInfo;
import com.maizhong.pojo.Orders;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-05-09
 * Time: 13:23
 */
public interface OrderService  {
    PageResult getOrderList(PageSearchParam param);

    Orders getOrdersById(Long aLong);

    OrderInfo getOrdersInfo(Long orderNumber);

    OperateEnum updateOrders(Orders orders);

    OperateEnum deleteOrdersById(long id);

    Orders getOrdersByOrderNumber(Long aLong);

    PageResult yuyueList(PageSearchParam param);
}
