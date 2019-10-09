<!doctype html>
<html class="x-admin-sm">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="UTF-8">
    <title>考勤系统</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <!-- <link rel="stylesheet" href="./css/theme5.css"> -->
    <script src="js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
        // 是否开启刷新记忆tab功能
        // var is_remember = false;
    </script>
    <style type="text/css">
            #div1 {
                max-height: 50px;
                max-width: 50px;
                border-radius: 10px;
            }

            #img1 {
                max-width: 100%;
                max-height: 100%;
                border-radius: 20px;
            }
    </style>

</head>
<body class="index">
<!-- 顶部开始 -->
<div class="container">
    <div class="logo">
        <a href="./index.html">办公OA系统</a></div>
    <div class="left_open">
        <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
    </div>
    <%--<ul class="layui-nav left fast-add" lay-filter="">--%>
        <%--<li class="layui-nav-item">--%>
            <%--<a href="javascript:;">+新增</a>--%>
            <%--<dl class="layui-nav-child">--%>
                <%--<!-- 二级菜单 -->--%>
                <%--<dd>--%>
                    <%--<a onclick="xadmin.open('最大化','http://www.baidu.com','','',true)">--%>
                        <%--<i class="iconfont">&#xe6a2;</i>弹出最大化</a></dd>--%>
                <%--<dd>--%>
                    <%--<a onclick="xadmin.open('弹出自动宽高','http://www.baidu.com')">--%>
                        <%--<i class="iconfont">&#xe6a8;</i>弹出自动宽高</a></dd>--%>
                <%--<dd>--%>
                    <%--<a onclick="xadmin.open('弹出指定宽高','http://www.baidu.com',500,300)">--%>
                        <%--<i class="iconfont">&#xe6a8;</i>弹出指定宽高</a></dd>--%>
                <%--<dd>--%>
                    <%--<a onclick="xadmin.add_tab('在tab打开','member-list.html')">--%>
                        <%--<i class="iconfont">&#xe6b8;</i>在tab打开</a></dd>--%>
                <%--<dd>--%>
                    <%--<a onclick="xadmin.add_tab('在tab打开刷新','member-del.html',true)">--%>
                        <%--<i class="iconfont">&#xe6b8;</i>在tab打开刷新</a></dd>--%>
            <%--</dl>--%>
        <%--</li>--%>
    <%--</ul>--%>
    <ul class="layui-nav right" lay-filter="">

        <c:if test="${userType == '管理员'}">
            <li class="layui-nav-item">
                <i class="layui-icon" id="msg1">&#xe667;</i>
                <i id="num"></i>
            </li>
        </c:if>
        <%--图标--%>

        <li class="layui-nav-item">
            <a href="javascript:;">${empName}</a>
            <dl class="layui-nav-child">
                <!-- 二级菜单 -->
                <dd>
                    <a onclick="xadmin.open('个人信息','http://www.baidu.com')">个人信息</a></dd>
                <dd>
                    <a onclick="xadmin.open('切换帐号','http://www.baidu.com')">切换帐号</a></dd>
                <dd>
                    <a href="./login.html">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index">
            <div id="div1">
                <%--测试--%>
                <img  src="/img${userHeadImg}" id="img1" />
            </div>
        </li>
        <li class="layui-nav-item to-index">
            <a href="/index_test.jsp">前台首页</a></li>

    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="会员管理">&#xe6b8;</i>
                    <cite>个人模块</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>个人管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('账号管理','manage_account_by_name.jsp')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>账号管理</cite></a>
                            </li>
                            <%--<li>--%>
                                <%--<a onclick="xadmin.add_tab('等级管理','list_user_account.jsp')">--%>
                                    <%--<i class="iconfont">&#xe6a7;</i>--%>
                                    <%--<cite>等级管理</cite></a>--%>
                            <%--</li>--%>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>请假申请</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('请假单管理','manage_leave_form_by_id.jsp')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>请假单管理</cite></a>
                            </li>
                            <%--<li>--%>
                                <%--<a onclick="xadmin.add_tab('等级管理','list_user_account.jsp')">--%>
                                    <%--<i class="iconfont">&#xe6a7;</i>--%>
                                    <%--<cite>等级管理</cite></a>--%>
                            <%--</li>--%>
                        </ul>
                    </li>
                </ul>
            </li>
                <li>
                    <a href="javascript:;">
                        <i class="iconfont left-nav-li" lay-tips="管理员管理">&#xe726;</i>
                        <cite>管理员管理</cite>
                        <i class="iconfont nav_right">&#xe697;</i></a>
                    <ul class="sub-menu">
                        <li>
                            <a onclick="xadmin.add_tab('管理员列表','list_user_account.jsp')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>管理员列表</cite></a>
                        </li>
                        <li>
                            <a onclick="xadmin.add_tab('角色管理','list_role.jsp')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>角色管理</cite></a>
                        </li>
                        <li>
                            <a onclick="xadmin.add_tab('用户管理','list_search_user.jsp')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>用户管理</cite></a>
                        </li>
                        <%--<li>--%>
                            <%--<a onclick="xadmin.add_tab('权限分类','member-list1.html')">--%>
                                <%--<i class="iconfont">&#xe6a7;</i>--%>
                                <%--<cite>权限分类</cite></a>--%>
                        <%--</li>--%>
                        <li>
                            <a onclick="xadmin.add_tab('操作日志','list_oper_record.jsp')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>操作日志</cite></a>
                        </li>
                        <li>
                            <a onclick="xadmin.add_tab('审核表单','list_process.jsp')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>审核表单</cite></a>
                        </li>
                        <li>
                            <a onclick="xadmin.add_tab('审核记录','list_process_detail.jsp')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>审核日志</cite></a>
                        </li>
                    </ul>
                </li>

            <%--<li>--%>
                <%--<a href="javascript:;">--%>
                    <%--<i class="iconfont left-nav-li" lay-tips="系统统计">&#xe6ce;</i>--%>
                    <%--<cite>系统统计</cite>--%>
                    <%--<i class="iconfont nav_right">&#xe697;</i></a>--%>
                <%--<ul class="sub-menu">--%>
                    <%--<li>--%>
                        <%--<a onclick="xadmin.add_tab('拆线图','echarts1.html')">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>拆线图</cite></a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a onclick="xadmin.add_tab('拆线图','echarts2.html')">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>拆线图</cite></a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a onclick="xadmin.add_tab('地图','echarts3.html')">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>地图</cite></a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a onclick="xadmin.add_tab('饼图','echarts4.html')">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>饼图</cite></a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a onclick="xadmin.add_tab('雷达图','echarts5.html')">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>雷达图</cite></a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a onclick="xadmin.add_tab('k线图','echarts6.html')">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>k线图</cite></a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a onclick="xadmin.add_tab('热力图','echarts7.html')">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>热力图</cite></a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a onclick="xadmin.add_tab('仪表图','echarts8.html')">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>仪表图</cite></a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="javascript:;">--%>
                    <%--<i class="iconfont left-nav-li" lay-tips="图标字体">&#xe6b4;</i>--%>
                    <%--<cite>图标字体</cite>--%>
                    <%--<i class="iconfont nav_right">&#xe697;</i></a>--%>
                <%--<ul class="sub-menu">--%>
                    <%--<li>--%>
                        <%--<a onclick="xadmin.add_tab('图标对应字体','unicode.html')">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>图标对应字体</cite></a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="javascript:;">--%>
                    <%--<i class="iconfont left-nav-li" lay-tips="其它页面">&#xe6b4;</i>--%>
                    <%--<cite>其它页面</cite>--%>
                    <%--<i class="iconfont nav_right">&#xe697;</i></a>--%>
                <%--<ul class="sub-menu">--%>
                    <%--<li>--%>
                        <%--<a href="login.html" target="_blank">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>登录页面</cite></a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a onclick="xadmin.add_tab('错误页面','error.html')">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>错误页面</cite></a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a onclick="xadmin.add_tab('示例页面','demo.html')">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>示例页面</cite></a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a onclick="xadmin.add_tab('更新日志','log.html')">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>更新日志</cite></a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>

        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home">
                <i class="layui-icon">&#xe68e;</i>我的桌面
            </li>
        </ul>
        <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
            <dl>
                <dd data-type="this">关闭当前</dd>
                <dd data-type="other">关闭其它</dd>
                <dd data-type="all">关闭全部</dd>
            </dl>
        </div>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='welcome.jsp' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
        <div id="tab_show"></div>
    </div>
</div>
<div class="page-content-bg"></div>
<style id="theme_style"></style>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
</body>
<script>

    var myVar = setInterval(function () {
        send_audit()
    }, 20000);

    function send_audit() {
        var $ = layui.jquery;
        $.ajax({
            type: 'post',
            url: '/auditMessage/audit',
            dataType: 'json',
            data: {},
            success: function (data) {
                // var submitAudit = document.getElementById("#demo");
                if (data.code == 200) {
                    // var submitAudit = document.getElementById("#num");
                    // alert("有人提交了请假申请单,请审批");
                    // 获取标签  改变标签中的内容
                    $('#num').html(data.count);
                } else if (data.code == 500) {
                    // alert("无")
                }


            }
        })
    }

</script>
<script>
    $(function () {
        $('#msg1').click(function () {
            xadmin.add_tab('审核表单','list_process.jsp')
        })
    })
</script>
</html>