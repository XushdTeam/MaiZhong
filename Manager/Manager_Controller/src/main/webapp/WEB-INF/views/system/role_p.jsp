<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/01 0027
  Time: 下午 4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>角色权限分配</title>
    <jsp:include page="../common/head.jsp"></jsp:include>
</head>
<body>
<div class="main-wrap" data-href="${baseUrl}">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>${handle}</h2>
    </blockquote>
    <div class="site-text site-block">
        <form class="layui-form layui-form-pane">
            <input type="hidden" name="roleId" value="${roleId}">
            <c:forEach var="item" items="${list}">
                <fieldset class="layui-elem-field">
                    <legend>${item.name}</legend>
                    <div class="layui-field-box">
                        <input type="checkbox" data-parent="0" name="permission" value="${item.id}" title="${item.name}"
                               <c:if test="${item.isChecked()==1}">checked</c:if> />
                        <c:forEach var="child" items="${item.list}">
                            <input type="checkbox" data-parent="${item.id}" name="permission" value="${child.id}"
                                   title="${child.name}"
                                   <c:if test="${child.isChecked()==1}">checked</c:if> />
                        </c:forEach>
                    </div>
                </fieldset>
            </c:forEach>
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
            layui.form_a_e.roleInit();
        });
    </script>
</div>
</body>
</html>
