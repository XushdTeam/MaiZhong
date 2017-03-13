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
    <title>用户信息修改</title>
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
            <li>头像</li>
            </shiro:hasPermission>
            <li>密码</li>
            <li>角色</li>
        </ul>
        <div class="layui-tab-content" style="height: auto;">
            <!-- 基本资料-->
            <div class="layui-form layui-form-pane layui-tab-item layui-show">
               <form  >
                        <input type="hidden" value="${user.id}" name="id"/>

                        <div class="layui-form-item">
                            <label class="layui-form-label">用户名称</label>
                            <div class="layui-input-block">
                                <input name="userName" autocomplete="off" value="${user.userName}" lay-verify="required"
                                       placeholder="用户名称，50字符内" class="layui-input" type="text">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">手机号</label>
                            <div class="layui-input-block">
                                <input name="userPhone" autocomplete="off" value="${user.userPhone}" lay-verify="phone"
                                       placeholder="用户手机号,作为登陆账号系统内部唯一" class="layui-input" type="text">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-block">
                                <input name="userEmail" autocomplete="off" value="${user.userEmail}" lay-verify="email"
                                       placeholder="用户邮箱,作为找回密码的通知方式" class="layui-input" type="text">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">是否启用</label>
                            <div class="layui-input-block">
                                <input type="radio" name="status" value="1" title="启用"  <c:if test="${user==null||user.status==1}">checked="checked"</c:if> >
                                <input type="radio" name="status" value="0" title="停用"  <c:if test="${user.status==0}">checked="checked"</c:if>>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <button class="layui-btn" lay-submit lay-filter="div1" data-href="${saveUrl}">确认修改</button>
                        </div>
                    </form>
            </div>
            <!-- 头像-->
            <shiro:hasPermission name="/user/advert">
            <div class="layui-form layui-form-pane layui-tab-item">
                <div class="layui-form-item">
                    <div class="avatar-add">
                        <p>建议尺寸168*168，支持jpg、png、gif，最大不能超过30KB</p>
                        <div class="upload-img">
                            <input type="file" name="advert" id="LAY-file" lay-title="上传头像" lay-ext="jpg|png|gif" class="layui-upload-file">
                        </div>
                        <img src="${user.userAdvert}" id="imgShow">
                        <span class="loading"></span>
                    </div>
                </div>
            </div>
            </shiro:hasPermission>
            <!-- 修改密码-->
            <div class="layui-form layui-form-pane layui-tab-item">
                <form>
                    <div class="layui-form-item">
                        <label class="layui-form-label">当前密码</label>
                        <div class="layui-input-inline">
                            <input name="pass0" autocomplete="off"  lay-verify="required"
                                   class="layui-input" type="password">
                        </div>
                        <div class="layui-form-mid layui-word-aux">默认密码为123456</div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">新密码</label>
                        <div class="layui-input-inline">
                            <input name="pass1" autocomplete="off"  lay-verify="required"
                                   class="layui-input" type="password">
                        </div>
                        <div class="layui-form-mid layui-word-aux">6到16个字符</div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">确认新密码</label>
                        <div class="layui-input-inline">
                            <input name="pass2" autocomplete="off"  lay-verify="required"
                                   class="layui-input" type="password">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <button class="layui-btn" lay-filter="div3" lay-submit data-href="${passUpdateUrl}">确认修改</button>
                    </div>
                </form>
            </div>
            <!-- 角色信息-->
            <div class="layui-form layui-form-pane layui-tab-item">
                <form>
                    <fieldset class="layui-elem-field">
                        <legend>角色</legend>
                        <div class="layui-field-box">
                            <c:forEach var="item" items="${roleList}">
                                <input type="checkbox" name="role" value="${item.id}" title="${item.roleName}"<c:if test="${item.isChecked==1}">checked</c:if> />
                            </c:forEach>
                        </div>
                    </fieldset>
                    <div class="layui-form-item">
                        <button class="layui-btn" lay-filter="div4" lay-submit data-href="${roleUpdateUrl}">确认修改</button>
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
               else{app.layerAlertS(r.message)}
            });
            return false;
        });

        //第三个div
        form.on("submit(div3)",function(filedata){
            var url = $(filedata.elem).data("href");
            if(filedata.field.pass1 != filedata.field.pass2){
                app.layerAlertE("两次新密码不一致", '提示');
                return false;
            }
            filedata.field.pass0 = app.sha(filedata.field.pass0);
            filedata.field.pass1 = app.sha(filedata.field.pass1);
            filedata.field.pass2 = app.sha(filedata.field.pass2);
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
                console.log(input);
                return false;
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

        //第四个div
        form.on("submit(div4)",function(filedata){
            var url = $(filedata.elem).data("href");
            var role = [];
            $.each( $('input[name="role"]:checked'),function(j,i){
                role.push(i.value);
            });
            filedata.field.role = role;
            app.ajaxPost(url,filedata.field,function(e,r){
                if(e){app.layerAlertE(e)}
                else{app.layerAlertS(r.message)}
            });
            return false;
        });
    });
</script>
</body>
</html>
