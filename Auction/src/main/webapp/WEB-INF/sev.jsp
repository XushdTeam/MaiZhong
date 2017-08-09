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
    <link href="/resources/main/css/CarDetailCss.css" rel="stylesheet">
</head>
<body>
<%@ include file="nav.jsp" %>
<div class="sercice" style="z-index: 1000">
    <img src="/resources/main/img/s.jpg">
    <div class="regs">
        <div class="reg_con">
            <div class="reg_left">
                <div class="reg_head">新注册的账号如何参与出价</div>
                <p>您新注册账号后，线下联系客服电话</br><b>010-80258108</b> 交付保证金后进行拍车</p>
            </div>
            <div class="reg_right">
                <img src="/resources/main/img/s.jpg">
            </div>
        </div>
    </div>

    <div class="regst">
        <div class="regl">
            <div class="reg_left">
                <div class="reg_head">保证金是干什么的</div>
                <p>保证金用于保证交易双方遵守平台规则进行交易；当用户有违规行为时将根据《优品拍车交易规则和争议处理》及相关规定，用于向守约方、优信拍支付违约金...</p>
            </div>
            <div class="reg_right">
                <img src="/resources/main/img/s.jpg">
            </div>
        </div>

        <div class="regr">
            <div class="reg_left">
                <div class="reg_head">车况等级怎么定义</div>
                <p> 综合车况等级
                    A级
                    全车除前后保险杠外无修复痕迹
                    B级
                    全车结构件无损伤，加强件无严重损伤，允许覆盖件和加强件有修复
                    C级
                    全车结构件无重大损伤，允许覆盖件和加强件有修复
                    D级
                    全车结构件发生一处或多处变形损伤</p>
            </div>
            <div class="reg_right">
                <img src="/resources/main/img/s.jpg">
            </div>
        </div>
    </div>

    <div class="regs regsty">
        <div class="reg_con">
            <div class="reg_left">
                <img src="/resources/main/img/s.jpg">
            </div>
            <div class="reg_right">
                <div class="reg_head">如何支付车款</div>
                <p>通过线下付款，如果想了解详情，请拨打客服电话<b>010-80258108</b></p>
                <button>立即拍车</button>
            </div>
        </div>
    </div>

</div>

<%@ include file="footer.jsp"%>

</body>
</html>
