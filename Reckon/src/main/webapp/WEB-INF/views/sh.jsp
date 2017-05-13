<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/20
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>悟空收车</title>
    <meta name="keywords" content="悟空收车，悟空，二手车，估值，收购"/>
    <meta name="description" content="悟空收车专业的二手车估值收购平台，验车快，当天到账，售后跟踪"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/guzhi.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/per.css" />
    <link rel="stylesheet" type="text/css" href="/resources/font/iconfont.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js" type="text/javascript"></script>

</head>
<body class="bgss">
<div class="top e_top">
    <div class="t_cen">
        <a href="/" class="logo"><img src="/resources/img/logo.png"></a>
        <ul class="t_right">
            <li><a href="/">首页</a></li>
            <li><a href="/sale">我要卖车</a></li>
            <li><a href="/join">销售商加盟</a></li>
            <li><a href="/app">APP下载</a></li>
           <li><a href="/help">帮助中心</a></li>
            <li><a href="/per/or"  class="hover">个人中心</a></li>
        </ul>
        <ul class="lon" >
            <li >
                <i class="iconfont icon ">&#xe6a3;</i>
                <a href="/per/or"  id="user">${phone}</a>
            </li>
            <li>
                <a href="javascript:void(0)" class="two" id="exit"  onclick="exit();">退出</a>
            </li>
        </ul>
    </div>
</div><!--top end-->

<div class="x_nav" style="height: 40px"></div>
<style>
    a{text-decoration:none!important;}
    .main .m_left ul li span{
        font-size: 14px;
        color: #000;

        width: 180px;
        display: block;
        padding-left: 36px;
    }
    .main .m_left ul a li:hover{
        color: #F60!important;
    }
</style>
<div class="main">
    <div class="m_left">
        <ul>
            <a href="/per/or"  style="display: block">
                <li ><img src="/resources/img/p_03.jpg">
                    订单中心
                    <span >查看订单详情</span>
                </li>

            </a>
        </ul>

        <ul>
            <a href="javascript:;" style="display: block" class="cuns">
                <li style="color:#f60"><img src="/resources/img/p_06.jpg">
                    售后进度
                    <span style="color: #F60">过户、指标更新状态</span>
                </li>

            </a>
        </ul>

        <ul>
            <a href="/per/su" style="display: block" >
                <li ><img src="/resources/img/p_12.jpg">
                    历史成交车辆
                    <span >历史记录</span>
                </li>
            </a>
        </ul>
    </div><!--m_left-->
    <div class="m_right">
        <c:forEach items="${orderInfo}" var="item" varStatus="status">

        <p class="p_top">
            <span class="mon">订单号：${item.orderNumber}</span>
            <span class="span1">${item.modelName}</span>

        </p>
        <div class="p_td">
            <section class="container">
                <input type="radio" class="radio" name="progress${status.index}" value="five" id="five" <c:if test="${item.status=='1'}">checked</c:if>>
                <label for="five" class="label">等待验收</label>
                <input type="radio" class="radio" name="progress${status.index}" value="twentyfive" id="twentyfive" <c:if test="${item.status=='2'}">checked</c:if>>
                <label for="twentyfive" class="label">车辆处理</label>
                <input type="radio" class="radio" name="progress${status.index}" value="fifty" id="fifty" <c:if test="${item.status=='3'}">checked</c:if>>
                <label for="fifty" class="label">等待过户</label>
                <input type="radio" class="radio" name="progress${status.index}" value="seventyfive" id="seventyfive" <c:if test="${item.status=='4'}">checked</c:if>>
                <label for="seventyfive" class="label">过户完成</label>
                <input type="radio" class="radio" name="progress${status.index}" value="onehundred" id="onehundred" <c:if test="${item.status=='5'||item.status=='6'}">checked</c:if>>
                <label for="onehundred" class="label">更新指标</label>
                <div class="progress">
                    <div class="progress-bar"></div>
                </div>
            </section>
        </div>

        </c:forEach>
    </div><!--m_right-->
</div><!--main end-->

<%@include file="footer.jsp"%>

<script>
    function exit(){
        $.cookie("phone",null,{path:"/"});
        $.cookie("token",null,{path:"/"});
        window.location.href="/";
    }
</script>

</body>
</html>
