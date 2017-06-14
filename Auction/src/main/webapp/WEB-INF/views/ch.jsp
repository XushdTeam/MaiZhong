<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/9
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>频道${num}</title>
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="/resources/script/push.js"></script>
    <script type="text/javascript" src="https://unpkg.com/vue@2.3.4/dist/vue.min.js"></script>

</head>
<body>
<div class="container" id="app">
    <div class="panel panel-default">
        <div class="alert alert-success" role="alert" v-show="su">加价成功</div>
        <div class="alert alert-danger" role="alert" v-show="er">加价失败</div>
        <div class="panel-heading text-center">
            <span>频道${num}</span>
            <h2 class="text-danger">
                <!-- 显示time图标-->
                <span class="glyphicon glyphicon-time"></span>
                <!-- 展示倒计时-->
                <span class="glyphicon" id="seckill-box"></span>
            </h2>
            <h2 id="seckill_price">

            </h2>
            <div class="panel-body">
                <div class="btn-group" role="group" aria-label="...">
                    <button type="button" class="btn btn-default" @click="add(100)">100</button>
                    <button type="button" class="btn btn-default" @click="add(200)">200</button>
                    <button type="button" class="btn btn-default" @click="add(300)">300</button>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script>

    var NOWPRICE = 0;
    $(function(){
        var box = document.getElementById("seckill-box");
        var price = document.getElementById("seckill_price");
        // 建立连接，conn 即web.xml中 CometServlet的<url-pattern>
        JS.Engine.start('/comet');
        // 监听后台某个频道
        JS.Engine.on({
            // 对应服务端 “频道1” 的值 result1
            "CH${num}" : function(d) {
                var d = JSON.parse(d);
                var time = new Date(parseInt(d.d)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
                box.innerHTML = time;
                price.innerHTML = d.p;
                NOWPRICE = d.p;

            }
        });
    })
    var vm = new Vue({
        el:"#app",
        data:{
            su:false,
            er:false
        },methods:{
            add:function(addprice){
                var price = NOWPRICE+addprice
                $.getJSON('/add/CH${num}/'+price,function(d){
                    if(d.status==200){
                        vm.su = true;
                    }else{
                        vm.er = true;

                    }
                    setTimeout(function(){
                        vm.su = false;
                        vm.er = false;
                    },1000)
                })
            }
        }
    })
</script>
</html>
