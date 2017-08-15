
var vm = new Vue({
    el: '#app',
    data: {
        loading: true,
        list: [{id: '', modelName: '', zcd: '', cdrq: '', pj: '', pfzb: '', bxlc: 0}],
        list2: []
    },
    methods: {
        init() {
            var url = ''
            if (${from==1}) {
                url = '/auction/mylist'
            } else if (${from==2}) {
                url = '/auction/orderList'
            } else if (${from==3}) {
                url = '/auction/bidRecordList'
            } else if (${from==4}) {
                url = '/auction/likeCarList'
            }
            $.getJSON(url, function (d) {
                if (d.status == 200) {
                    vm.list = d.data;
                }
                vm.loading = false;
            })
        }, changePassword() {
            window.location.href = '/auction/personal/changePass';
        },mylist: function () {
            window.location.href = '/auction/personal/mylist';
        },orderList: function () {
            window.location.href = '/auction/personal/orderList';
        },bidRecordList: function () {
            window.location.href = '/auction/personal/bidRecordList';
        },likeCarList: function () {
            window.location.href = '/auction/personal/likeCarList';
        },personal:function () {
            window.location.href = '/personal';
        }
    },
    mounted() {
        this.init();
    }
})