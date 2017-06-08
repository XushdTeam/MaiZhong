<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/2
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>估值结果</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/rest.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/eval_result.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css"/>
    <style>
        .mui-table-view-cell.mui-collapse .mui-table-view {
            margin-top: 0px;
        }

        .mui-table-view-cell.mui-collapse .mui-table-view .mui-table-view-cell {
            padding-left: 20px;
        }

        .mui-table-view-cell.mui-collapse .mui-collapse-content {
            padding: 0px 15px 8px 15px;
        }

        .mui-table-view-cell.mui-collapse .mui-table-view .mui-table-view-cell:after {
            left: 20px;
        }

        .mui-ellipsis {
            overflow: hidden;
            white-space: normal;
            text-overflow: ellipsis;
        }

        .mui-card {
            margin: 0px;
        }

        .right {
            float: right;
            margin-right: 18px;
            color: #ff6600;
            font-weight: bold;
        }

        .mui-table-view-cell.mui-collapse.mui-active {
            margin-top: 0px;
        }

        .mui-table-view-cell.mui-active {
            background-color: #FFF;
        }

        .mui-navigate-right.mui-active {
            background-color: #FFF !important;
        }
    </style>
<body>
<div id="app" class="mui-content" v-cloak>
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
        <div style="background: #FFFFFF!important;" v-show="!loading">
            <section class="s-1">
                <div class="clearfix">
                    <img class="seriesPic" alt="" :src="gzinfo.seriesImg">

                    <div class="des">
                        <strong class="modelName">{{gzinfo.modelName}}</strong>

                        <div class="newCar"><span class="label">新车价</span>：<span class="newCarPrice"> {{gzinfo.modelPrice}}万</span>
                        </div>
                    </div>
                </div>
                <ul>
                    <li>
                        <div>所在城市</div>
                        <div class="location">{{gzinfo.city}}</div>
                    </li>
                    <li>
                        <div>上牌日期</div>
                        <div class="regDate">{{gzinfo.regdate}}</div>
                    </li>
                    <li>
                        <div>行驶里程</div>
                        <div class="mileAge">{{gzinfo.mail}}万公里</div>
                    </li>
                    <li>
                        <div>排放标准</div>
                        <div class="dis">{{gzinfo.dischargeStandard}}</div>
                    </li>
                </ul>
            </section>
            <section class="title">
                <div>估值区间</div>
            </section>
            <section class="s-4">
                <div class="mui-card">
                    <ul class="mui-table-view">
                        <li class="mui-table-view-cell mui-collapse">
                            <a class="mui-navigate-right">车况优秀
                                <span class="right">{{gzinfo.priceA}}</span>
                            </a>
                            <div class="mui-collapse-content">
                                <ul class="mui-table-view">
                                    <li class="mui-table-view-cell mui-media">
                                        <div class="mui-media-body">
                                            外观
                                            <p class='mui-ellipsis'>外观无可见瑕疵和色差</p>
                                        </div>
                                    </li>
                                    <li class="mui-table-view-cell mui-media">
                                        <div class="mui-media-body">
                                            内饰
                                            <p class='mui-ellipsis'>内饰干净整洁无明显可见磨损；无异味</p>
                                        </div>
                                    </li>
                                    <li class="mui-table-view-cell mui-media">
                                        <div class="mui-media-body">
                                            工况
                                            <p class='mui-ellipsis'>2年且4万公里以内；动力系统、机械部位运行正常且无维修；按时保养且记录完整；电子系统无任何故障</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="mui-table-view-cell mui-collapse">
                            <a class="mui-navigate-right">车况良好
                                <span class="right">{{gzinfo.priceB}}</span>
                            </a>
                            <div class="mui-collapse-content">
                                <ul class="mui-table-view">
                                    <li class="mui-table-view-cell mui-media">
                                        <div class="mui-media-body">
                                            外观
                                            <p class='mui-ellipsis'>外观无色差，有个别瑕疵</p>
                                        </div>
                                    </li>
                                    <li class="mui-table-view-cell mui-media">
                                        <div class="mui-media-body">
                                            内饰
                                            <p class='mui-ellipsis'>内饰有个别部件存在轻微磨损；无破损，无异味</p>
                                        </div>
                                    </li>
                                    <li class="mui-table-view-cell mui-media">
                                        <div class="mui-media-body">
                                            工况
                                            <p class='mui-ellipsis'>
                                                20万公里以内；动力系统运行正常且无维修；机械部位运行正常，有部分维修或更换记录；电子设备及模块使用正常</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="mui-table-view-cell mui-collapse">
                            <a class="mui-navigate-right">车况一般
                                <span class="right">{{gzinfo.priceC}}</span>
                            </a>
                            <div class="mui-collapse-content">
                                <ul class="mui-table-view">
                                    <li class="mui-table-view-cell mui-media">
                                        <div class="mui-media-body">
                                            外观
                                            <p class='mui-ellipsis'>外观有轻微色差，有少量瑕疵</p>
                                        </div>
                                    </li>
                                    <li class="mui-table-view-cell mui-media">
                                        <div class="mui-media-body">
                                            内饰
                                            <p class='mui-ellipsis'>内饰有少量部件存在磨损，个别严重破损；通风后不存在明显异味</p>
                                        </div>
                                    </li>
                                    <li class="mui-table-view-cell mui-media">
                                        <div class="mui-media-body">
                                            工况
                                            <p class='mui-ellipsis'>动力系统正常且无维修；机械部位运行存在异常，有部分维修或更换记录</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="mui-table-view-cell mui-collapse">
                            <a class="mui-navigate-right">车况较差
                                <span class="right">{{gzinfo.priceD}}</span>
                            </a>
                            <div class="mui-collapse-content">
                                <ul class="mui-table-view">
                                    <li class="mui-table-view-cell mui-media">
                                        <div class="mui-media-body">
                                            外观
                                            <p class='mui-ellipsis'>外观多块喷漆，有较明显色差，有较多瑕疵</p>
                                        </div>
                                    </li>
                                    <li class="mui-table-view-cell mui-media">
                                        <div class="mui-media-body">
                                            内饰
                                            <p class='mui-ellipsis'>内饰较多部件存在磨损，个别严重破损；通风后不存在明显异味。</p>
                                        </div>
                                    </li>
                                    <li class="mui-table-view-cell mui-media">
                                        <div class="mui-media-body">
                                            工况
                                            <p class='mui-ellipsis'>动力系统正常；机械部位运行存在异常，有部分维修或更换记录</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
            </section>
            <section class="title">
                <div>成交记录</div>
            </section>
            <section class="s-6" id="carList">
                <div v-for="item in dealData">
                    <div class="top clearfix">
                        <strong>{{item.modelName}}</strong>
                        <span>{{item.price}}万</span>
                    </div>
                    <div class="bot clearfix">
                        <span>{{item.city}}</span><span>{{item.redate}}上牌</span><span>{{item.mail}}万公里</span><span>成交于{{item.time}}</span>
                    </div>
                </div>
            </section>
            <br/>
            <br/>
            <div class="est-bg" v-tap="{methods:sale}">
                <a>获取精准价格</a>
            </div>
        </div>
    </transition>
</div>
<script type="text/javascript" src="/resources/wap/script/api.js"></script>
<script type="text/javascript" src="/resources/wap/script/mui.min.js"></script>
<script type="text/javascript" src="/resources/wap/script/vue.js"></script>
<script type="text/javascript" src="/resources/wap/script/interface.js"></script>
<script type="text/javascript" src="/resources/wap/script/common.js"></script>
<script>

    vm = new Vue({
        el: '#app',
        data: {
            loading: true,
            gzinfo: {},
            dealData: []
        },
        methods: {
            sale:function(){
                window.location.href = "/m/precise"
            }
        }
    })

    mui.ready(function(){

        var dealData = [];
        var guzhi = ${data};
        var num = Math.floor(Math.random() * 10 + 5);

        var year = getYear(guzhi.minYear, guzhi.maxYear);
        var yn = year.length
        for (var i = 1; i < num; i++) {
            var item = {};
            item.modelName = guzhi.modelName;
            item.city = guzhi.city
            var mail = Math.floor(Math.random() * 19 + 1);
            item.mail = mail;
            item.time = datemy2(mail);
            item.redate = year[Math.floor(Math.random() * yn)].value + '-' + '01';
            var price = (guzhi.priceD_min - ('0.' + Math.floor(Math.random() * 9 + 1))).toFixed(2)
            item.price = price > 0 ? price : '0.00';
            dealData.push(item);
        }
        vm.dealData = dealData;
        vm.gzinfo = guzhi;
        vm.loading = false;
    })

    /**
     * 获取年
     * @param {Object} min
     * @param {Object} max
     */
    var getYear = function (min, max) {
        var c = min,
                d = max,
                time = [],
                e = "";
        for (y = c; y <= d; y++) {
            time.push({value: y, text: y + '年'})
        }
        return time;
    }
    /**
     * 获取月
     * @param {Object} year
     */
    var getMonth = function (year) {
        var b = year,
                c = 1,
                d = new Date,
                e = b >= parseInt(d.getFullYear()) ? parseInt(d.getMonth() + 1) : 12,
                month = [];

        for (m = c; m <= e; m++) {
            var f = "";
            f = m < 10 ? '0' + m + "月" : m + "月";
            month.push({value: b + '-' + m, text: b + ' 年 ' + f});
        }
        return month;
    }
</script>
</body>
</html>

