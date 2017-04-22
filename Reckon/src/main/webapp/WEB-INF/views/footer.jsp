<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/21
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--footer 开始-->
<div class="footer">
    <div class="foot_cen">
        <!--div class="n_f_m_c">
            <div class="">
                <a href="/about.html">关于我们</a>
                <a href="/help.html">帮助中心</a>
                <a href="/joinus.html">加入我们</a>
                <a href="/feedback.html">用户反馈</a>
            </div>
        </div-->

        <div class="pp">
            <p>Copyright © 2017-2020 迈众 All Rights Reserved 版权所有 迈众汽车信息服务有限公司</p>
            <p>京ICP备17017795号  &nbsp;&nbsp;&nbsp; 联系电话：010-8025-8108 &nbsp;&nbsp;&nbsp;
                <script type="text/javascript">
                    var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
                    document.write(unescape("%3Cspan id='cnzz_stat_icon_1261672623'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s95.cnzz.com/z_stat.php%3Fid%3D1261672623' type='text/javascript'%3E%3C/script%3E"));
                </script>
            </p>
        </div>

    </div>
</div>
<script>
    $(document).ready(function() {

        var phone = $.cookie('phone');
        var token = $.cookie('token');
        if(phone&&token){
            $.getJSON('/userIsLogin/'+phone+'/'+token,function (d) {
                if(d.status==200){
                    $("#login").hide();

                    $('#user').html(phone).show();

                }else{
                    $.cookie('phone', null);
                    $.cookie('token', null);
                }
            })
        }
    })
</script>
<!--fooot_cen end-->
