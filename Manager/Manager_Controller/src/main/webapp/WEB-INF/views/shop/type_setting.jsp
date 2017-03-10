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
            <li>示例图片</li>
            </shiro:hasPermission>
        </ul>
        <div class="layui-tab-content" style="height: auto;">
            <!-- 基本资料-->
            <div class="layui-form layui-form-pane layui-tab-item layui-show">
               <form  >
                        <input type="hidden" value="${type.id}" name="id"/>

                        <div class="layui-form-item">
                            <label class="layui-form-label">类别名称</label>
                            <div class="layui-input-block">
                                <input name="typeName" autocomplete="off" value="${type.typeName}" lay-verify="required"
                                       placeholder="类别名称，20字符内" class="layui-input" type="text">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">显示顺序</label>
                            <div class="layui-input-block">
                                <input name="typeSequence" autocomplete="off" value="${type.typeSequence}" lay-verify="number"
                                       placeholder="类别显示顺序" class="layui-input" type="text">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">是否启用</label>
                            <div class="layui-input-block">
                                <input type="radio" name="status" value="1" title="启用"  <c:if test="${type==null||type.status==1}">checked="checked"</c:if> >
                                <input type="radio" name="status" value="0" title="停用"  <c:if test="${type.status==0}">checked="checked"</c:if>>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <button class="layui-btn" lay-submit lay-filter="div1" data-href="${saveUrl}">确认修改</button>
                        </div>
                    </form>
            </div>
            <!-- 示例图片-->
            <shiro:hasPermission name="/user/advert">
            <div class="layui-form layui-form-pane layui-tab-item">
                <div class="layui-form-item">
                    <div class="avatar-add">
                        <p>建议尺寸150*50，支持jpg、png、gif，最大不能超过30KB</p>
                        <div class="upload-img">
                            <input type="file" name="advert" id="LAY-file" lay-title="上传示例图片" lay-ext="jpg|png|gif" class="layui-upload-file" >
                        </div>
                        <img src="${type.typeImg}" id="typeImgShow" style="width: 150px;height: 50px;">
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

        //初始化bar
        app.fixBar();
        //第一个div
        form.on("submit(div1)",function(filedata){
            var url = $(filedata.elem).data("href");
            app.ajaxPost(url,filedata.field,function(e,r){
               if(e){app.layerAlertE(e)}
               else{app.layerAlertS(r.message)}
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
                    document.getElementById("typeImgShow").src= res.data;
                } else {
                    app.layerAlertE(res.message);
    }
    }
    });

    });
</script>
</body>
</html>
