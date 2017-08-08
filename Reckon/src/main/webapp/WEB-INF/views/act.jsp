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
    <script src="/resources/js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js"></script>
    <script src="http://cdn.bootcss.com/layer/3.0.1/layer.min.js" type="text/javascript"></script>
    <script src="/resources/js/slider.js"></script>
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
            <li><a href="/app" target="_blank">APP下载</a></li>
           <li><a href="/help" target="_blank">帮助中心</a></li>
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

<!--banner-->
<div class="bg_imge"> </div>
<!--banner end-->

<div class="bg_imgs"></div>

<div class="hui_color">
    <div class="hui_top">
       <img src="/resources/img/hui_04.jpg">
        <a href="/sale"><img src="/resources/img/hui_08.jpg"></a>
        <p>成交即可赠送应季大礼包 多卖多送无上限</p>
    </div>
</div>

<div class="bg_imgr"></div>

<div class="zhongj">
   <div class="zhi_cen">
       <div class="z_left">
           <p class="p_head">中奖名单</p>

           <div class="txtMarquee-top">
               <div class="zdan bd">
                   <div class="zd"></div>
                   <ul class="infoList" id="ulist">
                       <script id="list-u-tmpl" type="text/x-dot-template">
                       {{ for(var i=0,len=it.length;i<len; i++) { }}
                       <li>
                           <span class="sp1">{{=it[i].phone}}</span>
                           <span class="sp2">{{=it[i].money}}</span>
                           <span>{{=it[i].time}}</span></li>
                       {{ } }}
                       </script>
                   </ul>
               </div>
           </div>


       </div>
       <div class="z_right">
           <p class="p_head">你还有0次抽奖机会</p>

           <div class="turntable-bg">

               <!--<div class="mask"><img src="images/award_01.png"/></div>-->

               <div class="pointer"><img src="/resources/img/pointer.png" alt="pointer" width="100%"/></div>

               <div class="rotate" ><img id="rotate" src="/resources/img/turntable.png" alt="turntable" width="100%"/></div>

           </div>
       </div>

       <div class="clear"></div>
       <div class="huod">
           <img src="/resources/img/huo_03.jpg">
           <div class="huo_cen">
               <p>1.活动时间：2017年5月6日-2018年1月1日。</p>
               <p> 2.用户在48小时内完成交易，即可活动一次抽奖机会。</p>
               <p> 3.中奖奖品由悟空收车平台客服负责审核并发放。</p>
               <p> 4.本次活动只针对在悟空收车平台成功交易客户参加。</p>
               <p> 5.奖品数量有限，先到先得。</p>
           </div>
       </div>
   </div>
</div>



<div class="cj">
    <div class="cj_cen" id="owl-example">


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


<!--头end-->
<%@include file="footer.jsp"%>
<script src="/resources/js/doT.min.js"></script>



<script>
    $(function(){
        $(".zdan ul li:even").css("background","#eee")
    });
</script>



<script src="/resources/js/awardRotate.js"></script>
<script src="/resources/js/slider.js"></script>

<script>
    //数组排序
    var shuffle = function(v){
        for(var j, x, i = v.length; i; j = parseInt(Math.random() * i), x = v[--i], v[i] = v[j], v[j] = x);
        return v;
    };
    $(function (){


        $.getJSON('/resources/data/userhj.json',function(d){
            var huj = doT.template($("#list-u-tmpl").text());
            $.each(d,function(i,j){
                j.time = datemy2(i);
            })
            d = shuffle(d)
            $("#ulist").html(huj(d));

            jQuery(".txtMarquee-top").slide({mainCell:".bd ul",autoPlay:true,effect:"topMarquee",vis:10,interTime:100});
        })

        $.getJSON('/resources/data/hotcar.json',function(d){
            var carevalText = doT.template($("#list-car-tmpl").text());
            d = shuffle(d)
            $("#owl-example").html(carevalText(d));

        })



        var rotateTimeOut = function (){

            $('#rotate').rotate({

                angle:0,

                animateTo:2160,

                duration:8000,

                callback:function (){

                    alert('网络超时，请检查您的网络设置！');

                }

            });

        };

        var bRotate = true;



        var rotateFn = function (awards, angles, txt){

            bRotate = !bRotate;

            $('#rotate').stopRotate();

            $('#rotate').rotate({

                angle:0,

                animateTo:angles+1800,

                duration:8000,

                callback:function (){

                    alert(txt);

                    bRotate = !bRotate;

                }

            })

        };



        $('.pointer').click(function (){

            var phone = $.cookie('phone');

            if(phone=='null'||!phone){
                layer.msg("快登陆，错过机会要等一年哦", {
                    offset: 't',
                    anim: 6
                });
                return ;
            }

            if(bRotate){
                layer.msg("您还没有抽奖机会，快去卖车吧", {
                    offset: 't',
                    anim: 6
                });
                return;
            }

            var item = rnd(0,8);



            switch (item) {

                case 0:

                    //var angle = [26, 88, 137, 185, 235, 287, 337];

                    rotateFn(0, 360, '50元');

                    break;

                case 1:

                    //var angle = [88, 137, 185, 235, 287];

                    rotateFn(1, 45, '666元');

                    break;

                case 2:

                    //var angle = [137, 185, 235, 287];

                    rotateFn(2, 90, '700元');

                    break;

                case 3:

                    //var angle = [137, 185, 235, 287];

                    rotateFn(3, 135, '888元');

                    break;

                case 4:

                    //var angle = [185, 235, 287];

                    rotateFn(4, 180, '500元');

                    break;

                case 5:

                    //var angle = [185, 235, 287];

                    rotateFn(5, 225, '300元');

                    break;

                case 6:

                    //var angle = [235, 287];

                    rotateFn(6, 270, '200元');

                    break;

                case 7:

                    //var angle = [287];

                    rotateFn(7, 315, '100元');

                    break;

                case 8:

                    //var angle = [287];

                    rotateFn(8, 360, '50元');

                    break;

            }



            console.log(item);

        });

    });

    function rnd(n, m){

        return Math.floor(Math.random()*(m-n+1)+n)

    }
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