<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/31
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <%@ include file="head.jsp" %>
    <link href="/resources/main/css/MyCyp.css" rel="stylesheet">
    <link href="/resources/main/css/page.css" rel="stylesheet">
</head>
<body>
<%@ include file="nav.jsp" %>

<div class="w1200 mauto" style="z-index: 1000">
    <div class="place mt20"><a href=" ">个人中心</a> &gt;&gt;&nbsp;<span class="c9" id="YeQianSan">基本信息<span></div>
    <div class="mt25 clearfix">


        <div class="fl w130 bgf8">
            <div class="pl30 pb15 pt15">
                <h3 class="fs14 c3 lh27">交易中心</h3>
                <ul class="fs12 newsubnav">
                    <li id="ConfirmOrderList"><a href=" ">成交确认</a></li>
                    <li id="OrderList"><a href=" ">订单车辆</a></li>
                    <li id="HistoryAuctionCarList"><a href=" "  >历史竞价</a></li>
                    <li id="CarList"><a href=" "  >关注车辆</a></li>
                </ul>
                <h3 class="fs14 c3 lh27 mt20">个人设置</h3>
                <ul class="fs12 newsubnav">
                    <li id="Account"><a href=" ">基本信息</a></li>
                    <li id="EditPwd"><a href=" ">修改密码</a></li>
                    <li id="Message"><a href=" ">投诉建议</a></li>
                </ul>
            </div>
        </div>

        <div class="fr w1060">
            <div class="infor">
                <h2><span></span>修改密码</h2>
                <div class="infor_coms">
                    <div class="infor_pass">
                        <label>输入旧密码：</label>
                        <input type="text" name="" placeholder="请输入姓名">
                    </div>
                    <div class="infor_pass">
                        <label>输入新密码：</label>
                        <input type="text" name="" placeholder="请输入新密码">
                    </div>

                    <div class="infor_pass">
                        <label>确认新密码：</label>
                        <input type="text" name="" placeholder="确认新密码">
                    </div>
                    <button class="buts">确定提交</button>
                </div>
            </div>
        </div>

    </div>

</div>

<%@ include file="footer.jsp"%>

</body>
</html>
