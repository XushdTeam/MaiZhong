<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/5
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html style="height: 100%;">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>订单确认4s店</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css" />
    <link rel="stylesheet" href="/resources/wap/css/eval_result.css" />
    <link rel="stylesheet" href="/resources/wap/css/picker.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js" type="text/javascript"></script>
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
        .trade-process-wrap .trade-process>li.finished:before {
            background: url(/resources/wap/image/icons-trade.png) -205px -177px no-repeat;
            background-size: 290px 243px;
            width: 11px;
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
        .selectBtn{
            display: block;
            padding: 10px 10px;
            border: 1px solid #e2e2e2;
        }
        .contact-info{
            margin-top: -45px;
        }
        .contact-info, .contact-info h2 {
            border-bottom: 1px solid #f2f2f2;
        }
        .contact-info, .contact-info h2 {
            border-bottom:1px solid #e6e6e6
        }
        .contact-info h2 {
            font-size: 15px;
            color: #333;
            height: 54px;
            line-height: 54px;
            overflow: hidden;
            padding-left: 15px;
            text-align: left;
            font-weight: normal;
        }
        .contact-info h2:before {
            content: "";
            display: block;
            width: 20px;
            height: 20px;
            float: left;
            margin-right: 10px;
            margin-top: 18px;
            background: url(/resources/wap/image/icons-trade.png) -43px -54px no-repeat;
            background-size: 290px 243px;
        }
        .contact-info .info-list li {
            display: block;
            margin-left: 15px;
            height: 54px;
            line-height: 54px;
            position: relative;
        }
        .contact-info .info-list li input {
            outline: 0;
            border: 0;
            display: block;
            padding-top: 13px;
            padding-bottom: 5px;
            line-height: 28px;
            font-size: 15px;
            width: 100%;
        }
        .contact-info .info-list{
            margin-top: -40px;
        }
        .contact-info .info-list li {
            display: block;
            margin-left: 15px;
            height: 50px;
            line-height: 50px;
            position: relative;
        }

        .contact-info .info-list li+li {
            height: 55px;
            line-height: 55px;
            border-top: 1px solid #f2f2f2;
        }
        .trade-type-info {
            border-bottom: 1px solid #e6e6e6;
            margin-bottom: 10px;
            margin-top: 0;
        }
        .trade-type-info li:last-child {
            border-bottom: none;
        }
        .trade-type-info .select-shop {
            height: 54px;
            line-height: 54px;
            padding-left: 15px;
            font-size: 15px;
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
        .trade-type-info .select-shop #js-choose-shop-btn {
            position: relative;
            color: #333;
        }
        .trade-type-info .select-shop #js-choose-shop-btn:before {
            content: '';
            display: block;
            height: 20px;
            width: 20px;
            background: url(/resources/wap/image/icons-trade.png) -10px -54px no-repeat;
            background-size: 290px 243px;
            margin-top: 17px;
            float: left;
            margin-right: 10px;
        }
        .trade-type-info .select-shop #js-choose-shop-btn:after {
            position: absolute;
            right: 15px;
            top: 50%;
            margin-top: -9px;
            width: 7px;
            height: 12px;
            background: url(/resources/wap/image/icons-trade.png) -194px -87px no-repeat;
            background-size: 290px 243px;
            content: '';
        }
    </style>
</head>

<body style="height: 100%;">
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
                        <img class="seriesPic"  :src="orderInfo.seriesImg">
                        <div class="des">
                            <strong class="modelName">{{orderInfo.modelName}}</strong>
                        </div>
                    </div>
                </section>
            </div>
            <div class="trade-process-wrap">
                <ul class="trade-process">
                    <li class="finished">验车方式</li>
                    <li :class="[{'current':shopId==0},{'finished':shopId!=0}]">填写信息</li>
                    <li :class="{'current':shopId!=0}">联系方式</li>
                    <li>提交成功</li>
                </ul>
            </div>
            <div class="shop">
                <div>
                    <ul class="trade-type-info">
                        <li class="trade select-shop clearfix" id="js-recommand-shop" >
                            <div id="js-choose-shop-btn" class="done" v-tap="{methods:selectPop}">{{shopName}}</div>
                        </li>
                    </ul>
                </div>
                <div class="popup-wrap slideup-popup " :class="{'show':shopPopup}" >
                    <div class="popup" id="popup" >
                        <div class="header">
                            <div class="close cancel" v-tap="{methods:selectPop}">取消</div>
                            <div class="title">4S店回收</div>
                            <div class="close ensure confirm" v-tap="{methods:shopOk}">确定</div>
                        </div>
                        <div class="shop-tab">
                            <ul class="">
                                <li class="area " :class="[{'current':tab==1},{'show':districtId!=0}]" v-tap="{methods:showTab,id:1}">选择区域</li>
                                <li class="city " :class="[{'current':tab==2},{'show':districtId!=0}]" v-tap="{methods:showTab,id:2}">选择门店</li>
                            </ul>
                        </div>
                        <div class="content1">
                            <div class="shop-wrap">
                                <div class="shop-trade clearfix">
                                    <div class="region tab-panel " :class="{'current':tab == 1}" id="js-region">
                                        <ul style="transition-duration: 600ms; transform: translateY(0px);overflow-y: auto; height: 260px;    background: #FFF">
                                            <li  v-for="(vo,index) in district" :class="{'current active':vo.id == districtId }"  v-tap="{methods:selectArea,id:vo.id}">
                                                {{vo.name}}
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="shop tab-panel " :class="{'current':tab== 2}"  id="js-shop">
                                        <ul style="overflow-y: auto; height: 260px;">
                                            <li v-for="(xo,index) in shop" :class="[{'hide':xo.districtId!=districtId},{'current':xo.id==shopId}]" >
                                                <div class="shop-text-wrap" v-tap="{methods:selectShop,item:xo}">
                                                    <div class="shop-name"><span>{{xo.name}}</span></div>
                                                    <div class="shop-info"> <p>{{xo.address}}</p></div>
                                                </div>
                                                <div class="shop-map-wrap" v-tap="{methods:openMap,item:xo}">
                                                    <a class="shop-map" ><span>地图</span></a>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="site">

            </div>
            <div class="gonhome">

            </div>

            <div class="contact-info" >
                <h2>联系人</h2>
                <div class="info-list">
                    <ul>
                        <li class="username"><input type="text" id="contact-username" v-model="username" placeholder="输入您的姓名" value=""></li>
                        <li class="number">
                            <input type="tel" id="mobile-number" placeholder="输入手机号" v-model="phone" value="" autocomplete="off">
                        </li>
                    </ul>
                </div>
            </div>

            <footer id="footer">
                <div class="btn clearfix">
                    <div class="price">
                        收车价格<i>￥</i><span id="js-price">{{orderInfo.salePrice}}万</span>
                    </div>
                    <a id="js-next" v-tap="{methods:next}">提交订单</a>
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
            loading:true,
            orderInfo:{},
            curId:0,
            shopPopup:false,
            district:[],
            shop:[],
            districtId:0,
            shopId:0,
            tab:1,
            username:'',
            phone:'',
            shopName:"点击选择4S店"
        },
        methods:{
            select:function(param){
                this.curId = param.id
            },
            next:function(){

                var input = document.querySelectorAll('input');
                $api.each(input,function(i,j){
                    j.blur();
                })

                if(!this.shopId){
                    mui.toast('请选择4S店')
                    return;
                }
                if(!this.username){
                    mui.toast('请输入您的姓名')
                    return;
                }
                if(!(/^1[34578]\d{9}$/.test(this.phone))){
                    mui.toast('请输入您的手机号')
                    return;
                }
                var param={};
                param.orderNumber = this.orderInfo.orderNumber;
                param.dealWay = "1";
                param.wayId = this.shopId;
                param.linkMan = this.username;
                param.linkPhone = this.phone;
                param.checkTime = "";
                param.address = "";

                mui.post("/OrderConfim",param,function(res){
                    console.log(res.status)
                    if(res.status==200){
                        window.location.href = "/m/ordersuccess"
                    }else{
                        mui.toast(res.message)
                    }
                },'json');


            },
            selectPop:function(param){
                var input = document.querySelectorAll('input');
                $api.each(input,function(i,j){
                    j.blur();
                })

                this.shopPopup = vm.shopPopup?false:true;
            },
            selectArea:function(param){
                this.districtId = param.id
                this.tab = 2;
            },
            selectShop:function(param){
                var item = param.item;
                this.shopId = item.id;
                this.shopPopup = false;
                this.shopName = item.name;

            },
            showTab:function(param){
                this.tab = param.id;
            },
            openMap:function(param){
                $api.remove('bmapItem')
                $api.setStorage('bmapItem',param.item)
                window.location.href = '/m/bmap'
            },
            shopOk:function(){
                if(this.shopId!=0){
                    this.shopPopup = false;
                }else{
                    mui.toast('请选择4S店')
                }
            }

        },
        computed: {
            tabclass1:function(){
                var cls = "";
                if(this.tb==1){
                    cls+=' current '
                }
                if(this.districtId!=0){
                    cls+=' show'
                }
                console.log(cls)
                return cls;
            },
            tabclass2:function(){
                var cls = "";
                if(this.tb==2){
                    cls+=' current '
                }
                if(this.districtId!=0){
                    cls+=' show'
                }
                return cls;
            }
        }
    })

    mui.ready(function(){
        var model = $api.getStorage('orderItem')
        if(model)vm.orderInfo = model
        var bussiness = ${business}
        var district = [];
        var shop = [];
        $api.each(bussiness,function(_index,item){
            district.push({id:item.id,name:item.district})
            $api.each(item.shop,function(j,vo){
                shop.push(vo);
            })
        })
        vm.district = district;
        vm.shop = shop;
        vm.phone = $.cookie('phone');
        vm.loading = false;
    })


</script>

</html>

