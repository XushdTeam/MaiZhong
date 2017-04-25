<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/19
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/guzhi.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script src="/resources/js/js.js" type="text/javascript"></script>
    <style>

        .error{
            display: none;
            color: #f05b48;
        }
        .d_box input {
            line-height: 41px;
            height: 41px;
            margin-top: 20px;
            padding-left: 10px;
            width: 178px;
            border: 1px solid #f05b48;
        }
        .verbut {
            width: 120px!important;
            background: #f05b48;
            color: #FFF;
            cursor: pointer;
        }
        .tells input[disabled]{color:#7a8475;opacity:0.8;background: #CCCCCC!important;}
    </style>
</head>
<body>
<div class="box">
    <p class="width"><img src="../resources/img/dl.jpg"></p>
    <div class="shouj">手机验证登录</div>
    <div class="d_box">
        <form name="form" class="tells" onsubmit="return false">
            <input type="text" name="phone" id="phone" maxlength="11" placeholder="手机号"><input type="button" class="verbut" value="获取验证码" onclick="onSendVcode(this)"/>
            <b class="error pr">手机号格式不正确</b>
            <input type="text" name="vercode" id="vercode" placeholder="短信验证码" maxlength="4" class="input2">
            <b class="error verc">验证码不能为空</b>
            <button onclick="onMysubmit()">立即登录</button>
        </form>
    </div>
    <a class="xieyi xieyis" href=" javascript:showoutc();"><input type="checkbox" name="1" checked>我已阅读并同意《迈众汽车协议》</a>
    <div class="xies">
        <div class=" regcon">
            <div class="m-sPopTitle"><strong>服务协议条款</strong><b id="sPopClose" class="m-sPopClose" onClick="closeClause()">×</b></div>
            <div class="apply_up_content">
    	<pre class="f-r0">
		<strong>同意以下服务条款，提交注册信息</strong>
        </pre>
                <div class="ovf">
                    <p>第一条 服务条款的确认和接纳</p>
                    <p>（一）迈众汽车的所有权和运营权归北京迈众汽车信息服务有限公司所有。</p>
                    <p>（二）用户在注册之前，应当仔细阅读本协议，并同意遵守本协议后方可成为注册用户。一旦注册成功，则用户与迈众汽车之间自动形成协议关系，用户应当受本协议的约束。用户在使用特殊的服务或产品时，应当同意接受相关协议后方能使用。</p>
                    <p>（三）本协议则可由迈众汽车随时更新，用户应当及时关注并同意本站不承担通知义务，迈众汽车鼓励用户定期浏览本协议。如果用户不接受对本协议所做的修改，用户可立即停止使用迈众汽车的网络服务。如果用户在本协议条款修改后继续使用迈众汽车的网络服务，则视为用户接受对本协议所做的修改。本站的通知、公告、声明或其它类似内容是本协议的一部分。</p>

                    <p>第二条 服务内容</p>
                    <p>（一）迈众汽车的具体内容由本站根据实际情况提供。</p>
                    <p>（二）本站仅提供相关的网络服务，除此之外与相关网络服务有关的设备(如个人电脑、手机、及其他与接入互联网或移动网有关的装置)及所需的费用(如为接入互联网而支付的电话费及上网费、为使用移动网而支付的手机费)均应由用户自行负担。</p>

                    <p> 第三条 注册和登录控制</p>
                    <p>（一）经本站注册系统完成注册程序并通过身份认证的用户即成为正式用户，可以获得本站规定用户所应享有的一切权限；未经认证仅享有本站规定的部分会员权限。迈众汽车有权对会员的权限设计进行变更。</p>
                    <p>（二）用户注册时必须提供准确的注册信息，注册后如有变动应及时更新。用户注册成功后，迈众汽车将为该用户设置一个帐号，用户将可以设置相应的密码。用户利用该密码和帐号所进行的一切活动引起的任何损失或损害，由用户自行承担全部责任，本站不承担任何责任。如用户发现帐号遭到未授权的使用或发生其他任何安全问题，应立即修改帐号密码并妥善保管，如有必要，请通知本站。因黑客行为或用户的保管疏忽导致帐号非法使用，本站不承担任何责任。</p>
                    <p>（三）迈众汽车网站内的任何帐号均为迈众汽车的财产，用户完成注册后，仅取得相关帐号的使用权，用户仅可为个人及非商业的目的使用该帐号，不得将帐号转让、出租、赠与给任何第三方或继承。</p>

                    <p>  第四条 合法使用</p>
                    <p> （一）迈众汽车的网络服务是经过特定设计以特定版式和风格向用户提供相关内容。未经迈众汽车同意，请不要通过其他渠道和门户使用迈众汽车的内容和服务。用户使用迈众汽车的网络服务，必须遵守所有与服务有关的中华人民共和国法律和法规，不得通过迈众汽车的网络服务实施或帮助别人实施如下行为：</p>
                    <p>（1）违反法律法规或社会公共利益和公共道德的行为；</p>
                    <p>2）侵犯迈众汽车合法利益的行为，包括但不限于发布未经迈众汽车许可的商业广告或信息公告；</p>
                    <p>（3）侵犯其他任何第三方的知识产权或其他任何合法权益；</p>
                    <p>（4）任何可能对迈众汽车互联网或移动网服务正常运转产生不利影响的行为；</p>
                    <p>（5）上载、发送或以其他方式传播包含病毒或其他危害计算机软、硬件设备正常工作的程序或资料；</p>
                    <p>（6）上载、发送或以其他方式传播任何诽谤性的、虚假的、辱骂性的、恐吓性的、淫秽的或其他任何非法的信息资料。</p>
                    <p>（二）迈众汽车有权对用户使用迈众汽车网络服务的情况进行实时审查和监督。如发现用户涉嫌在使用迈众汽车网络服务时违反任何上述规定的，迈众汽车有权单方面认定用户是否违反了任何上述规定，并采取改正、删除用户上传的内容、暂停或终止用户使用服务的权利等措施。</p>
                    <p>（三）未经本站的授权或许可，任何会员不得借用本站的名义从事任何商业活动，也不得将本站作为从事商业活动的场所、平台或其他任何形式的媒介。禁止将本站用作从事各种非法活动的场所、平台或者其他任何形式的媒介。违反者若触犯法律，一切后果自负，本站不承担任何责任。</p>

                    <p>  第五条 网站使用和帐号删除</p>
                    <p>（一）如果迈众汽车单方面认定用户违反本协议或者违反适用的法律法规，迈众汽车可以不经通知而限制用户使用迈众汽车的网络服务或者删除用户使用的帐号以及帐号里的相关内容和信息。迈众汽车不对用户因此遭受的损失承担任何责任。如果用户不同意本服务协议，用户应该立即停止使用迈众汽车的网络服务。</p>
                    <p>（二）除针对特定服务适用的特殊条款另有约定外，如用户在迈众汽车网站注册的帐号在任何连续90日内未实际使用的，则迈众汽车线有权删除该帐号并停止为该用户提供相关的网络服务。</p>
                    <p>（三）如因任何原因，迈众汽车限制用户使用网络服务或者删除用户使用的帐号以及帐号里的相关内容和信息的，迈众汽车有权继续使用相关内容和信息。</p>

                    <p> 第六条 隐私权声明及其他特殊条款</p>
                   <p> 依法保护用户隐私是迈众汽车的基本政策。</p>
                    <p>（一）信息的收集</p>
                   <p> 如果您仅仅浏览本网站的一般性内容，我们并不要求您提供任何个人信息。在您需要使用或浏览我们提供的特定服务或信息时（比如估值、卖车、参加优惠活动或直接联系本网站），在您的同意及确认下，我们可能会以线上或线下注册表格的形式要求您提供如下个人资料和信息：</p>
                   <p> 1.具体信息，比如姓名，电话号码，手机号码，通讯地址等；</p>
                    <p>2.仅在特定情况下（比如您需要付费才能享有的服务或产品，或参加本网站参与或组织的抽奖或竞赛活动），我们会要求您提供个人付款信息和身份证件信息，比如信用卡号码或身份证及护照号码。</p>
                    <p>（二）隐私保护</p>
                   <p> 1.本站不对外公开或向第三方提供单个用户的注册资料及用户在使用网络服务时存储在本站的非公开内容，但下列情况除外：</p>
                    <p>(1)事先获得用户的明确授权；</p>
                    <p>(2)根据有关的法律法规要求；</p>
                    <p> (3)按照相关政府主管部门的要求；</p>
                    <p>(4)为维护社会公众的利益，本站可能会与第三方合作向用户提供相关的网络服务，在此情况下，如该第三方同意承担与本站同等的保护用户隐私的责任，则本站有权将用户的注册资料等提供给该第三方。</p>
                    <p>2.在不透露单个用户隐私资料的前提下，本站有权对整个用户数据库进行分析并对用户数据库进行商业上的利用。<p>
                    <p>3.迈众汽车提供的某些特定服务可能还会适用其他特殊条款。迈众汽车会在用户使用相关特定服务时向用户提供或在相关页面发布这些特殊条款，请用户在使用相关特定服务前仔细阅读。用户使用相关特定服务的，将视为用户同意并接受这些特殊条款的约束。如上述特殊条款与本协议的规定有任何冲突的，以特殊条款的规定为准。</p>

                    <p>  第七条 第三方内容及广告</p>
                    <p>（一）迈众汽车网站有时会提供第三方内容或通往第三方网站的链接。迈众汽车并不审阅、评估或同意这些第三方内容或者链接。用户应对上述第三方内容或者链接自行加以判断，并承担因使用而引起的所有风险。迈众汽车不对这些第三方的内容或者链接做出任何保证或承担任何责任。</p>
                    <p>（二）用户同意迈众汽车有权在提供网络服务过程中以各种方式播放广告或提供其他商业信息。</p>

                    <p> 第八条 免责声明及责任限制</p>
                    <p>（一）迈众汽车及用户同意并特此确认：</p>
                    <p>1.用户使用迈众汽车网络服务所存在的一切风险及后果由其自身承担，迈众汽车对用户不承担任何责任，不对网络服务作任何形式的明示或默示的声明或担保。</p>
                    <p>2.迈众汽车不保证服务及时、安全、准确及可靠。迈众汽车有权不经通知随时变更、中断或终止部分或全部的网络服务、删除用户的帐号，而无需对用户和任何第三人承担任何责任。用户使用迈众汽车的网络服务应自行承担风险。涉及收费服务的，迈众汽车应当在变更、中断或终止之前事先通知用户，并根据用户实际使用服务的情况，将多收取的服务费退还给用户。但对于因不可抗力、迈众汽车不能控制的原因或本站正常的设备维修升级而造成的网络服务中断，迈众汽车不承担任何责任。</p>.
                   <p> 3.对于经由迈众汽车服务而传送的任何内容及信息，迈众汽车不保证正确性及完整性，迈众汽车不对任何上述内容及信息负责，用户使用任何上述内容及信息的，应自行承担风险，迈众汽车有权自行决定是否删除或保留任何上述内容及信息。</p>
                    <p> 第九条 违约赔偿</p>
                    <p>（一）如因迈众汽车违反有关法律、法规或本协议条款而给用户造成损失的，迈众汽车应承担赔偿责任。</p>
                    <p>（二）如因用户违反有关法律、法规、本协议项下的任何条款或任何对第三方的承诺，而给迈众汽车或任何其他第三人造成损失，用户同意承担由此造成的损害赔偿责任，并确保迈众汽车不会因此遭受任何损失。</p>

                    <p> 第十条 使用法律及争议解决</p>
                    <p>（一）本协议的订立、执行、解释及争议解决均应适用中华人民共和国法律。</p>
                    <p>（二）与本协议有关的或因本协议引起的任何争议，双方应尽量通过友好协商解决；协商不成的，任何一方均有权向“本公司”注册地人民法院提起诉讼。</p>




                </div>
            </div>
            <center><a class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3" href="javascript:closeClause();">已阅读并同意此条款</a></center>
        </div>
    </div>
</div>

<p class="p_fooot">Copyright © 2017-2020 迈众 All Rights Reserved 版权所有 迈众汽车信息服务有限公司</p>
<p class="p_fooot">京ICP备17017795号     联系电话：010-8025-8108     站长统计</p>
<script>
    var countdown = 120;

    var time = function(el){
        if (countdown == 0) {
            el.removeAttribute("disabled");
            el.value = "获取验证码";
            countdown = 120;
            return;
        } else {
            el.setAttribute("disabled", true);
            el.value = "重新发送(" + countdown + "s)";
            countdown--;
        }


        setTimeout(function(){time(el)},1000)

    }

    var onSendVcode = function(el){
        var phone = $("#phone").val();
        if(!(/^1[34578]\d{9}$/.test(phone))){
            $(".pr").show();
            $(".tell").css({
                color: "#f05b48"
            })
            return;
        }
        $(".pr").hide();
        $(".tell").css({
            color: "#333"
        });


        $.getJSON('/getSMSCode/'+phone,function (res) {
            console.log(JSON.stringify(res));
            if(res.status==200){
                countdown = 120;
                time(el);
            }
        });


    }

    var onMysubmit = function(){
        var phone = $("#phone").val();
        if(!(/^1[34578]\d{9}$/.test(phone))){
            $(".pr").show();
            return;
        }
        $(".pr").hide();
        var vercode = $("#vercode").val();
        if(vercode == ""){
            $(".verc").show();
            return;
        }
        $(".verc").hide();

        $.getJSON('/userLogin/'+phone+"/"+vercode,function(res){
            if(res.status == 200){
                //电话写入cookie
                $.cookie('phone', phone, {expires: 7, path: '/'});
                $.cookie('token', res.data, {expires: 7, path: '/'});
                window.location.href="/per/or";
            }else {
                $(".verc").html(res.message);
                $(".verc").show();
            }
        });

    }
</script>
</body>
</html>
