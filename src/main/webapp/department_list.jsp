<%--
  Created by IntelliJ IDEA.
  User: equation
  Date: 2019/8/27
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/jquery-1.11.3.js"></script>
<html>
<head>
    <title>部门管理</title>
    <%--<script type="text/javascript" src="layui/layui.js"></script>--%>
    <script type="text/javascript" src="./lib/layui/layui.js"></script>
    <%--<link rel="stylesheet" text="text/css" href="layui/css/layui.css">--%>
    <link rel="stylesheet" text="text/css" href="./lib/layui/css/layui.css">
    <script src="./js/xadmin.js"></script>
    <link rel="stylesheet" href="./css/xadmin.css">
</head>
<body>

<table id="demo" lay-filter="test"></table>


<script type="text/html" id="toolbarDemo">
    <div class="demoTable">
        <div class="layui-inline layui-show-xs-block">
            <input name="id" id="demoReload" autocomplete="off" placeholder="请输入编码或者名称">
            <button class="layui-btn layui-btn-sm" data-type="reload"><i class="layui-icon">&#xe615;</i></button>
        </div>
        <div class="layui-inline layui-show-xs-block">
            <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="getCheckData"><i class="layui-icon"></i>批量删除</button>
            <button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon"></i>添加</button>
        </div>
    </div>
</script>

<script type="text/html" id="bartest" lay-filter="test">
    <%--<a class="layui-btn layui-btn-xs" lay-event="add">添加</a>--%>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use('table', function () {
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            , height: 600
            , url: '/department/listByPage' //数据接口
            , page: true //开启分页
            , toolbar: '#toolbarDemo'
            , totalRow: true
            , id: 'testReload'
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: 'depId', title: 'ID', sort: true, fixed: 'left', totalRowText: '合计'}
                , {field: 'depCode', title: '部门编码'}
                , {field: 'depName', title: '部门名称'}
                , {field: 'depHead', title: '部门负责人'}
                , {field: 'depResponsibility', title: '部门职责'}
                , {field: 'depSuperiorId', title: '上级部门'}
                , {title: '操作', toolbar: '#bartest', fixed: 'right'}
            ]]
        });

        var $ = layui.$, active = {
            reload: function () {
                var demoReload = $('#demoReload');

                //执行重载
                table.reload('testReload', {
                    url: '/department/searchDepartment',
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        depNameOrDepCode: demoReload.val()   //data.field.userName  //obj.data
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });


        //头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'getCheckData':
                    var depIds = checkStatus.data;
                    var ids='';
                    for (var i in depIds) {
                        ids += depIds[i].depId+',';
                    }
                    // alert(ids);
                        $.ajax({
                            type: 'post',
                            url: '/department/delAll',
                            dataType: 'json',
                            data: {
                                depIds: ids  //obj.data
                            },
                            success: function (data) {
                                if (data.code == 200) {
                                   xadmin.father_reload();
                                } else if (data.code == 500) {
                                    layer.msg("删除失败");
                                }
                            }
                        });

                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：' + data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选' : '未全选');
                    break;
                case 'add':
                    xadmin.open("添加记录", "department_insert.jsp", 600, 500);
                    break;
            }
        });

        table.on('tool(test)', function (obj) {
            var data = obj.data;
            // var $ =layui.jquery;   //使用自带的jquery
            if (obj.event === 'del') {
                // layer.confirm('真的删除行么', function (data) {
                $.ajax({
                    type: 'get',
                    url: '/department/delete',
                    dataType: 'json',
                    data: {
                        depId: data.depId  //obj.data
                    },
                    success: function (data) {
                        if (data.code == 200) {
                            obj.del();
                            layer.msg("删除成功");
                        } else if (data.code == 500) {
                            layer.msg("删除失败");
                        }
                    }
                });
                // obj.del();
                // layer.close(index);
            } else if (obj.event === 'edit') {
                xadmin.open("修改信息", '/department/loadById?depId=' + data.depId, 700, 400)
            }
        });
    });
</script>
</body>
</html>
