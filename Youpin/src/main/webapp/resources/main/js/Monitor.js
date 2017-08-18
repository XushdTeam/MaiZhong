var monitor = {
    _domain: "monitor.cheyipai.com",
    _sessionName: "cypweblog",
    _userCookieName: "mointorInfo",
    _pageId: "",
    //_userId: "0", //联合登陆，无需userid
    Init: function () {
        monitor._pageId = monitor.GetGuid();
       // monitor.LoadPage();
        $('.track').click(function () { monitor.TrackClick(this); });
    },
    TrackClick: function (obj) {
        var name = $(obj).attr("trackname");
        var sessionId = monitor.GetCookie();
        var postUrl = "http://" + monitor._domain + "/click";
        var uesrModel = monitor.GetUserCookie();
        $.ajax({
            url: postUrl,
            dataType: "jsonp",
            data: { name: name, sessionId: sessionId, uesrModel: uesrModel },
            jsonp: "jsonpcallback"
        });
    },
    LoadPage: function () {
        var sessionId = monitor.GetCookie();
        var screenHeight = window.screen.height;
        var screenWidth = window.screen.width;
        var url = window.location.href;
        var referrer = document.referrer;
        var postUrl = "http://" + monitor._domain + "/loadpage";
        var uesrModel = monitor.GetUserCookie();
        $.ajax({
            url: postUrl,
            dataType: "jsonp",
            data: { url: url, referrer: referrer, sessionId: sessionId, pageId: monitor._pageId, uesrModel: uesrModel },
            jsonp: "jsonpcallback"
        });
    },
    Leave: function () {
        var sessionId = monitor.GetCookie();
        var screenHeight = window.screen.height;
        var screenWidth = window.screen.width;
        var url = window.location.href;
        var referrer = document.referrer;
        var postUrl = "http://" + monitor._domain + "/leave";
        var uesrModel = monitor.GetUserCookie();
        $.ajax({
            url: postUrl,
            dataType: "jsonp",
            data: { url: url, referrer: referrer, sessionId: sessionId, pageId: monitor._pageId, uesrModel: uesrModel },
            jsonp: "jsonpcallback"
        });
    },
    //写cookies
    SetCookie: function () {
        var guid = monitor.GetGuid();
        document.cookie = monitor._sessionName + "=" + escape(guid);
        return guid;
    },
    //读取cookies
    GetCookie: function () {
        var arr, reg = new RegExp("(^| )" + monitor._sessionName + "=([^;]*)(;|$)");
        if (arr = document.cookie.match(reg)) return unescape(arr[2]);
        else {
            return monitor.SetCookie();
        }
    },
    GetUserCookie: function () {
        var arr, reg = new RegExp("(^| )" + monitor._userCookieName + "=([^;]*)(;|$)");
        if (arr = document.cookie.match(reg)) return unescape(arr[2]);
        else {
            return "";
        }
    },
    GetGuid: function () {
        var S4 = function () {
            return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
        };
        return (S4() + S4() + "-" + S4() + "-" + S4() + "-" + S4() + "-" + S4() + S4() + S4());
    }
};

$(document).ready(function () {
    monitor.Init();

    $(window).unload(function () {
        monitor.Leave();
    });

});