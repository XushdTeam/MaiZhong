<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/20
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>${title}-迈众汽车</title>
    <link rel="stylesheet" type="text/css" href="/resources/style/base.css" />
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<!--background-->
<img src="/resources/img/gy.jpg" width="100%">
<!--background-->
<!--中间部分-->
<div class="A_colocr">
    <div class="A_con">
        <div class="left">
            <ul>
                <li <c:if test="${tab==0}">class="cun"</c:if>><a href="/about.html">关于我们 <span>&gt;</span></a></li>
                <li <c:if test="${tab==1}">class="cun"</c:if>><a href="/help.html">帮助中心 <span>&gt;</span></a></li>
                <li <c:if test="${tab==2}">class="cun"</c:if>><a href="/joinus.html">加入我们  <span>&gt;</span></a>  </li>
                <li <c:if test="${tab>=3}">class="cun"</c:if>><a href="/feedback.html">用户反馈  <span>&gt;</span> </a>  </li>

            </ul>
        </div>
        <div class="right">
            <c:choose>
                <c:when test="${tab==0}">
                    <h3>公司简介</h3>
                    <div class="xq">
                        北京迈众汽车信息服务有限公司，是一家致力服务于各大汽车经销商。推进4S店新车销量与市场流量的专业服务公司。2017年4月15日，产品正式上线，我们将成为中国领先的专业服务于各大汽车集团、4s店与C端客户的互联网平台，通过产品服务、数据技术和资源
                        共享为汽车消费者提供选车、买车、用车、换车、金融、维修、美容、装饰等全方位一体的快捷专业的一站式服务端口，通过我们的平台将庞大的客户资源与各大汽车集团、4S店服务资源优选整合。公司将秉承“杰出服务，行业领先”的经营理念，开启汽车互联网新纪元。

                    </div>
                    <div class=""><img src="/resources/img/j2.jpg"></div>
                </c:when>
                <c:when test="${tab==1}">
                    <h3>帮助中心</h3>
                    <div>
                        <h4>过户需要的手续</h4>
                        <p>卖方：车主身份证、车辆登记证、车辆行驶本、购车原始发票（如果之前有过户历史需提供过户票）。卖方是单位则需要组织机构代码证书原件及公章。</p>
                        <p>买方：身份证，外地人上当地牌照另需有效期内暂住证（部分城市改用居住证）。买方是单位则需要组织机构代码证书原件及公章。
                            双方：签订二手车买卖合同。带齐以上所有手续，到二手车过户大厅办理。</p>
                        <h4>二手车过户交易流程</h4>
                        <p>1.检查车辆并填写检查记录表</p>
                        <p>2.领取照片</p>
                        <p>3.取号机取号</p>
                        <p>4.转移受理</p>
                        <p>5.领取回执单</p>
                        <p>6.收费</p>
                        <p>7.选号</p>
                        <p>8.领行驶证，登记证，年检标志</p>
                        <p>9.领取号牌</p>
                    </div>
                </c:when>
                <c:when test="${tab==2}">
                    <h3>加入我们</h3>
                    <div>
                        <img src="/resources/img/ju.jpg" width="100%">
                        <p class="zp">招聘职位</p>
                        <ul class="ul">
                            <li><a href="">二手车评估主管 <span>></span></a></li>
                            <li><a href="">业务拓展专员 <span>></span></a></li>
                            <li><a href="">业务拓展主管 <span>></span></a></li>
                            <li><a href="">大客户销售 <span>></span></a></li>
                            <li><a href="">大客户开发 <span>></span></a></li>
                        </ul>
                        <p class="zp">公司福利</p>
                        <ul class="ul">
                            <li><a href="">公司上交五险一金</a></li>
                            <li><a href="">绩效奖金</a></li>
                            <li><a href="">全勤奖</a></li>
                            <li><a href="">交通补助</a></li>
                            <li><a href="">通讯补贴</a></li>
                            <li><a href="">员工旅游</a></li>
                            <li><a href="">节日福利</a></li>
                            <li><a href="">包住</a></li>
                        </ul>
                    </div>
                </c:when>
                <c:when test="${tab==3}">
                    <h3>用户反馈</h3>
                    <div class="A_form">
                        <form id="f_form" action="/feedback/post.html" method="post">
                            <div>
                                <label>反馈内容</label>
                                <textarea name="content" id="content"  placeholder="亲！请输入你的意见!"  style="resize: none" maxlength="500"></textarea>
                            </div>
                            <div>
                                <label>联系电话</label>
                                <input type="text" name="phone" id="phone" placeholder="您的联系方式" maxlength="11" />
                            </div>
                            <div>
                                <label>您的称呼</label>
                                <input type="text" name="n" id="linkName" placeholder="您的称呼" maxlength="10"  />
                                <input type="hidden" name="surname" id="surname">
                                <input type="radio" value="先生" name="r" style="width: 20px" checked>先生
                                <input type="radio" value="女士" name="r" style="width: 20px">女士
                            </div>
                            <div class="button">
                                <button class="sub">点击提交</button>
                            </div>
                        </form>
                    </div>
                </c:when>
                <c:when test="${tab==4}">
                    <h1>提交成功，谢谢您！</h1>
                </c:when>
            </c:choose>
        </div>
    </div><!--A_con end-->
</div>
<!--中间部分end-->
<jsp:include page="footer.jsp"></jsp:include>
<script src="http://cdn.bootcss.com/jquery/3.2.0/jquery.min.js" type="text/javascript"></script>
<script>

    var form = document.forms[0],submit = document.querySelector(".sub");
    form.onsubmit = function(){
        var content = $("#content").val();
        if(content==""){alert("还没有输入意见");return false;}
        var linkname = $("#linkName").val();
        if(linkname==""){alert("输入您的称呼，我们会尽快联系您");return false;}
        var phone = $("#phone").val();
        if(!(/^1[34578]\d{9}$/.test(phone))){
            alert("手机号码有误，请重填");
            return false;
        }
        $("#surname").val(linkname+$('input:radio:checked').val());
    }

</script>
</body>
</html>
