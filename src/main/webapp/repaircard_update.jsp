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
    <title>修改补卡信息</title>
</head>
<body>
<form class="layui-form" action="/repairCard/update" method="post">
    <div class="layui-form-item">
        <label for="repEmp" class="layui-form-label">
            <span class="x-red">*</span>补卡人编码</label>
        <div class="layui-input-inline">
            <input type="text" id="repEmp" name="repEmp" required lay-verify="required" value="${repairCard.repEmp}" autocomplete="off" class="layui-input" readonly>
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="repTime" class="layui-form-label">
            <span class="x-red">*</span>补卡时间</label>
        <div class="layui-input-inline">
            <input type="text" id="repTime" name="repTime" required lay-verify="required" value="${repairCard.repTime}" autocomplete="off" class="layui-input" readonly>
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">补卡原因</label>
        <div class="layui-input-block">
            <textarea name="repReason" style="width: 320px"  class="layui-textarea" readonly>${repairCard.repReason}</textarea>
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
                url: '/repairCard/update',
                dataType: 'json',
                data: {
                    repEmp:data.field.repEmp,
                    repTime:data.field.repTime,
                    repReason:data.field.repReason
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
