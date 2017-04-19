/**
 * Created by Administrator on 2017/4/19.
 */


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
        $(".yuyue .left .d_1").eq(a).show().siblings(".yuyue .left .d_1").hide();
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