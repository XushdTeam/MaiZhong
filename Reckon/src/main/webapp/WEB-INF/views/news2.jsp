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
    <script src="/resources/js/slider.js"></script>
    <script language="javascript">
        function imgdragstart(){return false;}
    </script>
</head>
<body>

<div class="top e_top">
    <div class="t_cen">
        <a href="/" class="logo"><img src="/resources/img/logo.png"></a>
        <ul class="t_right">
            <li><a href="/" target="_blank" >首页</a></li>

            <li><a href="/sale" target="_blank">我要卖车</a></li>
            <li><a href="/join" target="_blank">销售商加盟</a></li>
            <li><a href="/app" target="_blank">APP下载</a></li>
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

<div class="A_colocr">
    <div class="X_con">
        <h2>文章详情</h2>
        <div class="x_left">
            <h3>这是一篇硬文︱因为悟空收车的优惠活动太多啦</h3>
            <p  style=" text-align: right; font-size: 17px; color: #999; width: 700px; margin: 20px 0">2017年5月18日 作者：小悟空</p>
            <p style=" text-align: center"><img src="/resources/img/r1.jpg"></p>
            <p class="MsoNormal" style="text-indent:24.1pt;vertical-align:baseline;">
                <b><span style="font-size:16px;line-height:50px; text-align: center; display: block">写在最前面，想快速成为悟空会员；</span></b>
                <span style="display: block; text-align: center;font-size: 24px"><a href="/login" style="color:#E53333; "> 请戳我</a></span>
            </p>
            <p style="display: block; text-align: center;font-size: 24px; line-height: 65px">在聊优惠之前我想问大家一个问题</p>
            <p style=" text-align: center"><img src="/resources/img/r4.jpg"></p>
            <p style=" text-align: center">就这个问题，身边的朋友们是这么说的：</p>
            <p style="width: 80%; text-align: center; margin: 20px auto">@康康康：第一次因为现实原因，放弃自己喜欢了很久的人。现在已经记不清她具体长什么样了，只有第一次约会的地方成为我心中最美好的风景。</p>
            <p style=" text-align: center; font-size: 24px; line-height: 65px">我的第一次  <span style="color:#f60">first time</span></p>
            <p style=" text-align: center"><img src="/resources/img/tu1.jpg"></p>
            <p style="text-align: center; font-size: 29px; line-height: 46px;color: #000; padding: 0 80px 0 0"><span style="font-size: 50px; font-family: '宋体'">“</span>从此这道风景成为我心中<p>
            <p style="text-align: center; font-size: 29px;line-height: 46px;color: #000; padding: 0 0 0 80px"> 永远也无法抹去的记忆<span style="font-size: 50px;font-family: '宋体">”</span></p>


            <p style="width: 80%; text-align: center; margin: 60px auto 20px">@小zzz：第一次跟这两个兄弟说再见。</p>
            <p style=" text-align: center; font-size: 24px; line-height: 65px">我的第一次  <span style="color:#f60">first time</span></p>
            <p style=" text-align: center"><img src="/resources/img/tu2.jpg"></p>
            <p style="text-align: center; font-size: 29px; line-height: 46px;color: #000; padding: 0 80px 0 0">原来最好的兄弟也不能永远在一起<p>
            <p style="text-align: center; font-size: 29px;line-height: 46px;color: #000; padding: 0 0 0 220px"> 为了理想各自飞翔</p>


            <p style="width: 80%; text-align: center; margin: 60px auto 20px"> @悄钱：第一次买车，当时好激动，又好忐忑。</p>
            <p style=" text-align: center; font-size: 24px; line-height: 65px">我的第一次  <span style="color:#f60">first time</span></p>
            <p style=" text-align: center"><img src="/resources/img/tu3.jpg"></p>
            <p style="text-align: center; font-size: 29px; line-height: 46px;color: #000; padding: 0 80px 0 0">当时买车的时候有优惠活动人很多<p>
            <p style="text-align: center; font-size: 29px;line-height: 46px;color: #000; padding: 0 0 0 220px"> 我抽奖还赢了一台洗衣机呢</p>

            <p style="width: 80%; text-align: center; margin: 60px auto 20px"> @梦中的阿里：第一次卖车，那时候没有这么多平台，自己去市场感觉被骗了，后悔了好久，永生难忘。</p>
            <p style=" text-align: center; font-size: 24px; line-height: 65px">我的第一次  <span style="color:#f60">first time</span></p>
            <p style=" text-align: center"><img src="/resources/img/tu4.jpg"></p>
            <p style="text-align: center; font-size: 29px; line-height: 46px;color: #000; padding: 0 80px 0 0">心理价越来越低，最后不知道怎么就信了<p>
            <p style="text-align: center; font-size: 29px;line-height: 46px;color: #000; padding: 0 0 0 220px"> 当时卖车的情景大概是这样的</p>

            <p style=" text-align: center; margin: 40px auto"><img src="/resources/img/r2.jpg"></p>
            <p style="text-align: center">生活百般滋味</p>
            <p style="text-align: center">我们要面对太多的第一次</p>
            <p style="text-align: center">很多事情第一次都是不容易的</p>
            <p style="text-align: center">但是因为悟空收车</p>
            <p style="text-align: center">第一次卖车</p>
            <p style="text-align: center">就可以很省心放心</p>
            <p style="text-align: center">那么，硬货来了</p>
            <p style="text-align: center">2017悟空收车第二季优惠活动</p>
            <p style="text-align: center">前所未有的重磅优惠↓</p>
            <p style=" text-align: center; margin: 40px auto"><img src="/resources/img/r3.jpg"></p>

            <p style="text-align: center">参与步骤：</p>
            <p style="text-align: center"> ①</p>
            <p style="text-align: center"> 点击文章底部 立即抽奖或立即置换</p>
            <p style="text-align: center">进入活动链接</p>
            <p style="text-align: center">②</p>
            <p style="text-align: center"> 在活动页面中按活动步骤参与并填写手机号</p>
            <p style="text-align: center">（悟空收车优惠将与此手机号绑定，请保证正确填写）</p>
            <p style="text-align: center"> ③</p>
            <p style="text-align: center"> 按照活动步骤完成卖车</p>
            <p style="text-align: center"> 系统将自动开始审核</p>
            <p style="text-align: center">④</p>
            <p style="text-align: center"> 审核通过就能赢取礼品啦</p>
            <p style="text-align: center; font-size: 24px; margin: 40px 0"> 最后，也有吃瓜群众表示— —</p>
            <p style="text-align: center;"><img src="/resources/img/r5.jpg"></p>

            <p style="text-align: center; margin: 40px 0 0 0 ">我们诚挚地建议你：</p>
            <p style="text-align: center;">  要卖车，就选悟空收车</p>
            <p style="text-align: center;"> 快来吧！</p>

           <p style="text-align: center; margin: 40px auto">
               <button style="background: #f60; border-radius: 8px; border:0; outline: none;color:#fff; font-size: 24px; padding: 7px 20px">立即抽奖</button>
               <button style="background: #f60; border-radius: 8px; border:0;outline: none;font-size: 24px; padding: 7px 20px;color:#fff; margin-left: 20px">立即置换</button>
           </p>

          <p style="text-align: center"><img src="/resources/img/logo.png">&nbsp;&nbsp;&nbsp;<img src="/resources/img/m_11.jpg" style="width:10%"></p>





        </div>
    </div><!--X_con-->
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

<script language="javascript">
    for(i in document.images)document.images[i].ondragstart=imgdragstart;
</script>
</body>
</html>
