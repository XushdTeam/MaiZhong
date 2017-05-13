<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/18
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>迈众汽车</title>
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
    <style>
        .shiyan_fudong {
            top:15px;
        }
        .shiyan_fudong:hover {
            top:5px;
            box-shadow: 1px 1px 8px rgba(240,91,72, 0.7);
            -moz-box-shadow:  1px 1px 8px rgba(240,91,72, 0.7);
            -webkit-box-shadow: 1px 1px 8px rgba(240,91,72, 0.7);
            -o-box-shadow:  1px 1px 8px rgba(240,91,72, 0.7);
            -ms-box-shadow:  1px 1px 8px rgba(240,91,72, 0.7);
        }
    </style>
</head>
<body>

<div class="top e_top">
    <div class="t_cen">
        <a href="/" class="logo"><img src="/resources/img/logo.png"></a>
        <ul class="t_right">
            <li><a href="/" class="hover">首页</a></li>
            <li><a href="/sale">我要卖车</a></li>
            <li><a href="/join">销售商加盟</a></li>
            <li><a href="/app">APP下载</a></li>
           <li><a href="/help">帮助中心</a></li>
            <li style="display: none;" id="user_li"><a href="/per/or"  >个人中心</a></li>
        </ul>
        <ul class="lon" style="margin-top: 0px;">
            <li >
                <i class="iconfont icon ">&#xe6a3;</i>
                <a href="/login"  id="user">登录</a>
            </li>
            <li>
                <a href="javascript:void(0)" class="two" id="exit" style="display:none" onclick="exit();">退出</a>
            </li>
        </ul>
    </div>
</div><!--top end-->


<div class="x_nav"></div>

 <div class="can">
     <dl>
         <dt><img src="${result.seriesImg}?imageMogr2/thumbnail/x100" height="100" width="133"></dt>
         <dd class="dd1">${result.modelName}</dd>
         <dd><span>${result.city}</span>|<span>${result.regdate}上牌</span>|<span>${result.mail}万公里</span>|
             <span>${result.gearType}</span>|<span>排量${result.liter}</span>|<span>${result.dischargeStandard}</span>|
             <span>新车售价${result.modelPrice}万</span></dd>
     </dl>
 </div>

<!--估价选项-->
  <div class="guj">


      <div class="gu shiyan_fudong">
          <h2>车况较差</h2>
          <span>${result.priceD}</span>
          <p>车况说明</p>
          <div>迈众作为独立第三方价格服务平台，为您
              提供精确的车辆估值服务，让您在交易前充分
              了解市场行情价</div>

          <dl>
              <dt>外观</dt>
              <dd>外观多块喷漆，有较明显色差，有较多瑕疵 </dd>
          </dl>

          <dl>
              <dt>内饰</dt>
              <dd>内饰较多部件存在磨损，个别严重破损；通风后不存在明显异味。</dd>
          </dl>

          <dl>
              <dt>工况</dt>
              <dd>动力系统正常；机械部位运行存在异常，有部分维修或更换记录</dd>
          </dl>

      </div>



      <div class="gu shiyan_fudong">
          <h2>车况一般</h2>
          <span>${result.priceC}</span>
          <p>车况说明</p>
          <div>迈众作为独立第三方价格服务平台，为您
              提供精确的车辆估值服务，让您在交易前充分
              了解市场行情价</div>

          <dl>
              <dt>外观</dt>
              <dd>外观有轻微色差，有少量瑕疵</dd>
          </dl>

          <dl>
              <dt>内饰</dt>
              <dd>内饰有少量部件存在磨损，个别严重破损；
                  通风后不存在明显异味</dd>
          </dl>

          <dl>
              <dt>工况</dt>
              <dd>动力系统正常且无维修；
                  机械部位运行存在异常，有部分维修或更换记录</dd>
          </dl>

      </div>

      <div class="gu shiyan_fudong">
          <h2>车况良好</h2>
          <span>${result.priceB}</span>
          <p>车况说明</p>
          <div>迈众作为独立第三方价格服务平台，为您
              提供精确的车辆估值服务，让您在交易前充分
              了解市场行情价</div>

          <dl>
              <dt>外观</dt>
              <dd>外观无色差，有个别瑕疵</dd>
          </dl>

          <dl>
              <dt>内饰</dt>
              <dd>内饰有个别部件存在轻微磨损；
                  无破损，无异味</dd>
          </dl>

          <dl>
              <dt>工况</dt>
              <dd>20万公里以内；动力系统运行正常且无维修；
                  机械部位运行正常，有部分维修或更换记录；
                  电子设备及模块使用正常</dd>
          </dl>

      </div>
      <div class="gu none shiyan_fudong">
          <h2>车况优秀</h2>
          <span>${result.priceA}</span>
          <p>车况说明</p>
          <div>迈众作为独立第三方价格服务平台，为您
              提供精确的车辆估值服务，让您在交易前充分
              了解市场行情价</div>

          <dl>
              <dt>外观</dt>
              <dd>外观无可见瑕疵和色差</dd>
          </dl>

          <dl>
              <dt>内饰</dt>
              <dd>内饰干净整洁无明显可见磨损；
                  无异味</dd>
          </dl>

          <dl>
              <dt>工况</dt>
              <dd>2年且4万公里以内；
                  动力系统、机械部位运行正常且无维修；
                  按时保养且记录完整；电子系统无任何故障</dd>
          </dl>

      </div>

  </div>
<div class="mc"><a style="display: block;color: #FFF" href="/sale/${ppap}">我要出售此车</a></div>





<!--流程-->
<div class="liu">
    <div class="l_cen">
        <dl>
            <dt><i class="icon iconfont icon-search"></i></dt>
            <dd>1、搜索车型</dd>
            <ul>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </dl>

        <dl>
            <dt><i class="icon iconfont icon-stop"></i></dt>
            <dd>2、获得报价</dd>
            <ul>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </dl>

        <dl>
            <dt><i class="icon iconfont icon-cart"></i></dt>
            <dd>3、提交订单</dd>
            <ul>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </dl>

        <dl class="lase">
            <dt><i class="icon iconfont icon-huanhuobz"></i></dt>
            <dd>4、极速到账</dd>
        </dl>
    </div>
</div>
<!--流程 end-->


<%--<!--交易记录-->--%>
<%--<div class="jiaos">--%>

    <%--<h2>交易记录 <span> 真实记录、公正透明、超高效率</span></h2>--%>

    <%--<div class="j_cen">--%>

        <%--<div class="one">--%>
            <%--<span class="cl_one">成交车型</span>--%>
            <%--<span>新车指导价</span>--%>
            <%--<span>成交价</span>--%>
            <%--<span>上牌时间</span>--%>
            <%--<span>公里数</span>--%>
            <%--<span>成交日期</span>--%>
            <%--<span>城市</span>--%>
        <%--</div>--%>


        <%--<div>--%>
            <%--<span class="cl_one">2012款 迈腾 1.4TSI DSG豪华型</span>--%>
            <%--<span>16.78万</span>--%>
            <%--<span>7.07万</span>--%>
            <%--<span>2012年12月 </span>--%>
            <%--<span>13万公里 </span>--%>
            <%--<span>2017年04月20日</span>--%>
            <%--<span>北京</span>--%>
        <%--</div>--%>


        <%--<div>--%>
            <%--<span class="cl_one">2012款 迈腾 1.4TSI DSG豪华型</span>--%>
            <%--<span>16.7--%>
                <%--8万</span>--%>
            <%--<span>7.07万</span>--%>
            <%--<span>2012年6月 </span>--%>
            <%--<span>10.85万公里 </span>--%>
            <%--<span>2017年04月18日</span>--%>
            <%--<span>北京</span>--%>
        <%--</div>--%>



        <%--<div>--%>
            <%--<span class="cl_one">2012款 高尔夫 1.6L 自动 时尚型</span>--%>
            <%--<span>13.09万 </span>--%>
            <%--<span>5.64万</span>--%>
            <%--<span>2012年11月 </span>--%>
            <%--<span>12.85万公里 </span>--%>
            <%--<span>2017年04月06日</span>--%>
            <%--<span>北京</span>--%>
        <%--</div>--%>

        <%--<div>--%>
            <%--<span class="cl_one">2012款 高尔夫 1.4TSI 自动舒适型</span>--%>
            <%--<span>14.48万</span>--%>
            <%--<span>6.58万</span>--%>
            <%--<span>2012年5月 </span>--%>
            <%--<span>12万公里 </span>--%>
            <%--<span>2017年04月20日</span>--%>
            <%--<span>北京</span>--%>
        <%--</div>--%>


    <%--</div>--%>
<%--</div>--%>

<!--交易记录 end-->

<div class="cj" style="margin-top: 0px;background: #F8F8F8">
    <div class="cj_cen" id="owl-example" >


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


<div class="clear"></div>
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
