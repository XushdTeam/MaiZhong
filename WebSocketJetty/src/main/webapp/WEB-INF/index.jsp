<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/26
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Jetty</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/vue/2.3.4/vue.min.js"></script>
</head>
<body>
    <h1>拍卖测试</h1>
    <div id="app" style="width: 800px;margin: 0 auto">
        <div class="panel panel-default" v-for="i in 10" style="width: 150px;float: left;margin: 10px;">
            <div class="panel-heading">通道{{i}}</div>
            <div class="panel-body">
                <button type="button" class="btn btn-default" @click="addCar(i-1)" >添加车辆</button>
            </div>
        </div>
    </div>
</body>
<script>
    var VM = new Vue({
        el:"#app",
        data:{

        },
        methods:{
            addCar (index) {
                console.log(index)
                $.getJSON('/addcar/'+index,function(d){
                    if(d.status==200){

                    }
                })
            }
        }
    })
</script>
</html>
