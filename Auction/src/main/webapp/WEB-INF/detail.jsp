<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/8/4
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${title}</title>
    <%@ include file="head.jsp"%>
    <link href="/resources/main/css/CarDetailCss.css" rel="stylesheet">
    <style>
        .large_fixe_span{
            position: absolute;
            width: 100%;
            height: 40px;
            background: rgba(0,0,0,.6);
            top: 360px;
            text-align: center;
            font-size: 14px;
            line-height: 40px;
            color: #FFF;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
        .samll_fixe_span{
            width: 100%;
            height: 20px;
            line-height: 20px;
            background: rgba(0,0,0,.9);
            position: absolute;
            top: 52px;
            color: #FFF;
            z-index: 1989;
            text-align: center;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>
</head>
<body class="page1200">
    <%@ include file="nav.jsp"%>
    <div class="w1200 mauto" style="z-index: 1000">
        <div class="clearad"></div>
        <div class="crumbs mt20">
            当前位置:
            <a href="/" target="_blank">首页</a> &gt; <a href="/list" target="_blank">交易大厅</a> &gt; <span class="carName">${title}</span>
        </div>

        <div class="nw1200 mauto mt20">
            <div class="car-info pr zi2">
                <%--banner--%>
                <div class="car-box">
                    <div class="banners">
                        <div class="large_box">
                            <ul>
                                <c:forEach items="${carInfo.baseImgArry}" var="item" varStatus="status">
                                    <li style="display: none;">
                                        <img src="${item.img}" width="580" height="400" onclick="showImg(${status.index})">
                                        <span class="large_fixe_span">${item.desc}</span>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="small_box">
                            <span class="btn left_btn"><</span>
                            <div class="small_list">
                                <ul style="width: 720px; ">
                                    <c:forEach items="${carInfo.baseImgArry}" var="item">
                                        <li class="">
                                            <img src="${item.img}" width="110" height="73">
                                            <span class="samll_fixe_span">${item.desc}</span>
                                            <div class="bun_bg"></div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                            <span class="btn right_btn">></span>
                        </div>
                    </div>



                </div>
                <%--right info--%>
                <div class="pr car-info-right">
                    <img src="/resources/main/img/over.png" alt="已结束" class="car-info-over hide auctionEnd">
                    <h1 class="pr">
                        <span class="car-info-name  carName" >${carInfo.modelName}</span>
                    </h1>
                    <ul class="car-info-tab clearfix fs14 mt15">
                        <li class="first">
                            <p class="regDate">${carInfo.djz.cdrq}</p>
                            <span>初登日期</span>
                        </li>
                        <li>
                            <p class="mileage">${carInfo.verify.bxlc}万公里</p>
                            <span>行驶里程</span>
                        </li>
                        <li>
                            <p id="rName">${carInfo.djz.zcd}</p>
                            <span>所在地</span>
                        </li>
                        <li>
                            <p class="pf">${carInfo.other.pfbz}</p>
                            <span>排放标准</span>
                        </li>
                        <li class="last">
                            <p class="ghTime">${carInfo.djz.ghcs}次</p>
                            <span>过户次数</span>
                        </li>
                    </ul>
                    <%--等级--%>
                    <div class="car-info-grade mt15">
                        <div class="tip-con">
                            <p>A：全车除前后保险杠外无修复痕迹</p>
                            <p>B：全车结构件无损伤，加强件无严重损伤，允许覆盖件有修复</p>
                            <p>C：全车结构件无重大损伤，允许覆盖件和加强件有修复</p>
                            <p>D：全车结构件发生一处或多处变形类损伤</p>
                        </div>
                        <p class="car-info-grade-pr inblock vm"></p>
                        <p class="car-info-grade-num inblock vm"><span id="rak">${carInfo.other.pj} ${carInfo.other.pjDes1}</span><span class="car-info-grade-tip">Ⅰ</span></p>
                        <div class="car-info-grade-text inblock vm">
                            <p id="randDesc">${carInfo.other.pjDes2}</p>
                        </div>
                    </div>
                    <%--auction--%>
                    <div class="car-info-state mt10">
                        <div class="car-info-state-top clearfix">
                            <table width="44%" class="fl mt15 ml_5">
                                <tr class="fs14 c4a">
                                    <td width="31%">距结束</td>
                                    <td id="leftTime" class="leftTime">01:56:10</td>
                                </tr>
                                <tr>
                                    <td class="fs14 c4a">当前价</td>
                                    <td class="ccheng">
                                        <span class="fs36 finalOffer" finaloffer="19600" id="finalOffer">1.96</span><span class="fs18">万</span>
                                    </td>
                                </tr>
                                <tr class="onceBidTr  hide" style="display: table-row;">
                                    <td colspan="2" class="ccheng fs12 onceBid">未出价</td>
                                    <td colspan="2" class="ccheng fs12 onceBid">我是最高价</td>
                                    <td colspan="2" class="ccheng fs12 onceBid">出价被超越</td>
                                </tr>
                                <tr height="20">
                                    <td colspan="2" class="fs12 c9b">
                                        <span class="useIntelligenTip" id="useIntelligenTip" useintell="2" intellprice="0">
                                        </span>
                                        <span>保留价 2.23 万</span>
                                    </td>
                                </tr>
                                <tr height="20">
                                    <td colspan="2" class="fs12 ccheng hide promotionMsg" id="promotionMsg" promotion=""></td>
                                </tr>
                            </table>
                            <div class="fr w_50 fs12 c6">
                                <p class="mt15">
                                    出价记录(<span id="bidCount">23</span>)
                                </p>
                                <div class="car-info-record mt8 h90" style="height: 97px;">
                                    <div width="95%" id="bidList" style="right: 20px; height: 97px;overflow: auto;">
                                        <table style="width: 100%;font-size: 14px;line-height: 20px;">
                                            <tr>
                                                <td width="34%"><span class="vm">北京车商</span></td>
                                                <td width="33%">03:12:22</td>
                                                <td width="33%">1.96万</td>
                                            </tr>
                                            <tr>
                                                <td width="34%"><span class="vm">北京车商</span></td>
                                                <td width="33%">03:12:22</td>
                                                <td width="33%">1.96万</td>
                                            </tr>
                                            <tr>
                                                <td width="34%"><span class="vm">北京车商</span></td>
                                                <td width="33%">03:12:22</td>
                                                <td width="33%">1.96万</td>
                                            </tr>
                                            <tr>
                                                <td width="34%"><span class="vm">北京车商</span></td>
                                                <td width="33%">03:12:22</td>
                                                <td width="33%">1.96万</td>
                                            </tr>
                                            <tr>
                                                <td width="34%"><span class="vm">北京车商</span></td>
                                                <td width="33%">03:12:22</td>
                                                <td width="33%">1.96万</td>
                                            </tr>
                                            <tr>
                                                <td width="34%"><span class="vm">北京车商</span></td>
                                                <td width="33%">03:12:22</td>
                                                <td width="33%">1.96万</td>
                                            </tr>
                                            <tr>
                                                <td width="34%"><span class="vm">北京车商</span></td>
                                                <td width="33%">03:12:22</td>
                                                <td width="33%">1.96万</td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="car-info-state-bottom mt8">
                            <!-- 出价 -->
                            <div class="pt10 pl15 pr15 fs0 bidArea pr ">
                                <span class="bidStepList">
                                    <span class="mbtn vm mb10 track" step="200">+200</span>
                                    <span class="mbtn vm mb10 track" step="300">+300</span>
                                    <span class="mbtn mbtn_1 vm mb10 track" step="500">+500</span>
                                    <span class="mbtn mbtn_1 vm mb10 track" step="1000">+1000</span>
                                    <span class="mbtn mbtn_1 vm mb10 track" step="2000">+2000</span>
                                </span>
                                <p class="mipt-box inblock vm mb10">
                                    <span class="mipt-tip"><span class="mipTip">出价不能小于当前价</span><i class="mipt-tip-dot"></i></span>
                                    <input type="text" placeholder="请输入出价金额" class="mipt bidbox hui" style="width: 174px;" maxlength="7">
                                    <span class="moffer inblock bidPrice">出价</span>
                                </p>
                                <span class="mintell mintell_1 inblock vm mb10 ml5 optiBid">智能<br>报价</span>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <h4 class="mt30 page-tit page-tit-report" id="CarInfoTitle">车辆信息</h4>
            <div class="car-info-mat pr mt20 pt20" style="border-top: 1px solid #F60;">
                <div class="car-info-mat-tit c6 fs14">基本信息</div>
                <table width="100%" class="c6 fs14" >
                    <tr height="30">
                        <td width="11%">初登日期</td>
                        <td width="24%" class="cblack">${carInfo.djz.cdrq}</td>
                        <td width="11%">使用性质</td>
                        <td width="24%" class="cblack">${carInfo.xsz.xz}</td>
                        <td width="11%">表显里程</td>
                        <td width="19%" class="cblack">${carInfo.verify.bxlc}万公里</td>
                    </tr>
                    <tr height="30">
                        <td width="11%">出厂日期</td>
                        <td width="24%" class="cblack">${carInfo.djz.ccrq}</td>
                        <td width="11%">注册地</td>
                        <td width="24%" class="cblack">${carInfo.djz.zcd}</td>
                        <td width="11%">排放标准</td>
                        <td width="19%" class="cblack">${carInfo.other.pfbz}</td>
                    </tr>
                    <tr height="30">
                        <td width="11%">排量</td>
                        <td width="24%" class="cblack">${carInfo.djz.pl}</td>
                        <td width="11%">变速箱形式</td>
                        <td width="19%" class="cblack">${carInfo.bsx}</td>
                        <td width="11%">品牌型号</td>
                        <td width="19%" class="cblack">${carInfo.xsz.ppxh}</td>
                    </tr>
                    <tr height="30">
                        <td width="11%">车辆类型</td>
                        <td width="24%" class="cblack">${carInfo.xsz.lx}</td>
                        <td width="11%">驱动方式</td>
                        <td width="24%" class="cblack">${carInfo.qdfs}</td>
                        <td width="11%">燃油类型</td>
                        <td width="19%" class="cblack">${carInfo.djz.rszl}</td>
                    </tr>
                    <tr height="30">
                        <td width="11%">颜色/车身颜色</td>
                        <td width="24%" class="cblack">${carInfo.djz.color}</td>
                        <td width="11%">座位数</td>
                        <td width="24%" class="cblack">${carInfo.djz.hdzks}</td>
                        <td width="11%">轮胎规格</td>
                        <td width="19%" class="cblack">${carInfo.djz.ltgg}</td>
                    </tr>
                    <tr height="30">
                        <td width="11%">发动机号</td>
                        <td width="24%" class="cblack">${carInfo.xsz.fdjh}</td>
                        <td width="11%">过户次数</td>
                        <td width="19%" class="cblack">${carInfo.djz.ghcs}</td>
                        <td width="11%">现使用方</td>
                        <td width="24%" class="cblack">${carInfo.djz.xsyf}</td>
                    </tr>
                    <tr height="30">

                        <td width="11%">是否进口</td>
                        <td width="24%" class="cblack">${carInfo.djz.jk}</td>
                    </tr>
                </table>
            </div>
            <div class="car-info-mat pr mt20 pt20" style="border-top: 1px solid #F60;">
                <div class="car-info-mat-tit c6 fs14">手续信息</div>
                <table width="100%" class="c6 fs14" >
                    <tr height="30">
                        <td width="11%">登记证</td>
                        <c:if test="${carInfo.djz.wj=='有'}">
                            <td width="24%" class="cblack" >${carInfo.djz.wj}</td>
                        </c:if>
                        <c:if test="${carInfo.djz.wj=='无'}">
                            <td width="24%" class="ccheng" >${carInfo.djz.wj}</td>
                        </c:if>
                        <td width="11%">行驶证</td>
                        <c:if test="${carInfo.xsz.wj=='有'}">
                            <td width="24%" class="cblack" >${carInfo.xsz.wj}</td>
                        </c:if>
                        <c:if test="${carInfo.xsz.wj=='无'}">
                            <td width="24%" class="ccheng" >${carInfo.xsz.wj}</td>
                        </c:if>
                        <td width="11%">年检有效期</td>
                        <td width="19%" class="cblack">${carInfo.xsz.njh}</td>
                    </tr>
                    <tr height="30">
                        <%--<td width="11%">购车发票</td>--%>
                        <%--<td width="24%" class="cblack">${carInfo.qtz.}</td>--%>
                        <td width="11%">交强险有效期</td>
                        <td width="24%" class="cblack">${carInfo.qtz.jqxrq}</td>
                        <td width="11%">交强险所在地</td>
                        <td width="19%" class="cblack">${carInfo.qtz.jqxd}</td>
                        <td width="11%">车船税</td>
                        <td width="24%" class="cblack">${carInfo.qtz.ccx}</td>
                    </tr>
                    <tr height="30">

                        <td width="11%">车牌所在地</td>
                        <td width="24%" class="cblack">${carInfo.xsz.number}</td>
                        <td width="11%">购置税证</td>
                        <td width="19%" class="cblack">${carInfo.qtz.gzs}</td>
                        <td width="11%">车身铭牌</td>
                        <td width="24%" class="cblack">${carInfo.verify.djz}</td>
                    </tr>
                    <tr height="30">

                        <td width="11%">外观改装</td>
                        <td width="24%" class="cblack">${carInfo.verify.xsz}</td>
                        <td width="11%">违章记录</td>
                        <c:if test="${carInfo.other.wz=='无'}">
                            <td width="19%" class="cblack"> ${carInfo.other.wz} </td>
                        </c:if>
                        <c:if test="${carInfo.other.wz!='无'}">
                            <td width="19%" class="ccheng"> ${carInfo.other.wz} </td>
                        </c:if>
                        <td width="11%">备用钥匙</td>
                        <c:if test="${carInfo.qtz.byys=='有'}">
                            <td width="19%" class="cblack"> ${carInfo.qtz.byys} </td>
                        </c:if>
                        <c:if test="${carInfo.qtz.byys!='有'}">
                            <td width="19%" class="ccheng"> ${carInfo.qtz.byys} </td>
                        </c:if>
                    </tr>
                </table>
            </div>
            <div class="car-info-mat pr mt20 pt20" style="border-top: 1px solid #F60;">
                <div class="car-info-mat-tit c6 fs14">配置信息</div>
                <table width="100%" class="c6 fs14" >
                    <tr height="30">
                        <td width="11%">ABS</td>
                        <td width="24%" class="cblack">${carInfo.pz.abs} ${carInfo.pz.absBug}</td>
                        <td width="11%">气囊</td>
                        <td width="24%" class="cblack">${carInfo.pz.qn} ${carInfo.pz.qnBug}</td>
                        <td width="11%">转向助力</td>
                        <td width="19%" class="cblack">${carInfo.pz.zxzl} ${carInfo.pz.zxzlBug}</td>
                    </tr>
                    <tr height="30">
                        <td width="11%">车窗玻璃</td>
                        <td width="24%" class="cblack">${carInfo.pz.ccbl} ${carInfo.pz.ccblBug}</td>
                        <td width="11%">天窗</td>
                        <td width="24%" class="cblack">${carInfo.pz.tc} ${carInfo.pz.tcBug}</td>
                        <td width="11%">车外后视镜</td>
                        <td width="19%" class="cblack">${carInfo.pz.cwhsj} ${carInfo.pz.cwhsjBug}</td>
                    </tr>
                    <tr height="30">
                        <td width="11%">座椅材质</td>
                        <td width="24%" class="cblack">${carInfo.pz.zycz}</td>
                        <td width="11%">座椅调节方式</td>
                        <td width="24%" class="cblack">${carInfo.pz.zytjfs}</td>
                        <td width="11%">座椅功能</td>
                        <td width="19%" class="cblack">${carInfo.pz.zygn}</td>
                    </tr>
                    <tr height="30">
                        <td width="11%">空调</td>
                        <td width="24%" class="ccheng">${carInfo.pz.kt} ${carInfo.pz.ktBug}</td>
                        <td width="11%">影音设备</td>
                        <td width="24%" class="cblack">${carInfo.pz.yysb} ${carInfo.pz.yysbBug}</td>
                        <td width="11%">导航</td>
                        <td width="19%" class="cblack">${carInfo.pz.dh} ${carInfo.pz.dhBug}</td>
                    </tr>
                    <tr height="30">
                        <td width="11%">定速巡航</td>
                        <td width="24%" class="ccheng">${carInfo.pz.dsxh} ${carInfo.pz.dsxhBug}</td>
                        <td width="11%">倒车雷达</td>
                        <td width="24%" class="ccheng">${carInfo.pz.dcld} ${carInfo.pz.dcldBug}</td>
                        <td width="11%">倒车影像</td>
                        <td width="19%" class="ccheng">${carInfo.pz.dcyx} ${carInfo.pz.dcyxBug}</td>
                    </tr>
                    <tr height="30">
                        <td width="11%">轮毂</td>
                        <td width="24%" class="cblack">${carInfo.pz.lg}</td>
                    </tr>
                </table>
            </div>
            <div class="car-info-mat pr mt20 pt20" style="border-top: 1px solid #F60;">
                <div class="car-info-mat-tit c6 fs14">过户风险与责任</div>
                <table width="100%" class="c6 fs14">
                    <c:if test="${carInfo.xsz.wj =='无'|| carInfo.verify.djz!='有' || carInfo.verify.xsz!='实车与行驶证照片相符' }">
                    <tr>
                        <td width="11%" valign="top" class="pt5 pb5">买方负责</td>
                        <td width="89%" valign="top" class="cblack pt5 pb5">无</td>
                    </tr>
                    </c:if>
                    <tr>
                        <td width="11%" valign="top" class="pt5 pb5">卖方负责</td>
                        <td width="89%" valign="top" class="cblack pt5 pb5"><c:if test="${carInfo.other.wz=='无'}">存在违章</c:if> ${carInfo.other.wz}</td>
                    </tr>
                    <tr>
                        <td width="11%" valign="top" class="pt5 pb5">其他提示</td>
                        <td width="89%" valign="top" class="cblack pt5 pb5">${carInfo.other.other}</td>
                    </tr>
                </table>
            </div>
            <div class="mt70 page-tit page-tit-report" id="imgTab">
                车辆图片
                <ul class="page-tab clearfix">
                    <li class="cur">基本照片</li>
                    <li>事故照片</li>
                    <li>缺陷照片</li>
                    <li>其他照片</li>
                </ul>
            </div>
            <p class="page-line mt20"></p>
            <%--基本照片--%>
            <ul class="car-pho clearfix mt30">
                <c:forEach items="${carInfo.baseImgArry}" var="item" varStatus="status">
                    <li>
                        <img src="${item.img}" onclick="showImg(${status.index})">
                        <span> ${item.desc}</span>
                    </li>
                </c:forEach>
            </ul>
            <c:if test="${carInfo.sg.size()==0}">
                <ul class="car-pho clearfix mt30" style="display:none;">
                    <p class="pt20 pb30 fs14 ml140 cblack">未见明显异常,无事故照片</p>
                </ul>
            </c:if>
            <%--事故照片--%>
            <c:if test="${carInfo.sg.size()!=0}">
                <ul class="car-pho clearfix mt30" style="display:none;">
                    <c:forEach items="${carInfo.sg}" var="item" varStatus="status">
                    <li>
                        <img src="${item.img}" onclick="showImg(${status.index+carInfo.baseImgArry.size()})"><span> ${item.desc}</span>
                    </li>
                    </c:forEach>
                </ul>
            </c:if>
            <c:if test="${carInfo.wgqx.size()==0}">
                <ul class="car-pho clearfix mt30" style="display:none;">
                    <p class="pt20 pb30 fs14 ml140 cblack">未见明显异常,无外观缺陷照片</p>
                </ul>
            </c:if>
            <%--缺陷照片--%>
            <c:choose>
                <c:when test="${carInfo.wgqx.size()==0&&carInfo.nsqx.size()==0}">
                    <ul class="car-pho clearfix mt30" style="display:none;">
                        <p class="pt20 pb30 fs14 ml140 ccheng">未见明显异常,无缺陷照片</p>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="car-pho clearfix mt30" style="display:none;">
                        <div style="float: left;width: 100%;">
                            <p class="pt20 pb30 fs14  ccheng">外观缺陷</p>
                            <c:forEach items="${carInfo.wgqx}" var="item" varStatus="status">
                                <li>
                                    <img src="${item.img}" onclick="showImg(${status.index+carInfo.baseImgArry.size()+carInfo.sg.size()})"><span> ${item.desc}</span>
                                </li>
                            </c:forEach>
                            <c:if test="${carInfo.wgqx.size()==0}">
                                <p class="pt20 pb30 fs14 ml140 ccheng">未见明显异常,无外观缺陷照片</p>
                            </c:if>
                        </div>
                        <div style="float: left;width: 100%;">
                            <p class="pt20 pb30 fs14  ccheng">内饰缺陷</p>
                            <c:forEach items="${carInfo.nsqx}" var="item" varStatus="status">
                                <li>
                                    <img src="${item.img}" onclick="showImg(${status.index+carInfo.baseImgArry.size()+carInfo.sg.size()+carInfo.wgqx.size()})"><span> ${item.desc}</span>
                                </li>
                            </c:forEach>
                            <c:if test="${carInfo.nsqx.size()==0}">
                                <p class="pt20 pb30 fs14 ml140 ccheng">未见明显异常,无内饰缺陷照片</p>
                            </c:if>
                        </div>
                    </ul>
                </c:otherwise>
            </c:choose>

            <%--其他缺陷--%>
            <c:choose>
                <c:when test="${carInfo.ps.size()==0&&carInfo.hs.size()==0}">
                    <ul class="car-pho clearfix mt30" style="display:none;">
                        <p class="pt20 pb30 fs14 ml140 ccheng">未见明显异常,无其他缺陷照片</p>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="car-pho clearfix mt30" style="display:none;">
                        <div style="float: left;width: 100%;">
                            <p class="pt20 pb30 fs14  ccheng">泡水</p>
                            <c:forEach items="${carInfo.ps}" var="item" varStatus="status">
                                <li>
                                    <img src="${item.img}" onclick="showImg(${status.index+carInfo.baseImgArry.size()+carInfo.sg.size()+carInfo.wgqx.size()+carInfo.nsqx.size()})"><span> ${item.desc}</span>
                                </li>
                            </c:forEach>
                            <c:if test="${carInfo.ps.size()==0}">
                                <p class="pt20 pb30 fs14 ml140 ccheng">未见明显异常,无泡水痕迹</p>
                            </c:if>
                        </div>
                        <div style="float: left;width: 100%;">
                            <p class="pt20 pb30 fs14  ccheng">火烧</p>
                            <c:forEach items="${carInfo.hs}" var="item" varStatus="status">
                                <li>
                                    <img src="${item.img}" onclick="showImg(${status.index+carInfo.baseImgArry.size()+carInfo.sg.size()+carInfo.wgqx.size()+carInfo.ps.size()})"><span> ${item.desc}</span>
                                </li>
                            </c:forEach>
                            <c:if test="${carInfo.hs.size()==0}">
                                <p class="pt20 pb30 fs14 ml140 ccheng">未见明显异常,无火烧痕迹</p>
                            </c:if>
                        </div>
                    </ul>
                </c:otherwise>
            </c:choose>
            <h4 class="mt30 page-tit page-tit-report" id="CheckInfoTitle">检测信息</h4>
            <p class="page-line mt20"></p>
            <%--事故检测--%>

            <div class="car-info-mat pr mt45">
                <div class="car-info-mat-tit c6 fs14">事故检测
                    <img src="/resources/main/img/img.png"height="30" width="30" class="vm ml10" style="cursor:pointer;" onclick="Jump(2)">
                </div>
                <table width="100%" class="c6 fs14">
                    <c:forEach items="${carInfo.sg}" var="item">
                        <tr height="30">
                            <td>
                                <span class="inblock degree degree02 vm"></span>
                                <span class="degree-text vm">${item.desc}</span>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${carInfo.sg.size()==0}">
                        <tr height="30">
                            <td class="ccheng"> 未见明显异常</td>
                        </tr>
                    </c:if>
                </table>
            </div>

            <%--动力检查--%>
            <div class="car-info-mat pr mt45">
                <div class="car-info-mat-tit c6 fs14">动力检查</div>
                <table width="100%" class="c6 fs14">
                    <tr height="30">
                        <td width="10%">发动机性能</td>
                        <td colspan="3" class="ccheng">${carInfo.dl.fdjXn}</td>
                        <td width="10%">发动机尾气</td>
                        <td colspan="3" class="ccheng">${carInfo.dl.fdjWq}</td>
                        <td width="10%">变速器</td>
                        <td colspan="3" class="ccheng">${carInfo.dl.bsq}</td>
                    </tr>
                </table>
            </div>

            <%--外观检测--%>
            <div class="car-info-mat pr mt45">
                <div class="car-info-mat-tit c6 fs14">外观检测
                    <img src="/resources/main/img/img.png"height="30" width="30" class="vm ml10" style="cursor:pointer;" onclick="Jump(3)">
                </div>
                <table width="100%" class="c6 fs14">
                    <c:forEach items="${carInfo.wgqx}" var="item">
                        <tr height="30">
                            <td>
                                <span class="inblock degree degree02 vm"></span>
                                <span class="degree-text vm">${item.desc}</span>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${carInfo.wgqx.size()==0}">
                        <tr height="30">
                            <td class="ccheng"> 未见明显异常</td>
                        </tr>
                    </c:if>
                </table>
            </div>

            <%--内饰检测--%>
            <div class="car-info-mat pr mt45">
                <div class="car-info-mat-tit c6 fs14">内饰检测
                    <img src="/resources/main/img/img.png"height="30" width="30" class="vm ml10" style="cursor:pointer;" onclick="Jump(3)">
                </div>
                <table width="100%" class="c6 fs14">
                    <c:forEach items="${carInfo.nsqx}" var="item">
                        <tr height="30">
                            <td>
                                <span class="inblock degree degree02 vm"></span>
                                <span class="degree-text vm">${item.desc}</span>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${carInfo.nsqx.size()==0}">
                        <tr height="30">
                            <td class="ccheng"> 未见明显异常</td>
                        </tr>
                    </c:if>
                </table>
            </div>

            <%--泡水检测--%>
            <div class="car-info-mat pr mt45">
                <div class="car-info-mat-tit c6 fs14">泡水检测
                    <img src="/resources/main/img/img.png"height="30" width="30" class="vm ml10" style="cursor:pointer;" onclick="Jump(4)">
                </div>
                <table width="100%" class="c6 fs14">
                    <c:forEach items="${carInfo.ps}" var="item">
                        <tr height="30">
                            <td>
                                <span class="inblock degree degree02 vm"></span>
                                <span class="degree-text vm">${item.desc}</span>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${carInfo.ps.size()==0}">
                        <tr height="30">
                            <td class="ccheng"> 未见明显异常,无泡水痕迹</td>
                        </tr>
                    </c:if>
                </table>
            </div>

            <%--火烧检测--%>
            <div class="car-info-mat pr mt45">
                <div class="car-info-mat-tit c6 fs14">火烧检测
                    <img src="/resources/main/img/img.png"height="30" width="30" class="vm ml10" style="cursor:pointer;" onclick="Jump(4)">
                </div>
                <table width="100%" class="c6 fs14">
                    <c:forEach items="${carInfo.hs}" var="item">
                        <tr height="30">
                            <td>
                                <span class="inblock degree degree02 vm"></span>
                                <span class="degree-text vm">${item.desc}</span>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${carInfo.hs.size()==0}">
                        <tr height="30">
                            <td class="ccheng"> 未见明显异常,无火烧痕迹</td>
                        </tr>
                    </c:if>
                </table>
            </div>
            <p class="page-line mt20"></p>
            <div class="testing-end c6 fs14 tc mt50 mb25" style="background: #FFF">
                <p class="mt15">检测日期:<span id="CheckDate">${carInfo.checkDate}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    报告编码:<span id="TredeCode">${carInfo.checkNum}</span>&nbsp;&nbsp;&nbsp;&nbsp;
                    注：“本报告解释权归《北京迈众汽车信息服务有限公司》所有”
                </p>
            </div>

        </div>
    </div>
    <%--TOP float div--%>
    <div class="car-info-top" style="width: 1200px; margin-left: -600px;z-index: 1989; display: none;">
        <div class="car-info-top-text clearfix">
            <div class="fl w_40">
                <p class="car-info-name car-info-nameT carName">${carInfo.modelName}</p>
                <p class="fs12 c6 mt10">
                    <span class="regDate">${carInfo.djz.cdrq}</span>
                    <i class="italicmg">/</i>${carInfo.djz.zcd}
                    <i class="italicmg">/</i><span class="licenseSimple">${carInfo.xsz.number}</span>
                    <i class="italicmg">/</i><span class="pf">${carInfo.other.pfbz}</span>
                    <i class="italicmg">/</i><span class="mileage">${carInfo.verify.bxlc}万公里</span>
                    <i class="italicmg">/</i><span class="ghTime">${carInfo.djz.ghcs}次</span>过户
                </p>
            </div>
            <div class="fl w_25">
                <table width="100%" class="fs14">
                    <tr class="cfen">
                        <td width="20%">距结束</td>
                        <td class="fb leftTime">00:00:00</td>
                    </tr>
                    <tr>
                        <td class="fs14 c4a fb">当前价</td>
                        <td class="ccheng">
                            <span class="fs36 finalOffer" id="scrollFinalOffer">0.22</span><span class="fs18">万</span>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="fs14 c6  auctionEnd">
                <p class="fs14 ccheng onceBid">
                </p>
                <p class="mt5">该车已结束竞拍</p>
            </div>
        </div>
        <div class="car-info-top-tab fs0">
            <span class="inblock cur">车辆信息</span>
            <span class="inblock">车辆图片</span>
            <span class="inblock">检测信息</span>
        </div>
    </div>
    <%--IMG POP--%>
    <div class="popup hide" id="ImgDialogPopup">
        <p class="vam"></p>
        <div class="content bgwhite pr car-info-zoom" style="display: none; width: 1200px;" id="ImgDialog">
            <a href="javascript:;" class="prev"></a>
            <a href="javascript:;" class="next"></a>
            <span class="test-close close" onclick="closeImg()" style="right: -18px; top: -17px;">×</span>
            <div class="p30">
                <div class="clearfix">
                    <div class="car-info-zoom-left fl" style="width: 800px; height: 600px;">
                        <div class="car-big" style="width: 800px; height: 600px;">
                            <ul class="clearfix" id="BigPicture" style="width: 42400px;">
                                <%--基本照片--%>
                                <c:forEach items="${carInfo.baseImgArry}" var="item">
                                <li>
                                    <img src="${item.img}" style="width: 800px; height: 600px;">
                                    <span style="display: none;">
                                        <span style="float: left; margin-left: 5px;"> 基本照片 </span>
                                     ${item.desc}
                                    </span>
                                </li>
                                </c:forEach>
                                <%--事故照片--%>
                                <c:forEach items="${carInfo.sg}" var="item">
                                <li>
                                    <img src="${item.img}" style="width: 800px; height: 600px;">
                                    <span style="display: none;">
                                        <span style="float: left; margin-left: 5px;"> 事故照片 </span>
                                     ${item.desc}
                                    </span>
                                </li>
                                </c:forEach>
                                <%--外观缺陷--%>
                                <c:forEach items="${carInfo.wgqx}" var="item">
                                <li>
                                    <img src="${item.img}" style="width: 800px; height: 600px;">
                                    <span style="display: none;">
                                        <span style="float: left; margin-left: 5px;"> 外观缺陷 </span>
                                     ${item.desc}
                                    </span>
                                </li>
                                </c:forEach>
                                <%--内饰缺陷--%>
                                <c:forEach items="${carInfo.nsqx}" var="item">
                                <li>
                                    <img src="${item.img}" style="width: 800px; height: 600px;">
                                    <span style="display: none;">
                                        <span style="float: left; margin-left: 5px;"> 内饰缺陷 </span>
                                     ${item.desc}
                                    </span>
                                </li>
                                </c:forEach>
                                <%--泡水--%>
                                <c:forEach items="${carInfo.ps}" var="item">
                                <li>
                                    <img src="${item.img}" style="width: 800px; height: 600px;">
                                    <span style="display: none;">
                                        <span style="float: left; margin-left: 5px;"> 泡水 </span>
                                     ${item.desc}
                                    </span>
                                </li>
                                </c:forEach>
                                <%--火烧--%>
                                <c:forEach items="${carInfo.hs}" var="item">
                                <li>
                                    <img src="${item.img}" style="width: 800px; height: 600px;">
                                    <span style="display: none;">
                                        <span style="float: left; margin-left: 5px;"> 火烧 </span>
                                     ${item.desc}
                                    </span>
                                </li>
                                </c:forEach>
                            </ul>
                            <p class="car-big-tit" id="photo_long_desc"></p>
                        </div>
                    </div>

                </div>
                <div class="car-sm-box">

                </div>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp"%>
    <script src="/resources/main/js/carousel.min.js" type="text/javascript"></script>
    <script type="text/javascript">

        var carDetail = {
            NowPhotoIndex:0,
            IsSwitching:!1,
            ImgTabSwitch(n){
                var u = $(".car-info-zoom .car-big ul li").length,
                    e = $(".car-info-zoom .car-big ul li img").eq(0).width();
                this.NowPhotoIndex < 0 && (this.NowPhotoIndex = u - 1, n = !1), this.NowPhotoIndex == u && (this.NowPhotoIndex = 0, n = !1),$(".car-info-zoom .car-sm ul li").eq(this.NowPhotoIndex).addClass("current").siblings().removeClass("current"),
                         $(".car-info-zoom .car-big-tit").html($(".car-info-zoom .car-big ul li").eq(this.NowPhotoIndex).children("span").html()), n ? ($(".car-info-zoom .car-big ul").animate({left: -e * this.NowPhotoIndex}), $(".car-info-zoom .car-big ul").stop().animate({left: -e * this.NowPhotoIndex
                }, function() { carDetail.IsSwitching = !1})) : ($(".car-info-zoom .car-big ul").css("left", -e * this.NowPhotoIndex), this.IsSwitching = !1);
            }

        }

        var CheckTitleTop=0;
        $(function(){
            /* 商品轮播图（带缩略图的轮播效果） */
            $(".banners").thumbnailImg({
                large_elem: ".large_box",
                small_elem: ".small_list",
                left_btn: ".left_btn",
                right_btn: ".right_btn"
            });
            //提示
            $(".car-info-grade-tip").hover(function(){$(".tip-con").toggle()});
            //图片tab切换
            $(".page-tab li").click(function() {
                photoSwitch($(this).index())
            });

            //浮动
            var TitleTop = $("#CarInfoTitle").offset().top-200;

            $(window).scroll(function() {
                var r, t;
                if ($(window).scrollTop() > TitleTop)
                    if ($(".car-info-top").show(), r = $("#imgTab").offset().top, CheckTitleTop = $("#CheckInfoTitle").offset().top, t = $(".car-info-top").height(),$h1 = r - $(window).scrollTop() - t - 15,$h2 = CheckTitleTop - $(window).scrollTop() - t - 15, $h1 > 0)
                        $(".car-info-top-tab span").eq(0).addClass("cur").siblings().removeClass("cur");
                else $h1 < 0 && $h2 > 0 ? $(".car-info-top-tab span").eq(1).addClass("cur").siblings().removeClass("cur") : $h2 < 0 && $(".car-info-top-tab span").eq(2).addClass("cur").siblings().removeClass("cur");
                else $(".car-info-top").hide()
            });
            //浮动tab点击
            $(".car-info-top-tab span").click(function() {
                var n = $(this);
                $(this).addClass("cur").siblings().removeClass("cur");
                $("html,body").animate({
                    scrollTop: $(".page-tit-report").eq(n.index()).offset().top - $(".car-info-top").height() - 10
                }, 0)
            });
            //下一张
            $(".car-info-zoom .next").click(function() {
                carDetail.IsSwitching || (carDetail.NowPhotoIndex++, carDetail.IsSwitching = !0, carDetail.ImgTabSwitch(!0))
            });
            //上一张
            $(".car-info-zoom .prev").click(function() {
                carDetail.IsSwitching || (carDetail.NowPhotoIndex--, carDetail.IsSwitching = !0, carDetail.ImgTabSwitch(!0))
            });
        });
        //图片div切换
        var photoSwitch = function(n){
            $(".page-tab li").eq(n).addClass("cur").siblings().removeClass("cur");
            $(".car-pho").hide().eq(n).show();
        }
        //跳转
        var Jump = function(n){
            photoSwitch(n - 1);
            $("html,body").animate({
                scrollTop: $("#imgTab").offset().top - $(".car-info-top").height() - 10
            }, 0)
        }
        //图片弹层
        var showImg = function(n){
            $("#ImgDialogPopup").show();
            $("#ImgDialog").show();
            carDetail.NowPhotoIndex = n;
            carDetail.ImgTabSwitch(!1);
        }

        var closeImg = function() {
            $("#ImgDialogPopup").hide();
            $("#ImgDialog").hide()
        }

    </script>
</body>
</html>
