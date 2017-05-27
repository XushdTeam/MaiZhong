package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.mapper.OrderInfoMapper;
import com.maizhong.mapper.OrdersMapper;
import com.maizhong.pojo.OrderInfo;
import com.maizhong.pojo.OrderInfoExample;
import com.maizhong.pojo.Orders;
import com.maizhong.pojo.OrdersExample;
import com.maizhong.service.OrderService;
import org.apache.commons.lang3.StringUtils;
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
     *
     * @param param
     * @return
     */
    @Override
    public PageResult getOrderList(PageSearchParam param) {


        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        String status = param.getFiled("status");
        if (StringUtils.isNotBlank(status)) {
            try {
                criteria.andStatusEqualTo(Integer.valueOf(status));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        String orderNumber = param.getFiled("orderNumber");

        if (StringUtils.isNotBlank(orderNumber)) {
            try {
                criteria.andOrderNumberEqualTo(Long.valueOf(orderNumber));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        String userId = param.getFiled("user_id");
        if (StringUtils.isNotBlank(userId)) {
            try {
                criteria.andUserIdEqualTo(Long.valueOf(userId));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        criteria.andDelflagEqualTo(0);
        criteria.andStatusGreaterThan(0);
        example.setOrderByClause("order_id DESC");
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        List<Orders> ordersList = ordersMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(ordersList);
        return new PageResult(pageInfo);
    }


    /**
     * 获取订单
     *
     * @param aLong
     * @return
     */
    @Override
    public Orders getOrdersById(Long aLong) {
        Orders orders = ordersMapper.selectByPrimaryKey(aLong);

        System.out.println(orders.getReckonTime());
        return orders;
    }

    /**
     * 获取订单信息
     *
     * @param orderNumber
     * @return
     */
    @Override
    public OrderInfo getOrdersInfo(Long orderNumber) {
        OrderInfoExample example = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNumberEqualTo(orderNumber);
        List<OrderInfo> orderInfoList = orderInfoMapper.selectByExample(example);
        if (orderInfoList != null && orderInfoList.size() > 0) {
            OrderInfo orderInfo = orderInfoList.get(0);
            if (StringUtils.equals("1", orderInfo.getCk())) {
                orderInfo.setCk("车况优秀");
            } else if (StringUtils.equals("2", orderInfo.getCk())) {
                orderInfo.setCk("车况良好");
            } else if (StringUtils.equals("3", orderInfo.getCk())) {
                orderInfo.setCk("车况一般");
            } else {
                orderInfo.setCk("车况较差");
            }
            //颜色
            switch (orderInfo.getColor()) {
                case "1":
                    orderInfo.setColor("米色");
                    break;
                case "2":
                    orderInfo.setColor("白色");
                    break;
                case "3":
                    orderInfo.setColor("灰色");
                    break;
                case "4":
                    orderInfo.setColor("红色");
                    break;
                case "5":
                    orderInfo.setColor("棕色");
                    break;
                case "6":
                    orderInfo.setColor("蓝色");
                    break;
                case "7":
                    orderInfo.setColor("黄色");
                    break;
                case "8":
                    orderInfo.setColor("黑色");
                    break;
                case "9":
                    orderInfo.setColor("银色");
                    break;
                case "10":
                    orderInfo.setColor("绿色");
                    break;
                default:
                    orderInfo.setColor("其他颜色");
                    break;
            }
            //交强险
            if (StringUtils.equals(orderInfo.getJqx(), "1")) {
                orderInfo.setJqx("两个月以内");
            } else {
                orderInfo.setJqx("两个月以上");
            }
            //过户
            if (StringUtils.equals(orderInfo.getGh(), "1")) {
                orderInfo.setGh("0次");
            } else if (StringUtils.equals(orderInfo.getGh(), "2")) {
                orderInfo.setGh("1次");
            } else if (StringUtils.equals(orderInfo.getGh(), "3")) {
                orderInfo.setGh("2次");
            } else {
                orderInfo.setGh("3次及以上");
            }
            //过户时间
            if (StringUtils.equals(orderInfo.getGhtime(), "1")) {
                orderInfo.setGhtime("无过户");
            } else if (StringUtils.equals(orderInfo.getGhtime(), "2")) {
                orderInfo.setGhtime("六个月以内");
            }
            {
                orderInfo.setGhtime("六个月以上");
            }
            //性质
            if (StringUtils.equals(orderInfo.getXz(), "1")) {
                orderInfo.setXz("非营运");
            } else {
                orderInfo.setXz("租赁");
            }
            //年检
            if (StringUtils.equals(orderInfo.getNj(), "1")) {
                orderInfo.setNj("两个月以内");
            } else {
                orderInfo.setNj("两个月以上");
            }
            //使用方式
            if (StringUtils.equals(orderInfo.getMethod(), "1")) {
                orderInfo.setMethod("公司");
            } else {
                orderInfo.setMethod("个人");
            }
            return orderInfo;
        }
        return null;
    }

    /**
     * 更新订单信息  orderinfo不可更新
     *
     * @param orders
     * @return
     */
    @Override
    public OperateEnum updateOrders(Orders orders) {
        int i = ordersMapper.updateByPrimaryKeySelective(orders);
        if (i > 0) {
            return OperateEnum.SUCCESS;
        }
        return OperateEnum.FAILE;
    }

    /**
     * 删除订单 逻辑删除
     *
     * @param id
     * @return
     */
    @Override
    public OperateEnum deleteOrdersById(long id) {

        Orders orders = ordersMapper.selectByPrimaryKey(id);
        if (orders != null && orders.getOrderId() != null) {
            orders.setDelflag(1);
        }
        OrderInfoExample example = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNumberEqualTo(orders.getOrderNumber());
        List<OrderInfo> orderInfoList = orderInfoMapper.selectByExample(example);
        if (orderInfoList != null && orderInfoList.size() > 0) {
            OrderInfo orderInfo = orderInfoList.get(0);
            orderInfo.setDelflag(1);
            orderInfoMapper.updateByPrimaryKeySelective(orderInfo);

        }

        int i = ordersMapper.updateByPrimaryKeySelective(orders);
        if (i > 0) {
            return OperateEnum.SUCCESS;
        }
        return OperateEnum.FAILE;
    }

    /**
     * 获取订单对象
     *
     * @param orderNumber
     * @return
     */
    @Override
    public Orders getOrdersByOrderNumber(Long orderNumber) {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNumberEqualTo(orderNumber);
        List<Orders> ordersList = ordersMapper.selectByExample(example);
        if (ordersList == null || ordersList.size() == 0) {
            return null;
        }
        return ordersList.get(0);
    }

    /**
     * 未预约订单
     * @param param
     * @return
     */
    @Override
    public PageResult yuyueList(PageSearchParam param) {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        String status = param.getFiled("status");
        if (StringUtils.isNotBlank(status)) {
            try {
                criteria.andStatusEqualTo(Integer.valueOf(status));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        String orderNumber = param.getFiled("orderNumber");

        if (StringUtils.isNotBlank(orderNumber)) {
            try {
                criteria.andOrderNumberEqualTo(Long.valueOf(orderNumber));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        String userId = param.getFiled("user_id");
        if (StringUtils.isNotBlank(userId)) {
            try {
                criteria.andUserIdEqualTo(Long.valueOf(userId));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        criteria.andDelflagEqualTo(0);
        criteria.andStatusEqualTo(0);
        example.setOrderByClause("order_id DESC");
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        List<Orders> ordersList = ordersMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(ordersList);
        return new PageResult(pageInfo);
    }


}
