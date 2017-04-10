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
    <title>咨询处理</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap" data-href="${baseUrl}">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>${handle}</h2>
    </blockquote>
    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">

        <div class="layui-tab-content" style="height: auto;">
            <div class="layui-form layui-form-pane layui-tab-item layui-show">
                <form>
                    <input type="hidden" value="${consult.id}" name="id"/>
                    <div class="layui-form-item">
                        <label class="layui-form-label">手机号</label>
                        <div class="layui-input-block">
                            <input name="phone" autocomplete="off" value="${consult.phone}" lay-verify="phone"
                                   class="layui-input" type="text">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">咨询类型</label>
                        <div class="layui-input-inline">
                            <select name="type">
                                <option value="0" <c:if test="${consult.type==0}">selected="selected"</c:if>>新车</option>
                                <option value="1" <c:if test="${consult.type==1}">selected="selected"</c:if>>二手车
                                </option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">处理状态</label>
                        <div class="layui-input-inline">
                            <select name="status">
                                <option value="0">未处理</option>
                                <option value="1" selected="selected">已处理</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">客服姓名</label>
                        <div class="layui-input-block">
                            <input name="serviceName" autocomplete="off" value="${consult.serviceName}"
                                   lay-verify="required" maxlength="20"
                                   class="layui-input" type="text">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">备注</label>
                        <div class="layui-input-block">
                            <input name="remark" autocomplete="off" value="${consult.remark}"
                                   class="layui-input" type="text">
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <button class="layui-btn" lay-submit lay-filter="div1" data-href="${saveUrl}">确认</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/js/event.js"></script>
<script>
    layui.use(['form', 'upload', 'app', 'element'], function () {
        var $ = layui.jquery,
                app = layui.app,
                form = layui.form();

        //初始化bar
        app.fixBar();
        //第一个div
        form.on("submit(div1)", function (filedata) {
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
