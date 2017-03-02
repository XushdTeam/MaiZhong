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
                    <a href="javascript:;" data-fid="3">
                        <i class="fa1 fa-institution"></i>
                        <cite>学校</cite>
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
                            <a href="javascript:;"><i class="fa fa-gear" aria-hidden="true"></i> 设置</a>
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
                <img src="/resources/images/0.jpg"/>
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
<!-- js脚本结束 -->
</body>
</html>
