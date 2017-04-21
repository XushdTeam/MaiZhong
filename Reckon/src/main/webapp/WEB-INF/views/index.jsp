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
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/guzhi.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
</head>
<body>
<!--头部开始-->
<div class="bg_img">
    <div class="top">
        <div class="t_cen">
            <a href="#"><img src="../resources/img/logo.png"></a>
            <span class="tell">010-8025-8108</span>
            <span class="t_right">
                <a href="/sale" class="one">我要卖车</a>
                <a href="/login" class="one">登录</a>
                <a href="" class="two" >136****3782</a>
                <a href="javascript:vold(0)" class="two">APP下载</a></span>
        </div>
    </div><!--top end-->


    <div class="guzs">
       <div class="pinggu">

        <ul class="pt16">
            <li class="mb13" style="z-index:100">
                <div class="select_box" id="select1">
                    <div id="valnone">请 选 择 车 型</div>
                </div>
                <div class="bg0 lr_158_30 select model" id="select1_1" style="display: none"></div>
                <div class="ucarselecttype lr_158_30 select model" id="select1_2" style="width: 227px; height: 450px; display: none;">
                    <div class="ucarselecttype_pinpai " style="width:227px;height:450px">
                        <div class="ucarselecttype_pinpaitop" id="xzpp" style="width:222px;">请选择品牌</div>
                        <div class="left_list letters">
                            <a href="javascript:void(0)" id="letters_0" class="pinpai_num" rel="4">A</a>
                            <a href="javascript:void(0)" id="letters_1" class="pinpai_num" rel="26">B</a>
                            <a href="javascript:void(0)" id="letters_2" class="pinpai_num" rel="32">C</a>
                            <a href="javascript:void(0)" id="letters_3" class="pinpai_num" rel="45">D</a>
                            <a href="javascript:void(0)" id="letters_4" class="pinpai_num" rel="54">F</a>
                            <a href="javascript:void(0)" id="letters_5" class="pinpai_num" rel="60">G</a>
                            <a href="javascript:void(0)" id="letters_6" class="pinpai_num" rel="77">H</a>
                            <a href="javascript:void(0)" id="letters_7" class="pinpai_num" rel="91">J</a>
                            <a href="javascript:void(0)" id="letters_8" class="pinpai_num" rel="99">K</a>
                            <a href="javascript:void(0)" id="letters_9" class="pinpai_num" rel="113">L</a>
                            <a href="javascript:void(0)" id="letters_10" class="pinpai_num" rel="122">M</a>
                            <a href="javascript:void(0)" id="letters_11" class="pinpai_num" rel="124">N</a>
                            <a href="javascript:void(0)" id="letters_12" class="pinpai_num" rel="128">O</a>
                            <a href="javascript:void(0)" id="letters_13" class="pinpai_num" rel="133">Q</a>
                            <a href="javascript:void(0)" id="letters_14" class="pinpai_num" rel="137">R</a>
                            <a href="javascript:void(0)" id="letters_15" class="pinpai_num" rel="150">S</a>
                            <a href="javascript:void(0)" id="letters_16" class="pinpai_num" rel="154">T</a>
                            <a href="javascript:void(0)" id="letters_17" class="pinpai_num" rel="160">W</a>
                            <a href="javascript:void(0)" id="letters_18" class="pinpai_num" rel="169">X</a>
                            <a href="javascript:void(0)" id="letters_19" class="pinpai_num" rel="177">Y</a>
                            <a href="javascript:void(0)" id="letters_20" class="pinpai_num" rel="185">Z</a>                                            </div>
                        <div class="ucarselecttype_pinpaibottom brandgun" style="width:180px;">
                            <div class="ucarselecttype_pinpaibottom_ul brand">
                                <c:forEach items="${brandList}" var="i">
                                    <p id="${i.key}" class="pinpailist" style="background:#e3e3e3;text-align:center">${i.key}</p>
                                    <c:forEach items="${i.object}" var="j">
                                        <p class="pinpailist list_1" id="${j.key}" rel="A">${j.value}</p>
                                    </c:forEach>
                                </c:forEach>
                             </div>
                        </div>
                    </div>
                </div>
                <div class="bg0 lr_158_30 select model" style="width: 210px;height: 458px;left: 252px;display: none;" id="select2_1"></div>
                <div class="ucarselecttype lr_158_30 select model" style="left:260px;width:200px;height:450px;display: none;" id="select2_2">
                    <div class="ucarselecttype_pinpai" style="width:190px; height:450px;">
                        <div class="ucarselecttype_pinpaitop" id="xzcx" style="width:190px;">
                            请选择车系
                        </div>
                        <div class="ucarselecttype_pinpaibottom" style="width:190px;">
                            <div class="ucarselecttype_pinpaibottom_ul series"></div>
                        </div>
                    </div>
                </div>
                <div class="bg0 lr_158_30 select model" style="width:420px; height:458px; left:463px;display: none;" id="select3_1"></div>
                <div class="ucarselecttype lr_158_30 select model" style="left:472px;width:411px;height:450px;display: none;" id="select3_2">
                    <div class="ucarselecttype_pinpai last" style="width:400px;height:450px;">
                        <div class="ucarselecttype_pinpaitop" id="xzcxing" style="width:400px;">请选择车型</div>
                        <div class="ucarselecttype_pinpaibottom" style="width:400px;">
                            <div class="ucarselecttype_pinpaibottom_ul simple"></div>
                        </div>
                    </div>
                </div>
            </li>
            <li class="mb13" style="z-index:99">
                <div class="select_box" id="select4">请 选 择 年 份</div>
                <div class="bg1 lr_158_30 sele regDate" id="sele1_1" style="height:365px;display: none;"></div>
                <div class="ucarselecttype lr_158_30 sele regDate" id="sele1_2" style="width:182px;height:310px;display: none;">
                    <div class="ucarselecttype_pinpai" style="height:310px;">
                        <div class="ucarselecttype_pinpaitop selyear" style="width:180px;">选择年份</div>
                        <div class="ucarselecttype_pinpaibottom" style="height:320px;width:163px; margin-left:7px">
                            <div class="ucarselecttype_pinpaibottom_ul years"></div>
                        </div>
                    </div>
                </div>
                <div class="bg1 lr_158_30 sele regDate" id="sele2_1" style="height:365px;left:208px;display: none;"></div>
                <div class="ucarselecttype lr_158_30 sele regDate" id="sele2_2" style="left:206px;width:182px;height:340px;display: none;">
                    <div class="ucarselecttype_pinpai" style="height:340px;">
                        <div class="ucarselecttype_pinpaitop selmonth" style="width:180px;">选择月份</div>
                        <div class="ucarselecttype_pinpaibottom" style="height:320px;width:165px; margin-left:7px">
                            <div class="ucarselecttype_pinpaibottom_ul months"></div>
                        </div>
                    </div>
                </div>
            </li>
            <li class="mb13" style="z-index:88">
                <div class="select_box" id="select5">
                    北京</div>
                <div class="bg1 lr_158_30 sel zone" id="sel1_1" style="display: none;"></div>
                <div class="ucarselecttype lr_158_30 sel zone" id="sel1_2" style="width:182px;height:310px;display: none;">
                    <div class="ucarselecttype_pinpai" style="height:310px;">
                        <div class="ucarselecttype_pinpaitop selprov" style="width: 170px;">选择省份</div>
                        <div class="ucarselecttype_pinpaibottom" style="height:265px;width:165px; margin-left:7px">
                            <div class="ucarselecttype_pinpaibottom_ul select_province">
                               <c:forEach items="${proviceList}" var="i" varStatus="status">
                                   <p class="list_6 province <c:if test="${status.count == 1}">layerbg2</c:if>" id="${i.id}">${i.name}</p>
                               </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="bg1 lr_158_30 sel zone" id="sel2_1" style="left:208px;display: none;"></div>
                <div class="ucarselecttype lr_158_30 sel zone" id="sel2_2" style="left:206px;width:182px;height:310px;display: none;">
                    <div class="ucarselecttype_pinpai" style="height:310px;">
                        <div class="ucarselecttype_pinpaitop selcity">选择城市</div>
                        <div class="ucarselecttype_pinpaibottom" style="height:265px;width:160px; margin-left:7px">
                            <div class="ucarselecttype_pinpaibottom_ul select_city">
                                <p class="pinpailist list_7 layerbg2 pinpailisthover" id="1">北京</p>                                                                      </div>
                        </div>
                    </div>
                </div>
            </li>
            <li class="mb13" style="z-index:77">
                <div class="select_box none" id="gongli">
                    <input name="s_km" type="text" class="numgongli" id="lichengpd" maxlength="6" autocomplete="off" style="padding-left:0;">
                    <label>万公里</label>
                </div>
            </li>
            <li>
                <input type="hidden" name="s_brand" id="s_brand" value="0">
                <input type="hidden" name="s_series" id="s_series" value="0">
                <input type="hidden" name="s_simple" id="s_simple" value="0">
                <input type="hidden" name="s_year" id="s_year" value="0">
                <input type="hidden" name="s_mouth" id="s_month" value="0">
                <input type="hidden" name="s_province" id="s_province" value="1">
                <input type="hidden" name="s_city" id="s_city" value="1">
                <input id="cityList" type="hidden" value="">
            </li>
        </ul>
        <div class="submit" id="eval">快速估值</div>
    </div>

    </div>
    <%--<!--估值-->--%>
    <%--<div class="guz">--%>
        <%--<ul>--%>
            <%--<li>--%>
                <%--<div class="img">选择车型</div>--%>

            <%--</li>--%>
            <%--<li>--%>
                <%--<div class="img">选择年份</div>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<div class="img">北京</div>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<div><input type="text" name="" />万公里</div>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<div class="last">快速估值</div>--%>
            <%--</li>--%>
        <%--</ul>--%>
    <%--</div>--%>
    <!--估值end-->
</div><!--bg_img end-->
<!--头end-->


<!--流程-->
<div class="liu">
    <div class="l_cen">
        <h2>我们的流程</h2>
        <p>快速成交，立马打款，及时有效</p>

        <dl>
            <dt class="dt1"></dt>
            <dd>网上定价</dd>
        </dl>

        <dl>
            <dt class="dt2"></dt>
            <dd>预约检测</dd>
        </dl>

        <dl>
            <dt class="dt3"></dt>
            <dd>现场打款</dd>
        </dl>

        <dl>
            <dt class="dt4"></dt>
            <dd>售后保障</dd>
        </dl>
    </div>
</div>
<!--流程 end-->


<!--交易记录-->
<div class="jiao">

    <div class="j_cen">

        <h2>交易记录</h2>
        <p>真实记录、公正透明、超高效率</p>
        <div class="one">
            <span class="cl_one">成交车型</span>
            <span>新车指导价</span>
            <span>成交价</span>
            <span>上牌时间</span>
            <span>公里数</span>
            <span>成交日期</span>
            <span>城市</span>
            <span class="last">类别</span>
        </div>


        <div>
            <span class="cl_one">2106 奥迪A3 Limousine 35 TFSI 进取型</span>
            <span> 19.90万 </span>
            <span>14.60万</span>
            <span>2016年11月 </span>
            <span>0.85万公里 </span>
            <span>2017年04月01日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>


        <div>
            <span class="cl_one">2010款 雅阁 2.0L 自动庆典版 </span>
            <span> 19.98万 </span>
            <span>6.19万</span>
            <span>2010年7月 </span>
            <span>14万公里 </span>
            <span>2017年04月03日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>


        <div>
            <span class="cl_one">2013款 奥迪Q3 35 TFSI quattro 舒适型</span>
            <span>35.68万 </span>
            <span>15.90万</span>
            <span>2013年7月 </span>
            <span>12万公里 </span>
            <span>2017年03月02日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>

        <div>
            <span class="cl_one">2012款 北汽E系列两厢 1.5L 自动 乐尚版 </span>
            <span>7.51万</span>
            <span>1.88万</span>
            <span>2012年6月 </span>
            <span>18万公里 </span>
            <span>2017年03月23日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>

        <div>
            <span class="cl_one">2013款 比亚迪S6 2.4L 自动 尊荣型 劲悦版 </span>
            <span>12.99万 </span>
            <span>4.42万</span>
            <span>2013年6月 </span>
            <span>12万公里 </span>
            <span>2017年03月01日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>

        <div>
            <span class="cl_one">2011款 高尔夫 1.4TSI 自动舒适型</span>
            <span>14.98万 </span>
            <span>5.30万</span>
            <span>2011年9月 </span>
            <span>13万公里 </span>
            <span>2017年03月16日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>

        <div>
            <span class="cl_one">2012款 哈弗H6 2.4L 手动 汽油 两驱 尊贵型 </span>
            <span>12.48万</span>
            <span>4.42万</span>
            <span>2012年8月 </span>
            <span>10万公里 </span>
            <span>2017年03月15日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>

        <div>
            <span class="cl_one">2011款 凯越 1.6 LX-MT</span>
            <span>9.99万</span>
            <span>2.82万</span>
            <span>2011年7月 </span>
            <span>12万公里 </span>
            <span>2017年04月13日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>

        <div>
            <span class="cl_one">2013款 宝来 1.4T 手动 舒适型 </span>
            <span>12.63万</span>
            <span>5.30万</span>
            <span>2013年11月 </span>
            <span>12万公里 </span>
            <span>2017年04月15日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>


        <div>
            <span class="cl_one">2013款 赛欧两厢 1.2L 手动理想版 </span>
            <span>6.18万</span>
            <span>1.77万</span>
            <span>2013年10月 </span>
            <span>8万公里 </span>
            <span>2017年04月23日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>

    </div>
</div>

<!--交易记录 end-->


<!--关于我们-->
<div class="about">
    <div class="a_cen">
        <img src="../resources/img/logo2.png">
        <div class="abs"><img src="../resources/img/x.png">关于我们/<span>about us</span></div>

        <div class="right">
            <p>北京迈众汽车信息服务有限公司</p>

            北京迈众汽车信息服务有限公司，是一家致力服务于各大汽车经销商。推进4S店新车销量与市场流量的专业服务公司。2017年4月15日，产品正式上线，我们将成为中国领先的专业服务于各大汽车集团、4s店与C端客户的互联网平台，通过产品服务、数据技术和资源 共享为汽车消费者提供选车、买车、用车、换车、金融、维修、美容、装饰等全方位一体的快捷专业的一站式服务端口，通过我们的平台将庞大的客户资源与各大汽车集团、4S店服务资源优选整合。公司将秉承“杰出服务，行业领先”的经营理念，开启汽车互联网新纪元。</div>

        <div class="left">
            <div class="one">
                <div class="x_l">
                    <span>专业专注</span>
                    <span>客户至上</span>
                    <span class="spans"> 迈众汽车经营理念</span>
                </div>
                <div class="x_r">
                    <span>贴心服务</span>
                    <span>迈众宗旨</span>
                </div>

            </div>

        </div>
    </div>


</div>
<!--关于我们 end-->
<jsp:include page="footer.jsp"></jsp:include>
<script src="/resources/js/index.js"></script>
</body>
</html>