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
    <meta name="renderer" content="webkit"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
    <link rel="stylesheet" type="text/css" href="/resources/style/style.css" />
</head>
<body>
<!--首页头部开始-->
<div class="htmleaf-container">
    <div class="banner">
        <ul>
            <script type="text/javascript">
                $(function(){
                    var images_height = '600px';
                    var images_url = [
                        'img/1.jpg',
                        'img/2.jpg',
                        'img/4.jpg'
                    ];
                    var images_count = images_url.length;
                    for(var j=0;j<images_count+1;j++){
                        $('.banner ul').append('<li></li>')
                    }
                    //轮播圆点按钮节点
                    for(var j=0;j<images_count;j++){
                        if(j==0){
                            $('.banner ol').append('<li class="current"></li>')
                        }else{
                            $('.banner ol').append('<li></li>')
                        }
                    }

                    //载入图片
                    $('.banner ul li').css('background-image','url('+images_url[0]+')');
                    $.each(images_url,function(key,value){
                        $('.banner ul li').eq(key).css('background-image','url('+value+')');
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
                    //console.log(window_width);
                    $('.banner ul li').width(window_width);
                    //轮播圆点
                    $('.banner ol li').mouseover(function(){//用hover的话会有两个事件(鼠标进入和离开)
                        $(this).addClass('current').siblings().removeClass('current');
                        //第一张图： 0 * window_width
                        //第二张图： 1 * window_width
                        //第三张图： 2 * window_width
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
                            //悄悄把图片跳到最后一张图(复制页,与第一张图相同),然后做出图片播放动画，left参数是定位而不是移动的长度
                            $('.banner ul').css({left:-window_width*images_count}).stop().animate({left:-window_width*(images_count-1)},500);
                            num=images_count-1;
                        }else{
                            //console.log(num);
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
                            //播放到最后一张(复制页)后,悄悄地把图片跳到第一张,因为和第一张相同,所以难以发觉,
                            $('.banner ul').css({left:0}).stop().animate({left:-window_width},500);
                            //css({left:0})是直接悄悄改变位置，animate({left:-window_width},500)是做出移动动画
                            //随后要把指针指向第二张图片,表示已经播放至第二张了。
                            num=1;
                        }else{
                            //在最后面加入一张和第一张相同的图片，如果播放到最后一张，继续往下播，悄悄回到第一张(肉眼看不见)，从第一张播放到第二张
                            //console.log(num);
                            $('.banner ul').stop().animate({left:-num*window_width},500);
                        }
                        if(num==images_count){
                            $('.banner ol li').eq(0).addClass('current').siblings().removeClass('current');
                        }else{
                            $('.banner ol li').eq(num).addClass('current').siblings().removeClass('current');

                        }
                    }
                    timer = setInterval(nextPlay,5000);
                    //鼠标经过banner，停止定时器,离开则继续播放
                    $('.banner').mouseenter(function(){
                        clearInterval(timer);
                        //左右箭头显示(淡入)
                        $('.banner i').fadeIn();
                    }).mouseleave(function(){
                        timer = setInterval(nextPlay,5000);
                        //左右箭头隐藏(淡出)
                        $('.banner i').fadeOut();
                    });
                    //播放下一张
                    $('.banner .right').click(function(){
                        nextPlay();
                    });
                    //返回上一张
                    $('.banner .left').click(function(){
                        prevPlay();
                    });
                });
            </script>
        </ul>
        <ol>
        </ol>
        <i class="left"></i><i class="right"></i>
    </div><!--banner end-->
</div><!--htmleaf-container end-->
<!--首页导航条 搜索框-->
<div class="nav_sec">
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
    <div class="secs">
        <from action="#" method="post" name="1" id="s_from" class="">
            <div class="s_from">
                <input type="text"><span class="ss">搜索</span>
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
</div>
<!--首页导航条 搜索结束-->
<!--首页头部结束-->
</body>
</html>
