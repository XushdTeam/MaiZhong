<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/10
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>迈众汽车</title>
    <link rel="stylesheet" type="text/css" href="/resources/style/assess_style.css" />
    <link rel="stylesheet" type="text/css" href="/resources/style/base.css" />
    <link href="/resources/style/evaluate.css" rel="stylesheet" type="text/css">
    <Link Rel="SHORTCUT ICON" href="img/tao.ico">
    <link rel="Bookmark" href="img/tao.ico">
    <script src="/resources/script/jquery-1.8.0.min.js" type="text/javascript"></script>
    <script src="/resources/script/slider.js"></script>
</head>
<body>

<!--ban 开始-->
<div class="bans">
    <div class="ban_cen">
        <div class="count" id="div_body" >
            <div class="count-left">
                <h1>二手车估价计算器</h1>
                <ul>
                    <li>
                        <span class="p-l-tit">选择车型：</span>
                        <div class="p-r-area">
                            <div class="input-a-area">
                                <div class="select eva-select1" data-toggle="select" id="cbrandlist">
                                    <div class="select-selected" id="sh_sltCar">
                                        <span id="sltBscsCar">选择品牌</span><i class="icon10 icon10-down1"></i>
                                    </div>
                                    <div id="sh_sltCar_pop" data-toggle="selectpop" class="selectpop ass-items " style="display: none">
                                        <div class="selectpop-box fn-clear">
                                            <div>
                                                <a data-dismiss="selectpop" id="pCarClose" href="javascript:void(0);" class="icon16 icon16-close"></a>
                                            </div>
                                            <div data-type="left" class="selectpop-box-prov">
                                                <h4 class="title-prov">请选择品牌</h4>
                                                <div id="pletters" class="selectpop-cont-btn fn-left">
                                                    <a href="javascript:void(0);">A</a>
                                                    <a href="javascript:void(0);">B</a>
                                                    <a href="javascript:void(0);">C</a>
                                                    <a href="javascript:void(0);">D</a>
                                                    <a href="javascript:void(0);">F</a>
                                                    <a href="javascript:void(0);">G</a>
                                                    <a href="javascript:void(0);">H</a>
                                                    <a href="javascript:void(0);">J</a>
                                                    <a href="javascript:void(0);">K</a>
                                                    <a href="javascript:void(0);">L</a>
                                                    <a href="javascript:void(0);">M</a>
                                                    <a href="javascript:void(0);">N</a>
                                                    <a href="javascript:void(0);">O</a>
                                                    <a href="javascript:void(0);">Q</a>
                                                    <a href="javascript:void(0);">R</a>
                                                    <a href="javascript:void(0);">S</a>
                                                    <a href="javascript:void(0);">W</a>
                                                    <a href="javascript:void(0);">X</a>
                                                    <a href="javascript:void(0);">Y</a>
                                                    <a href="javascript:void(0);">Z</a>
                                                </div>
                                                <div class="selectpop-prov-cont fn-clear">
                                                    <div class="selectpop-cont-main  prov-width-03" id="pbrandlist">
                                                    </div>
                                                </div>
                                            </div>
                                            <div id="pseriesblock" data-type="right" class="selectpop-box-prov" style="display: none;">
                                                <h4 class="title-prov">请选择车系</h4>
                                                <div class="selectpop-prov-cont fn-clear">
                                                    <div class="selectpop-cont-main prov-width-01" id="pserieslist">
                                                    </div>
                                                </div>
                                            </div>
                                            <div id="pspecblock" data-type="right" class="selectpop-box-prov" style="display: none;">
                                                <h4 class="title-prov">请选择车型</h4>
                                                <div class="selectpop-prov-cont fn-clear">
                                                    <div class="selectpop-cont-main prov-width-02" id="pspeclist">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <p class="fot-red" id="msg_carInfo"></p>
                        </div>
                    </li>
                    <li>
                        <span class="p-l-tit">上牌年份：</span>
                        <div class="p-r-area">
                            <div class="input-b-area input-b-a">
                                <div class="input-b-box">
                                    <input id="sh_registeYear" readonly="readonly" value="请选择年份" type="text" class="inputall input-b" />
                                    <i class="sq-icon"></i>
                                </div>
                                <div id="sh_registeYear_pop" style="display: none;" class="input-b-pop car-tx">
                                </div>
                            </div>
                            <div class="input-b-area input-b-a">
                                <div class="input-b-box">
                                    <input id="sh_registeMonth" readonly="readonly" value="请选择月份" type="text" class="inputall input-b" name="" />
                                    <i id="isMonth" class="sq-icon"></i>
                                </div>
                                <div id="sh_registeMonth_pop" style="display: none;" class="input-b-pop car-tx"></div>
                            </div>
                            <div class="clear"></div>
                            <p id="msg_date" class="fot-red" style="display: none;"></p>
                        </div>
                    </li>
                    <li>
                        <span class="p-l-tit">车辆属地：</span>
                        <div class="p-r-area">
                            <div class="input-b-area input-b-b">
                                <div class="input-b-box">
                                    <input id="sh_Province" readonly="readonly" disabled type="text" value="北京" class="inputall input-b" name="" />
                                    <i class="sq-icon sq-icon-no"></i>
                                </div>
                                <div id="sh_Province_pop" style="display: none;" class="input-b-pop car-tx"></div>
                            </div>
                            <div class="input-b-area input-b-b">
                                <div class="input-b-box">
                                    <input id="sh_City" readonly="readonly" disabled type="text" value="北京" class="inputall input-b" name="" />
                                    <i id="isCity" class="sq-icon sq-icon-no"></i>
                                </div>
                                <div id="sh_City_pop" style="display: none;" class="input-b-pop car-tx"></div>
                            </div>
                            <div class="clear"></div>
                            <p id="msg_city" class="fot-red" style="display: none;"></p>
                        </div>
                    </li>
                    <li>
                        <span class="p-l-tit">行驶里程：</span>
                        <div class="p-r-area">
                            <div class="input-box">
                                <span class="input-tx">万公里</span>
                                <input id="carMileage" type="text" onblur="mileageValidate()" class="inpnt-mile" name="" maxlength="5" />
                                <p id="msg_mileage" class="fot-red" style="display: none;"></p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <span class="p-l-tit"></span>
                        <div class="p-r-area">
                            <a class="btn btn-org mr5" href="javascript:void(0);" onclick="submit();">卖车估价</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>

        <!--汽车评估结果页面-->
        <div  class="count" id="div_body2" >
            <%--<div class="trend-cont">--%>
            <div class="" style="width: 540px;height: 434px;">
                <div id="EvaSuccess" class="trend-cont-l" style="width: 540px;height: 434px;">

                    <div class="trend-r-tx" >
                        <p class="p-tit"><a href="javascript:;"  id="carName"></a></p>
                    </div>
                    <div class="ch-p">
                        <div class="ch-p-right">
                            <i></i>
                            <div class="ch-p-tx">
                                <p>
                                    卖给商家参考价：
                                </p>
                                <p><span id="PriceRange" class="redb">14.51-16.89</span>万元</p>
                            </div>
                        </div>
                        <!--卖车-->
                        <div class="ch-p-btn">
                            <a href=" " onclick="refreshTrem()" class="btn btn-gray mr20">重新选择条件</a>
                            <a id="btnsellcar" target="_blank" hidefocus="true" href="javascript:void(0);" class="btn btn-org">010-8025-8108</a></div>
                        <!--卖车显示的信息-->
                        <div class="mt15 gray6a">您也可以将车源
                            <a target="_blank"  href="javascript:void(0);">
                                <span class="colf8"> 发布至网站</span>
                            </a>，将车卖给个人，
                            <span class="colf8">售车价格将高于卖给商家</span>
                        </div>
                        <div class="mt5 gray6a">如果您将此车卖给商家，请参考这个价格；由于市场和车况因素影响，价格会有波动</div>
                    </div>
                </div>
            </div>

            <div id="EvaFail" style="display: none;" class="trend-cont-l">
                <div class="fruitless">
                    <i class="icon-car"></i>
                    <div class="fruitless-p-tx">
                        <p>您的车太稀有了，打电话问问我们的评估师吧</p>
                        <p><a href="javascript:;" onclick="refreshTrem()" class="ch-btn-gray">重新选择条件</a><a target="_blank" hidefocus="true" href="javascript:void(0);" class="ch-btn-org">发布卖车信息</a></p>
                    </div>
                </div>
            </div>
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
<div class="">


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




<script type="text/javascript">
    var pinggu;
    /*重置页面数据*/
    function resetPage() {
        $('#sh_sltCar').attr('bid', '');
        $('#sh_sltCar').attr('sid', '');
        $('#sh_sltCar').attr('spid', '');
        $('#sh_sltCar').val('请选择车辆信息');

        $('#sh_registeYear').attr('year', '');
        $('#sh_registeYear').val('请选择年份');
        $('#sh_registeMonth').attr('month', '');
        $('#sh_registeMonth').val('请选择月份');
        document.getElementById("isMonth").className = 'sq-icon sq-icon-no';


        $('#carMileage').val('') ;
    };
    resetPage();


    /* 事件绑定 */
    function eventBind(obj, eventType, callBack) {
        if (obj.addEventListener) {
            obj.addEventListener(eventType, callBack, false);
        }
        else if (window.attachEvent) {
            obj.attachEvent('on' + eventType, callBack);
        }
        else {
            obj['on' + eventType] = callBack;
        }
    };
    /*获取事件体元素*/
    function getEvent() {
        if (document.all) {
            return window.event; //如果是ie
        }
        func = getEvent.caller;
        while (func != null) {
            var arg0 = func.arguments[0];
            if (arg0) {
                if ((arg0.constructor == Event || arg0.constructor == MouseEvent)
                        || (typeof (arg0) == "object" && arg0.preventDefault && arg0.stopPropagation)) {
                    return arg0;
                }
            }
            func = func.caller;
        }
        return null;
    };
    /*所有document事件,隐藏所有ul*/
    var crtShowItem = null;
    function bodyClick() {
        var evt1 = getEvent();
        var obj = evt1.srcElement || evt1.target;
        var curObj = obj;
        while (curObj.parentNode) {
            if (typeof curObj.parentNode.tagName == 'undefined' || curObj.parentNode.tagName.toLowerCase() == 'body') {
                break;
            }
            else if (curObj.parentNode.id.indexOf('sh_') == 0) {
                obj = curObj.parentNode;
                break;
            }
            else {
                curObj = curObj.parentNode;
            }
        }

        if (obj.id.indexOf('sh_') == -1 && obj.tagName.toLowerCase() == 'i') {
            if (obj.parentNode.childNodes[0].id) {
                obj = obj.parentNode.childNodes[0];
            }
            else if (obj.parentNode.childNodes[1].id) {
                obj = obj.parentNode.childNodes[1];
            }
        }

        if (obj.id.indexOf('sh_') == 0) {
            if (crtShowItem != null && crtShowItem.id != 'sh_sltCar_pop') {
                crtShowItem.style.display = 'none';
            }
            crtShowItem = document.getElementById(obj.id + '_pop');
            $('#' + obj.id + '_pop').css('display', 'block');
        }
        else if (crtShowItem != null) {
            crtShowItem.style.display = 'none';
            crtShowItem = null;
        }
    };

    eventBind(document, 'click', bodyClick);

    /*字符串截取方法*/
    function getCharactersLen(charStr, cutCount) {
        var totalCount = 0;
        var newStr = '';
        for (var i = 0; i < charStr.length; i++) {
            var c = charStr.charCodeAt(i);
            if (c < 255 && c > 0) {
                totalCount++;
            } else {
                totalCount += 2;
            }
            if (totalCount >= cutCount) {
                newStr += charStr.charAt(i);
                break;
            }
            else {
                newStr += charStr.charAt(i);
            }
        }
        return newStr;
    };


    var sh_sltCar = $('#sh_sltCar');
    var sh_sltCar_pop = $('#sh_sltCar_pop');
    var pbrandList = $('#pbrandlist');
    var pseriesList = $('#pserieslist');
    var pspecList = $('#pspeclist');
    var pCarClose = $('#pCarClose');
    var pletters = $('#pletters');
    var sltCarSpan = $('#sltCarSpan');
    var sh_pgYear_pop = $('#sh_pgYear_pop');
    var sh_pgMonth_pop = $('#sh_pgMonth_pop');
    var pgSubmit = $('#pgSubmit');
    var Eva = new Object();
    Eva.selectBrand = null;
    Eva.BrandDelyTimeId = 0;
    Eva.selectSeries = null;
    Eva.SeriesDelyTimeId = 0;

    /*页面操作信息，选中品牌车系车型*/
    var isLoadedBrand = false; selectbrandid = 0, selectseriesid = 0, selectspecid = 0, selectYear = 0, selectMonth = 0, sltSeriesName = '', sltSpecName = '';

    /* 设置A-Z标签定位 */
    var setLetterAZ = function () {
        var curletters = $.trim(this.innerHTML);
        var carletters = $('#pbrandlist').find('dl');
        var totalHigh = 0;
        for (var i = 0; i < carletters.length; i++) {
            if (carletters.eq(i).find('dt').html() == curletters) {
                break;
            }
            else {
                totalHigh += (carletters.eq(i).find('dd>a').length + 1) * 26.3;
            }
        }
        $('#pbrandlist').scrollTop(totalHigh);
    };

    /*加载品牌*/
    var ie6 = !-[1, ] && !window.XMLHttpRequest;
    var loadBrand = function (pingu) {
        if (isLoadedBrand) { return; }
        //品牌
        $.ajax({
            url: '${getCarBrandUrl}',
            type: 'GET',
            dataType: 'json',
            success: function (mesg) {
                var result;
                if(mesg.status==200){
                    result=mesg.data;
                }else{
                    return ;
                }
                var gblist = '', blist = '', bletter = 'A';
                var brandName = '';
                $.each(result,function(i,e){
                    brandName = e.id == 35 ? '阿斯顿·马丁' : e.name;
                    if (pinggu && pinggu.brandId) {
                        if (e.id == pinggu.brandId) {
                            blist += '<a href="javascript:void(0);" id="temp_brandid" clsass="selected" brandid="' + e.id + '">' + brandName + '</a>';
                        }
                        else {
                            blist += '<a href="javascript:void(0);" brandid="' + e.id + '">' + brandName + '</a>';
                        }
                    }
                    else {
                        blist += '<a href="javascript:void(0);" brandid="' + e.id + '">' + brandName + '</a>';
                    }
                    if (result.length == i+1  || result[i+1].initial.toUpperCase() != bletter) {
                        gblist += ' <dl class="town-con-dl"><dt>' + e.initial + '</dt><dd class="town-btn">' + blist + '</dd></dl>';
                        if (result.length > i+1) { bletter = result[i+1].initial; }
                        blist = '';
                    }
                })

                pbrandList.html(gblist);
                //     pbrandList.find('dl>dd>a').bind('click', loadCarSeries);
                pbrandList.find("dl>dd>a").bind("mouseover", function () {
                    if (Eva.BrandDelyTimeId)
                        clearTimeout(Eva.BrandDelyTimeId);
                    var _this = $(this);
                    pbrandList.find('.selected').removeClass("selected");
                    pseriesList.find('.selected').removeClass("selected");
                    pspecList.find('.selected').removeClass("selected");
                    _this.add("selected");
                    Eva.BrandDelyTimeId = setTimeout(function () {
                        pseriesList.empty();
                        pspecList.empty();
                        Eva.selectBrand = _this
                        loadCarSeries();
                    }, 40);

                }).bind("mouseout", function () {
                    clearTimeout(Eva.BrandDelyTimeId);
                    Eva.BrandDelyTimeId = 0;
                });
                isLoadedBrand = true;
                if (pinggu && pinggu.brandId) {
                    Eva.selectBrand = $("#temp_brandid");
                    loadCarSeries(pinggu);
                }
            }
        })
    };

    /*加载车系*/
    var loadCarSeries = function (pinggu) {

        //pspecList.hide();
        //pbrandList.find('.selected').removeClass("selected");
        //pseriesList.find('.selected').removeClass("selected");
        //pspecList.find('.selected').removeClass("selected");
        Eva.selectBrand.addClass("selected");
        selectspecid = 0;
        selectseriesid = 0;
        selectbrandid = Eva.selectBrand.attr("brandid");// this.getAttribute("brandid");
        $('#sh_sltCar').attr('bid', selectbrandid);
        sltCarSpan.attr('title', '');
        // this.className = 'selected';
        // $('#sltBscsCar').text(this.innerHTML);
        $('#sltBscsCar').text(Eva.selectBrand.html());
        var url1 = '${getCarSeriesUrl}'+selectbrandid+".action";
        $.ajax({
            url: url1,
            dataType: "json",
            success: function (jsonResult) {
                var result ;
                if(jsonResult.status==200){
                    result = jsonResult.data;
                }else{
                    return;
                }
//                if (typeof br[selectbrandid] == 'undefined' || br[selectbrandid].length == 0) return;
                var gblist = '', blist = '', factoryname = '', curhref = '', seriessplit = '';
                $.each(result,function(i,e) {
                    factoryname = e.factory;
                    if (pinggu && pinggu.seriesId) {
                        if (pinggu.seriesId == e.id) {
                            blist += '<a href="javascript:void(0);" id="temp_seriesid" seriesid="' + e.id + '" class="selected">' + ' ' + e.name + ' ' + '</a>';
                        } else {
                            blist += '<a href="javascript:void(0);" seriesid="' + e.id + '">' + ' ' + e.name + ' ' + '</a>';
                        }
                    } else {
                        blist += '<a href="javascript:void(0);" seriesid="' + e.id + '">' + ' ' + e.name + ' ' + '</a>';
                    }
                    if (result.length == i+1 || result[i + 1].factory != factoryname) {
                        gblist += ' <dl class="town-con-dl"><dt>' + factoryname + '</dt><dd class="town-btn">' + blist + '</dd></dl>';
                        if (result.length > i +1) {
                            factoryname = result[i + 1].factory;
                        }
                        blist = '';
                    }
                })
                pseriesList.html(gblist);
                pseriesList.find("dl>dd>a").bind("mouseover", function () {
                    pseriesList.find('.selected').removeClass("selected");
                    if (Eva.SeriesDelyTimeId)
                        clearTimeout(Eva.SeriesDelyTimeId);
                    var _this = $(this);
                    Eva.SeriesDelyTimeId = setTimeout(function () {
                        Eva.selectSeries = _this;
                        pspecList.empty();
                        loadCarSpec();
                    }, 40);
                });
                pseriesList.find("dl>dd>a").bind("mouseout", function () {
                    clearTimeout(Eva.SeriesDelyTimeId);
                    Eva.SeriesDelyTimeId = 0;
                });
                if (pinggu && pinggu.seriesId) {
                    Eva.selectSeries = $("#temp_seriesid");
                    loadCarSpec(pinggu);
                }
            }
        });
    };

    /*加载车型*/
    var loadCarSpec = function (pinggu) {
        //    sh_sltCar_pop.children().eq(0).attr('class', 'selectpop-box fn-clear box-width-02');
        //   pseriesList.find('.selected').removeClass("selected");
        //   selectseriesid = this.getAttribute("seriesid");
        selectseriesid = Eva.selectSeries.attr("seriesid");
        sltSeriesName = Eva.selectSeries.html();// this.innerHTML;
        sltCarSpan.attr('title', sltSeriesName);
        // this.className = 'selected';
        Eva.selectSeries.addClass("selected");
        selectspecid = 0;
        $('#sh_sltCar').attr('sid', selectseriesid);
        // $('#sltBscsCar').text(this.innerHTML);
        $('#sltBscsCar').text(Eva.selectSeries.html());
        var url1 = '${getCarTypeUrl}'+ selectseriesid+'.action';
        $.ajax({
            url: url1,
            dataType: "json",
            success: function (mesg) {
                var result;
                if (mesg.status == 200) {
                    result = mesg.data;
                } else {
                    return;
                }
                var specHtml = '';
                var year = '';
                $.each(result,function(i,e){
                    if(year != e.year){
                        specHtml += '<dl class="town-con-dl"><dt>' + e.year + '</dt><dd class="town-btn">';
                        year = e.year;
                    }
                    if (pinggu && pinggu.specId) {
                        if (pinggu.specId == e.id) {
                            specHtml += '<a href="javascript:void(0);" class="selected" id="temp_specid" title="' + e.name + '" spid="' + e.id + '">' + e.name + '</a>';
                        }
                        else {
                            specHtml += '<a href="javascript:void(0);" title="' + e.name + '" spid="' + e.id + '">' + e.name + '</a>';
                        }
                    }
                    else {
                        specHtml += '<a href="javascript:void(0);" title="' + e.name + '" spid="' + e.id + '">' + e.name + '</a>';
                    }
                    if(!(result[i+1]&&result[i+1].year==year)){
                        specHtml += '</dd></dl>';
                    }
                })
                pspecList.html(specHtml);
                pspecList.find('dl>dd>a').bind('click', selectCarSpec);
                //pspecList.show();
                //$('#pspecblock').show();
                if (pinggu && pinggu.specId) {
                    $("#temp_specid").trigger("click")
                }
            }
        });
    };

    /*选择车型事件*/
    var selectCarSpec = function () {
        pspecList.find('.selected').removeClass("selected");
        selectspecid = this.getAttribute("spid");
        sltSpecName = this.getAttribute('title');
        this.className = 'selected';
        $('#sltBscsCar').text(sltSeriesName + ' ' + sltSpecName);
        sltCarSpan.attr('title', sltSeriesName + ' ' + sltSpecName);
        $('#sh_sltCar').attr('spid', selectspecid);
        sh_sltCar_pop.hide();
        $('#msg_carInfo').html('');
        ChangeRegisterYear(selectspecid);
    };

    var loaddefaultdatecallback = function (data) {
        data = eval(data);
        if (data.result) {
            var array = data.result.buydate.split("-");
            var regday = new Object();
            regday.year = Number(array[0]);
            regday.month = Number(array[1]);

            if (regday.year > 0) {
                $('#sh_registeYear').attr('year',regday.year);
                loadMonth($('#sh_registeYear'));
                $('#sh_registeYear').val(regday.year + '年') ;
                document.getElementById("isMonth").className = 'sq-icon';
            }
            if (regday.month > 0) {
                $('#sh_registeMonth').attr('month', regday.month);
                $('#sh_registeMonth').val( regday.month + '月');
            }
            $("#msg_date").hide();
            $('#carMileage').val( data.result.mileage);
            if (data.result.mileage)
                $("#msg_mileage").hide();
        }
    }

    /*获取选择的车型年代款，重新加载上牌日期的年份*/
    var ChangeRegisterYear = function (specId) {
        $.ajax({
            //TODO
            url: '${getCarBuyDateAndmileageUrl}' + specId +'.action',
            type: 'GET',
            dataType: 'json',
            success: function (msg) {
                if(msg.status!=200){
                    return;
                }
                var result = msg.data;
                //代码修改
                validate = result.buydate;
                var Years = new Date().getFullYear();
                var yearHTML = '';
                if (parseInt(result.year, 10) > 0) {
                    for (var i = Years; i >= parseInt(result.year, 10) - 2 ; i--) {
                        yearHTML += "<dd><a href=\"javascript:void(0)\" year=\"" + i + "\" onclick=\"loadMonth(this);\">" + i + "年</a></dd>\r\n";
                    }
                    $('#sh_registeYear_pop').html("<dl>" + yearHTML + "</dl>");
                }
                if ($("#temp_specid").size() == 0) {
                    loaddefaultdatecallback({"returncode":0,"message":"","result":{"buydate":result.buydate,"mileage":result.mileage}})
                }
            }
        });
    };
    /*页面初始加载*/
    var init = function () {
        sh_sltCar.bind('click', loadBrand);
        pletters.find('a').bind('click', setLetterAZ);
        pCarClose.bind('click', function () { sh_sltCar_pop.hide(); });
        sh_sltCar_pop.children().eq(0).attr('class', 'selectpop-box fn-clear box-width-02'); $('#pspecblock').show(); $('#pseriesblock').show();
    };
    init();


    /*加载年份*/
    function loadYear(yearId) {
        var yearList = '';
        for (var i = (new Date()).getFullYear() ; i >= 1990  ; i--) {
            yearList += '<a href="javascript:void(0);" year="' + i + '" onclick="loadMonth(this);">' + i + '年</a>';
        }
        $(yearId).html(yearList) ;

    };
    loadYear('sh_registeYear_pop');


    /*加载月份*/
    function loadMonth(objYear) {
        var sltYear = $(objYear).attr('year');
//        var sltYear = objYear.attr('year');
        $('#sh_registeYear').attr('year', sltYear);
        $('#sh_registeYear').val($(objYear).html());
        $('#sh_registeMonth').attr('month', '');
        $('#sh_registeMonth').val('请选择月份') ;
        $('#isMonth').addClass("sq-icon");
        var maxMonth = 12;
        if (sltYear == (new Date()).getFullYear()) maxMonth = (new Date()).getMonth() + 1;
        var monthList = '';
        for (var i = 1; i <= maxMonth; i++) {
            monthList += '<a href="javascript:void(0);" month="' + i + '" onclick="setMonth(this);">' + i + '月</a>';
        }
        $('#sh_registeMonth_pop').html(monthList);
        if (maxMonth < 10)
            $('#sh_registeMonth_pop').css("height",'auto');
        else $('#sh_registeMonth_pop').css("height",'260px');
    };

    /*设置月份*/
    function setMonth(objMonth) {
        var sltmonth = objMonth.getAttribute('month');
        $('#sh_registeMonth').attr('month', sltmonth);
        $('#sh_registeMonth').val( $(objMonth).html());
        msgTip('msg_date', '');
        vregisterDate();
    };



    /*设置月份*/
    function setCity(objCity) {
        var cityId = objCity.getAttribute('cid');
    };

    /* 获取两个日期之间的月数*/
    var getDateDiff = function (startDate, endDate) {
        var startTime = new Date(Date.parse(startDate.replace(/-/g, "/"))).getTime();
        var endTime = new Date(Date.parse(endDate.replace(/-/g, "/"))).getTime();
        var dates = Math.abs((startTime - endTime)) / (1000 * 60 * 60 * 24);
        return Math.floor(dates / 30);
    };


    function mileageValidate() {
        var carMileage = /^(([1-9][0-9]{0,1})|([0-9]{1,2}\.[0-9]{1,2}))$/, mileage = $('#carMileage').val();

        var regYear = $('#sh_registeYear').attr('year'),
                regMonth = $('#sh_registeMonth').attr('month'),
                regData = regYear + '-' + regMonth + '-' + '01',  /* 上牌日期 */
                dateNow = new Date(),
                curMonth = dateNow.getFullYear() + '-' + (dateNow.getMonth() + 1) + '-' + dateNow.getDate();  /* 当前日期 */
        /* 获取当前日期和上牌日期间隔的月数 */
        monthsDiff = getDateDiff(curMonth, regData);
        monthsDiff = monthsDiff <= 0 ? 1 : monthsDiff;

        if (mileage == '') {
            msgTip('msg_mileage', '请选填写里程');
            return false;
        } else if (parseFloat(mileage) === 0 || parseFloat(mileage) === 0.00) {
            msgTip('msg_mileage', '请输入正确的行驶里程');
            return false;

        } else if (!carMileage.test(mileage)) {
            msgTip('msg_mileage', '行驶里程格式不正确，最多为2位整数，2位小数');
            return false;
        } else if ((parseFloat(mileage) * 10000 / monthsDiff) > 6000) {
            msgTip('msg_mileage', '请输入正确的行驶里程');
            return false;
        } else {
            msgTip('msg_mileage', '');
            return true;
        }
    };
    /*信息提示*/
    function msgTip(tipId, tmsg) {
        if (tmsg.length > 0) {
            $('#'+tipId).css("display","");
            $('#'+tipId).html(tmsg);
        }
        else {
            $('#'+tipId).css("display","none");
            $('#'+tipId).html(tmsg);
        }
    };

    /*验证上牌日期*/
    function vregisterDate() {
        var ec_year = $('#sh_registeYear').attr('year');
        var ec_month = $('#sh_registeMonth').attr('month');
        var lresult = false;
        if ( ec_year > 0 && ec_month > 0) {
            var split = validate.split("-");
            if(ec_year<split[0]||ec_month<split[1]){
                lresult = false;
                $('#msg_date').html('请选择正确的上牌日期');
                $('#msg_date').css("display","");
            }
            var lresult = true;
        }
        return lresult;
    }

    /*数据提交*/
    function submit() {
        var ec_bid = $('#sh_sltCar').attr('bid');
        var ec_sid = $('#sh_sltCar').attr('sid');
        var ec_spid = $('#sh_sltCar').attr('spid');
        var ec_year = $('#sh_registeYear').attr('year');
        var ec_month = $('#sh_registeMonth').attr('month');
        var submitValue = "bid=" + ec_bid + "&sid=" + ec_sid + "&specId=" + ec_spid + "&registerYear=" + ec_year + "&registerMonth=" + ec_month + "&selectCarName=" + $('#sltBscsCar').text();
        if (globalValidate(ec_bid, ec_sid, ec_spid, ec_year, ec_month) && vregisterDate()) {
            $.ajax({
                url: '${assessUrl}', data: submitValue,dataType: 'json', success: function (result) {
                    if(result.status==200){
                        var data = result.data;
                        $("#carName").html($('#sltBscsCar').text());
                        $("#carName").attr("href","/car/list.html?s="+$('#sltBscsCar').text());
                        $("#PriceRange").html(data.minprice+"-"+data.maxprice);
                        $("#div_body").hide();
                        $("#div_body2").show();
                    }
                }
            });
        }else{
            alert("请检查数据哦")
        }
    };
    /*全局验证*/
    function globalValidate(ec_bid, ec_sid, ec_spid, ec_year, ec_month) {
        var v_global = true;
        if (ec_bid == '' || ec_sid == '' || ec_spid == '') {
            msgTip('msg_carInfo', '请选择车型信息');
            v_global = false;
        }
        if (ec_year == '') {
            msgTip('msg_date', '请选择月份');
            v_global = false;
        }
        if (ec_month == '') {
            msgTip('msg_date', '请选择月份');
            v_global = false;
        }
        if (!mileageValidate()) {
            v_global = false;
        }
        return v_global;
    };
    document.onkeydown = function CtrlEnterSubmit(evt) {
        e = window.event || evt;
        var keyCode = e.keyCode || e.which || e.charCode;

        if (keyCode == 13 && e.ctrlKey) {
            submit();
        }
    };

    /*加载评估数据*/
    function LoadEvaCar() {
        if (pinggu) {
            if (pinggu.specId > 0) {
                $('#sh_sltCar').attr('bid', pinggu.brandId);
                $('#sh_sltCar').attr('sid', pinggu.seriesId);
                $('#sh_sltCar').attr('spid', pinggu.specId);
                $('#sltBscsCar').html(getCharactersLen(pinggu.carname, 26));
                loadBrand(pinggu);
            }

            if (pinggu.year > 0) {
                $('#sh_registeYear').attr('year', pinggu.year);
                loadMonth($('#sh_registeYear'));
                $('#sh_registeYear').val(pinggu.year + '年') ;
                document.getElementById("isMonth").className = 'sq-icon';
            }
            if (pinggu.month > 0) {
                $('#sh_registeMonth').attr('month', pinggu.month);
                $('#sh_registeMonth').val( pinggu.month + '月');
            }
            if (pinggu.pid > 0 || pinggu.cid > 0) {
                curPId = pinggu.cid > 0 ? pinggu.cid : pinggu.pid;
                defaultArea();
            }
            if (pinggu.mileage != 0) $('#carMileage').val(pinggu.mileage) ;

            globalValidate(pinggu.brandid, pinggu.seriesId, pinggu.specId, pinggu.year, pinggu.month, pinggu.pid, pinggu.cid);
        }
    }
    LoadEvaCar();
</script>


<script type="text/javascript">

    $(function(){

        $("#sh_sltCar").click(function(){
            $(".ass-items").toggle();
        })
        $("#pCarClose").click(function(){
            $(".ass-items").hide();
        })

        $(".input-b-as").click(function(){
            $(".sh_registeYear_pop").toggle();
        })

        $("#sh_registeMonth").click(function(){
            $("#sh_registeMonth_pop").toggle();
        })

        $(".input-b-be").click(function(){
            $(".car-txt").toggle();
        })
        $("#div_body2").hide();
    })

    function refreshTrem(){
        //TODO
        $("#div_body2").hide();
        $("#div_body").show();
    }
</script>

</body>
</html>
