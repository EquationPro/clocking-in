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
    <title>添加员工</title>
</head>
<body>

<form  class="layui-form" action="/employees/insert" method="post">
    <div class="layui-form-item">
        <label for="empCode" class="layui-form-label">
            <span class="x-red">*</span>员工编码</label>
        <div class="layui-input-inline">
            <input type="text" id="empCode" name="empCode" required lay-verify="required" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">
            <span class="x-red">*</span>将会成为您唯一的登入名</div>
    </div>
    <div class="layui-form-item">
        <label for="empName" class="layui-form-label">
            <span class="x-red">*</span>姓名</label>
        <div class="layui-input-inline">
            <input type="text" id="empName" name="empName" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="empSex" class="layui-form-label">
            <span class="x-red">*</span>性别</label>
        <div class="layui-input-inline">
            <input type="text" id="empSex" name="empSex" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="empAge" class="layui-form-label">
            <span class="x-red">*</span>年龄</label>
        <div class="layui-input-inline">
            <input type="text" id="empAge" name="empAge" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="empNation" class="layui-form-label">
            <span class="x-red">*</span>民族</label>
        <div class="layui-input-inline">
            <input type="text" id="empNation" name="empNation" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="empIdentity" class="layui-form-label">
            <span class="x-red">*</span>身份证</label>
        <div class="layui-input-inline">
            <input type="text" id="empIdentity" name="empIdentity" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="empSalary" class="layui-form-label">薪水</label>
        <div class="layui-input-inline">
            <input type="text" id="empSalary" name="empSalary" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="empPhone" class="layui-form-label">
            <span class="x-red">*</span>联系电话</label>
        <div class="layui-input-inline">
            <input type="text" id="empPhone" name="empPhone" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="empContact" class="layui-form-label">
            <span class="x-red">*</span>紧急联系人</label>
        <div class="layui-input-inline">
            <input type="text" id="empContact" name="empContact" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="empContactPhone" class="layui-form-label">
            <span class="x-red">*</span>紧急联系人电话</label>
        <div class="layui-input-inline">
            <input type="text" id="empContactPhone" name="empContactPhone" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="empStationId" class="layui-form-label">
            <span class="x-red">*</span>岗位</label>
        <div class="layui-input-inline">
            <select id="empStationId" name="empStationId" required lay-verify="required">
               <c:forEach items="${staNames}" var="staName">
                   <option value="${staName}">${staName}</option>
               </c:forEach>
            </select>
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">个人描述</label>
        <div class="layui-input-block">
            <textarea name="empDesc" placeholder="请输入内容"   class="layui-textarea"></textarea>
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
    layui.use('form', function(){
        var form = layui.form;
        var $=layui.jquery;
        //监听提交
        form.on('submit(formDemo)', function(data){
            // location.href='updatestu'
            $.ajax({
                type:'post',
                url:'/employees/insert',
                dataType:'json',
                data:{
                    empCode:data.field.empCode,
                    empName:data.field.empName,
                    empSex:data.field.empSex,
                    empAge:data.field.empAge,
                    empNation:data.field.empNation,
                    empIdentity:data.field.empIdentity,
                    empSalary:data.field.empSalary,
                    empPhone:data.field.empPhone,
                    empContact:data.field.empContact,
                    empContactPhone:data.field.empContactPhone,
                    empStationId:data.field.empStationId,
                    empDesc:data.field.empDesc
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
