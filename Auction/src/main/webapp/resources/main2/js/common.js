// var DATAURL='http://m.mychebao.com';

jQuery(document).ready(function ($) {

    setTimeout(function () {
        $('.wow').css('opacity', 1);
    }, 300);

    // 清除按钮操作  开始
    $('._inputClear').find('._text').on('keyup keydown', function (event) {
        if ($(this).val().length > 0) {
            $(this).parents('._inputClear').find('._clear').removeClass('none');
        } else {
            $(this).parents('._inputClear').find('._clear').addClass('none');
        }
    });

    $('._clear').on('click', function (event) {
        $(this).parents('._inputClear').find('._text').val('');
        $(this).addClass('none');
        return false;
    });
    // 清除按钮操作  结束
    $(document).mouseup(function (e) {
        var indexCity = $('.index_city_floor');
        if (!indexCity.hasClass('none')) {
            if (!indexCity.is(e.target) && indexCity.has(e.target).length === 0) {
                setTimeout(function () {
                    indexCity.addClass('none');
                }, 10)
            }
        }

        var toolForm = $(".tool_city_floor");
        if (!toolForm.hasClass('none')) {
            if(!toolForm.is(e.target) && toolForm.has(e.target).length === 0){
            setTimeout(function () {
                toolForm.addClass('none');
            }, 10)
            }
        }
    });
});


// 获取城市列表
function getCityFloor(Type, Box) {
    $.ajax({
        async: true,
        type: 'POST',
        dataType: 'json',
        url: '../optcomm/getOpen.htm',
        success: function (data) {
            var CityFloorData = data;
            var CityFloorHTML = '';
            var storage_letter = '';
            if (Type == 'hot') {
                CityFloorHTML += '<div class="cli clearfix" id="Hot"><div class="_letter">热门</div><div class="_cli_list clearfix">' +
                    '<a href="javascript:void(0)" data-id="1867">北京</a>' +
                    '<a href="javascript:void(0)" data-id="1889">上海</a>' +
                    '<a href="javascript:void(0)" data-id="2053">深圳</a>' +
                    '<a href="javascript:void(0)" data-id="1898">重庆</a>' +
                    '<a href="javascript:void(0)" data-id="2076">苏州</a>' +
                    '<a href="javascript:void(0)" data-id="2072">南京</a>' +
                    '<a href="javascript:void(0)" data-id="2102">成都</a>' +
                    '<a href="javascript:void(0)" data-id="2176">西安</a>' +
                    '</div></div>';
            }
            for (var i = 0; i < CityFloorData.length; i++) {
                var thisData = CityFloorData[i];
                var this_letter = thisData.letter;
                if (storage_letter != this_letter) {
                    storage_letter = this_letter;
                    CityFloorHTML += '</div></div><div class="cli clearfix"><div class="_letter">' + this_letter + '</div><div class="_cli_list clearfix">';
                }
                CityFloorHTML += '<a href="javascript:void(0)" data-id="' + thisData.id + '">' + thisData.name.replace('市', '') + '</a>';
            }
            $(Box).find('.cityList').html(CityFloorHTML);
            $(Box).find('.city_floor').attr('rel', 1);
        },
        error: function (data) {
        }
    });
}


// 打开盒子
function openMsgBox(Box) {
    $(Box).removeClass('none');
    $(Box).find('.___box').css({
        'marginTop': '-' + ($(Box).find('.___box').height() / 2) + 'px',
        'marginLeft': '-' + ($(Box).find('.___box').width() / 2) + 'px'
    });
}

// 关闭盒子
function closeMsgBox(Box) {
    $(Box).addClass('none');
}


// 打开盒子
function openMsgBox(Box) {
    $(Box).removeClass('none');
    $(Box).find('.___box').css({
        'marginTop': '-' + ($(Box).find('.___box').height() / 2) + 'px',
        'marginLeft': '-' + ($(Box).find('.___box').width() / 2) + 'px'
    })
}

// 关闭盒子
function closeMsgBox(Box) {
    $(Box).addClass('none');
}

/*获取url参数*/
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}


function setCookie(name, value, time) {
    var strsec = getsec(time);
    var exp = new Date();
    exp.setTime(exp.getTime() + strsec * 1);
    document.cookie = escape(name) + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/";
}

function getsec(str) {
    var str1 = str.substring(1, str.length) * 1;
    var str2 = str.substring(0, 1);
    if (str2 == "s") {
        return str1 * 1000;
    } else if (str2 == "h") {
        return str1 * 60 * 60 * 1000;
    } else if (str2 == "d") {
        return str1 * 24 * 60 * 60 * 1000;
    }
}

/* 从cookie取值 */
function getCookie(name) {
    var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if (arr != null) {
        return unescape(arr[2]);
    }
    return null;
}
/* 删除cookie */
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    document.cookie = name + "=;expires=" + exp.toGMTString();
}

// turnDetail
function turnDetail(c, p, o, d, ct, bt) {
    setCookie(o, '{"c":' + c + ',"p":' + p + ',"d":\'' + d + '\',"ct":' + '\'' + ct + '\'' + ',"bt":' + '\'' + bt + '\'' + '}', 'h2');
    //window.open('../carDetail/' + o + '.htm');
}

//提交成功后，清除输入框信息
function setDefault(inputid) {
    inputid.val('');
}

function setDefaultCity(inputclass) {
    inputclass.text('城市');
}
