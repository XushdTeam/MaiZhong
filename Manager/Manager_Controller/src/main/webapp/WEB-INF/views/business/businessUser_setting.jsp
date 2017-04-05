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
    <title>4S店管理员</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap" data-href="${baseUrl}">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>管理员添加</h2>
    </blockquote>
    <div class="site-text site-block">
        <form class="layui-form layui-form-pane">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-block">
                    <input name="userName" autocomplete="off" lay-verify="required"
                           placeholder="用户名" class="layui-input" type="text" value="${businessUser.userName}" >
                    <input name="id" value="${businessUser.id}" type="hidden">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">登录密码</label>
                <div class="layui-input-block">
                    <input name="password" id="password" autocomplete="off"  maxlength="20"
                           placeholder="原密码将失效" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">手机号</label>
                <div class="layui-input-block">
                    <input name="userPhone" autocomplete="off" lay-verify="phone"
                           placeholder="手机号" class="layui-input" type="text" value="${businessUser.userPhone}" >
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
                    <button class="layui-btn" lay-submit lay-filter="btnsubmit" data-href="${saveUrl}">账号修改</button>
                </div>
            </div>
        </form>
    </div>
    <script type="text/javascript" src="/resources/js/event.js"></script>
    <script type="text/javascript">
        layui.use(['form', 'app'], function () {
            var $ = layui.jquery,
                    form = layui.form(),
                    app = layui.app;
            form.verify({
                account: [
                    /^[a-zA-Z0-9_]{1,20}$/,'用户名为字母数字下划线！'
                ]
            });
            app.fixBar();
            form.on("submit(btnsubmit)", function (formdata) {
                var url = $(formdata.elem).data("href");
                formdata.field.password=app.sha($("#password").val());
                app.ajaxPost(url, formdata.field, function (e, r) {
                    if (e) {
                        app.layerAlertE(e);
                    } else {
                        app.layerAlertS(r.message);
                        app.time(function () {
                            app.route("/businessUser");
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