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
    <title>卖车</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.indexedlist.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/animation50.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js" type="text/javascript"></script>
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
        .mui-table-view a,span{
            font-size: 0.857rem;
            font: normal 0.928rem/3.214rem 'Microsoft Yahei';
            color: #3a3836;
        }
        .MySellCar {
            padding-bottom: 0.2rem ;

        }
        .MySellCar .Title {
            border-bottom: 1px solid #e4e3e6!important;
            height: 3rem;
            line-height: 3rem;
            font: normal;
        }
        .other{

            background: white;
        }
        .mui-table-view li{
            /*height: 3.214rem;
            line-height: 3.214rem;*/
            padding: 5px 15px;
        }
        .mui-table-view-cell.mui-collapse.mui-active {
            margin-top: 0px;
        }
        .mui-table-view-cell.mui-active {
            background-color: #FFF;
        }
        .mui-navigate-right.mui-active{
            background-color: #FFF!important;
        }
        .month-list {
            padding: 10px 0;

        }

        .month-list > li {
            float: left;
            background-color: #e2e2e2;
            width: 20%;
            text-align: center;
            padding:  0px;
            margin: 5px 2.5%;
            border-radius: 3px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            font-size: 0.857rem;
            font: normal 0.928rem/2.214rem 'Microsoft Yahei';
            color: #3a3836;
        }

        .myactive{
            background-color:#FD5A37!important;
            color: #FFF!important;
        }
        .emactive{
            color: #fd5a37!important;
        }
        .mui-table-view-cell.mui-collapse .mui-collapse-content {
            padding: 0px;
            margin: -10px -15px;
        }
        .MySellCar {
            padding-bottom: 0rem;
        }
        .spanright{
            position: absolute;
            top: 0px;
            right: 10px;
            color: #fd5a37;
        }
        .mui-table-view-cell:after {
            left: 0px;
        }
        .mui-table-view-cell>a:not(.mui-btn) {
            margin: -11px -24px;
        }
        .mui-content{
            background: #FFF;
            margin-bottom: 20px;
        }
        .mui-table-view-cell a:active{
            background: #FFF!important;
        }
        .mui-indexed-list-item{
            padding: .8rem 1.2rem!important;
        }
        #modal2 .mui-table-view-cell {
            padding: .8rem 1.2rem!important;
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
            <transition name="fade">
                <div class="other">
                    <ul class="mui-table-view" >
                        <li class="mui-table-view-cell  mui-active">
                            <a>颜色</a>
                            <span class="spanright">{{colortext}}</span>
                            <div class="mui-collapse-content">
                                <ul class="month-list clearfix">
                                    <li  v-tap="{methods:chooseColor,id:8,text:'黑色'}" :class="{'myactive':color.id==8}">黑色</li>
                                    <li  v-tap="{methods:chooseColor,id:2,text:'白色'}" :class="{'myactive':color.id==2}">白色</li>
                                    <li  v-tap="{methods:chooseColor,id:1,text:'橙色'}" :class="{'myactive':color.id==1}">橙色</li>
                                    <li  v-tap="{methods:chooseColor,id:4,text:'红色'}" :class="{'myactive':color.id==4}">红色</li>
                                    <li  v-tap="{methods:chooseColor,id:5,text:'棕色'}" :class="{'myactive':color.id==5}">棕色</li>
                                    <li  v-tap="{methods:chooseColor,id:6,text:'蓝色'}" :class="{'myactive':color.id==6}">蓝色</li>
                                    <li  v-tap="{methods:chooseColor,id:7,text:'黄色'}" :class="{'myactive':color.id==7}">黄色</li>
                                    <li  v-tap="{methods:chooseColor,id:9,text:'银色'}" :class="{'myactive':color.id==9}">银色</li>
                                    <li  v-tap="{methods:chooseColor,id:10,text:'绿色'}" :class="{'myactive':color.id==10}">绿色</li>
                                    <li  v-tap="{methods:chooseColor,id:3,text:'其他'}" :class="{'myactive':color.id==3}">其他</li>
                                </ul>
                            </div>
                        </li>

                        <li class="mui-table-view-cell  mui-active">
                            <a >使用性质</a>
                            <span class="spanright">{{xztext}}</span>
                            <div class="mui-collapse-content">
                                <ul class="month-list clearfix">
                                    <li  v-tap="{methods:chooseXz,id:1,text:'非营运'}" :class="{'myactive':xz.id==1}" style="width: 45%;">非营运</li>
                                    <li  v-tap="{methods:chooseXz,id:2,text:'租赁'}" :class="{'myactive':xz.id==2}" style="width: 45%;">租赁</li>
                                </ul>
                            </div>
                        </li>

                        <li class="mui-table-view-cell  mui-active">
                            <a >现使用方</a>
                            <span class="spanright">{{methodtext}}</span>
                            <div class="mui-collapse-content">
                                <ul class="month-list clearfix">
                                    <li v-tap="{methods:chooseMethod,id:2,text:'个人'}" :class="{'myactive':method.id==2}" style="width: 45%;">个人</li>
                                    <li v-tap="{methods:chooseMethod,id:1,text:'公司'}" :class="{'myactive':method.id==1}" style="width: 45%;">公司</li>
                                </ul>
                            </div>
                        </li>

                        <li class="mui-table-view-cell  mui-active">
                            <a >交强险有效期</a>
                            <span class="spanright">{{jqxtext}}</span>
                            <div class="mui-collapse-content">
                                <ul class="month-list clearfix">
                                    <li  v-tap="{methods:chooseJqx,id:1,text:'2个月以内'}" :class="{'myactive':jqx.id==1}" style="width: 45%;">2个月以内</li>
                                    <li  v-tap="{methods:chooseJqx,id:2,text:'2个月以上'}" :class="{'myactive':jqx.id==2}" style="width: 45%;">2个月以上</li>
                                </ul>
                            </div>
                        </li>

                        <li class="mui-table-view-cell  mui-active">
                            <a >年检有效期</a>
                            <span class="spanright">{{njtext}}</span>
                            <div class="mui-collapse-content">
                                <ul class="month-list clearfix">
                                    <li  v-tap="{methods:chooseNj,id:1,text:'2个月以内'}" :class="{'myactive':nj.id==1}" style="width: 45%;">2个月以内</li>
                                    <li  v-tap="{methods:chooseNj,id:2,text:'2个月以上'}" :class="{'myactive':nj.id==2}" style="width: 45%;">2个月以上</li>
                                </ul>
                            </div>
                        </li>

                        <li class="mui-table-view-cell  mui-active">
                            <a >过户次数</a>
                            <span class="spanright">{{ghtext}}</span>
                            <div class="mui-collapse-content">
                                <ul class="month-list clearfix">
                                    <li v-tap="{methods:chooseGh,id:4,text:'0次'}" :class="{'myactive':gh.id==4}" >0次</li>
                                    <li v-tap="{methods:chooseGh,id:1,text:'1次'}" :class="{'myactive':gh.id==1}" >1次</li>
                                    <li v-tap="{methods:chooseGh,id:2,text:'2次'}" :class="{'myactive':gh.id==2}" >2次</li>
                                    <li v-tap="{methods:chooseGh,id:3,text:'3次以上'}" :class="{'myactive':gh.id==3}" >3次以上</li>
                                </ul>
                            </div>
                        </li>

                        <li class="mui-table-view-cell  mui-active">
                            <a >最后一次过户时间</a>
                            <span class="spanright">{{ghtimetext}}</span>
                            <div class="mui-collapse-content">
                                <ul class="month-list clearfix">
                                    <li v-tap="{ methods:chooseGhtime ,id:1, text:'无过户'}" :class="{'myactive':ghtime.id==1}" style="width: 28%;">无过户</li>
                                    <li v-tap="{ methods:chooseGhtime ,id:2, text:'6个月以内'}" :class="{'myactive':ghtime.id==2}" style="width: 28%;" >6个月以内</li>
                                    <li v-tap="{ methods:chooseGhtime ,id:3, text:'6个月以上'}" :class="{'myactive':ghtime.id==3}" style="width: 29%;">6个月以上</li>
                                </ul>
                            </div>
                        </li>

                        <li class="mui-table-view-cell  mui-active">
                            <a  href="#">车况</a>
                            <span class="spanright">{{cktext}}</span>
                            <div class="mui-collapse-content">
                                <ul class="month-list clearfix">
                                    <li v-tap="{ methods:chooseCk ,id:1, text:'A(优秀)'}" :class="{'myactive':ck.id==1}" style="width: 95%;">A(优秀)车况好没有任何故障</li>
                                    <li v-tap="{ methods:chooseCk ,id:2, text:'B(良好)'}" :class="{'myactive':ck.id==2}" style="width: 95%;">B(良好)有过少量剐蹭或钣金</li>
                                    <li v-tap="{ methods:chooseCk ,id:3, text:'C(一般)'}" :class="{'myactive':ck.id==3}" style="width: 95%;">C(一般)有过前后轻碰事故</li>
                                    <li v-tap="{ methods:chooseCk ,id:4, text:'D(较差)'}" :class="{'myactive':ck.id==4}" style="width: 95%;">D(较差)有伤及主体框架的碰撞或较大事故</li>

                                </ul>
                            </div>
                        </li>

                    </ul>
                </div>
            </transition>


            <a href="javascript:void(0);" class="Btn" id="tip" v-tap="{methods:submit}">精准估值</a>

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
            monthList:[],
            color:{},
            xz:{},
            method:{},
            jqx:{},
            nj:{},
            gh:{},
            ghtime:{},
            ck:{}
        }, methods: {
            chooseCity: function () {
                $api.dom("#modal").classList.add('mui-active');
            },
            chooseBrand: function () {
                if (this.model.model_id) {
                    window.history.back(1);
                } else {
                    $api.rmStorage('salemark')
                    $api.setStorage('salemark',1)
                    window.location.href = "/m/allbrand"
                }
            },
            cityChange:function(param){
                this.city = param.item
                $api.dom("#modal").classList.remove('mui-active');
            },
            chooseTime: function () {
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
            chooseColor:function(param){
                var input = document.querySelectorAll('input');
                $api.each(input,function(i,j){
                    j.blur();
                })
                this.color = {id:param.id,text:param.text}
//				$api.dom('.mui-table-view .mui-active').classList.remove("mui-active")
            },
            chooseXz:function(param){
                var input = document.querySelectorAll('input');
                $api.each(input,function(i,j){
                    j.blur();
                })
                this.xz = {id:param.id,text:param.text}
//				$api.dom('.mui-table-view .mui-active').classList.remove("mui-active")
            },
            chooseMethod:function(param){
                var input = document.querySelectorAll('input');
                $api.each(input,function(i,j){
                    j.blur();
                })
                this.method ={id:param.id,text:param.text}
//				$api.dom('.mui-table-view .mui-active').classList.remove("mui-active")
            },
            chooseJqx:function(param){
                var input = document.querySelectorAll('input');
                $api.each(input,function(i,j){
                    j.blur();
                })
                this.jqx ={id:param.id,text:param.text}
//				$api.dom('.mui-table-view .mui-active').classList.remove("mui-active")
            },
            chooseNj:function(param){
                var input = document.querySelectorAll('input');
                $api.each(input,function(i,j){
                    j.blur();
                })
                this.nj ={id:param.id,text:param.text}
//				$api.dom('.mui-table-view .mui-active').classList.remove("mui-active")
            },
            chooseGh:function(param){
                var input = document.querySelectorAll('input');
                $api.each(input,function(i,j){
                    j.blur();
                })
                this.gh ={id:param.id,text:param.text}
//				$api.dom('.mui-table-view .mui-active').classList.remove("mui-active")
            },
            chooseGhtime:function(param){
                var input = document.querySelectorAll('input');
                $api.each(input,function(i,j){
                    j.blur();
                })
                this.ghtime ={id:param.id,text:param.text}
//				$api.dom('.mui-table-view .mui-active').classList.remove("mui-active")
            },
            chooseCk:function(param){
                var input = document.querySelectorAll('input');
                $api.each(input,function(i,j){
                    j.blur();
                })
                this.ck ={id:param.id,text:param.text}
//				$api.dom('.mui-table-view .mui-active').classList.remove("mui-active")
            },
            submit: function () {
                if(!$.cookie('phone')){
                    window.location.href = "/m/dl";
                    return
                }

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
                if(!vm.color.id){
                    mui.toast('请选择颜色');
                    return;
                }
                if(!vm.xz.id){
                    mui.toast('请选择使用性质');
                    return;
                }
                if(!vm.method.id){
                    mui.toast('请选择现使用方');
                    return;
                }
                if(!vm.jqx.id){
                    mui.toast('请选择交强险有效期');
                    return;
                }
                if(!vm.nj.id){
                    mui.toast('请选择年检有效期');
                    return;
                }
                if(!vm.gh.id){
                    mui.toast('请选择过户次数');
                    return;
                }
                if(!vm.ghtime.id){
                    mui.toast('请选择最后一次过户时间');
                    return;
                }
                if(!vm.ck.id){
                    mui.toast('请选择车况');
                    return;
                }

                var param1 = vm.city.prov_id+
                                "c" + vm.city.city_id +
                                "m" + vm.model.model_id +
                                "r" + vm.time.value +
                                "g" + vm.mile,
                        param2 ="o"+vm.color.id +
                                "j" + vm.jqx.id +
                                "h" + vm.gh.id +
                                "t" + vm.ghtime.id +
                                "x" + vm.xz.id +
                                "n" + vm.nj.id +
                                "d" + vm.method.id +
                                "k" + vm.ck.id;


                window.location.href = "/m/saleguzhid/"+param1+param2;


            }
        },
        computed: {
            colortext:function(){
                if(this.color.id){
                    return this.color.text;
                }
            },
            xztext:function(){
                if(this.xz.id){
                    return this.xz.text;
                }
            },
            methodtext:function(){
                if(this.method.id){
                    return this.method.text;
                }
            },
            jqxtext:function(){
                if(this.jqx.id){
                    return this.jqx.text;
                }
            },
            njtext:function(){
                if(this.nj.id){
                    return this.nj.text;
                }
            },
            ghtext:function(){
                if(this.gh.id){
                    return this.gh.text;
                }
            },
            ghtimetext:function(){
                if(this.ghtime.id){
                    return this.ghtime.text;
                }
            },
            cktext:function(){
                if(this.ck.id){
                    return this.ck.text;
                }
            }
        }
    })

    mui.ready(function () {
        var model = $api.getStorage('model');
        if(model){
            vm.model = model
            vm.yearList = getYear(model.min_reg_year,model.max_reg_year);
            if($api.getStorage('mile'))vm.mile = $api.getStorage('mile');

            if($api.getStorage('time'))vm.time = $api.getStorage('time');
        }
        var city = localStorage.getItem('city');

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
