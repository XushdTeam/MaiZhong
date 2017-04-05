<%--
  Created by IntelliJ IDEA.
  User: yangF
  Date: 2017/3/15
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
    <link rel="stylesheet" type="text/css" href="/resources/style/base.css" />
    <link rel="stylesheet" type="text/css" href="/resources/style/other.css"/>
    <script src="http://cdn.bootcss.com/jquery/3.2.0/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="x_ban">
    <img src="/resources/img/x_ban.png" width="1200px">
</div>
<div id="content">
    <div class="car-sale-wrap">
        <div class="main search-opt">
            <div class="search" id="switchCarShop">
                <input type="text" value="${queryStr}" placeholder="请输入品牌、车系搜索" class="entry-box s-input fl ui-autocomplete-input" id="search_search" name="q"  autocomplete="off" style="color: rgb(191, 191, 191);">
                <a href="javascript:;" class="s-btn" for="search_search"></a>
            </div>
            <div class="select-result">
                <span class="has-condition">当前已选条件</span>
                <dl>
                    <dd class="selectednew">
                        <c:if test="${bN!=null}">
                            <a href="/car/cb_0/cs_0/cp_${pId}/cv_${vId}/p_${vT}/list.html">
                                ${bN}
                                <img src="/resources/img/456.png">
                            </a>
                        </c:if>
                        <c:if test="${sN!=null}">
                            <a href="/car/cb_${bId}/cs_0/cp_${pId}/cv_${vId}/p_${vT}/list.html">
                                    ${sN}
                                <img src="/resources/img/456.png">
                            </a>
                        </c:if>
                        <c:if test="${pId!='0'}">
                            <a href="/car/cb_${bId}/cs_${sId}/cp_0/cv_${vId}/p_${vT}/list.html">
                                    ${pN}
                                <img src="/resources/img/456.png">
                            </a>
                        </c:if>
                        <c:if test="${vId!='0'}">
                            <a href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_0/p_${vT}/list.html">
                                ${vN}
                                <img src="/resources/img/456.png">
                            </a>
                        </c:if>
                        <c:if test="${vT!='0'}">
                            <a href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_0/list.html">
                                    ${tN}
                                <img src="/resources/img/456.png">
                            </a>
                        </c:if>
                    </dd>
                    <a class="select-reset" href="/car/list.html">重置条件</a>
                </dl>
            </div>
            <div class="select select-filter">
                <div class="select-con">
                    <dl id="select1" class="searchLabel">
                        <dt class="bg1">品牌:</dt>
                        <c:choose>
                            <c:when test="${bId==0}">
                                <dd class="select-all selected"><a >不限</a></dd>
                            </c:when>
                            <c:otherwise>
                                <dd class="select-all"><a href="/car/cb_0/cs_0/cp_${pId}/cv_${vId}/p_${vT}/list.html">不限</a></dd>
                                <c:if test="${!bOut}">
                                    <dd class="selected">
                                        <a href="" class="spell preventdefault ">
                                                ${bN}
                                        </a>
                                    </dd>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach items="${bHot}" var="item">
                            <dd class="<c:if test="${item.key==bId}">selected </c:if>">
                                <a href="/car/cb_${item.key}/cs_0/cp_${pId}/cv_${vId}/p_${vT}/list.html" class="spell preventdefault" title="${item.value}" >${item.value}</a>
                            </dd>
                        </c:forEach>
                    </dl>
                    <a href="javascript:;" class="brand-more more-hover">更多<b class="searched-ico more-ico"></b></a>
                    <div class="frame-brand PopBox PopBox_hidden_b PopBoxs" style="display:none;">
                        <div class="uptop"></div>
                        <div class="brand-more brand-left">
                            <c:forEach items="${bAll}" var="i" begin="0" end="5">
                               <dl>
                                   <dt>${i.key}</dt>
                                   <dd>
                                       <c:forEach items="${i.object}" var="j">
                                           <a rel="nofollow" class=" preventdefault" title="${j.value}"  href="/car/cb_${j.key}/cs_0/cp_${pId}/cv_${vId}/p_${vT}/list.html">${j.value}</a>
                                       </c:forEach>
                                   </dd>
                               </dl>
                            </c:forEach>
                        </div>
                        <div class="brand-more brand-left">
                            <c:forEach items="${bAll}" var="i" begin="6" end="11">
                                <dl>
                                    <dt>${i.key}</dt>
                                    <dd>
                                        <c:forEach items="${i.object}" var="j">
                                            <a rel="nofollow" class=" preventdefault" title="${j.value}"  href="/car/cb_${j.key}/cs_0/cp_${pId}/cv_${vId}/p_${vT}/list.html">${j.value}</a>
                                        </c:forEach>
                                    </dd>
                                </dl>
                            </c:forEach>
                        </div>
                        <div class="brand-more brand-left">
                            <c:forEach items="${bAll}" var="i" begin="11" end="27">
                                <dl>
                                    <dt>${i.key}</dt>
                                    <dd>
                                        <c:forEach items="${i.object}" var="j">
                                            <a rel="nofollow" class=" preventdefault" title="${j.value}"  href="/car/cb_${j.key}/cs_0/cp_${pId}/cv_${vId}/p_${vT}/list.html">${j.value}</a>
                                        </c:forEach>
                                    </dd>
                                </dl>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="select-con">
                    <dl id="select2" class="searchLabel">
                        <dt class="bg2">车系:</dt>
                        <c:choose>
                            <c:when test="${sId==0}">
                                <dd class="select-all selected"><a >不限</a></dd>
                            </c:when>
                            <c:otherwise>
                                <dd class="select-all"><a href="/car/cb_${bId}/cs_0/cp_${pId}/cv_${vId}/p_${vT}/list.html">不限</a></dd>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach items="${sHot}" var="si" >
                            <dd class="<c:if test="${si.id==sId}">selected </c:if>">
                                <a href="/car/cb_${si.brandId}/cs_${si.id}/cp_${pId}/cv_${vId}/p_${vT}/list.html" class="spell preventdefault" title="${si.lineName}" >${si.lineName}</a>
                            </dd>
                        </c:forEach>
                    </dl>
                    <c:if test="${sL>10}">
                        <a href="javascript:;" class="more system-more TipBtn TipBtn_hidden_s" style=" ">更多<b class="searched-ico more-ico"></b></a>
                        <div id="search_serial" class="frame-system PopBox PopBox2 PopBox_hidden_s">
                            <div class="uptop"></div>
                            <a href="javascript:;" class="h1" data-for="hidden_s" data-valueid="0">全部车系</a>
                            <c:forEach items="${sAll}" var = "si">
                            <table>
                                <tbody>
                                <tr>
                                    <th><em>${si.fN}</em></th>
                                    <td>
                                        <c:forEach items="${si.fSL}" var="sis">
                                            <a rel="nofollow" class=" preventdefault" title="${sis.sN}"  href="/car/cb_${sis.sBi}/cs_${sis.sI}/cp_${pId}/cv_${vId}/p_${vT}/list.html">${sis.sN}</a>
                                        </c:forEach>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            </c:forEach>
                        </div>
                    </c:if>
                </div>
                <div class="select-con">
                    <dl id="select3" class="searchLabel">
                        <dt class="bg3">价格:</dt>
                        <dd class="select-all <c:if test="${'0'==pId}">selected </c:if>"><a  href="/car/cb_${bId}/cs_${sId}/cp_0/cv_${vId}/p_${vT}/list.html" >不限</a></dd>
                        <dd class="<c:if test="${'0-5'==pId}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_0-5/cv_${vId}/p_${vT}/list.html" title="5万以下" class="preventdefault">5万以下</a>
                        </dd>
                        <dd class="<c:if test="${'5-10'==pId}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_5-10/cv_${vId}/p_${vT}/list.html"  title="5-10万" class="preventdefault">5-10万</a>
                        </dd>
                        <dd class="<c:if test="${'10-15'==pId}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_10-15/cv_${vId}/p_${vT}/list.html"  title="10-15万" class="preventdefault">10-15万</a>
                        </dd>
                        <dd class="<c:if test="${'15-20'==pId}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_15-20/cv_${vId}/p_${vT}/list.html"  title="15-20万" class="preventdefault">15-20万</a>
                        </dd>
                        <dd class="<c:if test="${'20-30'==pId}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_20-30/cv_${vId}/p_${vT}/list.html"  title="20-30万" class="preventdefault">20-30万</a>
                        </dd>
                        <dd class="<c:if test="${'30-50'==pId}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_30-50/cv_${vId}/p_${vT}/list.html"  title="30-50万" class="preventdefault">30-50万</a>
                        </dd>
                        <dd class="<c:if test="${'50-'==pId}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_50-/cv_${vId}/p_${vT}/list.html"  title="50万以上" class="preventdefault">50万以上</a>
                        </dd>
                    </dl>
                    <div class="price-handle other-price clearfix">
                        <div class="box">
                            <input type="text" name="price_s" id="price_s" value="${ps}" class="txt" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')">万
                        </div>
                        <em>-</em>
                        <div class="box">
                            <input type="text"  class="txt" name="price_e" id="price_e" value="${pe}" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')">万
                        </div>
                        <a id="customer_price" class="confirm-btn" >确定</a>
                        <span id="other-price-error" class="error" style="display:none">请输入正确的价格</span>
                    </div>
                </div>
                <div class="select-con">
                    <dl id="select4" class="searchLabel">
                        <dt class="bg4">排量:</dt>
                        <dd class="select-all <c:if test="${'0'==vId}">selected </c:if>"><a  href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_0/p_${vT}/list.html" >不限</a></dd>
                        <dd class="<c:if test="${'0-1.0'==vId}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_0-1.0/p_${vT}/list.html"  title="1.0L以下" class="preventdefault">1.0L以下</a>
                        </dd>
                        <dd class="<c:if test="${'1.1-1.6'==vId}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_1.1-1.6/p_${vT}/list.html"  title="1.1L-1.6L" class="preventdefault">1.1L-1.6L</a>
                        </dd>
                        <dd class="<c:if test="${'1.6-2.0'==vId}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_1.6-2.0/p_${vT}/list.html"  title="1.6L-2.0L" class="preventdefault">1.6L-2.0L</a>
                        </dd>
                        <dd class="<c:if test="${'2.0-2.5'==vId}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_2.0-2.5/p_${vT}/list.html"  title="2.0L-2.5L" class="preventdefault">2.0L-2.5L</a>
                        </dd>
                        <dd class="<c:if test="${'2.5-3.0'==vId}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_2.5-3.0/p_${vT}/list.html"  title="2.5L-3.0L" class="preventdefault">2.5L-3.0L</a>
                        </dd>
                        <dd class="<c:if test="${'3.0-4.0'==vId}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_3.0-4.0/p_${vT}/list.html"  title="3.0L-4.0L" class="preventdefault">3.0L-4.0L</a>
                        </dd>
                        <dd class="<c:if test="${'4.0-'==vId}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_4.0-/p_${vT}/list.html"  title="4.0L以上" class="preventdefault">4.0L以上</a>
                        </dd>
                    </dl>
                </div>
                <div class="select-con">
                    <dl id="select5" class="searchLabel">
                        <dt class="bg4">车型:</dt>
                        <dd class="select-all <c:if test="${'0'==vT}">selected </c:if>"><a  href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_0/list.html" >不限</a></dd>
                        <dd class="<c:if test="${'1'==vT}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_1/list.html"  title="SUV" class="preventdefault">SUV</a>
                        </dd>
                        <dd class="<c:if test="${'2'==vT}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_2/list.html"  title="跑车" class="preventdefault">跑车</a>
                        </dd>
                        <dd class="<c:if test="${'3'==vT}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_3/list.html"  title="MPV" class="preventdefault">MPV</a>
                        </dd>
                        <dd class="<c:if test="${'4'==vT}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_4/list.html"  title="面包" class="preventdefault">面包</a>
                        </dd>
                        <dd class="<c:if test="${'5'==vT}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_5/list.html"  title="皮卡" class="preventdefault">皮卡</a>
                        </dd>
                        <dd class="<c:if test="${'6'==vT}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_6/list.html"  title="商务" class="preventdefault">商务</a>
                        </dd>
                        <dd class="<c:if test="${'7'==vT}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_7/list.html"  title="中型车" class="preventdefault">中型车</a>
                        </dd>
                        <dd class="<c:if test="${'8'==vT}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_8/list.html"  title="中大型车" class="preventdefault">中大型车</a>
                        </dd>
                        <dd class="<c:if test="${'9'==vT}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_9/list.html"  title="大型车" class="preventdefault">大型车</a>
                        </dd>
                        <dd class="<c:if test="${'10'==vT}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_10/list.html"  title="小型车" class="preventdefault">小型车</a>
                        </dd>
                        <dd class="<c:if test="${'11'==vT}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_11/list.html"  title="微型车" class="preventdefault">微型车</a>
                        </dd>
                        <dd class="<c:if test="${'12'==vT}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_12/list.html"  title="轻客" class="preventdefault">轻客</a>
                        </dd>
                        <dd class="<c:if test="${'13'==vT}">selected </c:if>">
                            <a rel="nofollow" href="/car/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_13/list.html"  title="紧凑型车" class="preventdefault">紧凑型车</a>
                        </dd>
                    </dl>
                </div>
            </div>

        </div>
        <div style="clear:both"></div>
        <!--综合-->
        <div class="filter clearfix" id="J_Filter"  >
            <div class="fi_left">全部汽车资源（${total}）</div>
            <div class="fi_right">
                <a class="fSort <c:if test="${sort=='d'}">fSort-cur</c:if>" href="/car/s_d_1_1/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_${vT}/list.html<c:if test="${queryStr!=''}">?s=${queryStr}</c:if>" >默认排序</a>
                <c:if test="${sort=='h'}">
                    <a class="fSort fSort-cur" href="/car/s_h_${method}_1/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_${vT}/list.html<c:if test="${queryStr!=''}">?s=${queryStr}</c:if>">人气
                        <c:if test="${method==1}"><i class="f-ico-arrow-d"><img src="/resources/img/35.png"></i></c:if>
                        <c:if test="${method!=1}"><i class="f-ico-arrow-d"><img src="/resources/img/34.png"></i></c:if>
                    </a>
                </c:if>
                <c:if test="${sort!='h'}">
                    <a class="fSort" href="/car/s_h_1_1/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_${vT}/list.html<c:if test="${queryStr!=''}">?s=${queryStr}</c:if>">人气</a>
                </c:if>
                <c:if test="${sort=='t'}">
                    <a class="fSort fSort-cur"href="/car/s_t_${method}_1/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_${vT}/list.html<c:if test="${queryStr!=''}">?s=${queryStr}</c:if>">最新
                        <c:if test="${method==1}"><i class="f-ico-arrow-d"><img src="/resources/img/35.png"></i></c:if>
                        <c:if test="${method!=1}"><i class="f-ico-arrow-d"><img src="/resources/img/34.png"></i></c:if>
                    </a>
                </c:if>
                <c:if test="${sort!='t'}">
                    <a class="fSort" href="/car/s_t_1_1/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_${vT}/list.html<c:if test="${queryStr!=''}">?s=${queryStr}</c:if>">最新</a>
                </c:if>
                <c:if test="${sort=='p'}">
                    <a class="fSort fSort-cur"href="/car/s_p_${method}_1/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_${vT}/list.html<c:if test="${queryStr!=''}">?s=${queryStr}</c:if>" >价格
                        <c:if test="${method==1}"><i class="f-ico-arrow-d"><img src="/resources/img/35.png"></i></c:if>
                        <c:if test="${method!=1}"><i class="f-ico-arrow-d"><img src="/resources/img/34.png"></i></c:if>
                    </a>
                </c:if>
                <c:if test="${sort!='p'}">
                    <a class="fSort"href="/car/s_p_1_1/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_${vT}/list.html<c:if test="${queryStr!=''}">?s=${queryStr}</c:if>" >价格</a>
                </c:if>
            </div>
        </div>
        <div style="clear:both"></div>
        <div class="view grid-nosku views" id="J_ItemList" style="min-height: 400px;">
            <c:forEach items="${carList}" var="c">
            <div class="product">
                <div class="product-iWrap">
                    <div class="productImg-wrap">
                        <a href="/car/${c.id}/detail.html" class="productImg" target="_blank" >
                            <img src="/resources/img/default.png" data-src="${c.image}">
                        </a>
                    </div><!--productImg-wrap end-->
                    <p class="productTitle">
                        <a href="/car/${c.id}/detail.html" target="_blank"   >
                            ${c.name}
                        </a>
                    </p>
                    <p class="productPrice">
                        <em title="${c.sellPrice}"><b>¥</b>${c.sellPrice}</em>万
                    </p>
                </div><!--product-iWrap end-->
            </div><!--product end-->
            </c:forEach>
        </div>
    </div>
    <!--分页-->
    <div class="ui-page">
        <div class="ui-page-wrap">
            <c:if test="${tp>0}">
                <b class="ui-page-num">
                    <c:if test="${cur>1}">
                        <a class="ui-page-prev" href="/car/s_${sort}_${method}_${cur-1}/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_${vT}/list.html<c:if test="${queryStr!=''}">?s=${queryStr}</c:if>" >上一页</a>
                    </c:if>
                    <c:if test="${cur==1}">
                        <a class="ui-page-prev" >上一页</a>
                    </c:if>
                    <c:if test="${tp<=10}">
                        <c:forEach var="i" begin="1" end="${tp}">
                            <c:choose>
                                <c:when test="${i == cur}">
                                    <a class="ui-page-cur">${i}</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/car/s_${sort}_${method}_${i}/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_${vT}/list.html<c:if test="${queryStr!=''}">?s=${queryStr}</c:if>">${i}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:if>
                    <c:if test="${tp>10}">
                        <c:if test="${cur<10}">
                            <c:forEach var="i" begin="1" end="10">
                                <c:choose>
                                    <c:when test="${i == cur}">
                                        <a class="ui-page-cur">${i}</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="/car/s_${sort}_${method}_${i}/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_${vT}/list.html<c:if test="${queryStr!=''}">?s=${queryStr}</c:if>">${i}</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </c:if>
                        <c:if test="${cur>=10}">
                            <c:forEach var="j" begin="${cur-5}" end="${cur+4}">
                                <c:if test="${j<=tp}">
                                    <c:choose>
                                        <c:when test="${j == cur}">
                                            <a class="ui-page-cur">${j}</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="/car/s_${sort}_${method}_${j}/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_${vT}/list.html<c:if test="${queryStr!=''}">?s=${queryStr}</c:if>">${j}</a>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:if>
                    <c:if test="${cur<tp}">
                        <a class="ui-page-prev" href="/car/s_${sort}_${method}_${cur+1}/cb_${bId}/cs_${sId}/cp_${pId}/cv_${vId}/p_${vT}/list.html<c:if test="${queryStr!=''}">?s=${queryStr}</c:if>" >下一页</a>
                    </c:if>
                    <c:if test="${cur==tp}">
                        <a class="ui-page-next" >下一页</a>
                    </c:if>
                </b>
            </c:if>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script src="/resources/script/lazy-load-img.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function(){
        $(".brand-more").click(function(){
            if($(this).is(":hidden")){

            }else{
                $(this).addClass("active");
            }
            var _this = $(this);
            $(".PopBoxs").toggle();
            $(this).next(".PopBoxs").parent().hover(function(){
                $(".PopBoxs").hide(150);
                _this.removeClass("active");
            })

        });
        $(".system-more").click(function(){
            if($(this).is(":hidden")){

            }else{
                $(this).addClass("active");
            }
            var _this = $(this);
            $(".PopBox2").toggle();
            $(this).next(".PopBox2").parent().hover(function(){
                $(".PopBox2").hide(150);
                _this.removeClass("active");
            })

        });
        $(".confirm-btn").click(function () {
            var ps = Number($("#price_s").val());
            var pe = Number($("#price_e").val());
            if(ps!=0&&pe==0){
                window.location.href="/car/cb_${bId}/cs_${sId}/cp_"+ps+"-/cv_${vId}/list.html";
            }
            if(ps==0&&pe!=0){
                window.location.href="/car/cb_${bId}/cs_${sId}/cp_0-"+pe+"/cv_${vId}/list.html";
            }
            if(ps!=0&&pe!=0){
                if(ps>pe){
                    $("#other-price-error").show();
                }else{
                    window.location.href="/car/cb_${bId}/cs_${sId}/cp_"+ps+"-"+pe+"/cv_${vId}/list.html";
                }
            }
            if(ps==0&&pe==0){
                $(".error").show();
            }
        });
        $(".s-btn").click(function(){

            var searchStr = $("#search_search").val().trim();
            if(searchStr=='')return;
            window.location.href="/car/list.html?s="+searchStr;

        });
        window.lazyLoadImg = new LazyLoadImg({
            el: document.querySelector('#J_ItemList'),
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
                el.src = '/resources/img/default.png'
            }
        });
    })
</script>
</body>
</html>
