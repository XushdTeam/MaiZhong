<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/18
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>迈众汽车</title>
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
    <link rel="stylesheet" type="text/css" href="/resources/style/base.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
</head>
<body>
<div class="top e_top">
    <div class="t_cen">
        <a href="#"><img src="../resources/img/logo.png"></a>
        <span class="tell">010-3993-394</span>
        <span class="t_right"><a href="" class="one">我要卖车</a><a href="" class="one">登录</a><a href="" class="two">APP下载</a></span>
    </div>
</div><!--top end-->

<div class="bans"><img src="../resources/img/1-3.jpg"></div>

<div class="x_nav">当前位置 :  <a href="#">首页</a> > <a href="#">二手车评估</a> >  北京2016款 奥迪A3 Limousine 35 TFSI 进取型二手车评估详情</div>

<!--估价选项-->
  <div class="guj">
      <div class="gu hover">
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


      <div class="gu">
          <h2>车况良好</h2>
          <span>${result.priceB}</span>
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


      <div class="gu">
          <h2>车况一般</h2>
          <span>${result.priceC}</span>
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


      <div class="gu none">
          <h2>车况较差</h2>
          <span>${result.priceD}</span>
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
<div class="mc">我要卖车</div>

<!--估价选项 end-->
<div class="bans"><img src="../resources/img/1-4.jpg"></div>



<!--流程-->
<div class="lius">
    <div class="l_cen">
        <h2>我们的流程 <span>快速成交，立马打款，及时有效</span></h2>
        <dl>
            <dt class="dt1"></dt>
            <dd>评估</dd>
        </dl>

        <dl>
            <dt class="dt2"></dt>
            <dd>评估</dd>
        </dl>

        <dl>
            <dt class="dt3"></dt>
            <dd>评估</dd>
        </dl>

        <dl>
            <dt class="dt4"></dt>
            <dd>评估</dd>
        </dl>
    </div>
</div>
<!--流程 end-->


<!--交易记录-->
<div class="jiaos">

    <h2>交易记录 <span> 真是记录、公正透明、超高效率</span></h2>

    <div class="j_cen">

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
            <span>2017年04月03日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>


        <div>
            <span class="cl_one">2106 奥迪A3 Limousine </span>
            <span> 19.90万 </span>
            <span>14.60万</span>
            <span>2016年11月 </span>
            <span>0.85万公里 </span>
            <span>2017年04月03日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>


        <div>
            <span class="cl_one">2106 奥迪A3 Limousine </span>
            <span> 19.90万 </span>
            <span>14.60万</span>
            <span>2016年11月 </span>
            <span>0.85万公里 </span>
            <span>2017年04月03日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>

        <div>
            <span class="cl_one">2106 奥迪A3 Limousine </span>
            <span> 19.90万 </span>
            <span>14.60万</span>
            <span>2016年11月 </span>
            <span>0.85万公里 </span>
            <span>2017年04月03日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>

        <div>
            <span class="cl_one">2106 奥迪A3 Limousine </span>
            <span> 19.90万 </span>
            <span>14.60万</span>
            <span>2016年11月 </span>
            <span>0.85万公里 </span>
            <span>2017年04月03日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>

        <div>
            <span class="cl_one">2106 奥迪A3 Limousine </span>
            <span> 19.90万 </span>
            <span>14.60万</span>
            <span>2016年11月 </span>
            <span>0.85万公里 </span>
            <span>2017年04月03日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>

        <div>
            <span class="cl_one">2106 奥迪A3 Limousine </span>
            <span> 19.90万 </span>
            <span>14.60万</span>
            <span>2016年11月 </span>
            <span>0.85万公里 </span>
            <span>2017年04月03日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>

        <div>
            <span class="cl_one">2106 奥迪A3 Limousine </span>
            <span> 19.90万 </span>
            <span>14.60万</span>
            <span>2016年11月 </span>
            <span>0.85万公里 </span>
            <span>2017年04月03日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>

        <div>
            <span class="cl_one">2106 奥迪A3 Limousine </span>
            <span> 19.90万 </span>
            <span>14.60万</span>
            <span>2016年11月 </span>
            <span>0.85万公里 </span>
            <span>2017年04月03日</span>
            <span>北京</span>
            <span class="last">车商</span>
        </div>
    </div>
</div>

<!--交易记录 end-->

<body>


</html>
