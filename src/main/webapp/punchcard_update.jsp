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
    <title>查看打卡单信息</title>
</head>
<body>
<form class="layui-form" action="/punchCard/update" method="post">
    <div class="layui-form-item">
        <label for="punEmp" class="layui-form-label">
            <span class="x-red">*</span>打卡人编码</label>
        <div class="layui-input-inline">
            <input type="text" id="punEmp" name="punEmp" required lay-verify="required" value="${punchCard.punEmp}" autocomplete="off" class="layui-input" readonly>
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="punTime" class="layui-form-label">
            <span class="x-red">*</span>打卡人姓名</label>
        <div class="layui-input-inline">
            <input type="text" id="punTime" name="punTime" required lay-verify="required" value="${punchCard.punTime}" autocomplete="off" class="layui-input" readonly>
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="punRemark" style="width: 320px" class="layui-textarea" readonly>${punchCard.punRemark}</textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <%--<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>--%>
            <%--<button type="reset" class="layui-btn layui-btn-primary">重置</button>--%>
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
                url: '/punchCard/update',
                dataType: 'json',
                data: {
                    punEmp:data.field.punEmp,
                    punTime:data.field.punTime,
                    punRemark:data.field.punRemark
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
