<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/31
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人中心</title>
    <%@ include file="head.jsp" %>
    <link href="/resources/main/css/MyCyp.css" rel="stylesheet">
    <link href="/resources/main/css/page.css" rel="stylesheet">
</head>
<body>
<%@ include file="nav.jsp" %>

<div class="w1200 mauto">
    <div class="mt25 clearfix">
        <%@ include file="personal_nav.jsp" %>
        <div class="fr w1060">
            <div class="bbs1b h41 pr">

            </div>
            <div class="pr10 pl10 pt25">
                <table class="fs14 c9 tabcar w">
                    <thead>
                    <tr class="c3 bgf5 fs14">
                        <td colspan="2" width="550">
                            <div class="select_box select_box2">
                                <span class="c3 text">车辆</span>

                            </div>
                        </td>
                        <td width="260" style="padding-left: 80px">合手价</td>
                        <td width="230">
                            <div class="select_box select_box2">
                                <span class="c3 text">竞拍结束时间</span>

                            </div>
                        </td>
                    </tr>
                    </thead>
                    <c:forEach items="${list}" var="item">
                        <tr height="120" class="trhover">
                            <td width="140px" class="pl10">
                                <div class="carnew">
                                    <img src="${item.zq45}">
                                </div>
                            </td>
                            <td width="270px" class="pl10 pr10">
                                <div class="fs14 clearfix">
                                    <a target="_blank" class="fl cblack" href="/list/check/report/${item.carId}">
                                        <span class="fl carname" style="cursor: pointer">${item.modelName}</span>
                                    </a>
                                    <p class="fr fs12 cwhite w60"></p>
                                </div>
                                <p class="mt10">${item.zcd}&nbsp;&nbsp;初登：${item.cdrq}&nbsp;&nbsp;等级：${item.pj}</p>
                                <p>里程：${item.bxlc}万公里&nbsp;&nbsp;排放：${item.pfbz}</p>
                            </td>
                            <td>
                                <span class="fs16 ccheng ml10">${item.dealPrice}</span>
                                <span class="fs16 ccheng ml10">卖家已确认</span>
                            </td>
                            <td class="pl20">${item.dealTime}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
