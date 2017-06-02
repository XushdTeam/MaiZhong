<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/5/18
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>悟空收车下载</title>
    <style>
        body{ background: #f8f8f8; font-size: 30px;}
        *{ margin: 0; padding: 0;}

        .bg_1{ background: url(/resources/img/app-download.jpg) no-repeat center; background-size: 100%; height: 370px; width: 80%;
            margin: 0 auto;}
        a{
            text-decoration: none;
        }
        .button{ font-size: 1.8rem;text-align: center;
            line-height: 4rem;background: #f60; display: block;color: #F8F8F8; width: 80%; margin: 0 auto;
            height: 4rem; border: none; margin-top: 1.2rem; border-radius: 8px; font-weight: 400;outline: none;}
    </style>
</head>
<body>
    <div class="b_bos">
        <div class="bg_1"></div>
        <a href="http://downloadpkg.apicloud.com/app/download?path=http://7yjb4g.com1.z0.glb.clouddn.com/452e8a2629110e043e0b15ac018a5339_d" class="button" style="<c:if test="${key=='ios'}">display:none;</c:if> ">Android下载</a>
        <a href="https://itunes.apple.com/us/app/%E6%82%9F%E7%A9%BA%E6%94%B6%E8%BD%A6/id1237538091?l=zh&ls=1&mt=8" class="button" style="<c:if test="${key=='android'}">display:none;</c:if> ">iphone下载</a>
    </div>
</body>
</html>
