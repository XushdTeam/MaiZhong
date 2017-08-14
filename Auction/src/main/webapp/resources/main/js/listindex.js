/**
 * Created by Xushd on 2017/8/1.
 */

var vm = new Vue({
    el: '#app',
    data: {
        loading:true,
        list:[],
        list2:[]
    },
    methods: {
        init(){
            $.getJSON('/auction/now/car/list',(d)=>{
                if(d.status==200){
                    vm.list = d.data;
                }
                vm.loading = false;
            });
            $.getJSON('/more/car',(d)=>{
                if(d.status==200){
                    vm.list2 = d.data;
                }
            });
        },timeOver(index){
            if(!this.list[index].over){
                this.list[index].over = true;
                this.list[index].count = 1;
            }else{
                this.list[index].count += 1;
            }
            if(this.list[index].count>7){
                this.init();
            }
        },like(index,type){
            if(type==1){
                var carId = this.list[index].carId;
                $.getJSON('/auction/car/like/'+carId,(d)=>{
                  if(d.status==200){
                      vm.list[index].imMyLike = true;
                      vm.list[index].likeCounts += 1;
                  }else if(d.data=='login'){
                      window.location.href = '/user/login';
                  }
                })
            }else{
                var carId = this.list2[index].carId;
                $.getJSON('/auction/car/like/'+carId,(d)=>{
                    if(d.status==200){
                        vm.list2[index].imMyLike = true;
                        vm.list2[index].likeCounts += 1;
                    }else if(d.data=='login'){
                        window.location.href = '/user/login';
                    }
                })
            }
        },likeCancle(index,type){
            if(type==1){
                var carId = this.list[index].carId;
                $.getJSON('/auction/car/like/cancle/'+carId,(d)=>{
                    if(d.status==200){
                        vm.list[index].imMyLike = false;
                        vm.list[index].likeCounts -= 1;
                    }
                })
            }else{
                var carId = this.list2[index].carId;
                $.getJSON('/auction/car/like/cancle/'+carId,(d)=>{
                    if(d.status==200){
                        vm.list2[index].imMyLike = false;
                        vm.list2[index].likeCounts -= 1;
                    }
                })
            }
        },detail(item){
            if(item.auction){
                //正在拍
                window.location.href = '/list/detail/'+item.auctionId+'/'+item.carId;
            }else{
                //未拍
                window.location.href = '/list/detail/'+item.carId;
            }
        }
    },components: {
        'count-down': Timer
    },
    mounted(){
        this.init();
    }
})