/**
 * 首页
 * Created by Xushd on 2017/1/19 0019.
 */


layui.define(['app', 'navbar', 'tab'], function(exports){
    var $ = layui.jquery,
        app = layui.app,
        navbar = layui.navbar(),
        tab = layui.tab({elem: '.layui-tab-card'});
    var obj = {};
    obj.init = function () {
        //清楚菜单缓存
        layui.data("tb_navbar", null);
        //iframe自适应
        $(window).on('resize', function () {
            var $content = $('.admin-nav-card .layui-tab-content');
            $content.height($(this).height() - 155);
            $content.find('iframe').each(function () {
                $(this).height($content.height());
            });
        }).resize();
        //防止iframe嵌套
        window.top.location !== window.location && (window.top.location = window.location);
        var now_index = 0;
        //绑定导航数据
        $(".layui-nav-item",$("#menu")).on("click",function () {
            var $this = $(this);
            //获取设置的模块ID
            var id = $this.find('a').data('fid');
            if(id==now_index)return;now_index  = id;
            app.ajaxGet('/menu/json/'+id,{},function (e, r) {
                if(e){
                    app.layerMessageE(e);
                }else{
                    //设置navbar
                    navbar.set({
                        elem: '#admin-navbar-side', //存在navbar数据的容器ID
                        data: r.data
                    });
                    //渲染navbar
                    navbar.render();
                    navbar.on('click(side)', function(data) {
                        tab.tabAdd(data.field);
                    });
                }
            });
        });
        //左侧菜单收缩
        var foldNode = $('#sidebar');
        var sidebarNode = $('#sidebar-side');
        if (foldNode) {
            $(document).on("click", '#sidebar', function () {
                var sideWidth = sidebarNode.width();
                if (sideWidth === 200) {
                    $('#admin-body').animate({
                        left: '70px'
                    });
                    $('#admin-footer').animate({
                        left: '70px'
                    });
                    sidebarNode.addClass('sidebar-mini');
                    $('#sidebar').find('i').removeClass('fa-bars').addClass('fa-th-large');
                } else {
                    $('#admin-body').animate({
                        left: '200px'
                    });
                    $('#admin-footer').animate({
                        left: '200px'
                    });
                    sidebarNode.removeClass('sidebar-mini');
                    $('#sidebar').find('i').removeClass('fa-th-large').addClass('fa-bars');
                }
            });
        };

    };
    exports("admin",obj);
});