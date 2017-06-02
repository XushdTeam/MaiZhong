/**
 * IndexedList
 * 类似联系人应用中的联系人列表，可以按首字母分组
 * 右侧的字母定位工具条，可以快速定位列表位置
 * varstion 1.0.0
 * by Houfeng
 * Houfeng@DCloud.io
 **/

(function($, window, document) {

	var classSelector = function(name) {
		return '.' + $.className(name);
	}

	var IndexedList = $.IndexedList = $.Class.extend({
		
		/**
		 * 通过 element 和 options 构造 IndexedList 实例
		 **/
		init: function(holder, options) {
			var self = this;			
			self.options = options || {};
			self.box = holder;
			if (!self.box) {
				throw "实例 IndexedList 时需要指定 element";
			}
			self.createDom();
			self.findElements();
			self.caleLayout();
			self.bindEvent();
		},
		createDom: function() {
			var self = this;
			self.el = self.el || {};
			//styleForSearch 用于搜索，此方式能在数据较多时获取很好的性能
			self.el.styleForSearch = document.createElement('style');
			(document.head || document.body).appendChild(self.el.styleForSearch);
		},
		findElements: function() {
			var self = this;
			self.el = self.el || {};
			self.el.search = self.box.querySelector(classSelector('indexed-list-search'));
			self.el.searchInput = self.box.querySelector(classSelector('indexed-list-search-input'));
			self.el.searchClear = self.box.querySelector(classSelector('indexed-list-search') + ' ' + classSelector('icon-clear'));
			self.el.bar = self.box.querySelector(classSelector('indexed-list-bar'));
			self.el.barItems = [].slice.call(self.box.querySelectorAll(classSelector('indexed-list-bar') + ' a'));
			self.el.inner = self.box.querySelector(classSelector('indexed-list-inner'));
			self.el.items = [].slice.call(self.box.querySelectorAll(classSelector('indexed-list-item')));
			self.el.liArray = [].slice.call(self.box.querySelectorAll(classSelector('indexed-list-inner') + ' li'));
			self.el.alert = self.box.querySelector(classSelector('indexed-list-alert'));
		},
		caleLayout: function() {
			var self = this;
			var withoutSearchHeight = (self.box.offsetHeight - self.el.search.offsetHeight) + 'px';
			//self.el.bar.style.height = withoutSearchHeight;
			self.el.inner.style.height = withoutSearchHeight;
			
		},
		scrollTo: function(group) {
			var self = this;
			var groupElement = self.el.inner.querySelector('[data-group="' + group + '"]');
			if (!groupElement || (self.hiddenGroups && self.hiddenGroups.indexOf(groupElement) > -1)) {
				return;
			}
			self.el.inner.scrollTop = groupElement.offsetTop;
		},
		bindBarEvent: function() {
			var self = this;
			var pointElement = null;
			var findStart = function(event) {
				if (pointElement) {
					pointElement.classList.remove('active');
					pointElement = null;
				}
				self.el.bar.classList.add('active');
				var point = event.changedTouches ? event.changedTouches[0] : event;
				pointElement = document.elementFromPoint(point.pageX, point.pageY);
				if (pointElement) {
					var group = pointElement.innerText;
					if (group && group.length == 1) {
						pointElement.classList.add('active');
						self.el.alert.innerText = group;
						self.el.alert.classList.add('active');
						self.scrollTo(group);
					}
				}
				event.preventDefault();
			};
			var findEnd = function(event) {
				self.el.alert.classList.remove('active');
				self.el.bar.classList.remove('active');
				if (pointElement) {
					pointElement.classList.remove('active');
					pointElement = null;
				}
			};
			self.el.bar.addEventListener($.EVENT_MOVE, function(event) {
				findStart(event);
			}, false);
			self.el.bar.addEventListener($.EVENT_START, function(event) {
				findStart(event);
			}, false);
			document.body.addEventListener($.EVENT_END, function(event) {
				findEnd(event);
			}, false);
			document.body.addEventListener($.EVENT_CANCEL, function(event) {
				findEnd(event);
			}, false);
		},
		bindEvent: function() {
			var self = this;
			self.bindBarEvent();
		}
	});

	//mui(selector).indexedList 方式
	$.fn.indexedList = function(options) {
		//遍历选择的元素
		this.each(function(i, element) {
			if (element.indexedList) return;
			element.indexedList = new IndexedList(element, options);
		});
		return this[0] ? this[0].indexedList : null;
	};

})(mui, window, document);