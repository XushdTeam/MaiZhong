<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2017/3/6 0006
  Time: 上午 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>汽车添加</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>汽车添加</h2>
    </blockquote>
    <blockquote class="layui-elem-quote fhuaui-tip">
        <p><i class="fa fa-info-circle" aria-hidden="true"></i>请勿重复添加同一商品</p>
        <p><i class="fa fa-info-circle" aria-hidden="true"></i>显示顺序越小越靠前</p>
    </blockquote>
    <div class="site-text site-block">
        <form class="layui-form layui-form-pane">
            <div class="layui-form-item">
                <label class="layui-form-label">汽车ID</label>
                <div class="layui-input-block">
                    <input name="carId" autocomplete="off" lay-verify="number" maxlength="50"
                           placeholder="汽车对应ID" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">汽车栏目</label>
                <div class="layui-input-inline">
                    <select name="columnId" lay-verify="required">
                        <option value="">请选择所属栏目</option>
                        <c:forEach items="${columnList}" var="column">
                            <option value="${column.key}">${column.value}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">显示顺序</label>
                <div class="layui-input-block">
                    <input name="carSort" autocomplete="off" lay-verify="number" maxlength="50"
                           placeholder="显示顺序" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">是否启用</label>
                <div class="layui-input-block">
                    <input type="radio" name="status" value="1" title="启用" checked="checked">
                    <input type="radio" name="status" value="0" title="停用">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="btnsubmit" data-href="${saveUrl}">添加汽车</button>
                </div>
            </div>
        </form>
    </div>

    <script type="text/javascript" src="/resources/js/event.js"></script>
    <script type="text/javascript">
        layui.use(['form', 'upload', 'app'], function () {
            var $ = layui.jquery,
                    form = layui.form(),
                    app = layui.app;
            app.fixBar();
            form.on("submit(btnsubmit)", function (formdata) {
                    var url = $(formdata.elem).data("href");
                    app.ajaxPost(url, formdata.field, function (e, r) {
                        if (e) {
                            app.layerAlertE(e);
                        } else {
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
</div>
</body>
</html>
