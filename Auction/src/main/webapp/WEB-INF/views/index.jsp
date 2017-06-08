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
</head>
<body>
<h1>AUCTION</h1>
<div id="result"></div>
</body>
<script>
    if(typeof(EventSource)!=="undefined")
    {
        var source=new EventSource("/push");
        source.onopen = function(){

        }
        source.onmessage=function(event) {

            document.getElementById("result").innerHTML = event.data + "<br />";
        };
    }else{
        document.getElementById("result").innerHTML="Sorry, your browser does not support server-sent events...";
    }

</script>
</html>
