<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/6
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>订单详情</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/eval_result.css" />
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
            -webkit-justify-content: flex-start;
            justify-content: flex-start;
        }
        .reckontime{
            position: absolute;
            right: 10px;
            top: 35px;
            z-index: 99999;
        }
        .reckontime span:nth-child(2) {
            color: #00aaee;
            font-size: 100%;
        }
        .mui-table-cell h5{
            line-height: 25px;
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
            <div class="mui-card">
                <div class="mui-card-header">
                    订单编号：{{item.orderNumber}}
                </div>
                <div class="mui-card-content">
                    <section class="s-1">
                        <div class="clearfix">
                            <img class="seriesPic" :src="item.seriesImg">
                            <div class="des">
                                <strong class="modelName">{{item.modelName}}</strong>
                                <div class="oldcar" >
                                    <span class="label">收购价</span>：<span class="newCarPrice"> {{item.reckonPrice}}万</span>
                                </div>
                            </div>
                        </div>
                        <ul>
                            <li>
                                <div>{{item.model.gearType}}</div>
                            </li>
                            <li>
                                <div>排量{{item.model.liter}}</div>
                            </li>
                            <li>
                                <div>{{item.model.dischargeStandard}}</div>
                            </li>
                            <li>
                                <div>座位{{item.model.seatNumber}}</div>
                            </li>
                        </ul>
                    </section>
                </div>
                <div class="mui-card-footer">
                    估值信息
                    <div class="reckontime">
                        <span >估值时间</span>：
							<span >
								{{item.reckon_time}}
							</span>
                    </div>
                </div>
                <div class="mui-card-content">
                    <section class="s-1">
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
                        <ul>
                            <li>
                                <div>使用性质 </div>
                                <div>{{item.orderInfo.xz}}</div>
                            </li>
                            <li>
                                <div>过户次数</div>
                                <div>{{item.orderInfo.gh}}</div>
                            </li>
                            <li>
                                <div>过户时间</div>
                                <div>{{item.orderInfo.ghtime}}</div>
                            </li>
                            <li>
                                <div>年检</div>
                                <div>{{item.orderInfo.nj}}</div>
                            </li>
                        </ul>
                        <ul>
                            <li>
                                <div>现使用方</div>
                                <div>{{item.orderInfo.method}}</div>
                            </li>
                            <li>
                                <div>交强险</div>
                                <div>{{item.orderInfo.jqx}}</div>
                            </li>
                            <li>
                                <div>颜色</div>
                                <div>{{item.orderInfo.color}}</div>
                            </li>
                            <li>
                                <div>车况</div>
                                <div>{{item.orderInfo.ck}}</div>
                            </li>
                        </ul>
                    </section>
                </div>
                <div class="mui-card-footer">
                    预约信息
                </div>
                <div class="mui-card-content">
                    <ul class="mui-table-view mui-table-view-striped mui-table-view-condensed">
                        <li class="mui-table-view-cell">
                            <div class="mui-table">
                                <div class="mui-table-cell mui-col-xs-10">
                                    <h5 class="mui-ellipsis">验车方式</h5>
                                    <p class="mui-h6 mui-ellipsis2">{{item.dealWay}}</p>
                                </div>
                            </div>
                        </li>
                        <li class="mui-table-view-cell">
                            <div class="mui-table">
                                <div class="mui-table-cell mui-col-xs-10">
                                    <h5 class="mui-ellipsis">地址</h5>
                                    <p class="mui-h6 mui-ellipsis2">{{item.address}}</p>
                                </div>
                            </div>
                        </li>
                        <li class="mui-table-view-cell">
                            <div class="mui-table">
                                <div class="mui-table-cell mui-col-xs-10">
                                    <h5 class="mui-ellipsis">预约时间</h5>
                                    <p class="mui-h6 mui-ellipsis2">{{item.checkTime}}</p>
                                </div>
                            </div>
                        </li>
                        <li class="mui-table-view-cell">
                            <div class="mui-table">
                                <div class="mui-table-cell mui-col-xs-10">
                                    <h5 class="mui-ellipsis">联系人</h5>
                                    <p class="mui-h6 mui-ellipsis2">{{item.linkMan}}</p>
                                </div>
                            </div>
                        </li>
                        <li class="mui-table-view-cell">
                            <div class="mui-table">
                                <div class="mui-table-cell mui-col-xs-10">
                                    <h5 class="mui-ellipsis">联系方式</h5>
                                    <p class="mui-h6 mui-ellipsis2">{{item.linkPhone}}</p>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </transition>
</div>
</body>
<script type="text/javascript" src="/resources/wap/script/api.js"></script>
<script type="text/javascript" src="/resources/wap/script/vue.js"></script>
<script type="text/javascript" src="/resources/wap/script/common.js"></script>
<script type="text/javascript" src="/resources/wap/script/mui.min.js"></script>
<script type="text/javascript">
    var vm = new Vue({
        el:"#app",
        data:{
            loading:true,
            item:{model:{},orderInfo:{}}
        },
        methods:{

        },
        computed: {

        }
    })
    mui.ready(function(){
        var param = $api.getStorage('orderDetailItem');
        vm.item = param;
        setTimeout(function(){
            vm.loading=false;
        },200)
    })


</script>

</html>
