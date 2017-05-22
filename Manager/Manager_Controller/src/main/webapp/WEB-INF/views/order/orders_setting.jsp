    <%--
      Created by IntelliJ IDEA.
      User: Xushd
      Date: 2017/3/1 0030
      Time: 下午 9:29
      To change this template use File | Settings | File Templates.
    --%>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
        <html>
        <head>
        <title>订单管理</title>
        <jsp:include page="../common/head.jsp"/>
        <link rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/js/kindeditor-4.1.10/themes/default/default.css">
        <script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/js/kindeditor-4.1.10/kindeditor-all-min.js"
        charset="utf-8"></script>
        <script src="/resources/js/jquery.min.js" type="text/javascript"></script>
        </head>
        <body>
        <div class="main-wrap" data-href="${baseUrl}">
        <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>${handle}</h2>
        </blockquote>
        <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">

        <%----%>

        <table class="layui-table" lay-skin="line">
        <colgroup>
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="30%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
        <col width="10%">
        </colgroup>
        <thead>
        <tr>
        <th>订单编号</th>
        <th>用户手机号</th>
        <th>用户称呼</th>
        <th>车型名称</th>
        <th>预估价格</th>
        <th>预估时间</th>
        <th>交易时间</th>
        <th>交易价格</th>
        </tr>
        </thead>
        <tbody id="tbody">
        <tr>
        <td>${orders.orderNumber}</td>
        <td>${orders.userId}</td>
        <td>${orders.linkMan}</td>
        <td>${orders.modelName}</td>
        <td>${orders.reckonPrice}万元</td>
        <td>${orders.reckonTime}</td>
        <td id="dealTime1">${orders.dealTime}</td>
        <td>${orders.dealPrice}万元</td>
        </tr>
        </tbody>
        </table>
        <%----%>
        <table class="layui-table" lay-skin="line">
        <colgroup>
        <col width="9%">
        <col width="9%">
        <col width="9%">
        <col width="9%">
        <col width="9%">
        <col width="9%">
        <col width="9%">
        <col width="9%">
        <col width="9%">
        <col width="9%">
        <col width="11%">
        </colgroup>
        <thead>
        <tr>
        <th>城市</th>
        <th>公里数</th>
        <th>上牌时间</th>
        <th>颜色</th>
        <th>过户次数</th>
        <th>过户时间</th>
        <th>交强险</th>
        <th>年检</th>
        <th>使用性质</th>
        <th>现使用方</th>
        <th>车况</th>
        </tr>
        </thead>
        <tbody id="tbody2">
        <%--  <script id="tpl" type="text/html">--%>
        <tr>
        <td>${orderInfo.cityId}</td>
        <td>${orderInfo.sKm}</td>
        <td>${orderInfo.regDate}</td>
        <td>${orderInfo.color}</td>
        <td>${orderInfo.gh}</td>
        <td>${orderInfo.ghtime}</td>
        <td>${orderInfo.jqx}</td>
        <td>${orderInfo.nj}</td>
        <td>${orderInfo.xz}</td>
        <td>${orderInfo.method}</td>
        <td>${orderInfo.ck}</td>
        </tr>
        <%--    </script>--%>
        </tbody>
        </table>

        <div class="layui-tab-content" style="height: 300px;" >

        <div class="layui-form layui-form-pane layui-tab-item layui-show">
        <form>
        <input type="hidden" value="${orders.orderId}" name="orderId"/>
        <div class="layui-form-item layui-input-inline">
        <label class="layui-form-label">订单状态</label>
        <div class="layui-input-block">
        <select name="status" style="float: left;" id="status">
        <option value="0"<c:if test="${orders.status==0}">selected="selected"</c:if>>未预约
        </option>
        <option value="1"<c:if test="${orders.status==1}">selected="selected"</c:if>>等待验收
        </option>
        <option value="2"<c:if test="${orders.status==2}">selected="selected"</c:if>>车辆处理
        </option>
        <option value="3"<c:if test="${orders.status==3}">selected="selected"</c:if>>等待过户
        </option>
        <option value="4"<c:if test="${orders.status==4}">selected="selected"</c:if>>过户完成
        </option>
        <option value="5"<c:if test="${orders.status==5}">selected="selected"</c:if>>更新指标
        </option>
        <option value="6"<c:if test="${orders.status==6}">selected="selected"</c:if>>已完结
        </option>
        </select>
        </div>
        </div>

        <div class="layui-form-item layui-input-inline">
        <label class="layui-form-label">交易价格</label>
        <div class="layui-input-inline">
        <input name="dealPrice" autocomplete="off" value="${orders.dealPrice}" id="dealPrice"
        class="layui-input" type="text">
        </div>
        </div>

        <div class="layui-form-item layui-input-inline">
        <div class="layui-input-inline">
        <button class="layui-btn" lay-submit lay-filter="div1" data-href="${saveUrl}" >确定</button>
        </div>
        </div>

        </form>
        </div>
        </div>

        </div>
        </div>
        <script type="text/javascript" src="/resources/js/event.js"></script>
        <script>
        layui.use(['form', 'upload', 'app', 'laydate','element'], function () {
        var $ = layui.jquery,
        app = layui.app,
        laydate=layui.laydate;
        form = layui.form();

        //初始化bar
        app.fixBar();
        //第一个div
        form.on("submit(div1)", function (filedata) {
        var status = $("#status").val();
        var dealPrice = $("#dealPrice").val();
        var dealTime1=    document.getElementById("dealTime1").innerText;
        if(status==2&&dealPrice!=null&&dealPrice!=""&&dealTime1.length==0){
        var nowTime=laydate.now(laydate.now,"YYYY-MM-DD hh:mm:ss");
        filedata.field.dealTime=nowTime;
        }
        var url = $(filedata.elem).data("href");
        app.ajaxPost(url, filedata.field, function (e, r) {
        if (e) {
        app.layerAlertE(e)
        }
        else {
        app.layerAlertS(r.message);
        app.time(function () {
        app.route("${baseUrl}");
        });
        }
        });
        return false;
        });
        });

        </script>
        </body>
        </html>
