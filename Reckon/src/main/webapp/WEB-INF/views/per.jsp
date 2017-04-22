<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/20
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/guzhi.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js" type="text/javascript"></script>

</head>
<body class="bgss">
<div class="top e_top">
    <div class="t_cen">
        <a href="#"><img src="../resources/img/logo.png"></a>
        <span class="tell">010-8025-8108</span>
        <span class="t_right">
            <a href="/sale" class="one">我要卖车</a>
            <a href="javascript:void(0)" class="two" >${phone}</a>
            <a href="javascript:void(0)" class="two">APP下载</a>
        </span>
    </div>
</div>

<div class="x_nav">当前位置 :  <a href="/">首页</a> > <a href="#">个人中心</a></div>

<div class="main">
    <div class="m_left">
        <ul>
            <li style="color:#f05b48;"><img src="../resources/img/p_03.jpg" >订单中心</li>
            <p><a href="javascript:void(0)" class="cuns">订单信息</a></p>
        </ul>

        <ul>
            <li><img src="../resources/img/p_06.jpg">售后进度</li>
            <p><a href="#">过户进度</a></p>
        </ul>

        <ul>
            <li><img src="../resources/img/p_12.jpg">历史成交车辆</li>
            <p><a href="#" >成交车辆信息</a></p>
        </ul>
    </div><!--m_left-->
    <div class="m_right">
        <p class="m_top">
            <span class="span1">订单名称</span>
            <span class="mon">价格</span>
            <span >状态</span>
            <span >进度</span>
        </p>
        <p class="danxix">
            <span>订单号：293930939387387</span><span class="colors">2017年3月30日</span>
        </p>
        <div class="td">
            <div class="flot ont">
                <img src="../resources/img/p_08.jpg">
                <span>2016款 北京BJ20 1.5T CVT 豪华型</span>
            </div>
            <div class="flot mony">￥245.0万</div>
            <div class="flot monys">已完成</div>
            <div class="flot none monys">已完成</div>
        </div>

        <p class="danxix">
            <span>订单号：293930939387387</span><span class="colors">2017年3月30日</span>
        </p>
        <div class="td">
            <div class="flot ont">
                <img src="../resources/img/p_08.jpg">
                <span>2016款 北京BJ20 1.5T CVT 豪华型</span>
            </div>
            <div class="flot mony">￥245.0万</div>
            <div class="flot monys">已完成</div>
            <div class="flot none monys">已完成</div>
        </div>


        <p class="danxix">
            <span>订单号：293930939387387</span><span class="colors">2017年3月30日</span>
        </p>
        <div class="td">
            <div class="flot ont">
                <img src="../resources/img/p_08.jpg">
                <span>2016款 北京BJ20 1.5T CVT 豪华型</span>
            </div>
            <div class="flot mony">￥245.0万</div>
            <div class="flot monys">已完成</div>
            <div class="flot none monys">已完成</div>
        </div>



    </div><!--m_right-->
</div><!--main end-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
