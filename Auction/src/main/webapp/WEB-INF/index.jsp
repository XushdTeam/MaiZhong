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
            <p>优品拍车拍完立马可以过户，车辆上架后能达到秒拍效果。优品拍车车辆检测时间较短并车况检测较准，近百位优秀二手车评估师为您服务。</p>
        </dl>
        <dl>
            <dt><img src="/resources/main/img/liu.png"></dt>
            <dd>流程少</dd>
            <p>优品拍车减少拍车流程，拍车到手只需要拍下车辆-车辆过户两个步骤。优品拍车过户时间属于国内最快过户的拍车平台。</p>
        </dl>

        <dl>
            <dt><img src="/resources/main/img/xin.png"></dt>
            <dd>超省心</dd>
            <p>优品拍车有近百位优秀二手车评估师为您服务，更有授权提车人让您忙时也能提车，所以优品拍车超省心。</p>
        </dl>
    </div>
    <%----%>
    <div class="jilu-con">
        <div class="jilu">
            <h2>拍卖历史</h2>
            <div class="lists">
                <a href="" class="shadow-car">
                    <p class="pic">
                        <img src="/resources/main/img/d.jpg" alt="大众 速腾 2007年1.6L手动">
                    </p>
                    <h3 class="title">2013款 阁瑞斯MPV 2.0L...</h3>
                    <p class="option">13年上牌/9万公里/北京</p>
                    <p class="row">
                        <span class="date">2017.08.02成交 </span>
                        <strong class="price">5.20万</strong>
                    </p>
                </a>
            </div>


            <div class="lists">
                <a href="" class="shadow-car">
                    <p class="pic">
                        <img src="/resources/main/img/d1.jpg" alt="大众 速腾 2007年1.6L手动">
                    </p>
                    <h3 class="title">2006款 &nbsp; 蒙迪欧&nbsp;  2.5L ...</h3>
                    <p class="option">07年上牌/10万公里/北京</p>
                    <p class="row">
                        <span class="date">2017.07.22成交 </span>
                        <strong class="price">3.20万</strong>
                    </p>
                </a>
            </div>

            <div class="lists">
                <a href="" class="shadow-car">
                    <p class="pic">
                        <img src="/resources/main/img/d3.jpg" alt="大众 速腾 2007年1.6L手动">
                    </p>
                    <h3 class="title">2007款&nbsp; 景程 SX 豪华版 MT</h3>
                    <p class="option">07年上牌/9万公里/北京</p>
                    <p class="row">
                        <span class="date">2017.07.28成交 </span>
                        <strong class="price">2.0万</strong>
                    </p>
                </a>
            </div>

            <div class="lists">
                <a href="" class="shadow-car">
                    <p class="pic">
                        <img src="/resources/main/img/d4.jpg" alt="大众 速腾 2007年1.6L手动">
                    </p>
                    <h3 class="title">2013款 瑞风S5 2.0T 手动 尊享版</h3>
                    <p class="option">13年上牌/1万公里/北京</p>
                    <p class="row">
                        <span class="date">2017.08.10成交 </span>
                        <strong class="price">6.0万</strong>
                    </p>
                </a>
            </div>

            <div style="clear: both;"></div>
            <div class="mores">查看更多</div>
        </div>
    </div>

    <%--新闻--%>
    <div class="new">
        <h2>媒体报道</h2>
        <p class="p1">
            <a href="#">
              <span>如果买遍《变形金刚5》里的车?</span>
               关于汽车的电影视觉大片在2017年让影迷们大饱眼福4月上映的《速度与激情8》中形形色色的经典车型互飙场面，成为最大看点...
            </a>
        </p>
        <p class="p2">
            <a href="#">
                 <span>英法宣布禁止销售燃油汽车,中国？</span>

                 大家可能也都听说了，法国和英国政府相继宣布计划在2040年之前停止销售新的汽油和柴油汽车，目的是为了减少空气污染...</p>
            </a>

        <p>
            <a href="#">
                 <span>这届跑男团成员都开什么车？</span>
                 每周五晚21:10对于全通君来说，都是一个神圣的时刻。此时我会沐浴更衣、净手煴香（也就是俗话的洗白白）躺在床上... </p>
            </a>
    </div>

    <%--footer--%>
    <%@ include file="footer.jsp"%>
    <script type="text/javascript" src="/resources/main/js/slider.js"></script>
    <script>


        new Slider({
            images_height:'540px',
            images_url:[
                '/resources/main/img/1.jpg',
                '/resources/main/img/2.jpg',
                '/resources/main/img/3.jpg'
            ]
        });

    </script>
</body>
</html>
