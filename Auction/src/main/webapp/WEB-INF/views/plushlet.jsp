<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/13
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Pragma" content="no-cache" />
    <script type="text/javascript" src="/ajax-pushlet-client.js"></script>
    <script type="text/javascript">
        PL._init();
        PL.joinListen('/cuige/he');
        function onData(event) {
            console.log(event.get("mess"));
            // 离开
            // PL.leave();
        }
    </script>
</head>
<body>
<center>
    <h1>
        my first pushlet!
    </h1>
</center>
</body>
</html>
