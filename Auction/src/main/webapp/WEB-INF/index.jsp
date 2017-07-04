<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/3
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>优品拍车</title>
    <link href="https://cdn.bootcss.com/element-ui/1.3.7/theme-default/index.css" rel="stylesheet">
    <link href="/resources/css/app.css" rel="stylesheet">
    <link href="/resources/css/iconfont.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script src="https://cdn.bootcss.com/vue/2.3.4/vue.min.js"></script>
    <script src="https://cdn.bootcss.com/element-ui/1.3.7/index.js"></script>

</head>
<body>
<div id="app" class="wrapper">
    <%@ include file="navbar.jsp"%>
    <%@ include file="slider.jsp"%>
    <div class="content">
        <transition name="move" mode="out-in">

        </transition>
    </div>
</div>
</body>
<script>
    var VM = new Vue({
        el:"#app",
        data:{
            onRoutes:'index',
            items:${menu}
        },
        methods:{
            loginout () {

            },handleCommand (command) {
                if(command == 'loginout'){

                }
            },handleSelect (href) {
                window.location.href = href;
            }
        }
    })
</script>
</html>
