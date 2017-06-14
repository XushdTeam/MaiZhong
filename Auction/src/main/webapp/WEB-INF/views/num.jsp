<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/9
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>拍卖测试</title>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="/resources/script/push.js"></script>
    <script type="text/javascript" src="https://unpkg.com/vue@2.3.4/dist/vue.min.js"></script>
    <style>
        .panel-default{
            float: left;
            margin-right: 20px;
            width: 30%;
        }
    </style>
</head>
<body>
<div id="app" class="container">
    <div v-for="vo in chlist" class="panel panel-default">
        <div class="panel-heading">{{vo.name}}</div>
        <div class="panel-body">
            <div class="btn-group" role="group" aria-label="...">
                <button v-for="bt in vo.price" type="button" class="btn btn-default" @click="add(vo.ch,bt)">
                    {{bt}}
                </button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
    var vm = new Vue({
        el:"#app",
        data:{
            chlist:[
                {name:'ch1',price:[200,300,500],ch:'1'},
                {name:'ch2',price:[100,200,400],ch:'2'},
                {name:'ch3',price:[200,500,800],ch:'3'},
                {name:'ch4',price:[300,400,500],ch:'4'},
                {name:'ch5',price:[500,1000,1500],ch:'5'},
                {name:'ch6',price:[100,300,500],ch:'6'},
                {name:'ch7',price:[200,400,500],ch:'7'},
                {name:'ch8',price:[200,500,800],ch:'8'},
                {name:'ch9',price:[100,200,400],ch:'9'},
                {name:'ch10',price:[200,300,400],ch:'10'}
            ]

        },methods:{
            add:function(id,addprice){
                var price = 1000+addprice
                $.getJSON('/add/CH'+id+'/'+price,function(d){
                    if(d.stauts==200){
                        alert('加价成功')
                    }else{
                        alert(d.message);
                    }
                })
            }
        }
    })
</script>

</html>