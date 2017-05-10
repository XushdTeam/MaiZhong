<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/20
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" type="text/css" href="/resources/font/iconfont.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/js.js"></script>
</head>
<body>
<div class="top e_top">
    <div class="t_cen">
        <a href="#" class="logo"><img src="../resources/img/logo.png"></a>
        <ul class="t_right">
            <li><a href="#" class="hover">首页</a></li>
            <li><a href="/sale">我要卖车</a></li>
            <li><a href="#">销售商加盟</a></li>
            <li><a href="#">app下载</a></li>
            <li><a href="#">帮助中心</a></li>
            <li><a href="#">个人中心</a></li>
            <li><a href="/per/or"  id="user" style="display:none">188****8888</a></li>
        </ul>
        <ul class="lon">
            <li ><i class="iconfont icon ">&#xe6a3;</i><a href="/login"  id="login">登录</a>/<a href="/login"  id="">注册</a></li>
            <li><a href="javascript:void(0)" class="two" id="exit" style="display:none" onclick="exit();">退出</a></li>
        </ul>
    </div>
</div><!--top end-->


<!--background-->
<!--中间部分-->
<div class="A_colocr">
    <div class="A_con">
        <div class="left">
            <ul>
                <li class="l_a"><a href="javascript:void(0)">交易方式<span>&gt;</span></a>
                    <ul class="xiao_ul">
                        <li><a href="#one">门店交易</a></li>
                        <li><a href="#two">上门交易</a></li>
                    </ul>
                </li>
                <li class="l_a"><a href="javascript:void(0)">质检说明 <span>&gt;</span></a>
                    <ul class="xiao_ul">
                        <li><a href="#tre">检测名词解释</a></li>
                        <li><a href="#for">专业检测项目</a></li>
                    </ul>
                </li>
                <li class="l_a" ><a href="javascript:void(0)">帮助中心  <span>&gt;</span></a>
                    <ul class="xiao_ul">
                        <li><a href="#six">常见问题</a></li>
                        <li><a href="#seve">服务条款</a></li>
                    </ul>
                </li>
                <li  class="l_a"><a href="javascript:void(0)">关于我们  <span>&gt;</span></a>
                    <ul class="xiao_ul">
                        <li><a href="#eih">公司简介</a></li>
                        <li><a href="#nig">招贤纳士</a></li>
                    </ul>
                </li>
                <li class="l_a"><a href="javascript:void(0)" >合作加盟<span>&gt;</span></a>
                    <ul class="xiao_ul">
                        <li><a href="#tens">销售商加盟</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="right">
               <div id="one">
                    <h3>门店交易</h3>
                    <div class="xq">
                        <p><b>什么是门店回收</b></p>
                        <p>门店回收是一种线下交易方式，用户在线下单之后，凭短信直接去悟空收车指定门店进行交易。</p>
                        <p>目前悟空收车在北京共有20余家线下指定门店，分布在多个区，用户可通过浏览地图，查看最近最方便的线下门店。</p>
                        <p>友情提示：用户没有在线下单，也可以在方便的时间自行前往任意一家门店进行交易</p>
                        <p>门店回收流程</p>
                       <p> 提交订单 门店交易 现场检测 价格确认 交易完成</p>


                    </div>
               </div><!--one end-->

            <div id="two">
                <h3>上门交易</h3>
                <div class="xq">
                    <p><b> 1.上门交易（地铁站和上门两种方式组成）</b></p>
                    <p> 1. 用户提交订单，选择交易时间</p>
                    <p>2. 交易当天检测专员提前联系用户，沟通好具体的上门时间和地点</p>
                    <p>3. 现场为用户提供专业质检和有品质的上门服务</p>
                </div>
            </div>


            <div id="tre">
                <h3>检测名词解释</h3>
                <div class="xq">

                     <p><b>1. 车况等级：</b></p>
                    <p>车款优秀：全车覆盖件（前后保险杠及塑料件除外）加强件和结构件无修复；</p>
                    <p>车况良好：全车结构件无事故类损伤，加强件无严重损伤，允许覆盖件有修复；</p>
                    <p>车况一般：全车结构件无事故类损伤，允许覆盖件和加强件有修复；</p>
                    <p> 车况较差：全车结构件发生一处或多处事故类损伤。</p>
                    <p> <b>2. 事故部件：</b></p>
                    <p> 结构件：包括前纵梁、门柱（ABC柱）、减震器座、后备箱底板、后纵梁、防火墙；</p>
                    <p> 加强件：包括翼子板内衬和水箱框架。（塑料材料，复合材料等可拆卸的水箱框架除外）；</p>
                    <p> 覆盖件：包括翼子板、车门、发动机盖、行李箱盖、车顶等。</p>
                    <p> <b>3.事故车：</b></p>
                    <p> “事故车”，一般是指存在结构性损伤的车辆。同时，泡水车、火烧车等也都属于“特殊事故车”这一类。</p>
                    <p> 有以下情景</p>
                    <p> 如符任何一条，即属事故车：</p>
                    <p> 1、经过撞击，损伤到发动机舱和驾驶舱的车辆。</p>
                    <p> 2、车身后翼子板撞击损伤超过其三分之一的车辆。</p>
                    <p>3、纵梁有焊接、切割、整形、变形的车辆。</p>
                    <p> 4、减振器座有焊接、切割、整形、变形的车辆。</p>
                    <p> 5、ABC柱有焊接、切割、整形、变形的车辆。</p>
                    <p> 6、因撞击造成汽车安全气囊弹出的车辆。</p>
                    <p> 7、其它不可拆卸部份有严重的焊接、切割、整形、变形的车辆。</p>
                    <p> 8、车身经水浸泡超过车身二分之一，或积水进入驾驶舱的车辆。</p>
                    <p> 9、车身经火焚烧超过0.5平方米，经修复仍存在安全隐患的车辆。</p>
                </div>
            </div>

            <div id="for">
                <h3>专业检测项目</h3>
                <div class="xq">
                    <p><b> 专业检测项目</b></p>
                    <p><img src="../resources/img/j_1.jpg"></p>
                    <p><img src="../resources/img/j_2.jpg"></p>
                    <p><img src="../resources/img/j_3.jpg"></p>
                    <p><img src="../resources/img/j_4.jpg"></p>
                    <p><img src="../resources/img/j_5.jpg"></p>
                    <p><img src="../resources/img/j_6.jpg"></p>
                    <p><img src="../resources/img/j_7.jpg"></p>
                </div>
            </div>

            <div id="six">
                 <h3>常见问题</h3>
                <div class="xq">

                    <p><b>（1）客服电话是多少？</b></p>
                    <p>客服热线电话 010-80258108</p>
                    <p>悟空收车客户服务热线通过人工，短信等方式为您提供有关卖车的业务咨询、业务受理和投诉建议等业务服务</p>
                    <p><b>（2）在悟空收车需要交什么费用？</b></p>
                    <p>我们不会向卖家收取任何费用，整个服务过程全部免费，物流费，过户费用等都由悟空收车承担。</p>
                    <p><b>（2）卖车流程是什么？</b></p>
                    <p> 1、在卖车页面填写车辆信息，或拨打客服电话联系我们。</p>
                    <p> 2、约定后和质检师在约定时间地点进行见面，对车辆细致检测。</p>
                    <p> 3、质检结果与卖家订单填写情况相符即可，若质检结果不符者需要按照实际车况重新作价。</p>
                    <p> 4、签定收购协议。</p>
                    <p> <b>（3）大概多长时间能够成交？</b></p>
                    <p>  需要您先在网站提交订单，由您选择现场质检时间，质检结果与订单无误，现场即可成交。</p>
                    <p><b>（4）打款需要多长时间？</b></p>
                    <p> 悟空收车承诺，卖家签定收购协议即可打款。</p>
                    <p><b>（5）在悟空收车卖车需要准备什么？</b></p>
                    <p> 需要先在网站提供您的联系电话，车辆品牌、型号等基本信息。待服务人员联系您后，在约定时间内准备好</p>
                    <p> 1、身份证</p>
                    <p> 2、行驶证</p>
                    <p>3、车辆登记证</p>
                    <p> 4、车辆钥匙</p>
                    <p>  5、车示标（环保标、检字标、交强险标）</p>
                    <p>  6、交强险单</p>
                    <p> 7、购置税本及购置税发票</p>
                    <p> 8、购车发票/最近一次过户发票</p>
                    <p> <b>（6）一直无法估价、提交订单怎么办？</b></p>
                    <p> 用其他浏览器试一下，如果还是不行请联系客服解决。</p>
                    <p> <b>（7）哪些车悟空收车不进行收购？</b></p>
                    <p>  对于以下车辆悟空收车不予收购</p>
                    <p>1.发生事故影响过户车辆、泡水车、火烧车</p>
                    <p> 2.有被盗抢记录，有经济抵押、法院封存记录车辆</p>
                    <p> 3.改凿发动机及车架号码车辆</p>
                    <p> 4.数据与车管所档案不相符车辆</p>
                    <p>5.证件不齐全、不合格、已无效车辆</p>

                    <p><b>（8）什么情况发生退车？</b></p>
                    <p> 如果您的车辆出现因为手续或者车况无法进行过户，或者我们发现车辆有被盗抢记录，有经济抵押、法院封存记录等不合</p>
                    <p><b>（9）退车物流费用由谁承担？</b></p>
                    <p> 退车的物流费用全部由悟空收车来承担（不和法车辆除外）。</p>
                    <p><b>（10）退车时间大概多久？</b></p>
                    <p>一般的退车时间为同意退车后的两个工作日内，悟空收车在退车后会与卖家约定退车时间地点将车辆送回并签定退车协议。</p>



                </div>
            </div>


            <div id="seve">
                <h3>服务条款</h3>
                <div class="xq">

                   <p> <b>第一部分 服务承诺</b></p>
                   <p> 多长时间内会安排上门服务？</p>
                    <p>用户提交上门交车订单后，19：00前提交的订单最早可以安排在第二天上门，订单较多的情况下会有延后。</p>
                    <p>车辆成交后，多长时间可以收到款项？</p>
                    <p>悟空收车承诺车辆检测完毕，若车况、价格与您提交订单时的车况、价格一致，将现场直接打款到您的银行账户；
                        若检测后的车况、价格与您提交订单时的车况、价格不一致，我们将重新作价，确认最终成交价格再交易，如果最终您不同意交易，可以申请取消订单。</p>
                    <p>第二部分 二次报价，退车及纠纷处理</p>
                    <p>什么情况下，悟空收车会申请二次报价？</p>
                    <p>若检测结果与用户提交订单时的描述符合，则立即成交打款。如果结果与用户的描述不符，悟空收车工作人员会与用户说明情况，为用户申请二次报价。若用户不同意二次报价，悟空收车将为用户取消订单。</p>
                    <p>什么情况发生退车？</p>
                    <p>如果您的车辆出现因为手续或者车况无法进行过户，或者我们发现车辆有被盗抢记录，有经济抵押、法院封存记录等不合</p>
                    <p>退车物流费用由谁承担？</p>
                    <p>退车的物流费用全部由悟空收车来承担（不和合法车辆除外）。</p>
                    <p>退车时间大概多久？</p>
                    <p> 一般的退车时间为同意退车后的两个工作日内，悟空收车在退车后会与卖家约定退车时间地点将车辆送回并签定退车协议。</p>
                    <p><b> 第三部分 免责申明</b></p>
                    <p> 1. 交易应秉承合法、公平、透明、合理的原则进行。<p>
                    <p>  2. 交易车辆应为正规渠道车辆，拒绝交易泡水车、火烧车、不合法车辆（如被盗抢，经济抵押、法院封存车辆）。<p>
                    <p> 3. 您应保证对交易车辆拥有合法、完整的处分权利。如悟空收车发现您提交的车辆为非法渠道车辆（如失、窃车辆等），有权依法向公安司法机关报案，将车辆转交公安司法机关。<p>
                    <p>4. 交易完成后，悟空收车有权对车辆进行处理，对车辆不作保留和预留。<p>
                    <p> <b>关于悟空收车</b><p>
                    <p>1. 悟空收车具有合法收车资质，您和悟空收车将就此直接进行相关交易，包括但不限于估价，议价，交付车辆等。</p>
                    <p> 2. 您应保证自己填写的车辆参数信息准确、真实、有效。因您填写的车辆参数信息错误导致车辆估价和最终成交价格不一致的，您应自行承担该后果。</p>
                    <p> 3. 您在交付交易车辆前，应自行确保已将车辆内的重要物品取出了。如因您未执行此操作导致您物品丢失，一切责任及后果将由您自行承担，悟空收车无需承担任何责任。</p>
                    <p>4. 上门服务期间，如遇恶劣天气或其它自然灾害等不可抗因素，买卖双方应酌情商议</p>
                    <p> 6. 若卖家车辆在交付前，遭遇第三方公司的损坏、丢失或者其它任何的利益损害，悟空收车不承担任何责任和损失</p>
                    <p> 7. 请勿将不必要的手续（车辆保养手册、商业险等）交付，若造成遗失，悟空收车不承担任何责任</p>
                    <p> 8. 一旦您已于悟空收车确认交易并且订单完成，将无法退还车辆（包含一起交付的相关所有手续），并取消订单</p>
                    <p> 9. 用户坚持按照出现明显输入错误或不符合常识的价格出售车辆。悟空收车有权取消或终止此类价格错误的订单。</p>


                </div>
            </div>

            <div id="eih">
                <h3>公司简介</h3>
                <div class="xq">
                   <p><b>一、悟空收车简介</b></p>
                    <p>  悟空收车（www.wukongshouche.com）致力于打造全新的二手车线上交易置换的专业服务平台。</p>

                    <p>悟空收车专注于为各大汽车集团、经销商、企事业单位、私家车车主服务。采用线上交易模式，将复杂的卖车环节简单化，卖车价格透明化，并与多家4S店达成合作，为用户提供优质便捷的上门交易业务和一站式置换服务。让交易二手车这件事发生彻底的改变，不再东奔西跑，简单、省心。

                    悟空收车拥有一支高素质的员工团队，在长期的经营实践和“专业专注，贴心服务，信誉第一，客户至上”的经营思想指导下，以高质量、高素质、高水平的专业服务标准，赢得了各大汽车集团、经销商、企事业单位、私家车车主的认可与信赖。</p>

                    <p><b> 二、悟空收车业务</b></p>
                    <p>如果您想卖二手车，悟空收车能够以一个公平合理的价格直接与你线上交易，成交快、价格高、超省心、有保障；如果您想买车，悟空收车能给您做精准的价格评估，告诉您合理的预期交易价格。</p>

                    <p><b>  三、企业文化</b></p>
                    <p> 愿景</p>
                    <p> 打造中国第一、世界一流的二手车线上交易平台。</p>
                    <p> 理念?</p>
                    <p> 专业专注，贴心服务，信誉第一，客户至上。</p>
                    <p> 使命</p>
                    <p>  让市场更健康、让交易更安全。</p>
                    <p>  我们倡导</p>
                    <p>开放、包容、进取、共享。</p>

                    <p> 四、公司声明</p>
                    <p> 悟空收车隶属于北京迈众汽车信息服务有限公司</p>
                    <p> 公司地址：北京市大兴区宏业路9号嘉悦广场5号楼1002室</p>
                    <p> 公司电话：010-80258108</p>

                </div>
            </div>


            <div id="nig">
                <h3>招贤纳士</h3>
                <div class="xq">
                    <p><b> 质检师</b></p>
                    <p>工作职责：</p>
                    <p>1、对筛选出的数据源进行排查、验证；</p>
                    <p>2、通过关注市场行情，对评估输出的结果根据市场行情给予反馈、必要时作调整；</p>
                    <p> 3、向高级统计分析师反馈模型输出结果与市场结果差距；</p>
                    <p> 4、提出市场热门车型，撰写分析报告；</p>
                    <p> 5、负责实时跟踪二手车市场交易行情和交易价格；</p>
                    <p> 6、上级安排的其他临时工作。</p>
                    <p> <b>任职要求：</b></p>
                    <p> 1、具有二手车交易市场评估二手车5年以上经验；</p>
                    <p> 2、具备一定的汽车行业资源，能联络各评估师及时反馈价格；</p>
                    <p> 3、熟练使用Word、Excel、PPT等办公软件，对数字价格敏感；</p>
                    <p> 4、熟悉热爱汽车行业、互联网行业；</p>
                    <p> 5、认真、负责、踏实耐心，实事求是、责任心强，具备良好的沟通协调能力和团队协作精神。</p>


                    <p><b> Android研发工程师</b></p>
                    <p> 工作职责：</p>
                    <p>1、负责项目需求分析，详细设计，架构设计以及开发工作；</p>
                    <p>2、根据项目任务计划按时完成软件编码和单元测试工作；</p>
                    <p>3、撰写项目相关技术文档；</p>
                    <p>4、解决研发过程中的相关问题和技术难题；</p>
                    <p> 5、对相关技术项目提供后续技术支持以及维护；</p>
                    <p> 6、完成上级分配的其他任务，向上级提出合理化建议。</p>
                    <p> 任职要求:</p>
                    <p>1、计算机或相关专业本科及以上学历；</p>
                    <p>2、3年以上Android研发工作经验，精通高性能编程及性能调优；</p>
                    <p> 3、熟悉开发，理解设计模式，拥有丰富的项目或产品设计实践，能独立完成设计和编码；</p>
                    <p>4、思路开阔，责任心强，具备快速学习能力，对软件开发有独到的见解，具有强烈的责任心和团队合作精神；</p>
                    <p> 5、具备良好的英语读写水平。</p>

                </div>
            </div>

            <div id="tens">
                <h3>销售商加盟</h3>
                <div class="xq">





                    <div class="help_howjoin">
                        <h1>如何加入平台</h1>
                        <div class="help_bid_line"></div>
                        <div class="help_form">
                            <div class="form_group">
                                <input id="txt_companyname" name="txt_required" type="text" placeholder="公司名称" class="placeholder">
                                <label class="errortip">公司名称为空！</label>
                            </div>
                            <div class="form_group">
                                <input id="txt_contactperson" name="txt_contactperson" type="text" placeholder="联系人" class="placeholder">
                                <label class="errortip">联系人为空！</label>
                            </div>
                            <div class="form_group">
                                <input id="txt_tel" name="txt_tel" type="text" placeholder="联系电话" class="placeholder">
                                <label class="errortip">输入正确的联系电话！</label>
                            </div>
                            <div class="form_group">
                                <input id="txt_city" name="txt_city" type="text" placeholder="所在城市" class="placeholder">
                                <label class="errortip">所在城市为空！</label>
                            </div>
                            <div class="form_group comment">
                                <textarea id="txt_remark" name="txt_remark" placeholder="说明（请务必说明经营区域和经营的类别）" class="placeholder"></textarea>
                                <label class="errortip">说明为空！</label>
                            </div>
                            <div class="btns">
                                <a id="btnSubmit" href="javascript:void(0)">提交信息</a>
                                <span class="tips"><i>*</i> 提交信息后，请保持电话畅通，我们将竭诚为您服务</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div><!--A_con end-->
</div>
<!--中间部分end-->


<script>


            $(document).ready(function() {
                $("#oneLink").click(function() {
                    $("html, body").animate({
                        scrollTop: $("#one").offset().top }, {duration: 500,easing: "swing"});
                    return false;
                });
                $("#twoLink").click(function() {
                    $("#two").show();
                    $("#one").hide();
                    $("html, body").animate({
                        scrollTop: $("#two").offset().top }, {duration: 500,easing: "swing"});
                    return false;
                });
                $("#treLink").click(function() {
                    $("#tre").show();
                    $("#two").hide();

                    $("html, body").animate({
                        scrollTop: $("#tre").offset().top }, {duration: 500,easing: "swing"});
                    return false;
                });
            });
</script>


<script type="text/javascript">
    $(function(){
        //设置标杆
        var _line=parseInt($(window).height()/3);
        $(window).scroll(function(){
            //滚动730px，左侧导航固定定位
            if ($(window).scrollTop()>730) {
                $('.A_con .left').css({'position':'fixed','top':0})
            }else{
                $('.A_con .left').css({'position':'','top':''})
            };
            $('.A_con .left .xiao_ul a').eq(0).addClass('active');
            //滚动到标杆位置,左侧导航加active
            $('.A_con .right>div').each(function(){
                var _target=parseInt($(this).offset().top-$(window).scrollTop()-_line);
                var _i=$(this).index();
                if (_target<=0) {
                    $('.A_con .left .xiao_ul a').removeClass('active');
                    $('.A_con .left .xiao_ul a').eq(_i).addClass('active');
                }
                //如果到达页面底部，给左侧导航最后一个加active
                else if($(document).height()==$(window).scrollTop()+$(window).height()){
                    $('.A_con .left .xiao_ul a').removeClass('active');
                    $('.A_con .left .xiao_ul a').eq($('.fl_r li').length-1).addClass('active');
                }
            });
        });
        $('.A_con .left .xiao_ul a').click(function(){
            $(this).addClass('active').siblings().removeClass('active');
            var _i=$(this).index();
            $('body, html').animate({scrollTop:$('.fl_r li').eq(_i).offset().top-_line},500);
        });
    });
</script>
</body>
</html>
