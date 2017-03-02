/**
 * Created by Xushd on 2017/2/7 0007.
 */
layui.define(['layer','util','sha256'],function (e) {
    var $ = layui.jquery,util = layui.util,sha =layui.sha256,
    layer = parent.layer||layui.layer;
    var app={};
    /*提示*/
    app.showLoading=function(text){
        layer.msg(text||"Loading...", {icon: 16,shade: 0.01, time: 0});
    };
    app.closeLoading=function(){
        layer.closeAll();
    };
    app.layerAlertS=function (text) {
        layer.alert(text, { title: "提示", icon: 1, time: 5000, resize: false, zIndex: layer.zIndex, anim: Math.ceil(Math.random() * 6) });
    };
    app.layerAlertE=function (text) {
        layer.alert(text, { title: "错误", icon: 2, time: 5000, resize: false, zIndex: layer.zIndex, anim: Math.ceil(Math.random() * 6) });
    };
    app.layerMessageI=function (text) {
        layer.msg(text, { time: 5000, resize: false, zIndex: layer.zIndex,  });
    };
    app.layerMessageE=function(text){
        layer.msg(text, {icon: 5,anim:6});
    };
    app.route=function (url) {
        window.location.href = url;
    };
    app.time=function(c,t){
        setTimeout(c,t||1000);
    };
    /*confirm*/
    /**
     * 删除询问
     * @param t{TEXT}
     * @param u{URL}
     * @param c{CALLBACK}
     */
    app.layerDel=function (t,c) {
        layer.confirm(t, {
            title: "询问",
            resize: false,
            btn: ['确定删除', '容我想想'],
            btnAlign: 'c',
            icon: 3
        }, function () {
            c();
        }, function () {
            app.layerMessageI("好吧！");
        });
    };
    /**
     * confirm
     * @param t{TEXT}
     * @param b{BTN[]}
     * @param c{CALLBACK}
     */
    app.layerConfirm=function (t,b,c) {
        layer.confirm(t, {
            title: "询问",
            resize: false,
            btn: b,
            btnAlign: 'c',
            icon: 3
        }, function () {
            c();
        }, function () {
            app.layerMessageI("好吧！");
        });
    };
    /*fixbar*/
    app.fixBar=function () {
        util.fixbar({
            bar1: "<i class='fa fa-arrow-left'></i>",
            click: function (type) {
                if (type === 'bar1') {
                    var backUrl = $(".main-wrap").data("href");
                    if (backUrl == undefined || backUrl == "") {
                        history.back();
                    } else {
                        app.route(backUrl);
                    }
                }
            }
        });
    };

    /*ajax*/
    /**
     * ajaxPOST
     * @param u{URL}
     * @param d{DATA}
     * @param c{CALLBACK}
     */
    app.ajaxPost = function (u,d,c) {
        app.showLoading();
        $.ajax({
            url: u,
            type: "POST",
            dataType: "JSON",
            data: d,
            success: function (data, startic) {
                app.closeLoading();
                if (data.status == 200) {
                    c(null,data);
                } else {
                    c(data.message);
                }
            },
            error: function (e) {
                app.closeLoading();
                c("Net Lost");
            }
        });

    };
    /**
     * ajaxGET
     * @param u{URL}
     * @param d{DATA}
     * @param c{CALLBACK}
     */
    app.ajaxGet =function (u,d,c) {
        app.showLoading();
        $.ajax({
            url: u,
            type: "GET",
            dataType: "JSON",
            data: d,
            success: function (data, startic) {
                app.closeLoading();
                if (data.status == 200) {
                    c(null,data);
                } else {
                    c(data.message);
                }
            },
            error: function (e) {
                app.closeLoading();
                c("Net Lost");
            }
        });
    };
    //sha256加密
    app.sha=function(p){
        return sha.sha256_digest(p);
    };
    app.throwError=function(t){
        console.log(t);
    };
    e('app',app);
});