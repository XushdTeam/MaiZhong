<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/31
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <%@ include file="head.jsp" %>
    <link href="/resources/main/css/MyCyp.css" rel="stylesheet">
    <link href="/resources/main/css/page.css" rel="stylesheet">
</head>
<body>
<%@ include file="nav.jsp" %>

<div class="w1200 mauto" id="app" v-clock>
    <div class="place mt20"><a href=" ">个人中心</a> &gt;&gt;&nbsp;<span class="c9" id="YeQianSan">历史竞价</span></div>
    <div class="mt25 clearfix">
        <div class="fl w130 bgf8">
            <div class="pl30 pb15 pt15">
                <h3 class="fs14 c3 lh27">交易中心</h3>
                <ul class="fs12 newsubnav">
                    <li id="ConfirmOrderList"><span @click="mylist" style="cursor: hand">成交确认</span></li>
                    <li id="OrderList"><span @click="orderList" style="cursor: hand">订单车辆</span></li>
                    <li id="HistoryAuctionCarList"><span @click="bidRecordList" style="cursor: hand">历史订单</span></li>
                    <li id="CarList"><span @click="likeCarList" style="cursor: hand">关注车辆</span></li>
                </ul>
                <h3 class="fs14 c3 lh27 mt20">个人设置</h3>
                <ul class="fs12 newsubnav">
                    <li id="Account"><span @click="personal" style="cursor: hand">基本信息</span></li>
                    <li id="EditPwd"><span @click="changePassword" style="cursor: hand">修改密码</span></li>
                    <li id="Message"><span @click="yijian" style="cursor: hand">投诉建议</span></li>
                </ul>
            </div>
        </div>

        <div class="fr w1060">
            <div class="bbs1b h41 pr">
                <span class="fs16 c3 righttit">历史竞价</span>
                <span class="icon_tips">
                    <img src="main/tishi.jpg"></span>
                <span class="tips_box">显示出用户对近6个月内所参与过报价的车辆列表（不包括竞拍中的交易车辆）</span>

            </div>
            <div class="pr10 pl10 pt25">
                <table class="fs14 c9 tabcar w">
                    <thead>
                    <tr class="c3 bgf5 fs14">
                        <td colspan="2" width="550">
                            <div class="select_box select_box2">
                                <span class="c3 text">车辆</span>

                            </div>
                        </td>
                        <td width="260" style="padding-left: 80px">合手价</td>
                        <td width="230">
                            <div class="select_box select_box2">
                                <span class="c3 text">竞拍结束时间</span>

                            </div>
                        </td>
                    </tr>
                    </thead>
                    <tbody id="HistoryAuctionCar">
                    <tr height="120" class="trhover" v-for="(item,index) in list">
                        <td width="140px" class="pl10">
                            <div class="carnew">
                                <img :src="item.zq45">
                            </div>
                        </td>
                        <td width="270px" class="pl10 pr10">
                            <div class="fs14 clearfix">
                                <a target="_blank" :title="item.modelName" href="" :id="item.id" class="fl cblack">
                                    <span class="fl carname" style="cursor: pointer">{{item.modelName}}</span>
                                </a>
                                <p class="fr fs12 cwhite w60"></p>
                            </div>
                            <p class="mt10">{{item.zcd}}&nbsp;&nbsp;初登：{{item.cdrq}}&nbsp;&nbsp;等级：{{item.pj}}</p>
                            <p>里程：{{item.bxlc}}万公里&nbsp;&nbsp;排放：{{item.pfbz}}</p>
                        </td>
                        <td>
                            <span class="fs16 ccheng ml10" v-if="item.dealPrice">{{item.dealPrice}}</span>
                            <span class="fs16 ccheng ml10" v-else="item.dealPrice">未成交</span>
                        </td>
                        <td class="pl20">2017/07/26 15:43</td>
                    </tr>
                    </tbody>
                </table>
                <%--<div id="pagination" class="pageinfo" style="  display: block;">
                    <ul class="pages">
                        <li>
                            <span class="beginEnd">首页</span>
                        </li>
                        <li>
                            <span class="beginEnd">上一页</span>
                        </li>
                        <li>
                            <span class="current">1</span>
                        </li>
                        <li>
                            <a>2</a>
                        </li>
                        <li><a>3</a></li>
                        <li><a>4</a></li>
                        <li><a>5</a></li>
                        <li class="dotted">...</li>
                        <li><a><span class="beginEnd">下一页</span></a></li>
                        <li><a><span class="beginEnd">末页</span></a></li>
                    </ul>
                </div>--%>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
<script type="text/javascript" src="/resources/main/js/timer.js"></script>
<script type="text/javascript">


    var vm = new Vue({
        el: '#app',
        data: {
            loading: true,
            list: [{id: '', modelName: '', zcd: '', cdrq: '', pj: '', pfzb: '', bxlc: 0}],
            list2: []
        },
        methods: {
            init() {
                var url = ''
                if (${from==1}) {
                    url = '/auction/mylist'
                } else if (${from==2}) {
                    url = '/auction/orderList'
                } else if (${from==3}) {
                    url = '/auction/bidRecordList'
                } else if (${from==4}) {
                    url = '/auction/likeCarList'
                }
                $.getJSON(url, function (d) {
                    if (d.status == 200) {
                        vm.list = d.data;
                    }
                    vm.loading = false;
                })
            }, changePassword() {
                window.location.href = '/auction/personal/changePass';
            },mylist: function () {
                window.location.href = '/auction/personal/mylist';
            },orderList: function () {
                window.location.href = '/auction/personal/orderList';
            },bidRecordList: function () {
                window.location.href = '/auction/personal/bidRecordList';
            },likeCarList: function () {
                window.location.href = '/auction/personal/likeCarList';
            },personal:function () {
                window.location.href = '/personal';
            },yijian:function () {
                window.location.href = '/auction/personal/myyijian';
            }
        },
        mounted() {
            this.init();
        }
    })
</script>
</body>
</html>
