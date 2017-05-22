<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/01 0018
  Time: 上午 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Language" content="zh-cn" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta name="author" content="Xushd" />
    <meta name="Copyright" content="MaiZhongCar" />
    <meta name="viewport" content="width=device-width, maximum-scale=1.0, initial-scale=1.0,initial-scale=1.0,user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <title>迈众汽车CMS</title>
    <link href="/resources/layui/css/layui.css" rel="stylesheet" />
    <link href="/resources/Font-Awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="/resources/css/global.css" rel="stylesheet" />
    <script src="/resources/layui/layui.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header header header-admin">
        <div class="layui-main">
            <div class="fhuaui-logo">
                <a class="logo" href="#">
                    <img src="/resources/images/logo.png" height="40" alt="MaiZhongCar" />
                </a>
            </div>
            <ul class="layui-nav" id="menu">
                <%--<li class="layui-nav-item">
                    <a href="javascript:;" data-fid="85">
                        <i class="fa1 fa-send-o"></i>
                        <cite>站点</cite>
                    </a>
                </li>
                <li class="layui-nav-item ">
                    <a href="javascript:;" data-fid="99">
                        <i class="fa1 fa-cube"></i>
                        <cite>应用</cite>
                    </a>
                </li>--%>
                <li class="layui-nav-item ">
                    <a href="javascript:;" data-fid="7">
                        <i class="fa1 fa-institution"></i>
                        <cite>商城功能</cite>
                    </a>
                </li>
                <shiro:hasAnyRoles name="admin,dev">
                    <li class="layui-nav-item ">
                        <a href="javascript:;" data-fid="2">
                            <i class="fa1 fa-television"></i>
                            <cite>系统</cite>
                        </a>
                    </li>
                </shiro:hasAnyRoles>
            </ul>
            <ul class="layui-nav admin-header-item site-nav-layim" >
                <li class="layui-nav-item ">
                    <a href="javascript:;" class="avatar">
                        <img src="${userAdvert}" />
                        <span>${userName}</span>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;"><i class="fa fa-user-circle" aria-hidden="true"></i> 个人信息</a>
                        </dd>
                        <dd>
                            <a href="javascript:;" class="do-action" data-type="doLock" aria-hidden="true" ><i class="fa fa-lock" aria-hidden="true"></i> 锁屏</a>
                        </dd>
                        <dd>
                            <a href="javascript:;" class="do-action" data-type="doLoginOut" data-href="/logOut"  aria-hidden="true"><i class="fa fa-dot-circle-o" aria-hidden="true"></i> 退出</a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div id="sidebar-side" class="layui-side layui-bg-black">
        <div id="admin-navbar-side" class="layui-side-scroll" lay-filter="side">
        </div>
    </div>
    <div id="admin-body" class="layui-body" style="bottom: 0;">
        <div class="layui-tab layui-tab-card admin-nav-card larry-tab-box" lay-filter="admin-tab">
            <ul class="layui-tab-title" id="admin-tab">
                <li class="layui-this">
                    <i class="layui-icon" style="top: 2px; font-size: 16px;">&#xe609;</i>
                    <cite>迈众汽车CMS</cite>
                </li>
            </ul>
            <div class="layui-tab-content" id="admin-tab-container" style="min-height: 150px; padding: 0px;">
                <div class="layui-tab-item layui-show">
                    <iframe name="mainframe" frameborder="0" src="Center.html"></iframe>
                </div>
            </div>
        </div>
    </div>
    <!-- 锁屏模板start -->
    <script type="text/template" id="lock-temp">
        <div class="admin-header-lock" id="lock-box">
            <div class="admin-header-lock-img">
                <img src="${userAdvert}"/>
            </div>
            <div class="admin-header-lock-name" id="lockUserName">${userName}</div>
            <input type="text" class="admin-header-lock-input" value="输入密码解锁.." name="lockPwd" id="lockPwd" />
            <button class="layui-btn layui-btn-small" id="unlock">解锁</button>
        </div>
    </script>
    <!--锁屏模板 end -->
    <jsp:include page="common/foot.jsp"/>
</div>
<!-- js脚本 -->
<script type="text/javascript" src="/resources/js/event.js"></script>
<script type="text/javascript">
    layui.use('admin',function () {
        layui.admin.init();
    });
</script>
<!-- js脚本开始 -->
    <div>
    <audio id="chatAudio">
    <source src="/resources/voice/notify.mp3" type="audio/mpeg">
    </audio>
    </div>

    <script type="text/javascript" src="/resources/js/event.js"></script>
    <script type="text/javascript">
    layui.use('layer', function(){ //独立版的layer无需执行这一句
    var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

    //触发事件
    var active = {
    setTop: function(innerHTML,Owidth,Oheight){
    var that = this;
    //多窗口模式，层叠置顶
    layer.open({
    type: 1
    ,title: '您有新订单了'
    ,area: ['200px', '130px']
    ,shade: 0
    ,maxmin: false
    ,offset: [
    Oheight
    ,($(window).width()-Owidth)
    ]
    ,content:innerHTML
    //,btn: ['全部关闭'] //只是为了演示
   // ,yes: function(){
    //layer.closeAll();
   // }
    ,zIndex: layer.zIndex //重点1
    ,success: function(layero){
    layer.setTop(layero); //重点2
    }
    });
    }
    };

    var websocket = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
    websocket = new WebSocket("ws://localhost:8085/websocket");
    }
    else {
    alert('当前浏览器 不支持订单监控，请更换浏览器')
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {
    setMessageInnerHTML("订单监控连接失败，请稍后刷新重试或更换浏览器");
    };

    //连接成功建立的回调方法
  //  websocket.onopen = function () {
  //  setMessageInnerHTML("");
 //   }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
    setMessageInnerHTML(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
    setMessageInnerHTML("WebSocket连接关闭");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
    closeWebSocket();
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
    if(innerHTML){
    $('#chatAudio')[0].play(); //播放声音
    var wind= $('.layui-layer-content').length;
    var Owidth=200;
    var num= Math.floor(wind / 4);
    if(wind>=4){
    Owidth=200+num*200;
    wind=wind-num*4;
    }
    active["setTop"].call(this,innerHTML,Owidth,155*wind)};
    }

    //关闭WebSocket连接
    function closeWebSocket() {
    websocket.close();
    }
    });
    </script>



</body>
</html>