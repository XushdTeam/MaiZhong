<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/5
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="height: 100%;">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>订单确认</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css" />
    <link rel="stylesheet" href="/resources/wap/css/eval_result.css" />
    <style>
        .s-1 > .clearfix > img {
            height: 3.85rem;
            width: 3.85rem;
            margin-right: 10px;
        }
        .trade-process-wrap {
            box-sizing: border-box;
            height: 66px;
            padding: 0 15px;
            background-color: #f2f2f2;
        }
        .trade-process-wrap .trade-process {
            overflow: hidden;
            padding-bottom: 6px;
            padding-top: 27px;
        }
        .trade-process-wrap .trade-process>li.current, .trade-process-wrap .trade-process>li.finished {
            color: #333;
        }
        .trade-process-wrap .trade-process>li {
            float: left;
            box-sizing: border-box;
            width: 25%;
            height: 31px;
            padding-bottom: 6px;
            line-height: 21px;
            font-size: 13px;
            text-align: center;
            color: #8e8e8e;
            position: relative;
            padding-top: 11px;
        }
        .trade-process-wrap .trade-process>li.current:before {
            background: url(/resources/wap/image/icons-trade.png) -222.5px -177px no-repeat;
            background-size: 290px 243px;
            width: 12px;
            height: 11px;
        }
        .trade-process-wrap .trade-process>li:before {
            content: '';
            width: 11px;
            height: 11px;
            position: absolute;
            background: url(/resources/wap/image/icons-trade.png) -238px -177px no-repeat;
            background-size: 290px 243px;
            top: -8px;
            left: 50%;
            margin-left: -5.5px;
        }
        .trade-process-wrap .trade-process>li:after {
            width: 100%;
            height: 1px;
            background: #c1c1c1;
            position: absolute;
            top: -2px;
            left: 50%;
            margin-left: 5.5px;
        }
        .trade-process-wrap .trade-process>li:after {
            display: inline-block;
            content: '';
        }
        .trade-process-wrap .trade-process>li:nth-child(4):after {
            display: none;
        }
        #footer {
            position: fixed;
            bottom: 0;
            width: 100%;
            background-color: #fff;
            visibility:visible
        }
        #footer .btn {
            height: 48px;
            line-height: 48px;
        }
        #footer .btn, .region-popup .popup li {
            text-indent: 15px;
        }
        #footer .btn .price {
            font-size: 16px;
            color: #333;
            width: 62.5%;
            float: left;
        }
        #footer .btn .price i {
            font-style: normal;
            font-size: 16px;
        }
        #footer .btn .price span {
            color: #FF3737;
            font-weight: 700;
        }
        #footer .btn a {
            float: left;
            width: 37.5%;
            height: 100%;
            font-size: 18px;
            color: #fff;
            background-color: #FF3737;
            text-align: center;
        }
        .clearfix:after {
            display: block;
            clear: both;
            width: 0;
            height: 0;
            visibility: hidden;
            overflow: hidden;
            content: "";
        }
        .list-choose-type>li {
            height: 70px;
            border-top: 1px solid #f2f2f2;
            background-color: #fff;
        }
        .list-choose-type>li>a {
            display: block;
            position: relative;
            padding: 17px 15px;
            overflow: hidden;
        }

        .list-choose-type>li>a:before {
            content: '';
            display: block;
            float: left;
            width: 36px;
            height: 36px;
        }
        .list-choose-type>li>a .type-content {
            float: left;
            margin-left: 13px;
        }
        .list-choose-type>li>a .type-content .type-name {
            color: #333;
            font-size: 15px;
            line-height: 15px;
            font-weight: 700;
            margin-bottom: 8px;
        }
        .list-choose-type>li>a .type-content .type-desc.text-gray {
            color: #757575;
        }
        .list-choose-type>li>a .type-content .type-desc {
            font-size: 12px;
            line-height: 12px;
            color: #757575;
        }
        .list-choose-type>li>a .type-content .type-desc.text-luck-draw {
            color: #FC6232;
        }
        .list-choose-type>li:nth-child(1)>a:before {
            background: url(/resources/wap/image/4s.svg);
            background-size: 36px 36px;
        }
        .list-choose-type>li:nth-child(2)>a:before {
            background: url(/resources/wap/image/site.svg);
            background-size: 36px 36px;
        }
        .list-choose-type>li:nth-child(3)>a:before {
            background: url(/resources/wap/image/gonghome.svg);
            background-size: 36px 36px;
        }
        .list-choose-type>li>a.showsource:after {
            width: 22px;
            height: 22px;
            background: url(/resources/wap/image/recycle_way_unselected.png) no-repeat;
            background-size: 100%;
        }
        .list-choose-type>li>a:after {
            content: '';
            display: block;
            position: absolute;
            top: 30px;
            right: 15px;
            width: 7px;
            height: 12px;
            background: url(/resources/wap/image/icons-trade.png) -194px -87px no-repeat;
            background-size: 290px 243px;
        }
        .list-choose-type>li.done>.showsource:after {
            background: url(/resources/wap/image/choose_active.png) no-repeat;
            background-size: 100%;
        }
        #footer .btn a {
            float: left;
            width: 37.5%;
            height: 102%!important;
            font-size: 18px;
            color: #fff;
            background-color: #F60!important;
            text-align: center;
            border-top: 1px solid #F60!important;
        }

    </style>
</head>

<body style="height: 100%;background-color: #f2f2f2;">
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
        <div v-show="!loading" class="main">
            <div>
                <section class="s-1">
                    <div class="clearfix">
                        <img class="seriesPic" :src="orderInfo.seriesImg">
                        <div class="des">
                            <strong class="modelName">{{orderInfo.modelName}}</strong>
                        </div>
                    </div>
                </section>
            </div>
            <div class="trade-process-wrap">
                <ul class="trade-process">
                    <li class="current">验车方式</li>
                    <li>填写信息</li>
                    <li>联系方式</li>
                    <li>提交成功</li>
                </ul>
            </div>
            <div>
                <ul class="list-choose-type">
                    <li :class="{'done':curId==1}" >
                        <a class="showsource" v-tap="{methods:select,id:1}">
                            <div class="type-content">
                                <div class="type-name">
                                    4S店验车
                                </div>
                                <div class="type-desc text-gray text-luck-draw">24小时内到店交易，必中现金大奖</div>
                            </div>
                        </a>
                    </li>
                    <li :class="{'done':curId==2}" >
                        <a class="showsource" v-tap="{methods:select,id:2}">
                            <div class="type-content two-lines">
                                <div class="type-name">地铁站验车</div>
                                <div class="type-desc text-gray">离您最近的地铁站</div>
                            </div>
                        </a>
                    </li>
                    <li :class="{'done':curId==3}" >
                        <a class="showsource" v-tap="{methods:select,id:3}">
                            <div class="type-content two-lines">
                                <div class="type-name">上门验车</div>
                                <div class="type-desc">免费上门服务，提前预约</div>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
            <footer id="footer">
                <div class="btn clearfix">
                    <div class="price">
                        收车价格<i>￥</i><span id="js-price">{{orderInfo.salePrice}}万</span>
                    </div>
                    <a id="js-next" v-tap="{methods:next}">下一步</a>
                </div>
            </footer>
        </div>
    </transition>
</div>
</body>
<script type="text/javascript" src="/resources/wap/script/api.js"></script>
<script type="text/javascript" src="/resources/wap/script/vue.js"></script>
<script type="text/javascript" src="/resources/wap/script/mui.min.js" ></script>
<script type="text/javascript" src="/resources/wap/script/common.js"></script>

<script type="text/javascript">
    var vm = new Vue({
        el:"#app",
        data:{
            loading:false,
            curId:0,
            orderNum:'',
            orderInfo:{seriesImg:'',reckonPrice:''},
            week:[]
        },
        methods:{
            select:function(param){
                this.curId = param.id
            },
            next:function(){
                if(this.curId==0){
                    mui.toast('请选择验车方式')
                    return
                }else{
                    if(vm.curId==1){
                        window.location.href = '/m/yuyue/4s'
                    }else if(vm.curId==2){
                        window.location.href = '/m/yuyue/site'
                    }else{
                        window.location.href = '/m/yuyue/address'

                    }

                }
            }
        },
        computed: {

        }
    })
    mui.ready(function () {
        var orderInfo = ${orderInfo}
        if(orderInfo){
            $api.rmStorage('orderItem')
            $api.setStorage('orderItem',orderInfo)
            vm.orderInfo = orderInfo
            //vm.week = r.data.oneWeek;
            vm.loading = false;
        }

    })



</script>

</html>
