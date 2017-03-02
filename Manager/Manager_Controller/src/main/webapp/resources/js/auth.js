/**
 * Created by Xushd on 2017/1/19 0019.
 */
layui.define(['form','app','element'], function(exports){
    var form = layui.form(),
        app = layui.app,
        device = layui.device();

    var obj={};
    obj.init=function () {
        //阻止IE7以下访问
        if (device.ie && device.ie < 8) {
            app.layerAlertE('最低支持ie8，您当前使用的是古老的 IE' + device.ie + '！');
        }
        //防止iframe嵌套
        window.top.location !== window.location && (window.top.location = window.location);
        //提交
        form.on('submit(btnsubmit)', function (formdata) {
            var data = formdata.field;
            data.password = app.sha(data.password);
            app.ajaxPost('/loginCheck',data,function (e, r) {
                if(e){
                    app.layerMessageE(e);
                }else {
                    app.layerMessageI(r.message);
                    app.time(function () {
                       app.route(r.data);
                    });
                }
            });
            return false;
        });
    };
    exports('auth', obj);
});
