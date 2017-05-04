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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/kindeditor-4.1.10/themes/default/default.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/kindeditor-4.1.10/kindeditor-all-min.js" charset="utf-8"></script>
    <script src="/resources/js/jquery.min.js" type="text/javascript"></script>
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

                    <%--富文本开始--%>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">具体内容</label>
                            <div class="layui-input-block">
                                <textarea placeholder="请编辑具体内容" name="content1" id="helpContent" class="layui-textarea" style="height: 400px;width: 700px;">
                                    ${help.content}
                                </textarea>
                            </div>
                        </div>
                    <%--富文本结束--%>
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
            <!--富文本数据同步 同步方法-->
            itemAddEditor.sync();
            filedata.field.content=$("#helpContent").val();
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

    /*富文本测试*/
    <!--图片上传以及富文本编译器-->
    $(function(){
        var kindEditorParams = {
            //指定上传文件参数名称
            filePostName  : "uploadFile",
            //指定上传文件请求的url。
            uploadJson : '/file/upload',
            //上传类型，分别为image、flash、media、file
            dir : "image",
            allowFileManager : true
        }

        //创建富文本编辑器
        itemAddEditor = KindEditor.create("#helpContent",kindEditorParams);
        $("#helpContent").click(function(){
            var _self = $(this);
            KindEditor.editor(kindEditorParams).loadPlugin('image', function() {
                this.plugin.imageDialog({
                    showRemote : false,
                    clickFn : function(url, title, width, height, border, align) {

                        //添加图片成功之后的回显
                        $("#imagesShow").append('<div class="layui-input-block" ><a href="'+url+'"  target="_blank"><img  style="width: 690px;height: 366px"  src="'+url+'"></a><button type="button" class="layui-btn layui-btn-warm" onclick="delImage(this)">删除<button/></div>');
                    }
                });
            });
        });

        <!--图片上传-->

        //给“上传图片按钮”绑定click事件
        $("#fileUpload").click(function(){
            var formTable = $(this).parentsUntil("form").parent("form");
            //打开图片上传窗口
            KindEditor.editor(kindEditorParams).loadPlugin('multiimage',function(){
                var editor = this;
                editor.plugin.multiImageDialog({
                    clickFn : function(urlList) {
                        var imgArray = [];
                        KindEditor.each(urlList, function(i, data) {
                            imgArray.push(data.url);
                            $("#imagesShow").append('<div class="layui-input-block" ><a href="'+data.url+'"  target="_blank"><img  style="width: 690px;height: 366px"  src="'+data.url+'"></a><button type="button" class="layui-btn layui-btn-warm" onclick="delImage(this)">删除<button/></div>');
                        });
                        formTable.find("[name=image]").val(imgArray.join(","));
                        editor.hideDialog();
                    }
                });
            });
        });
    })

    /*富文本测试*/
</script>
</body>
</html>
