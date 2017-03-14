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
    <title>广告信息修改</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap" data-href="${baseUrl}">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>${handle}</h2>
    </blockquote>
    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
        <ul class="layui-tab-title">
            <li class="layui-this">广告资料</li>
            <shiro:hasPermission name="/user/advert">
            <li>广告图片</li>
            </shiro:hasPermission>
        </ul>
        <div class="layui-tab-content" style="height: auto;">
            <!-- 基本资料-->
            <div class="layui-form layui-form-pane layui-tab-item layui-show">
               <form  >
                        <input type="hidden" value="${advert.id}" name="id"/>
                   <div class="layui-form-item">
                       <label class="layui-form-label">广告名称</label>
                       <div class="layui-input-block">
                           <input name="advertName" autocomplete="off" value="${advert.advertName}" lay-verify="required" maxlength="50"
                                  placeholder="广告名称" class="layui-input" type="text">
                       </div>
                   </div>
                   <div class="layui-form-item">
                       <label class="layui-form-label">商品编号</label>
                       <div class="layui-input-block">
                           <input name="carNumber" autocomplete="off" value="${advert.carNumber}" lay-verify="required" maxlength="36"
                                  placeholder="商品编号" class="layui-input" type="text">
                       </div>
                   </div>
                   <div class="layui-form-item">
                       <label class="layui-form-label">广告链接</label>
                       <div class="layui-input-block">
                           <input name="advertUrl" autocomplete="off" value="${advert.advertUrl}" lay-verify="required" maxlength="200"
                                  placeholder="广告链接" class="layui-input" type="text">
                       </div>
                   </div>
                   <div class="layui-form-item">
                       <label class="layui-form-label">广告类型</label>


                       <div class="layui-input-inline">
                           <select name="advertType" value="${advert.advertType}" lay-verify="required" id="advertType">
                               <option value="">请选择广告类型</option>
                               <option value="0" <c:if test="${advert.advertType==0}">selected="selected"</c:if>>首页轮播</option>
                               <option value="1" <c:if test="${advert.advertType==1}">selected="selected"</c:if>>首页推荐</option>
                               <option value="2" <c:if test="${advert.advertType==2}">selected="selected"</c:if>>分类页顶部</option>
                           </select>
                       </div>
                   </div>
                   <div class="layui-form-item">
                       <label class="layui-form-label">广告描述</label>
                       <div class="layui-input-block">
                           <input name="advertDesc" autocomplete="off" value="${advert.advertDesc}" lay-verify="required" maxlength="3000"
                                  placeholder="广告描述" class="layui-input" type="text">
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
                        <img src="${advert.advertImg}" id="imgShow">
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
                    document.getElementById("imgShow").src= res.data;
                } else {
                    app.layerAlertE(res.message);
    }
    }
    });

    });
</script>
</body>
</html>
