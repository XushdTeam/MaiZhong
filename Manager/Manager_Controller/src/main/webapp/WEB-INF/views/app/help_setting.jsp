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
    <title>帮助管理</title>
    <jsp:include page="../common/head.jsp"/>
    <link rel="stylesheet" href="/resources/edit/css/wangEditor.min.css">
    <script type="text/javascript" src="/resources/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="/resources/edit/js/wangEditor.min.js"></script>
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
                    <input type="hidden" value="${help.id}" name="id"/>
                    <div class="layui-form-item">
                        <label class="layui-form-label">标题</label>
                        <div class="layui-input-block">
                            <input name="title" autocomplete="off" value="${help.title}"
                                   class="layui-input" type="text">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">是否启用</label>
                        <div class="layui-input-block">
                            <input type="radio" name="status" value="1" title="启用"
                                   <c:if test="${help==null||help.status==1}">checked="checked"</c:if> >
                            <input type="radio" name="status" value="0" title="停用"
                                   <c:if test="${help.status==0}">checked="checked"</c:if>>
                        </div>
                    </div>

                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">内容</label>
                        <div class="layui-input-block">
                             <textarea id="textarea1" style="height:500px;max-height:800px;">
                                <p>请输入内容...</p>
                             </textarea>
                        </div>
                    </div>
                    <div id="innercontent" style="display: none" >
                        ${help.content}
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

            // 获取编辑器区域完整html代码
            var html = editor.$txt.html();
            filedata.field.content=html;
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
    var editor = null;

    $(function(){
        editor = new wangEditor('textarea1');

        // 上传图片（举例）
        editor.config.uploadImgUrl = '/help/upload';
        editor.config.uploadImgFileName = 'uploadFile'
        editor.config.mapAk = 'N8kgZsufZYtKgEXbtUoTHrKlaqgAxTFY';
        editor.create();

        // 初始化编辑器的内容
        editor.$txt.html($("#innercontent").html());
    })
</script>
</body>
</html>
