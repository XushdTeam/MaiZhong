/**
 * Created by Xushd on 2017/1/26 0026.
 */
layui.define(["app","form","laytpl","laypage",'laydate','util'],function (exports) {
    var $= layui.jquery,
        form =layui.form(),
        laypage = layui.laypage,
        laytpl = layui.laytpl,
        laydate = layui.laydate,
        util = layui.util,
        app = layui.app;

    var _pageSize = 10;

    var private = {

        /**
         * 获取数据
         * @param url
         * @param data
         * @param callback
         */
        getList:function(url,data,callback){
            app.ajaxPost(url,data,callback);
        },
        /**
         * 装配请求参数
         * @param pageIndex
         * @param pageSize
         * @param searchFilds
         * @returns {{pageIndex: *, pageSize: *, searchFileds: *}}
         */
        intPageData:function(pageIndex,pageSize,searchFilds){
            return {pageIndex:pageIndex,pageSize:pageSize,searchFileds:searchFilds};
        },
        /**
         * 初始化时间控件
         */
        initTime:function(){
            var start = {
                max: '2099-06-16 23:59:59',
                format: 'YYYY-MM-DD hh:mm:ss', //日期格式
                istime: true,
                istoday: false,
                choose: function(datas){
                    end.min = datas; //开始日选好后，重置结束日的最小日期
                    end.start = datas //将结束日的初始值设定为开始日
                }
            };
            var end = {
                max: '2099-06-16 23:59:59',
                format: 'YYYY-MM-DD hh:mm:ss', //日期格式
                istime: true,
                istoday: false,
                choose: function(datas){
                    start.max = datas; //结束日选好后，重置开始日的最大日期
                }
            };
            $("input[lay-filter='LAY_TIME_S']").on("click",function () {
                start.elem = this;
                laydate(start);
            });
            $("input[lay-filter='LAY_TIME_E']").on("click",function () {
                end.elem = this
                laydate(end);
            });

        },
        /**
         * 初始化分页函数
         * @param pages
         * @param url
         * @param searchFileds
         * @param callback
         */
        initPage:function(pages,url,searchFileds,callback){
            laypage({
                cont: 'page',
                pages: pages,//总页数
                groups: 5, //连续显示分页数
                jump: function(obj_page, first) {
                    //得到了当前页，用于向服务端请求对应数据
                    var curr = obj_page.curr;
                    if(!first) {
                        private.getList(url,private.intPageData(curr,_pageSize,searchFileds),function (err,res) {
                            if (err){
                                app.layerAlertE(err);
                            }else{
                                var data = {rows:res.data.rows};
                                callback(data);
                            }
                        });
                    }
                }
            });
        },
        /**
         * 初始模版函数
         * @param tpl
         * @param data
         */
        initTpl:function(tpl,data){
            tpl.render(data, function(html){
                $("#tbody").html(html);
            });
        },
        /**
         * 页面绘制带分页
         * @param tpl
         * @param url
         * @param searchField
         */
        initPagingHTML:function (tpl,url,searchField) {

            private.getList(url, private.intPageData(1, _pageSize, searchField), function (err, res) {
                if (err) {
                    app.layerAlertE(err);
                } else {
                    //初始化列表
                    private.initTpl(tpl, {rows: res.data.rows});
                    //初始化分页
                    private.initPage(res.data.pages, url, searchField, function (data) {
                        private.initTpl(tpl, data);
                    });

                }
            });
        },
        /**
         * 页面绘制无分页
         * @param tpl
         * @param url
         */
        initHTML:function (tpl,url) {
            private.getList(url, {}, function (err, res) {
                if (err) {
                    app.layerAlertE(err);
                } else {
                    //初始化列表
                    private.initTpl(tpl, {rows: res.data});
                }
            });
        },
        /**
         * 初始化查询
         * @param tpl
         * @param url
         */
        initSearch:function (tpl,url) {
            form.on("submit(btnsearch)", function (formdata) {
                //查询字段不为空执行查询
                if(private.isFormNull(formdata.field)){
                    app.layerAlertI("查询条件为空！");
                }else{
                    private.initPagingHTML(tpl,url,formdata.field);
                }
                return false;
            });
        },
        /**
         * 判断查询字段是否全为空
         * @param field
         * @returns {number}
         */
        isFormNull:function(field){
            var r = 1;
            $.each(field,function (key, value) {
                if(value){r =0 ;return false;}
            });
            return r;
        },
        fixBar:function(){
            //固定Bar 回到顶部
            util.fixbar({bar1: false});
        }
    }
    var obj = {
        /**
         * 初始化 分页
         * @param pageSize
         */
        basePagingInit:function(pageSize){
            _pageSize = pageSize;
            //获取URL
            var listUrl = $("#list").data("href");
            //定义模版
            var tpl = laytpl($("#tpl").html());
            //绘制页面
            private.initPagingHTML(tpl,listUrl,{});
            //初始化查询
            private.initSearch(tpl,listUrl);

        },
        /**
         * 初始化 无分页
         */
        baseInit:function(){
            //获取URL
            var listUrl = $("#list").data("href");
            //定义模版
            var tpl = laytpl($("#tpl").html());
            //绘制页面
            private.initHTML(tpl,listUrl);
            //回到顶部
            private.fixBar();
        },
        /**
         * 日志页面独立方法
         * @param pageSize
         */
        logTimeInit:function() {
            //初始化时间控件
            private.initTime();
        },
        /**
         * 角色页面独立方法
         */
        roleListInit:function(){

        }
    }
    exports("pagelist",obj);
});


