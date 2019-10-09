<%--
  Created by IntelliJ IDEA.
  User: equation
  Date: 2019/8/27
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="${ctx}/lib/layui/layui.js"></script>
<link rel="stylesheet" text="text/css" href="${ctx}/lib/layui/css/layui.css">
<script src="${ctx}/js/xadmin.js"></script>
<link rel="stylesheet" href="${ctx}/css/xadmin.css">
<html>
<head>
    <title>修改班次信息</title>
</head>
<body>
<form class="layui-form" action="/classes/update" method="post">
    <div class="layui-form-item">
        <label for="claCode" class="layui-form-label">
            <span class="x-red">*</span>班次编码</label>
        <div class="layui-input-inline">
            <input type="text" id="claCode" name="claCode" required lay-verify="required" value="${classes.claCode}" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="claName" class="layui-form-label">
            <span class="x-red">*</span>班次名称</label>
        <div class="layui-input-inline">
            <input type="text" id="claName" name="claName" required lay-verify="required" value="${classes.claName}" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="claBegin" class="layui-form-label">早上上班时间</label>
        <div class="layui-input-inline">
            <input type="text" id="claBegin" name="claBegin" required lay-verify="required" value="${classes.claBegin}" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="claEnd" class="layui-form-label">下午下班时间</label>
        <div class="layui-input-inline">
            <input type="text" id="claEnd" name="claEnd" required lay-verify="required" value="${classes.claEnd}" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="claRemark" placeholder="请输入内容"  class="layui-textarea">${classes.claRemark}</textarea>
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
    layui.use('form', function () {
        var form = layui.form;
        var $ = layui.jquery;
        //监听提交
        form.on('submit(formDemo)', function (data) {
            // location.href='updatestu'
            $.ajax({
                type: 'post',
                url: '/classes/update',
                dataType: 'json',
                data: {
                    claCode:data.field.claCode,
                    claName:data.field.claName,
                    claBegin:data.field.claBegin,
                    claEnd:data.field.claEnd,
                    claRemark:data.field.claRemark
                },
                success: function (data) {
                    if (data.code == 200) {
                        xadmin.close();
                        xadmin.father_reload()
                    } else {
                        layer.msg("修改失败")
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
