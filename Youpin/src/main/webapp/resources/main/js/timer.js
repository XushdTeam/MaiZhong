var Timer = {
    template: '<span class="dao_time"><slot>{{content}}</slot></span>',
    data() {
        return {
            content: '',
        }
    },
    props: {
        curTime: {
          type: Number
        },
        endTime: {
            type: Number
        },
        endText: {
            type: String,
            default: '已结束'
        }
    },
    mounted() {
        this.countdowm()
    },
    methods: {
        countdowm() {
            var self = this;
            var timeO = this.curTime;
            var timeD = new Date().getTime() - new Date(timeO).getTime();
            var timeE = this.endTime;
            var timer = setInterval(function() {
                var nowTime = new Date();
                if(timeO!=self.curTime||timeE!=self.endTime){
                  timeO = self.curTime;
                  timeE = self.endTime;
                  timeD = nowTime.getTime() - new Date(timeO).getTime();
                }
                var endTime = new Date(timeE);
                var t = endTime.getTime() - nowTime.getTime() + timeD;
                if (t > 0) {
                    var day = Math.floor(t / 86400000);
                    var hour = Math.floor((t / 3600000) % 24);
                    var min = Math.floor((t / 60000) % 60);
                    var sec = Math.floor((t / 1000) % 60);
                    hour = hour < 10 ? "0" + hour : hour;
                    min = min < 10 ? "0" + min : min;
                    sec = sec < 10 ? "0" + sec : sec;
                    var format = '';
                    if (day > 0) {
                        format = ` ${day}天${hour}:${min}:${sec}`;
                    }
                    if (day <= 0 && hour > 0) {
                        format = ` ${hour}:${min}:${sec}`;
                    }
                    if (day <= 0 && hour <= 0) {
                        format = ` 00:${min}:${sec}`;
                    }
                    self.content = format;

                } else {
                    //clearInterval(timer);
                    self.content = self.endText;
                    self._callback();
                }
            }, 1000);
        },
        _callback() {
            this.$emit('end_callback');
        }
    }
}
