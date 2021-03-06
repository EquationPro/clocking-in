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
    <title>添加岗位</title>
</head>
<body>

<form class="layui-form" action="/station/insert" method="post">
    <div class="layui-form-item">
        <label for="staCode" class="layui-form-label">
            <span class="x-red">*</span>岗位编码</label>
        <div class="layui-input-inline">
            <input type="text" id="staCode" name="staCode" required lay-verify="required" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="staName" class="layui-form-label">
            <span class="x-red">*</span>岗位名称</label>
        <div class="layui-input-inline">
            <input type="text" id="staName" name="staName" required lay-verify="required" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="staDepartment" class="layui-form-label">所在部门</label>
        <div class="layui-input-inline">
            <select id="staDepartment" name="staDepartment" required lay-verify="required">
                <c:forEach items="${depNames}" var="depName">
                    <option value="${depName}">${depName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="staHead" class="layui-form-label">直接上级</label>
        <div class="layui-input-inline">
            <select id="staHead" name="staHead" required lay-verify="required">
                <c:forEach items="${staCodes}" var="staCode">
                    <option value="${staCode}">${staCode}</option>
                </c:forEach>
            </select>
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="staCategory" class="layui-form-label">岗位类别</label>
        <div class="layui-input-inline">
            <input type="text" id="staCategory" name="staCategory" required lay-verify="required" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">岗位职责</label>
        <div class="layui-input-block">
            <textarea name="staDesc" placeholder="请输入内容"
                      class="layui-textarea"></textarea>
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
                url: '/station/insert',
                dataType: 'json',
                data: {
                    staCode: data.field.staCode,
                    staName: data.field.staName,
                    staDepartment: data.field.staDepartment,
                    staHead: data.field.staHead,
                    staCategory: data.field.staCategory,
                    staDesc: data.field.staDesc
                },
                success: function (data) {
                    if (data.code == 200) {
                        xadmin.close();
                        xadmin.father_reload()
                    } else if (data.code == 500) {
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
