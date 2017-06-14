<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/9
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body onload="init()">
现在时间是：<span id="nowTime">...</span>
</body>

<script type="text/javascript">
    function init() {
        var nowTime = document.getElementById('nowTime');

        // 建立连接，conn 即web.xml中 CometServlet的<url-pattern>
        JS.Engine.start('comet');

        // 监听后台某个频道
        JS.Engine.on({
            timer : function(num1) {
                nowTime.innerHTML = num1;
            },
        });
    }
</script>
<script type="text/javascript" src="/resources/script/push.js"></script>
</html>
