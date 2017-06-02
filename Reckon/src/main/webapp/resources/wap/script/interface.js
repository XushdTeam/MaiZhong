/**
 * 接口
 * Xushd 20170418
 */

var InterFace = (function(obj,mui){
	var BaseUrl = '/m/';


	/**
	 * POST 请求
	 * @param url
	 * @param param
	 * @param cb
     * @constructor
     */
	var HttpPost = function(url,param,cb){
		var token = localStorage.getItem('token');
		mui.ajax(BaseUrl+url,{
			data:param,
			dataType:'json',//服务器返回json格式数据
			type:'post',//HTTP请求类型
			timeout:10000,//超时时间设置为10秒；
			headers: {"X-Maizhong-AppKey": token},
			success:function(data){
				if(data.status==200){
					cb(null,data)
				}else{
					cb(data.message,null)
				}
			},
			error:function(xhr,type){
				cb(type,null)
			}
		});
	}

	/**
	 * GET 请求
	 * @param url
	 * @param param
	 * @param cb
     * @constructor
     */
	var HttpGet = function (url, param,cb) {
		var token = localStorage.getItem('token');

		mui.ajax(BaseUrl+url,{
			data:param,
			dataType:'json',//服务器返回json格式数据
			type:'get',//HTTP请求类型
			timeout:10000,//超时时间设置为10秒；
			headers: {"X-Maizhong-AppKey": token},
			success:function(data){
				if(data.status==200){
					cb(null,data)
				}else{
					cb(data.message,null)
				}
			},
			error:function(xhr,type){
				cb(type,null)
			}
		});
	}


	
	/**
	 * 更具设备ID 获取TOKEN
	 */
	obj.getToken = function(){
		
		var param = {};
		var userInfo = $api.getStorage('userInfo');
		if(userInfo){
			param.phone = userInfo.phone;				
		}else{
			param.deviceId = api.deviceId;	
		}		
		
		api.ajax({
		    url: BaseUrl+'getTokenByDeviceId',
		    method: 'get',
		    data: {
		        values: param		        
		    }
		}, function(ret, err) {
		    if (ret) {
		    	$api.setStorage('token',ret.data.token)			
		    } else {
		    	console.log('token获取失败')		      
		    }
		});
		
	}
	
//	obj.testToken = function(){
//		HttpGet('testGetToken',{},function(e,r){
//			if(e){
//				console.log(JSON.stringify(e));
//			}else{
//				console.log(JSON.stringify(r));
//			}
//		})
//	}
	/**
	 * 同步广告信息
	 */
	obj.getAdvertList = function(){
		HttpGet('getTopPic',{},function(e,r){
			if(e){
				console.log('广告信息同步失败');
			}else{
				
				$api.setStorage('advertList',r.data);
			}
		})
	}
	/**
	 * 同步省份信息
	 */
	obj.getProvice = function(cb){
		HttpGet('getProvince',{},cb);
	}
	/**
	 * 同步城市信息
	 */
	obj.getCity = function(cb){
		HttpGet('getCity',{},cb);
	}
	/**
	 * 同步品牌
	 * @param {Object} cb
	 */
	obj.getBrand = function(cb){
		HttpGet('getBrand',{},cb);
	}
	/**
	 * 品牌获取车系
	 * @param {Object} brandId
	 */
	obj.getSeriesByBrandId = function(brandId,cb){
		HttpGet('getSeriesByBrand/'+brandId,{},cb);
	}
	/**
	 * 车系获取车款
	 * @param {Object} seriesId
	 * @param {Object} cb
	 */
	obj.getModelBySeriesId = function(seriesId,cb){
		HttpGet('getModelBySeries/'+seriesId,{},cb);
	}
	/**
	 * 获取估值结果
	 * @param {Object} param
	 * @param {Object} cb
	 */
	obj.getGuzhiResult = function(param,cb){		
		HttpGet('guzhi/'+param,{},cb);
	}
	
	/**
	 * 发送验证码
	 * @param {Object} phone
	 * @param {Object} cb
	 */
	obj.sendVercode = function(phone,cb){
		HttpGet('getSmsCode/'+phone,{},cb);
	}
	/**
	 * 验证码登录
	 * @param {Object} phone
	 * @param {Object} vercode
	 * @param {Object} cb
	 */
	obj.login = function(phone,vercode,cb){
		HttpGet('userLogin/'+vercode+'/'+phone,{},cb);
	}
	/**
	 * 头像上传
	 * @param {Object} data
	 * @param {Object} cb
	 */
	obj.uploadHeadImg = function(data,cb){
		HttpPost('uploadBase64',{base64Date:data},cb);
	}
	/**
	 * 精准估值
	 * @param {Object} param1
	 * @param {Object} param2
	 * @param {Object} cb
	 */
	obj.getPrecise = function(param1,param2,cb){
		HttpGet('getSaleGZ/'+param1+'/'+param2,{},cb)
	}
	/**
	 * 获取协议
	 * @param {Object} cb
	 */
	obj.getAgreement = function(cb){
		HttpGet('getOrderAgreement',{},cb);
	}
	/**
	 * 获取帮助中心
	 * @param {Object} cb
	 */
	obj.getHelpTitle = function(cb){
		HttpGet('getHelpTitle',{},cb);
	}
	/**
	 * 获取帮助中心内容
	 * @param {Object} id
	 * @param {Object} cb
	 */
	obj.getHelpContent = function(id,cb){
		HttpGet('getHelpContent/'+id,{},cb)
	}	
	/**
	 * 获取地铁线路
	 * @param {Object} cb
	 */
	obj.getLine = function(cb){
		HttpGet('getLine',{},cb);
	}
	/**
	 * 获取地铁站信息
	 * @param {Object} cb
	 */
	obj.getSite = function(cb){
		HttpGet('getLineSite',{},cb)
	}
	/**
	 * 订单列表
	 * @param {Object} cb
	 */
	obj.getOrderList = function(cb){
		HttpGet('getOrdersByPhone',{},cb);
	}
	/**
	 * 通过订单编号获取订单信息
	 * @param {Object} ordernum
	 * @param {Object} cb
	 */
	obj.getOrderInfoByOrderNum = function(ordernum,cb){
		HttpGet('getSaleGZByOrder/'+ordernum,{},cb);
	}
	/**
	 * 通过手机号获取订单信息
	 * @param {Object} cb
	 */
	obj.getOrderInfo = function(cb){
		HttpGet('getAppGZDetail',{},cb);
	}
	/**
	 * 删除未预约订单信息
	 * @param {Object} ordernum
	 * @param {Object} cb
	 */
	obj.delOrder = function(ordernum,cb){
		HttpGet('deleteOrder/'+ordernum,{},cb);
	}
	
	/**
	 * 获取4s店信息
	 * @param {Object} cb
	 */
	obj.getShop = function(cb){
		HttpGet('getBusinessAddress',{},cb)
	}
	/**
	 * 完善订单
	 * @param {Object} param
	 * @param {Object} cb
	 */
	obj.updateOrder = function(param,cb){
		HttpPost('updateOrders',param,cb);
	}
	
	/**
	 * 获取估值记录
	 * @param {Object} cb
	 */
	obj.getGZRecord = function(cb){
		HttpPost('getGzrecord',{},cb);
	}
	/**
	 * 获取版本号 
	 * @param {Object} cb
	 */
	obj.getVersion = function(cb){
		HttpGet('getVersion',{},cb)
	}
	/**
	 * 获取车型详细信息
	 * @param {Object} modelId
	 * @param {Object} cb
	 */
	obj.getModel = function(modelId,cb){
		HttpGet('getModelById/'+modelId,{},cb)
	}
	
	/**
	 * 获取卖车数
	 * @param {Object} cb
	 */
	obj.getDealCount = function(cb){
		HttpGet('getSaleNum',{},cb)
	}
	
	return obj;
	
	
	
})(window.InterFace|| {},mui)


/**
 * 阿里oss对象服务器
 * 
 */
var OSS = (function(oss){
	
	var BaseUrl = 'http://oss.maizhongcar.com/app/';
	
	var getJSON = function(inter,cb){
		var version = $api.getStorage('versionNumber');		
		if(version)version='v0.0.1'
		
		api.ajax({
			url: BaseUrl+version+inter,
		    method: 'get',
		    data: {}},
		    function(d, err) {			    	
		     	if(d&&$api.isArray(d)){
					cb(d)
				}else{
					cb(null)
				}  
			}
		);
	}
	
	/**
	 * 获取轮播活动信息
	 */
	oss.syncActivity = function(cb){
		getJSON('/activity.json',function(d){
			if(d){$api.setStorage('activity',d)}
		})
	}
	/**
	 * 获取热门品牌（首页）
	 */
	oss.syncHotBrand = function(){
		getJSON('/hotbrand.json',function(d){
			if(d){$api.setStorage('hotbrand',d)}
		})
	}
	/**
	 * 获取热门车系（首页）
	 */
	oss.syncHotSeries = function(){
		getJSON('/hotseries.json',function(d){
			if(d){$api.setStorage('hotseries',d)}
		})
	}
	/**
	 * 获取最近成交（首页）
	 */
	oss.syncHotDeal = function(){
		getJSON('/hotdeal.json',function(d){
			if(d){$api.setStorage('hotdeal',d)}
		})
	}
	/**
	 * 获取最新评论（首页）
	 */
	oss.syncHotTalk = function(){
		getJSON('/hottalk.json',function(d){
			if(d){$api.setStorage('hottalk',d)}
		})
	}
	
	/**
	 * 获取最新文章（首页）
	 */
	oss.syncHotWZ = function(){
		getJSON('/wz.json',function(d){
			if(d){$api.setStorage('wz',d)}
		})
	}
	
	
	/**
	 * 获取城市信息
	 * @param {Object} cb
	 */
	oss.syncCity = function(cb){
		getJSON('/city.json',function(d){
			if(d){cb(d)}else{cb(null)}
		})
	}
	/**
	 * 获取省份信息
	 * @param {Object} cb
	 */
	oss.syncProvice = function(cb){
		getJSON('/province.json',function(d){
			if(d){cb(d)}else{cb(null)}
		})
	}
	/**
	 * 获取品牌信息
	 * @param {Object} cb
	 */
	oss.syncAllBrand = function(cb){
		getJSON('/allbrand.json',function(d){
			if(d){cb(d)}else{cb(null)}
		})
	}
	
	/**
	 * 获取地铁线路
	 * @param {Object} cb
	 */
	oss.syncLine = function(cb){
		getJSON('/line.json',function(d){
			if(d){cb(d)}else{cb(null)}
		})
	}
	/**
	 * 获取地铁线路
	 * @param {Object} cb
	 */
	oss.syncSite = function(cb){
		getJSON('/site.json',function(d){
			if(d){cb(d)}else{cb(null)}
		})
	}
	
	
	return oss;
})(window.OSS||{})
