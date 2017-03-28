;(function ($) {
    $.fn.navfix = function (mtop, zindex) {
        var nav = $(this),
            mtop = mtop,
            zindex = zindex,
            dftop = nav.offset().top - $(window).scrollTop(),
            dfleft = nav.offset().left - $(window).scrollLeft(),
            dfcss = new Array;
            dfcss[0] = nav.css("position"),
                dfcss[1] = nav.css("top"),
                dfcss[2] = nav.css("left"),
                dfcss[3] = nav.css("zindex"),
                $(window).scroll(function (e) {
                    if($(this).scrollTop() > dftop){
                        nav.css({
                            position: "fixed",
                            top: mtop + "px",
                            left: dfleft,
                            "z-index": zindex
                        });
                        $(".J_AppointmentBtn").show();
                    }else{
                        nav.css({position: dfcss[0], top: dfcss[1], left: dfcss[2], "z-index": dfcss[3]});
                        $(".J_AppointmentBtn").hide();
                    }
                   
        })
    }
})(jQuery)