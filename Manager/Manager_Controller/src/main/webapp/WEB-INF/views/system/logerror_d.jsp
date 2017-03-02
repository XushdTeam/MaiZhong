<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/1 0022
  Time: 上午 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>异常错误详情</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap" data-href="${baseUrl}">
    <blockquote class="layui-elem-quote fhui-admin-main_hd red">
        <h2>异常日志/异常日志详情</h2>
    </blockquote>
    <div class="site-text site-block">
        <fieldset class="layui-elem-field">
            <legend>模块-方法</legend>
            <div class="layui-field-box">
                ${log.moduleName}  -  ${log.methodName}
            </div>
        </fieldset>
        <fieldset class="layui-elem-field">
            <legend>用户-时间</legend>
            <div class="layui-field-box">
                ${log.userName} -  ${log.logTime}
            </div>
        </fieldset>
        <fieldset class="layui-elem-field">
            <legend>Service方法</legend>
            <div class="layui-field-box">
                ${log.logMethod}
            </div>
        </fieldset>
        <fieldset class="layui-elem-field">
            <legend>参数</legend>
            <div class="layui-field-box">
                ${log.params}
            </div>
        </fieldset>
        <fieldset class="layui-elem-field">
            <legend>异常名称</legend>
            <div class="layui-field-box">
                ${log.exceptionCode}
            </div>
        </fieldset>
        <fieldset class="layui-elem-field">
            <legend>异常详细</legend>
            <div class="layui-field-box">
                ${log.exceptionDetail}
            </div>
        </fieldset>
    </div>

    <div class="fhui-admin-pagelist"></div>
    <script type="text/javascript" src="/resources/js/event.js"></script>
    <script type="text/javascript">
        layui.use("form_a_e", function () {
            layui.form_a_e.fixbar();
        });
    </script>
</div>
</body>
</html>
