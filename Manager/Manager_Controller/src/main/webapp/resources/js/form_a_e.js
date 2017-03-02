/**
 * Created by Xushd on 2017/1/29 0029.
 */
layui.define(["app","form",'util'],function (exports) {
    var $ = layui.jquery,
        form = layui.form(),
        app = layui.app;

    var backUrl = $(".main-wrap").data("href");

    var private ={

        submit:function (data) {
            var url = $(data.elem).data("href");
            app.ajaxPost(url,data.field,function(e,r){
                if(e){app.layerAlertE(e)}
                else {
                    app.layerAlertS(r.message);
                    app.time(function(){
                       app.route(backUrl);
                    });
                }
            });
        },
        /**
         * 绑定form提交
         * @param callback
         */
        formOn:function (callback) {
            form.on('submit(btnsubmit)',callback);
        }
    }

    var obj = {
        /**
         * 通用
         */
        init:function () {
            private.formOn(function (formdata) {
                private.submit(formdata);
                return false;
            });
            app.fixBar();
        },
        /**
         * 角色
         */
        roleInit:function () {
            private.formOn(function(formdata){
                var permission = [];
                $.each( $('input[name="permission"]:checked'),function(j,i){
                    permission.push(i.value);
                });
                formdata.field.permission = permission;
                private.submit(formdata);
                return false;
            });
            app.fixBar();
        },
        /**
         * 用户注册
         */
        userInit:function(){
            private.formOn(function(formdata){
                formdata.field.password = app.sha("123456");
                private.submit(formdata);
                return false;
            });
            app.fixBar();
        },
        fixbar:function () {
            app.fixbar();
        }
    };
    exports("form_a_e",obj);
});