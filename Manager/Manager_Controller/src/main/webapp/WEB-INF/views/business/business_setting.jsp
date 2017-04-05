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
    <title>店铺信息修改</title>
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
            <%--<shiro:hasPermission name="/business/advert">--%>
            <li>店铺图片</li>
           <%-- </shiro:hasPermission>--%>
        </ul>
        <div class="layui-tab-content" style="height: auto;">
            <!-- 基本资料-->
            <div class="layui-form layui-form-pane layui-tab-item layui-show">
               <form  >
                        <input type="hidden" value="${business.id}" name="id"/>

                   <div class="layui-form-item">
                       <label class="layui-form-label">店铺编号</label>
                       <div class="layui-input-block">
                           <input name="number" autocomplete="off" lay-verify="required" maxlength="40" value="${business.number}"
                                  placeholder="店铺编号" class="layui-input" type="text">
                       </div>
                   </div>

                   <div class="layui-form-item">
                       <label class="layui-form-label">店铺名称</label>
                       <div class="layui-input-block">
                           <input name="businessName" autocomplete="off" lay-verify="required" maxlength="100" value="${business.businessName}"
                                  placeholder="店铺名称" class="layui-input" type="text">
                       </div>
                   </div>
                   <div class="layui-form-item">
                       <label class="layui-form-label">联系人</label>
                       <div class="layui-input-block">
                           <input name="linkman" autocomplete="off" lay-verify="required" maxlength="20" value="${business.linkman}"
                                  placeholder="联系人姓名" class="layui-input" type="text">
                       </div>
                   </div>
                   <div class="layui-form-item">
                       <label class="layui-form-label">手机</label>
                       <div class="layui-input-block">
                           <input name="mobilePhone" autocomplete="off" lay-verify="phone" value="${business.mobilePhone}"
                                  placeholder="手机号码" class="layui-input" type="text">
                       </div>
                   </div>
                   <div class="layui-form-item">
                       <label class="layui-form-label">座机</label>
                       <div class="layui-input-block">
                           <input name="telephone" autocomplete="off" lay-verify="requred" maxlength="20" value="${business.telephone}"
                                  placeholder="座机号码" class="layui-input" type="text">
                       </div>
                   </div>
                   <div class="layui-form-item">
                       <label class="layui-form-label">邮箱</label>
                       <div class="layui-input-block">
                           <input name="email" autocomplete="off" lay-verify="email"value="${business.email}"
                                  placeholder="电子邮箱" class="layui-input" type="text">
                       </div>
                   </div>
                   <div class="layui-form-item">
                       <label class="layui-form-label">店铺地址</label>
                       <div class="layui-input-block">
                           <input name="address" autocomplete="off" lay-verify="required" maxlength="150" value="${business.address}"
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
                                <input type="radio" name="status" value="1" title="启用"  <c:if test="${business==null||business.status==1}">checked="checked"</c:if> >
                                <input type="radio" name="status" value="0" title="停用"  <c:if test="${business.status==0}">checked="checked"</c:if>>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <button class="layui-btn" lay-submit lay-filter="div1" data-href="${saveUrl}">确认修改</button>
                        </div>
                    </form>
            </div>
            <!-- 店铺图片-->
           <%-- <shiro:hasPermission name="/business/logo">--%>
            <div class="layui-form layui-form-pane layui-tab-item">
                <div class="layui-form-item">
                    <div class="avatar-add">
                        <p>建议尺寸xxxx*xxx，支持jpg、png、gif</p>
                        <div class="upload-img">
                            <input type="file" name="logo" id="LAY-file" lay-title="上传店铺图片" lay-ext="jpg|png|gif" class="layui-upload-file" >
                        </div>
                        <img src="${business.logo}" id="logoImgShow" style="width: 150px;height: 50px;">
                        <span class="loading"></span>
                    </div>
                </div>
            </div>
    <%--        </shiro:hasPermission>--%>

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
                    document.getElementById("logoImgShow").src= res.data;
                } else {
                    app.layerAlertE(res.message);
    }
    }
    });

    });
</script>
</body>
</html>
