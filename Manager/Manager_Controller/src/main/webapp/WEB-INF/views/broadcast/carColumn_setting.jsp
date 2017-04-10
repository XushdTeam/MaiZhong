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
    <title>信息修改</title>
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
                    <input type="hidden" value="${carColumn.id}" name="id"/>
                    <div class="layui-form-item">
                        <label class="layui-form-label">汽车编号</label>
                        <div class="layui-input-block">
                            <input name="carNumber" autocomplete="off" disabled value="${carColumn.carNumber}" lay-verify="number"
                                   placeholder="请输入汽车编号" class="layui-input" type="text">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">显示顺序</label>
                        <div class="layui-input-block">
                            <input name="carSort" autocomplete="off" value="${carColumn.carSort}" lay-verify="number"
                                   placeholder="显示顺序" class="layui-input" type="text">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">所属栏目</label>
                        <div class="layui-input-inline">
                            <select name="columnId" value="${carColumn.columnId}" lay-verify="required">
                                <option value="">请选择所属栏目</option>
                                <c:forEach items="${columnList}" var="item">
                                    <option value="${item.key}"
                                            <c:if test="${carColumn.columnId==item.key}">selected="selected"</c:if>>${item.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">是否启用</label>
                        <div class="layui-input-block">
                            <input type="radio" name="status" value="1" title="启用"
                                   <c:if test="${carColumn==null||carColumn.status==1}">checked="checked"</c:if> >
                            <input type="radio" name="status" value="0" title="停用"
                                   <c:if test="${carColumn.status==0}">checked="checked"</c:if>>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <button class="layui-btn" lay-submit lay-filter="div1" data-href="${saveUrl}">确认修改</button>
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
