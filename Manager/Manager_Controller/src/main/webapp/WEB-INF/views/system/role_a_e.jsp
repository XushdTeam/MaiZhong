<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/01 0026
  Time: 下午 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>角色新增</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap" data-href="${baseUrl}">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>${handle}</h2>
    </blockquote>
    <div class="site-text site-block">
        <form class="layui-form layui-form-pane">
            <input type="hidden" value="${role.id}" name="id"/>
            <div class="layui-form-item">
                <label class="layui-form-label">角色名称</label>
                <div class="layui-input-block">
                    <input name="roleName" autocomplete="off" value="${role.roleName}" lay-verify="required"
                           placeholder="角色名称，50字符内" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">角色KEY</label>
                <div class="layui-input-block">
                    <input name="roleKey" autocomplete="off" value="${role.roleKey}" lay-verify="required"
                           placeholder="角色KEY，50字符内" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label form-textarea-label">角色描述</label>
                <div class="layui-input-block">
                    <textarea name="roleDescription" lay-verify="required" placeholder="请输入角色描述，200字符内"
                              class="layui-textarea form-textarea"
                              style="margin-top: 0px; margin-bottom: 0px; height: 50px;">${role.roleDescription}</textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">是否启用</label>
                <div class="layui-input-block">
                    <input type="radio" name="status" value="1" title="启用"
                           <c:if test="${role==null||role.status==1}">checked="checked"</c:if> >
                    <input type="radio" name="status" value="0" title="停用"
                           <c:if test="${role.status==0}">checked="checked"</c:if>>
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn" lay-submit lay-filter="btnsubmit" data-href="${saveUrl}">保存</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </form>
    </div>
    <div class="fhui-admin-pagelist"></div>

    <script type="text/javascript" src="/resources/js/event.js"></script>
    <script type="text/javascript">
        layui.use("form_a_e", function () {
            layui.form_a_e.init();
        });
    </script>
</div>
</body>
</html>