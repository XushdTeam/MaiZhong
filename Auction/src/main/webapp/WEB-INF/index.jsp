<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/31
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>优评拍车</title>
    <%@ include file="head.jsp"%>
</head>
<body >
    <%--nav--%>
    <%@ include file="nav.jsp"%>
    <%--banner--%>
    <div class="htmleaf-container">
        <div class="banner">
            <ul>
            </ul>
            <ol>
            </ol>
            <i class="left"></i><i class="right"></i>
        </div>
    </div>
    <%--three --%>
    <div class="main-conter">
        <dl>
            <dt><img src="/resources/main/img/scrm.png"></dt>
            <dd>成交快</dd>
            <p>优品拍车成交快首次上拍可获得300元优惠券礼品，优品拍车成交快首次上拍可获得300元优惠券礼品</p>
        </dl>
        <dl>
            <dt><img src="/resources/main/img/liu.png"></dt>
            <dd>流程少</dd>
            <p>优品拍车成交快首次上拍可获得300元优惠券礼品，优品拍车成交快首次上拍可获得300元优惠券礼品</p>
        </dl>

        <dl>
            <dt><img src="/resources/main/img/xin.png"></dt>
            <dd>超省心</dd>
            <p>优品拍车成交快首次上拍可获得300元优惠券礼品，优品拍车成交快首次上拍可获得300元优惠券礼品</p>
        </dl>
    </div>
    <%----%>
    <div class="jilu-con">
        <div class="jilu">
            <h2>拍卖历史</h2>
            <div class="lists">
                <a href="" class="shadow-car">
                    <p class="pic">
                        <img src="/resources/main/img/5.jpg" alt="大众 速腾 2007年1.6L手动">
                    </p>
                    <h3 class="title">大众&nbsp;速腾&nbsp;2007年1.6L手动</h3>
                    <p class="option">9年车龄/7.8万公里/北京</p>
                    <p class="row">
                        <span class="date">2017.07.22成交 </span>
                        <strong class="price">3.20万</strong>
                    </p>
                </a>
            </div>

            <div style="clear: both;"></div>
            <div class="mores">查看更多</div>
        </div>
    </div>
    <%--app 下载--%>
    <div class="app">
        <img src="/resources/main/img/4.jpg" width="100%">
    </div>
    <%--新闻--%>
    <div class="new">
        <h2>媒体报道</h2>
        <p class="p1">
            <span>新闻标题一</span>
            版权所有北京巅峰科技有限公司 | 京ICP证041552号-1 | 京公网安备110108401009号
        </p>
        <p class="p2">
            <span>新闻标题二</span>

            版权所有北京巅峰科技有限公司 | 京ICP证041552号-1 | 京公网安备110108401009号 版权所有北京巅峰科技有限公司 </p>

        <p>
            <span>新闻标题三</span>
            版权所有北京巅峰科技有限公司 | 京ICP证041552号-1 | 京公网安备110108401009号 版权所有北京巅峰科技有限公司 </p>
    </div>

    <%--footer--%>
    <%@ include file="footer.jsp"%>
    <script type="text/javascript" src="/resources/main/js/slider.js"></script>
    <script>


        new Slider({
            images_height:'540px',
            images_url:[
                '/resources/main/img/1.jpg',
                '/resources/main/img/1.jpg',
                '/resources/main/img/1.jpg'
            ]
        });

    </script>
</body>
</html>
