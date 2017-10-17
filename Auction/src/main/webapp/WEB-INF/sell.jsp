<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/17
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我要卖车</title>
    <link rel="stylesheet" href="/resources/main2/css/base.css" type="text/css">
    <link rel="stylesheet" href="/resources/main2/css/common.css" type="text/css">
    <link rel="stylesheet" href="/resources/main2/css/animate.min.css" type="text/css">
    <link rel="stylesheet" href="/resources/main2/css/style_j.css" type="text/css">
    <!-- JavaScript -->
    <script type="text/javascript" charset="utf-8"  src="/resources/main2/js/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8"  src="/resources/main2/js/wow.min.js"></script>
    <script type="text/javascript" charset="utf-8"  src="/resources/main2/js/common.js"></script>
    <script type="text/javascript" charset="utf-8"  src="/resources/main2/js/index_script.js"></script>
    <style>
        .banner .banner_center{
            left:39%;
            display:flex;
            justify-content: space-between;
            width:1100px;
        }
        .banner .banner_center div:nth-child(1) h1{
            margin-top:40px;
        }
        .banner .banner_center div:nth-child(2){
            width:360px;
            height:350px;
            background:rgba(0,0,0,0.7);
            display:flex;
            flex-direction: column;
            align-items: center;
            justify-content: space-around;
        }
        .banner .banner_center div:nth-child(2) h3{
            margin-top:20px;
            font-size:26px;
        }
        .banner .banner_center div:nth-child(2) select{
            width:260px;
            height:38px;
            border:1px solid #E3E3E3;
            outline:0;
            padding:0 10px;
        }
        .banner .banner_center div:nth-child(2) input{
            width:260px;
            height:38px;
            border:1px solid #E3E3E3;
            outline:0;
            padding:0 15px;
        }
        .banner .banner_center div:nth-child(2) span{
            display:none;
            color:#FFC200;
            font-size:14px;
            align-self: flex-start;
            margin:-20px 0 0 60px;
        }
        .banner .banner_center div:nth-child(2) >a{
            display:inline-block;
            width:260px;
            height:38px;
            background:#FFC200;
            color:#fff;
            line-height:38px;
            font-size:18px;
            margin:20px 0 40px 0;
            border-radius:6px;
        }
        .banner .banner_center div:nth-child(2) div{
            width:335px;
            height:110px;
            background:rgba(0,0,0,0.8);
            color:#fff;
            font-size:18px;
            position:fixed;
            top:40%;
            left:40%;
            border-radius:6px;
            padding-top:50px;
            display:none;
        }
        .banner .banner_center div:nth-child(2) div a{
            display:inline-block;
            width:100px;
            height:30px;
            background:#FFC200;
            text-align: center;
            line-height:30px;
            color:#fff;
            border-radius:5px;
            margin-top:30px;
        }
    </style>
</head>
<body class="bg_f2" style="zoom: 1;">
<div id="header" class="_index"><div class="header_bg container_full">
    <div class="_header clearfix">
        <div class="_header_left clearfix">

            <!-- logo -->
            <div class="logo"><a href=" "><img src="/resources/main2/logo.png" alt=""></a></div>
            <!-- menu -->
            <div class="menu clearfix">
                <ul>
                    <li><a href="/" class="shouye checked">首页</a></li>
                    <li><a href="/auction" class="gujia">拍卖入口</a></li>
                    <li><a href="/tosale" class="gujia">我要卖车</a></li>
                    <li><a href="/download" class="xiazai">APP下载</a></li>
                    <li><a href="http://www.wukongshouche.com" class="xiazai">悟空收车</a></li>
                </ul>
            </div>

        </div>

        <%--<div class="_header_right clearfix">--%>
        <%--<!-- login_enter -->--%>
        <%--<div class="login_enter clearfix">--%>
        <%--<a href="javascript:void(0)" id="Owner_login_btn">车主登录</a>--%>
        <%--<a href=" " target="_blank">买家入口</a>--%>
        <%--</div>--%>
        <%--<!-- header_tel -->--%>
        <%--<div class="header_tel">--%>

        <%--</div>--%>

        <%--</div>--%>
    </div>
</div></div>
<div id="index"><!-- banner -->
    <div class="banner">

        <div class="banner_bg">
            <img src="/resources/main2/banner.jpg">
            <div class="__bg"></div>
        </div>

        <div class="banner_center">
            <div>
                <h1 class="_wow fadeInUp" data-wow-duration="1.2s">全国收车价最高 </h1>
                <h3 class="_wow fadeInUp" data-wow-duration="1.3s" data-wow-delay="0.4s">交易最长不超过3天</h3>
            </div>
            <div>
                <h3>快速卖车</h3>
                <select name="" id="">
                    <option value="0">全国</option>
                    <option value="1">北京</option>
                    <option value="2">上海</option>
                    <option value="3">广东</option>
                    <option value="4">天津</option>
                    <option value="5">河北</option>
                    <option value="6">山东</option>
                    <option value="7">山西</option>
                    <option value="8">黑龙江</option>
                    <option value="9">吉林</option>
                    <option value="10">辽宁</option>
                    <option value="11">内蒙古</option>
                </select>
                <span id="n1">请选择城市</span>
                <input type="text" placeholder="请输入您的手机号">
                <span id="n2">请输入手机号</span>
                <span id="n3">请输入正确的手机号</span>
                <a href="#" id="sub">提  交</a>
                <div id="pop">
                    <p>提交成功！</p>
                    <a href="#1">OK</a>
                </div>
            </div>
        </div>
    </div>
    <!-- /banner -->




    <!-- warp -->
    <div class="warp">
        <!-- step -->
        <div class="_box_bg" id="Step">
            <div class="_box container">
                <!-- _box_body -->
                <div class="_box_body">

                    <!-- step_list -->
                    <div class="step_list clearfix">

                        <div class="_step_box">
                            <div class="_icon wow fadeInUp animated animated" data-wow-delay="0.5s"
                                 style="visibility: visible; animation-delay: 0.5s; opacity: 1;">
                                <img src="/resources/main2/j.png">
                            </div>
                            <div class="_bottom">
                                <h3 class="wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="0.8s"
                                    style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.8s; opacity: 1;">信息录入</h3>
                                <div class="_desc wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="1.2s"
                                     style="visibility: visible; animation-duration: 1.2s; animation-delay: 1.2s; opacity: 1;">随时预约免费检车</div>
                            </div>
                        </div>

                        <div class="_step_border wow fadeInUp animated animated" data-wow-delay="0.5s"
                             style="visibility: visible; animation-delay: 0.5s; opacity: 1;">
                        </div>

                        <div class="_step_box">
                            <div class="_icon wow fadeInUp animated animated" data-wow-delay="0.5s"
                                 style="visibility: visible; animation-delay: 0.5s; opacity: 1;">
                                <img src="/resources/main2/p.png">
                            </div>
                            <div class="_bottom">
                                <h3 class="wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="0.8s"
                                    style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.8s; opacity: 1;">精准报价</h3>
                                <div class="_desc wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="1.2s"
                                     style="visibility: visible; animation-duration: 1.2s; animation-delay: 1.2s; opacity: 1;">价格行业最高价</div>
                            </div>
                        </div>

                        <div class="_step_border wow fadeInUp animated animated" data-wow-delay="0.5s"
                             style="visibility: visible; animation-delay: 0.5s; opacity: 1;">

                        </div>

                        <div class="_step_box">
                            <div class="_icon wow fadeInUp animated animated" data-wow-delay="0.5s"
                                 style="visibility: visible; animation-delay: 0.5s; opacity: 1;">
                                <img src="/resources/main2/d.png">
                            </div>
                            <div class="_bottom">
                                <h3 class="wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="0.8s"
                                    style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.8s; opacity: 1;">急速打款</h3>
                                <div class="_desc wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="1.2s"
                                     style="visibility: visible; animation-duration: 1.2s; animation-delay: 1.2s; opacity: 1;">过户完毕立即打款</div>
                            </div>
                        </div>
                    </div>
                    <!-- /step_list -->
                </div>
                <!-- /_box_body -->
            </div>
        </div>
        <!-- /step -->


        <!-- Auctionhistory -->
        <div class="_box_bg __in" id="Auctionhistory">
            <div class="_box">
                <!-- _box_head -->
                <div class="_box_head">
                    <h2>
                        <a href=" ">
                            成交记录
                            <i class="_more"></i>
                        </a>
                        <i class="_border"></i>
                    </h2>
                </div>
                <!-- /_box_head -->

                <!-- _box_body -->
                <div class="_box_body">

                    <!-- history_count -->
                    <div class="history_count">
                        <span class="_small">共帮助</span>
                        <strong class="blue" id="history_count">
                            <div class="mt-number-animate">
                                <div>2457389</div>
                            </div>
                        </strong>
                        <span class="_small">名车主成功卖车</span>
                    </div>
                    <!-- /history_count -->
                    <div class="jilu-con">
                        <div class="jilu">

                            <div class="lists">
                                <a href="" class="shadow-car">
                                    <p class="pic">
                                        <img src="/resources/main2/d.jpg" alt="大众 速腾 2007年1.6L手动">
                                    </p>
                                    <h3 class="title">2013款 阁瑞斯MPV 2.0L...</h3>
                                    <p class="option">13年上牌/9万公里/北京</p>
                                    <p class="row">
                                        <span class="date">2017.08.02成交 </span>
                                        <strong class="price">5.20万</strong>
                                    </p>
                                </a>
                            </div>


                            <div class="lists">
                                <a href="" class="shadow-car">
                                    <p class="pic">
                                        <img src="/resources/main2/d1.jpg" alt="大众 速腾 2007年1.6L手动">
                                    </p>
                                    <h3 class="title">2006款 &nbsp; 蒙迪欧&nbsp;  2.5L ...</h3>
                                    <p class="option">07年上牌/10万公里/北京</p>
                                    <p class="row">
                                        <span class="date">2017.07.22成交 </span>
                                        <strong class="price">3.20万</strong>
                                    </p>
                                </a>
                            </div>

                            <div class="lists">
                                <a href="" class="shadow-car">
                                    <p class="pic">
                                        <img src="/resources/main2/d3.jpg" alt="大众 速腾 2007年1.6L手动">
                                    </p>
                                    <h3 class="title">2007款&nbsp; 景程 SX 豪华版 MT</h3>
                                    <p class="option">07年上牌/9万公里/北京</p>
                                    <p class="row">
                                        <span class="date">2017.07.28成交 </span>
                                        <strong class="price">2.0万</strong>
                                    </p>
                                </a>
                            </div>

                            <div class="lists">
                                <a href="" class="shadow-car">
                                    <p class="pic">
                                        <img src="/resources/main2/d4.jpg" alt="大众 速腾 2007年1.6L手动">
                                    </p>
                                    <h3 class="title">2013款 瑞风S5 2.0T 手动 尊享版</h3>
                                    <p class="option">13年上牌/1万公里/北京</p>
                                    <p class="row">
                                        <span class="date">2017.08.10成交 </span>
                                        <strong class="price">6.0万</strong>
                                    </p>
                                </a>
                            </div>

                            <div style="clear: both;"></div>
                        </div>
                    </div>
                </div>
                <!-- /_box_body -->
            </div>
        </div>
        <!-- /Auctionhistory -->



        <!--<a href="/network.htm" target="_blank">-->

        <!-- _box -->
        <div class="_box_bg" id="networkBox">
            <div class="_box">
                <!-- _box_body -->
                <div class="_box_body clearfix">

                    <!-- network_bg -->
                    <div class="network_bg"><img src="/resources/main2/network_bg.jpg"></div>
                    <!-- /network_bg -->

                    <!-- network_text -->
                    <div class="network_text">

                        <div class="__top clearfix wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="0.2s" style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.2s; opacity: 1;">
                            <strong>100</strong>
                            <span class="mr">位优秀评估师</span>
                            <strong>40</strong>
                            <span>位国内顶级评估师</span>
                        </div>
                        <div class="__desc wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="0.6s" style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.6s; opacity: 1;">
                            专业的平台搭建，致车主以极致的汽车交易服务体验，国内二手车电商行业领先产品。
                        </div>

                    </div>
                    <!-- /network_text -->


                </div>
                <!-- /_box_body -->
            </div>
        </div>
        <!-- /_box -->

        <!-- Mediareports -->
        <div class="_box_bg" id="Mediareports">
            <div class="_box container">
                <!-- _box_head -->
                <div class="_box_head">
                    <h2>
                        <a href="">
                            媒体报道
                            <i class="_more"></i>
                        </a>
                        <i class="_border"></i>
                    </h2>
                </div>
                <!-- /_box_head -->

                <!-- _box_body -->
                <div class="_box_body box_bodys">

                    <!-- reports_index -->
                    <div class="reports_index clearfix">

                        <div class="reports_pic first wow bounceIn animated animated" data-wow-duration="1.2s" data-wow-delay="0.2s" style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.2s; opacity: 1;">
                            <a href="javascript:;" class="_rep_bg1" target="_blank">
                                <div class="_rep">
                                    <h2>深度体验长城VV5S,它和博越，</br>长安cs35区别在哪里？</h2>
                                    <div class="__desc">
                                        近几年自主品牌的发展我们有目共睹...
                                    </div>
                                </div>
                            </a>
                        </div>

                        <div class="reports_pic wow bounceIn animated animated" data-wow-duration="1.2s" data-wow-delay="0.2s" style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.2s; opacity: 1;">
                            <a href="/news/1" class="_rep_bg2" target="_blank">
                                <div class="_rep">
                                    <h2>如果买遍《变形金刚5》里的车，</br>
                                        你需要赚几辈子的钱？</h2>
                                    <div class="__desc">
                                        关于汽车的电影视觉大片在2017年让影...
                                    </div>
                                </div>
                            </a>
                        </div>

                        <div class="reports_pic wow bounceIn animated animated" data-wow-duration="1.2s" data-wow-delay="0.2s" style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.2s; opacity: 1;">
                            <a href="/news/2" class="_rep_bg3" target="_blank">
                                <div class="_rep">
                                    <h2>英法相继宣布禁止销售燃油汽车 ，</br>
                                        中国怎么说？</h2>
                                    <div class="__desc">
                                        大家可能也都听说了，法国和英...
                                    </div>
                                </div>
                            </a>
                        </div>

                    </div>
                    <!-- /reports_index -->


                </div>
                <!-- /_box_body -->
            </div>
        </div>
        <!-- /Mediareports -->







        <!-- question -->
        <div class="_box_bg" id="question">
            <div class="_box container">
                <!-- _box_head -->
                <div class="_box_head">
                    <h2>
                        <a href="">
                            常见问题
                            <i class="_more"></i>
                        </a>
                        <i class="_border"></i>
                    </h2>
                </div>
                <!-- /_box_head -->

                <!-- _box_body -->
                <div class="_box_body">

                    <!-- question_index -->
                    <div class="question_index clearfix">

                        <div class="_que_box">
                            <a href="javascript:;">
                                <div class="__icon wow fadeInUp animated animated" data-wow-duration="0.8s" style="visibility: visible; animation-duration: 0.8s; opacity: 1;"><img src="/resources/main2/sf.png"></div>
                                <div class="__bottom">
                                    <h3 class="wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="0.4s" style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.4s; opacity: 1;">是否收费</h3>
                                    <div class="_text wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="0.6s" style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.6s; opacity: 1;">
                                        在优品拍车的卖车是完全免费的。
                                    </div>
                                </div>
                            </a>
                        </div>

                        <div class="_que_box">
                            <a href="javascript:;">
                                <div class="__icon wow fadeInUp animated animated" data-wow-duration="0.8s" style="visibility: visible; animation-duration: 0.8s; opacity: 1;"><img src="/resources/main2/nq.png"></div>
                                <div class="__bottom">
                                    <h3 class="wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="0.4s" style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.4s; opacity: 1;">什么时候打款</h3>
                                    <div class="_text wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="0.6s" style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.6s; opacity: 1;">
                                        车辆过户完成后立马打款
                                    </div>
                                </div>
                            </a>
                        </div>

                        <div class="_que_box">
                            <a href="javascript:;">
                                <div class="__icon wow fadeInUp animated animated" data-wow-duration="0.8s" style="visibility: visible; animation-duration: 0.8s; opacity: 1;"><img src="/resources/main2/dk.png"></div>
                                <div class="__bottom">
                                    <h3 class="wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="0.4s" style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.4s; opacity: 1;">是否安全</h3>
                                    <div class="_text wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="0.6s" style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.6s; opacity: 1;">
                                        专业工作人员维护，全程担保
                                    </div>
                                </div>
                            </a>
                        </div>

                        <div class="_que_box">
                            <a href="javascript:; ">
                                <div class="__icon wow fadeInUp animated animated" data-wow-duration="0.8s" style="visibility: visible; animation-duration: 0.8s; opacity: 1;"><img src="/resources/main2/pg.png"></div>
                                <div class="__bottom">
                                    <h3 class="wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="0.4s" style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.4s; opacity: 1;">评估依据</h3>
                                    <div class="_text wow fadeInUp animated animated" data-wow-duration="1.2s" data-wow-delay="0.6s" style="visibility: visible; animation-duration: 1.2s; animation-delay: 0.6s; opacity: 1;">
                                        专业检车软件，288项评估依据
                                    </div>
                                </div>
                            </a>
                        </div>


                    </div>
                    <!-- /question_index -->

                </div>
                <!-- /_box_body -->
            </div>
        </div>
        <!-- /question -->






    </div>
    <!-- /warp -->

</div>
<%@include file="footer.jsp"%>

<script>
    $('#sub').click(function(){
        var text=$('.banner input').val();
        var reg=/^1[34578]\d{9}$/;
        var ind=$('.banner select').val();
        if(ind==0){
            $('#n1').show().siblings('span').hide();
        }else{
            $('#n1').hide();
            if(!text){
                $('#n2').show().siblings('span').hide();
            }else if(!reg.test(text)){
                $('#n3').show().siblings('span').hide();
            }else{
                $('#pop').fadeIn(200);
                $('#n2').hide();
                $('#n3').hide();
            }
        }
    });
    $('#pop a').click(function(){
       $('#pop').fadeOut(100);
    });
</script>
</body>
</html>
