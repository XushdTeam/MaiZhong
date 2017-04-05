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
    <title>广告信息添加</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap" data-href="${baseUrl}">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>广告信息添加</h2>
    </blockquote>
    <blockquote class="layui-elem-quote fhuaui-tip">
        <p><i class="fa fa-info-circle" aria-hidden="true"></i>请将图片编辑好再上传</p>
    </blockquote>
    <div class="site-text site-block">
        <form class="layui-form layui-form-pane">
            <div class="layui-form-item">
                <label class="layui-form-label">广告名称</label>
                <div class="layui-input-block">
                    <input name="advertName" autocomplete="off" lay-verify="required" maxlength="50"
                           placeholder="广告名称" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">商品编号</label>
                <div class="layui-input-block">
                    <input name="carNumber" autocomplete="off" lay-verify="required" maxlength="36"
                           placeholder="商品编号" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">广告链接</label>
                <div class="layui-input-block">
                    <input name="advertUrl" autocomplete="off" lay-verify="required" maxlength="200"
                           placeholder="广告链接" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">广告描述</label>
                <div class="layui-input-block">
                    <input name="advertDesc" autocomplete="off" lay-verify="required" maxlength="3000"
                           placeholder="广告描述" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">广告类型</label>
                <div class="layui-input-inline">
                    <select name="advertType" lay-verify="required" id="advertType">
                        <option value="">请选择广告类型</option>
                        <c:forEach items="${typeList}" var="type">
                            <option value="${type.key}">${type.value}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="layui-form-item" style="height: 150px;">
                <label class="layui-form-label form-upload-label">广告图片</label>
                <div class="layui-input-block">
                    <div class="site-upload normal">
                        <img id="imgShow" src="/resources/images/logo_s.png" style="width: 400px">
                        <input type="hidden" name="advertImg" id="advertImg" value=""/>
                      <div class="site-upbar">
                            <input type="file" name="advert" class="layui-upload-file" lay-ext="jpg|png|gif">
                        </div>
                        <span class="loading"></span>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="btnsubmit" data-href="${saveUrl}">添加广告信息</button>
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

            /**
             * 绑定上传事件
             */

                    layui.upload(
                            {
                                //url: '${uploadUrl}',
                                url: '/advert/advert/upload',
                                before: function (input) {
                                    $(".loading").show();
                                },
                                success: function (res) {
                                    $(".loading").hide();
                                    if (res.status == 200) {
                                        app.layerAlertS(res.message);
                                        document.getElementById("imgShow").src = res.data;
                                        $("#advertImg").val(res.data);
                                    } else {
                                        app.layerAlertE(res.message);
                                    }
                                }
                            }

                );

            /**
             * 表单提交事件
             */
        form.on("submit(btnsubmit)", function (formdata) {
            var img = $("#advertImg").val();
            if (img == "") {
                app.layerMessageE("请上传广告图片！");
            } else {
                formdata.field.advertImg = img;
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
            }
            return false;
        });
        })
        ;
    </script>
</div>
</body>
</html>
