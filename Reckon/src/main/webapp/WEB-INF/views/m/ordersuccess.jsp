<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/5
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>订单提交成功</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css" />
    <style>
        .ordersuccess{
            text-align: center;
            margin-top: 3rem;
        }
        .shop-bottom {
            position: absolute;
            width: 100%;
            bottom: 0;
        }
        .shop-bottom .shop-text-wrap {
            width: 100%;
            padding: 12px 15px 13px;
            background-color: #fff;
        }
        .shop-bottom .shop-text-wrap .shop-name {
            width: 100%;
            font-size: 16px;
            color: #3782FF;
        }
        .shop-bottom .shop-text-wrap .shop-info {
            font-size: 12px;
            color: #999;
            width: 100%;
        }
        .shop-bottom .shop-text-wrap .shop-info p {
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 1;
            -webkit-box-orient: vertical;
        }
        .shop-bottom .next {
            width: 100%;
            height: 50px;
            background-color: #F60;
            text-align: center;

        }
        .shop-bottom .next a {
            display: inline-block;
            width: 100%;
            height: 100%;
            font-size: 18px;
            line-height: 50px;
            text-align: center;
            color: #FFF;
        }
    </style>
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
        <div v-show="!loading" >
            <div class="ordersuccess">
                <img src="/resources/wap/image/ordersuccess.svg" />
                <p>订单提交成功</p>
                <br>
                <p style="padding: 10px;">我们的客服人员会尽快的联系您，订单信息可以在订单中心查询</p>
            </div>
            <div class="shop-bottom">
                <div class="next"><a class="next-btn" v-tap="{methods:next}">前往个人中心</a></div>
            </div>
        </div>
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
            loading:false,

        },
        methods:{
            next:function(){
                window.location.href = "/m/my"
            }
        },
        computed: {

        }
    })
    mui.ready(function(){
        history.pushState(null, null, document.URL);
        window.addEventListener('popstate', function () {
            history.pushState(null, null, document.URL);
        });
    })

</script>

</html>
