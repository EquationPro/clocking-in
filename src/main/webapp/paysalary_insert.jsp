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
    <title>添加派薪记录</title>
</head>
<body>

<form  class="layui-form" action="/paySalary/insert" method="post">
    <div class="layui-form-item">
        <label for="payEmp" class="layui-form-label">
            <span class="x-red">*</span>领薪人编码</label>
        <div class="layui-input-inline">
            <select id="payEmp" name="payEmp" required lay-verify="required">
                <c:forEach items="${empCodes}" var="empCode">
                    <option value="${empCode}">${empCode}</option>
                </c:forEach>
            </select>
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="payEmpName" class="layui-form-label">
            <span class="x-red">*</span>领薪人姓名</label>
        <div class="layui-input-inline">
            <select id="payEmpName" name="payEmpName" required lay-verify="required">
                <c:forEach items="${empNames}" var="empName">
                    <option value="${empName}">${empName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="payBegin" class="layui-form-label">领薪区间</label>
        <div class="layui-input-inline">
            <input type="text" id="payBegin" name="payBegin" placeholder="开始时间" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="payEnd" class="layui-form-label"></label>
        <div class="layui-input-inline">
            <input type="text" id="payEnd" name="payEnd" placeholder="结束时间" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="paySal" class="layui-form-label">薪水</label>
        <div class="layui-input-inline">
            <input type="text" id="paySal" name="paySal" required lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label for="paySal2" class="layui-form-label"></label>
        <div class="layui-input-inline">
            <input type="hidden" id="paySal2" name="paySal2"  autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="countSal">计算薪水</button>
            <button class="layui-btn" lay-submit lay-filter="formDemo">保存</button>
        </div>
    </div>

</form>

<script>
    layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;


        //执行一个laydate实例
        laydate.render({
            elem: '#payBegin' //指定元素
            ,type: 'datetime'
            ,trigger:'click'
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#payEnd' //指定元素
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
                url:'/paySalary/insert',
                dataType:'json',
                data:{
                    payEmp:data.field.payEmp,
                    payEmpName:data.field.payEmpName,
                    paySal:data.field.paySal2,
                    payBegin:data.field.payBegin,
                    payEnd:data.field.payEnd
                },
                success:function (data) {
                    if (data.code==200){
                        xadmin.close();
                        xadmin.father_reload()
                    } else if (data.code==500) {
                        layer.msg("添加失败")
                    }
                }
            });
            // layer.msg(JSON.stringify(data.field));
            return false;
        });
        form.on('submit(countSal)', function(data){
            $.ajax({
                type:'post',
                url:'/paySalary/countSal',
                dataType:'json',
                data:{
                    payEmp:data.field.payEmp,
                    paySal:data.field.paySal,
                    payBegin:data.field.payBegin,
                    payEnd:data.field.payEnd
                },
                success:function (data) {
                    if (data.code==200){
                        layer.msg('计算结果为'+data.salary+'RMB');
                       $('#paySal2').val(data.salary)
                    } else if (data.code==500) {
                        layer.msg("计算失败，请重试")
                    }
                }
            });
            // layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</body>
</html>
