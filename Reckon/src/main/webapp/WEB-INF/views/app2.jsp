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
    <title>悟空收车</title>
    <meta name="keywords" content="悟空收车，悟空，二手车，估值，收购"/>
    <meta name="description" content="悟空收车专业的二手车估值收购平台，验车快，当天到账，售后跟踪"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/sp.css" />
    <link rel="stylesheet" type="text/css" href="/resources/font/iconfont.css" />

    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js"></script>
    <script src="/resources/js/js.js"></script>
    <script language="javascript">
        function imgdragstart(){return false;}
    </script>
</head>
<body>
<!--头部开始-->
<div class="top e_top">
    <div class="t_cen">
        <a href="/" class="logo"><img src="/resources/img/logo.png"></a>
        <ul class="t_right">
            <li><a href="/" target="_blank">首页</a></li>
            <li><a href="/sale" target="_blank">我要卖车</a></li>
            <li><a href="/join" target="_blank">销售商加盟</a></li>
            <li><a href="/app" class=" <c:if test="${key=='app'}">hover</c:if>"  >APP下载</a></li>
            <li><a href="/help" target="_blank">帮助中心</a></li>
            <li style="display: none;" id="user_li"><a href="/per/or" target="_blank" >个人中心</a></li>
        </ul>
        <ul class="lon" style="margin-top: 0px;">
            <li >
                <i class="iconfont icon ">&#xe6a3;</i>
                <a href="/login"  id="user">登录</a>
            </li>
            <li>
                <a href="javascript:void(0)" class="two" id="exit" style="display:none" onclick="exit();">退出</a>
            </li>
            <li >
                <img src="/resources/img/erwei.jpg" onmouseover="javascript:$('#erw').show()" onmouseleave="javascript:$('#erw').hide()" >
                <div style="display: none;position: absolute;z-index: 1989" id="erw">
                    <img src="/resources/img/m_11.jpg" width="150" >
                </div>
            </li>
        </ul>
    </div>
</div><!--top end-->

<!--banner-->
<div class="bg_imgfs">
    <div class="app_cen">
        <h2>悟空收车APP</h2>
        <p class="app_p">手机卖车，一键搞定，卖车就是这么简单！</p>
        <div class="app_x">
            <div>
                <button><img src="/resources/img/a_03.jpg">iphone</button>
                <button><img src="/resources/img/a_06.jpg">Android</button>
            </div>
            <p><img src="../resources/img/m_11.jpg"></p>
        </div>
    </div>
</div>
<!--banner end-->
<!--头end-->


<div class=" apps bg_none">
    <div class="ys_cen">
        <div class="ys_left">
            <h2>随时关注爱车</br>
                价格动态</h2>

        </div>
        <div class="ys_right">
            <img src="../resources/img/s_11.jpg">

        </div>
    </div>
</div>
<div class="bg_ys apps apps2">
    <div class="ys_cen">

        <div class="ys_right">

            <img src="../resources/img/s_15.jpg">
        </div>

        <div class="ys_left">
            <h2>最新优惠活动</br>
                一手掌握</h2>

        </div>

    </div>
</div>


<!--四个优势-->
<div class="ys app_you">
    <h2>随时随地卖车</h2>
    <dl>
        <dt><i class="icon iconfont icon-search"></i></dt>
        <dd class="dd1">1、搜索车型</dd>

    </dl>

    <dl>
        <dt><i class="icon iconfont icon-stop"></i></dt>
        <dd class="dd1">2、获得报价</dd>

    </dl>

    <dl>
        <dt><i class="icon iconfont icon-cart"></i></dt>
        <dd class="dd1">3、提交订单</dd>

    </dl>

    <dl>
        <dt><i class="icon iconfont icon-huanhuobz"></i></dt>
        <dd class="dd1">4、急速到账</dd>

    </dl>
</div>
<!--四个优势 end-->

<!--优势 end-->
<div class="clear"></div>
<%@include file="footer.jsp"%>
<script>
    $(document).ready(function() {

        var phone = $.cookie('phone');
        var token = $.cookie('token');
        if(phone&&token){
            $.getJSON('/loginByToken/'+phone+'/'+token,function (d) {
                if(d.status==200){
                    $("#login").hide();

                    var pre = phone.substring(0,3),pbc = phone.substring(8,11);
                    $('#user').html(pre+'****'+pbc).show();
                    $('#exit').show();

                    $('#user').attr('href','/per/or')
                    $("#user_li").show();
                }else{
                    $.cookie("phone",null,{path:"/"});
                    $.cookie("token",null,{path:"/"});
                }
            })
        }


    })
    function exit(){
        $.cookie("phone",null,{path:"/"});
        $.cookie("token",null,{path:"/"});
        window.location.reload()
    }
</script>


<script language="javascript">
    for(i in document.images)document.images[i].ondragstart=imgdragstart;
</script>

</body>
</html>