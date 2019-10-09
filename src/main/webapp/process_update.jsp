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
    <title>审批请假单</title>
</head>
<body>
<form class="layui-form" action="/process/update" method="post">
    <div class="layui-form-item">
        <label for="proFormId" class="layui-form-label">
            <span class="x-red">*</span>请假单ID</label>
        <div class="layui-input-inline">
            <input type="text" id="proFormId" name="proFormId" required lay-verify="required"
                   value="${process.proFormId}"
                   autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="proEmp" class="layui-form-label">
            <span class="x-red">*</span>请假人</label>
        <div class="layui-input-inline">
            <input type="text" id="proEmp" name="proEmp" required lay-verify="required" value="${process.proEmp}"
                   autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="proExamine" class="layui-form-label">审核人</label>
        <div class="layui-input-inline">
            <input type="text" id="proExamine" name="proExamine" required lay-verify="required"
                   value="${process.proExamine}" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">审核意见</label>
        <div class="layui-input-block">
            <input type="radio" name="proState" title="待审核" value="待审核"
                   <c:if test="${process.proState=='待审核'}">checked</c:if> autocomplete="off" class="layui-input">
            <input type="radio" name="proState" title="批准" value="批准" autocomplete="off" class="layui-input">
            <input type="radio" name="proState" title="驳回" value="驳回" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
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
                url: '/process/update',
                dataType: 'json',
                data: {
                    proFormId: data.field.proFormId,
                    proEmp: data.field.proEmp,
                    proExamine: data.field.proExamine,
                    proState: data.field.proState,
                },
                success: function (data) {
                    if (data.code == 200) {
                        xadmin.close();
                        xadmin.father_reload()
                    } else {
                        layer.msg("审核出现错误")
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
