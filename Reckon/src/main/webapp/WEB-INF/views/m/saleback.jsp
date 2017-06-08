<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/6
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>售后跟踪</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/eval_result.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/iconfont/iconfont.css" />
    <style>
        .mui-card-header {
            font-size: 14px;
            border-radius: 2px 2px 0 0;
            color: #757575;
        }
        .order{
            float: left;
        }
        .s-1 > .clearfix > img {
            height: 3.85rem;
            width: 3.85rem;
            margin-right: 10px;
        }
        .oldcar{
            position: absolute;
            top: 50px;
            right: 10px;
        }

        .btn{
            border: 1px solid #e4e3e6;
            border-radius: 2px;
            padding: 5px 15px 3px 15px;
            line-height: 18px;
            margin-left: 10px;
        }
        .mui-card-footer {
            -webkit-justify-content: flex-end;
            justify-content: flex-end;
        }
        .main p {
            line-height: 0.5rem;
            text-align: center;
            height: 0.5rem;
            margin-top: 0rem;
            text-indent: 0px;
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
        <div v-show="!loading" class="main" >
            <div class="none" v-show='none'><span class="iconfont icon-help1">暂无记录</span></div>
            <div class="mui-card" v-for="(item,index) in orderList">
                <div class="mui-card-header">
                    订单编号：{{item.orderNumber}}
                    <span class="btn" style="width: 95px;">{{state(item.status)}}</span>
                </div>
                <p class="mui-progressbar mui-progressbar-in">
                    <span :style="process(item.status)"></span>
                </p>
                <div class="mui-card-content">
                    <section class="s-1">
                        <div class="clearfix">
                            <img class="seriesPic"  :data-src='item.seriesImg' src="/resources/wap/image/placeholder.png">
                            <div class="des">
                                <strong class="modelName">{{item.modelName}}</strong>
                                <div class="oldcar" >
                                    <span class="label">收购价</span>：<span class="newCarPrice"> {{item.reckonPrice}}万</span>
                                </div>
                            </div>
                        </div>
                        <ul>
                            <li>
                                <div>所在城市</div>
                                <div>{{item.orderInfo.cityId}}</div>
                            </li>
                            <li>
                                <div>上牌日期</div>
                                <div>{{item.orderInfo.regDate}}</div>
                            </li>
                            <li>
                                <div>行驶里程</div>
                                <div>{{item.orderInfo.sKm}}万公里</div>
                            </li>
                            <li>
                                <div>排放标准</div>
                                <div>{{item.model.dischargeStandard}}</div>
                            </li>
                        </ul>
                    </section>
                </div>
                <div class="mui-card-footer">
                    <span class="btn" v-tap="{methods:phone}">联系客服</span>
                    <span class="btn" v-tap="{methods:detail,item:item}">详情</span>
                </div>
            </div>
        </div>
    </transition>
</div>
</body>
<script type="text/javascript" src="/resources/wap/script/api.js"></script>
<script type="text/javascript" src="/resources/wap/script/vue.js"></script>
<script type="text/javascript" src="/resources/wap/script/mui.min.js"></script>
<script type="text/javascript" src="/resources/wap/script/common.js"></script>
<script type="text/javascript" src="/resources/wap/script/lazy-load-img.min.js" ></script>
<script type="text/javascript">
    var vm = new Vue({
        el:"#app",
        data:{
            loading:true,
            orderList:[],
            none:false
        },
        methods:{
            detail:function(param){
                var item = param.item;
                $api.rmStorage('orderDetailItem')
                $api.setStorage('orderDetailItem',param.item)
                window.location.href = '/m/orderdetail'

            },
            state:function(status){
                if(status==0)return "等待预约"
                if(status==1)return "车辆处理"
                if(status==2)return "等待过户"
                if(status==3)return "过户完成"
                if(status==4)return "更新指标"
                if(status==5)return "完结"
            },
            process:function(status){
                if(status==0)return "transform: translate3d(-84%, 0px, 0px);"
                if(status==1)return "transform: translate3d(-66.4%, 0px, 0px);"
                if(status==2)return "transform: translate3d(-49.8%, 0px, 0px);"
                if(status==3)return "transform: translate3d(-33.2%, 0px, 0px);"
                if(status==4)return "transform: translate3d(-16.6%, 0px, 0px);"
                if(status==5)return "transform: translate3d(0%, 0px, 0px);background-color: #4cd964;"
            },
            phone:function(){
                window.location.href = 'tel://010-8025-8108';

            }

        },
        computed: {

        }
    })

    mui.ready(function(){
        var data = ${orderList}

        if(data.length==0){
            vm.none = true;
            vm.orderList =[];
        }else{
            vm.orderList = data;
        }
        lazyLoadImg()
        vm.loading = false;
    })

    
</script>

</html>
