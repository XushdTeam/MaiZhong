<!DOCTYPE HTML>
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>迈众汽车CMS</title>
    <link href="/resources/layui/css/layui.css" rel="stylesheet"/>

    <link href="/resources/css/login.css" rel="stylesheet"/>
    <script src="/resources/layui/layui.js"></script>
</head>
<body>
<div class="layui-header header login-header">
    <div class="layui-main login-top-bg">
        <div class="sitename">
            <a class="logo" href="/">
                <img src="/resources/images/logo_s.png" alt="Upingwang"/>
            </a>
            <h2>迈众汽车CMS</h2>
        </div>
        <ul class="layui-nav login-top-menu">
            <li class="layui-nav-item site-nav-layim"><a href="">商城预留</a></li>
            <li class="layui-nav-item site-nav-layim"><a href="">APP下载预留</a></li>
            <li class="layui-nav-item site-nav-layim"><a href="">官方网站预留</a></li>
        </ul>
    </div>
</div>
<div class="login_content">
    <div id="regist">
        <div id="login-banner">
            <a href="#" target="_blank">
                <img src="/resources/images/mhdcity.jpg">
            </a>
        </div>
        <div id="login">
            <form class="layui-form layui-form-pane" id="sign-in" method="post" role="form">
                <p>
                <div class="layui-form-item">
                    <label class="layui-form-label">账号</label>
                    <div class="layui-input-block">
                        <input name="userPhone" lay-verify="required" autocomplete="off" placeholder="请输入账号" value=""
                               class="layui-input" type="text">
                    </div>
                </div>
                </p>
                <p>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input name="password" lay-verify="required" autocomplete="off" placeholder="请输入密码" value=""
                               class="layui-input" type="password">
                    </div>
                </div>
                </p>
                <p>
                <div class="layui-form-item">
                    <label class="layui-form-label">验证码</label>
                    <div class="layui-input-block">
                        <input id="user_code" class="layui-input input" lay-verify="required" name="verifyCode" value=""
                               size="4" maxlength="4" type="text">
                    </div>
                </div>
                </p>
                <p class="forgetmenot" style="float: left">
                    <input name="remember" title="记住密码" type="checkbox">
                    <div class="layui-input-block" style="margin-left: 0px !important;float: right">
                    <img src="/verifyCode" onclick="this.src='/verifyCode?'+Math.random()"
                         title="点击图片刷新验证码" width="80" height="30"/>
                    </div>
                </p>
                <p class="submit">
                <div class="layui-form-item">
                    <a class="layui-btn" lay-submit  lay-filter="btnsubmit">登　陆</a>
                </div>
                </p>
                <p id="nav">
                    忘记密码 or 没有账号？请联系管理修改。
                </p>
            </form>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!--Foot-->
<jsp:include page="common/foot.jsp"/>
<!-- js脚本 -->
<script type="text/javascript">
    layui.config({
        base: '/resources/js/'
    }).use('auth',function () {
        layui.auth.init();
    });
</script>
<!-- js脚本结束 -->
</body>
</html>