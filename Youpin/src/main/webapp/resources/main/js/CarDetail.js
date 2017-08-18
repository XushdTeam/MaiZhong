function fnWheel(n) {
    var t = n || event;
    t.preventDefault()
}
var carDetail = {
    _tradeCode: "",
    _wayTag: 4,
    _aId: 0,
    _priceDetailType: 1,
    _ifLogin: !1,
    _cId: 0,
    _userPromise: !1,
    _auctionTag: 1,
    _priceStep: 0,
    _businessId: 0,
    _bidPrice: 0,
    _chkMsg: 0,
    _pCode: "",
    _title: "",
    _bidType: 0,
    _userStep: 0,
    _onceBid: !1,
    _rid: "",
    _brand: "",
    _standard: "",
    _isEnd: !1,
    _wId: 0,
    _ifFocus: !1,
    _loginAnchor: "",
    _loginType: "",
    _ccsRoot: "",
    _subName: [],
    _desaId: "",
    _descId: "",
    _hadOpt: !1,
    _memoirStar: 0,
    _memoirOption: "",
    hadLodBusinessNolocaltag: !1,
    IsSwitching: !1,
    NowPhotoIndex: 0,
    InfoTitleTop: 0,
    CheckTitleTop: 0,
    IsLoadedPhoto: !1,
    AllReportPhotos: {},
    _bazaarYear: "",
    _bazaarPl: "",
    _bazaarBSQ: "",
    _bazaarBrand: "",
    _loadBaraarTimes: 0,
    _combieBrand: ["奥迪", "比亚迪", "标致", "宝马", "宝骏", "长城", "东风小康", "哈弗", "捷豹", "凯迪拉克", "雷克萨斯", "力帆", "陆风", "启辰", "荣威", "沃尔沃", "五菱", "英菲尼迪", "中华"],
    _loadReport: 0,
    _AucStatus: 2,
    Init: function() {
        $("#loginPage").val("carDetail");
        carDetail._AucStatus == "3" && carDetail.GetBidList();
        carDetail.NeedLogin("hadLogin");
        carDetail.Bind();
        carDetail.GetRepair();
        carDetail.GetFocusCount();
        carDetail.GetMemoir();
        carDetail._isEnd || setInterval(carDetail.Countdown, 1e3)
    },
    NeedLogin: function(n) {
        carDetail._loginType = n;
        carDetail.GetCarDetail();
        carDetail._ifLogin ? (carDetail.GetFocus(), carDetail.CloseCarEggs(), carDetail.GetPromotion(), n != "hadLogin" ? (carDetail.GetUserId(), carDetail.GetUserOpt(), layout.CheckOnline()) : carDetail.GetBusinessNolocaltag("load")) : $("#recommend").html().replace(/[\r\n]/g, "").replace(/(^\s*)|(\s*$)/g, "").length != 0 && $(".recommend").show()
    },
    Bind: function() {
        function n() {
            var n = $(window).width();
            n < 1200 ? $(".car-info-top").css({
                width: n,
                "margin-left": -n / 2
            }) : $(".car-info-top").css({
                width: 1200,
                "margin-left": -600
            })
        }

        function t() {
            var n = $(window).width();
            n <= 1024 ? ($(".car-info-state .mipt-box").addClass("mt20"), $(".car-info-state .mintell").addClass("mt20")) : ($(".car-info-state .mipt-box").removeClass("mt20"), $(".car-info-state .mintell").removeClass("mt20"))
        }
        carDetail.InitePriceTxt();
        $("#userSetp").html(carDetail._userStep);
        $("#share").mouseover(function() {
            carDetail.GetWeChatImg()
        });
        $("#share").mouseleave(function() {
            $("#cshareArea").hide()
        });
        $("#getPriceDetail").click(function() {
            $("#priceDetailDialogPopup,#priceDetailDialog").toggle()
        });
        $(".close,.cancel").click(function() {
            var n = $(this).attr("dialog");
            carDetail.CloseDialog(n)
        });
        $(".mbtn_1").click(function() {
            var n = $(this).attr("step");
            carDetail.BidPrice(n, 0, this)
        });
        $(".bidPrice").click(function() {
            carDetail.BidPrice(0, 0, this)
        });
        $("#promise").click(function() {
            carDetail.SetPromise()
        });
        $("#toBidPrice").click(function() {
            carDetail.CloseDialog("bidDialog");
            carDetail._bidType == 2 ? carDetail.ToQuertBid() : carDetail.ToBid(0)
        });
        $(".optiBid").click(function() {
            carDetail.BidPrice(0, 1, this)
        });
        $("#optBid").click(function() {
            carDetail.CloseDialog("optiBidDialog");
            carDetail.ToBid(1)
        });
        n();
        $(window).resize(function() {
            n();
            t()
        });
        $(".car-info-top-tab span").click(function() {
            var n = $(this);
            $(this).addClass("cur").siblings().removeClass("cur");
            $("html,body").animate({
                scrollTop: $(".page-tit-report").eq(n.index()).offset().top - $(".car-info-top").height() - 10
            }, 0)
        });
        $("#memoir").click(function() {
            carDetail.ShowDialog("memoirDialog")
        });
        carDetail.MemoirVerify();
        $("#focusClick").click(function() {
            carDetail.RegLogin("focus") && carDetail.AddFocus()
        });
        $("#subscribeCar").click(function() {
            if (carDetail.RegLogin("subscribe")) {
                var n = $("#subscribeCar").attr("type");
                if (n == "-1") {
                    carDetail.AlertMsg("您的10条订阅已用完");
                    return
                }
                carDetail.ShowDialog("subscribeDialog")
            }
        });
        t();
        $(".car-info-grade-tip").hover(function() {
            $(".tip-con").toggle()
        });
        InfoTitleTop = $("#CarInfoTitle").offset().top;
        $(window).scroll(function() {
            var r, t, n, i;
            if ($(window).scrollTop() > InfoTitleTop) if ($(".car-info-top").show(), r = $("#CarPhotosTitle").offset().top, carDetail.CheckTitleTop = $("#CheckInfoTitle").offset().top, t = $(".car-info-top").height(), $h1 = r - $(window).scrollTop() - t - 15, $h2 = carDetail.CheckTitleTop - $(window).scrollTop() - t - 15, $h1 > 0) for ($(".car-info-top-tab span").eq(0).addClass("cur").siblings().removeClass("cur"), n = 0; n < $(".car-pho").eq(0).find("img").length; n++) i = $(".car-pho").eq(0).find("img").eq(n), $(i).attr("src", $(i).attr("src1"));
            else $h1 < 0 && $h2 > 0 ? $(".car-info-top-tab span").eq(1).addClass("cur").siblings().removeClass("cur") : $h2 < 0 && $(".car-info-top-tab span").eq(2).addClass("cur").siblings().removeClass("cur");
            else $(".car-info-top").hide()
        });
        $(".page-tab li").click(function() {
            carDetail.PhotoSwitch($(this).index())
        });
        $(".car-info-zoom .car-sm ul").on("click", "li", function() {
            var n = Math.abs($(this).index() - carDetail.NowPhotoIndex) < 2 ? !0 : !1;
            carDetail.NowPhotoIndex = $(this).index();
            carDetail.ImgTabSwitch(n)
        });
        $(".car-info-zoom .next").click(function() {
            carDetail.IsSwitching || (carDetail.NowPhotoIndex++, carDetail.IsSwitching = !0, carDetail.ImgTabSwitch(!0))
        });
        $(".car-info-zoom .prev").click(function() {
            carDetail.IsSwitching || (carDetail.NowPhotoIndex--, carDetail.IsSwitching = !0, carDetail.ImgTabSwitch(!0))
        });
        document.onkeydown = function(n) {
            var t = n || window.event || arguments.callee.caller.arguments[0];
            t && t.keyCode == 27 && carDetail.CloseDialog("BigPictureDialog");
            t && t.keyCode == 37 && $(".car-info-zoom .prev").click();
            t && t.keyCode == 39 && $(".car-info-zoom .next").click()
        };
        $(".memoirStarList i").mouseover(function() {
            var n = $(this).attr("num");
            carDetail.MemoirStarSelect(n);
            carDetail._memoirStar = n
        });
        $(".help_csxy").click(function() {
            $(".ask").toggleClass("show")
        });
        $("#btnQuote").click(function() {
            carDetail.BidPrice(0, 2, this)
        });
        $("#btnQuote1").click(function() {
            carDetail.BidPrice(0, 2, this)
        })
    },
    RegLogin: function(n) {
        return carDetail._ifLogin ? !0 : (carDetail._loginAnchor = n, carDetail.LoginDialog(), !1)
    },
    GetUserId: function() {
        $.ajax({
            type: "post",
            url: "/AjaxCarDetail/GetUserId",
            dataType: "json",
            cache: !1,
            success: function(n) {
                var t;
                if (n.result) {
                    t = n.model;
                    carDetail._businessId = t.UserId;
                    carDetail._userStep = t.MixBidStep;
                    $("#userSetp").html(carDetail._userStep);
                    $(".bidStepList").html("");
                    $("#PriceStepTemp").tmpl(t.PriceStep).appendTo(".bidStepList");
                    $(".mbtn_1").click(function() {
                        var n = $(this).attr("step");
                        carDetail.BidPrice(n, 0, this)
                    });
                    carDetail._businessId == carDetail._wId && ($(".onceBid").html("我是最高价"), $(".onceBidTr").show());
                    $(".topLoginName").html(t.LoginName);
                    $(".topUserName").html(t.UserName);
                    $(".topHeadImg").attr("src", t.HeadImg);
                    $("#memoirPhone").val(t.Mobile).removeClass("hui");
                    var r = t.BuyerLevel,
                        f = t.UserType,
                        i = carDetail._ccsRoot,
                        u = "";
                    u = r == 2 ? " <img src='" + i + "/Content/Common/images/V2.gif' alt='VIP2' class='ml5' />" : r == 1 ? " <img src='" + i + "/Content/Common/images/V1.png' alt='VIP1' class='ml5' />" : " <img src='" + i + "/Content/Common/images/VP.gif' alt='普通商户' class='ml5' />";
                    $(".topUserTag").html(u);
                    $("#topUserMsg").show();
                    $(".top_in").hide();
                    carDetail._AucStatus == "3" && carDetail.GetBidList()
                } else carDetail.LoginDialog()
            }
        })
    },
    GetUserOpt: function() {
        $.ajax({
            type: "post",
            url: "/AjaxCarDetail/GetOptimization",
            dataType: "json",
            cache: !1,
            data: {
                aId: carDetail._aId
            },
            success: function(n) {
                if (n.result) {
                    var t = n.data;
                    t.ShowMyOptimizationOffer && ($(".optiBid").removeClass("mintell_1").unbind(), $(".optiOfferDesc").html(t.MyOptimizationOfferDesc).attr("optpirce", t.MyOptimizationOffer), t.CustomizationTag ? $(".sendMsg").attr("checked", !0) : $(".sendMsg").attr("checked", !1), $(".optArea").show(), $(".bidArea").hide(), carDetail._hadOpt = !0);
                    carDetail.GetBusinessNolocaltag("load")
                } else carDetail.LoginDialog()
            }
        })
    },
    GetCarDetail: function() {
        $.ajax({
            type: "post",
            url: "/AjaxCarDetail/GetCarDetail",
            dataType: "json",
            cache: !1,
            data: {
                cId: carDetail._descId
            },
            success: function(n) {
                var i, t;
                n != null && (carDetail._tradeCode = n.TradeCode, carDetail._wayTag = n.WayTag, $(".carName").html(n.CarName).attr("title", n.CarName), document.title = "【二手车_" + n.CarName + "】- 车易拍在线交易系统", carDetail._title = document.title, $(".regDate").html(n.CarRegDate), $(".mileage").html(n.Mileage + "万公里"), $(".pf").html(n.PaiFangDesc), $("#rak").html(n.Rank), $(".licenseSimple").html(n.LicenseSimple), $(".brand").html(n.Brand), $(".serName").html(n.SeriesName), i = $("#rName").html() + " " + n.PaiFangDesc + " " + n.Brand, i.length > 10 && (i = $("#rName").html() + " " + n.Brand), $("#subsribeName").val(i), carDetail._brand = n.Brand, carDetail._standard = n.EmissionStandard, carDetail._bazaarYear = n.CarRegDate.substr(0, 4), t = n.CountryName != null ? n.CountryName : "", t = t != "" && $.trim(t) != "中国" ? "(进口)" : "", carDetail._bazaarBrand = $.inArray(n.Brand, carDetail._combieBrand) >= 0 ? n.Brand == "标致" ? n.Brand + n.SeriesName.replace("两厢", "").replace("三厢", "") + t : n.Brand + n.SeriesName + t : n.SeriesName + t, carDetail._ifLogin && (carDetail.GetSubscribe(), carDetail.SubscribeReg()), carDetail._loadReport == 0 && carDetail.GetCarReport())
            }
        })
    },
    GetFocus: function() {
        $.ajax({
            type: "post",
            url: "/AjaxCarDetail/GetFocus",
            dataType: "json",
            cache: !1,
            data: {
                productCode: carDetail._pCode
            },
            success: function(n) {
                n ? (carDetail._ifFocus = !0, $("#addFocus").html("已关注")) : carDetail._loginType != "hadLogin" && carDetail._loginAnchor == "focus" && carDetail.AddFocus()
            }
        })
    },
    GetSubscribe: function() {
        $.ajax({
            type: "post",
            url: "/AjaxCustomization/GetIsSubscription",
            dataType: "json",
            cache: !1,
            data: {
                brand: carDetail._brand,
                seriesName: "",
                orid: carDetail._rid,
                emissionStandard: carDetail._standard
            },
            success: function(n) {
                $("#subscribeCar").attr("type", n.Flag);
                var t = n.Flag;
                if (carDetail._subName = n.Names, t == 1) $("#subscribeCar").html("已订阅相似车辆"), $("#subscribeCar").unbind();
                else if ($("#subscribeCar").html("订阅相似车辆"), carDetail._loginType != "hadLogin" && carDetail._loginAnchor == "subscribe") {
                    if (t == -1) {
                        carDetail.AlertMsg("您的10条订阅已用完");
                        return
                    }
                    carDetail.ShowDialog("subscribeDialog")
                }
            }
        })
    },
    SubscribeReg: function() {
        $("#subsribeName").blur(function() {
            var n = $("#subsribeName").val(),
                t;
            n == "" ? $("#subscribeMsg").html("订阅名称不能为空") : $("#subscribeMsg").html("");
            t = /^[0-9a-zA-Z一-龥\s\-]{1,10}$/g;
            t.test(n) ? $("#subscribeMsg").html("") : $("#subscribeMsg").html(" 订阅名称仅支持输入汉字、数字、英文与空格")
        })
    },
    Subscribe: function() {
        var n, t;
        if (!carDetail.HasLogin()) {
            carDetail.LoginDialog();
            return
        }
        if (n = $("#subsribeName").val(), n == "") {
            $("#subscribeMsg").html("订阅名称不能为空");
            return
        }
        if ($("#subscribeMsg").html(""), carDetail._subName.toString().indexOf($("#subsribeName").val()) > -1) {
            carDetail.TipMsg("您的订阅名称已存在");
            return
        }
        if (t = /^[0-9a-zA-Z一-龥\s\-]{1,10}$/g, t.test(n)) $("#subscribeMsg").html("");
        else {
            $("#subscribeMsg").html(" 订阅名称仅支持输入汉字、数字、英文与空格");
            return
        }
        $.ajax({
            type: "post",
            url: "/AjaxCustomization/AddCustomization",
            dataType: "json",
            cache: !1,
            data: {
                customization: n,
                brand: carDetail._brand,
                rankA: "",
                rankB: "",
                carLocation: carDetail._rid,
                years: "",
                regarea: "",
                emissionStandard: carDetail._standard
            },
            success: function(n) {
                carDetail.CloseDialog("subscribeDialog");
                n == 1 ? (carDetail.TipMsg("订阅成功"), $("#subscribeCar").html("已订阅相似车辆"), $("#subscribeCar").unbind()) : carDetail.TipMsg("订阅失败")
            }
        })
    },
    GetBidList: function() {
        $.ajax({
            type: "post",
            url: "/AjaxCarDetail/GetBidList",
            dataType: "json",
            cache: !1,
            data: {
                id: carDetail._desaId
            },
            success: function(n) {
                var i, t, r;
                if ($("#bidList").html(""), n != null) {
                    for ($("#bidCount").html(n.TotalCount), i = $(window).width(), t = 0; t < n.Items.length; t++) n.Items[t].CurrentBusinessId = carDetail._businessId, i <= 1024 && (n.Items[t].UserLocation = n.Items[t].UserLocation.replace("车商", ""));
                    n.Items.length > 0 && (r = $("#onceBid").html(), n.Items[0].OnceBid > 0 && r.indexOf("我是最高价") == -1 && ($(".onceBid").html("出价被超越"), $(".onceBidTr").show()), n.Items[0].OnceBid > 0 && (carDetail._onceBid = !0));
                    $("#bidList").append($("#bidTemp").tmpl(n.Items));
                    carDetail.BidListRoll()
                }
                carDetail._ifLogin && carDetail.GetUserLocation()
            }
        })
    },
    BidListRoll: function() {
        function o(i) {
            var i = i || event;
            return h(i, function() {
                n += 5;
                n >= r && (n = r);
                t.style.top = n + "px";
                u.style.top = n / r * f + "px"
            }, function() {
                n -= 5;
                n <= 0 && (n = 0);
                t.style.top = n + "px";
                u.style.top = n / r * f + "px"
            }), i.preventDefault && i.preventDefault(), !1
        }

        function h(n, t, i) {
            var r = !0;
            r = n.wheelDelta ? n.wheelDelta > 0 ? !1 : !0 : n.detail > 0 ? !0 : !1;
            r ? typeof t == "function" && t() : typeof i == "function" && i()
        }
        var t = document.getElementById("sidebar"),
            i = document.getElementById("bidListDiv"),
            u = document.getElementById("bidList"),
            f = i.clientHeight - u.scrollHeight,
            n = 0,
            e = document.getElementById("bar"),
            s, r;
        i.clientHeight - u.scrollHeight > 0 ? (u.style.right = 0, t.style.display = e.style.display = "none", i.onmousewheel = null, i.addEventListener && i.removeEventListener("DOMMouseScroll", o, !1)) : (s = i.clientHeight / u.scrollHeight, t.style.height = s * i.clientHeight + "px", u.style.right = "20px", t.style.display = e.style.display = "block", i.onmousewheel = o, i.addEventListener && i.addEventListener("DOMMouseScroll", o, !1));
        r = i.clientHeight - t.offsetHeight;
        t.onmousedown = function(i) {
            var i = i || event,
                e = i.clientY - t.offsetTop;
            return document.onmousemove = function(i) {
                var i = i || event,
                    o, s;
                n = i.clientY - e;
                n <= 0 && (n = 0);
                n >= r && (n = r);
                t.style.top = n + "px";
                o = n / r;
                s = o * f;
                u.style.top = s + "px"
            }, document.onmouseup = function() {
                document.onmousemove = document.onmouseup = null
            }, !1
        };
        e.onclick = function(i) {
            var i = i || event,
                e = i.clientY;
            n = e - t.offsetHeight / 2;
            t.style.top = n + "px";
            n <= 0 && (n = 0);
            n >= r && (n = r);
            t.style.top = n + "px";
            u.style.top = n / r * f + "px"
        }
    },
    GetBusinessNolocaltag: function(n) {
        if (!carDetail.HasLogin()) {
            carDetail.LoginDialog();
            return
        }
        $.ajax({
            type: "post",
            url: "/AjaxCarDetail/GetBusnessNolocalTag",
            dataType: "json",
            cache: !1,
            data: {
                aucid: carDetail._aId,
                auctionTag: carDetail._auctionTag
            },
            success: function(t) {
                t != null && (carDetail.hadLodBusinessNolocaltag = !0, carDetail._userPromise = t, n == "bid" && (t ? carDetail.AlertBidDialog() : carDetail.ShowDialog("promiseDialog")), carDetail._loginType != "hadLogin" && carDetail._loginAnchor == "bid" && n == "load" && (t ? carDetail._hadOpt || carDetail.AlertBidDialog() : carDetail.ShowDialog("promiseDialog")))
            }
        })
    },
    GetPriceDetail: function() {
        $.ajax({
            type: "post",
            url: "/AjaxCarDetail/GetAuctionCost",
            dataType: "json",
            cache: !1,
            data: {
                aId: carDetail._desaId,
                type: carDetail._priceDetailType
            },
            success: function(n) {
                $("#priceFinalOfferName").html(n.FinalOfferName);
                $("#priceFinalOffer").html(n.FinalOfferDesc);
                $("#priceOfferName").html(n.PriorityOfferName);
                $("#priceOffer").html(n.PriorityOffer);
                $("#priceCommissionName").html(n.CommissionName);
                $("#priceCommission").html(n.Commission);
                $("#priceCostMsg").html(n.CostMsg);
                $("#priceCommissionAName").html(n.CommissionAddAName);
                $("#priceCommissionA").html(n.CommissionAddA);
                carDetail.ShowDialog("priceDetailDialog")
            }
        })
    },
    GetFocusCount: function() {
        $.ajax({
            type: "post",
            url: "/AjaxNewAuctionCenter/GetFocusCount",
            dataType: "json",
            cache: !1,
            data: {
                proCode: carDetail._pCode
            },
            success: function(n) {
                n != null && n.length > 0 && ($("#showFocusCount").show(), $("#focusCount").html(n[0].FocusCount))
            }
        })
    },
    Memoir: function() {
        var i = $(".report-btn-cur"),
            r, n, t, u, f;
        if (!(i.length <= 0)) {
            for (r = "", n = 0; n < i.length; n++) r += n == i.length - 1 ? $(i[n]).attr("mid") : $(i[n]).attr("mid") + ",";
            if (t = $("#memoirPhone").val(), t == "输入手机号，以便客服联系(选填)" && (t = ""), t != "" && (u = /^1\d{10}$/, !u.test(t))) {
                $("#memoirPhoneMsg").html("手机号不正确，请重新输入");
                return
            }
            f = $("#memoirTex").val();
            $.ajax({
                type: "post",
                url: "/AjaxCarDetail/SubmitMemoir",
                dataType: "json",
                cache: !1,
                data: {
                    itemId: r,
                    aucId: carDetail._aId,
                    carId: carDetail._cId,
                    description: f,
                    productCode: carDetail._pCode,
                    phone: t,
                    starNum: carDetail._memoirStar
                },
                success: function() {
                    carDetail.CloseDialog("memoirDialog");
                    carDetail.TipMsg("提交成功");
                    $("#memoirSubmit").unbind();
                    $("#memoirSubmit").removeClass("test-btn-cur");
                    $(".report-btn").removeClass("report-btn-cur");
                    $("#memoirTex").val("点评一下车辆或报告吧，您的意见很重要（选填）").addClass("hui");
                    $("#memoirNum").text(0);
                    carDetail.MemoirStarSelect(0)
                }
            })
        }
    },
    GetMemoir: function() {
        $.ajax({
            type: "post",
            url: "/AjaxCarDetail/GetReportItems",
            dataType: "json",
            cache: !1,
            success: function(n) {
                n != null && (carDetail._memoirOption = n)
            }
        })
    },
    MemoirStarSelect: function(n) {
        n = parseInt(n);
        $(".memoirStarList i").each(function() {
            $(this).attr("num") <= n ? $(this).addClass("cur") : $(this).removeClass("cur")
        });
        var t = $.Enumerable.From(carDetail._memoirOption).Where(function(t) {
            return t.EvaluationStars == n
        }).ToArray();
        $("#memoirList").html("");
        t.length > 0 && ($("#MemoirTemp").tmpl(t).appendTo("#memoirList"), $(".starDescribe").html(t[0].StarsDescription));
        $("#memoirSubmit").unbind();
        $("#memoirSubmit").removeClass("test-btn-cur");
        carDetail.MemoirOptionClick()
    },
    MemoirOptionClick: function() {
        $(".report-btn").click(function() {
            var t = $(".report-btn-cur").length,
                n;
            t == 0 && ($("#memoirSubmit").bind("click", function() {
                carDetail.Memoir()
            }), $("#memoirSubmit").addClass("test-btn-cur"));
            $(this).hasClass("report-btn-cur") ? $(this).removeClass("report-btn-cur") : $(this).addClass("report-btn-cur");
            n = $(".report-btn-cur").length;
            n == 0 && ($("#memoirSubmit").unbind(), $("#memoirSubmit").removeClass("test-btn-cur"))
        })
    },
    MemoirVerify: function() {
        var n = "点评一下车辆或报告吧，您的意见很重要（选填）";
        $("#memoirTex").focus(function() {
            var t = $(this).val();
            if (t == n) return $(this).val("").removeClass("hui"), !1
        }).blur(function() {
            var t = $(this).val();
            if (t == "") return $(this).val(n).addClass("hui"), !1
        }).keydown(function() {
            carDetail.MemoirWords()
        }).keyup(function() {
            carDetail.MemoirWords()
        });
        $("#memoirPhone").blur(function() {
            var n = $("#memoirPhone").val(),
                t;
            n == "输入手机号，以便客服联系(选填)" && (n = "");
            n != "" ? (t = /^1\d{10}$/, t.test(n) ? $("#memoirPhoneMsg").html("") : $("#memoirPhoneMsg").html("手机号不正确，请重新输入")) : ($("#memoirPhoneMsg").html(""), $("#memoirPhone").val("输入手机号，以便客服联系(选填)").addClass("hui"))
        });
        $("#memoirPhone").focus(function() {
            var n = $("#memoirPhone").val();
            n == "输入手机号，以便客服联系(选填)" && $("#memoirPhone").val("").removeClass("hui")
        })
    },
    MemoirWords: function() {
        var t = $("#memoirTex").val(),
            n = t.length;
        n > 200 ? ($("#memoirTex").val(t.substring(0, 200)), n > 200 && (n = 200), $("#memoirNum").text(n)) : $("#memoirNum").text(n)
    },
    GetRepair: function() {
        $.ajax({
            type: "post",
            url: "/AjaxRepair/getReportUrlById",
            dataType: "json",
            cache: !1,
            data: {
                carid: carDetail._cId
            },
            success: function(n) {
                if (n != null && n.isExist) {
                    $("#repairSearch").attr("href", n.newReportUrl);
                    $("#repairSearch").css("display", "inline-block");
                    $(".repairUrl").attr("href", n.newReportUrl);
                    $(".repairCount").html(n.reportCounts);
                    n.odometerCount != "" ? $(".repairMileage").html(n.odometerCount) : $(".repairMileageSpan").remove();
                    n.lastTimeToShop != "" ? $(".repairYear").html(n.lastTimeToShop) : $(".repairYearSpan").remove();
                    try {
                        n.partsInfoList != null && n.partsInfoList.length > 0 && n.partsInfoList[0].partStatus != null ? $(".repairList").append($("#RepairTmpl").tmpl(n.partsInfoList)) : $(".repairList").remove()
                    } catch (t) {
                        $(".repairList").remove()
                    }
                    $("#repairArea").show()
                }
            }
        })
    },
    GetWeChatImg: function() {
        var n = $("#shareImg").attr("load");
        if (n == 1) {
            $("#cshareArea").show();
            return
        }
        $.ajax({
            type: "post",
            url: "/Ajax/GetWeChatImg",
            cache: !1,
            data: {
                tradeCode: carDetail._tradeCode,
                wayTag: carDetail._wayTag
            },
            success: function(n) {
                n != null && ($("#shareImg").attr("src", n).attr("load", "1"), $("#cshareArea").show())
            }
        })
    },
    CloseDialog: function(n) {
        $("#" + n + "Popup").hide();
        $("#" + n).hide()
    },
    ShowDialog: function(n) {
        $("#BigPictureDialogPopup").show();
        $("#BigPictureDialog").show()
    },
    GetUserLocation: function() {
        $.ajax({
            type: "post",
            url: "/AjaxCarDetail/GetUserLocation",
            dataType: "json",
            cache: !1,
            success: function(n) {
                n != null && ($(".ulocation").html(n.Location), $("#locationMsg").removeClass("hide"), n.IfShow ? ($("#userLocation,.ulocation").html(n.Location), carDetail._onceBid && ($("#bidListDiv").height("74px"), $("#userLocationp").show())) : $("#userLocationp").html(""), carDetail.GetBazaarCar())
            }
        })
    },
    GetBazaarCar: function() {
        var t, n;
        if (carDetail._bazaarPl != "" && carDetail._bazaarBSQ != "" && (!carDetail._ifLogin || carDetail._ifLogin && carDetail._loadBaraarTimes == 0)) {
            if (t = carDetail._bazaarYear + "年上牌&nbsp;&nbsp;&nbsp;" + carDetail._bazaarBrand + "&nbsp;&nbsp;&nbsp;" + carDetail._bazaarPl + "&nbsp;&nbsp;&nbsp;" + carDetail._bazaarBSQ, $("#bazaarKey").html(t), n = $("#ulocation").html(), carDetail._ifLogin && $.trim(n) == "") return;
            carDetail._ifLogin && (carDetail._loadBaraarTimes = 1);
            $.ajax({
                type: "post",
                url: "/AjaxBazaar/GetMarketResultModelList",
                data: {
                    carSite: $("#rName").html(),
                    businessSite: n,
                    buyDate: carDetail._bazaarYear,
                    gear: carDetail._bazaarBSQ,
                    brand: carDetail._bazaarBrand,
                    displacement: carDetail._bazaarPl
                },
                dataType: "json",
                cache: !1,
                success: function(n) {
                    if ($("#BazaarCar").html(""), n != null && n.Items.length > 0) {
                        $(".lsdy,.page-tit").removeClass("hide");
                        $("#BazaarCarTmpl").tmpl(n.Items).appendTo("#BazaarCar");
                        var t = $("#BazaarCar tr:eq(0) td:last").html(),
                            i = carDetail._bazaarPl + " " + carDetail._bazaarBSQ,
                            r = "/Bazaar/SearchResult?Key=" + carDetail._bazaarBrand + "&CurrCity=" + t + "&GearCC=" + i + "&brand=" + carDetail._bazaarBrand;
                        $("#toBazaarUrl").attr("href", r)
                    } else $(".lsdy").addClass("hide")
                }
            })
        }
    },
    SetPromise: function() {
        if (!carDetail.HasLogin()) {
            carDetail.LoginDialog();
            return
        }
        var n = $(".promise").attr("tag");
        $.ajax({
            cache: !1,
            url: "/AjaxAuctionCenter/SetBidPolicy",
            data: {
                aucId: carDetail._aId,
                tag: n
            },
            type: "POST",
            async: !0,
            success: function(n) {
                n.Success && (carDetail._userPromise = !0, carDetail.CloseDialog("promiseDialog"), carDetail.AlertBidDialog())
            }
        })
    },
    GetPromotion: function() {
        $.ajax({
            cache: !1,
            url: "/AjaxAuctionCenter/GetPromotionInfo",
            data: {
                aucIds: carDetail._aId
            },
            type: "POST",
            success: function(n) {
                var t = !1;
                n != null && n.length > 0 && carDetail._businessId == n[0].UId && (t = !0, $(".promotionMsg").html(n[0].Content).attr("promotion", n[0].Promotion), $("#promotionTitle").html(n[0].Content), $(".promotionMsg").show(), $(".promotionTd").show());
                t ? $(".recommend").html("立减").show() : $("#recommend").html().replace(/[\r\n]/g, "").replace(/(^\s*)|(\s*$)/g, "").length != 0 && $(".recommend").show()
            }
        })
    },
    Countdown: function() {
        var r;
        try {
            if (r = $("#leftTime").html(), r.length > 0) {
                var u = r.split(":"),
                    i = parseInt(u[0], 10),
                    n = parseInt(u[1], 10),
                    t = parseInt(u[2], 10);
                if (i <= 0 && n <= 0 && t <= 0) carDetail._isEnd || carDetail.SyncTime();
                else {
                    t = t - 1;
                    t < 0 && (t = 59, n = n - 1, n < 0 && (n = 59, i = i - 1));
                    i == 0 && n <= 0 && t <= 10 ? $(".leftTime").attr("class").indexOf("ccheng") < 0 && $(".leftTime").addClass("ccheng") : (i != 0 || n != 0 || t > 10) && $(".leftTime").attr("class").indexOf("ccheng") > -1 && $(".leftTime").removeClass("ccheng");
                    var f = i.toString().length == 1 ? "0" + i : i,
                        e = n.toString().length == 1 ? "0" + n : n,
                        o = t.toString().length == 1 ? "0" + t : t;
                    r = f + ":" + e + ":" + o;
                    $(".leftTime").html(r)
                }
            }
        } catch (s) {}
    },
    SyncTime: function() {
        $.ajax({
            cache: !1,
            url: "/AjaxAuctionCenter/SyncTime",
            data: {
                aucId: carDetail._aId
            },
            type: "POST",
            async: !0,
            success: function(n) {
                try {
                    n.H == "00" && n.M == "00" && n.S == "00" ? ($(".leftTime").html("00:00:00"), $(".auctionEnd").show(), $(".bidArea").hide(), $(".optArea").hide(), carDetail._isEnd = !0, carDetail._priceDetailType = 2) : $(".leftTime").html(n.H + ":" + n.M + ":" + n.S)
                } catch (t) {}
            }
        })
    },
    InitePriceTxt: function() {
        $(".bidbox").live("mouseover", function() {
            try {
                $(this).is(":focus") || $(this).focus()
            } catch (n) {}
        });
        $(".bidbox").live("keydown", function(n) {
            try {
                n.keyCode > 47 && n.keyCode < 58 || n.keyCode > 95 && n.keyCode < 106 ? $(this).attr("position", parseInt($(this).attr("position")) + 1) : n.keyCode == 8 ? $(this).attr("position", $(this).attr("position") - 1) : n.keyCode == 46 || n.keyCode == 37 || n.keyCode == 39 || n.preventDefault();
                var t = $(this).val();
                if (t == "") return
            } catch (i) {}
        });
        $(".bidbox").live("keyup", function() {
            var n = 0,
                t = $(this).val();
            if (t == "") {
                $(".mipt-tip").hide();
                return
            }
            try {
                n = parseInt(t);
                isNaN(n) && (n = 0)
            } catch (e) {
                n = 0
            }
            var u = carDetail._AucStatus,
                f = parseInt($("#finalOffer").attr("finalOffer")),
                i = parseInt($("#finalOffer").attr("finalOffer")),
                r = new RegExp(/[0-9]*00$/);
            if (u == "3") if (r.test(n)) if (n <= i) carDetail.BidTxtTip("您的出价必须高于当前价");
            else {
                if (n < f + parseInt(carDetail._userStep)) {
                    carDetail.BidTxtTip("未达到最低加价幅度，请重新出价");
                    return
                }
                $(".mipt-tip").hide()
            } else carDetail.BidTxtTip("请输入整百的数字");
            else r.test(n) ? n <= i ? carDetail.BidTxtTip("您的出价必须高于当前价") : $(".mipt-tip").hide() : carDetail.BidTxtTip("请输入整百的数字")
        });
        $(".bidbox").live("blur", function(n) {
            try {
                if (this.value == "" || this.value == this.getAttribute("emptyText")) this.value = this.getAttribute("emptyText"), this.value = "请输入出价金额", $(this).addClass("hui");
                else {
                    var t = $(this).val();
                    $(this).val(formatMoney(t))
                }
                n.preventDefault()
            } catch (i) {}
        });
        $(".bidbox").live("focus", function() {
            try {
                this.style.color = "#000";
                this.value == this.getAttribute("emptyText") || this.value == "请输入出价金额" ? (this.value = "", $(this).removeClass("hui")) : $(this).val(formatMoneyReplace($(this).val()))
            } catch (n) {}
        })
    },
    BidTxtTip: function(n) {
        $(".mipt-tip").show();
        $(".mipTip").html(n)
    },
    BidPrice: function(n, t, i) {
        var u = parseInt($("#finalOffer").attr("finalOffer")),
            e = 0,
            f, r, o;
        if (n > 0) e = u + parseInt(n);
        else {
            if (f = $(i).parent().find(".bidbox").val(), (f == "" || f == "请输入出价金额") && (f = 0), r = formatMoneyReplace(f), o = new RegExp(/[0-9]*00$/), t == 2) if (o.test(r)) {
                if (r <= u) {
                    carDetail.BidTxtTip("您的出价必须高于当前价");
                    return
                }
                $(".mipt-tip").hide()
            } else {
                carDetail.BidTxtTip("请输入整百的数字");
                return
            } else if (o.test(r)) {
                if (r <= u) {
                    carDetail.BidTxtTip("您的出价必须高于当前价");
                    return
                }
                if (r < u + parseInt(carDetail._userStep)) {
                    carDetail.BidTxtTip("未达到最低加价幅度，请重新出价");
                    return
                }
                $(".mipt-tip").hide()
            } else {
                carDetail.BidTxtTip("请输入整百的数字");
                return
            }
            e = r;
            n = r - u
        }(carDetail._priceStep = n, carDetail._bidPrice = e, carDetail._bidType = t, carDetail.RegLogin("bid")) && (carDetail._userPromise ? carDetail.AlertBidDialog() : carDetail.hadLodBusinessNolocaltag ? carDetail.ShowDialog("promiseDialog") : carDetail.GetBusinessNolocaltag("bid"))
    },
    AlertBidDialog: function() {
        var n = parseInt($("#finalOffer").attr("finalOffer")),
            t = carDetail._priceStep;
        carDetail._bidType == 0 || carDetail._bidType == 2 ? ($("#bidFinalOffer").html(FormatMoneyTwo(carDetail._bidPrice)), $("#bidFinalOfferDesc").html(n + "+" + t), carDetail.ShowDialog("bidDialog")) : ($("#optPrice").html(FormatMoneyTwo(carDetail._bidPrice)), $("#optPriceDesc").html(n + "+" + t), carDetail.ShowDialog("optiBidDialog"))
    },
    ToBid: function(n) {
        if (!carDetail.HasLogin()) {
            carDetail.LoginDialog();
            return
        }
        var t = carDetail._aId,
            i = carDetail._bidPrice;
        $.ajax({
            cache: !1,
            url: "/AjaxAuctionCenter/Bid",
            data: {
                aucId: t,
                price: i,
                priceStep: carDetail._priceStep,
                bidType: n,
                FingerCde: GetFingerCde()
            },
            type: "POST",
            async: !0,
            success: function(t) {
                var i, r, u;
                t.Success ? ($(".bidbox").val() != "请输入出价金额" && $(".bidbox").val("请输入出价金额").addClass("hui"), $("#userLocationp").html() != "" && ($("#userLocationp").show(), $("#bidListDiv").height("74px")), i = "出价", n == 1 && (i = "报价"), r = "<div style='text-align:center;'><img src='/images/CarDetail/suc.png' class='vm' /><span style='font-size:18px;font-weight:bold;margin-left:8px;' class='vm'> " + i + "成功!<\/p><\/div>", carDetail.TipMsg(r), t.EPreferential > 0 && ($("#eggsFavorable").html(t.EPreferential), carDetail.ShowCarEggsTip()), $("#promotionMsg").html() != "" && ($("#eggsFavorable").html($("#promotionMsg").attr("promotion")), carDetail.ShowCarEggsTip()), n == 1 && ($(".optArea").show(), $(".bidArea").hide(), $(".optiOfferDesc").html(getFormatMoneyTwo(carDetail._bidPrice)).attr("optpirce", carDetail._bidPrice), $(".optiBid").removeClass("mintell_1").unbind()), carDetail._ifFocus || carDetail.AddFocus()) : (carDetail.AlertMsg(t.ErrorMsg), t.ErrorMsg == "已结束" && (u = new GetDbTime, carDetail.AddBusinessTimeDelay(aucId, carId, u)), t.ErrorMsg.search("zcbbox") != -1 && $(".zcbbox").find("a").bind("click", function() {
                    window.parent.SR.turnOffSR();
                    window.setTimeout(window.parent.SR.turnOnSR(), 200)
                }))
            }
        })
    },
    ToQuertBid: function() {
        if (!carDetail.HasLogin()) {
            carDetail.LoginDialog();
            return
        }
        var n = carDetail._aId,
            t = carDetail._bidPrice;
        $.ajax({
            cache: !1,
            url: "/AjaxPLJ/PreviewQuoteBid",
            data: {
                aucId: n,
                price: t
            },
            type: "POST",
            async: !0,
            success: function(n) {
                if (n.Success) {
                    $(".bidbox").val() != "请输入出价金额" && $(".bidbox").val("请输入出价金额").addClass("hui");
                    $("#userLocationp").html() != "" && ($("#userLocationp").show(), $("#bidListDiv").height("74px"));
                    carDetail.TipMsg("<div style='text-align:center;'><img src='/images/CarDetail/suc.png' class='vm' /><span style='font-size:18px;font-weight:bold;margin-left:8px;' class='vm'> 报价成功!<\/p><\/div>");
                    $("#QuiteBidDiv").addClass("hide");
                    $("#QuiteBidDiv1").addClass("hide");
                    $("#quoteResult").show();
                    $("#quoteOffer").html(getFormatMoneyTwo(carDetail._bidPrice));
                    $("#quoteResult1").show();
                    $("#quoteOffer1").html(getFormatMoneyTwo(carDetail._bidPrice));
                    $("#MyOptimizationDIV").show();
                    $("#quoteOffer2").html(getFormatMoneyTwo(carDetail._bidPrice));
                    carDetail._ifFocus || carDetail.AddFocus()
                } else carDetail.AlertMsg(n.ErrorMsg)
            }
        })
    },
    AddBusinessTimeDelay: function(n, t, i) {
        var r = 0;
        $("#leftTime").length > 0 && (r = $("#leftTime").html());
        $.ajax({
            type: "POST",
            timeout: 1e4,
            cache: !1,
            async: !0,
            url: "/AjaxAuctionCenter/BusinessTimeDelay",
            data: {
                aucId: n,
                carId: t,
                lastTime: r,
                bidTime: i
            },
            success: function() {}
        })
    },
    LoginDialog: function() {
        $(".login").css("display", "block ")
    },
    ImgTab: function(n) {
        function e() {
            o();
            $(n + " .car-sm ul").stop().animate({
                left: -r * t
            }, function() {
                var f = parseInt($(n + " .car-sm ul").css("left"));
                Math.abs(f) >= $(n + " .car-sm ul").width() / 2 && ($(n + " .car-sm ul li").eq(u / 2).prevAll().remove(), t = t - u / 2, $(n + " .car-sm ul").css({
                    left: -r * t
                }), $(n + " .car-sm ul").html($(n + " .car-sm ul").html() + $(n + " .car-sm ul").html()), $(n + " .car-sm ul li").eq(t).addClass("current").siblings().removeClass("current"));
                i = !0
            })
        }

        function o() {
            $(n + " .car-sm ul li").eq(t).addClass("current").siblings().removeClass("current");
            $(n + " .car-big-tit").html($(n + " .car-sm ul li").eq(t).children("span").html());
            $(n + " .car-big-img img").attr("src", $(n + " .car-sm ul li").eq(t).children("img")[0].src.split("?")[0] + "?w=580").attr("onclick", "carDetail.ShowBigPicture(" + $(n + " .car-sm ul li").eq(t).children("img").attr("pid") + ")")
        }
        var t = 0,
            r, u, f, i;
        $(n + " .car-sm ul").html($(n + " .car-sm ul").html() + $(n + " .car-sm ul").html());
        r = $(n + " .car-sm ul li").eq(0).outerWidth(!0);
        u = $(n + " .car-sm ul li").length;
        $(n + " .car-sm ul").css("width", r * u);
        f = $(n + " .car-sm ul").width();
        $(n + " .car-sm ul li").eq(0).addClass("current");
        $(n + " .car-sm ul").on("click", "li", function() {
            t = $(this).index();
            e()
        });
        i = !0;
        $(n + " .next").click(function() {
            i && (t++, i = !1, e())
        });
        $(n + " .prev").click(function() {
            if (i) {
                i = !1;
                var e = parseInt($(n + " .car-sm ul").css("left"));
                t == 0 && ($(n + " .car-sm ul").css({
                    left: -f / 2
                }), t = u / 2);
                t--;
                e = parseInt($(n + " .car-sm ul").css("left"));
                $(n + " .car-sm ul").stop().animate({
                    left: e + r
                }, function() {
                    i = !0
                });
                o()
            }
        })
    },
    ShowCarEggsTip: function() {
        function t(n) {
            n.addEventListener && n.addEventListener("DOMMouseScroll", fnWheel, !1);
            n.onmousewheel = fnWheel
        }
        var n = document.getElementById("eggs");
        $("#eggs").show();
        t(n)
    },
    CloseCarEggs: function() {
        function t(n) {
            n.removeEventListener && n.removeEventListener("DOMMouseScroll", fnWheel, !1);
            n.onmousewheel = null
        }
        var n = document.getElementById("eggs");
        $(".eggclose").click(function() {
            $("#eggs").hide();
            t(n)
        })
    },
    QuotesRules: function() {
        $("#mw_temp").show()
    },
    SendMsg: function(n) {
        var t = "";
        $(n).is(":checked") ? (t = "点击确定设置短信通知！", carDetail._chkMsg = 1, $(".sendMsg").attr("checked", !0)) : (t = "确定取消短信通知", carDetail._chkMsg = 0, $(".sendMsg").attr("checked", !1));
        $("#sendMsgTip").html(t);
        carDetail.ShowDialog("sendMsgDialog")
    },
    UpdateSendMsg: function() {
        if (carDetail.CloseDialog("sendMsgDialog"), !carDetail.HasLogin()) {
            carDetail.LoginDialog();
            return
        }
        $.ajax({
            type: "post",
            url: "/AjaxAuctionCenter/UpdateQuoteTag",
            data: {
                aucid: carDetail._aId,
                isSendMsg: carDetail._chkMsg
            },
            cache: !1,
            async: !0,
            success: function(n) {
                n.Result && carDetail.TipMsg("<span style='font-size:26px;font-weight:bold;'> 操作成功!<\/span>")
            }
        })
    },
    CancelSendMsg: function() {
        $(".sendMsg").attr("checked", carDetail._chkMsg == 1 ? !1 : !0)
    },
    AlertMsg: function(n) {
        $("#alertMsg").html(n);
        carDetail.ShowDialog("alertDialog")
    },
    TipMsg: function(n) {
        $("#tipMsg").html(n);
        carDetail.ShowDialog("tipDialog");
        setTimeout(function() {
            $("#tipMsg").html("");
            carDetail.CloseDialog("tipDialog")
        }, 1e3)
    },
    UpdatePrice: function(data) {
        for (var model = eval("(" + data + ")"), yxj = 0, winner = !1, overPrice = !1, ovcerOpt = !1, hadOptTip = !1, m, aucId, finalOffer, objid, finclass, idArr, onceBid, onBid, onOpt, useintel, $vpw, bidLength, j, i = 0; i < model.length; i++) {
            if (m = model[i], m.CurrentBusinessId = carDetail._businessId, aucId = m.AucId, aucId != carDetail._aId) return;
            if (finalOffer = m.FinalOffer, m.LeftTime != null && $(".leftTime").html(m.LeftTime), objid = $("#finalOffer"), $(objid).attr("finaloffer", finalOffer), finclass = $(".finalOffer"), $(finclass).html(m.FinalOfferDesc.replace("万", "")), idArr = [$("#finalOffer"), $("#photoDialogFinalOffer"), $("#scrollFinalOffer")], $(idArr[0]).css("background-color", "#fff"), $(idArr[0]).animate({
                    backgroundColor: "#ff0"
                }, 500, function() {
                    $(idArr[0]).animate({
                        backgroundColor: "#fff"
                    }, 700, function() {
                        $(idArr[0]).animate({
                            backgroundColor: "#ff0"
                        }, 700, function() {
                            setTimeout(function() {
                                $(idArr[0]).css("background-color", "transparent")
                            }, 50)
                        })
                    })
                }), $(idArr[1]).css("background-color", "#fff"), $(idArr[1]).animate({
                    backgroundColor: "#ff0"
                }, 500, function() {
                    $(idArr[1]).animate({
                        backgroundColor: "#fff"
                    }, 700, function() {
                        $(idArr[1]).animate({
                            backgroundColor: "#ff0"
                        }, 700, function() {
                            setTimeout(function() {
                                $(idArr[1]).css("background-color", "transparent")
                            }, 50)
                        })
                    })
                }), $(idArr[2]).css("background-color", "#fff"), $(idArr[2]).animate({
                    backgroundColor: "#ff0"
                }, 500, function() {
                    $(idArr[2]).animate({
                        backgroundColor: "#fff"
                    }, 700, function() {
                        $(idArr[2]).animate({
                            backgroundColor: "#ff0"
                        }, 700, function() {
                            setTimeout(function() {
                                $(idArr[2]).css("background-color", "transparent")
                            }, 50)
                        })
                    })
                }), onceBid = $("#onceBid").html(), carDetail._wId = m.BusinessId, m.BusinessId == m.CurrentBusinessId ? (winner = !0, overPrice = !1, hadOptTip = !1) : m.BusinessId != m.CurrentBusinessId && (winner = !1, onBid = onceBid.indexOf("我是最高价") > -1, onBid && (overPrice = !0), onOpt = onceBid.indexOf("智能报价被超越") > -1, onOpt && (hadOptTip = !0)), useintel = parseInt($("#useIntelligenTip").attr("useintell")), useintel == 1 && finalOffer > parseInt($("#useIntelligenTip").attr("intellPrice")) && $(".useIntelligenTip").html("达到车主预期价"), m.BusinessId == m.CurrentBusinessId && ($("#optiOfferDesc").attr("optPirce", m.OptimizationOffer), objid.attr("quotoPrice", m.BidType)), yxj = parseInt($("#optiOfferDesc").attr("optPirce")), yxj = isNaN(yxj) ? 0 : yxj, yxj < finalOffer && yxj > 0 && ($(".optArea").hide(), $(".bidArea").show(), $("#optiOfferDesc").attr("optPirce", 0), ovcerOpt = !0), $("#bidCount").html(parseInt($("#bidCount").html()) + 1), $vpw = $(window).width(), $vpw <= 1024 && (m.UserLocation = m.UserLocation.replace("车商", "")), $("#bidList").prepend($("#bidTemp").tmpl(m)), bidLength = $("#bidList tr").length, bidLength - 20 > 0) for (j = 0; j < bidLength - 20; j++) $("#bidList tr:last").remove();
            carDetail.BidListRoll();
            winner ? ($("#bidTip").html("您已是最高价"), $(".onceBid").html("我是最高价"), $(".onceBidTr").show()) : ovcerOpt ? (layout._bodyFocus || (document.title = "您的智能报价被超越", setTimeout(function() {
                document.title = carDetail._title
            }, 1e3)), $("#bidTip").html(""), $(".onceBid").html("智能报价被超越"), $(".onceBidTr").show()) : overPrice ? ($("#bidTip").html(""), $(".onceBid").html("出价被超越"), $(".onceBidTr").show(), layout._bodyFocus || (document.title = "您的出价被超越", setTimeout(function() {
                document.title = carDetail._title
            }, 1e3))) : hadOptTip && ($("#bidTip").html(""), $(".onceBid").html("出价被超越"), $(".onceBidTr").show())
        }
    },
    AddFocus: function() {
        if (!carDetail.HasLogin()) {
            carDetail.LoginDialog();
            return
        }
        var n = $("#addFocus").html() == "关注";
        $.ajax({
            cache: !1,
            url: "/AjaxAuctionCenter/AddFocus",
            data: {
                productCode: carDetail._pCode,
                aucId: carDetail._aId,
                carId: carDetail._cId,
                isAdd: n
            },
            type: "POST",
            async: !0,
            success: function(t) {
                if (t.Success) {
                    var i = parseInt($("#focusCount").html());
                    n ? ($("#addFocus").html("已关注"), $("#focusCount").html(i + 1), carDetail._ifFocus = !0, i == 0 && $("#showFocusCount").show()) : ($("#addFocus").html("关注"), $("#focusCount").html(i - 1), carDetail._ifFocus = !1, i <= 1 && $("#showFocusCount").hide())
                }
            }
        })
    },
    UpdateLeftTime: function(data) {
        var model = eval("(" + data + ")");
        model.AucId == carDetail._aId && $(".leftTime").html(model.LeftTime)
    },
    HasLogin: function() {
        var n = !1;
        return $.ajax({
            url: "/AjaxLogin/HasLogin",
            type: "POST",
            async: !1,
            success: function(t) {
                n = t
            }
        }), n
    },
    UpdatePromotion: function(n, t, i, r, u) {
        carDetail._businessId == t && carDetail._aId == n && ($(".promotionMsg").html(u).attr("promotion", i), $("#promotionTitle").html(u), $(".promotionMsg").show(), $(".promotionTd").show(), $(".recommend").html("立减").show())
    },
    GetCarReport: function() {
        $.ajax({
            type: "post",
            url: "/AjaxCarDetail/GetCarReportInformation",
            dataType: "json",
            cache: !1,
            data: {
                tradeCode: carDetail._tradeCode
            },
            success: function(n) {
                var t, i;
                if (carDetail._loadReport = 1, n != null && n.ReportALLModel.length > 0) {
                    try {
                        n.IsFire == 1 && $("#fire").html("<i class='fire'><\/i><span class='vm mr15'>有火烧<\/span>");
                        n.IsWater == 1 && $("#water").html("<i class='water'><\/i><span class='vm mr15'>有泡水<\/span>");
                        $("#randDesc").html(n.rankDescription);
                        $(".ghTime").html(n.tradeTimes + "次");
                        t = n.TopPhotos;
                        $("#photoList").html("").append($("#photoTemp").tmpl(t));
                        $("#photoTopList").attr("src", t[0].photo_samll + "?w=580");
                        $("#firstPhotoDesc").html(t[0].photo_desc);
                        carDetail.ImgTab(".car-box", 4)
                    } catch (r) {
                        i = 12
                    }
                    $("#BasciInformationTemplate").tmpl(n.ReportALLModel[0]).appendTo("#BasciInformation");
                    $("#FormalityInformationTemplate").tmpl(n.ReportALLModel[1]).appendTo("#FormalityInformation");
                    $("#ConfigInformationTemplate").tmpl(n.ReportALLModel[2]).appendTo("#ConfigInformation");
                    $("#ResponsibilityInformationTemplate").tmpl(n.ReportALLModel[3]).appendTo("#ResponsibilityInformation");
                    $("#KeyTipInformationTemplate").tmpl(n.ReportALLModel[4]).appendTo("#KeyTipInformation");
                    $("#Check").after($("#CheckTemplate").tmpl(n));
                    $("#TredeCode").text(carDetail._tradeCode);
                    $("#CheckDate").text(n.FinishDate);
                    carDetail.AllReportPhotos.PhotosModel = n.PhotosModel;
                    carDetail.AllReportPhotos.AllPhotos = n.PhotosModel[0].Photos268V.concat(n.PaintPhotos).concat(n.PhotosModel[1].Photos268V).concat(n.PhotosModel[2].Photos268V).concat(n.PhotosModel[3].Photos268V);
                    $("#BigPicture").html("").append($("#BigPictureTemp").tmpl(carDetail.AllReportPhotos));
                    $("#SmallPicture").html("").append($("#SmallPictureTmpl").tmpl(carDetail.AllReportPhotos));
                    $("#CarPhotosTitle").after($("#PhotosTemplate").tmpl(carDetail.AllReportPhotos));
                    carDetail.Winw();
                    carDetail.ImgTabForReport(".car-info-zoom", 8);
                    (carDetail._bazaarPl == "" || carDetail._bazaarBSQ == "") && ($("#BasciInformation tr:eq(2) td").each(function() {
                        $(this).html() == "排量" && (carDetail._bazaarPl = $(this).next().html().replace(/\s/g, ""));
                        $(this).html() == "变速箱形式" && (carDetail._bazaarBSQ = $(this).next().html());
                        $.trim(carDetail._bazaarBSQ) != "MT" && (carDetail._bazaarBSQ = "AT")
                    }), carDetail.GetBazaarCar())
                }
            }
        })
    },
    Jump: function(n) {
        carDetail.PhotoSwitch(n - 1);
        $("html,body").animate({
            scrollTop: $("#CarPhotosTitle").offset().top - $(".car-info-top").height() - 10
        }, 0)
    },
    PhotoSwitch: function(n) {
        var t, i;
        for ($(".page-tab li").eq(n).addClass("cur").siblings().removeClass("cur"), $(".car-pho").hide().eq(n).show(), carDetail.CheckTitleTop = $("#CheckInfoTitle").offset().top, t = 0; t < $(".car-pho").eq(n).find("img").length; t++) i = $(".car-pho").eq(n).find("img").eq(t), $(i).attr("src", $(i).attr("src1"))
    },
    Winw: function() {
        var n = $(window).width();
        n < 1300 ? ($(".car-info-zoom").css({
            width: 660
        }), $(".car-info-zoom-right").hide(), $(".car-info-zoom .car-sm-box").hide(), $(".car-info-zoom-left,.car-info-zoom .car-big,.car-info-zoom .car-big img").css({
            width: 600,
            height: 450
        }), $(".car-info-zoom .test-close").css({
            right: "5px",
            top: "0"
        })) : ($(".car-info-zoom").css("width", 1200), $(".car-info-zoom-right").show(), $(".car-info-zoom .car-sm-box").show(), $(".car-info-zoom-left,.car-info-zoom .car-big,.car-info-zoom .car-big img").css({
            width: 800,
            height: 600
        }), $(".car-info-zoom .test-close").css({
            right: "15px",
            top: "5px"
        }));
        n < 1100 ? $(".car-info-art > p").css("float", "none") : ($(".car-info-art > p").css("float", "right"), $(".car-info-art > .car-info-art-left").css({
            float: "left",
            "margin-bottom": "10px"
        }))
    },
    ImgTabForReport: function(n) {
        var r = $(n + " .car-big ul li").length,
            u = $(n + " .car-big ul li img").eq(0).width(),
            t, i;
        $(n + " .car-big ul").css("width", u * r);
        t = $(n + " .car-sm ul li").length;
        i = $(n + " .car-sm ul li").eq(0).outerWidth(!0);
        $(n + " .car-sm ul").css("width", i * t)
    },
    ImgTabSwitch: function(n) {
        var u = $(".car-info-zoom .car-big ul li").length,
            e = $(".car-info-zoom .car-big ul li img").eq(0).width(),
            s = $(".car-info-zoom .car-sm ul li").eq(0).outerWidth(!0),
            f, i, r, t, o;
        for (carDetail.NowPhotoIndex < 0 && (carDetail.NowPhotoIndex = u - 1, n = !1), carDetail.NowPhotoIndex == u && (carDetail.NowPhotoIndex = 0, n = !1), $(".car-info-zoom .car-sm ul li").eq(carDetail.NowPhotoIndex).addClass("current").siblings().removeClass("current"), $(".car-info-zoom .car-big-tit").html($(".car-info-zoom .car-big ul li").eq(carDetail.NowPhotoIndex).children("span").html()), n ? ($(".car-info-zoom .car-big ul").animate({
            left: -e * carDetail.NowPhotoIndex
        }), $(".car-info-zoom .car-big ul").stop().animate({
            left: -e * carDetail.NowPhotoIndex
        }, function() {
            carDetail.IsSwitching = !1
        })) : ($(".car-info-zoom .car-big ul").css("left", -e * carDetail.NowPhotoIndex), carDetail.IsSwitching = !1), f = Math.floor(carDetail.NowPhotoIndex / 8), $(".car-info-zoom .car-sm ul").css("left", -s * f * 8), i = carDetail.NowPhotoIndex - 1, r = carDetail.NowPhotoIndex + 1, i < 0 && (i = u - 1), r == u && (r = 0), $(".car-info-zoom .car-big ul img").eq(i).attr("src", $(".car-info-zoom .car-big ul img").eq(i).attr("src1")), $(".car-info-zoom .car-big ul img").eq(carDetail.NowPhotoIndex).attr("src", $(".car-info-zoom .car-big ul img").eq(carDetail.NowPhotoIndex).attr("src1")), $(".car-info-zoom .car-big ul img").eq(r).attr("src", $(".car-info-zoom .car-big ul img").eq(r).attr("src1")), t = 0; t < $(".car-info-zoom .car-sm ul img").length; t++) o = $(".car-info-zoom .car-sm ul img").eq(t), f * 8 <= t && t < (f + 1) * 8 && $(o).attr("src", $(o).attr("src1"))
    },
    ShowBigPicture: function(n) {
        carDetail.ShowDialog("BigPictureDialog");
        carDetail.NowPhotoIndex = n;
        carDetail.ImgTabSwitch(!1)
    },
    LoadPhotos: function() {
        carDetail.AllReportPhotos == null || $.isEmptyObject(carDetail.AllReportPhotos) || (carDetail.IsLoadedPhoto = !0)
    }
};
(function(n) {
    function u() {
        var t = n("script:first"),
            i = t.css("color"),
            r = !1;
        if (/^rgba/.test(i)) r = !0;
        else try {
            r = i != t.css("color", "rgba(0, 0, 0, 0.5)").css("color");
            t.css("color", i)
        } catch (u) {}
        return r
    }

    function i(t, i, r) {
        var u = "rgb" + (n.support.rgba ? "a" : "") + "(" + parseInt(t[0] + r * (i[0] - t[0]), 10) + "," + parseInt(t[1] + r * (i[1] - t[1]), 10) + "," + parseInt(t[2] + r * (i[2] - t[2]), 10);
        return n.support.rgba && (u += "," + (t && i ? parseFloat(t[3] + r * (i[3] - t[3])) : 1)), u + ")"
    }

    function t(n) {
        var t, i;
        return (t = /#([0-9a-fA-F]{2})([0-9a-fA-F]{2})([0-9a-fA-F]{2})/.exec(n)) ? i = [parseInt(t[1], 16), parseInt(t[2], 16), parseInt(t[3], 16), 1] : (t = /#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])/.exec(n)) ? i = [parseInt(t[1], 16) * 17, parseInt(t[2], 16) * 17, parseInt(t[3], 16) * 17, 1] : (t = /rgb\(\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*\)/.exec(n)) ? i = [parseInt(t[1]), parseInt(t[2]), parseInt(t[3]), 1] : (t = /rgba\(\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9\.]*)\s*\)/.exec(n)) && (i = [parseInt(t[1], 10), parseInt(t[2], 10), parseInt(t[3], 10), parseFloat(t[4])]), i
    }
    n.extend(!0, n, {
        support: {
            rgba: u()
        }
    });
    var r = ["color", "backgroundColor", "borderBottomColor", "borderLeftColor", "borderRightColor", "borderTopColor", "outlineColor"];
    n.each(r, function(r, u) {
        n.fx.step[u] = function(r) {
            r.init || (r.a = t(n(r.elem).css(u)), r.end = t(r.end), r.init = !0);
            r.elem.style[u] = i(r.a, r.end, r.pos)
        }
    });
    n.fx.step.borderColor = function(u) {
        u.init || (u.end = t(u.end));
        var f = r.slice(2, 6);
        n.each(f, function(r, f) {
            u.init || (u[f] = {
                a: t(n(u.elem).css(f))
            });
            u.elem.style[f] = i(u[f].a, u.end, u.pos)
        });
        u.init = !0
    }
})(jQuery);
jQuery.extend({
    Enumerable: function() {
        var y = "Single:sequence contains more than one element.",
            e = !0,
            r = null,
            i = !1,
            n = function(n) {
                this.GetEnumerator = n
            },
            l, o;
        n.Choice = function() {
            var t = arguments[0] instanceof Array ? arguments[0] : arguments;
            return new n(function() {
                return new u(f.Blank, function() {
                    return this.Yield(t[Math.floor(Math.random() * t.length)])
                }, f.Blank)
            })
        };
        n.Cycle = function() {
            var t = arguments[0] instanceof Array ? arguments[0] : arguments;
            return new n(function() {
                var n = 0;
                return new u(f.Blank, function() {
                    return n >= t.length && (n = 0), this.Yield(t[n++])
                }, f.Blank)
            })
        };
        n.Empty = function() {
            return new n(function() {
                return new u(f.Blank, function() {
                    return i
                }, f.Blank)
            })
        };
        n.From = function(h) {
            if (h == r) return n.Empty();
            if (h instanceof n) return h;
            if (typeof h == s.Number || typeof h == s.Boolean) return n.Repeat(h, 1);
            if (typeof h == s.String) return new n(function() {
                var n = 0;
                return new u(f.Blank, function() {
                    return n < h.length ? this.Yield(h.charAt(n++)) : i
                }, f.Blank)
            });
            if (typeof h != s.Function) {
                if (typeof h.length == s.Number) return new o(h);
                if (!(h instanceof Object) && t.IsIEnumerable(h)) return new n(function() {
                    var t = e,
                        n;
                    return new u(function() {
                        n = new Enumerator(h)
                    }, function() {
                        return t ? t = i : n.moveNext(), n.atEnd() ? i : this.Yield(n.item())
                    }, f.Blank)
                })
            }
            return new n(function() {
                var n = [],
                    t = 0;
                return new u(function() {
                    for (var t in h) h[t] instanceof Function || n.push({
                        Key: t,
                        Value: h[t]
                    })
                }, function() {
                    return t < n.length ? this.Yield(n[t++]) : i
                }, f.Blank)
            })
        };
        n.Return = function(t) {
            return n.Repeat(t, 1)
        };
        n.Matches = function(t, e, o) {
            return o == r && (o = ""), e instanceof RegExp && (o += e.ignoreCase ? "i" : "", o += e.multiline ? "m" : "", e = e.source), o.indexOf("g") === -1 && (o += "g"), new n(function() {
                var n;
                return new u(function() {
                    n = new RegExp(e, o)
                }, function() {
                    var r = n.exec(t);
                    return r ? this.Yield(r) : i
                }, f.Blank)
            })
        };
        n.Range = function(t, i, u) {
            return u == r && (u = 1), n.ToInfinity(t, u).Take(i)
        };
        n.RangeDown = function(t, i, u) {
            return u == r && (u = 1), n.ToNegativeInfinity(t, u).Take(i)
        };
        n.RangeTo = function(t, i, u) {
            return u == r && (u = 1), t < i ? n.ToInfinity(t, u).TakeWhile(function(n) {
                return n <= i
            }) : n.ToNegativeInfinity(t, u).TakeWhile(function(n) {
                return n >= i
            })
        };
        n.Repeat = function(t, i) {
            return i != r ? n.Repeat(t).Take(i) : new n(function() {
                return new u(f.Blank, function() {
                    return this.Yield(t)
                }, f.Blank)
            })
        };
        n.RepeatWithFinalize = function(i, f) {
            return i = t.CreateLambda(i), f = t.CreateLambda(f), new n(function() {
                var n;
                return new u(function() {
                    n = i()
                }, function() {
                    return this.Yield(n)
                }, function() {
                    n != r && (f(n), n = r)
                })
            })
        };
        n.Generate = function(i, e) {
            return e != r ? n.Generate(i).Take(e) : (i = t.CreateLambda(i), new n(function() {
                return new u(f.Blank, function() {
                    return this.Yield(i())
                }, f.Blank)
            }))
        };
        n.ToInfinity = function(t, i) {
            return t == r && (t = 0), i == r && (i = 1), new n(function() {
                var n;
                return new u(function() {
                    n = t - i
                }, function() {
                    return this.Yield(n += i)
                }, f.Blank)
            })
        };
        n.ToNegativeInfinity = function(t, i) {
            return t == r && (t = 0), i == r && (i = 1), new n(function() {
                var n;
                return new u(function() {
                    n = t + i
                }, function() {
                    return this.Yield(n -= i)
                }, f.Blank)
            })
        };
        n.Unfold = function(r, o) {
            return o = t.CreateLambda(o), new n(function() {
                var t = e,
                    n;
                return new u(f.Blank, function() {
                    return t ? (t = i, n = r, this.Yield(n)) : (n = o(n), this.Yield(n))
                }, f.Blank)
            })
        };
        n.prototype = {
            CascadeBreadthFirst: function(r, f) {
                var o = this;
                return r = t.CreateLambda(r), f = t.CreateLambda(f), new n(function() {
                    var s, c = 0,
                        h = [];
                    return new u(function() {
                        s = o.GetEnumerator()
                    }, function() {
                        while (e) {
                            if (s.MoveNext()) return h.push(s.Current()), this.Yield(f(s.Current(), c));
                            var u = n.From(h).SelectMany(function(n) {
                                return r(n)
                            });
                            if (u.Any()) c++, h = [], t.Dispose(s), s = u.GetEnumerator();
                            else return i
                        }
                    }, function() {
                        t.Dispose(s)
                    })
                })
            },
            CascadeDepthFirst: function(r, f) {
                var o = this;
                return r = t.CreateLambda(r), f = t.CreateLambda(f), new n(function() {
                    var h = [],
                        s;
                    return new u(function() {
                        s = o.GetEnumerator()
                    }, function() {
                        while (e) {
                            if (s.MoveNext()) {
                                var u = f(s.Current(), h.length);
                                return h.push(s), s = n.From(r(s.Current())).GetEnumerator(), this.Yield(u)
                            }
                            if (h.length <= 0) return i;
                            t.Dispose(s);
                            s = h.pop()
                        }
                    }, function() {
                        try {
                            t.Dispose(s)
                        } finally {
                            n.From(h).ForEach(function(n) {
                                n.Dispose()
                            })
                        }
                    })
                })
            },
            Flatten: function() {
                var o = this;
                return new n(function() {
                    var h, s = r;
                    return new u(function() {
                        h = o.GetEnumerator()
                    }, function() {
                        while (e) {
                            if (s != r) {
                                if (s.MoveNext()) return this.Yield(s.Current());
                                s = r
                            }
                            if (h.MoveNext()) if (h.Current() instanceof Array) {
                                t.Dispose(s);
                                s = n.From(h.Current()).SelectMany(f.Identity).Flatten().GetEnumerator();
                                continue
                            } else return this.Yield(h.Current());
                            return i
                        }
                    }, function() {
                        try {
                            t.Dispose(h)
                        } finally {
                            t.Dispose(s)
                        }
                    })
                })
            },
            Pairwise: function(r) {
                var f = this;
                return r = t.CreateLambda(r), new n(function() {
                    var n;
                    return new u(function() {
                        n = f.GetEnumerator();
                        n.MoveNext()
                    }, function() {
                        var t = n.Current();
                        return n.MoveNext() ? this.Yield(r(t, n.Current())) : i
                    }, function() {
                        t.Dispose(n)
                    })
                })
            },
            Scan: function(f, o, s) {
                var h, c;
                return s != r ? this.Scan(f, o).Select(s) : (o == r ? (o = t.CreateLambda(f), h = i) : (o = t.CreateLambda(o), h = e), c = this, new n(function() {
                    var n, r, s = e;
                    return new u(function() {
                        n = c.GetEnumerator()
                    }, function() {
                        if (s) {
                            if (s = i, h) return this.Yield(r = f);
                            if (n.MoveNext()) return this.Yield(r = n.Current())
                        }
                        return n.MoveNext() ? this.Yield(r = o(r, n.Current())) : i
                    }, function() {
                        t.Dispose(n)
                    })
                }))
            },
            Select: function(r) {
                var f = this;
                return r = t.CreateLambda(r), new n(function() {
                    var n, e = 0;
                    return new u(function() {
                        n = f.GetEnumerator()
                    }, function() {
                        return n.MoveNext() ? this.Yield(r(n.Current(), e++)) : i
                    }, function() {
                        t.Dispose(n)
                    })
                })
            },
            SelectMany: function(f, e) {
                var o = this;
                return f = t.CreateLambda(f), e == r && (e = function(n, t) {
                    return t
                }), e = t.CreateLambda(e), new n(function() {
                    var h, s = undefined,
                        c = 0;
                    return new u(function() {
                        h = o.GetEnumerator()
                    }, function() {
                        if (s === undefined && !h.MoveNext()) return i;
                        do {
                            if (s == r) {
                                var u = f(h.Current(), c++);
                                s = n.From(u).GetEnumerator()
                            }
                            if (s.MoveNext()) return this.Yield(e(h.Current(), s.Current()));
                            t.Dispose(s);
                            s = r
                        } while (h.MoveNext());
                        return i
                    }, function() {
                        try {
                            t.Dispose(h)
                        } finally {
                            t.Dispose(s)
                        }
                    })
                })
            },
            Where: function(r) {
                r = t.CreateLambda(r);
                var f = this;
                return new n(function() {
                    var n, e = 0;
                    return new u(function() {
                        n = f.GetEnumerator()
                    }, function() {
                        while (n.MoveNext()) if (r(n.Current(), e++)) return this.Yield(n.Current());
                        return i
                    }, function() {
                        t.Dispose(n)
                    })
                })
            },
            OfType: function(n) {
                var t;
                switch (n) {
                    case Number:
                        t = s.Number;
                        break;
                    case String:
                        t = s.String;
                        break;
                    case Boolean:
                        t = s.Boolean;
                        break;
                    case Function:
                        t = s.Function;
                        break;
                    default:
                        t = r
                }
                return t === r ? this.Where(function(t) {
                    return t instanceof n
                }) : this.Where(function(n) {
                    return typeof n === t
                })
            },
            Zip: function(r, f) {
                f = t.CreateLambda(f);
                var e = this;
                return new n(function() {
                    var o, s, h = 0;
                    return new u(function() {
                        o = e.GetEnumerator();
                        s = n.From(r).GetEnumerator()
                    }, function() {
                        return o.MoveNext() && s.MoveNext() ? this.Yield(f(o.Current(), s.Current(), h++)) : i
                    }, function() {
                        try {
                            t.Dispose(o)
                        } finally {
                            t.Dispose(s)
                        }
                    })
                })
            },
            Join: function(o, s, h, c, l) {
                s = t.CreateLambda(s);
                h = t.CreateLambda(h);
                c = t.CreateLambda(c);
                l = t.CreateLambda(l);
                var a = this;
                return new n(function() {
                    var v, p, y = r,
                        w = 0;
                    return new u(function() {
                        v = a.GetEnumerator();
                        p = n.From(o).ToLookup(h, f.Identity, l)
                    }, function() {
                        for (var n, t; e;) {
                            if (y != r) {
                                if (n = y[w++], n !== undefined) return this.Yield(c(v.Current(), n));
                                n = r;
                                w = 0
                            }
                            if (v.MoveNext()) t = s(v.Current()), y = p.Get(t).ToArray();
                            else return i
                        }
                    }, function() {
                        t.Dispose(v)
                    })
                })
            },
            GroupJoin: function(e, o, s, h, c) {
                o = t.CreateLambda(o);
                s = t.CreateLambda(s);
                h = t.CreateLambda(h);
                c = t.CreateLambda(c);
                var l = this;
                return new n(function() {
                    var a = l.GetEnumerator(),
                        v = r;
                    return new u(function() {
                        a = l.GetEnumerator();
                        v = n.From(e).ToLookup(s, f.Identity, c)
                    }, function() {
                        if (a.MoveNext()) {
                            var n = v.Get(o(a.Current()));
                            return this.Yield(h(a.Current(), n))
                        }
                        return i
                    }, function() {
                        t.Dispose(a)
                    })
                })
            },
            All: function(n) {
                n = t.CreateLambda(n);
                var r = e;
                return this.ForEach(function(t) {
                    if (!n(t)) return r = i, i
                }), r
            },
            Any: function(n) {
                n = t.CreateLambda(n);
                var r = this.GetEnumerator();
                try {
                    if (arguments.length == 0) return r.MoveNext();
                    while (r.MoveNext()) if (n(r.Current())) return e;
                    return i
                } finally {
                    t.Dispose(r)
                }
            },
            Concat: function(f) {
                var e = this;
                return new n(function() {
                    var s, o;
                    return new u(function() {
                        s = e.GetEnumerator()
                    }, function() {
                        if (o == r) {
                            if (s.MoveNext()) return this.Yield(s.Current());
                            o = n.From(f).GetEnumerator()
                        }
                        return o.MoveNext() ? this.Yield(o.Current()) : i
                    }, function() {
                        try {
                            t.Dispose(s)
                        } finally {
                            t.Dispose(o)
                        }
                    })
                })
            },
            Insert: function(r, f) {
                var o = this;
                return new n(function() {
                    var h, s, c = 0,
                        l = i;
                    return new u(function() {
                        h = o.GetEnumerator();
                        s = n.From(f).GetEnumerator()
                    }, function() {
                        return c == r && s.MoveNext() ? (l = e, this.Yield(s.Current())) : h.MoveNext() ? (c++, this.Yield(h.Current())) : !l && s.MoveNext() ? this.Yield(s.Current()) : i
                    }, function() {
                        try {
                            t.Dispose(h)
                        } finally {
                            t.Dispose(s)
                        }
                    })
                })
            },
            Alternate: function(t) {
                return t = n.Return(t), this.SelectMany(function(i) {
                    return n.Return(i).Concat(t)
                }).TakeExceptLast()
            },
            Contains: function(n, r) {
                r = t.CreateLambda(r);
                var u = this.GetEnumerator();
                try {
                    while (u.MoveNext()) if (r(u.Current()) === n) return e;
                    return i
                } finally {
                    t.Dispose(u)
                }
            },
            DefaultIfEmpty: function(r) {
                var f = this;
                return new n(function() {
                    var n, o = e;
                    return new u(function() {
                        n = f.GetEnumerator()
                    }, function() {
                        return n.MoveNext() ? (o = i, this.Yield(n.Current())) : o ? (o = i, this.Yield(r)) : i
                    }, function() {
                        t.Dispose(n)
                    })
                })
            },
            Distinct: function(t) {
                return this.Except(n.Empty(), t)
            },
            Except: function(r, f) {
                f = t.CreateLambda(f);
                var e = this;
                return new n(function() {
                    var o, s;
                    return new u(function() {
                        o = e.GetEnumerator();
                        s = new a(f);
                        n.From(r).ForEach(function(n) {
                            s.Add(n)
                        })
                    }, function() {
                        while (o.MoveNext()) {
                            var n = o.Current();
                            if (!s.Contains(n)) return s.Add(n), this.Yield(n)
                        }
                        return i
                    }, function() {
                        t.Dispose(o)
                    })
                })
            },
            Intersect: function(r, f) {
                f = t.CreateLambda(f);
                var e = this;
                return new n(function() {
                    var o, s, h;
                    return new u(function() {
                        o = e.GetEnumerator();
                        s = new a(f);
                        n.From(r).ForEach(function(n) {
                            s.Add(n)
                        });
                        h = new a(f)
                    }, function() {
                        while (o.MoveNext()) {
                            var n = o.Current();
                            if (!h.Contains(n) && s.Contains(n)) return h.Add(n), this.Yield(n)
                        }
                        return i
                    }, function() {
                        t.Dispose(o)
                    })
                })
            },
            SequenceEqual: function(r, u) {
                var o, f;
                u = t.CreateLambda(u);
                o = this.GetEnumerator();
                try {
                    f = n.From(r).GetEnumerator();
                    try {
                        while (o.MoveNext()) if (!f.MoveNext() || u(o.Current()) !== u(f.Current())) return i;
                        return f.MoveNext() ? i : e
                    } finally {
                        t.Dispose(f)
                    }
                } finally {
                    t.Dispose(o)
                }
            },
            Union: function(r, f) {
                f = t.CreateLambda(f);
                var e = this;
                return new n(function() {
                    var h, o, s;
                    return new u(function() {
                        h = e.GetEnumerator();
                        s = new a(f)
                    }, function() {
                        var t;
                        if (o === undefined) {
                            while (h.MoveNext()) if (t = h.Current(), !s.Contains(t)) return s.Add(t), this.Yield(t);
                            o = n.From(r).GetEnumerator()
                        }
                        while (o.MoveNext()) if (t = o.Current(), !s.Contains(t)) return s.Add(t), this.Yield(t);
                        return i
                    }, function() {
                        try {
                            t.Dispose(h)
                        } finally {
                            t.Dispose(o)
                        }
                    })
                })
            },
            OrderBy: function(n) {
                return new h(this, n, i)
            },
            OrderByDescending: function(n) {
                return new h(this, n, e)
            },
            Reverse: function() {
                var t = this;
                return new n(function() {
                    var n, r;
                    return new u(function() {
                        n = t.ToArray();
                        r = n.length
                    }, function() {
                        return r > 0 ? this.Yield(n[--r]) : i
                    }, f.Blank)
                })
            },
            Shuffle: function() {
                var t = this;
                return new n(function() {
                    var n;
                    return new u(function() {
                        n = t.ToArray()
                    }, function() {
                        if (n.length > 0) {
                            var t = Math.floor(Math.random() * n.length);
                            return this.Yield(n.splice(t, 1)[0])
                        }
                        return i
                    }, f.Blank)
                })
            },
            GroupBy: function(f, e, o, s) {
                var h = this;
                return f = t.CreateLambda(f), e = t.CreateLambda(e), o != r && (o = t.CreateLambda(o)), s = t.CreateLambda(s), new n(function() {
                    var n;
                    return new u(function() {
                        n = h.ToLookup(f, e, s).ToEnumerable().GetEnumerator()
                    }, function() {
                        while (n.MoveNext()) return o == r ? this.Yield(n.Current()) : this.Yield(o(n.Current().Key(), n.Current()));
                        return i
                    }, function() {
                        t.Dispose(n)
                    })
                })
            },
            PartitionBy: function(f, o, s, h) {
                var l = this,
                    c;
                return f = t.CreateLambda(f), o = t.CreateLambda(o), h = t.CreateLambda(h), s == r ? (c = i, s = function(n, t) {
                    return new v(n, t)
                }) : (c = e, s = t.CreateLambda(s)), new n(function() {
                    var r, v, y, a = [];
                    return new u(function() {
                        r = l.GetEnumerator();
                        r.MoveNext() && (v = f(r.Current()), y = h(v), a.push(o(r.Current())))
                    }, function() {
                        for (var t, u;
                             (t = r.MoveNext()) == e;) if (y === h(f(r.Current()))) a.push(o(r.Current()));
                        else break;
                        return a.length > 0 ? (u = c ? s(v, n.From(a)) : s(v, a), t ? (v = f(r.Current()), y = h(v), a = [o(r.Current())]) : a = [], this.Yield(u)) : i
                    }, function() {
                        t.Dispose(r)
                    })
                })
            },
            BufferWithCount: function(r) {
                var f = this;
                return new n(function() {
                    var n;
                    return new u(function() {
                        n = f.GetEnumerator()
                    }, function() {
                        for (var t = [], u = 0; n.MoveNext();) if (t.push(n.Current()), ++u >= r) return this.Yield(t);
                        return t.length > 0 ? this.Yield(t) : i
                    }, function() {
                        t.Dispose(n)
                    })
                })
            },
            Aggregate: function(n, t, i) {
                return this.Scan(n, t, i).Last()
            },
            Average: function(n) {
                n = t.CreateLambda(n);
                var i = 0,
                    r = 0;
                return this.ForEach(function(t) {
                    i += n(t);
                    ++r
                }), i / r
            },
            Count: function(n) {
                n = n == r ? f.True : t.CreateLambda(n);
                var i = 0;
                return this.ForEach(function(t, r) {
                    n(t, r) && ++i
                }), i
            },
            Max: function(n) {
                return n == r && (n = f.Identity), this.Select(n).Aggregate(function(n, t) {
                    return n > t ? n : t
                })
            },
            Min: function(n) {
                return n == r && (n = f.Identity), this.Select(n).Aggregate(function(n, t) {
                    return n < t ? n : t
                })
            },
            MaxBy: function(n) {
                return n = t.CreateLambda(n), this.Aggregate(function(t, i) {
                    return n(t) > n(i) ? t : i
                })
            },
            MinBy: function(n) {
                return n = t.CreateLambda(n), this.Aggregate(function(t, i) {
                    return n(t) < n(i) ? t : i
                })
            },
            Sum: function(n) {
                return n == r && (n = f.Identity), this.Select(n).Aggregate(0, function(n, t) {
                    return n + t
                })
            },
            ElementAt: function(n) {
                var t, r = i;
                if (this.ForEach(function(u, f) {
                        if (f == n) return t = u, r = e, i
                    }), !r) throw new Error("index is less than 0 or greater than or equal to the number of elements in source.");
                return t
            },
            ElementAtOrDefault: function(n, t) {
                var r, u = i;
                return this.ForEach(function(t, f) {
                    if (f == n) return r = t, u = e, i
                }), u ? r : t
            },
            First: function(n) {
                if (n != r) return this.Where(n).First();
                var t, u = i;
                if (this.ForEach(function(n) {
                        return t = n, u = e, i
                    }), !u) throw new Error("First:No element satisfies the condition.");
                return t
            },
            FirstOrDefault: function(n, t) {
                if (t != r) return this.Where(t).FirstOrDefault(n);
                var u, f = i;
                return this.ForEach(function(n) {
                    return u = n, f = e, i
                }), f ? u : n
            },
            Last: function(n) {
                if (n != r) return this.Where(n).Last();
                var t, u = i;
                if (this.ForEach(function(n) {
                        u = e;
                        t = n
                    }), !u) throw new Error("Last:No element satisfies the condition.");
                return t
            },
            LastOrDefault: function(n, t) {
                if (t != r) return this.Where(t).LastOrDefault(n);
                var u, f = i;
                return this.ForEach(function(n) {
                    f = e;
                    u = n
                }), f ? u : n
            },
            Single: function(n) {
                if (n != r) return this.Where(n).Single();
                var u, t = i;
                if (this.ForEach(function(n) {
                        if (t) throw new Error(y);
                        else t = e, u = n
                    }), !t) throw new Error("Single:No element satisfies the condition.");
                return u
            },
            SingleOrDefault: function(n, t) {
                if (t != r) return this.Where(t).SingleOrDefault(n);
                var f, u = i;
                return this.ForEach(function(n) {
                    if (u) throw new Error(y);
                    else u = e, f = n
                }), u ? f : n
            },
            Skip: function(r) {
                var f = this;
                return new n(function() {
                    var n, e = 0;
                    return new u(function() {
                        for (n = f.GetEnumerator(); e++ < r && n.MoveNext();)
                            }, function() {
                        return n.MoveNext() ? this.Yield(n.Current()) : i
                    }, function() {
                        t.Dispose(n)
                    })
                })
            },
            SkipWhile: function(r) {
                r = t.CreateLambda(r);
                var f = this;
                return new n(function() {
                    var n, s = 0,
                        o = i;
                    return new u(function() {
                        n = f.GetEnumerator()
                    }, function() {
                        while (!o) if (n.MoveNext()) {
                            if (!r(n.Current(), s++)) return o = e, this.Yield(n.Current());
                            continue
                        } else return i;
                        return n.MoveNext() ? this.Yield(n.Current()) : i
                    }, function() {
                        t.Dispose(n)
                    })
                })
            },
            Take: function(r) {
                var f = this;
                return new n(function() {
                    var n, e = 0;
                    return new u(function() {
                        n = f.GetEnumerator()
                    }, function() {
                        return e++ < r && n.MoveNext() ? this.Yield(n.Current()) : i
                    }, function() {
                        t.Dispose(n)
                    })
                })
            },
            TakeWhile: function(r) {
                r = t.CreateLambda(r);
                var f = this;
                return new n(function() {
                    var n, e = 0;
                    return new u(function() {
                        n = f.GetEnumerator()
                    }, function() {
                        return n.MoveNext() && r(n.Current(), e++) ? this.Yield(n.Current()) : i
                    }, function() {
                        t.Dispose(n)
                    })
                })
            },
            TakeExceptLast: function(f) {
                f == r && (f = 1);
                var e = this;
                return new n(function() {
                    if (f <= 0) return e.GetEnumerator();
                    var n, r = [];
                    return new u(function() {
                        n = e.GetEnumerator()
                    }, function() {
                        while (n.MoveNext()) {
                            if (r.length == f) return r.push(n.Current()), this.Yield(r.shift());
                            r.push(n.Current())
                        }
                        return i
                    }, function() {
                        t.Dispose(n)
                    })
                })
            },
            TakeFromLast: function(f) {
                if (f <= 0 || f == r) return n.Empty();
                var e = this;
                return new n(function() {
                    var h, o, s = [];
                    return new u(function() {
                        h = e.GetEnumerator()
                    }, function() {
                        while (h.MoveNext()) s.length == f && s.shift(), s.push(h.Current());
                        return o == r && (o = n.From(s).GetEnumerator()), o.MoveNext() ? this.Yield(o.Current()) : i
                    }, function() {
                        t.Dispose(o)
                    })
                })
            },
            IndexOf: function(n) {
                var t = r;
                return this.ForEach(function(i, r) {
                    if (i === n) return t = r, e
                }), t !== r ? t : -1
            },
            LastIndexOf: function(n) {
                var t = -1;
                return this.ForEach(function(i, r) {
                    i === n && (t = r)
                }), t
            },
            ToArray: function() {
                var n = [];
                return this.ForEach(function(t) {
                    n.push(t)
                }), n
            },
            ToLookup: function(n, i, r) {
                n = t.CreateLambda(n);
                i = t.CreateLambda(i);
                r = t.CreateLambda(r);
                var u = new a(r);
                return this.ForEach(function(t) {
                    var r = n(t),
                        f = i(t),
                        e = u.Get(r);
                    e !== undefined ? e.push(f) : u.Add(r, [f])
                }), new w(u)
            },
            ToObject: function(n, i) {
                n = t.CreateLambda(n);
                i = t.CreateLambda(i);
                var r = {};
                return this.ForEach(function(t) {
                    r[n(t)] = i(t)
                }), r
            },
            ToDictionary: function(n, i, r) {
                n = t.CreateLambda(n);
                i = t.CreateLambda(i);
                r = t.CreateLambda(r);
                var u = new a(r);
                return this.ForEach(function(t) {
                    u.Add(n(t), i(t))
                }), u
            },
            ToJSON: function(n, t) {
                return JSON.stringify(this.ToArray(), n, t)
            },
            ToString: function(n, t) {
                return n == r && (n = ""), t == r && (t = f.Identity), this.Select(t).ToArray().join(n)
            },
            Do: function(r) {
                var f = this;
                return r = t.CreateLambda(r), new n(function() {
                    var n, e = 0;
                    return new u(function() {
                        n = f.GetEnumerator()
                    }, function() {
                        return n.MoveNext() ? (r(n.Current(), e++), this.Yield(n.Current())) : i
                    }, function() {
                        t.Dispose(n)
                    })
                })
            },
            ForEach: function(n) {
                n = t.CreateLambda(n);
                var u = 0,
                    r = this.GetEnumerator();
                try {
                    while (r.MoveNext()) if (n(r.Current(), u++) === i) break
                } finally {
                    t.Dispose(r)
                }
            },
            Write: function(n, u) {
                n == r && (n = "");
                u = t.CreateLambda(u);
                var f = e;
                this.ForEach(function(t) {
                    f ? f = i : document.write(n);
                    document.write(u(t))
                })
            },
            WriteLine: function(n) {
                n = t.CreateLambda(n);
                this.ForEach(function(t) {
                    document.write(n(t));
                    document.write("<br />")
                })
            },
            Force: function() {
                var n = this.GetEnumerator();
                try {
                    while (n.MoveNext())
                        } finally {
                    t.Dispose(n)
                }
            },
            Let: function(r) {
                r = t.CreateLambda(r);
                var f = this;
                return new n(function() {
                    var e;
                    return new u(function() {
                        e = n.From(r(f)).GetEnumerator()
                    }, function() {
                        return e.MoveNext() ? this.Yield(e.Current()) : i
                    }, function() {
                        t.Dispose(e)
                    })
                })
            },
            Share: function() {
                var e = this,
                    t;
                return new n(function() {
                    return new u(function() {
                        t == r && (t = e.GetEnumerator())
                    }, function() {
                        return t.MoveNext() ? this.Yield(t.Current()) : i
                    }, f.Blank)
                })
            },
            MemoizeAll: function() {
                var o = this,
                    t, e;
                return new n(function() {
                    var n = -1;
                    return new u(function() {
                        e == r && (e = o.GetEnumerator(), t = [])
                    }, function() {
                        return n++, t.length <= n ? e.MoveNext() ? this.Yield(t[n] = e.Current()) : i : this.Yield(t[n])
                    }, f.Blank)
                })
            },
            Catch: function(r) {
                r = t.CreateLambda(r);
                var f = this;
                return new n(function() {
                    var n;
                    return new u(function() {
                        n = f.GetEnumerator()
                    }, function() {
                        try {
                            return n.MoveNext() ? this.Yield(n.Current()) : i
                        } catch (t) {
                            return r(t), i
                        }
                    }, function() {
                        t.Dispose(n)
                    })
                })
            },
            Finally: function(r) {
                r = t.CreateLambda(r);
                var f = this;
                return new n(function() {
                    var n;
                    return new u(function() {
                        n = f.GetEnumerator()
                    }, function() {
                        return n.MoveNext() ? this.Yield(n.Current()) : i
                    }, function() {
                        try {
                            t.Dispose(n)
                        } finally {
                            r()
                        }
                    })
                })
            },
            Trace: function(n, i) {
                return n == r && (n = "Trace"), i = t.CreateLambda(i), this.Do(function(t) {
                    console.log(n, ":", i(t))
                })
            }
        };
        var f = {
                Identity: function(n) {
                    return n
                },
                True: function() {
                    return e
                },
                Blank: function() {}
            },
            s = {
                Boolean: typeof e,
                Number: "number",
                String: "string",
                Object: "object",
                Undefined: typeof undefined,
                Function: typeof

                    function() {}
            },
            t = {
                CreateLambda: function(n) {
                    if (n == r) return f.Identity;
                    if (typeof n == s.String) {
                        if (n == "") return f.Identity;
                        if (n.indexOf("=>") == -1) return new Function("$,$$,$$$,$$$$", "return " + n);
                        var t = n.match(/^[(\s]*([^()]*?)[)\s]*=>(.*)/);
                        return new Function(t[1], "return " + t[2])
                    }
                    return n
                },
                IsIEnumerable: function(n) {
                    if (typeof Enumerator != s.Undefined) try {
                        return new Enumerator(n), e
                    } catch (t) {}
                    return i
                },
                Compare: function(n, t) {
                    return n === t ? 0 : n > t ? 1 : -1
                },
                Dispose: function(n) {
                    n != r && n.Dispose()
                }
            },
            c = {
                Before: 0,
                Running: 1,
                After: 2
            },
            u = function(n, t, r) {
                var f = new p,
                    u = c.Before;
                this.Current = f.Current;
                this.MoveNext = function() {
                    try {
                        switch (u) {
                            case c.Before:
                                u = c.Running;
                                n();
                            case c.Running:
                                return t.apply(f) ? e : (this.Dispose(), i);
                            case c.After:
                                return i
                        }
                    } catch (r) {
                        this.Dispose();
                        throw r;
                    }
                };
                this.Dispose = function() {
                    if (u == c.Running) try {
                        r()
                    } finally {
                        u = c.After
                    }
                }
            },
            p = function() {
                var n = r;
                this.Current = function() {
                    return n
                };
                this.Yield = function(t) {
                    return n = t, e
                }
            },
            h = function(n, i, r, u) {
                var f = this;
                f.source = n;
                f.keySelector = t.CreateLambda(i);
                f.descending = r;
                f.parent = u
            };
        h.prototype = new n;
        h.prototype.CreateOrderedEnumerable = function(n, t) {
            return new h(this.source, n, t, this)
        };
        h.prototype.ThenBy = function(n) {
            return this.CreateOrderedEnumerable(n, i)
        };
        h.prototype.ThenByDescending = function(n) {
            return this.CreateOrderedEnumerable(n, e)
        };
        h.prototype.GetEnumerator = function() {
            var e = this,
                t, n, o = 0;
            return new u(function() {
                t = [];
                n = [];
                e.source.ForEach(function(i, r) {
                    t.push(i);
                    n.push(r)
                });
                var i = l.Create(e, r);
                i.GenerateKeys(t);
                n.sort(function(n, t) {
                    return i.Compare(n, t)
                })
            }, function() {
                return o < n.length ? this.Yield(t[n[o++]]) : i
            }, f.Blank)
        };
        l = function(n, t, i) {
            var u = this;
            u.keySelector = n;
            u.descending = t;
            u.child = i;
            u.keys = r
        };
        l.Create = function(n, t) {
            var i = new l(n.keySelector, n.descending, t);
            return n.parent != r ? l.Create(n.parent, i) : i
        };
        l.prototype.GenerateKeys = function(n) {
            for (var t = this, u = n.length, e = t.keySelector, f = new Array(u), i = 0; i < u; i++) f[i] = e(n[i]);
            t.keys = f;
            t.child != r && t.child.GenerateKeys(n)
        };
        l.prototype.Compare = function(n, i) {
            var u = this,
                f = t.Compare(u.keys[n], u.keys[i]);
            if (f == 0) {
                if (u.child != r) return u.child.Compare(n, i);
                f = t.Compare(n, i)
            }
            return u.descending ? -f : f
        };
        o = function(n) {
            this.source = n
        };
        o.prototype = new n;
        o.prototype.Any = function(t) {
            return t == r ? this.source.length > 0 : n.prototype.Any.apply(this, arguments)
        };
        o.prototype.Count = function(t) {
            return t == r ? this.source.length : n.prototype.Count.apply(this, arguments)
        };
        o.prototype.ElementAt = function(t) {
            return 0 <= t && t < this.source.length ? this.source[t] : n.prototype.ElementAt.apply(this, arguments)
        };
        o.prototype.ElementAtOrDefault = function(n, t) {
            return 0 <= n && n < this.source.length ? this.source[n] : t
        };
        o.prototype.First = function(t) {
            return t == r && this.source.length > 0 ? this.source[0] : n.prototype.First.apply(this, arguments)
        };
        o.prototype.FirstOrDefault = function(t, i) {
            return i != r ? n.prototype.FirstOrDefault.apply(this, arguments) : this.source.length > 0 ? this.source[0] : t
        };
        o.prototype.Last = function(t) {
            var i = this;
            return t == r && i.source.length > 0 ? i.source[i.source.length - 1] : n.prototype.Last.apply(i, arguments)
        };
        o.prototype.LastOrDefault = function(t, i) {
            var u = this;
            return i != r ? n.prototype.LastOrDefault.apply(u, arguments) : u.source.length > 0 ? u.source[u.source.length - 1] : t
        };
        o.prototype.Skip = function(t) {
            var r = this.source;
            return new n(function() {
                var n;
                return new u(function() {
                    n = t < 0 ? 0 : t
                }, function() {
                    return n < r.length ? this.Yield(r[n++]) : i
                }, f.Blank)
            })
        };
        o.prototype.TakeExceptLast = function(n) {
            return n == r && (n = 1), this.Take(this.source.length - n)
        };
        o.prototype.TakeFromLast = function(n) {
            return this.Skip(this.source.length - n)
        };
        o.prototype.Reverse = function() {
            var t = this.source;
            return new n(function() {
                var n;
                return new u(function() {
                    n = t.length
                }, function() {
                    return n > 0 ? this.Yield(t[--n]) : i
                }, f.Blank)
            })
        };
        o.prototype.SequenceEqual = function(t, u) {
            return (t instanceof o || t instanceof Array) && u == r && n.From(t).Count() != this.Count() ? i : n.prototype.SequenceEqual.apply(this, arguments)
        };
        o.prototype.ToString = function(t, i) {
            return i != r || !(this.source instanceof Array) ? n.prototype.ToString.apply(this, arguments) : (t == r && (t = ""), this.source.join(t))
        };
        o.prototype.GetEnumerator = function() {
            var n = this.source,
                t = 0;
            return new u(f.Blank, function() {
                return t < n.length ? this.Yield(n[t++]) : i
            }, f.Blank)
        };
        var a = function() {
                var t = function(n, t) {
                        return Object.prototype.hasOwnProperty.call(n, t)
                    },
                    o = function(n) {
                        return n === r ? "null" : n === undefined ? "undefined" : typeof n.toString === s.Function ? n.toString() : Object.prototype.toString.call(n)
                    },
                    l = function(n, t) {
                        var i = this;
                        i.Key = n;
                        i.Value = t;
                        i.Prev = r;
                        i.Next = r
                    },
                    h = function() {
                        this.First = r;
                        this.Last = r
                    },
                    c;
                return h.prototype = {
                    AddLast: function(n) {
                        var t = this;
                        t.Last != r ? (t.Last.Next = n, n.Prev = t.Last, t.Last = n) : t.First = t.Last = n
                    },
                    Replace: function(n, t) {
                        n.Prev != r ? (n.Prev.Next = t, t.Prev = n.Prev) : this.First = t;
                        n.Next != r ? (n.Next.Prev = t, t.Next = n.Next) : this.Last = t
                    },
                    Remove: function(n) {
                        n.Prev != r ? n.Prev.Next = n.Next : this.First = n.Next;
                        n.Next != r ? n.Next.Prev = n.Prev : this.Last = n.Prev
                    }
                }, c = function(n) {
                    var t = this;
                    t.count = 0;
                    t.entryList = new h;
                    t.buckets = {};
                    t.compareSelector = n == r ? f.Identity : n
                }, c.prototype = {
                    Add: function(n, i) {
                        var r = this,
                            h = r.compareSelector(n),
                            s = o(h),
                            e = new l(n, i),
                            u, f;
                        if (t(r.buckets, s)) {
                            for (u = r.buckets[s], f = 0; f < u.length; f++) if (r.compareSelector(u[f].Key) === h) {
                                r.entryList.Replace(u[f], e);
                                u[f] = e;
                                return
                            }
                            u.push(e)
                        } else r.buckets[s] = [e];
                        r.count++;
                        r.entryList.AddLast(e)
                    },
                    Get: function(n) {
                        var i = this,
                            e = i.compareSelector(n),
                            s = o(e),
                            u, r, f;
                        if (!t(i.buckets, s)) return undefined;
                        for (u = i.buckets[s], r = 0; r < u.length; r++) if (f = u[r], i.compareSelector(f.Key) === e) return f.Value;
                        return undefined
                    },
                    Set: function(n, r) {
                        var f = this,
                            c = f.compareSelector(n),
                            a = o(c),
                            s, u, h;
                        if (t(f.buckets, a)) for (s = f.buckets[a], u = 0; u < s.length; u++) if (f.compareSelector(s[u].Key) === c) return h = new l(n, r), f.entryList.Replace(s[u], h), s[u] = h, e;
                        return i
                    },
                    Contains: function(n) {
                        var r = this,
                            s = r.compareSelector(n),
                            h = o(s),
                            f, u;
                        if (!t(r.buckets, h)) return i;
                        for (f = r.buckets[h], u = 0; u < f.length; u++) if (r.compareSelector(f[u].Key) === s) return e;
                        return i
                    },
                    Clear: function() {
                        this.count = 0;
                        this.buckets = {};
                        this.entryList = new h
                    },
                    Remove: function(n) {
                        var i = this,
                            e = i.compareSelector(n),
                            f = o(e),
                            r, u;
                        if (t(i.buckets, f)) for (r = i.buckets[f], u = 0; u < r.length; u++) if (i.compareSelector(r[u].Key) === e) {
                            i.entryList.Remove(r[u]);
                            r.splice(u, 1);
                            r.length == 0 && delete i.buckets[f];
                            i.count--;
                            return
                        }
                    },
                    Count: function() {
                        return this.count
                    },
                    ToEnumerable: function() {
                        var t = this;
                        return new n(function() {
                            var n;
                            return new u(function() {
                                n = t.entryList.First
                            }, function() {
                                if (n != r) {
                                    var t = {
                                        Key: n.Key,
                                        Value: n.Value
                                    };
                                    return n = n.Next, this.Yield(t)
                                }
                                return i
                            }, f.Blank)
                        })
                    }
                }, c
            }(),
            w = function(t) {
                var i = this;
                i.Count = function() {
                    return t.Count()
                };
                i.Get = function(i) {
                    return n.From(t.Get(i))
                };
                i.Contains = function(n) {
                    return t.Contains(n)
                };
                i.ToEnumerable = function() {
                    return t.ToEnumerable().Select(function(n) {
                        return new v(n.Key, n.Value)
                    })
                }
            },
            v = function(n, t) {
                this.Key = function() {
                    return n
                };
                o.call(this, t)
            };
        return v.prototype = new o, n
    }()
}), function(n, t) {
    n.fn.toEnumerable = function() {
        return t.From(this).Select(function(t) {
            return n(t)
        })
    };
    t.prototype.TojQuery = function() {
        return n(this.ToArray())
    }
}(jQuery, this.Enumerable || this.jQuery.Enumerable)