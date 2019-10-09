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
    <title>修改请假单信息</title>
</head>
<body>
<form class="layui-form" action="/leave/update" method="post">
    <div class="layui-form-item">
        <label for="leaEmp" class="layui-form-label">
            <span class="x-red">*</span>请假人</label>
        <div class="layui-input-inline">
            <input type="text" id="leaEmp" name="leaEmp" required lay-verify="required" value="${leave.leaEmp}" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="leaBegin" class="layui-form-label">请假时间</label>
        <div class="layui-input-inline">
            <input type="text" id="leaBegin" name="leaBegin" placeholder="开始日期" value="${leave.leaBegin}" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="leaEnd" class="layui-form-label"></label>
        <div class="layui-input-inline">
            <input type="text" id="leaEnd" name="leaEnd" placeholder="结束日期" value="${leave.leaEnd}" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">请假原因</label>
        <div class="layui-input-block">
            <textarea name="leaReason" placeholder="请输入请假原因" style="width: 380px" required lay-verify="required" class="layui-textarea">${leave.leaReason}</textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <label  class="layui-form-label"></label>
        <div class="layui-input-block">
            <input type="radio"  name="leaState"  title="保存" value="保存" <c:if test="${leave.leaState=='保存'}">checked</c:if>   autocomplete="off" class="layui-input">
            <input type="radio"  name="leaState"  title="待审核" value="待审核" <c:if test="${leave.leaState=='待审核'}">checked</c:if>   autocomplete="off" class="layui-input">
            <input type="radio"  name="leaState"  title="批准" value="批准" <c:if test="${leave.leaState=='批准'}">checked</c:if> autocomplete="off" class="layui-input">
            <input type="radio"  name="leaState"  title="驳回" value="驳回" <c:if test="${leave.leaState=='驳回'}">checked</c:if>  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
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
                url: '/leave/update',
                dataType: 'json',
                data: {
                    leaEmp:data.field.leaEmp,
                    leaBegin:data.field.leaBegin,
                    leaEnd:data.field.leaEnd,
                    leaReason:data.field.leaReason,
                    leaState:data.field.leaState
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
