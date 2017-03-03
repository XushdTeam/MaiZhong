/**
 * Created by Xushd on 2017/2/7 0007.
 */
layui.define(['layer'],function (e) {
    var $ = layui.jquery;
    var app={};
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
    }
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
    e('app',app);
});