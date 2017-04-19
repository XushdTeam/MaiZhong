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
    <link rel="stylesheet" type="text/css" href="/resources/css/rili.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/js.js" type="text/javascript"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=N8kgZsufZYtKgEXbtUoTHrKlaqgAxTFY"></script>
</head>
<body>
<div class="top e_top">
    <div class="t_cen">
        <a href="#"><img src="../resources/img/logo.png"></a>
        <span class="tell">010-3993-394</span>
        <span class="t_right"><a href="" class="one">我要卖车</a><a href="" class="one">登录</a><a href="" class="two">APP下载</a></span>
    </div>
</div><!--top end-->

<div class="x_nav">当前位置 :  <a href="#">首页</a> > <a href="#">二手车评估</a> > 预约</div>

<div class="yuyue">
    <div class="left">
        <h1><span>1</span>预约方式</h1>
         <dl class="dl1">
             <dt class="dt1"> </dt>
             <dd class="dd1">门店回收</dd>
             <dd>24小时内到店交易 必中现金大奖</dd>
         </dl>

        <dl class="dl2">
            <dt class="dt2"> </dt>
            <dd class="dd1">上门回收</dd>
            <dd>免费上门服务，提前预约</dd>
        </dl>
       <div class="clear"></div>
        <div class="xk xk1">
            <h1><span>2</span>选择门店</h1>
            <div class="x_left">
                <ul>
                    <li>全部门店</li>
                    <li>丰台区</li>
                    <li>大兴区</li>
                    <li class="active">朝阳区</li>
                    <li>昌平区</li>
                    <li>房山区</li>
                </ul>

            </div><!--xiao_left-->

            <div class="x_right">
                <div class="over">
                    <div class="x_dl">
                        <div class="x_dt"><input type="checkbox"></div>
                        <div class="x_dd x_dd1">北京朝阳大悦城店</div>
                        <div class="x_dd">北京市朝阳区朝阳北路101号地下一层（靠近地铁通道处）</div>
                    </div>

                    <div class="x_dl">
                        <div class="x_dt"><input type="checkbox"></div>
                        <div class="x_dd x_dd1">北京朝阳大悦城店</div>
                        <div class="x_dd">北京市朝阳区朝阳北路101号地下一层（靠近地铁通道处）</div>
                    </div>
                    <div class="x_dl">
                        <div class="x_dt"><input type="checkbox"></div>
                        <div class="x_dd x_dd1">北京朝阳大悦城店</div>
                        <div class="x_dd">北京市朝阳区朝阳北路101号地下一层（靠近地铁通道处）</div>
                    </div>

                    <div class="x_dl">
                        <div class="x_dt"><input type="checkbox"></div>
                        <div class="x_dd x_dd1">北京朝阳大悦城店</div>
                        <div class="x_dd">北京市朝阳区朝阳北路101号地下一层（靠近地铁通道处）</div>
                    </div>
                    <div class="x_dl">
                        <div class="x_dt"><input type="checkbox"></div>
                        <div class="x_dd x_dd1">北京朝阳大悦城店</div>
                        <div class="x_dd">北京市朝阳区朝阳北路101号地下一层（靠近地铁通道处）</div>
                    </div>

                    <div class="x_dl">
                        <div class="x_dt"><input type="checkbox"></div>
                        <div class="x_dd x_dd1">北京朝阳大悦城店</div>
                        <div class="x_dd">北京市朝阳区朝阳北路101号地下一层（靠近地铁通道处）</div>
                    </div>
                </div>
                <div style="width:400px;height:350px;border:#ccc solid 1px;font-size:12px" id="map"></div>


            </div><!--xiao_right-->
        </div><!--xk end-->
        <div class="clear"></div>
        <div class="xk xk2">
            <h1><span>2</span>取货方式</h1>
             <div class="quh">
                 <div class="qu"> <span>地铁取货</span> <span>上门取货</span></div>
                 <div class="d_1">
                     <div class="one one1">
                         <p>地铁线路</p>
                         <div onclick="cun();">地铁线路<img src="../resources/img/d.jpg"></div>

                     </div>

                     <div class="one">
                         <p>交易时间</p>
                          <div><input   type="date"> </div>
                     </div>
                     <div class="hid">
                         <span class="cun">1号线</span> <span>2号线</span> <span>4号线</span> <span>5号线</span> <span>6号线</span>
                         <span>7号线</span> <span>8号线</span> <span>9号线</span> <span>10号线</span> <span>14号线</span>
                         <span>13号线</span> <span>15号线</span> <span>房山线</span> <span>亦庄线</span> <span>八通线</span>
                         <span>昌平线</span>
                     </div>
                 </div>

                 <div class="d_1">
                    <div class="one one2">
                       <p>您的位置</p>
                        <input type="text" name="1" placeholder="请输入你的小区、大厦或街道名称 ">
                     </div>
                     <div class="one one3">
                         <p>详细地址</p>
                         <input type="text" name="1" placeholder=" ">
                     </div>
                     <div class="one">
                        <p>交易时间</p>
                         <div><input   type="date"> </div>
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
            <dt><img src="../resources/img/c_1.png"></dt>
            <dd>2016款 奥迪A3 Limousine 35 TFSI 进取型</dd>
            <dd class="dd2">￥450000</dd>
        </dl>
         <div class="clear"></div>
        <div>

           <p> 购买渠道: 大陆国行（有“进网许可”标签）</p>
            <p> 屏幕显示: 屏幕正常显示</p>
            <p> 触摸功能: 触摸功能不正常</p>
            <p> 拍摄功能: 拍照摄像正常</p>
            <p>  拆机维修史: 无拆机无维修</p>
            <p>  边框背板: 外壳完好（边框外壳完好无划痕磨损、无磕碰）</p>
            <p>  通话功能: 通话功能正常</p>
            <p>  开机情况: 开机正常</p>
            <p>  无线功能: 无线正常</p>
            <p>  屏幕外观: 屏幕完好（保护很好，屏幕无可见划痕）</p>
            <p>  机身是否弯曲: 机身无弯曲</p>
            <p>  受潮状况: 机身无进水</p>
        </div>
    </div><!--right end -->
</div>
</body>

<script type="text/javascript">
    //创建和初始化地图函数：
    function initMap(){
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addMapOverlay();//向地图添加覆盖物
    }
    function createMap(){
        map = new BMap.Map("map");
        map.centerAndZoom(new BMap.Point(116.403963,39.915119),15);
    }
    function setMapEvent(){
        map.enableScrollWheelZoom();
        map.enableKeyboard();
        map.enableDragging();
        map.enableDoubleClickZoom()
    }
    function addClickHandler(target,window){
        target.addEventListener("click",function(){
            target.openInfoWindow(window);
        });
    }
    function addMapOverlay(){
        var markers = [
            {content:"我的备注",title:"我的标记",imageOffset: {width:0,height:3},position:{lat:39.924305,lng:116.402526}}
        ];
        for(var index = 0; index < markers.length; index++ ){
            var point = new BMap.Point(markers[index].position.lng,markers[index].position.lat);
            var marker = new BMap.Marker(point,{icon:new BMap.Icon("http://api.map.baidu.com/lbsapi/createmap/images/icon.png",new BMap.Size(20,25),{
                imageOffset: new BMap.Size(markers[index].imageOffset.width,markers[index].imageOffset.height)
            })});
            var label = new BMap.Label(markers[index].title,{offset: new BMap.Size(25,5)});
            var opts = {
                width: 200,
                title: markers[index].title,
                enableMessage: false
            };
            var infoWindow = new BMap.InfoWindow(markers[index].content,opts);
            marker.setLabel(label);
            addClickHandler(marker,infoWindow);
            map.addOverlay(marker);
        };
    }
    //向地图添加控件
    function addMapControl(){
        var scaleControl = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
        scaleControl.setUnit(BMAP_UNIT_IMPERIAL);
        map.addControl(scaleControl);
        var navControl = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
        map.addControl(navControl);
        var overviewControl = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:true});
        map.addControl(overviewControl);
    }
    var map;
    initMap();
</script>
</html>
