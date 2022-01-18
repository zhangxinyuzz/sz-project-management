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
        elem: '#startTime'
    });
    laydate.render({
        elem: '#endTime'
    });
    // 项目类型
    gunsSelect.render({
        url: Feng.ctxPath + '/dict/list',
        elem: '#type',
        fields: {name: 'dictName', value: 'dictCode'},
        where: {dictTypeCode: 'project_type'}
    });

    // 获取详情
    var request = new HttpRequest(Feng.ctxPath + "/project/detail?id=" + Feng.getUrlParam("id"), 'get');
    var result = request.start();

    form.val('projectForm', result.data);



    // 表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var request = new HttpRequest(Feng.ctxPath + "/project/edit", 'post', function (data) {
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