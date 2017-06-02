/**
 * Created by Xushd on 2017/4/14.
 */
/**
 * vue-tap
 */
;(function () {
  var vueTap = {};
  var isVue2 = false;

  /**                               公用方法开始                 **/
  function isPc() {
    var uaInfo = navigator.userAgent;
    var agents = ["Android", "iPhone", "Windows Phone", "iPad", "iPod"];
    var flag = true;
    for ( var i = 0; i < agents.length; i++ ) {
      if (uaInfo.indexOf(agents[i]) > 0) {
        flag = false;
        break;
      }
    }
    return flag;
  }

  function isTap(self) {
    if (isVue2 ? self.disabled : self.el.disabled) {
      return false;
    }
    var tapObj = self.tapObj;
    return self.time < 300 && Math.abs(tapObj.distanceX) < 20 && Math.abs(tapObj.distanceY) < 20;
  }

  function touchstart(e, self) {
    var touches = e.touches[0];
    var tapObj = self.tapObj;
    tapObj.pageX = touches.pageX;
    tapObj.pageY = touches.pageY;
    tapObj.clientX = touches.clientX;
    tapObj.clientY = touches.clientY;
    self.time = +new Date();
  }

  function touchend(e, self) {
    var touches = e.changedTouches[0];
    var tapObj = self.tapObj;
    self.time = +new Date() - self.time;
    tapObj.distanceX = tapObj.pageX - touches.pageX;
    tapObj.distanceY = tapObj.pageY - touches.pageY;

    if (!isTap(self)) return;
      self.handler(e);

  }

  /**                               公用方法结束                 * */

  var vue1 = {
    isFn: true,
    acceptStatement: true,
    update: function (fn) {
      var self = this;
      self.tapObj = {};
      if (typeof fn !== 'function' && self.el.tagName.toLocaleLowerCase() !== 'a') {
        return console.error('The param of directive "v-tap" must be a function!');
      }

      self.handler = function (e) { //This directive.handler
        e.tapObj = self.tapObj;
        if (self.el.href && !self.modifiers.prevent) {
          return window.location = self.el.href;
        }
        fn.call(self, e);
      };
      if (isPc()) {
        self.el.addEventListener('click', function (e) {
          if (self.el.href && !self.modifiers.prevent) {
            return window.location = self.el.href;
          }
          self.handler.call(self, e);
        }, false);
      } else {
        self.el.addEventListener('touchstart', function (e) {

          if (self.modifiers.stop)
            e.stopPropagation();
          if (self.modifiers.prevent)
            e.preventDefault();
          touchstart(e, self);
        }, false);
        self.el.addEventListener('touchend', function (e) {
          try {
            Object.defineProperty(e, 'currentTarget', {// 重写currentTarget对象 与jq相同
              value: self.el,
              writable: true,
              enumerable: true,
              configurable: true
            })
          } catch (e) {
            // ios 7下对 e.currentTarget 用defineProperty会报错。
            // 报“TypeError：Attempting to configurable attribute of unconfigurable property”错误
            // 在catch里重写
            console.error(e.message)
            e.currentTarget = self.el
          }
          e.preventDefault();

          return touchend(e, self);
        }, false);
      }
    }
  };

  var vue2 = {
    bind: function (el, binding) {
      el.tapObj = {};
      el.handler = function (e,isPc) { //This directive.handler
        var value = binding.value;
        if (!value && el.href && !binding.modifiers.prevent) {
          return window.location = el.href;
        }
        value.event = e;
        !isPc ? value.tapObj = el.tapObj : null;
        value.methods.call(this, value);
      };
      if (isPc()) {
        el.addEventListener('click', function (e) {

          if (binding.modifiers.stop)
            e.stopPropagation();
          if (binding.modifiers.prevent)
            e.preventDefault();
          el.handler(e, true)
        }, false);
      } else {
        el.addEventListener('touchstart', function (e) {

          if (binding.modifiers.stop)
            e.stopPropagation();
          if (binding.modifiers.prevent)
            e.preventDefault();
          touchstart(e, el);
        }, false);
        el.addEventListener('touchend', function (e) {
          try {
            Object.defineProperty(e, 'currentTarget', {// 重写currentTarget对象 与jq相同
              value: el,
              writable: true,
              enumerable: true,
              configurable: true
            })
          } catch (e) {
            // ios 7下对 e.currentTarget 用defineProperty会报错。
            // 报“TypeError：Attempting to configurable attribute of unconfigurable property”错误
            // 在catch里重写
            console.error(e.message)
            e.currentTarget = el
          }
          e.preventDefault();

          return touchend(e, el);
        }, false);
      }
    },
    componentUpdated : function(el,binding) {
      el.tapObj = {};
      el.handler = function (e,isPc) { //This directive.handler
        var value = binding.value;
        if (!value && el.href && !binding.modifiers.prevent) {
          return window.location = el.href;
        }
        value.event = e;
        !isPc ? value.tapObj = el.tapObj : null;
        value.methods.call(this, value);
      };
    },
    unbind: function (el) {
      // 卸载，别说了都是泪
      el.handler = function () {};
    }
  };

  vueTap.install = function (Vue) {
    if (Vue.version.substr(0, 1) > 1) {
      isVue2 = true;
    }

    Vue.directive('tap', isVue2 ? vue2 : vue1);
  };

  if (typeof exports == "object") {
    module.exports = vueTap;
  } else if (typeof define == "function" && define.amd) {
    define([], function () {
      return vueTap
    })
  } else if (window.Vue) {
    window.vueTap = vueTap;
    Vue.use(vueTap);
  }

})();
//IOS设置bar
function fixIos7Bar_API2(el,el1){
    if(!$api.isElement(el)){
        console.warn('$api.fixIos7Bar Function need el param, el param must be DOM Element');
        return;
    }
    var strDM = $api.getStorage('SYSTEMTYPE');
    if (strDM == 'ios') {
        var strSV = $api.getStorage('SYSTEMVERSION');
        var numSV = parseInt(strSV,10);
        var fullScreen = $api.getStorage('FULLSCREEN');
        var iOS7StatusBarAppearance = $api.getStorage('IOS7STATUSBARAPPEARANCE');
        if (numSV >= 7 && fullScreen == 'false' && iOS7StatusBarAppearance) {
            el.style.paddingTop = '20px';
            el1.style.paddingTop = '64px';
            el.style.height = '64px';
        }else{
        	el1.style.paddingTop='44px';
        }
    }
}
function fixStatusBar_API2(el,el1){
    if(!$api.isElement(el)){
        console.warn('$api.fixStatusBar Function need el param, el param must be DOM Element');
        return;
    }
    var sysType = $api.getStorage('SYSTEMTYPE');
    if(sysType == 'ios'){
        fixIos7Bar_API2(el,el1);
    }else if(sysType == 'android'){
        var ver = $api.getStorage('SYSTEMVERSION');
        ver = parseFloat(ver);
        if(ver >= 4.4){
            el.style.paddingTop = '25px';
            el.style.height = '69px';
            el1.style.paddingTop = '69px';
        }else{
        	el1.style.paddingTop = '44px';
        }
    }
};
//IOS设置bar
function fixIos7Bar_API(el){
    if(!$api.isElement(el)){
        console.warn('$api.fixIos7Bar Function need el param, el param must be DOM Element');
        return;
    }
    var strDM = $api.getStorage('SYSTEMTYPE');
    if (strDM == 'ios') {
        var strSV = $api.getStorage('SYSTEMVERSION');
        var numSV = parseInt(strSV,10);
        var fullScreen = $api.getStorage('FULLSCREEN');
        var iOS7StatusBarAppearance = $api.getStorage('IOS7STATUSBARAPPEARANCE');
        if (numSV >= 7 && fullScreen == 'false' && iOS7StatusBarAppearance) {
            el.style.paddingTop = '20px';
           
            el.style.height = '64px';
        }
    }
}
function fixStatusBar_API(el){
    if(!$api.isElement(el)){
        console.warn('$api.fixStatusBar Function need el param, el param must be DOM Element');
        return;
    }
    var sysType = $api.getStorage('SYSTEMTYPE');
    if(sysType == 'ios'){
        fixIos7Bar_API(el);
    }else if(sysType == 'android'){
        var ver = $api.getStorage('SYSTEMVERSION');
        ver = parseFloat(ver);
        if(ver >= 4.4){
            el.style.paddingTop = '25px';
            el.style.height = '69px';
           
        }
    }
};
/**
 * 打开窗口
 * @param {Object} id
 * @param {Object} url
 */
function openWin(id,url,param){
	var delay = 0;
	if(api.systemType != 'ios'){
	    delay = 300;
	}
	var pageParam = param || {};
	api.openWin({
	    name: id,
	    url: url,
	    bounces:false,
	    delay: delay,
	    slidBackEnabled:true,
	    vScrollBarEnabled:false,
	    pageParam:pageParam
	});
}
/**
 * 打开无侧滑的窗口
 * @param {Object} id
 * @param {Object} url
 * @param {Object} param
 */
function openWinSlidFalse(id,url,param){
	var delay = 0;
	if(api.systemType != 'ios'){
	    delay = 300;
	}
	var pageParam = param || {};
	api.openWin({
	    name: id,
	    url: url,
	    bounces:false,
	    delay: delay,
	    slidBackEnabled:false,
	    vScrollBarEnabled:false,
	    pageParam:pageParam
	});
}



var lazyLoadImg = function(){
	window.lazyLoadImg = new LazyLoadImg({
        el: document.querySelector('#app'),
        mode: 'diy', //默认模式，将显示原图，diy模式，将自定义剪切，默认剪切居中部分
        time: 300, // 设置一个检测时间间隔
        complete: true, //页面内所有数据图片加载完成后，是否自己销毁程序，true默认销毁，false不销毁
        position: { // 只要其中一个位置符合条件，都会触发加载机制
            top: 0, // 元素距离顶部
            right: 0, // 元素距离右边
            bottom: 0, // 元素距离下面
            left: 0 // 元素距离左边
        },
        diy: { //设置图片剪切规则，diy模式时才有效果
            backgroundSize: 'cover',
            backgroundRepeat: 'no-repeat',
            backgroundPosition: 'center center'
        },
        before: function (el) { // 图片加载之前执行方法

        },
        success: function (el) { // 图片加载成功执行方法
            el.classList.add('success')              
        },
        error: function (el) { // 图片加载失败执行方法      
        	
        }
    });
}
var datemy = function(d){
    //抓取现在日期
    var now = new Date();
    var years = now.getYear()+1;
    var months = now.getMonth()+1;
    var days = now.getDate();

    //抓取前一天日期

    NextNow = addDate(months+"/"+days+"/"+years,0-d);
    months = NextNow.getMonth()+1;
    days = NextNow.getDate();
    return months+'月'+days+'日';
}
var datemy2= function(d){
	//抓取现在日期
    var now = new Date();
    var years = now.getFullYear();

    var months = now.getMonth()+1;
    var days = now.getDate();

    //抓取前一天日期

    NextNow = addDate(months+"/"+days+"/"+years,0-d);
    months = NextNow.getMonth()+1;
    days = NextNow.getDate();
    years = NextNow.getFullYear();    
    return years+'.'+months+'.'+days;
}
function addDate(dd,dadd){
    var a = new Date(dd)
    a = a.valueOf()
    a = a + dadd * 24 * 60 * 60 * 1000
    a = new Date(a)
    return a;
}
