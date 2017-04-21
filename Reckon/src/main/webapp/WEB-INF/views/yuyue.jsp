<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/19
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/guzhi.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/site.css" />

    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/js.js" type="text/javascript"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=N8kgZsufZYtKgEXbtUoTHrKlaqgAxTFY"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="x_nav">当前位置 :  <a href="#">首页</a> > <a href="#">二手车评估</a> > 预约</div>

<div class="yuyue">
    <div class="left">
        <h1><span>1</span>验车方式</h1>
        <dl class="dl1">
            <dt class="dt1"> </dt>
            <dd class="dd1">门店验车</dd>
            <dd>24小时内到店交易 必中现金大奖</dd>
        </dl>

        <dl class="dl2">
            <dt class="dt2"> </dt>
            <dd class="dd1">上门验车</dd>
            <dd>免费上门服务，提前预约</dd>
        </dl>
        <div class="clear"></div>
        <div class="xk xk1">
            <h1><span>2</span>选择门店</h1>
            <div class="x_left">
                <ul>
                    <li>全部门店</li>
                    <c:forEach items="${shop}" var="item">
                        <li>${item.name}</li>
                    </c:forEach>

                </ul>
            </div>
            <div class="x_right">
                <div class="over">
                    <ul id="outlets-list" class="outlets-list scrollbar">
                        <li data-shop-id="28"
                            data-longitude="116.42575000"
                            data-latitude="39.90450000"
                            style="display: list-item;">
                            <p class="outlets-name">北京国瑞店</p>
                            <p class="outlets-addr">北京市东城区崇外大街18号国瑞购物中心B2层</p>
                        </li>
                        <li data-shop-id="28"
                            data-longitude="116.42575000"
                            data-latitude="39.90450000"
                            style="display: list-item;">
                            <p class="outlets-name">北京国瑞店</p>
                            <p class="outlets-addr">北京市东城区崇外大街18号国瑞购物中心B2层</p>
                        </li>
                    </ul>
                </div>
            </div><!--xiao_right-->
            <div class="baidumap" id="map"></div>
        </div><!--xk end-->
        <div class="clear"></div>
        <div class="xk xk2">
            <h1><span>2</span>验车方式</h1>
            <div class="quh">
                <div class="qu"> <span>地铁附近</span> <span>上门验车</span></div>
                <div class="d_1">
                    <div class="one one1">
                        <p>地铁线路</p>
                        <div id="lineInput">地铁线路<img src="../resources/img/u.jpg"></div>
                    </div>

                    <div class="one">
                        <p>预约时间</p>
                        <div id="dateInput">预约时间<img src="../resources/img/u.jpg"></div>
                    </div>
                    <div class="hid">
                        <c:forEach items="${lines}" var="item">
                            <span  data-id="${item.id}">${item.name}线</span>
                        </c:forEach>
                    </div>
                    <div class="hid1">
                        <span data-text="04-22 星期六" data-date="2017-04-22">04-22 <br> 星期六</span>
                        <span data-text="04-23 星期日" data-date="2017-04-23">04-23 <br> 星期日</span>
                        <span data-text="04-24 星期一" data-date="2017-04-24">04-24 <br> 星期一</span>
                        <span data-text="04-25 星期二" data-date="2017-04-25">04-25 <br> 星期二</span>
                        <span data-text="04-26 星期三" data-date="2017-04-26">04-26 <br> 星期三</span>
                        <span data-text="04-27 星期四" data-date="2017-04-27">04-27 <br> 星期四</span>
                        <span data-text="04-28 星期五" data-date="2017-04-28">04-28 <br> 星期五</span>
                    </div>
                </div>

                <div class="metro-station-wrap  clearfix ">
                    <div class="metro-station-content" id="lineSite">
                        <script id="list-tmpl" type="text/x-dot-template">
                            <ul style="margin-left: 0px;" id="ul_site">
                                {{ for(var i=0,len=it.length;i<len; i++) { }}
                                <li data-metro-station-id="{{=it[i].id}}">
                                    <div class="station-name">{{=it[i].name}}</div>
                                </li>
                                {{ } }}
                            </ul>
                        </script>
                    </div>

                </div>

                <div class="d_1">
                    <div class="one one3">
                        <p>详细地址</p>
                        <input type="text" name="1" placeholder=" ">
                    </div>
                    <div class="one">
                        <p>交易时间</p>
                        <div id="dateInput1">预约时间<img src="../resources/img/u.jpg"></div>
                    </div>
                    <div class="hid2">
                        <span data-text="04-22 星期六" data-date="2017-04-22">04-22 <br> 星期六</span>
                        <span data-text="04-23 星期日" data-date="2017-04-23">04-23 <br> 星期日</span>
                        <span data-text="04-24 星期一" data-date="2017-04-24">04-24 <br> 星期一</span>
                        <span data-text="04-25 星期二" data-date="2017-04-25">04-25 <br> 星期二</span>
                        <span data-text="04-26 星期三" data-date="2017-04-26">04-26 <br> 星期三</span>
                        <span data-text="04-27 星期四" data-date="2017-04-27">04-27 <br> 星期四</span>
                        <span data-text="04-28 星期五" data-date="2017-04-28">04-28 <br> 星期五</span>
                    </div>
                </div>
            </div>
        </div><!--xk end-->
        <div class="clear"></div>
        <h1><span>3</span>联系方式</h1>
        <div class="d_2">
            <div class="one one1">
                <p>输入姓名</p>
                <div><input type="text" name="1"> </div>
            </div>
            <div class="one">
                <p>输入手机号</p>
                <div><input type="tel" name="1"></div>
                <p>用来接受订单信息</p>
            </div>
        </div><!--d_2 end-->
        <div class="clear"></div>
        <div class="anniu">确认预约</div>
    </div><!--left end-->
    <div class="right">
        <dl>
            <dt><img src="${result.seriesImg}" width="100"></dt>
            <dd>${result.modelName}</dd>
            <dd class="dd2">￥${result.salePrice}万</dd>
        </dl>
        <div class="clear"></div>
        <div>
            <p> 上牌时间: ${result.regdate}</p>
            <p> 屏幕显示: ${result.city}</p>
            <p> 触摸功能: ${result.mail}</p>
            <p> 拍摄功能: ${result.ck}</p>
            <p> 拆机维修史: 无拆机无维修</p>
            <p> 边框背板: 外壳完好（边框外壳完好无划痕磨损、无磕碰）</p>
            <p> 通话功能: 通话功能正常</p>
            <p> 开机情况: 开机正常</p>
            <p> 无线功能: 无线正常</p>
            <p> 屏幕外观: 屏幕完好（保护很好，屏幕无可见划痕）</p>
            <p> 机身是否弯曲: 机身无弯曲</p>
            <p> 受潮状况: 机身无进水</p>
        </div>
    </div><!--right end -->
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="/resources/js/doT.min.js" type="text/javascript"></script>
<script type="text/javascript">



    $(function () {

        var evalText = doT.template($("#list-tmpl").text());
        $(".hid1 span").click(function () {
            $(this).addClass('checked').siblings().removeClass("checked");
            var text = $(this).data("text");
            $("#dateInput").html(text+'<img src="../resources/img/u.jpg">');
            $(".hid1").hide();
        });
        $(".hid2 span").click(function () {
            $(this).addClass('checked').siblings().removeClass("checked");
            var text = $(this).data("text");
            $("#dateInput1").html(text+'<img src="../resources/img/u.jpg">');
            $(".hid2").hide();
        });
        $(".hid span").click(function(){
            $(this).addClass('cun').siblings().removeClass("cun");
            var lineId = $(this).data("id");
            var lineName = $(this).html();
            $("#lineInput").html(lineName+'<img src="../resources/img/u.jpg">');
            $(".hid").hide();

            $.getJSON("/getSite/"+lineId,function (d) {
                if(d.status == 200){
                    $("#lineSite").html('');
                    $("#lineSite").html(evalText(d.data));
                    $(".metro-station-wrap").show();
                    var count = d.data.length;
                    var w = 35*count;
                    if(w>550){
                        $("#ul_site").css({"width":w+"px"}).parent().css({"overflow-x": "scroll"});
                    }else{
                        $("#ul_site").css({"width":w+"px"}).parent().css({"overflow-x": "hidden"});
                    }
                    $(".metro-station-content ul li").click(function(){
                        $(this).addClass("active").siblings().removeClass('active');
                    });

                }
            })


        });

        $("#lineInput").click(function () {
            $(this).html('地铁线路<img src="../resources/img/d.jpg">');
            $(".hid").show();
            $(".hid1").hide();
        })
        $("#dateInput").click(function () {
            $(this).html('预约时间<img src="../resources/img/d.jpg">');
            $(".hid1").show();
            $(".hid").hide();
        })
        $("#dateInput1").click(function () {
            $(this).html('交易时间<img src="../resources/img/d.jpg">');
            $(".hid2").show();

        })
        $(".x_left li").click(function(){
            $(this).addClass('active').siblings().removeClass("active");
        })
        initMap();
    });
    var initMap = function(){
        // 百度地图API功能
        var map = new BMap.Map("map");
        var point = new BMap.Point(116.417854,39.921988);
        var marker = new BMap.Marker(point);  // 创建标注
        map.addOverlay(marker);              // 将标注添加到地图中
        map.centerAndZoom(point, 15);
        map.enableScrollWheelZoom(true);
        var opts = {
            width : 200,     // 信息窗口宽度
            height: 100,     // 信息窗口高度
            title : "海底捞王府井店" , // 信息窗口标题
            enableMessage:true,//设置允许信息窗发送短息
            message:"亲耐滴，晚上一起吃个饭吧？戳下面的链接看下地址喔~"
        }
        var infoWindow = new BMap.InfoWindow("地址：北京市东城区王府井大街88号乐天银泰百货八层", opts);  // 创建信息窗口对象
        marker.addEventListener("click", function(){
            map.openInfoWindow(infoWindow,point); //开启信息窗口
        });
    }

</script>
</html>
