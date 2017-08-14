/**
 * Created by Xushd on 2017/8/1.
 */

var vm = new Vue({
    el: '#app',
    data: {
        loading:true,
        list:[{id:12112,modelName:'2010款 东风日产轩逸豪华版',zcd:'北京',cdrq:'2010:08:09',pj:'B',pfzb:'国三',bxlc:13.33}],
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
        },changePassword(){
            window.location.href = '/to/mypass';
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
        }
    },components: {
        'count-down': Timer
    }/*,
    mounted(){
        this.init();
    }*/
})