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
            <h3>二手车行业存在一个潜规则-----------塞价</h3>
            <p class="MsoNormal" style="text-indent:24.1pt;vertical-align:baseline;">
                <b><span style="font-size:16px;line-height:1.5;color:#E53333;">塞价</span></b><span style="font-size:16px;line-height:1.5;">是 “黄牛”最常用的收车手段，很多朋友在卖车前都会通过网络电话广播或者二手车市场来咨询自己车辆的价格，但一般很难得到准确的市场行情，“黄牛”一般都会在您询价的时候给报一个虚高于市场的价格，因为他明白您是在询价，不是当时成交，报高价才能吸引您再次回来。 </span><span></span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">碰到询价的客户，“黄牛”一般会问两个问题。</span><span> </span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">今天能卖吗？</span><span> </span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">想卖多少钱？</span><span> </span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">看着随便问的两个问题实际上就要确定怎么塞价，塞多少钱合适，第一个问题是想确定客户是出于询价阶段还是着急卖，自己此时要不要塞价，第二个问题就是了解客户的心理低价，确定塞多少钱合适，也会遇到一些警惕性非常高的客户，不作直接的回答，也不要紧，“黄牛”一般非常有经验，应对自如，有些客户会说，价格合适就马上卖，那“黄牛”紧跟着会问：</span><span style="font-size:16px;line-height:1.5;">“</span><span style="font-size:16px;line-height:1.5;">手续带齐了吗？我帮你看看吧，一般人不到真实卖车的时候不会带着齐全的手续，或是显得很随便的问一问，是不是换新车呀？还会借机跟您侃一通新车的品牌好坏等，都是要确定客户是在询价还是马上就能卖？第二个问题是要摸出客户的心理底价，有没有被人塞过价，塞了多少钱，自己要塞多少钱合适，这个是有一定的技术含量的。
用悟空收车平台，不被潜规则，评估项属实，绝不议价，快速到账省去东奔西跑。</span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
	<span style="font-size:16px;line-height:1.5;"><br />
</span>
            </p>
            <p class="MsoNormal" style="vertical-align:baseline;">
                <b><span style="color:#E53333;font-size:18px;line-height:1.5;">选什么样的车更保值，悟空收车教你</span></b>
            </p>
            <p class="MsoNormal" style="vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">二手车中不同车型也有其相应的保值率，那就是市场上的热销车。</span><span></span>
            </p>
            <p class="MsoNormal" style="vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">对于二手车市场各车系热销车型，其所有车型保值率大致都有以下共同特征：</span><span></span>
            </p>
            <p class="MsoNormal" style="vertical-align:baseline;">
                <b><span style="font-size:16px;line-height:1.5;">保有量与保值率成正比。</span><span></span></b>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">车型热销，保有量大，市场占有率相对较高，价格相对稳定，因此未来保值率较高。比如广汽本田在国内已有</span><span style="font-size:16px;line-height:1.5;">200</span><span style="font-size:16px;line-height:1.5;">万辆车下线，其中</span><span style="font-size:16px;line-height:1.5;">100</span><span style="font-size:16px;line-height:1.5;">万辆是雅阁，飞度是继雅阁之后广本的第二大畅销车型，这两款车型保有量之大可以想像，其保值率自然位居各车系前列。</span><span style="font-size:16px;line-height:1.5;">“</span><span style="font-size:16px;line-height:1.5;">以前要是有辆普桑不用担心卖不掉，现在要是有辆飞度，肯定能赚钱，其正常行情价格一直在</span><span style="font-size:16px;line-height:1.5;">6</span><span style="font-size:16px;line-height:1.5;">万元浮动。</span><span style="font-size:16px;line-height:1.5;">”</span><span style="font-size:16px;line-height:1.5;">这是二手车市场评估人员对飞度的评价。此外，凯越、帕萨特、</span><span style="font-size:16px;line-height:1.5;">CR-V</span><span style="font-size:16px;line-height:1.5;">等热销车也是高保值率的佼佼者。</span><span style="font-size:16px;line-height:1.5;">&nbsp;&nbsp;</span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
	<span style="font-size:16px;line-height:1.5;"><br />
</span>
            </p>
            <p class="MsoNormal" style="vertical-align:baseline;">
                <b><span style="font-size:16px;line-height:1.5;">品牌认知度影响很大</span><span></span></b>
            </p>
            <p class="MsoNormal" style="margin-left:0cm;text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">汽车品牌对保值率的影响非常明显。一般来说，德系车使用两年后的保值率大约为七成左右。在沪上二手车市场，以</span><span style="font-size:16px;line-height:1.5;">POO</span><span style="font-size:16px;line-height:1.5;">、普桑、宝来、帕萨特等大众品牌为代表的德系车是非常抢手的香饽饽，其保值率也最高；其次，骐达、轩逸等日系车燃油经济性方面表现出色，因此也较受欢迎；自主品牌车型中，仅销量巨大的比亚迪</span><span style="font-size:16px;line-height:1.5;">F3</span><span style="font-size:16px;line-height:1.5;">和江淮瑞风较常见，其余品牌车型量少，保值率也低。</span><span style="font-size:16px;line-height:1.5;">&nbsp;</span>
            </p>
            <p class="MsoNormal" style="margin-left:0cm;text-indent:24.0pt;vertical-align:baseline;">
	<span style="font-size:16px;line-height:1.5;"><br />
</span>
            </p>
            <p class="MsoNormal" style="vertical-align:baseline;">
                <b><span style="font-size:16px;line-height:1.5;">新车价越稳保值率越高</span><span></span></b>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">二手车价格评估中很重要的一个参照标准，就是该款新车当时的实际售价，以此为基准按照折旧率的比例进行评估。如一款高配版手动挡凯越，厂家指导价为</span><span style="font-size:16px;line-height:1.5;">10.78</span><span style="font-size:16px;line-height:1.5;">万元，优惠后的实际售价一般为</span><span style="font-size:16px;line-height:1.5;">9.5</span><span style="font-size:16px;line-height:1.5;">万元左右，该车在二手评估时需参照</span><span style="font-size:16px;line-height:1.5;">9.5</span><span style="font-size:16px;line-height:1.5;">万元的价格进行折旧。这说明新车价格越稳定，二手车价越坚挺。</span><span></span>
            </p>
            <p class="MsoNormal" style="vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">而对于一些上市之初定价虚高的车型，二手车经纪公司收购时会压价格，所以尽可能要选择一些成熟企业的产品，价格相对较稳定，短期内还不会停产。</span>
            </p>
            <p class="MsoNormal" style="vertical-align:baseline;">
	<span style="font-size:16px;line-height:1.5;"><br />
</span>
            </p>
            <p class="MsoNormal" style="vertical-align:baseline;">
                <b><span style="font-size:16px;line-height:1.5;">日常养护也影响保值率</span><span></span></b>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">日常养护要考虑两方面，一是使用成本越高，保值率越低。最为明显的表现在美系车型上。虽然美系车性能好，品质高，在品牌价值上也被认可，但其</span><span style="font-size:16px;line-height:1.5;">“</span><span style="font-size:16px;line-height:1.5;">油老虎</span><span style="font-size:16px;line-height:1.5;">”</span><span style="font-size:16px;line-height:1.5;">的特征使车辆的后期使用成本增加了不少。</span><span></span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">另一方面是售后保养越方便，保值率越高。其中大众的车型绝对是沪上二手车市场的销售主力，</span><span style="font-size:16px;line-height:1.5;">500</span><span style="font-size:16px;line-height:1.5;">多家特约维修站遍布全国，形成国内最大的售后服务网络，无论何处都能买到优质价廉的零配件，都能得到便捷的维修服务。相比来说，奇瑞的维修网点在上海就不多，其二手车型市场上几乎看不到。</span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
	<span style="font-size:16px;line-height:1.5;"><br />
</span>
            </p>
            <p class="MsoNormal" style="vertical-align:baseline;">
                <b><span style="font-size:16px;line-height:1.5;">车按价分，不同市场不同对待</span><span></span></b>
            </p>
            <p class="MsoNormal" style="margin-left:27.35pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">根据价格不同，车辆也分多种档次，而在不同档次的细分领域，各车型所呈现的特征也不尽相同，考察不同款型类别的车型保值率需要区别对待。</span>
            </p>
            <p class="MsoNormal" style="margin-left:27.35pt;vertical-align:baseline;">
	<span style="font-size:16px;line-height:1.5;"><br />
</span>
            </p>
            <p class="MsoNormal" style="margin-left:27.35pt;vertical-align:baseline;">
                <br />
            </p>
            <p class="MsoNormal" style="vertical-align:baseline;">
                <b><span style="font-size:16px;line-height:1.5;">15</span></b><b><span style="font-size:16px;line-height:1.5;">万元以下车型（经济型车和中级车）</span></b><b><span style="font-size:16px;line-height:1.5;">换车把握后三年</span></b>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">这部分车型在市场中占有比例最大，加之这类车型的市场保有量大和保养维修的成熟，使得多数车型的保值率较高。如</span><span style="font-size:16px;line-height:1.5;">POO</span><span style="font-size:16px;line-height:1.5;">、骐达、明锐、凯越等，保有量大，配件便宜，消费者比较青睐，造成其二手车价格居高不下。这一级别二手车型的消费者对品牌的重视程度较弱，而主要关注车型本身的性能和品质表现。简而言之，小车质量越稳定、可靠，保值率也自然提高。</span><span></span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;">
                <span style="font-size:16px;line-height:1.5;">不过，越便宜的车型，在前三年的保值率排名中占据较明显优势，但三年一过，宝来、明锐等原价相对较高的中级车型优势显现，其</span><span style="font-size:16px;line-height:1.5;">4-5</span><span style="font-size:16px;line-height:1.5;">年的保值率较高。因为一般车辆到了第三、第四年，行驶里程已经接近十万公里，需要进行一些比较大的维修保养项目，这个时期最能反映车辆品质的差异。这部分车主要换车，最好把握住第四年和第五年这个黄金节点。如果你的车够保值，这时最能体现车辆的保值率优势。</span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;">
	<span style="font-size:16px;line-height:1.5;"><br />
</span>
            </p>
            <p class="MsoNormal" style="vertical-align:baseline;">
                <b><span style="font-size:16px;line-height:1.5;">15</span></b><b><span style="font-size:16px;line-height:1.5;">万元以上车型（中高级车）
高龄车辆难出手</span><span></span></b>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">中高级车的保值率在使用期的前五年规律与中级车的保值率基本一致，但从第六年后中高级车的贬值率比中级车的贬值率要高一些。一般来说价格越高的车型保值率也就越低。正常情况下，一年的旧车折旧</span><span style="font-size:16px;line-height:1.5;">20%</span><span style="font-size:16px;line-height:1.5;">，之后每过一年折旧</span><span style="font-size:16px;line-height:1.5;">10%</span><span style="font-size:16px;line-height:1.5;">，车价越高的车型掉价也越快，因此保值率也就相对要低。</span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
	<span style="font-size:16px;line-height:1.5;"><br />
</span>
            </p>
            <p class="MsoNormal" style="vertical-align:baseline;">
                <b><span style="font-size:16px;line-height:1.5;">高档车及进口车
三大品牌仍是保证</span><span></span></b>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">奥迪、宝马、奔驰三大品牌是这部分车型中保值率最高的。它们的生产历史比较长、质量比较稳定，品牌形象高，保有量大。不过这些二手车型的购买者并非完全是家用，像奥迪</span><span style="font-size:16px;line-height:1.5;">A6</span><span style="font-size:16px;line-height:1.5;">给人的官车形象已经深入人心，就是众多商务人士或单位追求的热点车型，还有的则是被购买作婚庆用车。</span><span></span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">越高档车型越容易受到换代车型影响，尤其以</span><span style="font-size:16px;line-height:1.5;">40</span><span style="font-size:16px;line-height:1.5;">万元以上的车型最为明显。如</span><span style="font-size:16px;line-height:1.5;">2004-2005</span><span style="font-size:16px;line-height:1.5;">年间的奥迪</span><span style="font-size:16px;line-height:1.5;">A6</span><span style="font-size:16px;line-height:1.5;">，其老款车型二手价格约为</span><span style="font-size:16px;line-height:1.5;">16</span><span style="font-size:16px;line-height:1.5;">万元，一旦换代，即使是同一年份，价格立马高出</span><span style="font-size:16px;line-height:1.5;">8</span><span style="font-size:16px;line-height:1.5;">万元，有的甚至提高</span><span style="font-size:16px;line-height:1.5;">20%</span><span style="font-size:16px;line-height:1.5;">。</span><span></span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">这部分车型中，最好卖的莫过于帕萨特。梁文杰告诉记者，</span><span style="font-size:16px;line-height:1.5;">“</span><span style="font-size:16px;line-height:1.5;">帕萨特基本上收一辆就能卖一辆，</span><span style="font-size:16px;line-height:1.5;">”</span><span style="font-size:16px;line-height:1.5;">在二手车市场，帕萨特车型每月的销量都领先。统计来看，帕萨特、雅阁、君威等卖的较好的车型近</span><span style="font-size:16px;line-height:1.5;">80%</span><span style="font-size:16px;line-height:1.5;">的车身颜色均为黑色，这和它们主打公务车市场有很大关系。</span><span></span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">日系车在二手车市场里销得不错，但同为日系，内部排名今年以来悄然发生了变化。</span><span style="font-size:16px;line-height:1.5;">“</span><span style="font-size:16px;line-height:1.5;">前几年，丰田和本田系列车型是同等受欢迎的，但受召回影响，丰田车型在二手车市场的保值率开始下跌。市场售价差不多的凯美瑞和雅阁，在二手车市场上现在相差</span><span style="font-size:16px;line-height:1.5;">4000-5000</span><span style="font-size:16px;line-height:1.5;">元。</span><span style="font-size:16px;line-height:1.5;">”</span><span style="font-size:16px;line-height:1.5;">相比来说，日产车的保值率在中高级车二手市场倍受青睐，如天籁，其保值率就一直很稳定。由于买这部分车型的车主不差钱，观念新，重视排场和外观，其对于车的理解大都认为新款比旧款好，所以多半会多掏钱购买相对款型较新的车型。老车型的退市往往意味着其在二手市场上将加快贬值步伐，所以对于购买该级别二手车的消费者来说，应尽量避免购买即将换代的车型。</span><span></span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;vertical-align:baseline;">
                <span style="font-size:16px;line-height:1.5;">高档和进口车型的保值率受品牌的影响因素非常大。相比上面三大高知名度的高档车品牌，一些小众的进口车品牌在二手车市场的价格要差许多。如斯巴鲁，</span><span style="font-size:16px;line-height:1.5;">40</span><span style="font-size:16px;line-height:1.5;">多万元的新车，使用一年后在二手车市场的价格就跌了近一半；二手市场上</span><span style="font-size:16px;line-height:1.5;">2007</span><span style="font-size:16px;line-height:1.5;">年的萨博，三年时间折了</span><span style="font-size:16px;line-height:1.5;">20</span><span style="font-size:16px;line-height:1.5;">万元。诸如类似的还有沃尔沃、雷诺等品牌。一般大众化的车价格透明，小众车型价格起伏则很大。</span><span></span>
            </p>
            <p class="MsoNormal" style="text-indent:24.0pt;">
                <span style="font-size:16px;line-height:1.5;">&nbsp;</span>
            </p>
            <span style="font-size:16px;line-height:1.5;"></span>
            <p>
                <br />
            </p>

        </div>
    </div><!--X_con-->
</div>

<div class="cj" style="margin-top: -40px;">
    <div class="cj_cen" id="owl-example" style="background: #F8F8F8">


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
