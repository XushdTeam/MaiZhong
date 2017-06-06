<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/2
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>估值</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.indexedlist.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/animation50.css" />
    <style>
        html {
            font-family: "Microsoft YaHei", Arial, Helvetica, sans-serif;
            min-width: 320px;
            font-size: 50px;
            -webkit-text-size-adjust: none;
        }
        .mui-indexed-list-bar {
            top:10%;
            z-index: 19890509;
        }
        .mui-indexed-list-bar a {
            display: block;
            text-align: center;
            font-size: 14px;
            padding: 0px;
            margin: 0px;
            line-height: 16px;
            color: #aaa;
        }
        .mui-indexed-list-group, .mui-indexed-list-item {
            padding-right: 15px!important;
        }
        .mui-table-view-cell {
            padding: .8rem 1.2rem;
        }
        .mui-content>.mui-table-view:first-child {
             margin-top: 0px;
        }
    </style>
</head>
<body>
<div id="app" v-cloak style="height: 100%;background: #FFF">
    <div id="body" style="height: 100%;">
        <div class="MySellCar PTop0">
            <div class="Title">
                <a href="javascript:void(0);" class="Title bTop_City" v-tap="{methods:chooseBrand}">
                    <span>选择车型<em>{{model.model_name}}</em></span>
                    <i></i>
                </a>
                <i></i>
            </div>
            <div class="Title">
                <a href="javascript:void(0);" class="Title bTop_City" v-tap="{methods:chooseCity}">
                    <span>查询城市<em>{{city.city_name}}</em></span>
                    <i></i>
                </a>
                <i></i>
            </div>
            <div class="Title">
                <a href="javascript:void(0);" class="Title bTop_City" v-tap="{methods:chooseTime}">
                    <span>首次上牌<em>{{time.text}}</em></span>
                    <i></i>
                </a>
                <i></i>
            </div>
            <div class="Title">
					<span>表显里程<em style="right: 0px;color: #fd5a37;">
	            	<input type="text" class="text" name="mileage"
                           placeholder="请输入里程数" style="font-size: 0.857rem;color:#c3c3c3;"
                           maxlength="4" v-model="mile">万公里</em>
            		</span>
            </div>
            <a href="javascript:void(0);" class="Btn" id="tip" v-tap="{methods:submit}">立即查询</a>

        </div>
    </div>
    <div id="modal" class="mui-modal">
        <header class="mui-bar mui-bar-nav">
            <a class="mui-icon mui-icon-close mui-pull-right" href="#modal"></a>
            <h1 class="mui-title">选择城市</h1>
        </header>
        <div id='list' class="mui-indexed-list">
            <div class="mui-indexed-list-search mui-input-row " style="display: none;"></div>

            <div class="mui-indexed-list-alert"></div>
            <div class="mui-indexed-list-inner " id="inner">
                <transition name="fade">
                    <ul class="mui-table-view">
                        <template v-for="vo in cityarry">
                            <li v-if="vo.city_id==0" :data-group="vo.initial" class="mui-table-view-divider mui-indexed-list-group">{{vo.initial}}</li>
                            <li v-else class="mui-table-view-cell mui-indexed-list-item"
                                v-tap="{methods:cityChange,item:vo}">
                                <div class="mui-media-body">{{vo.city_name}}</div>
                            </li>
                        </template>
                    </ul>
                </transition>
            </div>
            <div class="mui-indexed-list-bar">
                <a v-for="i in initialarry">{{i}}</a>
            </div>
        </div>
    </div>
    <div id="modal2" class="mui-modal">
        <header class="mui-bar mui-bar-nav">
            <a class="mui-icon mui-icon-close mui-pull-right" href="#modal2"></a>
            <h1 class="mui-title">首次上牌</h1>
        </header>
        <div class="mui-content">
            <ul class="mui-table-view">
                <template v-for="(vo,index) in yearList">
                    <li class="mui-table-view-cell mui-indexed-list-item" v-tap="{methods:changeYear,value:vo.value}">
                        {{vo.text}}
                    </li>
                </template>
            </ul>
            <div id="menu-wrapper" class="menu-wrapper hidden">
                <div id="menu" class="menu">
                    <ul class="mui-table-view">
                        <li class="mui-table-view-cell" v-for="(c,i) in monthList" v-tap="{methods:changMonth,item:c}" >
                            {{c.text}}
                        </li>
                    </ul>
                </div>
            </div>
            <div id="menu-backdrop" class="menu-backdrop" v-tap="{methods:closeMenu}" ></div>
        </div>
    </div>
</div>

<script type="text/javascript" src="/resources/wap/script/api.js"></script>
<script type="text/javascript" src="/resources/wap/script/vue.js"></script>
<script type="text/javascript" src="/resources/wap/script/mui.min.js"></script>
<script type="text/javascript" src="/resources/wap/script/mui.indexedlist.js"></script>
<script type="text/javascript" src="/resources/wap/script/common.js"></script>
<script>
    var vm = new Vue({
        el: '#app', data: {
            city: {city_id: '0', city_name: '请选择车辆所在城市'},
            model: {model_name: '请选择品牌和车型'},
            time: {text: '请选择首次上牌日期'},
            mile: '',
            cityarry:[],
            initialarry:[],
            yearList:[],
            monthList:[]
        }, methods: {
            chooseCity: function () {
               $api.dom("#modal").classList.add('mui-active');
            },
            chooseBrand: function () {
                if (this.model.model_id) {
                    window.history.back(1);
                } else {
                    window.location.href = "/m/allbrand"
                }
            },
            cityChange:function(param){

                this.city = param.item
                $api.dom("#modal").classList.remove('mui-active');
            },
            chooseTime: function () {
                if(!this.model.model_id){
                    mui.toast("请选择车型")
                    return
                }
                $api.dom("#modal2").classList.add('mui-active');
            },
            changeYear:function(param){
                var year = param.value;
                toggleMenu();
                vm.monthList = getMonth(year);

            },
            changMonth:function(param){
                this.time = param.item
                $api.dom("#modal2").classList.remove('mui-active');

            },
            closeMenu:function(){
                toggleMenu();
            },
            submit: function () {
                var input = document.querySelectorAll('input');
                $api.each(input,function(i,j){
                    j.blur();
                })
                if (!vm.model.model_id) {
                    mui.toast('请选择品牌和车型');
                    return;
                }
                if (vm.city.id == '0') {
                    mui.toast('请选择车辆所在城市');
                    return;
                }
                if (vm.time.text == '请选择首次上牌日期') {
                    mui.toast('请选择首次上牌日期');
                    return;
                }
                if(!(/^\d+[.]?\d*$/.test(vm.mile))){
                    mui.toast('请输入里程数');
                    return;
                }
                var param = vm.city.prov_id + "c" + vm.city.city_id + "m" + vm.model.model_id
                        + "r" + vm.time.value + "g" + vm.mile;
                window.location.href = "/m/guzhi/"+param;
                $api.rmStorage('model');
                $api.setStorage('model',this.model);
                $api.rmStorage('city');
                $api.setStorage('city',this.city);
                $api.rmStorage('mile');
                $api.setStorage('mile',this.mile);
                $api.rmStorage('time');
                $api.setStorage('time',this.time);
            }
        }
    })

    mui.ready(function () {
        var bdata = ${model};
        if (bdata.model_id){
            vm.model = bdata
            vm.yearList = getYear(bdata.min_reg_year,bdata.max_reg_year);
        }
        loadJScript()
        var list = document.getElementById('list');
        //calc hieght
        list.style.height = document.body.offsetHeight + 'px';
        //create
        window.indexedList = new mui.IndexedList(list);


    });


    var loadJScript = function () {
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=N8kgZsufZYtKgEXbtUoTHrKlaqgAxTFY&callback=getLocation";
        document.body.appendChild(script);
    }
    var getLocation = function () {
        var myCity = new BMap.LocalCity();
        myCity.get(function (r) {
            var city = r.name.replace('市','');

            var cityarry = [],initialarry=[]
            mui.getJSON('/resources/data/allcity.json',function(d){
                mui.each(d,function(j,i){
                    var tt = i.initial.toUpperCase()
                    if(!contains(initialarry,tt)){
                        initialarry.push(tt)
                        cityarry.push({'city_id':0,'city_name':'','initial':tt})
                    }
                    cityarry.push(i);
                    if(i.city_name == city){
                        vm.city = i;
                    }
                })
                vm.cityarry = cityarry
                vm.initialarry = initialarry
            })

        });
    }
    /**
     * 获取年
     * @param {Object} min
     * @param {Object} max
     */
    var getYear = function(min,max){
        var c = min,
                d = max,
                time=[],
                e = "";
        for (y = c; y <= d; y++){
            time.push({value:y,text:y+'年'})
        }
        return time;
    }
    /**
     * 获取月
     * @param {Object} year
     */
    var getMonth = function(year){
        var b = year,
                c = 1,
                d = new Date,
                e = b >= parseInt(d.getFullYear()) ? parseInt(d.getMonth() + 1) : 12,
                month =[];

        for (m = c; m <= e; m++){
            var f = "";
            f =  m < 10 ? '0' + m + "月" :  m + "月" ;
            month.push({value:b+'-'+m,text:b+' 年 '+f});
        }
        return month;
    }

    var defaultFontSize = adapt(640, 100);
    function adapt(designWidth, rem2px) {
        var d = window.document.createElement('div');
        d.style.width = '1rem';
        d.style.display = "none";
        var head = window.document.getElementsByTagName('head')[0];
        head.appendChild(d);
        var defaultFontSize = parseFloat(window.getComputedStyle(d, null).getPropertyValue('width'));
        d.remove();
        document.documentElement.style.fontSize = window.innerWidth / designWidth * rem2px / defaultFontSize * 100 + '%';
        var st = document.createElement('style');
        var portrait = "@media screen and (min-width: " + window.innerWidth + "px) {html{font-size:" + ((window.innerWidth / (designWidth / rem2px) / defaultFontSize) * 100) + "%;}}";
        var landscape = "@media screen and (min-width: " + window.innerHeight + "px) {html{font-size:" + ((window.innerHeight / (designWidth / rem2px) / defaultFontSize) * 100) + "%;}}"
        st.innerHTML = portrait + landscape;
        head.appendChild(st);
        return defaultFontSize
    }
    function contains(arr, obj) {
        var i = arr.length;
        while (i--) {
            if (arr[i] === obj) {
                return true;
            }
        }
        return false;
    }
    var menuWrapper = document.getElementById("menu-wrapper");
    var menu = document.getElementById("menu");
    var menuWrapperClassList = menuWrapper.classList;
    var backdrop = document.getElementById("menu-backdrop");
    var busying = false;


    var toggleMenu = function () {
        if (busying) {
            return;
        }
        busying = true;
        if (menuWrapperClassList.contains('mui-active')) {
            document.body.classList.remove('menu-open');
            menuWrapper.className = 'menu-wrapper fade-out-up animated';
            setTimeout(function() {
                backdrop.style.opacity = 0;
                menuWrapper.classList.add('hidden');
                $api.dom(".mui-table-view").style.overflowY = 'auto';
            }, 300);
        } else {
            document.body.classList.add('menu-open');
            menuWrapper.className = 'menu-wrapper fade-in-down animated mui-active';
            backdrop.style.opacity = 1;
            mui('.menu-wrapper').scroll().scrollTo(0,0,100);
            $api.dom(".mui-table-view").style.overflowY = 'hidden';
        }
        setTimeout(function() {
            busying = false;
        }, 500);
    }
</script>
</body>
</html>
