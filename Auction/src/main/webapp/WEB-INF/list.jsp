<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/31
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>交易大厅</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="nav.jsp" %>
<div id="app" class="w1200 mauto" style="z-index: 1000;min-height: 650px;" v-loading="loading" v-cloak
     element-loading-text="努力加载中">
    <div class="clearad"></div>
    <div class="w1200  norFont">
        <div class="lineBid">
            <b>在线竞价<span id="allCount">{{list.length}}</span>辆</b>
        </div>
        <div class="liatMain bor1e2 bort0" >
            <div class="carMains cursor" type="0" v-for="(item,index) in list" @click="detail(item)">
                <div class="carImg end ">
                    <div class="mask" :class="{'hide':!item.over}">已结束</div>
                    <i class="smallIcon  "></i>
                    <img :src="item.zq45">
                </div>
                <div class="carMes">
                    <h3>[{{item.zcd}} {{item.number}}] {{item.modelName}}</h3>
                    <p class="mes"><span>{{item.cdrq}}</span>&nbsp;|&nbsp;<span>{{item.bxlc}}万公里</span></p>
                    <p class="sign">
                        <span class="dj">{{item.pj}}</span>
                        <span class="dj">{{item.pfbz}}</span>
                        <span class="gh" v-show="item.auctionCount==1">首次上拍</span>
                    </p>
                </div>
                <div class="carNum">
                    <p class="endTime">距结束
                        <count-down :cur-time="item.nowTime" :end-time="item.overTime" v-on:end_callback="timeOver(index)" end-text="已结束"></count-down>
                    </p>
                    <div class="price"><span>{{item.nowPrice}}</span><em>万</em></div>
                    <p class="baoliu">保留价{{item.savePrice}}万</p>
                </div>
                <div class="doSt">
                    <a href="javascript:void(0);" class=" track ">
                        <span v-if="item.imMyLike" @click="likeCancle(index,1)">取消关注</span>
                        <span v-else @click="like(index,1)">关注</span>
                        <em class="">(<i>{{item.likeCounts}}</i>)</em>
                    </a>
                    <a href="javascript:void(0);" class=" track ">
                        <span v-if="item.myAuction" style="color: #006e29">已参与竞价</span>
                        <span v-else>我未出价</span>
                    </a>
                </div>
                <div class="doSt">

                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    <div class="clearad"></div>
    <div class="w1200  norFont">
        <div class="lineBid">
            <b>即将上拍</b>
        </div>
        <div class="liatMain bor1e2 bort0">
            <div class="carMains cursor" type="0" v-for="(item,index) in list2" @click="detail(item)">
                <div class="carImg end ">
                    <img :src="item.zq45">
                </div>
                <div class="carMes">
                    <h3>[{{item.zcd}} {{item.number}}] {{item.modelName}}</h3>
                    <p class="mes"><span>{{item.cdrq}}</span>&nbsp;|&nbsp;<span>{{item.bxlc}}万公里</span></p>
                    <p class="sign">
                        <span class="dj">{{item.pj}}</span>
                        <span class="dj">{{item.pfbz}}</span>
                        <span class="gh" v-show="item.auctionCount==1">首次上拍</span>
                    </p>
                </div>
                <div class="carNum">
                    <p class="endTime">

                    </p>
                    <div class="price"><span >{{item.nowPrice}}</span><em>万</em></div>
                    <p class="baoliu">保留价{{item.savePrice}}万</p>
                </div>
                <div class="doSt">
                    <a href="javascript:void(0);" class=" track ">
                        <span v-if="item.imMyLike" @click="likeCancle(index,2)">取消关注</span>
                        <span v-else @click="like(index,2)">关注</span>
                        <em class="">(<i>{{item.likeCounts}}</i>)</em>
                    </a>
                </div>

                <div class="doSt">
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
</div>
<div class="clearad"></div>
<%@ include file="footer.jsp" %>
<script type="text/javascript" src="/resources/main/js/timer.js"></script>
<script type="text/javascript" src="/resources/main/js/listindex.js"></script>
</body>
</html>
