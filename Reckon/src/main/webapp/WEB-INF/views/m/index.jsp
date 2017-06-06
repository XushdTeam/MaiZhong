<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/5/31
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>悟空收车</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css"/>
    <link rel="stylesheet" href="/resources/wap/css/iconfont/iconfont.css"/>
    <style>
        html {
            font-family: "Microsoft YaHei", Arial, Helvetica, sans-serif;
            min-width: 320px;
            font-size: 50px;
            -webkit-text-size-adjust: none;
        }

        .mui-card-header {
            -webkit-justify-content: flex-start;
            justify-content: flex-start;
        }

        .headimg {
            height: 32px !important;
            width: 32px !important;
            margin-right: 0.5rem;
        }

        .mui-slider {
            height: 10rem;
        }

        .mui-slider .mui-slider-group .mui-slider-item img {
            height: 10rem;
            width: 100%;
        }

        .mui-bar-transparent {
            background: rgba(255, 255, 255, 0.99);
        }

        .mui-hed {
            float: right;
            line-height: 44px;
            color: #f60;
        }

        .mui-ti {
            color: #f60;
            text-align: left;
            line-height: 44px
        }

        .mui-ti img {
            line-height: 44px;
            margin-top: .3rem;
        }

        .mui-foot {
            margin-top: 20px;
            text-align: center;
            overflow: hidden;
        }

        .mui-foot span {
            border: 1px solid #f60;
            padding: .6rem 1rem;
            color: #f60;
            font-size: 0.8rem;
            border-radius: 8%;
        }

        .mui-bar .mui-title {
            right: 10px;
            left: 10px;
        }
        .swiper-slide {
           height: auto!important;
        }
    </style>
</head>
<body>
<div id="app">
<div style="background: url(/resources/wap/image/t_banner.jpg) no-repeat; height: 3.5rem; background-size:100% ;"
     id="t_banner" v-tap="{methods:goto,url:'/app/download'}" >
    <span style=" padding: 1.3rem 2rem; font-size:1.2rem;color: #666;"
          onclick="javascript:document.getElementById('t_banner').style.display='none'">X</span>
</div>

<header id="header" class="mui-bar mui-bar-transparent">
    <h1 class="mui-title mui-ti"><img src="/resources/wap/image/logo.png" width="120rem">
        <i class="mui-icon mui-icon-contact mui-icon-icon-contact-filled mui-hed" v-tap="{methods:goto,url:'/m/my'}"></i>
    </h1>
</header>

    <div id="body">
        <div id="slider" class="mui-slider">
            <div class="mui-slider-group mui-slider-loop">
                <div class="mui-slider-item mui-slider-item-duplicate" v-for="(vo,index) in slideImg">
                    <a v-tap="{methods:goto,url:vo.url}">
                        <img :src="vo.i">
                    </a>
                </div>
            </div>
        </div>
        <nav class="deal-bar">
            <a class="buy-car-btn iconfont icon-awcompute" v-tap="{methods:goto,url:'/m/computed'}">免费估值</a>
            <a class="sell-car-btn iconfont icon-vipsale" v-tap="{methods:gotosale,url:'/m/precise'}">我要卖车</a>
        </nav>
        <div class="quick-wrap wrap newly-add">
            <a class="mores" v-tap="{methods:goto,url:'/m/allbrand'}">更多 &gt;</a>
            <h2>热收车型</h2>
            <nav class="brands">
                <a v-for="(brand,index) in hotbrand" v-tap="{methods:hotbrandM,model:brand}">
                    <img :src="brand.largeLogo">
                    {{brand.brand}}
                </a>
            </nav>
        </div>
        <div class="quick-wrap wrap newly-add">
            <h2>热收车系</h2>
            <nav class="price" v-for="group in hotseries">
                <a v-for="item in group.child " v-tap="{methods:hotseriesM,model:item}">{{item.seriesName}}</a>
            </nav>
        </div>
        <div class="quick-wrap wrap newly-add">
            <h2>成交记录</h2>
            <ul class="swiper-wrapper">
                <li class="swiper-slide swiper-slide-active">
                    <dl class="car-list">
                        <dd v-for="car in hotdeal">
                            <a class="icon-half">
                                <img :src="car.img"  :data-img='car.img'
                                     v-tap="{methods:selectCarDeal,model:car}">
                                <h4 v-tap="{methods:selectCarDeal,model:car}" class="mui-ellipsis-2">{{car.title}}</h4>
                                <span class="data" v-tap="{methods:selectCarDeal,model:car}">{{car.param}}</span>
                                <div class="price-wrap" v-tap="{methods:selectCarDeal,model:car}">
                                    ￥<strong class="price" style="border-top: none;">{{car.price}}</strong>
                                </div>
                            </a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
        <div class="quick-wrap wrap newly-add">
            <h2>用户评论</h2>
            <div id="sliderTalk" class="mui-slider" style="height: 220px;">
                <div class="mui-slider-group mui-slider-loop">
                    <div class="mui-slider-item mui-slider-item-duplicate" v-for="talk in hottalk">
                        <div class="mui-card">
                            <div class="mui-card-header"><img class="headimg"
                                                              :src="talk.img"><span>{{talk.phone}}</span></div>
                            <div class="mui-card-content">
                                <div class="mui-card-content-inner" style="height: 90px;line-height: 30px;">
                                    {{talk.content}}
                                </div>
                            </div>
                            <div class="mui-card-footer" style="height: 53px;">{{talk.time}}{{talk.method}}<span
                                    style="color: #F60;"
                                    v-tap="{methods:gototalk,modelId:talk.modelId}">{{talk.car}}</span></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="quick-wrap wrap newly-add knowledge-wrap">
            <h2>精选文章</h2>
            <dl class="knowledge-list">
                <dd v-for="(wz,index) in wz">
                    <a>
                        <img :src="wz.img"
                             v-tap="{methods:goto,url:wz.url}">
                        <h4 v-tap="{methods:goto,url:wz.url}">{{wz.title}}</h4>
                        <p class="mui-ellipsis-2" v-tap="{methods:goto,url:wz.url}">
                            {{wz.content}}
                        </p>
                    </a>
                </dd>
            </dl>
        </div>

        <div class="mui-foot">
            <p><a href="/app/download"><span>下载APP </span> </a> &nbsp;&nbsp;&nbsp;<a href="/activity/1"><span> 服务保障</span></a></p>

        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/wap/script/api.js"></script>
<script type="text/javascript" src="/resources/wap/script/vue.js"></script>
<script type="text/javascript" src="/resources/wap/script/mui.min.js"></script>
<script type="text/javascript" src="/resources/wap/script/common.js"></script>
<script type="text/javascript" src="/resources/wap/script/async.min.js"></script>
<script type="text/javascript" src="/resources/wap/script/interface.js"></script>
<script>
    var vm = new Vue({
        el: '#app',
        data: {
            slideImg: [],
            wz: [],
            hotbrand: [],
            hotseries: [],
            hottalk: [],
            hotdeal: []
        },
        methods: {
            goto: function (param) {
                window.location = param.url;
            },hotbrandM:function(param) {
                $api.rmStorage('hotbrandItem')
                $api.rmStorage('model')
                $api.setStorage('hotbrandItem',param.model)
                window.location.href = '/m/series/'+param.model.brandId

            },hotseriesM:function(param){
                $api.rmStorage('model')
                window.location.href = "/m/model/"+param.model.seriesId;
            },gotosale:function(param){
                $api.rmStorage('model');
                $api.rmStorage('city');
                $api.rmStorage('mile');
                $api.rmStorage('time');
                window.location = param.url;
            },gototalk:function(param){
                window.location = '/m/computed/'+param.modelId;

            },selectCarDeal:function(param){
                window.location = '/m/computed/'+param.model.mid;

            },getData: function () {
                async.parallel([
                    function (cb) {
                        //轮播
                        mui.getJSON('${OSS}/activity.json', function (d) {
                            vm.slideImg = d
                            setTimeout(function () {
                                var slider = mui("#slider");
                                slider.slider({
                                    interval: 5000
                                });
                            }, 100)
                            cb(null, 1)
                        })
                    }, function (cb) {
                        //热收品牌
                        mui.getJSON('${OSS}/hotbrand.json', function (d) {
                            vm.hotbrand = d;
                            cb(null, 2)
                        });
                    }, function (cb) {
                        //热门车系
                        mui.getJSON('${OSS}/hotseries.json', function (d) {
                            vm.hotseries = d;
                            cb(null, 3)
                        });
                    }, function (cb) {
                        //最近成交
                        mui.getJSON('${OSS}/hotdeal.json', function (d) {
                            vm.hotdeal = $api.shuffle(d);
                            cb(null, 4)
                        });
                    }, function (cb) {
                        //最新评论
                        mui.getJSON('${OSS}/hottalk.json', function (d) {
                            $api.each(d, function (j, i) {
                                i.img = '/resources/wap/image/user' + (j % 4 + 1) + '.svg';
                                i.time = datemy(j);
                            });

                            vm.hottalk = $api.shuffle(d)
                            setTimeout(function () {
                                var slider1 = mui("#sliderTalk");
                                slider1.slider({
                                    interval: 5000
                                });
                            }, 100)

                            cb(null, 5)
                        });
                    }, function (cb) {
                        mui.getJSON('${OSS}/wz.json', function (d) {
                            vm.wz = d
                            cb(null, 6)
                        });
                    }
                ], function (e, r) {
                    console.log(r);
                })
            }
        },
        created(){
            this.getData();
        }
    });


    function adapt(designWidth, rem2px) {
        var d = window.document.createElement('div');
        d.style.width = '1rem';
        d.style.display = "none";
        var head = window.document.getElementsByTagName('head')[0];
        head.appendChild(d);
        var defaultFontSize = parseFloat(window.getComputedStyle(d, null).getPropertyValue('width'));
        d.remove();
        document.documentElement.style.fontSize = window.innerWidth / designWidth * rem2px / defaultFontSize * 100 + '%';
        var st = document.createElement('style');
        var portrait = "@media screen and (min-width: " + window.innerWidth + "px) {html{font-size:" + ((window.innerWidth / (designWidth / rem2px) / defaultFontSize) * 100) + "%;}}";
        var landscape = "@media screen and (min-width: " + window.innerHeight + "px) {html{font-size:" + ((window.innerHeight / (designWidth / rem2px) / defaultFontSize) * 100) + "%;}}"
        st.innerHTML = portrait + landscape;
        head.appendChild(st);
        return defaultFontSize
    }
    ;
    var defaultFontSize = adapt(640, 100);
</script>
</body>
</html>
