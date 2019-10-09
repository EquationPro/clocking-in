<%--
  Created by IntelliJ IDEA.
  User: equation
  Date: 2019/8/30
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="./lib/layui/layui.js"></script>
<link rel="stylesheet" text="text/css" href="./lib/layui/css/layui.css">
<script src="./js/xadmin.js"></script>
<link rel="stylesheet" href="./css/xadmin.css">
<html>
<head>
    <title>发起请假请求</title>
</head>
<body>

<form  class="layui-form" action="/leave/insert" method="post">
    <div class="layui-form-item">
        <label for="leaEmp" class="layui-form-label">
            <span class="x-red">*</span>请假人</label>
        <div class="layui-input-inline">
            <input type="text" id="leaEmp" name="leaEmp" required lay-verify="required" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="leaBegin" class="layui-form-label">请假时间</label>
        <div class="layui-input-inline">
            <input type="text" id="leaBegin" name="leaBegin" placeholder="开始日期" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="leaEnd" class="layui-form-label"></label>
        <div class="layui-input-inline">
            <input type="text" id="leaEnd" name="leaEnd" placeholder="结束日期" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">请假原因</label>
        <div class="layui-input-block">
            <textarea name="leaReason" placeholder="请输入请假原因" style="width: 380px"  required lay-verify="required" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

</form>

<script>
    layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;


        //执行一个laydate实例
        laydate.render({
            elem: '#leaBegin' //指定元素
            ,type: 'datetime'
            ,trigger:'click'
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#leaEnd' //指定元素
            ,type: 'datetime'
            ,trigger:'click'
        });

    });
    layui.use('form', function(){
        var form = layui.form;
        var $=layui.jquery;
        //监听提交
        form.on('submit(formDemo)', function(data){
            // location.href='updatestu'
            $.ajax({
                type:'post',
                url:'/leave/insert',
                dataType:'json',
                data:{
                    leaEmp:data.field.leaEmp,
                    leaBegin:data.field.leaBegin,
                    leaEnd:data.field.leaEnd,
                    leaReason:data.field.leaReason
                },
                success:function (data) {
                    if (data.code==200){
                        xadmin.close();
                        xadmin.father_reload()
                    } else if (data.code==500) {
                        layer.msg("请假时长必须是半个小时的整数倍")
                    }
                }
            })
            // layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</body>
</html>
