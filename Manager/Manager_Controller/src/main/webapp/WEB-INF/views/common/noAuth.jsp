<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/2/3
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>没有权限</title>
    <style>
        body {
            margin: 0px auto;
            width: 950px;
            margin: 0 auto;
            font: 11px "lucida grande", arial, verdana, sans-serif;
            background: url(/resources/images/body_bg.jpg) #d4d4d4 repeat-x;
            padding-top: 80px;
        }

        div.error404_main {
            font-family: 'microsoft yahei';
            font-size: 16px;
            position: relative;
            margin: 31px 21px 0px;
            width: 950px;
            background: url(/resources/images/403.jpg) no-repeat;
            height: 500px
        }

        span.main_txt {
            position: absolute;
            text-align: center;
            padding-bottom: 0px;
            padding-left: 0px;
            width: 150px;
            padding-right: 0px;
            display: block;
            height: 63px;
            color: #ce5051;
            top: 223px;
            padding-top: 2px;
            left: 745px
        }

        span.main_txt span {
            margin: 0px 0px 2px;
            display: block
        }

        span.main_txt a {
            color: #1d1d1d
        }

        div.error404_guide {
            position: relative;
            background-color: #b4b4b4;
            margin: 0px 21px;
            width: 950px;
            height: 84px
        }
    </style>
</head>
<body>
<div class="error404_main">
<span class="main_txt">
    <span>您没有访问权限哦！</span>
    <span>请联系管理员</span>
</span>
</div>
</body>
</html>
