package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.PageResult;
import com.maizhong.mapper.OrderInfoMapper;
import com.maizhong.mapper.OrdersMapper;
import com.maizhong.pojo.OrderInfo;
import com.maizhong.pojo.Orders;
import com.maizhong.pojo.OrdersExample;
import com.maizhong.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-05-09
 * Time: 13:23
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;


    /**
     * 获取订单列表
     * @param param
     * @return
     */
    @Override
    public PageResult getOrderList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        OrdersExample example=new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        List<Orders> ordersList = ordersMapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(ordersList);
        return new PageResult(pageInfo);
    }
}
