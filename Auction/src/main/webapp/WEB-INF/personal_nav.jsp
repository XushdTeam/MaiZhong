<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/8/15
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="fl w130 bgf8">
    <div class="pl30 pb15 pt15">
        <h3 class="fs14 c3 lh27">交易信息</h3>
        <ul class="fs12 newsubnav">
            <li ><a href="/personal/deallist" style="<c:if test="${cur==1}">color:#F60;</c:if>">待成交车辆</a></li>
            <li ><a href="/personal/orderlist" style="<c:if test="${cur==2}">color:#F60;</c:if>">全部订单</a></li>
            <li ><a href="/personal/bidlist" style="<c:if test="${cur==3}">color:#F60;</c:if>">出价车辆</a></li>
            <li ><a href="/personal/likelist" style="<c:if test="${cur==4}">color:#F60;</c:if>">关注车辆</a></li>
        </ul>
        <h3 class="fs14 c3 lh27 mt20">个人设置</h3>
        <ul class="fs12 newsubnav">
            <li ><a href="/personal/baseinfo" style="<c:if test="${cur==5}">color:#F60;</c:if>">基本信息</a></li>
            <li ><a href="/personal/recharge" style="<c:if test="${cur==6}">color:#F60;</c:if>">充值记录</a></li>
            <li ><a href="/personal/account/safe" style="<c:if test="${cur==7}">color:#F60;</c:if>">帐号安全</a></li>

        </ul>
    </div>
</div>
