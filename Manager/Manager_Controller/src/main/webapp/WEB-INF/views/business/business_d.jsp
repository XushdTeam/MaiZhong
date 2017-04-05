<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/4/5
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../common/head.jsp"/>
    <style type="text/css">
        body, html, #allmap {
            width: 100%;
            height: 100%;
            overflow: hidden;
            margin: 0;
            font-family: "微软雅黑";
        }

    </style>
    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=2.0&ak=N8kgZsufZYtKgEXbtUoTHrKlaqgAxTFY"></script>
    <title>详情页</title>
</head>
<body>
<div class="main-wrap" data-href="/business">
<div id="business">
    <table>
        <tr>
            <td>店铺名称:</td>
            <td><span>${business.businessName}</span></td>
        </tr>
        <tr>
            <td>店铺地址:</td>
            <td><span>${business.address}</span></td>
        </tr>
        <tr>
            <td>负责人:</td>
            <td><span>${business.linkman}</span></td>
        </tr>
        <tr>
            <td>手机号:</td>
            <td><span>${business.mobilePhone}</span></td>
        </tr>
        <tr>
            <td>座机 :</td>
            <td><span>${business.telephone}</span></td>
        </tr>
        <tr>
            <td>邮箱:</td>
            <td><span>${business.email}</span></td>
        </tr>
    </table>
</div>
<div id="allmap" style="width: 1200px;height: 600px"></div>
</div>
</body>
</html>
<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");    // 创建Map实例
    var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
    var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
    map.centerAndZoom(new BMap.Point(${business.location}), 18);  // 初始化地图,设置中心点坐标和地图级别
    map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
    map.setCurrentCity("北京");          // 设置地图显示的城市 此项是必须设置的
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
    map.addControl(top_left_control);
    map.addControl(top_left_navigation);

    var point = new BMap.Point(${business.location});
    var marker = new BMap.Marker(point);  // 创建标注
    map.addOverlay(marker);              // 将标注添加到地图中
    map.panTo(point);
</script>
<script type="text/javascript" src="/resources/js/event.js"></script>
<script type="text/javascript">
    layui.use("app",function(){
        app = layui.app;
        app.fixBar();
    });
</script>

