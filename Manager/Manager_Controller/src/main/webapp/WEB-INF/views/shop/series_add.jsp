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
    <title>车系添加</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>车系添加</h2>
    </blockquote>
    <div class="site-text site-block">
        <form class="layui-form layui-form-pane">
            <div class="layui-form-item">
                <label class="layui-form-label">车系名称</label>
                <div class="layui-input-block">
                    <input name="lineName" autocomplete="off" lay-verify="required" maxlength="20"
                           placeholder="车系名称" class="layui-input" type="text">
                   <input name="brandId" value="${brandIdS}" type="hidden">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">类别顺序</label>
                <div class="layui-input-block">
                    <input name="lineSequence" autocomplete="off" lay-verify="number" maxlength="5"
                           placeholder="车系顺序" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">是否启用</label>
                <div class="layui-input-block">
                    <input type="radio" name="status" value="1" title="启用">
                    <input type="radio" name="status" value="0" title="停用">
                </div>
            </div>

          <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="btnsubmit" data-href="${saveUrl}">车系添加</button>
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
