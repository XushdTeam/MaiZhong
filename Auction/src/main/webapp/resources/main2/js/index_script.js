var inNum = 0;
var bidNum = 0;
var addAuctionNum = 0;

jQuery(document).ready(function($) {


	// networkBox
	$('#networkBox').on('click',function(){
		console.log('networkBox');
		window.location.href="/network.htm";
	});


	// openMsgBox('.msgBox_submit');

//	$('#car_carousel').on('click','a._tran',function(event) {
//    openMsgBox('.msgBox_being');
//    event.preventDefault();
//  });
// 	$('.menu').find('a').removeClass('checked');
//     $('.shouye').addClass('checked');

	// 页面滚动
	// header
	$('#index_changeCity').on('click',function(){
		$(this).find('span').removeClass('_error');
		// 加载城市
    	getCityFloor('hot','.banner_form');
    	if($('.index_city_floor').hasClass('none')){
    		$('.index_city_floor').removeClass('none');
    	}else{
    		$('.index_city_floor').addClass('none');
    	}
	});

	$('#sellphone').on('focus', function() {
	    if ($(this).val() == '请输入您的手机号码') {
	        $(this).val('');
	    }
	    $(this).removeClass('_error');
	});

	// 表单验证 
    $('#SellSubmit').on('click',function(){
      var cityID=$('#cityID').val();
      var cityName=$('#cityName').val();
      var sellphone=$('#sellphone').val();
      var $phonetest = /^0?(13|14|15|18|17)[0-9]{9}$/;
      var hasError  = false;

      if(!cityID||!cityName){
        $('#index_changeCity').find('span').addClass('_error');
        hasError  = true;
      }
      if(!sellphone){
        $('#sellphone').val('请输入您的手机号码').addClass('_error');
        hasError  = true;
      }else if(!$phonetest.test(sellphone)){
        $('#sellphone').addClass('_error');
        hasError  = true;
      }else if(sellphone=='请输入您的手机号码'){
      	$('#sellphone').addClass('_error');
        hasError  = true;
      }
      if(hasError){
        return false;
      }

      // 如果没有实际渠道来源，默认车置宝网站24120
      if(typeof(channel) == "undefined"  || channel==null || channel.trim()==''){
          channel = '24120';
      }
      source = 20112;
      var formObj = new Object();
      formObj.source = channel;
      formObj.source0=source;
      formObj.uid=uid;
      formObj.sellphone=sellphone;
      
      formObj.region=cityID;
      formObj.regionName=cityName;
      formObj.mobile=sellphone;
      formObj.submitType = $('#submitType_').val();
      formObj.customerName="未知";
      formObj.bak='';
      $.ajax({
          type : 'POST',
          data : formObj,
          dataType : 'json',
          async : true,
          url : './optAssess/add.htm',
          timeout : 10000,
          error : function(){
          },
          success : function(data) {
              if (data.status) {
              } else {
              }
          }
      	});
        canSubmit = true;
        setDefaultCity( $(".CityText"));
        setDefault($("#sellphone"));
        // 提示框
        $('.submit_title').html('您的拍卖顾问会12小时内与您联系，请留意接听1010-8866的来电');
        openMsgBox('.msgBox_submit');
		$('#cityID').val('');
		$('#cityName').val('');
    });


    // 点击城市名称
    $('.index_city_floor').on('click','a',function(){
		$('.banner_form').find('.CityText').html($(this).text()).removeClass('_placeholder');
		$('#cityID').val($(this).attr('data-id'));
		$('#cityName').val($(this).text());
		$('.index_city_floor').addClass('none');
		return false;
	});


// 	// 竞拍历史
// 	$.ajax({
// 		async : true,
// 		type : 'POST',
// 		dataType : 'json',
// 		url : 'czbm_PCIndex/getLoadHistroy.htm',
// 		data : {},
// 		success : function(data){
// 			// 拍卖历史
// 			var historyList = data.data.list;
// 			var record = "";
// 			for(var i = 0; i < historyList.length; i++){
//
//                 record += '<div class="history_item">'
//                     + '<div class="_item">'
//                     + '<div class="_top">'
//                     + '<a href="../carDetail/' + historyList[i].HREFPATH + '.htm " target="_blank" onclick="turnDetail(' + historyList[i].BIDCOUNT + ', ' + historyList[i].PRICE + ',\'' +historyList[i].HREFPATH + '\',\'' + historyList[i].JPDATE + '\',\''+historyList[i].REGION + '\',\''+historyList[i].BUYERREGION+'\')">'
//                     + '<img class="lazyOwl" src="' + historyList[i].DEFTPIC + '">'
// //                    + '<img class="__load" src="' + historyList[i].DEFTPIC + '" style="display:none;">'
//                     + '<div class="_price clearfix">'
//                     + '<span>卖出价</span>'
//                     + '<strong>' + (historyList[i].PRICE).toFixed(2) + '万</strong>'
//                     + '</div>'
//                     + '<div class="_count">' + historyList[i].BIDCOUNT + '人出价</div>'
//                     + '</a>'
//                     + '</div>'
//                     + '<div class="_bottom">'
//                     + '<h3><a href="../carDetail/' + historyList[i].HREFPATH + '.htm " target="_blank" onclick="turnDetail(' + historyList[i].BIDCOUNT + ', ' + historyList[i].PRICE + ',\'' +historyList[i].HREFPATH + '\',\'' + historyList[i].JPDATE + '\',\''+historyList[i].REGION + '\',\''+historyList[i].BUYERREGION+'\')">' + historyList[i].CARTYPE + '</a></h3>'
//                     + '<div class="_data">' + historyList[i].DJYEAR + '年 | ' + historyList[i].MILEAGE + '万公里 | ' + historyList[i].REGION.replace('市','') + '车主 | ' + historyList[i].BUYERREGION.replace('市','') + '买家</div>'
//                     + '</div>'
//                     + '</div>'
//                     + '</div>'
// 			}
// 			$("#history_carousel").html(record);
//
// 			$('#history_carousel').owlCarousel({
// 				items: 6,
// //				lazyLoad: true,
// 				itemsDesktop: [2100,6],
// 				itemsDesktopSmall: [1800,5],
// 				itemsTablet: [1500,4],
// 				itemsTabletSmall: [1200,3],
// 				itemsMobile:false,
// 				autoPlay:5000,			// 自动轮播时间（毫秒）
// 				rewindNav:true,
// 				stopOnHover:true,
// 				paginationSpeed:300,
// 				scrollPerPage:true,
// 				pagination:true,
// 				afterInit:function(e){
// 					var itemWidth	=	$('#history_carousel').find('._item').width();
// 					$('#history_carousel').find('._item').find('._top a').height( (itemWidth/16)*9 );
// 					$('#history_carousel').find('._item').find('._top a img').height( (itemWidth/16)*9 );
// 				},
// 				afterUpdate:function(e){
// 					var itemWidth	=	$('#history_carousel').find('._item').width();
// 					$('#history_carousel').find('._item').find('._top a').height( (itemWidth/16)*9 );
// 					$('#history_carousel').find('._item').find('._top a img').height( (itemWidth/16)*9 );
// 				}
// 			});
//
// 			$('#history_carousel').find('.owl-controls').css('marginLeft', '-'+($('#history_carousel').find('.owl-controls').width()/2)+'px');
//
// 			$('#history_carousel').find('.__load').each(function(){
// 				$(this).load(function (e) {
// 	                $(this).parents('._top').find('.lazyOwl').attr('src',$(this).attr('src'));
// 	            });
// 				$(this).error(function(){
// 				});
// 			});
// 		}
// 	});
    
// 	// 今日竞拍
// 	$.ajax({
// 			async : true,
// 			type : 'POST',
// 			dataType : 'json',
// 			url : './czbm_PCIndex/getLoadInfo.htm',
// 			data : {},
// 			success : function(data){
// 				inNum = data.inNum;// 正在拍卖车辆
// 				if(data.inNum - 200 < 0) {
// 					$("#Auction").hide();
// 				}
// 				bidNum = data.buyerNum;// 实名买家
// 				$('#auction_count_1').html(inNum);
// 				$('#auction_count_2').html(bidNum);
// 				addAuctionNum = data.auctionCarNum; // 累计拍卖车辆
// 				$('#history_count').html(addAuctionNum);
//
// 				var nowList = data.todayCars;
// 				var h = "";
// 				for (var i = 0; i < nowList.length; i++) {
//
// 					// nowList.length
//
//
// 					  if(nowList[i].status == 1 ){
// 							h+='<div class="__car_loop clearfix none">';
// 								h+='<div class="__pic">';
// 								    h+='<a href="czbm_PCIndex/auction.htm"><img src="'+nowList[i].modelImg+'"></a>';
// 								h+='</div>';
// 								h+='<div class="__right">';
// 									h+='<div class="_auctBox">';
// 										h+='<a href="czbm_PCIndex/auction.htm">';
// 											h+='<div class="_top">';
// 												var carBrand_1 = (nowList[i].carBrand).slice(0,2);
// 												var carModel_2 = (nowList[i].carModel).slice(0,2);
// 												var carBrand_3 = (carBrand_1 == carModel_2) ? '' : nowList[i].carBrand;
// 												var carModel_1 = (nowList[i].carModel).slice(0,2);
// 												var carType_1 = (nowList[i].carType).slice(0,2);
// 												var carModel_3 = (carModel_1 == carType_1) ? '' : nowList[i].carModel;
// 												var carType_2;
// 												if (!(nowList[i].carType == null || nowList[i].carType == '' || nowList[i].carType == undefined || nowList[i].carType=='null')) {
// 													carType_2 = nowList[i].carType;
// 												}else{
// 													carType_2 = '';
// 												}
// 												h+='<h3>'+carBrand_3+' '+carModel_3+' '+carType_2+'</h3>'
// 												h+='<div class="_data">'+nowList[i].carRegist+'年 | '+(nowList[i].carMileage/10000).toFixed(2)+'万公里 | '+nowList[i].carCity.replace('市','')+'</div>'
// 											h+='</div>';
// 											h+='<div class="_bottom">';
// 												h+='<div class="_tit red">拍卖结束</div>';
// 												h+='<div class="_number clearfix">';
// 													h+='<span>共</span>';
// 												var a6 = nowList[i].times; //出价次数
// 												if(a6.length){
// 												  	for (var i = 0; i < a6.length; i++) {
// 												  		h+='<strong>'+a6[i]+'</strong>';
// 												  	}
// 												}else{
// 													h+='<strong>'+a6+'</strong>';
// 												}
// 													h+='<span>人出价</span>';
// 												h+='</div>';
// 												h+='<div class="_desc clearfix">';
// 													h+='<div class="__buyList" id="buyList_'+i+'">';
// 														h+='<ul>';
// 															var bidinfoNow = nowList[i].bidinfo;
// 															for (var j = 0; j < bidinfoNow.length; j++) {
// 																	h += '<li>';
// 																	h += bidinfoNow[j].bidTime+' ';
// 																	var buyerInfoNow = bidinfoNow[j].buyerInfo;
// 																	h += buyerInfoNow.buyerRegionName.replace('市','')+'买家'+buyerInfoNow.phone+'出价';
// 																	h += '</li>';
// 															}
// 														h+='</ul>';
// 													h+='</div>';
// 												h+='</div>';
// 											h+='</div>';
// 										h+='</a>';
// 									h+='</div>';
// 								h+='</div>';
// 							h+='</div>';
// 							$("#car_carousel").html(h);
//
// 					  }else if (nowList[i].status == 0 && nowList[i].overTime > new Date().getTime()){
//
// 							h+='<div class="__car_loop clearfix none">';
// 								h+='<div class="__pic">';
// 								    h+='<a href="czbm_PCIndex/auction.htm"><img src="'+nowList[i].modelImg+'"></a>';
// 								h+='</div>';
// 								h+='<div class="__right">';
// 									h+='<div class="_auctBox">';
// 										h+='<a href="czbm_PCIndex/auction.htm">';
// 											h+='<div class="_top">';
// 											var carBrand_1 = (nowList[i].carBrand).slice(0,2);
// 											var carModel_2 = (nowList[i].carModel).slice(0,2);
// 											var carBrand_3 = (carBrand_1 == carModel_2) ? '' : nowList[i].carBrand;
// 											var carModel_1 = (nowList[i].carModel).slice(0,2);
// 											var carType_1 = (nowList[i].carType).slice(0,2);
// 											var carModel_3 = (carModel_1 == carType_1) ? '' : nowList[i].carModel;
// 											var carType_2;
// 											if (!(nowList[i].carType == null || nowList[i].carType == '' || nowList[i].carType == undefined || nowList[i].carType=='null')) {
// 												carType_2 = nowList[i].carType;
// 											}else{
// 												carType_2 = '';
// 											}
// //											h+='<h3>'+(((nowList[i].carBrand).slice(0,2) == (nowList[i].carModel).slice(0,2)) ? '' : nowList[i].carBrand)+' '+nowList[i].carModel+' '+nowList[i].carType+'</h3>'
// 											h+='<h3>'+carBrand_3+' '+carModel_3+' '+carType_2+'</h3>';
// 												h+='<div class="_data">'+nowList[i].carRegist+'年 | '+(nowList[i].carMileage/10000).toFixed(2)+'万公里 | '+nowList[i].carCity.replace('市','')+'</div>';
// 											h+='</div>';
// 											h+='<div class="_bottom">';
// 												h+='<div class="_tit blue" id="JSid_'+i+'">距拍卖结束</div>';
// 												h+='<div class="_number clearfix" id="divTime_'+i+'">';
// 														h+='<strong id="hourF'+i+'">00</strong>';
// 														h+='<span class="__t">:</span>';
// 														h+='<strong id="minS'+i+'">00</strong>';
// 												h+='</div>';
// 												h+='<div class="_desc clearfix">';
// 													h+='<div class="__buyList" id="buyList_'+i+'">';
// 														h+='<ul>';
// 															var bidinfoNow = nowList[i].bidinfo;
// 															for (var j = 0; j < bidinfoNow.length; j++) {
// 																h+='<li>';
// 																h+=bidinfoNow[j].bidTime+' ';
// 																var buyerInfoNow = bidinfoNow[j].buyerInfo;
// 																h += buyerInfoNow.buyerRegionName.replace('市','')+'买家'+buyerInfoNow.phone+'出价';
// 																h+='</li>';
// 															}
// 														h+='</ul>';
// 													h+='</div>';
// 												h+='</div>';
// 											h+='</div>';
// 										h+='</a>';
// 									h+='</div>';
// 								h+='</div>';
// 							h+='</div>';
// 							$("#car_carousel").html(h);
// 							var overTime = nowList[i].overTime;
// 							overTimeF(new Date().getTime(),overTime,i);
// 					  }
//
// 				}
// 				// 车型动画 开始
// 					var thisIndex=0;
// 					var loopLength=$('#car_carousel').find('.__car_loop').length;
// 					// 设置页码
// 					var pageLi='';
// 					for (var i = 0; i < loopLength; i++) {
// 						if(i==0){
// 							pageLi+='<li><a href="javascript:void(0)" data-id="'+i+'" class="checked"></a></li>';
// 						}else{
// 							pageLi+='<li><a href="javascript:void(0)" data-id="'+i+'"></a></li>';
// 						}
// 					}
// 					$('._acar_page ul').html(pageLi);
//
// 					// 滚动文字
// 					for (var i = 0; i < loopLength; i++) {
// 						setInterval('AutoScroll("#buyList_'+(i+1)+'")', 5000);
// 					}
//
//
//
//
// 					var thisInterval;
//
// 					// 第一个
// 					if($('#car_carousel').find('.__car_loop').length==1){
//
// 						car_carousel(thisIndex,1);
//
// 					}else{
//
// 						car_carousel(thisIndex,0);
//
// 						// 定时器
// 						thisInterval = setInterval(function(){
// 							if(	thisIndex!=0 && thisIndex==(loopLength-1) ){
// 								thisIndex=0;
// 							}else{
// 								thisIndex++;
// 							}
// 							car_carousel(thisIndex,0);
// 						},7300);
// 					}
//
//
// 					// 点击底部页码
// 					$('._acar_page').on('click', 'a', function(event) {
// 						var nowIndex=$(this).attr('data-id');
//
//
// 						if($('#car_carousel').find('.__car_loop').length==1){
//
// 							car_carousel(thisIndex,1);
//
// 							clearInterval(thisInterval);
//
// 						}else{
//
// 							car_carousel(nowIndex,0);
//
// 							clearInterval(thisInterval);
//
// 							thisIndex=nowIndex;
//
// 							thisInterval = setInterval(function(){
// 								if(	thisIndex!=0 && thisIndex==(loopLength-1) ){
// 									thisIndex=0;
// 								}else{
// 									thisIndex++;
// 								}
// 								car_carousel(thisIndex,0);
// 							},7300);
//
// 						}
//
// 						event.preventDefault();
// 					});
// 				// 车型动画 结束
// 			}
// 	});
	
	function overTimeF(t,e,i){
        var d1=new Date(e);
        var d2=new Date(t);
        var d3=(d1-d2)/1000;
        if(d3 > 0){
          window.setInterval(function(){
              var hour=0,
                  minute=0,
                  second=0;//时间默认值        
              if(d3 > 0){
                  hour = Math.floor(d3 / (60 * 60));
                  minute = Math.floor(d3 / 60) - (hour * 60);
                  second = Math.floor(d3) - (hour * 60 * 60) - (minute * 60);
              }
              if (hour <= 9) hour = '0' + hour;
              if (minute <= 9) minute = '0' + minute;
              if (second <= 9) second = '0' + second;
              $('#hourF'+i).html(hour);
              $('#minS'+i).html(minute);
            }, 1000);
        }else{
          var divTime = "divTime_"+i;
          var JSid = "JSid_"+i;
        }
      }

    if(navigator.appName == "Microsoft Internet Explorer"&&parseInt(navigator.appVersion.split(";")[1].replace(/[ ]/g, "").replace("MSIE",""))<9){
    }else{
    	// WOW
    	var wow = new WOW({
    	    boxClass: 'wow',
    	    animateClass: 'animated',
    	    offset: 0,
    	    mobile: true,
    	    live: true
    	});
    	wow.init();
    }
});	//ready


// 文字滚动
function AutoScroll(obj) {
	var moveHeight=$(obj).height();
    $(obj).find("ul:first").animate({
        marginTop: "-"+moveHeight+"px"
    }, 500, function() {
        $(this).css({ marginTop: "0px" }).find("li:first").appendTo(this);
    });
}

// scroll
$(window).scroll(function(e){
	if($(document).scrollTop()> 20 ){
		$('#header').removeClass('_index').addClass('_fixed');
		// $('#header').animate({'top':"0px"},100);
	}else{
		$('#header').removeClass('_fixed').addClass('_index');
		// $('#header').animate({'top':"-100px"},100);
	}

	// if($(document).scrollTop()>($('#Auction').position().top-$(window).height()+200)){
	// 	if(!$('#Auction').hasClass('__in')){
	// 		// return false;
	// 		// $('#auction_count_1').animateNumber({ number: 1065 });
	// 		// $('#auction_count_2').animateNumber({ number: 53473 });
	//
	// 		var numRun1 = $("#auction_count_1").numberAnimate({
	// 		    num: inNum,
	// 		    speed: 1000
	// 		});
	// 		var numRun2 = $("#auction_count_2").numberAnimate({
	// 		    num: bidNum,
	// 		    speed: 1000
	// 		});
	// 		$('#Auction').addClass('__in');
	// 	}
	// }
    //
	// if($(document).scrollTop()>($('#Auction').position().top-$(window).height()+200)){
	// 	if(!$('#Auctionhistory').hasClass('__in')){
	// 		// return false;
	// 		var numRun3 = $("#history_count").numberAnimate({
	// 		    num: addAuctionNum,
	// 		    speed: 2000
	// 		});
	// 		$('#Auctionhistory').addClass('__in');
	// 	}
	// }
});




if(navigator.appName == "Microsoft Internet Explorer"&&parseInt(navigator.appVersion.split(";")[1].replace(/[ ]/g, "").replace("MSIE",""))<9){
}else{
	// WOW
	var wow = new WOW({
	    boxClass: 'wow',
	    animateClass: 'animated',
	    offset: 0,
	    mobile: true,
	    live: true
	});
	wow.init();
}




//正在拍卖数字变化
(function($) {
    $.fn.numberAnimate = function(setting) {
        var defaults = {
                speed: 1000, //动画速度
                num: "", //初始化值
                iniAnimate: true, //是否要初始化动画效果
                symbol: '', //默认的分割符号，千，万，千万
                dot: 0 //保留几位小数点
            }
            //如果setting为空，就取default的值
        var setting = $.extend(defaults, setting);

        var nHtml = '<div class="mt-number-animate-dom" data-num="{{num}}">\
            <span class="mt-number-animate-span">0</span>\
            <span class="mt-number-animate-span">1</span>\
            <span class="mt-number-animate-span">2</span>\
            <span class="mt-number-animate-span">3</span>\
            <span class="mt-number-animate-span">4</span>\
            <span class="mt-number-animate-span">5</span>\
            <span class="mt-number-animate-span">6</span>\
            <span class="mt-number-animate-span">7</span>\
            <span class="mt-number-animate-span">8</span>\
            <span class="mt-number-animate-span">9</span>\
            <span class="mt-number-animate-span">.</span>\
          </div>';

        //数字处理
        var numToArr = function(num) {
            num = parseFloat(num).toFixed(setting.dot);
            if (typeof(num) == 'number') {
                var arrStr = num.toString().split("");
            } else {
                var arrStr = num.split("");
            }
            return arrStr;
        }

        //设置DOM symbol:分割符号
        var setNumDom = function(arrStr) {
            var shtml = '<div class="mt-number-animate">';
            for (var i = 0, len = arrStr.length; i < len; i++) {
                if (i != 0 && (len - i) % 3 == 0 && setting.symbol != "" && arrStr[i] != ".") {
                    shtml += '<div class="mt-number-animate-dot">' + setting.symbol + '</div>' + nHtml.replace("{{num}}", arrStr[i]);
                } else {
                    shtml += nHtml.replace("{{num}}", arrStr[i]);
                }
            }
            shtml += '</div>';
            return shtml;
        }

        //执行动画
        var runAnimate = function($parent) {
            $parent.find(".mt-number-animate-dom").each(function() {
                var num = $(this).attr("data-num");
                num = (num == "." ? 10 : num);
                var spanHei = $(this).height() / 11; //11为元素个数
                var thisTop = -num * spanHei + "px";
                if (thisTop != $(this).css("top")) {
                    if (setting.iniAnimate) {
                        //HTML5不支持
                        if (!window.applicationCache) {
                            $(this).animate({
                                top: thisTop
                            }, setting.speed);
                        } else {
                            $(this).css({
                                'transform': 'translateY(' + thisTop + ')',
                                '-ms-transform': 'translateY(' + thisTop + ')',
                                /* IE 9 */
                                '-moz-transform': 'translateY(' + thisTop + ')',
                                /* Firefox */
                                '-webkit-transform': 'translateY(' + thisTop + ')',
                                /* Safari 和 Chrome */
                                '-o-transform': 'translateY(' + thisTop + ')',
                                '-ms-transition': setting.speed / 1000 + 's',
                                '-moz-transition': setting.speed / 1000 + 's',
                                '-webkit-transition': setting.speed / 1000 + 's',
                                '-o-transition': setting.speed / 1000 + 's',
                                'transition': setting.speed / 1000 + 's'
                            });
                        }
                    } else {
                        setting.iniAnimate = true;
                        $(this).css({
                            top: thisTop
                        });
                    }
                }
            });
        }

        //初始化
        var init = function($parent) {
            //初始化
            $parent.html(setNumDom(numToArr(setting.num)));
            runAnimate($parent);
        };

        //重置参数
        this.resetData = function(num) {
                var newArr = numToArr(num);
                var $dom = $(this).find(".mt-number-animate-dom");
                if ($dom.length < newArr.length) {
                    $(this).html(setNumDom(numToArr(num)));
                } else {
                    $dom.each(function(index, el) {
                        $(this).attr("data-num", newArr[index]);
                    });
                }
                runAnimate($(this));
            }
            //init
        init($(this));
        return this;
    }
})(jQuery);