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
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/guzhi.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/per.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js" type="text/javascript"></script>

</head>
<body class="bgss">
<div class="top e_top">
    <div class="t_cen">
        <a href="/"><img src="../resources/img/logo.png"></a>
        <span class="tell">010-8025-8108</span>
        <span class="t_right">
            <a href="/sale" class="one">我要卖车</a>
            <a href="javascript:void(0)" class="two" >${phone}</a>
            <a href="javascript:void(0)" class="two" id="exit"  onclick="exit();">退出</a>
            <a href="javascript:void(0)" class="two">APP下载</a>
        </span>
    </div>
</div>

<div class="x_nav">当前位置 :  <a href="/">首页</a> > <a href="#">个人中心</a></div>

<div class="main">
    <div class="m_left">
        <ul>
            <li><img src="../resources/img/p_03.jpg">订单中心</li>
            <p><a href="/per/or" >订单信息</a></p>
        </ul>

        <ul>
            <li style="color:#f60"><img src="../resources/img/p_06.jpg">售后进度</li>
            <p><a href="javascript:void(0)" class="cuns">售后进度</a></p>
        </ul>

        <ul>
            <li><img src="../resources/img/p_12.jpg">历史成交车辆</li>
            <p><a href="/per/su">成交车辆信息</a></p>
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

<div class="clear"></div>
<div class="footer">
    <div class="foot_cen">
        <div class="n_f_m_c">
            <div class="ul1">
                <a href="/about.html">交易方式</a>
                <a href="/help.html">质检说明</a>
                <a href="/joinus.html">帮助中心</a>

                <a href="/joinus.html">加盟合作</a>
                <a href="/feedback.html">关于我们</a>
                <a href="/feedback.html">联系我们</a>
            </div>
            <div class="ul">
                <ul>
                    <li><a href="#">门店交易</a></li>
                    <li><a href="#">上门交易</a></li>
                </ul>
                <ul>
                    <li><a href="#">检测名词解释</a></li>
                    <li><a href="#">专业检测项目</a></li>

                </ul>
                <ul>
                    <li><a href="#">常见问题</a></li>
                    <li><a href="#">服务条款</a></li>

                </ul>

                <ul>
                    <li><a href="#">公司简介</a></li>
                    <li><a href="#">招贤纳士</a></li>

                </ul>
                <ul>
                    <li><a href="#"> 销售商加盟</a></li>

                </ul>
                <ul class="last">
                    <li><a href="#">系电话：010-82967855/18515157855</a></li>
                    <li><a href="#">  公司地址：北京市大兴区西红门嘉悦广场
                        5号楼1002室或西红门公交车站对面</a></li>
                </ul>

            </div><!--ul end-->
        </div><!--f_n-->
        <div class="f_n_r">
            <div class="f_one">
                <img src="../resources/img/m_11.jpg">
                <p>APP下载</p>
            </div>
            <div class="f_one">
                <img src="../resources/img/m_13.jpg">
                <p>微信公众号</p>
            </div>
        </div>


        <div class="clear"></div>
        <div class="pp">
            <p>Copyright © 2017-2020 迈众 All Rights Reserved 版权所有 北京迈众汽车信息服务有限公司</p>
            <p>京ICP备17017795号  &nbsp;&nbsp;&nbsp; 联系电话：010-8025-8108 &nbsp;&nbsp;&nbsp;
                <script type="text/javascript">
                    var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
                    document.write(unescape("%3Cspan id='cnzz_stat_icon_1261672623'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s95.cnzz.com/z_stat.php%3Fid%3D1261672623' type='text/javascript'%3E%3C/script%3E"));
                </script>
            </p>
        </div>

    </div>
</div>

<script>
    function exit(){
        $.cookie("phone",null,{path:"/"});
        $.cookie("token",null,{path:"/"});
        window.location.href="/";
    }
</script>
</body>
</html>
