<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/8/19
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>APP下载</title>
    <link rel="stylesheet" href="/resources/main2/css/base.css" type="text/css">
    <link rel="stylesheet" href="/resources/main2/css/common.css" type="text/css">
    <link rel="stylesheet" href="/resources/main2/css/animate.min.css" type="text/css">
    <link rel="stylesheet" href="/resources/main2/css/style_j.css" type="text/css">
    <style>
        .phone{
            width: 300px;
            border-radius: 10px;
            border: 2px solid #FFF;
        }
    </style>
</head>
<body class="bg_f2" style="zoom: 1;">
<div id="header" class="_index">
    <div class="header_bg container_full">
        <div class="_header clearfix">
            <div class="_header_left clearfix">

                <!-- logo -->
                <div class="logo"><a href=" "><img src="/resources/main2/logo.png" alt=""></a></div>
                <!-- menu -->
                <div class="menu clearfix">
                    <ul>
                        <li><a href="/" class="shouye ">首页</a></li>
                        <li><a href="/auction" class="gujia">拍卖入口</a></li>
                        <li><a href="/tosale" class="gujia">我要卖车</a></li>
                        <li><a href="/download" class="xiazai checked">APP下载</a></li>
                        <li><a href="http://www.wukongshouche.com" class="xiazai" target="_blank">悟空收车</a></li>
                    </ul>
                </div>

            </div>

            <%--<div class="_header_right clearfix">--%>
                <%--<!-- login_enter -->--%>
                <%--<div class="login_enter clearfix">--%>
                    <%--<a href="javascript:void(0)" id="Owner_login_btn">车主登录</a>--%>
                    <%--<a href=" " target="_blank">买家入口</a>--%>
                <%--</div>--%>
                <%--<!-- header_tel -->--%>
                <%--<div class="header_tel">--%>

                <%--</div>--%>

            <%--</div>--%>
        </div>
    </div>
</div>

<!--conent-->
<div class="pos">
    <img src="/resources/main2/7.jpg" width="100%" style="height: 860px">
    <div class="con">
        <div class="con_center">
            <img src="/resources/images/3-1.jpg" class="left phone">
            <div class="right">
                <p>优品拍车</p>
                <div class="jianjie">优品拍车国内收车专业平台  全国收车价最高</div>
                <div class="div_img">
                    <b>车主</b> <b>车商</b>
                    <div style="clear: both;" class="imgs">
                        <img src="/resources/images/yppccz.png">
                        <img src="/resources/images/yppc.png">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--conent end-->
<%@include file="footer.jsp"%>






</body>
</html>
