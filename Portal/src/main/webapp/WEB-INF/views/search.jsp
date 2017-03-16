<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yangF
  Date: 2017/3/15
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>迈众汽车</title>
    <script src="/resources/script/jquery-1.8.0.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="/resources/style/style.css" />

    <%--<link rel="stylesheet" type="text/css" href="/resources/style/base.css" />--%>

    <%--<script type="text/javascript" src="/resources/script/jquery.jqzoom.js"></script>--%>
    <%--<script type="text/javascript" src="/resources/script/use_jqzoom.js"></script>--%>
    <script src="/resources/script/js.js"></script>
    <!--[if lt IE 8]>
    <script src=”http://ie7-js.googlecode.com/svn/version/2.0(beta)/IE8.js” type=”text/javascript”></script>
    <![endif]-->


    <%--<script type="text/javascript" src="/resources/script/common.js"></script>--%>
    <%--<script type="text/javascript" src="/resources/script/quick_links.js"></script>--%>
</head>
<body>
<!--导航-->
<div class="haeder">
    <div class="nav_top nav_tops">
        <div class="logo">
            <a href="#" title="迈众汽车"><img src="img/logo.png"></a> <span>北京</span>
        </div>
        <ul class="navs">
            <li><a href>首页</a></li>
            <li><a href>我要买车</a></li>
            <li><a href>我要卖车</a></li>
            <li><a href>服务保障</a></li>
        </ul><!--navs end-->

        <!--call-->
        <div class="call">
            <span class="span_one"><a href="">400-090-0494</a></span>
            <span><a href="#">登录</a> / <a href="#">注册</a></span>
        </div>
    </div><!--nav_top end-->
</div>
<!--导航 end-->
<!--广告位-->
<%--以后再解开--%>
<%--<div class="x_ban">--%>
    <%--<img src="img/x_ban.png" width="1200px">--%>
<%--</div>--%>
<!--广告位 end-->



<div id="content">

    <div class="main">
        <div class="crumb" id="J_crumbs">

            <div class="chaxun">
                <span class="spans">请选择你的查询条件</span>
                <span id="searchArea">
                    <c:forEach items="${conditions}" var="condition">
                        <c:if test="${condition.value!=null}">
                            <p class="p_spn" data-type="${condition.key}" data-attr="${condition.value}" style="display:inline">${condition.value}<span class="spas" onclick="delLi(this)">X</span><p>
                        </c:if>
                    </c:forEach>
                    <p class="p_spn" data-attr="12-16万" data-type="sellPrice" style="display:inline">12-16万<span class="spas" onclick="delLi(this)">X</span><p>
                    <p class="p_spn" data-attr="1.6-2.0" data-type="capacity" style="display:inline">1.6-2.0L<span class="spas" onclick="delLi(this)">X</span><p>


                </span>
                <from action="#" method="post" class="">
                    <div class="from_f2">
                        <input type="text" id="queryString" name="queryString" placeholder="请输入你要查询的东西"><span class="sp" onclick="refresh()"><img src="img/67.jpg"></span>
                    </div>
                </from>
            </div><!--chaxun emd-->


            <script type="text/javascript">
            </script>
            <div class="clear"></div>
            <div class="attrs j_NavAttrs" style="display:block">
                <div class="brandAttr j_nav_brand" data-spm="a220m.1000858.1000720">
                    <div class="j_Brand attr">
                        <div class="attrKey">品牌</div>
                        <div class="attrValues" >
                            <%--<div class="j_BrandSearch av-search clearfix">--%>
                                <%--<input type="text" value="" placeholder="搜索&nbsp;品牌名称" class="searchs" />--%>
                            <%--</div>--%>
                            <ul class="av-collapse avd" >

                                <li>
                                    <a  href="javascript:;" onclick="addCause(this)" data-type="carBrand" data-attr="" style="color:red" title="不限">不限</a>
                                </li>

                                <c:forEach items="${carType}" var="type">
                                    <li>
                                        <a  href="javascript:" onclick="addCause(this)" data-attr="${type.typeName}" data-type="carType" title="${type.typeName}">${type.typeName}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="av-options">
                                <a class="advs j_More avo-more ui-more-drop-l" href="javascript:;"  >更多<!--i class="ui-more-drop-l-arrow"></i--><img src="img/35.png"></a>
                            </div><!--attrValues-->

                        </div><!--brandAttr-->
                    </div><!--j_Brand-->
                </div><!--brandAttr end-->


                <div class="cateAttrs j_nav_cat" data-spm="a220m.1000858.1000721">
                    <div class="j_Cate attr">
                        <div class="attrKey"   >
                            <a title="车系" href=" ">车系</a>
                        </div>
                        <div class="attrValues">
                            <ul class="av-expand" >
                                <li >
                                    <a title="车系" style="color:red"  href="javascript:;"  data-attr="" data-type="carBrandLine">
                                        <b>不限</b>
                                    </a>
                                </li>

                                <c:forEach items="${carBrandLine}" var="line">
                                    <li>
                                        <a title="车系" href="javascript:;" data-attr="${line.lineName}" data-type="carBrandLine">
                                            <b> ${line.lineName}</b>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="j_Cate attr">
                        <div class="attrKey"  >
                            <a title="价格" href=" ">价格</a>
                        </div>
                        <div class="attrValues">
                            <ul class="av-expand"  >

                                <li>
                                    <a title="价格" style="color:red" href="javascript:;" onclick="addCause(this)" data-attr="" data-type="sellPrice">
                                        <b>不限</b>
                                    </a>
                                </li>

                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="0-3万" data-type="sellPrice">
                                        <b>3万以下</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="3-5万" data-type="sellPrice">
                                        <b>3-5万</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="5-7万" data-type="sellPrice">
                                        <b>5-7万</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="7-9万" data-type="sellPrice">
                                        <b>7-9万</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="9-12万" data-type="sellPrice">
                                        <b>9-12万</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="12-16万" data-type="sellPrice">
                                        <b>12-16万</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="16-20万" data-type="sellPrice">
                                        <b>16-20万</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="20-万" data-type="sellPrice">
                                        <b>20万以上</b>
                                    </a>
                                </li>

                            </ul>
                        </div>
                    </div>
                    <div class="j_Cate attr">
                        <div class="attrKey">排量</div>
                        <div class="attrValues">
                            <ul>

                                <li>
                                    <a title="排量" style="color:red" href="javascript:;" onclick="addCause(this)" data-attr="" data-type="capacity">
                                        <b>不限</b>
                                    </a>
                                </li>



                                <li>
                                    <a title="排量" href="javascript:;" onclick="addCause(this)" data-attr="-1.0" data-type="capacity">
                                        <b>1.0L以下</b>
                                    </a>
                                </li>

                                <li>
                                    <a title="排量" href="javascript:;" onclick="addCause(this)" data-attr="1.1-1.6" data-type="capacity">
                                        <b>1.1L~1.6L</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="排量" href="javascript:;" onclick="addCause(this)" data-attr="1.6-2.0" data-type="capacity">
                                        <b>1.6L~2.0L</b>
                                    </a>
                                </li>


                                <li>
                                    <a title="排量" href="javascript:;" onclick="addCause(this)" data-attr="2.0-2.5" data-type="capacity">
                                        <b>2.0L~2.5L</b>
                                    </a>
                                </li>

                                <li>
                                    <a title="排量" href="javascript:;" onclick="addCause(this)" data-attr="2.5-3.0" data-type="capacity">
                                        <b>2.5L~3.0L</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="排量" href="javascript:;" onclick="addCause(this)" data-attr="3.0-4.0" data-type="capacity">
                                        <b>3.0L~4.0L</b>
                                    </a>
                                </li>

                                <li>
                                    <a title="排量" href="javascript:;" onclick="addCause(this)" data-attr="4.0-" data-type="capacity">
                                        <b>4.0L以上</b>
                                    </a>
                                </li>

                            </ul>
                        </div>
                    </div>

                    <div class="j_Cate attr">
                        <div class="attrKey"  >
                            <a title="颜色" href=" ">颜色</a>
                        </div>
                        <div class="attrValues">
                            <ul class="av-expand"  >


                                <li>
                                    <a title="颜色" style="color:red" href="javascript:;" data-attr="" data-type="color">
                                        <b>不限</b>
                                    </a>
                                </li>

                                <c:forEach items="${colors}" var="color" >
                                    <li>
                                        <a title="颜色" href="javascript:;" data-attr="${color.id}" data-type="color">
                                            <b>${color.dicName}</b>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>



                    <div class="j_Cate attr">
                        <div class="attrKey"  >
                            <a title="变速箱" href=" ">变速箱</a>
                        </div>
                        <div class="attrValues">
                            <ul class="av-expand"  >


                                <li>
                                    <a title="变速箱" style="color:red" href="javascript:;" onclick="addCause(this)" data-attr="" data-type="gearbox">
                                        <b>不限</b>
                                    </a>
                                </li>

                                <c:forEach items="${gearboxs}" var="gearbox" >
                                    <li>
                                        <a title="变速箱" href="javascript:;" onclick="addCause(this)" data-attr="${gearbox.id}" data-type="gearbox">
                                            <b>${gearbox.dicName}</b>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                </div>

            </div><!--attrs end-->



            <!--综合-->
            <div class="filter clearfix" id="J_Filter"  >
                <div class="fi_left">全部汽车资源（489473）</div>
                <div class="fi_right">
                    <a class="fSort fSort-cur" href=" " title="点击后恢复默认排序"  >默认排序<i class="f-ico-arrow-d"></i></a>
                    <a class="fSort" href=" " title="点击后按人气从高到低"  >人气<i class="f-ico-arrow-d"></i></a>
                    <a class="fSort" href=" ">最新<i class="f-ico-arrow-d"></i></a>
                    <a class="fSort" href=" ">车龄<i class="f-ico-arrow-d"></i></a>
                    <a class="fSort" href=" ">里程<i class="f-ico-arrow-d"></i></a>
                    <a class="fSort" href=" ">价格<i class="f-ico-triangle-mt"></i><i class="f-ico-triangle-mb"></i></a>
                </div>
            </div>




            <div style="clert:both"></div>

            <div class="view grid-nosku views" id="J_ItemList1" >
                <div class="product">
                    <div class="product-iWrap">
                        <div class="productImg-wrap">
                            <a href=" " class="productImg" target="_blank" >
                                <img src="img/5.jpg">
                            </a>
                        </div><!--productImg-wrap end-->
                        <p class="productPrice">
                            <em title="399.00"><b>¥</b>399.00</em>
                        </p>
                        <p class="productTitle">
                            <a href=" " target="_blank" title="【汽车分期】上汽好车e贷 金融产品 专拍链接 订金支付"  >
                                【<span class="H">汽车</span>分期】上汽好车e贷 金融产品 专拍链接 订金支付
                            </a>
                        </p>

                        <div class="productShop">
                            <a class="productShop-name" href=" " target="_blank">上汽荣威官方旗舰店</a>
                        </div><!--productShop END-->

                        <p class="productStatus">
                            <span>月成交 <em>103笔</em></span>
                            <span>评价 <a href=" ">11</a></span>
              <span data-icon="small" class="ww-light ww-small" >
                 <a href=" " target="_blank" class="ww-inline ww-online" title="点此可以直接和卖家交流选好的宝贝，或相互交流网购体验，还支持语音视频噢。"><img src="img/44.png"><span>旺旺在线</span></a>
               </span>
                        </p>
                    </div>

                </div><!--product end-->



            </div>




            <!--分页-->

            <div class="ui-page">
                <div class="ui-page-wrap">
                    <b class="ui-page-num">
                        <b class="ui-page-prev">&lt;&lt;上一页</b>
                        <b class="ui-page-cur">1</b>
                        <a href=" ">2</a>
                        <a href=" ">3</a>
                        <b class="ui-page-break">...</b>
                        <a class="ui-page-next" href=" ">下一页&gt;&gt;</a>
                    </b>
                    <b class="ui-page-skip">
                        <form name="filterPageForm" method="get">
                            <input type="hidden" name="type" value="pc">
                            <input type="hidden" name="q" value="汽车">
                            <input type="hidden" name="totalPage" value="100">
                            <input type="hidden" name="sort" value="s"><input type="hidden" name="style" value="g">    共100页，到第
                            <input type="text" name="jumpto" class="ui-page-skipTo" size="3" value="1">页
                            <button type="submit" class="ui-btn-s" atpanel="2,pageton,,,,20,footer,">确定</button>
                        </form>
                    </b>
                </div>
            </div>



            <p class="relKeyRec relKeyRec-btm"  >
                <span>您是不是想找</span>
                <a href=" ">大众汽车</a>
                <a href=" ">汽车整车</a>
                <a href=" ">suv汽车</a>
                <a href=" ">二手车</a>
                <a href=" ">汽车分期</a>
                <a href=" ">jeep汽车</a>
                <a href=" ">阿里汽车</a>
            </p>


            <!--广告-->


            <div class="view grid-nosku views" id="J_ItemList" >
                <div class="product">
                    <div class="product-iWrap">
                        <div class="productImg-wrap">
                            <a href=" " class="productImg" target="_blank" >
                                <img src="img/5.jpg">
                            </a>
                        </div><!--productImg-wrap end-->
                        <p class="productPrice">
                            <em title="399.00"><b>¥</b>399.00</em>
                        </p>
                        <p class="productTitle">
                            <a href=" " target="_blank" title="【汽车分期】上汽好车e贷 金融产品 专拍链接 订金支付"  >
                                【<span class="H">汽车</span>分期】上汽好车e贷 金融产品 专拍链接 订金支付
                            </a>
                        </p>

                        <div class="productShop">
                            <a class="productShop-name" href=" " target="_blank">上汽荣威官方旗舰店</a>
                        </div><!--productShop END-->
                    </div>

                </div><!--product end-->

                <div class="product">
                    <div class="product-iWrap">
                        <div class="productImg-wrap">
                            <a href=" " class="productImg" target="_blank" >
                                <img src="img/5.jpg">
                            </a>
                        </div><!--productImg-wrap end-->
                        <p class="productPrice">
                            <em title="399.00"><b>¥</b>399.00</em>
                        </p>
                        <p class="productTitle">
                            <a href=" " target="_blank" title="【汽车分期】上汽好车e贷 金融产品 专拍链接 订金支付"  >
                                【<span class="H">汽车</span>分期】上汽好车e贷 金融产品 专拍链接 订金支付
                            </a>
                        </p>

                        <div class="productShop">
                            <a class="productShop-name" href=" " target="_blank">上汽荣威官方旗舰店</a>
                        </div><!--productShop END-->
                    </div>

                </div><!--product end-->

            </div><!--view end-->

        </div><!--main end-->


    </div>
</div>





<!--搜索-->

<div class="btmSearch-loading" id="J_BtmSearch">
    <div class="btmSearch" data-spm="a220m.1000858.1000729">
        <div class="btmSearch-main">
            <form class="btmSearch-form clearfix" action="" target="_top" name="searchTop">
                <fieldset>
                    <div class="btmSearch-input clearfix">
                        <input type="text" value="汽车" autocomplete="off" tabindex="9" accesskey="s" class="btmSearch-mq" id="btm-mq" data-bts="0" name="q" aria-label="搜索关键词">
                        <button type="submit" class="ui-btn-search-l" aria-label="搜索">搜索<s></s></button>
                        <input type="hidden" name="type" value="p">
                        <input type="hidden" name="redirect" value="notRedirect">
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<!--搜索 恩德-->
<!--免费电话-->
<div id="leftsead">
    <ul>
        <li id="tel">
            <a href="javascript:void(0)">
                <div class="hides" id="tels">
                    <div class="hides" id="p1">
                        <img src="img/ll05.png">
                    </div>
                    <div class="" id="p33">
                  <span style="color:#FFF;font-size:12px">
                      <from action="#" method="post" name="1" class="f_zuo">
                          <input type="text" />
                          <span>免费电话</span>
                      </from>
                  </span>
                    </div>
                </div>
            </a>
        </li>

        <li id="btn">
            <a id="top_btn">
                <div class="hides" style="width:161px;display:none">
                    <img src="img/ll06.png" width="161" height="49" />
                </div>
                <img src="img/l06.png" width="47" height="49" class="shows" />
            </a>
        </li>
    </ul>

</div>
<script type="text/javascript">

    function delLi(Obj){
//        删除元素
        var pEle = $(Obj).parent();
        $("a[data-type='"+$(pEle).data("type")+"'][data-attr='"+$(pEle).data("attr")+"']").removeAttr("style");
//        css("color","black");
        $("a[data-type='"+$(pEle).data("type")+"'][data-attr='']").css("color","red");
        $(Obj).parent().remove();

    }


    function addCause(Obj){
//        添加条件到搜索栏上
        var type = $(Obj).data("type");
        $(".p_spn[data-type='"+type+"']").remove();
        var attr = $(Obj).data("attr");
        var text = $(Obj).text();
        $("#searchArea").append('<p class="p_spn" data-type="'+type+'" data-attr="'+attr+'" >'+text+'<span class="spas" onclick="delLi(this)">X</span><p>');
        refresh();
    }

    $(function(){
        //初始化选中状态
        $("#searchArea p").each(function (i,e) {
            if($(e).data("type")){
                var selected = $("a[data-type='"+$(e).data("type")+"'][data-attr='"+$(e).data("attr")+"']")
                $.each($(selected).parent().parent().find("a"),function () {
//                    $(this).css("color","black");
                    $(this).removeAttr("style");
                })
                $(selected).css("color","red");
            }
        })
    })


    function refresh(){

        //初始化url
        var url = "${searchUrl}";

        //拼装数据
        var bo = true;
        if($("#queryString").val()){
            url+="?queryString="+$("#queryString").val();
            bo=false;
        }


        $("#searchArea p").each(function (i,e) {
            if($(e).data("type")){
                url+=bo?"?":"&"+$(e).data("type")+"="+$(e).data("attr");
                if(bo) bo=false;
            }
        })
        //跳转
        window.location.href = url;
    }
</script>
</body>
</html>
