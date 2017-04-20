/**
 * Created by Xushd on 2017/4/18.
 */
var metaUrl = "/";
var baseUrl = "https://www.che300.com/";

/**
 * 打开背景
 */
function openbg() {
    var a = navigator.userAgent.toLocaleLowerCase();
    browserVersion = "", null != a.match(/msie/) || null != a.match(/trident/) ? (browserType = "IE", browserVersion = null != a.match(/msie ([\d.]+)/) ? a.match(/msie ([\d.]+)/)[1] : a.match(/rv:([\d.]+)/)[1]) : null != a.match(/firefox/) ? browserType = "firefox" : null != a.match(/opera/) ? browserType = "opera" : null != a.match(/chrome/) ? browserType = "chrome" : null != a.match(/safari/) && (browserType = "Safari");
    var b = 0,
        c = 0;
    "IE" != browserType || "6.0" != browserVersion && "7.0" != browserVersion && "8.0" != browserVersion ? (b = $(document.body).width(), c = $(document.body).height()) : (b = document.body.scrollWidth, c = document.body.scrollHeight), $(".bgdiv_sel").css({
        width: b + "px",
        height: c + "px"
    }).show()
}
/**
 * 关闭背景
 */
function closebg() {
    $("#select1_1,#select1_2,#select2_1,#select2_2,#select3_1,#select3_2,#sele1_1,#sele1_2,#sele2_1,#sele2_2,#sel1_1,#sel1_2,#sel2_1,#sel2_2,#_select1_1,#_select1_2,#_sele1_1,#_sele1_2,#_sel2_1,#_sel2_2,#_sp_time").fadeOut(), $(".bgdiv_sel").hide()
}
/**
 * 获取省市区
 * @param a
 * @param b
 * @param c
 * @param d
 */
function getArea(a, b, c, d) {

    var e = $("#cityList").val();
    e = e.replace(/'/g, '"'), e = jQuery.parseJSON(e);
    for (var f = $("#s_" + a).val(), g = "", h = 0; h < e.length; h++) if (e[h].prov == b) {
        var i = f == e[h].id ? " layerbg2" : "";
        g += d.replace("%css", " " + i).replace("%id", e[h].id).replace("%name", e[h].name)
    }
    c.empty(), c.append(g)
}
/**
 * loading
 * @param a
 */
function showLoading(a) {
    a.empty();
    var b = "<div style='margin:0 auto;margin-top:50%;text-align: center;'><p style='padding-left: 0px;height:32px;line-height: 32px;'><img src='/resources/img/meta_loading.gif'></p></div>";
    a.html(b)
}
/**
 * 获取车系信息
 * @param a
 * @param b
 * @param c
 * @param d
 * @param e
 * @param f
 * @param g
 */
function getSeriesList(a, b, c, d, e, f, g) {
    function h(h) {
        var k = "";
        if (h.length > 0) {
            for (var l = "", m = 0; m < h.length; m++) {
                l != h[m].series_group_name && (l = h[m].series_group_name, k += 2 == e ? '<p class="pinpailist" style="background:#e3e3e3;text-align:center;line-height:30px">' + l + "</p>" : '<p class="pinpailist" style="background:#e3e3e3;text-align:center">' + l + "</p>"), i = 1 == e && 0 == i ? h[m].series_id : i, j = 1 == e && 0 == j ? h[m].series_id : j;
                var n = i == h[m].series_id && 1 != e ? "layerbg2" : "";
                k += d.replace("%css", " " + n).replace("%id", h[m].series_id).replace("%letter", a).replace("%name", h[m].series_name)
            }
            1 == e && ($("#s_brand").val(b), $("#s_series").val(j), getSimpleList(i, f, g))
        } else k += '<p class="pinpailist" style="background:#e3e3e3;text-align:center">暂无车系</p>';
        c.empty(), c.append(k)
    }
    var i = $("#s_series").val() > 0 ? $("#s_series").val() : 0,
        j = 0;
    showLoading(c), "Microsoft Internet Explorer" != navigator.appName || "8." != navigator.appVersion.match(/8./i) && "9." != navigator.appVersion.match(/9./i) ? $.getJSON(metaUrl + "series/series_brand/" + b , function(a) {
        h(a.data)
    }) : $.getJSON(metaUrl + "series/series_brand/" + b,function(a){
        h(a.data)

    })
}
/**
 * 获取车型
 * @param a
 * @param b
 * @param c
 */
function getSimpleList(a, b, c) {


    function d(a) {
        if (a.length > 0) for (var d = 99999, h = 0; h < a.length; h++) {
            a[h].model_year != d && (d = a[h].model_year, g += '<p class="pinpailist" style="background:#e3e3e3;text-align:center">' + d + "款</p>");
            var i = e == a[h].model_id ? "layerbg2" : "";
            g += c.replace("%css", " " + i).replace(f, a[h].model_id).replace("%name", "<span>" + a[h].model_name + "</span><span style='float:right;margin-right:10px;'>" + Number(a[h].model_price).toFixed(2) + "万</span>").replace("%modelName", a[h].model_name).replace("%date", d).replace("%min", a[h].min_reg_year).replace("%max", a[h].max_reg_year).replace("%price", a[h].model_price)
        } else g += '<p class="pinpailist" style="background:#e3e3e3;text-align:center">暂无车型</p>';
        b.empty(), b.append(g), $("#select4").html("请 选 择 年 份")
    }
    var e = $("body #s_simple").val() > 0 ? $("body #s_simple").val() : "",
        f = new RegExp("%id", "g"),
        g = "";
    showLoading(b), "Microsoft Internet Explorer" != navigator.appName || "8." != navigator.appVersion.match(/8./i) && "9." != navigator.appVersion.match(/9./i) ? $.getJSON(metaUrl + "model/model_series/" + a + "", function(a) {
        d(a.data)
    }) :$.getJSON(metaUrl + "model/model_series/" + a + "",function(a){
        d(a.data)
    })
}
/**
 * 获取年份
 */
function getYears() {
    $("#select4").html("请 选 择 年 份");
    var a = $("#s_year").val(),
        b = $("#s_simple").val(),
        c = $(".simple_" + b).attr("data-min"),
        d = $(".simple_" + b).attr("data-max"),
        e = "";
    for (y = c; y <= d; y++) e += a == y ? '<p class="pinpailist list_4 mylist layerbg2" id="' + y + '">' + y + "年</p>" : '<p class="pinpailist list_4 mylist" id="' + y + '">' + y + "年</p>";
    $(".years").empty(), $(".years").append(e)
}
/**
 * 获取月份
 */
function getMonths() {
    var a = $("#s_month").val(),
        b = $("#s_year").val(),
        c = 1,
        d = new Date,
        e = b >= parseInt(d.getFullYear()) ? parseInt(d.getMonth() + 1) : 12,
        f = "";
    for (m = c; m <= e; m++) f += a == m ? m < 10 ? '<p class="pinpailist list_5 mylist layerbg2" id="' + m + '">0' + m + "月</p>" : '<p class="pinpailist list_5 mylist layerbg2" id="' + m + '">' + m + "月</p>" : m < 10 ? '<p class="pinpailist list_5 mylist" id="' + m + '">0' + m + "月</p>" : '<p class="pinpailist list_5 mylist" id="' + m + '">' + m + "月</p>";
    $(".months").empty(), $(".months").append(f)
}
/**
 * 表单验证
 * @param a
 * @param b
 * @param c
 * @param d
 */
function cleckinput(a, b, c, d) {
    var e = $("#valnone").html(),
        f = $("#select4").html(),
        g = $("#s_year").val() ? $("#s_year").val() : 0,
        h = $("#s_month").val() ? $("#s_month").val() : 0,
        i = $("#select5").html(),
        j = $("#s_province").val() ? $("#s_province").val() : 0,
        k = $("#s_city").val() ? $("#s_city").val() : 0,
        l = $("#lichengpd").val(),
        m = 4;
    if (1 == a && ("请 选 择 车 型" == e ? $("#select1").css({
            color: "#ff5d5d"
        }) : (m--, $("#select1").css({
            color: "#333"
        }))), 1 == b && ("请 选 择 年 份" == f || 0 == g || 0 == h ? $("#select4").css({
            color: "#ff5d5d"
        }) : (m--, $("#select4").css({
            color: "#333"
        }))), 1 == c && ("请 选 择 地 区" == i || 0 == j || 0 == k ? $("#select5").css({
            color: "#ff5d5d"
        }) : (m--, $("#select5").css({
            color: "#333"
        }))), 1 == d && ("" == l && 0 == l ? ($("#gongli").find("label").css({
            color: "#ff5d5d"
        }), $("#lichengpd").focus()) : (m--, $("#gongli").find("label").css({
            color: "#333"
        }))), 0 == m) {
        var n = ($("#s_brand").val(), $("#s_series").val(), $("#s_simple").val());
        resetAllHiddenInput();
        // console.log('j'+j);
        // console.log('k'+k);
        // console.log('n'+n);
        // console.log('g'+g);
        // console.log('h'+h);
        // console.log('l'+l);
        var o = "/guzhi/" + j + "c" + k + "m" + n + "r" + g + "-" + h + "g" + l;
        location.href = o
    }
}
/**
 * 重置所有隐藏input
 */
function resetAllHiddenInput() {
    $("#s_brand").attr("value", "0"),
    $("#s_series").attr("value", "0"),
    $("#s_simple").attr("value", "0"),
    $("#s_year").attr("value", "0"),
    $("#s_month").attr("value", "0"),
    $("#s_province").attr("value", "1"),
    $("#s_city").attr("value", "1"),
    $("#_s_brand").attr("value", "0"),
    $("#_s_series").attr("value", "0"),
    $("#contact").attr("value", ""),
    $("#_valnone").html("请 选 择 车 系"),
    $("#shangpai").html("请 选 择 上 牌 时 间")
}

// function getSeriesList(a, b, c, d, e, f, g) {
//     function h(f) {
//         var g = "";
//         if (f.length > 0) {
//             for (var h = "", k = 0; k < f.length; k++) {
//                 h != f[k].series_group_name && (h = f[k].series_group_name, g += 2 == e ? '<p class="_pinpailist" style="background:#e3e3e3;text-align:center;line-height:30px">' + h + "</p>" : '<p class="_pinpailist" style="background:#e3e3e3;text-align:center">' + h + "</p>"), i = 1 == e && 0 == i ? f[k].series_id : i, j = 1 == e && 0 == j ? f[k].series_id : j;
//                 var l = i == f[k].series_id && 1 != e ? "_layerbg2" : "";
//                 g += d.replace("%css", " " + l).replace("%id", f[k].series_id).replace("%letter", a).replace("%name", f[k].series_name)
//             }
//             1 == e && ($("#_s_brand").val(b), $("#_s_series").val(j))
//         } else g += '<p class="_pinpailist" style="background:#e3e3e3;text-align:center">暂无车系</p>';
//         c.empty(), c.append(g)
//     }
//     var i = $("#_s_series").val() > 0 ? $("#_s_series").val() : 0,
//         j = 0;
//     "Microsoft Internet Explorer" != navigator.appName || "8." != navigator.appVersion.match(/8./i) && "9." != navigator.appVersion.match(/9./i) ? $.getJSON(metaUrl + "series/series_brand" + b + ".json" + assetVersion, function(a) {
//         h(a)
//     }) : $.ajax({
//         type: "get",
//         contentType: "application/json; charset=utf-8",
//         url: baseUrl + "/service/QueryService.php",
//         data: {
//             carBrand: b,
//             oper: "getCarSeriesList"
//         },
//         success: function(a) {
//             var b = jQuery.parseJSON(a);
//             h(b)
//         }
//     })
// }
function showMsg(a) {
    new $.flavr({
        content: a,
        autoclose: !0,
        buttons: {},
        timeout: 2e3
    })
}
function _cleckinput(a, b, c, d) {
    var e = $("#pinpai").val(),
        f = $("#_valnone").html(),
        g = $("#_select5").html(),
        h = $("#_s_brand").val();
    h = h ? h : 0;
    var i = $("#_s_series").val();
    i = i ? i : 0;
    var j = $("#_regDate").val(),
        k = $("#_s_province").val() ? $("#_s_province").val() : 0,
        l = $("#_s_city").val() ? $("#_s_city").val() : 0,
        m = $("#contact").val(),
        n = 4;
    1 == a && ("" == e || 0 == h || 0 == i ? $("#_select1").css({
        "border-color": "#ff5d5d"
    }) : (n--, $("#_select1").css({
        "border-color": "#e6e6e6"
    }))), 1 == b && ("" == j ? $("#shangpai").css({
        "border-color": "#ff5d5d"
    }) : ($("#shangpai").css({
        "border-color": "#e6e6e6"
    }), n--)), 1 == c && ("请 选 择 城 市" == g || 0 == k || 0 == l ? $("#_select5").css({
        "border-color": "#ff5d5d"
    }) : (n--, $("#_select5").css({
        "border-color": "#e6e6e6"
    }))), 1 == d && ("" == m && 0 == m ? ($("#tel").css({
        "border-color": "#ff5d5d"
    }), $("#contact").focus()) : validMobileFormat(m) ? (n--, $("#tel").css({
        "border-color": "#e6e6e6"
    })) : ($("#tel").css({
        "border-color": "#e6e6e6"
    }), $("#contact").css({
        color: "#ff5d5d"
    })));
    var o = $("li.checked"),
        p = "";
    if (0 != o.length && ($("li.checked").each(function(a, b) {
            b = $(b), p = 0 == a ? b.attr("data-name") : p + "," + b.attr("data-name")
        }), 0 == n)) {
        var q = $("#_regDate").val(),
            r = $("#_mileAge").val(),
            s = $("#from").val();
        s = s ? s : "c2c_web";
        var t = q.split("-");
        1 == t.length ? q += "-01-01" : 2 == t.length && (q += "-01");
        var u = "seller_name=&location=" + l + "&tel=" + m + "&brand_name=" + h + "&series_name=" + i + "&model_name=&source=" + s + "&sell_channel=" + p;
        q && (u += "&register_date=" + q), r && (u += "&mile_age=" + r), $.ajax({
            url: siteUrl + "common/add_sale_car_info",
            data: u,
            async: !1,
            type: "POST",
            success: function(a) {
                if ("ok" == a) {
                    resetAllHiddenInput(), $("#msg_tip").text("您的信息已经提交成功！"), $("#sell_confirm_modal").fadeIn();
                    var b = $.trim(e) + " " + $.trim(f);
                    $.post(siteUrl + "service/QueryService.php", {
                        oper: "sendSellNotificationMail",
                        detail: "帮卖需求：" + b + "<br>地区：" + $.trim(g) + "<br>联系方式：" + m,
                        channel: p
                    }).done(function(a) {})
                } else "exists" == a ? ($("#msg_tip").text("重复提交！"), $(".modal-backdrop,#sell_confirm_modal").fadeIn()) : showMsg("提交卖车信息失败，请详询4000257585")
            }
        })
    }
}
function controlSellChannel() {
    var a = $("#_s_city").val(),
        b = $("#_regDate").val(),
        c = 0;
    b && (c = getCurrentYear() - b), $(".car_channel_li_item").each(function(b, d) {
        d = $(d);
        var e = parseInt(d.attr("data-carage")),
            f = d.attr("cities");
        f = f.split(",");
        var g = $.inArray(a, f),
            h = g >= 0;
        c && e && (h = h && c <= e), h ? d.hasClass("checked") ? d.show() : d.show().addClass("checked") : d.hide().removeClass("checked")
    });
    var d = $("li.checked");
    0 == d.length ? ($("#tip").text("*当前卖车条件无平台可支持"), $("#get-it").hide(), $(".cant-get-it,#tip").show()) : ($("#get-it").show(), $(".cant-get-it,#tip").hide())
}
function validMobileFormat(a) {
    var b = /^\d{11}$/,
        c = new RegExp(b);
    if (c.test(a)) {
        var d = /^(13|14|18|15|17)\d{9}$/,
            e = new RegExp(d);
        return e.test(a)
    }
    return !1
}
function getCurrentYear() {
    var a = new Date;
    return a.getFullYear()
}
$(function() {
    $("#select1").live("click", function() {
        var a = $("#s_simple").val(),
            b = $(this).next();
        "0" != a ? b.is(":hidden") ? ($(".model").fadeIn(), openbg()) : ($(".model").hide(), closebg()) : b.is(":hidden") ? (b.fadeIn().next().fadeIn(), openbg()) : (b.hide().next().hide(), closebg())
    }), $(".pinpai_num").live("click", function() {
        var a = $(this).attr("id"),
            b = a.split("_"),
            c = 0,
            d = 26;
        if (0 != parseInt(b[1])) {
            var e = parseInt(b[1]) - 1;
            c = $("#letters_" + e).attr("rel")
        }
        var f = $("body .brand h3").height();
        1 == $(".brandgun").attr("id") && (d = $(".brandgun").find("p").height());
        var g = c * d + f;
        $(".brandgun").scrollTop(g)
    }), $(".list_1").live("click", function() {
        $(".list_1").removeClass("layerbg2").addClass("pinpailist"), $(this).removeClass("pinpailist pinpailisthover").addClass("layerbg2");
        var a = $(this).attr("id"),
            b = ($(this).attr("rel"), $("#s_brand").val()),
            c = $("#s_series").val(),
            d = $("#s_simple").val();
        b == a && "0" != c && "0" != d || ($("#s_brand").val(a), getSeriesList("", a, $(".series"), '<p class="pinpailist list_2 mylist%css" id="%id">%letter%name</p>', 0, "", ""), $("#s_series").val(0), $("#s_simple").val(0), $("#select1").html('<div id="valnone" >请 选 择 车 型</div>'), $("#select2_1,#select2_2").fadeIn(), $("#select3_1,#select3_2").fadeOut())
    }), $(".list_2").live("click", function() {
        $(".list_2").removeClass("layerbg2").addClass("pinpailist"), $(this).removeClass("pinpailist pinpailisthover").addClass("layerbg2");
        var a = $(this).attr("id");
        $("#s_series").val(a), $("#s_simple").val(0), getSimpleList(a, $(".simple"), '<p class="pinpailist list_3 mylist%css simple_%id" id="%id" rel="%date" data-price="%price" data-name="%modelName" data-min="%min" data-max="%max">%name</p>'), $("#select3_1,#select3_2").fadeIn()
    }), $(".list_3").live("click", function() {
        $(".list_3").removeClass("layerbg2").addClass("pinpailist"), $(this).removeClass("pinpailist").removeClass("pinpailisthover").addClass("layerbg2"), $("#s_simple").val($(this).attr("id")), $("#simple_photo").val($(this).attr("rev"));
        var a = $(this).attr("data-name");
        closebg(), $("#select1").html('<div id="valnone" style="width:240px;">' + a + "</div>").css("color", "#333"), $("#s_year").val("0"), $("#s_month").val("0"), getYears()
    }), $("#select4").live("click", function() {
        if ("请 选 择 车 型" == $("#valnone").html()) return $("#valnone").css({
            color: "#ff5d5d"
        }), !1;
        var a = $("#s_month").val();
        if ("0" != a) {
            var b = $(this).next();
            b.is(":hidden") ? ($(".regDate").fadeIn(), openbg()) : ($(".regDate").hide(), closebg())
        } else {
            getYears();
            var c = $(this).next();
            c.is(":hidden") ? (c.fadeIn().next().fadeIn(), openbg()) : (c.hide().next().hide(), closebg())
        }
    }), $(".list_4").live("click", function() {
        $(".list_4").removeClass("layerbg2").addClass("pinpailist"), $(this).removeClass("pinpailist pinpailisthover").addClass("layerbg2 year");
        var a = $(this).html();
        $("#s_year").val($(this).attr("id")), $("#s_month").val(0), $("#select4").html(a), getMonths(), $("#sele2_1,#sele2_2").fadeIn()
    }), $(".list_5").live("click", function() {
        $(".list_5").removeClass("layerbg2").addClass("pinpailist"), $(this).removeClass("pinpailist pinpailisthover").addClass("layerbg2"), $("#s_month").val($(this).attr("id"));
        var a = $("#s_year").val() + "年" + $(this).html();
        $("#select4").html(a).css("color", "#333"), closebg()
    }), $("#select5").live("click", function() {
        var a = $("#s_city").val();
        if ("0" != a) {
            var b = $(this).next();
            b.is(":hidden") ? ($("#sel1_1,#sel1_2").fadeIn(), openbg()) : ($(".zone").hide(), closebg())
        } else {
            var c = $(this).next();
            c.is(":hidden") ? (c.fadeIn().next().fadeIn(), openbg()) : (c.hide().next().hide(), $("#sel2_1,#sel2_2").hide(), closebg())
        }
    }), $(".list_6").live("click", function() {
        $(".list_6").removeClass("layerbg2 province").addClass("pinpailist"), $(this).removeClass("pinpailist pinpailisthover").addClass("layerbg2 province");
        var a = $(this).attr("id");
        $("#s_province").val(a), a > 4 ? ($("#s_city").val(0), getArea("city", a, $(".select_city"), '<p class="pinpailist list_7 mylist%css" id="%id">%name</p>'), $("#sel2_1,#sel2_2").fadeIn()) : ($("#sel2_2,#sel2_1,#sel1_1,#sel1_2").hide(), $("#s_city").val($(this).attr("id")), closebg());
        var b = $(this).html();
        $("#select5").html(b)
    }), $(".list_7").live("click", function() {
        $(".list_7").removeClass("layerbg2").addClass("pinpailist"), $(this).removeClass("pinpailist pinpailisthover").addClass("layerbg2"), $("#s_city").val($(this).attr("id"));
        var a = "";
        a = $(".province").html() == $(this).html() ? $(this).html() : $(".province").html() + $(this).html(), closebg(), $("#select5").html(a).css("color", "#333")
    }), $.fn.numeral = function() {
        $(this).css("ime-mode", "disabled"), this.bind("keypress", function(a) {
            var b = a.keyCode ? a.keyCode : a.which;
            if ("undefined" == typeof document.body.style.maxHeight || 8 != a.keyCode) return b >= 48 && b <= 57 || 46 == b
        }), this.bind("blur", function() {
            this.value.lastIndexOf(".") == this.value.length - 1 ? this.value = this.value.substr(0, this.value.length - 1) : isNaN(this.value) && (this.value = " ")
        }), this.bind("paste", function() {
            var a = clipboardData.getData("text");
            return !/\D/.test(a), value = a.replace(/^0*/, ""), !1
        }), this.bind("dragenter", function() {
            return !1
        }), this.bind("keyup", function() {
            this.value = this.value.replace(/[^\d.]/g, ""), this.value = this.value.replace(/^\./g, ""), this.value = this.value.replace(/^\./g, ""), this.value = this.value.replace(/\.{2,}/g, "."), this.value = this.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", "."), this.value >= 100 && (this.value = this.value.substr(0, 2)), "00" == this.value.toString().substr(0, 2) && (this.value = ""), this.value = this.value.replace(/\.([0-9]{3,6})/g, this.value.substr(this.value.indexOf("."), 3)), $("#gongli label").css("color", "#333")
        })
    }, $("#lichengpd").numeral(), $(".bgdiv_sel").live("click", function() {
        closebg()
    }), $("#eval").live("click", function() {
        0 == $(".numgongli").val() && $(".numgongli").val(""), cleckinput(1, 1, 1, 1)
    })
}), $(function() {
    function a(a) {       
        var b = "[",
            c = !0;
        for (var d in a) {
            var e = a[d],
                f = e.id,
                g = e.name,
                h = e.prov;
            c ? c = !1 : b += ",", b = b + "{'id':'" + f + "', 'name':'" + g + "', 'prov':'" + h + "'}"
        }
        b += "]", $("#cityList").val(b)
    }
    function b(a) {
        "车300个人版" == $(a).text() ? ($(".introduce-choose>div").attr("class", ""), $(a).addClass("orange"), $("#phone-in-img").attr("class", "img-home-major home-icons"), $(".b-c").show(), $(".b-b").hide()) : ($(".introduce-choose>div").attr("class", ""), $(a).addClass("blue"), $("#phone-in-img").attr("class", "img-home-personal home-icons"), $(".b-c").hide(), $(".b-b").show())
    }!
        function() {
            $("img.lazy").lazyload({
                effect: "fadeIn"
            }), $(".slideBox").slide({
                mainCell: ".bd ul",
                interTime: 3500,
                autoPlay: !1,
                autoPage: !0,
                titCell: ".hd > ul",
                startFun: function(a, b) {
                    var c = $(".bd>ul>li").eq(a).attr("data-color");
                    $(".banner").css("background", c)
                }
            });
            var a = $("#article_num").val();
            $(".multiple-info").slick({
                dots: !1,
                infinite: !1,
                speed: 1e3,
                slidesToShow: 3,
                slidesToScroll: a >= 5 ? 3 : 1,
                lazyload: "ondemand",
                touchMove: !1,
                swipe: !1,
                autoplay: !1,
                easing: "ease"
            })
        }();
    var c = "/getAllCity";
    "Microsoft Internet Explorer" != navigator.appName || "8." != navigator.appVersion.match(/8./i) && "9." != navigator.appVersion.match(/9./i) ? $.getJSON(c, function(b) {
        a(b.data)
    }) : $.getJSON(c,function(b){
        a(b.data)
    }),  $(".fdlink-tab>li").click(function() {
        $(this).addClass("tab-focus").siblings().removeClass("tab-focus");
        var a = $(this).attr("id").split("-")[1],
            b = $(".fdlink-show").find("#fdlist-" + a);
        a && b.show().siblings().hide()
    }), function() {
        $(".bd-info").slick({
            dots: !0,
            infinite: !1,
            slidesToShow: 4,
            swipe: !1,
            autoplay: !1,
            slide: "dl"
        });
        var a = $(".tab_letter");
        a.on("click", function(a) {
            var b = $(this);
            0 == b.hasClass("on") && b.addClass("on").siblings().removeClass("on");
            var c = b.attr("data-ind"),
                d = $(".info-wrap").find('li[data-ind="' + c + '"]');
            d.fadeIn(100).siblings().fadeOut(100)
        })
    }();
    var d = $(".introduce-choose>div"),
        e = d[0],
        f = d[1],
        g = !0,
        h = setInterval(function() {
            g ? (b(f), g = !1) : (b(e), g = !0)
        }, 3e3);
    $(".app-introduce").mouseenter(function() {
        clearInterval(h)
    }), $(".app-introduce").mouseleave(function() {
        h = setInterval(function() {
            g ? (b(f), g = !1) : (b(e), g = !0)
        }, 3e3)
    }), $(".introduce-choose>div").mouseenter(function() {
        b(this)
    }), $(".scanning-download").mouseenter(function() {
        "orange" == $(".introduce-choose>div").attr("class") ? ($(".scanning-download").attr("class", "scanning-download orange"), $(".scanning-download>i").attr("class", "icon-scancode-sel home-icons"), $("#app_qrcode_personal").show(), $("#phone-in-code").show()) : ($(".scanning-download").attr("class", "scanning-download blue"), $(".scanning-download>i").attr("class", "icon-scancode-sel home-icons"), $("#app_qrcode_major").show(), $("#phone-in-code").show())
    }), $(".scanning-download").mouseleave(function() {
        $(".scanning-download").attr("class", "scanning-download"), $("#phone-in-img>img").hide(), $("#phone-in-code").hide(), "orange" == $(".introduce-choose>div").attr("class") ? $(".scanning-download>i").attr("class", "icon-scancode-nor home-icons") : $(".scanning-download>i").attr("class", "icon-scancode-major home-icons")
    });
    var i = $(".our-img");
    i.mouseenter(function() {
        $(this).attr("class", "our-img tag"), $(this).attr("class") == $(i[0]).attr("class") ? $($(".our-img>i")[0]).attr("class", "icon-valuation-sel home-icons") : $(this).attr("class") == $(i[1]).attr("class") ? $($(".our-img>i")[1]).attr("class", "icon-buycar-sel home-icons") : $(this).attr("class") == $(i[2]).attr("class") ? $($(".our-img>i")[2]).attr("class", "icon-salecar-sel home-icons") : $($(".our-img>i")[3]).attr("class", "icon-finance-sel home-icons")
    }), i.mouseleave(function() {
        i.attr("class", "our-img"), $($(".our-img>i")[0]).attr("class", "icon-valuation-nor home-icons"), $($(".our-img>i")[1]).attr("class", "icon-buycar-nor home-icons"), $($(".our-img>i")[2]).attr("class", "icon-salecar-nor home-icons"), $($(".our-img>i")[3]).attr("class", "icon-finance-nor home-icons")
    })
}), !
    function(a, b, c, d) {
        var e = a(b);
        a.fn.lazyload = function(f) {
            function g() {
                var b = 0;
                i.each(function() {
                    var c = a(this);
                    if (!j.skip_invisible || c.is(":visible")) if (a.abovethetop(this, j) || a.leftofbegin(this, j));
                    else if (a.belowthefold(this, j) || a.rightoffold(this, j)) {
                        if (++b > j.failure_limit) return !1
                    } else c.trigger("appear"), b = 0
                })
            }
            var h, i = this,
                j = {
                    threshold: 0,
                    failure_limit: 0,
                    event: "scroll",
                    effect: "show",
                    container: b,
                    data_attribute: "original",
                    skip_invisible: !0,
                    appear: null,
                    load: null,
                    placeholder: "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC"
                };
            return f && (d !== f.failurelimit && (f.failure_limit = f.failurelimit, delete f.failurelimit), d !== f.effectspeed && (f.effect_speed = f.effectspeed, delete f.effectspeed), a.extend(j, f)), h = j.container === d || j.container === b ? e : a(j.container), 0 === j.event.indexOf("scroll") && h.bind(j.event, function() {
                return g()
            }), this.each(function() {
                var b = this,
                    c = a(b);
                b.loaded = !1, (c.attr("src") === d || c.attr("src") === !1) && c.attr("src", j.placeholder), c.one("appear", function() {
                    if (!this.loaded) {
                        if (j.appear) {
                            var d = i.length;
                            j.appear.call(b, d, j)
                        }
                        a("<img />").bind("load", function() {
                            var d = c.data(j.data_attribute);
                            c.hide(), c.is("img") ? c.attr("src", d) : c.css("background-image", "url('" + d + "')"), c[j.effect](j.effect_speed), b.loaded = !0;
                            var e = a.grep(i, function(a) {
                                return !a.loaded
                            });
                            if (i = a(e), j.load) {
                                var f = i.length;
                                j.load.call(b, f, j)
                            }
                        }).attr("src", c.data(j.data_attribute))
                    }
                }), 0 !== j.event.indexOf("scroll") && c.bind(j.event, function() {
                    b.loaded || c.trigger("appear")
                })
            }), e.bind("resize", function() {
                g()
            }), /iphone|ipod|ipad.*os 5/gi.test(navigator.appVersion) && e.bind("pageshow", function(b) {
                b.originalEvent && b.originalEvent.persisted && i.each(function() {
                    a(this).trigger("appear")
                })
            }), a(c).ready(function() {
                g()
            }), this
        }, a.belowthefold = function(c, f) {
            var g;
            return g = f.container === d || f.container === b ? (b.innerHeight ? b.innerHeight : e.height()) + e.scrollTop() : a(f.container).offset().top + a(f.container).height(), g <= a(c).offset().top - f.threshold
        }, a.rightoffold = function(c, f) {
            var g;
            return g = f.container === d || f.container === b ? e.width() + e.scrollLeft() : a(f.container).offset().left + a(f.container).width(), g <= a(c).offset().left - f.threshold
        }, a.abovethetop = function(c, f) {
            var g;
            return g = f.container === d || f.container === b ? e.scrollTop() : a(f.container).offset().top, g >= a(c).offset().top + f.threshold + a(c).height()
        }, a.leftofbegin = function(c, f) {
            var g;
            return g = f.container === d || f.container === b ? e.scrollLeft() : a(f.container).offset().left, g >= a(c).offset().left + f.threshold + a(c).width()
        }, a.inviewport = function(b, c) {
            return !(a.rightoffold(b, c) || a.leftofbegin(b, c) || a.belowthefold(b, c) || a.abovethetop(b, c))
        }, a.extend(a.expr[":"], {
            "below-the-fold": function(b) {
                return a.belowthefold(b, {
                    threshold: 0
                })
            },
            "above-the-top": function(b) {
                return !a.belowthefold(b, {
                    threshold: 0
                })
            },
            "right-of-screen": function(b) {
                return a.rightoffold(b, {
                    threshold: 0
                })
            },
            "left-of-screen": function(b) {
                return !a.rightoffold(b, {
                    threshold: 0
                })
            },
            "in-viewport": function(b) {
                return a.inviewport(b, {
                    threshold: 0
                })
            },
            "above-the-fold": function(b) {
                return !a.belowthefold(b, {
                    threshold: 0
                })
            },
            "right-of-fold": function(b) {
                return a.rightoffold(b, {
                    threshold: 0
                })
            },
            "left-of-fold": function(b) {
                return !a.rightoffold(b, {
                    threshold: 0
                })
            }
        })
    }(jQuery, window, document), !
    function(a) {
        a.fn.slide = function(b) {
            return a.fn.slide.defaults = {
                type: "slide",
                effect: "fade",
                autoPlay: !1,
                delayTime: 500,
                interTime: 2500,
                triggerTime: 150,
                defaultIndex: 0,
                titCell: ".hd li",
                mainCell: ".bd",
                targetCell: null,
                trigger: "mouseover",
                scroll: 1,
                vis: 1,
                titOnClassName: "on",
                autoPage: !1,
                prevCell: ".prev",
                nextCell: ".next",
                pageStateCell: ".pageState",
                opp: !1,
                pnLoop: !0,
                easing: "swing",
                startFun: null,
                endFun: null,
                switchLoad: null,
                playStateCell: ".playState",
                mouseOverStop: !0,
                defaultPlay: !0,
                returnDefault: !1
            }, this.each(function() {
                var c = a.extend({}, a.fn.slide.defaults, b),
                    d = a(this),
                    e = c.effect,
                    f = a(c.prevCell, d),
                    g = a(c.nextCell, d),
                    h = a(c.pageStateCell, d),
                    i = a(c.playStateCell, d),
                    j = a(c.titCell, d),
                    k = j.size(),
                    l = a(c.mainCell, d),
                    m = l.children().size(),
                    n = c.switchLoad,
                    o = a(c.targetCell, d),
                    p = parseInt(c.defaultIndex),
                    q = parseInt(c.delayTime),
                    r = parseInt(c.interTime);
                parseInt(c.triggerTime);
                var s, t = parseInt(c.scroll),
                    u = parseInt(c.vis),
                    v = "false" != c.autoPlay && 0 != c.autoPlay,
                    w = "false" != c.opp && 0 != c.opp,
                    x = "false" != c.autoPage && 0 != c.autoPage,
                    y = "false" != c.pnLoop && 0 != c.pnLoop,
                    z = "false" != c.mouseOverStop && 0 != c.mouseOverStop,
                    A = "false" != c.defaultPlay && 0 != c.defaultPlay,
                    B = "false" != c.returnDefault && 0 != c.returnDefault,
                    C = 0,
                    D = 0,
                    E = 0,
                    F = 0,
                    G = c.easing,
                    H = null,
                    I = null,
                    J = null,
                    K = c.titOnClassName,
                    L = j.index(d.find("." + K)),
                    M = p = -1 == L ? p : L,
                    N = p,
                    O = p,
                    P = m >= u ? 0 != m % t ? m % t : t : 0,
                    Q = "leftMarquee" == e || "topMarquee" == e,
                    R = function() {
                        a.isFunction(c.startFun) && c.startFun(p, k, d, a(c.titCell, d), l, o, f, g)
                    },
                    S = function() {
                        a.isFunction(c.endFun) && c.endFun(p, k, d, a(c.titCell, d), l, o, f, g)
                    },
                    T = function() {
                        j.removeClass(K), A && j.eq(N).addClass(K)
                    };
                if ("menu" == c.type) return A && j.removeClass(K).eq(p).addClass(K), j.hover(function() {
                    s = a(this).find(c.targetCell);
                    var b = j.index(a(this));
                    I = setTimeout(function() {
                        switch (p = b, j.removeClass(K).eq(p).addClass(K), R(), e) {
                            case "fade":
                                s.stop(!0, !0).animate({
                                    opacity: "show"
                                }, q, G, S);
                                break;
                            case "slideDown":
                                s.stop(!0, !0).animate({
                                    height: "show"
                                }, q, G, S)
                        }
                    }, c.triggerTime)
                }, function() {
                    switch (clearTimeout(I), e) {
                        case "fade":
                            s.animate({
                                opacity: "hide"
                            }, q, G);
                            break;
                        case "slideDown":
                            s.animate({
                                height: "hide"
                            }, q, G)
                    }
                }), void(B && d.hover(function() {
                    clearTimeout(J)
                }, function() {
                    J = setTimeout(T, q)
                }));
                if (0 == k && (k = m), Q && (k = 2), x) {
                    if (m >= u) if ("leftLoop" == e || "topLoop" == e) k = 0 != m % t ? (0 ^ m / t) + 1 : m / t;
                    else {
                        var U = m - u;
                        k = 1 + parseInt(0 != U % t ? U / t + 1 : U / t), 0 >= k && (k = 1)
                    } else k = 1;
                    j.html("");
                    var V = "";
                    if (1 == c.autoPage || "true" == c.autoPage) for (var W = 0; k > W; W++) V += "<li>" + (W + 1) + "</li>";
                    else for (var W = 0; k > W; W++) V += c.autoPage.replace("$", W + 1);
                    j.html(V);
                    var j = j.children()
                }
                if (m >= u) {
                    l.children().each(function() {
                        a(this).width() > E && (E = a(this).width(), D = a(this).outerWidth(!0)), a(this).height() > F && (F = a(this).height(), C = a(this).outerHeight(!0))
                    });
                    var X = l.children(),
                        Y = function() {
                            for (var a = 0; u > a; a++) X.eq(a).clone().addClass("clone").appendTo(l);
                            for (var a = 0; P > a; a++) X.eq(m - a - 1).clone().addClass("clone").prependTo(l)
                        };
                    switch (e) {
                        case "fold":
                            l.css({
                                position: "relative",
                                width: D,
                                height: C
                            }).children().css({
                                position: "absolute",
                                width: E,
                                left: 0,
                                top: 0,
                                display: "none"
                            });
                            break;
                        case "top":
                            l.wrap('<div class="tempWrap" style="overflow:hidden; position:relative; height:' + u * C + 'px"></div>').css({
                                top: -(p * t) * C,
                                position: "relative",
                                padding: "0",
                                margin: "0"
                            }).children().css({
                                height: F
                            });
                            break;
                        case "left":
                            l.wrap('<div class="tempWrap" style="overflow:hidden; position:relative; width:' + u * D + 'px"></div>').css({
                                width: m * D,
                                left: -(p * t) * D,
                                position: "relative",
                                overflow: "hidden",
                                padding: "0",
                                margin: "0"
                            }).children().css({
                                "float": "left",
                                width: E
                            });
                            break;
                        case "leftLoop":
                        case "leftMarquee":
                            Y(), l.wrap('<div class="tempWrap" style="overflow:hidden; position:relative; width:' + u * D + 'px"></div>').css({
                                width: (m + u + P) * D,
                                position: "relative",
                                overflow: "hidden",
                                padding: "0",
                                margin: "0",
                                left: -(P + p * t) * D
                            }).children().css({
                                "float": "left",
                                width: E
                            });
                            break;
                        case "topLoop":
                        case "topMarquee":
                            Y(), l.wrap('<div class="tempWrap" style="overflow:hidden; position:relative; height:' + u * C + 'px"></div>').css({
                                height: (m + u + P) * C,
                                position: "relative",
                                padding: "0",
                                margin: "0",
                                top: -(P + p * t) * C
                            }).children().css({
                                height: F
                            })
                    }
                }
                var Z = function(a) {
                        var b = a * t;
                        return a == k ? b = m : -1 == a && 0 != m % t && (b = -m % t), b
                    },
                    $ = function(b) {
                        var c = function(c) {
                            for (var d = c; u + c > d; d++) b.eq(d).find("img[" + n + "]").each(function() {
                                var b = a(this);
                                if (b.attr("src", b.attr(n)).removeAttr(n), l.find(".clone")[0]) for (var c = l.children(), d = 0; d < c.size(); d++) c.eq(d).find("img[" + n + "]").each(function() {
                                    a(this).attr(n) == b.attr("src") && a(this).attr("src", a(this).attr(n)).removeAttr(n)
                                })
                            })
                        };
                        switch (e) {
                            case "fade":
                            case "fold":
                            case "top":
                            case "left":
                            case "slideDown":
                                c(p * t);
                                break;
                            case "leftLoop":
                            case "topLoop":
                                c(P + Z(O));
                                break;
                            case "leftMarquee":
                            case "topMarquee":
                                var d = "leftMarquee" == e ? l.css("left").replace("px", "") : l.css("top").replace("px", ""),
                                    f = "leftMarquee" == e ? D : C,
                                    g = P;
                                if (0 != d % f) {
                                    var h = Math.abs(0 ^ d / f);
                                    g = 1 == p ? P + h : P + h - 1
                                }
                                c(g)
                        }
                    },
                    _ = function(a) {
                        if (!A || M != p || a || Q) {
                            if (Q ? p >= 1 ? p = 1 : 0 >= p && (p = 0) : (O = p, p >= k ? p = 0 : 0 > p && (p = k - 1)), R(), null != n && $(l.children()), o[0] && (s = o.eq(p), null != n && $(o), "slideDown" == e ? (o.not(s).stop(!0, !0).slideUp(q), s.slideDown(q, G, function() {
                                    l[0] || S()
                                })) : (o.not(s).stop(!0, !0).hide(), s.animate({
                                    opacity: "show"
                                }, q, function() {
                                    l[0] || S()
                                }))), m >= u) switch (e) {
                                case "fade":
                                    l.children().stop(!0, !0).eq(p).animate({
                                        opacity: "show"
                                    }, q, G, function() {
                                        S()
                                    }).siblings().hide();
                                    break;
                                case "fold":
                                    l.children().stop(!0, !0).eq(p).animate({
                                        opacity: "show"
                                    }, q, G, function() {
                                        S()
                                    }).siblings().animate({
                                        opacity: "hide"
                                    }, q, G);
                                    break;
                                case "top":
                                    l.stop(!0, !1).animate({
                                        top: -p * t * C
                                    }, q, G, function() {
                                        S()
                                    });
                                    break;
                                case "left":
                                    l.stop(!0, !1).animate({
                                        left: -p * t * D
                                    }, q, G, function() {
                                        S()
                                    });
                                    break;
                                case "leftLoop":
                                    var b = O;
                                    l.stop(!0, !0).animate({
                                        left: -(Z(O) + P) * D
                                    }, q, G, function() {
                                        -1 >= b ? l.css("left", -(P + (k - 1) * t) * D) : b >= k && l.css("left", -P * D), S()
                                    });
                                    break;
                                case "topLoop":
                                    var b = O;
                                    l.stop(!0, !0).animate({
                                        top: -(Z(O) + P) * C
                                    }, q, G, function() {
                                        -1 >= b ? l.css("top", -(P + (k - 1) * t) * C) : b >= k && l.css("top", -P * C), S()
                                    });
                                    break;
                                case "leftMarquee":
                                    var c = l.css("left").replace("px", "");
                                    0 == p ? l.animate({
                                        left: ++c
                                    }, 0, function() {
                                        l.css("left").replace("px", "") >= 0 && l.css("left", -m * D)
                                    }) : l.animate({
                                        left: --c
                                    }, 0, function() {
                                        l.css("left").replace("px", "") <= -(m + P) * D && l.css("left", -P * D)
                                    });
                                    break;
                                case "topMarquee":
                                    var d = l.css("top").replace("px", "");
                                    0 == p ? l.animate({
                                        top: ++d
                                    }, 0, function() {
                                        l.css("top").replace("px", "") >= 0 && l.css("top", -m * C)
                                    }) : l.animate({
                                        top: --d
                                    }, 0, function() {
                                        l.css("top").replace("px", "") <= -(m + P) * C && l.css("top", -P * C)
                                    })
                            }
                            j.removeClass(K).eq(p).addClass(K), M = p, y || (g.removeClass("nextStop"), f.removeClass("prevStop"), 0 == p && f.addClass("prevStop"), p == k - 1 && g.addClass("nextStop")), h.html("<span>" + (p + 1) + "</span>/" + k)
                        }
                    };
                A && _(!0), B && d.hover(function() {
                    clearTimeout(J)
                }, function() {
                    J = setTimeout(function() {
                        p = N, A ? _() : "slideDown" == e ? s.slideUp(q, T) : s.animate({
                            opacity: "hide"
                        }, q, T), M = p
                    }, 300)
                });
                var aa = function(a) {
                        H = setInterval(function() {
                            w ? p-- : p++, _()
                        }, a ? a : r)
                    },
                    ba = function(a) {
                        H = setInterval(_, a ? a : r)
                    },
                    ca = function() {
                        z || (clearInterval(H), aa())
                    },
                    da = function() {
                        (y || p != k - 1) && (p++, _(), Q || ca())
                    },
                    ea = function() {
                        (y || 0 != p) && (p--, _(), Q || ca())
                    },
                    fa = function() {
                        clearInterval(H), Q ? ba() : aa(), i.removeClass("pauseState")
                    },
                    ga = function() {
                        clearInterval(H), i.addClass("pauseState")
                    };
                if (v ? Q ? (w ? p-- : p++, ba(), z && l.hover(ga, fa)) : (aa(), z && d.hover(ga, fa)) : (Q && (w ? p-- : p++), i.addClass("pauseState")), i.click(function() {
                        i.hasClass("pauseState") ? fa() : ga()
                    }), "mouseover" == c.trigger ? j.hover(function() {
                        var a = j.index(this);
                        I = setTimeout(function() {
                            p = a, _(), ca()
                        }, c.triggerTime)
                    }, function() {
                        clearTimeout(I)
                    }) : j.click(function() {
                        p = j.index(this), _(), ca()
                    }), Q) {
                    if (g.mousedown(da), f.mousedown(ea), y) {
                        var ha, ia = function() {
                                ha = setTimeout(function() {
                                    clearInterval(H), ba(0 ^ r / 10)
                                }, 150)
                            },
                            ja = function() {
                                clearTimeout(ha), clearInterval(H), ba()
                            };
                        g.mousedown(ia), g.mouseup(ja), f.mousedown(ia), f.mouseup(ja)
                    }
                    "mouseover" == c.trigger && (g.hover(da, function() {}), f.hover(ea, function() {}))
                } else g.click(da), f.click(ea)
            })
        }
    }(jQuery), jQuery.easing.jswing = jQuery.easing.swing, jQuery.extend(jQuery.easing, {
    def: "easeOutQuad",
    swing: function(a, b, c, d, e) {
        return jQuery.easing[jQuery.easing.def](a, b, c, d, e)
    },
    easeInQuad: function(a, b, c, d, e) {
        return d * (b /= e) * b + c
    },
    easeOutQuad: function(a, b, c, d, e) {
        return -d * (b /= e) * (b - 2) + c
    },
    easeInOutQuad: function(a, b, c, d, e) {
        return (b /= e / 2) < 1 ? d / 2 * b * b + c : -d / 2 * (--b * (b - 2) - 1) + c
    },
    easeInCubic: function(a, b, c, d, e) {
        return d * (b /= e) * b * b + c
    },
    easeOutCubic: function(a, b, c, d, e) {
        return d * ((b = b / e - 1) * b * b + 1) + c
    },
    easeInOutCubic: function(a, b, c, d, e) {
        return (b /= e / 2) < 1 ? d / 2 * b * b * b + c : d / 2 * ((b -= 2) * b * b + 2) + c
    },
    easeInQuart: function(a, b, c, d, e) {
        return d * (b /= e) * b * b * b + c
    },
    easeOutQuart: function(a, b, c, d, e) {
        return -d * ((b = b / e - 1) * b * b * b - 1) + c
    },
    easeInOutQuart: function(a, b, c, d, e) {
        return (b /= e / 2) < 1 ? d / 2 * b * b * b * b + c : -d / 2 * ((b -= 2) * b * b * b - 2) + c
    },
    easeInQuint: function(a, b, c, d, e) {
        return d * (b /= e) * b * b * b * b + c
    },
    easeOutQuint: function(a, b, c, d, e) {
        return d * ((b = b / e - 1) * b * b * b * b + 1) + c
    },
    easeInOutQuint: function(a, b, c, d, e) {
        return (b /= e / 2) < 1 ? d / 2 * b * b * b * b * b + c : d / 2 * ((b -= 2) * b * b * b * b + 2) + c
    },
    easeInSine: function(a, b, c, d, e) {
        return -d * Math.cos(b / e * (Math.PI / 2)) + d + c
    },
    easeOutSine: function(a, b, c, d, e) {
        return d * Math.sin(b / e * (Math.PI / 2)) + c
    },
    easeInOutSine: function(a, b, c, d, e) {
        return -d / 2 * (Math.cos(Math.PI * b / e) - 1) + c
    },
    easeInExpo: function(a, b, c, d, e) {
        return 0 == b ? c : d * Math.pow(2, 10 * (b / e - 1)) + c
    },
    easeOutExpo: function(a, b, c, d, e) {
        return b == e ? c + d : d * (-Math.pow(2, -10 * b / e) + 1) + c
    },
    easeInOutExpo: function(a, b, c, d, e) {
        return 0 == b ? c : b == e ? c + d : (b /= e / 2) < 1 ? d / 2 * Math.pow(2, 10 * (b - 1)) + c : d / 2 * (-Math.pow(2, -10 * --b) + 2) + c
    },
    easeInCirc: function(a, b, c, d, e) {
        return -d * (Math.sqrt(1 - (b /= e) * b) - 1) + c
    },
    easeOutCirc: function(a, b, c, d, e) {
        return d * Math.sqrt(1 - (b = b / e - 1) * b) + c
    },
    easeInOutCirc: function(a, b, c, d, e) {
        return (b /= e / 2) < 1 ? -d / 2 * (Math.sqrt(1 - b * b) - 1) + c : d / 2 * (Math.sqrt(1 - (b -= 2) * b) + 1) + c
    },
    easeInElastic: function(a, b, c, d, e) {
        var f = 1.70158,
            g = 0,
            h = d;
        if (0 == b) return c;
        if (1 == (b /= e)) return c + d;
        if (g || (g = .3 * e), h < Math.abs(d)) {
            h = d;
            var f = g / 4
        } else var f = g / (2 * Math.PI) * Math.asin(d / h);
        return -(h * Math.pow(2, 10 * (b -= 1)) * Math.sin(2 * (b * e - f) * Math.PI / g)) + c
    },
    easeOutElastic: function(a, b, c, d, e) {
        var f = 1.70158,
            g = 0,
            h = d;
        if (0 == b) return c;
        if (1 == (b /= e)) return c + d;
        if (g || (g = .3 * e), h < Math.abs(d)) {
            h = d;
            var f = g / 4
        } else var f = g / (2 * Math.PI) * Math.asin(d / h);
        return h * Math.pow(2, -10 * b) * Math.sin(2 * (b * e - f) * Math.PI / g) + d + c
    },
    easeInOutElastic: function(a, b, c, d, e) {
        var f = 1.70158,
            g = 0,
            h = d;
        if (0 == b) return c;
        if (2 == (b /= e / 2)) return c + d;
        if (g || (g = .3 * e * 1.5), h < Math.abs(d)) {
            h = d;
            var f = g / 4
        } else var f = g / (2 * Math.PI) * Math.asin(d / h);
        return 1 > b ? -.5 * h * Math.pow(2, 10 * (b -= 1)) * Math.sin(2 * (b * e - f) * Math.PI / g) + c : .5 * h * Math.pow(2, -10 * (b -= 1)) * Math.sin(2 * (b * e - f) * Math.PI / g) + d + c
    },
    easeInBack: function(a, b, c, d, e, f) {
        return void 0 == f && (f = 1.70158), d * (b /= e) * b * ((f + 1) * b - f) + c
    },
    easeOutBack: function(a, b, c, d, e, f) {
        return void 0 == f && (f = 1.70158), d * ((b = b / e - 1) * b * ((f + 1) * b + f) + 1) + c
    },
    easeInOutBack: function(a, b, c, d, e, f) {
        return void 0 == f && (f = 1.70158), (b /= e / 2) < 1 ? d / 2 * b * b * (((f *= 1.525) + 1) * b - f) + c : d / 2 * ((b -= 2) * b * (((f *= 1.525) + 1) * b + f) + 2) + c
    },
    easeInBounce: function(a, b, c, d, e) {
        return d - jQuery.easing.easeOutBounce(a, e - b, 0, d, e) + c
    },
    easeOutBounce: function(a, b, c, d, e) {
        return (b /= e) < 1 / 2.75 ? 7.5625 * d * b * b + c : 2 / 2.75 > b ? d * (7.5625 * (b -= 1.5 / 2.75) * b + .75) + c : 2.5 / 2.75 > b ? d * (7.5625 * (b -= 2.25 / 2.75) * b + .9375) + c : d * (7.5625 * (b -= 2.625 / 2.75) * b + .984375) + c
    },
    easeInOutBounce: function(a, b, c, d, e) {
        return e / 2 > b ? .5 * jQuery.easing.easeInBounce(a, 2 * b, 0, d, e) + c : .5 * jQuery.easing.easeOutBounce(a, 2 * b - e, 0, d, e) + .5 * d + c
    }
}), $(function() {
    $("#_select1").click(function() {
        $("#_sele1_1,#_sele1_2").hide();
        var a = $(this).next();
        a.is(":hidden") ? (a.fadeIn().next().fadeIn(), openbg()) : (a.hide().next().hide(), closebg())
    }), $("._pinpai_num").click(function() {
        var a = $(this).attr("id"),
            b = a.split("_"),
            c = 0,
            d = 32;
        if (0 != parseInt(b[2])) {
            var e = parseInt(b[2]) - 1;
            c = $("#_letters_" + e).attr("rel")
        }
        var f = c * d;
        $("._brandgun").scrollTop(f)
    }), $("body").on("mouseenter", "._mylist", function() {
        $(this).addClass("_pinpailisthover")
    }), $("body").on("mouseleave", "._mylist", function() {
        $(this).removeClass("_pinpailisthover")
    }), $("._list_1").click(function() {
        $("._list_1").removeClass("_layerbg2").addClass("_pinpailist"), $(this).removeClass("_pinpailist _pinpailisthover").addClass("_layerbg2");
        var a = $(this).html(),
            b = $(this).attr("id");
        $(this).attr("rel");
        $("#_s_brand").val(b), getSeriesList("", b, $(".series"), '<p class="_pinpailist _list_2 _mylist%css" id="%id">%letter%name</p>', 0, "", ""), $("#_s_series").val(0), $("#pinpai").val(a), closebg(), $("#_sele1_1,#_sele1_2").fadeIn(), $("#_regDate").val(""), $("#_mileAge").val("")
    }), $("body").on("click", "._list_2", function() {
        $("._list_2").removeClass("_layerbg2").addClass("_pinpailist"), $(this).removeClass("_pinpailist _pinpailisthover").addClass("_layerbg2");
        var a = $(this).html(),
            b = $(this).attr("id");
        b != $("#_s_series").val() && ($("#_regDate").val(""), $("#_mileAge").val("")), $("#_s_series").val(b), $("#_valnone").html(a).css("color", "#666"), closebg()
    });
    for (var a = 2e3; a <= parseInt(getCurrentYear()); a++) $("#_sp_time").prepend('<dd data-year="' + a + '">' + a + " 年</dd>");
    $("#_sp_time").prepend("<dt>上牌时间</dt>"), $("#shangpai").click(function() {
        $(this).next().is(":hidden") ? ($(this).next().fadeIn(), openbg()) : ($(this).next().hide(), closebg())
    }), $("#_sp_time>dd").click(function() {
        $("#_regDate").val($(this).attr("data-year")), $("#shangpai").text($(this).text()).attr("data-year", $(this).attr("data-year")), $(this).parents("dl").hide(), controlSellChannel(), closebg()
    }), $("#_select5").click(function() {
        var a = $("#_s_city").val();
        if ("0" != a) {
            var b = $(this).next();
            b.is(":hidden") ? ($("._zone").fadeIn(), openbg()) : ($("._zone").hide(), closebg())
        } else {
            var c = $(this).next();
            c.is(":hidden") ? (c.fadeIn().next().fadeIn(), openbg()) : (c.hide().next().hide(), $("#_sel2_1,#_sel2_2").hide(), closebg())
        }
    }), $("._list_6").click(function() {
        $("._list_6").removeClass("_layerbg2 province").addClass("_pinpailist"), $(this).removeClass("_pinpailist _pinpailisthover").addClass("_layerbg2 province");
        var a = $(this).attr("data-prov"),
            b = $(this).attr("id");
        $("#_s_province").val(a), $("#_s_city").val(b);
        var c = $(this).html();
        $("#_select5").html(c), $("#_sel2_1,#_sel2_2").hide(), controlSellChannel(), closebg()
    }), $(".channel_work").click(function(a) {
        var b = $(this);
        b.hasClass("checked") ? b.removeClass("checked") : b.addClass("checked"), 0 == b.siblings(".channel_work").hasClass("checked") && 0 == b.hasClass("checked") ? ($("#get-it").hide(), $(".cant-get-it,#tip").show()) : ($("#get-it").show(), $(".cant-get-it,#tip").hide()), a.stopPropagation()
    }), $(".show_itd").click(function(a) {
        var b = $(".car_channel_div_item"),
            c = $(this);
        $(".pg_prj").animate({
            left: "-713px"
        }, 500), $(".pg_itd").animate({
            left: "0"
        }, 500).show(), $(".pg_itd_close").fadeIn(), $(".pg_right").animate({
            scrollTop: 0
        }, 0), console.log("car_channel:" + b + "data-target:" + c.attr("data-target") + ",data-name:" + b.attr("data-name")), b.each(function() {
            c.attr("data-target") == $(this).attr("data-name") && $(this).show().siblings().hide()
        }), a.stopPropagation()
    }), $(".pg_itd_close").click(function(a) {
        $(".pg_itd").animate({
            left: "713px"
        }, 500), $(".pg_prj").animate({
            left: "0"
        }, 500), setTimeout(function() {
            $(".pg_itd").hide()
        }, 500), $(".pg_itd_close").fadeOut(), a.stopPropagation()
    }), $(document).keyup(function(a) {
        13 == a.keyCode && $("#sell-next").trigger("click")
    }), $("#sell-next").on("click", function() {
        var a = $("#_valnone").text().trim(),
            b = $("#shangpai").text().trim(),
            c = $("._numgongli"),
            d = $("#_select5").text().trim();
        "请 选 择 品 牌 车 系" == a ? $("#_select1").css("border-color", "#FD534C") : "请 选 择 上 牌 年 份" == b ? $("#shangpai").css("border-color", "#FD534C") : 0 == c.val() || 0 == validMobileFormat(c.val()) ? ($("#_select1,#shangpai").css("border-color", "#e6e6e6"), $("#tel").css("border-color", "#FD534C")) : "请 选 择 城 市" == d ? ($("#tel").css("border-color", "#e6e6e6"), $("#_select5").css("border-color", "#FD534C")) : ($("#_select1,#shangpai,#tel,#_select5").css("border-color", "#e6e6e6"), $(".pgr-wrap,.black-mask").fadeIn())
    }), $("._ucarselecttype_pinpaibottom_ul._brand>p").on("click", function() {
        $("#_select1").css("border-color", "#e6e6e6")
    }), $(".close-btn").on("click", function(a) {
        $("#sell_confirm_modal,.black-mask").fadeOut()
    }), $(".black-mask,.pgr-close").click(function() {
        $(".black-mask,.pgr-wrap,#sell_confirm_modal").fadeOut()
    }), $("#get-it").click(function() {
        var a = $("#_valnone").text().trim(),
            b = $("#shangpai").text().trim(),
            c = $("#_select5").text().trim();
        "请 选 择 车 系" == a ? $("#_select1").css("border-color", "#FD534C") : "请 选 择 上 牌 时 间" == b ? $("#shangpai").css("border-color", "#FD534C") : 0 == $("._numgongli").val() ? ($("#_select1").css("border-color", "#e6e6e6"), $("#shangpai").css("border-color", "#e6e6e6"), $("#tel").css("border-color", "#FD534C"), $("._numgongli").val("")) : "请 选 择 城 市" == c ? ($("#tel").css("border-color", "#e6e6e6"), $("#_select5").css("border-color", "#FD534C")) : ($("#_select1").css("border-color", "#e6e6e6"), $("#shangpai").css("border-color", "#e6e6e6"), $("#tel").css("border-color", "#e6e6e6"), $("#_select5").css("border-color", "#e6e6e6"), $(".pgr-wrap").hide(), _cleckinput(1, 1, 1, 1))
    })
}), !
    function(a) {
        "use strict";
        "function" == typeof define && define.amd ? define(["jquery"], a) : a(jQuery)
    }(function(a) {
        "use strict";
        var b = window.Slick || {};
        b = function() {
            function b(b, d) {
                var e, f, g = this;
                if (g.defaults = {
                        accessibility: !0,
                        arrows: !0,
                        autoplay: !1,
                        autoplaySpeed: 3e3,
                        centerMode: !1,
                        centerPadding: "50px",
                        cssEase: "ease",
                        customPaging: function(a, b) {
                            return '<button type="button">' + (b + 1) + "</button>"
                        },
                        dots: !1,
                        draggable: !0,
                        easing: "linear",
                        fade: !1,
                        infinite: !0,
                        lazyLoad: "ondemand",
                        onBeforeChange: null,
                        onAfterChange: null,
                        onInit: null,
                        onReInit: null,
                        pauseOnHover: !0,
                        responsive: null,
                        slide: "div",
                        slidesToShow: 1,
                        slidesToScroll: 1,
                        speed: 300,
                        swipe: !0,
                        touchMove: !0,
                        touchThreshold: 5,
                        vertical: !1
                    }, g.initials = {
                        animating: !1,
                        autoPlayTimer: null,
                        currentSlide: 0,
                        currentLeft: null,
                        direction: 1,
                        $dots: null,
                        listWidth: null,
                        listHeight: null,
                        loadIndex: 0,
                        $nextArrow: null,
                        $prevArrow: null,
                        slideCount: null,
                        slideWidth: null,
                        $slideTrack: null,
                        $slides: null,
                        sliding: !1,
                        slideOffset: 0,
                        swipeLeft: null,
                        $list: null,
                        touchObject: {},
                        transformsEnabled: !1
                    }, a.extend(g, g.initials), g.activeBreakpoint = null, g.animType = null, g.animProp = null, g.breakpoints = [], g.breakpointSettings = [], g.cssTransitions = !1, g.paused = !1, g.positionProp = null, g.$slider = a(b), g.$slidesCache = null, g.transformType = null, g.transitionType = null, g.windowWidth = 0, g.windowTimer = null, g.options = a.extend({}, g.defaults, d), g.originalSettings = g.options, e = g.options.responsive || null, e && e.length > -1) {
                    for (f in e) e.hasOwnProperty(f) && (g.breakpoints.push(e[f].breakpoint), g.breakpointSettings[e[f].breakpoint] = e[f].settings);
                    g.breakpoints.sort(function(a, b) {
                        return b - a
                    })
                }
                g.autoPlay = a.proxy(g.autoPlay, g), g.autoPlayClear = a.proxy(g.autoPlayClear, g), g.changeSlide = a.proxy(g.changeSlide, g), g.setPosition = a.proxy(g.setPosition, g), g.swipeHandler = a.proxy(g.swipeHandler, g), g.dragHandler = a.proxy(g.dragHandler, g), g.keyHandler = a.proxy(g.keyHandler, g), g.autoPlayIterator = a.proxy(g.autoPlayIterator, g), g.instanceUid = c++, g.init()
            }
            var c = 0;
            return b
        }(), b.prototype.addSlide = function(b, c, d) {
            var e = this;
            if ("boolean" == typeof c) d = c, c = null;
            else if (0 > c || c >= e.slideCount) return !1;
            e.unload(), "number" == typeof c ? 0 === c && 0 === e.$slides.length ? a(b).appendTo(e.$slideTrack) : d ? a(b).insertBefore(e.$slides.eq(c)) : a(b).insertAfter(e.$slides.eq(c)) : d === !0 ? a(b).prependTo(e.$slideTrack) : a(b).appendTo(e.$slideTrack), e.$slides = e.$slideTrack.children(this.options.slide), e.$slideTrack.children(this.options.slide).remove(), e.$slideTrack.append(e.$slides), e.$slidesCache = e.$slides, e.reinit()
        }, b.prototype.animateSlide = function(b, c) {
            var d = {},
                e = this;
            e.transformsEnabled === !1 ? e.options.vertical === !1 ? e.$slideTrack.animate({
                left: b
            }, e.options.speed, e.options.easing, c) : e.$slideTrack.animate({
                top: b
            }, e.options.speed, e.options.easing, c) : e.cssTransitions === !1 ? a({
                animStart: e.currentLeft
            }).animate({
                animStart: b
            }, {
                duration: e.options.speed,
                easing: e.options.easing,
                step: function(a) {
                    e.options.vertical === !1 ? (d[e.animType] = "translate(" + a + "px, 0px)", e.$slideTrack.css(d)) : (d[e.animType] = "translate(0px," + a + "px)", e.$slideTrack.css(d))
                },
                complete: function() {
                    c && c.call()
                }
            }) : (e.applyTransition(), d[e.animType] = e.options.vertical === !1 ? "translate3d(" + b + "px, 0px, 0px)" : "translate3d(0px," + b + "px, 0px)", e.$slideTrack.css(d), c && setTimeout(function() {
                e.disableTransition(), c.call()
            }, e.options.speed))
        }, b.prototype.applyTransition = function(a) {
            var b = this,
                c = {};
            c[b.transitionType] = b.options.fade === !1 ? b.transformType + " " + b.options.speed + "ms " + b.options.cssEase : "opacity " + b.options.speed + "ms " + b.options.cssEase, b.options.fade === !1 ? b.$slideTrack.css(c) : b.$slides.eq(a).css(c)
        }, b.prototype.autoPlay = function() {
            var a = this;
            a.autoPlayTimer && clearInterval(a.autoPlayTimer), a.slideCount > a.options.slidesToShow && a.paused !== !0 && (a.autoPlayTimer = setInterval(a.autoPlayIterator, a.options.autoplaySpeed))
        }, b.prototype.autoPlayClear = function() {
            var a = this;
            a.autoPlayTimer && clearInterval(a.autoPlayTimer)
        }, b.prototype.autoPlayIterator = function() {
            var a = this;
            a.options.infinite === !1 ? 1 === a.direction ? (a.currentSlide + 1 === a.slideCount - 1 && (a.direction = 0), a.slideHandler(a.currentSlide + a.options.slidesToScroll)) : (0 === a.currentSlide - 1 && (a.direction = 1), a.slideHandler(a.currentSlide - a.options.slidesToScroll)) : a.slideHandler(a.currentSlide + a.options.slidesToScroll)
        }, b.prototype.buildArrows = function() {
            var b = this;
            b.options.arrows === !0 && b.slideCount > b.options.slidesToShow && (b.$prevArrow = a('<button type="button" class="slick-prev">Previous</button>').appendTo(b.$slider), b.$nextArrow = a('<button type="button" class="slick-next">Next</button>').appendTo(b.$slider), b.options.infinite !== !0 && b.$prevArrow.addClass("slick-disabled"))
        }, b.prototype.buildDots = function() {
            var b, c, d = this;
            if (d.options.dots === !0 && d.slideCount > d.options.slidesToShow) {
                for (c = '<ul class="slick-dots">', b = 0; b <= d.getDotCount(); b += 1) c += "<li>" + d.options.customPaging.call(this, d, b) + "</li>";
                c += "</ul>", d.$dots = a(c).appendTo(d.$slider), d.$dots.find("li").first().addClass("slick-active")
            }
        }, b.prototype.buildOut = function() {
            var b = this;
            b.$slides = b.$slider.children(b.options.slide + ":not(.slick-cloned)").addClass("slick-slide"), b.slideCount = b.$slides.length, b.$slidesCache = b.$slides, b.$slider.addClass("slick-slider"), b.$slideTrack = 0 === b.slideCount ? a('<div class="slick-track"/>').appendTo(b.$slider) : b.$slides.wrapAll('<div class="slick-track"/>').parent(), b.$list = b.$slideTrack.wrap('<div class="slick-list"/>').parent(), b.$slideTrack.css("opacity", 0), b.options.centerMode === !0 && (b.options.infinite = !0, b.options.slidesToScroll = 1, 0 === b.options.slidesToShow % 2 && (b.options.slidesToShow = 3)), a("img[data-lazy]", b.$slider).not("[src]").addClass("slick-loading"), b.setupInfinite(), b.buildArrows(), b.buildDots(), b.options.accessibility === !0 && b.$list.prop("tabIndex", 0), b.setSlideClasses(0), b.options.draggable === !0 && b.$list.addClass("draggable")
        }, b.prototype.checkResponsive = function() {
            var b, c, d = this;
            if (d.originalSettings.responsive && d.originalSettings.responsive.length > -1 && null !== d.originalSettings.responsive) {
                c = null;
                for (b in d.breakpoints) d.breakpoints.hasOwnProperty(b) && a(window).width() < d.breakpoints[b] && (c = d.breakpoints[b]);
                null !== c ? null !== d.activeBreakpoint ? c !== d.activeBreakpoint && (d.activeBreakpoint = c, d.options = a.extend({}, d.defaults, d.breakpointSettings[c]), d.refresh()) : (d.activeBreakpoint = c, d.options = a.extend({}, d.defaults, d.breakpointSettings[c]), d.refresh()) : null !== d.activeBreakpoint && (d.activeBreakpoint = null, d.options = a.extend({}, d.defaults, d.originalSettings), d.refresh())
            }
        }, b.prototype.changeSlide = function(b) {
            var c = this;
            switch (b.data.message) {
                case "previous":
                    c.slideHandler(c.currentSlide - c.options.slidesToScroll);
                    break;
                case "next":
                    c.slideHandler(c.currentSlide + c.options.slidesToScroll);
                    break;
                case "index":
                    c.slideHandler(a(b.target).parent().index() * c.options.slidesToScroll);
                    break;
                default:
                    return !1
            }
        }, b.prototype.destroy = function() {
            var b = this;
            b.autoPlayClear(), b.touchObject = {}, a(".slick-cloned", b.$slider).remove(), b.$dots && b.$dots.remove(), b.$prevArrow && (b.$prevArrow.remove(), b.$nextArrow.remove()), b.$slides.unwrap().unwrap(), b.$slides.removeClass("slick-slide slick-active slick-visible").removeAttr("style"), b.$slider.removeClass("slick-slider"), b.$slider.removeClass("slick-initialized"), b.$list.off(".slick"), a(window).off(".slick-" + b.instanceUid)
        }, b.prototype.disableTransition = function(a) {
            var b = this,
                c = {};
            c[b.transitionType] = "", b.options.fade === !1 ? b.$slideTrack.css(c) : b.$slides.eq(a).css(c)
        }, b.prototype.fadeSlide = function(a, b) {
            var c = this;
            c.cssTransitions === !1 ? (c.$slides.eq(a).css({
                zIndex: 1e3
            }), c.$slides.eq(a).animate({
                opacity: 1
            }, c.options.speed, c.options.easing, b)) : (c.applyTransition(a), c.$slides.eq(a).css({
                opacity: 1,
                zIndex: 1e3
            }), b && setTimeout(function() {
                c.disableTransition(a), b.call()
            }, c.options.speed))
        }, b.prototype.filterSlides = function(a) {
            var b = this;
            null !== a && (b.unload(), b.$slideTrack.children(this.options.slide).remove(), b.$slidesCache.filter(a).appendTo(b.$slideTrack), b.reinit())
        }, b.prototype.getCurrent = function() {
            var a = this;
            return a.currentSlide
        }, b.prototype.getDotCount = function() {
            var a, b = this,
                c = 0,
                d = 0,
                e = 0;
            for (a = b.options.infinite === !0 ? b.slideCount + b.options.slidesToShow - b.options.slidesToScroll : b.slideCount; a > c;) e++, d += b.options.slidesToScroll, c = d + b.options.slidesToShow;
            return e
        }, b.prototype.getLeft = function(a) {
            var b, c = this;
            return c.slideOffset = 0, c.options.infinite === !0 ? (c.slideCount > c.options.slidesToShow && (c.slideOffset = -1 * c.slideWidth * c.options.slidesToShow), 0 !== c.slideCount % c.options.slidesToScroll && a + c.options.slidesToScroll > c.slideCount && c.slideCount > c.options.slidesToShow && (c.slideOffset = -1 * c.slideCount % c.options.slidesToShow * c.slideWidth)) : 0 !== c.slideCount % c.options.slidesToShow && a + c.options.slidesToScroll > c.slideCount && c.slideCount > c.options.slidesToShow && (c.slideOffset = c.slideCount % c.options.slidesToShow * c.slideWidth), c.options.centerMode === !0 && (c.slideOffset += c.slideWidth * Math.floor(c.options.slidesToShow / 2) - c.slideWidth), c.options.vertical === !1 ? b = -1 * a * c.slideWidth + c.slideOffset : (c.listHeight = c.$list.height(), b = c.options.infinite === !0 ? -1 * a * c.listHeight - c.listHeight : -1 * a * c.listHeight), b
        }, b.prototype.init = function() {
            var b = this;
            a(b.$slider).hasClass("slick-initialized") || (a(b.$slider).addClass("slick-initialized"), b.buildOut(), b.setProps(), b.startLoad(), b.loadSlider(), b.initializeEvents(), b.checkResponsive()), null !== b.options.onInit && b.options.onInit.call(this, b)
        }, b.prototype.initArrowEvents = function() {
            var a = this;
            a.options.arrows === !0 && a.slideCount > a.options.slidesToShow && (a.$prevArrow.on("click.slick", {
                message: "previous"
            }, a.changeSlide), a.$nextArrow.on("click.slick", {
                message: "next"
            }, a.changeSlide))
        }, b.prototype.initDotEvents = function() {
            var b = this;
            b.options.dots === !0 && b.slideCount > b.options.slidesToShow && a("li", b.$dots).on("click.slick", {
                message: "index"
            }, b.changeSlide)
        }, b.prototype.initializeEvents = function() {
            var b = this;
            b.initArrowEvents(), b.initDotEvents(), b.$list.on("touchstart.slick mousedown.slick", {
                action: "start"
            }, b.swipeHandler), b.$list.on("touchmove.slick mousemove.slick", {
                action: "move"
            }, b.swipeHandler), b.$list.on("touchend.slick mouseup.slick", {
                action: "end"
            }, b.swipeHandler), b.$list.on("touchcancel.slick mouseleave.slick", {
                action: "end"
            }, b.swipeHandler), b.options.pauseOnHover === !0 && b.options.autoplay === !0 && (b.$list.on("mouseenter.slick", b.autoPlayClear), b.$list.on("mouseleave.slick", b.autoPlay)), b.options.accessibility === !0 && b.$list.on("keydown.slick", b.keyHandler), a(window).on("orientationchange.slick.slick-" + b.instanceUid, function() {
                b.checkResponsive(), b.setPosition()
            }), a(window).on("resize.slick.slick-" + b.instanceUid, function() {
                a(window).width !== b.windowWidth && (clearTimeout(b.windowDelay), b.windowDelay = window.setTimeout(function() {
                    b.windowWidth = a(window).width(), b.checkResponsive(), b.setPosition()
                }, 50))
            }), a(window).on("load.slick.slick-" + b.instanceUid, b.setPosition)
        }, b.prototype.initUI = function() {
            var a = this;
            a.options.arrows === !0 && a.slideCount > a.options.slidesToShow && (a.$prevArrow.show(), a.$nextArrow.show()), a.options.dots === !0 && a.slideCount > a.options.slidesToShow && a.$dots.show(), a.options.autoplay === !0 && a.autoPlay()
        }, b.prototype.keyHandler = function(a) {
            var b = this;
            37 === a.keyCode ? b.changeSlide({
                data: {
                    message: "previous"
                }
            }) : 39 === a.keyCode && b.changeSlide({
                data: {
                    message: "next"
                }
            })
        }, b.prototype.lazyLoad = function() {
            var b, c, d, e, f = this;
            f.options.centerMode === !0 ? (d = f.options.slidesToShow + f.currentSlide - 1, e = d + f.options.slidesToShow + 2) : (d = f.options.infinite ? f.options.slidesToShow + f.currentSlide : f.currentSlide, e = d + f.options.slidesToShow), b = f.$slider.find(".slick-slide").slice(d, e), a("img[data-lazy]", b).not("[src]").each(function() {
                a(this).css({
                    opacity: 0
                }).attr("src", a(this).attr("data-lazy")).removeClass("slick-loading").load(function() {
                    a(this).animate({
                        opacity: 1
                    }, 200)
                })
            }), f.currentSlide >= f.slideCount - f.options.slidesToShow ? (c = f.$slider.find(".slick-cloned").slice(0, f.options.slidesToShow), a("img[data-lazy]", c).not("[src]").each(function() {
                a(this).css({
                    opacity: 0
                }).attr("src", a(this).attr("data-lazy")).removeClass("slick-loading").load(function() {
                    a(this).animate({
                        opacity: 1
                    }, 200)
                })
            })) : 0 === f.currentSlide && (c = f.$slider.find(".slick-cloned").slice(-1 * f.options.slidesToShow), a("img[data-lazy]", c).not("[src]").each(function() {
                a(this).css({
                    opacity: 0
                }).attr("src", a(this).attr("data-lazy")).removeClass("slick-loading").load(function() {
                    a(this).animate({
                        opacity: 1
                    }, 200)
                })
            }))
        }, b.prototype.loadSlider = function() {
            var a = this;
            a.setPosition(), a.$slideTrack.css({
                opacity: 1
            }), a.$slider.removeClass("slick-loading"), a.initUI(), "progressive" === a.options.lazyLoad && a.progressiveLazyLoad()
        }, b.prototype.postSlide = function(a) {
            var b = this;
            null !== b.options.onAfterChange && b.options.onAfterChange.call(this, b, a), b.animating = !1, b.setPosition(), b.swipeLeft = null, b.options.autoplay === !0 && b.paused === !1 && b.autoPlay(), b.setSlideClasses(b.currentSlide)
        }, b.prototype.progressiveLazyLoad = function() {
            var b, c, d = this;
            b = a("img[data-lazy]").not("[src]").length, b > 0 && (c = a(a("img[data-lazy]", d.$slider).not("[src]").get(0)), c.attr("src", c.attr("data-lazy")).removeClass("slick-loading").load(function() {
                d.progressiveLazyLoad()
            }))
        }, b.prototype.refresh = function() {
            var b = this;
            b.destroy(), a.extend(b, b.initials), b.init()
        }, b.prototype.reinit = function() {
            var b = this;
            b.$slides = a(b.options.slide + ":not(.slick-cloned)", b.$slideTrack).addClass("slick-slide"), b.slideCount = b.$slides.length, b.currentSlide >= b.slideCount && 0 !== b.currentSlide && (b.currentSlide = b.currentSlide - b.options.slidesToScroll), b.setProps(), b.setupInfinite(), b.buildArrows(), b.updateArrows(), b.initArrowEvents(), b.buildDots(), b.updateDots(), b.initDotEvents(), b.setSlideClasses(0), b.setPosition(), null !== b.options.onReInit && b.options.onReInit.call(this, b)
        }, b.prototype.removeSlide = function(a, b) {
            var c = this;
            return "boolean" == typeof a ? (b = a, a = b === !0 ? 0 : c.slideCount - 1) : a = b === !0 ? --a : a, !(c.slideCount < 1 || 0 > a || a > c.slideCount - 1) && (c.unload(), c.$slideTrack.children(this.options.slide).eq(a).remove(), c.$slides = c.$slideTrack.children(this.options.slide), c.$slideTrack.children(this.options.slide).remove(), c.$slideTrack.append(c.$slides), c.$slidesCache = c.$slides, void c.reinit())
        }, b.prototype.setCSS = function(a) {
            var b, c, d = this,
                e = {};
            b = "left" == d.positionProp ? a + "px" : "0px", c = "top" == d.positionProp ? a + "px" : "0px", e[d.positionProp] = a, d.transformsEnabled === !1 ? d.$slideTrack.css(e) : (e = {}, d.cssTransitions === !1 ? (e[d.animType] = "translate(" + b + ", " + c + ")", d.$slideTrack.css(e)) : (e[d.animType] = "translate3d(" + b + ", " + c + ", 0px)", d.$slideTrack.css(e)))
        }, b.prototype.setDimensions = function() {
            var a = this;
            a.options.centerMode === !0 ? a.$slideTrack.children(".slick-slide").width(a.slideWidth) : a.$slideTrack.children(".slick-slide").width(a.slideWidth), a.options.vertical === !1 ? (a.$slideTrack.width(Math.ceil(a.slideWidth * a.$slideTrack.children(".slick-slide").length)), a.options.centerMode === !0 && a.$list.css({
                padding: "0px " + a.options.centerPadding
            })) : (a.$list.height(a.$slides.first().outerHeight()), a.$slideTrack.height(Math.ceil(a.listHeight * a.$slideTrack.children(".slick-slide").length)), a.options.centerMode === !0 && a.$list.css({
                padding: a.options.centerPadding + " 0px"
            }))
        }, b.prototype.setFade = function() {
            var b, c = this;
            c.$slides.each(function(d, e) {
                b = -1 * c.slideWidth * d, a(e).css({
                    position: "relative",
                    left: b,
                    top: 0,
                    zIndex: 800,
                    opacity: 0
                })
            }), c.$slides.eq(c.currentSlide).css({
                zIndex: 900,
                opacity: 1
            })
        }, b.prototype.setPosition = function() {
            var a = this;
            a.setValues(), a.setDimensions(), a.options.fade === !1 ? a.setCSS(a.getLeft(a.currentSlide)) : a.setFade()
        }, b.prototype.setProps = function() {
            var a = this;
            a.positionProp = a.options.vertical === !0 ? "top" : "left", "top" === a.positionProp ? a.$slider.addClass("slick-vertical") : a.$slider.removeClass("slick-vertical"), (void 0 !== document.body.style.WebkitTransition || void 0 !== document.body.style.MozTransition || void 0 !== document.body.style.msTransition) && (a.cssTransitions = !0), void 0 !== document.body.style.MozTransform && (a.animType = "MozTransform", a.transformType = "-moz-transform", a.transitionType = "MozTransition"), void 0 !== document.body.style.webkitTransform && (a.animType = "webkitTransform", a.transformType = "-webkit-transform", a.transitionType = "webkitTransition"), void 0 !== document.body.style.msTransform && (a.animType = "transform", a.transformType = "transform", a.transitionType = "transition"), a.transformsEnabled = null !== a.animType
        }, b.prototype.setValues = function() {
            var a = this;
            a.listWidth = a.$list.width(), a.listHeight = a.$list.height(), a.slideWidth = Math.ceil(a.listWidth / a.options.slidesToShow)
        }, b.prototype.setSlideClasses = function(a) {
            var b, c, d, e = this;
            e.$slider.find(".slick-slide").removeClass("slick-active").removeClass("slick-center"), c = e.$slider.find(".slick-slide"), e.options.centerMode === !0 ? (b = Math.floor(e.options.slidesToShow / 2), a >= b && a <= e.slideCount - 1 - b ? e.$slides.slice(a - b, a + b + 1).addClass("slick-active") : (d = e.options.slidesToShow + a, c.slice(d - b + 1, d + b + 2).addClass("slick-active")), 0 === a ? c.eq(c.length - 1 - e.options.slidesToShow).addClass("slick-center") : a === e.slideCount - 1 && c.eq(e.options.slidesToShow).addClass("slick-center"), e.$slides.eq(a).addClass("slick-center")) : a > 0 && a < e.slideCount - e.options.slidesToShow ? e.$slides.slice(a, a + e.options.slidesToShow).addClass("slick-active") : (d = e.options.slidesToShow + a, c.slice(d, d + e.options.slidesToShow).addClass("slick-active")), "ondemand" === e.options.lazyLoad && e.lazyLoad()
        }, b.prototype.setupInfinite = function() {
            var b, c, d, e = this;
            if ((e.options.fade === !0 || e.options.vertical === !0) && (e.options.slidesToShow = 1, e.options.slidesToScroll = 1, e.options.centerMode = !1), e.options.infinite === !0 && e.options.fade === !1 && (c = null, e.slideCount > e.options.slidesToShow)) {
                for (d = e.options.centerMode === !0 ? e.options.slidesToShow + 1 : e.options.slidesToShow, b = e.slideCount; b > e.slideCount - d; b -= 1) c = b - 1, a(e.$slides[c]).clone().attr("id", "").prependTo(e.$slideTrack).addClass("slick-cloned");
                for (b = 0; d > b; b += 1) c = b, a(e.$slides[c]).clone().attr("id", "").appendTo(e.$slideTrack).addClass("slick-cloned");
                e.$slideTrack.find(".slick-cloned").find("[id]").each(function() {
                    a(this).attr("id", "")
                })
            }
        }, b.prototype.slideHandler = function(a) {
            var b, c, d, e, f = null,
                g = this;
            return g.animating !== !0 && (b = a, f = g.getLeft(b), d = g.getLeft(g.currentSlide), e = 0 !== g.slideCount % g.options.slidesToScroll ? g.options.slidesToScroll : 0, g.currentLeft = null === g.swipeLeft ? d : g.swipeLeft, g.options.infinite === !1 && (0 > a || a > g.slideCount - g.options.slidesToShow + e) ? (b = g.currentSlide, g.animateSlide(d, function() {
                    g.postSlide(b)
                }), !1) : (g.options.autoplay === !0 && clearInterval(g.autoPlayTimer), c = 0 > b ? 0 !== g.slideCount % g.options.slidesToScroll ? g.slideCount - g.slideCount % g.options.slidesToScroll : g.slideCount - g.options.slidesToScroll : b > g.slideCount - 1 ? 0 : b, g.animating = !0, null !== g.options.onBeforeChange && a !== g.currentSlide && g.options.onBeforeChange.call(this, g, g.currentSlide, c), g.currentSlide = c, g.updateDots(), g.updateArrows(), g.options.fade === !0 ? (g.fadeSlide(c, function() {
                    g.postSlide(c)
                }), !1) : void g.animateSlide(f, function() {
                    g.postSlide(c)
                })))
        }, b.prototype.startLoad = function() {
            var a = this;
            a.options.arrows === !0 && a.slideCount > a.options.slidesToShow && (a.$prevArrow.hide(), a.$nextArrow.hide()), a.options.dots === !0 && a.slideCount > a.options.slidesToShow && a.$dots.hide(), a.$slider.addClass("slick-loading")
        }, b.prototype.swipeDirection = function() {
            var a, b, c, d, e = this;
            return a = e.touchObject.startX - e.touchObject.curX, b = e.touchObject.startY - e.touchObject.curY, c = Math.atan2(b, a), d = Math.round(180 * c / Math.PI), 0 > d && (d = 360 - Math.abs(d)), 45 >= d && d >= 0 ? "left" : 360 >= d && d >= 315 ? "left" : d >= 135 && 225 >= d ? "right" : "vertical"
        }, b.prototype.swipeEnd = function(b) {
            var c = this;
            if (c.$list.removeClass("dragging"), void 0 === c.touchObject.curX) return !1;
            if (c.touchObject.swipeLength >= c.touchObject.minSwipe) switch (a(b.target).on("click.slick", function(b) {
                b.stopImmediatePropagation(), b.stopPropagation(), b.preventDefault(), a(b.target).off("click.slick")
            }), c.swipeDirection()) {
                case "left":
                    c.slideHandler(c.currentSlide + c.options.slidesToScroll), c.touchObject = {};
                    break;
                case "right":
                    c.slideHandler(c.currentSlide - c.options.slidesToScroll), c.touchObject = {}
            } else c.touchObject.startX !== c.touchObject.curX && (c.slideHandler(c.currentSlide), c.touchObject = {})
        }, b.prototype.swipeHandler = function(a) {
            var b = this;
            if ("ontouchend" in document && b.options.swipe === !1) return !1;
            if (b.options.draggable === !1 && !a.originalEvent.touches) return !1;
            switch (b.touchObject.fingerCount = a.originalEvent && void 0 !== a.originalEvent.touches ? a.originalEvent.touches.length : 1, b.touchObject.minSwipe = b.listWidth / b.options.touchThreshold, a.data.action) {
                case "start":
                    b.swipeStart(a);
                    break;
                case "move":
                    b.swipeMove(a);
                    break;
                case "end":
                    b.swipeEnd(a)
            }
        }, b.prototype.swipeMove = function(a) {
            var b, c, d, e, f = this;
            return e = void 0 !== a.originalEvent ? a.originalEvent.touches : null, b = f.getLeft(f.currentSlide), !(!f.$list.hasClass("dragging") || e && 1 !== e.length) && (f.touchObject.curX = void 0 !== e ? e[0].pageX : a.clientX, f.touchObject.curY = void 0 !== e ? e[0].pageY : a.clientY, f.touchObject.swipeLength = Math.round(Math.sqrt(Math.pow(f.touchObject.curX - f.touchObject.startX, 2))), c = f.swipeDirection(), "vertical" !== c ? (void 0 !== a.originalEvent && f.touchObject.swipeLength > 4 && a.preventDefault(), d = f.touchObject.curX > f.touchObject.startX ? 1 : -1, f.swipeLeft = f.options.vertical === !1 ? b + f.touchObject.swipeLength * d : b + f.touchObject.swipeLength * (f.listHeight / f.listWidth) * d, f.options.fade !== !0 && f.options.touchMove !== !1 && (f.animating === !0 ? (f.swipeLeft = null, !1) : void f.setCSS(f.swipeLeft))) : void 0)
        }, b.prototype.swipeStart = function(a) {
            var b, c = this;
            return 1 !== c.touchObject.fingerCount || c.slideCount <= c.options.slidesToShow ? (c.touchObject = {}, !1) : (void 0 !== a.originalEvent && void 0 !== a.originalEvent.touches && (b = a.originalEvent.touches[0]), c.touchObject.startX = c.touchObject.curX = void 0 !== b ? b.pageX : a.clientX, c.touchObject.startY = c.touchObject.curY = void 0 !== b ? b.pageY : a.clientY, void c.$list.addClass("dragging"))
        }, b.prototype.unfilterSlides = function() {
            var a = this;
            null !== a.$slidesCache && (a.unload(), a.$slideTrack.children(this.options.slide).remove(), a.$slidesCache.appendTo(a.$slideTrack), a.reinit())
        }, b.prototype.unload = function() {
            var b = this;
            a(".slick-cloned", b.$slider).remove(), b.$dots && b.$dots.remove(), b.$prevArrow && (b.$prevArrow.remove(), b.$nextArrow.remove()), b.$slides.removeClass("slick-slide slick-active slick-visible").removeAttr("style")
        }, b.prototype.updateArrows = function() {
            var a = this;
            a.options.arrows === !0 && a.options.infinite !== !0 && a.slideCount > a.options.slidesToShow && (a.$prevArrow.removeClass("slick-disabled"), a.$nextArrow.removeClass("slick-disabled"), 0 === a.currentSlide ? (a.$prevArrow.addClass("slick-disabled"), a.$nextArrow.removeClass("slick-disabled")) : a.currentSlide >= a.slideCount - a.options.slidesToShow && (a.$nextArrow.addClass("slick-disabled"), a.$prevArrow.removeClass("slick-disabled")))
        }, b.prototype.updateDots = function() {
            var a = this;
            null !== a.$dots && (a.$dots.find("li").removeClass("slick-active"), a.$dots.find("li").eq(a.currentSlide / a.options.slidesToScroll).addClass("slick-active"))
        }, a.fn.slick = function(a) {
            var c = this;
            return c.each(function(c, d) {
                d.slick = new b(d, a)
            })
        }, a.fn.slickAdd = function(a, b, c) {
            var d = this;
            return d.each(function(d, e) {
                e.slick.addSlide(a, b, c)
            })
        }, a.fn.slickCurrentSlide = function() {
            var a = this;
            return a.get(0).slick.getCurrent()
        }, a.fn.slickFilter = function(a) {
            var b = this;
            return b.each(function(b, c) {
                c.slick.filterSlides(a)
            })
        }, a.fn.slickGoTo = function(a) {
            var b = this;
            return b.each(function(b, c) {
                c.slick.slideHandler(a)
            })
        }, a.fn.slickNext = function() {
            var a = this;
            return a.each(function(a, b) {
                b.slick.changeSlide({
                    data: {
                        message: "next"
                    }
                })
            })
        }, a.fn.slickPause = function() {
            var a = this;
            return a.each(function(a, b) {
                b.slick.autoPlayClear(), b.slick.paused = !0
            })
        }, a.fn.slickPlay = function() {
            var a = this;
            return a.each(function(a, b) {
                b.slick.paused = !1, b.slick.autoPlay()
            })
        }, a.fn.slickPrev = function() {
            var a = this;
            return a.each(function(a, b) {
                b.slick.changeSlide({
                    data: {
                        message: "previous"
                    }
                })
            })
        }, a.fn.slickRemove = function(a, b) {
            var c = this;
            return c.each(function(c, d) {
                d.slick.removeSlide(a, b)
            })
        }, a.fn.slickSetOption = function(a, b, c) {
            var d = this;
            return d.each(function(d, e) {
                e.slick.options[a] = b, c === !0 && (e.slick.unload(), e.slick.reinit())
            })
        }, a.fn.slickUnfilter = function() {
            var a = this;
            return a.each(function(a, b) {
                b.slick.unfilterSlides()
            })
        }, a.fn.unslick = function() {
            var a = this;
            return a.each(function(a, b) {
                b.slick.destroy()
            })
        }
    });