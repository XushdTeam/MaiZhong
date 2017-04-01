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
    <title>品牌信息修改</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap" data-href="${baseUrl}">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>${handle}</h2>
    </blockquote>
    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
        <ul class="layui-tab-title">
            <li class="layui-this">基本资料</li>
            <shiro:hasPermission name="/user/advert">
            <li>品牌LOGO</li>
            </shiro:hasPermission>
        </ul>
        <div class="layui-tab-content" style="height: auto;">
            <!-- 基本资料-->
            <div class="layui-form layui-form-pane layui-tab-item layui-show">
               <form  >
                        <input type="hidden" value="${brand.id}" name="id"/>
                        <div class="layui-form-item">
                            <label class="layui-form-label">品牌名称</label>
                            <div class="layui-input-block">
                                <input name="brandName" autocomplete="off" value="${brand.brandName}" lay-verify="required"
                                       placeholder="用户名称，50字符内" class="layui-input" type="text">
                            </div>
                        </div>
                         <div class="layui-form-item">
                            <label class="layui-form-label">品牌首字母</label>
                            <div class="layui-input-block">
                                <input name="initial" autocomplete="off" value="${brand.initial}" lay-verify="letter"
                                       placeholder="品牌首字母，务必大写" class="layui-input" type="text">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">显示顺序</label>
                            <div class="layui-input-block">
                                <input name="brandSequence" autocomplete="off" value="${brand.brandSequence}" lay-verify="number"
                                       placeholder="品牌显示顺序" class="layui-input" type="text">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">是否启用</label>
                            <div class="layui-input-block">
                                <input type="radio" name="status" value="1" title="启用"  <c:if test="${brand==null||brand.status==1}">checked="checked"</c:if> >
                                <input type="radio" name="status" value="0" title="停用"  <c:if test="${brand.status==0}">checked="checked"</c:if>>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <button class="layui-btn" lay-submit lay-filter="div1" data-href="${saveUrl}">确认修改</button>
                        </div>
                    </form>
            </div>
            <!-- 品牌LOGO-->
            <shiro:hasPermission name="/user/advert">
            <div class="layui-form layui-form-pane layui-tab-item">
                <div class="layui-form-item">
                    <div class="avatar-add">
                        <p>建议尺寸100*100，支持jpg、png、gif，最大不能超过30KB</p>
                        <div class="upload-img">
                            <input type="file" name="advert" id="LAY-file" lay-title="上传品牌LOGO" lay-ext="jpg|png|gif" class="layui-upload-file">
                        </div>
                        <img src="${brand.brandImg}" id="imgShow">
                        <span class="loading"></span>
                    </div>
                </div>
            </div>
            </shiro:hasPermission>

        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/js/event.js"></script>
<script>
    layui.use(['form','upload','app','element'], function(){
        var $ = layui.jquery,
                app = layui.app,
                form = layui.form();
        form.verify({
            letter: [
                /^[A-Z]$/,'必须为大写首字母！'
            ]
        });

        //初始化bar
        app.fixBar();
        //第一个div
        form.on("submit(div1)",function(filedata){
            var url = $(filedata.elem).data("href");
            app.ajaxPost(url,filedata.field,function(e,r){
               if(e){app.layerAlertE(e)}
               else{app.layerAlertS(r.message); app.time(function () {
                   app.route("${baseUrl}");
               });}
            });
            return false;
        });


        /**
         * 第二个div
         * 绑定上传事件
         */
        layui.upload({
            url: '${uploadUrl}',
            before: function(input){
                $(".loading").show();
            },
            success: function(res) {
                $(".loading").hide();
                if (res.status == 200) {
                    app.layerAlertS(res.message);
                    document.getElementById("imgShow").src= res.data;
                    app.time(function () {
                        app.route("${baseUrl}");
                    });
                } else {
                    app.layerAlertE(res.message);
    }
    }
    });

    });
</script>
</body>
</html>
