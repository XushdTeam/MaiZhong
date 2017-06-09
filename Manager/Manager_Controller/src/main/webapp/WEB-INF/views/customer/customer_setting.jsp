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
    <title>客户信息修改</title>
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
        </ul>
        <div class="layui-tab-content" style="height: auto;">
            <!-- 基本资料-->
            <div class="layui-form layui-form-pane layui-tab-item layui-show">
               <form  >
                        <input type="hidden" value="${user.userId}" name="userId"/>


                        <div class="layui-form-item">
                            <label class="layui-form-label">手机号</label>
                            <div class="layui-input-block">
                                <input name="phone" autocomplete="off" value="${user.phone}" lay-verify="phone"  disabled="disabled"
                                       class="layui-input" type="text">
                            </div>
                        </div>

                   <div class="layui-form-item">
                       <label class="layui-form-label">用户姓名</label>
                       <div class="layui-input-block">
                           <input name="userName" autocomplete="off" value="${user.userName}"
                                  class="layui-input" type="text">
                       </div>
                   </div>
                   <div class="layui-form-item">
                       <label class="layui-form-label">职位</label>
                       <div class="layui-input-block">
                           <input name="userJob" autocomplete="off" value="${user.userJob}"
                                  class="layui-input" type="text">
                       </div>
                   </div>


                   <div class="layui-form-item">
                       <label class="layui-form-label">店铺名称</label>
                       <div class="layui-input-block">
                           <input name="shopName" autocomplete="off" value="${user.shopName}"
                                  class="layui-input" type="text">
                       </div>
                   </div>

                   <div class="layui-form-item">
                       <label class="layui-form-label">店铺地址</label>
                       <div class="layui-input-block">
                           <input name="shopAddress" autocomplete="off" value="${user.shopAddress}"
                                  class="layui-input" type="text">
                       </div>
                   </div>
                   <div class="layui-form-item">
                       <label class="layui-form-label">银行账户</label>
                       <div class="layui-input-block">
                           <input name="bankAccount" autocomplete="off" value="${user.bankAccount}"
                                  class="layui-input" type="text">
                       </div>
                   </div>

                   <div class="layui-form-item">
                            <label class="layui-form-label">设为合作用户</label>
                            <div class="layui-input-block">
                                <input type="radio" name="userRole" value="0" title="普通用户"  <c:if test="${user==null||user.userRole==0||user.userRole==null}">checked="checked"</c:if> >
                                <input type="radio" name="userRole" value="2" title="合作用户"  <c:if test="${user.userRole==2}">checked="checked"</c:if>>
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
               else{app.layerAlertS(r.message);
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
