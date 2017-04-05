<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2017/3/22 0006
  Time: 上午 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>店铺添加</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap" data-href="${baseUrl}">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>店铺添加</h2>
    </blockquote>
    <blockquote class="layui-elem-quote fhuaui-tip">
        <p><i class="fa fa-info-circle" aria-hidden="true"></i>请填写完整信息</p>
    </blockquote>
    <div class="site-text site-block">
        <form class="layui-form layui-form-pane">
            <div class="layui-form-item">
                <label class="layui-form-label">店铺编号</label>
                <div class="layui-input-block">
                    <input name="number" autocomplete="off" lay-verify="required" maxlength="40"
                           placeholder="店铺编号" class="layui-input" type="text">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">店铺名称</label>
                <div class="layui-input-block">
                    <input name="businessName" autocomplete="off" lay-verify="required" maxlength="100"
                           placeholder="店铺名称" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">联系人</label>
                <div class="layui-input-block">
                    <input name="linkman" autocomplete="off" lay-verify="required" maxlength="20"
                           placeholder="联系人姓名" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">手机</label>
                <div class="layui-input-block">
                    <input name="mobilePhone" autocomplete="off" lay-verify="phone"
                           placeholder="手机号码" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
            <label class="layui-form-label">座机</label>
            <div class="layui-input-block">
                <input name="telephone" autocomplete="off" lay-verify="requred" maxlength="20"
                       placeholder="座机号码" class="layui-input" type="text">
            </div>
        </div>
            <div class="layui-form-item">
                <label class="layui-form-label">邮箱</label>
                <div class="layui-input-block">
                    <input name="email" autocomplete="off" lay-verify="email"
                           placeholder="电子邮箱" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">店铺地址</label>
                <div class="layui-input-block">
                    <input name="address" autocomplete="off" lay-verify="required" maxlength="150"
                           placeholder="店铺地址" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">地址坐标</label>
                <div class="layui-input-block">
                    <input name="location" autocomplete="off" lay-verify="required" maxlength="100"
                           placeholder="地址坐标" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">是否启用</label>
                <div class="layui-input-block">
                    <input type="radio" name="status" value="1" title="启用"checked="checked">
                    <input type="radio" name="status" value="0" title="停用" >
                </div>
            </div>
            <div class="layui-form-item" >
                <label class="layui-form-label" >店铺LOGO</label>
                <div class="layui-input-block">
                    <div class="site-upload normal" style="height: 200px;width: 300px;">
                        <img id="imgShow" src="/resources/images/logo_s.png" style="width: 300px;height: 200px;">
                        <input type="hidden" name="logo" id="typeImg" value=""/>
                        <div class="site-upbar">
                            <input type="file" name="businessLogo" class="layui-upload-file" lay-ext="jpg|png|gif">
                        </div>
                        <span class="loading"></span>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="btnsubmit" data-href="${saveUrl}">添加店铺</button>
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
            layui.upload({
              //url: '${uploadUrl}',
              url: '/business/logo/upload',
                before: function (input) {
                    $(".loading").show();
                },
                success: function (res) {
                    $(".loading").hide();
                    if (res.status == 200) {
                        app.layerAlertS(res.message);
                        document.getElementById("imgShow").src = res.data;
                        $("#typeImg").val(res.data);
                    } else {
                        app.layerAlertE(res.message);
                    }
                }
            });
            

            form.on("submit(btnsubmit)", function (formdata) {
                var logo = $("#typeImg").val();
                if (logo == "") {
                    app.layerMessageE("请上店铺logo！");
                } else {
                    formdata.field.typeImg = logo;
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
