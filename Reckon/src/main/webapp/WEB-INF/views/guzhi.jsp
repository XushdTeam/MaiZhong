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
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
     <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
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
        <a href="#"><img src="../resources/img/logo.png"></a>
        <span class="tell">010-8025-8108</span>
        <span class="t_right">
            <a href="/sale" class="one">我要卖车</a>
            <a href="/login" class="one" id="login">登录</a>
            <a href="/per/or" class="two" id="user" style="display:none">188****8888</a>
            <a href="javascript:vold(0)" class="two">APP下载</a></span>

    </div>
</div>

<div class="bans"><img src="../resources/img/1-3.jpg"></div>

<div class="x_nav">当前位置 :  <a href="/">首页</a> > <a href="javascript:;">估值</a> > ${result.city} &nbsp;${result.modelName} 二手车评估详情</div>

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

<!--估价选项 end-->
<div class="bans"><img src="../resources/img/1-4.jpg"></div>



<!--流程-->
<div class="lius">
    <div class="l_cen">
        <h2>我们的流程 <span>快速成交，立马打款，及时有效</span></h2>
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
<div class="jiaos">

    <h2>交易记录 <span> 真实记录、公正透明、超高效率</span></h2>

    <div class="j_cen">

        <div class="one">
            <span class="cl_one">成交车型</span>
            <span>新车指导价</span>
            <span>成交价</span>
            <span>上牌时间</span>
            <span>公里数</span>
            <span>成交日期</span>
            <span>城市</span>
        </div>


        <div>
            <span class="cl_one">2012款 迈腾 1.4TSI DSG豪华型</span>
            <span>16.78万</span>
            <span>7.07万</span>
            <span>2012年12月 </span>
            <span>13万公里 </span>
            <span>2017年04月20日</span>
            <span>北京</span>
        </div>


        <div>
            <span class="cl_one">2012款 迈腾 1.4TSI DSG豪华型</span>
            <span>16.7
                8万</span>
            <span>7.07万</span>
            <span>2012年6月 </span>
            <span>10.85万公里 </span>
            <span>2017年04月18日</span>
            <span>北京</span>
        </div>



        <div>
            <span class="cl_one">2012款 高尔夫 1.6L 自动 时尚型</span>
            <span>13.09万 </span>
            <span>5.64万</span>
            <span>2012年11月 </span>
            <span>12.85万公里 </span>
            <span>2017年04月06日</span>
            <span>北京</span>
        </div>

        <div>
            <span class="cl_one">2012款 高尔夫 1.4TSI 自动舒适型</span>
            <span>14.48万</span>
            <span>6.58万</span>
            <span>2012年5月 </span>
            <span>12万公里 </span>
            <span>2017年04月20日</span>
            <span>北京</span>
        </div>


    </div>
</div>

<!--交易记录 end-->
<div class="clear"></div>
<div class="footer">
    <div class="foot_cen">
        <div class="n_f_m_c">
            <div class="ul1">
                <a href="/about.html">交易方式</a>
                <a href="/help.html">质检说明</a>
                <a href="/joinus.html">帮助中心</a>

                <a href="/joinus.html">加盟合作</a>
                <a href="/feedback.html">关于我们</a>
                <a href="/feedback.html">联系我们</a>
            </div>
            <div class="ul">
                <ul>
                    <li><a href="#">门店交易</a></li>
                    <li><a href="#">上门交易</a></li>
                </ul>
                <ul>
                    <li><a href="#">检测名词解释</a></li>
                    <li><a href="#">专业检测项目</a></li>

                </ul>
                <ul>
                    <li><a href="#">常见问题</a></li>
                    <li><a href="#">服务条款</a></li>

                </ul>

                <ul>
                    <li><a href="#">公司简介</a></li>
                    <li><a href="#">招贤纳士</a></li>

                </ul>
                <ul>
                    <li><a href="#"> 销售商加盟</a></li>

                </ul>
                <ul class="last">
                    <li><a href="#">系电话：010-82967855/18515157855</a></li>
                    <li><a href="#">  公司地址：北京市大兴区西红门嘉悦广场
                        5号楼1002室或西红门公交车站对面</a></li>
                </ul>

            </div><!--ul end-->
        </div><!--f_n-->
        <div class="f_n_r">
            <div class="f_one">
                <img src="../resources/img/m_11.jpg">
                <p>APP下载</p>
            </div>
            <div class="f_one">
                <img src="../resources/img/m_13.jpg">
                <p>微信公众号</p>
            </div>
        </div>


        <div class="clear"></div>
        <div class="pp">
            <p>Copyright © 2017-2020 迈众 All Rights Reserved 版权所有 北京迈众汽车信息服务有限公司</p>
            <p>京ICP备17017795号  &nbsp;&nbsp;&nbsp; 联系电话：010-8025-8108 &nbsp;&nbsp;&nbsp;
                <script type="text/javascript">
                    var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
                    document.write(unescape("%3Cspan id='cnzz_stat_icon_1261672623'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s95.cnzz.com/z_stat.php%3Fid%3D1261672623' type='text/javascript'%3E%3C/script%3E"));
                </script>
            </p>
        </div>

    </div>
</div>

<script>
    $(document).ready(function() {

        var phone = $.cookie('phone');
        var token = $.cookie('token');
        if(phone&&token){
            $.getJSON('/loginByToken/'+phone+'/'+token,function (d) {
                if(d.status==200){
                    $("#login").hide();

                    $('#user').html(phone).show();

                }else{
                    $.cookie("phone",null,{path:"/"});
                    $.cookie("token",null,{path:"/"});

                }
            })
        }
    })
</script>
</body>

</html>
