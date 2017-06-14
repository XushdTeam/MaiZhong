/**
 * Created by Xushd on 2017/6/8.
 */
var auction = {
    URL:{
        now:'/now',
        push:'/push'
    },
    //控制定时器
    countdown: function (nowTime, endTime) {
        var seckillBox = $('#seckill-box');
        //时间判断
        if (nowTime >= endTime) {
            //秒杀结束
            seckillBox.html('秒杀结束！');
        } else if (nowTime < endTime) {
            //秒杀未开始,计时事件绑定
            var killTime = new Date(startTime+1000);
            seckillBox.countdown(killTime,function(event){
                var format = event.strftime('剩余倒计时：%H时 %M分 %S秒');
                seckillBox.html(format);
            }).on('finish.countdown',function(){
                seckillBox.html('秒杀结束！');
            });
        }
    },
    init:function(){


        $.getJSON(auction.URL.now, {}, function (d) {
            if (d.status==200) {
                var nowTime = d['data'];
                //时间判断
                auction.countdown(nowTime,endTime);
            } else {
                console.log('result:' + result);
            }
        });
    }

}