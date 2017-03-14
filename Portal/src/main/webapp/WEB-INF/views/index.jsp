<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/3
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
    <link rel="stylesheet" type="text/css" href="/resources/style/style.css" />
    <script src="/resources/script/jquery-1.8.0.min.js" type="text/javascript"></script>

</head>
<!--首页头部开始-->
<div class="htmleaf-container" style="background-image: url('/resources/img/home_phload.jpg'); width: 1903px;">
    <div class="banner">
        <ul>
            <script type="text/javascript">
                $(function(){
                    var images_height = '600px';
                    var ad_data = ${adJson};
                    var images_count = ad_data.length;
                    for(var j=0;j<images_count+1;j++){
                        $('.banner ul').append('<li></li>')
                    }
                    //轮播圆点按钮节点
                    for(var j=0;j<images_count;j++){
                        if(j==0){
                            $('.banner ol').append('<li class="current" data-url="'+ad_data[j].advertUrl+'"></li>')
                        }else{
                            $('.banner ol').append('<li data-url="'+ad_data[j].advertUrl+'"></li>')
                        }
                    }
                    //载入图片
                    $('.banner ul li').css('background-image','url('+ad_data[0].advertImg+')');
                    $.each(ad_data,function(key,value){
                        $('.banner ul li').eq(key).css('background-image','url('+value.advertImg+')');
                    });
                    $('.banner').css('height',images_height);
                    $('.banner ul').css('width',(images_count+1)*100+'%');
                    $('.banner ol').css('width',images_count*20+'px');
                    $('.banner ol').css('margin-left',-images_count*20*0.5-10+'px');
                    //=========================
                    var num = 0;
                    //获取窗口宽度
                    var window_width = $(window).width();
                    $(window).resize(function(){
                        window_width = $(window).width();
                        $('.banner ul li').css({width:window_width});
                        clearInterval(timer);
                        nextPlay();
                        timer = setInterval(nextPlay,2000);
                    });
                    $('.banner ul li').width(window_width);
                    //轮播圆点
                    $('.banner ol li').click(function(){//用hover的话会有两个事件(鼠标进入和离开)
                        $(this).addClass('current').siblings().removeClass('current');
                        //获取当前编号
                        var i = $(this).index();
                        //console.log(i);
                        $('.banner ul').stop().animate({left:-i*window_width},500);
                        num = i;
                    });
                    //自动播放
                    var timer = null;
                    function prevPlay(){
                        num--;
                        if(num<0){
                            $('.banner ul').css({left:-window_width*images_count}).stop().animate({left:-window_width*(images_count-1)},500);
                            num=images_count-1;
                        }else{
                            $('.banner ul').stop().animate({left:-num*window_width},500);
                        }
                        if(num==images_count-1){
                            $('.banner ol li').eq(images_count-1).addClass('current').siblings().removeClass('current');
                        }else{
                            $('.banner ol li').eq(num).addClass('current').siblings().removeClass('current');

                        }
                    }
                    function nextPlay(){
                        num++;
                        if(num>images_count){
                            $('.banner ul').css({left:0}).stop().animate({left:-window_width},500);
                            num=1;
                        }else{
                            $('.banner ul').stop().animate({left:-num*window_width},500);
                        }
                        if(num==images_count){
                            $('.banner ol li').eq(0).addClass('current').siblings().removeClass('current');
                        }else{
                            $('.banner ol li').eq(num).addClass('current').siblings().removeClass('current');
                        }
                    }
                    timer = setInterval(nextPlay,10000);
                    //播放下一张
                    $('.banner .right').click(function(){
                        nextPlay();
                    });
                    //返回上一张
                    $('.banner .left').click(function(){
                        prevPlay();
                    });

                    $(".nav_sec").not(".nav_s").click(function(){
                        var url = $('.banner ol li').eq(num).data("url");
                        window.open(url,"_blank");
                    })
                });
            </script>
        </ul>
        <ol>
        </ol>
        <i class="left"></i><i class="right"></i>
    </div><!--banner end-->
</div><!--htmleaf-container end-->
<!--首页导航条 搜索框-->
<div class="nav_sec"></div>
<div class="nav_s">
    <div class="nav_top">
        <div class="logo">
            <a href="#" title="迈众汽车"><img src="img/logo.png"></a><span>北京</span>
        </div>
        <ul class="navs">
            <li><a href="">首页</a></li>
            <li><a href="">我要买车</a></li>
            <li><a href="">我要卖车</a></li>
            <li><a href="">服务保障</a></li>
        </ul><!--navs end-->
        <!--call-->
        <div class="call">
            <span class="span_one"><a href="">400-090-0494</a></span>
                <span><a href="#" onclick="return false;" class="openlogin">登录</a> / <a href="#" onclick="return false;"
                                                                                        class="reg">注册</a></span>
        </div>
        <!--sec-->
        <from action="#" method="post" name="1" id="s_from" class="">
            <div class="s_froms">
                <input type="text"><span class="ss">搜索</span>
                <div class="sec_hide">
                    <ul>
                        <li><a href="#">大众汽车</a></li>
                        <li><a href="#">大众汽车</a></li>
                        <li><a href="#">大众汽车</a></li>
                        <li><a href="#">大众汽车</a></li>
                    </ul>
                </div>
            </div><!--s_from end-->
        </from>
    </div><!--nav_top end-->
</div><!--nav_tops end-->
<!--搜索框-->
<div style="width: 100%;position: absolute;top: 220px;">
<div class="secs">
    <from action="#" method="post" name="1" id="s_from" class="">
        <div class="s_from">
            <input type="text"><span class="ss">立即搜索</span>
            <p class="mai"><a href="#">我要置换</a></p>
            <div class="sec_hide">
                <ul>
                    <li><a href="#">大众汽车</a></li>
                    <li><a href="#">大众汽车</a></li>
                    <li><a href="#">大众汽车</a></li>
                    <li><a href="#">大众汽车</a></li>
                </ul>
            </div>
        </div><!--s_from end-->
    </from>
</div>
</div>
<!--首页导航条 搜索结束-->
<!--首页头部结束-->
<!--热销车型-->
<div class="re_xiao">
    <div class="re_con">
        <dl>
            <dt><img src="/resources/img/bg_re.jpg"></dt>
            <dd class="dd1"></dd>
            <dd class="dd2">
                <h2>科鲁兹经典</h2>
                <p>2015经典款 1.5L 自动挡/手动挡</p>
                <ul>
                    <li>1、外观大气</li>
                    <li>2、低油耗</li>
                    <li>3、操控精准</li>
                    <li>4、安全性高</li>
                </ul>
                <div class="bors"><a href="">预约看车</a></div>
                <div class="bort">400-054-9494</div>
            </dd>
        </dl>
    </div>
</div>
<!--热销车型 end-->
<!--品牌 车型-->
<div class="index_cen">

    <div class="pin">
        <p>汽车品牌<span><a href="#">大众</a>/<a href="#">奥迪</a>/<a href="#">比亚迪</a>/<a href="#">沃尔沃</a></span><a href="" class="fr more">查看更多</a</p>
        <ul class="lists">
            <li>
                <a href="#">
                    <span><img src="img/b_84.png"></span>
                    <span>大众</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <span><img src="img/b_135.png"></span>
                    <span>大众</span>
                </a>
            </li>

            <li>
                <a href="#">
                    <span><img src="img/b_15.png"></span>
                    <span>大众</span>
                </a>
            </li>

            <li>
                <a href="#">
                    <span><img src="img/b_59.png"></span>
                    <span>大众</span>
                </a>
            </li>

            <li>
                <a href="#">
                    <span><img src="img/b_89.png"></span>
                    <span>大众</span>
                </a>
            </li>

            <li>
                <a href="#">
                    <span><img src="img/b_62.png"></span>
                    <span>大众</span>
                </a>
            </li>

            <li>
                <a href="#">
                    <span><img src="img/b_34.png"></span>
                    <span>大众</span>
                </a>
            </li>

            <li>
                <a href="#">
                    <span><img src="img/b_98.png"></span>
                    <span>大众</span>
                </a>
            </li>

            <li>
                <a href="#">
                    <span><img src="img/b_38.png"></span>
                    <span>大众</span>
                </a>
            </li>

            <li>
                <a href="#">
                    <span><img src="img/b_47.png"></span>
                    <span>大众</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <span><img src="img/b_145.png"></span>
                    <span>大众</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <span><img src="img/b_55.png"></span>
                    <span>大众</span>
                </a>
            </li>

        </ul><!--lists end-->
        <div class="clear"></div>

        <p class="p2">车系种类<span><a href="#">SUV</a>/<a href="#">MPV</a>/<a href="#">面包</a>/<a href="#">跑车</a></span><a href="" class="fr more">查看更多</a></p>
        <ul class="lists lists2">
            <li>
                <a href="#">
                    <span><img src="img/c-2.png"></span>
                    <span>大众</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <span><img src="img/c-4.png"></span>
                    <span>大众</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <span><img src="img/c-5.png"></span>
                    <span>大众</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <span><img src="img/c-3.png"></span>
                    <span>大众</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <span><img src="img/c-7.png"></span>
                    <span>大众</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <span><img src="img/c-8.png"></span>
                    <span>大众</span>
                </a>
            </li>
        </ul>
    </div><!--pin end-->
</div>
<!--品牌 车型 end-->
<div class="clear"></div>

</body>
</html>
