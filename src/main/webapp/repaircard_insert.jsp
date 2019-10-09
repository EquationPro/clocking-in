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
    <title>添加补卡数据</title>
</head>
<body>

<form  class="layui-form" action="/repairCard/insert" method="post">
    <div class="layui-form-item">
        <label for="repEmp" class="layui-form-label">
            <span class="x-red">*</span>补卡人编码</label>
        <div class="layui-input-inline">
            <input type="text" id="repEmp" name="repEmp" value="${empCode}" required lay-verify="required" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="repTime" class="layui-form-label">
            <span class="x-red">*</span>补卡时间</label>
        <div class="layui-input-inline">
            <input type="text" id="repTime" name="repTime" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">补卡原因</label>
        <div class="layui-input-block">
            <textarea name="repReason" style="width: 320px" placeholder="请输入内容"   class="layui-textarea"></textarea>
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
            elem: '#repTime' //指定元素
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
                url:'/repairCard/insert',
                dataType:'json',
                data:{
                    repEmp:data.field.repEmp,
                    repTime:data.field.repTime,
                    repReason:data.field.repReason
                },
                success:function (data) {
                    if (data.code==200){
                        xadmin.close();
                        xadmin.father_reload()
                    } else if (data.code==500) {
                        layer.msg("添加失败")
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
