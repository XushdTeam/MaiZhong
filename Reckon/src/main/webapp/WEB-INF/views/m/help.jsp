<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/6
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>帮助中心</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/iconfont/iconfont.css" />

</head>

<body>
<div class="mui-content" id="app" v-cloak>
    <transition name="fade">
        <div v-show="loading" class="loading">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
    </transition>
    <transition name="fade">
        <ul class="mui-table-view" v-show="!loading">

            <li class="mui-table-view-cell" v-for="(vo,index) in titleList" v-tap="{methods:detail,item:vo}">
                <a class="iconfont icon-help1">
                    {{vo.title}}
                </a>
            </li>

        </ul>
    </transition>
</div>
</body>
<script type="text/javascript" src="/resources/wap/script/api.js"></script>
<script type="text/javascript" src="/resources/wap/script/vue.js"></script>
<script type="text/javascript" src="/resources/wap/script/mui.min.js"></script>
<script type="text/javascript" src="/resources/wap/script/common.js"></script>
<script type="text/javascript">
    var vm = new Vue({
        el:"#app",
        data:{
            loading:true,
            titleList:[]
        },
        methods:{
            detail:function(param){
                var item = param.item
                window.location.href = "/m/helpdetail/"+item.id;
                openWin('helpdetail','./helpdetail.html',{id:item.id,title:item.title})
            }
        },
        computed: {

        }
    })
    mui.ready(function () {

        vm.titleList = ${list};
        vm.loading = false;
    })


</script>

</html>
