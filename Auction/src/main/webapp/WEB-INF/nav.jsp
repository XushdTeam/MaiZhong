<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/31
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%----%>
<div class="nav">
    <div class="navMain w1200">
        <a class="logo" href=" ">
            <img src="/resources/main/img/logo.png">
        </a>
        <ul>
            <li class="track <c:if test="${menu =='/'}">cur</c:if>"><a href="/">首页</a></li>
            <li class="track <c:if test="${menu =='/list'}">cur</c:if>"><a href="/list">交易大厅</a></li>
            <li class="track <c:if test="${menu =='/warranty'}">cur</c:if>"><a href="/warranty">服务保障</a></li>
            <li class="track <c:if test="${menu =='/personal'}">cur</c:if>"><a href="/personal">个人中心</a></li>
        </ul>
        <c:if test="${username!=null}">
            <p class="logins"><a href="javascript:;">${username}</a> <a href="/user/logout">退出</a></p>
        </c:if>
        <c:if test="${username==null}">
            <p class="logins"><a href="/user/login">登录</a> <a href="/user/regist">注册</a></p>
        </c:if>
    </div>
</div>
