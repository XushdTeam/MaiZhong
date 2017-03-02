/**
 * 页面交互事件
 * Created by Xushd on 2017/1/30 0030.
 */
layui.config({
    base: '/resources/js/' //自定义layui组件的目录
});
layui.use(['layer','app'], function () {

    var $ = layui.jquery,
        app=layui.app,active={};

    //修改tab文字
    var title = $(".fhui-admin-main_hd").find("h2").text();
    if(title){
        var tab = parent.document.getElementById("admin-tab");
        $(tab).find(".layui-this").find("cite").text(title);
    }
    /**
     * 绑定页面do-action事件
     */
    $('body').on("click",".do-action", function (e) {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
        layui.stope(e);//阻止冒泡事件
    });
    //刷新
    active.doRefresh=function () {
        var url = $(this).data('href');
        if (url) {app.route(url);}
        else {location.href = location.href;}
    };
    //新增修改跳转
    active.doAddEdit=function () {
        var url = $(this).data('href');
        if (url) {app.route(url);}
        else {app.layerMessageE("没有设定跳转地址")}
    };
    //单向出发ajax
    active.doAjax=function () {
        var url = $(this).data("href");
        app.ajaxPost(url,{}, function (e, r) {
            if (e){app.layerAlertE(err);}
            else {app.layerAlertS(r.message);}
        });
    };
    //删除
    active.doDelete = function () {
        var url = $(this).data("href");
        var text = $(this).data("text");
        app.layerDel(text,function (e,r) {
            app.ajaxPost(url, {}, function (e, r) {
                if (e) {
                    app.layerAlertE(e);
                } else {
                    app.layerAlertS(r.message);
                    app.time(function () {
                        location.href = location.href;
                    });
                }
            });
        });
    };
    //返回
    active.doGoBack=function () {
        var url = $(this).data('href');
        if (url) {app.route(url)}
        else {history.go(-1);}
    };
    //子父节点展开收缩
    active.doToggle=function () {
        var parentId = $(this).data("id");
        if( $(this).find('i').hasClass("fa-minus-square-o")){
            $(this).find('i').removeClass('fa-minus-square-o').addClass('fa-plus-square-o');
        }else{
            $(this).find('i').removeClass('fa-plus-square-o').addClass('fa-minus-square-o');
        }
        $.each($('tr[data-parent="'+parentId+'"]'),function (j,i) {
            $(i).toggle();
        });
    };
    //退出登录
    active.doLoginOut=function () {
        var url = $(this).data('href');
        app.layerConfirm("确认退出系统?",['确定退出', '容我想想'],function () {
            app.ajaxPost(url,{},function (e,r) {
               if(e){app.layerAlertE(e);}
               else {app.route(r.message)}
            });
        });
    };
    //锁屏
    active.doLock=function() {
        layer.open({
            title: false,
            type: 1,
            closeBtn: 0,
            anim: 6,
            content: $('#lock-temp').html(),
            shade: [0.9, '#393D49'],
            success: function(layero, lockIndex) {
                //给显示用户名赋值
                layero.find('input[name=lockPwd]').on('focus', function() {
                        var $this = $(this);
                        if($this.val() === '输入密码解锁..') {
                            $this.val('').attr('type', 'password');
                        }
                    })
                    .on('blur', function() {
                        var $this = $(this);
                        if($this.val() === '' || $this.length === 0) {
                            $this.attr('type', 'text').val('输入密码解锁..');
                        }
                    });

                //绑定解锁按钮的点击事件
                layero.find('button#unlock').on('click', function() {
                    var $lockBox = $('div#lock-box');
                    var userName = $lockBox.find('div#lockUserName').text();
                    var pwd = $lockBox.find('input[name=lockPwd]').val();
                    if(pwd === '输入密码解锁..' || pwd.length === 0) {
                        layer.msg('请输入密码..', {
                            icon: 2,
                            time: 1000
                        });
                        return;
                    }
                    pwd = app.sha(pwd);
                    app.ajaxPost("/lock/" + userName + "/" + pwd,{},function(e,r){
                        if(e){
                            layer.msg(r.message, {icon: 2, time: 1000});
                        }else{
                            layer.close(lockIndex);
                        }
                    });
                });

            }
        });
    };
});
