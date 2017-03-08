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
    <title>品牌添加</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>品牌添加</h2>
    </blockquote>
    <blockquote class="layui-elem-quote fhuaui-tip">
        <p><i class="fa fa-info-circle" aria-hidden="true"></i>品牌默认显示顺序为999</p>
    </blockquote>
    <div class="site-text site-block">
        <form class="layui-form layui-form-pane">
            <div class="layui-form-item">
                <label class="layui-form-label">品牌名称</label>
                <div class="layui-input-block">
                    <input name="brandName" autocomplete="off" lay-verify="required" maxlength="50"
                           placeholder="汽车品牌名称" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">品牌顺序</label>
                <div class="layui-input-block">
                    <input name="brandSequence" autocomplete="off" lay-verify="number" maxlength="50"
                           placeholder="品牌顺序" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">是否启用</label>
                <div class="layui-input-block">
                    <input type="radio" name="status" value="1" title="启用"  <c:if test="${brand==null||brand.status==1}">checked="checked"</c:if> >
                    <input type="radio" name="status" value="0" title="停用"  <c:if test="${brand.status==0}">checked="checked"</c:if>>
                </div>
            </div>

            <div class="layui-form-item" style="height: 150px;">
                <label class="layui-form-label form-upload-label">品牌LOGO</label>
                <div class="layui-input-block">
                    <div class="site-upload normal">
                        <img id="imgShow" src="/resources/images/logo_s.png">
                        <input type="hidden" name="brandImg" id="brandLogo" value=""/>
                        <div class="site-upbar">
                            <input type="file" name="advert" class="layui-upload-file" lay-ext="jpg|png|gif">
                        </div>
                        <span class="loading"></span>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="btnsubmit" data-href="${saveUrl}">添加品牌</button>
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

            /**
             * 绑定上传事件
             */
            app.fixBar();
            layui.upload({
              //url: '${uploadUrl}',
              url: '/brand/advert/upload',
                before: function (input) {
                    $(".loading").show();
                },
                success: function (res) {
                    $(".loading").hide();
                    if (res.status == 200) {
                        app.layerAlertS(res.message);
                        document.getElementById("imgShow").src = res.data;
                        $("#brandLogo").val(res.data);
                    } else {
                        app.layerAlertE(res.message);
                    }
                }
            });
            

            form.on("submit(btnsubmit)", function (formdata) {
                var logo = $("#brandLogo").val();
                if (logo == "") {
                    app.layerMessageE("LOGO请上传！");
                } else {
                    formdata.field.brandLogo = logo;
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
        });
    </script>
</div>
</body>
</html>
