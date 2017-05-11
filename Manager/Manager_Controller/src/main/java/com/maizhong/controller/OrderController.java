package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: 订单管理
 * User: 王存浩
 * Date: 2017-05-09
 * Time: 13:21
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /*@RequiresPermissions("/orders")*/
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orders(Model model) {
        model.addAttribute("baseUrl", "/orders");
        model.addAttribute("listUrl", "/orders/list");
        model.addAttribute("handleUrl", "/orders/handle");
        model.addAttribute("deleteUrl", "/orders/delete");
        return "/order/orders";
    }

    /**
     * 订单管理
     *
     * @param param
     * @return
     */
    @ControllerLog(module = "订单管理", methods = "订单审核")
    @RequestMapping(value = "/orders/list", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult orderList(PageSearchParam param) {
        PageResult result = orderService.getOrderList(param);
        return JsonResult.OK(result);
    }
/*
    *//**
     * 订单修改
     *
     * @param id
     * @param model
     * @return
     *//*
    @RequestMapping(value = "/orders/handle/{id}")
    public String handle(@PathVariable String id, Model model) {

        model.addAttribute("baseUrl", "/order/orders");
        Orders orders = orderService.getOrdersById(Long.valueOf(id));

        OrderInfo orderInfo = orderService.getOrdersInfo(orders.getOrderNumber());
        model.addAttribute("orders", orders);
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("handle", "帮助管理/帮助修改");
        model.addAttribute("saveUrl", "/orders/update");
        return "order/orders_setting";

    }*/
/*
    *//**
     * 订单删除
     *
     * @param id
     * @return
     *//*
  *//*  @RequiresPermissions("/orders/delete")*//*
    @ControllerLog(module = "订单管理", methods = "订单删除")
    @RequestMapping(value = "/orders/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult helpDelete(@PathVariable long id) {
        //订单删除
        OperateEnum result = orderService.deleteOrdersById(id);
        return JsonResult.build(result);
    }*/


    /**
     * 订单管理
     *
     * @param orders
     * @return
     *//*
    *//*@RequiresPermissions("/orders/update")*//*
    @ControllerLog(module = "订单管理", methods = "订单信息修改")
    @RequestMapping(value = "/orders/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult ordersUpdate(Orders orders, OrderInfo orderInfo) {
        OperateEnum result = orderService.updateOrders(orders, orderInfo);
        return JsonResult.build(result);
    }*/

/*
    */
/**
 * 订单信息修改
 * @param orderInfo
 * @return
 *//*

    */
/*@RequiresPermissions("/orders/update")*//*

    @ControllerLog(module = "订单管理", methods = "订单信息修改")
    @RequestMapping(value = "/olrders/updateInfo",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult orderInfoUpdate(OrderInfo orderInfo){
        OperateEnum result=orderService.updateOrderInfo(orderInfo);
        return JsonResult.build(result);
    }



*/


}
