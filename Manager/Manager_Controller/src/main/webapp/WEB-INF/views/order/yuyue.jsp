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
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>订单管理</title>
    <jsp:include page="../common/head.jsp"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/js/kindeditor-4.1.10/themes/default/default.css">
    <style type="text/css">
        tr th{
            border: 1px solid gray !important;
            text-align: center !important;
        }
        tr td{
            border: 1px solid gray !important;
            text-align: center !important;
        }
        .layui-form-label{
            border: 1px solid gray !important;
            text-align: center !important;
        }
        div input{
            border: 1px solid gray !important;
            text-align: center !important;
        }

    </style>

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
                <col width="9%">
                <col width="9%">
                <col width="10%">
                <col width="9%">
                <col width="9%">
            </colgroup>
            <thead>
            <tr>
                <th>订单编号</th>
                <th>用户手机号</th>
                <th>车型名称</th>
                <th>预估价格</th>
                <th>预估时间</th>
            </tr>
            </thead>
            <tbody id="tbody">
            <input type="hidden" value="${orders.orderId}" name="orderId"/>
            <tr>
                <td>${orders.orderNumber}</td>
                <td>${orders.userId}</td>
                <td>${orders.modelName}</td>
                <td>${orders.reckonPrice}万元</td>
                <td><fmt:formatDate value="${orders.reckonTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>

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
                <td>${orderInfo.sKm}万公里</td>
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

        <div class="layui-tab-content" style="height: 300px;">

            <div class="layui-form layui-form-pane layui-tab-item layui-show">
                <form>
                    <input type="hidden" value="${orders.orderId}" name="orderId" id="orderId"/>
                    <div class="layui-form-item layui-input-inline">
                        <label class="layui-form-label">联系人称呼</label>
                        <div class="layui-input-inline" style="width: 100px;">
                            <input name="linkMan" autocomplete="off" value="${orders.linkMan}" id="linkMan"
                                   class="layui-input" type="text"  style="width: 100px;">
                        </div>
                    </div>

                    <div class="layui-form-item layui-input-inline" style="width: 260px;">
                        <label class="layui-form-label">验车方式</label>
                        <div class="layui-input-block">
                            <select name="dealWay" style="float: left;" id="dealWay">
                                <option value="" >请选择验车方式
                                </option>
                                <option value="1" <c:if test="${orders.dealWay==1}">selected="selected"</c:if>>4S店验车
                                </option>
                                <option value="2" <c:if test="${orders.dealWay==2}">selected="selected"</c:if>>地铁站验车
                                </option>
                                <option value="3" <c:if test="${orders.dealWay==3}">selected="selected"</c:if>>上门验车
                                </option>
                            </select>
                        </div>
                    </div>

                    <div class="layui-form-item layui-input-inline">
                        <label class="layui-form-label">预约地址</label>
                        <div class="layui-input-inline">
                            <input name="address" autocomplete="off" value="${orders.address}" id="address"
                                   class="layui-input" type="text">
                        </div>
                    </div>
                    <div class="layui-form-item layui-input-inline">
                        <label class="layui-form-label">验车时间</label>
                        <div class="layui-input-inline">
                            <input name="checkTime" autocomplete="off" value="${orders.checkTime}" id="checkTime"
                                   class="layui-input" type="text">
                        </div>
                    </div>
                    <div class="layui-form-item layui-input-inline">
                        <label class="layui-form-label">联系手机</label>
                        <div class="layui-input-inline">
                            <input name="linkPhone" autocomplete="off" value="${orders.linkPhone}" id="linkPhone" lay-verify="number"
                                   class="layui-input" type="text">
                        </div>
                    </div>
                    <div class="layui-form-item layui-input-inline">
                        <div class="layui-input-inline">
                            <button class="layui-btn" lay-submit lay-filter="div1" data-href="${saveUrl}">确认预约</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>

    </div>
</div>
<script type="text/javascript" src="/resources/js/event.js"></script>
<script>
    layui.use(['form', 'upload', 'app', 'laydate', 'element'], function () {
        var $ = layui.jquery,
                app = layui.app,
                laydate = layui.laydate;
        form = layui.form();

        //初始化bar
        app.fixBar();

        form.on("submit(div1)", function (filedata) {
            var orderId = $("#orderId").val();
            var url = $(filedata.elem).data("href");
            filedata.field.status=1;
            app.ajaxPost(url, filedata.field, function (e, r) {
                if (e) {
                    app.layerAlertE(e)
                }
                else {
                    app.layerAlertS(r.message);
                    app.time(function () {
                        app.route("/orders/handle/"+orderId);
                    });
                }
            });
            return false;
        });
    });

</script>
</body>
</html>
