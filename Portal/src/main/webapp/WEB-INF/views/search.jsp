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
                    <c:forEach items="${searchResult.conditions}" var="condition">
                        <c:if test="${condition.value!=null}">
                            <p class="p_spn" data-type="${condition.key}" data-attr="${condition.value}" style="display:inline">${condition.value}<span class="spas" onclick="delLi(this)">X</span><p>
                        </c:if>
                    </c:forEach>
                </span>
                <from action="#" method="post" class="">
                    <div class="from_f2">
                        <input type="text" id="queryString" value="${searchResult.queryString}" name="queryString" placeholder="请输入你要查询的东西"><span class="sp" onclick="refresh('search')"><img src="img/67.jpg"></span>
                    </div>
                </from>
            </div><!--chaxun emd-->


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
                                    <a  href="javascript:;" onclick="addCause(this)" data-type="car_brand" data-attr="" style="color:red" title="不限">不限</a>
                                </li>

                                <c:forEach items="${searchResult.tbCarBrands}" var="brands">
                                    <li>
                                        <a  href="javascript:" onclick="addCause(this)" data-attr="${brands.brandName}" data-type="carType" title="${brands.brandName}">${brands.brandName}</a>
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
                                    <a title="车系" style="color:red"  href="javascript:;"  data-attr="" data-type="car_brandLine">
                                        <b>不限</b>
                                    </a>
                                </li>

                                <c:forEach items="${searchResult.tbCarBrandLines}" var="line">
                                    <li>
                                        <a title="车系" href="javascript:;" data-attr="${line.lineName}" data-type="car_brandLine">
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
                                    <a title="价格" style="color:red" href="javascript:;" onclick="addCause(this)" data-attr="" data-type="car_sellPrice">
                                        <b>不限</b>
                                    </a>
                                </li>

                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="0-3万" data-type="car_sellPrice">
                                        <b>3万以下</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="3-5万" data-type="car_sellPrice">
                                        <b>3-5万</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="5-7万" data-type="car_sellPrice">
                                        <b>5-7万</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="7-9万" data-type="car_sellPrice">
                                        <b>7-9万</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="9-12万" data-type="car_sellPrice">
                                        <b>9-12万</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="12-16万" data-type="car_sellPrice">
                                        <b>12-16万</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="16-20万" data-type="car_sellPrice">
                                        <b>16-20万</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="价格" href="javascript:;" onclick="addCause(this)" data-attr="20-万" data-type="car_sellPrice">
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
                                    <a title="排量" style="color:red" href="javascript:;" onclick="addCause(this)" data-attr="" data-type="car_capacity">
                                        <b>不限</b>
                                    </a>
                                </li>



                                <li>
                                    <a title="排量" href="javascript:;" onclick="addCause(this)" data-attr="-1.0" data-type="car_capacity">
                                        <b>1.0L以下</b>
                                    </a>
                                </li>

                                <li>
                                    <a title="排量" href="javascript:;" onclick="addCause(this)" data-attr="1.1-1.6" data-type="car_capacity">
                                        <b>1.1L~1.6L</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="排量" href="javascript:;" onclick="addCause(this)" data-attr="1.6-2.0" data-type="car_capacity">
                                        <b>1.6L~2.0L</b>
                                    </a>
                                </li>


                                <li>
                                    <a title="排量" href="javascript:;" onclick="addCause(this)" data-attr="2.0-2.5" data-type="car_capacity">
                                        <b>2.0L~2.5L</b>
                                    </a>
                                </li>

                                <li>
                                    <a title="排量" href="javascript:;" onclick="addCause(this)" data-attr="2.5-3.0" data-type="car_capacity">
                                        <b>2.5L~3.0L</b>
                                    </a>
                                </li>
                                <li>
                                    <a title="排量" href="javascript:;" onclick="addCause(this)" data-attr="3.0-4.0" data-type="car_capacity">
                                        <b>3.0L~4.0L</b>
                                    </a>
                                </li>

                                <li>
                                    <a title="排量" href="javascript:;" onclick="addCause(this)" data-attr="4.0-" data-type="car_capacity">
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
                                    <a title="颜色" style="color:red" href="javascript:;" data-attr="" data-type="car_color">
                                        <b>不限</b>
                                    </a>
                                </li>

                                <c:forEach items="${searchResult.colors}" var="color" >
                                    <li>
                                        <a title="颜色" href="javascript:;" data-attr="${color.dicName}" data-type="car_color">
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
                                    <a title="变速箱" style="color:red" href="javascript:;" onclick="addCause(this)" data-attr="" data-type="car_gearbox">
                                        <b>不限</b>
                                    </a>
                                </li>

                                <c:forEach items="${searchResult.geadboxs}" var="gearbox" >
                                    <li>
                                        <a title="变速箱" href="javascript:;" onclick="addCause(this)" data-attr="${gearbox.dicName}" data-type="car_gearbox">
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
                <div class="fi_left">全部汽车资源</div>
                <div class="fi_right">
                    <a class="fSort"  data-sname="default" href="javascript:;" title="点击后恢复默认排序"  >默认排序<i class="f-ico-arrow-d"></i></a>
                    <%--TODO <a class="fSort" data-sname="car_" data-sort="asc" href="javascript:;" title="点击后按人气从高到低">人气<i class="f-ico-arrow-d"></i></a>--%>
                    <a class="fSort" data-sname="car_createTime" data-sort="asc" onclick="onSort(this)" href="javascript:;" title="点击后按照最新排序">最新<i class="f-ico-arrow-d"></i></a>
                    <a class="fSort" data-sname="car_capacity" data-sort="asc" onclick="onSort(this)" href="javascript:;">排量<i class="f-ico-triangle-mt"></i><i class="f-ico-arrow-d"></i></a>
                    <a class="fSort" data-sname="car_createTime" data-sort="asc" onclick="onSort(this)" href="javascript:;"><i class="f-ico-arrow-d"></i></a>
                    <a class="fSort" data-sname="car_sellPrice" data-sort="asc" onclick="onSort(this)" href="javascript:;">价格<i class="f-ico-triangle-mb"></i></a>
                </div>
            </div>



            <div style="clert:both"></div>




            <div class="view grid-nosku views" id="J_ItemList1" >
            <c:forEach items="${searchResult.rows}" var="carVo">

                <div class="product">
                    <div class="product-iWrap">
                        <div class="productImg-wrap">
                            <a href=" " class="productImg" target="_blank" >
                                <img src="${carVo.image}">
                            </a>
                        </div><!--productImg-wrap end-->
                        <p class="productPrice">
                            <em title="399.00"><b>¥</b>${carVo.sellPrice}</em>
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

                </div>

            </c:forEach>
            </div>




            <!--分页-->

            <c:if test="${searchResult.total>0}">
                <div class="ui-page">
                    <div class="ui-page-wrap">
                            <b class="ui-page-prev" onclick="jumpPage('-1')">&lt;&lt;上一页</b>
                                <c:forEach begin="1" end="${searchResult.pageNum}"  varStatus="vs">
                                    <b onclick="jumpPage('${vs.count}')" <c:if test="${vs.count==searchResult.currentPage}"> class="ui-page-cur"</c:if>>${vs.count}</b>
                                </c:forEach>
                                <%--这玩意不会做啊--%>
                                <%--<b class="ui-page-break">...</b>--%>
                                <a class="ui-page-next" onclick="jumpPage('+1')" href="">下一页&gt;&gt;</a>
                            </b>
                        <b class="ui-page-skip">
                            共${searchResult.pageSize}页，到第<input type="text" name="jumpto" id="jumpto" class="ui-page-skipTo" size="3" value="1">页
                        </b>
                    </div>
                </div>
            </c:if>
            <c:if test="${searchResult.total==0}">
                <h1><font color="aqua">没有查询结果</font></h1>

            </c:if>



            <p class="relKeyRec relKeyRec-btm"  >
                <span>您是不是想找</span>
                <a href=" ">大众汽车</a>
                <a href=" ">汽车整车</a>
                <a href=" ">suv汽车</a>
                <a href=" ">汽车分期</a>
                <a href=" ">jeep汽车</a>
                <a href=" ">迈众汽车</a>
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
                        <!--TODO 搜索方法有问题-->
                        <button type="button" onclick="refresh('search')" class="ui-btn-search-l" aria-label="搜索">搜索<s></s></button>
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
//        css("car_color","black");
        $("a[data-type='"+$(pEle).data("type")+"'][data-attr='']").css("car_color","red");
        $(Obj).parent().remove();
        refresh();
    }


    //排序以及初始化方法  无参数时为刷新调用的初始化方法
    function jumpPage(page){
        if(page){
            if(page=='+1'){
                page = parseInt($(".ui-page-cur:first").text())+1;
            }
            if(page=='-1'){
                page = parseInt($(".ui-page-cur:first").text())-1;
            }
            $("#jumpto").val(page);
            refresh('page');
        }else{
            $("#jumpto").val($(".ui-page-cur:first").text());
        }
        //TODO


    }




    function addCause(Obj){
//        添加条件到搜索栏上
        var type = $(Obj).data("type");
        $(".p_spn[data-type='"+type+"']").remove();
        var attr = $(Obj).data("attr");
        if(attr!=""){
//            var text = $(Obj).text();
            $("#searchArea").append('<p class="p_spn" data-type="'+type+'" data-attr="'+attr+'" >'+attr+'<span class="spas" onclick="delLi(this)">X</span><p>');
        }
        refresh();
    }

    $(function(){
        //初始化选中状态
        $("#searchArea p").each(function (i,e) {
            if($(e).data("type")){
                var selected = $("a[data-type='"+$(e).data("type")+"'][data-attr='"+$(e).data("attr")+"']")
                $.each($(selected).parent().parent().find("a"),function () {
//                    $(this).css("car_color","black");
                    $(this).removeAttr("style");
                })
                $(selected).css("color","red");
            }
        })

        queryString = "${searchResult.queryString}"
        //偷个懒。。。
        sortString = "${searchResult.sortString}"

        if(sortString!=""){
            var sortArr = sortString.split("-");
            //TODO  排序字段回显
            $("#J_Filter a[data-sname='"+sortArr[0]+"']").addClass("fSort-cur");
            $("#J_Filter a[data-sname='"+sortArr[0]+"']").data("sort",sortArr[1]);
        }
    })

    //排序字段选中
    function onSort(Obj){
        //清空排序状态
        $("#J_Filter a").removeClass("fSort-cur");
        sortString = "";

        if($(Obj).data("sname")=="default"){
            return;
        }

        //判断是否被选中
        if($(Obj).hasClass("fSort-cur")){
            //已经被选中的状态更改
            if($(Obj).data("sort")=="asc"){
                $(Obj).data("sort","desc");
            }else{
                $(Obj).data("sort","asc");
            }
        }else{
            //未被选中的添加class字段就可以了
            $(Obj).addClass("fSort-cur");
        }

        sortString = $(Obj).data("sname")+"-"+ $(Obj).data("sort");
        alert(sortString)
        //刷新页面
        refresh("sort");
    }




    //参数的意义  判断刷新事件是否是搜索框 排序 还是跳页 字段分别分 search sort page  无字段情况下为默认条件检索
    //判断是跳页事件还是
    function refresh(kindStr){

        //初始化url
        var url = "${searchUrl}";

//        Search
//        无视其他条件直接跳转  页数 排序无视
        if(kindStr=='search'){
            url+="?searchFileds[queryString]="+$("#queryString").val();
            //跳转
            window.location.href = url;
        }
        //标记字段  添加？  还是 &
        var bo = true;
        //如果是非查询或者 查询字段==null的情况下  说明是 分类检索的分页，排序 或者纯粹分类  需要封装排序字段
        if(!kindStr||queryString==""){
            //封装查询字段
            $.each( $("#searchArea p"),function (i,e) {
                if($(e).data("type")){
                    url+=bo?"?searchFileds[":"&searchFileds["+$(e).data("type")+"]="+$(e).data("attr");
                    bo=false;
                }
            })
        }
        //如果是直接分类 直接跳转  如果不是判断queryString是否为空  不为空添加queryString字段
        if(!kindStr){
            window.location.href = url;
        }else if(queryString!=""){
            url+=bo?"?searchFileds[queryString]=":"&searchFileds[queryString]="+queryString;
        }


        //跳页包含排序条件  排序不包含跳页
        //查询条件存在  非直接跳转 需要添加分页参数 排序参数
        if(kindStr){
            if(sortString!=""){
                url+=bo?"?searchFileds[sortString]=":"&searchFileds[sortString]="+sortString;
                bo=false;
            }
//            if(kindStr=='sort'){
//            }
            if(kindStr=='page'){
                url+=bo?"?pageIndex=":"&pageIndex="+$("#jumpto").val();
            }
        }

        //跳转
        window.location.href = url;
    }

</script>
</body>
</html>
