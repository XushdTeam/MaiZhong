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
    <link rel="stylesheet" type="text/css" href="/resources/font/iconfont.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js" type="text/javascript"></script>
    <script src="/resources/js/js.js"></script>
</head>
<body>

<div class="top e_top">
    <div class="t_cen">
        <a href="/" class="logo"><img src="/resources/img/logo.png"></a>
        <ul class="t_right">
            <li><a href="/" target="_blank">首页</a></li>

            <li><a href="/sale"target="_blank">我要卖车</a></li>
            <li><a href="/join"target="_blank">销售商加盟</a></li>
            <li><a href="/app"target="_blank">APP下载</a></li>
            <li><a href="/help"target="_blank">帮助中心</a></li>
            <li style="display: none;" id="user_li"><a href="/per/or"  target="_blank">个人中心</a></li>
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

<div class="A_colocr">
    <div class="X_con">
        <h2>文章详情</h2>
        <div class="x_left">
           ${content.content}
        </div>
    </div><!--X_con-->
</div>

<div class="cj" style="margin-top: -40px;">
    <div class="cj_cen" id="owl-example" >


        <script id="list-car-tmpl" type="text/x-dot-template">
            <h2>热收车型</h2>
            {{ for(var i=0,len=it.length;i<len; i++) { }}
            <div class="owl-item">
                <a href="/sale/{{=it[i].paramId}}"  title="{{=it[i].title}}">
                    <div class="item darkCyan">
                        <img src="{{=it[i].img}}">
                        <h3>{{=it[i].title}}</h3>
                        <p>{{=it[i].param}}</p>
                        <h4>{{=it[i].price}}</h4>
                    </div>
                </a>
            </div>
            {{ } }}
        </script>





    </div>
</div>


<!--中间部分end-->
<%@include file="footer.jsp"%>
<script src="/resources/js/doT.min.js"></script>
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
    //数组排序
    var shuffle = function(v){
        for(var j, x, i = v.length; i; j = parseInt(Math.random() * i), x = v[--i], v[i] = v[j], v[j] = x);
        return v;
    };
    function exit(){
        $.cookie("phone",null,{path:"/"});
        $.cookie("token",null,{path:"/"});
        window.location.reload()
    }
    $(function () {
        $.getJSON('/resources/data/hotcar.json',function(d){
            var carevalText = doT.template($("#list-car-tmpl").text());
            d = shuffle(d)
            $("#owl-example").html(carevalText(d));

        })
    })
</script>
</body>
</html>
