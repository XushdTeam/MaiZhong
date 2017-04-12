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
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
    <link rel="stylesheet" type="text/css" href="/resources/style/base.css" />
    <script src="http://cdn.bootcss.com/jquery/3.2.0/jquery.min.js" type="text/javascript"></script>

</head>
<!--首页头部开始-->
<div class="htmleaf-container" style="background-image: url('/resources/img/1.jpg');background-size: 100%; width: 100%; height:600px">
    <div class="banner">
        <ul>
            <script type="text/javascript">
                $(function(){
                    var images_height = '600px';
                    var ad_data = ${ggList};
                    var images_count = ad_data.length;
                    for(var j=0;j<images_count+1;j++){
                        $('.banner ul').append('<li></li>')
                    }
                    //轮播圆点按钮节点
                    for(var j=0;j<images_count;j++){
                        if(j==0){
                            $('.banner ol').append('<li class="current" data-url="'+ad_data[j].ggUrl+'"></li>')
                        }else{
                            $('.banner ol').append('<li data-url="'+ad_data[j].ggUrl+'"></li>')
                        }
                    }
                    //载入图片
                    $('.banner ul li').css('background-image','url('+ad_data[0].ggImg+')');
                    $.each(ad_data,function(key,value){
                        $('.banner ul li').eq(key).css('background-image','url('+value.ggImg +')');
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
                        timer = setInterval(nextPlay,5000);
                    });
                    $('.banner ul li').width(window_width);
                    //轮播圆点
                    $('.banner ol li').click(function(){//用hover的话会有两个事件(鼠标进入和离开)
                        $(this).addClass('current').siblings().removeClass('current');
                        //获取当前编号
                        var i = $(this).index();
                        //console.log(i);
                        $('.banner ul').stop().animate({left:-i*window_width},1000);
                        num = i;
                    });
                    //自动播放
                    var timer = null;
                    function prevPlay(){
                        num--;
                        if(num<0){
                            $('.banner ul').css({left:-window_width*images_count}).stop().animate({left:-window_width*(images_count-1)},1000);
                            num=images_count-1;
                        }else{
                            $('.banner ul').stop().animate({left:-num*window_width},1000);
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
                            $('.banner ul').css({left:0}).stop().animate({left:-window_width},1000);
                            num=1;
                        }else{
                            $('.banner ul').stop().animate({left:-num*window_width},1000);
                        }
                        if(num==images_count){
                            $('.banner ol li').eq(0).addClass('current').siblings().removeClass('current');
                        }else{
                            $('.banner ol li').eq(num).addClass('current').siblings().removeClass('current');
                        }
                    }
                    timer = setInterval(nextPlay,5000);
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
            <a href="#" title="迈众汽车">
                <img src="/resources/img/logo.png">
            </a>
        </div>
        <ul class="navs">
            <li><a href="/">首页</a></li>
            <li><a href="/car/list.html">我要买车</a></li>
            <li><a href="/sale.html">我要卖车</a></li>
            <li><a href="">服务保障</a></li>
        </ul><!--navs end-->

        <div class="s_froms">
            <input type="text" id="search1"><a class="s1"><span class="ss">搜索</span></a>
        </div>
        <!--call-->
        <div class="call">
            <span class="span_one"><a href="">010-8025-8108</a></span>
        </div>
    </div><!--nav_top end-->
</div><!--nav_tops end-->
<!--搜索框-->
<div style="width: 100%;position: absolute;top: 160px;">
<div class="secs">
    <from action="#" method="post" name="1" id="s_from" class="">
        <div class="s_from">
            <input type="text" id="search2"><span class="ss s2"><a href="#" style="display: block">立即搜索</a></span>
            <p class="mai"><a href="/sale.html">我要置换</a></p>
            <div class="sec_hide">
                <ul>

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
            <dd class="dd2">
                <h2>科鲁兹经典</h2>
                <p>2015经典款 1.5L 自动挡/手动挡</p>
               <%-- <ul>
                    <li>1、外观大气</li>
                    <li>2、低油耗</li>
                    <li>3、操控精准</li>
                    <li>4、安全性高</li>
                </ul>--%>
                <div class="bors"><a href="">预约看车</a></div>
                <div class="bort">24小时热线：400-054-9494</div>
            </dd>
        </dl>
    </div>
</div>
<!--热销车型 end-->
<!--品牌 车型-->
<div class="index_cen">
    <div class="pin">
        <p>热门品牌
            <span>
                <c:forEach items="${cbList}" var="item"  varStatus="stat">
                    <a href="/car/cb_${item.id}/cs_0/cp_0/cv_0/p_0/x_0/list.html">${item.name}</a>
                    <c:if test="${!stat.last}" >/</c:if>
                </c:forEach>
            </span>
            <a href="/car/list.html" class="fr more">查看更多</a>
        </p>
        <ul class="lists">
            <c:forEach items="${cbList}" var="item" >
                <li>
                    <a href="/car/cb_${item.id}/cs_0/cp_0/cv_0/p_0/x_0/list.html">
                        <span><img src="${item.imgUrl}"></span>
                        <span>${item.name}</span>
                    </a>
                </li>
            </c:forEach>
        </ul><!--lists end-->
        <div class="clear"></div>

        <p class="p2">热门车型
            <span>
                <c:forEach items="${ctList}" var="item"  varStatus="stat" begin="0" end="5">
                    <a href="/car/cb_0/cs_0/cp_0/cv_0/p_${item.id}/x_0/list.html">${item.typeName}</a>
                    <c:if test="${!stat.last}" >/</c:if>
                </c:forEach>
            </span>
        </p>
        <ul class="lists lists2">
            <c:forEach items="${ctList}" var="item" begin="0" end="5">
                <li>
                    <a href="/car/cb_0/cs_0/cp_0/cv_0/p_${item.id}/x_0/list.html">
                        <span><img src="${item.typeImg}"></span>
                        <span>${item.typeName}</span>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div><!--pin end-->
</div>
<!--品牌 车型 end-->
<div class="clear"></div>
<div class="clear"></div>
<!--推荐-->
<div id = "list">
    <script id="list-tmpl" type="text/x-dot-template">
        {{ for(var i=0,len=it.length;i<len; i++) { }}
        <div class="tuijian">
            <h2 class="heads"> {{=it[i].name }} <a href="/car/list.html">更多>></a></h2>
            <div class="recommend-car-list carList" style="display: block; ">
                {{ for(var j=0, a_l=it[i]['arry'].length; j<a_l; j++) { }}
                <dl class="{{if(j==3){}}last{{}}}">
                    <dd>
                        <a href="car/{{=it[i]['arry'][j].id}}/detail.html" class="cars-info">
                            <img src="/resources/img/default.png" data-src="{{=it[i]['arry'][j].img}}" width="360" height="240">
                            <p>{{=it[i]['arry'][j].name}}</p>
                            <p><span>{{=it[i]['arry'][j].sellPrice}} 万</span></p>
                        </a>
                    </dd>
                </dl>
                {{ } }}
            </div>
        </div>
        <div class="clear"></div>
        {{ } }}
    </script>
</div>
<!--推荐end-->

<!--新闻热点-->
<div class="new">
    <div class="new_con">

            <dl>
                <a href="/news.html?newsId=1">
                    <dt><img src="/resources/img/new.jpg"></dt>
                </a>
                <dd class="dd1"><a href="/news.html?newsId=3">将于4月7日上市 江淮推3款新能源车型</a></dd>
                <dd><a href="/news.html?newsId=1">日前，我们从江淮汽车官方获悉，旗下新能源车型iEV6E、iEV7以及2017款iEV4车型将于4月7日正式上市。其中iEV6E为全新车型，iEV7和新款iEV4在外观以及续航能力上进行了升级。</a></dd>
            </dl>



            <dl>
                <a href="/news.html?newsId=2">
                    <dt><img src="/resources/img/new_2.jpg"></dt>
                </a>
                <dd class="dd1"><a href="/news.html?newsId=2">造型/配置均有提升 实拍2017款景逸X3</a></dd>
                <dd><a href="/news.html?newsId=2">最近的一些日子里，东风风行推出了不少改款、换代车型，如2016年12月上市的2017款景逸X5、2017年3月份上市的现款景逸X3、本月（4月）8日将要上市的新款菱智M5L（点击车型名称进入相关文章）</a></dd>
            </dl>

            <dl>
                <a href="/news.html?newsId=3">
                    <dt><img src="/resources/img/new_4.jpg"></dt>
                </a>
                <dd class="dd1"><a href="/news.html?newsId=3">空间\运动\舒适 3款各有强项的合资中型车</a></dd>
                <dd><a href="/news.html?newsId=3">国内中型车市场的竞争非常激烈，用中坚力量这个词来形容它们是非常合适的，对于选购中型车的消费者来说，最受人关注的是价格，无论是配置、舒适性还是动力表现都较为均衡的车型。</a></dd>
            </dl>

    </div><!--new_con-->
</div>
<!--新闻热点 end-->
<div class="clear"></div>

<!--footer 开始-->
<div class="footer">
    <div class="foot_cen">
        <div class="n_f_m_c">
            <a href="/about.html">关于我们</a>
            <a href="/help.html">帮助中心</a>
            <a href="/joinus.html">加入我们</a>
            <a href="/feedback.html">用户反馈</a>
        </div><!--n_f_m_c end-->

        <div class="pp">
            <p>Copyright © 2017-2020 迈众 All Rights Reserved 版权所有 迈众汽车信息服务有限公司</p>
            <p>京ICP备17017795号  &nbsp;&nbsp;&nbsp; 联系电话：010-8025-8108 &nbsp;&nbsp;&nbsp;
            <script type="text/javascript">
                var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
                document.write(unescape("%3Cspan id='cnzz_stat_icon_1261672623'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s95.cnzz.com/z_stat.php%3Fid%3D1261672623' type='text/javascript'%3E%3C/script%3E"));
            </script>
            </p>
        </div>


    </div><!--fooot_cen end-->
</div>
<!--footer 结束-->




<div class="sidebar sidebar-new">
    <a href="javascript:void(0);" class="sBtn free" id="sphone"><i></i>免费电话</a>
    <a href="javascript:void(0);" class="toTop"><i></i>返回顶部</a>
</div>
<div class="sList free-phone" id="sidebar-list-sphone" style="display:none;">
    <i></i>
    <input type="text" placeholder="请输入电话号码" class="ipt-box" id="phone" maxlength="11" />
    <a href="javascript:void(0);" class="free-btn">咨询</a>
</div>
<div class="free-phone-error" style="display:none;">
    <i class="false"></i>
    <span style="color: red">请输入正确的手机号</span>
</div>
<div class="free-phone-success" style="display:none;">
    <i class="success"></i>
    <span style="color: green">我们会尽快给您致电</span>
</div>
<script src="/resources/script/doT.min.js" type="text/javascript"></script>
<script src="/resources/script/lazy-load-img.min.js" type="text/javascript"></script>

<script>

    var is = false;
    $(document).ready(function() {
        $(".halfpay-car-list div .lazyload").hover(function(){
            $(this).animate({right:'15px'});
        },function(){

            $(this).animate({right:'0px'});
        });
        $(window).scroll(function() {
            if ($(document).scrollTop()>=170){
                $(".nav_s").css("background","#fff").css("position","fixed").css("box-shadow","1px 1px 5px #999")
                $(".navs a,.logo span").css("color","#666")
                $(".call").hide();
                $(".s_froms").show();
            }
            if ($(document).scrollTop()<=170){
                $(".nav_s").css("background","none").css("position","absolute").css("box-shadow","0px 0px 0px #999")
                $(".navs a,.logo span").css("color","#fff")
                $(".call").show();
                $(".s_froms").hide();
            }
            if($(document).scrollTop()>=400 && !is){
                is = true;
                $.getJSON("/getHomeItemContent.action",function(res){
                    var evalText = doT.template($("#list-tmpl").text());
                    $("#list").html(evalText(res.data));
                });

            }

        });
        $(".s1").click(function(){
            var searchStr = $("#search1").val().trim();
            if(searchStr=='')return;
            window.location.href="/car/list.html?s="+searchStr;

        });
        $(".s2 a").click(function(){
            var searchStr = $("#search2").val().trim();
            if(searchStr=='')return;
            window.location.href="/car/list.html?s="+searchStr;

        });
        $('#search1').on('keypress',function(event){
            if(event.keyCode == 13){
                var searchStr = $("#search1").val().trim();
                if(searchStr=='')return;
                window.location.href="/car/list.html?s="+searchStr;
            }

        });
        $('#search2').on('keypress',function(event){
            if(event.keyCode == 13){
                var searchStr = $("#search2").val().trim();
                if(searchStr=='')return;
                window.location.href="/car/list.html?s="+searchStr;
            }

        });
    });

    ;(function () {

        window.lazyLoadImg = new LazyLoadImg({
            el: document.querySelector('#list'),
            mode: 'diy', //默认模式，将显示原图，diy模式，将自定义剪切，默认剪切居中部分
            time: 300, // 设置一个检测时间间隔
            complete: true, //页面内所有数据图片加载完成后，是否自己销毁程序，true默认销毁，false不销毁
            position: { // 只要其中一个位置符合条件，都会触发加载机制
                top: 0, // 元素距离顶部
                right: 0, // 元素距离右边
                bottom: 0, // 元素距离下面
                left: 0 // 元素距离左边
            },
            diy: { //设置图片剪切规则，diy模式时才有效果
                backgroundSize: 'cover',
                backgroundRepeat: 'no-repeat',
                backgroundPosition: 'center center'
            },
            before: function () { // 图片加载之前执行方法
            },
            success: function (el) { // 图片加载成功执行方法
                el.classList.add('success')
            },
            error: function (el) { // 图片加载失败执行方法
                el.src = './resources/img/default.png'
            }
        });
        $('.toTop').click(function () {
            $("html, body").animate({ scrollTop: 0 }, 200);
        });
        $('#sphone').click(function () {
            $('.free-phone-error').hide();
            $('.free-phone-success').hide();
            $('#sidebar-list-sphone').toggle();
        });
        $('.free-btn').click(function () {
            var phone = $("#phone").val();
            if(!(/^1[34578]\d{9}$/.test(phone))){
                $('.free-phone-error').show();
                return false;
            }else{
                $('.free-phone-error').hide();
                if(!sessionStorage.getItem('homePhone')){
                    $.post("/doPhoneLink.action",{phone:phone,type:'0'},function(res){
                        $('.free-phone-error').hide();
                        $('.free-phone-success').show();
                        sessionStorage.setItem('homePhone',1);
                    });
                }else{
                    $('.free-phone-success').show();
                }
            }
        });
    })()

</script>

</body>
</html>
