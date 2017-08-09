<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/31
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>服务保障</title>
    <%@ include file="head.jsp"%>
</head>
<body>
    <%@ include file="nav.jsp"%>
    <div class="sercice" style="z-index: 1000">
        <img src="/resources/main/img/s.jpg" width="100%">
        <div class="regs">
            <div class="reg_con">
                <div class="reg_left">
                    <div class="reg_head">新注册的账号如何参与出价</div>
                    <p>您新注册账号后，线下联系客服电话</br><b>010-80258108</b> 交付保证金后进行拍车</p>
                </div>
                <div class="reg_right">
                    <img src="/resources/main/img/tel.png">
                </div>
            </div>
        </div>

        <div class="regst">
            <div class="regl">
                <div class="reg_left">
                    <div class="reg_head">保证金被冻结怎么办？</div>
                    <p>在以下四种情况下您的保证金会被解冻出来：
                        1、您的出价被其他商户超过
                        2、车辆竞拍结束后，您出价最高但卖方不同意卖车，
                        3、您支付车款成功后
                        4、卖方在交易过程中出现违约
                    </p>
                </div>
                <div class="reg_right">
                    <img src="/resources/main/img/m.png">
                </div>
            </div>

            <div class="regr">
                <div class="reg_left">
                    <div class="reg_head">车况等级怎么定义</div>
                    <p> 综合车况等级:
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
                    <img src="/resources/main/img/v.png">
                </div>
            </div>
        </div>

        <div class="regs regsty">
            <div class="reg_con">
                <div class="reg_left">
                    <img src="/resources/main/img/t.png">
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
