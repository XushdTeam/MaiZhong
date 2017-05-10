<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/3
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/resources/font/iconfont.css" />
    <script src="/resources/js/js.js"></script>
</head>
<body>
<div class="top e_top">
    <div class="t_cen">
        <a href="#" class="logo"><img src="../resources/img/logo.png"></a>
        <ul class="t_right">
            <li><a href="#" class="hover">首页</a></li>
            <li><a href="/sale">我要卖车</a></li>
            <li><a href="#">销售商加盟</a></li>
            <li><a href="#">app下载</a></li>
            <li><a href="#">帮助中心</a></li>
            <li><a href="#">个人中心</a></li>
            <li><a href="/per/or"  id="user" style="display:none">188****8888</a></li>
        </ul>
        <ul class="lon">
            <li ><i class="iconfont icon ">&#xe6a3;</i><a href="/login"  id="login">登录</a>/<a href="/login"  id="">注册</a></li>
            <li><a href="javascript:void(0)" class="two" id="exit" style="display:none" onclick="exit();">退出</a></li>
        </ul>
    </div>
</div><!--top end-->
<!--中间部分-->

<div class="A_colocr">
    <div class="X_con">
        <h2>文章详情</h2>
        <div class="x_left">
            <h3>如何界定“事故车”</h3>
            <span class="clock">时间: 2017-03-03 / 作者:兽鬼乌拉</span>
            <div>如何界定事故车？哪些损伤算是事故车？事故车到底能不能买等等。一辆车的结构部件（文中所指：纵梁、悬架系统、前后防撞钢梁、吸能盒等核心框架）、车架（车身骨架、结构部件，不含外观覆盖件），这些部分如果因为碰撞导致拉伸、形变、损坏的情况（在受到冲击时，结构部件表面也许看不出明显损伤，但是很可能伤害已经分散到车架的其它部位），就可以算是事故车了。</div>
            <div>这样的车辆不建议大家购买。一旦结构部件部分受损，就算通过拉伸、敲打或者其它方式修复了，也无法恢复其整体的车身刚性，如果再次发生碰撞很可能就会“散架”了。


                反之，如果是车身的覆盖件受损或发生碰撞，只要没有伤及结构部件的部分，就不会影响行驶安全，就算修复过或者更换过也没事。可以将覆盖件理解为车辆的“外衣”，损坏后可以通过更换原厂配件来进行更换，而结构部件则不同，不能随便就拆下进行更换，一旦受损就是不可逆的。两者的区别大家要搞清楚。
            </div>

            <!--ul class="x_foot">
               <li><a href="#">上一篇：全家出行无忧 3款合资中型SUV推荐</a></li>
               <li><a href="#">下一篇：都是畅销榜常客 3款紧凑型SUV推荐</a></li>
            </ul-->
        </div>

        <%--<div class="x_right">--%>
            <%--<h2>热销车系</h2>--%>
            <%--<dl>--%>
                <%--<a href='#'>--%>
                    <%--<dt><img src="img/x_5.jpg"></dt>--%>
                    <%--<dd>大众 夏明</dd>--%>
                    <%--<dd class="dd1">￥13.4~16.4万</dd>--%>
                <%--</a>--%>
            <%--</dl>--%>
            <%--<dl>--%>
                <%--<a href='#'>--%>
                    <%--<dt><img src="img/x_5.jpg"></dt>--%>
                    <%--<dd>大众 夏明</dd>--%>
                    <%--<dd class="dd1">￥13.4~16.4万</dd>--%>
                <%--</a>--%>
            <%--</dl>--%>
            <%--<dl>--%>
                <%--<a href='#'>--%>
                    <%--<dt><img src="img/x_5.jpg"></dt>--%>
                    <%--<dd>大众 夏明</dd>--%>
                    <%--<dd class="dd1">￥13.4~16.4万</dd>--%>
                <%--</a>--%>
            <%--</dl>--%>
            <%--<dl>--%>
                <%--<a href='#'>--%>
                    <%--<dt><img src="img/x_5.jpg"></dt>--%>
                    <%--<dd>大众 夏明</dd>--%>
                    <%--<dd class="dd1">￥13.4~16.4万</dd>--%>
                <%--</a>--%>
            <%--</dl>--%>
            <%--<dl>--%>
                <%--<a href='#'>--%>
                    <%--<dt><img src="img/x_5.jpg"></dt>--%>
                    <%--<dd>大众 夏明</dd>--%>
                    <%--<dd class="dd1">￥13.4~16.4万</dd>--%>
                <%--</a>--%>
            <%--</dl>--%>

        <%--</div>--%>
    </div><!--X_con-->
</div>
<!--中间部分end-->
</body>
</html>
