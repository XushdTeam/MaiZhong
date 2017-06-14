<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/7
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>auction</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<h1>AUCTION</h1>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2 class="text-danger">
                <!-- 显示time图标-->
                <span class="glyphicon glyphicon-time"></span>
                <!-- 展示倒计时-->
                <span class="glyphicon" id="seckill-box"></span>
            </h2>
        </div>
        <div class="panel-body text-center">
            <h2>价格</h2>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js"></script>
<script>
//    if(typeof(EventSource)!=="undefined")
//    {
//        var source=new EventSource("/push");
//        source.onopen = function(){
//
//        }
//        source.onmessage=function(event) {
//
//            document.getElementById("result").innerHTML = event.data + "<br />";
//        };
//    }else{
//        document.getElementById("result").innerHTML="Sorry, your browser does not support server-sent events...";
//    }


</script>
</html>
