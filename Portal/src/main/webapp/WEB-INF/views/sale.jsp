<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/20
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
    <link rel="stylesheet" type="text/css" href="/resources/style/base.css" />
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<!--ban 开始-->
<div class="bans">
    <div class="ban_cen">
        <div class="ban_form">
            <p class="p_top">成功卖车<span>4656567</span>人</p>
            <from>
                <input type="text" name="4" required placeholder="请输入手机号" class="inputs">
                <h2>免费卖车</h2>
                <div class="h_cens">
                    <label>后续计划</label>
                    <input type="radio" value="2" name="r">团购新车
                    <input type="radio" value="e" name="r">旧车换新车
                    <input type="radio" value="5" name="r">不买车
                </div>
            </from>
            <p class="calls">400-429-0902 免费咨询</p>
            <div class="pinggu"><a href="#">我要评估</a></div>
        </div>


    </div><!--ban_cen end-->
</div>
<!--ban end-->
<!--main-->
<div class="bg_color">
    <!--4个优势-->
    <div class="ma_cen">
        <dl>
            <dt>1</dt>
            <dd>在线预约</dd>
        </dl>
        <dl>
            <dt>2</dt>
            <dd>提交资料</dd>
        </dl>
        <dl>
            <dt>3</dt>
            <dd>到店检测</dd>
        </dl>
        <dl>
            <dt>4</dt>
            <dd>交易过户</dd>
        </dl>
    </div>
</div>
<!--mains end-->

<div class="newCarSaleCon-tit">卖车者说</div>
<div class="newCarSaleCon-say">
    <ul>
        <li class="bor">
            <div class="header-box pr">
                <span class="header-box-l">
                  <img src="/resources/img/user_h4.png"></span>
            <span class="header-box-r">
                  <strong>刁先生：</strong>儿子毕业已成家，想换一辆7座的大车。感觉迈众这样的大平台卖车让人放心，不会发生价格欺诈，就选择在这里卖车。迈众的报价符合心理预期，检测人员和服务人员都很专业，解释也比较到位，手续不复杂、很方便。
            </span>
            </div>
            <div class="car-img pr16">

                <img src="/resources/img/new-s-car3.png" alt="">
            </div>
        </li>
        <li>
            <div class="header-box pl">
                <span class="header-box-l"><img src="/resources/img/user_h4.png"></span>
            <span class="header-box-r">
                  <strong>李先生：</strong>我的A6在迈众上给出的价格在19万左右，比之前去4S店保养时店里报给的价格高，于是预约了检测。检测之后，属于A级车况，还是19万，价格有效期居然长达15天，非常赞。签订协议后，当天就收到了车款，效率非常高。
            </span>
            </div>
            <div class="car-img pl16">

                <img src="/resources/img/new-s-car3.png" alt="">
            </div>

        </li>
    </ul>
</div><!--newCarSaleCon-say end-->
<div class="bg_color bg_s">
    <div class="newCarSaleCon-tit">卖车小知识</div>
    <div class="newCar-question-list">
        <ul class="cFaq">
            <li>
                <!--  <label>Q1</label> -->
                <p><em>在迈众卖车能卖到理想价位吗？</em><span>您只要提交信息，我们就会通过大数据定价系统出具报价，如果您对此价格不满意，我们还会获取百万用户和车商的报价，海量报价任您选，若有满意的报价随时可预约看车，双方同意即可成交。</span></p>
            </li>
            <li>
                <!--  <label>Q1</label> -->
                <p><em>为什么在迈众上卖车成交快？</em><span>迈众拥有海量的车商和个人买车用户，当您到达迈众门店完成车辆检测后，就能在20分钟以内收到一个合理的报价，如果您接受这个价格就能立即进行成交并获得90%的首款，待过户完成获得剩余的10%。</span></p>
            </li>
            <li>
                <!--  <label>Q2</label> -->
                <p><em>出售车辆需要符合怎样的条件？</em><span>只要您的车辆为非营运车辆且相关手续齐全即可在我们平台出售。</span></p>
            </li>
            <li>
                <!--  <label>Q3</label> -->
                <p><em>卖车需要准备哪些材料？</em><span>只需要提供您的身份证、行驶证、登记证、购置税本、购车发票，如果车辆为公车，还需要提供相关的组织机构代码信息。</span></p>
            </li>
            <li>
                <p><em>是否收取费用？</em><span>卖车全过程我们是不收取卖家任何费用的，成交时我们会按比例收取买家少量费用。</span></p>
            </li>
            <li>
                <p><em>卖车流程是什么样的？</em><span>1、通过迈众网站或者迈众手机应用提交车辆信息和联系方式；2、到迈众门店进行免费的30分钟专业检测，并在检测完成的20分钟内得到报价；3、达成交易，迈众全程帮办\陪同完成过户。</span></p>
            </li>
        </ul>
    </div><!--newCar-question-list end-->

</div> <!--bg_colocr end-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
