<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/5
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>我的</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/iconfont/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js" type="text/javascript"></script>
    <style>
        html{
            font-family:"Microsoft YaHei",Arial,Helvetica,sans-serif;
            min-width:320px;
            font-size: 50px;
            -webkit-text-size-adjust: none;
        }

        .mui-off{ text-align: center; background: #f60; color: #fff; padding-right: 0 !important;margin-left: -1.2rem;}
        .iconfont {
            font-size: 0.9rem;

        }
        .head{
            background: rgba(239, 75, 24,0.88) url(/resources/wap/image/5.jpg) no-repeat center;
            background-size: cover;
            padding-top: 2rem;
            opacity: 0.72;
        }
    </style>
</head>
<body >
<div id="app" v-cloak>
    <transition name="fade">
        <!--页面主内容区开始-->
        <div class="mui-content mui-views">
            <div class="head" >
                <div class="head-img"  >
                    <img id="avatar"  name="avatar" :src="userInfo.headimg">
                </div>
                <div class="head-dsb" >
                    <p class="dsb-id">{{userInfo.login}}</p>
                </div>
            </div>
            <ul class="mui-table-view mui-table-view-chevron" style="margin-top: .9rem;">
                <li class="mui-table-view-cell" v-tap="{methods:goto,url:'/m/order'}">
                    <a href="javascript:void(0)" class="mui-navigate-right iconfont icon-manageorder"> 我的订单</a>
                </li>
                <li class="mui-table-view-cell" v-tap="{methods:goto,url:'/m/saleback'}">
                    <a href="javascript:void(0)" class="mui-navigate-right iconfont icon-service"> 售后跟踪</a>
                </li>
                <li class="mui-table-view-cell" v-tap="{methods:goto,url:'/m/help'}">
                    <a href="javascript:;" class="mui-navigate-right  iconfont icon-help1">
                        帮助中心
                    </a>
                </li>
                <li class="mui-table-view-cell" v-tap="{methods:goto,url:'/m/about'}">
                    <a href="javascript:;" class="mui-navigate-right  iconfont icon-help">
                        关于我们
                    </a>
                </li>
            </ul>

            <ul class="mui-table-view mui-table-view-chevron" style="margin-top: .9rem;">
                <li class="mui-table-view-cell mui-off" v-tap="{methods:exit}">退出账号</li>
            </ul>

        </div>
    </transition>
</div>
<script type="text/javascript" src="/resources/wap/script/api.js"></script>
<script type="text/javascript" src="/resources/wap/script/vue.js"></script>
<script type="text/javascript" src="/resources/wap/script/common.js"></script>
<script type="text/javascript" src="/resources/wap/script/mui.min.js"></script>

<script>
    var vm = new Vue({
        el: '#app',
        data:{
            userInfo:{
                headimg:'/resources/wap/image/headimg.svg',login:'未登陆'
            }
        },
        methods:{
            goto:function(param){
              window.location.href = param.url
            },
            exit:function(){
                $.cookie('phone','', { expires: -1, path: '/' }); // 删除 cookie
                window.location.href = "/m"
            }
        }
    });
    mui.ready(function(){

        var phone =   $.cookie('phone');

        vm.userInfo.login = phone;
    })


    function adapt(designWidth, rem2px){
        var d = window.document.createElement('div');
        d.style.width = '1rem';
        d.style.display = "none";
        var head = window.document.getElementsByTagName('head')[0];
        head.appendChild(d);
        var defaultFontSize = parseFloat(window.getComputedStyle(d, null).getPropertyValue('width'));
        d.remove();
        document.documentElement.style.fontSize = window.innerWidth / designWidth * rem2px / defaultFontSize * 100 + '%';
        var st = document.createElement('style');
        var portrait = "@media screen and (min-width: "+window.innerWidth+"px) {html{font-size:"+ ((window.innerWidth/(designWidth/rem2px)/defaultFontSize)*100) +"%;}}";
        var landscape = "@media screen and (min-width: "+window.innerHeight+"px) {html{font-size:"+ ((window.innerHeight/(designWidth/rem2px)/defaultFontSize)*100) +"%;}}"
        st.innerHTML = portrait + landscape;
        head.appendChild(st);
        return defaultFontSize
    };
    var defaultFontSize = adapt(640, 100);
</script>
</body>
</html>
