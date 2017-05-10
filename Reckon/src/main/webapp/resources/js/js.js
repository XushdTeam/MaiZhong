
$(function(){
    var images_height = '460px';
    var images_url = [
        '../resources/img/3.jpg',
        '../resources/img/1.jpg',
        '../resources/img/2.jpg'
    ];
    var images_count = images_url.length;
    for(var j=0;j<images_count+1;j++){
        $('.banner ul').append('<li></li>')
    }
    //轮播圆点按钮节点
    for(var j=0;j<images_count;j++){
        if(j==0){
            $('.banner ol').append('<li class="current"></li>')
        }else{
            $('.banner ol').append('<li></li>')
        }
    }

    //载入图片
    $(".banner ul li").css('background-image','url('+images_url[0]+')');
    $.each(images_url,function(key,value){
        $('.banner ul li').eq(key).css('background-image','url('+value+')');
    });

    $('.banner').css('height',images_height);

    $('.banner ul').css('width',(images_count+1)*100+'%');

    $('.banner ol').css('width',images_count*20+'px');
    $('.banner ol').css('margin-left',-images_count*20*0.5-10+'px');

    //=========================

    var num = 0;
    //获取窗口宽度
    var window_width = $(window).width();
    $(window).resize(function(){
        window_width = $(window).width();
        $('.banner ul li').css({width:window_width});
        clearInterval(timer);
        nextPlay();
        timer = setInterval(nextPlay,2000);
    });
    //console.log(window_width);
    $('.banner ul li').width(window_width);
    //轮播圆点
    $('.banner ol li').mouseover(function(){//用hover的话会有两个事件(鼠标进入和离开)
        $(this).addClass('current').siblings().removeClass('current');
        //第一张图： 0 * window_width
        //第二张图： 1 * window_width
        //第三张图： 2 * window_width
        //获取当前编号
        var i = $(this).index();
        //console.log(i);
        $('.banner ul').stop().animate({left:-i*window_width},500);
        num = i;
    });
    //自动播放
    var timer = null;
    function prevPlay(){
        num--;
        if(num<0){
            //悄悄把图片跳到最后一张图(复制页,与第一张图相同),然后做出图片播放动画，left参数是定位而不是移动的长度
            $('.banner ul').css({left:-window_width*images_count}).stop().animate({left:-window_width*(images_count-1)},500);
            num=images_count-1;
        }else{
            //console.log(num);
            $('.banner ul').stop().animate({left:-num*window_width},500);
        }
        if(num==images_count-1){
            $('.banner ol li').eq(images_count-1).addClass('current').siblings().removeClass('current');
        }else{
            $('.banner ol li').eq(num).addClass('current').siblings().removeClass('current');

        }
    }
    function nextPlay(){
        num++;
        if(num>images_count){
            //播放到最后一张(复制页)后,悄悄地把图片跳到第一张,因为和第一张相同,所以难以发觉,
            $('.banner ul').css({left:0}).stop().animate({left:-window_width},500);
            //css({left:0})是直接悄悄改变位置，animate({left:-window_width},500)是做出移动动画
            //随后要把指针指向第二张图片,表示已经播放至第二张了。
            num=1;
        }else{
            //在最后面加入一张和第一张相同的图片，如果播放到最后一张，继续往下播，悄悄回到第一张(肉眼看不见)，从第一张播放到第二张
            //console.log(num);
            $('.banner ul').stop().animate({left:-num*window_width},500);
        }
        if(num==images_count){
            $('.banner ol li').eq(0).addClass('current').siblings().removeClass('current');
        }else{
            $('.banner ol li').eq(num).addClass('current').siblings().removeClass('current');

        }
    }
    timer = setInterval(nextPlay,50000);
    //鼠标经过banner，停止定时器,离开则继续播放
    $('.banner').mouseenter(function(){
        clearInterval(timer);
        //左右箭头显示(淡入)
        $('.banner i').fadeIn();
    }).mouseleave(function(){
        timer = setInterval(nextPlay,50000);
        //左右箭头隐藏(淡出)
        $('.banner i').fadeOut();
    });
    //播放下一张
    $('.banner .right').click(function(){
        nextPlay();
    });
    //返回上一张
    $('.banner .left').click(function(){
        prevPlay();
    });
});




$(function () {
    $(".hot-prods .opt .more").click(function () {
        $(".hot-prods .collapse").show();
        $(".hot-prods .hot-prods-list").css("height","auto")
        $(this).hide();
    })
})

$(function () {
    $(".hot-prods .collapse").click(function () {
        $(".opt .more").show();
        $(".hot-prods .hot-prods-list").css("height","55px")
        $(this).hide();
    })
})


$(function () {
    $(".brands .opt .more").click(function () {
        $(".brands .collapse").show();
        $(".brands-list li").show();
        $(this).hide();
    })
})

$(function () {
    $(".brands .collapse").click(function () {
        $(".brands .opt .more").show();
        $(".brands-list li:gt(13)").hide();;
        $(this).hide();
    })
})




$(function () {
    $(".yuyue .left .xk:gt(0)").hide();
    $(".yuyue .left dl").eq(0).addClass("hover")
    $(".yuyue .left dl ").click(function () {
        $(this).addClass("hover").siblings(".yuyue .left dl").removeClass("hover");
    })

    $(".dl1").click(function () {
      $(".xk1").show();
        $(".xk2").hide()
    })

    $(".dl2").click(function () {
        $(".xk2").show();
        $(".xk1").hide()

    })
})




$(function () {
    $(".yuyue .left .d_1:gt(0)").hide();
    $(".yuyue .left .qu span").eq(0).addClass("hovers")
    $(".yuyue .left .qu span ").click(function () {
        var a=$(this).index();
        if(a==0){
            $(".yuyue .left .d_1").eq(a).show().siblings(".yuyue .left .d_1").hide();
            if($("#lineInput").html().indexOf('地铁线路')){
                $(".metro-station-wrap").css("visibility","visible");
            }

        }else{
            $(".yuyue .left .d_1").eq(a).show().siblings(".yuyue .left .d_1").hide();
            $(".metro-station-wrap").css("visibility","hidden");
        }



        $(this).addClass("hovers").siblings(".yuyue .left .qu span").removeClass("hovers");
    })
})


function showoutc(){$(".xies").show();}
function closeClause(){
    $(".xies").hide();
}


$(function () {
    $(".hid").hide();

})

function cun  () {
    $(".hid").toggle();

}



/*地图*/




