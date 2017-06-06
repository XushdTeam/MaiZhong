package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.TimeUtils;
import com.maizhong.mapper.OrderInfoMapper;
import com.maizhong.mapper.OrdersMapper;
import com.maizhong.pojo.OrderInfo;
import com.maizhong.pojo.OrderInfoExample;
import com.maizhong.pojo.Orders;
import com.maizhong.pojo.OrdersExample;
import com.maizhong.service.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
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
     * 获取需要评估师验车的订单列表
     *
     * @param param
     * @return
     */
    @Override
    public PageResult yancheList(PageSearchParam param) {

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
        criteria.andStatusEqualTo(1);
        example.setOrderByClause("order_id DESC");
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());
        List<Orders> ordersList = ordersMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(ordersList);
        return new PageResult(pageInfo);
    }

    /**
     * 售后订单
     *
     * @param param
     * @return
     */
    @Override
    public PageResult shouhouList(PageSearchParam param) {

        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();

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
        criteria.andStatusGreaterThan(1);
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
            if (StringUtils.equals(orderInfo.getGh(), "4")) {
                orderInfo.setGh("0次");
            } else if (StringUtils.equals(orderInfo.getGh(), "1")) {
                orderInfo.setGh("1次");
            } else if (StringUtils.equals(orderInfo.getGh(), "2")) {
                orderInfo.setGh("2次");
            } else {
                orderInfo.setGh("3次及以上");
            }
            //过户时间
            if (StringUtils.equals(orderInfo.getGhtime(), "1")) {
                orderInfo.setGhtime("无过户");
            } else if (StringUtils.equals(orderInfo.getGhtime(), "2")) {
                orderInfo.setGhtime("六个月以内");
            } else {
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
     *
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

    /**
     * 导出订单
     *
     * @param wb
     */
    @Override
    public void exportExcel(HSSFWorkbook wb) {
        OrdersExample example=new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo(0);
        List<Orders> ordersList = ordersMapper.selectByExample(example);
        HSSFSheet sheet = wb.createSheet("订单记录");
        sheet.setDefaultRowHeight((short) (2 * 256));

        HSSFFont font = wb.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 16);
        HSSFRow row = sheet.createRow(0);
        sheet.createRow(1);

        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        HSSFCell cell = row.createCell(0);
        cell.setCellValue("序号");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("订单编号");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("用户手机");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("车型名称");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("预估价格");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("预估时间");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("交易价格");
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue("交易时间");
        cell.setCellStyle(style);

        cell = row.createCell(8);
        cell.setCellValue("联系人称呼");
        cell.setCellStyle(style);


        cell = row.createCell(9);
        cell.setCellValue("验车电话");
        cell.setCellStyle(style);


        cell = row.createCell(10);
        cell.setCellValue("验车方式");
        cell.setCellStyle(style);

        cell = row.createCell(11);
        cell.setCellValue("验车地址");
        cell.setCellStyle(style);

        cell = row.createCell(12);
        cell.setCellValue("验车时间");
        cell.setCellStyle(style);


        cell = row.createCell(13);
        cell.setCellValue("城市");
        cell.setCellStyle(style);

        cell = row.createCell(14);
        cell.setCellValue("公里数");
        cell.setCellStyle(style);

        cell = row.createCell(15);
        cell.setCellValue("上牌时间");
        cell.setCellStyle(style);

        cell = row.createCell(16);
        cell.setCellValue("颜色");
        cell.setCellStyle(style);

        cell = row.createCell(17);
        cell.setCellValue("过户次数");
        cell.setCellStyle(style);

        cell = row.createCell(18);
        cell.setCellValue("过户时间");
        cell.setCellStyle(style);

        cell = row.createCell(19);
        cell.setCellValue("交强险");
        cell.setCellStyle(style);

        cell = row.createCell(20);
        cell.setCellValue("年检");
        cell.setCellStyle(style);

        cell = row.createCell(21);
        cell.setCellValue("使用性质");
        cell.setCellStyle(style);

        cell = row.createCell(22);
        cell.setCellValue("使用方");
        cell.setCellStyle(style);

        cell = row.createCell(23);
        cell.setCellValue("车况");
        cell.setCellStyle(style);


        cell = row.createCell(24);
        cell.setCellValue("订单状态");
        cell.setCellStyle(style);

        for (int i = 0; i < ordersList.size(); i++) {
            HSSFRow row1 = sheet.createRow(i + 1);

            Orders orders = ordersList.get(i);
            OrderInfo orderInfo = getOrdersInfo(orders.getOrderNumber());
            row1.createCell(0).setCellValue(i + 1);//序号
            row1.createCell(1).setCellValue(String.valueOf(orders.getOrderNumber()));//订单编号
            row1.createCell(2).setCellValue(String.valueOf(orders.getUserId()));//用户手机
            row1.createCell(3).setCellValue(orders.getModelName());//车型名称
            row1.createCell(4).setCellValue(orders.getReckonPrice());//预估价格
            try {
                row1.createCell(6).setCellValue(orders.getDealPrice());//交易价格
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (StringUtils.isNotBlank(orders.getDealTime())) {
                row1.createCell(7).setCellValue(orders.getDealTime().substring(0, 10));//交易时间
            }

            row1.createCell(8).setCellValue(orders.getLinkMan());//联系人称呼
            row1.createCell(9).setCellValue(orders.getLinkPhone());//验车电话

            if (orders.getDealWay() != null) {
                if (orders.getDealWay() == 1) {
                    row1.createCell(10).setCellValue("4S店验车");//验车方式
                } else if (orders.getDealWay() == 2) {
                    row1.createCell(10).setCellValue("地铁站验车");//验车方式
                } else if (orders.getDealWay() == 3) {
                    row1.createCell(10).setCellValue("上门验车");//验车方式
                }
            }


            row1.createCell(11).setCellValue(orders.getAddress());//验车地址
            row1.createCell(12).setCellValue(orders.getCheckTime());//验车时间
            row1.createCell(13).setCellValue(orderInfo.getCityId());//城市
            row1.createCell(14).setCellValue(orderInfo.getsKm());//公里数
            row1.createCell(15).setCellValue(orderInfo.getRegDate());//上牌时间
            row1.createCell(16).setCellValue(orderInfo.getColor());//颜色
            row1.createCell(17).setCellValue(orderInfo.getGh());//过户次数
            row1.createCell(18).setCellValue(orderInfo.getGhtime());//过户时间
            row1.createCell(19).setCellValue(orderInfo.getJqx());//交强险
            row1.createCell(20).setCellValue(orderInfo.getNj());//年检
            row1.createCell(21).setCellValue(orderInfo.getXz());//使用性质
            row1.createCell(22).setCellValue(orderInfo.getMethod());//使用方
            row1.createCell(23).setCellValue(orderInfo.getCk());//车况

            switch (orders.getStatus()) {
                case 0:
                    row1.createCell(24).setCellValue("未预约");
                    break;
                case 1:
                    row1.createCell(24).setCellValue("等待验收");
                    break;
                case 2:
                    row1.createCell(24).setCellValue("车辆处理");
                    break;
                case 3:
                    row1.createCell(24).setCellValue("等待过户");
                    break;
                case 4:
                    row1.createCell(24).setCellValue("过户完成");
                    break;
                case 5:
                    row1.createCell(24).setCellValue("更新指标");
                    break;
                case 6:
                    row1.createCell(24).setCellValue("已完结");
                    break;
            }


        }

        for (int m = 0; m <= 24; m++) {
            sheet.autoSizeColumn(m, true);
        }

    }

    /**
     * 根据订单Id导出ECXEL
     *
     * @param wb
     * @param orderId
     */
    @Override
    public void exportExcelOne(HSSFWorkbook wb, String orderId) {
        Long id = 1L;
        try {
            id = Long.valueOf(orderId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Orders orders = ordersMapper.selectByPrimaryKey(id);

        HSSFSheet sheet = wb.createSheet("订单记录");
        sheet.setDefaultRowHeight((short) (2 * 256));

        HSSFFont font = wb.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        HSSFRow row = sheet.createRow(0);
        HSSFRow row1 = sheet.createRow(1);
        HSSFRow row2 = sheet.createRow(2);
        HSSFRow row3 = sheet.createRow(3);
        HSSFRow row4 = sheet.createRow(4);
        HSSFRow row5 = sheet.createRow(5);

        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setFont(font);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

        HSSFCellStyle setBorder = wb.createCellStyle();
        setBorder.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        setBorder.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        setBorder.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        setBorder.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

        HSSFCellStyle setBorder2 = wb.createCellStyle();
        setBorder2.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        setBorder2.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        setBorder2.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        setBorder2.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
        setBorder2.setWrapText(true);


        HSSFCell cell = row.createCell(0);
        cell.setCellValue("序号");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("订单编号");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("用户手机");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("车型名称");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("预估价格");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("交易价格");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("交易时间");
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue("联系人称呼");
        cell.setCellStyle(style);
        /*换行*/


        cell = row2.createCell(0);
        cell.setCellValue("城市");
        cell.setCellStyle(style);

        cell = row2.createCell(1);
        cell.setCellValue("验车电话");
        cell.setCellStyle(style);


        cell = row2.createCell(2);
        cell.setCellValue("验车方式");
        cell.setCellStyle(style);

        cell = row2.createCell(3);
        cell.setCellValue("验车地址");
        cell.setCellStyle(style);

        cell = row2.createCell(4);
        cell.setCellValue("验车时间");
        cell.setCellStyle(style);

        cell = row2.createCell(5);
        cell.setCellValue("公里数");
        cell.setCellStyle(style);

        cell = row2.createCell(6);
        cell.setCellValue("上牌时间");
        cell.setCellStyle(style);


        cell = row2.createCell(7);
        cell.setCellValue("颜色");
        cell.setCellStyle(style);

         /*换行*/
        cell = row4.createCell(0);
        cell.setCellValue("过户次数");
        cell.setCellStyle(style);

        cell = row4.createCell(1);
        cell.setCellValue("过户时间");
        cell.setCellStyle(style);

        cell = row4.createCell(2);
        cell.setCellValue("交强险");
        cell.setCellStyle(style);

        cell = row4.createCell(3);
        cell.setCellValue("年检");
        cell.setCellStyle(style);

        cell = row4.createCell(4);
        cell.setCellValue("使用性质");
        cell.setCellStyle(style);

        cell = row4.createCell(5);
        cell.setCellValue("使用方");
        cell.setCellStyle(style);

        cell = row4.createCell(6);
        cell.setCellValue("车况");
        cell.setCellStyle(style);

        cell = row4.createCell(7);
        cell.setCellValue("订单状态");
        cell.setCellStyle(style);


        OrderInfo orderInfo = getOrdersInfo(orders.getOrderNumber());
        cell = row1.createCell(0);
        cell.setCellValue(1);//序号
        cell.setCellStyle(setBorder);

        cell = row1.createCell(1);
        cell.setCellValue(String.valueOf(orders.getOrderNumber()));//订单编号
        cell.setCellStyle(setBorder);


        cell = row1.createCell(2);
        cell.setCellValue(String.valueOf(orders.getUserId()));//用户手机
        cell.setCellStyle(setBorder);


        cell = row1.createCell(3);
        cell.setCellValue(orders.getModelName());//车型名称
        cell.setCellStyle(setBorder);


        cell = row1.createCell(4);
        cell.setCellValue(orders.getReckonPrice());//预估价格
        cell.setCellStyle(setBorder);


        try {
            cell = row1.createCell(5);
            cell.setCellValue(orders.getDealPrice());//交易价格
            cell.setCellStyle(setBorder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(orders.getDealTime())) {
            cell = row1.createCell(6);
            cell.setCellValue(orders.getDealTime().substring(0, 10));//交易时间
            cell.setCellStyle(setBorder);
        }

        cell = row1.createCell(7);
        cell.setCellValue(orders.getLinkMan());//联系人称呼
        cell.setCellStyle(setBorder);


        cell = row3.createCell(0);
        cell.setCellValue(orderInfo.getCityId());//城市
        cell.setCellStyle(setBorder);


        cell = row3.createCell(1);
        cell.setCellValue(orders.getLinkPhone());//验车电话
        cell.setCellStyle(setBorder);

        if (orders.getDealWay() != null) {
            cell = row3.createCell(2);
            cell.setCellStyle(setBorder);
            if (orders.getDealWay() == 1)
                cell.setCellValue("4S店验车");//验车方式
        } else if (orders.getDealWay() == 2) {
            cell.setCellValue("地铁站验车");//验车方式
        } else if (orders.getDealWay() == 3) {
            cell.setCellValue("上门验车");//验车方式
        }


        cell = row3.createCell(3);
        cell.setCellValue(orders.getAddress());//验车地址
        cell.setCellStyle(setBorder);

        cell = row3.createCell(4);
        cell.setCellValue(orders.getCheckTime());//验车时间
        cell.setCellStyle(setBorder);


        cell = row3.createCell(5);
        cell.setCellValue(orderInfo.getsKm());//公里数
        cell.setCellStyle(setBorder);

        cell = row3.createCell(6);
        cell.setCellValue(orderInfo.getRegDate());//上牌时间
        cell.setCellStyle(setBorder);


        cell = row3.createCell(7);
        cell.setCellValue(orderInfo.getColor());//颜色\
        cell.setCellStyle(setBorder);


        cell = row5.createCell(0);
        cell.setCellValue(orderInfo.getGh());//过户次数
        cell.setCellStyle(setBorder);

        cell = row5.createCell(1);
        cell.setCellValue(orderInfo.getGhtime());//过户时间
        cell.setCellStyle(setBorder);

        cell = row5.createCell(2);
        cell.setCellValue(orderInfo.getJqx());//交强险
        cell.setCellStyle(setBorder);
        cell = row5.createCell(3);
        cell.setCellValue(orderInfo.getNj());//年检
        cell.setCellStyle(setBorder);

        cell = row5.createCell(4);
        cell.setCellValue(orderInfo.getXz());//使用性质
        cell.setCellStyle(setBorder);

        cell = row5.createCell(5);
        cell.setCellValue(orderInfo.getMethod());//使用方
        cell.setCellStyle(setBorder);

        cell = row5.createCell(6);
        cell.setCellValue(orderInfo.getCk());//车况
        cell.setCellStyle(setBorder);

        cell = row5.createCell(7);
        cell.setCellStyle(setBorder);
        switch (orders.getStatus()) {
            case 0:
                cell.setCellValue("未预约");
                break;
            case 1:
                cell.setCellValue("等待验收");
                break;
            case 2:
                cell.setCellValue("车辆处理");
                break;
            case 3:
                cell.setCellValue("等待过户");
                break;
            case 4:
                cell.setCellValue("过户完成");
                break;
            case 5:
                cell.setCellValue("更新指标");
                break;
            case 6:
                cell.setCellValue("已完结");
                break;
        }

        for (int m = 0; m <= 11; m++) {
            sheet.autoSizeColumn(m, true);
        }


    }


}
