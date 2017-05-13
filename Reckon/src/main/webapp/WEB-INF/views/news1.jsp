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
            <li><a href="/" >首页</a></li>

            <li><a href="/sale">我要卖车</a></li>
            <li><a href="/join">销售商加盟</a></li>
            <li><a href="/app">APP下载</a></li>
            <li><a href="/help">帮助中心</a></li>
            <li style="display: none;" id="user_li"><a href="/per/or"  >个人中心</a></li>
        </ul>
        <ul class="lon" style="margin-top: 0px;">
            <li >
                <i class="iconfont icon ">&#xe6a3;</i>
                <a href="/login"  id="user">登录</a>
            </li>
            <li>
                <a href="javascript:void(0)" class="two" id="exit" style="display:none" onclick="exit();">退出</a>
            </li>
        </ul>
    </div>
</div><!--top end-->

<div class="A_colocr">
    <div class="X_con">
        <h2>文章详情</h2>
        <div class="x_left">
            <h3>如何界定“事故车”</h3>

            <p style="background:white;">
                <br />
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp; &nbsp; &nbsp; &nbsp; 如何界定事故车？哪些损伤算是事故车？事故车到底能不能买</span><span style="font-size:16px;">等等。一辆车的结构部件（文中所指：</span>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">纵梁、悬架系统、前后防撞钢梁、吸能盒等核心框架）、车架（车身骨架、结构部件，不含外观覆盖件），这些部分如果因为碰撞导致拉伸、形变、损坏的情况（在受到冲击时，结构部件表面也许看不出明显损伤，但是很可能伤害已经分散到车架的其它部位），就可以算是事故车了。</span><span style="font-size:16px;line-height:1.5;">这样的车辆不建议大家购买。一旦结构部件部分受损，就算通过拉伸、敲打或者其它方式修复了，也无法恢复其整体的车身刚性，如果再次发生碰撞很可能就会“散架”了。</span>
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="528" height="304" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494551961938884.jpg" alt="620x0_1_2014072108380560180" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp;</span>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp; &nbsp; &nbsp; &nbsp;反之，如果是车身的覆盖件受损或发生碰撞，只要没有伤及结构部件的部分，就不会影响行驶安全，就算修复过或者更换过也没事。可以将覆盖件理解为车辆的“外衣”，损坏后可以通过更换原厂配件来进行更换，而结构部件则不同，不能随便就拆下进行更换，一旦受损就是不可逆的。两者的区别大家要搞清楚。</span>
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="576" height="372" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494552730731456.jpg" alt="620x0_1_2014072713541534427" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="620" height="465" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494552807342426.jpg" alt="620x0_1_2014072721305985000" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp;</span>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp;</span>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">如何甄别“事故车”？</span>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">案例：车头结构部件受损</span>
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="504" height="378" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494552909296713.jpg" alt="620x0_1_2014072719461384795" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="528" height="291" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494553042344548.jpg" alt="620x0_1_2014072714154025612" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="552" height="354" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494553169385940.jpg" alt="620x0_1_2014072714154474672" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp;</span>
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="620" height="379" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494553253261659.jpg" alt="620x0_1_2014072110481069809" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="620" height="465" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494553339739345.jpg" alt="620x0_1_2014072714171106388" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp;</span>
            </p>
            <p style="background:white;">
                <strong><span style="font-size:16px;">方法</span></strong><strong><span style="font-size:16px;">1 </span></strong><strong><span style="font-size:16px;">看螺丝</span></strong>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp; &nbsp; &nbsp; &nbsp; 一辆车一旦发生碰撞，首先受损的一般都是覆盖件，比如发动机舱盖、保险杠、翼子板等，但是如果碰撞的强度非常大，就会波及到发动机舱内的各种结构部件，由于冲击力较大，发动机舱内各种连接部位的固定件就容易因此产生位移。</span>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp; &nbsp; &nbsp; &nbsp;如果程度较轻，一般商家则不会对其修复，如果程度较重，则会进行更换，通过观察固定螺丝附近的漆面可以判断出该位置是否承受过较大的冲击，另外，如果螺丝被更换过的话，它的油漆颜色及喷涂形状也会和原厂配件产生明显的差异。</span>
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="492" height="369" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494553436480858.jpg" alt="620x0_1_2014072111004428862" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp;</span>
            </p>
            <p style="background:white;">
                <strong><span style="font-size:16px;">方法</span></strong><strong><span style="font-size:16px;">2 </span></strong><strong><span style="font-size:16px;">看漆面痕迹</span></strong>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp; &nbsp; &nbsp; 建议在挑选二手车时一定要对车辆密封条内的状况进行检查，尤其是车辆受到过严重撞击后，对于A柱、B柱、C柱的影响会更明显，此处如果进行过修复，摸起来就不会像原厂漆面那般光滑，而且在框架的边缘可以看到修复后的焊接痕迹或是敲打过的痕迹。</span>
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="552" height="320" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494553499557539.jpg" alt="620x0_1_2014072111243732273" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp;</span>
            </p>
            <p style="background:white;">
                <strong><span style="font-size:16px;">方法</span></strong><strong><span style="font-size:16px;">3 </span></strong><strong><span style="font-size:16px;">升起车辆看底盘</span></strong>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp; &nbsp; &nbsp; 在经过以上的排查后，初步可以断定这台车的前部受到了不轻的损伤，但是仅通过这样的方式还不能直观的判定这台车的“核心伤势”在哪，所以我们决定将车辆升起来，通过查看底盘的方式去看看这台车的“筋骨部分”有何损伤，这也是消费者在辨别事故车时最该关注的地方。</span>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp; &nbsp; &nbsp; 在进行底盘部分的检查之前，我们先用一张图和大家简单介绍一下在底盘部分要重点进行检查的部分，从前到后的顺序分别是：前防撞梁、吸能盒、前纵梁。详情请看下图：</span>
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="516" height="387" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494553544685266.jpg" alt="620x0_1_2014072719502795680" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="516" height="387" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494553635968816.jpg" alt="620x0_1_2014072721351469205" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp;</span>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp;</span>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp;</span>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp;</span>
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="620" height="367" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494553692864836.jpg" alt="620x0_1_2014072713371166826" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="620" height="315" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494553756983536.jpg" alt="620x0_1_2014072113364742958" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp;</span>
            </p>
            <p style="background:white;">
                <strong><span style="font-size:16px;">方法</span></strong><strong><span style="font-size:16px;">4 </span></strong><strong><span style="font-size:16px;">摸手感</span></strong>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp; &nbsp; &nbsp; &nbsp;当然，目前不法二手车商的修复技术越来越高明，尤其是那些遭受重大事故的车辆，商家往往会对车辆的纵梁、A柱、B柱及C柱进行重新焊接，这时再用一般的方法就不易观察到了，需要另想办法。</span>
            </p>
            <p style="background:white;">
                <span style="font-size:16px;line-height:1.5;">&nbsp; &nbsp; &nbsp; 对于像是A柱、B柱、C柱受损的车辆而言，可以通过对它们的漆面情况、和有无修补痕迹来进行判断，如果车辆在以上部位发生了形变或修补痕迹，或是某一段的漆面和其它部分的漆面摸上去感觉不一样，就有可能被修复过了，这样的车辆即使经过再好的修复技术，也不可能恢复到原厂的状态，会严重影响行车安全的。</span>
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="516" height="366" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494553810740030.jpg" alt="620x0_1_2014072721431595068" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="540" height="518" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494553854153335.jpg" alt="620x0_1_2014072713511794075" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp;</span>
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="564" height="389" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494553949451073.jpg" alt="620x0_1_2014072714265766950" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <span style="font-size:16px;">&nbsp;</span>
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="620" height="389" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494553986680551.jpg" alt="620x0_1_2014072115194209203" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="620" height="302" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494554056294823.jpg" alt="620x0_1_2014072713582523890" /><!--[endif]-->
            </p>
            <p style="background:white;">
                <!--[if gte vml 1]><![endif]--><!--[if !vml]--><img width="620" height="304" src="http://mzcar.oss-cn-qingdao.aliyuncs.com/car/1494554092667872.jpg" alt="620x0_1_2014072721442167360" /><!--[endif]-->
            </p>


            <!--ul class="x_foot">
               <li><a href="#">上一篇：全家出行无忧 3款合资中型SUV推荐</a></li>
               <li><a href="#">下一篇：都是畅销榜常客 3款紧凑型SUV推荐</a></li>
            </ul-->
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
