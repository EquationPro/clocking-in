<%--
  Created by IntelliJ IDEA.
  User: equation
  Date: 2019/8/31
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <title>欢迎</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->

      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<%--<p id="demo"></p>--%>
<div class="layui-fluid">
<div class="layui-row layui-col-space15">
    <div class="layui-col-md12">
        <div class="layui-card">
            <div class="layui-card-body ">
                <blockquote class="layui-elem-quote" style="text-align: center">欢迎<span class="x-red"> &nbsp;${user_type}</span>：
                    <span class="x-red">${empName}</span> &nbsp;!
                </blockquote>
            </div>
        </div>
        <div class="layui-card">
            <div class="layui-card-body ">
                <blockquote class="layui-elem-quote" style="text-align: center">登录时间: <span class="x-red">${loginDate}</span>
                </blockquote>
            </div>
        </div>
        <div class="layui-card">
            <div class="layui-card-body ">
                <blockquote class="layui-elem-quote" style="text-align: center"><span class="x-so" style="color: #000; "><h2>I give you endless brand-new good wishes. Please accept them as a new
                    remembrance of our lasting friendship !</h2></span>
                </blockquote>
            </div>
        </div>
        <div class="layui-card">
            <div class="layui-card-body ">
                <blockquote class="layui-elem-quote" style="text-align: center"><span class="x-so" style="color: #000; "><h2>给你我无尽的新的祝福，让它们成为我们永恒友谊的新的纪念!</h2></span>
                </blockquote>
            </div>
        </div>
    </div>
    <%--<div class="layui-col-md12">--%>
        <%--<div class="layui-card">--%>
            <%--<div class="layui-card-header">数据统计</div>--%>
            <%--<div class="layui-card-body ">--%>
                <%--<ul class="layui-row layui-col-space10 layui-this x-admin-carousel x-admin-backlog">--%>
                    <%--<li class="layui-col-md2 layui-col-xs6">--%>
                        <%--<a href="javascript:;" class="x-admin-backlog-body">--%>
                            <%--<h3>文章数</h3>--%>
                            <%--<p>--%>
                                <%--<cite>66</cite></p>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="layui-col-md2 layui-col-xs6">--%>
                        <%--<a href="javascript:;" class="x-admin-backlog-body">--%>
                            <%--<h3>会员数</h3>--%>
                            <%--<p>--%>
                                <%--<cite>12</cite></p>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="layui-col-md2 layui-col-xs6">--%>
                        <%--<a href="javascript:;" class="x-admin-backlog-body">--%>
                            <%--<h3>回复数</h3>--%>
                            <%--<p>--%>
                                <%--<cite>99</cite></p>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="layui-col-md2 layui-col-xs6">--%>
                        <%--<a href="javascript:;" class="x-admin-backlog-body">--%>
                            <%--<h3>商品数</h3>--%>
                            <%--<p>--%>
                                <%--<cite>67</cite></p>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="layui-col-md2 layui-col-xs6">--%>
                        <%--<a href="javascript:;" class="x-admin-backlog-body">--%>
                            <%--<h3>文章数</h3>--%>
                            <%--<p>--%>
                                <%--<cite>67</cite></p>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="layui-col-md2 layui-col-xs6 ">--%>
                        <%--<a href="javascript:;" class="x-admin-backlog-body">--%>
                            <%--<h3>文章数</h3>--%>
                            <%--<p>--%>
                                <%--<cite>6766</cite></p>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div class="layui-col-md12">--%>
        <%--<div class="layui-card">--%>
            <%--<div class="layui-card-header">系统信息</div>--%>
            <%--<div class="layui-card-body ">--%>
                <%--<table class="layui-table">--%>
                    <%--<tbody>--%>
                    <%--<tr>--%>
                        <%--<th>xxx版本</th>--%>
                        <%--<td>1.0.180420</td></tr>--%>
                    <%--<tr>--%>
                        <%--<th>服务器地址</th>--%>
                        <%--<td>x.xuebingsi.com</td></tr>--%>
                    <%--<tr>--%>
                        <%--<th>操作系统</th>--%>
                        <%--<td>WINNT</td></tr>--%>
                    <%--<tr>--%>
                        <%--<th>运行环境</th>--%>
                        <%--<td>Apache/2.4.23 (Win32) OpenSSL/1.0.2j mod_fcgid/2.3.9</td></tr>--%>
                    <%--<tr>--%>
                        <%--<th>PHP版本</th>--%>
                        <%--<td>5.6.27</td></tr>--%>
                    <%--<tr>--%>
                        <%--<th>PHP运行方式</th>--%>
                        <%--<td>cgi-fcgi</td></tr>--%>
                    <%--<tr>--%>
                        <%--<th>MYSQL版本</th>--%>
                        <%--<td>5.5.53</td></tr>--%>
                    <%--<tr>--%>
                        <%--<th>ThinkPHP</th>--%>
                        <%--<td>5.0.18</td></tr>--%>
                    <%--<tr>--%>
                        <%--<th>上传附件限制</th>--%>
                        <%--<td>2M</td></tr>--%>
                    <%--<tr>--%>
                        <%--<th>执行时间限制</th>--%>
                        <%--<td>30s</td></tr>--%>
                    <%--<tr>--%>
                        <%--<th>剩余空间</th>--%>
                        <%--<td>86015.2M</td></tr>--%>
                    <%--</tbody>--%>
                <%--</table>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="layui-col-md12">--%>
        <%--<div class="layui-card">--%>
            <%--<div class="layui-card-header">开发团队</div>--%>
            <%--<div class="layui-card-body ">--%>
                <%--<table class="layui-table">--%>
                    <%--<tbody>--%>
                    <%--<tr>--%>
                        <%--<th>版权所有</th>--%>
                        <%--<td>xuebingsi(xuebingsi)--%>
                            <%--<a href="http://x.xuebingsi.com/" target="_blank">访问官网</a></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<th>开发者</th>--%>
                        <%--<td>马志斌(113664000@qq.com)</td></tr>--%>
                    <%--</tbody>--%>
                <%--</table>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<style id="welcome_style"></style>--%>
    <%--<div class="layui-col-md12">--%>
        <%--<blockquote class="layui-elem-quote layui-quote-nm">感谢layui,百度Echarts,jquery,本系统由x-admin提供技术支持。</blockquote></div>--%>
</div>
</div>
</div>
</body>

<%--<script>--%>
    <%--var myVar=setInterval(function(){send_audit()},3000);--%>
    <%--function send_audit(){--%>
        <%--var $=layui.jquery;--%>
        <%--$.ajax({--%>
            <%--type:'post',--%>
            <%--url:'auditMessage',--%>
            <%--dataType:'json',--%>
            <%--data:{--%>

            <%--},--%>
            <%--success:function (data) {--%>
                <%--// var demo = document.getElementById("#demo");--%>
                <%--if (data.code==200){--%>
                    <%--alert("有人提交了请假申请单,请审批");--%>
                <%--} else if (data.code==500){--%>
                    <%--// alert("无")--%>
                <%--}--%>


            <%--}--%>
        <%--})--%>
    <%--//     var d=new Date();--%>
    <%--//     var t=d.toLocaleTimeString();--%>
    <%--//     document.getElementById("demo").innerHTML=t;--%>
    <%--}--%>
<%--</script>--%>

</html>
