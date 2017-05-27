package com.maizhong.controller;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.target.ControllerLog;
import com.maizhong.pojo.OrderInfo;
import com.maizhong.pojo.Orders;
import com.maizhong.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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


    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orders(Model model) {
        model.addAttribute("baseUrl", "/orders");
        model.addAttribute("listUrl", "/orders/list");
        model.addAttribute("handleUrl", "/orders/handle");
        model.addAttribute("deleteUrl", "/orders/delete");
        return "/order/orders";
    }


    @RequestMapping(value = "/yuyue", method = RequestMethod.GET)
    public String yuyue(Model model) {
        model.addAttribute("baseUrl", "/yuyue");
        model.addAttribute("listUrl", "/orders/yuyue");
        model.addAttribute("handleUrl", "/yuyue/handle");
        model.addAttribute("deleteUrl", "/orders/delete");
        return "/order/orders_yuyue";
    }


    /**
     * 订单管理
     *
     * @param param
     * @return
     */
    @ControllerLog(module = "订单管理", methods = "完整订单")
    @RequestMapping(value = "/orders/list")
    @ResponseBody
    public JsonResult orderList(PageSearchParam param) {
        PageResult result = orderService.getOrderList(param);
        return JsonResult.OK(result);
    }

    /**
     * 订单管理
     *
     * @param param
     * @return
     */
    @ControllerLog(module = "订单管理", methods = "未预约订单")
    @RequestMapping(value = "/orders/yuyue")
    @ResponseBody
    public JsonResult yuyueList(PageSearchParam param) {
        PageResult result = orderService.yuyueList(param);
        return JsonResult.OK(result);
    }

/**
     * 订单修改
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/orders/handle/{id}")
    public String handle(@PathVariable String id, Model model) {

        model.addAttribute("baseUrl", "/orders/handle/"+id);
        Orders orders = orderService.getOrdersById(Long.valueOf(id));
        OrderInfo orderInfo = orderService.getOrdersInfo(orders.getOrderNumber());
        model.addAttribute("orders", orders);
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("handle", "订单管理/订单审核");
        model.addAttribute("saveUrl", "/orders/update");
        return "order/orders_setting";
    }

    /**
     * 订单修改
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/yuyue/handle/{id}")
    public String yuyueHandle(@PathVariable String id, Model model) {

        model.addAttribute("baseUrl", "/yuyue");
        Orders orders = orderService.getOrdersById(Long.valueOf(id));
        OrderInfo orderInfo = orderService.getOrdersInfo(orders.getOrderNumber());
        model.addAttribute("orders", orders);
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("handle", "订单管理/订单审核");
        model.addAttribute("saveUrl", "/orders/update");
        return "order/yuyue";
    }




    /**
     * 订单更新
     *
     * @param orderNumber
     * @param model
     * @return
     */
    @RequestMapping(value = "/orders/check/{orderNumber}")
    public String check(@PathVariable String orderNumber, Model model) {
        model.addAttribute("baseUrl", "/orders/check/"+orderNumber);
        Orders orders = orderService.getOrdersByOrderNumber(Long.valueOf(orderNumber));
        OrderInfo orderInfo = orderService.getOrdersInfo(orders.getOrderNumber());
        model.addAttribute("orders", orders);
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("handle", "订单确认/订单审核");
        model.addAttribute("saveUrl", "/orders/update");
        return "order/orders_setting";
    }




    /**
     * 订单删除
     *
     * @param id
     * @return
     */
    @ControllerLog(module = "订单管理", methods = "订单删除")
    @RequestMapping(value = "/orders/delete/{id}")
    @ResponseBody
    public JsonResult orderDelete(@PathVariable long id) {
        //订单删除
        OperateEnum result = orderService.deleteOrdersById(id);
        return JsonResult.build(result);
    }


    /**
     * 订单管理
     *
     * @param orders
     * @return
     */
    @ControllerLog(module = "订单管理", methods = "订单信息修改")
    @RequestMapping(value = "/orders/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult ordersUpdate(Orders orders) {
        OperateEnum result = orderService.updateOrders(orders);
        return JsonResult.build(result);
    }

}
