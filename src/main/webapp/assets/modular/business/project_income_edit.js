/**
 * 编辑
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
    // 获取详情
    var request = new HttpRequest(Feng.ctxPath + "/projectIncome/detail?id=" + Feng.getUrlParam("id"), 'get');
    var result = request.start();
    var request2 = new HttpRequest(Feng.ctxPath + "/project/detail?id=" + result.data.pid, 'get');
    var result2 = request2.start();

    // 处理下拉框回显
    let property = result2.data;
    $('#pid').append(new Option(property.name, property.id));

    // 渲染任务job class实现类下拉框
    $.ajax({
        url: Feng.ctxPath + '/project/list',
        dataType: 'json',
        type: 'get',
        success: function (data) {
            //使用循环遍历，给下拉列表赋值
            $.each(data.data, function (index, value) {
                if (property.id != value.id) {
                    $('#pid').append(new Option(value.name, value.id));
                }
            });
            layui.form.render("select");
        }
    })
    form.val('projectIncomeForm', result.data);


    // 表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var request = new HttpRequest(Feng.ctxPath + "/projectIncome/edit", 'post', function (data) {
            Feng.success("修改成功!");
            admin.putTempData('formOk', true);
            admin.closeThisDialog();
        }, function (data) {
            Feng.error("修改失败!" + data.message);
            admin.closeThisDialog();
        });
        request.set(data.field);
        request.start(true);
    });

});