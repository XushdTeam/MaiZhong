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
<div class="bg_imgq"> </div>
<!--banner end-->
<!--头end-->


<!--四个优势-->
<div class="ys">
   <dl>
       <dt><img src="../resources/img/ys_05.jpg"></dt>
       <dd class="dd1">二手车收购专家</dd>
       <dd>悟空收车给你更专业的服务</dd>
   </dl>

    <dl>
        <dt><img src="../resources/img/ys_12.jpg"></dt>
        <dd class="dd1">全新卖车方式</dd>
        <dd>直接线上成交 省时、省力、省心</dd>
    </dl>

    <dl>
        <dt><img src="../resources/img/ys_07.jpg"></dt>
        <dd class="dd1">不挑车</dd>
        <dd>悟空收车不挑车合法合规均收购</dd>
    </dl>

    <dl>
        <dt><img src="../resources/img/ys_09.jpg"></dt>
        <dd class="dd1">速度</dd>
        <dd>最快当天成交，当天付款</dd>
    </dl>
</div>
<!--四个优势 end-->


<div class="bg_ys">
    <div class="ys_cen">
         <div class="ys_left">
             <h2>成交快</h2>
             <p>选择太多 没时间等，网上提交订单，
                 悟空收车直接收购，分分钟成交。</p>
         </div>
        <div class="ys_right">
            <img src="../resources/img/ys_1.jpg">
            <img src="../resources/img/ys_2.jpg">
        </div>
    </div>
</div>
<div class="bg_none">
    <div class="ys_cen">

        <div class="ys_right">
            <img src="../resources/img/ys_3.jpg">
            <img src="../resources/img/ys_4.jpg">
        </div>

        <div class="ys_left">
            <h2>价格高</h2>
            <p>海量的收购数据、精准的市场估价，平均比市场多卖10%~20%
                2000万 +用户卖车的第一选择
            </p>
        </div>

    </div>
</div>


<div class="bg_ys">
    <div class="ys_cen">
        <div class="ys_left">
            <h2>超省心</h2>
            <p>一站式服务，足不出户，省时省心</p>
        </div>
        <div class="ys_right">
            <img src="../resources/img/ys_5.jpg">
            <img src="../resources/img/ys_6.jpg">
        </div>
    </div>
</div>



<div class="bg_none">
    <div class="ys_cen">

        <div class="ys_right">
            <img src="../resources/img/ys_7.jpg">
            <img src="../resources/img/ys_8.jpg">
        </div>

        <div class="ys_left">
            <h2>有保障</h2>
            <p>放心卖车，安全有我 </br> 一对一服务，全程可视
            </p>
        </div>

    </div>
</div>

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

</body>
</html>