/**
 * Created by Xushd on 2017/2/7 0007.
 */
layui.config({
    base: '/resources/js/' //自定义layui组件的目录
});
layui.use(["form", "color", "layer","app"], function () {
    var $ = layui.jquery,
        color = layui.color,
        app = layui.app,
        form = layui.form();
    //颜色交替
    color.init(60);
    form.on('submit(btnsubmit)', function (formdata) {
        var data = formdata.field;
        if (data.username == "") {
            layer.tips('用户名为空', '#username', {
                tips: [2, '#78BA32'] //还可配置颜色
            });
        }else if (data.password==""){
            layer.tips('密码为空', '#password', {
                tips: [2, '#78BA32'] //还可配置颜色
            });
        }else{
            app.ajaxPost('/rest/index/login',data,function (e, r) {
                if (e){
                    app.layerAlertE(e);
                }else{
                    app.layerMessageI(r.message);
                    app.time(function(){
                        app.route(r.data);
                    });
                }
            });           
        }
        return false;
    })
});