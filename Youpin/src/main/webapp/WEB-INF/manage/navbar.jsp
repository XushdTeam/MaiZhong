<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/3
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getServerName()+":"+request.getServerPort()+path;
    request.setAttribute("BASE_PATH",basePath);
%>
<html>
<head>
    <title>navbar</title>
</head>
<body>
<div class="header">
    <div class="logo">后台管理系统</div>
    <div class="user-info">
        <el-dropdown trigger="click" @command="handleCommand">
                <span class="el-dropdown-link">
                    <img class="user-logo" src="/resources/images/img.jpg">
                    ${username}
                </span>
            <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="loginout">退出</el-dropdown-item>
            </el-dropdown-menu>
        </el-dropdown>
    </div>
    <audio id="chatAudio">
        <source src="/resources/voice/notify.mp3" type="audio/mpeg">
    </audio>
</div>
</body>
<script>
    $(document).ready(function(){

        if('WebSocket' in window) {
            websocket = new WebSocket("ws://${BASE_PATH}/websocket/socketServer?userId=" + ${userId});
        } else if('MozWebSocket' in window) {
            websocket = new MozWebSocket("ws://${BASE_PATH}/websocket/socketServer?userId==" + ${userId});
        } else {
            websocket = new SockJS("ws://${BASE_PATH}/websocket/sockjs?userId=" + ${userId});
        }
        websocket.onopen = function(event) {
            console.log("WebSocket:已连接");
        };
        websocket.onmessage = function(event) {
            var data = JSON.parse(event.data);
            $('#chatAudio')[0].play(); //播放声音
            VM.notify(data);
        };
        websocket.onerror = function(event) {
            console.log("WebSocket:发生错误 ");
        };
        websocket.onclose = function(event) {
            console.log("WebSocket:已关闭");
        }
    })
</script>
</html>
