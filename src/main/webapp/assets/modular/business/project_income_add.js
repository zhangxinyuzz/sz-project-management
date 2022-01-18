/**
 * 添加
 */
layui.use(['form', 'admin', 'laydate', 'HttpRequest','gunsSelect','laydate'], function () {
    var form = layui.form;
    var admin = layui.admin;
    var HttpRequest = layui.HttpRequest;
    var laydate = layui.laydate;
    var $ = layui.jquery;
    var gunsSelect = layui.gunsSelect;
    // 渲染时间选择框
    laydate.render({
        elem: '#signDate'
    });
    $.ajax({
        url: Feng.ctxPath + '/project/list',
        dataType: 'json',
        type: 'get',
        success: function (data) {
            //使用循环遍历，给下拉列表赋值
            $.each(data.data, function (index, value) {
                $('#pid').append(new Option(value.name, value.id));// 下拉菜单里添加元素
            });
            layui.form.render("select");//重新渲染 固定写法
        }
    })

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var request = new HttpRequest(Feng.ctxPath + "/projectIncome/add", 'post', function (data) {
            admin.closeThisDialog();
            Feng.success("添加成功！");
            admin.putTempData('formOk', true);
        }, function (data) {
            admin.closeThisDialog();
            Feng.error("添加失败！" + data.message);
        });
        request.set(data.field);
        request.start(true);
    });

});