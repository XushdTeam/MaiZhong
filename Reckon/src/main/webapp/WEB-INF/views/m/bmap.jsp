<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/5
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html style="height: 100%;">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>地图定位</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css" />
    <style>
        #allmap{
            width: 100%;
            height:100%;
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

<body style="height: 100%;">
<div class="mui-content" id="app" v-cloak style="height: 100%;">
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
        <div v-show="!loading" style="height: 100%;" >
            <div id="allmap"></div>

            <div class="shop-bottom">
                <div class="shop-text-wrap">
                    <div class="shop-name"><span>{{item.name}} <input id="js-id" type="hidden" value="17"></span></div>
                    <div class="shop-info"> <p>{{item.address}}</p></div>
                </div>
                <div class="next"><a class="next-btn" v-tap="{methods:next}">返回</a></div>
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
            item:{}
        },
        methods:{
            next:function(){
               window.history.back(1)
            }
        },
        computed: {

        }
    })

    //百度地图API功能
    function loadJScript(lon,lat) {
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=N8kgZsufZYtKgEXbtUoTHrKlaqgAxTFY&callback=init";
        document.body.appendChild(script);
    }
    function init() {
        var map = new BMap.Map("allmap");            // 创建Map实例
        var point = new BMap.Point(lon, lat); // 创建点坐标

        map.enableScrollWheelZoom();                 //启用滚轮放大缩小
        var marker = new BMap.Marker(point);  // 创建标注
        // 将标注添加到地图中
        map.addOverlay(marker);
        map.centerAndZoom(point,15);

        setTimeout(function(){
            vm.loading = false;
        },200);
    }
    var lon,lat="";


    mui.ready(function(){
        var item = $api.getStorage('bmapItem')
        vm.item = item;
        lon = item.location.split(',')[0];
        lat = item.location.split(',')[1];
        /**
         * 异步加载地图
         */
        loadJScript()
    })



</script>

</html>

