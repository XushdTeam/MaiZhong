<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/22 0022
  Time: 上午 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>500</title>
    <link href="/resources/css/errorpage.css" rel="stylesheet">
</head>
<body>
<div class="container" style=" margin-top:8%;">
    <div class="panel margin-big-top">
        <div class="text-center">
            <% Exception ex = (Exception)request.getAttribute("exception"); %>
            <H2 class="padding-top">Exception: <%= ex.getMessage()%></H2>
            <P/>
            <% ex.printStackTrace(new java.io.PrintWriter(out)); %>
            <div class="">
                <div class="float-left">
                    <img src="http://www.pintuer.com/images/ds-1.gif">
                    <div class="alert"> 卧槽！出错了！ </div>
                </div>
                <div class="float-right">
                    <img src="http://www.pintuer.com/images/ds-2.png" width="260">
                </div>
            </div>
            <div class="padding-big">
                <a href="javascript:history.back();" class="button bg-yellow">回到来的地方</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
