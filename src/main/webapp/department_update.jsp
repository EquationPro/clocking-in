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
    <title>修改部门信息</title>
</head>
<body>
<form class="layui-form" action="/department/update" method="post">
    <div class="layui-form-item">
        <label for="depCode" class="layui-form-label">
            <span class="x-red">*</span>部门编码</label>
        <div class="layui-input-inline">
            <input type="text" id="depCode" name="depCode" required lay-verify="required" value="${department.depCode}" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="depName" class="layui-form-label">
            <span class="x-red">*</span>部门名称</label>
        <div class="layui-input-inline">
            <input type="text" id="depName" name="depName" required lay-verify="required" value="${department.depName}" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="depHead" class="layui-form-label">部门负责人</label>
        <div class="layui-input-inline">
            <select id="depHead" name="depHead" required lay-verify="required">
                <option value="${department.depHead}">${department.depHead}</option>
                <c:forEach items="${empNames}" var="empName">
                    <option value="${empName}">${empName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="depResponsibility" class="layui-form-label">部门职责</label>
        <div class="layui-input-inline">
            <input type="text" id="depResponsibility" name="depResponsibility" required lay-verify="required" value="${department.depResponsibility}" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="depSuperiorId" class="layui-form-label">上级部门</label>
        <div class="layui-input-inline">
            <input type="text" id="depSuperiorId" name="depSuperiorId" required lay-verify="required" value="${department.depSuperiorId}" autocomplete="off" class="layui-input">
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
                url: '/department/update',
                dataType: 'json',
                data: {
                    depCode:data.field.depCode,
                    depName:data.field.depName,
                    depHead:data.field.depHead,
                    depResponsibility:data.field.depResponsibility,
                    depSuperiorId:data.field.depSuperiorId
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
